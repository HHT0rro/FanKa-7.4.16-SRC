package com.tencent.liteav.videoproducer.producer;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45051a;

    /* renamed from: b, reason: collision with root package name */
    private final List f45052b;

    /* renamed from: c, reason: collision with root package name */
    private final List f45053c;

    private w(i iVar, List list, List list2) {
        this.f45051a = iVar;
        this.f45052b = list;
        this.f45053c = list2;
    }

    public static Runnable a(i iVar, List list, List list2) {
        return new w(iVar, list, list2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45051a, this.f45052b, this.f45053c);
    }
}
