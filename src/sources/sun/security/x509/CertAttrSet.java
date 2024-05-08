package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CertAttrSet<T> {
    void delete(String str) throws CertificateException, IOException;

    void encode(OutputStream outputStream) throws CertificateException, IOException;

    Object get(String str) throws CertificateException, IOException;

    Enumeration<T> getElements();

    String getName();

    void set(String str, Object obj) throws CertificateException, IOException;

    String toString();
}
