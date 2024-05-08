package com.bytedance.pangle.f.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int[] f10769a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f10770b;

    public final String a(int i10) {
        int[] iArr;
        if (i10 < 0 || (iArr = this.f10769a) == null || i10 >= iArr.length) {
            return null;
        }
        int i11 = iArr[i10];
        int a10 = a(this.f10770b, i11);
        StringBuilder sb2 = new StringBuilder(a10);
        while (a10 != 0) {
            i11 += 2;
            sb2.append((char) a(this.f10770b, i11));
            a10--;
        }
        return sb2.toString();
    }

    private static final int a(int[] iArr, int i10) {
        int i11 = iArr[i10 / 4];
        return (i10 % 4) / 2 == 0 ? i11 & 65535 : i11 >>> 16;
    }
}
