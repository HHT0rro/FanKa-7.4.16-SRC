package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Externalizable extends Serializable {
    void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException;

    void writeExternal(ObjectOutput objectOutput) throws IOException;
}
