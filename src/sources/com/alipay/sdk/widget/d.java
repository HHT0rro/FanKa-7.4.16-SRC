package com.alipay.sdk.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f4790a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, Looper looper) {
        super(looper);
        this.f4790a = aVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        this.f4790a.c();
    }
}
