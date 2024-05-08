package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.videobase.DisplayTarget;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44058a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayTarget f44059b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44060c;

    private ad(t tVar, DisplayTarget displayTarget, boolean z10) {
        this.f44058a = tVar;
        this.f44059b = displayTarget;
        this.f44060c = z10;
    }

    public static Runnable a(t tVar, DisplayTarget displayTarget, boolean z10) {
        return new ad(tVar, displayTarget, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44058a.b(this.f44059b, this.f44060c);
    }
}
