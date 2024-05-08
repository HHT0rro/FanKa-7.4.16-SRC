package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class z<E> extends a0<E> {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f25343a = new Object[4];

    /* renamed from: b, reason: collision with root package name */
    public int f25344b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25345c;

    public z(int i10) {
    }

    public final z<E> a(E e2) {
        Objects.requireNonNull(e2);
        b(this.f25344b + 1);
        Object[] objArr = this.f25343a;
        int i10 = this.f25344b;
        this.f25344b = i10 + 1;
        objArr[i10] = e2;
        return this;
    }

    public final void b(int i10) {
        Object[] objArr = this.f25343a;
        int length = objArr.length;
        if (length >= i10) {
            if (this.f25345c) {
                this.f25343a = (Object[]) objArr.clone();
                this.f25345c = false;
                return;
            }
            return;
        }
        int i11 = length + (length >> 1) + 1;
        if (i11 < i10) {
            int highestOneBit = Integer.highestOneBit(i10 - 1);
            i11 = highestOneBit + highestOneBit;
        }
        if (i11 < 0) {
            i11 = Integer.MAX_VALUE;
        }
        this.f25343a = Arrays.copyOf(objArr, i11);
        this.f25345c = false;
    }
}
