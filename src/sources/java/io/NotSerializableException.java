package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NotSerializableException extends ObjectStreamException {
    private static final long serialVersionUID = 2906642554793891381L;

    public NotSerializableException(String classname) {
        super(classname);
    }

    public NotSerializableException() {
    }
}
