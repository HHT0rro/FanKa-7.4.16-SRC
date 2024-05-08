package f;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class a<K, A> {

    /* renamed from: c, reason: collision with root package name */
    public final d<K> f49025c;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public o.c<A> f49027e;

    /* renamed from: a, reason: collision with root package name */
    public final List<b> f49023a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public boolean f49024b = false;

    /* renamed from: d, reason: collision with root package name */
    public float f49026d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public A f49028f = null;

    /* renamed from: g, reason: collision with root package name */
    public float f49029g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f49030h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface b {
        void e();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class c<T> implements d<T> {
        public c() {
        }

        @Override // f.a.d
        public o.a<T> a() {
            throw new IllegalStateException("not implemented");
        }

        @Override // f.a.d
        public float b() {
            return 0.0f;
        }

        @Override // f.a.d
        public boolean c(float f10) {
            throw new IllegalStateException("not implemented");
        }

        @Override // f.a.d
        public boolean d(float f10) {
            return false;
        }

        @Override // f.a.d
        public float e() {
            return 1.0f;
        }

        @Override // f.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface d<T> {
        o.a<T> a();

        @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
        float b();

        boolean c(float f10);

        boolean d(float f10);

        @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class e<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        public final List<? extends o.a<T>> f49031a;

        /* renamed from: c, reason: collision with root package name */
        public o.a<T> f49033c = null;

        /* renamed from: d, reason: collision with root package name */
        public float f49034d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        public o.a<T> f49032b = f(0.0f);

        public e(List<? extends o.a<T>> list) {
            this.f49031a = list;
        }

        @Override // f.a.d
        @NonNull
        public o.a<T> a() {
            return this.f49032b;
        }

        @Override // f.a.d
        public float b() {
            return this.f49031a.get(0).f();
        }

        @Override // f.a.d
        public boolean c(float f10) {
            o.a<T> aVar = this.f49033c;
            o.a<T> aVar2 = this.f49032b;
            if (aVar == aVar2 && this.f49034d == f10) {
                return true;
            }
            this.f49033c = aVar2;
            this.f49034d = f10;
            return false;
        }

        @Override // f.a.d
        public boolean d(float f10) {
            if (this.f49032b.a(f10)) {
                return !this.f49032b.i();
            }
            this.f49032b = f(f10);
            return true;
        }

        @Override // f.a.d
        public float e() {
            return this.f49031a.get(r0.size() - 1).c();
        }

        public final o.a<T> f(float f10) {
            List<? extends o.a<T>> list = this.f49031a;
            o.a<T> aVar = list.get(list.size() - 1);
            if (f10 >= aVar.f()) {
                return aVar;
            }
            for (int size = this.f49031a.size() - 2; size >= 1; size--) {
                o.a<T> aVar2 = this.f49031a.get(size);
                if (this.f49032b != aVar2 && aVar2.a(f10)) {
                    return aVar2;
                }
            }
            return this.f49031a.get(0);
        }

        @Override // f.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class f<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public final o.a<T> f49035a;

        /* renamed from: b, reason: collision with root package name */
        public float f49036b = -1.0f;

        public f(List<? extends o.a<T>> list) {
            this.f49035a = list.get(0);
        }

        @Override // f.a.d
        public o.a<T> a() {
            return this.f49035a;
        }

        @Override // f.a.d
        public float b() {
            return this.f49035a.f();
        }

        @Override // f.a.d
        public boolean c(float f10) {
            if (this.f49036b == f10) {
                return true;
            }
            this.f49036b = f10;
            return false;
        }

        @Override // f.a.d
        public boolean d(float f10) {
            return !this.f49035a.i();
        }

        @Override // f.a.d
        public float e() {
            return this.f49035a.c();
        }

        @Override // f.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public a(List<? extends o.a<K>> list) {
        this.f49025c = o(list);
    }

    public static <T> d<T> o(List<? extends o.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.f49023a.add(bVar);
    }

    public o.a<K> b() {
        com.airbnb.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        o.a<K> a10 = this.f49025c.a();
        com.airbnb.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return a10;
    }

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
    public float c() {
        if (this.f49030h == -1.0f) {
            this.f49030h = this.f49025c.e();
        }
        return this.f49030h;
    }

    public float d() {
        o.a<K> b4 = b();
        if (b4 == null || b4.i()) {
            return 0.0f;
        }
        return b4.f52213d.getInterpolation(e());
    }

    public float e() {
        if (this.f49024b) {
            return 0.0f;
        }
        o.a<K> b4 = b();
        if (b4.i()) {
            return 0.0f;
        }
        return (this.f49026d - b4.f()) / (b4.c() - b4.f());
    }

    public float f() {
        return this.f49026d;
    }

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
    public final float g() {
        if (this.f49029g == -1.0f) {
            this.f49029g = this.f49025c.b();
        }
        return this.f49029g;
    }

    public A h() {
        A i10;
        float e2 = e();
        if (this.f49027e == null && this.f49025c.c(e2)) {
            return this.f49028f;
        }
        o.a<K> b4 = b();
        Interpolator interpolator = b4.f52214e;
        if (interpolator != null && b4.f52215f != null) {
            i10 = j(b4, e2, interpolator.getInterpolation(e2), b4.f52215f.getInterpolation(e2));
        } else {
            i10 = i(b4, d());
        }
        this.f49028f = i10;
        return i10;
    }

    public abstract A i(o.a<K> aVar, float f10);

    public A j(o.a<K> aVar, float f10, float f11, float f12) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i10 = 0; i10 < this.f49023a.size(); i10++) {
            this.f49023a.get(i10).e();
        }
    }

    public void l() {
        this.f49024b = true;
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.f49025c.isEmpty()) {
            return;
        }
        if (f10 < g()) {
            f10 = g();
        } else if (f10 > c()) {
            f10 = c();
        }
        if (f10 == this.f49026d) {
            return;
        }
        this.f49026d = f10;
        if (this.f49025c.d(f10)) {
            k();
        }
    }

    public void n(@Nullable o.c<A> cVar) {
        o.c<A> cVar2 = this.f49027e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f49027e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
