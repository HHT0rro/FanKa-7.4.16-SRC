package com.alibaba.security.common.http.ok;

import java.net.Socket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
