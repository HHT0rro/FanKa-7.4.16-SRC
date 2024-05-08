package com.jd.ad.sdk.jad_zi;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_cp implements Serializable, Comparable<jad_cp> {
    public static final char[] jad_dq = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final jad_cp jad_er = new jad_cp((byte[]) new byte[0].clone());
    public final byte[] jad_an;
    public transient int jad_bo;
    public transient String jad_cp;

    public jad_cp(byte[] bArr) {
        this.jad_an = bArr;
    }

    public static jad_cp jad_an(String str) {
        jad_cp jad_cpVar = new jad_cp(str.getBytes(jad_ob.jad_an));
        jad_cpVar.jad_cp = str;
        return jad_cpVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(com.jd.ad.sdk.jad_zi.jad_cp r8) {
        /*
            r7 = this;
            com.jd.ad.sdk.jad_zi.jad_cp r8 = (com.jd.ad.sdk.jad_zi.jad_cp) r8
            int r0 = r7.jad_cp()
            int r1 = r8.jad_cp()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L10:
            if (r4 >= r2) goto L26
            byte r5 = r7.jad_an(r4)
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r6 = r8.jad_an(r4)
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r5 != r6) goto L23
            int r4 = r4 + 1
            goto L10
        L23:
            if (r5 >= r6) goto L2d
            goto L2b
        L26:
            if (r0 != r1) goto L29
            goto L2e
        L29:
            if (r0 >= r1) goto L2d
        L2b:
            r3 = -1
            goto L2e
        L2d:
            r3 = 1
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_zi.jad_cp.compareTo(java.lang.Object):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof jad_cp) {
            jad_cp jad_cpVar = (jad_cp) obj;
            int jad_cp = jad_cpVar.jad_cp();
            byte[] bArr = this.jad_an;
            if (jad_cp == bArr.length && jad_cpVar.jad_an(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.jad_bo;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = Arrays.hashCode(this.jad_an);
        this.jad_bo = hashCode;
        return hashCode;
    }

    public byte jad_an(int i10) {
        return this.jad_an[i10];
    }

    public jad_cp jad_an(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.jad_an;
        if (i11 > bArr.length) {
            StringBuilder jad_an = jad_pc.jad_an("endIndex > length(");
            jad_an.append(this.jad_an.length);
            jad_an.append(")");
            throw new IllegalArgumentException(jad_an.toString());
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i10 == 0 && i11 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i12];
        System.arraycopy((Object) bArr, i10, (Object) bArr2, 0, i12);
        return new jad_cp(bArr2);
    }

    public String jad_an() {
        byte[] bArr = this.jad_an;
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b4 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = jad_dq;
            cArr[i10] = cArr2[(b4 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public boolean jad_an(int i10, jad_cp jad_cpVar, int i11, int i12) {
        return jad_cpVar.jad_an(i11, this.jad_an, i10, i12);
    }

    public boolean jad_an(int i10, byte[] bArr, int i11, int i12) {
        if (i10 >= 0) {
            byte[] bArr2 = this.jad_an;
            if (i10 <= bArr2.length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && jad_ob.jad_an(bArr2, i10, bArr, i11, i12)) {
                return true;
            }
        }
        return false;
    }

    public byte[] jad_bo() {
        return this.jad_an;
    }

    public int jad_cp() {
        return this.jad_an.length;
    }

    public String jad_dq() {
        String str = this.jad_cp;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.jad_an, jad_ob.jad_an);
        this.jad_cp = str2;
        return str2;
    }

    public String toString() {
        StringBuilder sb2;
        StringBuilder jad_an;
        if (this.jad_an.length == 0) {
            return "[size=0]";
        }
        String jad_dq2 = jad_dq();
        int length = jad_dq2.length();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = jad_dq2.length();
                break;
            }
            if (i11 == 64) {
                break;
            }
            int codePointAt = jad_dq2.codePointAt(i10);
            if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                i11++;
                i10 += Character.charCount(codePointAt);
            }
        }
        i10 = -1;
        if (i10 == -1) {
            if (this.jad_an.length <= 64) {
                jad_an = jad_pc.jad_an("[hex=");
                jad_an.append(jad_an());
                jad_an.append("]");
            } else {
                jad_an = jad_pc.jad_an("[size=");
                jad_an.append(this.jad_an.length);
                jad_an.append(" hex=");
                jad_an.append(jad_an(0, 64).jad_an());
                jad_an.append("…]");
            }
            return jad_an.toString();
        }
        String replace = jad_dq2.substring(0, i10).replace("\\", "\\\\").replace("\n", "\\n").replace(StringUtils.CR, "\\r");
        if (i10 < jad_dq2.length()) {
            sb2 = jad_pc.jad_an("[size=");
            sb2.append(this.jad_an.length);
            sb2.append(" text=");
            sb2.append(replace);
            sb2.append("…]");
        } else {
            sb2 = new StringBuilder();
            sb2.append("[text=");
            sb2.append(replace);
            sb2.append("]");
        }
        return sb2.toString();
    }
}
