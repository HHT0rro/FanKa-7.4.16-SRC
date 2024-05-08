package java.lang.constant;

import java.lang.invoke.MethodHandles;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ReferenceClassDescImpl implements ClassDesc {
    private final String descriptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceClassDescImpl(String descriptor) {
        Objects.requireNonNull(descriptor);
        int len = ConstantUtils.skipOverFieldSignature(descriptor, 0, descriptor.length(), false);
        if (len == 0 || len == 1 || len != descriptor.length()) {
            throw new IllegalArgumentException(String.format("not a valid reference type descriptor: %s", descriptor));
        }
        this.descriptor = descriptor;
    }

    @Override // java.lang.constant.ClassDesc, java.lang.invoke.TypeDescriptor
    public String descriptorString() {
        return this.descriptor;
    }

    @Override // java.lang.constant.ConstantDesc
    public Class<?> resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
        ClassDesc c4 = this;
        int depth = ConstantUtils.arrayDepth(descriptorString());
        for (int i10 = 0; i10 < depth; i10++) {
            c4 = c4.componentType();
        }
        if (c4.isPrimitive()) {
            return lookup.findClass(descriptorString());
        }
        Class<?> clazz = lookup.findClass(ConstantUtils.internalToBinary(ConstantUtils.dropFirstAndLastChar(c4.descriptorString())));
        for (int i11 = 0; i11 < depth; i11++) {
            clazz = clazz.arrayType();
        }
        return clazz;
    }

    @Override // java.lang.constant.ClassDesc
    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        ClassDesc constant = (ClassDesc) o10;
        return this.descriptor.equals(constant.descriptorString());
    }

    public int hashCode() {
        return this.descriptor.hashCode();
    }

    public String toString() {
        return String.format("ClassDesc[%s]", displayName());
    }
}
