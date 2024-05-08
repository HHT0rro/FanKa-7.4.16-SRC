package com.sun.security.cert.internal.x509;

import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Date;
import javax.security.cert.CertificateEncodingException;
import javax.security.cert.CertificateExpiredException;
import javax.security.cert.CertificateNotYetValidException;
import javax.security.cert.X509Certificate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509V1CertImpl extends X509Certificate implements Serializable {
    static final long serialVersionUID = -2048442350420423405L;
    private java.security.cert.X509Certificate wrappedCert;

    private static synchronized CertificateFactory getFactory() throws CertificateException {
        CertificateFactory certificateFactory;
        synchronized (X509V1CertImpl.class) {
            certificateFactory = CertificateFactory.getInstance(e.f29912b);
        }
        return certificateFactory;
    }

    public X509V1CertImpl() {
    }

    public X509V1CertImpl(byte[] certData) throws javax.security.cert.CertificateException {
        try {
            ByteArrayInputStream bs = new ByteArrayInputStream(certData);
            this.wrappedCert = (java.security.cert.X509Certificate) getFactory().generateCertificate(bs);
        } catch (CertificateException e2) {
            throw new javax.security.cert.CertificateException(e2.getMessage());
        }
    }

    public X509V1CertImpl(InputStream in) throws javax.security.cert.CertificateException {
        try {
            this.wrappedCert = (java.security.cert.X509Certificate) getFactory().generateCertificate(in);
        } catch (CertificateException e2) {
            throw new javax.security.cert.CertificateException(e2.getMessage());
        }
    }

    @Override // javax.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.wrappedCert.getEncoded();
        } catch (java.security.cert.CertificateEncodingException e2) {
            throw new CertificateEncodingException(e2.getMessage());
        }
    }

    @Override // javax.security.cert.Certificate
    public void verify(PublicKey key) throws javax.security.cert.CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        try {
            this.wrappedCert.verify(key);
        } catch (CertificateException e2) {
            throw new javax.security.cert.CertificateException(e2.getMessage());
        }
    }

    @Override // javax.security.cert.Certificate
    public void verify(PublicKey key, String sigProvider) throws javax.security.cert.CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        try {
            this.wrappedCert.verify(key, sigProvider);
        } catch (CertificateException e2) {
            throw new javax.security.cert.CertificateException(e2.getMessage());
        }
    }

    @Override // javax.security.cert.X509Certificate
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    @Override // javax.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        try {
            this.wrappedCert.checkValidity(date);
        } catch (java.security.cert.CertificateExpiredException e2) {
            throw new CertificateExpiredException(e2.getMessage());
        } catch (java.security.cert.CertificateNotYetValidException e10) {
            throw new CertificateNotYetValidException(e10.getMessage());
        }
    }

    @Override // javax.security.cert.Certificate
    public String toString() {
        return this.wrappedCert.toString();
    }

    @Override // javax.security.cert.Certificate
    public PublicKey getPublicKey() {
        PublicKey key = this.wrappedCert.getPublicKey();
        return key;
    }

    @Override // javax.security.cert.X509Certificate
    public int getVersion() {
        return this.wrappedCert.getVersion() - 1;
    }

    @Override // javax.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.wrappedCert.getSerialNumber();
    }

    @Override // javax.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return this.wrappedCert.getSubjectDN();
    }

    @Override // javax.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return this.wrappedCert.getIssuerDN();
    }

    @Override // javax.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.wrappedCert.getNotBefore();
    }

    @Override // javax.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.wrappedCert.getNotAfter();
    }

    @Override // javax.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.wrappedCert.getSigAlgName();
    }

    @Override // javax.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.wrappedCert.getSigAlgOID();
    }

    @Override // javax.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return this.wrappedCert.getSigAlgParams();
    }

    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        try {
            stream.write(getEncoded());
        } catch (CertificateEncodingException e2) {
            throw new IOException("getEncoded failed: " + e2.getMessage());
        }
    }

    private synchronized void readObject(ObjectInputStream stream) throws IOException {
        try {
            this.wrappedCert = (java.security.cert.X509Certificate) getFactory().generateCertificate(stream);
        } catch (CertificateException e2) {
            throw new IOException("generateCertificate failed: " + e2.getMessage());
        }
    }

    public java.security.cert.X509Certificate getX509Certificate() {
        return this.wrappedCert;
    }
}
