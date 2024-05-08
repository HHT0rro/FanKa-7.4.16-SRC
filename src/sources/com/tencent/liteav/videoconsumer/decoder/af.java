package com.tencent.liteav.videoconsumer.decoder;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ae f43845a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f43846b;

    private af(ae aeVar, Surface surface) {
        this.f43845a = aeVar;
        this.f43846b = surface;
    }

    public static Runnable a(ae aeVar, Surface surface) {
        return new af(aeVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43845a.f43844i = this.f43846b;
    }
}
