package com.alibaba.fastjson.asm;

import com.baidu.mobads.sdk.api.IAdInterListener;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Type {
    private final char[] buf;
    private final int len;
    private final int off;
    public final int sort;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    private Type(int i10, char[] cArr, int i11, int i12) {
        this.sort = i10;
        this.buf = cArr;
        this.off = i11;
        this.len = i12;
    }

    public static Type[] getArgumentTypes(String str) {
        char[] charArray = str.toCharArray();
        int i10 = 1;
        int i11 = 1;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 1;
            char c4 = charArray[i11];
            if (c4 == ')') {
                break;
            }
            if (c4 == 'L') {
                while (true) {
                    i11 = i13 + 1;
                    if (charArray[i13] == ';') {
                        break;
                    }
                    i13 = i11;
                }
                i12++;
            } else {
                if (c4 != '[') {
                    i12++;
                }
                i11 = i13;
            }
        }
        Type[] typeArr = new Type[i12];
        int i14 = 0;
        while (charArray[i10] != ')') {
            typeArr[i14] = getType(charArray, i10);
            i10 += typeArr[i14].len + (typeArr[i14].sort == 10 ? 2 : 0);
            i14++;
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i10;
        int i11 = 1;
        int i12 = 1;
        int i13 = 1;
        while (true) {
            i10 = i12 + 1;
            char charAt = str.charAt(i12);
            if (charAt == ')') {
                break;
            }
            if (charAt == 'L') {
                while (true) {
                    i12 = i10 + 1;
                    if (str.charAt(i10) == ';') {
                        break;
                    }
                    i10 = i12;
                }
                i13++;
            } else {
                i13 = (charAt == 'D' || charAt == 'J') ? i13 + 2 : i13 + 1;
                i12 = i10;
            }
        }
        char charAt2 = str.charAt(i10);
        int i14 = i13 << 2;
        if (charAt2 == 'V') {
            i11 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i11 = 2;
        }
        return i14 | i11;
    }

    private int getDimensions() {
        int i10 = 1;
        while (this.buf[this.off + i10] == '[') {
            i10++;
        }
        return i10;
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb2 = new StringBuilder(getType(this.buf, this.off + getDimensions()).getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    sb2.append("[]");
                }
                return sb2.toString();
            default:
                return new String(this.buf, this.off, this.len).replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
        }
    }

    public String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
    
        if (r6[r4] == 'L') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0051, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:
    
        if (r6[r7 + r0] == ';') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0062, code lost:
    
        return new com.alibaba.fastjson.asm.Type(9, r6, r7, r0 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.alibaba.fastjson.asm.Type getType(char[] r6, int r7) {
        /*
            char r0 = r6[r7]
            r1 = 70
            if (r0 == r1) goto L72
            r1 = 83
            if (r0 == r1) goto L6f
            r1 = 86
            if (r0 == r1) goto L6c
            r1 = 73
            if (r0 == r1) goto L69
            r1 = 74
            if (r0 == r1) goto L66
            r1 = 90
            if (r0 == r1) goto L63
            r1 = 59
            r2 = 91
            r3 = 1
            if (r0 == r2) goto L41
            switch(r0) {
                case 66: goto L3e;
                case 67: goto L3b;
                case 68: goto L38;
                default: goto L24;
            }
        L24:
            r0 = 1
        L25:
            int r2 = r7 + r0
            char r2 = r6[r2]
            if (r2 == r1) goto L2e
            int r0 = r0 + 1
            goto L25
        L2e:
            com.alibaba.fastjson.asm.Type r1 = new com.alibaba.fastjson.asm.Type
            r2 = 10
            int r7 = r7 + r3
            int r0 = r0 - r3
            r1.<init>(r2, r6, r7, r0)
            return r1
        L38:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.DOUBLE_TYPE
            return r6
        L3b:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.CHAR_TYPE
            return r6
        L3e:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.BYTE_TYPE
            return r6
        L41:
            r0 = 1
        L42:
            int r4 = r7 + r0
            char r5 = r6[r4]
            if (r5 != r2) goto L4b
            int r0 = r0 + 1
            goto L42
        L4b:
            char r2 = r6[r4]
            r4 = 76
            if (r2 != r4) goto L5a
        L51:
            int r0 = r0 + 1
            int r2 = r7 + r0
            char r2 = r6[r2]
            if (r2 == r1) goto L5a
            goto L51
        L5a:
            com.alibaba.fastjson.asm.Type r1 = new com.alibaba.fastjson.asm.Type
            r2 = 9
            int r0 = r0 + r3
            r1.<init>(r2, r6, r7, r0)
            return r1
        L63:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.BOOLEAN_TYPE
            return r6
        L66:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.LONG_TYPE
            return r6
        L69:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.INT_TYPE
            return r6
        L6c:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.VOID_TYPE
            return r6
        L6f:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.SHORT_TYPE
            return r6
        L72:
            com.alibaba.fastjson.asm.Type r6 = com.alibaba.fastjson.asm.Type.FLOAT_TYPE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.asm.Type.getType(char[], int):com.alibaba.fastjson.asm.Type");
    }
}
