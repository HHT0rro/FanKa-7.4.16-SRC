package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: CommonHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<a> f30413a;

    /* compiled from: CommonHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void a(Message message);
    }

    public f(a aVar) {
        this.f30413a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f30413a.get();
        if (aVar != null) {
            aVar.a(message);
        }
    }
}
