package o;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: LottieValueCallback.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final b<T> f52233a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public f.a<?, ?> f52234b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public T f52235c;

    public c() {
        this.f52233a = new b<>();
        this.f52235c = null;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.f52235c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f10, float f11, T t2, T t10, float f12, float f13, float f14) {
        return a(this.f52233a.h(f10, f11, t2, t10, f12, f13, f14));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable f.a<?, ?> aVar) {
        this.f52234b = aVar;
    }

    public c(@Nullable T t2) {
        this.f52233a = new b<>();
        this.f52235c = t2;
    }
}
