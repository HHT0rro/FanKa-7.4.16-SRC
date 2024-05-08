package java.lang.constant;

import java.lang.constant.DirectMethodHandleDesc;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface MethodHandleDesc extends ConstantDesc {
    boolean equals(Object obj);

    MethodTypeDesc invocationType();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.lang.constant.MethodHandleDesc$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind;

        static {
            int[] iArr = new int[DirectMethodHandleDesc.Kind.values().length];
            $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind = iArr;
            try {
                iArr[DirectMethodHandleDesc.Kind.GETTER.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.SETTER.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.STATIC_GETTER.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.STATIC_SETTER.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.VIRTUAL.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.SPECIAL.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.INTERFACE_VIRTUAL.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.INTERFACE_SPECIAL.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.INTERFACE_STATIC.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.STATIC.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[DirectMethodHandleDesc.Kind.CONSTRUCTOR.ordinal()] = 11;
            } catch (NoSuchFieldError e19) {
            }
        }
    }

    static DirectMethodHandleDesc of(DirectMethodHandleDesc.Kind kind, ClassDesc owner, String name, String lookupDescriptor) {
        switch (AnonymousClass1.$SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[kind.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return ofField(kind, owner, name, ClassDesc.ofDescriptor(lookupDescriptor));
            default:
                return new DirectMethodHandleDescImpl(kind, owner, name, MethodTypeDesc.ofDescriptor(lookupDescriptor));
        }
    }

    static DirectMethodHandleDesc ofMethod(DirectMethodHandleDesc.Kind kind, ClassDesc owner, String name, MethodTypeDesc lookupMethodType) {
        switch (AnonymousClass1.$SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[kind.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new IllegalArgumentException(kind.toString());
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return new DirectMethodHandleDescImpl(kind, owner, name, lookupMethodType);
            default:
                throw new IllegalArgumentException(kind.toString());
        }
    }

    static DirectMethodHandleDesc ofField(DirectMethodHandleDesc.Kind kind, ClassDesc owner, String fieldName, ClassDesc fieldType) {
        MethodTypeDesc mtr;
        switch (AnonymousClass1.$SwitchMap$java$lang$constant$DirectMethodHandleDesc$Kind[kind.ordinal()]) {
            case 1:
                mtr = MethodTypeDesc.of(fieldType, owner);
                break;
            case 2:
                mtr = MethodTypeDesc.of(ConstantDescs.CD_void, owner, fieldType);
                break;
            case 3:
                mtr = MethodTypeDesc.of(fieldType, new ClassDesc[0]);
                break;
            case 4:
                mtr = MethodTypeDesc.of(ConstantDescs.CD_void, fieldType);
                break;
            default:
                throw new IllegalArgumentException(kind.toString());
        }
        return new DirectMethodHandleDescImpl(kind, owner, fieldName, mtr);
    }

    static DirectMethodHandleDesc ofConstructor(ClassDesc owner, ClassDesc... paramTypes) {
        return ofMethod(DirectMethodHandleDesc.Kind.CONSTRUCTOR, owner, "_", MethodTypeDesc.of(ConstantDescs.CD_void, paramTypes));
    }

    default MethodHandleDesc asType(MethodTypeDesc type) {
        return invocationType().equals(type) ? this : new AsTypeMethodHandleDesc(this, type);
    }
}
