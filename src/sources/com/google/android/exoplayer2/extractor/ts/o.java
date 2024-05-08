package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: H263Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o implements m {

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f20539l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final j0 f20540a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final ParsableByteArray f20541b;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final t f20544e;

    /* renamed from: f, reason: collision with root package name */
    public b f20545f;

    /* renamed from: g, reason: collision with root package name */
    public long f20546g;

    /* renamed from: h, reason: collision with root package name */
    public String f20547h;

    /* renamed from: i, reason: collision with root package name */
    public TrackOutput f20548i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20549j;

    /* renamed from: c, reason: collision with root package name */
    public final boolean[] f20542c = new boolean[4];

    /* renamed from: d, reason: collision with root package name */
    public final a f20543d = new a(128);

    /* renamed from: k, reason: collision with root package name */
    public long f20550k = -9223372036854775807L;

    /* compiled from: H263Reader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: f, reason: collision with root package name */
        public static final byte[] f20551f = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        public boolean f20552a;

        /* renamed from: b, reason: collision with root package name */
        public int f20553b;

        /* renamed from: c, reason: collision with root package name */
        public int f20554c;

        /* renamed from: d, reason: collision with root package name */
        public int f20555d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f20556e;

        public a(int i10) {
            this.f20556e = new byte[i10];
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f20552a) {
                int i12 = i11 - i10;
                byte[] bArr2 = this.f20556e;
                int length = bArr2.length;
                int i13 = this.f20554c;
                if (length < i13 + i12) {
                    this.f20556e = Arrays.copyOf(bArr2, (i13 + i12) * 2);
                }
                System.arraycopy((Object) bArr, i10, (Object) this.f20556e, this.f20554c, i12);
                this.f20554c += i12;
            }
        }

        public boolean b(int i10, int i11) {
            int i12 = this.f20553b;
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 != 3) {
                            if (i12 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i10 == 179 || i10 == 181) {
                                this.f20554c -= i11;
                                this.f20552a = false;
                                return true;
                            }
                        } else if ((i10 & 240) != 32) {
                            com.google.android.exoplayer2.util.m.h("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f20555d = this.f20554c;
                            this.f20553b = 4;
                        }
                    } else if (i10 > 31) {
                        com.google.android.exoplayer2.util.m.h("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f20553b = 3;
                    }
                } else if (i10 != 181) {
                    com.google.android.exoplayer2.util.m.h("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f20553b = 2;
                }
            } else if (i10 == 176) {
                this.f20553b = 1;
                this.f20552a = true;
            }
            byte[] bArr = f20551f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f20552a = false;
            this.f20554c = 0;
            this.f20553b = 0;
        }
    }

    /* compiled from: H263Reader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final TrackOutput f20557a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f20558b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f20559c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f20560d;

        /* renamed from: e, reason: collision with root package name */
        public int f20561e;

        /* renamed from: f, reason: collision with root package name */
        public int f20562f;

        /* renamed from: g, reason: collision with root package name */
        public long f20563g;

        /* renamed from: h, reason: collision with root package name */
        public long f20564h;

        public b(TrackOutput trackOutput) {
            this.f20557a = trackOutput;
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f20559c) {
                int i12 = this.f20562f;
                int i13 = (i10 + 1) - i12;
                if (i13 < i11) {
                    this.f20560d = ((bArr[i13] & 192) >> 6) == 0;
                    this.f20559c = false;
                } else {
                    this.f20562f = i12 + (i11 - i10);
                }
            }
        }

        public void b(long j10, int i10, boolean z10) {
            if (this.f20561e == 182 && z10 && this.f20558b) {
                long j11 = this.f20564h;
                if (j11 != -9223372036854775807L) {
                    this.f20557a.d(j11, this.f20560d ? 1 : 0, (int) (j10 - this.f20563g), i10, null);
                }
            }
            if (this.f20561e != 179) {
                this.f20563g = j10;
            }
        }

        public void c(int i10, long j10) {
            this.f20561e = i10;
            this.f20560d = false;
            this.f20558b = i10 == 182 || i10 == 179;
            this.f20559c = i10 == 182;
            this.f20562f = 0;
            this.f20564h = j10;
        }

        public void d() {
            this.f20558b = false;
            this.f20559c = false;
            this.f20560d = false;
            this.f20561e = -1;
        }
    }

    public o(@Nullable j0 j0Var) {
        this.f20540a = j0Var;
        if (j0Var != null) {
            this.f20544e = new t(178, 128);
            this.f20541b = new ParsableByteArray();
        } else {
            this.f20544e = null;
            this.f20541b = null;
        }
    }

    public static Format b(a aVar, int i10, String str) {
        byte[] copyOf = Arrays.copyOf(aVar.f20556e, aVar.f20554c);
        com.google.android.exoplayer2.util.u uVar = new com.google.android.exoplayer2.util.u(copyOf);
        uVar.s(i10);
        uVar.s(4);
        uVar.q();
        uVar.r(8);
        if (uVar.g()) {
            uVar.r(4);
            uVar.r(3);
        }
        int h10 = uVar.h(4);
        float f10 = 1.0f;
        if (h10 == 15) {
            int h11 = uVar.h(8);
            int h12 = uVar.h(8);
            if (h12 == 0) {
                com.google.android.exoplayer2.util.m.h("H263Reader", "Invalid aspect ratio");
            } else {
                f10 = h11 / h12;
            }
        } else {
            float[] fArr = f20539l;
            if (h10 < fArr.length) {
                f10 = fArr[h10];
            } else {
                com.google.android.exoplayer2.util.m.h("H263Reader", "Invalid aspect ratio");
            }
        }
        if (uVar.g()) {
            uVar.r(2);
            uVar.r(1);
            if (uVar.g()) {
                uVar.r(15);
                uVar.q();
                uVar.r(15);
                uVar.q();
                uVar.r(15);
                uVar.q();
                uVar.r(3);
                uVar.r(11);
                uVar.q();
                uVar.r(15);
                uVar.q();
            }
        }
        if (uVar.h(2) != 0) {
            com.google.android.exoplayer2.util.m.h("H263Reader", "Unhandled video object layer shape");
        }
        uVar.q();
        int h13 = uVar.h(16);
        uVar.q();
        if (uVar.g()) {
            if (h13 == 0) {
                com.google.android.exoplayer2.util.m.h("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i11 = 0;
                for (int i12 = h13 - 1; i12 > 0; i12 >>= 1) {
                    i11++;
                }
                uVar.r(i11);
            }
        }
        uVar.q();
        int h14 = uVar.h(13);
        uVar.q();
        int h15 = uVar.h(13);
        uVar.q();
        uVar.q();
        return new Format.b().S(str).e0("video/mp4v-es").j0(h14).Q(h15).a0(f10).T(Collections.singletonList(copyOf)).E();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        NalUnitUtil.a(this.f20542c);
        this.f20543d.c();
        b bVar = this.f20545f;
        if (bVar != null) {
            bVar.d();
        }
        t tVar = this.f20544e;
        if (tVar != null) {
            tVar.d();
        }
        this.f20546g = 0L;
        this.f20550k = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.a.i(this.f20545f);
        com.google.android.exoplayer2.util.a.i(this.f20548i);
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        byte[] d10 = parsableByteArray.d();
        this.f20546g += parsableByteArray.a();
        this.f20548i.a(parsableByteArray, parsableByteArray.a());
        while (true) {
            int c4 = NalUnitUtil.c(d10, e2, f10, this.f20542c);
            if (c4 == f10) {
                break;
            }
            int i10 = c4 + 3;
            int i11 = parsableByteArray.d()[i10] & 255;
            int i12 = c4 - e2;
            int i13 = 0;
            if (!this.f20549j) {
                if (i12 > 0) {
                    this.f20543d.a(d10, e2, c4);
                }
                if (this.f20543d.b(i11, i12 < 0 ? -i12 : 0)) {
                    TrackOutput trackOutput = this.f20548i;
                    a aVar = this.f20543d;
                    trackOutput.b(b(aVar, aVar.f20555d, (String) com.google.android.exoplayer2.util.a.e(this.f20547h)));
                    this.f20549j = true;
                }
            }
            this.f20545f.a(d10, e2, c4);
            t tVar = this.f20544e;
            if (tVar != null) {
                if (i12 > 0) {
                    tVar.a(d10, e2, c4);
                } else {
                    i13 = -i12;
                }
                if (this.f20544e.b(i13)) {
                    t tVar2 = this.f20544e;
                    ((ParsableByteArray) com.google.android.exoplayer2.util.j0.j(this.f20541b)).N(this.f20544e.f20634d, NalUnitUtil.k(tVar2.f20634d, tVar2.f20635e));
                    ((j0) com.google.android.exoplayer2.util.j0.j(this.f20540a)).a(this.f20550k, this.f20541b);
                }
                if (i11 == 178 && parsableByteArray.d()[c4 + 2] == 1) {
                    this.f20544e.e(i11);
                }
            }
            int i14 = f10 - c4;
            this.f20545f.b(this.f20546g - i14, i14, this.f20549j);
            this.f20545f.c(i11, this.f20550k);
            e2 = i10;
        }
        if (!this.f20549j) {
            this.f20543d.a(d10, e2, f10);
        }
        this.f20545f.a(d10, e2, f10);
        t tVar3 = this.f20544e;
        if (tVar3 != null) {
            tVar3.a(d10, e2, f10);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20547h = dVar.b();
        TrackOutput c4 = eVar.c(dVar.c(), 2);
        this.f20548i = c4;
        this.f20545f = new b(c4);
        j0 j0Var = this.f20540a;
        if (j0Var != null) {
            j0Var.b(eVar, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20550k = j10;
        }
    }
}
