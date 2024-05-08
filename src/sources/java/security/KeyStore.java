package java.security;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import org.apache.commons.io.IOUtils;
import sun.security.util.Debug;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class KeyStore {
    private static final String KEYSTORE_TYPE = "keystore.type";
    private static final Debug kdebug = Debug.getInstance("keystore");
    private boolean initialized = false;
    private KeyStoreSpi keyStoreSpi;
    private Provider provider;
    private String type;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface LoadStoreParameter {
        ProtectionParameter getProtectionParameter();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface ProtectionParameter {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PasswordProtection implements ProtectionParameter, Destroyable {
        private volatile boolean destroyed = false;
        private final char[] password;
        private final String protectionAlgorithm;
        private final AlgorithmParameterSpec protectionParameters;

        public PasswordProtection(char[] password) {
            this.password = password == null ? null : (char[]) password.clone();
            this.protectionAlgorithm = null;
            this.protectionParameters = null;
        }

        public PasswordProtection(char[] password, String protectionAlgorithm, AlgorithmParameterSpec protectionParameters) {
            if (protectionAlgorithm == null) {
                throw new NullPointerException("invalid null input");
            }
            this.password = password == null ? null : (char[]) password.clone();
            this.protectionAlgorithm = protectionAlgorithm;
            this.protectionParameters = protectionParameters;
        }

        public String getProtectionAlgorithm() {
            return this.protectionAlgorithm;
        }

        public AlgorithmParameterSpec getProtectionParameters() {
            return this.protectionParameters;
        }

        public synchronized char[] getPassword() {
            if (this.destroyed) {
                throw new IllegalStateException("password has been cleared");
            }
            return this.password;
        }

        @Override // javax.security.auth.Destroyable
        public synchronized void destroy() throws DestroyFailedException {
            this.destroyed = true;
            char[] cArr = this.password;
            if (cArr != null) {
                Arrays.fill(cArr, ' ');
            }
        }

        @Override // javax.security.auth.Destroyable
        public synchronized boolean isDestroyed() {
            return this.destroyed;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CallbackHandlerProtection implements ProtectionParameter {
        private final CallbackHandler handler;

        public CallbackHandlerProtection(CallbackHandler handler) {
            if (handler == null) {
                throw new NullPointerException("handler must not be null");
            }
            this.handler = handler;
        }

        public CallbackHandler getCallbackHandler() {
            return this.handler;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Entry {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public interface Attribute {
            String getName();

            String getValue();
        }

        default Set<Attribute> getAttributes() {
            return Collections.emptySet();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class PrivateKeyEntry implements Entry {
        private final Set<Entry.Attribute> attributes;
        private final java.security.cert.Certificate[] chain;
        private final PrivateKey privKey;

        public PrivateKeyEntry(PrivateKey privateKey, java.security.cert.Certificate[] chain) {
            this(privateKey, chain, Collections.emptySet());
        }

        public PrivateKeyEntry(PrivateKey privateKey, java.security.cert.Certificate[] chain, Set<Entry.Attribute> attributes) {
            if (privateKey == null || chain == null || attributes == null) {
                throw new NullPointerException("invalid null input");
            }
            if (chain.length == 0) {
                throw new IllegalArgumentException("invalid zero-length input chain");
            }
            java.security.cert.Certificate[] clonedChain = (java.security.cert.Certificate[]) chain.clone();
            String certType = clonedChain[0].getType();
            for (int i10 = 1; i10 < clonedChain.length; i10++) {
                if (!certType.equals(clonedChain[i10].getType())) {
                    throw new IllegalArgumentException("chain does not contain certificates of the same type");
                }
            }
            if (!privateKey.getAlgorithm().equals(clonedChain[0].getPublicKey().getAlgorithm())) {
                throw new IllegalArgumentException("private key algorithm does not match algorithm of public key in end entity certificate (at index 0)");
            }
            this.privKey = privateKey;
            if ((clonedChain[0] instanceof X509Certificate) && !(clonedChain instanceof X509Certificate[])) {
                X509Certificate[] x509CertificateArr = new X509Certificate[clonedChain.length];
                this.chain = x509CertificateArr;
                System.arraycopy(clonedChain, 0, x509CertificateArr, 0, clonedChain.length);
            } else {
                this.chain = clonedChain;
            }
            this.attributes = Collections.unmodifiableSet(new HashSet(attributes));
        }

        public PrivateKey getPrivateKey() {
            return this.privKey;
        }

        public java.security.cert.Certificate[] getCertificateChain() {
            return (java.security.cert.Certificate[]) this.chain.clone();
        }

        public java.security.cert.Certificate getCertificate() {
            return this.chain[0];
        }

        @Override // java.security.KeyStore.Entry
        public Set<Entry.Attribute> getAttributes() {
            return this.attributes;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Private key entry and certificate chain with " + this.chain.length + " elements:\r\n");
            for (java.security.cert.Certificate cert : this.chain) {
                sb2.append((Object) cert);
                sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            return sb2.toString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class SecretKeyEntry implements Entry {
        private final Set<Entry.Attribute> attributes;
        private final SecretKey sKey;

        public SecretKeyEntry(SecretKey secretKey) {
            if (secretKey == null) {
                throw new NullPointerException("invalid null input");
            }
            this.sKey = secretKey;
            this.attributes = Collections.emptySet();
        }

        public SecretKeyEntry(SecretKey secretKey, Set<Entry.Attribute> attributes) {
            if (secretKey == null || attributes == null) {
                throw new NullPointerException("invalid null input");
            }
            this.sKey = secretKey;
            this.attributes = Collections.unmodifiableSet(new HashSet(attributes));
        }

        public SecretKey getSecretKey() {
            return this.sKey;
        }

        @Override // java.security.KeyStore.Entry
        public Set<Entry.Attribute> getAttributes() {
            return this.attributes;
        }

        public String toString() {
            return "Secret key entry with algorithm " + this.sKey.getAlgorithm();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class TrustedCertificateEntry implements Entry {
        private final Set<Entry.Attribute> attributes;
        private final java.security.cert.Certificate cert;

        public TrustedCertificateEntry(java.security.cert.Certificate trustedCert) {
            if (trustedCert == null) {
                throw new NullPointerException("invalid null input");
            }
            this.cert = trustedCert;
            this.attributes = Collections.emptySet();
        }

        public TrustedCertificateEntry(java.security.cert.Certificate trustedCert, Set<Entry.Attribute> attributes) {
            if (trustedCert == null || attributes == null) {
                throw new NullPointerException("invalid null input");
            }
            this.cert = trustedCert;
            this.attributes = Collections.unmodifiableSet(new HashSet(attributes));
        }

        public java.security.cert.Certificate getTrustedCertificate() {
            return this.cert;
        }

        @Override // java.security.KeyStore.Entry
        public Set<Entry.Attribute> getAttributes() {
            return this.attributes;
        }

        public String toString() {
            return "Trusted certificate entry:\r\n" + this.cert.toString();
        }
    }

    protected KeyStore(KeyStoreSpi keyStoreSpi, Provider provider, String type) {
        this.keyStoreSpi = keyStoreSpi;
        this.provider = provider;
        this.type = type;
    }

    public static KeyStore getInstance(String type) throws KeyStoreException {
        try {
            Object[] objs = Security.getImpl(type, "KeyStore", (String) null);
            return new KeyStore((KeyStoreSpi) objs[0], (Provider) objs[1], type);
        } catch (NoSuchAlgorithmException nsae) {
            throw new KeyStoreException(type + " not found", nsae);
        } catch (NoSuchProviderException nspe) {
            throw new KeyStoreException(type + " not found", nspe);
        }
    }

    public static KeyStore getInstance(String type, String provider) throws KeyStoreException, NoSuchProviderException {
        if (provider == null || provider.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        try {
            Object[] objs = Security.getImpl(type, "KeyStore", provider);
            return new KeyStore((KeyStoreSpi) objs[0], (Provider) objs[1], type);
        } catch (NoSuchAlgorithmException nsae) {
            throw new KeyStoreException(type + " not found", nsae);
        }
    }

    public static KeyStore getInstance(String type, Provider provider) throws KeyStoreException {
        if (provider == null) {
            throw new IllegalArgumentException("missing provider");
        }
        Objects.requireNonNull(type, "null type name");
        try {
            Object[] objs = Security.getImpl(type, "KeyStore", provider);
            return new KeyStore((KeyStoreSpi) objs[0], (Provider) objs[1], type);
        } catch (NoSuchAlgorithmException nsae) {
            throw new KeyStoreException(type + " not found", nsae);
        }
    }

    public static final String getDefaultType() {
        String kstype = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: java.security.KeyStore.1
            @Override // java.security.PrivilegedAction
            public String run() {
                return Security.getProperty(KeyStore.KEYSTORE_TYPE);
            }
        });
        if (kstype == null) {
            return "jks";
        }
        return kstype;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getType() {
        return this.type;
    }

    public final Key getKey(String alias, char[] password) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineGetKey(alias, password);
    }

    public final java.security.cert.Certificate[] getCertificateChain(String alias) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineGetCertificateChain(alias);
    }

    public final java.security.cert.Certificate getCertificate(String alias) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineGetCertificate(alias);
    }

    public final Date getCreationDate(String alias) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineGetCreationDate(alias);
    }

    public final void setKeyEntry(String alias, Key key, char[] password, java.security.cert.Certificate[] chain) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        if ((key instanceof PrivateKey) && (chain == null || chain.length == 0)) {
            throw new IllegalArgumentException("Private key must be accompanied by certificate chain");
        }
        this.keyStoreSpi.engineSetKeyEntry(alias, key, password, chain);
    }

    public final void setKeyEntry(String alias, byte[] key, java.security.cert.Certificate[] chain) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineSetKeyEntry(alias, key, chain);
    }

    public final void setCertificateEntry(String alias, java.security.cert.Certificate cert) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineSetCertificateEntry(alias, cert);
    }

    public final void deleteEntry(String alias) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineDeleteEntry(alias);
    }

    public final Enumeration<String> aliases() throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineAliases();
    }

    public final boolean containsAlias(String alias) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineContainsAlias(alias);
    }

    public final int size() throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineSize();
    }

    public final boolean isKeyEntry(String alias) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineIsKeyEntry(alias);
    }

    public final boolean isCertificateEntry(String alias) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineIsCertificateEntry(alias);
    }

    public final String getCertificateAlias(java.security.cert.Certificate cert) throws KeyStoreException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineGetCertificateAlias(cert);
    }

    public final void store(OutputStream stream, char[] password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineStore(stream, password);
    }

    public final void store(LoadStoreParameter param) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineStore(param);
    }

    public final void load(InputStream stream, char[] password) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.keyStoreSpi.engineLoad(stream, password);
        this.initialized = true;
    }

    public final void load(LoadStoreParameter param) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.keyStoreSpi.engineLoad(param);
        this.initialized = true;
    }

    public final Entry getEntry(String alias, ProtectionParameter protParam) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        if (alias == null) {
            throw new NullPointerException("invalid null input");
        }
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineGetEntry(alias, protParam);
    }

    public final void setEntry(String alias, Entry entry, ProtectionParameter protParam) throws KeyStoreException {
        if (alias == null || entry == null) {
            throw new NullPointerException("invalid null input");
        }
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        this.keyStoreSpi.engineSetEntry(alias, entry, protParam);
    }

    public final boolean entryInstanceOf(String alias, Class<? extends Entry> entryClass) throws KeyStoreException {
        if (alias == null || entryClass == null) {
            throw new NullPointerException("invalid null input");
        }
        if (!this.initialized) {
            throw new KeyStoreException("Uninitialized keystore");
        }
        return this.keyStoreSpi.engineEntryInstanceOf(alias, entryClass);
    }

    public static final KeyStore getInstance(File file, char[] password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        return getInstance(file, password, null, true);
    }

    public static final KeyStore getInstance(File file, LoadStoreParameter param) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        return getInstance(file, null, param, false);
    }

    private static final KeyStore getInstance(File file, char[] password, LoadStoreParameter param, boolean hasPassword) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        Object[] objs;
        KeyStoreSpi impl;
        if (file == null) {
            throw new NullPointerException();
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException("File does not exist or it does not refer to a normal file: " + ((Object) file));
        }
        KeyStore keystore = null;
        DataInputStream dataStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            dataStream.mark(Integer.MAX_VALUE);
            Iterator<String> iterator2 = Security.getAlgorithms("KeyStore").iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                String type = iterator2.next();
                try {
                    try {
                        objs = Security.getImpl(type, "KeyStore", (String) null);
                        impl = (KeyStoreSpi) objs[0];
                    } catch (NoSuchAlgorithmException | NoSuchProviderException e2) {
                        Debug debug = kdebug;
                        if (debug != null) {
                            debug.println(type + " not found - " + ((Object) e2));
                        }
                    }
                } catch (IOException e10) {
                    Debug debug2 = kdebug;
                    if (debug2 != null) {
                        debug2.println("I/O error in " + ((Object) file) + " - " + ((Object) e10));
                    }
                }
                if (impl.engineProbe(dataStream)) {
                    Debug debug3 = kdebug;
                    if (debug3 != null) {
                        debug3.println(type + " keystore detected: " + ((Object) file));
                    }
                    KeyStore keystore2 = new KeyStore(impl, (Provider) objs[1], type);
                    keystore = keystore2;
                    break;
                }
                continue;
                dataStream.reset();
            }
            if (keystore != null) {
                dataStream.reset();
                if (hasPassword) {
                    keystore.load(dataStream, password);
                } else {
                    keystore.keyStoreSpi.engineLoad(dataStream, param);
                    keystore.initialized = true;
                }
                dataStream.close();
                return keystore;
            }
            dataStream.close();
            throw new KeyStoreException("Unrecognized keystore format. Please load it with a specified type");
        } catch (Throwable th) {
            try {
                dataStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Builder {
        static final int MAX_CALLBACK_TRIES = 3;

        public abstract KeyStore getKeyStore() throws KeyStoreException;

        public abstract ProtectionParameter getProtectionParameter(String str) throws KeyStoreException;

        protected Builder() {
        }

        public static Builder newInstance(final KeyStore keyStore, final ProtectionParameter protectionParameter) {
            if (keyStore == null || protectionParameter == null) {
                throw new NullPointerException();
            }
            if (!keyStore.initialized) {
                throw new IllegalArgumentException("KeyStore not initialized");
            }
            return new Builder() { // from class: java.security.KeyStore.Builder.1
                private volatile boolean getCalled;

                @Override // java.security.KeyStore.Builder
                public KeyStore getKeyStore() {
                    this.getCalled = true;
                    return KeyStore.this;
                }

                @Override // java.security.KeyStore.Builder
                public ProtectionParameter getProtectionParameter(String alias) {
                    if (alias == null) {
                        throw new NullPointerException();
                    }
                    if (!this.getCalled) {
                        throw new IllegalStateException("getKeyStore() must be called first");
                    }
                    return protectionParameter;
                }
            };
        }

        public static Builder newInstance(String type, Provider provider, File file, ProtectionParameter protection) {
            if (type == null || file == null || protection == null) {
                throw new NullPointerException();
            }
            if (!(protection instanceof PasswordProtection) && !(protection instanceof CallbackHandlerProtection)) {
                throw new IllegalArgumentException("Protection must be PasswordProtection or CallbackHandlerProtection");
            }
            if (!file.isFile()) {
                throw new IllegalArgumentException("File does not exist or it does not refer to a normal file: " + ((Object) file));
            }
            return new FileBuilder(type, provider, file, protection, AccessController.getContext());
        }

        public static Builder newInstance(File file, ProtectionParameter protection) {
            return newInstance("", null, file, protection);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class FileBuilder extends Builder {
            private final AccessControlContext context;
            private final File file;
            private ProtectionParameter keyProtection;
            private KeyStore keyStore;
            private Throwable oldException;
            private ProtectionParameter protection;
            private final Provider provider;
            private final String type;

            FileBuilder(String type, Provider provider, File file, ProtectionParameter protection, AccessControlContext context) {
                this.type = type;
                this.provider = provider;
                this.file = file;
                this.protection = protection;
                this.context = context;
            }

            @Override // java.security.KeyStore.Builder
            public synchronized KeyStore getKeyStore() throws KeyStoreException {
                KeyStore keyStore = this.keyStore;
                if (keyStore != null) {
                    return keyStore;
                }
                Throwable th = this.oldException;
                if (th != null) {
                    throw new KeyStoreException("Previous KeyStore instantiation failed", th);
                }
                PrivilegedExceptionAction<KeyStore> action = new PrivilegedExceptionAction<KeyStore>() { // from class: java.security.KeyStore.Builder.FileBuilder.1
                    @Override // java.security.PrivilegedExceptionAction
                    public KeyStore run() throws Exception {
                        if (!(FileBuilder.this.protection instanceof CallbackHandlerProtection)) {
                            return run0();
                        }
                        int tries = 0;
                        do {
                            tries++;
                            try {
                                return run0();
                            } catch (IOException e2) {
                                if (tries >= 3) {
                                    break;
                                }
                                throw e2;
                            }
                        } while (e2.getCause() instanceof UnrecoverableKeyException);
                        throw e2;
                    }

                    public KeyStore run0() throws Exception {
                        char[] password;
                        KeyStore ks;
                        if (FileBuilder.this.protection instanceof PasswordProtection) {
                            password = ((PasswordProtection) FileBuilder.this.protection).getPassword();
                            FileBuilder fileBuilder = FileBuilder.this;
                            fileBuilder.keyProtection = fileBuilder.protection;
                        } else {
                            CallbackHandler handler = ((CallbackHandlerProtection) FileBuilder.this.protection).getCallbackHandler();
                            PasswordCallback callback = new PasswordCallback("Password for keystore " + FileBuilder.this.file.getName(), false);
                            handler.handle(new Callback[]{callback});
                            password = callback.getPassword();
                            if (password == null) {
                                throw new KeyStoreException("No password provided");
                            }
                            callback.clearPassword();
                            FileBuilder.this.keyProtection = new PasswordProtection(password);
                        }
                        if (FileBuilder.this.type.isEmpty()) {
                            KeyStore ks2 = KeyStore.getInstance(FileBuilder.this.file, password);
                            return ks2;
                        }
                        if (FileBuilder.this.provider == null) {
                            ks = KeyStore.getInstance(FileBuilder.this.type);
                        } else {
                            ks = KeyStore.getInstance(FileBuilder.this.type, FileBuilder.this.provider);
                        }
                        InputStream in = new FileInputStream(FileBuilder.this.file);
                        try {
                            ks.load(in, password);
                            in.close();
                            return ks;
                        } catch (Throwable th2) {
                            try {
                                in.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                };
                try {
                    KeyStore keyStore2 = (KeyStore) AccessController.doPrivileged(action, this.context);
                    this.keyStore = keyStore2;
                    return keyStore2;
                } catch (PrivilegedActionException e2) {
                    Throwable cause = e2.getCause();
                    this.oldException = cause;
                    throw new KeyStoreException("KeyStore instantiation failed", cause);
                }
            }

            @Override // java.security.KeyStore.Builder
            public synchronized ProtectionParameter getProtectionParameter(String alias) {
                try {
                    if (alias == null) {
                        throw new NullPointerException();
                    }
                    if (this.keyStore == null) {
                        throw new IllegalStateException("getKeyStore() must be called first");
                    }
                } catch (Throwable th) {
                    throw th;
                }
                return this.keyProtection;
            }
        }

        public static Builder newInstance(final String type, final Provider provider, final ProtectionParameter protection) {
            if (type == null || protection == null) {
                throw new NullPointerException();
            }
            final AccessControlContext context = AccessController.getContext();
            return new Builder() { // from class: java.security.KeyStore.Builder.2
                private final PrivilegedExceptionAction<KeyStore> action = new PrivilegedExceptionAction<KeyStore>() { // from class: java.security.KeyStore.Builder.2.1
                    @Override // java.security.PrivilegedExceptionAction
                    public KeyStore run() throws Exception {
                        KeyStore ks;
                        if (Provider.this == null) {
                            ks = KeyStore.getInstance(type);
                        } else {
                            ks = KeyStore.getInstance(type, Provider.this);
                        }
                        LoadStoreParameter param = new SimpleLoadStoreParameter(protection);
                        if (!(protection instanceof CallbackHandlerProtection)) {
                            ks.load(param);
                        } else {
                            int tries = 0;
                            while (true) {
                                tries++;
                                try {
                                    ks.load(param);
                                    break;
                                } catch (IOException e2) {
                                    if (!(e2.getCause() instanceof UnrecoverableKeyException)) {
                                        break;
                                    }
                                    if (tries >= 3) {
                                        AnonymousClass2.this.oldException = e2;
                                        break;
                                    }
                                    throw e2;
                                }
                            }
                            throw e2;
                        }
                        AnonymousClass2.this.getCalled = true;
                        return ks;
                    }
                };
                private volatile boolean getCalled;
                private IOException oldException;

                @Override // java.security.KeyStore.Builder
                public synchronized KeyStore getKeyStore() throws KeyStoreException {
                    IOException iOException = this.oldException;
                    if (iOException != null) {
                        throw new KeyStoreException("Previous KeyStore instantiation failed", iOException);
                    }
                    try {
                    } catch (PrivilegedActionException e2) {
                        Throwable cause = e2.getCause();
                        throw new KeyStoreException("KeyStore instantiation failed", cause);
                    }
                    return (KeyStore) AccessController.doPrivileged(this.action, context);
                }

                @Override // java.security.KeyStore.Builder
                public ProtectionParameter getProtectionParameter(String alias) {
                    if (alias == null) {
                        throw new NullPointerException();
                    }
                    if (!this.getCalled) {
                        throw new IllegalStateException("getKeyStore() must be called first");
                    }
                    return protection;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SimpleLoadStoreParameter implements LoadStoreParameter {
        private final ProtectionParameter protection;

        SimpleLoadStoreParameter(ProtectionParameter protection) {
            this.protection = protection;
        }

        @Override // java.security.KeyStore.LoadStoreParameter
        public ProtectionParameter getProtectionParameter() {
            return this.protection;
        }
    }
}
