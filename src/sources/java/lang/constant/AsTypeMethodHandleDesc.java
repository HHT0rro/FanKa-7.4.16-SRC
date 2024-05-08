package java.lang.constant;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class AsTypeMethodHandleDesc extends DynamicConstantDesc<MethodHandle> implements MethodHandleDesc {
    private final MethodTypeDesc type;
    private final MethodHandleDesc underlying;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsTypeMethodHandleDesc(MethodHandleDesc underlying, MethodTypeDesc type) {
        super(ConstantDescs.BSM_INVOKE, "_", ConstantDescs.CD_MethodHandle, ConstantDescs.MHD_METHODHANDLE_ASTYPE, underlying, type);
        this.underlying = (MethodHandleDesc) Objects.requireNonNull(underlying);
        this.type = (MethodTypeDesc) Objects.requireNonNull(type);
    }

    @Override // java.lang.constant.MethodHandleDesc
    public MethodTypeDesc invocationType() {
        return this.type;
    }

    @Override // java.lang.constant.DynamicConstantDesc, java.lang.constant.ConstantDesc
    public MethodHandle resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
        MethodHandle handle = (MethodHandle) this.underlying.resolveConstantDesc(lookup);
        MethodType methodType = (MethodType) this.type.resolveConstantDesc(lookup);
        return handle.asType(methodType);
    }

    @Override // java.lang.constant.DynamicConstantDesc
    public String toString() {
        return String.format("%s.asType%s", this.underlying.toString(), this.type.displayDescriptor());
    }
}
