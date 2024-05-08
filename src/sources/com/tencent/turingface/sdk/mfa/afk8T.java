package com.tencent.turingface.sdk.mfa;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class afk8T implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f45740a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f45741b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f45742c;

    public afk8T(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f45740a = atomicBoolean;
        this.f45741b = atomicReference;
        this.f45742c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f45740a.get()) {
            return;
        }
        try {
            throw new Exception("");
        } catch (Exception e2) {
            String a10 = kC0XR.a(kC0XR.G0);
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (a10.equals(stackTraceElement.getClassName() + "_" + stackTraceElement.getMethodName())) {
                    this.f45741b.set(Boolean.TRUE);
                }
            }
            synchronized (this.f45742c) {
                this.f45742c.notify();
            }
        }
    }
}
