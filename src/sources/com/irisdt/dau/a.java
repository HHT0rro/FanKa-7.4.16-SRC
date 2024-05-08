package com.irisdt.dau;

import com.irisdt.dau.DayActiveUserProtos;
import com.irisdt.dau.ReportServiceGrpc;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* compiled from: ReportServiceGrpc.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a {
    public static void a(ReportServiceGrpc.AsyncService asyncService, DayActiveUserProtos.Request request, StreamObserver streamObserver) {
        ServerCalls.asyncUnimplementedUnaryCall(ReportServiceGrpc.getReportMethod(), streamObserver);
    }
}
