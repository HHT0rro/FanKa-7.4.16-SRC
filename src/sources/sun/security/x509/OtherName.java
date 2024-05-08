package sun.security.x509;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class OtherName implements GeneralNameInterface {
    private static final byte TAG_VALUE = 0;
    private GeneralNameInterface gni;
    private int myhash = -1;
    private String name;
    private byte[] nameValue;
    private ObjectIdentifier oid;

    public OtherName(ObjectIdentifier oid, byte[] value) throws IOException {
        this.nameValue = null;
        this.gni = null;
        if (oid == null || value == null) {
            throw new NullPointerException("parameters may not be null");
        }
        this.oid = oid;
        this.nameValue = value;
        GeneralNameInterface gni = getGNI(oid, value);
        this.gni = gni;
        if (gni != null) {
            this.name = gni.toString();
        } else {
            this.name = "Unrecognized ObjectIdentifier: " + oid.toString();
        }
    }

    public OtherName(DerValue derValue) throws IOException {
        this.nameValue = null;
        this.gni = null;
        DerInputStream in = derValue.toDerInputStream();
        this.oid = in.getOID();
        DerValue val = in.getDerValue();
        byte[] byteArray = val.toByteArray();
        this.nameValue = byteArray;
        GeneralNameInterface gni = getGNI(this.oid, byteArray);
        this.gni = gni;
        if (gni != null) {
            this.name = gni.toString();
        } else {
            this.name = "Unrecognized ObjectIdentifier: " + this.oid.toString();
        }
    }

    public ObjectIdentifier getOID() {
        return this.oid;
    }

    public byte[] getNameValue() {
        return (byte[]) this.nameValue.clone();
    }

    private GeneralNameInterface getGNI(ObjectIdentifier oid, byte[] nameValue) throws IOException {
        try {
            Class<?> extClass = OIDMap.getClass(oid);
            if (extClass == null) {
                return null;
            }
            Class<?>[] params = {Object.class};
            Constructor<?> cons = extClass.getConstructor(params);
            Object[] passed = {nameValue};
            GeneralNameInterface gni = (GeneralNameInterface) cons.newInstance(passed);
            return gni;
        } catch (Exception e2) {
            throw new IOException("Instantiation error: " + ((Object) e2), e2);
        }
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int getType() {
        return 0;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public void encode(DerOutputStream out) throws IOException {
        GeneralNameInterface generalNameInterface = this.gni;
        if (generalNameInterface != null) {
            generalNameInterface.encode(out);
            return;
        }
        DerOutputStream tmp = new DerOutputStream();
        tmp.putOID(this.oid);
        tmp.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), this.nameValue);
        out.write((byte) 48, tmp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OtherName)) {
            return false;
        }
        OtherName otherOther = (OtherName) other;
        if (!otherOther.oid.equals((Object) this.oid)) {
            return false;
        }
        try {
            GeneralNameInterface otherGNI = getGNI(otherOther.oid, otherOther.nameValue);
            if (otherGNI != null) {
                try {
                    return otherGNI.constrains(this) == 0;
                } catch (UnsupportedOperationException e2) {
                    return false;
                }
            }
            boolean result = Arrays.equals(this.nameValue, otherOther.nameValue);
            return result;
        } catch (IOException e10) {
            return false;
        }
    }

    public int hashCode() {
        if (this.myhash == -1) {
            this.myhash = this.oid.hashCode() + 37;
            int i10 = 0;
            while (true) {
                byte[] bArr = this.nameValue;
                if (i10 >= bArr.length) {
                    break;
                }
                this.myhash = (this.myhash * 37) + bArr[i10];
                i10++;
            }
        }
        int i11 = this.myhash;
        return i11;
    }

    public String toString() {
        return "Other-Name: " + this.name;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int constrains(GeneralNameInterface inputName) {
        if (inputName == null) {
            return -1;
        }
        int constraintType = inputName.getType();
        if (constraintType != 0) {
            return -1;
        }
        throw new UnsupportedOperationException("Narrowing, widening, and matching are not supported for OtherName.");
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int subtreeDepth() {
        throw new UnsupportedOperationException("subtreeDepth() not supported for generic OtherName");
    }
}
