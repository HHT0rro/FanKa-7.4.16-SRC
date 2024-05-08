package javax.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SealedObject implements Serializable {
    static final long serialVersionUID = 4482838265551344752L;
    protected byte[] encodedParams;
    private byte[] encryptedContent;
    private String paramsAlg;
    private String sealAlg;

    public SealedObject(Serializable object, Cipher c4) throws IOException, IllegalBlockSizeException {
        this.encryptedContent = null;
        this.sealAlg = null;
        this.paramsAlg = null;
        this.encodedParams = null;
        ByteArrayOutputStream b4 = new ByteArrayOutputStream();
        ObjectOutput a10 = new ObjectOutputStream(b4);
        try {
            a10.writeObject(object);
            a10.flush();
            byte[] content = b4.toByteArray();
            try {
                this.encryptedContent = c4.doFinal(content);
            } catch (BadPaddingException e2) {
            }
            if (c4.getParameters() != null) {
                this.encodedParams = c4.getParameters().getEncoded();
                this.paramsAlg = c4.getParameters().getAlgorithm();
            }
            this.sealAlg = c4.getAlgorithm();
        } finally {
            a10.close();
        }
    }

    protected SealedObject(SealedObject so) {
        this.encryptedContent = null;
        this.sealAlg = null;
        this.paramsAlg = null;
        this.encodedParams = null;
        this.encryptedContent = (byte[]) so.encryptedContent.clone();
        this.sealAlg = so.sealAlg;
        this.paramsAlg = so.paramsAlg;
        byte[] bArr = so.encodedParams;
        if (bArr != null) {
            this.encodedParams = (byte[]) bArr.clone();
        } else {
            this.encodedParams = null;
        }
    }

    public final String getAlgorithm() {
        return this.sealAlg;
    }

    public final Object getObject(Key key) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeyException {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        try {
            return unseal(key, null);
        } catch (NoSuchProviderException e2) {
            throw new NoSuchAlgorithmException("algorithm not found");
        } catch (BadPaddingException bpe) {
            throw new InvalidKeyException(bpe.getMessage());
        } catch (IllegalBlockSizeException ibse) {
            throw new InvalidKeyException(ibse.getMessage());
        }
    }

    public final Object getObject(Cipher c4) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException {
        byte[] content = c4.doFinal(this.encryptedContent);
        ByteArrayInputStream b4 = new ByteArrayInputStream(content);
        ObjectInput a10 = new extObjectInputStream(b4);
        try {
            Object obj = a10.readObject();
            return obj;
        } finally {
            a10.close();
        }
    }

    public final Object getObject(Key key, String provider) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        if (provider == null || provider.length() == 0) {
            throw new IllegalArgumentException("missing provider");
        }
        try {
            return unseal(key, provider);
        } catch (BadPaddingException | IllegalBlockSizeException ex) {
            throw new InvalidKeyException(ex.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    private Object unseal(Key key, String provider) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher c4;
        AlgorithmParameters params = null;
        String str = " not found";
        if (this.encodedParams != null) {
            try {
                if (provider != null) {
                    params = AlgorithmParameters.getInstance(this.paramsAlg, provider);
                } else {
                    params = AlgorithmParameters.getInstance(this.paramsAlg);
                }
                params.init(this.encodedParams);
            } catch (NoSuchProviderException nspe) {
                if (provider == null) {
                    throw new NoSuchAlgorithmException(this.paramsAlg + " not found");
                }
                throw new NoSuchProviderException(nspe.getMessage());
            }
        }
        try {
            if (provider != null) {
                c4 = Cipher.getInstance(this.sealAlg, provider);
            } else {
                c4 = Cipher.getInstance(this.sealAlg);
            }
            str = 2;
            try {
                if (params != null) {
                    c4.init(2, key, params);
                } else {
                    c4.init(2, key);
                }
                byte[] content = c4.doFinal(this.encryptedContent);
                ByteArrayInputStream b4 = new ByteArrayInputStream(content);
                ObjectInput a10 = new extObjectInputStream(b4);
                try {
                    Object obj = a10.readObject();
                    return obj;
                } finally {
                    a10.close();
                }
            } catch (InvalidAlgorithmParameterException iape) {
                throw new RuntimeException(iape.getMessage());
            }
        } catch (NoSuchProviderException nspe2) {
            if (provider == null) {
                throw new NoSuchAlgorithmException(this.sealAlg + str);
            }
            throw new NoSuchProviderException(nspe2.getMessage());
        } catch (NoSuchPaddingException e2) {
            throw new NoSuchAlgorithmException("Padding that was used in sealing operation not available");
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        byte[] bArr = this.encryptedContent;
        if (bArr != null) {
            this.encryptedContent = (byte[]) bArr.clone();
        }
        byte[] bArr2 = this.encodedParams;
        if (bArr2 != null) {
            this.encodedParams = (byte[]) bArr2.clone();
        }
    }
}
