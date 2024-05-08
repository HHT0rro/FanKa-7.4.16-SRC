package f6;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.android.internal.midi.MidiConstants;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import e6.a;
import e6.h;
import e6.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Cea608Decoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends e {

    /* renamed from: h, reason: collision with root package name */
    public final int f49136h;

    /* renamed from: i, reason: collision with root package name */
    public final int f49137i;

    /* renamed from: j, reason: collision with root package name */
    public final int f49138j;

    /* renamed from: k, reason: collision with root package name */
    public final long f49139k;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public List<e6.a> f49142n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public List<e6.a> f49143o;

    /* renamed from: p, reason: collision with root package name */
    public int f49144p;

    /* renamed from: q, reason: collision with root package name */
    public int f49145q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f49146r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f49147s;

    /* renamed from: t, reason: collision with root package name */
    public byte f49148t;

    /* renamed from: u, reason: collision with root package name */
    public byte f49149u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f49151w;

    /* renamed from: x, reason: collision with root package name */
    public long f49152x;

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f49133y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f49134z = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: g, reason: collision with root package name */
    public final ParsableByteArray f49135g = new ParsableByteArray();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<C0733a> f49140l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    public C0733a f49141m = new C0733a(0, 4);

    /* renamed from: v, reason: collision with root package name */
    public int f49150v = 0;

    /* compiled from: Cea608Decoder.java */
    /* renamed from: f6.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0733a {

        /* renamed from: a, reason: collision with root package name */
        public final List<C0734a> f49153a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final List<SpannableString> f49154b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final StringBuilder f49155c = new StringBuilder();

        /* renamed from: d, reason: collision with root package name */
        public int f49156d;

        /* renamed from: e, reason: collision with root package name */
        public int f49157e;

        /* renamed from: f, reason: collision with root package name */
        public int f49158f;

        /* renamed from: g, reason: collision with root package name */
        public int f49159g;

        /* renamed from: h, reason: collision with root package name */
        public int f49160h;

        /* compiled from: Cea608Decoder.java */
        /* renamed from: f6.a$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static class C0734a {

            /* renamed from: a, reason: collision with root package name */
            public final int f49161a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f49162b;

            /* renamed from: c, reason: collision with root package name */
            public int f49163c;

            public C0734a(int i10, boolean z10, int i11) {
                this.f49161a = i10;
                this.f49162b = z10;
                this.f49163c = i11;
            }
        }

        public C0733a(int i10, int i11) {
            j(i10);
            this.f49160h = i11;
        }

        public static void n(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12) {
            if (i12 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i12), i10, i11, 33);
        }

        public static void o(SpannableStringBuilder spannableStringBuilder, int i10, int i11) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i10, i11, 33);
        }

        public static void q(SpannableStringBuilder spannableStringBuilder, int i10, int i11) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i10, i11, 33);
        }

        public void e(char c4) {
            if (this.f49155c.length() < 32) {
                this.f49155c.append(c4);
            }
        }

        public void f() {
            int length = this.f49155c.length();
            if (length > 0) {
                this.f49155c.delete(length - 1, length);
                for (int size = this.f49153a.size() - 1; size >= 0; size--) {
                    C0734a c0734a = this.f49153a.get(size);
                    int i10 = c0734a.f49163c;
                    if (i10 != length) {
                        return;
                    }
                    c0734a.f49163c = i10 - 1;
                }
            }
        }

        @Nullable
        public e6.a g(int i10) {
            float f10;
            int i11 = this.f49157e + this.f49158f;
            int i12 = 32 - i11;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i13 = 0; i13 < this.f49154b.size(); i13++) {
                spannableStringBuilder.append(j0.W0(this.f49154b.get(i13), i12));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(j0.W0(h(), i12));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i12 - spannableStringBuilder.length();
            int i14 = i11 - length;
            if (i10 == Integer.MIN_VALUE) {
                if (this.f49159g != 2 || (Math.abs(i14) >= 3 && length >= 0)) {
                    i10 = (this.f49159g != 2 || i14 <= 0) ? 0 : 2;
                } else {
                    i10 = 1;
                }
            }
            if (i10 != 1) {
                if (i10 == 2) {
                    i11 = 32 - length;
                }
                f10 = ((i11 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f10 = 0.5f;
            }
            int i15 = this.f49156d;
            if (i15 > 7) {
                i15 = (i15 - 15) - 2;
            } else if (this.f49159g == 1) {
                i15 -= this.f49160h - 1;
            }
            return new a.b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i15, 1).k(f10).l(i10).a();
        }

        public final SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f49155c);
            int length = spannableStringBuilder.length();
            int i10 = 0;
            int i11 = -1;
            int i12 = -1;
            int i13 = 0;
            int i14 = -1;
            int i15 = -1;
            boolean z10 = false;
            while (i10 < this.f49153a.size()) {
                C0734a c0734a = this.f49153a.get(i10);
                boolean z11 = c0734a.f49162b;
                int i16 = c0734a.f49161a;
                if (i16 != 8) {
                    boolean z12 = i16 == 7;
                    if (i16 != 7) {
                        i15 = a.A[i16];
                    }
                    z10 = z12;
                }
                int i17 = c0734a.f49163c;
                i10++;
                if (i17 != (i10 < this.f49153a.size() ? this.f49153a.get(i10).f49163c : length)) {
                    if (i11 != -1 && !z11) {
                        q(spannableStringBuilder, i11, i17);
                        i11 = -1;
                    } else if (i11 == -1 && z11) {
                        i11 = i17;
                    }
                    if (i12 != -1 && !z10) {
                        o(spannableStringBuilder, i12, i17);
                        i12 = -1;
                    } else if (i12 == -1 && z10) {
                        i12 = i17;
                    }
                    if (i15 != i14) {
                        n(spannableStringBuilder, i13, i17, i14);
                        i14 = i15;
                        i13 = i17;
                    }
                }
            }
            if (i11 != -1 && i11 != length) {
                q(spannableStringBuilder, i11, length);
            }
            if (i12 != -1 && i12 != length) {
                o(spannableStringBuilder, i12, length);
            }
            if (i13 != length) {
                n(spannableStringBuilder, i13, length, i14);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean i() {
            return this.f49153a.isEmpty() && this.f49154b.isEmpty() && this.f49155c.length() == 0;
        }

        public void j(int i10) {
            this.f49159g = i10;
            this.f49153a.clear();
            this.f49154b.clear();
            this.f49155c.setLength(0);
            this.f49156d = 15;
            this.f49157e = 0;
            this.f49158f = 0;
        }

        public void k() {
            this.f49154b.add(h());
            this.f49155c.setLength(0);
            this.f49153a.clear();
            int min = Math.min(this.f49160h, this.f49156d);
            while (this.f49154b.size() >= min) {
                this.f49154b.remove(0);
            }
        }

        public void l(int i10) {
            this.f49159g = i10;
        }

        public void m(int i10) {
            this.f49160h = i10;
        }

        public void p(int i10, boolean z10) {
            this.f49153a.add(new C0734a(i10, z10, this.f49155c.length()));
        }
    }

    public a(String str, int i10, long j10) {
        this.f49139k = j10 > 0 ? j10 * 1000 : -9223372036854775807L;
        this.f49136h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i10 == 1) {
            this.f49138j = 0;
            this.f49137i = 0;
        } else if (i10 == 2) {
            this.f49138j = 1;
            this.f49137i = 0;
        } else if (i10 == 3) {
            this.f49138j = 0;
            this.f49137i = 1;
        } else if (i10 != 4) {
            m.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f49138j = 0;
            this.f49137i = 0;
        } else {
            this.f49138j = 1;
            this.f49137i = 1;
        }
        M(0);
        L();
        this.f49151w = true;
        this.f49152x = -9223372036854775807L;
    }

    public static boolean A(byte b4, byte b10) {
        return (b4 & MidiConstants.STATUS_TUNE_REQUEST) == 18 && (b10 & MidiConstants.STATUS_PITCH_BEND) == 32;
    }

    public static boolean B(byte b4, byte b10) {
        return (b4 & MidiConstants.STATUS_END_SYSEX) == 17 && (b10 & 240) == 32;
    }

    public static boolean C(byte b4, byte b10) {
        return (b4 & MidiConstants.STATUS_TUNE_REQUEST) == 20 && (b10 & 240) == 32;
    }

    public static boolean D(byte b4, byte b10) {
        return (b4 & 240) == 16 && (b10 & 192) == 64;
    }

    public static boolean E(byte b4) {
        return (b4 & 240) == 16;
    }

    public static boolean G(byte b4) {
        return (b4 & MidiConstants.STATUS_END_SYSEX) == 20;
    }

    public static boolean H(byte b4, byte b10) {
        return (b4 & MidiConstants.STATUS_END_SYSEX) == 17 && (b10 & 240) == 48;
    }

    public static boolean I(byte b4, byte b10) {
        return (b4 & MidiConstants.STATUS_END_SYSEX) == 23 && b10 >= 33 && b10 <= 35;
    }

    public static boolean J(byte b4) {
        return 1 <= b4 && b4 <= 15;
    }

    public static char p(byte b4) {
        return (char) B[(b4 & Byte.MAX_VALUE) - 32];
    }

    public static int q(byte b4) {
        return (b4 >> 3) & 1;
    }

    public static char s(byte b4) {
        return (char) D[b4 & 31];
    }

    public static char t(byte b4) {
        return (char) E[b4 & 31];
    }

    public static char u(byte b4, byte b10) {
        if ((b4 & 1) == 0) {
            return s(b10);
        }
        return t(b10);
    }

    public static char v(byte b4) {
        return (char) C[b4 & 15];
    }

    public static boolean z(byte b4) {
        return (b4 & MidiConstants.STATUS_PITCH_BEND) == 0;
    }

    public final boolean F(boolean z10, byte b4, byte b10) {
        if (z10 && E(b4)) {
            if (this.f49147s && this.f49148t == b4 && this.f49149u == b10) {
                this.f49147s = false;
                return true;
            }
            this.f49147s = true;
            this.f49148t = b4;
            this.f49149u = b10;
        } else {
            this.f49147s = false;
        }
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0018. Please report as an issue. */
    public final void K(byte b4, byte b10) {
        if (J(b4)) {
            this.f49151w = false;
            return;
        }
        if (G(b4)) {
            if (b10 != 32 && b10 != 47) {
                switch (b10) {
                    default:
                        switch (b10) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.f49151w = false;
                                return;
                            default:
                                return;
                        }
                    case 37:
                    case 38:
                    case 39:
                        this.f49151w = true;
                }
            }
            this.f49151w = true;
        }
    }

    public final void L() {
        this.f49141m.j(this.f49144p);
        this.f49140l.clear();
        this.f49140l.add(this.f49141m);
    }

    public final void M(int i10) {
        int i11 = this.f49144p;
        if (i11 == i10) {
            return;
        }
        this.f49144p = i10;
        if (i10 == 3) {
            for (int i12 = 0; i12 < this.f49140l.size(); i12++) {
                this.f49140l.get(i12).l(i10);
            }
            return;
        }
        L();
        if (i11 == 3 || i10 == 1 || i10 == 0) {
            this.f49142n = Collections.emptyList();
        }
    }

    public final void N(int i10) {
        this.f49145q = i10;
        this.f49141m.m(i10);
    }

    public final boolean O() {
        return (this.f49139k == -9223372036854775807L || this.f49152x == -9223372036854775807L || j() - this.f49152x < this.f49139k) ? false : true;
    }

    public final boolean P(byte b4) {
        if (z(b4)) {
            this.f49150v = q(b4);
        }
        return this.f49150v == this.f49138j;
    }

    @Override // f6.e, e6.f
    public /* bridge */ /* synthetic */ void b(long j10) {
        super.b(j10);
    }

    @Override // f6.e
    public e6.e e() {
        List<e6.a> list = this.f49142n;
        this.f49143o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0018 A[SYNTHETIC] */
    @Override // f6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(e6.h r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.a.f(e6.h):void");
    }

    @Override // f6.e, z4.c
    public void flush() {
        super.flush();
        this.f49142n = null;
        this.f49143o = null;
        M(0);
        N(4);
        L();
        this.f49146r = false;
        this.f49147s = false;
        this.f49148t = (byte) 0;
        this.f49149u = (byte) 0;
        this.f49150v = 0;
        this.f49151w = true;
        this.f49152x = -9223372036854775807L;
    }

    @Override // f6.e
    @Nullable
    /* renamed from: g */
    public /* bridge */ /* synthetic */ h a() throws SubtitleDecoderException {
        return super.a();
    }

    @Override // f6.e, z4.c
    @Nullable
    /* renamed from: h */
    public i c() throws SubtitleDecoderException {
        i i10;
        i c4 = super.c();
        if (c4 != null) {
            return c4;
        }
        if (!O() || (i10 = i()) == null) {
            return null;
        }
        this.f49142n = Collections.emptyList();
        this.f49152x = -9223372036854775807L;
        i10.q(j(), e(), Long.MAX_VALUE);
        return i10;
    }

    @Override // f6.e
    public boolean k() {
        return this.f49142n != this.f49143o;
    }

    @Override // f6.e
    /* renamed from: l */
    public /* bridge */ /* synthetic */ void d(h hVar) throws SubtitleDecoderException {
        super.d(hVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<e6.a> r() {
        int size = this.f49140l.size();
        ArrayList arrayList = new ArrayList(size);
        int i10 = 2;
        for (int i11 = 0; i11 < size; i11++) {
            e6.a g3 = this.f49140l.get(i11).g(Integer.MIN_VALUE);
            arrayList.add(g3);
            if (g3 != null) {
                i10 = Math.min(i10, g3.f48892i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            e6.a aVar = (e6.a) arrayList.get(i12);
            if (aVar != null) {
                if (aVar.f48892i != i10) {
                    aVar = (e6.a) com.google.android.exoplayer2.util.a.e(this.f49140l.get(i12).g(i10));
                }
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    @Override // f6.e, z4.c
    public void release() {
    }

    public final void w(byte b4) {
        this.f49141m.e(' ');
        this.f49141m.p((b4 >> 1) & 7, (b4 & 1) == 1);
    }

    public final void x(byte b4) {
        if (b4 == 32) {
            M(2);
            return;
        }
        if (b4 != 41) {
            switch (b4) {
                case 37:
                    M(1);
                    N(2);
                    return;
                case 38:
                    M(1);
                    N(3);
                    return;
                case 39:
                    M(1);
                    N(4);
                    return;
                default:
                    int i10 = this.f49144p;
                    if (i10 == 0) {
                        return;
                    }
                    if (b4 != 33) {
                        switch (b4) {
                            case 44:
                                this.f49142n = Collections.emptyList();
                                int i11 = this.f49144p;
                                if (i11 == 1 || i11 == 3) {
                                    L();
                                    return;
                                }
                                return;
                            case 45:
                                if (i10 != 1 || this.f49141m.i()) {
                                    return;
                                }
                                this.f49141m.k();
                                return;
                            case 46:
                                L();
                                return;
                            case 47:
                                this.f49142n = r();
                                L();
                                return;
                            default:
                                return;
                        }
                    }
                    this.f49141m.f();
                    return;
            }
        }
        M(3);
    }

    public final void y(byte b4, byte b10) {
        int i10 = f49133y[b4 & 7];
        if ((b10 & 32) != 0) {
            i10++;
        }
        if (i10 != this.f49141m.f49156d) {
            if (this.f49144p != 1 && !this.f49141m.i()) {
                C0733a c0733a = new C0733a(this.f49144p, this.f49145q);
                this.f49141m = c0733a;
                this.f49140l.add(c0733a);
            }
            this.f49141m.f49156d = i10;
        }
        boolean z10 = (b10 & 16) == 16;
        boolean z11 = (b10 & 1) == 1;
        int i11 = (b10 >> 1) & 7;
        this.f49141m.p(z10 ? 8 : i11, z11);
        if (z10) {
            this.f49141m.f49157e = f49134z[i11];
        }
    }
}
