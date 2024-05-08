package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k0 extends h7.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zack f23472a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(zack zackVar, Looper looper) {
        super(looper);
        this.f23472a = zackVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        zack zackVar;
        int i10 = message.what;
        if (i10 != 0) {
            if (i10 != 1) {
                StringBuilder sb2 = new StringBuilder(70);
                sb2.append("TransformationResultHandler received unknown message type: ");
                sb2.append(i10);
                return;
            } else {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String valueOf = String.valueOf(runtimeException.getMessage());
                if (valueOf.length() != 0) {
                    "Runtime exception on the transformation worker thread: ".concat(valueOf);
                    throw runtimeException;
                }
                throw runtimeException;
            }
        }
        PendingResult<?> pendingResult = (PendingResult) message.obj;
        obj = this.f23472a.f23503e;
        synchronized (obj) {
            zackVar = this.f23472a.f23500b;
            zack zackVar2 = (zack) com.google.android.gms.common.internal.h.h(zackVar);
            if (pendingResult == null) {
                zackVar2.e(new Status(13, "Transform returned null"));
            } else if (pendingResult instanceof d0) {
                zackVar2.e(((d0) pendingResult).b());
            } else {
                zackVar2.c(pendingResult);
            }
        }
    }
}
