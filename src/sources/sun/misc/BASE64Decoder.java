package sun.misc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.util.Locale;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BASE64Decoder extends CharacterDecoder {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX};
    private static final byte[] pem_convert_array = new byte[256];
    byte[] decode_buffer = new byte[4];

    @Override // sun.misc.CharacterDecoder
    protected int bytesPerAtom() {
        return 4;
    }

    @Override // sun.misc.CharacterDecoder
    protected int bytesPerLine() {
        return 72;
    }

    static {
        for (int i10 = 0; i10 < 255; i10++) {
            pem_convert_array[i10] = -1;
        }
        int i11 = 0;
        while (true) {
            char[] cArr = pem_array;
            if (i11 < cArr.length) {
                pem_convert_array[cArr[i11]] = (byte) i11;
                i11++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // sun.misc.CharacterDecoder
    protected void decodeAtom(PushbackInputStream inStream, OutputStream outStream, int rem) throws IOException {
        byte a10 = -1;
        byte b4 = -1;
        byte c4 = -1;
        byte d10 = -1;
        if (rem < 2) {
            throw new CEFormatException("BASE64Decoder: Not enough bytes for an atom.");
        }
        while (true) {
            int i10 = inStream.read();
            if (i10 == -1) {
                throw new CEStreamExhausted();
            }
            if (i10 != 10 && i10 != 13) {
                byte[] bArr = this.decode_buffer;
                bArr[0] = (byte) i10;
                if (readFully(inStream, bArr, 1, rem - 1) == -1) {
                    throw new CEStreamExhausted();
                }
                if (rem > 3 && this.decode_buffer[3] == 61) {
                    rem = 3;
                }
                if (rem > 2 && this.decode_buffer[2] == 61) {
                    rem = 2;
                }
                switch (rem) {
                    case 2:
                        byte[] bArr2 = pem_convert_array;
                        byte[] bArr3 = this.decode_buffer;
                        b4 = bArr2[bArr3[1] & 255];
                        a10 = bArr2[bArr3[0] & 255];
                        break;
                    case 3:
                        c4 = pem_convert_array[this.decode_buffer[2] & 255];
                        byte[] bArr22 = pem_convert_array;
                        byte[] bArr32 = this.decode_buffer;
                        b4 = bArr22[bArr32[1] & 255];
                        a10 = bArr22[bArr32[0] & 255];
                        break;
                    case 4:
                        d10 = pem_convert_array[this.decode_buffer[3] & 255];
                        c4 = pem_convert_array[this.decode_buffer[2] & 255];
                        byte[] bArr222 = pem_convert_array;
                        byte[] bArr322 = this.decode_buffer;
                        b4 = bArr222[bArr322[1] & 255];
                        a10 = bArr222[bArr322[0] & 255];
                        break;
                }
                switch (rem) {
                    case 2:
                        outStream.write((byte) (((a10 << 2) & 252) | ((b4 >>> 4) & 3)));
                        return;
                    case 3:
                        outStream.write((byte) (((a10 << 2) & 252) | ((b4 >>> 4) & 3)));
                        outStream.write((byte) (((b4 << 4) & 240) | ((c4 >>> 2) & 15)));
                        return;
                    case 4:
                        outStream.write((byte) (((a10 << 2) & 252) | ((b4 >>> 4) & 3)));
                        outStream.write((byte) (((b4 << 4) & 240) | ((c4 >>> 2) & 15)));
                        outStream.write((byte) (((c4 << 6) & 192) | (d10 & Utf8.REPLACEMENT_BYTE)));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
