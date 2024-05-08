package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.Rotation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class as implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44953a;

    /* renamed from: b, reason: collision with root package name */
    private final Rotation f44954b;

    /* renamed from: c, reason: collision with root package name */
    private final Rotation f44955c;

    private as(i iVar, Rotation rotation, Rotation rotation2) {
        this.f44953a = iVar;
        this.f44954b = rotation;
        this.f44955c = rotation2;
    }

    public static Runnable a(i iVar, Rotation rotation, Rotation rotation2) {
        return new as(iVar, rotation, rotation2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44953a, this.f44954b, this.f44955c);
    }
}
