package e6;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.q;
import java.util.Collections;
import java.util.List;

/* compiled from: TextRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k extends com.google.android.exoplayer2.f implements Handler.Callback {
    public int A;
    public long B;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public final Handler f48925n;

    /* renamed from: o, reason: collision with root package name */
    public final j f48926o;

    /* renamed from: p, reason: collision with root package name */
    public final g f48927p;

    /* renamed from: q, reason: collision with root package name */
    public final s0 f48928q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f48929r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f48930s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f48931t;

    /* renamed from: u, reason: collision with root package name */
    public int f48932u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public Format f48933v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public f f48934w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public h f48935x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public i f48936y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public i f48937z;

    public k(j jVar, @Nullable Looper looper) {
        this(jVar, looper, g.f48921a);
    }

    @Override // com.google.android.exoplayer2.f
    public void E() {
        this.f48933v = null;
        this.B = -9223372036854775807L;
        N();
        T();
    }

    @Override // com.google.android.exoplayer2.f
    public void G(long j10, boolean z10) {
        N();
        this.f48929r = false;
        this.f48930s = false;
        this.B = -9223372036854775807L;
        if (this.f48932u != 0) {
            U();
        } else {
            S();
            ((f) com.google.android.exoplayer2.util.a.e(this.f48934w)).flush();
        }
    }

    @Override // com.google.android.exoplayer2.f
    public void K(Format[] formatArr, long j10, long j11) {
        this.f48933v = formatArr[0];
        if (this.f48934w != null) {
            this.f48932u = 1;
        } else {
            Q();
        }
    }

    public final void N() {
        W(Collections.emptyList());
    }

    public final long O() {
        if (this.A == -1) {
            return Long.MAX_VALUE;
        }
        com.google.android.exoplayer2.util.a.e(this.f48936y);
        if (this.A >= this.f48936y.b()) {
            return Long.MAX_VALUE;
        }
        return this.f48936y.a(this.A);
    }

    public final void P(SubtitleDecoderException subtitleDecoderException) {
        String valueOf = String.valueOf(this.f48933v);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 39);
        sb2.append("Subtitle decoding failed. streamFormat=");
        sb2.append(valueOf);
        m.d("TextRenderer", sb2.toString(), subtitleDecoderException);
        N();
        U();
    }

    public final void Q() {
        this.f48931t = true;
        this.f48934w = this.f48927p.b((Format) com.google.android.exoplayer2.util.a.e(this.f48933v));
    }

    public final void R(List<a> list) {
        this.f48926o.onCues(list);
    }

    public final void S() {
        this.f48935x = null;
        this.A = -1;
        i iVar = this.f48936y;
        if (iVar != null) {
            iVar.p();
            this.f48936y = null;
        }
        i iVar2 = this.f48937z;
        if (iVar2 != null) {
            iVar2.p();
            this.f48937z = null;
        }
    }

    public final void T() {
        S();
        ((f) com.google.android.exoplayer2.util.a.e(this.f48934w)).release();
        this.f48934w = null;
        this.f48932u = 0;
    }

    public final void U() {
        T();
        Q();
    }

    public void V(long j10) {
        com.google.android.exoplayer2.util.a.g(j());
        this.B = j10;
    }

    public final void W(List<a> list) {
        Handler handler = this.f48925n;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            R(list);
        }
    }

    @Override // com.google.android.exoplayer2.n1
    public int a(Format format) {
        if (this.f48927p.a(format)) {
            return m1.a(format.F == null ? 4 : 2);
        }
        if (q.r(format.f19544m)) {
            return m1.a(1);
        }
        return m1.a(0);
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean b() {
        return this.f48930s;
    }

    @Override // com.google.android.exoplayer2.l1, com.google.android.exoplayer2.n1
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            R((List) message.obj);
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
        boolean z10;
        if (j()) {
            long j12 = this.B;
            if (j12 != -9223372036854775807L && j10 >= j12) {
                S();
                this.f48930s = true;
            }
        }
        if (this.f48930s) {
            return;
        }
        if (this.f48937z == null) {
            ((f) com.google.android.exoplayer2.util.a.e(this.f48934w)).b(j10);
            try {
                this.f48937z = ((f) com.google.android.exoplayer2.util.a.e(this.f48934w)).c();
            } catch (SubtitleDecoderException e2) {
                P(e2);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f48936y != null) {
            long O = O();
            z10 = false;
            while (O <= j10) {
                this.A++;
                O = O();
                z10 = true;
            }
        } else {
            z10 = false;
        }
        i iVar = this.f48937z;
        if (iVar != null) {
            if (iVar.m()) {
                if (!z10 && O() == Long.MAX_VALUE) {
                    if (this.f48932u == 2) {
                        U();
                    } else {
                        S();
                        this.f48930s = true;
                    }
                }
            } else if (iVar.f54863c <= j10) {
                i iVar2 = this.f48936y;
                if (iVar2 != null) {
                    iVar2.p();
                }
                this.A = iVar.c(j10);
                this.f48936y = iVar;
                this.f48937z = null;
                z10 = true;
            }
        }
        if (z10) {
            com.google.android.exoplayer2.util.a.e(this.f48936y);
            W(this.f48936y.f(j10));
        }
        if (this.f48932u == 2) {
            return;
        }
        while (!this.f48929r) {
            try {
                h hVar = this.f48935x;
                if (hVar == null) {
                    hVar = ((f) com.google.android.exoplayer2.util.a.e(this.f48934w)).a();
                    if (hVar == null) {
                        return;
                    } else {
                        this.f48935x = hVar;
                    }
                }
                if (this.f48932u == 1) {
                    hVar.o(4);
                    ((f) com.google.android.exoplayer2.util.a.e(this.f48934w)).d(hVar);
                    this.f48935x = null;
                    this.f48932u = 2;
                    return;
                }
                int L = L(this.f48928q, hVar, 0);
                if (L == -4) {
                    if (hVar.m()) {
                        this.f48929r = true;
                        this.f48931t = false;
                    } else {
                        Format format = this.f48928q.f21132b;
                        if (format == null) {
                            return;
                        }
                        hVar.f48922j = format.f19548q;
                        hVar.r();
                        this.f48931t &= !hVar.n();
                    }
                    if (!this.f48931t) {
                        ((f) com.google.android.exoplayer2.util.a.e(this.f48934w)).d(hVar);
                        this.f48935x = null;
                    }
                } else if (L == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e10) {
                P(e10);
                return;
            }
        }
    }

    public k(j jVar, @Nullable Looper looper, g gVar) {
        super(3);
        this.f48926o = (j) com.google.android.exoplayer2.util.a.e(jVar);
        this.f48925n = looper == null ? null : j0.w(looper, this);
        this.f48927p = gVar;
        this.f48928q = new s0();
        this.B = -9223372036854775807L;
    }
}
