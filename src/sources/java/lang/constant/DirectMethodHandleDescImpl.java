package java.lang.constant;

import androidx.exifinterface.media.ExifInterface;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class DirectMethodHandleDescImpl implements DirectMethodHandleDesc {
    private final MethodTypeDesc invocationType;
    private final DirectMethodHandleDesc.Kind kind;
    private final String name;
    private final ClassDesc owner;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DirectMethodHandleDescImpl(DirectMethodHandleDesc.Kind kind, ClassDesc owner, String name, MethodTypeDesc type) {
        name = kind == DirectMethodHandleDesc.Kind.CONSTRUCTOR ? "<init>" : name;
        Objects.requireNonNull(kind);
        ConstantUtils.validateClassOrInterface((ClassDesc) Objects.requireNonNull(owner));
        ConstantUtils.validateMemberName((String) Objects.requireNonNull(name), true);
        Objects.requireNonNull(type);
        switch (AnonymousClass1.$SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[kind.ordinal()]) {
            case 1:
                validateConstructor(type);
                break;
            case 2:
                validateFieldType(type, false, true);
                break;
            case 3:
                validateFieldType(type, true, true);
                break;
            case 4:
                validateFieldType(type, false, false);
                break;
            case 5:
                validateFieldType(type, true, false);
                break;
        }
        this.kind = kind;
        this.owner = owner;
        this.name = name;
        if (kind.isVirtualMethod()) {
            this.invocationType = type.insertParameterTypes(0, owner);
        } else if (kind == DirectMethodHandleDesc.Kind.CONSTRUCTOR) {
            this.invocationType = type.changeReturnType(owner);
        } else {
            this.invocationType = type;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.lang.constant.DirectMethodHandleDescImpl$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind;

        static {
            int[] iArr = new int[DirectMethodHandleDesc.Kind.values().length];
            $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind = iArr;
            try {
                iArr[DirectMethodHandleDesc.Kind.CONSTRUCTOR.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.GETTER.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.SETTER.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.STATIC_GETTER.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.STATIC_SETTER.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.VIRTUAL.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.SPECIAL.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.INTERFACE_VIRTUAL.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.INTERFACE_SPECIAL.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.STATIC.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.INTERFACE_STATIC.ordinal()] = 11;
            } catch (NoSuchFieldError e19) {
            }
        }
    }

    private static void validateFieldType(MethodTypeDesc methodTypeDesc, boolean z10, boolean z11) {
        String descriptorString = methodTypeDesc.returnType().descriptorString();
        String str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        boolean equals = descriptorString.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i10 = (z10 ? 1 : 0) + (z11 ? 1 : 0);
        if (equals != z10 || methodTypeDesc.parameterCount() != i10 || (z11 && methodTypeDesc.parameterType(0).isPrimitive())) {
            Object[] objArr = new Object[3];
            objArr[0] = z11 ? "R" : "";
            objArr[1] = z10 ? ExifInterface.GPS_DIRECTION_TRUE : "";
            if (!z10) {
                str = ExifInterface.GPS_DIRECTION_TRUE;
            }
            objArr[2] = str;
            throw new IllegalArgumentException(String.format("Expected type of %s for getter, found %s", String.format("(%s%s)%s", objArr), methodTypeDesc));
        }
    }

    private static void validateConstructor(MethodTypeDesc type) {
        if (!type.returnType().descriptorString().equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            throw new IllegalArgumentException(String.format("Expected type of (T*)V for constructor, found %s", type));
        }
    }

    @Override // java.lang.constant.DirectMethodHandleDesc
    public DirectMethodHandleDesc.Kind kind() {
        return this.kind;
    }

    @Override // java.lang.constant.DirectMethodHandleDesc
    public int refKind() {
        return this.kind.refKind;
    }

    @Override // java.lang.constant.DirectMethodHandleDesc
    public boolean isOwnerInterface() {
        return this.kind.isInterface;
    }

    @Override // java.lang.constant.DirectMethodHandleDesc
    public ClassDesc owner() {
        return this.owner;
    }

    @Override // java.lang.constant.DirectMethodHandleDesc
    public String methodName() {
        return this.name;
    }

    @Override // java.lang.constant.MethodHandleDesc
    public MethodTypeDesc invocationType() {
        return this.invocationType;
    }

    @Override // java.lang.constant.DirectMethodHandleDesc
    public String lookupDescriptor() {
        switch (AnonymousClass1.$SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[this.kind.ordinal()]) {
            case 1:
                return this.invocationType.changeReturnType(ConstantDescs.CD_void).descriptorString();
            case 2:
            case 4:
                return this.invocationType.returnType().descriptorString();
            case 3:
                return this.invocationType.parameterType(1).descriptorString();
            case 5:
                return this.invocationType.parameterType(0).descriptorString();
            case 6:
            case 7:
            case 8:
            case 9:
                return this.invocationType.dropParameterTypes(0, 1).descriptorString();
            case 10:
            case 11:
                return this.invocationType.descriptorString();
            default:
                throw new IllegalStateException(this.kind.toString());
        }
    }

    @Override // java.lang.constant.ConstantDesc
    public MethodHandle resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
        Class<?> resolvedOwner = (Class) this.owner.resolveConstantDesc(lookup);
        MethodType invocationType = (MethodType) invocationType().resolveConstantDesc(lookup);
        switch (AnonymousClass1.$SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[this.kind.ordinal()]) {
            case 1:
                return lookup.findConstructor(resolvedOwner, invocationType.changeReturnType((Class<?>) Void.TYPE));
            case 2:
                return lookup.findGetter(resolvedOwner, this.name, invocationType.returnType());
            case 3:
                return lookup.findSetter(resolvedOwner, this.name, invocationType.parameterType(1));
            case 4:
                return lookup.findStaticGetter(resolvedOwner, this.name, invocationType.returnType());
            case 5:
                return lookup.findStaticSetter(resolvedOwner, this.name, invocationType.parameterType(0));
            case 6:
            case 8:
                return lookup.findVirtual(resolvedOwner, this.name, invocationType.dropParameterTypes(0, 1));
            case 7:
            case 9:
                return lookup.findSpecial(resolvedOwner, this.name, invocationType.dropParameterTypes(0, 1), lookup.lookupClass());
            case 10:
            case 11:
                return lookup.findStatic(resolvedOwner, this.name, invocationType);
            default:
                throw new IllegalStateException(this.kind.name());
        }
    }

    @Override // java.lang.constant.MethodHandleDesc
    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        DirectMethodHandleDescImpl desc = (DirectMethodHandleDescImpl) o10;
        if (this.kind == desc.kind && Objects.equals(this.owner, desc.owner) && Objects.equals(this.name, desc.name) && Objects.equals(this.invocationType, desc.invocationType)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.kind, this.owner, this.name, this.invocationType);
    }

    public String toString() {
        return String.format("MethodHandleDesc[%s/%s::%s%s]", this.kind, this.owner.displayName(), this.name, this.invocationType.displayDescriptor());
    }
}
