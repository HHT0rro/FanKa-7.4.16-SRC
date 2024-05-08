package com.irisdt.client;

import com.irisdt.client.ClientProtos;
import com.irisdt.client.ReportServiceGrpc;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* compiled from: ReportServiceGrpc.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class c {
    public static void a(ReportServiceGrpc.AsyncService asyncService, ClientProtos.Requests requests, StreamObserver streamObserver) {
        ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getBatchReportMethod(), streamObserver);
    }
}
