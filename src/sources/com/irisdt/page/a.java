package com.irisdt.page;

import com.irisdt.page.PageDurationProtos;
import com.irisdt.page.ReportServiceGrpc;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* compiled from: ReportServiceGrpc.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a {
    public static void a(ReportServiceGrpc.AsyncService asyncService, PageDurationProtos.Requests requests, StreamObserver streamObserver) {
        ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getBatchReportMethod(), streamObserver);
    }
}
