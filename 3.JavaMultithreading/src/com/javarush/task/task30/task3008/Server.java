package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        ConsoleHelper.writeMessage("Введите порт сервера");

        int portServer = 0;
        try {
            portServer = ConsoleHelper.readInt();
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Введен неверный порт сервера");
        }


        try (ServerSocket serverSocket = new ServerSocket(portServer);) {
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);

                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка");
        }

    }

    public static void sendBroadcastMessage(Message message) {
        for (String name : connectionMap.keySet()) {
            try {
                connectionMap.get(name).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(String.format("Can't send the message to %s", name));
            }
        }
    }

    private static class Handler extends Thread {

        Socket socket;


        Handler(Socket socket) {
            this.socket = socket;
        }


        @Override

        public void run() {


            if (socket != null && socket.getRemoteSocketAddress() != null) {

                ConsoleHelper.writeMessage("Established a new connection to a remote socket address: " + socket.getRemoteSocketAddress());

            }

            String userName = null;


            try (Connection connection = new Connection(socket)) {


                userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                sendListOfUsers(connection, userName);

                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException e) {

                ConsoleHelper.writeMessage("An exchange of data error to a remote socket address");

            } finally {

                if (userName != null) {

                    connectionMap.remove(userName);

                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));

                }

                ConsoleHelper.writeMessage("Closed connection to a remote socket address: "); // + socketAddress);

            }

        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {
                Message sent = new Message(MessageType.NAME_REQUEST);
                connection.send(sent);
                Message received = connection.receive();
                if (received.getType() == MessageType.USER_NAME && !received.getData().isEmpty() && !connectionMap.containsKey(received.getData())) {
                    connectionMap.put(received.getData(), connection);
                    Message accepted = new Message(MessageType.NAME_ACCEPTED);
                    connection.send(accepted);
                    return received.getData();
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {

            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {

                if (!entry.getKey().equals(userName)) {

                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));

                }

            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {

                Message message = connection.receive();

                if (message != null && message.getType() == MessageType.TEXT) {

                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));

                } else {

                    ConsoleHelper.writeMessage("Error!");

                }

            }

        }

    }

}
    

