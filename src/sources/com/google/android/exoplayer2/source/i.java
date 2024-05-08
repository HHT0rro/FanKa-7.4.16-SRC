package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

/* compiled from: DefaultMediaSourceFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final a.InterfaceC0208a f21741a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<a0> f21742b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f21743c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f21744d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.ui.b f21745e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.h f21746f;

    /* renamed from: g, reason: collision with root package name */
    public long f21747g;

    /* renamed from: h, reason: collision with root package name */
    public long f21748h;

    /* renamed from: i, reason: collision with root package name */
    public long f21749i;

    /* renamed from: j, reason: collision with root package name */
    public float f21750j;

    /* renamed from: k, reason: collision with root package name */
    public float f21751k;

    /* compiled from: DefaultMediaSourceFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        @Nullable
        com.google.android.exoplayer2.source.ads.b a(w0.b bVar);
    }

    public i(Context context, d5.i iVar) {
        this(new com.google.android.exoplayer2.upstream.d(context), iVar);
    }

    public static SparseArray<a0> c(a.InterfaceC0208a interfaceC0208a, d5.i iVar) {
        SparseArray<a0> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (a0) DashMediaSource.Factory.class.asSubclass(a0.class).getConstructor(a.InterfaceC0208a.class).newInstance(interfaceC0208a));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (a0) SsMediaSource.Factory.class.asSubclass(a0.class).getConstructor(a.InterfaceC0208a.class).newInstance(interfaceC0208a));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (a0) HlsMediaSource.Factory.class.asSubclass(a0.class).getConstructor(a.InterfaceC0208a.class).newInstance(interfaceC0208a));
        } catch (Exception unused3) {
        }
        try {
            sparseArray.put(3, (a0) RtspMediaSource.Factory.class.asSubclass(a0.class).getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception unused4) {
        }
        sparseArray.put(4, new h0.b(interfaceC0208a, iVar));
        return sparseArray;
    }

    public static s d(w0 w0Var, s sVar) {
        w0.d dVar = w0Var.f23166e;
        long j10 = dVar.f23196a;
        if (j10 == 0 && dVar.f23197b == Long.MIN_VALUE && !dVar.f23199d) {
            return sVar;
        }
        long d10 = com.google.android.exoplayer2.h.d(j10);
        long d11 = com.google.android.exoplayer2.h.d(w0Var.f23166e.f23197b);
        w0.d dVar2 = w0Var.f23166e;
        return new ClippingMediaSource(sVar, d10, d11, !dVar2.f23200e, dVar2.f23198c, dVar2.f23199d);
    }

    @Override // com.google.android.exoplayer2.source.a0
    public int[] a() {
        int[] iArr = this.f21743c;
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.google.android.exoplayer2.source.a0
    public s b(w0 w0Var) {
        com.google.android.exoplayer2.util.a.e(w0Var.f23163b);
        w0.g gVar = w0Var.f23163b;
        int l02 = com.google.android.exoplayer2.util.j0.l0(gVar.f23216a, gVar.f23217b);
        a0 a0Var = this.f21742b.get(l02);
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("No suitable media source factory found for content type: ");
        sb2.append(l02);
        com.google.android.exoplayer2.util.a.f(a0Var, sb2.toString());
        w0.f fVar = w0Var.f23164c;
        if ((fVar.f23211a == -9223372036854775807L && this.f21747g != -9223372036854775807L) || ((fVar.f23214d == -3.4028235E38f && this.f21750j != -3.4028235E38f) || ((fVar.f23215e == -3.4028235E38f && this.f21751k != -3.4028235E38f) || ((fVar.f23212b == -9223372036854775807L && this.f21748h != -9223372036854775807L) || (fVar.f23213c == -9223372036854775807L && this.f21749i != -9223372036854775807L))))) {
            w0.c a10 = w0Var.a();
            long j10 = w0Var.f23164c.f23211a;
            if (j10 == -9223372036854775807L) {
                j10 = this.f21747g;
            }
            w0.c o10 = a10.o(j10);
            float f10 = w0Var.f23164c.f23214d;
            if (f10 == -3.4028235E38f) {
                f10 = this.f21750j;
            }
            w0.c n10 = o10.n(f10);
            float f11 = w0Var.f23164c.f23215e;
            if (f11 == -3.4028235E38f) {
                f11 = this.f21751k;
            }
            w0.c l10 = n10.l(f11);
            long j11 = w0Var.f23164c.f23212b;
            if (j11 == -9223372036854775807L) {
                j11 = this.f21748h;
            }
            w0.c m10 = l10.m(j11);
            long j12 = w0Var.f23164c.f23213c;
            if (j12 == -9223372036854775807L) {
                j12 = this.f21749i;
            }
            w0Var = m10.k(j12).a();
        }
        s b4 = a0Var.b(w0Var);
        List<w0.h> list = ((w0.g) com.google.android.exoplayer2.util.j0.j(w0Var.f23163b)).f23222g;
        if (!list.isEmpty()) {
            s[] sVarArr = new s[list.size() + 1];
            int i10 = 0;
            sVarArr[0] = b4;
            p0.b b10 = new p0.b(this.f21741a).b(this.f21746f);
            while (i10 < list.size()) {
                int i11 = i10 + 1;
                sVarArr[i11] = b10.a(list.get(i10), -9223372036854775807L);
                i10 = i11;
            }
            b4 = new MergingMediaSource(sVarArr);
        }
        return e(w0Var, d(w0Var, b4));
    }

    public final s e(w0 w0Var, s sVar) {
        com.google.android.exoplayer2.util.a.e(w0Var.f23163b);
        w0.b bVar = w0Var.f23163b.f23219d;
        if (bVar == null) {
            return sVar;
        }
        a aVar = this.f21744d;
        com.google.android.exoplayer2.ui.b bVar2 = this.f21745e;
        if (aVar != null && bVar2 != null) {
            com.google.android.exoplayer2.source.ads.b a10 = aVar.a(bVar);
            if (a10 == null) {
                com.google.android.exoplayer2.util.m.h("DefaultMediaSourceFactory", "Playing media without ads, as no AdsLoader was provided.");
                return sVar;
            }
            com.google.android.exoplayer2.upstream.b bVar3 = new com.google.android.exoplayer2.upstream.b(bVar.f23167a);
            Object obj = bVar.f23168b;
            return new AdsMediaSource(sVar, bVar3, obj != null ? obj : ImmutableList.of((Uri) w0Var.f23162a, w0Var.f23163b.f23216a, bVar.f23167a), this, a10, bVar2);
        }
        com.google.android.exoplayer2.util.m.h("DefaultMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
        return sVar;
    }

    public i(a.InterfaceC0208a interfaceC0208a, d5.i iVar) {
        this.f21741a = interfaceC0208a;
        SparseArray<a0> c4 = c(interfaceC0208a, iVar);
        this.f21742b = c4;
        this.f21743c = new int[c4.size()];
        for (int i10 = 0; i10 < this.f21742b.size(); i10++) {
            this.f21743c[i10] = this.f21742b.keyAt(i10);
        }
        this.f21747g = -9223372036854775807L;
        this.f21748h = -9223372036854775807L;
        this.f21749i = -9223372036854775807L;
        this.f21750j = -3.4028235E38f;
        this.f21751k = -3.4028235E38f;
    }
}
