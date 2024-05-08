package f6;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.u;
import e6.a;
import e6.h;
import e6.i;
import f6.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okio.Utf8;

/* compiled from: Cea708Decoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends e {

    /* renamed from: g, reason: collision with root package name */
    public final ParsableByteArray f49165g = new ParsableByteArray();

    /* renamed from: h, reason: collision with root package name */
    public final u f49166h = new u();

    /* renamed from: i, reason: collision with root package name */
    public int f49167i = -1;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f49168j;

    /* renamed from: k, reason: collision with root package name */
    public final int f49169k;

    /* renamed from: l, reason: collision with root package name */
    public final b[] f49170l;

    /* renamed from: m, reason: collision with root package name */
    public b f49171m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public List<e6.a> f49172n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public List<e6.a> f49173o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public C0735c f49174p;

    /* renamed from: q, reason: collision with root package name */
    public int f49175q;

    /* compiled from: Cea708Decoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public static final Comparator<a> f49176c = new Comparator() { // from class: f6.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c4;
                c4 = c.a.c((c.a) obj, (c.a) obj2);
                return c4;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final e6.a f49177a;

        /* renamed from: b, reason: collision with root package name */
        public final int f49178b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12, boolean z10, int i13, int i14) {
            a.b n10 = new a.b().o(charSequence).p(alignment).h(f10, i10).i(i11).k(f11).l(i12).n(f12);
            if (z10) {
                n10.s(i13);
            }
            this.f49177a = n10.a();
            this.f49178b = i14;
        }

        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f49178b, aVar.f49178b);
        }
    }

    /* compiled from: Cea708Decoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {
        public static final int[] A;
        public static final int[] B;
        public static final boolean[] C;
        public static final int[] D;
        public static final int[] E;
        public static final int[] F;
        public static final int[] G;

        /* renamed from: w, reason: collision with root package name */
        public static final int f49179w = h(2, 2, 2, 0);

        /* renamed from: x, reason: collision with root package name */
        public static final int f49180x;

        /* renamed from: y, reason: collision with root package name */
        public static final int f49181y;

        /* renamed from: z, reason: collision with root package name */
        public static final int[] f49182z;

        /* renamed from: a, reason: collision with root package name */
        public final List<SpannableString> f49183a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final SpannableStringBuilder f49184b = new SpannableStringBuilder();

        /* renamed from: c, reason: collision with root package name */
        public boolean f49185c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f49186d;

        /* renamed from: e, reason: collision with root package name */
        public int f49187e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f49188f;

        /* renamed from: g, reason: collision with root package name */
        public int f49189g;

        /* renamed from: h, reason: collision with root package name */
        public int f49190h;

        /* renamed from: i, reason: collision with root package name */
        public int f49191i;

        /* renamed from: j, reason: collision with root package name */
        public int f49192j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f49193k;

        /* renamed from: l, reason: collision with root package name */
        public int f49194l;

        /* renamed from: m, reason: collision with root package name */
        public int f49195m;

        /* renamed from: n, reason: collision with root package name */
        public int f49196n;

        /* renamed from: o, reason: collision with root package name */
        public int f49197o;

        /* renamed from: p, reason: collision with root package name */
        public int f49198p;

        /* renamed from: q, reason: collision with root package name */
        public int f49199q;

        /* renamed from: r, reason: collision with root package name */
        public int f49200r;

        /* renamed from: s, reason: collision with root package name */
        public int f49201s;

        /* renamed from: t, reason: collision with root package name */
        public int f49202t;

        /* renamed from: u, reason: collision with root package name */
        public int f49203u;

        /* renamed from: v, reason: collision with root package name */
        public int f49204v;

        static {
            int h10 = h(0, 0, 0, 0);
            f49180x = h10;
            int h11 = h(0, 0, 0, 3);
            f49181y = h11;
            f49182z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{h10, h11, h10, h10, h11, h10, h10};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{h10, h10, h10, h10, h10, h11, h11};
        }

        public b() {
            l();
        }

        public static int g(int i10, int i11, int i12) {
            return h(i10, i11, i12, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.google.android.exoplayer2.util.a.c(r4, r0, r1)
                com.google.android.exoplayer2.util.a.c(r5, r0, r1)
                com.google.android.exoplayer2.util.a.c(r6, r0, r1)
                com.google.android.exoplayer2.util.a.c(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L21
                if (r7 == r1) goto L21
                r3 = 2
                if (r7 == r3) goto L1e
                r3 = 3
                if (r7 == r3) goto L1c
                goto L21
            L1c:
                r7 = 0
                goto L23
            L1e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L23
            L21:
                r7 = 255(0xff, float:3.57E-43)
            L23:
                if (r4 <= r1) goto L28
                r4 = 255(0xff, float:3.57E-43)
                goto L29
            L28:
                r4 = 0
            L29:
                if (r5 <= r1) goto L2e
                r5 = 255(0xff, float:3.57E-43)
                goto L2f
            L2e:
                r5 = 0
            L2f:
                if (r6 <= r1) goto L33
                r0 = 255(0xff, float:3.57E-43)
            L33:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: f6.c.b.h(int, int, int, int):int");
        }

        public void a(char c4) {
            if (c4 == '\n') {
                this.f49183a.add(d());
                this.f49184b.clear();
                if (this.f49198p != -1) {
                    this.f49198p = 0;
                }
                if (this.f49199q != -1) {
                    this.f49199q = 0;
                }
                if (this.f49200r != -1) {
                    this.f49200r = 0;
                }
                if (this.f49202t != -1) {
                    this.f49202t = 0;
                }
                while (true) {
                    if ((!this.f49193k || this.f49183a.size() < this.f49192j) && this.f49183a.size() < 15) {
                        return;
                    } else {
                        this.f49183a.remove(0);
                    }
                }
            } else {
                this.f49184b.append(c4);
            }
        }

        public void b() {
            int length = this.f49184b.length();
            if (length > 0) {
                this.f49184b.delete(length - 1, length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public f6.c.a c() {
            /*
                Method dump skipped, instructions count: 199
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: f6.c.b.c():f6.c$a");
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f49184b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f49198p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f49198p, length, 33);
                }
                if (this.f49199q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f49199q, length, 33);
                }
                if (this.f49200r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f49201s), this.f49200r, length, 33);
                }
                if (this.f49202t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f49203u), this.f49202t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f49183a.clear();
            this.f49184b.clear();
            this.f49198p = -1;
            this.f49199q = -1;
            this.f49200r = -1;
            this.f49202t = -1;
            this.f49204v = 0;
        }

        public void f(boolean z10, boolean z11, boolean z12, int i10, boolean z13, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f49185c = true;
            this.f49186d = z10;
            this.f49193k = z11;
            this.f49187e = i10;
            this.f49188f = z13;
            this.f49189g = i11;
            this.f49190h = i12;
            this.f49191i = i15;
            int i18 = i13 + 1;
            if (this.f49192j != i18) {
                this.f49192j = i18;
                while (true) {
                    if ((!z11 || this.f49183a.size() < this.f49192j) && this.f49183a.size() < 15) {
                        break;
                    } else {
                        this.f49183a.remove(0);
                    }
                }
            }
            if (i16 != 0 && this.f49195m != i16) {
                this.f49195m = i16;
                int i19 = i16 - 1;
                q(D[i19], f49181y, C[i19], 0, A[i19], B[i19], f49182z[i19]);
            }
            if (i17 == 0 || this.f49196n == i17) {
                return;
            }
            this.f49196n = i17;
            int i20 = i17 - 1;
            m(0, 1, 1, false, false, F[i20], E[i20]);
            n(f49179w, G[i20], f49180x);
        }

        public boolean i() {
            return this.f49185c;
        }

        public boolean j() {
            return !i() || (this.f49183a.isEmpty() && this.f49184b.length() == 0);
        }

        public boolean k() {
            return this.f49186d;
        }

        public void l() {
            e();
            this.f49185c = false;
            this.f49186d = false;
            this.f49187e = 4;
            this.f49188f = false;
            this.f49189g = 0;
            this.f49190h = 0;
            this.f49191i = 0;
            this.f49192j = 15;
            this.f49193k = true;
            this.f49194l = 0;
            this.f49195m = 0;
            this.f49196n = 0;
            int i10 = f49180x;
            this.f49197o = i10;
            this.f49201s = f49179w;
            this.f49203u = i10;
        }

        public void m(int i10, int i11, int i12, boolean z10, boolean z11, int i13, int i14) {
            if (this.f49198p != -1) {
                if (!z10) {
                    this.f49184b.setSpan(new StyleSpan(2), this.f49198p, this.f49184b.length(), 33);
                    this.f49198p = -1;
                }
            } else if (z10) {
                this.f49198p = this.f49184b.length();
            }
            if (this.f49199q == -1) {
                if (z11) {
                    this.f49199q = this.f49184b.length();
                }
            } else {
                if (z11) {
                    return;
                }
                this.f49184b.setSpan(new UnderlineSpan(), this.f49199q, this.f49184b.length(), 33);
                this.f49199q = -1;
            }
        }

        public void n(int i10, int i11, int i12) {
            if (this.f49200r != -1 && this.f49201s != i10) {
                this.f49184b.setSpan(new ForegroundColorSpan(this.f49201s), this.f49200r, this.f49184b.length(), 33);
            }
            if (i10 != f49179w) {
                this.f49200r = this.f49184b.length();
                this.f49201s = i10;
            }
            if (this.f49202t != -1 && this.f49203u != i11) {
                this.f49184b.setSpan(new BackgroundColorSpan(this.f49203u), this.f49202t, this.f49184b.length(), 33);
            }
            if (i11 != f49180x) {
                this.f49202t = this.f49184b.length();
                this.f49203u = i11;
            }
        }

        public void o(int i10, int i11) {
            if (this.f49204v != i10) {
                a('\n');
            }
            this.f49204v = i10;
        }

        public void p(boolean z10) {
            this.f49186d = z10;
        }

        public void q(int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
            this.f49197o = i10;
            this.f49194l = i15;
        }
    }

    /* compiled from: Cea708Decoder.java */
    /* renamed from: f6.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0735c {

        /* renamed from: a, reason: collision with root package name */
        public final int f49205a;

        /* renamed from: b, reason: collision with root package name */
        public final int f49206b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f49207c;

        /* renamed from: d, reason: collision with root package name */
        public int f49208d = 0;

        public C0735c(int i10, int i11) {
            this.f49205a = i10;
            this.f49206b = i11;
            this.f49207c = new byte[(i11 * 2) - 1];
        }
    }

    public c(int i10, @Nullable List<byte[]> list) {
        this.f49169k = i10 == -1 ? 1 : i10;
        this.f49168j = list != null && com.google.android.exoplayer2.util.c.h(list);
        this.f49170l = new b[8];
        for (int i11 = 0; i11 < 8; i11++) {
            this.f49170l[i11] = new b();
        }
        this.f49171m = this.f49170l[0];
    }

    public final void A() {
        int h10 = b.h(this.f49166h.h(2), this.f49166h.h(2), this.f49166h.h(2), this.f49166h.h(2));
        int h11 = b.h(this.f49166h.h(2), this.f49166h.h(2), this.f49166h.h(2), this.f49166h.h(2));
        this.f49166h.r(2);
        this.f49171m.n(h10, h11, b.g(this.f49166h.h(2), this.f49166h.h(2), this.f49166h.h(2)));
    }

    public final void B() {
        this.f49166h.r(4);
        int h10 = this.f49166h.h(4);
        this.f49166h.r(2);
        this.f49171m.o(h10, this.f49166h.h(6));
    }

    public final void C() {
        int h10 = b.h(this.f49166h.h(2), this.f49166h.h(2), this.f49166h.h(2), this.f49166h.h(2));
        int h11 = this.f49166h.h(2);
        int g3 = b.g(this.f49166h.h(2), this.f49166h.h(2), this.f49166h.h(2));
        if (this.f49166h.g()) {
            h11 |= 4;
        }
        boolean g10 = this.f49166h.g();
        int h12 = this.f49166h.h(2);
        int h13 = this.f49166h.h(2);
        int h14 = this.f49166h.h(2);
        this.f49166h.r(8);
        this.f49171m.q(h10, g3, g10, h11, h12, h13, h14);
    }

    public final void D() {
        C0735c c0735c = this.f49174p;
        int i10 = c0735c.f49208d;
        int i11 = c0735c.f49206b;
        if (i10 != (i11 * 2) - 1) {
            int i12 = c0735c.f49205a;
            StringBuilder sb2 = new StringBuilder(115);
            sb2.append("DtvCcPacket ended prematurely; size is ");
            sb2.append((i11 * 2) - 1);
            sb2.append(", but current index is ");
            sb2.append(i10);
            sb2.append(" (sequence number ");
            sb2.append(i12);
            sb2.append(");");
            m.b("Cea708Decoder", sb2.toString());
        }
        u uVar = this.f49166h;
        C0735c c0735c2 = this.f49174p;
        uVar.o(c0735c2.f49207c, c0735c2.f49208d);
        int h10 = this.f49166h.h(3);
        int h11 = this.f49166h.h(5);
        if (h10 == 7) {
            this.f49166h.r(2);
            h10 = this.f49166h.h(6);
            if (h10 < 7) {
                StringBuilder sb3 = new StringBuilder(44);
                sb3.append("Invalid extended service number: ");
                sb3.append(h10);
                m.h("Cea708Decoder", sb3.toString());
            }
        }
        if (h11 == 0) {
            if (h10 != 0) {
                StringBuilder sb4 = new StringBuilder(59);
                sb4.append("serviceNumber is non-zero (");
                sb4.append(h10);
                sb4.append(") when blockSize is 0");
                m.h("Cea708Decoder", sb4.toString());
                return;
            }
            return;
        }
        if (h10 != this.f49169k) {
            return;
        }
        boolean z10 = false;
        while (this.f49166h.b() > 0) {
            int h12 = this.f49166h.h(8);
            if (h12 == 16) {
                int h13 = this.f49166h.h(8);
                if (h13 <= 31) {
                    s(h13);
                } else {
                    if (h13 <= 127) {
                        x(h13);
                    } else if (h13 <= 159) {
                        t(h13);
                    } else if (h13 <= 255) {
                        y(h13);
                    } else {
                        StringBuilder sb5 = new StringBuilder(37);
                        sb5.append("Invalid extended command: ");
                        sb5.append(h13);
                        m.h("Cea708Decoder", sb5.toString());
                    }
                    z10 = true;
                }
            } else if (h12 <= 31) {
                q(h12);
            } else {
                if (h12 <= 127) {
                    v(h12);
                } else if (h12 <= 159) {
                    r(h12);
                } else if (h12 <= 255) {
                    w(h12);
                } else {
                    StringBuilder sb6 = new StringBuilder(33);
                    sb6.append("Invalid base command: ");
                    sb6.append(h12);
                    m.h("Cea708Decoder", sb6.toString());
                }
                z10 = true;
            }
        }
        if (z10) {
            this.f49172n = p();
        }
    }

    public final void E() {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f49170l[i10].l();
        }
    }

    @Override // f6.e, e6.f
    public /* bridge */ /* synthetic */ void b(long j10) {
        super.b(j10);
    }

    @Override // f6.e
    public e6.e e() {
        List<e6.a> list = this.f49172n;
        this.f49173o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    @Override // f6.e
    public void f(h hVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(hVar.f19882d);
        this.f49165g.N(byteBuffer.array(), byteBuffer.limit());
        while (this.f49165g.a() >= 3) {
            int D = this.f49165g.D() & 7;
            int i10 = D & 3;
            boolean z10 = (D & 4) == 4;
            byte D2 = (byte) this.f49165g.D();
            byte D3 = (byte) this.f49165g.D();
            if (i10 == 2 || i10 == 3) {
                if (z10) {
                    if (i10 == 3) {
                        o();
                        int i11 = (D2 & 192) >> 6;
                        int i12 = this.f49167i;
                        if (i12 != -1 && i11 != (i12 + 1) % 4) {
                            E();
                            int i13 = this.f49167i;
                            StringBuilder sb2 = new StringBuilder(71);
                            sb2.append("Sequence number discontinuity. previous=");
                            sb2.append(i13);
                            sb2.append(" current=");
                            sb2.append(i11);
                            m.h("Cea708Decoder", sb2.toString());
                        }
                        this.f49167i = i11;
                        int i14 = D2 & Utf8.REPLACEMENT_BYTE;
                        if (i14 == 0) {
                            i14 = 64;
                        }
                        C0735c c0735c = new C0735c(i11, i14);
                        this.f49174p = c0735c;
                        byte[] bArr = c0735c.f49207c;
                        int i15 = c0735c.f49208d;
                        c0735c.f49208d = i15 + 1;
                        bArr[i15] = D3;
                    } else {
                        com.google.android.exoplayer2.util.a.a(i10 == 2);
                        C0735c c0735c2 = this.f49174p;
                        if (c0735c2 == null) {
                            m.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0735c2.f49207c;
                            int i16 = c0735c2.f49208d;
                            int i17 = i16 + 1;
                            c0735c2.f49208d = i17;
                            bArr2[i16] = D2;
                            c0735c2.f49208d = i17 + 1;
                            bArr2[i17] = D3;
                        }
                    }
                    C0735c c0735c3 = this.f49174p;
                    if (c0735c3.f49208d == (c0735c3.f49206b * 2) - 1) {
                        o();
                    }
                }
            }
        }
    }

    @Override // f6.e, z4.c
    public void flush() {
        super.flush();
        this.f49172n = null;
        this.f49173o = null;
        this.f49175q = 0;
        this.f49171m = this.f49170l[0];
        E();
        this.f49174p = null;
    }

    @Override // f6.e
    @Nullable
    /* renamed from: g */
    public /* bridge */ /* synthetic */ h a() throws SubtitleDecoderException {
        return super.a();
    }

    @Override // f6.e
    @Nullable
    /* renamed from: h */
    public /* bridge */ /* synthetic */ i c() throws SubtitleDecoderException {
        return super.c();
    }

    @Override // f6.e
    public boolean k() {
        return this.f49172n != this.f49173o;
    }

    @Override // f6.e
    /* renamed from: l */
    public /* bridge */ /* synthetic */ void d(h hVar) throws SubtitleDecoderException {
        super.d(hVar);
    }

    public final void o() {
        if (this.f49174p == null) {
            return;
        }
        D();
        this.f49174p = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<e6.a> p() {
        a c4;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 8; i10++) {
            if (!this.f49170l[i10].j() && this.f49170l[i10].k() && (c4 = this.f49170l[i10].c()) != null) {
                arrayList.add(c4);
            }
        }
        Collections.sort(arrayList, a.f49176c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList2.add(((a) arrayList.get(i11)).f49177a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public final void q(int i10) {
        if (i10 != 0) {
            if (i10 == 3) {
                this.f49172n = p();
                return;
            }
            if (i10 != 8) {
                switch (i10) {
                    case 12:
                        E();
                        return;
                    case 13:
                        this.f49171m.a('\n');
                        return;
                    case 14:
                        return;
                    default:
                        if (i10 >= 17 && i10 <= 23) {
                            StringBuilder sb2 = new StringBuilder(55);
                            sb2.append("Currently unsupported COMMAND_EXT1 Command: ");
                            sb2.append(i10);
                            m.h("Cea708Decoder", sb2.toString());
                            this.f49166h.r(8);
                            return;
                        }
                        if (i10 >= 24 && i10 <= 31) {
                            StringBuilder sb3 = new StringBuilder(54);
                            sb3.append("Currently unsupported COMMAND_P16 Command: ");
                            sb3.append(i10);
                            m.h("Cea708Decoder", sb3.toString());
                            this.f49166h.r(16);
                            return;
                        }
                        StringBuilder sb4 = new StringBuilder(31);
                        sb4.append("Invalid C0 command: ");
                        sb4.append(i10);
                        m.h("Cea708Decoder", sb4.toString());
                        return;
                }
            }
            this.f49171m.b();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    public final void r(int i10) {
        int i11 = 1;
        switch (i10) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i12 = i10 - 128;
                if (this.f49175q != i12) {
                    this.f49175q = i12;
                    this.f49171m = this.f49170l[i12];
                    return;
                }
                return;
            case 136:
                while (i11 <= 8) {
                    if (this.f49166h.g()) {
                        this.f49170l[8 - i11].e();
                    }
                    i11++;
                }
                return;
            case 137:
                for (int i13 = 1; i13 <= 8; i13++) {
                    if (this.f49166h.g()) {
                        this.f49170l[8 - i13].p(true);
                    }
                }
                return;
            case 138:
                while (i11 <= 8) {
                    if (this.f49166h.g()) {
                        this.f49170l[8 - i11].p(false);
                    }
                    i11++;
                }
                return;
            case 139:
                for (int i14 = 1; i14 <= 8; i14++) {
                    if (this.f49166h.g()) {
                        this.f49170l[8 - i14].p(!r0.k());
                    }
                }
                return;
            case 140:
                while (i11 <= 8) {
                    if (this.f49166h.g()) {
                        this.f49170l[8 - i11].l();
                    }
                    i11++;
                }
                return;
            case 141:
                this.f49166h.r(8);
                return;
            case 142:
                return;
            case 143:
                E();
                return;
            case 144:
                if (!this.f49171m.i()) {
                    this.f49166h.r(16);
                    return;
                } else {
                    z();
                    return;
                }
            case 145:
                if (!this.f49171m.i()) {
                    this.f49166h.r(24);
                    return;
                } else {
                    A();
                    return;
                }
            case 146:
                if (!this.f49171m.i()) {
                    this.f49166h.r(16);
                    return;
                } else {
                    B();
                    return;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Invalid C1 command: ");
                sb2.append(i10);
                m.h("Cea708Decoder", sb2.toString());
                return;
            case 151:
                if (!this.f49171m.i()) {
                    this.f49166h.r(32);
                    return;
                } else {
                    C();
                    return;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i15 = i10 - 152;
                u(i15);
                if (this.f49175q != i15) {
                    this.f49175q = i15;
                    this.f49171m = this.f49170l[i15];
                    return;
                }
                return;
        }
    }

    @Override // f6.e, z4.c
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final void s(int i10) {
        if (i10 <= 7) {
            return;
        }
        if (i10 <= 15) {
            this.f49166h.r(8);
        } else if (i10 <= 23) {
            this.f49166h.r(16);
        } else if (i10 <= 31) {
            this.f49166h.r(24);
        }
    }

    public final void t(int i10) {
        if (i10 <= 135) {
            this.f49166h.r(32);
            return;
        }
        if (i10 <= 143) {
            this.f49166h.r(40);
        } else if (i10 <= 159) {
            this.f49166h.r(2);
            this.f49166h.r(this.f49166h.h(6) * 8);
        }
    }

    public final void u(int i10) {
        b bVar = this.f49170l[i10];
        this.f49166h.r(2);
        boolean g3 = this.f49166h.g();
        boolean g10 = this.f49166h.g();
        boolean g11 = this.f49166h.g();
        int h10 = this.f49166h.h(3);
        boolean g12 = this.f49166h.g();
        int h11 = this.f49166h.h(7);
        int h12 = this.f49166h.h(8);
        int h13 = this.f49166h.h(4);
        int h14 = this.f49166h.h(4);
        this.f49166h.r(2);
        int h15 = this.f49166h.h(6);
        this.f49166h.r(2);
        bVar.f(g3, g10, g11, h10, g12, h11, h12, h14, h15, h13, this.f49166h.h(3), this.f49166h.h(3));
    }

    public final void v(int i10) {
        if (i10 == 127) {
            this.f49171m.a((char) 9835);
        } else {
            this.f49171m.a((char) (i10 & 255));
        }
    }

    public final void w(int i10) {
        this.f49171m.a((char) (i10 & 255));
    }

    public final void x(int i10) {
        if (i10 == 32) {
            this.f49171m.a(' ');
            return;
        }
        if (i10 == 33) {
            this.f49171m.a((char) 160);
            return;
        }
        if (i10 == 37) {
            this.f49171m.a((char) 8230);
            return;
        }
        if (i10 == 42) {
            this.f49171m.a((char) 352);
            return;
        }
        if (i10 == 44) {
            this.f49171m.a((char) 338);
            return;
        }
        if (i10 == 63) {
            this.f49171m.a((char) 376);
            return;
        }
        if (i10 == 57) {
            this.f49171m.a((char) 8482);
            return;
        }
        if (i10 == 58) {
            this.f49171m.a((char) 353);
            return;
        }
        if (i10 == 60) {
            this.f49171m.a((char) 339);
            return;
        }
        if (i10 != 61) {
            switch (i10) {
                case 48:
                    this.f49171m.a((char) 9608);
                    return;
                case 49:
                    this.f49171m.a((char) 8216);
                    return;
                case 50:
                    this.f49171m.a((char) 8217);
                    return;
                case 51:
                    this.f49171m.a((char) 8220);
                    return;
                case 52:
                    this.f49171m.a((char) 8221);
                    return;
                case 53:
                    this.f49171m.a((char) 8226);
                    return;
                default:
                    switch (i10) {
                        case 118:
                            this.f49171m.a((char) 8539);
                            return;
                        case 119:
                            this.f49171m.a((char) 8540);
                            return;
                        case 120:
                            this.f49171m.a((char) 8541);
                            return;
                        case 121:
                            this.f49171m.a((char) 8542);
                            return;
                        case 122:
                            this.f49171m.a((char) 9474);
                            return;
                        case 123:
                            this.f49171m.a((char) 9488);
                            return;
                        case 124:
                            this.f49171m.a((char) 9492);
                            return;
                        case 125:
                            this.f49171m.a((char) 9472);
                            return;
                        case 126:
                            this.f49171m.a((char) 9496);
                            return;
                        case 127:
                            this.f49171m.a((char) 9484);
                            return;
                        default:
                            StringBuilder sb2 = new StringBuilder(33);
                            sb2.append("Invalid G2 character: ");
                            sb2.append(i10);
                            m.h("Cea708Decoder", sb2.toString());
                            return;
                    }
            }
        }
        this.f49171m.a((char) 8480);
    }

    public final void y(int i10) {
        if (i10 == 160) {
            this.f49171m.a((char) 13252);
            return;
        }
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("Invalid G3 character: ");
        sb2.append(i10);
        m.h("Cea708Decoder", sb2.toString());
        this.f49171m.a('_');
    }

    public final void z() {
        this.f49171m.m(this.f49166h.h(4), this.f49166h.h(2), this.f49166h.h(2), this.f49166h.g(), this.f49166h.g(), this.f49166h.h(3), this.f49166h.h(3));
    }
}
