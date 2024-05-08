package java.security;

import java.nio.ByteBuffer;
import java.util.Objects;
import sun.security.jca.Providers;
import sun.security.pkcs.PKCS9Attribute;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class MessageDigest extends MessageDigestSpi {
    private static final int INITIAL = 0;
    private static final int IN_PROGRESS = 1;
    private String algorithm;
    private Provider provider;
    private int state = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageDigest(String algorithm) {
        this.algorithm = algorithm;
    }

    public static MessageDigest getInstance(String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md2;
        Objects.requireNonNull(algorithm, "null algorithm name");
        try {
            Object[] objs = Security.getImpl(algorithm, PKCS9Attribute.MESSAGE_DIGEST_STR, (String) null);
            if (objs[0] instanceof MessageDigest) {
                md2 = (MessageDigest) objs[0];
            } else {
                md2 = new Delegate((MessageDigestSpi) objs[0], algorithm);
            }
            md2.provider = (Provider) objs[1];
            return md2;
        } catch (NoSuchProviderException e2) {
            throw new NoSuchAlgorithmException(algorithm + " not found");
        }
    }

    public static MessageDigest getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        Objects.requireNonNull(algorithm, "null algorithm name");
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException("missing provider");
        }
        Providers.checkBouncyCastleDeprecation(provider, PKCS9Attribute.MESSAGE_DIGEST_STR, algorithm);
        Object[] objs = Security.getImpl(algorithm, PKCS9Attribute.MESSAGE_DIGEST_STR, provider);
        if (objs[0] instanceof MessageDigest) {
            MessageDigest md2 = (MessageDigest) objs[0];
            md2.provider = (Provider) objs[1];
            return md2;
        }
        MessageDigest delegate = new Delegate((MessageDigestSpi) objs[0], algorithm);
        delegate.provider = (Provider) objs[1];
        return delegate;
    }

    public static MessageDigest getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        Objects.requireNonNull(algorithm, "null algorithm name");
        if (provider == null) {
            throw new IllegalArgumentException("missing provider");
        }
        Providers.checkBouncyCastleDeprecation(provider, PKCS9Attribute.MESSAGE_DIGEST_STR, algorithm);
        Object[] objs = Security.getImpl(algorithm, PKCS9Attribute.MESSAGE_DIGEST_STR, provider);
        if (objs[0] instanceof MessageDigest) {
            MessageDigest md2 = (MessageDigest) objs[0];
            md2.provider = (Provider) objs[1];
            return md2;
        }
        MessageDigest delegate = new Delegate((MessageDigestSpi) objs[0], algorithm);
        delegate.provider = (Provider) objs[1];
        return delegate;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public void update(byte input) {
        engineUpdate(input);
        this.state = 1;
    }

    public void update(byte[] input, int offset, int len) {
        if (input == null) {
            throw new IllegalArgumentException("No input buffer given");
        }
        if (input.length - offset < len) {
            throw new IllegalArgumentException("Input buffer too short");
        }
        engineUpdate(input, offset, len);
        this.state = 1;
    }

    public void update(byte[] input) {
        engineUpdate(input, 0, input.length);
        this.state = 1;
    }

    public final void update(ByteBuffer input) {
        if (input == null) {
            throw new NullPointerException();
        }
        engineUpdate(input);
        this.state = 1;
    }

    public byte[] digest() {
        byte[] result = engineDigest();
        this.state = 0;
        return result;
    }

    public int digest(byte[] buf, int offset, int len) throws DigestException {
        if (buf == null) {
            throw new IllegalArgumentException("No output buffer given");
        }
        if (buf.length - offset < len) {
            throw new IllegalArgumentException("Output buffer too small for specified offset and length");
        }
        int numBytes = engineDigest(buf, offset, len);
        this.state = 0;
        return numBytes;
    }

    public byte[] digest(byte[] input) {
        update(input);
        return digest();
    }

    private String getProviderName() {
        Provider provider = this.provider;
        return provider == null ? "(no provider)" : provider.getName();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.algorithm);
        builder.append(" Message Digest from ");
        builder.append(getProviderName());
        builder.append(", ");
        switch (this.state) {
            case 0:
                builder.append("<initialized>");
                break;
            case 1:
                builder.append("<in progress>");
                break;
        }
        return builder.toString();
    }

    public static boolean isEqual(byte[] digesta, byte[] digestb) {
        if (digesta == digestb) {
            return true;
        }
        if (digesta == null || digestb == null) {
            return false;
        }
        int lenA = digesta.length;
        int lenB = digestb.length;
        if (lenB == 0) {
            if (lenA == 0) {
                return true;
            }
            return false;
        }
        int result = 0 | (lenA - lenB);
        for (int i10 = 0; i10 < lenA; i10++) {
            int indexB = ((i10 - lenB) >>> 31) * i10;
            result |= digesta[i10] ^ digestb[indexB];
        }
        if (result == 0) {
            return true;
        }
        return false;
    }

    public void reset() {
        engineReset();
        this.state = 0;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final int getDigestLength() {
        int digestLen = engineGetDigestLength();
        if (digestLen == 0) {
            try {
                MessageDigest md2 = (MessageDigest) clone();
                byte[] digest = md2.digest();
                return digest.length;
            } catch (CloneNotSupportedException e2) {
                return digestLen;
            }
        }
        return digestLen;
    }

    @Override // java.security.MessageDigestSpi
    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class Delegate extends MessageDigest {
        private MessageDigestSpi digestSpi;

        public Delegate(MessageDigestSpi digestSpi, String algorithm) {
            super(algorithm);
            this.digestSpi = digestSpi;
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            MessageDigestSpi messageDigestSpi = this.digestSpi;
            if (messageDigestSpi instanceof Cloneable) {
                MessageDigestSpi digestSpiClone = (MessageDigestSpi) messageDigestSpi.clone();
                MessageDigest that = new Delegate(digestSpiClone, ((MessageDigest) this).algorithm);
                that.provider = ((MessageDigest) this).provider;
                that.state = ((MessageDigest) this).state;
                return that;
            }
            throw new CloneNotSupportedException();
        }

        @Override // java.security.MessageDigestSpi
        protected int engineGetDigestLength() {
            return this.digestSpi.engineGetDigestLength();
        }

        @Override // java.security.MessageDigestSpi
        protected void engineUpdate(byte input) {
            this.digestSpi.engineUpdate(input);
        }

        @Override // java.security.MessageDigestSpi
        protected void engineUpdate(byte[] input, int offset, int len) {
            this.digestSpi.engineUpdate(input, offset, len);
        }

        @Override // java.security.MessageDigestSpi
        protected void engineUpdate(ByteBuffer input) {
            this.digestSpi.engineUpdate(input);
        }

        @Override // java.security.MessageDigestSpi
        protected byte[] engineDigest() {
            return this.digestSpi.engineDigest();
        }

        @Override // java.security.MessageDigestSpi
        protected int engineDigest(byte[] buf, int offset, int len) throws DigestException {
            return this.digestSpi.engineDigest(buf, offset, len);
        }

        @Override // java.security.MessageDigestSpi
        protected void engineReset() {
            this.digestSpi.engineReset();
        }
    }
}
