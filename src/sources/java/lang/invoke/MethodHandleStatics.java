package java.lang.invoke;

import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MethodHandleStatics {
    static final Unsafe UNSAFE = Unsafe.getUnsafe();

    private MethodHandleStatics() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InternalError newInternalError(String message) {
        return new InternalError(message);
    }

    static InternalError newInternalError(String message, Throwable cause) {
        return new InternalError(message, cause);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InternalError newInternalError(Throwable cause) {
        return new InternalError(cause);
    }

    static RuntimeException newIllegalStateException(String message) {
        return new IllegalStateException(message);
    }

    static RuntimeException newIllegalStateException(String message, Object obj) {
        return new IllegalStateException(message(message, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException newIllegalArgumentException(String message) {
        return new IllegalArgumentException(message);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException newIllegalArgumentException(String message, Object obj) {
        return new IllegalArgumentException(message(message, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException newIllegalArgumentException(String message, Object obj, Object obj2) {
        return new IllegalArgumentException(message(message, obj, obj2));
    }

    static Error uncaughtException(Throwable ex) {
        if (ex instanceof Error) {
            throw ((Error) ex);
        }
        if (ex instanceof RuntimeException) {
            throw ((RuntimeException) ex);
        }
        throw newInternalError("uncaught exception", ex);
    }

    static Error NYI() {
        throw new AssertionError((Object) "NYI");
    }

    private static String message(String message, Object obj) {
        return obj != null ? message + ": " + obj : message;
    }

    private static String message(String message, Object obj, Object obj2) {
        return (obj == null && obj2 == null) ? message : message + ": " + obj + ", " + obj2;
    }
}
