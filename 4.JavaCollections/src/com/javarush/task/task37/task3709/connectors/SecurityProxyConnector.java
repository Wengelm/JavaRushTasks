package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;

public class SecurityProxyConnector implements Connector {


    SimpleConnector simpleConnector;
    SecurityChecker securityChecker;

    public SecurityProxyConnector(String one){
        simpleConnector = new SimpleConnector(one);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()) {
            simpleConnector.connect();
        }
        else {

            System.out.println("Невозможно подключится.");
        }

    }
}
