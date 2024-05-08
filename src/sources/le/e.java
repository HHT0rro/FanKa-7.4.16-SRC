package le;

import io.reactivex.Scheduler;
import java.lang.reflect.Type;

/* compiled from: RxJava2CallAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e<R> implements retrofit2.c<R, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final Type f51709a;

    /* renamed from: b, reason: collision with root package name */
    public final Scheduler f51710b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f51711c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f51712d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f51713e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f51714f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f51715g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f51716h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f51717i;

    public e(Type type, Scheduler scheduler, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.f51709a = type;
        this.f51710b = scheduler;
        this.f51711c = z10;
        this.f51712d = z11;
        this.f51713e = z12;
        this.f51714f = z13;
        this.f51715g = z14;
        this.f51716h = z15;
        this.f51717i = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // retrofit2.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(retrofit2.b<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.f51711c
            if (r0 == 0) goto La
            le.b r0 = new le.b
            r0.<init>(r2)
            goto Lf
        La:
            le.c r0 = new le.c
            r0.<init>(r2)
        Lf:
            boolean r2 = r1.f51712d
            if (r2 == 0) goto L1a
            le.d r2 = new le.d
            r2.<init>(r0)
        L18:
            r0 = r2
            goto L24
        L1a:
            boolean r2 = r1.f51713e
            if (r2 == 0) goto L24
            le.a r2 = new le.a
            r2.<init>(r0)
            goto L18
        L24:
            io.reactivex.Scheduler r2 = r1.f51710b
            if (r2 == 0) goto L2c
            io.reactivex.Observable r0 = r0.subscribeOn(r2)
        L2c:
            boolean r2 = r1.f51714f
            if (r2 == 0) goto L37
            io.reactivex.BackpressureStrategy r2 = io.reactivex.BackpressureStrategy.LATEST
            io.reactivex.Flowable r2 = r0.toFlowable(r2)
            return r2
        L37:
            boolean r2 = r1.f51715g
            if (r2 == 0) goto L40
            io.reactivex.Single r2 = r0.singleOrError()
            return r2
        L40:
            boolean r2 = r1.f51716h
            if (r2 == 0) goto L49
            io.reactivex.Maybe r2 = r0.singleElement()
            return r2
        L49:
            boolean r2 = r1.f51717i
            if (r2 == 0) goto L52
            io.reactivex.Completable r2 = r0.ignoreElements()
            return r2
        L52:
            io.reactivex.Observable r2 = io.reactivex.plugins.RxJavaPlugins.onAssembly(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: le.e.a(retrofit2.b):java.lang.Object");
    }

    @Override // retrofit2.c
    public Type responseType() {
        return this.f51709a;
    }
}
