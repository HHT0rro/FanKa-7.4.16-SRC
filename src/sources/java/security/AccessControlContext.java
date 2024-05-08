package java.security;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class AccessControlContext {
    public AccessControlContext(ProtectionDomain[] context) {
    }

    public AccessControlContext(AccessControlContext acc, DomainCombiner combiner) {
    }

    AccessControlContext(AccessControlContext acc, DomainCombiner combiner, boolean preauthorized) {
    }

    AccessControlContext(ProtectionDomain caller, DomainCombiner combiner, AccessControlContext parent, AccessControlContext context, Permission[] perms) {
    }

    AccessControlContext(ProtectionDomain[] context, boolean isPrivileged) {
    }

    AccessControlContext(ProtectionDomain[] context, AccessControlContext privilegedContext) {
    }

    ProtectionDomain[] getContext() {
        return null;
    }

    boolean isPrivileged() {
        return false;
    }

    DomainCombiner getAssignedCombiner() {
        return null;
    }

    public DomainCombiner getDomainCombiner() {
        return null;
    }

    public void checkPermission(Permission perm) throws AccessControlException {
    }

    AccessControlContext optimize() {
        return null;
    }
}
