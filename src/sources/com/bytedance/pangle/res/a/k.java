package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k {
    public static int a(g gVar) {
        return (int) gVar.f10932a.a().b();
    }

    private static byte[] a(int i10) {
        return new byte[]{(byte) (i10 >> 0), (byte) (i10 >> 8), (byte) (i10 >> 16), (byte) (i10 >> 24)};
    }

    public static int a(byte[] bArr, int i10, int i11, h hVar) {
        if (i10 < 2130706432) {
            return i10;
        }
        int a10 = hVar.a(i10);
        byte[] a11 = a(a10);
        bArr[i11] = a11[0];
        bArr[i11 + 1] = a11[1];
        bArr[i11 + 2] = a11[2];
        bArr[i11 + 3] = a11[3];
        return a10;
    }

    public static void a(byte[] bArr, h hVar) {
        b bVar = new b(bArr, hVar);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        bVar.a();
        bVar.f10908c = new g(new i(new e(byteArrayInputStream)));
        do {
        } while (bVar.b() != 1);
    }

    public static void a(int i10, byte[] bArr, int[] iArr, int i11, HashMap<Integer, Integer> hashMap) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int i12 = -1;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = i13 * 5;
            int i15 = iArr[i14 + 1];
            if (hashMap.containsKey(Integer.valueOf(i15))) {
                if (i12 == -1) {
                    i12 = i13;
                }
                int i16 = (i14 * 4) + i10;
                hashMap2.put(Integer.valueOf(i13), Arrays.copyOfRange(bArr, i16, i16 + 20));
                hashMap3.put(Integer.valueOf(hashMap.get(Integer.valueOf(i15)).intValue()), Integer.valueOf(i13));
            }
        }
        ArrayList arrayList = new ArrayList(hashMap3.h());
        Collections.sort(arrayList);
        Iterator iterator2 = arrayList.iterator2();
        int i17 = 0;
        while (iterator2.hasNext()) {
            byte[] bArr2 = (byte[]) hashMap2.get(Integer.valueOf(((Integer) hashMap3.get((Integer) iterator2.next())).intValue()));
            System.arraycopy((Object) bArr2, 0, (Object) bArr, ((i17 + i12) * 5 * 4) + i10, bArr2.length);
            i17++;
        }
    }
}
