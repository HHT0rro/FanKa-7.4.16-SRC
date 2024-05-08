package com.tencent.cloud.huiyansdkface.okhttp3.internal.ws;

import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.ByteString;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class WebSocketProtocol {
    private WebSocketProtocol() {
        throw new AssertionError((Object) "No instances.");
    }

    public static String a(int i10) {
        StringBuilder sb2;
        if (i10 < 1000 || i10 >= 5000) {
            sb2 = new StringBuilder();
            sb2.append("Code must be in range [1000,5000): ");
            sb2.append(i10);
        } else {
            if ((i10 < 1004 || i10 > 1006) && (i10 < 1012 || i10 > 2999)) {
                return null;
            }
            sb2 = new StringBuilder();
            sb2.append("Code ");
            sb2.append(i10);
            sb2.append(" is reserved and may not be used.");
        }
        return sb2.toString();
    }

    public static void a(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        int length = bArr.length;
        int i10 = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i11 = unsafeCursor.start;
            int i12 = unsafeCursor.end;
            while (i11 < i12) {
                int i13 = i10 % length;
                bArr2[i11] = (byte) (bArr2[i11] ^ bArr[i13]);
                i11++;
                i10 = i13 + 1;
            }
        } while (unsafeCursor.next() != -1);
    }

    public static String acceptHeader(String str) {
        return ByteString.encodeUtf8(str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    }

    public static void b(int i10) {
        String a10 = a(i10);
        if (a10 != null) {
            throw new IllegalArgumentException(a10);
        }
    }
}
