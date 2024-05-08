package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.zip.ZipUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    public static final int INT_MULTMIN_RADIX_TEN = -214748364;
    public static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    public int bp;
    public char ch;
    public int eofPos;
    public int features;
    public boolean hasSpecial;
    public int np;
    public int pos;
    public char[] sbuf;
    public int sp;
    public String stringDefaultValue;
    public int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    public static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    public static final int[] digits = new int[103];
    public Calendar calendar = null;
    public TimeZone timeZone = JSON.defaultTimeZone;
    public Locale locale = JSON.defaultLocale;
    public int matchStat = 0;

    static {
        for (int i10 = 48; i10 <= 57; i10++) {
            digits[i10] = i10 - 48;
        }
        for (int i11 = 97; i11 <= 102; i11++) {
            digits[i11] = (i11 - 97) + 10;
        }
        for (int i12 = 65; i12 <= 70; i12++) {
            digits[i12] = (i12 - 65) + 10;
        }
    }

    public JSONLexerBase(int i10) {
        this.stringDefaultValue = null;
        this.features = i10;
        if ((i10 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c4) {
        return c4 <= ' ' && (c4 == ' ' || c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == '\f' || c4 == '\b');
    }

    public static String readString(char[] cArr, int i10) {
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
                                                throw new JSONException("unclosed.str.lit");
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

    /* JADX WARN: Code restructure failed: missing block: B:89:0x014a, code lost:
    
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r1 + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void scanStringSingleQuote() {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringSingleQuote():void");
    }

    public abstract String addSymbol(int i10, int i11, int i12, SymbolTable symbolTable);

    public abstract void arrayCopy(int i10, char[] cArr, int i11, int i12);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i10);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z10) {
        int config = Feature.config(this.features, feature, z10);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public abstract void copyTo(int i10, int i11, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z10) {
        char charAt = charAt((this.np + this.sp) - 1);
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
            return Double.valueOf(doubleValue());
        } catch (NumberFormatException e2) {
            throw new JSONException(e2.getMessage() + ", " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat != 0.0f && parseFloat != Float.POSITIVE_INFINITY) || (charAt = numberString.charAt(0)) <= '0' || charAt > '9') {
            return parseFloat;
        }
        throw new JSONException("float overflow : " + numberString);
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        return this.features;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c4, int i10);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i10;
        boolean z10;
        int i11 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i12 = this.np;
        int i13 = this.sp + i12;
        if (charAt(i12) == '-') {
            i10 = Integer.MIN_VALUE;
            i12++;
            z10 = true;
        } else {
            i10 = -2147483647;
            z10 = false;
        }
        if (i12 < i13) {
            i11 = -(charAt(i12) - '0');
            i12++;
        }
        while (i12 < i13) {
            int i14 = i12 + 1;
            char charAt = charAt(i12);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i12 = i14;
                break;
            }
            int i15 = charAt - '0';
            if (i11 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i16 = i11 * 10;
            if (i16 < i10 + i15) {
                throw new NumberFormatException(numberString());
            }
            i11 = i16 - i15;
            i12 = i14;
        }
        if (!z10) {
            return -i11;
        }
        if (i12 > this.np + 1) {
            return i11;
        }
        throw new NumberFormatException(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long j10;
        long j11;
        boolean z10 = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i10 = this.np;
        int i11 = this.sp + i10;
        char c4 = ' ';
        char charAt = charAt(i11 - 1);
        if (charAt == 'B') {
            i11--;
            c4 = 'B';
        } else if (charAt == 'L') {
            i11--;
            c4 = 'L';
        } else if (charAt == 'S') {
            i11--;
            c4 = 'S';
        }
        if (charAt(this.np) == '-') {
            j10 = Long.MIN_VALUE;
            i10++;
            z10 = true;
        } else {
            j10 = -9223372036854775807L;
        }
        long j12 = -922337203685477580L;
        if (i10 < i11) {
            j11 = -(charAt(i10) - '0');
            i10++;
        } else {
            j11 = 0;
        }
        while (i10 < i11) {
            int i12 = i10 + 1;
            int charAt2 = charAt(i10) - '0';
            if (j11 < j12) {
                return new BigInteger(numberString());
            }
            long j13 = j11 * 10;
            long j14 = charAt2;
            if (j13 < j10 + j14) {
                return new BigInteger(numberString());
            }
            j11 = j13 - j14;
            i10 = i12;
            j12 = -922337203685477580L;
        }
        if (!z10) {
            long j15 = -j11;
            if (j15 > ZipUtils.UPPER_UNIXTIME_BOUND || c4 == 'L') {
                return Long.valueOf(j15);
            }
            if (c4 == 'S') {
                return Short.valueOf((short) j15);
            }
            if (c4 == 'B') {
                return Byte.valueOf((byte) j15);
            }
            return Integer.valueOf((int) j15);
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i10 = 0;
        while (true) {
            char charAt = charAt(i10);
            if (charAt == 26) {
                this.token = 20;
                return true;
            }
            if (!isWhitespace(charAt)) {
                return false;
            }
            i10++;
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:10:0x0032). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r15 = this;
            int r0 = r15.np
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L8
            r15.np = r1
        L8:
            int r0 = r15.np
            int r2 = r15.sp
            int r2 = r2 + r0
            char r3 = r15.charAt(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1c
            r3 = -9223372036854775808
            int r0 = r0 + 1
            r1 = 1
            goto L21
        L1c:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L21:
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            if (r0 >= r2) goto L34
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r9 = (long) r0
        L32:
            r0 = r8
            goto L36
        L34:
            r9 = 0
        L36:
            if (r0 >= r2) goto L73
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            r11 = 76
            if (r0 == r11) goto L72
            r11 = 83
            if (r0 == r11) goto L72
            r11 = 66
            if (r0 != r11) goto L4b
            goto L72
        L4b:
            int r0 = r0 + (-48)
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 < 0) goto L68
            r11 = 10
            long r9 = r9 * r11
            long r11 = (long) r0
            long r13 = r3 + r11
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 < 0) goto L5e
            long r9 = r9 - r11
            goto L32
        L5e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L68:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L72:
            r0 = r8
        L73:
            if (r1 == 0) goto L85
            int r1 = r15.np
            int r1 = r1 + r5
            if (r0 <= r1) goto L7b
            return r9
        L7b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L85:
            long r0 = -r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.longValue():long");
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.ch)) {
                return false;
            }
            next();
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char charAt = charAt(length);
        this.ch = charAt;
        if (charAt == '{') {
            next();
            this.token = 12;
        } else if (charAt == '[') {
            next();
            this.token = 14;
        } else if (charAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i10 = this.bp + 3;
            this.bp = i10;
            this.ch = charAt(i10);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c4 = this.ch;
        if (c4 != '_' && c4 != '$' && !Character.isLetter(c4)) {
            nextToken();
        } else {
            scanIdent();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c4 = this.ch;
            if (c4 == '/') {
                skipComment();
            } else {
                if (c4 == '\"') {
                    scanString();
                    return;
                }
                if (c4 == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (c4 >= '0' && c4 <= '9') {
                    scanNumber();
                    return;
                }
                if (c4 == '-') {
                    scanNumber();
                    return;
                }
                switch (c4) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (isEnabled(Feature.AllowSingleQuotes)) {
                            scanStringSingleQuote();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token != 20) {
                                this.token = 20;
                                int i10 = this.bp;
                                this.pos = i10;
                                this.eofPos = i10;
                                return;
                            }
                            throw new JSONException("EOF error");
                        }
                        char c10 = this.ch;
                        if (c10 > 31 && c10 != 127) {
                            lexError("illegal.char", String.valueOf((int) c10));
                            next();
                            return;
                        } else {
                            next();
                            break;
                        }
                }
            }
        }
    }

    public final void nextTokenWithChar(char c4) {
        this.sp = 0;
        while (true) {
            char c10 = this.ch;
            if (c10 == c4) {
                next();
                nextToken();
                return;
            }
            if (c10 != ' ' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != '\f' && c10 != '\b') {
                throw new JSONException("not match " + c4 + " - " + this.ch + ", info : " + info());
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    public final void putChar(char c4) {
        int i10 = this.sp;
        char[] cArr = this.sbuf;
        if (i10 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i11 = this.sp;
        this.sp = i11 + 1;
        cArr3[i11] = c4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c4) {
        boolean z10 = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i10 = 5;
        if (charAt == 't') {
            if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
                charAt = charAt(this.bp + 4);
                z10 = true;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt != 'f') {
            if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z10 = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i10 = 1;
            }
            i10 = 2;
        } else if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
            charAt = charAt(this.bp + 5);
            i10 = 6;
        } else {
            this.matchStat = -1;
            return false;
        }
        while (charAt != c4) {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i10);
                i10++;
            } else {
                this.matchStat = -1;
                return z10;
            }
        }
        int i11 = this.bp + i10;
        this.bp = i11;
        this.ch = charAt(i11);
        this.matchStat = 3;
        return z10;
    }

    public Date scanDate(char c4) {
        long j10;
        int i10;
        Date date;
        boolean z10 = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i11 = 5;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i12 = this.bp + 1;
                String subString = subString(i12, indexOf - i12);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i13 = 0;
                        for (int i14 = indexOf - 1; i14 >= 0 && charAt(i14) == '\\'; i14--) {
                            i13++;
                        }
                        if (i13 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i15 = this.bp;
                    int i16 = indexOf - (i15 + 1);
                    subString = readString(sub_chars(i15 + 1, i16), i16);
                }
                int i17 = this.bp;
                int i18 = (indexOf - (i17 + 1)) + 1 + 1;
                int i19 = i18 + 1;
                charAt = charAt(i17 + i18);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                        jSONScanner.close();
                        i11 = i19;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c10 = '9';
            int i20 = 2;
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                    this.matchStat = 5;
                    charAt = charAt(this.bp + 4);
                    date = null;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            } else {
                if (charAt == '-') {
                    charAt = charAt(this.bp + 1);
                    z10 = true;
                } else {
                    i20 = 1;
                }
                if (charAt >= '0' && charAt <= '9') {
                    j10 = charAt - '0';
                    while (true) {
                        i10 = i20 + 1;
                        charAt = charAt(this.bp + i20);
                        if (charAt < '0' || charAt > c10) {
                            break;
                        }
                        j10 = (j10 * 10) + (charAt - '0');
                        i20 = i10;
                        c10 = '9';
                    }
                } else {
                    j10 = 0;
                    i10 = i20;
                }
                if (j10 < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z10) {
                    j10 = -j10;
                }
                date = new Date(j10);
                i11 = i10;
            }
        }
        if (charAt == ',') {
            int i21 = this.bp + i11;
            this.bp = i21;
            this.ch = charAt(i21);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        if (charAt == ']') {
            int i22 = i11 + 1;
            char charAt2 = charAt(this.bp + i11);
            if (charAt2 == ',') {
                this.token = 16;
                int i23 = this.bp + i22;
                this.bp = i23;
                this.ch = charAt(i23);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i24 = this.bp + i22;
                this.bp = i24;
                this.ch = charAt(i24);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i25 = this.bp + i22;
                this.bp = i25;
                this.ch = charAt(i25);
            } else if (charAt2 == 26) {
                this.token = 20;
                this.bp += i22 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        }
        this.matchStat = -1;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00af A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00b1 -> B:43:0x009f). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.math.BigDecimal scanDecimal(char r19) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00c9 -> B:42:0x00b7). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double scanDouble(char r21) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDouble(char):double");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c4) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c4);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    public long scanEnumSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i10 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j10 = -3750763034362895579L;
        while (true) {
            int i11 = i10 + 1;
            char charAt = charAt(this.bp + i10);
            if (charAt == '\"') {
                int i12 = i11 + 1;
                char charAt2 = charAt(this.bp + i11);
                if (charAt2 == ',') {
                    int i13 = this.bp + i12;
                    this.bp = i13;
                    this.ch = charAt(i13);
                    this.matchStat = 3;
                    return j10;
                }
                if (charAt2 == '}') {
                    int i14 = i12 + 1;
                    char charAt3 = charAt(this.bp + i12);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i15 = this.bp + i14;
                        this.bp = i15;
                        this.ch = charAt(i15);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i16 = this.bp + i14;
                        this.bp = i16;
                        this.ch = charAt(i16);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i17 = this.bp + i14;
                        this.bp = i17;
                        this.ch = charAt(i17);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i14 - 1;
                        this.ch = (char) 26;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j10;
                }
                this.matchStat = -1;
                return 0L;
            }
            j10 = (j10 ^ ((charAt < 'A' || charAt > 'Z') ? charAt : charAt + ' ')) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i10 = i11;
        }
    }

    public final void scanFalse() {
        if (this.ch == 'f') {
            next();
            if (this.ch == 'a') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 's') {
                        next();
                        if (this.ch == 'e') {
                            next();
                            char c4 = this.ch;
                            if (c4 != ' ' && c4 != ',' && c4 != '}' && c4 != ']' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != 26 && c4 != '\f' && c4 != '\b' && c4 != ':' && c4 != '/') {
                                throw new JSONException("scan false error");
                            }
                            this.token = 7;
                            return;
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        int i10;
        char charAt;
        boolean z10;
        int length;
        int i11;
        BigInteger bigInteger;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i12 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        boolean z11 = charAt2 == '\"';
        if (z11) {
            charAt2 = charAt(this.bp + i12);
            i12++;
        }
        boolean z12 = charAt2 == '-';
        if (z12) {
            charAt2 = charAt(this.bp + i12);
            i12++;
        }
        if (charAt2 >= '0') {
            char c4 = '9';
            if (charAt2 <= '9') {
                long j10 = charAt2 - '0';
                while (true) {
                    i10 = i12 + 1;
                    charAt = charAt(this.bp + i12);
                    if (charAt < '0' || charAt > c4) {
                        break;
                    }
                    long j11 = (10 * j10) + (charAt - '0');
                    if (j11 < j10) {
                        z10 = true;
                        break;
                    }
                    j10 = j11;
                    i12 = i10;
                    c4 = '9';
                }
                z10 = false;
                if (!z11) {
                    int i13 = this.bp;
                    length = cArr.length + i13;
                    i11 = ((i13 + i10) - length) - 1;
                } else {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return null;
                    }
                    int i14 = i10 + 1;
                    charAt = charAt(this.bp + i10);
                    int i15 = this.bp;
                    length = cArr.length + i15 + 1;
                    i11 = ((i15 + i14) - length) - 2;
                    i10 = i14;
                }
                if (!z10 && (i11 < 20 || (z12 && i11 < 21))) {
                    if (z12) {
                        j10 = -j10;
                    }
                    bigInteger = BigInteger.valueOf(j10);
                } else {
                    bigInteger = new BigInteger(subString(length, i11));
                }
                if (charAt == ',') {
                    int i16 = this.bp + i10;
                    this.bp = i16;
                    this.ch = charAt(i16);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigInteger;
                }
                if (charAt == '}') {
                    int i17 = i10 + 1;
                    char charAt3 = charAt(this.bp + i10);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i18 = this.bp + i17;
                        this.bp = i18;
                        this.ch = charAt(i18);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i19 = this.bp + i17;
                        this.bp = i19;
                        this.ch = charAt(i19);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i20 = this.bp + i17;
                        this.bp = i20;
                        this.ch = charAt(i20);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i17 - 1;
                        this.ch = (char) 26;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return bigInteger;
                }
                this.matchStat = -1;
                return null;
            }
        }
        if (charAt2 == 'n' && charAt(this.bp + i12) == 'u' && charAt(this.bp + i12 + 1) == 'l' && charAt(this.bp + i12 + 2) == 'l') {
            this.matchStat = 5;
            int i21 = i12 + 3;
            int i22 = i21 + 1;
            char charAt4 = charAt(this.bp + i21);
            if (z11 && charAt4 == '\"') {
                charAt4 = charAt(this.bp + i22);
                i22++;
            }
            while (charAt4 != ',') {
                if (charAt4 == '}') {
                    int i23 = this.bp + i22;
                    this.bp = i23;
                    this.ch = charAt(i23);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                }
                if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i22);
                    i22++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i24 = this.bp + i22;
            this.bp = i24;
            this.ch = charAt(i24);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        this.matchStat = -1;
        return null;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i10;
        boolean z10;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i11 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i12 = i11 + 1;
            if (charAt(this.bp + i11) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i13 = i12 + 1;
            if (charAt(this.bp + i12) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i10 = i13 + 1;
            if (charAt(this.bp + i13) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z10 = true;
        } else if (charAt == 'f') {
            int i14 = i11 + 1;
            if (charAt(this.bp + i11) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i15 = i14 + 1;
            if (charAt(this.bp + i14) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i16 = i15 + 1;
            if (charAt(this.bp + i15) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i17 = i16 + 1;
            if (charAt(this.bp + i16) != 'e') {
                this.matchStat = -1;
                return false;
            }
            i10 = i17;
            z10 = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i18 = i10 + 1;
        char charAt2 = charAt(this.bp + i10);
        if (charAt2 == ',') {
            int i19 = this.bp + i18;
            this.bp = i19;
            this.ch = charAt(i19);
            this.matchStat = 3;
            this.token = 16;
            return z10;
        }
        if (charAt2 == '}') {
            int i20 = i18 + 1;
            char charAt3 = charAt(this.bp + i18);
            if (charAt3 == ',') {
                this.token = 16;
                int i21 = this.bp + i20;
                this.bp = i21;
                this.ch = charAt(i21);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i22 = this.bp + i20;
                this.bp = i22;
                this.ch = charAt(i22);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i23 = this.bp + i20;
                this.bp = i23;
                this.ch = charAt(i23);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i20 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z10;
        }
        this.matchStat = -1;
        return false;
    }

    public Date scanFieldDate(char[] cArr) {
        int i10;
        long j10;
        Date date;
        int i11;
        char charAt;
        boolean z10 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                String subString = subString(length2, indexOf - length2);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i13 = 0;
                        for (int i14 = indexOf - 1; i14 >= 0 && charAt(i14) == '\\'; i14--) {
                            i13++;
                        }
                        if (i13 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i15 = this.bp;
                    int length3 = indexOf - ((cArr.length + i15) + 1);
                    subString = readString(sub_chars(i15 + cArr.length + 1, length3), length3);
                }
                int i16 = this.bp;
                int length4 = i12 + (indexOf - ((cArr.length + i16) + 1)) + 1;
                i10 = length4 + 1;
                charAt2 = charAt(i16 + length4);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            if (charAt2 != '-' && (charAt2 < '0' || charAt2 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i12);
                i12++;
                z10 = true;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                i10 = i12;
                j10 = 0;
            } else {
                j10 = charAt2 - '0';
                while (true) {
                    i11 = i12 + 1;
                    charAt = charAt(this.bp + i12);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j10 = (j10 * 10) + (charAt - '0');
                    i12 = i11;
                }
                charAt2 = charAt;
                i10 = i11;
            }
            if (j10 < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z10) {
                j10 = -j10;
            }
            date = new Date(j10);
        }
        if (charAt2 == ',') {
            int i17 = this.bp + i10;
            this.bp = i17;
            this.ch = charAt(i17);
            this.matchStat = 3;
            return date;
        }
        if (charAt2 == '}') {
            int i18 = i10 + 1;
            char charAt3 = charAt(this.bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                int i19 = this.bp + i18;
                this.bp = i19;
                this.ch = charAt(i19);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i20 = this.bp + i18;
                this.bp = i20;
                this.ch = charAt(i20);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i21 = this.bp + i18;
                this.bp = i21;
                this.ch = charAt(i21);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i18 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        }
        this.matchStat = -1;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00be -> B:46:0x00ac). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.math.BigDecimal scanFieldDecimal(char[] r19) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDecimal(char[]):java.math.BigDecimal");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00de -> B:46:0x00ca). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double scanFieldDouble(char[] r24) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    public final float scanFieldFloat(char[] cArr) {
        int i10;
        char charAt;
        boolean z10;
        long j10;
        int length;
        int i11;
        float parseFloat;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i12 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        boolean z11 = charAt2 == '\"';
        if (z11) {
            charAt2 = charAt(this.bp + i12);
            i12++;
        }
        boolean z12 = charAt2 == '-';
        if (z12) {
            charAt2 = charAt(this.bp + i12);
            i12++;
        }
        if (charAt2 >= '0') {
            char c4 = '9';
            if (charAt2 <= '9') {
                long j11 = charAt2 - '0';
                while (true) {
                    i10 = i12 + 1;
                    charAt = charAt(this.bp + i12);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j11 = (j11 * 10) + (charAt - '0');
                    i12 = i10;
                }
                if (charAt == '.') {
                    int i13 = i10 + 1;
                    char charAt3 = charAt(this.bp + i10);
                    if (charAt3 >= '0' && charAt3 <= '9') {
                        z10 = z11;
                        j11 = (j11 * 10) + (charAt3 - '0');
                        j10 = 10;
                        while (true) {
                            i10 = i13 + 1;
                            charAt = charAt(this.bp + i13);
                            if (charAt < '0' || charAt > c4) {
                                break;
                            }
                            j11 = (j11 * 10) + (charAt - '0');
                            j10 *= 10;
                            i13 = i10;
                            c4 = '9';
                        }
                    } else {
                        this.matchStat = -1;
                        return 0.0f;
                    }
                } else {
                    z10 = z11;
                    j10 = 1;
                }
                boolean z13 = charAt == 'e' || charAt == 'E';
                if (z13) {
                    int i14 = i10 + 1;
                    charAt = charAt(this.bp + i10);
                    if (charAt == '+' || charAt == '-') {
                        int i15 = i14 + 1;
                        charAt = charAt(this.bp + i14);
                        i10 = i15;
                    } else {
                        i10 = i14;
                    }
                    while (charAt >= '0' && charAt <= '9') {
                        int i16 = i10 + 1;
                        charAt = charAt(this.bp + i10);
                        i10 = i16;
                    }
                }
                if (!z10) {
                    int i17 = this.bp;
                    length = cArr.length + i17;
                    i11 = ((i17 + i10) - length) - 1;
                } else {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0.0f;
                    }
                    int i18 = i10 + 1;
                    charAt = charAt(this.bp + i10);
                    int i19 = this.bp;
                    length = cArr.length + i19 + 1;
                    i11 = ((i19 + i18) - length) - 2;
                    i10 = i18;
                }
                if (z13 || i11 >= 17) {
                    parseFloat = Float.parseFloat(subString(length, i11));
                } else {
                    parseFloat = (float) (j11 / j10);
                    if (z12) {
                        parseFloat = -parseFloat;
                    }
                }
                if (charAt == ',') {
                    int i20 = this.bp + i10;
                    this.bp = i20;
                    this.ch = charAt(i20);
                    this.matchStat = 3;
                    this.token = 16;
                    return parseFloat;
                }
                if (charAt == '}') {
                    int i21 = i10 + 1;
                    char charAt4 = charAt(this.bp + i10);
                    if (charAt4 == ',') {
                        this.token = 16;
                        int i22 = this.bp + i21;
                        this.bp = i22;
                        this.ch = charAt(i22);
                    } else if (charAt4 == ']') {
                        this.token = 15;
                        int i23 = this.bp + i21;
                        this.bp = i23;
                        this.ch = charAt(i23);
                    } else if (charAt4 == '}') {
                        this.token = 13;
                        int i24 = this.bp + i21;
                        this.bp = i24;
                        this.ch = charAt(i24);
                    } else if (charAt4 == 26) {
                        this.bp += i21 - 1;
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
        }
        boolean z14 = z11;
        if (charAt2 == 'n' && charAt(this.bp + i12) == 'u' && charAt(this.bp + i12 + 1) == 'l' && charAt(this.bp + i12 + 2) == 'l') {
            this.matchStat = 5;
            int i25 = i12 + 3;
            int i26 = i25 + 1;
            char charAt5 = charAt(this.bp + i25);
            if (z14 && charAt5 == '\"') {
                charAt5 = charAt(this.bp + i26);
                i26++;
            }
            while (charAt5 != ',') {
                if (charAt5 == '}') {
                    int i27 = this.bp + i26;
                    this.bp = i27;
                    this.ch = charAt(i27);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0f;
                }
                if (isWhitespace(charAt5)) {
                    charAt5 = charAt(this.bp + i26);
                    i26++;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            int i28 = this.bp + i26;
            this.bp = i28;
            this.ch = charAt(i28);
            this.matchStat = 5;
            this.token = 16;
            return 0.0f;
        }
        this.matchStat = -1;
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00a9, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ab, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] scanFieldFloatArray(char[] r20) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x014b, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00b1, code lost:
    
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00b3, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0193, code lost:
    
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0196, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0136, code lost:
    
        r4 = r18 + 1;
        r1 = charAt(r21.bp + r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0141, code lost:
    
        if (r2 == r3.length) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0143, code lost:
    
        r5 = new float[r2];
        r6 = 0;
        java.lang.System.arraycopy((java.lang.Object) r3, 0, (java.lang.Object) r5, 0, r2);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x014d, code lost:
    
        if (r8 < r7.length) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x014f, code lost:
    
        r5 = new float[(r7.length * 3) / 2];
        java.lang.System.arraycopy(r3, r6, r5, r6, r2);
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015b, code lost:
    
        r5 = r8 + 1;
        r7[r8] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0161, code lost:
    
        if (r1 != ',') goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0163, code lost:
    
        r3 = r4 + 1;
        r2 = charAt(r21.bp + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0171, code lost:
    
        if (r1 != ']') goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x017e, code lost:
    
        r2 = r1;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0173, code lost:
    
        r3 = r4 + 1;
        r2 = charAt(r21.bp + r4);
        r8 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[][] scanFieldFloatArray2(char[] r22) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    public int scanFieldInt(char[] cArr) {
        int i10;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i11 = length + 1;
        char charAt2 = charAt(this.bp + length);
        boolean z10 = charAt2 == '-';
        if (z10) {
            charAt2 = charAt(this.bp + i11);
            i11++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i12 = charAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            charAt = charAt(this.bp + i11);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i12 = (i12 * 10) + (charAt - '0');
            i11 = i10;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if ((i12 < 0 || i10 > cArr.length + 14) && !(i12 == Integer.MIN_VALUE && i10 == 17 && z10)) {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == ',') {
            int i13 = this.bp + i10;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return z10 ? -i12 : i12;
        }
        if (charAt == '}') {
            int i14 = i10 + 1;
            char charAt3 = charAt(this.bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                int i15 = this.bp + i14;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i16 = this.bp + i14;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i17 = this.bp + i14;
                this.bp = i17;
                this.ch = charAt(i17);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i14 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z10 ? -i12 : i12;
        }
        this.matchStat = -1;
        return 0;
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z10;
        int i10;
        char charAt;
        int i11;
        int i12;
        char charAt2;
        this.matchStat = 0;
        int[] iArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i13 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i14 = i13 + 1;
        char charAt3 = charAt(this.bp + i13);
        int[] iArr2 = new int[16];
        if (charAt3 == ']') {
            i12 = i14 + 1;
            charAt2 = charAt(this.bp + i14);
            i11 = 0;
        } else {
            int i15 = 0;
            while (true) {
                if (charAt3 == '-') {
                    charAt3 = charAt(this.bp + i14);
                    i14++;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (charAt3 < '0' || charAt3 > '9') {
                    break;
                }
                int i16 = charAt3 - '0';
                while (true) {
                    i10 = i14 + 1;
                    charAt = charAt(this.bp + i14);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i16 = (i16 * 10) + (charAt - '0');
                    i14 = i10;
                }
                if (i15 >= iArr2.length) {
                    int[] iArr3 = new int[(iArr2.length * 3) / 2];
                    System.arraycopy((Object) iArr2, 0, (Object) iArr3, 0, i15);
                    iArr2 = iArr3;
                }
                i11 = i15 + 1;
                if (z10) {
                    i16 = -i16;
                }
                iArr2[i15] = i16;
                if (charAt == ',') {
                    char charAt4 = charAt(this.bp + i10);
                    i10++;
                    charAt = charAt4;
                } else if (charAt == ']') {
                    i12 = i10 + 1;
                    charAt2 = charAt(this.bp + i10);
                    break;
                }
                i15 = i11;
                iArr = null;
                charAt3 = charAt;
                i14 = i10;
            }
            int[] iArr4 = iArr;
            this.matchStat = -1;
            return iArr4;
        }
        if (i11 != iArr2.length) {
            int[] iArr5 = new int[i11];
            System.arraycopy((Object) iArr2, 0, (Object) iArr5, 0, i11);
            iArr2 = iArr5;
        }
        if (charAt2 == ',') {
            this.bp += i12 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr2;
        }
        if (charAt2 == '}') {
            int i17 = i12 + 1;
            char charAt5 = charAt(this.bp + i12);
            if (charAt5 == ',') {
                this.token = 16;
                this.bp += i17 - 1;
                next();
            } else if (charAt5 == ']') {
                this.token = 15;
                this.bp += i17 - 1;
                next();
            } else if (charAt5 == '}') {
                this.token = 13;
                this.bp += i17 - 1;
                next();
            } else if (charAt5 == 26) {
                this.bp += i17 - 1;
                this.token = 20;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr2;
        }
        this.matchStat = -1;
        return null;
    }

    public long scanFieldLong(char[] cArr) {
        boolean z10;
        int i10;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i11 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i11);
            i11++;
            z10 = true;
        } else {
            z10 = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j10 = charAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            charAt = charAt(this.bp + i11);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j10 = (j10 * 10) + (charAt - '0');
            i11 = i10;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (!(i10 - cArr.length < 21 && (j10 >= 0 || (j10 == Long.MIN_VALUE && z10)))) {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == ',') {
            int i12 = this.bp + i10;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return z10 ? -j10 : j10;
        }
        if (charAt == '}') {
            int i13 = i10 + 1;
            char charAt3 = charAt(this.bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                int i14 = this.bp + i13;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i15 = this.bp + i13;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i16 = this.bp + i13;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i13 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 4;
            return z10 ? -j10 : j10;
        }
        this.matchStat = -1;
        return 0L;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i10 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i11 = 0;
                    for (int i12 = indexOf - 1; i12 >= 0 && charAt(i12) == '\\'; i12--) {
                        i11++;
                    }
                    if (i11 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i13 = this.bp;
                int length3 = indexOf - ((cArr.length + i13) + 1);
                subString = readString(sub_chars(i13 + cArr.length + 1, length3), length3);
            }
            int i14 = this.bp;
            int length4 = i10 + (indexOf - ((cArr.length + i14) + 1)) + 1;
            int i15 = length4 + 1;
            char charAt = charAt(i14 + length4);
            if (charAt == ',') {
                int i16 = this.bp + i15;
                this.bp = i16;
                this.ch = charAt(i16);
                this.matchStat = 3;
                return subString;
            }
            if (charAt == '}') {
                int i17 = i15 + 1;
                char charAt2 = charAt(this.bp + i15);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i18 = this.bp + i17;
                    this.bp = i18;
                    this.ch = charAt(i18);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i19 = this.bp + i17;
                    this.bp = i19;
                    this.ch = charAt(i19);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i20 = this.bp + i17;
                    this.bp = i20;
                    this.ch = charAt(i20);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp += i17 - 1;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            }
            this.matchStat = -1;
            return stringDefaultValue();
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fa, code lost:
    
        if (r12 != ',') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fc, code lost:
    
        r12 = r11.bp + r1;
        r11.bp = r12;
        r11.ch = charAt(r12);
        r11.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010a, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010d, code lost:
    
        if (r12 != '}') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010f, code lost:
    
        r6 = r1 + 1;
        r12 = charAt(r11.bp + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0118, code lost:
    
        if (r12 != ',') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011a, code lost:
    
        r11.token = 16;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x015f, code lost:
    
        r11.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0162, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012a, code lost:
    
        if (r12 != ']') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012c, code lost:
    
        r11.token = 15;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013c, code lost:
    
        if (r12 != '}') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013e, code lost:
    
        r11.token = 13;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0150, code lost:
    
        if (r12 != 26) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0152, code lost:
    
        r11.bp += r6 - 1;
        r11.token = 20;
        r11.ch = 26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0163, code lost:
    
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0165, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0166, code lost:
    
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0168, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ee, code lost:
    
        if (r13.size() != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f0, code lost:
    
        r12 = charAt(r11.bp + r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0170, code lost:
    
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r12, java.lang.Class<?> r13) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i10 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j10 = -3750763034362895579L;
        while (true) {
            int i11 = i10 + 1;
            char charAt = charAt(this.bp + i10);
            if (charAt == '\"') {
                int i12 = i11 + 1;
                char charAt2 = charAt(this.bp + i11);
                if (charAt2 == ',') {
                    int i13 = this.bp + i12;
                    this.bp = i13;
                    this.ch = charAt(i13);
                    this.matchStat = 3;
                    return j10;
                }
                if (charAt2 == '}') {
                    int i14 = i12 + 1;
                    char charAt3 = charAt(this.bp + i12);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i15 = this.bp + i14;
                        this.bp = i15;
                        this.ch = charAt(i15);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i16 = this.bp + i14;
                        this.bp = i16;
                        this.ch = charAt(i16);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i17 = this.bp + i14;
                        this.bp = i17;
                        this.ch = charAt(i17);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i14 - 1;
                        this.ch = (char) 26;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j10;
                }
                this.matchStat = -1;
                return 0L;
            }
            j10 = (j10 ^ charAt) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i10 = i11;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        char charAt;
        int i10;
        UUID uuid;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i24 = length + 1;
        char charAt2 = charAt(this.bp + length);
        char c4 = 4;
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                int i25 = indexOf - length2;
                char c10 = 'F';
                char c11 = 'f';
                char c12 = 'A';
                char c13 = '0';
                if (i25 == 36) {
                    int i26 = 0;
                    long j10 = 0;
                    while (i26 < 8) {
                        char charAt3 = charAt(length2 + i26);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= 'f') {
                                i22 = charAt3 - 'a';
                            } else {
                                if (charAt3 < 'A' || charAt3 > c10) {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i22 = charAt3 - 'A';
                            }
                            i23 = i22 + 10;
                        } else {
                            i23 = charAt3 - '0';
                        }
                        j10 = (j10 << 4) | i23;
                        i26++;
                        indexOf = indexOf;
                        c10 = 'F';
                    }
                    int i27 = indexOf;
                    int i28 = 9;
                    int i29 = 13;
                    while (i28 < i29) {
                        char charAt4 = charAt(length2 + i28);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i20 = charAt4 - 'a';
                            } else {
                                if (charAt4 < c12 || charAt4 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i20 = charAt4 - 'A';
                            }
                            i21 = i20 + 10;
                        } else {
                            i21 = charAt4 - '0';
                        }
                        j10 = (j10 << c4) | i21;
                        i28++;
                        i29 = 13;
                        c12 = 'A';
                        c4 = 4;
                    }
                    long j11 = j10;
                    for (int i30 = 14; i30 < 18; i30++) {
                        char charAt5 = charAt(length2 + i30);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= 'a' && charAt5 <= 'f') {
                                i18 = charAt5 - 'a';
                            } else {
                                if (charAt5 < 'A' || charAt5 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i18 = charAt5 - 'A';
                            }
                            i19 = i18 + 10;
                        } else {
                            i19 = charAt5 - '0';
                        }
                        j11 = (j11 << 4) | i19;
                    }
                    long j12 = 0;
                    for (int i31 = 19; i31 < 23; i31++) {
                        char charAt6 = charAt(length2 + i31);
                        if (charAt6 < '0' || charAt6 > '9') {
                            if (charAt6 >= 'a' && charAt6 <= 'f') {
                                i16 = charAt6 - 'a';
                            } else {
                                if (charAt6 < 'A' || charAt6 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i16 = charAt6 - 'A';
                            }
                            i17 = i16 + 10;
                        } else {
                            i17 = charAt6 - '0';
                        }
                        j12 = (j12 << 4) | i17;
                    }
                    int i32 = 24;
                    long j13 = j12;
                    int i33 = 36;
                    while (i32 < i33) {
                        char charAt7 = charAt(length2 + i32);
                        if (charAt7 < c13 || charAt7 > '9') {
                            if (charAt7 >= 'a' && charAt7 <= c11) {
                                i14 = charAt7 - 'a';
                            } else {
                                if (charAt7 < 'A' || charAt7 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i14 = charAt7 - 'A';
                            }
                            i15 = i14 + 10;
                        } else {
                            i15 = charAt7 - '0';
                        }
                        j13 = (j13 << 4) | i15;
                        i32++;
                        i24 = i24;
                        i33 = 36;
                        c13 = '0';
                        c11 = 'f';
                    }
                    uuid = new UUID(j11, j13);
                    int i34 = this.bp;
                    int length3 = i24 + (i27 - ((cArr.length + i34) + 1)) + 1;
                    i10 = length3 + 1;
                    charAt = charAt(i34 + length3);
                } else {
                    if (i25 == 32) {
                        long j14 = 0;
                        for (int i35 = 0; i35 < 16; i35++) {
                            char charAt8 = charAt(length2 + i35);
                            if (charAt8 < '0' || charAt8 > '9') {
                                if (charAt8 >= 'a' && charAt8 <= 'f') {
                                    i12 = charAt8 - 'a';
                                } else {
                                    if (charAt8 < 'A' || charAt8 > 'F') {
                                        this.matchStat = -2;
                                        return null;
                                    }
                                    i12 = charAt8 - 'A';
                                }
                                i13 = i12 + 10;
                            } else {
                                i13 = charAt8 - '0';
                            }
                            j14 = (j14 << 4) | i13;
                        }
                        int i36 = 16;
                        long j15 = 0;
                        for (int i37 = 32; i36 < i37; i37 = 32) {
                            char charAt9 = charAt(length2 + i36);
                            if (charAt9 >= '0' && charAt9 <= '9') {
                                i11 = charAt9 - '0';
                            } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                i11 = (charAt9 - 'a') + 10;
                            } else {
                                if (charAt9 < 'A' || charAt9 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i11 = (charAt9 - 'A') + 10;
                                j15 = (j15 << 4) | i11;
                                i36++;
                            }
                            j15 = (j15 << 4) | i11;
                            i36++;
                        }
                        uuid = new UUID(j14, j15);
                        int i38 = this.bp;
                        int length4 = i24 + (indexOf - ((cArr.length + i38) + 1)) + 1;
                        i10 = length4 + 1;
                        charAt = charAt(i38 + length4);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            if (charAt2 == 'n') {
                int i39 = i24 + 1;
                if (charAt(this.bp + i24) == 'u') {
                    int i40 = i39 + 1;
                    if (charAt(this.bp + i39) == 'l') {
                        int i41 = i40 + 1;
                        if (charAt(this.bp + i40) == 'l') {
                            charAt = charAt(this.bp + i41);
                            i10 = i41 + 1;
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            int i42 = this.bp + i10;
            this.bp = i42;
            this.ch = charAt(i42);
            this.matchStat = 3;
            return uuid;
        }
        if (charAt == '}') {
            int i43 = i10 + 1;
            char charAt10 = charAt(this.bp + i10);
            if (charAt10 == ',') {
                this.token = 16;
                int i44 = this.bp + i43;
                this.bp = i44;
                this.ch = charAt(i44);
            } else if (charAt10 == ']') {
                this.token = 15;
                int i45 = this.bp + i43;
                this.bp = i45;
                this.ch = charAt(i45);
            } else if (charAt10 == '}') {
                this.token = 13;
                int i46 = this.bp + i43;
                this.bp = i46;
                this.ch = charAt(i46);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i43 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        }
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final float scanFloat(char c4) {
        int i10;
        int i11;
        char charAt;
        int i12;
        int i13;
        float parseFloat;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z10 = charAt2 == '\"';
        if (z10) {
            charAt2 = charAt(this.bp + 1);
            i10 = 2;
        } else {
            i10 = 1;
        }
        boolean z11 = charAt2 == '-';
        if (z11) {
            charAt2 = charAt(this.bp + i10);
            i10++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            if (charAt2 == 'n' && charAt(this.bp + i10) == 'u' && charAt(this.bp + i10 + 1) == 'l' && charAt(this.bp + i10 + 2) == 'l') {
                this.matchStat = 5;
                int i14 = i10 + 3;
                int i15 = i14 + 1;
                char charAt3 = charAt(this.bp + i14);
                if (z10 && charAt3 == '\"') {
                    charAt3 = charAt(this.bp + i15);
                    i15++;
                }
                while (charAt3 != ',') {
                    if (charAt3 == ']') {
                        int i16 = this.bp + i15;
                        this.bp = i16;
                        this.ch = charAt(i16);
                        this.matchStat = 5;
                        this.token = 15;
                        return 0.0f;
                    }
                    if (isWhitespace(charAt3)) {
                        charAt3 = charAt(this.bp + i15);
                        i15++;
                    } else {
                        this.matchStat = -1;
                        return 0.0f;
                    }
                }
                int i17 = this.bp + i15;
                this.bp = i17;
                this.ch = charAt(i17);
                this.matchStat = 5;
                this.token = 16;
                return 0.0f;
            }
            this.matchStat = -1;
            return 0.0f;
        }
        long j10 = charAt2 - '0';
        while (true) {
            i11 = i10 + 1;
            charAt = charAt(this.bp + i10);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j10 = (j10 * 10) + (charAt - '0');
            i10 = i11;
        }
        long j11 = 1;
        if (charAt == '.') {
            int i18 = i11 + 1;
            char charAt4 = charAt(this.bp + i11);
            if (charAt4 >= '0' && charAt4 <= '9') {
                j10 = (j10 * 10) + (charAt4 - '0');
                j11 = 10;
                while (true) {
                    i11 = i18 + 1;
                    charAt = charAt(this.bp + i18);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j10 = (j10 * 10) + (charAt - '0');
                    j11 *= 10;
                    i18 = i11;
                }
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        }
        long j12 = j11;
        boolean z12 = charAt == 'e' || charAt == 'E';
        if (z12) {
            int i19 = i11 + 1;
            char charAt5 = charAt(this.bp + i11);
            if (charAt5 == '+' || charAt5 == '-') {
                int i20 = i19 + 1;
                charAt = charAt(this.bp + i19);
                i11 = i20;
            } else {
                i11 = i19;
                charAt = charAt5;
            }
            while (charAt >= '0' && charAt <= '9') {
                int i21 = i11 + 1;
                charAt = charAt(this.bp + i11);
                i11 = i21;
            }
        }
        if (!z10) {
            i12 = this.bp;
            i13 = ((i12 + i11) - i12) - 1;
        } else {
            if (charAt != '\"') {
                this.matchStat = -1;
                return 0.0f;
            }
            int i22 = i11 + 1;
            charAt = charAt(this.bp + i11);
            int i23 = this.bp;
            i12 = i23 + 1;
            i13 = ((i23 + i22) - i12) - 2;
            i11 = i22;
        }
        if (z12 || i13 >= 17) {
            parseFloat = Float.parseFloat(subString(i12, i13));
        } else {
            parseFloat = (float) (j10 / j12);
            if (z11) {
                parseFloat = -parseFloat;
            }
        }
        if (charAt == c4) {
            int i24 = this.bp + i11;
            this.bp = i24;
            this.ch = charAt(i24);
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        }
        this.matchStat = -1;
        return parseFloat;
    }

    public final void scanHex() {
        char next;
        if (this.ch == 'x') {
            next();
            if (this.ch == '\'') {
                this.np = this.bp;
                next();
                if (this.ch == '\'') {
                    next();
                    this.token = 26;
                    return;
                }
                while (true) {
                    next = next();
                    if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                        break;
                    } else {
                        this.sp++;
                    }
                }
                if (next == '\'') {
                    this.sp++;
                    next();
                    this.token = 26;
                    return;
                } else {
                    throw new JSONException("illegal state. " + next);
                }
            }
            throw new JSONException("illegal state. " + this.ch);
        }
        throw new JSONException("illegal state. " + this.ch);
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
            this.token = 8;
            return;
        }
        if ("new".equals(stringVal)) {
            this.token = 9;
            return;
        }
        if ("true".equals(stringVal)) {
            this.token = 6;
            return;
        }
        if ("false".equals(stringVal)) {
            this.token = 7;
            return;
        }
        if ("undefined".equals(stringVal)) {
            this.token = 23;
            return;
        }
        if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c4) {
        int i10;
        int i11;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z10 = charAt2 == '\"';
        if (z10) {
            charAt2 = charAt(this.bp + 1);
            i10 = 2;
        } else {
            i10 = 1;
        }
        boolean z11 = charAt2 == '-';
        if (z11) {
            charAt2 = charAt(this.bp + i10);
            i10++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i12 = charAt2 - '0';
            while (true) {
                i11 = i10 + 1;
                charAt = charAt(this.bp + i10);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i12 = (i12 * 10) + (charAt - '0');
                i10 = i11;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (i12 < 0) {
                this.matchStat = -1;
                return 0;
            }
            while (charAt != c4) {
                if (isWhitespace(charAt)) {
                    char charAt3 = charAt(this.bp + i11);
                    i11++;
                    charAt = charAt3;
                } else {
                    this.matchStat = -1;
                    return z11 ? -i12 : i12;
                }
            }
            int i13 = this.bp + i11;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return z11 ? -i12 : i12;
        }
        if (charAt2 == 'n' && charAt(this.bp + i10) == 'u' && charAt(this.bp + i10 + 1) == 'l' && charAt(this.bp + i10 + 2) == 'l') {
            this.matchStat = 5;
            int i14 = i10 + 3;
            int i15 = i14 + 1;
            char charAt4 = charAt(this.bp + i14);
            if (z10 && charAt4 == '\"') {
                int i16 = i15 + 1;
                charAt4 = charAt(this.bp + i15);
                i15 = i16;
            }
            while (charAt4 != ',') {
                if (charAt4 == ']') {
                    int i17 = this.bp + i15;
                    this.bp = i17;
                    this.ch = charAt(i17);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0;
                }
                if (isWhitespace(charAt4)) {
                    int i18 = i15 + 1;
                    charAt4 = charAt(this.bp + i15);
                    i15 = i18;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i19 = this.bp + i15;
            this.bp = i19;
            this.ch = charAt(i19);
            this.matchStat = 5;
            this.token = 16;
            return 0;
        }
        this.matchStat = -1;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c4) {
        int i10;
        int i11;
        char charAt;
        char c10;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z10 = charAt2 == '\"';
        if (z10) {
            charAt2 = charAt(this.bp + 1);
            i10 = 2;
        } else {
            i10 = 1;
        }
        boolean z11 = charAt2 == '-';
        if (z11) {
            charAt2 = charAt(this.bp + i10);
            i10++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j10 = charAt2 - '0';
            while (true) {
                i11 = i10 + 1;
                charAt = charAt(this.bp + i10);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j10 = (j10 * 10) + (charAt - '0');
                i10 = i11;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (j10 >= 0 || (j10 == Long.MIN_VALUE && z11)) {
                if (!z10) {
                    c10 = c4;
                } else {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0L;
                    }
                    charAt = charAt(this.bp + i11);
                    c10 = c4;
                    i11++;
                }
                while (charAt != c10) {
                    if (isWhitespace(charAt)) {
                        charAt = charAt(this.bp + i11);
                        i11++;
                    } else {
                        this.matchStat = -1;
                        return j10;
                    }
                }
                int i12 = this.bp + i11;
                this.bp = i12;
                this.ch = charAt(i12);
                this.matchStat = 3;
                this.token = 16;
                return z11 ? -j10 : j10;
            }
            throw new NumberFormatException(subString(this.bp, i11 - 1));
        }
        if (charAt2 == 'n' && charAt(this.bp + i10) == 'u' && charAt(this.bp + i10 + 1) == 'l' && charAt(this.bp + i10 + 2) == 'l') {
            this.matchStat = 5;
            int i13 = i10 + 3;
            int i14 = i13 + 1;
            char charAt3 = charAt(this.bp + i13);
            if (z10 && charAt3 == '\"') {
                int i15 = i14 + 1;
                charAt3 = charAt(this.bp + i14);
                i14 = i15;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    int i16 = this.bp + i14;
                    this.bp = i16;
                    this.ch = charAt(i16);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0L;
                }
                if (isWhitespace(charAt3)) {
                    int i17 = i14 + 1;
                    charAt3 = charAt(this.bp + i14);
                    i14 = i17;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            int i18 = this.bp + i14;
            this.bp = i18;
            this.ch = charAt(i18);
            this.matchStat = 5;
            this.token = 16;
            return 0L;
        }
        this.matchStat = -1;
        return 0L;
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scanNumber() {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0170, code lost:
    
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r1 + r2);
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scanString() {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanString():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x012b, code lost:
    
        if (r1 != r18) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x012d, code lost:
    
        r1 = r16.bp + r3;
        r16.bp = r1;
        r16.ch = charAt(r1);
        r16.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x013a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x013b, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x013d, code lost:
    
        return;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scanStringArray(java.util.Collection<java.lang.String> r17, char r18) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringArray(java.util.Collection, char):void");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c4 = this.ch;
        if (c4 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c4 == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
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
        if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        }
        throw new JSONException("syntax error");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = com.alibaba.fastjson.util.IOUtils.firstIdentifierFlags;
        int i10 = this.ch;
        if (i10 >= zArr.length || zArr[i10]) {
            boolean[] zArr2 = com.alibaba.fastjson.util.IOUtils.identifierFlags;
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i10 = (i10 * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp == 4 && i10 == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
                return null;
            }
            if (symbolTable == null) {
                return subString(this.np, this.sp);
            }
            return addSymbol(this.np, this.sp, i10, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.ch + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c4) {
        int i10 = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c4) {
                    int i11 = this.bp + 5;
                    this.bp = i11;
                    this.ch = charAt(i11);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        }
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char charAt2 = charAt(this.bp + i12);
            if (charAt2 == '\"') {
                int i14 = this.bp;
                int i15 = i14 + 0 + 1;
                String addSymbol = addSymbol(i15, ((i14 + i13) - i15) - 1, i10, symbolTable);
                int i16 = i13 + 1;
                char charAt3 = charAt(this.bp + i13);
                while (charAt3 != c4) {
                    if (isWhitespace(charAt3)) {
                        charAt3 = charAt(this.bp + i16);
                        i16++;
                    } else {
                        this.matchStat = -1;
                        return addSymbol;
                    }
                }
                int i17 = this.bp + i16;
                this.bp = i17;
                this.ch = charAt(i17);
                this.matchStat = 3;
                return addSymbol;
            }
            i10 = (i10 * 31) + charAt2;
            if (charAt2 == '\\') {
                this.matchStat = -1;
                return null;
            }
            i12 = i13;
        }
    }

    public final void scanTrue() {
        if (this.ch == 't') {
            next();
            if (this.ch == 'r') {
                next();
                if (this.ch == 'u') {
                    next();
                    if (this.ch == 'e') {
                        next();
                        char c4 = this.ch;
                        if (c4 != ' ' && c4 != ',' && c4 != '}' && c4 != ']' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != 26 && c4 != '\f' && c4 != '\b' && c4 != ':' && c4 != '/') {
                            throw new JSONException("scan true error");
                        }
                        this.token = 6;
                        return;
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.bp + cArr.length;
        int length2 = str.length();
        for (int i10 = 0; i10 < length2; i10++) {
            if (str.charAt(i10) != charAt(length + i10)) {
                return -1;
            }
        }
        int i11 = length + length2;
        if (charAt(i11) != '\"') {
            return -1;
        }
        int i12 = i11 + 1;
        char charAt = charAt(i12);
        this.ch = charAt;
        if (charAt == ',') {
            int i13 = i12 + 1;
            this.ch = charAt(i13);
            this.bp = i13;
            this.token = 16;
            return 3;
        }
        if (charAt == '}') {
            i12++;
            char charAt2 = charAt(i12);
            this.ch = charAt2;
            if (charAt2 == ',') {
                this.token = 16;
                i12++;
                this.ch = charAt(i12);
            } else if (charAt2 == ']') {
                this.token = 15;
                i12++;
                this.ch = charAt(i12);
            } else if (charAt2 == '}') {
                this.token = 13;
                i12++;
                this.ch = charAt(i12);
            } else {
                if (charAt2 != 26) {
                    return -1;
                }
                this.token = 20;
            }
            this.matchStat = 4;
        }
        this.bp = i12;
        return this.matchStat;
    }

    public UUID scanUUID(char c4) {
        int i10;
        char charAt;
        UUID uuid;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        int i24 = 13;
        char c10 = 4;
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i25 = this.bp + 1;
                int i26 = indexOf - i25;
                char c11 = 'f';
                char c12 = 'A';
                char c13 = 'a';
                if (i26 == 36) {
                    int i27 = 0;
                    long j10 = 0;
                    while (i27 < 8) {
                        char charAt3 = charAt(i25 + i27);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= c11) {
                                i22 = charAt3 - 'a';
                            } else {
                                if (charAt3 < 'A' || charAt3 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i22 = charAt3 - 'A';
                            }
                            i23 = i22 + 10;
                        } else {
                            i23 = charAt3 - '0';
                        }
                        j10 = (j10 << 4) | i23;
                        i27++;
                        c11 = 'f';
                    }
                    int i28 = 9;
                    while (i28 < i24) {
                        char charAt4 = charAt(i25 + i28);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i20 = charAt4 - 'a';
                            } else {
                                if (charAt4 < c12 || charAt4 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i20 = charAt4 - 'A';
                            }
                            i21 = i20 + 10;
                        } else {
                            i21 = charAt4 - '0';
                        }
                        j10 = (j10 << 4) | i21;
                        i28++;
                        i24 = 13;
                        c12 = 'A';
                    }
                    long j11 = j10;
                    for (int i29 = 14; i29 < 18; i29++) {
                        char charAt5 = charAt(i25 + i29);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= 'a' && charAt5 <= 'f') {
                                i18 = charAt5 - 'a';
                            } else {
                                if (charAt5 < 'A' || charAt5 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i18 = charAt5 - 'A';
                            }
                            i19 = i18 + 10;
                        } else {
                            i19 = charAt5 - '0';
                        }
                        j11 = (j11 << 4) | i19;
                    }
                    int i30 = 19;
                    long j12 = 0;
                    while (i30 < 23) {
                        char charAt6 = charAt(i25 + i30);
                        if (charAt6 < '0' || charAt6 > '9') {
                            if (charAt6 >= c13 && charAt6 <= 'f') {
                                i16 = charAt6 - 'a';
                            } else {
                                if (charAt6 < 'A' || charAt6 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i16 = charAt6 - 'A';
                            }
                            i17 = i16 + 10;
                        } else {
                            i17 = charAt6 - '0';
                        }
                        j12 = (j12 << c10) | i17;
                        i30++;
                        c13 = 'a';
                        c10 = 4;
                    }
                    long j13 = j12;
                    for (int i31 = 24; i31 < 36; i31++) {
                        char charAt7 = charAt(i25 + i31);
                        if (charAt7 < '0' || charAt7 > '9') {
                            if (charAt7 >= 'a' && charAt7 <= 'f') {
                                i14 = charAt7 - 'a';
                            } else {
                                if (charAt7 < 'A' || charAt7 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i14 = charAt7 - 'A';
                            }
                            i15 = i14 + 10;
                        } else {
                            i15 = charAt7 - '0';
                        }
                        j13 = (j13 << 4) | i15;
                    }
                    uuid = new UUID(j11, j13);
                    int i32 = this.bp;
                    int i33 = 1 + (indexOf - (i32 + 1)) + 1;
                    i10 = i33 + 1;
                    charAt = charAt(i32 + i33);
                } else {
                    if (i26 == 32) {
                        long j14 = 0;
                        for (int i34 = 0; i34 < 16; i34++) {
                            char charAt8 = charAt(i25 + i34);
                            if (charAt8 < '0' || charAt8 > '9') {
                                if (charAt8 >= 'a' && charAt8 <= 'f') {
                                    i12 = charAt8 - 'a';
                                } else {
                                    if (charAt8 < 'A' || charAt8 > 'F') {
                                        this.matchStat = -2;
                                        return null;
                                    }
                                    i12 = charAt8 - 'A';
                                }
                                i13 = i12 + 10;
                            } else {
                                i13 = charAt8 - '0';
                            }
                            j14 = (j14 << 4) | i13;
                        }
                        int i35 = 16;
                        long j15 = 0;
                        for (int i36 = 32; i35 < i36; i36 = 32) {
                            char charAt9 = charAt(i25 + i35);
                            if (charAt9 >= '0' && charAt9 <= '9') {
                                i11 = charAt9 - '0';
                            } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                i11 = (charAt9 - 'a') + 10;
                            } else {
                                if (charAt9 < 'A' || charAt9 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                }
                                i11 = (charAt9 - 'A') + 10;
                            }
                            j15 = (j15 << 4) | i11;
                            i35++;
                        }
                        uuid = new UUID(j14, j15);
                        int i37 = this.bp;
                        int i38 = 1 + (indexOf - (i37 + 1)) + 1;
                        i10 = i38 + 1;
                        charAt = charAt(i37 + i38);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
            i10 = 5;
            charAt = charAt(this.bp + 4);
            uuid = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            int i39 = this.bp + i10;
            this.bp = i39;
            this.ch = charAt(i39);
            this.matchStat = 3;
            return uuid;
        }
        if (charAt == ']') {
            int i40 = i10 + 1;
            char charAt10 = charAt(this.bp + i10);
            if (charAt10 == ',') {
                this.token = 16;
                int i41 = this.bp + i40;
                this.bp = i41;
                this.ch = charAt(i41);
            } else if (charAt10 == ']') {
                this.token = 15;
                int i42 = this.bp + i40;
                this.bp = i42;
                this.ch = charAt(i42);
            } else if (charAt10 == '}') {
                this.token = 13;
                int i43 = this.bp + i40;
                this.bp = i43;
                this.ch = charAt(i43);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i40 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        }
        this.matchStat = -1;
        return null;
    }

    public boolean seekArrayToItem(int i10) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long j10, boolean z10) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToFieldDeepScan(long j10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToken(int i10) {
        this.token = i10;
    }

    public void skipArray() {
        throw new UnsupportedOperationException();
    }

    public void skipComment() {
        char c4;
        next();
        char c10 = this.ch;
        if (c10 != '/') {
            if (c10 == '*') {
                next();
                while (true) {
                    char c11 = this.ch;
                    if (c11 == 26) {
                        return;
                    }
                    if (c11 == '*') {
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
                throw new JSONException("invalid comment");
            }
        }
        do {
            next();
            c4 = this.ch;
            if (c4 == '\n') {
                next();
                return;
            }
        } while (c4 != 26);
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
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

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i10, int i11);

    public abstract char[] sub_chars(int i10, int i11);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i10) {
        return (i10 & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i10) {
        nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
    }

    public final void scanNullOrNew(boolean z10) {
        if (this.ch == 'n') {
            next();
            char c4 = this.ch;
            if (c4 != 'u') {
                if (c4 == 'e') {
                    next();
                    if (this.ch == 'w') {
                        next();
                        char c10 = this.ch;
                        if (c10 != ' ' && c10 != ',' && c10 != '}' && c10 != ']' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != 26 && c10 != '\f' && c10 != '\b') {
                            throw new JSONException("scan new error");
                        }
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("error parse new");
                }
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch == 'l') {
                next();
                if (this.ch == 'l') {
                    next();
                    char c11 = this.ch;
                    if (c11 != ' ' && c11 != ',' && c11 != '}' && c11 != ']' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != 26 && ((c11 != ':' || !z10) && c11 != '\f' && c11 != '\b')) {
                        throw new JSONException("scan null error");
                    }
                    this.token = 8;
                    return;
                }
                throw new JSONException("error parse null");
            }
            throw new JSONException("error parse null");
        }
        throw new JSONException("error parse null or new");
    }

    public int seekObjectToField(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    public void skipObject(boolean z10) {
        throw new UnsupportedOperationException();
    }

    public final boolean isEnabled(int i10, int i11) {
        return ((this.features & i11) == 0 && (i10 & i11) == 0) ? false : true;
    }

    public int matchField(long j10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c4) {
        String addSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            char next = next();
            if (next == c4) {
                this.token = 4;
                if (!z10) {
                    int i11 = this.np;
                    addSymbol = addSymbol(i11 == -1 ? 0 : i11 + 1, this.sp, i10, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i10);
                }
                this.sp = 0;
                next();
                return addSymbol;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z10) {
                    int i12 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i12 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i12 <= length) {
                            i12 = length;
                        }
                        char[] cArr2 = new char[i12];
                        System.arraycopy((Object) cArr, 0, (Object) cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                    z10 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i10 = (i10 * 31) + 34;
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i10 = (i10 * 31) + 92;
                            putChar(IOUtils.DIR_SEPARATOR_WINDOWS);
                        } else if (next2 == 'b') {
                            i10 = (i10 * 31) + 8;
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i10 = (i10 * 31) + 10;
                                putChar('\n');
                            } else if (next2 == 'r') {
                                i10 = (i10 * 31) + 13;
                                putChar(CharUtils.CR);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i10 = (i10 * 31) + 47;
                                        putChar(IOUtils.DIR_SEPARATOR_UNIX);
                                        break;
                                    case '0':
                                        i10 = (i10 * 31) + next2;
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        i10 = (i10 * 31) + next2;
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        i10 = (i10 * 31) + next2;
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        i10 = (i10 * 31) + next2;
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        i10 = (i10 * 31) + next2;
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        i10 = (i10 * 31) + next2;
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        i10 = (i10 * 31) + next2;
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        i10 = (i10 * 31) + next2;
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i10 = (i10 * 31) + 9;
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i10 = (i10 * 31) + parseInt;
                                                putChar((char) parseInt);
                                                break;
                                            case 'v':
                                                i10 = (i10 * 31) + 11;
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.ch = next3;
                                char next4 = next();
                                this.ch = next4;
                                int[] iArr = digits;
                                char c10 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i10 = (i10 * 31) + c10;
                                putChar(c10);
                            }
                        }
                    }
                    i10 = (i10 * 31) + 12;
                    putChar('\f');
                } else {
                    i10 = (i10 * 31) + 39;
                    putChar('\'');
                }
            } else {
                i10 = (i10 * 31) + next;
                if (!z10) {
                    this.sp++;
                } else {
                    int i13 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i13 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.sp = i13 + 1;
                        cArr3[i13] = next;
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0029. Please report as an issue. */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i10) {
        this.sp = 0;
        while (true) {
            if (i10 == 2) {
                char c4 = this.ch;
                if (c4 >= '0' && c4 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                if (c4 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c4 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c4 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i10 == 4) {
                char c10 = this.ch;
                if (c10 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                }
                if (c10 >= '0' && c10 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c10 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c10 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i10 == 12) {
                char c11 = this.ch;
                if (c11 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c11 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i10 != 18) {
                if (i10 != 20) {
                    switch (i10) {
                        case 14:
                            char c12 = this.ch;
                            if (c12 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c12 == '{') {
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
                            char c13 = this.ch;
                            if (c13 == ',') {
                                this.token = 16;
                                next();
                                return;
                            }
                            if (c13 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c13 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c13 == 26) {
                                this.token = 20;
                                return;
                            } else if (c13 == 'n') {
                                scanNullOrNew(false);
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
            char c14 = this.ch;
            if (c14 != ' ' && c14 != '\n' && c14 != '\r' && c14 != '\t' && c14 != '\f' && c14 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c4) {
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c4) {
                    int i10 = this.bp + 5;
                    this.bp = i10;
                    this.ch = charAt(i10);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        int i11 = 1;
        while (charAt != '\"') {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i11);
                i11++;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int i12 = this.bp + i11;
        int indexOf = indexOf('\"', i12);
        if (indexOf != -1) {
            String subString = subString(this.bp + i11, indexOf - i12);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i13 = 0;
                    for (int i14 = indexOf - 1; i14 >= 0 && charAt(i14) == '\\'; i14--) {
                        i13++;
                    }
                    if (i13 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i15 = indexOf - i12;
                subString = readString(sub_chars(this.bp + 1, i15), i15);
            }
            int i16 = i11 + (indexOf - i12) + 1;
            int i17 = i16 + 1;
            char charAt2 = charAt(this.bp + i16);
            while (charAt2 != c4) {
                if (isWhitespace(charAt2)) {
                    charAt2 = charAt(this.bp + i17);
                    i17++;
                } else {
                    this.matchStat = -1;
                    return subString;
                }
            }
            int i18 = this.bp + i17;
            this.bp = i18;
            this.ch = charAt(i18);
            this.matchStat = 3;
            this.token = 16;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    public String[] scanFieldStringArray(char[] cArr, int i10, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }
}
