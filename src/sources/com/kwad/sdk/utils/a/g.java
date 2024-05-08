package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g implements c.b<Set<String>> {
    public static final g aSg = new g();

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i10 = 0;
        int i11 = 0;
        for (String str : set) {
            if (str == null) {
                i10 += 5;
                iArr[i11] = -1;
            } else {
                int he2 = b.he(str);
                strArr[i11] = str;
                iArr[i11] = he2;
                i10 += b.eg(he2) + he2;
            }
            i11++;
        }
        b bVar = new b(i10);
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = iArr[i12];
            bVar.ef(i13);
            if (i13 >= 0) {
                bVar.hd(strArr[i12]);
            }
        }
        return bVar.aRo;
    }

    private static Set<String> h(byte[] bArr, int i10, int i11) {
        int i12;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i11 > 0) {
            b bVar = new b(bArr, i10);
            int i13 = i10 + i11;
            while (true) {
                i12 = bVar.position;
                if (i12 >= i13) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.Nt()));
            }
            if (i12 != i13) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final String NN() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i10, int i11) {
        return h(bArr, i10, i11);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] m(Set<String> set) {
        return e(set);
    }
}
