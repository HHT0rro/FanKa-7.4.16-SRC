package java.lang.constant;

import java.lang.invoke.TypeDescriptor;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface MethodTypeDesc extends ConstantDesc, TypeDescriptor.OfMethod<ClassDesc, MethodTypeDesc> {
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    MethodTypeDesc changeParameterType(int i10, ClassDesc classDesc);

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    MethodTypeDesc changeReturnType(ClassDesc classDesc);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    MethodTypeDesc dropParameterTypes(int i10, int i11);

    boolean equals(Object obj);

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    MethodTypeDesc insertParameterTypes(int i10, ClassDesc... classDescArr);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    ClassDesc[] parameterArray();

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    int parameterCount();

    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    List<ClassDesc> parameterList();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    ClassDesc parameterType(int i10);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.invoke.TypeDescriptor.OfMethod
    ClassDesc returnType();

    static MethodTypeDesc ofDescriptor(String descriptor) {
        return MethodTypeDescImpl.ofDescriptor(descriptor);
    }

    static MethodTypeDesc of(ClassDesc returnDesc, ClassDesc... paramDescs) {
        return new MethodTypeDescImpl(returnDesc, paramDescs);
    }

    @Override // java.lang.invoke.TypeDescriptor
    default String descriptorString() {
        return String.format("(%s)%s", Stream.of((Object[]) parameterArray()).map(new Function() { // from class: java.lang.constant.MethodTypeDesc$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ClassDesc) obj).descriptorString();
            }
        }).collect(Collectors.joining()), returnType().descriptorString());
    }

    default String displayDescriptor() {
        return String.format("(%s)%s", Stream.of((Object[]) parameterArray()).map(new Function() { // from class: java.lang.constant.MethodTypeDesc$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ClassDesc) obj).displayName();
            }
        }).collect(Collectors.joining(",")), returnType().displayName());
    }
}
