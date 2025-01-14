package sun.security.x509;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import sun.security.util.BitArray;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DistributionPoint {
    public static final int AA_COMPROMISE = 8;
    public static final int AFFILIATION_CHANGED = 3;
    public static final int CA_COMPROMISE = 2;
    public static final int CERTIFICATE_HOLD = 6;
    public static final int CESSATION_OF_OPERATION = 5;
    public static final int KEY_COMPROMISE = 1;
    public static final int PRIVILEGE_WITHDRAWN = 7;
    private static final String[] REASON_STRINGS = {null, "key compromise", "CA compromise", "affiliation changed", ReasonFlags.SUPERSEDED, "cessation of operation", "certificate hold", "privilege withdrawn", "AA compromise"};
    public static final int SUPERSEDED = 4;
    private static final byte TAG_DIST_PT = 0;
    private static final byte TAG_FULL_NAME = 0;
    private static final byte TAG_ISSUER = 2;
    private static final byte TAG_REASONS = 1;
    private static final byte TAG_REL_NAME = 1;
    private GeneralNames crlIssuer;
    private GeneralNames fullName;
    private volatile int hashCode;
    private boolean[] reasonFlags;
    private RDN relativeName;

    public DistributionPoint(GeneralNames fullName, boolean[] reasonFlags, GeneralNames crlIssuer) {
        if (fullName == null && crlIssuer == null) {
            throw new IllegalArgumentException("fullName and crlIssuer may not both be null");
        }
        this.fullName = fullName;
        this.reasonFlags = reasonFlags;
        this.crlIssuer = crlIssuer;
    }

    public DistributionPoint(RDN relativeName, boolean[] reasonFlags, GeneralNames crlIssuer) {
        if (relativeName == null && crlIssuer == null) {
            throw new IllegalArgumentException("relativeName and crlIssuer may not both be null");
        }
        this.relativeName = relativeName;
        this.reasonFlags = reasonFlags;
        this.crlIssuer = crlIssuer;
    }

    public DistributionPoint(DerValue val) throws IOException {
        if (val.tag != 48) {
            throw new IOException("Invalid encoding of DistributionPoint.");
        }
        while (val.data != null && val.data.available() != 0) {
            DerValue opt = val.data.getDerValue();
            if (opt.isContextSpecific((byte) 0) && opt.isConstructed()) {
                if (this.fullName != null || this.relativeName != null) {
                    throw new IOException("Duplicate DistributionPointName in DistributionPoint.");
                }
                DerValue distPnt = opt.data.getDerValue();
                if (distPnt.isContextSpecific((byte) 0) && distPnt.isConstructed()) {
                    distPnt.resetTag((byte) 48);
                    this.fullName = new GeneralNames(distPnt);
                } else if (distPnt.isContextSpecific((byte) 1) && distPnt.isConstructed()) {
                    distPnt.resetTag((byte) 49);
                    this.relativeName = new RDN(distPnt);
                } else {
                    throw new IOException("Invalid DistributionPointName in DistributionPoint");
                }
            } else if (opt.isContextSpecific((byte) 1) && !opt.isConstructed()) {
                if (this.reasonFlags != null) {
                    throw new IOException("Duplicate Reasons in DistributionPoint.");
                }
                opt.resetTag((byte) 3);
                this.reasonFlags = opt.getUnalignedBitString().toBooleanArray();
            } else if (opt.isContextSpecific((byte) 2) && opt.isConstructed()) {
                if (this.crlIssuer != null) {
                    throw new IOException("Duplicate CRLIssuer in DistributionPoint.");
                }
                opt.resetTag((byte) 48);
                this.crlIssuer = new GeneralNames(opt);
            } else {
                throw new IOException("Invalid encoding of DistributionPoint.");
            }
        }
        if (this.crlIssuer == null && this.fullName == null && this.relativeName == null) {
            throw new IOException("One of fullName, relativeName,  and crlIssuer has to be set");
        }
    }

    public GeneralNames getFullName() {
        return this.fullName;
    }

    public RDN getRelativeName() {
        return this.relativeName;
    }

    public boolean[] getReasonFlags() {
        return this.reasonFlags;
    }

    public GeneralNames getCRLIssuer() {
        return this.crlIssuer;
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tagged = new DerOutputStream();
        if (this.fullName != null || this.relativeName != null) {
            DerOutputStream distributionPoint = new DerOutputStream();
            if (this.fullName != null) {
                DerOutputStream derOut = new DerOutputStream();
                this.fullName.encode(derOut);
                distributionPoint.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), derOut);
            } else if (this.relativeName != null) {
                DerOutputStream derOut2 = new DerOutputStream();
                this.relativeName.encode(derOut2);
                distributionPoint.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 1), derOut2);
            }
            tagged.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), distributionPoint);
        }
        if (this.reasonFlags != null) {
            DerOutputStream reasons = new DerOutputStream();
            BitArray rf = new BitArray(this.reasonFlags);
            reasons.putTruncatedUnalignedBitString(rf);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 1), reasons);
        }
        if (this.crlIssuer != null) {
            DerOutputStream issuer = new DerOutputStream();
            this.crlIssuer.encode(issuer);
            tagged.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 2), issuer);
        }
        out.write((byte) 48, tagged);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DistributionPoint)) {
            return false;
        }
        DistributionPoint other = (DistributionPoint) obj;
        return Objects.equals(this.fullName, other.fullName) && Objects.equals(this.relativeName, other.relativeName) && Objects.equals(this.crlIssuer, other.crlIssuer) && Arrays.equals(this.reasonFlags, other.reasonFlags);
    }

    public int hashCode() {
        int hash = this.hashCode;
        if (hash == 0) {
            GeneralNames generalNames = this.fullName;
            hash = generalNames != null ? 1 + generalNames.hashCode() : 1;
            RDN rdn = this.relativeName;
            if (rdn != null) {
                hash += rdn.hashCode();
            }
            GeneralNames generalNames2 = this.crlIssuer;
            if (generalNames2 != null) {
                hash += generalNames2.hashCode();
            }
            if (this.reasonFlags != null) {
                int i10 = 0;
                while (true) {
                    boolean[] zArr = this.reasonFlags;
                    if (i10 >= zArr.length) {
                        break;
                    }
                    if (zArr[i10]) {
                        hash += i10;
                    }
                    i10++;
                }
            }
            this.hashCode = hash;
        }
        return hash;
    }

    private static String reasonToString(int reason) {
        if (reason > 0) {
            String[] strArr = REASON_STRINGS;
            if (reason < strArr.length) {
                return strArr[reason];
            }
        }
        return "Unknown reason " + reason;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.fullName != null) {
            sb2.append("DistributionPoint:\n     " + ((Object) this.fullName) + "\n");
        }
        if (this.relativeName != null) {
            sb2.append("DistributionPoint:\n     " + ((Object) this.relativeName) + "\n");
        }
        if (this.reasonFlags != null) {
            sb2.append("   ReasonFlags:\n");
            int i10 = 0;
            while (true) {
                boolean[] zArr = this.reasonFlags;
                if (i10 >= zArr.length) {
                    break;
                }
                if (zArr[i10]) {
                    sb2.append("    " + reasonToString(i10) + "\n");
                }
                i10++;
            }
        }
        if (this.crlIssuer != null) {
            sb2.append("   CRLIssuer:" + ((Object) this.crlIssuer) + "\n");
        }
        return sb2.toString();
    }
}
