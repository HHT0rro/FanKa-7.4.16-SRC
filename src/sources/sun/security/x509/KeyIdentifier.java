package sun.security.x509;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;
import sun.misc.HexDumpEncoder;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class KeyIdentifier {
    private byte[] octetString;

    public KeyIdentifier(byte[] octetString) {
        this.octetString = (byte[]) octetString.clone();
    }

    public KeyIdentifier(DerValue val) throws IOException {
        this.octetString = val.getOctetString();
    }

    public KeyIdentifier(PublicKey pubKey) throws IOException {
        DerValue algAndKey = new DerValue(pubKey.getEncoded());
        if (algAndKey.tag != 48) {
            throw new IOException("PublicKey value is not a valid X.509 public key");
        }
        AlgorithmId.parse(algAndKey.data.getDerValue());
        byte[] key = algAndKey.data.getUnalignedBitString().toByteArray();
        try {
            MessageDigest md2 = MessageDigest.getInstance("SHA1");
            md2.update(key);
            this.octetString = md2.digest();
        } catch (NoSuchAlgorithmException e2) {
            throw new IOException("SHA1 not supported");
        }
    }

    public byte[] getIdentifier() {
        return (byte[]) this.octetString.clone();
    }

    public String toString() {
        HexDumpEncoder encoder = new HexDumpEncoder();
        String s2 = "KeyIdentifier [\n" + encoder.encodeBuffer(this.octetString);
        return s2 + "]\n";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(DerOutputStream out) throws IOException {
        out.putOctetString(this.octetString);
    }

    public int hashCode() {
        int retval = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.octetString;
            if (i10 < bArr.length) {
                retval += bArr[i10] * i10;
                i10++;
            } else {
                return retval;
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyIdentifier)) {
            return false;
        }
        byte[] otherString = ((KeyIdentifier) other).octetString;
        return Arrays.equals(this.octetString, otherString);
    }
}
