package java.security;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class AccessController {
    private AccessController() {
    }

    public static <T> T doPrivileged(PrivilegedAction<T> action) {
        return action.run();
    }

    public static <T> T doPrivilegedWithCombiner(PrivilegedAction<T> action) {
        return action.run();
    }

    public static <T> T doPrivileged(PrivilegedAction<T> action, AccessControlContext context) {
        return action.run();
    }

    public static <T> T doPrivilegedWithCombiner(PrivilegedAction<T> privilegedAction, AccessControlContext accessControlContext, Permission... permissionArr) {
        return (T) doPrivileged(privilegedAction);
    }

    public static <T> T doPrivileged(PrivilegedExceptionAction<T> action) throws PrivilegedActionException {
        try {
            return action.run();
        } catch (Exception e2) {
            throw new PrivilegedActionException(e2);
        }
    }

    public static <T> T doPrivilegedWithCombiner(PrivilegedExceptionAction<T> privilegedExceptionAction) throws PrivilegedActionException {
        return (T) doPrivileged(privilegedExceptionAction);
    }

    public static <T> T doPrivileged(PrivilegedExceptionAction<T> privilegedExceptionAction, AccessControlContext accessControlContext) throws PrivilegedActionException {
        return (T) doPrivileged(privilegedExceptionAction);
    }

    public static <T> T doPrivileged(PrivilegedExceptionAction<T> privilegedExceptionAction, AccessControlContext accessControlContext, Permission... permissionArr) throws PrivilegedActionException {
        return (T) doPrivileged(privilegedExceptionAction);
    }

    public static <T> T doPrivilegedWithCombiner(PrivilegedExceptionAction<T> privilegedExceptionAction, AccessControlContext accessControlContext, Permission... permissionArr) throws PrivilegedActionException {
        return (T) doPrivileged(privilegedExceptionAction);
    }

    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, AccessControlContext accessControlContext, Permission... permissionArr) {
        return (T) doPrivileged(privilegedAction);
    }

    public static AccessControlContext getContext() {
        return new AccessControlContext(null);
    }

    public static void checkPermission(Permission perm) throws AccessControlException {
    }
}
