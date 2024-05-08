package com.tencent.liteav.videobase.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final a f43374a = new a();

    private a() {
    }

    public static Runnable a() {
        return f43374a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HDRCapability.checkIsHDR10Supported();
    }
}
