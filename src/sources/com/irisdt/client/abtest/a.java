package com.irisdt.client.abtest;

import com.irisdt.client.abtest.AbClientProtos;
import com.irisdt.client.abtest.AbClientServiceGrpc;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* compiled from: AbClientServiceGrpc.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a {
    public static void a(AbClientServiceGrpc.AsyncService asyncService, AbClientProtos.Request request, StreamObserver streamObserver) {
        ServerCalls.asyncUnimplementedUnaryCall(AbClientServiceGrpc.getGetAbResultMethod(), streamObserver);
    }
}
