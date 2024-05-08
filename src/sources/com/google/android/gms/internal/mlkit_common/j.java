package com.google.android.gms.internal.mlkit_common;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j extends l {

    /* renamed from: b, reason: collision with root package name */
    public boolean f24181b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f24182c;

    public j(Object obj) {
        this.f24182c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f24181b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f24181b) {
            this.f24181b = true;
            return this.f24182c;
        }
        throw new NoSuchElementException();
    }
}
