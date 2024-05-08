package com.tencent.turingface.sdk.mfa;

import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class WOMZP<E> {

    /* renamed from: a, reason: collision with root package name */
    public final int f45718a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<E> f45719b = new LinkedList<>();

    public WOMZP(int i10) {
        this.f45718a = i10;
    }

    public final void a(E e2) {
        if (this.f45719b.size() >= this.f45718a) {
            this.f45719b.poll();
        }
        this.f45719b.offer(e2);
    }
}
