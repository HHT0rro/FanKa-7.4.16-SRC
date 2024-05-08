package com.google.android.gms.internal.mlkit_vision_common;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k7 extends m7 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f24423b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f24424c;

    public k7(Object obj) {
        this.f24424c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f24423b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f24423b) {
            this.f24423b = true;
            return this.f24424c;
        }
        throw new NoSuchElementException();
    }
}
