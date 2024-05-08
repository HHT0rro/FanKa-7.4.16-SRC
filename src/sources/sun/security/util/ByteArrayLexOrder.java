package sun.security.util;

import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ByteArrayLexOrder implements Comparator<byte[]> {
    @Override // java.util.Comparator
    public final int compare(byte[] bytes1, byte[] bytes2) {
        for (int i10 = 0; i10 < bytes1.length && i10 < bytes2.length; i10++) {
            int diff = (bytes1[i10] & 255) - (bytes2[i10] & 255);
            if (diff != 0) {
                return diff;
            }
        }
        int i11 = bytes1.length;
        return i11 - bytes2.length;
    }
}
