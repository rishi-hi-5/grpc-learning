package com.learning.demo.service;

import com.demo.animeservice.AnimeServiceGrpc;
import com.demo.animeservice.PowerId;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

public class AnimeServiceImpl extends AnimeServiceGrpc.AnimeServiceImplBase {

    Map<com.demo.animeservice.PowerId, com.demo.animeservice.Power> powerMap = new HashMap<>();

    @Override
    public void addPower(com.demo.animeservice.Power request,
                         io.grpc.stub.StreamObserver<com.demo.animeservice.PowerId> responseObserver) {
        PowerId powerId = PowerId
                .newBuilder()
                .setId(UUID.randomUUID().toString())
                .build();
        powerMap.put(powerId,request);
        responseObserver.onNext(powerId);
        responseObserver.onCompleted();
    }


    @Override
    public void getPower(com.demo.animeservice.PowerId request,
                         io.grpc.stub.StreamObserver<com.demo.animeservice.Power> responseObserver) {
        responseObserver.onNext(powerMap.get(request));
        responseObserver.onCompleted();
    }


}
