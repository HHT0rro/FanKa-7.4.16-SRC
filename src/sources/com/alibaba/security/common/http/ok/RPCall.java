package com.alibaba.security.common.http.ok;

import com.alibaba.security.common.http.okio.Timeout;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface RPCall extends Cloneable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Factory {
        RPCall newCall(RPRequest rPRequest);
    }

    void cancel();

    RPCall clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    RPRequest request();

    Timeout timeout();
}
