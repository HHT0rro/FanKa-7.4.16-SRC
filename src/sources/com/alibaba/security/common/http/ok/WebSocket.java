package com.alibaba.security.common.http.ok;

import com.alibaba.security.common.http.okio.ByteString;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface WebSocket {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Factory {
        WebSocket newWebSocket(RPRequest rPRequest, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i10, String str);

    long queueSize();

    RPRequest request();

    boolean send(ByteString byteString);

    boolean send(String str);
}
