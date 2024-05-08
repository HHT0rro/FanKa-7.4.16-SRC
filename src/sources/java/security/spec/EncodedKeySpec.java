package java.security.spec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class EncodedKeySpec implements KeySpec {
    private byte[] encodedKey;

    public abstract String getFormat();

    public EncodedKeySpec(byte[] encodedKey) {
        this.encodedKey = (byte[]) encodedKey.clone();
    }

    public byte[] getEncoded() {
        return (byte[]) this.encodedKey.clone();
    }
}
