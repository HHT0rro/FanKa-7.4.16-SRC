package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44909a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.MirrorMode f44910b;

    private ab(i iVar, GLConstants.MirrorMode mirrorMode) {
        this.f44909a = iVar;
        this.f44910b = mirrorMode;
    }

    public static Runnable a(i iVar, GLConstants.MirrorMode mirrorMode) {
        return new ab(iVar, mirrorMode);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44909a, this.f44910b);
    }
}
