package java.lang.invoke;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class VolatileCallSite extends CallSite {
    public VolatileCallSite(MethodType type) {
        super(type);
    }

    public VolatileCallSite(MethodHandle target) {
        super(target);
    }

    @Override // java.lang.invoke.CallSite
    public final MethodHandle getTarget() {
        return getTargetVolatile();
    }

    @Override // java.lang.invoke.CallSite
    public void setTarget(MethodHandle newTarget) {
        checkTargetChange(getTargetVolatile(), newTarget);
        setTargetVolatile(newTarget);
    }

    @Override // java.lang.invoke.CallSite
    public final MethodHandle dynamicInvoker() {
        return makeDynamicInvoker();
    }
}
