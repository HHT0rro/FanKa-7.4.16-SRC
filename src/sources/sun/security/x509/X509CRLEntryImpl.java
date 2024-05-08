package sun.security.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.CRLReason;
import java.security.cert.X509CRLEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.security.auth.x500.X500Principal;
import sun.misc.HexDumpEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509CRLEntryImpl extends X509CRLEntry implements Comparable<X509CRLEntryImpl> {
    private static final long YR_2050 = 2524636800000L;
    private static final boolean isExplicit = false;
    private X500Principal certIssuer;
    private CRLExtensions extensions;
    private Date revocationDate;
    private byte[] revokedCert;
    private SerialNumber serialNumber;

    public X509CRLEntryImpl(BigInteger num, Date date) {
        this.serialNumber = null;
        this.revocationDate = null;
        this.extensions = null;
        this.revokedCert = null;
        this.serialNumber = new SerialNumber(num);
        this.revocationDate = date;
    }

    public X509CRLEntryImpl(BigInteger num, Date date, CRLExtensions crlEntryExts) {
        this.serialNumber = null;
        this.revocationDate = null;
        this.extensions = null;
        this.revokedCert = null;
        this.serialNumber = new SerialNumber(num);
        this.revocationDate = date;
        this.extensions = crlEntryExts;
    }

    public X509CRLEntryImpl(byte[] revokedCert) throws CRLException {
        this.serialNumber = null;
        this.revocationDate = null;
        this.extensions = null;
        this.revokedCert = null;
        try {
            parse(new DerValue(revokedCert));
        } catch (IOException e2) {
            this.revokedCert = null;
            throw new CRLException("Parsing error: " + e2.toString());
        }
    }

    public X509CRLEntryImpl(DerValue derValue) throws CRLException {
        this.serialNumber = null;
        this.revocationDate = null;
        this.extensions = null;
        this.revokedCert = null;
        try {
            parse(derValue);
        } catch (IOException e2) {
            this.revokedCert = null;
            throw new CRLException("Parsing error: " + e2.toString());
        }
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public void encode(DerOutputStream outStrm) throws CRLException {
        try {
            if (this.revokedCert == null) {
                DerOutputStream tmp = new DerOutputStream();
                this.serialNumber.encode(tmp);
                if (this.revocationDate.getTime() < YR_2050) {
                    tmp.putUTCTime(this.revocationDate);
                } else {
                    tmp.putGeneralizedTime(this.revocationDate);
                }
                CRLExtensions cRLExtensions = this.extensions;
                if (cRLExtensions != null) {
                    cRLExtensions.encode(tmp, false);
                }
                DerOutputStream seq = new DerOutputStream();
                seq.write((byte) 48, tmp);
                this.revokedCert = seq.toByteArray();
            }
            outStrm.write(this.revokedCert);
        } catch (IOException e2) {
            throw new CRLException("Encoding error: " + e2.toString());
        }
    }

    @Override // java.security.cert.X509CRLEntry
    public byte[] getEncoded() throws CRLException {
        return (byte[]) getEncoded0().clone();
    }

    private byte[] getEncoded0() throws CRLException {
        if (this.revokedCert == null) {
            encode(new DerOutputStream());
        }
        return this.revokedCert;
    }

    @Override // java.security.cert.X509CRLEntry
    public X500Principal getCertificateIssuer() {
        return this.certIssuer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCertificateIssuer(X500Principal crlIssuer, X500Principal certIssuer) {
        if (crlIssuer.equals(certIssuer)) {
            this.certIssuer = null;
        } else {
            this.certIssuer = certIssuer;
        }
    }

    @Override // java.security.cert.X509CRLEntry
    public BigInteger getSerialNumber() {
        return this.serialNumber.getNumber();
    }

    @Override // java.security.cert.X509CRLEntry
    public Date getRevocationDate() {
        return new Date(this.revocationDate.getTime());
    }

    @Override // java.security.cert.X509CRLEntry
    public CRLReason getRevocationReason() {
        Extension ext = getExtension(PKIXExtensions.ReasonCode_Id);
        if (ext == null) {
            return null;
        }
        CRLReasonCodeExtension rcExt = (CRLReasonCodeExtension) ext;
        return rcExt.getReasonCode();
    }

    public static CRLReason getRevocationReason(X509CRLEntry crlEntry) {
        try {
            byte[] ext = crlEntry.getExtensionValue("2.5.29.21");
            if (ext == null) {
                return null;
            }
            DerValue val = new DerValue(ext);
            byte[] data = val.getOctetString();
            CRLReasonCodeExtension rcExt = new CRLReasonCodeExtension(Boolean.FALSE, data);
            return rcExt.getReasonCode();
        } catch (IOException e2) {
            return null;
        }
    }

    public Integer getReasonCode() throws IOException {
        Object obj = getExtension(PKIXExtensions.ReasonCode_Id);
        if (obj == null) {
            return null;
        }
        CRLReasonCodeExtension reasonCode = (CRLReasonCodeExtension) obj;
        return reasonCode.get("reason");
    }

    @Override // java.security.cert.X509CRLEntry
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.serialNumber.toString());
        sb2.append("  On: " + this.revocationDate.toString());
        if (this.certIssuer != null) {
            sb2.append("\n    Certificate issuer: " + ((Object) this.certIssuer));
        }
        CRLExtensions cRLExtensions = this.extensions;
        if (cRLExtensions != null) {
            Collection<Extension> allEntryExts = cRLExtensions.getAllExtensions();
            Extension[] exts = (Extension[]) allEntryExts.toArray(new Extension[0]);
            sb2.append("\n    CRL Entry Extensions: " + exts.length);
            for (int i10 = 0; i10 < exts.length; i10++) {
                sb2.append("\n    [" + (i10 + 1) + "]: ");
                Extension ext = exts[i10];
                try {
                    if (OIDMap.getClass(ext.getExtensionId()) == null) {
                        sb2.append(ext.toString());
                        byte[] extValue = ext.getExtensionValue();
                        if (extValue != null) {
                            DerOutputStream out = new DerOutputStream();
                            out.putOctetString(extValue);
                            byte[] extValue2 = out.toByteArray();
                            HexDumpEncoder enc = new HexDumpEncoder();
                            sb2.append("Extension unknown: DER encoded OCTET string =\n" + enc.encodeBuffer(extValue2) + "\n");
                        }
                    } else {
                        sb2.append(ext.toString());
                    }
                } catch (Exception e2) {
                    sb2.append(", Error parsing this extension");
                }
            }
        }
        sb2.append("\n");
        return sb2.toString();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        CRLExtensions cRLExtensions = this.extensions;
        if (cRLExtensions == null) {
            return false;
        }
        return cRLExtensions.hasUnsupportedCriticalExtension();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        if (this.extensions == null) {
            return null;
        }
        Set<String> extSet = new TreeSet<>();
        for (Extension ex : this.extensions.getAllExtensions()) {
            if (ex.isCritical()) {
                extSet.add(ex.getExtensionId().toString());
            }
        }
        return extSet;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        if (this.extensions == null) {
            return null;
        }
        Set<String> extSet = new TreeSet<>();
        for (Extension ex : this.extensions.getAllExtensions()) {
            if (!ex.isCritical()) {
                extSet.add(ex.getExtensionId().toString());
            }
        }
        return extSet;
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String oid) {
        byte[] extData;
        if (this.extensions == null) {
            return null;
        }
        try {
            String extAlias = OIDMap.getName(new ObjectIdentifier(oid));
            Extension crlExt = null;
            if (extAlias == null) {
                ObjectIdentifier findOID = new ObjectIdentifier(oid);
                Enumeration<Extension> e2 = this.extensions.getElements();
                while (true) {
                    if (!e2.hasMoreElements()) {
                        break;
                    }
                    Extension ex = e2.nextElement();
                    ObjectIdentifier inCertOID = ex.getExtensionId();
                    if (inCertOID.equals((Object) findOID)) {
                        crlExt = ex;
                        break;
                    }
                }
            } else {
                crlExt = this.extensions.get(extAlias);
            }
            if (crlExt == null || (extData = crlExt.getExtensionValue()) == null) {
                return null;
            }
            DerOutputStream out = new DerOutputStream();
            out.putOctetString(extData);
            return out.toByteArray();
        } catch (Exception e10) {
            return null;
        }
    }

    public Extension getExtension(ObjectIdentifier oid) {
        CRLExtensions cRLExtensions = this.extensions;
        if (cRLExtensions == null) {
            return null;
        }
        return cRLExtensions.get(OIDMap.getName(oid));
    }

    private void parse(DerValue derVal) throws CRLException, IOException {
        if (derVal.tag != 48) {
            throw new CRLException("Invalid encoded RevokedCertificate, starting sequence tag missing.");
        }
        if (derVal.data.available() == 0) {
            throw new CRLException("No data encoded for RevokedCertificates");
        }
        this.revokedCert = derVal.toByteArray();
        DerInputStream in = derVal.toDerInputStream();
        DerValue val = in.getDerValue();
        this.serialNumber = new SerialNumber(val);
        int nextByte = derVal.data.peekByte();
        if (((byte) nextByte) == 23) {
            this.revocationDate = derVal.data.getUTCTime();
        } else if (((byte) nextByte) == 24) {
            this.revocationDate = derVal.data.getGeneralizedTime();
        } else {
            throw new CRLException("Invalid encoding for revocation date");
        }
        if (derVal.data.available() == 0) {
            return;
        }
        this.extensions = new CRLExtensions(derVal.toDerInputStream());
    }

    public static X509CRLEntryImpl toImpl(X509CRLEntry entry) throws CRLException {
        if (entry instanceof X509CRLEntryImpl) {
            return (X509CRLEntryImpl) entry;
        }
        return new X509CRLEntryImpl(entry.getEncoded());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CertificateIssuerExtension getCertificateIssuerExtension() {
        return (CertificateIssuerExtension) getExtension(PKIXExtensions.CertificateIssuer_Id);
    }

    public Map<String, java.security.cert.Extension> getExtensions() {
        CRLExtensions cRLExtensions = this.extensions;
        if (cRLExtensions == null) {
            return Collections.emptyMap();
        }
        Collection<Extension> exts = cRLExtensions.getAllExtensions();
        Map<String, java.security.cert.Extension> map = new TreeMap<>();
        for (Extension ext : exts) {
            map.put(ext.getId(), ext);
        }
        return map;
    }

    @Override // java.lang.Comparable
    public int compareTo(X509CRLEntryImpl that) {
        int compSerial = getSerialNumber().compareTo(that.getSerialNumber());
        if (compSerial != 0) {
            return compSerial;
        }
        try {
            byte[] thisEncoded = getEncoded0();
            byte[] thatEncoded = that.getEncoded0();
            for (int i10 = 0; i10 < thisEncoded.length && i10 < thatEncoded.length; i10++) {
                int a10 = thisEncoded[i10] & 255;
                int b4 = thatEncoded[i10] & 255;
                if (a10 != b4) {
                    return a10 - b4;
                }
            }
            int i11 = thisEncoded.length;
            return i11 - thatEncoded.length;
        } catch (CRLException e2) {
            return -1;
        }
    }
}
