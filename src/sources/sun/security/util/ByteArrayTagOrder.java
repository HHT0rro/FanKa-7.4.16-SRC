package sun.security.util;

import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ByteArrayTagOrder implements Comparator<byte[]> {
    @Override // java.util.Comparator
    public final int compare(byte[] bytes1, byte[] bytes2) {
        return (bytes1[0] | 32) - (bytes2[0] | 32);
    }
}
