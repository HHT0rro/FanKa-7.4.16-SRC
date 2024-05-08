package com.google.android.gms.internal.mlkit_vision_face;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d0 extends t0 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f24800b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f24801c;

    public d0(Object obj) {
        this.f24801c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f24800b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f24800b) {
            this.f24800b = true;
            return this.f24801c;
        }
        throw new NoSuchElementException();
    }
}
