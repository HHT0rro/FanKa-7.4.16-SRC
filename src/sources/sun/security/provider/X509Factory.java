package sun.security.provider;

import com.android.internal.logging.nano.MetricsProto;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import sun.security.util.Cache;
import sun.security.x509.X509CRLImpl;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509Factory {
    private static final int ENC_MAX_LENGTH = 4194304;
    private static final Cache<Object, X509CertImpl> certCache = Cache.newSoftMemoryCache(MetricsProto.MetricsEvent.SETTINGS_LANGUAGE_CATEGORY);
    private static final Cache<Object, X509CRLImpl> crlCache = Cache.newSoftMemoryCache(MetricsProto.MetricsEvent.SETTINGS_LANGUAGE_CATEGORY);

    public static synchronized X509CertImpl intern(X509Certificate c4) throws CertificateException {
        byte[] encoding;
        X509CertImpl newC;
        synchronized (X509Factory.class) {
            if (c4 == null) {
                return null;
            }
            boolean isImpl = c4 instanceof X509CertImpl;
            if (isImpl) {
                encoding = ((X509CertImpl) c4).getEncodedInternal();
            } else {
                encoding = c4.getEncoded();
            }
            Cache<Object, X509CertImpl> cache = certCache;
            X509CertImpl newC2 = (X509CertImpl) getFromCache(cache, encoding);
            if (newC2 != null) {
                return newC2;
            }
            if (isImpl) {
                newC = (X509CertImpl) c4;
            } else {
                newC = new X509CertImpl(encoding);
                encoding = newC.getEncodedInternal();
            }
            addToCache(cache, encoding, newC);
            return newC;
        }
    }

    public static synchronized X509CRLImpl intern(X509CRL c4) throws CRLException {
        byte[] encoding;
        X509CRLImpl newC;
        synchronized (X509Factory.class) {
            if (c4 == null) {
                return null;
            }
            boolean isImpl = c4 instanceof X509CRLImpl;
            if (isImpl) {
                encoding = ((X509CRLImpl) c4).getEncodedInternal();
            } else {
                encoding = c4.getEncoded();
            }
            Cache<Object, X509CRLImpl> cache = crlCache;
            X509CRLImpl newC2 = (X509CRLImpl) getFromCache(cache, encoding);
            if (newC2 != null) {
                return newC2;
            }
            if (isImpl) {
                newC = (X509CRLImpl) c4;
            } else {
                newC = new X509CRLImpl(encoding);
                encoding = newC.getEncodedInternal();
            }
            addToCache(cache, encoding, newC);
            return newC;
        }
    }

    private static synchronized <K, V> V getFromCache(Cache<K, V> cache, byte[] encoding) {
        V v2;
        synchronized (X509Factory.class) {
            Object key = new Cache.EqualByteArray(encoding);
            v2 = cache.get(key);
        }
        return v2;
    }

    private static synchronized <V> void addToCache(Cache<Object, V> cache, byte[] encoding, V value) {
        synchronized (X509Factory.class) {
            if (encoding.length > 4194304) {
                return;
            }
            Object key = new Cache.EqualByteArray(encoding);
            cache.put(key, value);
        }
    }
}
