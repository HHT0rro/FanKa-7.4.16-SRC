package com.irisdt.apm;

import com.irisdt.apm.ApmProtos;
import com.irisdt.apm.ReportServiceGrpc;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* compiled from: ReportServiceGrpc.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a {
    public static void a(ReportServiceGrpc.AsyncService asyncService, ApmProtos.Requests requests, StreamObserver streamObserver) {
        ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getBatchReportMethod(), streamObserver);
    }
}
