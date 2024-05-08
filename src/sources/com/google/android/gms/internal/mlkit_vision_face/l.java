package com.google.android.gms.internal.mlkit_vision_face;

import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l extends j implements ListIterator {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m f25029e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar) {
        super(mVar);
        this.f25029e = mVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean isEmpty = this.f25029e.isEmpty();
        a();
        ((ListIterator) this.f24950b).add(obj);
        zzao.zzl(this.f25029e.f25052g);
        if (isEmpty) {
            this.f25029e.c();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        return ((ListIterator) this.f24950b).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return ((ListIterator) this.f24950b).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        return ((ListIterator) this.f24950b).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return ((ListIterator) this.f24950b).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        ((ListIterator) this.f24950b).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, int i10) {
        super(mVar, ((List) mVar.f24988c).listIterator(i10));
        this.f25029e = mVar;
    }
}
