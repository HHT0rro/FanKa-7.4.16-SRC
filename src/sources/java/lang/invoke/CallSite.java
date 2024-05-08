package java.lang.invoke;

import com.huawei.quickcard.base.Attributes;
import java.lang.invoke.MethodHandles;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CallSite {
    private static MethodHandle GET_TARGET = null;
    private static final long TARGET_OFFSET;
    MethodHandle target;

    public abstract MethodHandle dynamicInvoker();

    public abstract MethodHandle getTarget();

    public abstract void setTarget(MethodHandle methodHandle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallSite(MethodType type) {
        MethodHandle throwException = MethodHandles.throwException(type.returnType(), IllegalStateException.class);
        this.target = throwException;
        this.target = MethodHandles.insertArguments(throwException, 0, new IllegalStateException("uninitialized call site"));
        if (type.parameterCount() > 0) {
            this.target = MethodHandles.dropArguments(this.target, 0, type.ptypes());
        }
        initializeGetTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallSite(MethodHandle target) {
        target.type();
        this.target = target;
        initializeGetTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallSite(MethodType targetType, MethodHandle createTargetHook) throws Throwable {
        this(targetType);
        ConstantCallSite selfCCS = (ConstantCallSite) this;
        MethodHandle boundTarget = (MethodHandle) createTargetHook.invokeWithArguments(selfCCS);
        checkTargetChange(this.target, boundTarget);
        this.target = boundTarget;
        initializeGetTarget();
    }

    public MethodType type() {
        return this.target.type();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkTargetChange(MethodHandle oldTarget, MethodHandle newTarget) {
        MethodType oldType = oldTarget.type();
        MethodType newType = newTarget.type();
        if (!newType.equals((Object) oldType)) {
            throw wrongTargetType(newTarget, oldType);
        }
    }

    private static WrongMethodTypeException wrongTargetType(MethodHandle target, MethodType type) {
        return new WrongMethodTypeException(String.valueOf(target) + " should be of type " + ((Object) type));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodHandle makeDynamicInvoker() {
        MethodHandle getTarget = GET_TARGET.bindTo(this);
        MethodHandle invoker = MethodHandles.exactInvoker(type());
        return MethodHandles.foldArguments(invoker, getTarget);
    }

    static {
        try {
            TARGET_OFFSET = MethodHandleStatics.UNSAFE.objectFieldOffset(CallSite.class.getDeclaredField(Attributes.Style.TARGET));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private void initializeGetTarget() {
        synchronized (CallSite.class) {
            if (GET_TARGET == null) {
                try {
                    GET_TARGET = MethodHandles.Lookup.IMPL_LOOKUP.findVirtual(CallSite.class, "getTarget", MethodType.methodType(MethodHandle.class));
                } catch (ReflectiveOperationException e2) {
                    throw new InternalError(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTargetNormal(MethodHandle newTarget) {
        this.target = newTarget;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodHandle getTargetVolatile() {
        return (MethodHandle) MethodHandleStatics.UNSAFE.getObjectVolatile(this, TARGET_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTargetVolatile(MethodHandle newTarget) {
        MethodHandleStatics.UNSAFE.putObjectVolatile(this, TARGET_OFFSET, newTarget);
    }
}
