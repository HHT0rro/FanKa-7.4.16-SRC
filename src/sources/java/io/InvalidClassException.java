package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InvalidClassException extends ObjectStreamException {
    private static final long serialVersionUID = -4333316296251054416L;
    public String classname;

    public InvalidClassException(String reason) {
        super(reason);
    }

    public InvalidClassException(String cname, String reason) {
        super(reason);
        this.classname = cname;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.classname == null) {
            return super.getMessage();
        }
        return this.classname + "; " + super.getMessage();
    }
}
