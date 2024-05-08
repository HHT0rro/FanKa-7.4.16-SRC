package java.lang.constant;

import androidx.exifinterface.media.ExifInterface;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class MethodTypeDescImpl implements MethodTypeDesc {
    private final ClassDesc[] argTypes;
    private final ClassDesc returnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodTypeDescImpl(ClassDesc returnType, ClassDesc[] argTypes) {
        this.returnType = (ClassDesc) Objects.requireNonNull(returnType);
        this.argTypes = (ClassDesc[]) Objects.requireNonNull(argTypes);
        for (ClassDesc cr : argTypes) {
            if (cr.isPrimitive() && cr.descriptorString().equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                throw new IllegalArgumentException("Void parameters not permitted");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MethodTypeDescImpl ofDescriptor(String descriptor) {
        Objects.requireNonNull(descriptor);
        List<String> types = ConstantUtils.parseMethodDescriptor(descriptor);
        ClassDesc[] paramTypes = (ClassDesc[]) types.stream().skip(1L).map(new Function() { // from class: java.lang.constant.MethodTypeDescImpl$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ClassDesc.ofDescriptor((String) obj);
            }
        }).toArray(new IntFunction() { // from class: java.lang.constant.MethodTypeDescImpl$$ExternalSyntheticLambda1
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return MethodTypeDescImpl.lambda$ofDescriptor$0(i10);
            }
        });
        return new MethodTypeDescImpl(ClassDesc.ofDescriptor(types.get(0)), paramTypes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ClassDesc[] lambda$ofDescriptor$0(int x$0) {
        return new ClassDesc[x$0];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public ClassDesc returnType() {
        return this.returnType;
    }

    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public int parameterCount() {
        return this.argTypes.length;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public ClassDesc parameterType(int index) {
        return this.argTypes[index];
    }

    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public List<ClassDesc> parameterList() {
        return List.of((Object[]) this.argTypes);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public ClassDesc[] parameterArray() {
        return (ClassDesc[]) this.argTypes.clone();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public MethodTypeDesc changeReturnType(ClassDesc returnType) {
        return MethodTypeDesc.of(returnType, this.argTypes);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public MethodTypeDesc changeParameterType(int index, ClassDesc paramType) {
        ClassDesc[] newArgs = (ClassDesc[]) this.argTypes.clone();
        newArgs[index] = paramType;
        return MethodTypeDesc.of(this.returnType, newArgs);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public MethodTypeDesc dropParameterTypes(int start, int end) {
        if (start >= 0) {
            ClassDesc[] classDescArr = this.argTypes;
            if (start < classDescArr.length && end >= 0 && end <= classDescArr.length && start <= end) {
                ClassDesc[] newArgs = new ClassDesc[classDescArr.length - (end - start)];
                System.arraycopy(classDescArr, 0, newArgs, 0, start);
                ClassDesc[] classDescArr2 = this.argTypes;
                System.arraycopy(classDescArr2, end, newArgs, start, classDescArr2.length - end);
                return MethodTypeDesc.of(this.returnType, newArgs);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.constant.MethodTypeDesc, java.lang.invoke.TypeDescriptor.OfMethod
    public MethodTypeDesc insertParameterTypes(int pos, ClassDesc... paramTypes) {
        if (pos >= 0) {
            ClassDesc[] classDescArr = this.argTypes;
            if (pos <= classDescArr.length) {
                ClassDesc[] newArgs = new ClassDesc[classDescArr.length + paramTypes.length];
                System.arraycopy(classDescArr, 0, newArgs, 0, pos);
                System.arraycopy(paramTypes, 0, newArgs, pos, paramTypes.length);
                ClassDesc[] classDescArr2 = this.argTypes;
                System.arraycopy(classDescArr2, pos, newArgs, paramTypes.length + pos, classDescArr2.length - pos);
                return MethodTypeDesc.of(this.returnType, newArgs);
            }
        }
        throw new IndexOutOfBoundsException(pos);
    }

    @Override // java.lang.constant.ConstantDesc
    public MethodType resolveConstantDesc(final MethodHandles.Lookup lookup) throws ReflectiveOperationException {
        MethodType mtype = (MethodType) AccessController.doPrivileged(new PrivilegedAction<MethodType>() { // from class: java.lang.constant.MethodTypeDescImpl.1
            @Override // java.security.PrivilegedAction
            public MethodType run() {
                return MethodType.fromMethodDescriptorString(MethodTypeDescImpl.this.descriptorString(), lookup.lookupClass().getClassLoader());
            }
        });
        lookup.accessClass(mtype.returnType());
        for (Class<?> paramType : mtype.parameterArray()) {
            lookup.accessClass(paramType);
        }
        return mtype;
    }

    @Override // java.lang.constant.MethodTypeDesc
    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        MethodTypeDescImpl constant = (MethodTypeDescImpl) o10;
        if (this.returnType.equals(constant.returnType) && Arrays.equals(this.argTypes, constant.argTypes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.returnType.hashCode();
        return (result * 31) + Arrays.hashCode(this.argTypes);
    }

    public String toString() {
        return String.format("MethodTypeDesc[%s]", displayDescriptor());
    }
}
