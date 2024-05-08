package sun.security.x509;

import java.io.IOException;
import sun.security.util.BitArray;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UniqueIdentity {

    /* renamed from: id, reason: collision with root package name */
    private BitArray f53748id;

    public UniqueIdentity(BitArray id2) {
        this.f53748id = id2;
    }

    public UniqueIdentity(byte[] id2) {
        this.f53748id = new BitArray(id2.length * 8, id2);
    }

    public UniqueIdentity(DerInputStream in) throws IOException {
        DerValue derVal = in.getDerValue();
        this.f53748id = derVal.getUnalignedBitString(true);
    }

    public UniqueIdentity(DerValue derVal) throws IOException {
        this.f53748id = derVal.getUnalignedBitString(true);
    }

    public String toString() {
        return "UniqueIdentity:" + this.f53748id.toString() + "\n";
    }

    public void encode(DerOutputStream out, byte tag) throws IOException {
        byte[] bytes = this.f53748id.toByteArray();
        int excessBits = (bytes.length * 8) - this.f53748id.length();
        out.write(tag);
        out.putLength(bytes.length + 1);
        out.write(excessBits);
        out.write(bytes);
    }

    public boolean[] getId() {
        BitArray bitArray = this.f53748id;
        if (bitArray == null) {
            return null;
        }
        return bitArray.toBooleanArray();
    }
}
