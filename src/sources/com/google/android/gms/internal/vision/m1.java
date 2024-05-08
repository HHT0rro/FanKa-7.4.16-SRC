package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m1 extends r1 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f25548b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f25549c;

    public m1(Object obj) {
        this.f25549c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f25548b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f25548b) {
            this.f25548b = true;
            return this.f25549c;
        }
        throw new NoSuchElementException();
    }
}
