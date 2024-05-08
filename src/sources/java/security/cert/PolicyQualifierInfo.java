package java.security.cert;

import java.io.IOException;
import sun.security.util.DerValue;
import sun.security.util.HexDumpEncoder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PolicyQualifierInfo {
    private byte[] mData;
    private byte[] mEncoded;
    private String mId;
    private String pqiString;

    public PolicyQualifierInfo(byte[] encoded) throws IOException {
        byte[] bArr = (byte[]) encoded.clone();
        this.mEncoded = bArr;
        DerValue val = new DerValue(bArr);
        if (val.tag != 48) {
            throw new IOException("Invalid encoding for PolicyQualifierInfo");
        }
        this.mId = val.data.getDerValue().getOID().toString();
        byte[] tmp = val.data.toByteArray();
        if (tmp == null) {
            this.mData = null;
            return;
        }
        byte[] bArr2 = new byte[tmp.length];
        this.mData = bArr2;
        System.arraycopy((Object) tmp, 0, (Object) bArr2, 0, tmp.length);
    }

    public final String getPolicyQualifierId() {
        return this.mId;
    }

    public final byte[] getEncoded() {
        return (byte[]) this.mEncoded.clone();
    }

    public final byte[] getPolicyQualifier() {
        byte[] bArr = this.mData;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public String toString() {
        String str = this.pqiString;
        if (str != null) {
            return str;
        }
        HexDumpEncoder enc = new HexDumpEncoder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PolicyQualifierInfo: [\n");
        sb2.append("  qualifierID: " + this.mId + "\n");
        StringBuilder append = new StringBuilder().append("  qualifier: ");
        byte[] bArr = this.mData;
        sb2.append(append.append(bArr == null ? "null" : enc.encodeBuffer(bArr)).append("\n").toString());
        sb2.append("]");
        String sb3 = sb2.toString();
        this.pqiString = sb3;
        return sb3;
    }
}
