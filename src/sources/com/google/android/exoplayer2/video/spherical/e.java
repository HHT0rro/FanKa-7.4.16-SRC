package com.google.android.exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.video.spherical.Projection;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* compiled from: ProjectionDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {
    @Nullable
    public static Projection a(byte[] bArr, int i10) {
        ArrayList<Projection.a> arrayList;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        try {
            arrayList = c(parsableByteArray) ? f(parsableByteArray) : e(parsableByteArray);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new Projection(arrayList.get(0), i10);
        }
        if (size != 2) {
            return null;
        }
        return new Projection(arrayList.get(0), arrayList.get(1), i10);
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >> 1);
    }

    public static boolean c(ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(4);
        int n10 = parsableByteArray.n();
        parsableByteArray.P(0);
        return n10 == 1886547818;
    }

    @Nullable
    public static Projection.a d(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.n();
        if (n10 > 10000) {
            return null;
        }
        float[] fArr = new float[n10];
        for (int i10 = 0; i10 < n10; i10++) {
            fArr[i10] = parsableByteArray.m();
        }
        int n11 = parsableByteArray.n();
        if (n11 > 32000) {
            return null;
        }
        double d10 = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(n10 * 2.0d) / log);
        u uVar = new u(parsableByteArray.d());
        int i11 = 8;
        uVar.p(parsableByteArray.e() * 8);
        float[] fArr2 = new float[n11 * 5];
        int i12 = 5;
        int[] iArr = new int[5];
        int i13 = 0;
        int i14 = 0;
        while (i13 < n11) {
            int i15 = 0;
            while (i15 < i12) {
                int b4 = iArr[i15] + b(uVar.h(ceil));
                if (b4 >= n10 || b4 < 0) {
                    return null;
                }
                fArr2[i14] = fArr[b4];
                iArr[i15] = b4;
                i15++;
                i14++;
                i12 = 5;
            }
            i13++;
            i12 = 5;
        }
        uVar.p((uVar.e() + 7) & (-8));
        int i16 = 32;
        int h10 = uVar.h(32);
        Projection.SubMesh[] subMeshArr = new Projection.SubMesh[h10];
        int i17 = 0;
        while (i17 < h10) {
            int h11 = uVar.h(i11);
            int h12 = uVar.h(i11);
            int h13 = uVar.h(i16);
            if (h13 > 128000) {
                return null;
            }
            int ceil2 = (int) Math.ceil(Math.log(n11 * d10) / log);
            float[] fArr3 = new float[h13 * 3];
            float[] fArr4 = new float[h13 * 2];
            int i18 = 0;
            for (int i19 = 0; i19 < h13; i19++) {
                i18 += b(uVar.h(ceil2));
                if (i18 < 0 || i18 >= n11) {
                    return null;
                }
                int i20 = i19 * 3;
                int i21 = i18 * 5;
                fArr3[i20] = fArr2[i21];
                fArr3[i20 + 1] = fArr2[i21 + 1];
                fArr3[i20 + 2] = fArr2[i21 + 2];
                int i22 = i19 * 2;
                fArr4[i22] = fArr2[i21 + 3];
                fArr4[i22 + 1] = fArr2[i21 + 4];
            }
            subMeshArr[i17] = new Projection.SubMesh(h11, fArr3, fArr4, h12);
            i17++;
            i16 = 32;
            d10 = 2.0d;
            i11 = 8;
        }
        return new Projection.a(subMeshArr);
    }

    @Nullable
    public static ArrayList<Projection.a> e(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.D() != 0) {
            return null;
        }
        parsableByteArray.Q(7);
        int n10 = parsableByteArray.n();
        if (n10 == 1684433976) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!j0.m0(parsableByteArray, parsableByteArray2, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            } finally {
                inflater.end();
            }
        } else if (n10 != 1918990112) {
            return null;
        }
        return g(parsableByteArray);
    }

    @Nullable
    public static ArrayList<Projection.a> f(ParsableByteArray parsableByteArray) {
        int n10;
        parsableByteArray.Q(8);
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        while (e2 < f10 && (n10 = parsableByteArray.n() + e2) > e2 && n10 <= f10) {
            int n11 = parsableByteArray.n();
            if (n11 != 2037673328 && n11 != 1836279920) {
                parsableByteArray.P(n10);
                e2 = n10;
            } else {
                parsableByteArray.O(n10);
                return e(parsableByteArray);
            }
        }
        return null;
    }

    @Nullable
    public static ArrayList<Projection.a> g(ParsableByteArray parsableByteArray) {
        ArrayList<Projection.a> arrayList = new ArrayList<>();
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        while (e2 < f10) {
            int n10 = parsableByteArray.n() + e2;
            if (n10 <= e2 || n10 > f10) {
                return null;
            }
            if (parsableByteArray.n() == 1835365224) {
                Projection.a d10 = d(parsableByteArray);
                if (d10 == null) {
                    return null;
                }
                arrayList.add(d10);
            }
            parsableByteArray.P(n10);
            e2 = n10;
        }
        return arrayList;
    }
}
