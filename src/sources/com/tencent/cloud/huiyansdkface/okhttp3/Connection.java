package com.tencent.cloud.huiyansdkface.okhttp3;

import java.net.Socket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
