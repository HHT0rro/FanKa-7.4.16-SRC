package com.jd.ad.sdk.jad_ud;

import com.jd.ad.sdk.jad_js.jad_zm;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class jad_cp implements Closeable {
    public static final String[] jad_er = new String[128];
    public int jad_an;
    public int[] jad_bo = new int[32];
    public String[] jad_cp = new String[32];
    public int[] jad_dq = new int[32];

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class jad_an {
        public final String[] jad_an;
        public final com.jd.ad.sdk.jad_zi.jad_fs jad_bo;

        public jad_an(String[] strArr, com.jd.ad.sdk.jad_zi.jad_fs jad_fsVar) {
            this.jad_an = strArr;
            this.jad_bo = jad_fsVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[Catch: IOException -> 0x007b, TryCatch #1 {IOException -> 0x007b, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:13:0x0046, B:15:0x003a, B:16:0x003d, B:27:0x004b, B:28:0x004e, B:30:0x0056, B:31:0x005c, B:34:0x0065, B:35:0x006a, B:38:0x006b), top: B:1:0x0000, inners: #0 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.jd.ad.sdk.jad_ud.jad_cp.jad_an jad_an(java.lang.String... r12) {
            /*
                int r0 = r12.length     // Catch: java.io.IOException -> L7b
                com.jd.ad.sdk.jad_zi.jad_cp[] r0 = new com.jd.ad.sdk.jad_zi.jad_cp[r0]     // Catch: java.io.IOException -> L7b
                com.jd.ad.sdk.jad_zi.jad_an r1 = new com.jd.ad.sdk.jad_zi.jad_an     // Catch: java.io.IOException -> L7b
                r1.<init>()     // Catch: java.io.IOException -> L7b
                r2 = 0
                r3 = 0
            La:
                int r4 = r12.length     // Catch: java.io.IOException -> L7b
                if (r3 >= r4) goto L6b
                r4 = r12[r3]     // Catch: java.io.IOException -> L7b
                java.lang.String[] r5 = com.jd.ad.sdk.jad_ud.jad_cp.jad_er     // Catch: java.io.IOException -> L7b
                r6 = 34
                r1.jad_bo(r6)     // Catch: java.io.IOException -> L7b
                int r7 = r4.length()     // Catch: java.io.IOException -> L7b
                r8 = 0
                r9 = 0
            L1c:
                if (r8 >= r7) goto L49
                char r10 = r4.charAt(r8)     // Catch: java.io.IOException -> L7b
                r11 = 128(0x80, float:1.794E-43)
                if (r10 >= r11) goto L2b
                r10 = r5[r10]     // Catch: java.io.IOException -> L7b
                if (r10 != 0) goto L38
                goto L46
            L2b:
                r11 = 8232(0x2028, float:1.1535E-41)
                if (r10 != r11) goto L32
                java.lang.String r10 = "\\u2028"
                goto L38
            L32:
                r11 = 8233(0x2029, float:1.1537E-41)
                if (r10 != r11) goto L46
                java.lang.String r10 = "\\u2029"
            L38:
                if (r9 >= r8) goto L3d
                r1.jad_an(r4, r9, r8)     // Catch: java.io.IOException -> L7b
            L3d:
                int r9 = r10.length()     // Catch: java.io.IOException -> L7b
                r1.jad_an(r10, r2, r9)     // Catch: java.io.IOException -> L7b
                int r9 = r8 + 1
            L46:
                int r8 = r8 + 1
                goto L1c
            L49:
                if (r9 >= r7) goto L4e
                r1.jad_an(r4, r9, r7)     // Catch: java.io.IOException -> L7b
            L4e:
                r1.jad_bo(r6)     // Catch: java.io.IOException -> L7b
                r1.jad_bo()     // Catch: java.io.IOException -> L7b
                com.jd.ad.sdk.jad_zi.jad_cp r4 = new com.jd.ad.sdk.jad_zi.jad_cp     // Catch: java.io.IOException -> L7b
                long r5 = r1.jad_bo     // Catch: java.io.EOFException -> L64 java.io.IOException -> L7b
                byte[] r5 = r1.jad_cp(r5)     // Catch: java.io.EOFException -> L64 java.io.IOException -> L7b
                r4.<init>(r5)     // Catch: java.io.IOException -> L7b
                r0[r3] = r4     // Catch: java.io.IOException -> L7b
                int r3 = r3 + 1
                goto La
            L64:
                r12 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch: java.io.IOException -> L7b
                r0.<init>(r12)     // Catch: java.io.IOException -> L7b
                throw r0     // Catch: java.io.IOException -> L7b
            L6b:
                com.jd.ad.sdk.jad_ud.jad_cp$jad_an r1 = new com.jd.ad.sdk.jad_ud.jad_cp$jad_an     // Catch: java.io.IOException -> L7b
                java.lang.Object r12 = r12.clone()     // Catch: java.io.IOException -> L7b
                java.lang.String[] r12 = (java.lang.String[]) r12     // Catch: java.io.IOException -> L7b
                com.jd.ad.sdk.jad_zi.jad_fs r0 = com.jd.ad.sdk.jad_zi.jad_fs.jad_an(r0)     // Catch: java.io.IOException -> L7b
                r1.<init>(r12, r0)     // Catch: java.io.IOException -> L7b
                return r1
            L7b:
                r12 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>(r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ud.jad_cp.jad_an.jad_an(java.lang.String[]):com.jd.ad.sdk.jad_ud.jad_cp$jad_an");
        }
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            jad_er[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = jad_er;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract int jad_an(jad_an jad_anVar);

    public final jad_bo jad_an(String str) {
        throw new jad_bo(str + " at path " + jad_fs());
    }

    public final void jad_an(int i10) {
        int i11 = this.jad_an;
        int[] iArr = this.jad_bo;
        if (i11 == iArr.length) {
            if (i11 == 256) {
                StringBuilder jad_an2 = jad_zm.jad_an("Nesting too deep at ");
                jad_an2.append(jad_fs());
                throw new com.jd.ad.sdk.jad_ud.jad_an(jad_an2.toString());
            }
            this.jad_bo = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.jad_cp;
            this.jad_cp = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.jad_dq;
            this.jad_dq = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.jad_bo;
        int i12 = this.jad_an;
        this.jad_an = i12 + 1;
        iArr3[i12] = i10;
    }

    public abstract void jad_bo();

    public abstract void jad_cp();

    public abstract void jad_dq();

    public abstract void jad_er();

    public final String jad_fs() {
        int i10 = this.jad_an;
        int[] iArr = this.jad_bo;
        String[] strArr = this.jad_cp;
        int[] iArr2 = this.jad_dq;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11];
            if (i12 == 1 || i12 == 2) {
                sb2.append('[');
                sb2.append(iArr2[i11]);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append('.');
                if (strArr[i11] != null) {
                    sb2.append(strArr[i11]);
                }
            }
        }
        return sb2.toString();
    }

    public abstract boolean jad_hu();

    public abstract double jad_iv();

    public abstract boolean jad_jt();

    public abstract int jad_jw();

    public abstract String jad_kx();

    public abstract String jad_ly();

    public abstract int jad_mz();

    public abstract void jad_na();

    public abstract void jad_ob();
}
