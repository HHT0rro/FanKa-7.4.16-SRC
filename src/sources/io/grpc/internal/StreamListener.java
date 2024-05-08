package io.grpc.internal;

import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface StreamListener {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface MessageProducer {
        InputStream next();
    }

    void messagesAvailable(MessageProducer messageProducer);

    void onReady();
}
