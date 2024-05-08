package sun.security.provider.certpath;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.security.auth.x500.X500Principal;
import sun.misc.HexDumpEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.x509.AlgorithmId;
import sun.security.x509.SerialNumber;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertId {
    private static final AlgorithmId SHA1_ALGID = new AlgorithmId(AlgorithmId.SHA_oid);
    private static final boolean debug = false;
    private final SerialNumber certSerialNumber;
    private final AlgorithmId hashAlgId;
    private final byte[] issuerKeyHash;
    private final byte[] issuerNameHash;
    private int myhash;

    public CertId(X509Certificate issuerCert, SerialNumber serialNumber) throws IOException {
        this(issuerCert.getSubjectX500Principal(), issuerCert.getPublicKey(), serialNumber);
    }

    public CertId(X500Principal issuerName, PublicKey issuerKey, SerialNumber serialNumber) throws IOException {
        this.myhash = -1;
        try {
            MessageDigest md2 = MessageDigest.getInstance("SHA1");
            this.hashAlgId = SHA1_ALGID;
            md2.update(issuerName.getEncoded());
            this.issuerNameHash = md2.digest();
            byte[] pubKey = issuerKey.getEncoded();
            DerValue val = new DerValue(pubKey);
            DerValue[] seq = {val.data.getDerValue(), val.data.getDerValue()};
            byte[] keyBytes = seq[1].getBitString();
            md2.update(keyBytes);
            this.issuerKeyHash = md2.digest();
            this.certSerialNumber = serialNumber;
        } catch (NoSuchAlgorithmException nsae) {
            throw new IOException("Unable to create CertId", nsae);
        }
    }

    public CertId(DerInputStream derIn) throws IOException {
        this.myhash = -1;
        this.hashAlgId = AlgorithmId.parse(derIn.getDerValue());
        this.issuerNameHash = derIn.getOctetString();
        this.issuerKeyHash = derIn.getOctetString();
        this.certSerialNumber = new SerialNumber(derIn);
    }

    public AlgorithmId getHashAlgorithm() {
        return this.hashAlgId;
    }

    public byte[] getIssuerNameHash() {
        return this.issuerNameHash;
    }

    public byte[] getIssuerKeyHash() {
        return this.issuerKeyHash;
    }

    public BigInteger getSerialNumber() {
        return this.certSerialNumber.getNumber();
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        this.hashAlgId.encode(tmp);
        tmp.putOctetString(this.issuerNameHash);
        tmp.putOctetString(this.issuerKeyHash);
        this.certSerialNumber.encode(tmp);
        out.write((byte) 48, tmp);
    }

    public int hashCode() {
        if (this.myhash == -1) {
            this.myhash = this.hashAlgId.hashCode();
            int i10 = 0;
            while (true) {
                byte[] bArr = this.issuerNameHash;
                if (i10 >= bArr.length) {
                    break;
                }
                this.myhash += bArr[i10] * i10;
                i10++;
            }
            int i11 = 0;
            while (true) {
                byte[] bArr2 = this.issuerKeyHash;
                if (i11 >= bArr2.length) {
                    break;
                }
                this.myhash += bArr2[i11] * i11;
                i11++;
            }
            int i12 = this.myhash;
            this.myhash = i12 + this.certSerialNumber.getNumber().hashCode();
        }
        return this.myhash;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof CertId)) {
            return false;
        }
        CertId that = (CertId) other;
        if (this.hashAlgId.equals(that.getHashAlgorithm()) && Arrays.equals(this.issuerNameHash, that.getIssuerNameHash()) && Arrays.equals(this.issuerKeyHash, that.getIssuerKeyHash()) && this.certSerialNumber.getNumber().equals(that.getSerialNumber())) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CertId \n");
        sb2.append("Algorithm: " + this.hashAlgId.toString() + "\n");
        sb2.append("issuerNameHash \n");
        HexDumpEncoder encoder = new HexDumpEncoder();
        sb2.append(encoder.encode(this.issuerNameHash));
        sb2.append("\nissuerKeyHash: \n");
        sb2.append(encoder.encode(this.issuerKeyHash));
        sb2.append("\n" + this.certSerialNumber.toString());
        return sb2.toString();
    }
}
