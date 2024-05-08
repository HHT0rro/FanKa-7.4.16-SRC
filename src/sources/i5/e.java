package i5;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.video.ColorInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import d5.h;
import d5.i;
import java.io.IOException;
import java.io.ObjectStreamConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.CharUtils;

/* compiled from: MatroskaExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e implements Extractor {

    /* renamed from: b0, reason: collision with root package name */
    public static final i f49732b0 = new i() { // from class: i5.d
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] A;
            A = e.A();
            return A;
        }
    };

    /* renamed from: c0, reason: collision with root package name */
    public static final byte[] f49733c0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: d0, reason: collision with root package name */
    public static final byte[] f49734d0 = j0.i0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: e0, reason: collision with root package name */
    public static final byte[] f49735e0 = {68, 105, 97, 108, 111, 103, ObjectStreamConstants.TC_ARRAY, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: f0, reason: collision with root package name */
    public static final UUID f49736f0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* renamed from: g0, reason: collision with root package name */
    public static final Map<String, Integer> f49737g0;
    public long A;
    public long B;

    @Nullable
    public n C;

    @Nullable
    public n D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public long I;
    public int J;
    public int K;
    public int[] L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public byte Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final i5.c f49738a;

    /* renamed from: a0, reason: collision with root package name */
    public d5.e f49739a0;

    /* renamed from: b, reason: collision with root package name */
    public final g f49740b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray<c> f49741c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f49742d;

    /* renamed from: e, reason: collision with root package name */
    public final ParsableByteArray f49743e;

    /* renamed from: f, reason: collision with root package name */
    public final ParsableByteArray f49744f;

    /* renamed from: g, reason: collision with root package name */
    public final ParsableByteArray f49745g;

    /* renamed from: h, reason: collision with root package name */
    public final ParsableByteArray f49746h;

    /* renamed from: i, reason: collision with root package name */
    public final ParsableByteArray f49747i;

    /* renamed from: j, reason: collision with root package name */
    public final ParsableByteArray f49748j;

    /* renamed from: k, reason: collision with root package name */
    public final ParsableByteArray f49749k;

    /* renamed from: l, reason: collision with root package name */
    public final ParsableByteArray f49750l;

    /* renamed from: m, reason: collision with root package name */
    public final ParsableByteArray f49751m;

    /* renamed from: n, reason: collision with root package name */
    public final ParsableByteArray f49752n;

    /* renamed from: o, reason: collision with root package name */
    public ByteBuffer f49753o;

    /* renamed from: p, reason: collision with root package name */
    public long f49754p;

    /* renamed from: q, reason: collision with root package name */
    public long f49755q;

    /* renamed from: r, reason: collision with root package name */
    public long f49756r;

    /* renamed from: s, reason: collision with root package name */
    public long f49757s;

    /* renamed from: t, reason: collision with root package name */
    public long f49758t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public c f49759u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f49760v;

    /* renamed from: w, reason: collision with root package name */
    public int f49761w;

    /* renamed from: x, reason: collision with root package name */
    public long f49762x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f49763y;

    /* renamed from: z, reason: collision with root package name */
    public long f49764z;

    /* compiled from: MatroskaExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements i5.b {
        public b() {
        }

        @Override // i5.b
        public void a(int i10) throws ParserException {
            e.this.o(i10);
        }

        @Override // i5.b
        public void b(int i10, double d10) throws ParserException {
            e.this.r(i10, d10);
        }

        @Override // i5.b
        public void c(int i10, int i11, d5.d dVar) throws IOException {
            e.this.l(i10, i11, dVar);
        }

        @Override // i5.b
        public void d(int i10, long j10) throws ParserException {
            e.this.x(i10, j10);
        }

        @Override // i5.b
        public void e(int i10, String str) throws ParserException {
            e.this.H(i10, str);
        }

        @Override // i5.b
        public void f(int i10, long j10, long j11) throws ParserException {
            e.this.G(i10, j10, j11);
        }

        @Override // i5.b
        public int g(int i10) {
            return e.this.u(i10);
        }

        @Override // i5.b
        public boolean h(int i10) {
            return e.this.z(i10);
        }
    }

    /* compiled from: MatroskaExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;
        public byte[] N;
        public int O;
        public int P;
        public int Q;
        public long R;
        public long S;
        public d T;
        public boolean U;
        public boolean V;
        public String W;
        public TrackOutput X;
        public int Y;

        /* renamed from: a, reason: collision with root package name */
        public String f49766a;

        /* renamed from: b, reason: collision with root package name */
        public String f49767b;

        /* renamed from: c, reason: collision with root package name */
        public int f49768c;

        /* renamed from: d, reason: collision with root package name */
        public int f49769d;

        /* renamed from: e, reason: collision with root package name */
        public int f49770e;

        /* renamed from: f, reason: collision with root package name */
        public int f49771f;

        /* renamed from: g, reason: collision with root package name */
        public int f49772g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f49773h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f49774i;

        /* renamed from: j, reason: collision with root package name */
        public TrackOutput.CryptoData f49775j;

        /* renamed from: k, reason: collision with root package name */
        public byte[] f49776k;

        /* renamed from: l, reason: collision with root package name */
        public DrmInitData f49777l;

        /* renamed from: m, reason: collision with root package name */
        public int f49778m;

        /* renamed from: n, reason: collision with root package name */
        public int f49779n;

        /* renamed from: o, reason: collision with root package name */
        public int f49780o;

        /* renamed from: p, reason: collision with root package name */
        public int f49781p;

        /* renamed from: q, reason: collision with root package name */
        public int f49782q;

        /* renamed from: r, reason: collision with root package name */
        public int f49783r;

        /* renamed from: s, reason: collision with root package name */
        public float f49784s;

        /* renamed from: t, reason: collision with root package name */
        public float f49785t;

        /* renamed from: u, reason: collision with root package name */
        public float f49786u;

        /* renamed from: v, reason: collision with root package name */
        public byte[] f49787v;

        /* renamed from: w, reason: collision with root package name */
        public int f49788w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f49789x;

        /* renamed from: y, reason: collision with root package name */
        public int f49790y;

        /* renamed from: z, reason: collision with root package name */
        public int f49791z;

        public c() {
            this.f49778m = -1;
            this.f49779n = -1;
            this.f49780o = -1;
            this.f49781p = -1;
            this.f49782q = 0;
            this.f49783r = -1;
            this.f49784s = 0.0f;
            this.f49785t = 0.0f;
            this.f49786u = 0.0f;
            this.f49787v = null;
            this.f49788w = -1;
            this.f49789x = false;
            this.f49790y = -1;
            this.f49791z = -1;
            this.A = -1;
            this.B = 1000;
            this.C = 200;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = -1.0f;
            this.O = 1;
            this.P = -1;
            this.Q = 8000;
            this.R = 0L;
            this.S = 0L;
            this.V = true;
            this.W = "eng";
        }

        public static Pair<String, List<byte[]>> j(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.Q(16);
                long t2 = parsableByteArray.t();
                if (t2 == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (t2 == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (t2 == 826496599) {
                    byte[] d10 = parsableByteArray.d();
                    for (int e2 = parsableByteArray.e() + 20; e2 < d10.length - 4; e2++) {
                        if (d10[e2] == 0 && d10[e2 + 1] == 0 && d10[e2 + 2] == 1 && d10[e2 + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(d10, e2, d10.length)));
                        }
                    }
                    throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
                }
                m.h("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        public static boolean k(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int v2 = parsableByteArray.v();
                if (v2 == 1) {
                    return true;
                }
                if (v2 != 65534) {
                    return false;
                }
                parsableByteArray.P(24);
                if (parsableByteArray.w() == e.f49736f0.getMostSignificantBits()) {
                    if (parsableByteArray.w() == e.f49736f0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }

        public static List<byte[]> l(byte[] bArr) throws ParserException {
            try {
                if (bArr[0] == 2) {
                    int i10 = 1;
                    int i11 = 0;
                    while ((bArr[i10] & 255) == 255) {
                        i11 += 255;
                        i10++;
                    }
                    int i12 = i10 + 1;
                    int i13 = i11 + (bArr[i10] & 255);
                    int i14 = 0;
                    while ((bArr[i12] & 255) == 255) {
                        i14 += 255;
                        i12++;
                    }
                    int i15 = i12 + 1;
                    int i16 = i14 + (bArr[i12] & 255);
                    if (bArr[i15] == 1) {
                        byte[] bArr2 = new byte[i13];
                        System.arraycopy((Object) bArr, i15, (Object) bArr2, 0, i13);
                        int i17 = i15 + i13;
                        if (bArr[i17] == 3) {
                            int i18 = i17 + i16;
                            if (bArr[i18] == 5) {
                                byte[] bArr3 = new byte[bArr.length - i18];
                                System.arraycopy((Object) bArr, i18, (Object) bArr3, 0, bArr.length - i18);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                        }
                        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                    }
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            }
        }

        public final void e() {
            com.google.android.exoplayer2.util.a.e(this.X);
        }

        public final byte[] f(String str) throws ParserException {
            byte[] bArr = this.f49776k;
            if (bArr != null) {
                return bArr;
            }
            String valueOf = String.valueOf(str);
            throw ParserException.createForMalformedContainer(valueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(valueOf) : new String("Missing CodecPrivate for codec "), null);
        }

        @Nullable
        public final byte[] g() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.D * 50000.0f) + 0.5f));
            order.putShort((short) ((this.E * 50000.0f) + 0.5f));
            order.putShort((short) ((this.F * 50000.0f) + 0.5f));
            order.putShort((short) ((this.G * 50000.0f) + 0.5f));
            order.putShort((short) ((this.H * 50000.0f) + 0.5f));
            order.putShort((short) ((this.I * 50000.0f) + 0.5f));
            order.putShort((short) ((this.J * 50000.0f) + 0.5f));
            order.putShort((short) ((this.K * 50000.0f) + 0.5f));
            order.putShort((short) (this.L + 0.5f));
            order.putShort((short) (this.M + 0.5f));
            order.putShort((short) this.B);
            order.putShort((short) this.C);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x01d1. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:13:0x044a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0462  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0471  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x058d  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0483  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0464  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void h(d5.e r20, int r21) throws com.google.android.exoplayer2.ParserException {
            /*
                Method dump skipped, instructions count: 1692
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: i5.e.c.h(d5.e, int):void");
        }

        public void i() {
            d dVar = this.T;
            if (dVar != null) {
                dVar.a(this);
            }
        }

        public void m() {
            d dVar = this.T;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* compiled from: MatroskaExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f49792a = new byte[10];

        /* renamed from: b, reason: collision with root package name */
        public boolean f49793b;

        /* renamed from: c, reason: collision with root package name */
        public int f49794c;

        /* renamed from: d, reason: collision with root package name */
        public long f49795d;

        /* renamed from: e, reason: collision with root package name */
        public int f49796e;

        /* renamed from: f, reason: collision with root package name */
        public int f49797f;

        /* renamed from: g, reason: collision with root package name */
        public int f49798g;

        public void a(c cVar) {
            if (this.f49794c > 0) {
                cVar.X.d(this.f49795d, this.f49796e, this.f49797f, this.f49798g, cVar.f49775j);
                this.f49794c = 0;
            }
        }

        public void b() {
            this.f49793b = false;
            this.f49794c = 0;
        }

        public void c(c cVar, long j10, int i10, int i11, int i12) {
            if (this.f49793b) {
                int i13 = this.f49794c;
                int i14 = i13 + 1;
                this.f49794c = i14;
                if (i13 == 0) {
                    this.f49795d = j10;
                    this.f49796e = i10;
                    this.f49797f = 0;
                }
                this.f49797f += i11;
                this.f49798g = i12;
                if (i14 >= 16) {
                    a(cVar);
                }
            }
        }

        public void d(d5.d dVar) throws IOException {
            if (this.f49793b) {
                return;
            }
            dVar.j(this.f49792a, 0, 10);
            dVar.m();
            if (x4.b.i(this.f49792a) == 0) {
                return;
            }
            this.f49793b = true;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        f49737g0 = Collections.unmodifiableMap(hashMap);
    }

    public e() {
        this(0);
    }

    public static /* synthetic */ Extractor[] A() {
        return new Extractor[]{new e()};
    }

    public static void F(String str, long j10, byte[] bArr) {
        byte[] s2;
        int i10;
        str.hashCode();
        if (str.equals("S_TEXT/ASS")) {
            s2 = s(j10, "%01d:%02d:%02d:%02d", 10000L);
            i10 = 21;
        } else if (str.equals("S_TEXT/UTF8")) {
            s2 = s(j10, "%02d:%02d:%02d,%03d", 1000L);
            i10 = 19;
        } else {
            throw new IllegalArgumentException();
        }
        System.arraycopy((Object) s2, 0, (Object) bArr, i10, s2.length);
    }

    public static int[] p(@Nullable int[] iArr, int i10) {
        if (iArr == null) {
            return new int[i10];
        }
        return iArr.length >= i10 ? iArr : new int[Math.max(iArr.length * 2, i10)];
    }

    public static byte[] s(long j10, String str, long j11) {
        com.google.android.exoplayer2.util.a.a(j10 != -9223372036854775807L);
        int i10 = (int) (j10 / 3600000000L);
        long j12 = j10 - ((i10 * SdkConfigData.DEFAULT_REQUEST_INTERVAL) * 1000000);
        int i11 = (int) (j12 / 60000000);
        long j13 = j12 - ((i11 * 60) * 1000000);
        int i12 = (int) (j13 / 1000000);
        return j0.i0(String.format(Locale.US, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf((int) ((j13 - (i12 * 1000000)) / j11))));
    }

    public static boolean y(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    c4 = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    c4 = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    c4 = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    c4 = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    c4 = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    c4 = '\b';
                    break;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    c4 = '\t';
                    break;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    c4 = '\n';
                    break;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    c4 = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    c4 = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    c4 = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    c4 = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    c4 = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    c4 = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    c4 = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    c4 = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    c4 = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    c4 = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    c4 = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    c4 = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c4 = 25;
                    break;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    c4 = 26;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c4 = 27;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    c4 = 28;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    c4 = 29;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    c4 = 30;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    c4 = 31;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                return true;
            default:
                return false;
        }
    }

    public final boolean B(d5.n nVar, long j10) {
        if (this.f49763y) {
            this.A = j10;
            nVar.f48642a = this.f49764z;
            this.f49763y = false;
            return true;
        }
        if (this.f49760v) {
            long j11 = this.A;
            if (j11 != -1) {
                nVar.f48642a = j11;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    public final void C(d5.d dVar, int i10) throws IOException {
        if (this.f49745g.f() >= i10) {
            return;
        }
        if (this.f49745g.b() < i10) {
            ParsableByteArray parsableByteArray = this.f49745g;
            parsableByteArray.c(Math.max(parsableByteArray.b() * 2, i10));
        }
        dVar.readFully(this.f49745g.d(), this.f49745g.f(), i10 - this.f49745g.f());
        this.f49745g.O(i10);
    }

    public final void D() {
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = 0;
        this.Y = (byte) 0;
        this.Z = false;
        this.f49748j.L(0);
    }

    public final long E(long j10) throws ParserException {
        long j11 = this.f49756r;
        if (j11 != -9223372036854775807L) {
            return j0.H0(j10, j11, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @CallSuper
    public void G(int i10, long j10, long j11) throws ParserException {
        k();
        if (i10 == 160) {
            this.Q = false;
            return;
        }
        if (i10 == 174) {
            this.f49759u = new c();
            return;
        }
        if (i10 == 187) {
            this.E = false;
            return;
        }
        if (i10 == 19899) {
            this.f49761w = -1;
            this.f49762x = -1L;
            return;
        }
        if (i10 == 20533) {
            t(i10).f49773h = true;
            return;
        }
        if (i10 == 21968) {
            t(i10).f49789x = true;
            return;
        }
        if (i10 == 408125543) {
            long j12 = this.f49755q;
            if (j12 != -1 && j12 != j10) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.f49755q = j10;
            this.f49754p = j11;
            return;
        }
        if (i10 != 475249515) {
            if (i10 == 524531317 && !this.f49760v) {
                if (this.f49742d && this.f49764z != -1) {
                    this.f49763y = true;
                    return;
                } else {
                    this.f49739a0.r(new i.b(this.f49758t));
                    this.f49760v = true;
                    return;
                }
            }
            return;
        }
        this.C = new n();
        this.D = new n();
    }

    @CallSuper
    public void H(int i10, String str) throws ParserException {
        if (i10 == 134) {
            t(i10).f49767b = str;
            return;
        }
        if (i10 != 17026) {
            if (i10 == 21358) {
                t(i10).f49766a = str;
                return;
            } else {
                if (i10 != 2274716) {
                    return;
                }
                t(i10).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22);
        sb2.append("DocType ");
        sb2.append(str);
        sb2.append(" not supported");
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    public final int I(d5.d dVar, c cVar, int i10) throws IOException {
        int i11;
        if ("S_TEXT/UTF8".equals(cVar.f49767b)) {
            J(dVar, f49733c0, i10);
            return q();
        }
        if ("S_TEXT/ASS".equals(cVar.f49767b)) {
            J(dVar, f49735e0, i10);
            return q();
        }
        TrackOutput trackOutput = cVar.X;
        if (!this.U) {
            if (cVar.f49773h) {
                this.O &= -1073741825;
                if (!this.V) {
                    dVar.readFully(this.f49745g.d(), 0, 1);
                    this.R++;
                    if ((this.f49745g.d()[0] & 128) != 128) {
                        this.Y = this.f49745g.d()[0];
                        this.V = true;
                    } else {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                }
                byte b4 = this.Y;
                if ((b4 & 1) == 1) {
                    boolean z10 = (b4 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.Z) {
                        dVar.readFully(this.f49750l.d(), 0, 8);
                        this.R += 8;
                        this.Z = true;
                        this.f49745g.d()[0] = (byte) ((z10 ? 128 : 0) | 8);
                        this.f49745g.P(0);
                        trackOutput.f(this.f49745g, 1, 1);
                        this.S++;
                        this.f49750l.P(0);
                        trackOutput.f(this.f49750l, 8, 1);
                        this.S += 8;
                    }
                    if (z10) {
                        if (!this.W) {
                            dVar.readFully(this.f49745g.d(), 0, 1);
                            this.R++;
                            this.f49745g.P(0);
                            this.X = this.f49745g.D();
                            this.W = true;
                        }
                        int i12 = this.X * 4;
                        this.f49745g.L(i12);
                        dVar.readFully(this.f49745g.d(), 0, i12);
                        this.R += i12;
                        short s2 = (short) ((this.X / 2) + 1);
                        int i13 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.f49753o;
                        if (byteBuffer == null || byteBuffer.capacity() < i13) {
                            this.f49753o = ByteBuffer.allocate(i13);
                        }
                        this.f49753o.position(0);
                        this.f49753o.putShort(s2);
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            i11 = this.X;
                            if (i14 >= i11) {
                                break;
                            }
                            int H = this.f49745g.H();
                            if (i14 % 2 == 0) {
                                this.f49753o.putShort((short) (H - i15));
                            } else {
                                this.f49753o.putInt(H - i15);
                            }
                            i14++;
                            i15 = H;
                        }
                        int i16 = (i10 - this.R) - i15;
                        if (i11 % 2 == 1) {
                            this.f49753o.putInt(i16);
                        } else {
                            this.f49753o.putShort((short) i16);
                            this.f49753o.putInt(0);
                        }
                        this.f49751m.N(this.f49753o.array(), i13);
                        trackOutput.f(this.f49751m, i13, 1);
                        this.S += i13;
                    }
                }
            } else {
                byte[] bArr = cVar.f49774i;
                if (bArr != null) {
                    this.f49748j.N(bArr, bArr.length);
                }
            }
            if (cVar.f49771f > 0) {
                this.O |= 268435456;
                this.f49752n.L(0);
                this.f49745g.L(4);
                this.f49745g.d()[0] = (byte) ((i10 >> 24) & 255);
                this.f49745g.d()[1] = (byte) ((i10 >> 16) & 255);
                this.f49745g.d()[2] = (byte) ((i10 >> 8) & 255);
                this.f49745g.d()[3] = (byte) (i10 & 255);
                trackOutput.f(this.f49745g, 4, 2);
                this.S += 4;
            }
            this.U = true;
        }
        int f10 = i10 + this.f49748j.f();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f49767b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f49767b)) {
            if (cVar.T != null) {
                com.google.android.exoplayer2.util.a.g(this.f49748j.f() == 0);
                cVar.T.d(dVar);
            }
            while (true) {
                int i17 = this.R;
                if (i17 >= f10) {
                    break;
                }
                int K = K(dVar, trackOutput, f10 - i17);
                this.R += K;
                this.S += K;
            }
        } else {
            byte[] d10 = this.f49744f.d();
            d10[0] = 0;
            d10[1] = 0;
            d10[2] = 0;
            int i18 = cVar.Y;
            int i19 = 4 - i18;
            while (this.R < f10) {
                int i20 = this.T;
                if (i20 == 0) {
                    L(dVar, d10, i19, i18);
                    this.R += i18;
                    this.f49744f.P(0);
                    this.T = this.f49744f.H();
                    this.f49743e.P(0);
                    trackOutput.a(this.f49743e, 4);
                    this.S += 4;
                } else {
                    int K2 = K(dVar, trackOutput, i20);
                    this.R += K2;
                    this.S += K2;
                    this.T -= K2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f49767b)) {
            this.f49746h.P(0);
            trackOutput.a(this.f49746h, 4);
            this.S += 4;
        }
        return q();
    }

    public final void J(d5.d dVar, byte[] bArr, int i10) throws IOException {
        int length = bArr.length + i10;
        if (this.f49749k.b() < length) {
            this.f49749k.M(Arrays.copyOf(bArr, length + i10));
        } else {
            System.arraycopy((Object) bArr, 0, (Object) this.f49749k.d(), 0, bArr.length);
        }
        dVar.readFully(this.f49749k.d(), bArr.length, i10);
        this.f49749k.P(0);
        this.f49749k.O(length);
    }

    public final int K(d5.d dVar, TrackOutput trackOutput, int i10) throws IOException {
        int a10 = this.f49748j.a();
        if (a10 > 0) {
            int min = Math.min(i10, a10);
            trackOutput.a(this.f49748j, min);
            return min;
        }
        return trackOutput.c(dVar, i10, false);
    }

    public final void L(d5.d dVar, byte[] bArr, int i10, int i11) throws IOException {
        int min = Math.min(i11, this.f49748j.a());
        dVar.readFully(bArr, i10 + min, i11 - min);
        if (min > 0) {
            this.f49748j.j(bArr, i10, min);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    @CallSuper
    public void a(long j10, long j11) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.f49738a.reset();
        this.f49740b.e();
        D();
        for (int i10 = 0; i10 < this.f49741c.size(); i10++) {
            this.f49741c.valueAt(i10).m();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void b(d5.e eVar) {
        this.f49739a0 = eVar;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final int f(d5.d dVar, d5.n nVar) throws IOException {
        this.F = false;
        boolean z10 = true;
        while (z10 && !this.F) {
            z10 = this.f49738a.a(dVar);
            if (z10 && B(nVar, dVar.getPosition())) {
                return 1;
            }
        }
        if (z10) {
            return 0;
        }
        for (int i10 = 0; i10 < this.f49741c.size(); i10++) {
            c valueAt = this.f49741c.valueAt(i10);
            valueAt.e();
            valueAt.i();
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final boolean g(d5.d dVar) throws IOException {
        return new f().b(dVar);
    }

    public final void i(int i10) throws ParserException {
        if (this.C == null || this.D == null) {
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Element ");
            sb2.append(i10);
            sb2.append(" must be in a Cues");
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }
    }

    public final void j(int i10) throws ParserException {
        if (this.f49759u != null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("Element ");
        sb2.append(i10);
        sb2.append(" must be in a TrackEntry");
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }

    public final void k() {
        com.google.android.exoplayer2.util.a.i(this.f49739a0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0243, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
     */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l(int r22, int r23, d5.d r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 769
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.e.l(int, int, d5.d):void");
    }

    public final com.google.android.exoplayer2.extractor.i m(@Nullable n nVar, @Nullable n nVar2) {
        int i10;
        if (this.f49755q != -1 && this.f49758t != -9223372036854775807L && nVar != null && nVar.c() != 0 && nVar2 != null && nVar2.c() == nVar.c()) {
            int c4 = nVar.c();
            int[] iArr = new int[c4];
            long[] jArr = new long[c4];
            long[] jArr2 = new long[c4];
            long[] jArr3 = new long[c4];
            int i11 = 0;
            for (int i12 = 0; i12 < c4; i12++) {
                jArr3[i12] = nVar.b(i12);
                jArr[i12] = this.f49755q + nVar2.b(i12);
            }
            while (true) {
                i10 = c4 - 1;
                if (i11 >= i10) {
                    break;
                }
                int i13 = i11 + 1;
                iArr[i11] = (int) (jArr[i13] - jArr[i11]);
                jArr2[i11] = jArr3[i13] - jArr3[i11];
                i11 = i13;
            }
            iArr[i10] = (int) ((this.f49755q + this.f49754p) - jArr[i10]);
            jArr2[i10] = this.f49758t - jArr3[i10];
            long j10 = jArr2[i10];
            if (j10 <= 0) {
                StringBuilder sb2 = new StringBuilder(72);
                sb2.append("Discarding last cue point with unexpected duration: ");
                sb2.append(j10);
                m.h("MatroskaExtractor", sb2.toString());
                iArr = Arrays.copyOf(iArr, i10);
                jArr = Arrays.copyOf(jArr, i10);
                jArr2 = Arrays.copyOf(jArr2, i10);
                jArr3 = Arrays.copyOf(jArr3, i10);
            }
            return new com.google.android.exoplayer2.extractor.b(iArr, jArr, jArr2, jArr3);
        }
        return new i.b(this.f49758t);
    }

    public final void n(c cVar, long j10, int i10, int i11, int i12) {
        d dVar = cVar.T;
        if (dVar != null) {
            dVar.c(cVar, j10, i10, i11, i12);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f49767b) || "S_TEXT/ASS".equals(cVar.f49767b)) {
                if (this.K > 1) {
                    m.h("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j11 = this.I;
                    if (j11 == -9223372036854775807L) {
                        m.h("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        F(cVar.f49767b, j11, this.f49749k.d());
                        int e2 = this.f49749k.e();
                        while (true) {
                            if (e2 >= this.f49749k.f()) {
                                break;
                            }
                            if (this.f49749k.d()[e2] == 0) {
                                this.f49749k.O(e2);
                                break;
                            }
                            e2++;
                        }
                        TrackOutput trackOutput = cVar.X;
                        ParsableByteArray parsableByteArray = this.f49749k;
                        trackOutput.a(parsableByteArray, parsableByteArray.f());
                        i11 += this.f49749k.f();
                    }
                }
            }
            if ((268435456 & i10) != 0) {
                if (this.K > 1) {
                    i10 &= -268435457;
                } else {
                    int f10 = this.f49752n.f();
                    cVar.X.f(this.f49752n, f10, 2);
                    i11 += f10;
                }
            }
            cVar.X.d(j10, i10, i11, i12, cVar.f49775j);
        }
        this.F = true;
    }

    @CallSuper
    public void o(int i10) throws ParserException {
        k();
        if (i10 == 160) {
            if (this.G != 2) {
                return;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.K; i12++) {
                i11 += this.L[i12];
            }
            c cVar = this.f49741c.get(this.M);
            cVar.e();
            for (int i13 = 0; i13 < this.K; i13++) {
                long j10 = ((cVar.f49770e * i13) / 1000) + this.H;
                int i14 = this.O;
                if (i13 == 0 && !this.Q) {
                    i14 |= 1;
                }
                int i15 = this.L[i13];
                i11 -= i15;
                n(cVar, j10, i14, i15, i11);
            }
            this.G = 0;
            return;
        }
        if (i10 == 174) {
            c cVar2 = (c) com.google.android.exoplayer2.util.a.i(this.f49759u);
            String str = cVar2.f49767b;
            if (str != null) {
                if (y(str)) {
                    cVar2.h(this.f49739a0, cVar2.f49768c);
                    this.f49741c.put(cVar2.f49768c, cVar2);
                }
                this.f49759u = null;
                return;
            }
            throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
        }
        if (i10 == 19899) {
            int i16 = this.f49761w;
            if (i16 != -1) {
                long j11 = this.f49762x;
                if (j11 != -1) {
                    if (i16 == 475249515) {
                        this.f49764z = j11;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i10 == 25152) {
            j(i10);
            c cVar3 = this.f49759u;
            if (cVar3.f49773h) {
                if (cVar3.f49775j != null) {
                    cVar3.f49777l = new DrmInitData(new DrmInitData.SchemeData(com.google.android.exoplayer2.h.f20704a, "video/webm", this.f49759u.f49775j.encryptionKey));
                    return;
                }
                throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
            }
            return;
        }
        if (i10 == 28032) {
            j(i10);
            c cVar4 = this.f49759u;
            if (cVar4.f49773h && cVar4.f49774i != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i10 == 357149030) {
            if (this.f49756r == -9223372036854775807L) {
                this.f49756r = 1000000L;
            }
            long j12 = this.f49757s;
            if (j12 != -9223372036854775807L) {
                this.f49758t = E(j12);
                return;
            }
            return;
        }
        if (i10 == 374648427) {
            if (this.f49741c.size() != 0) {
                this.f49739a0.l();
                return;
            }
            throw ParserException.createForMalformedContainer("No valid tracks were found", null);
        }
        if (i10 != 475249515) {
            return;
        }
        if (!this.f49760v) {
            this.f49739a0.r(m(this.C, this.D));
            this.f49760v = true;
        }
        this.C = null;
        this.D = null;
    }

    public final int q() {
        int i10 = this.S;
        D();
        return i10;
    }

    @CallSuper
    public void r(int i10, double d10) throws ParserException {
        if (i10 == 181) {
            t(i10).Q = (int) d10;
            return;
        }
        if (i10 != 17545) {
            switch (i10) {
                case 21969:
                    t(i10).D = (float) d10;
                    return;
                case 21970:
                    t(i10).E = (float) d10;
                    return;
                case 21971:
                    t(i10).F = (float) d10;
                    return;
                case 21972:
                    t(i10).G = (float) d10;
                    return;
                case 21973:
                    t(i10).H = (float) d10;
                    return;
                case 21974:
                    t(i10).I = (float) d10;
                    return;
                case 21975:
                    t(i10).J = (float) d10;
                    return;
                case 21976:
                    t(i10).K = (float) d10;
                    return;
                case 21977:
                    t(i10).L = (float) d10;
                    return;
                case 21978:
                    t(i10).M = (float) d10;
                    return;
                default:
                    switch (i10) {
                        case 30323:
                            t(i10).f49784s = (float) d10;
                            return;
                        case 30324:
                            t(i10).f49785t = (float) d10;
                            return;
                        case 30325:
                            t(i10).f49786u = (float) d10;
                            return;
                        default:
                            return;
                    }
            }
        }
        this.f49757s = (long) d10;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void release() {
    }

    public final c t(int i10) throws ParserException {
        j(i10);
        return this.f49759u;
    }

    @CallSuper
    public int u(int i10) {
        switch (i10) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public void v(c cVar, d5.d dVar, int i10) throws IOException {
        if (cVar.f49772g != 1685485123 && cVar.f49772g != 1685480259) {
            dVar.r(i10);
            return;
        }
        byte[] bArr = new byte[i10];
        cVar.N = bArr;
        dVar.readFully(bArr, 0, i10);
    }

    public void w(c cVar, int i10, d5.d dVar, int i11) throws IOException {
        if (i10 == 4 && "V_VP9".equals(cVar.f49767b)) {
            this.f49752n.L(i11);
            dVar.readFully(this.f49752n.d(), 0, i11);
        } else {
            dVar.r(i11);
        }
    }

    @CallSuper
    public void x(int i10, long j10) throws ParserException {
        if (i10 == 20529) {
            if (j10 == 0) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingOrder ");
            sb2.append(j10);
            sb2.append(" not supported");
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }
        if (i10 == 20530) {
            if (j10 == 1) {
                return;
            }
            StringBuilder sb3 = new StringBuilder(55);
            sb3.append("ContentEncodingScope ");
            sb3.append(j10);
            sb3.append(" not supported");
            throw ParserException.createForMalformedContainer(sb3.toString(), null);
        }
        switch (i10) {
            case 131:
                t(i10).f49769d = (int) j10;
                return;
            case 136:
                t(i10).V = j10 == 1;
                return;
            case 155:
                this.I = E(j10);
                return;
            case 159:
                t(i10).O = (int) j10;
                return;
            case 176:
                t(i10).f49778m = (int) j10;
                return;
            case 179:
                i(i10);
                this.C.a(E(j10));
                return;
            case 186:
                t(i10).f49779n = (int) j10;
                return;
            case 215:
                t(i10).f49768c = (int) j10;
                return;
            case 231:
                this.B = E(j10);
                return;
            case 238:
                this.P = (int) j10;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                i(i10);
                this.D.a(j10);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                t(i10).f49772g = (int) j10;
                return;
            case 16980:
                if (j10 == 3) {
                    return;
                }
                StringBuilder sb4 = new StringBuilder(50);
                sb4.append("ContentCompAlgo ");
                sb4.append(j10);
                sb4.append(" not supported");
                throw ParserException.createForMalformedContainer(sb4.toString(), null);
            case 17029:
                if (j10 < 1 || j10 > 2) {
                    StringBuilder sb5 = new StringBuilder(53);
                    sb5.append("DocTypeReadVersion ");
                    sb5.append(j10);
                    sb5.append(" not supported");
                    throw ParserException.createForMalformedContainer(sb5.toString(), null);
                }
                return;
            case 17143:
                if (j10 == 1) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(50);
                sb6.append("EBMLReadVersion ");
                sb6.append(j10);
                sb6.append(" not supported");
                throw ParserException.createForMalformedContainer(sb6.toString(), null);
            case 18401:
                if (j10 == 5) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(49);
                sb7.append("ContentEncAlgo ");
                sb7.append(j10);
                sb7.append(" not supported");
                throw ParserException.createForMalformedContainer(sb7.toString(), null);
            case 18408:
                if (j10 == 1) {
                    return;
                }
                StringBuilder sb8 = new StringBuilder(56);
                sb8.append("AESSettingsCipherMode ");
                sb8.append(j10);
                sb8.append(" not supported");
                throw ParserException.createForMalformedContainer(sb8.toString(), null);
            case 21420:
                this.f49762x = j10 + this.f49755q;
                return;
            case 21432:
                int i11 = (int) j10;
                j(i10);
                if (i11 == 0) {
                    this.f49759u.f49788w = 0;
                    return;
                }
                if (i11 == 1) {
                    this.f49759u.f49788w = 2;
                    return;
                } else if (i11 == 3) {
                    this.f49759u.f49788w = 1;
                    return;
                } else {
                    if (i11 != 15) {
                        return;
                    }
                    this.f49759u.f49788w = 3;
                    return;
                }
            case 21680:
                t(i10).f49780o = (int) j10;
                return;
            case 21682:
                t(i10).f49782q = (int) j10;
                return;
            case 21690:
                t(i10).f49781p = (int) j10;
                return;
            case 21930:
                t(i10).U = j10 == 1;
                return;
            case 21998:
                t(i10).f49771f = (int) j10;
                return;
            case 22186:
                t(i10).R = j10;
                return;
            case 22203:
                t(i10).S = j10;
                return;
            case 25188:
                t(i10).P = (int) j10;
                return;
            case 30321:
                j(i10);
                int i12 = (int) j10;
                if (i12 == 0) {
                    this.f49759u.f49783r = 0;
                    return;
                }
                if (i12 == 1) {
                    this.f49759u.f49783r = 1;
                    return;
                } else if (i12 == 2) {
                    this.f49759u.f49783r = 2;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.f49759u.f49783r = 3;
                    return;
                }
            case 2352003:
                t(i10).f49770e = (int) j10;
                return;
            case 2807729:
                this.f49756r = j10;
                return;
            default:
                switch (i10) {
                    case 21945:
                        j(i10);
                        int i13 = (int) j10;
                        if (i13 == 1) {
                            this.f49759u.A = 2;
                            return;
                        } else {
                            if (i13 != 2) {
                                return;
                            }
                            this.f49759u.A = 1;
                            return;
                        }
                    case 21946:
                        j(i10);
                        int b4 = ColorInfo.b((int) j10);
                        if (b4 != -1) {
                            this.f49759u.f49791z = b4;
                            return;
                        }
                        return;
                    case 21947:
                        j(i10);
                        this.f49759u.f49789x = true;
                        int a10 = ColorInfo.a((int) j10);
                        if (a10 != -1) {
                            this.f49759u.f49790y = a10;
                            return;
                        }
                        return;
                    case 21948:
                        t(i10).B = (int) j10;
                        return;
                    case 21949:
                        t(i10).C = (int) j10;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public boolean z(int i10) {
        return i10 == 357149030 || i10 == 524531317 || i10 == 475249515 || i10 == 374648427;
    }

    public e(int i10) {
        this(new i5.a(), i10);
    }

    public e(i5.c cVar, int i10) {
        this.f49755q = -1L;
        this.f49756r = -9223372036854775807L;
        this.f49757s = -9223372036854775807L;
        this.f49758t = -9223372036854775807L;
        this.f49764z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.f49738a = cVar;
        cVar.b(new b());
        this.f49742d = (i10 & 1) == 0;
        this.f49740b = new g();
        this.f49741c = new SparseArray<>();
        this.f49745g = new ParsableByteArray(4);
        this.f49746h = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f49747i = new ParsableByteArray(4);
        this.f49743e = new ParsableByteArray(NalUnitUtil.f22925a);
        this.f49744f = new ParsableByteArray(4);
        this.f49748j = new ParsableByteArray();
        this.f49749k = new ParsableByteArray();
        this.f49750l = new ParsableByteArray(8);
        this.f49751m = new ParsableByteArray();
        this.f49752n = new ParsableByteArray();
        this.L = new int[1];
    }
}
