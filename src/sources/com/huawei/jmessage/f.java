package com.huawei.jmessage;

import android.os.RemoteException;
import com.huawei.jmessage.api.MessageChannelPayload;
import com.koushikdutta.quack.JavaScriptObject;

/* compiled from: MessageChannelCallback.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f implements MessageChannelPayload.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final JavaScriptObject f32027a;

    public f(JavaScriptObject javaScriptObject) {
        this.f32027a = javaScriptObject;
    }

    private static boolean a(JavaScriptObject javaScriptObject) {
        return (javaScriptObject == null || javaScriptObject.quackContext.isClose()) ? false : true;
    }

    @Override // com.huawei.jmessage.api.MessageChannelPayload.Callback
    public Object call(Object... objArr) throws RemoteException {
        if (a(this.f32027a)) {
            return this.f32027a.call(objArr);
        }
        throw new RemoteException("JavaScriptObject is invalid");
    }
}
