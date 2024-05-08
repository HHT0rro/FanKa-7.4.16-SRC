package io.grpc.internal;

import com.google.common.base.c;
import com.google.common.io.BaseEncoding;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TransportFrameUtil {
    private static final Logger logger = Logger.getLogger(TransportFrameUtil.class.getName());
    private static final byte[] binaryHeaderSuffixBytes = Metadata.BINARY_HEADER_SUFFIX.getBytes(c.f25959a);

    private TransportFrameUtil() {
    }

    private static boolean endsWith(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i10 = length; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10 - length]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSpecCompliantAscii(byte[] bArr) {
        for (byte b4 : bArr) {
            if (b4 < 32 || b4 > 126) {
                return false;
            }
        }
        return true;
    }

    private static byte[][] serializeHeadersWithCommasInBin(byte[][] bArr, int i10) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(bArr[i11]);
        }
        while (i10 < bArr.length) {
            byte[] bArr2 = bArr[i10];
            byte[] bArr3 = bArr[i10 + 1];
            if (!endsWith(bArr2, binaryHeaderSuffixBytes)) {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            } else {
                int i12 = 0;
                for (int i13 = 0; i13 <= bArr3.length; i13++) {
                    if (i13 == bArr3.length || bArr3[i13] == 44) {
                        byte[] b4 = BaseEncoding.a().b(new String(bArr3, i12, i13 - i12, c.f25959a));
                        arrayList.add(bArr2);
                        arrayList.add(b4);
                        i12 = i13 + 1;
                    }
                }
            }
            i10 += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0]);
    }

    public static byte[][] toHttp2Headers(Metadata metadata) {
        byte[][] serialize = InternalMetadata.serialize(metadata);
        if (serialize == null) {
            return new byte[0];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < serialize.length; i11 += 2) {
            byte[] bArr = serialize[i11];
            byte[] bArr2 = serialize[i11 + 1];
            if (endsWith(bArr, binaryHeaderSuffixBytes)) {
                serialize[i10] = bArr;
                serialize[i10 + 1] = InternalMetadata.BASE64_ENCODING_OMIT_PADDING.e(bArr2).getBytes(c.f25959a);
            } else if (isSpecCompliantAscii(bArr2)) {
                serialize[i10] = bArr;
                serialize[i10 + 1] = bArr2;
            } else {
                String str = new String(bArr, c.f25959a);
                logger.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i10 += 2;
        }
        return i10 == serialize.length ? serialize : (byte[][]) Arrays.copyOfRange(serialize, 0, i10);
    }

    public static byte[][] toRawSerializedHeaders(byte[][] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10 += 2) {
            byte[] bArr2 = bArr[i10];
            int i11 = i10 + 1;
            byte[] bArr3 = bArr[i11];
            if (endsWith(bArr2, binaryHeaderSuffixBytes)) {
                for (byte b4 : bArr3) {
                    if (b4 == 44) {
                        return serializeHeadersWithCommasInBin(bArr, i10);
                    }
                }
                bArr[i11] = BaseEncoding.a().b(new String(bArr3, c.f25959a));
            }
        }
        return bArr;
    }
}
