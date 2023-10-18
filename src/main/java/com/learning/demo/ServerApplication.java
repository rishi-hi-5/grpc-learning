package com.learning.demo;


import com.learning.demo.service.AnimeServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server starting up and registering services");
        Server server = ServerBuilder
                .forPort(9091)
                .addService(new AnimeServiceImpl())
                .build();
        server.start();
        System.out.println("Server started");
        server.awaitTermination();
        System.out.println("Server shutting down");
    }
}
