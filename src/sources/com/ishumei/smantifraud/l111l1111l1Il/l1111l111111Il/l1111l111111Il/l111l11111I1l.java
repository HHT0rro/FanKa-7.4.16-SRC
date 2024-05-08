package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111I1l {
    private static Comparator<byte[]> l1111l111111Il = new Comparator<byte[]>() { // from class: com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l11111I1l.1
        private static int l1111l111111Il(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private final List<byte[]> l111l11111lIl = new ArrayList();
    private final List<byte[]> l111l11111I1l = new ArrayList(64);
    private int l111l1111l1Il = 0;
    private final int l111l11111Il = 4096;

    public l111l11111I1l(int i10) {
    }

    private synchronized void l1111l111111Il() {
        while (this.l111l1111l1Il > this.l111l11111Il) {
            byte[] remove = this.l111l11111lIl.remove(0);
            this.l111l11111I1l.remove(remove);
            this.l111l1111l1Il -= remove.length;
        }
    }

    public final synchronized void l1111l111111Il(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.l111l11111Il) {
                this.l111l11111lIl.add(bArr);
                int binarySearch = Collections.binarySearch(this.l111l11111I1l, bArr, l1111l111111Il);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.l111l11111I1l.add(binarySearch, bArr);
                this.l111l1111l1Il += bArr.length;
                l1111l111111Il();
            }
        }
    }

    public final synchronized byte[] l1111l111111Il(int i10) {
        for (int i11 = 0; i11 < this.l111l11111I1l.size(); i11++) {
            byte[] bArr = this.l111l11111I1l.get(i11);
            if (bArr.length >= i10) {
                this.l111l1111l1Il -= bArr.length;
                this.l111l11111I1l.remove(i11);
                this.l111l11111lIl.remove(bArr);
                return bArr;
            }
        }
        return new byte[i10];
    }
}
