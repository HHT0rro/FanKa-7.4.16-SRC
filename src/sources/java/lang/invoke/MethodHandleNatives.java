package java.lang.invoke;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MethodHandleNatives {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    MethodHandleNatives() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class Constants {
        static final byte REF_LIMIT = 10;
        static final byte REF_NONE = 0;
        static final byte REF_getField = 1;
        static final byte REF_getStatic = 2;
        static final byte REF_invokeInterface = 9;
        static final byte REF_invokeSpecial = 7;
        static final byte REF_invokeStatic = 6;
        static final byte REF_invokeVirtual = 5;
        static final byte REF_newInvokeSpecial = 8;
        static final byte REF_putField = 3;
        static final byte REF_putStatic = 4;

        Constants() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean refKindIsValid(int refKind) {
        return refKind > 0 && refKind < 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean refKindIsField(byte refKind) {
        return refKind <= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String refKindName(byte refKind) {
        switch (refKind) {
            case 1:
                return "getField";
            case 2:
                return "getStatic";
            case 3:
                return "putField";
            case 4:
                return "putStatic";
            case 5:
                return "invokeVirtual";
            case 6:
                return "invokeStatic";
            case 7:
                return "invokeSpecial";
            case 8:
                return "newInvokeSpecial";
            case 9:
                return "invokeInterface";
            default:
                return "REF_???";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LinkageError mapLookupExceptionToError(ReflectiveOperationException ex) {
        LinkageError err;
        if (ex instanceof IllegalAccessException) {
            Throwable cause = ex.getCause();
            if (cause instanceof AbstractMethodError) {
                return (AbstractMethodError) cause;
            }
            err = new IllegalAccessError(ex.getMessage());
        } else if (ex instanceof NoSuchMethodException) {
            err = new NoSuchMethodError(ex.getMessage());
        } else if (ex instanceof NoSuchFieldException) {
            err = new NoSuchFieldError(ex.getMessage());
        } else {
            err = new IncompatibleClassChangeError();
        }
        return (LinkageError) initCauseFrom(err, ex);
    }

    static <E extends Error> E initCauseFrom(E err, Exception ex) {
        Throwable th = ex.getCause();
        Class<?> cls = err.getClass();
        if (cls.isInstance(th)) {
            return (E) cls.cast(th);
        }
        err.initCause(th == null ? ex : th);
        return err;
    }
}
