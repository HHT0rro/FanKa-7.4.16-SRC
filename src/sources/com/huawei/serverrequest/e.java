package com.huawei.serverrequest;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.serverrequest.api.ServerResponse;

/* compiled from: RequestLogger.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f34815a = "ServerRequest";

    /* renamed from: b, reason: collision with root package name */
    private static final String f34816b = "ServerRequest";

    public static void a(@NonNull d dVar, @NonNull ServerResponse serverResponse, long j10) {
        a(dVar);
        b(dVar, serverResponse, j10);
    }

    public static void b(@NonNull d dVar, @NonNull ServerResponse serverResponse, long j10) {
        Log.d("ServerRequest", dVar.a().getId() + " on response(" + ((Object) serverResponse.getResponseType()) + "):" + System.lineSeparator() + "<-- " + serverResponse.getResponse().statusCode() + " " + serverResponse.getResponse().statusMessage() + " " + serverResponse.getResponse().url() + " (" + j10 + "ms)" + System.lineSeparator() + "<-- END HTTP (length = " + serverResponse.getResponse().contentLength() + ")" + System.lineSeparator());
    }

    public static void a(@NonNull d dVar) {
        Log.d("ServerRequest", dVar.a().getId() + " on request(" + ((Object) dVar.a().getRequestType()) + "):" + System.lineSeparator() + "--> " + dVar.method() + " " + dVar.url() + System.lineSeparator() + "--> END " + dVar.method() + " (length = " + dVar.body().length() + ")" + System.lineSeparator());
    }
}
