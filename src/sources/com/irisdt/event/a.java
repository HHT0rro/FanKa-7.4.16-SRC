package com.irisdt.event;

import com.irisdt.event.CustomEventProtos;
import com.irisdt.event.ReportServiceGrpc;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* compiled from: ReportServiceGrpc.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a {
    public static void a(ReportServiceGrpc.AsyncService asyncService, CustomEventProtos.Requests requests, StreamObserver streamObserver) {
        ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getBatchReportMethod(), streamObserver);
    }
}
