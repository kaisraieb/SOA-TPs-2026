package dev.kais;

import dev.kais.Services.BanqueServiceImpl;
import jakarta.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        String url = "http://localhost:9000/BanqueWS";

        Endpoint.publish(url, new BanqueServiceImpl());

        System.out.println("Web Service déployé sur : " + url);

        System.out.println("WSDL dispo sur : " + url + "?WSDL");
    }
}