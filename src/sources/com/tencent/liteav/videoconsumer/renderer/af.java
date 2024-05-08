package com.tencent.liteav.videoconsumer.renderer;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44063a;

    /* renamed from: b, reason: collision with root package name */
    private final List f44064b;

    /* renamed from: c, reason: collision with root package name */
    private final List f44065c;

    private af(t tVar, List list, List list2) {
        this.f44063a = tVar;
        this.f44064b = list;
        this.f44065c = list2;
    }

    public static Runnable a(t tVar, List list, List list2) {
        return new af(tVar, list, list2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44063a, this.f44064b, this.f44065c);
    }
}
