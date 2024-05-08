package sun.security.x509;

import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import sun.misc.HexDumpEncoder;
import sun.security.util.BitArray;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509Key implements PublicKey {
    private static final long serialVersionUID = -5359250853002055002L;
    protected AlgorithmId algid;
    protected byte[] encodedKey;

    @Deprecated
    protected byte[] key = null;

    @Deprecated
    private int unusedBits = 0;
    private BitArray bitStringKey = null;

    public X509Key() {
    }

    private X509Key(AlgorithmId algid, BitArray key) throws InvalidKeyException {
        this.algid = algid;
        setKey(key);
        encode();
    }

    protected void setKey(BitArray key) {
        this.bitStringKey = (BitArray) key.clone();
        this.key = key.toByteArray();
        int remaining = key.length() % 8;
        this.unusedBits = remaining == 0 ? 0 : 8 - remaining;
    }

    protected BitArray getKey() {
        byte[] bArr = this.key;
        BitArray bitArray = new BitArray((bArr.length * 8) - this.unusedBits, bArr);
        this.bitStringKey = bitArray;
        return (BitArray) bitArray.clone();
    }

    public static PublicKey parse(DerValue in) throws IOException {
        if (in.tag != 48) {
            throw new IOException("corrupt subject key");
        }
        AlgorithmId algorithm = AlgorithmId.parse(in.data.getDerValue());
        try {
            PublicKey subjectKey = buildX509Key(algorithm, in.data.getUnalignedBitString());
            if (in.data.available() != 0) {
                throw new IOException("excess subject key");
            }
            return subjectKey;
        } catch (InvalidKeyException e2) {
            throw new IOException("subject key, " + e2.getMessage(), e2);
        }
    }

    protected void parseKeyBits() throws IOException, InvalidKeyException {
        encode();
    }

    static PublicKey buildX509Key(AlgorithmId algid, BitArray key) throws IOException, InvalidKeyException {
        Provider sunProvider;
        DerOutputStream x509EncodedKeyStream = new DerOutputStream();
        encode(x509EncodedKeyStream, algid, key);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(x509EncodedKeyStream.toByteArray());
        try {
            KeyFactory keyFac = KeyFactory.getInstance(algid.getName());
            return keyFac.generatePublic(x509KeySpec);
        } catch (NoSuchAlgorithmException e2) {
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
            String classname = sunProvider.getProperty("PublicKey.X.509." + algid.getName());
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
            if (inst instanceof X509Key) {
                X509Key result = (X509Key) inst;
                result.algid = algid;
                result.setKey(key);
                result.parseKeyBits();
                return result;
            }
            return new X509Key(algid, key);
        } catch (InvalidKeySpecException e14) {
            throw new InvalidKeyException(e14.getMessage(), e14);
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
        encode(out, this.algid, getKey());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (byte[]) getEncodedInternal().clone();
        } catch (InvalidKeyException e2) {
            return null;
        }
    }

    public byte[] getEncodedInternal() throws InvalidKeyException {
        byte[] encoded = this.encodedKey;
        if (encoded == null) {
            try {
                DerOutputStream out = new DerOutputStream();
                encode(out);
                byte[] encoded2 = out.toByteArray();
                this.encodedKey = encoded2;
                return encoded2;
            } catch (IOException e2) {
                throw new InvalidKeyException("IOException : " + e2.getMessage());
            }
        }
        return encoded;
    }

    @Override // java.security.Key
    public String getFormat() {
        return e.f29912b;
    }

    public byte[] encode() throws InvalidKeyException {
        return (byte[]) getEncodedInternal().clone();
    }

    public String toString() {
        HexDumpEncoder encoder = new HexDumpEncoder();
        return "algorithm = " + this.algid.toString() + ", unparsed keybits = \n" + encoder.encodeBuffer(this.key);
    }

    public void decode(InputStream in) throws InvalidKeyException {
        try {
            DerValue val = new DerValue(in);
            if (val.tag != 48) {
                throw new InvalidKeyException("invalid key format");
            }
            this.algid = AlgorithmId.parse(val.data.getDerValue());
            setKey(val.data.getUnalignedBitString());
            parseKeyBits();
            if (val.data.available() != 0) {
                throw new InvalidKeyException("excess key data");
            }
        } catch (IOException e2) {
            throw new InvalidKeyException("IOException: " + e2.getMessage());
        }
    }

    public void decode(byte[] encodedKey) throws InvalidKeyException {
        decode(new ByteArrayInputStream(encodedKey));
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.write(getEncoded());
    }

    private void readObject(ObjectInputStream stream) throws IOException {
        try {
            decode(stream);
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            throw new IOException("deserialized key is invalid: " + e2.getMessage());
        }
    }

    public boolean equals(Object obj) {
        byte[] otherEncoded;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Key)) {
            return false;
        }
        try {
            byte[] thisEncoded = getEncodedInternal();
            if (obj instanceof X509Key) {
                otherEncoded = ((X509Key) obj).getEncodedInternal();
            } else {
                otherEncoded = ((Key) obj).getEncoded();
            }
            return Arrays.equals(thisEncoded, otherEncoded);
        } catch (InvalidKeyException e2) {
            return false;
        }
    }

    public int hashCode() {
        try {
            byte[] b12 = getEncodedInternal();
            int r10 = b12.length;
            for (byte b4 : b12) {
                r10 += (b4 & 255) * 37;
            }
            return r10;
        } catch (InvalidKeyException e2) {
            return 0;
        }
    }

    static void encode(DerOutputStream out, AlgorithmId algid, BitArray key) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        algid.encode(tmp);
        tmp.putUnalignedBitString(key);
        out.write((byte) 48, tmp);
    }
}
