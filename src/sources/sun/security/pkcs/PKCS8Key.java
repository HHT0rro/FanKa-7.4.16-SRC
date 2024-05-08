package sun.security.pkcs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyRep;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import sun.security.util.Debug;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.x509.AlgorithmId;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKCS8Key implements PrivateKey {
    private static final long serialVersionUID = -3836890099307167124L;
    public static final BigInteger version = BigInteger.ZERO;
    protected AlgorithmId algid;
    protected byte[] encodedKey;
    protected byte[] key;

    public PKCS8Key() {
    }

    private PKCS8Key(AlgorithmId algid, byte[] key) throws InvalidKeyException {
        this.algid = algid;
        this.key = key;
        encode();
    }

    public static PKCS8Key parse(DerValue in) throws IOException {
        PrivateKey key = parseKey(in);
        if (key instanceof PKCS8Key) {
            return (PKCS8Key) key;
        }
        throw new IOException("Provider did not return PKCS8Key");
    }

    public static PrivateKey parseKey(DerValue in) throws IOException {
        if (in.tag != 48) {
            throw new IOException("corrupt private key");
        }
        BigInteger parsedVersion = in.data.getBigInteger();
        BigInteger bigInteger = version;
        if (!bigInteger.equals(parsedVersion)) {
            throw new IOException("version mismatch: (supported: " + Debug.toHexString(bigInteger) + ", parsed: " + Debug.toHexString(parsedVersion));
        }
        AlgorithmId algorithm = AlgorithmId.parse(in.data.getDerValue());
        try {
            PrivateKey privKey = buildPKCS8Key(algorithm, in.data.getOctetString());
            if (in.data.available() != 0) {
                throw new IOException("excess private key");
            }
            return privKey;
        } catch (InvalidKeyException e2) {
            throw new IOException("corrupt private key");
        }
    }

    protected void parseKeyBits() throws IOException, InvalidKeyException {
        encode();
    }

    static PrivateKey buildPKCS8Key(AlgorithmId algid, byte[] key) throws IOException, InvalidKeyException {
        Provider sunProvider;
        DerOutputStream pkcs8EncodedKeyStream = new DerOutputStream();
        encode(pkcs8EncodedKeyStream, algid, key);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pkcs8EncodedKeyStream.toByteArray());
        try {
            KeyFactory keyFac = KeyFactory.getInstance(algid.getName());
            return keyFac.generatePrivate(pkcs8KeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            try {
                try {
                    sunProvider = Security.getProvider("SUN");
                } catch (IllegalAccessException e10) {
                    throw new IOException(" [internal error]");
                } catch (InstantiationException e11) {
                }
            } catch (ClassNotFoundException e12) {
            }
            if (sunProvider == null) {
                throw new InstantiationException();
            }
            String classname = sunProvider.getProperty("PrivateKey.PKCS#8." + algid.getName());
            if (classname == null) {
                throw new InstantiationException();
            }
            Class<?> keyClass = null;
            try {
                keyClass = Class.forName(classname);
            } catch (ClassNotFoundException e13) {
                ClassLoader cl = ClassLoader.getSystemClassLoader();
                if (cl != null) {
                    keyClass = cl.loadClass(classname);
                }
            }
            Object inst = null;
            if (keyClass != null) {
                inst = keyClass.newInstance();
            }
            if (inst instanceof PKCS8Key) {
                PKCS8Key result = (PKCS8Key) inst;
                result.algid = algid;
                result.key = key;
                result.parseKeyBits();
                return result;
            }
            PKCS8Key result2 = new PKCS8Key();
            result2.algid = algid;
            result2.key = key;
            return result2;
        }
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algid.getName();
    }

    public AlgorithmId getAlgorithmId() {
        return this.algid;
    }

    public final void encode(DerOutputStream out) throws IOException {
        encode(out, this.algid, this.key);
    }

    @Override // java.security.Key
    public synchronized byte[] getEncoded() {
        byte[] result;
        result = null;
        try {
            result = encode();
        } catch (InvalidKeyException e2) {
        }
        return result;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public byte[] encode() throws InvalidKeyException {
        if (this.encodedKey == null) {
            try {
                DerOutputStream out = new DerOutputStream();
                encode(out);
                this.encodedKey = out.toByteArray();
            } catch (IOException e2) {
                throw new InvalidKeyException("IOException : " + e2.getMessage());
            }
        }
        return (byte[]) this.encodedKey.clone();
    }

    public void decode(InputStream in) throws InvalidKeyException {
        try {
            DerValue val = new DerValue(in);
            if (val.tag != 48) {
                throw new InvalidKeyException("invalid key format");
            }
            BigInteger version2 = val.data.getBigInteger();
            BigInteger bigInteger = version;
            if (!version2.equals(bigInteger)) {
                throw new IOException("version mismatch: (supported: " + Debug.toHexString(bigInteger) + ", parsed: " + Debug.toHexString(version2));
            }
            this.algid = AlgorithmId.parse(val.data.getDerValue());
            this.key = val.data.getOctetString();
            parseKeyBits();
            val.data.available();
        } catch (IOException e2) {
            throw new InvalidKeyException("IOException : " + e2.getMessage());
        }
    }

    public void decode(byte[] encodedKey) throws InvalidKeyException {
        decode(new ByteArrayInputStream(encodedKey));
    }

    protected Object writeReplace() throws ObjectStreamException {
        return new KeyRep(KeyRep.Type.PRIVATE, getAlgorithm(), getFormat(), getEncoded());
    }

    private void readObject(ObjectInputStream stream) throws IOException {
        try {
            decode(stream);
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            throw new IOException("deserialized key is invalid: " + e2.getMessage());
        }
    }

    static void encode(DerOutputStream out, AlgorithmId algid, byte[] key) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        tmp.putInteger(version);
        algid.encode(tmp);
        tmp.putOctetString(key);
        out.write((byte) 48, tmp);
    }

    public boolean equals(Object object) {
        byte[] b12;
        if (this == object) {
            return true;
        }
        if (!(object instanceof Key)) {
            return false;
        }
        if (this.encodedKey != null) {
            b12 = this.encodedKey;
        } else {
            b12 = getEncoded();
        }
        byte[] b22 = ((Key) object).getEncoded();
        if (b12.length != b22.length) {
            return false;
        }
        for (int i10 = 0; i10 < b12.length; i10++) {
            if (b12[i10] != b22[i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int retval = 0;
        byte[] b12 = getEncoded();
        for (int i10 = 1; i10 < b12.length; i10++) {
            retval += b12[i10] * i10;
        }
        return retval;
    }
}
