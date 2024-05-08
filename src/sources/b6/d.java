package b6;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: RtpExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final c6.e f1300a;

    /* renamed from: d, reason: collision with root package name */
    public final int f1303d;

    /* renamed from: g, reason: collision with root package name */
    public d5.e f1306g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1307h;

    /* renamed from: k, reason: collision with root package name */
    @GuardedBy("lock")
    public boolean f1310k;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1301b = new ParsableByteArray(65507);

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f1302c = new ParsableByteArray();

    /* renamed from: e, reason: collision with root package name */
    public final Object f1304e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final g f1305f = new g();

    /* renamed from: i, reason: collision with root package name */
    public volatile long f1308i = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public volatile int f1309j = -1;

    /* renamed from: l, reason: collision with root package name */
    @GuardedBy("lock")
    public long f1311l = -9223372036854775807L;

    /* renamed from: m, reason: collision with root package name */
    @GuardedBy("lock")
    public long f1312m = -9223372036854775807L;

    public d(h hVar, int i10) {
        this.f1303d = i10;
        this.f1300a = (c6.e) com.google.android.exoplayer2.util.a.e(new c6.a().a(hVar));
    }

    public static long c(long j10) {
        return j10 - 30;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        synchronized (this.f1304e) {
            this.f1311l = j10;
            this.f1312m = j11;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f1300a.c(eVar, this.f1303d);
        eVar.l();
        eVar.r(new i.b(-9223372036854775807L));
        this.f1306g = eVar;
    }

    public boolean d() {
        return this.f1307h;
    }

    public void e() {
        synchronized (this.f1304e) {
            this.f1310k = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, d5.n nVar) throws IOException {
        com.google.android.exoplayer2.util.a.e(this.f1306g);
        int read = dVar.read(this.f1301b.d(), 0, 65507);
        if (read == -1) {
            return -1;
        }
        if (read == 0) {
            return 0;
        }
        this.f1301b.P(0);
        this.f1301b.O(read);
        e b4 = e.b(this.f1301b);
        if (b4 == null) {
            return 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long c4 = c(elapsedRealtime);
        this.f1305f.f(b4, elapsedRealtime);
        e g3 = this.f1305f.g(c4);
        if (g3 == null) {
            return 0;
        }
        if (!this.f1307h) {
            if (this.f1308i == -9223372036854775807L) {
                this.f1308i = g3.f1321h;
            }
            if (this.f1309j == -1) {
                this.f1309j = g3.f1320g;
            }
            this.f1300a.b(this.f1308i, this.f1309j);
            this.f1307h = true;
        }
        synchronized (this.f1304e) {
            if (this.f1310k) {
                if (this.f1311l != -9223372036854775807L && this.f1312m != -9223372036854775807L) {
                    this.f1305f.i();
                    this.f1300a.a(this.f1311l, this.f1312m);
                    this.f1310k = false;
                    this.f1311l = -9223372036854775807L;
                    this.f1312m = -9223372036854775807L;
                }
            }
            do {
                this.f1302c.M(g3.f1324k);
                this.f1300a.d(this.f1302c, g3.f1321h, g3.f1320g, g3.f1318e);
                g3 = this.f1305f.g(c4);
            } while (g3 != null);
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }

    public void h(int i10) {
        this.f1309j = i10;
    }

    public void i(long j10) {
        this.f1308i = j10;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
