package java.lang.constant;

import java.lang.invoke.TypeDescriptor;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import sun.invoke.util.Wrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ClassDesc extends ConstantDesc, TypeDescriptor.OfField<ClassDesc> {
    @Override // java.lang.invoke.TypeDescriptor
    String descriptorString();

    boolean equals(Object obj);

    static ClassDesc of(String name) {
        ConstantUtils.validateBinaryClassName((String) Objects.requireNonNull(name));
        return ofDescriptor("L" + ConstantUtils.binaryToInternal(name) + ";");
    }

    static ClassDesc of(String packageName, String className) {
        ConstantUtils.validateBinaryClassName((String) Objects.requireNonNull(packageName));
        if (packageName.isEmpty()) {
            return of(className);
        }
        ConstantUtils.validateMemberName((String) Objects.requireNonNull(className), false);
        return ofDescriptor("L" + ConstantUtils.binaryToInternal(packageName) + (packageName.length() > 0 ? "/" : "") + className + ";");
    }

    static ClassDesc ofDescriptor(String descriptor) {
        Objects.requireNonNull(descriptor);
        if (descriptor.isEmpty()) {
            throw new IllegalArgumentException("not a valid reference type descriptor: " + descriptor);
        }
        int depth = ConstantUtils.arrayDepth(descriptor);
        if (depth > 255) {
            throw new IllegalArgumentException("Cannot create an array type descriptor with more than 255 dimensions");
        }
        if (descriptor.length() == 1) {
            return new PrimitiveClassDescImpl(descriptor);
        }
        return new ReferenceClassDescImpl(descriptor);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfField
    default ClassDesc arrayType() {
        int depth = ConstantUtils.arrayDepth(descriptorString());
        if (depth >= 255) {
            throw new IllegalStateException("Cannot create an array type descriptor with more than 255 dimensions");
        }
        return arrayType(1);
    }

    default ClassDesc arrayType(int rank) {
        int currentDepth = ConstantUtils.arrayDepth(descriptorString());
        if (rank <= 0 || currentDepth + rank > 255) {
            throw new IllegalArgumentException("rank: " + currentDepth + rank);
        }
        return ofDescriptor("[".repeat(rank) + descriptorString());
    }

    default ClassDesc nested(String nestedName) {
        ConstantUtils.validateMemberName(nestedName, false);
        if (!isClassOrInterface()) {
            throw new IllegalStateException("Outer class is not a class or interface type");
        }
        return ofDescriptor(ConstantUtils.dropLastChar(descriptorString()) + "$" + nestedName + ";");
    }

    default ClassDesc nested(String firstNestedName, String... moreNestedNames) {
        if (!isClassOrInterface()) {
            throw new IllegalStateException("Outer class is not a class or interface type");
        }
        ConstantUtils.validateMemberName(firstNestedName, false);
        Objects.requireNonNull(moreNestedNames);
        for (String addNestedNames : moreNestedNames) {
            ConstantUtils.validateMemberName(addNestedNames, false);
        }
        if (moreNestedNames.length == 0) {
            return nested(firstNestedName);
        }
        return nested(firstNestedName + ((String) Stream.of((Object[]) moreNestedNames).collect(Collectors.joining("$", "$", ""))));
    }

    @Override // java.lang.invoke.TypeDescriptor.OfField
    default boolean isArray() {
        return descriptorString().startsWith("[");
    }

    @Override // java.lang.invoke.TypeDescriptor.OfField
    default boolean isPrimitive() {
        return descriptorString().length() == 1;
    }

    default boolean isClassOrInterface() {
        return descriptorString().startsWith("L");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfField
    default ClassDesc componentType() {
        if (isArray()) {
            return ofDescriptor(descriptorString().substring(1));
        }
        return null;
    }

    default String packageName() {
        String className;
        int index;
        return (isClassOrInterface() && (index = (className = ConstantUtils.internalToBinary(ConstantUtils.dropFirstAndLastChar(descriptorString()))).lastIndexOf(46)) != -1) ? className.substring(0, index) : "";
    }

    default String displayName() {
        if (isPrimitive()) {
            return Wrapper.forBasicType(descriptorString().charAt(0)).primitiveSimpleName();
        }
        if (isClassOrInterface()) {
            return descriptorString().substring(Math.max(1, descriptorString().lastIndexOf(47) + 1), descriptorString().length() - 1);
        }
        if (isArray()) {
            int depth = ConstantUtils.arrayDepth(descriptorString());
            ClassDesc c4 = this;
            for (int i10 = 0; i10 < depth; i10++) {
                c4 = c4.componentType();
            }
            return c4.displayName() + "[]".repeat(depth);
        }
        throw new IllegalStateException(descriptorString());
    }
}
