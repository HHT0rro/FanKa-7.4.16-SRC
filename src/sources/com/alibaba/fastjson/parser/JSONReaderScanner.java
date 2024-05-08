package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class JSONReaderScanner extends JSONLexerBase {
    private static final ThreadLocal<char[]> BUF_LOCAL = new ThreadLocal<>();
    private char[] buf;
    private int bufLength;
    private Reader reader;

    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i10, int i11, int i12, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i10, i11, i12);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i10, char[] cArr, int i11, int i12) {
        System.arraycopy((Object) this.buf, i10, (Object) cArr, i11, i12);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token != 26) {
            return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
        }
        throw new JSONException("TODO");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        for (int i10 = 0; i10 < cArr.length; i10++) {
            if (charAt(this.bp + i10) != cArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i10) {
        int i11 = this.bufLength;
        if (i10 >= i11) {
            if (i11 == -1) {
                if (i10 < this.sp) {
                    return this.buf[i10];
                }
                return (char) 26;
            }
            int i12 = this.bp;
            if (i12 == 0) {
                char[] cArr = this.buf;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy((Object) cArr, i12, (Object) cArr2, 0, i11);
                int i13 = this.bufLength;
                try {
                    this.bufLength += this.reader.read(cArr2, i13, length - i13);
                    this.buf = cArr2;
                } catch (IOException e2) {
                    throw new JSONException(e2.getMessage(), e2);
                }
            } else {
                int i14 = i11 - i12;
                if (i14 > 0) {
                    char[] cArr3 = this.buf;
                    System.arraycopy((Object) cArr3, i12, (Object) cArr3, 0, i14);
                }
                try {
                    Reader reader = this.reader;
                    char[] cArr4 = this.buf;
                    int read = reader.read(cArr4, i14, cArr4.length - i14);
                    this.bufLength = read;
                    if (read == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    }
                    if (read == -1) {
                        return (char) 26;
                    }
                    this.bufLength = read + i14;
                    int i15 = this.bp;
                    i10 -= i15;
                    this.np -= i15;
                    this.bp = 0;
                } catch (IOException e10) {
                    throw new JSONException(e10.getMessage(), e10);
                }
            }
        }
        return this.buf[i10];
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            BUF_LOCAL.set(cArr);
        }
        this.buf = null;
        IOUtils.close(this.reader);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i10, int i11, char[] cArr) {
        System.arraycopy((Object) this.buf, i10, (Object) cArr, 0, i11);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        int i10 = this.np;
        if (i10 == -1) {
            i10 = 0;
        }
        char charAt = charAt((this.sp + i10) - 1);
        int i11 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i11--;
        }
        return new BigDecimal(this.buf, i10, i11);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c4, int i10) {
        int i11 = i10 - this.bp;
        while (true) {
            char charAt = charAt(this.bp + i11);
            if (c4 == charAt) {
                return i11 + this.bp;
            }
            if (charAt == 26) {
                return -1;
            }
            i11++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i10 = 0;
        while (true) {
            char c4 = this.buf[i10];
            if (c4 == 26) {
                this.token = 20;
                return true;
            }
            if (!JSONLexerBase.isWhitespace(c4)) {
                return false;
            }
            i10++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        if (this.bufLength == -1) {
            return true;
        }
        int i10 = this.bp;
        char[] cArr = this.buf;
        if (i10 != cArr.length) {
            return this.ch == 26 && i10 + 1 >= cArr.length;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i10 = this.bp + 1;
        this.bp = i10;
        int i11 = this.bufLength;
        if (i10 >= i11) {
            if (i11 == -1) {
                return (char) 26;
            }
            int i12 = this.sp;
            if (i12 > 0) {
                int i13 = i11 - i12;
                if (this.ch == '\"' && i13 > 0) {
                    i13--;
                }
                char[] cArr = this.buf;
                System.arraycopy((Object) cArr, i13, (Object) cArr, 0, i12);
            }
            this.np = -1;
            int i14 = this.sp;
            this.bp = i14;
            try {
                char[] cArr2 = this.buf;
                int length = cArr2.length - i14;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    System.arraycopy((Object) cArr2, 0, (Object) cArr3, 0, cArr2.length);
                    this.buf = cArr3;
                    length = cArr3.length - i14;
                }
                int read = this.reader.read(this.buf, this.bp, length);
                this.bufLength = read;
                if (read == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                }
                if (read == -1) {
                    this.ch = (char) 26;
                    return (char) 26;
                }
                this.bufLength = read + this.bp;
                i10 = i14;
            } catch (IOException e2) {
                throw new JSONException(e2.getMessage(), e2);
            }
        }
        char c4 = this.buf[i10];
        this.ch = c4;
        return c4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        int i10 = this.np;
        if (i10 == -1) {
            i10 = 0;
        }
        char charAt = charAt((this.sp + i10) - 1);
        int i11 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i11--;
        }
        return new String(this.buf, i10, i11);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            int i10 = this.np + 1;
            if (i10 >= 0) {
                char[] cArr = this.buf;
                int length = cArr.length;
                int i11 = this.sp;
                if (i10 <= length - i11) {
                    return new String(cArr, i10, i11);
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i10, int i11) {
        if (i11 >= 0) {
            return new String(this.buf, i10, i11);
        }
        throw new StringIndexOutOfBoundsException(i11);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i10, int i11) {
        if (i11 < 0) {
            throw new StringIndexOutOfBoundsException(i11);
        }
        if (i10 == 0) {
            return this.buf;
        }
        char[] cArr = new char[i11];
        System.arraycopy((Object) this.buf, i10, (Object) cArr, 0, i11);
        return cArr;
    }

    public JSONReaderScanner(String str, int i10) {
        this(new StringReader(str), i10);
    }

    public JSONReaderScanner(char[] cArr, int i10) {
        this(cArr, i10, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader) {
        this(reader, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader, int i10) {
        super(i10);
        this.reader = reader;
        ThreadLocal<char[]> threadLocal = BUF_LOCAL;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[16384];
        }
        try {
            this.bufLength = reader.read(this.buf);
            this.bp = -1;
            next();
            if (this.ch == 65279) {
                next();
            }
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public JSONReaderScanner(char[] cArr, int i10, int i11) {
        this(new CharArrayReader(cArr, 0, i10), i11);
    }
}
