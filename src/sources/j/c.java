package j;

import java.util.Arrays;

/* compiled from: GradientColor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f50187a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f50188b;

    public c(float[] fArr, int[] iArr) {
        this.f50187a = fArr;
        this.f50188b = iArr;
    }

    public c a(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            iArr[i10] = b(fArr[i10]);
        }
        return new c(fArr, iArr);
    }

    public final int b(float f10) {
        int binarySearch = Arrays.binarySearch(this.f50187a, f10);
        if (binarySearch >= 0) {
            return this.f50188b[binarySearch];
        }
        int i10 = -(binarySearch + 1);
        if (i10 == 0) {
            return this.f50188b[0];
        }
        int[] iArr = this.f50188b;
        if (i10 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f50187a;
        int i11 = i10 - 1;
        float f11 = fArr[i11];
        return n.b.c((f10 - f11) / (fArr[i10] - f11), iArr[i11], iArr[i10]);
    }

    public int[] c() {
        return this.f50188b;
    }

    public float[] d() {
        return this.f50187a;
    }

    public int e() {
        return this.f50188b.length;
    }

    public void f(c cVar, c cVar2, float f10) {
        if (cVar.f50188b.length == cVar2.f50188b.length) {
            for (int i10 = 0; i10 < cVar.f50188b.length; i10++) {
                this.f50187a[i10] = n.g.i(cVar.f50187a[i10], cVar2.f50187a[i10], f10);
                this.f50188b[i10] = n.b.c(f10, cVar.f50188b[i10], cVar2.f50188b[i10]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f50188b.length + " vs " + cVar2.f50188b.length + ")");
    }
}
