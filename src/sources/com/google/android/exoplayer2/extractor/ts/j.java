package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import sun.security.util.DerValue;

/* compiled from: DefaultTsPayloadReaderFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j implements h0.c {

    /* renamed from: a, reason: collision with root package name */
    public final int f20496a;

    /* renamed from: b, reason: collision with root package name */
    public final List<Format> f20497b;

    public j(int i10) {
        this(i10, ImmutableList.of());
    }

    @Override // com.google.android.exoplayer2.extractor.ts.h0.c
    @Nullable
    public h0 a(int i10, h0.b bVar) {
        if (i10 == 2) {
            return new v(new n(d(bVar)));
        }
        if (i10 == 3 || i10 == 4) {
            return new v(new s(bVar.f20466b));
        }
        if (i10 == 21) {
            return new v(new q());
        }
        if (i10 == 27) {
            if (f(4)) {
                return null;
            }
            return new v(new H264Reader(c(bVar), f(1), f(8)));
        }
        if (i10 == 36) {
            return new v(new p(c(bVar)));
        }
        if (i10 != 89) {
            if (i10 != 138) {
                if (i10 == 172) {
                    return new v(new f(bVar.f20466b));
                }
                if (i10 != 257) {
                    if (i10 != 129) {
                        if (i10 != 130) {
                            if (i10 == 134) {
                                if (f(16)) {
                                    return null;
                                }
                                return new b0(new u("application/x-scte35"));
                            }
                            if (i10 != 135) {
                                switch (i10) {
                                    case 15:
                                        if (f(2)) {
                                            return null;
                                        }
                                        return new v(new i(false, bVar.f20466b));
                                    case 16:
                                        return new v(new o(d(bVar)));
                                    case 17:
                                        if (f(2)) {
                                            return null;
                                        }
                                        return new v(new r(bVar.f20466b));
                                    default:
                                        return null;
                                }
                            }
                        } else if (!f(64)) {
                            return null;
                        }
                    }
                    return new v(new c(bVar.f20466b));
                }
                return new b0(new u("application/vnd.dvb.ait"));
            }
            return new v(new k(bVar.f20466b));
        }
        return new v(new l(bVar.f20467c));
    }

    @Override // com.google.android.exoplayer2.extractor.ts.h0.c
    public SparseArray<h0> b() {
        return new SparseArray<>();
    }

    public final c0 c(h0.b bVar) {
        return new c0(e(bVar));
    }

    public final j0 d(h0.b bVar) {
        return new j0(e(bVar));
    }

    public final List<Format> e(h0.b bVar) {
        String str;
        int i10;
        if (f(32)) {
            return this.f20497b;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(bVar.f20468d);
        List<Format> list = this.f20497b;
        while (parsableByteArray.a() > 0) {
            int D = parsableByteArray.D();
            int e2 = parsableByteArray.e() + parsableByteArray.D();
            if (D == 134) {
                list = new ArrayList<>();
                int D2 = parsableByteArray.D() & 31;
                for (int i11 = 0; i11 < D2; i11++) {
                    String A = parsableByteArray.A(3);
                    int D3 = parsableByteArray.D();
                    boolean z10 = (D3 & 128) != 0;
                    if (z10) {
                        i10 = D3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i10 = 1;
                    }
                    byte D4 = (byte) parsableByteArray.D();
                    parsableByteArray.Q(1);
                    List<byte[]> list2 = null;
                    if (z10) {
                        list2 = com.google.android.exoplayer2.util.c.b((D4 & DerValue.TAG_APPLICATION) != 0);
                    }
                    list.add(new Format.b().e0(str).V(A).F(i10).T(list2).E());
                }
            }
            parsableByteArray.P(e2);
        }
        return list;
    }

    public final boolean f(int i10) {
        return (i10 & this.f20496a) != 0;
    }

    public j(int i10, List<Format> list) {
        this.f20496a = i10;
        this.f20497b = list;
    }
}
