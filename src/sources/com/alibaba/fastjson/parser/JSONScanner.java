package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean charArrayCompare(String str, int i10, char[] cArr) {
        int length = cArr.length;
        if (length + i10 > str.length()) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (cArr[i11] != str.charAt(i10 + i11)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(char c4, char c10, char c11, char c12, char c13, char c14, int i10, int i11) {
        if (c4 >= '0' && c4 <= '9' && c10 >= '0' && c10 <= '9' && c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9') {
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
    
        if (r6 <= '4') goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkTime(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto Lc
            if (r6 < r2) goto Lb
            if (r6 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r5 != r3) goto L15
            if (r6 < r2) goto L14
            if (r6 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r5 != r3) goto L42
            if (r6 < r2) goto L42
            r5 = 52
            if (r6 <= r5) goto L20
            goto L42
        L20:
            r5 = 53
            r6 = 54
            if (r7 < r2) goto L2d
            if (r7 > r5) goto L2d
            if (r8 < r2) goto L2c
            if (r8 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r7 != r6) goto L42
            if (r8 == r2) goto L32
            return r1
        L32:
            if (r9 < r2) goto L3b
            if (r9 > r5) goto L3b
            if (r10 < r2) goto L3a
            if (r10 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r9 != r6) goto L42
            if (r10 == r2) goto L40
            return r1
        L40:
            r5 = 1
            return r5
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.checkTime(char, char, char, char, char, char):boolean");
    }

    private void setCalendar(char c4, char c10, char c11, char c12, char c13, char c14, char c15, char c16) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c4 - '0') * 1000) + ((c10 - '0') * 100) + ((c11 - '0') * 10) + (c12 - '0'));
        this.calendar.set(2, (((c13 - '0') * 10) + (c14 - '0')) - 1);
        this.calendar.set(5, ((c15 - '0') * 10) + (c16 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i10, int i11, int i12, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i10, i11, i12);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i10, char[] cArr, int i11, int i12) {
        this.text.getChars(i10, i12 + i10, cArr, i11);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i10 = this.np + 1;
            int i11 = this.sp;
            if (i11 % 2 == 0) {
                int i12 = i11 / 2;
                byte[] bArr = new byte[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = (i13 * 2) + i10;
                    char charAt = this.text.charAt(i14);
                    char charAt2 = this.text.charAt(i14 + 1);
                    char c4 = '0';
                    int i15 = charAt - (charAt <= '9' ? '0' : '7');
                    if (charAt2 > '9') {
                        c4 = '7';
                    }
                    bArr[i13] = (byte) ((i15 << 4) | (charAt2 - c4));
                }
                return bArr;
            }
            throw new JSONException("illegal state. " + i11);
        }
        if (!this.hasSpecial) {
            return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        }
        return IOUtils.decodeBase64(new String(this.sbuf, 0, this.sp));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i10) {
        if (i10 >= this.len) {
            return (char) 26;
        }
        return this.text.charAt(i10);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i10, int i11, char[] cArr) {
        this.text.getChars(i10, i11 + i10, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c4, int i10) {
        return this.text.indexOf(c4, i10);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        while (i10 < this.bp) {
            if (this.text.charAt(i10) == '\n') {
                i11++;
                i12 = 1;
            }
            i10++;
            i12++;
        }
        sb2.append("pos ");
        sb2.append(this.bp);
        sb2.append(", line ");
        sb2.append(i11);
        sb2.append(", column ");
        sb2.append(i12);
        if (this.text.length() < 65535) {
            sb2.append(this.text);
        } else {
            sb2.append(this.text.substring(0, 65535));
        }
        return sb2.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i10 = this.bp;
        int i11 = this.len;
        if (i10 != i11) {
            return this.ch == 26 && i10 + 1 >= i11;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i10 = length + 1;
        char charAt = this.text.charAt(length);
        while (JSONLexerBase.isWhitespace(charAt)) {
            charAt = this.text.charAt(i10);
            i10++;
        }
        if (charAt == ':') {
            this.bp = i10;
            this.ch = charAt(i10);
            return true;
        }
        this.matchStat = -2;
        return false;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i10 = this.bp + 1;
        this.bp = i10;
        char charAt = i10 >= this.len ? (char) 26 : this.text.charAt(i10);
        this.ch = charAt;
        return charAt;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i10 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        return subString(this.np, i10);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c4) {
        char c10;
        long j10;
        Date date;
        int i10;
        boolean z10 = false;
        this.matchStat = 0;
        int i11 = this.bp;
        char c11 = this.ch;
        int i12 = i11 + 1;
        char charAt = charAt(i11);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i12);
            if (indexOf != -1) {
                this.bp = i12;
                if (scanISO8601DateIfMatch(false, indexOf - i12)) {
                    date = this.calendar.getTime();
                    c10 = charAt(indexOf + 1);
                    this.bp = i11;
                    while (c10 != ',' && c10 != ']') {
                        if (JSONLexerBase.isWhitespace(c10)) {
                            indexOf++;
                            c10 = charAt(indexOf + 1);
                        } else {
                            this.bp = i11;
                            this.ch = c11;
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c10;
                } else {
                    this.bp = i11;
                    this.ch = c11;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c12 = '9';
            char c13 = '0';
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                if (charAt == 'n') {
                    int i13 = i12 + 1;
                    if (charAt(i12) == 'u') {
                        int i14 = i13 + 1;
                        if (charAt(i13) == 'l') {
                            int i15 = i14 + 1;
                            if (charAt(i14) == 'l') {
                                c10 = charAt(i15);
                                this.bp = i15;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i11;
                this.ch = c11;
                this.matchStat = -1;
                return null;
            }
            if (charAt == '-') {
                charAt = charAt(i12);
                i12++;
                z10 = true;
            }
            if (charAt < '0' || charAt > '9') {
                c10 = charAt;
                j10 = 0;
            } else {
                j10 = charAt - '0';
                while (true) {
                    i10 = i12 + 1;
                    c10 = charAt(i12);
                    if (c10 < c13 || c10 > c12) {
                        break;
                    }
                    j10 = (j10 * 10) + (c10 - '0');
                    i12 = i10;
                    c12 = '9';
                    c13 = '0';
                }
                if (c10 == ',' || c10 == ']') {
                    this.bp = i10 - 1;
                }
            }
            if (j10 < 0) {
                this.bp = i11;
                this.ch = c11;
                this.matchStat = -1;
                return null;
            }
            if (z10) {
                j10 = -j10;
            }
            date = new Date(j10);
        }
        if (c10 == ',') {
            int i16 = this.bp + 1;
            this.bp = i16;
            this.ch = charAt(i16);
            this.matchStat = 3;
            return date;
        }
        int i17 = this.bp + 1;
        this.bp = i17;
        char charAt2 = charAt(i17);
        if (charAt2 == ',') {
            this.token = 16;
            int i18 = this.bp + 1;
            this.bp = i18;
            this.ch = charAt(i18);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i19 = this.bp + 1;
            this.bp = i19;
            this.ch = charAt(i19);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i20 = this.bp + 1;
            this.bp = i20;
            this.ch = charAt(i20);
        } else if (charAt2 == 26) {
            this.ch = (char) 26;
            this.token = 20;
        } else {
            this.bp = i11;
            this.ch = c11;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c4 -> B:42:0x00b4). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double scanDouble(char r22) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanDouble(char):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0152, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanFieldBoolean(char[] r11) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldBoolean(char[]):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        char c4;
        long j10;
        char c10;
        Date date;
        int i10;
        boolean z10 = false;
        this.matchStat = 0;
        int i11 = this.bp;
        char c11 = this.ch;
        if (!charArrayCompare(this.text, i11, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i12 = length + 1;
        char charAt = charAt(length);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i12);
            if (indexOf != -1) {
                this.bp = i12;
                if (scanISO8601DateIfMatch(false, indexOf - i12)) {
                    date = this.calendar.getTime();
                    c10 = charAt(indexOf + 1);
                    this.bp = i11;
                    while (c10 != ',' && c10 != '}') {
                        if (JSONLexerBase.isWhitespace(c10)) {
                            indexOf++;
                            c10 = charAt(indexOf + 1);
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c10;
                } else {
                    this.bp = i11;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c12 = '9';
            char c13 = '0';
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (charAt == '-') {
                charAt = charAt(i12);
                i12++;
                z10 = true;
            }
            if (charAt < '0' || charAt > '9') {
                c4 = charAt;
                j10 = 0;
            } else {
                j10 = charAt - '0';
                while (true) {
                    i10 = i12 + 1;
                    c4 = charAt(i12);
                    if (c4 < c13 || c4 > c12) {
                        break;
                    }
                    j10 = (j10 * 10) + (c4 - '0');
                    i12 = i10;
                    c12 = '9';
                    c13 = '0';
                }
                if (c4 == ',' || c4 == '}') {
                    this.bp = i10 - 1;
                }
            }
            if (j10 < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z10) {
                j10 = -j10;
            }
            c10 = c4;
            date = new Date(j10);
        }
        if (c10 == ',') {
            int i13 = this.bp + 1;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i14 = this.bp + 1;
        this.bp = i14;
        char charAt2 = charAt(i14);
        if (charAt2 == ',') {
            this.token = 16;
            int i15 = this.bp + 1;
            this.bp = i15;
            this.ch = charAt(i15);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i16 = this.bp + 1;
            this.bp = i16;
            this.ch = charAt(i16);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i17 = this.bp + 1;
            this.bp = i17;
            this.ch = charAt(i17);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.bp = i11;
            this.ch = c11;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        if (r15 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
    
        if (r3 >= 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        if (r6 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0071, code lost:
    
        if (r15 == '\"') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0075, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0076, code lost:
    
        r15 = r11 + 1;
        r4 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007c, code lost:
    
        r11 = r15;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0082, code lost:
    
        if (r15 == ',') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0084, code lost:
    
        if (r15 != '}') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008b, code lost:
    
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r15) == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008d, code lost:
    
        r15 = r11 + 1;
        r4 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007c, code lost:
    
        r11 = r15;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0094, code lost:
    
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0096, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
    
        r11 = r11 - 1;
        r14.bp = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009c, code lost:
    
        if (r15 != ',') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
    
        r11 = r11 + 1;
        r14.bp = r11;
        r14.ch = charAt(r11);
        r14.matchStat = 3;
        r14.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ac, code lost:
    
        if (r7 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00af, code lost:
    
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b0, code lost:
    
        if (r15 != '}') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b2, code lost:
    
        r11 = r11 + 1;
        r14.bp = r11;
        r15 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b9, code lost:
    
        if (r15 != ',') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00cb, code lost:
    
        if (r15 != ']') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00dd, code lost:
    
        if (r15 != '}') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f1, code lost:
    
        if (r15 != 26) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ff, code lost:
    
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r15) == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0101, code lost:
    
        r15 = r14.bp + 1;
        r14.bp = r15;
        r15 = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x010b, code lost:
    
        r14.bp = r1;
        r14.ch = r2;
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0111, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f3, code lost:
    
        r14.token = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f7, code lost:
    
        r14.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00df, code lost:
    
        r14.token = 13;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00cd, code lost:
    
        r14.token = 15;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00bb, code lost:
    
        r14.token = 16;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0112, code lost:
    
        if (r7 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0115, code lost:
    
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
    
        return r3;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int scanFieldInt(char[] r15) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldInt(char[]):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0112, code lost:
    
        r20.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0115, code lost:
    
        if (r11 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0118, code lost:
    
        return -r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return r2;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long scanFieldLong(char[] r21) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldLong(char[]):long");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i10 = this.bp;
        char c4 = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (JSONLexerBase.isWhitespace(this.ch)) {
                next();
            } else {
                this.matchStat = -2;
                return stringDefaultValue();
            }
        }
        int length = this.bp + cArr.length;
        int i11 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i11);
        if (indexOf != -1) {
            String subString = subString(i11, indexOf - i11);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i12 = 0;
                    for (int i13 = indexOf - 1; i13 >= 0 && charAt(i13) == '\\'; i13--) {
                        i12++;
                    }
                    if (i12 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i14 = this.bp;
                int length2 = indexOf - ((cArr.length + i14) + 1);
                subString = JSONLexerBase.readString(sub_chars(i14 + cArr.length + 1, length2), length2);
            }
            char charAt = charAt(indexOf + 1);
            while (charAt != ',' && charAt != '}') {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    indexOf++;
                    charAt = charAt(indexOf + 1);
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int i15 = indexOf + 1;
            this.bp = i15;
            this.ch = charAt;
            if (charAt == ',') {
                int i16 = i15 + 1;
                this.bp = i16;
                this.ch = charAt(i16);
                this.matchStat = 3;
                return subString;
            }
            int i17 = i15 + 1;
            this.bp = i17;
            char charAt2 = charAt(i17);
            if (charAt2 == ',') {
                this.token = 16;
                int i18 = this.bp + 1;
                this.bp = i18;
                this.ch = charAt(i18);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i19 = this.bp + 1;
                this.bp = i19;
                this.ch = charAt(i19);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i20 = this.bp + 1;
                this.bp = i20;
                this.ch = charAt(i20);
            } else if (charAt2 == 26) {
                this.token = 20;
            } else {
                this.bp = i10;
                this.ch = c4;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.matchStat = 4;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00db, code lost:
    
        if (r9 != ']') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00e1, code lost:
    
        if (r3.size() != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00e3, code lost:
    
        r2 = r1 + 1;
        r1 = charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ed, code lost:
    
        r17.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00f0, code lost:
    
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r18, java.lang.Class<?> r19) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i10 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j10 = -3750763034362895579L;
        while (true) {
            int i11 = i10 + 1;
            char charAt = charAt(i10);
            if (charAt == '\"') {
                this.bp = i11;
                char charAt2 = charAt(i11);
                this.ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i12 = this.bp + 1;
                            this.bp = i12;
                            this.ch = charAt(i12);
                        } else if (current == ']') {
                            this.token = 15;
                            int i13 = this.bp + 1;
                            this.bp = i13;
                            this.ch = charAt(i13);
                        } else if (current == '}') {
                            this.token = 13;
                            int i14 = this.bp + 1;
                            this.bp = i14;
                            this.ch = charAt(i14);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j10;
                    }
                    if (JSONLexerBase.isWhitespace(charAt2)) {
                        int i15 = this.bp + 1;
                        this.bp = i15;
                        charAt2 = charAt(i15);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i16 = this.bp + 1;
                this.bp = i16;
                this.ch = charAt(i16);
                this.matchStat = 3;
                return j10;
            }
            if (i11 > this.len) {
                this.matchStat = -1;
                return 0L;
            }
            j10 = (j10 ^ charAt) * 1099511628211L;
            i10 = i11;
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
    
        if (r3 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        if (r7 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        if (r3 == '\"') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r3 = charAt(r13);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0093, code lost:
    
        if (r4 >= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0097, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
    
        if (r3 != r17) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b1, code lost:
    
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r3) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b3, code lost:
    
        r3 = charAt(r13);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bb, code lost:
    
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bd, code lost:
    
        if (r8 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c0, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009c, code lost:
    
        r16.bp = r13;
        r16.ch = charAt(r13);
        r16.matchStat = 3;
        r16.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a9, code lost:
    
        if (r8 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ac, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return r4;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int scanInt(char r17) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanInt(char):int");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c4) {
        int i10;
        char charAt;
        boolean z10 = false;
        this.matchStat = 0;
        int i11 = this.bp;
        int i12 = i11 + 1;
        char charAt2 = charAt(i11);
        boolean z11 = charAt2 == '\"';
        if (z11) {
            int i13 = i12 + 1;
            char charAt3 = charAt(i12);
            i12 = i13;
            charAt2 = charAt3;
        }
        boolean z12 = charAt2 == '-';
        if (z12) {
            int i14 = i12 + 1;
            char charAt4 = charAt(i12);
            i12 = i14;
            charAt2 = charAt4;
        }
        char c10 = '0';
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j10 = charAt2 - '0';
            while (true) {
                i10 = i12 + 1;
                charAt = charAt(i12);
                if (charAt < c10 || charAt > '9') {
                    break;
                }
                j10 = (j10 * 10) + (charAt - '0');
                i12 = i10;
                c10 = '0';
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z11) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                charAt = charAt(i10);
                i10++;
            }
            if (j10 >= 0 || (j10 == Long.MIN_VALUE && z12)) {
                z10 = true;
            }
            if (!z10) {
                this.matchStat = -1;
                return 0L;
            }
            while (charAt != c4) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i10);
                    i10++;
                } else {
                    this.matchStat = -1;
                    return j10;
                }
            }
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return z12 ? -j10 : j10;
        }
        if (charAt2 == 'n') {
            int i15 = i12 + 1;
            if (charAt(i12) == 'u') {
                int i16 = i15 + 1;
                if (charAt(i15) == 'l') {
                    int i17 = i16 + 1;
                    if (charAt(i16) == 'l') {
                        this.matchStat = 5;
                        int i18 = i17 + 1;
                        char charAt5 = charAt(i17);
                        if (z11 && charAt5 == '\"') {
                            int i19 = i18 + 1;
                            char charAt6 = charAt(i18);
                            i18 = i19;
                            charAt5 = charAt6;
                        }
                        while (charAt5 != ',') {
                            if (charAt5 == ']') {
                                this.bp = i18;
                                this.ch = charAt(i18);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            }
                            if (JSONLexerBase.isWhitespace(charAt5)) {
                                int i20 = i18 + 1;
                                char charAt7 = charAt(i18);
                                i18 = i20;
                                charAt5 = charAt7;
                            } else {
                                this.matchStat = -1;
                                return 0L;
                            }
                        }
                        this.bp = i18;
                        this.ch = charAt(i18);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean seekArrayToItem(int i10) {
        if (i10 >= 0) {
            int i11 = this.token;
            if (i11 == 20) {
                return false;
            }
            if (i11 != 14) {
                throw new UnsupportedOperationException();
            }
            int i12 = 0;
            while (true) {
                boolean z10 = true;
                if (i12 < i10) {
                    skipWhitespace();
                    char c4 = this.ch;
                    if (c4 != '\"' && c4 != '\'') {
                        if (c4 == '{') {
                            next();
                            this.token = 12;
                            skipObject(false);
                        } else if (c4 == '[') {
                            next();
                            this.token = 14;
                            skipArray(false);
                        } else {
                            int i13 = this.bp + 1;
                            while (true) {
                                if (i13 >= this.text.length()) {
                                    z10 = false;
                                    break;
                                }
                                char charAt = this.text.charAt(i13);
                                if (charAt == ',') {
                                    int i14 = i13 + 1;
                                    this.bp = i14;
                                    this.ch = charAt(i14);
                                    break;
                                }
                                if (charAt == ']') {
                                    int i15 = i13 + 1;
                                    this.bp = i15;
                                    this.ch = charAt(i15);
                                    nextToken();
                                    return false;
                                }
                                i13++;
                            }
                            if (!z10) {
                                throw new JSONException("illegal json.");
                            }
                        }
                        int i16 = this.token;
                        if (i16 != 16) {
                            if (i16 == 15) {
                                return false;
                            }
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        skipString();
                        char c10 = this.ch;
                        if (c10 != ',') {
                            if (c10 == ']') {
                                next();
                                nextToken(16);
                                return false;
                            }
                            throw new JSONException("illegal json.");
                        }
                        next();
                    }
                    i12++;
                } else {
                    nextToken();
                    return true;
                }
            }
        } else {
            throw new IllegalArgumentException("index must > 0, but " + i10);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long j10, boolean z10) {
        char c4;
        int i10 = this.token;
        int i11 = -1;
        if (i10 == 20) {
            return -1;
        }
        if (i10 != 13) {
            int i12 = 15;
            if (i10 != 15) {
                int i13 = 16;
                if (i10 != 12 && i10 != 16) {
                    throw new UnsupportedOperationException(JSONToken.name(this.token));
                }
                while (true) {
                    char c10 = this.ch;
                    if (c10 == '}') {
                        next();
                        nextToken();
                        return i11;
                    }
                    if (c10 == 26) {
                        return i11;
                    }
                    if (c10 != '\"') {
                        skipWhitespace();
                    }
                    if (this.ch == '\"') {
                        long j11 = -3750763034362895579L;
                        int i14 = this.bp + 1;
                        while (true) {
                            if (i14 >= this.text.length()) {
                                break;
                            }
                            char charAt = this.text.charAt(i14);
                            if (charAt == '\\') {
                                i14++;
                                if (i14 != this.text.length()) {
                                    charAt = this.text.charAt(i14);
                                } else {
                                    throw new JSONException("unclosed str, " + info());
                                }
                            }
                            if (charAt == '\"') {
                                int i15 = i14 + 1;
                                this.bp = i15;
                                this.ch = i15 >= this.text.length() ? (char) 26 : this.text.charAt(this.bp);
                            } else {
                                j11 = (j11 ^ charAt) * 1099511628211L;
                                i14++;
                            }
                        }
                        if (j11 == j10) {
                            if (this.ch != ':') {
                                skipWhitespace();
                            }
                            if (this.ch != ':') {
                                return 3;
                            }
                            int i16 = this.bp + 1;
                            this.bp = i16;
                            char charAt2 = i16 >= this.text.length() ? (char) 26 : this.text.charAt(i16);
                            this.ch = charAt2;
                            if (charAt2 == ',') {
                                int i17 = this.bp + 1;
                                this.bp = i17;
                                this.ch = i17 >= this.text.length() ? (char) 26 : this.text.charAt(i17);
                                this.token = i13;
                                return 3;
                            }
                            if (charAt2 == ']') {
                                int i18 = this.bp + 1;
                                this.bp = i18;
                                this.ch = i18 >= this.text.length() ? (char) 26 : this.text.charAt(i18);
                                this.token = i12;
                                return 3;
                            }
                            if (charAt2 == '}') {
                                int i19 = this.bp + 1;
                                this.bp = i19;
                                this.ch = i19 >= this.text.length() ? (char) 26 : this.text.charAt(i19);
                                this.token = 13;
                                return 3;
                            }
                            if (charAt2 >= '0' && charAt2 <= '9') {
                                this.sp = 0;
                                this.pos = this.bp;
                                scanNumber();
                                return 3;
                            }
                            nextToken(2);
                            return 3;
                        }
                        if (this.ch != ':') {
                            skipWhitespace();
                        }
                        if (this.ch == ':') {
                            int i20 = this.bp + 1;
                            this.bp = i20;
                            char charAt3 = i20 >= this.text.length() ? (char) 26 : this.text.charAt(i20);
                            this.ch = charAt3;
                            if (charAt3 != '\"' && charAt3 != '\'' && charAt3 != '{' && charAt3 != '[' && charAt3 != '0' && charAt3 != '1' && charAt3 != '2' && charAt3 != '3' && charAt3 != '4' && charAt3 != '5' && charAt3 != '6' && charAt3 != '7' && charAt3 != '8' && charAt3 != '9' && charAt3 != '+' && charAt3 != '-') {
                                skipWhitespace();
                            }
                            char c11 = this.ch;
                            if (c11 == '-' || c11 == '+' || (c11 >= '0' && c11 <= '9')) {
                                next();
                                while (true) {
                                    c4 = this.ch;
                                    if (c4 < '0' || c4 > '9') {
                                        break;
                                    }
                                    next();
                                }
                                if (c4 == '.') {
                                    next();
                                    while (true) {
                                        char c12 = this.ch;
                                        if (c12 < '0' || c12 > '9') {
                                            break;
                                        }
                                        next();
                                    }
                                }
                                char c13 = this.ch;
                                if (c13 == 'E' || c13 == 'e') {
                                    next();
                                    char c14 = this.ch;
                                    if (c14 == '-' || c14 == '+') {
                                        next();
                                    }
                                    while (true) {
                                        char c15 = this.ch;
                                        if (c15 < '0' || c15 > '9') {
                                            break;
                                        }
                                        next();
                                    }
                                }
                                if (this.ch != ',') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c11 == '\"') {
                                skipString();
                                char c16 = this.ch;
                                if (c16 != ',' && c16 != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c11 == 't') {
                                next();
                                if (this.ch == 'r') {
                                    next();
                                    if (this.ch == 'u') {
                                        next();
                                        if (this.ch == 'e') {
                                            next();
                                        }
                                    }
                                }
                                char c17 = this.ch;
                                if (c17 != ',' && c17 != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c11 == 'n') {
                                next();
                                if (this.ch == 'u') {
                                    next();
                                    if (this.ch == 'l') {
                                        next();
                                        if (this.ch == 'l') {
                                            next();
                                        }
                                    }
                                }
                                char c18 = this.ch;
                                if (c18 != ',' && c18 != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c11 == 'f') {
                                next();
                                if (this.ch == 'a') {
                                    next();
                                    if (this.ch == 'l') {
                                        next();
                                        if (this.ch == 's') {
                                            next();
                                            if (this.ch == 'e') {
                                                next();
                                            }
                                        }
                                    }
                                }
                                char c19 = this.ch;
                                if (c19 != ',' && c19 != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (c11 == '{') {
                                int i21 = this.bp + 1;
                                this.bp = i21;
                                this.ch = i21 >= this.text.length() ? (char) 26 : this.text.charAt(i21);
                                if (z10) {
                                    this.token = 12;
                                    return 1;
                                }
                                skipObject(false);
                                if (this.token == 13) {
                                    return -1;
                                }
                            } else if (c11 == '[') {
                                next();
                                if (z10) {
                                    this.token = 14;
                                    return 2;
                                }
                                skipArray(false);
                                if (this.token == 13) {
                                    return -1;
                                }
                            } else {
                                throw new UnsupportedOperationException();
                            }
                            i11 = -1;
                            i12 = 15;
                            i13 = 16;
                        } else {
                            throw new JSONException("illegal json, " + info());
                        }
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        nextToken();
        return -1;
    }

    public void setTime(char c4, char c10, char c11, char c12, char c13, char c14) {
        this.calendar.set(11, ((c4 - '0') * 10) + (c10 - '0'));
        this.calendar.set(12, ((c11 - '0') * 10) + (c12 - '0'));
        this.calendar.set(13, ((c13 - '0') * 10) + (c14 - '0'));
    }

    public void setTimeZone(char c4, char c10, char c11) {
        setTimeZone(c4, c10, c11, '0', '0');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        skipArray(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject() {
        skipObject(false);
    }

    public final void skipString() {
        if (this.ch == '\"') {
            int i10 = this.bp;
            while (true) {
                i10++;
                if (i10 < this.text.length()) {
                    char charAt = this.text.charAt(i10);
                    if (charAt == '\\') {
                        if (i10 < this.len - 1) {
                            i10++;
                        }
                    } else if (charAt == '\"') {
                        String str = this.text;
                        int i11 = i10 + 1;
                        this.bp = i11;
                        this.ch = str.charAt(i11);
                        return;
                    }
                } else {
                    throw new JSONException("unclosed str");
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i10, int i11) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i11 < cArr.length) {
                this.text.getChars(i10, i10 + i11, cArr, 0);
                return new String(this.sbuf, 0, i11);
            }
            char[] cArr2 = new char[i11];
            this.text.getChars(i10, i11 + i10, cArr2, 0);
            return new String(cArr2);
        }
        return this.text.substring(i10, i11 + i10);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i10, int i11) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i11 < cArr.length) {
                this.text.getChars(i10, i11 + i10, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i11];
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i10) {
        super(i10);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z10) {
        return scanISO8601DateIfMatch(z10, this.len - this.bp);
    }

    public void setTimeZone(char c4, char c10, char c11, char c12, char c13) {
        int i10 = ((((c10 - '0') * 10) + (c11 - '0')) * SdkConfigData.DEFAULT_REQUEST_INTERVAL * 1000) + ((((c12 - '0') * 10) + (c13 - '0')) * 60 * 1000);
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

    public final void skipArray(boolean z10) {
        int i10 = this.bp;
        boolean z11 = false;
        int i11 = 0;
        while (i10 < this.text.length()) {
            char charAt = this.text.charAt(i10);
            if (charAt == '\\') {
                if (i10 >= this.len - 1) {
                    this.ch = charAt;
                    this.bp = i10;
                    throw new JSONException("illegal str, " + info());
                }
                i10++;
            } else if (charAt == '\"') {
                z11 = !z11;
            } else if (charAt != '[') {
                if (charAt == '{' && z10) {
                    int i12 = this.bp + 1;
                    this.bp = i12;
                    this.ch = i12 < this.text.length() ? this.text.charAt(i12) : (char) 26;
                    skipObject(z10);
                } else if (charAt == ']' && !z11 && i11 - 1 == -1) {
                    int i13 = i10 + 1;
                    this.bp = i13;
                    if (i13 == this.text.length()) {
                        this.ch = (char) 26;
                        this.token = 20;
                        return;
                    } else {
                        this.ch = this.text.charAt(this.bp);
                        nextToken(16);
                        return;
                    }
                }
            } else if (!z11) {
                i11++;
            }
            i10++;
        }
        if (i10 != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean z10) {
        int i10 = this.bp;
        boolean z11 = false;
        int i11 = 0;
        while (i10 < this.text.length()) {
            char charAt = this.text.charAt(i10);
            if (charAt == '\\') {
                if (i10 >= this.len - 1) {
                    this.ch = charAt;
                    this.bp = i10;
                    throw new JSONException("illegal str, " + info());
                }
                i10++;
            } else if (charAt == '\"') {
                z11 = !z11;
            } else if (charAt == '{') {
                if (!z11) {
                    i11++;
                }
            } else if (charAt == '}' && !z11 && i11 - 1 == -1) {
                int i12 = i10 + 1;
                this.bp = i12;
                if (i12 == this.text.length()) {
                    this.ch = (char) 26;
                    this.token = 20;
                    return;
                }
                char charAt2 = this.text.charAt(this.bp);
                this.ch = charAt2;
                if (charAt2 == ',') {
                    this.token = 16;
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    this.ch = i13 < this.text.length() ? this.text.charAt(i13) : (char) 26;
                    return;
                }
                if (charAt2 == '}') {
                    this.token = 13;
                    next();
                    return;
                } else if (charAt2 == ']') {
                    this.token = 15;
                    next();
                    return;
                } else {
                    nextToken(16);
                    return;
                }
            }
            i10++;
        }
        if (i10 != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0210 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0212  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean scanISO8601DateIfMatch(boolean r35, int r36) {
        /*
            Method dump skipped, instructions count: 1782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i10) {
        this(cArr, i10, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i10, int i11) {
        this(new String(cArr, 0, i10), i11);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i10, SymbolTable symbolTable) {
        int i11;
        char c4;
        int i12 = this.bp;
        char c10 = this.ch;
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i13 = length + 1;
            char charAt = this.text.charAt(length);
            while (JSONLexerBase.isWhitespace(charAt)) {
                charAt = this.text.charAt(i13);
                i13++;
            }
            if (charAt == ':') {
                i11 = i13 + 1;
                c4 = this.text.charAt(i13);
                while (JSONLexerBase.isWhitespace(c4)) {
                    c4 = this.text.charAt(i11);
                    i11++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i11 = this.bp + 1;
            c4 = this.ch;
        }
        if (c4 == '[') {
            this.bp = i11;
            this.ch = this.text.charAt(i11);
            String[] strArr = i10 >= 0 ? new String[i10] : new String[4];
            int i14 = 0;
            while (true) {
                if (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                } else {
                    if (this.ch != '\"') {
                        this.bp = i12;
                        this.ch = c10;
                        this.matchStat = -1;
                        return null;
                    }
                    String scanSymbol = scanSymbol(symbolTable, '\"');
                    if (i14 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i15 = i14 + 1;
                    strArr[i14] = scanSymbol;
                    while (JSONLexerBase.isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i14 = i15;
                    } else {
                        if (strArr.length != i15) {
                            String[] strArr3 = new String[i15];
                            System.arraycopy(strArr, 0, strArr3, 0, i15);
                            strArr = strArr3;
                        }
                        while (JSONLexerBase.isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i12;
                        this.ch = c10;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else {
            if (c4 == 'n' && this.text.startsWith("ull", this.bp + 1)) {
                int i16 = this.bp + 4;
                this.bp = i16;
                this.ch = this.text.charAt(i16);
                return null;
            }
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long[] jArr) {
        char c4;
        int i10 = this.token;
        if (i10 != 12 && i10 != 16) {
            throw new UnsupportedOperationException();
        }
        while (true) {
            char c10 = this.ch;
            if (c10 == '}') {
                next();
                nextToken();
                this.matchStat = -1;
                return -1;
            }
            if (c10 == 26) {
                this.matchStat = -1;
                return -1;
            }
            if (c10 != '\"') {
                skipWhitespace();
            }
            if (this.ch == '\"') {
                long j10 = -3750763034362895579L;
                int i11 = this.bp;
                while (true) {
                    i11++;
                    if (i11 >= this.text.length()) {
                        break;
                    }
                    char charAt = this.text.charAt(i11);
                    if (charAt == '\\') {
                        i11++;
                        if (i11 != this.text.length()) {
                            charAt = this.text.charAt(i11);
                        } else {
                            throw new JSONException("unclosed str, " + info());
                        }
                    }
                    if (charAt == '\"') {
                        int i12 = i11 + 1;
                        this.bp = i12;
                        this.ch = i12 >= this.text.length() ? (char) 26 : this.text.charAt(this.bp);
                    } else {
                        j10 = (j10 ^ charAt) * 1099511628211L;
                    }
                }
                int i13 = 0;
                while (true) {
                    if (i13 >= jArr.length) {
                        i13 = -1;
                        break;
                    }
                    if (j10 == jArr[i13]) {
                        break;
                    }
                    i13++;
                }
                if (i13 != -1) {
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i14 = this.bp + 1;
                        this.bp = i14;
                        char charAt2 = i14 >= this.text.length() ? (char) 26 : this.text.charAt(i14);
                        this.ch = charAt2;
                        if (charAt2 == ',') {
                            int i15 = this.bp + 1;
                            this.bp = i15;
                            this.ch = i15 < this.text.length() ? this.text.charAt(i15) : (char) 26;
                            this.token = 16;
                        } else if (charAt2 == ']') {
                            int i16 = this.bp + 1;
                            this.bp = i16;
                            this.ch = i16 < this.text.length() ? this.text.charAt(i16) : (char) 26;
                            this.token = 15;
                        } else if (charAt2 == '}') {
                            int i17 = this.bp + 1;
                            this.bp = i17;
                            this.ch = i17 < this.text.length() ? this.text.charAt(i17) : (char) 26;
                            this.token = 13;
                        } else if (charAt2 >= '0' && charAt2 <= '9') {
                            this.sp = 0;
                            this.pos = this.bp;
                            scanNumber();
                        } else {
                            nextToken(2);
                        }
                    }
                    this.matchStat = 3;
                    return i13;
                }
                if (this.ch != ':') {
                    skipWhitespace();
                }
                if (this.ch == ':') {
                    int i18 = this.bp + 1;
                    this.bp = i18;
                    char charAt3 = i18 >= this.text.length() ? (char) 26 : this.text.charAt(i18);
                    this.ch = charAt3;
                    if (charAt3 != '\"' && charAt3 != '\'' && charAt3 != '{' && charAt3 != '[' && charAt3 != '0' && charAt3 != '1' && charAt3 != '2' && charAt3 != '3' && charAt3 != '4' && charAt3 != '5' && charAt3 != '6' && charAt3 != '7' && charAt3 != '8' && charAt3 != '9' && charAt3 != '+' && charAt3 != '-') {
                        skipWhitespace();
                    }
                    char c11 = this.ch;
                    if (c11 == '-' || c11 == '+' || (c11 >= '0' && c11 <= '9')) {
                        next();
                        while (true) {
                            c4 = this.ch;
                            if (c4 < '0' || c4 > '9') {
                                break;
                            }
                            next();
                        }
                        if (c4 == '.') {
                            next();
                            while (true) {
                                char c12 = this.ch;
                                if (c12 < '0' || c12 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        char c13 = this.ch;
                        if (c13 == 'E' || c13 == 'e') {
                            next();
                            char c14 = this.ch;
                            if (c14 == '-' || c14 == '+') {
                                next();
                            }
                            while (true) {
                                char c15 = this.ch;
                                if (c15 < '0' || c15 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        if (this.ch != ',') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c11 == '\"') {
                        skipString();
                        char c16 = this.ch;
                        if (c16 != ',' && c16 != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c11 == '{') {
                        int i19 = this.bp + 1;
                        this.bp = i19;
                        this.ch = i19 < this.text.length() ? this.text.charAt(i19) : (char) 26;
                        skipObject(false);
                    } else if (c11 == '[') {
                        next();
                        skipArray(false);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    throw new JSONException("illegal json, " + info());
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }
}
