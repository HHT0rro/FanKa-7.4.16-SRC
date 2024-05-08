package l5;

import android.net.Uri;
import android.util.Pair;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import d5.h;
import d5.i;
import d5.n;
import java.io.IOException;
import java.util.Map;
import x4.y;

/* compiled from: WavExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Extractor {

    /* renamed from: f, reason: collision with root package name */
    public static final i f51627f = new i() { // from class: l5.a
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] e2;
            e2 = b.e();
            return e2;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public d5.e f51628a;

    /* renamed from: b, reason: collision with root package name */
    public TrackOutput f51629b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0787b f51630c;

    /* renamed from: d, reason: collision with root package name */
    public int f51631d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f51632e = -1;

    /* compiled from: WavExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements InterfaceC0787b {

        /* renamed from: m, reason: collision with root package name */
        public static final int[] f51633m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: n, reason: collision with root package name */
        public static final int[] f51634n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, MetricsProto.MetricsEvent.SUW_ACCESSIBILITY_TOGGLE_SCREEN_READER, 408, 449, 494, MetricsProto.MetricsEvent.DIALOG_WIFI_SKIP, MetricsProto.MetricsEvent.DIALOG_USER_CHOOSE_TYPE, MetricsProto.MetricsEvent.ACTION_PERMISSION_REQUEST_ACCESS_FINE_LOCATION, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_MMS, MetricsProto.MetricsEvent.NOTIFICATION_ID, MetricsProto.MetricsEvent.ACTION_SETTINGS_CLEAR_APP_DATA, 963, 1060, 1166, MetricsProto.MetricsEvent.ACTION_SCREENSHOT_POWER_MENU, 1411, MetricsProto.MetricsEvent.FIELD_ACTIVITY_RECORD_IS_VISIBLE_IGNORING_KEYGUARD, MetricsProto.MetricsEvent.DIALOG_SIM_LIST, 1878, 2066, 2272, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_UNKONWN_ERROR, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a, reason: collision with root package name */
        public final d5.e f51635a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackOutput f51636b;

        /* renamed from: c, reason: collision with root package name */
        public final l5.c f51637c;

        /* renamed from: d, reason: collision with root package name */
        public final int f51638d;

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f51639e;

        /* renamed from: f, reason: collision with root package name */
        public final ParsableByteArray f51640f;

        /* renamed from: g, reason: collision with root package name */
        public final int f51641g;

        /* renamed from: h, reason: collision with root package name */
        public final Format f51642h;

        /* renamed from: i, reason: collision with root package name */
        public int f51643i;

        /* renamed from: j, reason: collision with root package name */
        public long f51644j;

        /* renamed from: k, reason: collision with root package name */
        public int f51645k;

        /* renamed from: l, reason: collision with root package name */
        public long f51646l;

        public a(d5.e eVar, TrackOutput trackOutput, l5.c cVar) throws ParserException {
            this.f51635a = eVar;
            this.f51636b = trackOutput;
            this.f51637c = cVar;
            int max = Math.max(1, cVar.f51657c / 10);
            this.f51641g = max;
            ParsableByteArray parsableByteArray = new ParsableByteArray(cVar.f51661g);
            parsableByteArray.v();
            int v2 = parsableByteArray.v();
            this.f51638d = v2;
            int i10 = cVar.f51656b;
            int i11 = (((cVar.f51659e - (i10 * 4)) * 8) / (cVar.f51660f * i10)) + 1;
            if (v2 == i11) {
                int l10 = j0.l(max, v2);
                this.f51639e = new byte[cVar.f51659e * l10];
                this.f51640f = new ParsableByteArray(l10 * h(v2, i10));
                int i12 = ((cVar.f51657c * cVar.f51659e) * 8) / v2;
                this.f51642h = new Format.b().e0("audio/raw").G(i12).Z(i12).W(h(max, i10)).H(cVar.f51656b).f0(cVar.f51657c).Y(2).E();
                return;
            }
            StringBuilder sb2 = new StringBuilder(56);
            sb2.append("Expected frames per block: ");
            sb2.append(i11);
            sb2.append("; got: ");
            sb2.append(v2);
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }

        public static int h(int i10, int i11) {
            return i10 * 2 * i11;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0036 -> B:3:0x001c). Please report as a decompilation issue!!! */
        @Override // l5.b.InterfaceC0787b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(d5.d r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f51641g
                int r1 = r6.f51645k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f51638d
                int r0 = com.google.android.exoplayer2.util.j0.l(r0, r1)
                l5.c r1 = r6.f51637c
                int r1 = r1.f51659e
                int r0 = r0 * r1
                r1 = 1
                r2 = 0
                int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r4 != 0) goto L1e
            L1c:
                r2 = 1
                goto L1f
            L1e:
                r2 = 0
            L1f:
                if (r2 != 0) goto L3f
                int r3 = r6.f51643i
                if (r3 >= r0) goto L3f
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r4 = (int) r3
                byte[] r3 = r6.f51639e
                int r5 = r6.f51643i
                int r3 = r7.read(r3, r5, r4)
                r4 = -1
                if (r3 != r4) goto L39
                goto L1c
            L39:
                int r4 = r6.f51643i
                int r4 = r4 + r3
                r6.f51643i = r4
                goto L1f
            L3f:
                int r7 = r6.f51643i
                l5.c r8 = r6.f51637c
                int r8 = r8.f51659e
                int r7 = r7 / r8
                if (r7 <= 0) goto L77
                byte[] r8 = r6.f51639e
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.f51640f
                r6.d(r8, r7, r9)
                int r8 = r6.f51643i
                l5.c r9 = r6.f51637c
                int r9 = r9.f51659e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f51643i = r8
                com.google.android.exoplayer2.util.ParsableByteArray r7 = r6.f51640f
                int r7 = r7.f()
                com.google.android.exoplayer2.extractor.TrackOutput r8 = r6.f51636b
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.f51640f
                r8.a(r9, r7)
                int r8 = r6.f51645k
                int r8 = r8 + r7
                r6.f51645k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f51641g
                if (r7 < r8) goto L77
                r6.i(r8)
            L77:
                if (r2 == 0) goto L84
                int r7 = r6.f51645k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L84
                r6.i(r7)
            L84:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: l5.b.a.a(d5.d, long):boolean");
        }

        @Override // l5.b.InterfaceC0787b
        public void b(int i10, long j10) {
            this.f51635a.r(new e(this.f51637c, this.f51638d, i10, j10));
            this.f51636b.b(this.f51642h);
        }

        @Override // l5.b.InterfaceC0787b
        public void c(long j10) {
            this.f51643i = 0;
            this.f51644j = j10;
            this.f51645k = 0;
            this.f51646l = 0L;
        }

        public final void d(byte[] bArr, int i10, ParsableByteArray parsableByteArray) {
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < this.f51637c.f51656b; i12++) {
                    e(bArr, i11, i12, parsableByteArray.d());
                }
            }
            int g3 = g(this.f51638d * i10);
            parsableByteArray.P(0);
            parsableByteArray.O(g3);
        }

        public final void e(byte[] bArr, int i10, int i11, byte[] bArr2) {
            l5.c cVar = this.f51637c;
            int i12 = cVar.f51659e;
            int i13 = cVar.f51656b;
            int i14 = (i10 * i12) + (i11 * 4);
            int i15 = (i13 * 4) + i14;
            int i16 = (i12 / i13) - 4;
            int i17 = (short) (((bArr[i14 + 1] & 255) << 8) | (bArr[i14] & 255));
            int min = Math.min(bArr[i14 + 2] & 255, 88);
            int i18 = f51634n[min];
            int i19 = ((i10 * this.f51638d * i13) + i11) * 2;
            bArr2[i19] = (byte) (i17 & 255);
            bArr2[i19 + 1] = (byte) (i17 >> 8);
            for (int i20 = 0; i20 < i16 * 2; i20++) {
                int i21 = bArr[((i20 / 8) * i13 * 4) + i15 + ((i20 / 2) % 4)] & 255;
                int i22 = i20 % 2 == 0 ? i21 & 15 : i21 >> 4;
                int i23 = ((((i22 & 7) * 2) + 1) * i18) >> 3;
                if ((i22 & 8) != 0) {
                    i23 = -i23;
                }
                i17 = j0.r(i17 + i23, -32768, 32767);
                i19 += i13 * 2;
                bArr2[i19] = (byte) (i17 & 255);
                bArr2[i19 + 1] = (byte) (i17 >> 8);
                int i24 = min + f51633m[i22];
                int[] iArr = f51634n;
                min = j0.r(i24, 0, iArr.length - 1);
                i18 = iArr[min];
            }
        }

        public final int f(int i10) {
            return i10 / (this.f51637c.f51656b * 2);
        }

        public final int g(int i10) {
            return h(i10, this.f51637c.f51656b);
        }

        public final void i(int i10) {
            long H0 = this.f51644j + j0.H0(this.f51646l, 1000000L, this.f51637c.f51657c);
            int g3 = g(i10);
            this.f51636b.d(H0, 1, g3, this.f51645k - g3, null);
            this.f51646l += i10;
            this.f51645k -= g3;
        }
    }

    /* compiled from: WavExtractor.java */
    /* renamed from: l5.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0787b {
        boolean a(d5.d dVar, long j10) throws IOException;

        void b(int i10, long j10) throws ParserException;

        void c(long j10);
    }

    /* compiled from: WavExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements InterfaceC0787b {

        /* renamed from: a, reason: collision with root package name */
        public final d5.e f51647a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackOutput f51648b;

        /* renamed from: c, reason: collision with root package name */
        public final l5.c f51649c;

        /* renamed from: d, reason: collision with root package name */
        public final Format f51650d;

        /* renamed from: e, reason: collision with root package name */
        public final int f51651e;

        /* renamed from: f, reason: collision with root package name */
        public long f51652f;

        /* renamed from: g, reason: collision with root package name */
        public int f51653g;

        /* renamed from: h, reason: collision with root package name */
        public long f51654h;

        public c(d5.e eVar, TrackOutput trackOutput, l5.c cVar, String str, int i10) throws ParserException {
            this.f51647a = eVar;
            this.f51648b = trackOutput;
            this.f51649c = cVar;
            int i11 = (cVar.f51656b * cVar.f51660f) / 8;
            int i12 = cVar.f51659e;
            if (i12 == i11) {
                int i13 = cVar.f51657c;
                int i14 = i13 * i11 * 8;
                int max = Math.max(i11, (i13 * i11) / 10);
                this.f51651e = max;
                this.f51650d = new Format.b().e0(str).G(i14).Z(i14).W(max).H(cVar.f51656b).f0(cVar.f51657c).Y(i10).E();
                return;
            }
            StringBuilder sb2 = new StringBuilder(50);
            sb2.append("Expected block size: ");
            sb2.append(i11);
            sb2.append("; got: ");
            sb2.append(i12);
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }

        @Override // l5.b.InterfaceC0787b
        public boolean a(d5.d dVar, long j10) throws IOException {
            int i10;
            int i11;
            long j11 = j10;
            while (j11 > 0 && (i10 = this.f51653g) < (i11 = this.f51651e)) {
                int c4 = this.f51648b.c(dVar, (int) Math.min(i11 - i10, j11), true);
                if (c4 == -1) {
                    j11 = 0;
                } else {
                    this.f51653g += c4;
                    j11 -= c4;
                }
            }
            int i12 = this.f51649c.f51659e;
            int i13 = this.f51653g / i12;
            if (i13 > 0) {
                long H0 = this.f51652f + j0.H0(this.f51654h, 1000000L, r1.f51657c);
                int i14 = i13 * i12;
                int i15 = this.f51653g - i14;
                this.f51648b.d(H0, 1, i14, i15, null);
                this.f51654h += i13;
                this.f51653g = i15;
            }
            return j11 <= 0;
        }

        @Override // l5.b.InterfaceC0787b
        public void b(int i10, long j10) {
            this.f51647a.r(new e(this.f51649c, 1, i10, j10));
            this.f51648b.b(this.f51650d);
        }

        @Override // l5.b.InterfaceC0787b
        public void c(long j10) {
            this.f51652f = j10;
            this.f51653g = 0;
            this.f51654h = 0L;
        }
    }

    public static /* synthetic */ Extractor[] e() {
        return new Extractor[]{new b()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        InterfaceC0787b interfaceC0787b = this.f51630c;
        if (interfaceC0787b != null) {
            interfaceC0787b.c(j11);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f51628a = eVar;
        this.f51629b = eVar.c(0, 1);
        eVar.l();
    }

    public final void d() {
        com.google.android.exoplayer2.util.a.i(this.f51629b);
        j0.j(this.f51628a);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, n nVar) throws IOException {
        d();
        if (this.f51630c == null) {
            l5.c a10 = d.a(dVar);
            if (a10 != null) {
                int i10 = a10.f51655a;
                if (i10 == 17) {
                    this.f51630c = new a(this.f51628a, this.f51629b, a10);
                } else if (i10 == 6) {
                    this.f51630c = new c(this.f51628a, this.f51629b, a10, "audio/g711-alaw", -1);
                } else if (i10 == 7) {
                    this.f51630c = new c(this.f51628a, this.f51629b, a10, "audio/g711-mlaw", -1);
                } else {
                    int a11 = y.a(i10, a10.f51660f);
                    if (a11 != 0) {
                        this.f51630c = new c(this.f51628a, this.f51629b, a10, "audio/raw", a11);
                    } else {
                        int i11 = a10.f51655a;
                        StringBuilder sb2 = new StringBuilder(40);
                        sb2.append("Unsupported WAV format type: ");
                        sb2.append(i11);
                        throw ParserException.createForUnsupportedContainerFeature(sb2.toString());
                    }
                }
            } else {
                throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav header.", null);
            }
        }
        if (this.f51631d == -1) {
            Pair<Long, Long> b4 = d.b(dVar);
            this.f51631d = ((Long) b4.first).intValue();
            long longValue = ((Long) b4.second).longValue();
            this.f51632e = longValue;
            this.f51630c.b(this.f51631d, longValue);
        } else if (dVar.getPosition() == 0) {
            dVar.r(this.f51631d);
        }
        com.google.android.exoplayer2.util.a.g(this.f51632e != -1);
        return this.f51630c.a(dVar, this.f51632e - dVar.getPosition()) ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        return d.a(dVar) != null;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
