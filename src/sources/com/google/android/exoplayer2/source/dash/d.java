package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import d5.p;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import o6.g;
import x5.f;

/* compiled from: PlayerEmsgHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements Handler.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final o6.b f21352b;

    /* renamed from: c, reason: collision with root package name */
    public final b f21353c;

    /* renamed from: g, reason: collision with root package name */
    public z5.c f21357g;

    /* renamed from: h, reason: collision with root package name */
    public long f21358h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21359i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21360j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21361k;

    /* renamed from: f, reason: collision with root package name */
    public final TreeMap<Long, Long> f21356f = new TreeMap<>();

    /* renamed from: e, reason: collision with root package name */
    public final Handler f21355e = j0.y(this);

    /* renamed from: d, reason: collision with root package name */
    public final p5.a f21354d = new p5.a();

    /* compiled from: PlayerEmsgHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f21362a;

        /* renamed from: b, reason: collision with root package name */
        public final long f21363b;

        public a(long j10, long j11) {
            this.f21362a = j10;
            this.f21363b = j11;
        }
    }

    /* compiled from: PlayerEmsgHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(long j10);

        void b();
    }

    /* compiled from: PlayerEmsgHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements TrackOutput {

        /* renamed from: a, reason: collision with root package name */
        public final l0 f21364a;

        /* renamed from: b, reason: collision with root package name */
        public final s0 f21365b = new s0();

        /* renamed from: c, reason: collision with root package name */
        public final n5.d f21366c = new n5.d();

        /* renamed from: d, reason: collision with root package name */
        public long f21367d = -9223372036854775807L;

        public c(o6.b bVar) {
            this.f21364a = l0.l(bVar);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ void a(ParsableByteArray parsableByteArray, int i10) {
            p.b(this, parsableByteArray, i10);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void b(Format format) {
            this.f21364a.b(format);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int c(g gVar, int i10, boolean z10) {
            return p.a(this, gVar, i10, z10);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void d(long j10, int i10, int i11, int i12, @Nullable TrackOutput.CryptoData cryptoData) {
            this.f21364a.d(j10, i10, i11, i12, cryptoData);
            l();
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int e(g gVar, int i10, boolean z10, int i11) throws IOException {
            return this.f21364a.c(gVar, i10, z10);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void f(ParsableByteArray parsableByteArray, int i10, int i11) {
            this.f21364a.a(parsableByteArray, i10);
        }

        @Nullable
        public final n5.d g() {
            this.f21366c.h();
            if (this.f21364a.S(this.f21365b, this.f21366c, 0, false) != -4) {
                return null;
            }
            this.f21366c.r();
            return this.f21366c;
        }

        public boolean h(long j10) {
            return d.this.j(j10);
        }

        public void i(f fVar) {
            long j10 = this.f21367d;
            if (j10 == -9223372036854775807L || fVar.f54513h > j10) {
                this.f21367d = fVar.f54513h;
            }
            d.this.m(fVar);
        }

        public boolean j(f fVar) {
            long j10 = this.f21367d;
            return d.this.n(j10 != -9223372036854775807L && j10 < fVar.f54512g);
        }

        public final void k(long j10, long j11) {
            d.this.f21355e.sendMessage(d.this.f21355e.obtainMessage(1, new a(j10, j11)));
        }

        public final void l() {
            while (this.f21364a.K(false)) {
                n5.d g3 = g();
                if (g3 != null) {
                    long j10 = g3.f19884f;
                    Metadata a10 = d.this.f21354d.a(g3);
                    if (a10 != null) {
                        EventMessage eventMessage = (EventMessage) a10.c(0);
                        if (d.h(eventMessage.schemeIdUri, eventMessage.value)) {
                            m(j10, eventMessage);
                        }
                    }
                }
            }
            this.f21364a.s();
        }

        public final void m(long j10, EventMessage eventMessage) {
            long f10 = d.f(eventMessage);
            if (f10 == -9223372036854775807L) {
                return;
            }
            k(j10, f10);
        }

        public void n() {
            this.f21364a.T();
        }
    }

    public d(z5.c cVar, b bVar, o6.b bVar2) {
        this.f21357g = cVar;
        this.f21353c = bVar;
        this.f21352b = bVar2;
    }

    public static long f(EventMessage eventMessage) {
        try {
            return j0.C0(j0.E(eventMessage.messageData));
        } catch (ParserException unused) {
            return -9223372036854775807L;
        }
    }

    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    @Nullable
    public final Map.Entry<Long, Long> e(long j10) {
        return this.f21356f.ceilingEntry(Long.valueOf(j10));
    }

    public final void g(long j10, long j11) {
        Long l10 = this.f21356f.get(Long.valueOf(j11));
        if (l10 == null) {
            this.f21356f.put(Long.valueOf(j11), Long.valueOf(j10));
        } else if (l10.longValue() > j10) {
            this.f21356f.put(Long.valueOf(j11), Long.valueOf(j10));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f21361k) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f21362a, aVar.f21363b);
        return true;
    }

    public final void i() {
        if (this.f21359i) {
            this.f21360j = true;
            this.f21359i = false;
            this.f21353c.b();
        }
    }

    public boolean j(long j10) {
        z5.c cVar = this.f21357g;
        boolean z10 = false;
        if (!cVar.f54892d) {
            return false;
        }
        if (this.f21360j) {
            return true;
        }
        Map.Entry<Long, Long> e2 = e(cVar.f54896h);
        if (e2 != null && e2.getValue().longValue() < j10) {
            this.f21358h = e2.getKey().longValue();
            l();
            z10 = true;
        }
        if (z10) {
            i();
        }
        return z10;
    }

    public c k() {
        return new c(this.f21352b);
    }

    public final void l() {
        this.f21353c.a(this.f21358h);
    }

    public void m(f fVar) {
        this.f21359i = true;
    }

    public boolean n(boolean z10) {
        if (!this.f21357g.f54892d) {
            return false;
        }
        if (this.f21360j) {
            return true;
        }
        if (!z10) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f21361k = true;
        this.f21355e.removeCallbacksAndMessages(null);
    }

    public final void p() {
        Iterator<Map.Entry<Long, Long>> iterator2 = this.f21356f.entrySet().iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().getKey().longValue() < this.f21357g.f54896h) {
                iterator2.remove();
            }
        }
    }

    public void q(z5.c cVar) {
        this.f21360j = false;
        this.f21358h = -9223372036854775807L;
        this.f21357g = cVar;
        p();
    }
}
