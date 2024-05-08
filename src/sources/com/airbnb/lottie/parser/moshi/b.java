package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.android.internal.midi.MidiConstants;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.commons.lang3.CharUtils;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b extends JsonReader {

    /* renamed from: o, reason: collision with root package name */
    public static final ByteString f2104o = ByteString.encodeUtf8("'\\");

    /* renamed from: p, reason: collision with root package name */
    public static final ByteString f2105p = ByteString.encodeUtf8("\"\\");

    /* renamed from: q, reason: collision with root package name */
    public static final ByteString f2106q = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: r, reason: collision with root package name */
    public static final ByteString f2107r = ByteString.encodeUtf8("\n\r");

    /* renamed from: s, reason: collision with root package name */
    public static final ByteString f2108s = ByteString.encodeUtf8("*/");

    /* renamed from: i, reason: collision with root package name */
    public final BufferedSource f2109i;

    /* renamed from: j, reason: collision with root package name */
    public final Buffer f2110j;

    /* renamed from: k, reason: collision with root package name */
    public int f2111k = 0;

    /* renamed from: l, reason: collision with root package name */
    public long f2112l;

    /* renamed from: m, reason: collision with root package name */
    public int f2113m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public String f2114n;

    public b(BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        this.f2109i = bufferedSource;
        this.f2110j = bufferedSource.buffer();
        x(6);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void A() throws IOException {
        if (!this.f2079g) {
            int i10 = 0;
            do {
                int i11 = this.f2111k;
                if (i11 == 0) {
                    i11 = E();
                }
                if (i11 == 3) {
                    x(1);
                } else if (i11 == 1) {
                    x(3);
                } else {
                    if (i11 == 4) {
                        i10--;
                        if (i10 >= 0) {
                            this.f2074b--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + ((Object) w()) + " at path " + g());
                        }
                    } else if (i11 == 2) {
                        i10--;
                        if (i10 >= 0) {
                            this.f2074b--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + ((Object) w()) + " at path " + g());
                        }
                    } else if (i11 == 14 || i11 == 10) {
                        Q();
                    } else if (i11 == 9 || i11 == 13) {
                        N(f2105p);
                    } else if (i11 == 8 || i11 == 12) {
                        N(f2104o);
                    } else if (i11 == 17) {
                        this.f2110j.skip(this.f2113m);
                    } else if (i11 == 18) {
                        throw new JsonDataException("Expected a value but was " + ((Object) w()) + " at path " + g());
                    }
                    this.f2111k = 0;
                }
                i10++;
                this.f2111k = 0;
            } while (i10 != 0);
            int[] iArr = this.f2077e;
            int i12 = this.f2074b;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.f2076d[i12 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + ((Object) w()) + " at " + g());
    }

    public final void D() throws IOException {
        if (!this.f2078f) {
            throw C("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final int E() throws IOException {
        int[] iArr = this.f2075c;
        int i10 = this.f2074b;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int H = H(true);
            this.f2110j.readByte();
            if (H != 44) {
                if (H != 59) {
                    if (H == 93) {
                        this.f2111k = 4;
                        return 4;
                    }
                    throw C("Unterminated array");
                }
                D();
            }
        } else {
            if (i11 == 3 || i11 == 5) {
                iArr[i10 - 1] = 4;
                if (i11 == 5) {
                    int H2 = H(true);
                    this.f2110j.readByte();
                    if (H2 != 44) {
                        if (H2 != 59) {
                            if (H2 == 125) {
                                this.f2111k = 2;
                                return 2;
                            }
                            throw C("Unterminated object");
                        }
                        D();
                    }
                }
                int H3 = H(true);
                if (H3 == 34) {
                    this.f2110j.readByte();
                    this.f2111k = 13;
                    return 13;
                }
                if (H3 == 39) {
                    this.f2110j.readByte();
                    D();
                    this.f2111k = 12;
                    return 12;
                }
                if (H3 != 125) {
                    D();
                    if (G((char) H3)) {
                        this.f2111k = 14;
                        return 14;
                    }
                    throw C("Expected name");
                }
                if (i11 != 5) {
                    this.f2110j.readByte();
                    this.f2111k = 2;
                    return 2;
                }
                throw C("Expected name");
            }
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int H4 = H(true);
                this.f2110j.readByte();
                if (H4 != 58) {
                    if (H4 == 61) {
                        D();
                        if (this.f2109i.request(1L) && this.f2110j.getByte(0L) == 62) {
                            this.f2110j.readByte();
                        }
                    } else {
                        throw C("Expected ':'");
                    }
                }
            } else if (i11 == 6) {
                iArr[i10 - 1] = 7;
            } else if (i11 == 7) {
                if (H(false) == -1) {
                    this.f2111k = 18;
                    return 18;
                }
                D();
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int H5 = H(true);
        if (H5 == 34) {
            this.f2110j.readByte();
            this.f2111k = 9;
            return 9;
        }
        if (H5 == 39) {
            D();
            this.f2110j.readByte();
            this.f2111k = 8;
            return 8;
        }
        if (H5 != 44 && H5 != 59) {
            if (H5 == 91) {
                this.f2110j.readByte();
                this.f2111k = 3;
                return 3;
            }
            if (H5 != 93) {
                if (H5 != 123) {
                    int K = K();
                    if (K != 0) {
                        return K;
                    }
                    int L = L();
                    if (L != 0) {
                        return L;
                    }
                    if (G(this.f2110j.getByte(0L))) {
                        D();
                        this.f2111k = 10;
                        return 10;
                    }
                    throw C("Expected value");
                }
                this.f2110j.readByte();
                this.f2111k = 1;
                return 1;
            }
            if (i11 == 1) {
                this.f2110j.readByte();
                this.f2111k = 4;
                return 4;
            }
        }
        if (i11 != 1 && i11 != 2) {
            throw C("Unexpected value");
        }
        D();
        this.f2111k = 7;
        return 7;
    }

    public final int F(String str, JsonReader.a aVar) {
        int length = aVar.f2080a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f2080a[i10])) {
                this.f2111k = 0;
                this.f2076d[this.f2074b - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    public final boolean G(int i10) throws IOException {
        if (i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13 || i10 == 32) {
            return false;
        }
        if (i10 != 35) {
            if (i10 == 44) {
                return false;
            }
            if (i10 != 47 && i10 != 61) {
                if (i10 == 123 || i10 == 125 || i10 == 58) {
                    return false;
                }
                if (i10 != 59) {
                    switch (i10) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        D();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.f2110j.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r1 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        D();
        P();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r6.f2109i.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003c, code lost:
    
        D();
        r3 = r6.f2110j.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r6.f2110j.readByte();
        r6.f2110j.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        if (O() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        throw C("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        r6.f2110j.readByte();
        r6.f2110j.readByte();
        P();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003b, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int H(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.BufferedSource r2 = r6.f2109i
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            okio.Buffer r2 = r6.f2110j
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            okio.Buffer r2 = r6.f2110j
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.BufferedSource r3 = r6.f2109i
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.D()
            okio.Buffer r3 = r6.f2110j
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.Buffer r1 = r6.f2110j
            r1.readByte()
            okio.Buffer r1 = r6.f2110j
            r1.readByte()
            r6.P()
            goto L1
        L5c:
            okio.Buffer r1 = r6.f2110j
            r1.readByte()
            okio.Buffer r1 = r6.f2110j
            r1.readByte()
            boolean r1 = r6.O()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.C(r7)
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.D()
            r6.P()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.H(boolean):int");
    }

    public final String I(ByteString byteString) throws IOException {
        StringBuilder sb2 = null;
        while (true) {
            long indexOfElement = this.f2109i.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f2110j.getByte(indexOfElement) != 92) {
                    if (sb2 == null) {
                        String readUtf8 = this.f2110j.readUtf8(indexOfElement);
                        this.f2110j.readByte();
                        return readUtf8;
                    }
                    sb2.append(this.f2110j.readUtf8(indexOfElement));
                    this.f2110j.readByte();
                    return sb2.toString();
                }
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.f2110j.readUtf8(indexOfElement));
                this.f2110j.readByte();
                sb2.append(M());
            } else {
                throw C("Unterminated string");
            }
        }
    }

    public final String J() throws IOException {
        long indexOfElement = this.f2109i.indexOfElement(f2106q);
        return indexOfElement != -1 ? this.f2110j.readUtf8(indexOfElement) : this.f2110j.readUtf8();
    }

    public final int K() throws IOException {
        int i10;
        String str;
        String str2;
        byte b4 = this.f2110j.getByte(0L);
        if (b4 == 116 || b4 == 84) {
            i10 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (b4 == 102 || b4 == 70) {
            i10 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (b4 != 110 && b4 != 78) {
                return 0;
            }
            i10 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i11 = 1;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (!this.f2109i.request(i12)) {
                return 0;
            }
            byte b10 = this.f2110j.getByte(i11);
            if (b10 != str.charAt(i11) && b10 != str2.charAt(i11)) {
                return 0;
            }
            i11 = i12;
        }
        if (this.f2109i.request(length + 1) && G(this.f2110j.getByte(length))) {
            return 0;
        }
        this.f2110j.skip(length);
        this.f2111k = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0087, code lost:
    
        if (G(r11) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0089, code lost:
    
        if (r6 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:
    
        if (r7 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r10 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0097, code lost:
    
        if (r8 != 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
    
        if (r10 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009b, code lost:
    
        if (r10 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009e, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        r16.f2112l = r8;
        r16.f2110j.skip(r5);
        r16.f2111k = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ab, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ac, code lost:
    
        if (r6 == 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00af, code lost:
    
        if (r6 == 4) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b2, code lost:
    
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b5, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b7, code lost:
    
        r16.f2113m = r5;
        r16.f2111k = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bd, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00be, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int L() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.L():int");
    }

    public final char M() throws IOException {
        int i10;
        int i11;
        if (this.f2109i.request(1L)) {
            byte readByte = this.f2110j.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return '\b';
            }
            if (readByte == 102) {
                return '\f';
            }
            if (readByte == 110) {
                return '\n';
            }
            if (readByte == 114) {
                return CharUtils.CR;
            }
            if (readByte == 116) {
                return '\t';
            }
            if (readByte != 117) {
                if (this.f2078f) {
                    return (char) readByte;
                }
                throw C("Invalid escape sequence: \\" + ((char) readByte));
            }
            if (this.f2109i.request(4L)) {
                char c4 = 0;
                for (int i12 = 0; i12 < 4; i12++) {
                    byte b4 = this.f2110j.getByte(i12);
                    char c10 = (char) (c4 << 4);
                    if (b4 < 48 || b4 > 57) {
                        if (b4 >= 97 && b4 <= 102) {
                            i10 = b4 - 97;
                        } else {
                            if (b4 < 65 || b4 > 70) {
                                throw C("\\u" + this.f2110j.readUtf8(4L));
                            }
                            i10 = b4 - 65;
                        }
                        i11 = i10 + 10;
                    } else {
                        i11 = b4 + MidiConstants.STATUS_CHANNEL_PRESSURE;
                    }
                    c4 = (char) (c10 + i11);
                }
                this.f2110j.skip(4L);
                return c4;
            }
            throw new EOFException("Unterminated escape sequence at path " + g());
        }
        throw C("Unterminated escape sequence");
    }

    public final void N(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.f2109i.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.f2110j.getByte(indexOfElement) == 92) {
                    this.f2110j.skip(indexOfElement + 1);
                    M();
                } else {
                    this.f2110j.skip(indexOfElement + 1);
                    return;
                }
            } else {
                throw C("Unterminated string");
            }
        }
    }

    public final boolean O() throws IOException {
        long indexOf = this.f2109i.indexOf(f2108s);
        boolean z10 = indexOf != -1;
        Buffer buffer = this.f2110j;
        buffer.skip(z10 ? indexOf + r1.size() : buffer.size());
        return z10;
    }

    public final void P() throws IOException {
        long indexOfElement = this.f2109i.indexOfElement(f2107r);
        Buffer buffer = this.f2110j;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    public final void Q() throws IOException {
        long indexOfElement = this.f2109i.indexOfElement(f2106q);
        Buffer buffer = this.f2110j;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void b() throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 3) {
            x(1);
            this.f2077e[this.f2074b - 1] = 0;
            this.f2111k = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + ((Object) w()) + " at path " + g());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2111k = 0;
        this.f2075c[0] = 8;
        this.f2074b = 1;
        this.f2110j.clear();
        this.f2109i.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void d() throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 1) {
            x(3);
            this.f2111k = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + ((Object) w()) + " at path " + g());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void e() throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 4) {
            int i11 = this.f2074b - 1;
            this.f2074b = i11;
            int[] iArr = this.f2077e;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f2111k = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + ((Object) w()) + " at path " + g());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void f() throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 2) {
            int i11 = this.f2074b - 1;
            this.f2074b = i11;
            this.f2076d[i11] = null;
            int[] iArr = this.f2077e;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f2111k = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + ((Object) w()) + " at path " + g());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean i() throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        return (i10 == 2 || i10 == 4 || i10 == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean j() throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 5) {
            this.f2111k = 0;
            int[] iArr = this.f2077e;
            int i11 = this.f2074b - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        }
        if (i10 == 6) {
            this.f2111k = 0;
            int[] iArr2 = this.f2077e;
            int i12 = this.f2074b - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + ((Object) w()) + " at path " + g());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double k() throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 16) {
            this.f2111k = 0;
            int[] iArr = this.f2077e;
            int i11 = this.f2074b - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f2112l;
        }
        if (i10 == 17) {
            this.f2114n = this.f2110j.readUtf8(this.f2113m);
        } else if (i10 == 9) {
            this.f2114n = I(f2105p);
        } else if (i10 == 8) {
            this.f2114n = I(f2104o);
        } else if (i10 == 10) {
            this.f2114n = J();
        } else if (i10 != 11) {
            throw new JsonDataException("Expected a double but was " + ((Object) w()) + " at path " + g());
        }
        this.f2111k = 11;
        try {
            double parseDouble = Double.parseDouble(this.f2114n);
            if (!this.f2078f && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + g());
            }
            this.f2114n = null;
            this.f2111k = 0;
            int[] iArr2 = this.f2077e;
            int i12 = this.f2074b - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f2114n + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int l() throws IOException {
        String I;
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 16) {
            long j10 = this.f2112l;
            int i11 = (int) j10;
            if (j10 == i11) {
                this.f2111k = 0;
                int[] iArr = this.f2077e;
                int i12 = this.f2074b - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new JsonDataException("Expected an int but was " + this.f2112l + " at path " + g());
        }
        if (i10 == 17) {
            this.f2114n = this.f2110j.readUtf8(this.f2113m);
        } else if (i10 == 9 || i10 == 8) {
            if (i10 == 9) {
                I = I(f2105p);
            } else {
                I = I(f2104o);
            }
            this.f2114n = I;
            try {
                int parseInt = Integer.parseInt(I);
                this.f2111k = 0;
                int[] iArr2 = this.f2077e;
                int i13 = this.f2074b - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i10 != 11) {
            throw new JsonDataException("Expected an int but was " + ((Object) w()) + " at path " + g());
        }
        this.f2111k = 11;
        try {
            double parseDouble = Double.parseDouble(this.f2114n);
            int i14 = (int) parseDouble;
            if (i14 == parseDouble) {
                this.f2114n = null;
                this.f2111k = 0;
                int[] iArr3 = this.f2077e;
                int i15 = this.f2074b - 1;
                iArr3[i15] = iArr3[i15] + 1;
                return i14;
            }
            throw new JsonDataException("Expected an int but was " + this.f2114n + " at path " + g());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f2114n + " at path " + g());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String m() throws IOException {
        String str;
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 14) {
            str = J();
        } else if (i10 == 13) {
            str = I(f2105p);
        } else if (i10 == 12) {
            str = I(f2104o);
        } else if (i10 == 15) {
            str = this.f2114n;
        } else {
            throw new JsonDataException("Expected a name but was " + ((Object) w()) + " at path " + g());
        }
        this.f2111k = 0;
        this.f2076d[this.f2074b - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String r() throws IOException {
        String readUtf8;
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 == 10) {
            readUtf8 = J();
        } else if (i10 == 9) {
            readUtf8 = I(f2105p);
        } else if (i10 == 8) {
            readUtf8 = I(f2104o);
        } else if (i10 == 11) {
            readUtf8 = this.f2114n;
            this.f2114n = null;
        } else if (i10 == 16) {
            readUtf8 = Long.toString(this.f2112l);
        } else if (i10 == 17) {
            readUtf8 = this.f2110j.readUtf8(this.f2113m);
        } else {
            throw new JsonDataException("Expected a string but was " + ((Object) w()) + " at path " + g());
        }
        this.f2111k = 0;
        int[] iArr = this.f2077e;
        int i11 = this.f2074b - 1;
        iArr[i11] = iArr[i11] + 1;
        return readUtf8;
    }

    public String toString() {
        return "JsonReader(" + ((Object) this.f2109i) + ")";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token w() throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        switch (i10) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int y(JsonReader.a aVar) throws IOException {
        int i10 = this.f2111k;
        if (i10 == 0) {
            i10 = E();
        }
        if (i10 < 12 || i10 > 15) {
            return -1;
        }
        if (i10 == 15) {
            return F(this.f2114n, aVar);
        }
        int select = this.f2109i.select(aVar.f2081b);
        if (select != -1) {
            this.f2111k = 0;
            this.f2076d[this.f2074b - 1] = aVar.f2080a[select];
            return select;
        }
        String str = this.f2076d[this.f2074b - 1];
        String m10 = m();
        int F = F(m10, aVar);
        if (F == -1) {
            this.f2111k = 15;
            this.f2114n = m10;
            this.f2076d[this.f2074b - 1] = str;
        }
        return F;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void z() throws IOException {
        if (!this.f2079g) {
            int i10 = this.f2111k;
            if (i10 == 0) {
                i10 = E();
            }
            if (i10 == 14) {
                Q();
            } else if (i10 == 13) {
                N(f2105p);
            } else if (i10 == 12) {
                N(f2104o);
            } else if (i10 != 15) {
                throw new JsonDataException("Expected a name but was " + ((Object) w()) + " at path " + g());
            }
            this.f2111k = 0;
            this.f2076d[this.f2074b - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + ((Object) w()) + " at " + g());
    }
}
