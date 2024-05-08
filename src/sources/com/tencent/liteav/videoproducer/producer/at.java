package com.tencent.liteav.videoproducer.producer;

import android.graphics.Point;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class at implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44956a;

    /* renamed from: b, reason: collision with root package name */
    private final Point f44957b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44958c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44959d;

    /* renamed from: e, reason: collision with root package name */
    private final int f44960e;

    /* renamed from: f, reason: collision with root package name */
    private final int f44961f;

    private at(i iVar, Point point, int i10, int i11, int i12, int i13) {
        this.f44956a = iVar;
        this.f44957b = point;
        this.f44958c = i10;
        this.f44959d = i11;
        this.f44960e = i12;
        this.f44961f = i13;
    }

    public static Runnable a(i iVar, Point point, int i10, int i11, int i12, int i13) {
        return new at(iVar, point, i10, i11, i12, i13);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44956a, this.f44957b, this.f44958c, this.f44959d, this.f44960e, this.f44961f);
    }
}
