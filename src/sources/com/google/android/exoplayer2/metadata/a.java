package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.j0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import n5.b;
import n5.c;
import n5.d;
import n5.e;

/* compiled from: MetadataRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends f implements Handler.Callback {

    /* renamed from: n, reason: collision with root package name */
    public final c f20848n;

    /* renamed from: o, reason: collision with root package name */
    public final e f20849o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public final Handler f20850p;

    /* renamed from: q, reason: collision with root package name */
    public final d f20851q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public b f20852r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f20853s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20854t;

    /* renamed from: u, reason: collision with root package name */
    public long f20855u;

    /* renamed from: v, reason: collision with root package name */
    public long f20856v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public Metadata f20857w;

    public a(e eVar, @Nullable Looper looper) {
        this(eVar, looper, c.f52127a);
    }

    @Override // com.google.android.exoplayer2.f
    public void E() {
        this.f20857w = null;
        this.f20856v = -9223372036854775807L;
        this.f20852r = null;
    }

    @Override // com.google.android.exoplayer2.f
    public void G(long j10, boolean z10) {
        this.f20857w = null;
        this.f20856v = -9223372036854775807L;
        this.f20853s = false;
        this.f20854t = false;
    }

    @Override // com.google.android.exoplayer2.f
    public void K(Format[] formatArr, long j10, long j11) {
        this.f20852r = this.f20848n.b(formatArr[0]);
    }

    public final void N(Metadata metadata, List<Metadata.Entry> list) {
        for (int i10 = 0; i10 < metadata.d(); i10++) {
            Format wrappedMetadataFormat = metadata.c(i10).getWrappedMetadataFormat();
            if (wrappedMetadataFormat != null && this.f20848n.a(wrappedMetadataFormat)) {
                b b4 = this.f20848n.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.a.e(metadata.c(i10).getWrappedMetadataBytes());
                this.f20851q.h();
                this.f20851q.q(bArr.length);
                ((ByteBuffer) j0.j(this.f20851q.f19882d)).put(bArr);
                this.f20851q.r();
                Metadata a10 = b4.a(this.f20851q);
                if (a10 != null) {
                    N(a10, list);
                }
            } else {
                list.add(metadata.c(i10));
            }
        }
    }

    public final void O(Metadata metadata) {
        Handler handler = this.f20850p;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            P(metadata);
        }
    }

    public final void P(Metadata metadata) {
        this.f20849o.onMetadata(metadata);
    }

    public final boolean Q(long j10) {
        boolean z10;
        Metadata metadata = this.f20857w;
        if (metadata == null || this.f20856v > j10) {
            z10 = false;
        } else {
            O(metadata);
            this.f20857w = null;
            this.f20856v = -9223372036854775807L;
            z10 = true;
        }
        if (this.f20853s && this.f20857w == null) {
            this.f20854t = true;
        }
        return z10;
    }

    public final void R() {
        if (this.f20853s || this.f20857w != null) {
            return;
        }
        this.f20851q.h();
        s0 A = A();
        int L = L(A, this.f20851q, 0);
        if (L != -4) {
            if (L == -5) {
                this.f20855u = ((Format) com.google.android.exoplayer2.util.a.e(A.f21132b)).f19548q;
                return;
            }
            return;
        }
        if (this.f20851q.m()) {
            this.f20853s = true;
            return;
        }
        d dVar = this.f20851q;
        dVar.f52128j = this.f20855u;
        dVar.r();
        Metadata a10 = ((b) j0.j(this.f20852r)).a(this.f20851q);
        if (a10 != null) {
            ArrayList arrayList = new ArrayList(a10.d());
            N(a10, arrayList);
            if (arrayList.isEmpty()) {
                return;
            }
            this.f20857w = new Metadata(arrayList);
            this.f20856v = this.f20851q.f19884f;
        }
    }

    @Override // com.google.android.exoplayer2.n1
    public int a(Format format) {
        if (this.f20848n.a(format)) {
            return m1.a(format.F == null ? 4 : 2);
        }
        return m1.a(0);
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean b() {
        return this.f20854t;
    }

    @Override // com.google.android.exoplayer2.l1, com.google.android.exoplayer2.n1
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            P((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.l1
    public void k(long j10, long j11) {
        boolean z10 = true;
        while (z10) {
            R();
            z10 = Q(j10);
        }
    }

    public a(e eVar, @Nullable Looper looper, c cVar) {
        super(5);
        this.f20849o = (e) com.google.android.exoplayer2.util.a.e(eVar);
        this.f20850p = looper == null ? null : j0.w(looper, this);
        this.f20848n = (c) com.google.android.exoplayer2.util.a.e(cVar);
        this.f20851q = new d();
        this.f20856v = -9223372036854775807L;
    }
}
