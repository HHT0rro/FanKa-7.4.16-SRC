package com.alibaba.fastjson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class JSONValidator implements Cloneable {
    public char ch;
    public boolean eof;
    public Type type;
    public int pos = -1;
    public int count = 0;
    public boolean supportMultiValue = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ReaderValidator extends JSONValidator {
        private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
        private char[] buf;

        /* renamed from: r, reason: collision with root package name */
        public final Reader f2139r;
        private int end = -1;
        private int readCount = 0;

        public ReaderValidator(Reader reader) {
            this.f2139r = reader;
            ThreadLocal<char[]> threadLocal = bufLocal;
            char[] cArr = threadLocal.get();
            this.buf = cArr;
            if (cArr != null) {
                threadLocal.set(null);
            } else {
                this.buf = new char[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.f2139r.close();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void error() {
            throw new JSONException("error, readCount " + this.readCount + ", valueCount : " + this.count + ", pos " + this.pos);
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int i10 = this.pos;
            if (i10 < this.end) {
                char[] cArr = this.buf;
                int i11 = i10 + 1;
                this.pos = i11;
                this.ch = cArr[i11];
                return;
            }
            if (this.eof) {
                return;
            }
            try {
                Reader reader = this.f2139r;
                char[] cArr2 = this.buf;
                int read = reader.read(cArr2, 0, cArr2.length);
                this.readCount++;
                if (read > 0) {
                    this.ch = this.buf[0];
                    this.pos = 0;
                    this.end = read - 1;
                } else {
                    if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = (char) 0;
                        this.eof = true;
                        return;
                    }
                    this.pos = 0;
                    this.end = 0;
                    this.buf = null;
                    this.ch = (char) 0;
                    this.eof = true;
                    throw new JSONException("read error");
                }
            } catch (IOException unused) {
                throw new JSONException("read error");
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum Type {
        Object,
        Array,
        Value
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class UTF16Validator extends JSONValidator {
        private final String str;

        public UTF16Validator(String str) {
            this.str = str;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int i10 = this.pos + 1;
            this.pos = i10;
            if (i10 >= this.str.length()) {
                this.ch = (char) 0;
                this.eof = true;
            } else {
                this.ch = this.str.charAt(this.pos);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class UTF8InputStreamValidator extends JSONValidator {
        private static final ThreadLocal<byte[]> bufLocal = new ThreadLocal<>();
        private byte[] buf;
        private final InputStream is;
        private int end = -1;
        private int readCount = 0;

        public UTF8InputStreamValidator(InputStream inputStream) {
            this.is = inputStream;
            ThreadLocal<byte[]> threadLocal = bufLocal;
            byte[] bArr = threadLocal.get();
            this.buf = bArr;
            if (bArr != null) {
                threadLocal.set(null);
            } else {
                this.buf = new byte[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.is.close();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void error() {
            throw new JSONException("error, readCount " + this.readCount + ", valueCount : " + this.count + ", pos " + this.pos);
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int i10 = this.pos;
            if (i10 < this.end) {
                byte[] bArr = this.buf;
                int i11 = i10 + 1;
                this.pos = i11;
                this.ch = (char) bArr[i11];
                return;
            }
            if (this.eof) {
                return;
            }
            try {
                InputStream inputStream = this.is;
                byte[] bArr2 = this.buf;
                int read = inputStream.read(bArr2, 0, bArr2.length);
                this.readCount++;
                if (read > 0) {
                    this.ch = (char) this.buf[0];
                    this.pos = 0;
                    this.end = read - 1;
                } else {
                    if (read == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = (char) 0;
                        this.eof = true;
                        return;
                    }
                    this.pos = 0;
                    this.end = 0;
                    this.buf = null;
                    this.ch = (char) 0;
                    this.eof = true;
                    throw new JSONException("read error");
                }
            } catch (IOException unused) {
                throw new JSONException("read error");
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class UTF8Validator extends JSONValidator {
        private final byte[] bytes;

        public UTF8Validator(byte[] bArr) {
            this.bytes = bArr;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int i10 = this.pos + 1;
            this.pos = i10;
            byte[] bArr = this.bytes;
            if (i10 >= bArr.length) {
                this.ch = (char) 0;
                this.eof = true;
            } else {
                this.ch = (char) bArr[i10];
            }
        }
    }

    public static JSONValidator from(String str) {
        return new UTF16Validator(str);
    }

    public static JSONValidator fromUtf8(byte[] bArr) {
        return new UTF8Validator(bArr);
    }

    public static final boolean isWhiteSpace(char c4) {
        return c4 == ' ' || c4 == '\t' || c4 == '\r' || c4 == '\n' || c4 == '\f' || c4 == '\b';
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void any() {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONValidator.any():void");
    }

    public void close() throws IOException {
    }

    public void error() {
        throw new JSONException("error : " + this.pos);
    }

    public void fieldName() {
        next();
        while (true) {
            char c4 = this.ch;
            if (c4 == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else {
                if (c4 == '\"') {
                    next();
                    return;
                }
                next();
            }
        }
    }

    public Type getType() {
        return this.type;
    }

    public abstract void next();

    public void skipWhiteSpace() {
        while (isWhiteSpace(this.ch)) {
            next();
        }
    }

    public boolean validate() {
        do {
            any();
            this.count++;
            if (!this.supportMultiValue || this.eof) {
                break;
            }
            skipWhiteSpace();
        } while (!this.eof);
        return true;
    }

    public static JSONValidator from(Reader reader) {
        return new ReaderValidator(reader);
    }

    public static JSONValidator fromUtf8(InputStream inputStream) {
        return new UTF8InputStreamValidator(inputStream);
    }
}
