package javax.crypto;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NullCipher extends Cipher {
    public NullCipher() {
        super(new NullCipherSpi(), null, null);
    }
}
