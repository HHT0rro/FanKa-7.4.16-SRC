package java.security;

import com.alibaba.security.realidentity.build.cg;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import sun.security.jca.GetInstance;
import sun.security.jca.Providers;
import sun.security.jca.ServiceId;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Signature extends SignatureSpi {
    private static final String RSA_CIPHER = "RSA/ECB/PKCS1Padding";
    protected static final int SIGN = 2;
    protected static final int UNINITIALIZED = 0;
    protected static final int VERIFY = 3;
    private static final Map<String, Boolean> signatureInfo;
    private String algorithm;
    Provider provider;
    protected int state = 0;
    private static final String RSA_SIGNATURE = "NONEwithRSA";
    private static final List<ServiceId> rsaIds = Arrays.asList(new ServiceId(cg.f3335y, RSA_SIGNATURE), new ServiceId("Cipher", "RSA/ECB/PKCS1Padding"), new ServiceId("Cipher", "RSA/ECB"), new ServiceId("Cipher", "RSA//PKCS1Padding"), new ServiceId("Cipher", "RSA"));

    protected Signature(String algorithm) {
        this.algorithm = algorithm;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        signatureInfo = concurrentHashMap;
        Boolean TRUE = Boolean.TRUE;
        concurrentHashMap.put("sun.security.provider.DSA$RawDSA", TRUE);
        concurrentHashMap.put("sun.security.provider.DSA$SHA1withDSA", TRUE);
        concurrentHashMap.put("sun.security.rsa.RSASignature$MD2withRSA", TRUE);
        concurrentHashMap.put("sun.security.rsa.RSASignature$MD5withRSA", TRUE);
        concurrentHashMap.put("sun.security.rsa.RSASignature$SHA1withRSA", TRUE);
        concurrentHashMap.put("sun.security.rsa.RSASignature$SHA256withRSA", TRUE);
        concurrentHashMap.put("sun.security.rsa.RSASignature$SHA384withRSA", TRUE);
        concurrentHashMap.put("sun.security.rsa.RSASignature$SHA512withRSA", TRUE);
        concurrentHashMap.put("com.sun.net.ssl.internal.ssl.RSASignature", TRUE);
        concurrentHashMap.put("sun.security.pkcs11.P11Signature", TRUE);
    }

    public static Signature getInstance(String algorithm) throws NoSuchAlgorithmException {
        List<Provider.Service> list;
        if (algorithm.equalsIgnoreCase(RSA_SIGNATURE)) {
            list = GetInstance.getServices(rsaIds);
        } else {
            list = GetInstance.getServices(cg.f3335y, algorithm);
        }
        Iterator<Provider.Service> t2 = list.iterator2();
        if (!t2.hasNext()) {
            throw new NoSuchAlgorithmException(algorithm + " Signature not available");
        }
        do {
            Provider.Service s2 = t2.next();
            if (isSpi(s2)) {
                return new Delegate(algorithm);
            }
            try {
                GetInstance.Instance instance = GetInstance.getInstance(s2, SignatureSpi.class);
                return getInstance(instance, algorithm);
            } catch (NoSuchAlgorithmException e2) {
            }
        } while (t2.hasNext());
        throw e2;
    }

    private static Signature getInstance(GetInstance.Instance instance, String algorithm) {
        Signature sig;
        if (instance.impl instanceof Signature) {
            sig = (Signature) instance.impl;
            sig.algorithm = algorithm;
        } else {
            SignatureSpi spi = (SignatureSpi) instance.impl;
            sig = new Delegate(spi, algorithm);
        }
        sig.provider = instance.provider;
        return sig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSpi(Provider.Service s2) {
        boolean r10 = true;
        if (s2.getType().equals("Cipher")) {
            return true;
        }
        String className = s2.getClassName();
        Map<String, Boolean> map = signatureInfo;
        Boolean result = map.get(className);
        if (result == null) {
            try {
                Object instance = s2.newInstance(null);
                if (!(instance instanceof SignatureSpi) || (instance instanceof Signature)) {
                    r10 = false;
                }
                result = Boolean.valueOf(r10);
                map.put(className, result);
            } catch (Exception e2) {
                return false;
            }
        }
        return result.booleanValue();
    }

    public static Signature getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (algorithm.equalsIgnoreCase(RSA_SIGNATURE)) {
            if (provider == null || provider.length() == 0) {
                throw new IllegalArgumentException("missing provider");
            }
            Provider p10 = Security.getProvider(provider);
            if (p10 == null) {
                throw new NoSuchProviderException("no such provider: " + provider);
            }
            return getInstanceRSA(p10);
        }
        Providers.checkBouncyCastleDeprecation(provider, cg.f3335y, algorithm);
        GetInstance.Instance instance = GetInstance.getInstance(cg.f3335y, (Class<?>) SignatureSpi.class, algorithm, provider);
        return getInstance(instance, algorithm);
    }

    public static Signature getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (algorithm.equalsIgnoreCase(RSA_SIGNATURE)) {
            if (provider == null) {
                throw new IllegalArgumentException("missing provider");
            }
            return getInstanceRSA(provider);
        }
        Providers.checkBouncyCastleDeprecation(provider, cg.f3335y, algorithm);
        GetInstance.Instance instance = GetInstance.getInstance(cg.f3335y, (Class<?>) SignatureSpi.class, algorithm, provider);
        return getInstance(instance, algorithm);
    }

    private static Signature getInstanceRSA(Provider p10) throws NoSuchAlgorithmException {
        Provider.Service s2 = p10.getService(cg.f3335y, RSA_SIGNATURE);
        if (s2 != null) {
            GetInstance.Instance instance = GetInstance.getInstance(s2, SignatureSpi.class);
            return getInstance(instance, RSA_SIGNATURE);
        }
        try {
            Cipher c4 = Cipher.getInstance("RSA/ECB/PKCS1Padding", p10);
            return new Delegate(new CipherAdapter(c4), RSA_SIGNATURE);
        } catch (GeneralSecurityException e2) {
            throw new NoSuchAlgorithmException("no such algorithm: NONEwithRSA for provider " + p10.getName(), e2);
        }
    }

    public final Provider getProvider() {
        chooseFirstProvider();
        return this.provider;
    }

    void chooseFirstProvider() {
    }

    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        engineInitVerify(publicKey);
        this.state = 3;
    }

    public final void initVerify(java.security.cert.Certificate certificate) throws InvalidKeyException {
        X509Certificate cert;
        Set<String> critSet;
        boolean[] keyUsageInfo;
        if ((certificate instanceof X509Certificate) && (critSet = (cert = (X509Certificate) certificate).getCriticalExtensionOIDs()) != null && !critSet.isEmpty() && critSet.contains("2.5.29.15") && (keyUsageInfo = cert.getKeyUsage()) != null && !keyUsageInfo[0]) {
            throw new InvalidKeyException("Wrong key usage");
        }
        PublicKey publicKey = certificate.getPublicKey();
        engineInitVerify(publicKey);
        this.state = 3;
    }

    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        engineInitSign(privateKey);
        this.state = 2;
    }

    public final void initSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        engineInitSign(privateKey, random);
        this.state = 2;
    }

    public final byte[] sign() throws SignatureException {
        if (this.state == 2) {
            return engineSign();
        }
        throw new SignatureException("object not initialized for signing");
    }

    public final int sign(byte[] outbuf, int offset, int len) throws SignatureException {
        if (outbuf == null) {
            throw new IllegalArgumentException("No output buffer given");
        }
        if (offset < 0 || len < 0) {
            throw new IllegalArgumentException("offset or len is less than 0");
        }
        if (outbuf.length - offset < len) {
            throw new IllegalArgumentException("Output buffer too small for specified offset and length");
        }
        if (this.state != 2) {
            throw new SignatureException("object not initialized for signing");
        }
        return engineSign(outbuf, offset, len);
    }

    public final boolean verify(byte[] signature) throws SignatureException {
        if (this.state == 3) {
            return engineVerify(signature);
        }
        throw new SignatureException("object not initialized for verification");
    }

    public final boolean verify(byte[] signature, int offset, int length) throws SignatureException {
        if (this.state == 3) {
            if (signature == null) {
                throw new IllegalArgumentException("signature is null");
            }
            if (offset < 0 || length < 0) {
                throw new IllegalArgumentException("offset or length is less than 0");
            }
            if (signature.length - offset < length) {
                throw new IllegalArgumentException("signature too small for specified offset and length");
            }
            return engineVerify(signature, offset, length);
        }
        throw new SignatureException("object not initialized for verification");
    }

    public final void update(byte b4) throws SignatureException {
        int i10 = this.state;
        if (i10 == 3 || i10 == 2) {
            engineUpdate(b4);
            return;
        }
        throw new SignatureException("object not initialized for signature or verification");
    }

    public final void update(byte[] data) throws SignatureException {
        update(data, 0, data.length);
    }

    public final void update(byte[] data, int off, int len) throws SignatureException {
        int i10 = this.state;
        if (i10 == 2 || i10 == 3) {
            if (data == null) {
                throw new IllegalArgumentException("data is null");
            }
            if (off < 0 || len < 0) {
                throw new IllegalArgumentException("off or len is less than 0");
            }
            if (data.length - off < len) {
                throw new IllegalArgumentException("data too small for specified offset and length");
            }
            engineUpdate(data, off, len);
            return;
        }
        throw new SignatureException("object not initialized for signature or verification");
    }

    public final void update(ByteBuffer data) throws SignatureException {
        int i10 = this.state;
        if (i10 != 2 && i10 != 3) {
            throw new SignatureException("object not initialized for signature or verification");
        }
        if (data == null) {
            throw new NullPointerException();
        }
        engineUpdate(data);
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public String toString() {
        String initState = "";
        switch (this.state) {
            case 0:
                initState = "<not initialized>";
                break;
            case 2:
                initState = "<initialized for signing>";
                break;
            case 3:
                initState = "<initialized for verifying>";
                break;
        }
        return "Signature object: " + getAlgorithm() + initState;
    }

    @Deprecated
    public final void setParameter(String param, Object value) throws InvalidParameterException {
        engineSetParameter(param, value);
    }

    public final void setParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        engineSetParameter(params);
    }

    public final AlgorithmParameters getParameters() {
        return engineGetParameters();
    }

    @Deprecated
    public final Object getParameter(String param) throws InvalidParameterException {
        return engineGetParameter(param);
    }

    @Override // java.security.SignatureSpi
    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }

    public SignatureSpi getCurrentSpi() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Delegate extends Signature {
        private static final int I_PRIV = 2;
        private static final int I_PRIV_SR = 3;
        private static final int I_PUB = 1;
        private static int warnCount = 10;
        private final Object lock;
        private SignatureSpi sigSpi;

        Delegate(SignatureSpi sigSpi, String algorithm) {
            super(algorithm);
            this.sigSpi = sigSpi;
            this.lock = null;
        }

        Delegate(String algorithm) {
            super(algorithm);
            this.lock = new Object();
        }

        @Override // java.security.Signature, java.security.SignatureSpi
        public Object clone() throws CloneNotSupportedException {
            chooseFirstProvider();
            SignatureSpi signatureSpi = this.sigSpi;
            if (signatureSpi instanceof Cloneable) {
                SignatureSpi sigSpiClone = (SignatureSpi) signatureSpi.clone();
                Signature that = new Delegate(sigSpiClone, ((Signature) this).algorithm);
                that.provider = this.provider;
                return that;
            }
            throw new CloneNotSupportedException();
        }

        private static SignatureSpi newInstance(Provider.Service s2) throws NoSuchAlgorithmException {
            if (s2.getType().equals("Cipher")) {
                try {
                    Cipher c4 = Cipher.getInstance("RSA/ECB/PKCS1Padding", s2.getProvider());
                    return new CipherAdapter(c4);
                } catch (NoSuchPaddingException e2) {
                    throw new NoSuchAlgorithmException(e2);
                }
            }
            Object o10 = s2.newInstance(null);
            if (!(o10 instanceof SignatureSpi)) {
                throw new NoSuchAlgorithmException("Not a SignatureSpi: " + o10.getClass().getName());
            }
            return (SignatureSpi) o10;
        }

        @Override // java.security.Signature
        void chooseFirstProvider() {
            List<Provider.Service> list;
            if (this.sigSpi != null) {
                return;
            }
            synchronized (this.lock) {
                if (this.sigSpi != null) {
                    return;
                }
                Exception lastException = null;
                if (((Signature) this).algorithm.equalsIgnoreCase(Signature.RSA_SIGNATURE)) {
                    list = GetInstance.getServices(Signature.rsaIds);
                } else {
                    list = GetInstance.getServices(cg.f3335y, ((Signature) this).algorithm);
                }
                for (Provider.Service s2 : list) {
                    if (Signature.isSpi(s2)) {
                        try {
                            this.sigSpi = newInstance(s2);
                            this.provider = s2.getProvider();
                            return;
                        } catch (NoSuchAlgorithmException e2) {
                            lastException = e2;
                        }
                    }
                }
                ProviderException e10 = new ProviderException("Could not construct SignatureSpi instance");
                if (lastException == null) {
                    throw e10;
                }
                e10.initCause(lastException);
                throw e10;
            }
        }

        private void chooseProvider(int type, Key key, SecureRandom random) throws InvalidKeyException {
            List<Provider.Service> list;
            synchronized (this.lock) {
                SignatureSpi signatureSpi = this.sigSpi;
                if (signatureSpi != null && key == null) {
                    init(signatureSpi, type, key, random);
                    return;
                }
                Exception lastException = null;
                if (((Signature) this).algorithm.equalsIgnoreCase(Signature.RSA_SIGNATURE)) {
                    list = GetInstance.getServices(Signature.rsaIds);
                } else {
                    list = GetInstance.getServices(cg.f3335y, ((Signature) this).algorithm);
                }
                for (Provider.Service s2 : list) {
                    if (s2.supportsParameter(key) && Signature.isSpi(s2)) {
                        try {
                            SignatureSpi spi = newInstance(s2);
                            init(spi, type, key, random);
                            this.provider = s2.getProvider();
                            this.sigSpi = spi;
                            return;
                        } catch (Exception e2) {
                            if (lastException == null) {
                                lastException = e2;
                            }
                            if (lastException instanceof InvalidKeyException) {
                                throw ((InvalidKeyException) lastException);
                            }
                        }
                    }
                }
                if (lastException instanceof InvalidKeyException) {
                    throw ((InvalidKeyException) lastException);
                }
                if (lastException instanceof RuntimeException) {
                    throw ((RuntimeException) lastException);
                }
                String k10 = key != null ? key.getClass().getName() : "(null)";
                throw new InvalidKeyException("No installed provider supports this key: " + k10, lastException);
            }
        }

        private void init(SignatureSpi spi, int type, Key key, SecureRandom random) throws InvalidKeyException {
            switch (type) {
                case 1:
                    spi.engineInitVerify((PublicKey) key);
                    return;
                case 2:
                    spi.engineInitSign((PrivateKey) key);
                    return;
                case 3:
                    spi.engineInitSign((PrivateKey) key, random);
                    return;
                default:
                    throw new AssertionError((Object) ("Internal error: " + type));
            }
        }

        @Override // java.security.SignatureSpi
        protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
            SignatureSpi signatureSpi = this.sigSpi;
            if (signatureSpi != null && (this.lock == null || publicKey == null)) {
                signatureSpi.engineInitVerify(publicKey);
            } else {
                chooseProvider(1, publicKey, null);
            }
        }

        @Override // java.security.SignatureSpi
        protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            SignatureSpi signatureSpi = this.sigSpi;
            if (signatureSpi != null && (this.lock == null || privateKey == null)) {
                signatureSpi.engineInitSign(privateKey);
            } else {
                chooseProvider(2, privateKey, null);
            }
        }

        @Override // java.security.SignatureSpi
        protected void engineInitSign(PrivateKey privateKey, SecureRandom sr) throws InvalidKeyException {
            SignatureSpi signatureSpi = this.sigSpi;
            if (signatureSpi != null && (this.lock == null || privateKey == null)) {
                signatureSpi.engineInitSign(privateKey, sr);
            } else {
                chooseProvider(3, privateKey, sr);
            }
        }

        @Override // java.security.SignatureSpi
        protected void engineUpdate(byte b4) throws SignatureException {
            chooseFirstProvider();
            this.sigSpi.engineUpdate(b4);
        }

        @Override // java.security.SignatureSpi
        protected void engineUpdate(byte[] b4, int off, int len) throws SignatureException {
            chooseFirstProvider();
            this.sigSpi.engineUpdate(b4, off, len);
        }

        @Override // java.security.SignatureSpi
        protected void engineUpdate(ByteBuffer data) {
            chooseFirstProvider();
            this.sigSpi.engineUpdate(data);
        }

        @Override // java.security.SignatureSpi
        protected byte[] engineSign() throws SignatureException {
            chooseFirstProvider();
            return this.sigSpi.engineSign();
        }

        @Override // java.security.SignatureSpi
        protected int engineSign(byte[] outbuf, int offset, int len) throws SignatureException {
            chooseFirstProvider();
            return this.sigSpi.engineSign(outbuf, offset, len);
        }

        @Override // java.security.SignatureSpi
        protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
            chooseFirstProvider();
            return this.sigSpi.engineVerify(sigBytes);
        }

        @Override // java.security.SignatureSpi
        protected boolean engineVerify(byte[] sigBytes, int offset, int length) throws SignatureException {
            chooseFirstProvider();
            return this.sigSpi.engineVerify(sigBytes, offset, length);
        }

        @Override // java.security.SignatureSpi
        protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
            chooseFirstProvider();
            this.sigSpi.engineSetParameter(param, value);
        }

        @Override // java.security.SignatureSpi
        protected void engineSetParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
            chooseFirstProvider();
            this.sigSpi.engineSetParameter(params);
        }

        @Override // java.security.SignatureSpi
        protected Object engineGetParameter(String param) throws InvalidParameterException {
            chooseFirstProvider();
            return this.sigSpi.engineGetParameter(param);
        }

        @Override // java.security.SignatureSpi
        protected AlgorithmParameters engineGetParameters() {
            chooseFirstProvider();
            return this.sigSpi.engineGetParameters();
        }

        @Override // java.security.Signature
        public SignatureSpi getCurrentSpi() {
            SignatureSpi signatureSpi;
            Object obj = this.lock;
            if (obj == null) {
                return this.sigSpi;
            }
            synchronized (obj) {
                signatureSpi = this.sigSpi;
            }
            return signatureSpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CipherAdapter extends SignatureSpi {
        private final Cipher cipher;
        private ByteArrayOutputStream data;

        CipherAdapter(Cipher cipher) {
            this.cipher = cipher;
        }

        @Override // java.security.SignatureSpi
        protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
            this.cipher.init(2, publicKey);
            ByteArrayOutputStream byteArrayOutputStream = this.data;
            if (byteArrayOutputStream == null) {
                this.data = new ByteArrayOutputStream(128);
            } else {
                byteArrayOutputStream.reset();
            }
        }

        @Override // java.security.SignatureSpi
        protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            this.cipher.init(1, privateKey);
            this.data = null;
        }

        @Override // java.security.SignatureSpi
        protected void engineInitSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
            this.cipher.init(1, privateKey, random);
            this.data = null;
        }

        @Override // java.security.SignatureSpi
        protected void engineUpdate(byte b4) throws SignatureException {
            engineUpdate(new byte[]{b4}, 0, 1);
        }

        @Override // java.security.SignatureSpi
        protected void engineUpdate(byte[] b4, int off, int len) throws SignatureException {
            ByteArrayOutputStream byteArrayOutputStream = this.data;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.write(b4, off, len);
                return;
            }
            byte[] out = this.cipher.update(b4, off, len);
            if (out != null && out.length != 0) {
                throw new SignatureException("Cipher unexpectedly returned data");
            }
        }

        @Override // java.security.SignatureSpi
        protected byte[] engineSign() throws SignatureException {
            try {
                return this.cipher.doFinal();
            } catch (BadPaddingException e2) {
                throw new SignatureException("doFinal() failed", e2);
            } catch (IllegalBlockSizeException e10) {
                throw new SignatureException("doFinal() failed", e10);
            }
        }

        @Override // java.security.SignatureSpi
        protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
            try {
                byte[] out = this.cipher.doFinal(sigBytes);
                byte[] dataBytes = this.data.toByteArray();
                this.data.reset();
                return MessageDigest.isEqual(out, dataBytes);
            } catch (BadPaddingException e2) {
                return false;
            } catch (IllegalBlockSizeException e10) {
                throw new SignatureException("doFinal() failed", e10);
            }
        }

        @Override // java.security.SignatureSpi
        protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
            throw new InvalidParameterException("Parameters not supported");
        }

        @Override // java.security.SignatureSpi
        protected Object engineGetParameter(String param) throws InvalidParameterException {
            throw new InvalidParameterException("Parameters not supported");
        }
    }
}
