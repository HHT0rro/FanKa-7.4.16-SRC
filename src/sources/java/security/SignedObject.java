package java.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class SignedObject implements Serializable {
    private static final long serialVersionUID = 720502720485447167L;
    private byte[] content;
    private byte[] signature;
    private String thealgorithm;

    public SignedObject(Serializable object, PrivateKey signingKey, Signature signingEngine) throws IOException, InvalidKeyException, SignatureException {
        ByteArrayOutputStream b4 = new ByteArrayOutputStream();
        ObjectOutput a10 = new ObjectOutputStream(b4);
        a10.writeObject(object);
        a10.flush();
        a10.close();
        this.content = b4.toByteArray();
        b4.close();
        sign(signingKey, signingEngine);
    }

    public Object getObject() throws IOException, ClassNotFoundException {
        ByteArrayInputStream b4 = new ByteArrayInputStream(this.content);
        ObjectInput a10 = new ObjectInputStream(b4);
        Object obj = a10.readObject();
        b4.close();
        a10.close();
        return obj;
    }

    public byte[] getSignature() {
        return (byte[]) this.signature.clone();
    }

    public String getAlgorithm() {
        return this.thealgorithm;
    }

    public boolean verify(PublicKey verificationKey, Signature verificationEngine) throws InvalidKeyException, SignatureException {
        verificationEngine.initVerify(verificationKey);
        verificationEngine.update((byte[]) this.content.clone());
        return verificationEngine.verify((byte[]) this.signature.clone());
    }

    private void sign(PrivateKey signingKey, Signature signingEngine) throws InvalidKeyException, SignatureException {
        signingEngine.initSign(signingKey);
        signingEngine.update((byte[]) this.content.clone());
        this.signature = (byte[]) signingEngine.sign().clone();
        this.thealgorithm = signingEngine.getAlgorithm();
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s2.readFields();
        this.content = (byte[]) ((byte[]) fields.get("content", (Object) null)).clone();
        this.signature = (byte[]) ((byte[]) fields.get("signature", (Object) null)).clone();
        this.thealgorithm = (String) fields.get("thealgorithm", (Object) null);
    }
}
