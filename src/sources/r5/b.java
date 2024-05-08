package r5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.u;
import com.huawei.openalliance.ad.constant.bb;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import n5.d;
import n5.f;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: Id3Decoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends f {

    /* renamed from: b, reason: collision with root package name */
    public static final a f53290b = new a() { // from class: r5.a
        @Override // r5.b.a
        public final boolean a(int i10, int i11, int i12, int i13, int i14) {
            boolean z10;
            z10 = b.z(i10, i11, i12, i13, i14);
            return z10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f53291a;

    /* compiled from: Id3Decoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        boolean a(int i10, int i11, int i12, int i13, int i14);
    }

    /* compiled from: Id3Decoder.java */
    /* renamed from: r5.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0810b {

        /* renamed from: a, reason: collision with root package name */
        public final int f53292a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f53293b;

        /* renamed from: c, reason: collision with root package name */
        public final int f53294c;

        public C0810b(int i10, boolean z10, int i11) {
            this.f53292a = i10;
            this.f53293b = z10;
            this.f53294c = i11;
        }
    }

    public b() {
        this(null);
    }

    public static int A(ParsableByteArray parsableByteArray, int i10) {
        byte[] d10 = parsableByteArray.d();
        int e2 = parsableByteArray.e();
        int i11 = e2;
        while (true) {
            int i12 = i11 + 1;
            if (i12 >= e2 + i10) {
                return i10;
            }
            if ((d10[i11] & 255) == 255 && d10[i12] == 0) {
                System.arraycopy((Object) d10, i11 + 2, (Object) d10, i12, (i10 - (i11 - e2)) - 2);
                i10--;
            }
            i11 = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if ((r10 & 1) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0086, code lost:
    
        if ((r10 & 128) != 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean B(com.google.android.exoplayer2.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.e()
        L8:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Laf
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lab
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L22
            int r7 = r18.n()     // Catch: java.lang.Throwable -> Laf
            long r8 = r18.F()     // Catch: java.lang.Throwable -> Laf
            int r10 = r18.J()     // Catch: java.lang.Throwable -> Laf
            goto L2c
        L22:
            int r7 = r18.G()     // Catch: java.lang.Throwable -> Laf
            int r8 = r18.G()     // Catch: java.lang.Throwable -> Laf
            long r8 = (long) r8
            r10 = 0
        L2c:
            r11 = 0
            if (r7 != 0) goto L3a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3a
            if (r10 != 0) goto L3a
            r1.P(r2)
            return r4
        L3a:
            r7 = 4
            if (r0 != r7) goto L6b
            if (r21 != 0) goto L6b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4b
            r1.P(r2)
            return r6
        L4b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6b:
            if (r0 != r7) goto L7b
            r3 = r10 & 64
            if (r3 == 0) goto L73
            r3 = 1
            goto L74
        L73:
            r3 = 0
        L74:
            r7 = r10 & 1
            if (r7 == 0) goto L79
            goto L8b
        L79:
            r4 = 0
            goto L8b
        L7b:
            if (r0 != r3) goto L89
            r3 = r10 & 32
            if (r3 == 0) goto L83
            r3 = 1
            goto L84
        L83:
            r3 = 0
        L84:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L79
            goto L8b
        L89:
            r3 = 0
            goto L79
        L8b:
            if (r4 == 0) goto L8f
            int r3 = r3 + 4
        L8f:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L98
            r1.P(r2)
            return r6
        L98:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Laf
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La5
            r1.P(r2)
            return r6
        La5:
            int r3 = (int) r8
            r1.Q(r3)     // Catch: java.lang.Throwable -> Laf
            goto L8
        Lab:
            r1.P(r2)
            return r4
        Laf:
            r0 = move-exception
            r1.P(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.b.B(com.google.android.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    public static byte[] d(byte[] bArr, int i10, int i11) {
        if (i11 <= i10) {
            return j0.f22995f;
        }
        return Arrays.copyOfRange(bArr, i10, i11);
    }

    public static ApicFrame f(ParsableByteArray parsableByteArray, int i10, int i11) throws UnsupportedEncodingException {
        int y10;
        String str;
        int D = parsableByteArray.D();
        String v2 = v(D);
        int i12 = i10 - 1;
        byte[] bArr = new byte[i12];
        parsableByteArray.j(bArr, 0, i12);
        if (i11 == 2) {
            String valueOf = String.valueOf(com.google.common.base.a.e(new String(bArr, 0, 3, CharEncoding.ISO_8859_1)));
            str = valueOf.length() != 0 ? "image/".concat(valueOf) : new String("image/");
            if (bb.I.equals(str)) {
                str = bb.V;
            }
            y10 = 2;
        } else {
            y10 = y(bArr, 0);
            String e2 = com.google.common.base.a.e(new String(bArr, 0, y10, CharEncoding.ISO_8859_1));
            if (e2.indexOf(47) == -1) {
                if (e2.length() != 0) {
                    str = "image/".concat(e2);
                } else {
                    e2 = new String("image/");
                }
            }
            str = e2;
        }
        int i13 = bArr[y10 + 1] & 255;
        int i14 = y10 + 2;
        int x10 = x(bArr, i14, D);
        return new ApicFrame(str, new String(bArr, i14, x10 - i14, v2), i13, d(bArr, x10 + u(D), i12));
    }

    public static BinaryFrame g(ParsableByteArray parsableByteArray, int i10, String str) {
        byte[] bArr = new byte[i10];
        parsableByteArray.j(bArr, 0, i10);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame h(ParsableByteArray parsableByteArray, int i10, int i11, boolean z10, int i12, @Nullable a aVar) throws UnsupportedEncodingException {
        int e2 = parsableByteArray.e();
        int y10 = y(parsableByteArray.d(), e2);
        String str = new String(parsableByteArray.d(), e2, y10 - e2, CharEncoding.ISO_8859_1);
        parsableByteArray.P(y10 + 1);
        int n10 = parsableByteArray.n();
        int n11 = parsableByteArray.n();
        long F = parsableByteArray.F();
        long j10 = F == 4294967295L ? -1L : F;
        long F2 = parsableByteArray.F();
        long j11 = F2 == 4294967295L ? -1L : F2;
        ArrayList arrayList = new ArrayList();
        int i13 = e2 + i10;
        while (parsableByteArray.e() < i13) {
            Id3Frame k10 = k(i11, parsableByteArray, z10, i12, aVar);
            if (k10 != null) {
                arrayList.add(k10);
            }
        }
        return new ChapterFrame(str, n10, n11, j10, j11, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame i(ParsableByteArray parsableByteArray, int i10, int i11, boolean z10, int i12, @Nullable a aVar) throws UnsupportedEncodingException {
        int e2 = parsableByteArray.e();
        int y10 = y(parsableByteArray.d(), e2);
        String str = new String(parsableByteArray.d(), e2, y10 - e2, CharEncoding.ISO_8859_1);
        parsableByteArray.P(y10 + 1);
        int D = parsableByteArray.D();
        boolean z11 = (D & 2) != 0;
        boolean z12 = (D & 1) != 0;
        int D2 = parsableByteArray.D();
        String[] strArr = new String[D2];
        for (int i13 = 0; i13 < D2; i13++) {
            int e10 = parsableByteArray.e();
            int y11 = y(parsableByteArray.d(), e10);
            strArr[i13] = new String(parsableByteArray.d(), e10, y11 - e10, CharEncoding.ISO_8859_1);
            parsableByteArray.P(y11 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i14 = e2 + i10;
        while (parsableByteArray.e() < i14) {
            Id3Frame k10 = k(i11, parsableByteArray, z10, i12, aVar);
            if (k10 != null) {
                arrayList.add(k10);
            }
        }
        return new ChapterTocFrame(str, z11, z12, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    public static CommentFrame j(ParsableByteArray parsableByteArray, int i10) throws UnsupportedEncodingException {
        if (i10 < 4) {
            return null;
        }
        int D = parsableByteArray.D();
        String v2 = v(D);
        byte[] bArr = new byte[3];
        parsableByteArray.j(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i11 = i10 - 4;
        byte[] bArr2 = new byte[i11];
        parsableByteArray.j(bArr2, 0, i11);
        int x10 = x(bArr2, 0, D);
        String str2 = new String(bArr2, 0, x10, v2);
        int u10 = x10 + u(D);
        return new CommentFrame(str, str2, p(bArr2, u10, x(bArr2, u10, D), v2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0190, code lost:
    
        if (r13 == 67) goto L132;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.metadata.id3.Id3Frame k(int r19, com.google.android.exoplayer2.util.ParsableByteArray r20, boolean r21, int r22, @androidx.annotation.Nullable r5.b.a r23) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.b.k(int, com.google.android.exoplayer2.util.ParsableByteArray, boolean, int, r5.b$a):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    public static GeobFrame l(ParsableByteArray parsableByteArray, int i10) throws UnsupportedEncodingException {
        int D = parsableByteArray.D();
        String v2 = v(D);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        parsableByteArray.j(bArr, 0, i11);
        int y10 = y(bArr, 0);
        String str = new String(bArr, 0, y10, CharEncoding.ISO_8859_1);
        int i12 = y10 + 1;
        int x10 = x(bArr, i12, D);
        String p10 = p(bArr, i12, x10, v2);
        int u10 = x10 + u(D);
        int x11 = x(bArr, u10, D);
        return new GeobFrame(str, p10, p(bArr, u10, x11, v2), d(bArr, x11 + u(D), i11));
    }

    @Nullable
    public static C0810b m(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 10) {
            m.h("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int G = parsableByteArray.G();
        boolean z10 = false;
        if (G != 4801587) {
            String valueOf = String.valueOf(String.format("%06X", Integer.valueOf(G)));
            m.h("Id3Decoder", valueOf.length() != 0 ? "Unexpected first three bytes of ID3 tag header: 0x".concat(valueOf) : new String("Unexpected first three bytes of ID3 tag header: 0x"));
            return null;
        }
        int D = parsableByteArray.D();
        parsableByteArray.Q(1);
        int D2 = parsableByteArray.D();
        int C = parsableByteArray.C();
        if (D == 2) {
            if ((D2 & 64) != 0) {
                m.h("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (D == 3) {
            if ((D2 & 64) != 0) {
                int n10 = parsableByteArray.n();
                parsableByteArray.Q(n10);
                C -= n10 + 4;
            }
        } else {
            if (D != 4) {
                StringBuilder sb2 = new StringBuilder(57);
                sb2.append("Skipped ID3 tag with unsupported majorVersion=");
                sb2.append(D);
                m.h("Id3Decoder", sb2.toString());
                return null;
            }
            if ((D2 & 64) != 0) {
                int C2 = parsableByteArray.C();
                parsableByteArray.Q(C2 - 4);
                C -= C2;
            }
            if ((D2 & 16) != 0) {
                C -= 10;
            }
        }
        if (D < 4 && (D2 & 128) != 0) {
            z10 = true;
        }
        return new C0810b(D, z10, C);
    }

    public static MlltFrame n(ParsableByteArray parsableByteArray, int i10) {
        int J = parsableByteArray.J();
        int G = parsableByteArray.G();
        int G2 = parsableByteArray.G();
        int D = parsableByteArray.D();
        int D2 = parsableByteArray.D();
        u uVar = new u();
        uVar.m(parsableByteArray);
        int i11 = ((i10 - 10) * 8) / (D + D2);
        int[] iArr = new int[i11];
        int[] iArr2 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int h10 = uVar.h(D);
            int h11 = uVar.h(D2);
            iArr[i12] = h10;
            iArr2[i12] = h11;
        }
        return new MlltFrame(J, G, G2, iArr, iArr2);
    }

    public static PrivFrame o(ParsableByteArray parsableByteArray, int i10) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i10];
        parsableByteArray.j(bArr, 0, i10);
        int y10 = y(bArr, 0);
        return new PrivFrame(new String(bArr, 0, y10, CharEncoding.ISO_8859_1), d(bArr, y10 + 1, i10));
    }

    public static String p(byte[] bArr, int i10, int i11, String str) throws UnsupportedEncodingException {
        return (i11 <= i10 || i11 > bArr.length) ? "" : new String(bArr, i10, i11 - i10, str);
    }

    @Nullable
    public static TextInformationFrame q(ParsableByteArray parsableByteArray, int i10, String str) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int D = parsableByteArray.D();
        String v2 = v(D);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        parsableByteArray.j(bArr, 0, i11);
        return new TextInformationFrame(str, null, new String(bArr, 0, x(bArr, 0, D), v2));
    }

    @Nullable
    public static TextInformationFrame r(ParsableByteArray parsableByteArray, int i10) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int D = parsableByteArray.D();
        String v2 = v(D);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        parsableByteArray.j(bArr, 0, i11);
        int x10 = x(bArr, 0, D);
        String str = new String(bArr, 0, x10, v2);
        int u10 = x10 + u(D);
        return new TextInformationFrame("TXXX", str, p(bArr, u10, x(bArr, u10, D), v2));
    }

    public static UrlLinkFrame s(ParsableByteArray parsableByteArray, int i10, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i10];
        parsableByteArray.j(bArr, 0, i10);
        return new UrlLinkFrame(str, null, new String(bArr, 0, y(bArr, 0), CharEncoding.ISO_8859_1));
    }

    @Nullable
    public static UrlLinkFrame t(ParsableByteArray parsableByteArray, int i10) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int D = parsableByteArray.D();
        String v2 = v(D);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        parsableByteArray.j(bArr, 0, i11);
        int x10 = x(bArr, 0, D);
        String str = new String(bArr, 0, x10, v2);
        int u10 = x10 + u(D);
        return new UrlLinkFrame("WXXX", str, p(bArr, u10, y(bArr, u10), CharEncoding.ISO_8859_1));
    }

    public static int u(int i10) {
        return (i10 == 0 || i10 == 3) ? 1 : 2;
    }

    public static String v(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? CharEncoding.ISO_8859_1 : "UTF-8" : CharEncoding.UTF_16BE : CharEncoding.UTF_16;
    }

    public static String w(int i10, int i11, int i12, int i13, int i14) {
        return i10 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
    }

    public static int x(byte[] bArr, int i10, int i11) {
        int y10 = y(bArr, i10);
        if (i11 == 0 || i11 == 3) {
            return y10;
        }
        while (y10 < bArr.length - 1) {
            if ((y10 - i10) % 2 == 0 && bArr[y10 + 1] == 0) {
                return y10;
            }
            y10 = y(bArr, y10 + 1);
        }
        return bArr.length;
    }

    public static int y(byte[] bArr, int i10) {
        while (i10 < bArr.length) {
            if (bArr[i10] == 0) {
                return i10;
            }
            i10++;
        }
        return bArr.length;
    }

    public static /* synthetic */ boolean z(int i10, int i11, int i12, int i13, int i14) {
        return false;
    }

    @Override // n5.f
    @Nullable
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    @Nullable
    public Metadata e(byte[] bArr, int i10) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i10);
        C0810b m10 = m(parsableByteArray);
        if (m10 == null) {
            return null;
        }
        int e2 = parsableByteArray.e();
        int i11 = m10.f53292a == 2 ? 6 : 10;
        int i12 = m10.f53294c;
        if (m10.f53293b) {
            i12 = A(parsableByteArray, m10.f53294c);
        }
        parsableByteArray.O(e2 + i12);
        boolean z10 = false;
        if (!B(parsableByteArray, m10.f53292a, i11, false)) {
            if (m10.f53292a != 4 || !B(parsableByteArray, 4, i11, true)) {
                int i13 = m10.f53292a;
                StringBuilder sb2 = new StringBuilder(56);
                sb2.append("Failed to validate ID3 tag with majorVersion=");
                sb2.append(i13);
                m.h("Id3Decoder", sb2.toString());
                return null;
            }
            z10 = true;
        }
        while (parsableByteArray.a() >= i11) {
            Id3Frame k10 = k(m10.f53292a, parsableByteArray, z10, i11, this.f53291a);
            if (k10 != null) {
                arrayList.add(k10);
            }
        }
        return new Metadata(arrayList);
    }

    public b(@Nullable a aVar) {
        this.f53291a = aVar;
    }
}
