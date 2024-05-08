package java.lang.constant;

import java.lang.Enum;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class DynamicConstantDesc<T> implements ConstantDesc {
    private final ConstantDesc[] bootstrapArgs;
    private final DirectMethodHandleDesc bootstrapMethod;
    private final String constantName;
    private final ClassDesc constantType;

    /* JADX INFO: Access modifiers changed from: protected */
    public DynamicConstantDesc(DirectMethodHandleDesc bootstrapMethod, String constantName, ClassDesc constantType, ConstantDesc... bootstrapArgs) {
        this.bootstrapMethod = (DirectMethodHandleDesc) Objects.requireNonNull(bootstrapMethod);
        this.constantName = ConstantUtils.validateMemberName((String) Objects.requireNonNull(constantName), true);
        this.constantType = (ClassDesc) Objects.requireNonNull(constantType);
        this.bootstrapArgs = (ConstantDesc[]) ((ConstantDesc[]) Objects.requireNonNull(bootstrapArgs)).clone();
        if (constantName.length() == 0) {
            throw new IllegalArgumentException("Illegal invocation name: " + constantName);
        }
    }

    public static <T> ConstantDesc ofCanonical(DirectMethodHandleDesc bootstrapMethod, String constantName, ClassDesc constantType, ConstantDesc[] bootstrapArgs) {
        return ofNamed(bootstrapMethod, constantName, constantType, bootstrapArgs).tryCanonicalize();
    }

    public static <T> DynamicConstantDesc<T> ofNamed(DirectMethodHandleDesc bootstrapMethod, String constantName, ClassDesc constantType, ConstantDesc... bootstrapArgs) {
        return new AnonymousDynamicConstantDesc(bootstrapMethod, constantName, constantType, bootstrapArgs);
    }

    public static <T> DynamicConstantDesc<T> of(DirectMethodHandleDesc bootstrapMethod, ConstantDesc... bootstrapArgs) {
        return ofNamed(bootstrapMethod, "_", bootstrapMethod.invocationType().returnType(), bootstrapArgs);
    }

    public static <T> DynamicConstantDesc<T> of(DirectMethodHandleDesc bootstrapMethod) {
        return of(bootstrapMethod, ConstantUtils.EMPTY_CONSTANTDESC);
    }

    public String constantName() {
        return this.constantName;
    }

    public ClassDesc constantType() {
        return this.constantType;
    }

    public DirectMethodHandleDesc bootstrapMethod() {
        return this.bootstrapMethod;
    }

    public ConstantDesc[] bootstrapArgs() {
        return (ConstantDesc[]) this.bootstrapArgs.clone();
    }

    public List<ConstantDesc> bootstrapArgsList() {
        return List.of((Object[]) this.bootstrapArgs);
    }

    @Override // java.lang.constant.ConstantDesc
    public T resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
        try {
            MethodHandle methodHandle = (MethodHandle) this.bootstrapMethod.resolveConstantDesc(lookup);
            if (methodHandle.type().parameterCount() < 2 || !MethodHandles.Lookup.class.isAssignableFrom(methodHandle.type().parameterType(0))) {
                throw new BootstrapMethodError("Invalid bootstrap method declared for resolving a dynamic constant: " + ((Object) this.bootstrapMethod));
            }
            Object[] objArr = new Object[this.bootstrapArgs.length + 3];
            objArr[0] = lookup;
            objArr[1] = this.constantName;
            objArr[2] = this.constantType.resolveConstantDesc(lookup);
            int i10 = 0;
            while (true) {
                ConstantDesc[] constantDescArr = this.bootstrapArgs;
                if (i10 < constantDescArr.length) {
                    objArr[i10 + 3] = constantDescArr[i10].resolveConstantDesc(lookup);
                    i10++;
                } else {
                    return (T) methodHandle.invokeWithArguments(objArr);
                }
            }
        } catch (Error e2) {
            throw e2;
        } catch (Throwable th) {
            throw new BootstrapMethodError(th);
        }
    }

    private ConstantDesc tryCanonicalize() {
        Function<DynamicConstantDesc<?>, ConstantDesc> f10 = CanonicalMapHolder.CANONICAL_MAP.get(this.bootstrapMethod);
        if (f10 != null) {
            try {
                return f10.apply(this);
            } catch (Throwable th) {
                return this;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConstantDesc canonicalizeNull(DynamicConstantDesc<?> desc) {
        if (((DynamicConstantDesc) desc).bootstrapArgs.length != 0) {
            return desc;
        }
        return ConstantDescs.NULL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConstantDesc canonicalizeEnum(DynamicConstantDesc<?> desc) {
        String str;
        if (((DynamicConstantDesc) desc).bootstrapArgs.length != 0 || (str = ((DynamicConstantDesc) desc).constantName) == null) {
            return desc;
        }
        return Enum.EnumDesc.of(((DynamicConstantDesc) desc).constantType, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConstantDesc canonicalizePrimitiveClass(DynamicConstantDesc<?> desc) {
        String str;
        if (((DynamicConstantDesc) desc).bootstrapArgs.length != 0 || !desc.constantType().equals(ConstantDescs.CD_Class) || (str = ((DynamicConstantDesc) desc).constantName) == null) {
            return desc;
        }
        return ClassDesc.ofDescriptor(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConstantDesc canonicalizeStaticFieldVarHandle(DynamicConstantDesc<?> desc) {
        if (((DynamicConstantDesc) desc).bootstrapArgs.length != 2 || !desc.constantType().equals(ConstantDescs.CD_VarHandle)) {
            return desc;
        }
        ConstantDesc[] constantDescArr = ((DynamicConstantDesc) desc).bootstrapArgs;
        return VarHandle.VarHandleDesc.ofStaticField((ClassDesc) constantDescArr[0], ((DynamicConstantDesc) desc).constantName, (ClassDesc) constantDescArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConstantDesc canonicalizeFieldVarHandle(DynamicConstantDesc<?> desc) {
        if (((DynamicConstantDesc) desc).bootstrapArgs.length != 2 || !desc.constantType().equals(ConstantDescs.CD_VarHandle)) {
            return desc;
        }
        ConstantDesc[] constantDescArr = ((DynamicConstantDesc) desc).bootstrapArgs;
        return VarHandle.VarHandleDesc.ofField((ClassDesc) constantDescArr[0], ((DynamicConstantDesc) desc).constantName, (ClassDesc) constantDescArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConstantDesc canonicalizeArrayVarHandle(DynamicConstantDesc<?> desc) {
        if (((DynamicConstantDesc) desc).bootstrapArgs.length != 1 || !desc.constantType().equals(ConstantDescs.CD_VarHandle)) {
            return desc;
        }
        return VarHandle.VarHandleDesc.ofArray((ClassDesc) ((DynamicConstantDesc) desc).bootstrapArgs[0]);
    }

    public final boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 instanceof DynamicConstantDesc) {
            DynamicConstantDesc<?> desc = (DynamicConstantDesc) o10;
            if (Objects.equals(this.bootstrapMethod, desc.bootstrapMethod) && Arrays.equals(this.bootstrapArgs, desc.bootstrapArgs) && Objects.equals(this.constantName, desc.constantName) && Objects.equals(this.constantType, desc.constantType)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = Objects.hash(this.bootstrapMethod, this.constantName, this.constantType);
        return (result * 31) + Arrays.hashCode(this.bootstrapArgs);
    }

    public String toString() {
        Object[] objArr = new Object[5];
        objArr[0] = this.bootstrapMethod.owner().displayName();
        objArr[1] = this.bootstrapMethod.methodName();
        objArr[2] = this.constantName.equals("_") ? "" : this.constantName + "/";
        objArr[3] = Stream.of((Object[]) this.bootstrapArgs).map(new Function() { // from class: java.lang.constant.DynamicConstantDesc$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String obj2;
                obj2 = ((ConstantDesc) obj).toString();
                return obj2;
            }
        }).collect(Collectors.joining(","));
        objArr[4] = this.constantType.displayName();
        return String.format("DynamicConstantDesc[%s::%s(%s%s)%s]", objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class AnonymousDynamicConstantDesc<T> extends DynamicConstantDesc<T> {
        AnonymousDynamicConstantDesc(DirectMethodHandleDesc bootstrapMethod, String constantName, ClassDesc constantType, ConstantDesc... bootstrapArgs) {
            super(bootstrapMethod, constantName, constantType, bootstrapArgs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CanonicalMapHolder {
        static final Map<MethodHandleDesc, Function<DynamicConstantDesc<?>, ConstantDesc>> CANONICAL_MAP = Map.ofEntries(Map.entry(ConstantDescs.BSM_PRIMITIVE_CLASS, new Function() { // from class: java.lang.constant.DynamicConstantDesc$CanonicalMapHolder$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ConstantDesc canonicalizePrimitiveClass;
                canonicalizePrimitiveClass = DynamicConstantDesc.canonicalizePrimitiveClass((DynamicConstantDesc) obj);
                return canonicalizePrimitiveClass;
            }
        }), Map.entry(ConstantDescs.BSM_ENUM_CONSTANT, new Function() { // from class: java.lang.constant.DynamicConstantDesc$CanonicalMapHolder$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ConstantDesc canonicalizeEnum;
                canonicalizeEnum = DynamicConstantDesc.canonicalizeEnum((DynamicConstantDesc) obj);
                return canonicalizeEnum;
            }
        }), Map.entry(ConstantDescs.BSM_NULL_CONSTANT, new Function() { // from class: java.lang.constant.DynamicConstantDesc$CanonicalMapHolder$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ConstantDesc canonicalizeNull;
                canonicalizeNull = DynamicConstantDesc.canonicalizeNull((DynamicConstantDesc) obj);
                return canonicalizeNull;
            }
        }), Map.entry(ConstantDescs.BSM_VARHANDLE_STATIC_FIELD, new Function() { // from class: java.lang.constant.DynamicConstantDesc$CanonicalMapHolder$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ConstantDesc canonicalizeStaticFieldVarHandle;
                canonicalizeStaticFieldVarHandle = DynamicConstantDesc.canonicalizeStaticFieldVarHandle((DynamicConstantDesc) obj);
                return canonicalizeStaticFieldVarHandle;
            }
        }), Map.entry(ConstantDescs.BSM_VARHANDLE_FIELD, new Function() { // from class: java.lang.constant.DynamicConstantDesc$CanonicalMapHolder$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ConstantDesc canonicalizeFieldVarHandle;
                canonicalizeFieldVarHandle = DynamicConstantDesc.canonicalizeFieldVarHandle((DynamicConstantDesc) obj);
                return canonicalizeFieldVarHandle;
            }
        }), Map.entry(ConstantDescs.BSM_VARHANDLE_ARRAY, new Function() { // from class: java.lang.constant.DynamicConstantDesc$CanonicalMapHolder$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ConstantDesc canonicalizeArrayVarHandle;
                canonicalizeArrayVarHandle = DynamicConstantDesc.canonicalizeArrayVarHandle((DynamicConstantDesc) obj);
                return canonicalizeArrayVarHandle;
            }
        }));

        private CanonicalMapHolder() {
        }
    }
}
