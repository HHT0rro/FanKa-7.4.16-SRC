package java.lang.invoke;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ConstantCallSite extends CallSite {
    private final boolean isFrozen;

    public ConstantCallSite(MethodHandle target) {
        super(target);
        this.isFrozen = true;
    }

    protected ConstantCallSite(MethodType targetType, MethodHandle createTargetHook) throws Throwable {
        super(targetType, createTargetHook);
        this.isFrozen = true;
    }

    @Override // java.lang.invoke.CallSite
    public final MethodHandle getTarget() {
        if (!this.isFrozen) {
            throw new IllegalStateException();
        }
        return this.target;
    }

    @Override // java.lang.invoke.CallSite
    public final void setTarget(MethodHandle ignore) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.invoke.CallSite
    public final MethodHandle dynamicInvoker() {
        return getTarget();
    }
}
