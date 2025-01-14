package javax.security.cert;

import com.sun.security.cert.internal.x509.X509V1CertImpl;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.Principal;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class X509Certificate extends Certificate {
    private static final String DEFAULT_X509_CERT_CLASS = X509V1CertImpl.class.getName();
    private static String X509Provider = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: javax.security.cert.X509Certificate.1
        @Override // java.security.PrivilegedAction
        public String run() {
            return Security.getProperty(X509Certificate.X509_PROVIDER);
        }
    });
    private static final String X509_PROVIDER = "cert.provider.x509v1";

    public abstract void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException;

    public abstract void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException;

    public abstract Principal getIssuerDN();

    public abstract Date getNotAfter();

    public abstract Date getNotBefore();

    public abstract BigInteger getSerialNumber();

    public abstract String getSigAlgName();

    public abstract String getSigAlgOID();

    public abstract byte[] getSigAlgParams();

    public abstract Principal getSubjectDN();

    public abstract int getVersion();

    public static final X509Certificate getInstance(InputStream inStream) throws CertificateException {
        return getInst(inStream);
    }

    public static final X509Certificate getInstance(byte[] certData) throws CertificateException {
        return getInst(certData);
    }

    private static final X509Certificate getInst(Object value) throws CertificateException {
        Class<?>[] params;
        String className = X509Provider;
        if (className == null || className.length() == 0) {
            className = DEFAULT_X509_CERT_CLASS;
        }
        try {
            if (value instanceof InputStream) {
                params = new Class[]{InputStream.class};
            } else if (value instanceof byte[]) {
                params = new Class[]{value.getClass()};
            } else {
                throw new CertificateException("Unsupported argument type");
            }
            Class<?> certClass = Class.forName(className);
            Constructor<?> cons = certClass.getConstructor(params);
            Object obj = cons.newInstance(value);
            return (X509Certificate) obj;
        } catch (ClassNotFoundException e2) {
            throw new CertificateException("Could not find class: " + ((Object) e2));
        } catch (IllegalAccessException e10) {
            throw new CertificateException("Could not access class: " + ((Object) e10));
        } catch (InstantiationException e11) {
            throw new CertificateException("Problems instantiating: " + ((Object) e11));
        } catch (NoSuchMethodException e12) {
            throw new CertificateException("Could not find class method: " + e12.getMessage());
        } catch (InvocationTargetException e13) {
            throw new CertificateException("InvocationTargetException: " + ((Object) e13.getTargetException()));
        }
    }
}
