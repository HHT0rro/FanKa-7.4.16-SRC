package sun.misc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IOUtils {
    public static byte[] readFully(InputStream is, int length, boolean readAll) throws IOException {
        int bytesToRead;
        byte[] output = new byte[0];
        if (length == -1) {
            length = Integer.MAX_VALUE;
        }
        int pos = 0;
        while (pos < length) {
            if (pos >= output.length) {
                bytesToRead = Math.min(length - pos, output.length + 1024);
                if (output.length < pos + bytesToRead) {
                    output = Arrays.copyOf(output, pos + bytesToRead);
                }
            } else {
                int bytesToRead2 = output.length;
                bytesToRead = bytesToRead2 - pos;
            }
            int cc2 = is.read(output, pos, bytesToRead);
            if (cc2 < 0) {
                if (readAll && length != Integer.MAX_VALUE) {
                    throw new EOFException("Detect premature EOF");
                }
                if (output.length != pos) {
                    return Arrays.copyOf(output, pos);
                }
                return output;
            }
            pos += cc2;
        }
        return output;
    }
}
