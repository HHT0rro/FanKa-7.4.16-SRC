package java.lang;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ClassNotFoundException extends ReflectiveOperationException {
    private static final long serialVersionUID = 9176873029745254542L;
    private Throwable ex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassNotFoundException() {
        super((Throwable) null);
    }

    public ClassNotFoundException(String s2) {
        super(s2, null);
    }

    public ClassNotFoundException(String s2, Throwable ex) {
        super(s2, null);
        this.ex = ex;
    }

    public Throwable getException() {
        return this.ex;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.ex;
    }
}
