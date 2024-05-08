package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.w0;
import java.util.Collections;

/* compiled from: SingleSampleMediaSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p0 extends com.google.android.exoplayer2.source.a {

    /* renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f21869h;

    /* renamed from: i, reason: collision with root package name */
    public final a.InterfaceC0208a f21870i;

    /* renamed from: j, reason: collision with root package name */
    public final Format f21871j;

    /* renamed from: k, reason: collision with root package name */
    public final long f21872k;

    /* renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f21873l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f21874m;

    /* renamed from: n, reason: collision with root package name */
    public final Timeline f21875n;

    /* renamed from: o, reason: collision with root package name */
    public final w0 f21876o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public o6.v f21877p;

    /* compiled from: SingleSampleMediaSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0208a f21878a;

        /* renamed from: b, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.h f21879b = new com.google.android.exoplayer2.upstream.f();

        /* renamed from: c, reason: collision with root package name */
        public boolean f21880c = true;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f21881d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public String f21882e;

        public b(a.InterfaceC0208a interfaceC0208a) {
            this.f21878a = (a.InterfaceC0208a) com.google.android.exoplayer2.util.a.e(interfaceC0208a);
        }

        public p0 a(w0.h hVar, long j10) {
            return new p0(this.f21882e, hVar, this.f21878a, j10, this.f21879b, this.f21880c, this.f21881d);
        }

        public b b(@Nullable com.google.android.exoplayer2.upstream.h hVar) {
            if (hVar == null) {
                hVar = new com.google.android.exoplayer2.upstream.f();
            }
            this.f21879b = hVar;
            return this;
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable o6.v vVar) {
        this.f21877p = vVar;
        C(this.f21875n);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f21876o;
    }

    @Override // com.google.android.exoplayer2.source.s
    public p e(s.a aVar, o6.b bVar, long j10) {
        return new o0(this.f21869h, this.f21870i, this.f21877p, this.f21871j, this.f21872k, this.f21873l, w(aVar), this.f21874m);
    }

    @Override // com.google.android.exoplayer2.source.s
    public void f() {
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        ((o0) pVar).r();
    }

    public p0(@Nullable String str, w0.h hVar, a.InterfaceC0208a interfaceC0208a, long j10, com.google.android.exoplayer2.upstream.h hVar2, boolean z10, @Nullable Object obj) {
        this.f21870i = interfaceC0208a;
        this.f21872k = j10;
        this.f21873l = hVar2;
        this.f21874m = z10;
        w0 a10 = new w0.c().t(Uri.EMPTY).p(hVar.f23224a.toString()).r(Collections.singletonList(hVar)).s(obj).a();
        this.f21876o = a10;
        this.f21871j = new Format.b().S(str).e0(hVar.f23225b).V(hVar.f23226c).g0(hVar.f23227d).c0(hVar.f23228e).U(hVar.f23229f).E();
        this.f21869h = new b.C0209b().i(hVar.f23224a).b(1).a();
        this.f21875n = new n0(j10, true, false, false, null, a10);
    }
}
