package java.lang.invoke;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MutableCallSite extends CallSite {
    public MutableCallSite(MethodType type) {
        super(type);
    }

    public MutableCallSite(MethodHandle target) {
        super(target);
    }

    @Override // java.lang.invoke.CallSite
    public final MethodHandle getTarget() {
        return this.target;
    }

    @Override // java.lang.invoke.CallSite
    public void setTarget(MethodHandle newTarget) {
        checkTargetChange(this.target, newTarget);
        setTargetNormal(newTarget);
    }

    @Override // java.lang.invoke.CallSite
    public final MethodHandle dynamicInvoker() {
        return makeDynamicInvoker();
    }
}
