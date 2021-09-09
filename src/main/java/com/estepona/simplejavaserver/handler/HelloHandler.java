package com.estepona.simplejavaserver.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HelloHandler implements HttpHandler {
  @Override
  public void handle(HttpExchange t) throws IOException {
    // get query
    String query = t.getRequestURI().getQuery();
    System.out.println("request query: " + query);

    // get body
    InputStream inputStream = t.getRequestBody();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    inputStream.transferTo(outputStream);
    System.out.println("request body: " + outputStream);

    String message = "Hello World\n";

    t.sendResponseHeaders(200, message.length());
    OutputStream os = t.getResponseBody();
    os.write(message.getBytes());
    os.close();
  }
}
