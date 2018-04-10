package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Пользователь " + userName + " присоенидинился.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Пользователь " + userName + " покинул чат.");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message message;
            while (true) {
                try {
                    message = connection.receive();
                } catch (Exception e) {
                    break;
                }
                if (message != null) {
                    if (message.getType() == MessageType.NAME_REQUEST) {
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                    } else {
                        if (message.getType() == MessageType.NAME_ACCEPTED) {
                            notifyConnectionStatusChanged(true);
                            return;
                        } else {
                            throw new IOException("Unexpected MessageType");
                        }
                    }
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message;
            while (true) {
                try {
                    message = connection.receive();
                } catch (Exception e) {
                    break;
                }
                if (message != null) {
                    if (message.getType() == MessageType.TEXT) {
                        processIncomingMessage(message.getData());
                    } else {
                        if (message.getType() == MessageType.USER_ADDED) {
                            informAboutAddingNewUser(message.getData());
                        } else {
                            if (message.getType() == MessageType.USER_REMOVED) {
                                informAboutDeletingNewUser(message.getData());
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            throw new IOException("Unexpected MessageType");
        }

        public void run() {
            String adress = getServerAddress();


            try {
                int port = getServerPort();
                Socket socket = new Socket(adress, port);

                 connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }

        }
    }

   protected String getServerAddress() {
       ConsoleHelper.writeMessage("Введите адрес сервера");
       String serverAddress = ConsoleHelper.readString();

       return serverAddress;
   }
   protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера");

        int serverPort = ConsoleHelper.readInt();

        return serverPort;
   }

   protected String getUserName() {

        ConsoleHelper.writeMessage("Введите имя пользователя");
        String userName = ConsoleHelper.readString();

        return userName;
   }

   protected  boolean shouldSendTextFromConsole() {
        return true;
   }

   protected SocketThread getSocketThread() {

        SocketThread socketThread = new SocketThread();

        return socketThread;
   }

   protected void sendTextMessage(String text) {


       try {
           Message message = new Message(MessageType.TEXT,text);
           connection.send(message);
       } catch (IOException e) {
           clientConnected = false;
       }
   }

    public void run(){
//        SocketThread thread = client.getSocketThread();
        SocketThread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();

        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("При работе клиента возникла ошибка");
        }
        if(clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’");
            while (clientConnected) {
                String text = ConsoleHelper.readString();
                if (text.equalsIgnoreCase("exit")) {
                    break;
                }else if(shouldSendTextFromConsole()){
                    sendTextMessage(text);
                }
            }
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка соединения");






    } }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
