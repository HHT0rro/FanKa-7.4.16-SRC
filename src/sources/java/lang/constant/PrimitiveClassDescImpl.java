package java.lang.constant;

import java.lang.invoke.MethodHandles;
import java.util.Objects;
import sun.invoke.util.Wrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class PrimitiveClassDescImpl extends DynamicConstantDesc<Class<?>> implements ClassDesc {
    private final String descriptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrimitiveClassDescImpl(String descriptor) {
        super(ConstantDescs.BSM_PRIMITIVE_CLASS, (String) Objects.requireNonNull(descriptor), ConstantDescs.CD_Class, new ConstantDesc[0]);
        if (descriptor.length() != 1 || "VIJCSBFDZ".indexOf(descriptor.charAt(0)) < 0) {
            throw new IllegalArgumentException(String.format("not a valid primitive type descriptor: %s", descriptor));
        }
        this.descriptor = descriptor;
    }

    @Override // java.lang.constant.ClassDesc, java.lang.invoke.TypeDescriptor
    public String descriptorString() {
        return this.descriptor;
    }

    @Override // java.lang.constant.DynamicConstantDesc, java.lang.constant.ConstantDesc
    public Class<?> resolveConstantDesc(MethodHandles.Lookup lookup) {
        return Wrapper.forBasicType(descriptorString().charAt(0)).primitiveType();
    }

    @Override // java.lang.constant.DynamicConstantDesc
    public String toString() {
        return String.format("PrimitiveClassDesc[%s]", displayName());
    }
}
