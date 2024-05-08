package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CRLDistributionPointsExtension extends Extension implements CertAttrSet<String> {
    public static final String IDENT = "x509.info.extensions.CRLDistributionPoints";
    public static final String NAME = "CRLDistributionPoints";
    public static final String POINTS = "points";
    private List<DistributionPoint> distributionPoints;
    private String extensionName;

    public CRLDistributionPointsExtension(List<DistributionPoint> distributionPoints) throws IOException {
        this(false, distributionPoints);
    }

    public CRLDistributionPointsExtension(boolean isCritical, List<DistributionPoint> distributionPoints) throws IOException {
        this(PKIXExtensions.CRLDistributionPoints_Id, isCritical, distributionPoints, NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CRLDistributionPointsExtension(ObjectIdentifier extensionId, boolean isCritical, List<DistributionPoint> distributionPoints, String extensionName) throws IOException {
        this.extensionId = extensionId;
        this.critical = isCritical;
        this.distributionPoints = distributionPoints;
        encodeThis();
        this.extensionName = extensionName;
    }

    public CRLDistributionPointsExtension(Boolean critical, Object value) throws IOException {
        this(PKIXExtensions.CRLDistributionPoints_Id, critical, value, NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CRLDistributionPointsExtension(ObjectIdentifier extensionId, Boolean critical, Object value, String extensionName) throws IOException {
        this.extensionId = extensionId;
        this.critical = critical.booleanValue();
        if (!(value instanceof byte[])) {
            throw new IOException("Illegal argument type");
        }
        this.extensionValue = (byte[]) value;
        DerValue val = new DerValue(this.extensionValue);
        if (val.tag != 48) {
            throw new IOException("Invalid encoding for " + extensionName + " extension.");
        }
        this.distributionPoints = new ArrayList();
        while (val.data.available() != 0) {
            DerValue seq = val.data.getDerValue();
            DistributionPoint point = new DistributionPoint(seq);
            this.distributionPoints.add(point);
        }
        this.extensionName = extensionName;
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return this.extensionName;
    }

    @Override // sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        encode(out, PKIXExtensions.CRLDistributionPoints_Id, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void encode(OutputStream out, ObjectIdentifier extensionId, boolean isCritical) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (this.extensionValue == null) {
            this.extensionId = extensionId;
            this.critical = isCritical;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase(POINTS)) {
            if (!(obj instanceof List)) {
                throw new IOException("Attribute value should be of type List.");
            }
            this.distributionPoints = (List) obj;
            encodeThis();
            return;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:" + this.extensionName + ".");
    }

    @Override // sun.security.x509.CertAttrSet
    public List<DistributionPoint> get(String name) throws IOException {
        if (name.equalsIgnoreCase(POINTS)) {
            return this.distributionPoints;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:" + this.extensionName + ".");
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(POINTS)) {
            this.distributionPoints = Collections.emptyList();
            encodeThis();
            return;
        }
        throw new IOException("Attribute name [" + name + "] not recognized by CertAttrSet:" + this.extensionName + '.');
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(POINTS);
        return elements.elements();
    }

    private void encodeThis() throws IOException {
        if (this.distributionPoints.isEmpty()) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream pnts = new DerOutputStream();
        for (DistributionPoint point : this.distributionPoints) {
            point.encode(pnts);
        }
        DerOutputStream seq = new DerOutputStream();
        seq.write((byte) 48, pnts);
        this.extensionValue = seq.toByteArray();
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        return super.toString() + this.extensionName + " [\n  " + ((Object) this.distributionPoints) + "]\n";
    }
}
