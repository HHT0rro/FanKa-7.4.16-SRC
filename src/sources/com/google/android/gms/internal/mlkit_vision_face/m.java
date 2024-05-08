package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class m extends k implements List {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzao f25052g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NullableDecl zzao zzaoVar, Object obj, @NullableDecl List list, k kVar) {
        super(zzaoVar, obj, list, kVar);
        this.f25052g = zzaoVar;
    }

    @Override // java.util.List
    public final void add(int i10, Object obj) {
        b();
        boolean isEmpty = this.f24988c.isEmpty();
        ((List) this.f24988c).add(i10, obj);
        zzao.zzl(this.f25052g);
        if (isEmpty) {
            c();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i10, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.f24988c).addAll(i10, collection);
        if (!addAll) {
            return addAll;
        }
        zzao.zzm(this.f25052g, this.f24988c.size() - size);
        if (size != 0) {
            return addAll;
        }
        c();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        b();
        return ((List) this.f24988c).get(i10);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        b();
        return ((List) this.f24988c).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        b();
        return ((List) this.f24988c).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        b();
        return new l(this);
    }

    @Override // java.util.List
    public final Object remove(int i10) {
        b();
        Object remove = ((List) this.f24988c).remove(i10);
        zzao.zzk(this.f25052g);
        zzb();
        return remove;
    }

    @Override // java.util.List
    public final Object set(int i10, Object obj) {
        b();
        return ((List) this.f24988c).set(i10, obj);
    }

    @Override // java.util.List
    public final List subList(int i10, int i11) {
        b();
        zzao zzaoVar = this.f25052g;
        Object obj = this.f24987b;
        List subList = ((List) this.f24988c).subList(i10, i11);
        k kVar = this.f24989d;
        if (kVar == null) {
            kVar = this;
        }
        return zzaoVar.zzg(obj, subList, kVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i10) {
        b();
        return new l(this, i10);
    }
}
