package java.lang.reflect;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InvocationTargetException extends ReflectiveOperationException {
    private static final long serialVersionUID = 4085088731926701167L;
    private Throwable target;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected InvocationTargetException() {
        super((Throwable) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvocationTargetException(Throwable target) {
        super((Throwable) null);
        this.target = target;
    }

    public InvocationTargetException(Throwable target, String s2) {
        super(s2, null);
        this.target = target;
    }

    public Throwable getTargetException() {
        return this.target;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.target;
    }
}
