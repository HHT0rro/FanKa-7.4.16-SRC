package sun.security.provider.certpath;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import javax.security.auth.x500.X500Principal;
import sun.security.provider.X509Factory;
import sun.security.util.Cache;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509CertificatePair {
    private static final byte TAG_FORWARD = 0;
    private static final byte TAG_REVERSE = 1;
    private static final Cache<Object, X509CertificatePair> cache = Cache.newSoftMemoryCache(MetricsProto.MetricsEvent.SETTINGS_LANGUAGE_CATEGORY);
    private byte[] encoded;
    private X509Certificate forward;
    private X509Certificate reverse;

    public X509CertificatePair() {
    }

    public X509CertificatePair(X509Certificate forward, X509Certificate reverse) throws CertificateException {
        if (forward == null && reverse == null) {
            throw new CertificateException("at least one of certificate pair must be non-null");
        }
        this.forward = forward;
        this.reverse = reverse;
        checkPair();
    }

    private X509CertificatePair(byte[] encoded) throws CertificateException {
        try {
            parse(new DerValue(encoded));
            this.encoded = encoded;
            checkPair();
        } catch (IOException ex) {
            throw new CertificateException(ex.toString());
        }
    }

    public static synchronized void clearCache() {
        synchronized (X509CertificatePair.class) {
            cache.clear();
        }
    }

    public static synchronized X509CertificatePair generateCertificatePair(byte[] encoded) throws CertificateException {
        synchronized (X509CertificatePair.class) {
            Object key = new Cache.EqualByteArray(encoded);
            Cache<Object, X509CertificatePair> cache2 = cache;
            X509CertificatePair pair = cache2.get(key);
            if (pair != null) {
                return pair;
            }
            X509CertificatePair pair2 = new X509CertificatePair(encoded);
            Object key2 = new Cache.EqualByteArray(pair2.encoded);
            cache2.put(key2, pair2);
            return pair2;
        }
    }

    public void setForward(X509Certificate cert) throws CertificateException {
        checkPair();
        this.forward = cert;
    }

    public void setReverse(X509Certificate cert) throws CertificateException {
        checkPair();
        this.reverse = cert;
    }

    public X509Certificate getForward() {
        return this.forward;
    }

    public X509Certificate getReverse() {
        return this.reverse;
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            if (this.encoded == null) {
                DerOutputStream tmp = new DerOutputStream();
                emit(tmp);
                this.encoded = tmp.toByteArray();
            }
            return this.encoded;
        } catch (IOException ex) {
            throw new CertificateEncodingException(ex.toString());
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("X.509 Certificate Pair: [\n");
        if (this.forward != null) {
            sb2.append("  Forward: ").append((Object) this.forward).append("\n");
        }
        if (this.reverse != null) {
            sb2.append("  Reverse: ").append((Object) this.reverse).append("\n");
        }
        sb2.append("]");
        return sb2.toString();
    }

    private void parse(DerValue val) throws IOException, CertificateException {
        if (val.tag != 48) {
            throw new IOException("Sequence tag missing for X509CertificatePair");
        }
        while (val.data != null && val.data.available() != 0) {
            DerValue opt = val.data.getDerValue();
            short tag = (byte) (opt.tag & 31);
            switch (tag) {
                case 0:
                    if (opt.isContextSpecific() && opt.isConstructed()) {
                        if (this.forward != null) {
                            throw new IOException("Duplicate forward certificate in X509CertificatePair");
                        }
                        this.forward = X509Factory.intern(new X509CertImpl(opt.data.getDerValue().toByteArray()));
                        break;
                    }
                    break;
                case 1:
                    if (opt.isContextSpecific() && opt.isConstructed()) {
                        if (this.reverse != null) {
                            throw new IOException("Duplicate reverse certificate in X509CertificatePair");
                        }
                        this.reverse = X509Factory.intern(new X509CertImpl(opt.data.getDerValue().toByteArray()));
                        break;
                    }
                    break;
                default:
                    throw new IOException("Invalid encoding of X509CertificatePair");
            }
        }
        if (this.forward == null && this.reverse == null) {
            throw new CertificateException("at least one of certificate pair must be non-null");
        }
    }

    private void emit(DerOutputStream out) throws IOException, CertificateEncodingException {
        DerOutputStream tagged = new DerOutputStream();
        if (this.forward != null) {
            DerOutputStream tmp = new DerOutputStream();
            tmp.putDerValue(new DerValue(this.forward.getEncoded()));
            tagged.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), tmp);
        }
        if (this.reverse != null) {
            DerOutputStream tmp2 = new DerOutputStream();
            tmp2.putDerValue(new DerValue(this.reverse.getEncoded()));
            tagged.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 1), tmp2);
        }
        out.write((byte) 48, tagged);
    }

    private void checkPair() throws CertificateException {
        X509Certificate x509Certificate = this.forward;
        if (x509Certificate == null || this.reverse == null) {
            return;
        }
        X500Principal fwSubject = x509Certificate.getSubjectX500Principal();
        X500Principal fwIssuer = this.forward.getIssuerX500Principal();
        X500Principal rvSubject = this.reverse.getSubjectX500Principal();
        X500Principal rvIssuer = this.reverse.getIssuerX500Principal();
        if (!fwIssuer.equals(rvSubject) || !rvIssuer.equals(fwSubject)) {
            throw new CertificateException("subject and issuer names in forward and reverse certificates do not match");
        }
        try {
            PublicKey pk = this.reverse.getPublicKey();
            if (!(pk instanceof DSAPublicKey) || ((DSAPublicKey) pk).getParams() != null) {
                this.forward.verify(pk);
            }
            PublicKey pk2 = this.forward.getPublicKey();
            if (!(pk2 instanceof DSAPublicKey) || ((DSAPublicKey) pk2).getParams() != null) {
                this.reverse.verify(pk2);
            }
        } catch (GeneralSecurityException e2) {
            throw new CertificateException("invalid signature: " + e2.getMessage());
        }
    }
}
