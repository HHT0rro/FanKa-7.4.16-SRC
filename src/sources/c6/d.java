package c6;

import b6.h;
import com.android.internal.midi.MidiConstants;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import sun.security.util.DerValue;

/* compiled from: RtpH264Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements e {

    /* renamed from: c, reason: collision with root package name */
    public final h f1550c;

    /* renamed from: d, reason: collision with root package name */
    public TrackOutput f1551d;

    /* renamed from: e, reason: collision with root package name */
    public int f1552e;

    /* renamed from: h, reason: collision with root package name */
    public int f1555h;

    /* renamed from: i, reason: collision with root package name */
    public long f1556i;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1549b = new ParsableByteArray(NalUnitUtil.f22925a);

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f1548a = new ParsableByteArray();

    /* renamed from: f, reason: collision with root package name */
    public long f1553f = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public int f1554g = -1;

    public d(h hVar) {
        this.f1550c = hVar;
    }

    public static int e(int i10) {
        return i10 == 5 ? 1 : 0;
    }

    public static long i(long j10, long j11, long j12) {
        return j10 + j0.H0(j11 - j12, 1000000L, 90000L);
    }

    @Override // c6.e
    public void a(long j10, long j11) {
        this.f1553f = j10;
        this.f1555h = 0;
        this.f1556i = j11;
    }

    @Override // c6.e
    public void b(long j10, int i10) {
    }

    @Override // c6.e
    public void c(d5.e eVar, int i10) {
        TrackOutput c4 = eVar.c(i10, 2);
        this.f1551d = c4;
        ((TrackOutput) j0.j(c4)).b(this.f1550c.f1342c);
    }

    @Override // c6.e
    public void d(ParsableByteArray parsableByteArray, long j10, int i10, boolean z10) throws ParserException {
        try {
            int i11 = parsableByteArray.d()[0] & 31;
            com.google.android.exoplayer2.util.a.i(this.f1551d);
            if (i11 > 0 && i11 < 24) {
                g(parsableByteArray);
            } else if (i11 == 24) {
                h(parsableByteArray);
            } else if (i11 == 28) {
                f(parsableByteArray, i10);
            } else {
                throw ParserException.createForMalformedManifest(String.format("RTP H264 packetization mode [%d] not supported.", Integer.valueOf(i11)), null);
            }
            if (z10) {
                if (this.f1553f == -9223372036854775807L) {
                    this.f1553f = j10;
                }
                this.f1551d.d(i(this.f1556i, j10, this.f1553f), this.f1552e, this.f1555h, 0, null);
                this.f1555h = 0;
            }
            this.f1554g = i10;
        } catch (IndexOutOfBoundsException e2) {
            throw ParserException.createForMalformedManifest(null, e2);
        }
    }

    public final void f(ParsableByteArray parsableByteArray, int i10) {
        byte b4 = parsableByteArray.d()[0];
        byte b10 = parsableByteArray.d()[1];
        int i11 = (b4 & MidiConstants.STATUS_PITCH_BEND) | (b10 & 31);
        boolean z10 = (b10 & 128) > 0;
        boolean z11 = (b10 & DerValue.TAG_APPLICATION) > 0;
        if (z10) {
            this.f1555h += j();
            parsableByteArray.d()[1] = (byte) i11;
            this.f1548a.M(parsableByteArray.d());
            this.f1548a.P(1);
        } else {
            int i12 = (this.f1554g + 1) % 65535;
            if (i10 != i12) {
                m.h("RtpH264Reader", j0.D("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(i12), Integer.valueOf(i10)));
                return;
            } else {
                this.f1548a.M(parsableByteArray.d());
                this.f1548a.P(2);
            }
        }
        int a10 = this.f1548a.a();
        this.f1551d.a(this.f1548a, a10);
        this.f1555h += a10;
        if (z11) {
            this.f1552e = e(i11 & 31);
        }
    }

    public final void g(ParsableByteArray parsableByteArray) {
        int a10 = parsableByteArray.a();
        this.f1555h += j();
        this.f1551d.a(parsableByteArray, a10);
        this.f1555h += a10;
        this.f1552e = e(parsableByteArray.d()[0] & 31);
    }

    public final void h(ParsableByteArray parsableByteArray) {
        parsableByteArray.D();
        while (parsableByteArray.a() > 4) {
            int J = parsableByteArray.J();
            this.f1555h += j();
            this.f1551d.a(parsableByteArray, J);
            this.f1555h += J;
        }
        this.f1552e = 0;
    }

    public final int j() {
        this.f1549b.P(0);
        int a10 = this.f1549b.a();
        ((TrackOutput) com.google.android.exoplayer2.util.a.e(this.f1551d)).a(this.f1549b, a10);
        return a10;
    }
}
