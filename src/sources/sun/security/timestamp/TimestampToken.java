package sun.security.timestamp;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TimestampToken {
    private Date genTime;
    private AlgorithmId hashAlgorithm;
    private byte[] hashedMessage;
    private BigInteger nonce;
    private ObjectIdentifier policy;
    private BigInteger serialNumber;
    private int version;

    public TimestampToken(byte[] timestampTokenInfo) throws IOException {
        if (timestampTokenInfo == null) {
            throw new IOException("No timestamp token info");
        }
        parse(timestampTokenInfo);
    }

    public Date getDate() {
        return this.genTime;
    }

    public AlgorithmId getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getHashedMessage() {
        return this.hashedMessage;
    }

    public BigInteger getNonce() {
        return this.nonce;
    }

    public String getPolicyID() {
        return this.policy.toString();
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    private void parse(byte[] timestampTokenInfo) throws IOException {
        DerValue tstInfo = new DerValue(timestampTokenInfo);
        if (tstInfo.tag != 48) {
            throw new IOException("Bad encoding for timestamp token info");
        }
        this.version = tstInfo.data.getInteger();
        this.policy = tstInfo.data.getOID();
        DerValue messageImprint = tstInfo.data.getDerValue();
        this.hashAlgorithm = AlgorithmId.parse(messageImprint.data.getDerValue());
        this.hashedMessage = messageImprint.data.getOctetString();
        this.serialNumber = tstInfo.data.getBigInteger();
        this.genTime = tstInfo.data.getGeneralizedTime();
        while (tstInfo.data.available() > 0) {
            DerValue d10 = tstInfo.data.getDerValue();
            if (d10.tag == 2) {
                this.nonce = d10.getBigInteger();
                return;
            }
        }
    }
}
