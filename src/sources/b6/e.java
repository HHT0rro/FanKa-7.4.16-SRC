package b6;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;

/* compiled from: RtpPacket.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f1313l = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final byte f1314a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1315b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1316c;

    /* renamed from: d, reason: collision with root package name */
    public final byte f1317d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1318e;

    /* renamed from: f, reason: collision with root package name */
    public final byte f1319f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1320g;

    /* renamed from: h, reason: collision with root package name */
    public final long f1321h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1322i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f1323j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f1324k;

    /* compiled from: RtpPacket.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1325a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1326b;

        /* renamed from: c, reason: collision with root package name */
        public byte f1327c;

        /* renamed from: d, reason: collision with root package name */
        public int f1328d;

        /* renamed from: e, reason: collision with root package name */
        public long f1329e;

        /* renamed from: f, reason: collision with root package name */
        public int f1330f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f1331g = e.f1313l;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f1332h = e.f1313l;

        public e i() {
            return new e(this);
        }

        public b j(byte[] bArr) {
            com.google.android.exoplayer2.util.a.e(bArr);
            this.f1331g = bArr;
            return this;
        }

        public b k(boolean z10) {
            this.f1326b = z10;
            return this;
        }

        public b l(boolean z10) {
            this.f1325a = z10;
            return this;
        }

        public b m(byte[] bArr) {
            com.google.android.exoplayer2.util.a.e(bArr);
            this.f1332h = bArr;
            return this;
        }

        public b n(byte b4) {
            this.f1327c = b4;
            return this;
        }

        public b o(int i10) {
            com.google.android.exoplayer2.util.a.a(i10 >= 0 && i10 <= 65535);
            this.f1328d = i10 & 65535;
            return this;
        }

        public b p(int i10) {
            this.f1330f = i10;
            return this;
        }

        public b q(long j10) {
            this.f1329e = j10;
            return this;
        }
    }

    @Nullable
    public static e b(ParsableByteArray parsableByteArray) {
        byte[] bArr;
        if (parsableByteArray.a() < 12) {
            return null;
        }
        int D = parsableByteArray.D();
        byte b4 = (byte) (D >> 6);
        boolean z10 = ((D >> 5) & 1) == 1;
        byte b10 = (byte) (D & 15);
        if (b4 != 2) {
            return null;
        }
        int D2 = parsableByteArray.D();
        boolean z11 = ((D2 >> 7) & 1) == 1;
        byte b11 = (byte) (D2 & 127);
        int J = parsableByteArray.J();
        long F = parsableByteArray.F();
        int n10 = parsableByteArray.n();
        if (b10 > 0) {
            bArr = new byte[b10 * 4];
            for (int i10 = 0; i10 < b10; i10++) {
                parsableByteArray.j(bArr, i10 * 4, 4);
            }
        } else {
            bArr = f1313l;
        }
        byte[] bArr2 = new byte[parsableByteArray.a()];
        parsableByteArray.j(bArr2, 0, parsableByteArray.a());
        return new b().l(z10).k(z11).n(b11).o(J).q(F).p(n10).j(bArr).m(bArr2).i();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f1319f == eVar.f1319f && this.f1320g == eVar.f1320g && this.f1318e == eVar.f1318e && this.f1321h == eVar.f1321h && this.f1322i == eVar.f1322i;
    }

    public int hashCode() {
        int i10 = (((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f1319f) * 31) + this.f1320g) * 31) + (this.f1318e ? 1 : 0)) * 31;
        long j10 = this.f1321h;
        return ((i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f1322i;
    }

    public String toString() {
        return j0.D("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.f1319f), Integer.valueOf(this.f1320g), Long.valueOf(this.f1321h), Integer.valueOf(this.f1322i), Boolean.valueOf(this.f1318e));
    }

    public e(b bVar) {
        this.f1314a = (byte) 2;
        this.f1315b = bVar.f1325a;
        this.f1316c = false;
        this.f1318e = bVar.f1326b;
        this.f1319f = bVar.f1327c;
        this.f1320g = bVar.f1328d;
        this.f1321h = bVar.f1329e;
        this.f1322i = bVar.f1330f;
        byte[] bArr = bVar.f1331g;
        this.f1323j = bArr;
        this.f1317d = (byte) (bArr.length / 4);
        this.f1324k = bVar.f1332h;
    }
}
