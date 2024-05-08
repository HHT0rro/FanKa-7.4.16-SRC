package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.RPJSON;
import com.alibaba.security.common.json.RPJSONException;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class JSONLexer {
    public static final char[] CA;
    public static final int END = 4;
    public static final char EOI = 26;
    public static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    public static final int[] digits;
    public static final boolean[] firstIdentifierFlags;
    public static final boolean[] identifierFlags;
    private static final ThreadLocal<char[]> sbufLocal;
    public int bp;
    public Calendar calendar;
    public char ch;
    public boolean disableCircularReferenceDetect;
    public int eofPos;
    public boolean exp;
    public int features;
    public long fieldHash;
    public boolean hasSpecial;
    public boolean isDouble;
    public final int len;
    public Locale locale;
    public int matchStat;
    public int np;
    public int pos;
    public char[] sbuf;
    public int sp;
    public String stringDefaultValue;
    public final String text;
    public TimeZone timeZone;
    public int token;

    static {
        int i10;
        try {
            i10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            i10 = -1;
        }
        char c4 = 0;
        V6 = i10 >= 23;
        sbufLocal = new ThreadLocal<>();
        digits = new int[103];
        for (int i11 = 48; i11 <= 57; i11++) {
            digits[i11] = i11 - 48;
        }
        for (int i12 = 97; i12 <= 102; i12++) {
            digits[i12] = (i12 - 97) + 10;
        }
        for (int i13 = 65; i13 <= 70; i13++) {
            digits[i13] = (i13 - 65) + 10;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i14 = 0; i14 < length; i14++) {
            IA[CA[i14]] = i14;
        }
        IA[61] = 0;
        firstIdentifierFlags = new boolean[256];
        char c10 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c10 >= zArr.length) {
                break;
            }
            if (c10 >= 'A' && c10 <= 'Z') {
                zArr[c10] = true;
            } else if (c10 >= 'a' && c10 <= 'z') {
                zArr[c10] = true;
            } else if (c10 == '_') {
                zArr[c10] = true;
            }
            c10 = (char) (c10 + 1);
        }
        identifierFlags = new boolean[256];
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c4 >= zArr2.length) {
                return;
            }
            if (c4 >= 'A' && c4 <= 'Z') {
                zArr2[c4] = true;
            } else if (c4 >= 'a' && c4 <= 'z') {
                zArr2[c4] = true;
            } else if (c4 == '_') {
                zArr2[c4] = true;
            } else if (c4 >= '0' && c4 <= '9') {
                zArr2[c4] = true;
            }
            c4 = (char) (c4 + 1);
        }
    }

    public JSONLexer(String str) {
        this(str, RPJSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean checkDate(char c4, char c10, char c11, char c12, char c13, char c14, int i10, int i11) {
        if ((c4 == '1' || c4 == '2') && c10 >= '0' && c10 <= '9' && c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9') {
            if (c13 == '0') {
                if (c14 < '1' || c14 > '9') {
                    return false;
                }
            } else if (c13 != '1' || (c14 != '0' && c14 != '1' && c14 != '2')) {
                return false;
            }
            if (i10 == 48) {
                return i11 >= 49 && i11 <= 57;
            }
            if (i10 != 49 && i10 != 50) {
                return i10 == 51 && (i11 == 48 || i11 == 49);
            }
            if (i11 >= 48 && i11 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001d, code lost:
    
        if (r5 <= '4') goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkTime(char r4, char r5, char r6, char r7, char r8, char r9) {
        /*
            r0 = 57
            r1 = 0
            r2 = 48
            if (r4 != r2) goto Lc
            if (r5 < r2) goto Lb
            if (r5 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r4 != r3) goto L15
            if (r5 < r2) goto L14
            if (r5 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r4 != r3) goto L42
            if (r5 < r2) goto L42
            r4 = 52
            if (r5 <= r4) goto L20
            goto L42
        L20:
            r4 = 53
            r5 = 54
            if (r6 < r2) goto L2d
            if (r6 > r4) goto L2d
            if (r7 < r2) goto L2c
            if (r7 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r6 != r5) goto L42
            if (r7 == r2) goto L32
            return r1
        L32:
            if (r8 < r2) goto L3b
            if (r8 > r4) goto L3b
            if (r9 < r2) goto L3a
            if (r9 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r8 != r5) goto L42
            if (r9 == r2) goto L40
            return r1
        L40:
            r4 = 1
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.checkTime(char, char, char, char, char, char):boolean");
    }

    public static final byte[] decodeFast(String str, int i10, int i11) {
        int i12;
        int i13 = 0;
        if (i11 == 0) {
            return new byte[0];
        }
        int i14 = (i10 + i11) - 1;
        while (i10 < i14 && IA[str.charAt(i10)] < 0) {
            i10++;
        }
        while (i14 > 0 && IA[str.charAt(i14)] < 0) {
            i14--;
        }
        int i15 = str.charAt(i14) == '=' ? str.charAt(i14 + (-1)) == '=' ? 2 : 1 : 0;
        int i16 = (i14 - i10) + 1;
        if (i11 > 76) {
            i12 = (str.charAt(76) == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i17 = (((i16 - i12) * 6) >> 3) - i15;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i18) {
            int[] iArr = IA;
            int i21 = i10 + 1;
            int i22 = i21 + 1;
            int i23 = (iArr[str.charAt(i10)] << 18) | (iArr[str.charAt(i21)] << 12);
            int i24 = i22 + 1;
            int i25 = i23 | (iArr[str.charAt(i22)] << 6);
            int i26 = i24 + 1;
            int i27 = i25 | iArr[str.charAt(i24)];
            int i28 = i19 + 1;
            bArr[i19] = (byte) (i27 >> 16);
            int i29 = i28 + 1;
            bArr[i28] = (byte) (i27 >> 8);
            int i30 = i29 + 1;
            bArr[i29] = (byte) i27;
            if (i12 <= 0 || (i20 = i20 + 1) != 19) {
                i10 = i26;
            } else {
                i10 = i26 + 2;
                i20 = 0;
            }
            i19 = i30;
        }
        if (i19 < i17) {
            int i31 = 0;
            while (i10 <= i14 - i15) {
                i13 |= IA[str.charAt(i10)] << (18 - (i31 * 6));
                i31++;
                i10++;
            }
            int i32 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i13 >> i32);
                i32 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    private int matchFieldHash(long j10) {
        char c4 = this.ch;
        int i10 = this.bp + 1;
        int i11 = 1;
        while (c4 != '\"' && c4 != '\'') {
            if (c4 <= ' ' && (c4 == ' ' || c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == '\f' || c4 == '\b')) {
                int i12 = i11 + 1;
                int i13 = this.bp + i11;
                c4 = i13 >= this.len ? (char) 26 : this.text.charAt(i13);
                i11 = i12;
            } else {
                this.fieldHash = 0L;
                this.matchStat = -2;
                return 0;
            }
        }
        long j11 = -3750763034362895579L;
        int i14 = i10;
        while (true) {
            if (i14 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i14);
            if (charAt == c4) {
                i11 += i14 - i10;
                break;
            }
            j11 = (j11 ^ charAt) * 1099511628211L;
            i14++;
        }
        if (j11 != j10) {
            this.fieldHash = j11;
            this.matchStat = -2;
            return 0;
        }
        int i15 = i11 + 1;
        int i16 = this.bp + i15;
        char charAt2 = i16 >= this.len ? (char) 26 : this.text.charAt(i16);
        while (charAt2 != ':') {
            if (charAt2 <= ' ' && (charAt2 == ' ' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == '\f' || charAt2 == '\b')) {
                int i17 = i15 + 1;
                int i18 = this.bp + i15;
                charAt2 = i18 >= this.len ? (char) 26 : this.text.charAt(i18);
                i15 = i17;
            } else {
                throw new RPJSONException("match feild error expect ':'");
            }
        }
        return i15 + 1;
    }

    private static String readString(char[] cArr, int i10) {
        int i11;
        char[] cArr2 = new char[i10];
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            char c4 = cArr[i12];
            if (c4 != '\\') {
                cArr2[i13] = c4;
                i13++;
            } else {
                i12++;
                char c10 = cArr[i12];
                if (c10 == '\"') {
                    i11 = i13 + 1;
                    cArr2[i13] = '\"';
                } else if (c10 != '\'') {
                    if (c10 != 'F') {
                        if (c10 == '\\') {
                            i11 = i13 + 1;
                            cArr2[i13] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        } else if (c10 == 'b') {
                            i11 = i13 + 1;
                            cArr2[i13] = '\b';
                        } else if (c10 != 'f') {
                            if (c10 == 'n') {
                                i11 = i13 + 1;
                                cArr2[i13] = '\n';
                            } else if (c10 == 'r') {
                                i11 = i13 + 1;
                                cArr2[i13] = CharUtils.CR;
                            } else if (c10 != 'x') {
                                switch (c10) {
                                    case '/':
                                        i11 = i13 + 1;
                                        cArr2[i13] = IOUtils.DIR_SEPARATOR_UNIX;
                                        break;
                                    case '0':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 0;
                                        break;
                                    case '1':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 1;
                                        break;
                                    case '2':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 2;
                                        break;
                                    case '3':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 3;
                                        break;
                                    case '4':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 4;
                                        break;
                                    case '5':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 5;
                                        break;
                                    case '6':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 6;
                                        break;
                                    case '7':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 7;
                                        break;
                                    default:
                                        switch (c10) {
                                            case 't':
                                                i11 = i13 + 1;
                                                cArr2[i13] = '\t';
                                                break;
                                            case 'u':
                                                i11 = i13 + 1;
                                                int i14 = i12 + 1;
                                                int i15 = i14 + 1;
                                                int i16 = i15 + 1;
                                                i12 = i16 + 1;
                                                cArr2[i13] = (char) Integer.parseInt(new String(new char[]{cArr[i14], cArr[i15], cArr[i16], cArr[i12]}), 16);
                                                break;
                                            case 'v':
                                                i11 = i13 + 1;
                                                cArr2[i13] = 11;
                                                break;
                                            default:
                                                throw new RPJSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i11 = i13 + 1;
                                int[] iArr = digits;
                                int i17 = i12 + 1;
                                int i18 = iArr[cArr[i17]] * 16;
                                i12 = i17 + 1;
                                cArr2[i13] = (char) (i18 + iArr[cArr[i12]]);
                            }
                        }
                    }
                    i11 = i13 + 1;
                    cArr2[i13] = '\f';
                } else {
                    i11 = i13 + 1;
                    cArr2[i13] = '\'';
                }
                i13 = i11;
            }
            i12++;
        }
        return new String(cArr2, 0, i13);
    }

    private void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if (stringVal.equals("null")) {
            this.token = 8;
            return;
        }
        if (stringVal.equals("true")) {
            this.token = 6;
            return;
        }
        if (stringVal.equals("false")) {
            this.token = 7;
            return;
        }
        if (stringVal.equals("new")) {
            this.token = 9;
            return;
        }
        if (stringVal.equals("undefined")) {
            this.token = 23;
            return;
        }
        if (stringVal.equals("Set")) {
            this.token = 21;
        } else if (stringVal.equals("TreeSet")) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    private void setCalendar(char c4, char c10, char c11, char c12, char c13, char c14, char c15, char c16) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c4 - '0') * 1000) + ((c10 - '0') * 100) + ((c11 - '0') * 10) + (c12 - '0'));
        this.calendar.set(2, (((c13 - '0') * 10) + (c14 - '0')) - 1);
        this.calendar.set(5, ((c15 - '0') * 10) + (c16 - '0'));
    }

    private final String subString(int i10, int i11) {
        char[] cArr = this.sbuf;
        if (i11 < cArr.length) {
            this.text.getChars(i10, i10 + i11, cArr, 0);
            return new String(this.sbuf, 0, i11);
        }
        char[] cArr2 = new char[i11];
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    public char charAt(int i10) {
        if (i10 >= this.len) {
            return (char) 26;
        }
        return this.text.charAt(i10);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z10) {
        if (z10) {
            this.features |= feature.mask;
        } else {
            this.features &= ~feature.mask;
        }
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z10 ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final Number decimalValue(boolean z10) {
        char[] cArr;
        boolean z11;
        int i10 = (this.np + this.sp) - 1;
        char charAt = i10 >= this.len ? (char) 26 : this.text.charAt(i10);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z10) {
                return decimalValue();
            }
            char charAt2 = this.text.charAt((this.np + this.sp) - 1);
            int i11 = this.sp;
            if (charAt2 == 'L' || charAt2 == 'S' || charAt2 == 'B' || charAt2 == 'F' || charAt2 == 'D') {
                i11--;
            }
            int i12 = this.np;
            char[] cArr2 = this.sbuf;
            int i13 = 0;
            if (i11 < cArr2.length) {
                this.text.getChars(i12, i12 + i11, cArr2, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr3 = new char[i11];
                this.text.getChars(i12, i12 + i11, cArr3, 0);
                cArr = cArr3;
            }
            if (i11 <= 9 && !this.exp) {
                char c4 = cArr[0];
                int i14 = 2;
                if (c4 == '-') {
                    c4 = cArr[1];
                    z11 = true;
                } else if (c4 == '+') {
                    c4 = cArr[1];
                    z11 = false;
                } else {
                    z11 = false;
                    i14 = 1;
                }
                int i15 = c4 - '0';
                while (i14 < i11) {
                    char c10 = cArr[i14];
                    if (c10 == '.') {
                        i13 = 1;
                    } else {
                        i15 = (i15 * 10) + (c10 - '0');
                        if (i13 != 0) {
                            i13 *= 10;
                        }
                    }
                    i14++;
                }
                double d10 = i15 / i13;
                if (z11) {
                    d10 = -d10;
                }
                return Double.valueOf(d10);
            }
            return Double.valueOf(Double.parseDouble(new String(cArr, 0, i11)));
        } catch (NumberFormatException e2) {
            throw new RPJSONException(e2.getMessage() + ", " + info());
        }
    }

    public String info() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pos ");
        sb2.append(this.bp);
        sb2.append(", json : ");
        sb2.append(this.len < 65536 ? this.text : this.text.substring(0, 65536));
        return sb2.toString();
    }

    public final int intValue() {
        int i10;
        boolean z10;
        int i11 = this.np;
        int i12 = this.sp + i11;
        int i13 = 0;
        if ((i11 >= this.len ? (char) 26 : this.text.charAt(i11)) == '-') {
            i10 = Integer.MIN_VALUE;
            i11++;
            z10 = true;
        } else {
            i10 = -2147483647;
            z10 = false;
        }
        if (i11 < i12) {
            i13 = -((i11 >= this.len ? (char) 26 : this.text.charAt(i11)) - '0');
            i11++;
        }
        while (i11 < i12) {
            int i14 = i11 + 1;
            char charAt = i11 >= this.len ? (char) 26 : this.text.charAt(i11);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i11 = i14;
                break;
            }
            int i15 = charAt - '0';
            if (i13 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i16 = i13 * 10;
            if (i16 < i10 + i15) {
                throw new NumberFormatException(numberString());
            }
            i13 = i16 - i15;
            i11 = i14;
        }
        if (!z10) {
            return -i13;
        }
        if (i11 > this.np + 1) {
            return i13;
        }
        throw new NumberFormatException(numberString());
    }

    public final Number integerValue() throws NumberFormatException {
        char c4;
        long j10;
        boolean z10;
        long j11;
        int i10 = this.np;
        int i11 = this.sp + i10;
        int i12 = i11 - 1;
        char charAt = i12 >= this.len ? (char) 26 : this.text.charAt(i12);
        if (charAt == 'B') {
            i11--;
            c4 = 'B';
        } else if (charAt == 'L') {
            i11--;
            c4 = 'L';
        } else if (charAt != 'S') {
            c4 = ' ';
        } else {
            i11--;
            c4 = 'S';
        }
        int i13 = this.np;
        if ((i13 >= this.len ? (char) 26 : this.text.charAt(i13)) == '-') {
            j10 = Long.MIN_VALUE;
            i10++;
            z10 = true;
        } else {
            j10 = -9223372036854775807L;
            z10 = false;
        }
        if (i10 < i11) {
            j11 = -((i10 >= this.len ? (char) 26 : this.text.charAt(i10)) - '0');
            i10++;
        } else {
            j11 = 0;
        }
        while (i10 < i11) {
            int i14 = i10 + 1;
            int charAt2 = (i10 >= this.len ? (char) 26 : this.text.charAt(i10)) - '0';
            if (j11 < -922337203685477580L) {
                return new BigInteger(numberString());
            }
            long j12 = j11 * 10;
            long j13 = charAt2;
            if (j12 < j10 + j13) {
                return new BigInteger(numberString());
            }
            j11 = j12 - j13;
            i10 = i14;
        }
        if (!z10) {
            long j14 = -j11;
            if (j14 > ZipUtils.UPPER_UNIXTIME_BOUND || c4 == 'L') {
                return Long.valueOf(j14);
            }
            if (c4 == 'S') {
                return Short.valueOf((short) j14);
            }
            if (c4 == 'B') {
                return Byte.valueOf((byte) j14);
            }
            return Integer.valueOf((int) j14);
        }
        if (i10 <= this.np + 1) {
            throw new NumberFormatException(numberString());
        }
        if (j11 < -2147483648L || c4 == 'L') {
            return Long.valueOf(j11);
        }
        if (c4 == 'S') {
            return Short.valueOf((short) j11);
        }
        if (c4 == 'B') {
            return Byte.valueOf((byte) j11);
        }
        return Integer.valueOf((int) j11);
    }

    public final boolean isBlankInput() {
        int i10 = 0;
        while (true) {
            char charAt = charAt(i10);
            boolean z10 = true;
            if (charAt == 26) {
                return true;
            }
            if (charAt > ' ' || (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t' && charAt != '\f' && charAt != '\b')) {
                z10 = false;
            }
            if (!z10) {
                return false;
            }
            i10++;
        }
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005e -> B:6:0x0026). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r2 = r13.charAt(r0)
            r3 = 1
            r4 = 45
            if (r2 != r4) goto L14
            r4 = -9223372036854775808
            int r0 = r0 + 1
            r2 = 1
            goto L1a
        L14:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r2 = 0
        L1a:
            if (r0 >= r1) goto L28
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L26:
            r0 = r6
            goto L2a
        L28:
            r7 = 0
        L2a:
            if (r0 >= r1) goto L75
            int r6 = r0 + 1
            int r9 = r13.len
            if (r0 < r9) goto L35
            r0 = 26
            goto L3b
        L35:
            java.lang.String r9 = r13.text
            char r0 = r9.charAt(r0)
        L3b:
            r9 = 76
            if (r0 == r9) goto L74
            r9 = 83
            if (r0 == r9) goto L74
            r9 = 66
            if (r0 != r9) goto L48
            goto L74
        L48:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L6a
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r4 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L60
            long r7 = r7 - r9
            goto L26
        L60:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L6a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L74:
            r0 = r6
        L75:
            if (r2 == 0) goto L87
            int r1 = r13.np
            int r1 = r1 + r3
            if (r0 <= r1) goto L7d
            return r7
        L7d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L87:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.longValue():long");
    }

    public boolean matchField(long j10) {
        char c4 = this.ch;
        int i10 = this.bp + 1;
        int i11 = 1;
        while (c4 != '\"' && c4 != '\'') {
            if (c4 <= ' ' && (c4 == ' ' || c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == '\f' || c4 == '\b')) {
                int i12 = i11 + 1;
                int i13 = this.bp + i11;
                c4 = i13 >= this.len ? (char) 26 : this.text.charAt(i13);
                i11 = i12;
            } else {
                this.fieldHash = 0L;
                this.matchStat = -2;
                return false;
            }
        }
        int i14 = i10;
        long j11 = -3750763034362895579L;
        while (true) {
            if (i14 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i14);
            if (charAt == c4) {
                i11 += (i14 - i10) + 1;
                break;
            }
            j11 = 1099511628211L * (j11 ^ charAt);
            i14++;
        }
        if (j11 != j10) {
            this.matchStat = -2;
            this.fieldHash = j11;
            return false;
        }
        int i15 = i11 + 1;
        int i16 = this.bp + i11;
        char charAt2 = i16 >= this.len ? (char) 26 : this.text.charAt(i16);
        while (charAt2 != ':') {
            if (charAt2 <= ' ' && (charAt2 == ' ' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == '\f' || charAt2 == '\b')) {
                int i17 = i15 + 1;
                int i18 = this.bp + i15;
                charAt2 = i18 >= this.len ? (char) 26 : this.text.charAt(i18);
                i15 = i17;
            } else {
                throw new RPJSONException("match feild error expect ':'");
            }
        }
        int i19 = this.bp + i15;
        char charAt3 = i19 >= this.len ? (char) 26 : this.text.charAt(i19);
        if (charAt3 == '{') {
            int i20 = i19 + 1;
            this.bp = i20;
            this.ch = i20 >= this.len ? (char) 26 : this.text.charAt(i20);
            this.token = 12;
        } else if (charAt3 == '[') {
            int i21 = i19 + 1;
            this.bp = i21;
            this.ch = i21 >= this.len ? (char) 26 : this.text.charAt(i21);
            this.token = 14;
        } else {
            this.bp = i19;
            this.ch = i19 >= this.len ? (char) 26 : this.text.charAt(i19);
            nextToken();
        }
        return true;
    }

    public char next() {
        int i10 = this.bp + 1;
        this.bp = i10;
        char charAt = i10 >= this.len ? (char) 26 : this.text.charAt(i10);
        this.ch = charAt;
        return charAt;
    }

    public final void nextIdent() {
        char c4;
        while (true) {
            c4 = this.ch;
            if (!(c4 <= ' ' && (c4 == ' ' || c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == '\f' || c4 == '\b'))) {
                break;
            } else {
                next();
            }
        }
        if (c4 != '_' && !Character.isLetter(c4)) {
            nextToken();
        } else {
            scanIdent();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        scanNumber();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0103, code lost:
    
        scanIdent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0106, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void nextToken() {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.nextToken():void");
    }

    public final void nextTokenWithChar(char c4) {
        this.sp = 0;
        while (true) {
            char c10 = this.ch;
            if (c10 == c4) {
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = i10 >= this.len ? (char) 26 : this.text.charAt(i10);
                nextToken();
                return;
            }
            if (c10 != ' ' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != '\f' && c10 != '\b') {
                throw new RPJSONException("not match " + c4 + " - " + this.ch);
            }
            next();
        }
    }

    public final String numberString() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i10 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        return subString(this.np, i10);
    }

    public boolean scanBoolean() {
        boolean z10 = false;
        int i10 = 1;
        if (this.text.startsWith("false", this.bp)) {
            i10 = 5;
        } else if (this.text.startsWith("true", this.bp)) {
            z10 = true;
            i10 = 4;
        } else {
            char c4 = this.ch;
            if (c4 == '1') {
                z10 = true;
            } else if (c4 != '0') {
                this.matchStat = -1;
                return false;
            }
        }
        int i11 = this.bp + i10;
        this.bp = i11;
        this.ch = charAt(i11);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanFieldBoolean(long r11) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.scanFieldBoolean(long):boolean");
    }

    public final double scanFieldDouble(long j10) {
        int i10;
        char charAt;
        int i11;
        double parseDouble;
        int i12;
        char charAt2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return ShadowDrawableWrapper.COS_45;
        }
        int i13 = matchFieldHash + 1;
        char charAt3 = charAt(this.bp + matchFieldHash);
        int i14 = this.bp;
        int i15 = (i14 + i13) - 1;
        boolean z10 = charAt3 == '-';
        if (z10) {
            char charAt4 = charAt(i14 + i13);
            i13++;
            charAt3 = charAt4;
        }
        if (charAt3 >= '0' && charAt3 <= '9') {
            int i16 = charAt3 - '0';
            while (true) {
                i10 = i13 + 1;
                charAt = charAt(this.bp + i13);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i16 = (i16 * 10) + (charAt - '0');
                i13 = i10;
            }
            if (charAt == '.') {
                int i17 = i10 + 1;
                char charAt5 = charAt(this.bp + i10);
                if (charAt5 < '0' || charAt5 > '9') {
                    this.matchStat = -1;
                    return ShadowDrawableWrapper.COS_45;
                }
                i16 = (i16 * 10) + (charAt5 - '0');
                int i18 = 10;
                while (true) {
                    i12 = i17 + 1;
                    charAt2 = charAt(this.bp + i17);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    i16 = (i16 * 10) + (charAt2 - '0');
                    i18 *= 10;
                    i17 = i12;
                }
                i10 = i12;
                i11 = i18;
                charAt = charAt2;
            } else {
                i11 = 1;
            }
            boolean z11 = charAt == 'e' || charAt == 'E';
            if (z11) {
                int i19 = i10 + 1;
                charAt = charAt(this.bp + i10);
                if (charAt == '+' || charAt == '-') {
                    int i20 = i19 + 1;
                    charAt = charAt(this.bp + i19);
                    i10 = i20;
                } else {
                    i10 = i19;
                }
                while (charAt >= '0' && charAt <= '9') {
                    int i21 = i10 + 1;
                    charAt = charAt(this.bp + i10);
                    i10 = i21;
                }
            }
            int i22 = ((this.bp + i10) - i15) - 1;
            if (z11 || i22 >= 10) {
                parseDouble = Double.parseDouble(subString(i15, i22));
            } else {
                parseDouble = i16 / i11;
                if (z10) {
                    parseDouble = -parseDouble;
                }
            }
            if (charAt == ',') {
                this.bp += i10 - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            }
            if (charAt == '}') {
                int i23 = i10 + 1;
                char charAt6 = charAt(this.bp + i10);
                if (charAt6 == ',') {
                    this.token = 16;
                    this.bp += i23 - 1;
                    next();
                } else if (charAt6 == ']') {
                    this.token = 15;
                    this.bp += i23 - 1;
                    next();
                } else if (charAt6 == '}') {
                    this.token = 13;
                    this.bp += i23 - 1;
                    next();
                } else if (charAt6 == 26) {
                    this.bp += i23 - 1;
                    this.token = 20;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return ShadowDrawableWrapper.COS_45;
                }
                this.matchStat = 4;
                return parseDouble;
            }
            this.matchStat = -1;
            return ShadowDrawableWrapper.COS_45;
        }
        this.matchStat = -1;
        return ShadowDrawableWrapper.COS_45;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x00d3, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00d5, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x021c, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x021e, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0116 -> B:66:0x0119). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double[] scanFieldDoubleArray(long r20) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.scanFieldDoubleArray(long):double[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x00e5, code lost:
    
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x00e7, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0290, code lost:
    
        r12 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0293, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double[][] scanFieldDoubleArray2(long r21) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.scanFieldDoubleArray2(long):double[][]");
    }

    public final float scanFieldFloat(long j10) {
        int i10;
        char charAt;
        int i11;
        float parseFloat;
        int i12;
        char charAt2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0.0f;
        }
        int i13 = matchFieldHash + 1;
        char charAt3 = charAt(this.bp + matchFieldHash);
        int i14 = this.bp;
        int i15 = (i14 + i13) - 1;
        boolean z10 = charAt3 == '-';
        if (z10) {
            char charAt4 = charAt(i14 + i13);
            i13++;
            charAt3 = charAt4;
        }
        if (charAt3 >= '0' && charAt3 <= '9') {
            int i16 = charAt3 - '0';
            while (true) {
                i10 = i13 + 1;
                charAt = charAt(this.bp + i13);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i16 = (i16 * 10) + (charAt - '0');
                i13 = i10;
            }
            if (charAt == '.') {
                int i17 = i10 + 1;
                char charAt5 = charAt(this.bp + i10);
                if (charAt5 < '0' || charAt5 > '9') {
                    this.matchStat = -1;
                    return 0.0f;
                }
                i16 = (i16 * 10) + (charAt5 - '0');
                int i18 = 10;
                while (true) {
                    i12 = i17 + 1;
                    charAt2 = charAt(this.bp + i17);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    i16 = (i16 * 10) + (charAt2 - '0');
                    i18 *= 10;
                    i17 = i12;
                }
                i10 = i12;
                i11 = i18;
                charAt = charAt2;
            } else {
                i11 = 1;
            }
            boolean z11 = charAt == 'e' || charAt == 'E';
            if (z11) {
                int i19 = i10 + 1;
                charAt = charAt(this.bp + i10);
                if (charAt == '+' || charAt == '-') {
                    int i20 = i19 + 1;
                    charAt = charAt(this.bp + i19);
                    i10 = i20;
                } else {
                    i10 = i19;
                }
                while (charAt >= '0' && charAt <= '9') {
                    int i21 = i10 + 1;
                    charAt = charAt(this.bp + i10);
                    i10 = i21;
                }
            }
            int i22 = ((this.bp + i10) - i15) - 1;
            if (z11 || i22 >= 10) {
                parseFloat = Float.parseFloat(subString(i15, i22));
            } else {
                parseFloat = i16 / i11;
                if (z10) {
                    parseFloat = -parseFloat;
                }
            }
            if (charAt == ',') {
                this.bp += i10 - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return parseFloat;
            }
            if (charAt == '}') {
                int i23 = i10 + 1;
                char charAt6 = charAt(this.bp + i10);
                if (charAt6 == ',') {
                    this.token = 16;
                    this.bp += i23 - 1;
                    next();
                } else if (charAt6 == ']') {
                    this.token = 15;
                    this.bp += i23 - 1;
                    next();
                } else if (charAt6 == '}') {
                    this.token = 13;
                    this.bp += i23 - 1;
                    next();
                } else if (charAt6 == 26) {
                    this.bp += i23 - 1;
                    this.token = 20;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
                this.matchStat = 4;
                return parseFloat;
            }
            this.matchStat = -1;
            return 0.0f;
        }
        this.matchStat = -1;
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x00d3, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00d5, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x021c, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x021e, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0116 -> B:66:0x0119). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] scanFieldFloatArray(long r20) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.scanFieldFloatArray(long):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x00e5, code lost:
    
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x00e7, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0290, code lost:
    
        r12 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0293, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[][] scanFieldFloatArray2(long r21) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.scanFieldFloatArray2(long):float[][]");
    }

    public int scanFieldInt(long j10) {
        boolean z10;
        int i10;
        char charAt;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i11 = matchFieldHash + 1;
        int i12 = this.bp + matchFieldHash;
        char charAt2 = i12 >= this.len ? (char) 26 : this.text.charAt(i12);
        if (charAt2 == '\"') {
            int i13 = i11 + 1;
            int i14 = this.bp + i11;
            charAt2 = i14 >= this.len ? (char) 26 : this.text.charAt(i14);
            i11 = i13;
            z10 = true;
        } else {
            z10 = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i15 = charAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            int i16 = this.bp + i11;
            charAt = i16 >= this.len ? (char) 26 : this.text.charAt(i16);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i15 = (i15 * 10) + (charAt - '0');
            i11 = i10;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == '\"') {
            if (!z10) {
                this.matchStat = -1;
                return 0;
            }
            int i17 = i10 + 1;
            int i18 = this.bp + i10;
            i10 = i17;
            charAt = i18 >= this.len ? (char) 26 : this.text.charAt(i18);
        }
        if (i15 < 0) {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == ',') {
            int i19 = this.bp + (i10 - 1) + 1;
            this.bp = i19;
            this.ch = i19 < this.len ? this.text.charAt(i19) : (char) 26;
            this.matchStat = 3;
            this.token = 16;
            return i15;
        }
        if (charAt == '}') {
            int i20 = i10 + 1;
            char charAt3 = charAt(this.bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                int i21 = this.bp + (i20 - 1) + 1;
                this.bp = i21;
                this.ch = i21 < this.len ? this.text.charAt(i21) : (char) 26;
            } else if (charAt3 == ']') {
                this.token = 15;
                int i22 = this.bp + (i20 - 1) + 1;
                this.bp = i22;
                this.ch = i22 < this.len ? this.text.charAt(i22) : (char) 26;
            } else if (charAt3 == '}') {
                this.token = 13;
                int i23 = this.bp + (i20 - 1) + 1;
                this.bp = i23;
                this.ch = i23 < this.len ? this.text.charAt(i23) : (char) 26;
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i20 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return i15;
        }
        this.matchStat = -1;
        return 0;
    }

    public final int[] scanFieldIntArray(long j10) {
        boolean z10;
        int[] iArr;
        int i10;
        int i11;
        char charAt;
        int i12;
        int i13;
        char charAt2;
        int[] iArr2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        int[] iArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i14 = matchFieldHash + 1;
        int i15 = this.bp + matchFieldHash;
        if ((i15 >= this.len ? (char) 26 : this.text.charAt(i15)) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i16 = i14 + 1;
        int i17 = this.bp + i14;
        char charAt3 = i17 >= this.len ? (char) 26 : this.text.charAt(i17);
        int[] iArr4 = new int[16];
        if (charAt3 == ']') {
            i13 = i16 + 1;
            int i18 = this.bp + i16;
            charAt2 = i18 >= this.len ? (char) 26 : this.text.charAt(i18);
            i12 = 0;
        } else {
            int i19 = 0;
            while (true) {
                if (charAt3 == '-') {
                    int i20 = i16 + 1;
                    int i21 = this.bp + i16;
                    charAt3 = i21 >= this.len ? (char) 26 : this.text.charAt(i21);
                    i16 = i20;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (charAt3 < '0') {
                    iArr = iArr3;
                    i10 = -1;
                    break;
                }
                if (charAt3 > '9') {
                    i10 = -1;
                    iArr = null;
                    break;
                }
                int i22 = charAt3 - '0';
                while (true) {
                    i11 = i16 + 1;
                    int i23 = this.bp + i16;
                    charAt = i23 >= this.len ? (char) 26 : this.text.charAt(i23);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i22 = (i22 * 10) + (charAt - '0');
                    i16 = i11;
                }
                if (i19 >= iArr4.length) {
                    int[] iArr5 = new int[(iArr4.length * 3) / 2];
                    System.arraycopy((Object) iArr4, 0, (Object) iArr5, 0, i19);
                    iArr4 = iArr5;
                }
                i12 = i19 + 1;
                if (z10) {
                    i22 = -i22;
                }
                iArr4[i19] = i22;
                if (charAt == ',') {
                    int i24 = i11 + 1;
                    int i25 = this.bp + i11;
                    i11 = i24;
                    iArr2 = null;
                    charAt = i25 >= this.len ? (char) 26 : this.text.charAt(i25);
                } else if (charAt == ']') {
                    i13 = i11 + 1;
                    int i26 = this.bp + i11;
                    charAt2 = i26 >= this.len ? (char) 26 : this.text.charAt(i26);
                } else {
                    iArr2 = null;
                }
                i19 = i12;
                charAt3 = charAt;
                iArr3 = iArr2;
                i16 = i11;
            }
            this.matchStat = i10;
            return iArr;
        }
        if (i12 != iArr4.length) {
            int[] iArr6 = new int[i12];
            System.arraycopy((Object) iArr4, 0, (Object) iArr6, 0, i12);
            iArr4 = iArr6;
        }
        if (charAt2 == ',') {
            this.bp += i13 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr4;
        }
        if (charAt2 == '}') {
            int i27 = i13 + 1;
            char charAt4 = charAt(this.bp + i13);
            if (charAt4 == ',') {
                this.token = 16;
                this.bp += i27 - 1;
                next();
            } else if (charAt4 == ']') {
                this.token = 15;
                this.bp += i27 - 1;
                next();
            } else if (charAt4 == '}') {
                this.token = 13;
                this.bp += i27 - 1;
                next();
            } else if (charAt4 == 26) {
                this.bp += i27 - 1;
                this.token = 20;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr4;
        }
        this.matchStat = -1;
        return null;
    }

    public long scanFieldLong(long j10) {
        int i10;
        char charAt;
        boolean z10 = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i11 = matchFieldHash + 1;
        int i12 = this.bp + matchFieldHash;
        char charAt2 = i12 >= this.len ? (char) 26 : this.text.charAt(i12);
        if (charAt2 == '\"') {
            int i13 = i11 + 1;
            int i14 = this.bp + i11;
            i11 = i13;
            charAt2 = i14 >= this.len ? (char) 26 : this.text.charAt(i14);
            z10 = true;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j11 = charAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            int i15 = this.bp + i11;
            charAt = i15 >= this.len ? (char) 26 : this.text.charAt(i15);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j11 = (j11 * 10) + (charAt - '0');
            i11 = i10;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == '\"') {
            if (!z10) {
                this.matchStat = -1;
                return 0L;
            }
            int i16 = i10 + 1;
            int i17 = this.bp + i10;
            i10 = i16;
            charAt = i17 >= this.len ? (char) 26 : this.text.charAt(i17);
        }
        if (j11 < 0) {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == ',') {
            int i18 = this.bp + (i10 - 1) + 1;
            this.bp = i18;
            this.ch = i18 >= this.len ? (char) 26 : this.text.charAt(i18);
            this.matchStat = 3;
            this.token = 16;
            return j11;
        }
        if (charAt == '}') {
            int i19 = i10 + 1;
            char charAt3 = charAt(this.bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                int i20 = this.bp + (i19 - 1) + 1;
                this.bp = i20;
                this.ch = i20 >= this.len ? (char) 26 : this.text.charAt(i20);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i21 = this.bp + (i19 - 1) + 1;
                this.bp = i21;
                this.ch = i21 >= this.len ? (char) 26 : this.text.charAt(i21);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i22 = this.bp + (i19 - 1) + 1;
                this.bp = i22;
                this.ch = i22 >= this.len ? (char) 26 : this.text.charAt(i22);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i19 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 4;
            return j11;
        }
        this.matchStat = -1;
        return 0L;
    }

    public String scanFieldString(long j10) {
        String str;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return null;
        }
        int i10 = matchFieldHash + 1;
        int i11 = this.bp + matchFieldHash;
        if (i11 < this.len) {
            if (this.text.charAt(i11) != '\"') {
                this.matchStat = -1;
                return this.stringDefaultValue;
            }
            int i12 = this.bp + i10;
            int indexOf = this.text.indexOf(34, i12);
            if (indexOf != -1) {
                if (V6) {
                    str = this.text.substring(i12, indexOf);
                } else {
                    int i13 = indexOf - i12;
                    str = new String(sub_chars(this.bp + i10, i13), 0, i13);
                }
                if (str.indexOf(92) != -1) {
                    boolean z10 = false;
                    while (true) {
                        int i14 = indexOf - 1;
                        int i15 = 0;
                        while (i14 >= 0 && this.text.charAt(i14) == '\\') {
                            i15++;
                            i14--;
                            z10 = true;
                        }
                        if (i15 % 2 == 0) {
                            break;
                        }
                        indexOf = this.text.indexOf(34, indexOf + 1);
                    }
                    int i16 = indexOf - i12;
                    char[] sub_chars = sub_chars(this.bp + i10, i16);
                    if (z10) {
                        str = readString(sub_chars, i16);
                    } else {
                        str = new String(sub_chars, 0, i16);
                        if (str.indexOf(92) != -1) {
                            str = readString(sub_chars, i16);
                        }
                    }
                }
                int i17 = indexOf + 1;
                char charAt = i17 >= this.len ? (char) 26 : this.text.charAt(i17);
                if (charAt == ',') {
                    int i18 = i17 + 1;
                    this.bp = i18;
                    this.ch = i18 < this.len ? this.text.charAt(i18) : (char) 26;
                    this.matchStat = 3;
                    this.token = 16;
                    return str;
                }
                if (charAt == '}') {
                    int i19 = i17 + 1;
                    char charAt2 = i19 >= this.len ? (char) 26 : this.text.charAt(i19);
                    if (charAt2 == ',') {
                        this.token = 16;
                        this.bp = i19;
                        next();
                    } else if (charAt2 == ']') {
                        this.token = 15;
                        this.bp = i19;
                        next();
                    } else if (charAt2 == '}') {
                        this.token = 13;
                        this.bp = i19;
                        next();
                    } else if (charAt2 == 26) {
                        this.token = 20;
                        this.bp = i19;
                        this.ch = (char) 26;
                    } else {
                        this.matchStat = -1;
                        return this.stringDefaultValue;
                    }
                    this.matchStat = 4;
                    return str;
                }
                this.matchStat = -1;
                return this.stringDefaultValue;
            }
            throw new RPJSONException("unclosed str, " + info());
        }
        throw new RPJSONException("unclosed str, " + info());
    }

    public long scanFieldSymbol(long j10) {
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i10 = matchFieldHash + 1;
        int i11 = this.bp + matchFieldHash;
        if ((i11 >= this.len ? (char) 26 : this.text.charAt(i11)) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j11 = -3750763034362895579L;
        while (true) {
            int i12 = i10 + 1;
            int i13 = this.bp + i10;
            char charAt = i13 >= this.len ? (char) 26 : this.text.charAt(i13);
            if (charAt == '\"') {
                int i14 = i12 + 1;
                int i15 = this.bp + i12;
                char charAt2 = i15 >= this.len ? (char) 26 : this.text.charAt(i15);
                if (charAt2 == ',') {
                    int i16 = this.bp + (i14 - 1) + 1;
                    this.bp = i16;
                    this.ch = i16 < this.len ? this.text.charAt(i16) : (char) 26;
                    this.matchStat = 3;
                    return j11;
                }
                if (charAt2 == '}') {
                    int i17 = i14 + 1;
                    int i18 = this.bp + i14;
                    char charAt3 = i18 >= this.len ? (char) 26 : this.text.charAt(i18);
                    if (charAt3 == ',') {
                        this.token = 16;
                        this.bp += i17 - 1;
                        next();
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        this.bp += i17 - 1;
                        next();
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        this.bp += i17 - 1;
                        next();
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i17 - 1;
                        this.ch = (char) 26;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j11;
                }
                this.matchStat = -1;
                return 0L;
            }
            j11 = (j11 ^ charAt) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i10 = i12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanISO8601DateIfMatch(boolean r36) {
        /*
            Method dump skipped, instructions count: 1613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.scanISO8601DateIfMatch(boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c3, code lost:
    
        if (r0 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c6, code lost:
    
        return -r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long scanLongValue() {
        /*
            r13 = this;
            r0 = 0
            r13.np = r0
            char r1 = r13.ch
            r2 = 1
            r3 = 45
            if (r1 != r3) goto L3f
            r0 = -9223372036854775808
            r3 = 0
            int r3 = r3 + r2
            r13.np = r3
            int r3 = r13.bp
            int r3 = r3 + r2
            r13.bp = r3
            int r4 = r13.len
            if (r3 >= r4) goto L24
            java.lang.String r4 = r13.text
            char r3 = r4.charAt(r3)
            r13.ch = r3
            r3 = r0
            r0 = 1
            goto L44
        L24:
            com.alibaba.security.common.json.RPJSONException r0 = new com.alibaba.security.common.json.RPJSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "syntax error, "
            r1.append(r2)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L3f:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L44:
            r5 = 0
        L46:
            char r1 = r13.ch
            r7 = 48
            if (r1 < r7) goto Lc3
            r7 = 57
            if (r1 > r7) goto Lc3
            int r1 = r1 + (-48)
            r7 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            java.lang.String r9 = ", "
            java.lang.String r10 = "error long value, "
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 < 0) goto La4
            r7 = 10
            long r5 = r5 * r7
            long r7 = (long) r1
            long r11 = r3 + r7
            int r1 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r1 < 0) goto L85
            long r5 = r5 - r7
            int r1 = r13.np
            int r1 = r1 + r2
            r13.np = r1
            int r1 = r13.bp
            int r1 = r1 + r2
            r13.bp = r1
            int r7 = r13.len
            if (r1 < r7) goto L7c
            r1 = 26
            goto L82
        L7c:
            java.lang.String r7 = r13.text
            char r1 = r7.charAt(r1)
        L82:
            r13.ch = r1
            goto L46
        L85:
            com.alibaba.security.common.json.RPJSONException r0 = new com.alibaba.security.common.json.RPJSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            r1.append(r5)
            r1.append(r9)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La4:
            com.alibaba.security.common.json.RPJSONException r0 = new com.alibaba.security.common.json.RPJSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            r1.append(r5)
            r1.append(r9)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        Lc3:
            if (r0 != 0) goto Lc6
            long r5 = -r5
        Lc6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.scanLongValue():long");
    }

    public final void scanNumber() {
        char c4;
        char c10;
        int i10 = this.bp;
        this.np = i10;
        this.exp = false;
        if (this.ch == '-') {
            this.sp++;
            int i11 = i10 + 1;
            this.bp = i11;
            this.ch = i11 >= this.len ? (char) 26 : this.text.charAt(i11);
        }
        while (true) {
            c4 = this.ch;
            if (c4 < '0' || c4 > '9') {
                break;
            }
            this.sp++;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.ch = i12 >= this.len ? (char) 26 : this.text.charAt(i12);
        }
        this.isDouble = false;
        if (c4 == '.') {
            this.sp++;
            int i13 = this.bp + 1;
            this.bp = i13;
            this.ch = i13 >= this.len ? (char) 26 : this.text.charAt(i13);
            this.isDouble = true;
            while (true) {
                char c11 = this.ch;
                if (c11 < '0' || c11 > '9') {
                    break;
                }
                this.sp++;
                int i14 = this.bp + 1;
                this.bp = i14;
                this.ch = i14 >= this.len ? (char) 26 : this.text.charAt(i14);
            }
        }
        char c12 = this.ch;
        if (c12 == 'L') {
            this.sp++;
            next();
        } else if (c12 == 'S') {
            this.sp++;
            next();
        } else if (c12 == 'B') {
            this.sp++;
            next();
        } else if (c12 == 'F') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c12 == 'D') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c12 == 'e' || c12 == 'E') {
            this.sp++;
            int i15 = this.bp + 1;
            this.bp = i15;
            char charAt = i15 >= this.len ? (char) 26 : this.text.charAt(i15);
            this.ch = charAt;
            if (charAt == '+' || charAt == '-') {
                this.sp++;
                int i16 = this.bp + 1;
                this.bp = i16;
                this.ch = i16 >= this.len ? (char) 26 : this.text.charAt(i16);
            }
            while (true) {
                c10 = this.ch;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                this.sp++;
                int i17 = this.bp + 1;
                this.bp = i17;
                this.ch = i17 >= this.len ? (char) 26 : this.text.charAt(i17);
            }
            if (c10 == 'D' || c10 == 'F') {
                this.sp++;
                next();
            }
            this.exp = true;
            this.isDouble = true;
        }
        if (this.isDouble) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0225 A[Catch: NumberFormatException -> 0x0255, TryCatch #0 {NumberFormatException -> 0x0255, blocks: (B:84:0x01fd, B:89:0x0209, B:91:0x020d, B:95:0x021e, B:96:0x0215, B:98:0x021c, B:104:0x0225, B:107:0x022b, B:109:0x0230, B:112:0x0236, B:114:0x0206, B:115:0x023b, B:117:0x0245, B:120:0x024b), top: B:81:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0230 A[Catch: NumberFormatException -> 0x0255, TryCatch #0 {NumberFormatException -> 0x0255, blocks: (B:84:0x01fd, B:89:0x0209, B:91:0x020d, B:95:0x021e, B:96:0x0215, B:98:0x021c, B:104:0x0225, B:107:0x022b, B:109:0x0230, B:112:0x0236, B:114:0x0206, B:115:0x023b, B:117:0x0245, B:120:0x024b), top: B:81:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0245 A[Catch: NumberFormatException -> 0x0255, TryCatch #0 {NumberFormatException -> 0x0255, blocks: (B:84:0x01fd, B:89:0x0209, B:91:0x020d, B:95:0x021e, B:96:0x0215, B:98:0x021c, B:104:0x0225, B:107:0x022b, B:109:0x0230, B:112:0x0236, B:114:0x0206, B:115:0x023b, B:117:0x0245, B:120:0x024b), top: B:81:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x024b A[Catch: NumberFormatException -> 0x0255, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0255, blocks: (B:84:0x01fd, B:89:0x0209, B:91:0x020d, B:95:0x021e, B:96:0x0215, B:98:0x021c, B:104:0x0225, B:107:0x022b, B:109:0x0230, B:112:0x0236, B:114:0x0206, B:115:0x023b, B:117:0x0245, B:120:0x024b), top: B:81:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020d A[Catch: NumberFormatException -> 0x0255, TryCatch #0 {NumberFormatException -> 0x0255, blocks: (B:84:0x01fd, B:89:0x0209, B:91:0x020d, B:95:0x021e, B:96:0x0215, B:98:0x021c, B:104:0x0225, B:107:0x022b, B:109:0x0230, B:112:0x0236, B:114:0x0206, B:115:0x023b, B:117:0x0245, B:120:0x024b), top: B:81:0x01f9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Number scanNumberValue() {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JSONLexer.scanNumberValue():java.lang.Number");
    }

    public final void scanString() {
        char c4 = this.ch;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c4, i10);
        if (indexOf != -1) {
            int i11 = indexOf - i10;
            char[] sub_chars = sub_chars(this.bp + 1, i11);
            boolean z10 = false;
            while (i11 > 0 && sub_chars[i11 - 1] == '\\') {
                int i12 = 1;
                for (int i13 = i11 - 2; i13 >= 0 && sub_chars[i13] == '\\'; i13--) {
                    i12++;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c4, indexOf + 1);
                int i14 = (indexOf2 - indexOf) + i11;
                if (i14 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i14) {
                        length = i14;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy((Object) sub_chars, 0, (Object) cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i11);
                indexOf = indexOf2;
                i11 = i14;
                z10 = true;
            }
            if (!z10) {
                for (int i15 = 0; i15 < i11; i15++) {
                    if (sub_chars[i15] == '\\') {
                        z10 = true;
                    }
                }
            }
            this.sbuf = sub_chars;
            this.sp = i11;
            this.np = this.bp;
            this.hasSpecial = z10;
            int i16 = indexOf + 1;
            this.bp = i16;
            this.ch = i16 >= this.len ? (char) 26 : this.text.charAt(i16);
            this.token = 4;
            return;
        }
        throw new RPJSONException("unclosed str, " + info());
    }

    public String scanStringValue(char c4) {
        String str;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c4, i10);
        if (indexOf != -1) {
            if (V6) {
                str = this.text.substring(i10, indexOf);
            } else {
                int i11 = indexOf - i10;
                str = new String(sub_chars(this.bp + 1, i11), 0, i11);
            }
            if (str.indexOf(92) != -1) {
                while (true) {
                    int i12 = 0;
                    for (int i13 = indexOf - 1; i13 >= 0 && this.text.charAt(i13) == '\\'; i13--) {
                        i12++;
                    }
                    if (i12 % 2 == 0) {
                        break;
                    }
                    indexOf = this.text.indexOf(c4, indexOf + 1);
                }
                int i14 = indexOf - i10;
                str = readString(sub_chars(this.bp + 1, i14), i14);
            }
            int i15 = indexOf + 1;
            this.bp = i15;
            this.ch = i15 >= this.len ? (char) 26 : this.text.charAt(i15);
            return str;
        }
        throw new RPJSONException("unclosed str, " + info());
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c4;
        while (true) {
            c4 = this.ch;
            if (c4 != ' ' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != '\f' && c4 != '\b') {
                break;
            }
            next();
        }
        if (c4 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c4 == '\'') {
            return scanSymbol(symbolTable, '\'');
        }
        if (c4 == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c4 == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c4 == 26) {
            this.token = 20;
            return null;
        }
        return scanSymbolUnQuoted(symbolTable);
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i10 = this.ch;
        boolean[] zArr = firstIdentifierFlags;
        if (i10 >= zArr.length || zArr[i10]) {
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                boolean[] zArr2 = identifierFlags;
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i10 = (i10 * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp == 4 && this.text.startsWith("null", this.np)) {
                return null;
            }
            return symbolTable.addSymbol(this.text, this.np, this.sp, i10);
        }
        throw new RPJSONException("illegal identifier : " + this.ch + ", " + info());
    }

    public void setTime(char c4, char c10, char c11, char c12, char c13, char c14) {
        this.calendar.set(11, ((c4 - '0') * 10) + (c10 - '0'));
        this.calendar.set(12, ((c11 - '0') * 10) + (c12 - '0'));
        this.calendar.set(13, ((c13 - '0') * 10) + (c14 - '0'));
    }

    public void setTimeZone(char c4, char c10, char c11) {
        int i10 = (((c10 - '0') * 10) + (c11 - '0')) * SdkConfigData.DEFAULT_REQUEST_INTERVAL * 1000;
        if (c4 == '-') {
            i10 = -i10;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i10) {
            String[] availableIDs = TimeZone.getAvailableIDs(i10);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    public void skipComment() {
        next();
        char c4 = this.ch;
        if (c4 != '/') {
            if (c4 == '*') {
                next();
                while (true) {
                    char c10 = this.ch;
                    if (c10 == 26) {
                        return;
                    }
                    if (c10 == '*') {
                        next();
                        if (this.ch == '/') {
                            next();
                            return;
                        }
                    } else {
                        next();
                    }
                }
            } else {
                throw new RPJSONException("invalid comment");
            }
        }
        do {
            next();
        } while (this.ch != '\n');
        next();
    }

    public final void skipWhitespace() {
        while (true) {
            char c4 = this.ch;
            if (c4 > '/') {
                return;
            }
            if (c4 == ' ' || c4 == '\r' || c4 == '\n' || c4 == '\t' || c4 == '\f' || c4 == '\b') {
                next();
            } else if (c4 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringVal() {
        if (this.hasSpecial) {
            return readString(this.sbuf, this.sp);
        }
        return subString(this.np + 1, this.sp);
    }

    public final char[] sub_chars(int i10, int i11) {
        char[] cArr = this.sbuf;
        if (i11 < cArr.length) {
            this.text.getChars(i10, i11 + i10, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i11];
        this.sbuf = cArr2;
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }

    public JSONLexer(char[] cArr, int i10) {
        this(cArr, i10, RPJSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(char[] cArr, int i10, int i11) {
        this(new String(cArr, 0, i10), i11);
    }

    public JSONLexer(String str, int i10) {
        this.features = RPJSON.DEFAULT_PARSER_FEATURE;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = RPJSON.defaultTimeZone;
        this.locale = RPJSON.defaultLocale;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i10;
        this.text = str;
        int length = str.length();
        this.len = length;
        int i11 = (-1) + 1;
        this.bp = i11;
        char charAt = i11 >= length ? (char) 26 : str.charAt(i11);
        this.ch = charAt;
        if (charAt == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i10) != 0 ? "" : null;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i10) != 0;
    }

    public String scanSymbol(SymbolTable symbolTable, char c4) {
        String readString;
        int i10 = this.bp + 1;
        int indexOf = this.text.indexOf(c4, i10);
        if (indexOf != -1) {
            int i11 = indexOf - i10;
            char[] sub_chars = sub_chars(this.bp + 1, i11);
            boolean z10 = false;
            while (i11 > 0 && sub_chars[i11 - 1] == '\\') {
                int i12 = 1;
                for (int i13 = i11 - 2; i13 >= 0 && sub_chars[i13] == '\\'; i13--) {
                    i12++;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c4, indexOf + 1);
                int i14 = (indexOf2 - indexOf) + i11;
                if (i14 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i14) {
                        length = i14;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy((Object) sub_chars, 0, (Object) cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i11);
                indexOf = indexOf2;
                i11 = i14;
                z10 = true;
            }
            if (z10) {
                readString = readString(sub_chars, i11);
            } else {
                int i15 = 0;
                for (int i16 = 0; i16 < i11; i16++) {
                    char c10 = sub_chars[i16];
                    i15 = (i15 * 31) + c10;
                    if (c10 == '\\') {
                        z10 = true;
                    }
                }
                if (z10) {
                    readString = readString(sub_chars, i11);
                } else {
                    readString = i11 < 20 ? symbolTable.addSymbol(sub_chars, 0, i11, i15) : new String(sub_chars, 0, i11);
                }
            }
            int i17 = indexOf + 1;
            this.bp = i17;
            this.ch = i17 >= this.len ? (char) 26 : this.text.charAt(i17);
            return readString;
        }
        throw new RPJSONException("unclosed str, " + info());
    }

    public final BigDecimal decimalValue() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i10 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        int i11 = this.np;
        char[] cArr = this.sbuf;
        if (i10 < cArr.length) {
            this.text.getChars(i11, i11 + i10, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i10);
        }
        char[] cArr2 = new char[i10];
        this.text.getChars(i11, i10 + i11, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0029. Please report as an issue. */
    public final void nextToken(int i10) {
        this.sp = 0;
        while (true) {
            if (i10 != 2) {
                if (i10 == 4) {
                    char c4 = this.ch;
                    if (c4 == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    } else if (c4 >= '0' && c4 <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                        return;
                    } else if (c4 == '{') {
                        this.token = 12;
                        int i11 = this.bp + 1;
                        this.bp = i11;
                        this.ch = i11 < this.len ? this.text.charAt(i11) : (char) 26;
                        return;
                    }
                } else if (i10 == 12) {
                    char c10 = this.ch;
                    if (c10 == '{') {
                        this.token = 12;
                        int i12 = this.bp + 1;
                        this.bp = i12;
                        this.ch = i12 < this.len ? this.text.charAt(i12) : (char) 26;
                        return;
                    }
                    if (c10 == '[') {
                        this.token = 14;
                        int i13 = this.bp + 1;
                        this.bp = i13;
                        this.ch = i13 < this.len ? this.text.charAt(i13) : (char) 26;
                        return;
                    }
                } else if (i10 != 18) {
                    if (i10 != 20) {
                        switch (i10) {
                            case 14:
                                char c11 = this.ch;
                                if (c11 == '[') {
                                    this.token = 14;
                                    next();
                                    return;
                                } else if (c11 == '{') {
                                    this.token = 12;
                                    next();
                                    return;
                                }
                                break;
                            case 15:
                                if (this.ch == ']') {
                                    this.token = 15;
                                    next();
                                    return;
                                }
                                break;
                            case 16:
                                char c12 = this.ch;
                                if (c12 == ',') {
                                    this.token = 16;
                                    int i14 = this.bp + 1;
                                    this.bp = i14;
                                    this.ch = i14 < this.len ? this.text.charAt(i14) : (char) 26;
                                    return;
                                }
                                if (c12 == '}') {
                                    this.token = 13;
                                    int i15 = this.bp + 1;
                                    this.bp = i15;
                                    this.ch = i15 < this.len ? this.text.charAt(i15) : (char) 26;
                                    return;
                                }
                                if (c12 == ']') {
                                    this.token = 15;
                                    int i16 = this.bp + 1;
                                    this.bp = i16;
                                    this.ch = i16 < this.len ? this.text.charAt(i16) : (char) 26;
                                    return;
                                }
                                if (c12 == 26) {
                                    this.token = 20;
                                    return;
                                }
                                break;
                        }
                    }
                    if (this.ch == 26) {
                        this.token = 20;
                        return;
                    }
                } else {
                    nextIdent();
                    return;
                }
            } else {
                char c13 = this.ch;
                if (c13 >= '0' && c13 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                if (c13 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c13 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c13 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            }
            char c14 = this.ch;
            if (c14 != ' ' && c14 != '\n' && c14 != '\r' && c14 != '\t' && c14 != '\f' && c14 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }
}
