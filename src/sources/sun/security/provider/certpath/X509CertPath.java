package sun.security.provider.certpath;

import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import sun.security.pkcs.ContentInfo;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.SignerInfo;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.x509.AlgorithmId;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509CertPath extends CertPath {
    private static final String COUNT_ENCODING = "count";
    private static final String PKCS7_ENCODING = "PKCS7";
    private static final String PKIPATH_ENCODING = "PkiPath";
    private static final Collection<String> encodingList;
    private static final long serialVersionUID = 4989800333263052980L;
    private List<X509Certificate> certs;

    static {
        List<String> list = new ArrayList<>(2);
        list.add(PKIPATH_ENCODING);
        list.add(PKCS7_ENCODING);
        encodingList = Collections.unmodifiableCollection(list);
    }

    public X509CertPath(List<? extends Certificate> certs) throws CertificateException {
        super(e.f29912b);
        for (Object obj : certs) {
            if (!(obj instanceof X509Certificate)) {
                throw new CertificateException("List is not all X509Certificates: " + obj.getClass().getName());
            }
        }
        this.certs = Collections.unmodifiableList(new ArrayList(certs));
    }

    public X509CertPath(InputStream is) throws CertificateException {
        this(is, PKIPATH_ENCODING);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public X509CertPath(InputStream is, String encoding) throws CertificateException {
        super(e.f29912b);
        char c4;
        switch (encoding.hashCode()) {
            case 76183020:
                if (encoding.equals(PKCS7_ENCODING)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 1148619507:
                if (encoding.equals(PKIPATH_ENCODING)) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                this.certs = parsePKIPATH(is);
                return;
            case 1:
                this.certs = parsePKCS7(is);
                return;
            default:
                throw new CertificateException("unsupported encoding");
        }
    }

    private static List<X509Certificate> parsePKIPATH(InputStream is) throws CertificateException {
        if (is == null) {
            throw new CertificateException("input stream is null");
        }
        try {
            DerInputStream dis = new DerInputStream(readAllBytes(is));
            DerValue[] seq = dis.getSequence(3);
            if (seq.length == 0) {
                return Collections.emptyList();
            }
            CertificateFactory certFac = CertificateFactory.getInstance(e.f29912b);
            List<X509Certificate> certList = new ArrayList<>(seq.length);
            for (int i10 = seq.length - 1; i10 >= 0; i10--) {
                certList.add((X509Certificate) certFac.generateCertificate(new ByteArrayInputStream(seq[i10].toByteArray())));
            }
            return Collections.unmodifiableList(certList);
        } catch (IOException ioe) {
            throw new CertificateException("IOException parsing PkiPath data: " + ((Object) ioe), ioe);
        }
    }

    private static List<X509Certificate> parsePKCS7(InputStream is) throws CertificateException {
        List<X509Certificate> certList;
        if (is == null) {
            throw new CertificateException("input stream is null");
        }
        try {
            if (!is.markSupported()) {
                is = new ByteArrayInputStream(readAllBytes(is));
            }
            PKCS7 pkcs7 = new PKCS7(is);
            X509Certificate[] certArray = pkcs7.getCertificates();
            if (certArray != null) {
                certList = Arrays.asList(certArray);
            } else {
                certList = new ArrayList<>(0);
            }
            return Collections.unmodifiableList(certList);
        } catch (IOException ioe) {
            throw new CertificateException("IOException parsing PKCS7 data: " + ((Object) ioe));
        }
    }

    private static byte[] readAllBytes(InputStream is) throws IOException {
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        while (true) {
            int n10 = is.read(buffer);
            if (n10 != -1) {
                baos.write(buffer, 0, n10);
            } else {
                return baos.toByteArray();
            }
        }
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded() throws CertificateEncodingException {
        return encodePKIPATH();
    }

    private byte[] encodePKIPATH() throws CertificateEncodingException {
        List<X509Certificate> list = this.certs;
        ListIterator<X509Certificate> li = list.listIterator(list.size());
        try {
            DerOutputStream bytes = new DerOutputStream();
            while (li.hasPrevious()) {
                X509Certificate cert = li.previous();
                if (this.certs.lastIndexOf(cert) != this.certs.indexOf(cert)) {
                    throw new CertificateEncodingException("Duplicate Certificate");
                }
                byte[] encoded = cert.getEncoded();
                bytes.write(encoded);
            }
            DerOutputStream derout = new DerOutputStream();
            derout.write((byte) 48, bytes);
            return derout.toByteArray();
        } catch (IOException ioe) {
            throw new CertificateEncodingException("IOException encoding PkiPath data: " + ((Object) ioe), ioe);
        }
    }

    private byte[] encodePKCS7() throws CertificateEncodingException {
        ContentInfo contentInfo = new ContentInfo(ContentInfo.DATA_OID, (DerValue) null);
        List<X509Certificate> list = this.certs;
        PKCS7 p72 = new PKCS7(new AlgorithmId[0], contentInfo, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), new SignerInfo[0]);
        DerOutputStream derout = new DerOutputStream();
        try {
            p72.encodeSignedData(derout);
            return derout.toByteArray();
        } catch (IOException ioe) {
            throw new CertificateEncodingException(ioe.getMessage());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.security.cert.CertPath
    public byte[] getEncoded(String encoding) throws CertificateEncodingException {
        char c4;
        switch (encoding.hashCode()) {
            case 76183020:
                if (encoding.equals(PKCS7_ENCODING)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 1148619507:
                if (encoding.equals(PKIPATH_ENCODING)) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                return encodePKIPATH();
            case 1:
                return encodePKCS7();
            default:
                throw new CertificateEncodingException("unsupported encoding");
        }
    }

    public static Iterator<String> getEncodingsStatic() {
        return encodingList.iterator2();
    }

    @Override // java.security.cert.CertPath
    public Iterator<String> getEncodings() {
        return getEncodingsStatic();
    }

    @Override // java.security.cert.CertPath
    public List<X509Certificate> getCertificates() {
        return this.certs;
    }
}
