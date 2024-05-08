package g6;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import e6.a;
import e6.c;
import e6.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* compiled from: PgsDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends c {

    /* renamed from: o, reason: collision with root package name */
    public final ParsableByteArray f49389o;

    /* renamed from: p, reason: collision with root package name */
    public final ParsableByteArray f49390p;

    /* renamed from: q, reason: collision with root package name */
    public final C0740a f49391q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public Inflater f49392r;

    /* compiled from: PgsDecoder.java */
    /* renamed from: g6.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0740a {

        /* renamed from: a, reason: collision with root package name */
        public final ParsableByteArray f49393a = new ParsableByteArray();

        /* renamed from: b, reason: collision with root package name */
        public final int[] f49394b = new int[256];

        /* renamed from: c, reason: collision with root package name */
        public boolean f49395c;

        /* renamed from: d, reason: collision with root package name */
        public int f49396d;

        /* renamed from: e, reason: collision with root package name */
        public int f49397e;

        /* renamed from: f, reason: collision with root package name */
        public int f49398f;

        /* renamed from: g, reason: collision with root package name */
        public int f49399g;

        /* renamed from: h, reason: collision with root package name */
        public int f49400h;

        /* renamed from: i, reason: collision with root package name */
        public int f49401i;

        @Nullable
        public e6.a d() {
            int i10;
            if (this.f49396d == 0 || this.f49397e == 0 || this.f49400h == 0 || this.f49401i == 0 || this.f49393a.f() == 0 || this.f49393a.e() != this.f49393a.f() || !this.f49395c) {
                return null;
            }
            this.f49393a.P(0);
            int i11 = this.f49400h * this.f49401i;
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int D = this.f49393a.D();
                if (D != 0) {
                    i10 = i12 + 1;
                    iArr[i12] = this.f49394b[D];
                } else {
                    int D2 = this.f49393a.D();
                    if (D2 != 0) {
                        i10 = ((D2 & 64) == 0 ? D2 & 63 : ((D2 & 63) << 8) | this.f49393a.D()) + i12;
                        Arrays.fill(iArr, i12, i10, (D2 & 128) == 0 ? 0 : this.f49394b[this.f49393a.D()]);
                    }
                }
                i12 = i10;
            }
            return new a.b().f(Bitmap.createBitmap(iArr, this.f49400h, this.f49401i, Bitmap.Config.ARGB_8888)).k(this.f49398f / this.f49396d).l(0).h(this.f49399g / this.f49397e, 0).i(0).n(this.f49400h / this.f49396d).g(this.f49401i / this.f49397e).a();
        }

        public final void e(ParsableByteArray parsableByteArray, int i10) {
            int G;
            if (i10 < 4) {
                return;
            }
            parsableByteArray.Q(3);
            int i11 = i10 - 4;
            if ((parsableByteArray.D() & 128) != 0) {
                if (i11 < 7 || (G = parsableByteArray.G()) < 4) {
                    return;
                }
                this.f49400h = parsableByteArray.J();
                this.f49401i = parsableByteArray.J();
                this.f49393a.L(G - 4);
                i11 -= 7;
            }
            int e2 = this.f49393a.e();
            int f10 = this.f49393a.f();
            if (e2 >= f10 || i11 <= 0) {
                return;
            }
            int min = Math.min(i11, f10 - e2);
            parsableByteArray.j(this.f49393a.d(), e2, min);
            this.f49393a.P(e2 + min);
        }

        public final void f(ParsableByteArray parsableByteArray, int i10) {
            if (i10 < 19) {
                return;
            }
            this.f49396d = parsableByteArray.J();
            this.f49397e = parsableByteArray.J();
            parsableByteArray.Q(11);
            this.f49398f = parsableByteArray.J();
            this.f49399g = parsableByteArray.J();
        }

        public final void g(ParsableByteArray parsableByteArray, int i10) {
            if (i10 % 5 != 2) {
                return;
            }
            parsableByteArray.Q(2);
            Arrays.fill(this.f49394b, 0);
            int i11 = i10 / 5;
            int i12 = 0;
            while (i12 < i11) {
                int D = parsableByteArray.D();
                int D2 = parsableByteArray.D();
                int D3 = parsableByteArray.D();
                int D4 = parsableByteArray.D();
                int D5 = parsableByteArray.D();
                double d10 = D2;
                double d11 = D3 - 128;
                int i13 = (int) ((1.402d * d11) + d10);
                int i14 = i12;
                double d12 = D4 - 128;
                this.f49394b[D] = j0.r((int) (d10 + (d12 * 1.772d)), 0, 255) | (j0.r((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255) << 8) | (D5 << 24) | (j0.r(i13, 0, 255) << 16);
                i12 = i14 + 1;
            }
            this.f49395c = true;
        }

        public void h() {
            this.f49396d = 0;
            this.f49397e = 0;
            this.f49398f = 0;
            this.f49399g = 0;
            this.f49400h = 0;
            this.f49401i = 0;
            this.f49393a.L(0);
            this.f49395c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f49389o = new ParsableByteArray();
        this.f49390p = new ParsableByteArray();
        this.f49391q = new C0740a();
    }

    @Nullable
    public static e6.a C(ParsableByteArray parsableByteArray, C0740a c0740a) {
        int f10 = parsableByteArray.f();
        int D = parsableByteArray.D();
        int J = parsableByteArray.J();
        int e2 = parsableByteArray.e() + J;
        e6.a aVar = null;
        if (e2 > f10) {
            parsableByteArray.P(f10);
            return null;
        }
        if (D != 128) {
            switch (D) {
                case 20:
                    c0740a.g(parsableByteArray, J);
                    break;
                case 21:
                    c0740a.e(parsableByteArray, J);
                    break;
                case 22:
                    c0740a.f(parsableByteArray, J);
                    break;
            }
        } else {
            aVar = c0740a.d();
            c0740a.h();
        }
        parsableByteArray.P(e2);
        return aVar;
    }

    @Override // e6.c
    public e A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        this.f49389o.N(bArr, i10);
        B(this.f49389o);
        this.f49391q.h();
        ArrayList arrayList = new ArrayList();
        while (this.f49389o.a() >= 3) {
            e6.a C = C(this.f49389o, this.f49391q);
            if (C != null) {
                arrayList.add(C);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }

    public final void B(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() <= 0 || parsableByteArray.h() != 120) {
            return;
        }
        if (this.f49392r == null) {
            this.f49392r = new Inflater();
        }
        if (j0.m0(parsableByteArray, this.f49390p, this.f49392r)) {
            parsableByteArray.N(this.f49390p.d(), this.f49390p.f());
        }
    }
}
