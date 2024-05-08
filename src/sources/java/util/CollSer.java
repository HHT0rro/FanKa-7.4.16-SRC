package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ImmutableCollections;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: ImmutableCollections.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class CollSer implements Serializable {
    static final int IMM_LIST = 1;
    static final int IMM_LIST_NULLS = 4;
    static final int IMM_MAP = 3;
    static final int IMM_SET = 2;
    private static final long serialVersionUID = 6309168927139932177L;
    private transient Object[] array;
    private final int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CollSer(int t2, Object... a10) {
        this.tag = t2;
        this.array = a10;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        int len = ois.readInt();
        if (len < 0) {
            throw new InvalidObjectException("negative length " + len);
        }
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(ois, Object[].class, len);
        Object[] a10 = new Object[len];
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = ois.readObject();
        }
        this.array = a10;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(this.array.length);
        int i10 = 0;
        while (true) {
            Object[] objArr = this.array;
            if (i10 < objArr.length) {
                oos.writeObject(objArr[i10]);
                i10++;
            } else {
                return;
            }
        }
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            Object[] objArr = this.array;
            if (objArr == null) {
                throw new InvalidObjectException("null array");
            }
            int i10 = this.tag;
            switch (i10 & 255) {
                case 1:
                    return List.of(objArr);
                case 2:
                    return Set.of(objArr);
                case 3:
                    if (objArr.length == 0) {
                        return ImmutableCollections.EMPTY_MAP;
                    }
                    if (objArr.length == 2) {
                        return new ImmutableCollections.Map1(objArr[0], objArr[1]);
                    }
                    return new ImmutableCollections.MapN(objArr);
                case 4:
                    return ImmutableCollections.listFromTrustedArrayNullsAllowed(Arrays.copyOf(objArr, objArr.length, Object[].class));
                default:
                    throw new InvalidObjectException(String.format("invalid flags 0x%x", Integer.valueOf(i10)));
            }
        } catch (IllegalArgumentException | NullPointerException ex) {
            InvalidObjectException ioe = new InvalidObjectException("invalid object");
            ioe.initCause(ex);
            throw ioe;
        }
    }
}
