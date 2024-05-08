package com.jd.ad.sdk.jad_zi;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_ly extends jad_cp {
    public final transient byte[][] jad_fs;
    public final transient int[] jad_jt;

    public jad_ly(jad_an jad_anVar, int i10) {
        super(null);
        jad_ob.jad_an(jad_anVar.jad_bo, 0L, i10);
        jad_jw jad_jwVar = jad_anVar.jad_an;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = jad_jwVar.jad_cp;
            int i15 = jad_jwVar.jad_bo;
            if (i14 == i15) {
                throw new AssertionError((Object) "s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            jad_jwVar = jad_jwVar.jad_fs;
        }
        this.jad_fs = new byte[i13];
        this.jad_jt = new int[i13 * 2];
        jad_jw jad_jwVar2 = jad_anVar.jad_an;
        int i16 = 0;
        while (i11 < i10) {
            byte[][] bArr = this.jad_fs;
            bArr[i16] = jad_jwVar2.jad_an;
            int i17 = jad_jwVar2.jad_cp;
            int i18 = jad_jwVar2.jad_bo;
            int i19 = (i17 - i18) + i11;
            i11 = i19 > i10 ? i10 : i19;
            int[] iArr = this.jad_jt;
            iArr[i16] = i11;
            iArr[bArr.length + i16] = i18;
            jad_jwVar2.jad_dq = true;
            i16++;
            jad_jwVar2 = jad_jwVar2.jad_fs;
        }
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof jad_cp) {
            jad_cp jad_cpVar = (jad_cp) obj;
            if (jad_cpVar.jad_cp() == jad_cp() && jad_an(0, jad_cpVar, 0, jad_cp())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public int hashCode() {
        int i10 = this.jad_bo;
        if (i10 != 0) {
            return i10;
        }
        int length = this.jad_fs.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (i11 < length) {
            byte[] bArr = this.jad_fs[i11];
            int[] iArr = this.jad_jt;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            int i16 = (i15 - i12) + i14;
            while (i14 < i16) {
                i13 = (i13 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i12 = i15;
        }
        this.jad_bo = i13;
        return i13;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public byte jad_an(int i10) {
        jad_ob.jad_an(this.jad_jt[this.jad_fs.length - 1], i10, 1L);
        int jad_bo = jad_bo(i10);
        int i11 = jad_bo == 0 ? 0 : this.jad_jt[jad_bo - 1];
        int[] iArr = this.jad_jt;
        byte[][] bArr = this.jad_fs;
        return bArr[jad_bo][(i10 - i11) + iArr[bArr.length + jad_bo]];
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public jad_cp jad_an(int i10, int i11) {
        return jad_fs().jad_an(i10, i11);
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public String jad_an() {
        return jad_fs().jad_an();
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public boolean jad_an(int i10, jad_cp jad_cpVar, int i11, int i12) {
        if (i10 < 0 || i10 > jad_cp() - i12) {
            return false;
        }
        int jad_bo = jad_bo(i10);
        while (i12 > 0) {
            int i13 = jad_bo == 0 ? 0 : this.jad_jt[jad_bo - 1];
            int min = Math.min(i12, ((this.jad_jt[jad_bo] - i13) + i13) - i10);
            int[] iArr = this.jad_jt;
            byte[][] bArr = this.jad_fs;
            if (!jad_cpVar.jad_an(i11, bArr[jad_bo], (i10 - i13) + iArr[bArr.length + jad_bo], min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            jad_bo++;
        }
        return true;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public boolean jad_an(int i10, byte[] bArr, int i11, int i12) {
        if (i10 < 0 || i10 > jad_cp() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int jad_bo = jad_bo(i10);
        while (i12 > 0) {
            int i13 = jad_bo == 0 ? 0 : this.jad_jt[jad_bo - 1];
            int min = Math.min(i12, ((this.jad_jt[jad_bo] - i13) + i13) - i10);
            int[] iArr = this.jad_jt;
            byte[][] bArr2 = this.jad_fs;
            if (!jad_ob.jad_an(bArr2[jad_bo], (i10 - i13) + iArr[bArr2.length + jad_bo], bArr, i11, min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            jad_bo++;
        }
        return true;
    }

    public final int jad_bo(int i10) {
        int binarySearch = Arrays.binarySearch(this.jad_jt, 0, this.jad_fs.length, i10 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public byte[] jad_bo() {
        return jad_er();
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public int jad_cp() {
        return this.jad_jt[this.jad_fs.length - 1];
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public String jad_dq() {
        jad_cp jad_fs = jad_fs();
        String str = jad_fs.jad_cp;
        if (str != null) {
            return str;
        }
        String str2 = new String(jad_fs.jad_an, jad_ob.jad_an);
        jad_fs.jad_cp = str2;
        return str2;
    }

    public byte[] jad_er() {
        int[] iArr = this.jad_jt;
        byte[][] bArr = this.jad_fs;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr2 = this.jad_jt;
            int i12 = iArr2[length + i10];
            int i13 = iArr2[i10];
            System.arraycopy((Object) this.jad_fs[i10], i12, (Object) bArr2, i11, i13 - i11);
            i10++;
            i11 = i13;
        }
        return bArr2;
    }

    public final jad_cp jad_fs() {
        return new jad_cp(jad_er());
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_cp
    public String toString() {
        return jad_fs().toString();
    }
}
