package sun.misc;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BASE64Encoder extends CharacterEncoder {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX};

    @Override // sun.misc.CharacterEncoder
    protected int bytesPerAtom() {
        return 3;
    }

    @Override // sun.misc.CharacterEncoder
    protected int bytesPerLine() {
        return 57;
    }

    @Override // sun.misc.CharacterEncoder
    protected void encodeAtom(OutputStream outStream, byte[] data, int offset, int len) throws IOException {
        if (len == 1) {
            byte a10 = data[offset];
            char[] cArr = pem_array;
            outStream.write(cArr[(a10 >>> 2) & 63]);
            outStream.write(cArr[((a10 << 4) & 48) + ((0 >>> 4) & 15)]);
            outStream.write(61);
            outStream.write(61);
            return;
        }
        if (len == 2) {
            byte a11 = data[offset];
            byte b4 = data[offset + 1];
            char[] cArr2 = pem_array;
            outStream.write(cArr2[(a11 >>> 2) & 63]);
            outStream.write(cArr2[((a11 << 4) & 48) + ((b4 >>> 4) & 15)]);
            outStream.write(cArr2[((b4 << 2) & 60) + ((0 >>> 6) & 3)]);
            outStream.write(61);
            return;
        }
        byte a12 = data[offset];
        byte b10 = data[offset + 1];
        byte c4 = data[offset + 2];
        char[] cArr3 = pem_array;
        outStream.write(cArr3[(a12 >>> 2) & 63]);
        outStream.write(cArr3[((a12 << 4) & 48) + ((b10 >>> 4) & 15)]);
        outStream.write(cArr3[((b10 << 2) & 60) + ((c4 >>> 6) & 3)]);
        outStream.write(cArr3[c4 & Utf8.REPLACEMENT_BYTE]);
    }
}
