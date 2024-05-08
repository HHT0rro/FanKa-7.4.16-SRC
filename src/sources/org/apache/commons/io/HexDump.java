package org.apache.commons.io;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    private static final char[] _hexcodes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int[] _shifts = {28, 24, 20, 16, 12, 8, 4, 0};

    public static void dump(byte[] bArr, long j10, OutputStream outputStream, int i10) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i10 < 0 || i10 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("illegal index: " + i10 + " into array of length " + bArr.length);
        }
        if (outputStream != null) {
            long j11 = j10 + i10;
            StringBuilder sb2 = new StringBuilder(74);
            while (i10 < bArr.length) {
                int length = bArr.length - i10;
                if (length > 16) {
                    length = 16;
                }
                dump(sb2, j11).append(' ');
                for (int i11 = 0; i11 < 16; i11++) {
                    if (i11 < length) {
                        dump(sb2, bArr[i11 + i10]);
                    } else {
                        sb2.append("  ");
                    }
                    sb2.append(' ');
                }
                for (int i12 = 0; i12 < length; i12++) {
                    int i13 = i12 + i10;
                    if (bArr[i13] >= 32 && bArr[i13] < Byte.MAX_VALUE) {
                        sb2.append((char) bArr[i13]);
                    } else {
                        sb2.append('.');
                    }
                }
                sb2.append(EOL);
                outputStream.write(sb2.toString().getBytes());
                outputStream.flush();
                sb2.setLength(0);
                j11 += length;
                i10 += 16;
            }
            return;
        }
        throw new IllegalArgumentException("cannot write to nullstream");
    }

    private static StringBuilder dump(StringBuilder sb2, long j10) {
        for (int i10 = 0; i10 < 8; i10++) {
            sb2.append(_hexcodes[((int) (j10 >> _shifts[i10])) & 15]);
        }
        return sb2;
    }

    private static StringBuilder dump(StringBuilder sb2, byte b4) {
        for (int i10 = 0; i10 < 2; i10++) {
            sb2.append(_hexcodes[(b4 >> _shifts[i10 + 6]) & 15]);
        }
        return sb2;
    }
}
