package java.security;

import java.security.Provider;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.security.jca.GetInstance;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SecureRandom extends Random {
    private static volatile SecureRandom seedGenerator = null;
    static final long serialVersionUID = 4940670005562187L;
    private String algorithm;
    private long counter;
    private MessageDigest digest;
    private Provider provider;
    private byte[] randomBytes;
    private int randomBytesUsed;
    private SecureRandomSpi secureRandomSpi;
    private byte[] state;

    public SecureRandom() {
        super(0L);
        this.provider = null;
        this.secureRandomSpi = null;
        this.digest = null;
        getDefaultPRNG(false, null);
    }

    public SecureRandom(byte[] seed) {
        super(0L);
        this.provider = null;
        this.secureRandomSpi = null;
        this.digest = null;
        getDefaultPRNG(true, seed);
    }

    private void getDefaultPRNG(boolean setSeed, byte[] seed) {
        String prng = getPrngAlgorithm();
        if (prng == null) {
            throw new IllegalStateException("No SecureRandom implementation!");
        }
        try {
            SecureRandom random = getInstance(prng);
            this.secureRandomSpi = random.getSecureRandomSpi();
            this.provider = random.getProvider();
            if (setSeed) {
                this.secureRandomSpi.engineSetSeed(seed);
            }
            if (getClass() == SecureRandom.class) {
                this.algorithm = prng;
            }
        } catch (NoSuchAlgorithmException nsae) {
            throw new RuntimeException(nsae);
        }
    }

    protected SecureRandom(SecureRandomSpi secureRandomSpi, Provider provider) {
        this(secureRandomSpi, provider, null);
    }

    private SecureRandom(SecureRandomSpi secureRandomSpi, Provider provider, String algorithm) {
        super(0L);
        this.provider = null;
        this.secureRandomSpi = null;
        this.digest = null;
        this.secureRandomSpi = secureRandomSpi;
        this.provider = provider;
        this.algorithm = algorithm;
    }

    public static SecureRandom getInstance(String algorithm) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("SecureRandom", (Class<?>) SecureRandomSpi.class, algorithm);
        return new SecureRandom((SecureRandomSpi) instance.impl, instance.provider, algorithm);
    }

    public static SecureRandom getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        GetInstance.Instance instance = GetInstance.getInstance("SecureRandom", (Class<?>) SecureRandomSpi.class, algorithm, provider);
        return new SecureRandom((SecureRandomSpi) instance.impl, instance.provider, algorithm);
    }

    public static SecureRandom getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        GetInstance.Instance instance = GetInstance.getInstance("SecureRandom", (Class<?>) SecureRandomSpi.class, algorithm, provider);
        return new SecureRandom((SecureRandomSpi) instance.impl, instance.provider, algorithm);
    }

    SecureRandomSpi getSecureRandomSpi() {
        return this.secureRandomSpi;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public String getAlgorithm() {
        String str = this.algorithm;
        return str != null ? str : "unknown";
    }

    public synchronized void setSeed(byte[] seed) {
        this.secureRandomSpi.engineSetSeed(seed);
    }

    @Override // java.util.Random
    public void setSeed(long seed) {
        if (seed != 0) {
            this.secureRandomSpi.engineSetSeed(longToByteArray(seed));
        }
    }

    @Override // java.util.Random
    public synchronized void nextBytes(byte[] bytes) {
        this.secureRandomSpi.engineNextBytes(bytes);
    }

    @Override // java.util.Random
    protected final int next(int numBits) {
        int numBytes = (numBits + 7) / 8;
        byte[] b4 = new byte[numBytes];
        int next = 0;
        nextBytes(b4);
        for (int i10 = 0; i10 < numBytes; i10++) {
            next = (next << 8) + (b4[i10] & 255);
        }
        int i11 = numBytes * 8;
        return next >>> (i11 - numBits);
    }

    public static byte[] getSeed(int numBytes) {
        if (seedGenerator == null) {
            seedGenerator = new SecureRandom();
        }
        return seedGenerator.generateSeed(numBytes);
    }

    public byte[] generateSeed(int numBytes) {
        return this.secureRandomSpi.engineGenerateSeed(numBytes);
    }

    private static byte[] longToByteArray(long l10) {
        byte[] retVal = new byte[8];
        for (int i10 = 0; i10 < 8; i10++) {
            retVal[i10] = (byte) l10;
            l10 >>= 8;
        }
        return retVal;
    }

    private static String getPrngAlgorithm() {
        for (Provider p10 : Providers.getProviderList().providers()) {
            for (Provider.Service s2 : p10.getServices()) {
                if (s2.getType().equals("SecureRandom")) {
                    return s2.getAlgorithm();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class StrongPatternHolder {
        private static Pattern pattern = Pattern.compile("\\s*([\\S&&[^:,]]*)(\\:([\\S&&[^,]]*))?\\s*(\\,(.*))?");

        private StrongPatternHolder() {
        }
    }

    public static SecureRandom getInstanceStrong() throws NoSuchAlgorithmException {
        String property = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: java.security.SecureRandom.1
            @Override // java.security.PrivilegedAction
            public String run() {
                return Security.getProperty("securerandom.strongAlgorithms");
            }
        });
        if (property == null || property.length() == 0) {
            throw new NoSuchAlgorithmException("Null/empty securerandom.strongAlgorithms Security Property");
        }
        String remainder = property;
        while (remainder != null) {
            Matcher m10 = StrongPatternHolder.pattern.matcher(remainder);
            if (m10.matches()) {
                String alg = m10.group(1);
                String prov = m10.group(3);
                try {
                    if (prov == null) {
                        return getInstance(alg);
                    }
                    return getInstance(alg, prov);
                } catch (NoSuchAlgorithmException | NoSuchProviderException e2) {
                    remainder = m10.group(5);
                }
            } else {
                remainder = null;
            }
        }
        throw new NoSuchAlgorithmException("No strong SecureRandom impls available: " + property);
    }
}
