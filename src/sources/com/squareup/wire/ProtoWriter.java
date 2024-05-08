package com.squareup.wire;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ProtoWriter {
    private final BufferedSink sink;

    public ProtoWriter(BufferedSink bufferedSink) {
        this.sink = bufferedSink;
    }

    public static int decodeZigZag32(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long decodeZigZag64(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static int encodeZigZag32(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long encodeZigZag64(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int int32Size(int i10) {
        if (i10 >= 0) {
            return varint32Size(i10);
        }
        return 10;
    }

    private static int makeTag(int i10, FieldEncoding fieldEncoding) {
        return (i10 << 3) | fieldEncoding.value;
    }

    public static int tagSize(int i10) {
        return varint32Size(makeTag(i10, FieldEncoding.VARINT));
    }

    public static int utf8Length(String str) {
        int i10;
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i12 += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i12 += 3;
                } else if (charAt <= 56319 && (i10 = i11 + 1) < length && str.charAt(i10) >= 56320 && str.charAt(i10) <= 57343) {
                    i12 += 4;
                    i11 = i10;
                }
                i11++;
            }
            i12++;
            i11++;
        }
        return i12;
    }

    public static int varint32Size(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int varint64Size(long j10) {
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (((-16384) & j10) == 0) {
            return 2;
        }
        if (((-2097152) & j10) == 0) {
            return 3;
        }
        if (((-268435456) & j10) == 0) {
            return 4;
        }
        if (((-34359738368L) & j10) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j10) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j10) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j10) == 0) {
            return 8;
        }
        return (j10 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public void writeBytes(ByteString byteString) throws IOException {
        this.sink.write(byteString);
    }

    public void writeFixed32(int i10) throws IOException {
        this.sink.writeIntLe(i10);
    }

    public void writeFixed64(long j10) throws IOException {
        this.sink.writeLongLe(j10);
    }

    public void writeSignedVarint32(int i10) throws IOException {
        if (i10 >= 0) {
            writeVarint32(i10);
        } else {
            writeVarint64(i10);
        }
    }

    public void writeString(String str) throws IOException {
        this.sink.writeUtf8(str);
    }

    public void writeTag(int i10, FieldEncoding fieldEncoding) throws IOException {
        writeVarint32(makeTag(i10, fieldEncoding));
    }

    public void writeVarint32(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.sink.writeByte((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.sink.writeByte(i10);
    }

    public void writeVarint64(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.sink.writeByte((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.sink.writeByte((int) j10);
    }
}
