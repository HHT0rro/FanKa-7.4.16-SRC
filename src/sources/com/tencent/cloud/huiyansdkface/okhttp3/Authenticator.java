package com.tencent.cloud.huiyansdkface.okhttp3;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface Authenticator {

    /* renamed from: a, reason: collision with root package name */
    public static final Authenticator f41232a = new Authenticator() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Authenticator.1
        @Override // com.tencent.cloud.huiyansdkface.okhttp3.Authenticator
        public Request authenticate(Route route, Response response) {
            return null;
        }
    };

    Request authenticate(Route route, Response response) throws IOException;
}
