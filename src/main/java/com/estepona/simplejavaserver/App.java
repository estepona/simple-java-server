package com.estepona.simplejavaserver;

import com.estepona.simplejavaserver.handler.HelloHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
  public static String hostname = "localhost";
  public static int port = 8000;

  public static void main(String[] args) {
    try {
      HttpServer httpServer = HttpServer.create(new InetSocketAddress(hostname, port), 0);
      httpServer.setExecutor(null);

      httpServer.createContext("/hello", new HelloHandler());

      httpServer.start();
      System.out.println("server started at " + hostname + ":" + port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
