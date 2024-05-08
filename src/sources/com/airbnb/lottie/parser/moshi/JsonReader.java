package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f2073h = new String[128];

    /* renamed from: b, reason: collision with root package name */
    public int f2074b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f2075c = new int[32];

    /* renamed from: d, reason: collision with root package name */
    public String[] f2076d = new String[32];

    /* renamed from: e, reason: collision with root package name */
    public int[] f2077e = new int[32];

    /* renamed from: f, reason: collision with root package name */
    public boolean f2078f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2079g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f2080a;

        /* renamed from: b, reason: collision with root package name */
        public final Options f2081b;

        public a(String[] strArr, Options options) {
            this.f2080a = strArr;
            this.f2081b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    JsonReader.B(buffer, strArr[i10]);
                    buffer.readByte();
                    byteStringArr[i10] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f2073h[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f2073h;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void B(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.f2073h
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.B(okio.BufferedSink, java.lang.String):void");
    }

    public static JsonReader u(BufferedSource bufferedSource) {
        return new b(bufferedSource);
    }

    public abstract void A() throws IOException;

    public final JsonEncodingException C(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + g());
    }

    public abstract void b() throws IOException;

    public abstract void d() throws IOException;

    public abstract void e() throws IOException;

    public abstract void f() throws IOException;

    public final String g() {
        return com.airbnb.lottie.parser.moshi.a.a(this.f2074b, this.f2075c, this.f2076d, this.f2077e);
    }

    public abstract boolean i() throws IOException;

    public abstract boolean j() throws IOException;

    public abstract double k() throws IOException;

    public abstract int l() throws IOException;

    public abstract String m() throws IOException;

    public abstract String r() throws IOException;

    public abstract Token w() throws IOException;

    public final void x(int i10) {
        int i11 = this.f2074b;
        int[] iArr = this.f2075c;
        if (i11 == iArr.length) {
            if (i11 != 256) {
                this.f2075c = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f2076d;
                this.f2076d = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f2077e;
                this.f2077e = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + g());
            }
        }
        int[] iArr3 = this.f2075c;
        int i12 = this.f2074b;
        this.f2074b = i12 + 1;
        iArr3[i12] = i10;
    }

    public abstract int y(a aVar) throws IOException;

    public abstract void z() throws IOException;
}
