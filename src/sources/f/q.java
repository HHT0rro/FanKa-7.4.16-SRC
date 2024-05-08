package f;

import androidx.annotation.Nullable;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class q<K, A> extends a<K, A> {

    /* renamed from: i, reason: collision with root package name */
    public final A f49085i;

    public q(o.c<A> cVar) {
        this(cVar, null);
    }

    @Override // f.a
    public float c() {
        return 1.0f;
    }

    @Override // f.a
    public A h() {
        o.c<A> cVar = this.f49027e;
        A a10 = this.f49085i;
        return cVar.b(0.0f, 0.0f, a10, a10, f(), f(), f());
    }

    @Override // f.a
    public A i(o.a<K> aVar, float f10) {
        return h();
    }

    @Override // f.a
    public void k() {
        if (this.f49027e != null) {
            super.k();
        }
    }

    @Override // f.a
    public void m(float f10) {
        this.f49026d = f10;
    }

    public q(o.c<A> cVar, @Nullable A a10) {
        super(Collections.emptyList());
        n(cVar);
        this.f49085i = a10;
    }
}
