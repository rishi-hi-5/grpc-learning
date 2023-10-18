package com.learning.demo;

import com.demo.animeservice.AnimeServiceGrpc;
import com.demo.animeservice.Power;
import com.demo.animeservice.PowerId;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApplication {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9091)
                .usePlaintext()
                .build();

        AnimeServiceGrpc.AnimeServiceBlockingStub stub
                = AnimeServiceGrpc.newBlockingStub(channel);


        Power kamehamehaPower = Power
                .newBuilder()
                .setName("Kamehameha")
                .setPowerOutput(90L)
                .build();

        PowerId powerId = stub.addPower(kamehamehaPower);
        System.out.println("Power Id obtained from server"+powerId.toString());

        Power powerObtained = stub.getPower(powerId);
        System.out.println("Power obtained is"+ powerObtained);

        channel.shutdown();
    }
}
