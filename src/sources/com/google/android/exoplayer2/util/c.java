package com.google.android.exoplayer2.util;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: CodecSpecificDataUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f22959a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f22960b = {"", "A", "B", "C"};

    public static String a(int i10, int i11, int i12) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public static List<byte[]> b(boolean z10) {
        return Collections.singletonList(z10 ? new byte[]{1} : new byte[]{0});
    }

    public static String c(v vVar) {
        vVar.l(24);
        int e2 = vVar.e(2);
        boolean d10 = vVar.d();
        int e10 = vVar.e(5);
        int i10 = 0;
        for (int i11 = 0; i11 < 32; i11++) {
            if (vVar.d()) {
                i10 |= 1 << i11;
            }
        }
        int i12 = 6;
        int[] iArr = new int[6];
        for (int i13 = 0; i13 < 6; i13++) {
            iArr[i13] = vVar.e(8);
        }
        int e11 = vVar.e(8);
        Object[] objArr = new Object[5];
        objArr[0] = f22960b[e2];
        objArr[1] = Integer.valueOf(e10);
        objArr[2] = Integer.valueOf(i10);
        objArr[3] = Character.valueOf(d10 ? 'H' : 'L');
        objArr[4] = Integer.valueOf(e11);
        StringBuilder sb2 = new StringBuilder(j0.D("hvc1.%s%d.%X.%c%d", objArr));
        while (i12 > 0 && iArr[i12 - 1] == 0) {
            i12--;
        }
        for (int i14 = 0; i14 < i12; i14++) {
            sb2.append(String.format(".%02X", Integer.valueOf(iArr[i14])));
        }
        return sb2.toString();
    }

    public static byte[] d(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = f22959a;
        byte[] bArr3 = new byte[bArr2.length + i11];
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, bArr2.length);
        System.arraycopy((Object) bArr, i10, (Object) bArr3, bArr2.length, i11);
        return bArr3;
    }

    public static int e(byte[] bArr, int i10) {
        int length = bArr.length - f22959a.length;
        while (i10 <= length) {
            if (f(bArr, i10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static boolean f(byte[] bArr, int i10) {
        if (bArr.length - i10 <= f22959a.length) {
            return false;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f22959a;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i10 + i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    public static Pair<Integer, Integer> g(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.P(9);
        int D = parsableByteArray.D();
        parsableByteArray.P(20);
        return Pair.create(Integer.valueOf(parsableByteArray.H()), Integer.valueOf(D));
    }

    public static boolean h(List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static byte[][] i(byte[] bArr) {
        if (!f(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        do {
            arrayList.add(Integer.valueOf(i10));
            i10 = e(bArr, i10 + f22959a.length);
        } while (i10 != -1);
        byte[][] bArr2 = new byte[arrayList.size()];
        int i11 = 0;
        while (i11 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i11)).intValue();
            int intValue2 = (i11 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i11 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr3 = new byte[intValue2];
            System.arraycopy((Object) bArr, intValue, (Object) bArr3, 0, intValue2);
            bArr2[i11] = bArr3;
            i11++;
        }
        return bArr2;
    }
}
