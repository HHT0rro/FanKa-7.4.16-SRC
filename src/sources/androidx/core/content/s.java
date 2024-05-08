package androidx.core.content;

import androidx.core.util.Predicate;

/* compiled from: R8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final /* synthetic */ class s implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f892a;

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return androidx.core.util.g.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate negate() {
        return androidx.core.util.g.b(this);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return androidx.core.util.g.c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return this.f892a.equals((String) obj);
    }
}
