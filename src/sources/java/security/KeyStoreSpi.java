package java.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;
import javax.crypto.SecretKey;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class KeyStoreSpi {
    public abstract Enumeration<String> engineAliases();

    public abstract boolean engineContainsAlias(String str);

    public abstract void engineDeleteEntry(String str) throws KeyStoreException;

    public abstract java.security.cert.Certificate engineGetCertificate(String str);

    public abstract String engineGetCertificateAlias(java.security.cert.Certificate certificate);

    public abstract java.security.cert.Certificate[] engineGetCertificateChain(String str);

    public abstract Date engineGetCreationDate(String str);

    public abstract Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException;

    public abstract boolean engineIsCertificateEntry(String str);

    public abstract boolean engineIsKeyEntry(String str);

    public abstract void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException;

    public abstract void engineSetCertificateEntry(String str, java.security.cert.Certificate certificate) throws KeyStoreException;

    public abstract void engineSetKeyEntry(String str, Key key, char[] cArr, java.security.cert.Certificate[] certificateArr) throws KeyStoreException;

    public abstract void engineSetKeyEntry(String str, byte[] bArr, java.security.cert.Certificate[] certificateArr) throws KeyStoreException;

    public abstract int engineSize();

    public abstract void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException;

    public void engineStore(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        throw new UnsupportedOperationException();
    }

    public void engineLoad(KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        engineLoad((InputStream) null, param);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void engineLoad(InputStream stream, KeyStore.LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        char[] password;
        if (param == null) {
            engineLoad((InputStream) null, (char[]) null);
            return;
        }
        if (param instanceof KeyStore.SimpleLoadStoreParameter) {
            KeyStore.ProtectionParameter protection = param.getProtectionParameter();
            if (protection instanceof KeyStore.PasswordProtection) {
                password = ((KeyStore.PasswordProtection) protection).getPassword();
            } else if (protection instanceof KeyStore.CallbackHandlerProtection) {
                CallbackHandler handler = ((KeyStore.CallbackHandlerProtection) protection).getCallbackHandler();
                PasswordCallback callback = new PasswordCallback("Password: ", false);
                try {
                    handler.handle(new Callback[]{callback});
                    char[] password2 = callback.getPassword();
                    callback.clearPassword();
                    if (password2 == null) {
                        throw new NoSuchAlgorithmException("No password provided");
                    }
                    password = password2;
                } catch (UnsupportedCallbackException e2) {
                    throw new NoSuchAlgorithmException("Could not obtain password", e2);
                }
            } else {
                throw new NoSuchAlgorithmException("ProtectionParameter must be PasswordProtection or CallbackHandlerProtection");
            }
            engineLoad((InputStream) null, password);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public KeyStore.Entry engineGetEntry(String alias, KeyStore.ProtectionParameter protParam) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableEntryException {
        boolean isCertificateEntry;
        if (alias == null) {
            return null;
        }
        if (!engineIsKeyEntry(alias)) {
            if (!engineContainsAlias(alias)) {
                return null;
            }
            isCertificateEntry = true;
        } else {
            isCertificateEntry = false;
        }
        if (protParam == null && isCertificateEntry) {
            return new KeyStore.TrustedCertificateEntry(engineGetCertificate(alias));
        }
        if (protParam == null || (protParam instanceof KeyStore.PasswordProtection)) {
            if (isCertificateEntry) {
                throw new UnsupportedOperationException("trusted certificate entries are not password-protected");
            }
            char[] password = null;
            if (protParam != null) {
                KeyStore.PasswordProtection pp = (KeyStore.PasswordProtection) protParam;
                password = pp.getPassword();
            }
            Key key = engineGetKey(alias, password);
            if (key instanceof PrivateKey) {
                java.security.cert.Certificate[] chain = engineGetCertificateChain(alias);
                return new KeyStore.PrivateKeyEntry((PrivateKey) key, chain);
            }
            if (key instanceof SecretKey) {
                return new KeyStore.SecretKeyEntry((SecretKey) key);
            }
        }
        throw new UnsupportedOperationException();
    }

    public void engineSetEntry(String alias, KeyStore.Entry entry, KeyStore.ProtectionParameter protParam) throws KeyStoreException {
        if (protParam != null && !(protParam instanceof KeyStore.PasswordProtection)) {
            throw new KeyStoreException("unsupported protection parameter");
        }
        KeyStore.PasswordProtection pProtect = null;
        if (protParam != null) {
            pProtect = (KeyStore.PasswordProtection) protParam;
        }
        char[] password = pProtect == null ? null : pProtect.getPassword();
        if (entry instanceof KeyStore.TrustedCertificateEntry) {
            KeyStore.TrustedCertificateEntry tce = (KeyStore.TrustedCertificateEntry) entry;
            engineSetCertificateEntry(alias, tce.getTrustedCertificate());
        } else if (entry instanceof KeyStore.PrivateKeyEntry) {
            engineSetKeyEntry(alias, ((KeyStore.PrivateKeyEntry) entry).getPrivateKey(), password, ((KeyStore.PrivateKeyEntry) entry).getCertificateChain());
        } else {
            if (entry instanceof KeyStore.SecretKeyEntry) {
                engineSetKeyEntry(alias, ((KeyStore.SecretKeyEntry) entry).getSecretKey(), password, null);
                return;
            }
            throw new KeyStoreException("unsupported entry type: " + entry.getClass().getName());
        }
    }

    public boolean engineEntryInstanceOf(String alias, Class<? extends KeyStore.Entry> entryClass) {
        if (entryClass == KeyStore.TrustedCertificateEntry.class) {
            return engineIsCertificateEntry(alias);
        }
        if (entryClass == KeyStore.PrivateKeyEntry.class) {
            return engineIsKeyEntry(alias) && engineGetCertificate(alias) != null;
        }
        if (entryClass == KeyStore.SecretKeyEntry.class) {
            return engineIsKeyEntry(alias) && engineGetCertificate(alias) == null;
        }
        return false;
    }

    public boolean engineProbe(InputStream stream) throws IOException {
        if (stream == null) {
            throw new NullPointerException("input stream must not be null");
        }
        return false;
    }
}
