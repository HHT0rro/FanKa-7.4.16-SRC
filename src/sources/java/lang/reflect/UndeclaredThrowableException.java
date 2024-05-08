package java.lang.reflect;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UndeclaredThrowableException extends RuntimeException {
    static final long serialVersionUID = 330127114055056639L;
    private Throwable undeclaredThrowable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UndeclaredThrowableException(Throwable undeclaredThrowable) {
        super((Throwable) null);
        this.undeclaredThrowable = undeclaredThrowable;
    }

    public UndeclaredThrowableException(Throwable undeclaredThrowable, String s2) {
        super(s2, null);
        this.undeclaredThrowable = undeclaredThrowable;
    }

    public Throwable getUndeclaredThrowable() {
        return this.undeclaredThrowable;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.undeclaredThrowable;
    }
}
