package java.lang.invoke;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.constant.DynamicConstantDesc;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class VarHandle {
    private static final int ALL_MODES_BIT_MASK;
    private static final int ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK;
    private static final int BITWISE_ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK;
    private static final int NUMERIC_ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK;
    private static final int READ_ACCESS_MODES_BIT_MASK;
    private static final Unsafe UNSAFE = Unsafe.getUnsafe();
    private static final int WRITE_ACCESS_MODES_BIT_MASK;
    private final int accessModesBitMask;
    private final Class<?> coordinateType0;
    private final Class<?> coordinateType1;
    private final Class<?> varType;

    @MethodHandle.PolymorphicSignature
    public final native Object compareAndExchange(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object compareAndExchangeAcquire(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object compareAndExchangeRelease(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native boolean compareAndSet(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object get(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAcquire(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndAdd(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndAddAcquire(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndAddRelease(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseAnd(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseAndAcquire(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseAndRelease(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseOr(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseOrAcquire(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseOrRelease(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseXor(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseXorAcquire(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndBitwiseXorRelease(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndSet(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndSetAcquire(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getAndSetRelease(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getOpaque(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native Object getVolatile(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native void set(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native void setOpaque(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native void setRelease(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native void setVolatile(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native boolean weakCompareAndSet(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native boolean weakCompareAndSetAcquire(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native boolean weakCompareAndSetPlain(Object... objArr);

    @MethodHandle.PolymorphicSignature
    public final native boolean weakCompareAndSetRelease(Object... objArr);

    static {
        if (AccessMode.values().length > 32) {
            throw new InternalError("accessModes overflow");
        }
        int accessTypesToBitMask = accessTypesToBitMask(EnumSet.of(AccessType.GET));
        READ_ACCESS_MODES_BIT_MASK = accessTypesToBitMask;
        int accessTypesToBitMask2 = accessTypesToBitMask(EnumSet.of(AccessType.SET));
        WRITE_ACCESS_MODES_BIT_MASK = accessTypesToBitMask2;
        int accessTypesToBitMask3 = accessTypesToBitMask(EnumSet.of(AccessType.COMPARE_AND_EXCHANGE, AccessType.COMPARE_AND_SET, AccessType.GET_AND_UPDATE));
        ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK = accessTypesToBitMask3;
        int accessTypesToBitMask4 = accessTypesToBitMask(EnumSet.of(AccessType.GET_AND_UPDATE_NUMERIC));
        NUMERIC_ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK = accessTypesToBitMask4;
        int accessTypesToBitMask5 = accessTypesToBitMask(EnumSet.of(AccessType.GET_AND_UPDATE_BITWISE));
        BITWISE_ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK = accessTypesToBitMask5;
        ALL_MODES_BIT_MASK = accessTypesToBitMask | accessTypesToBitMask2 | accessTypesToBitMask3 | accessTypesToBitMask4 | accessTypesToBitMask5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum AccessType {
        GET,
        SET,
        COMPARE_AND_SET,
        COMPARE_AND_EXCHANGE,
        GET_AND_UPDATE,
        GET_AND_UPDATE_BITWISE,
        GET_AND_UPDATE_NUMERIC;

        MethodType accessModeType(Class<?> receiver, Class<?> value, Class<?>... intermediate) {
            switch (AnonymousClass1.$SwitchMap$java$lang$invoke$VarHandle$AccessType[ordinal()]) {
                case 1:
                    Class<?>[] ps = allocateParameters(0, receiver, intermediate);
                    fillParameters(ps, receiver, intermediate);
                    return MethodType.methodType(value, ps);
                case 2:
                    Class<?>[] ps2 = allocateParameters(1, receiver, intermediate);
                    ps2[fillParameters(ps2, receiver, intermediate)] = value;
                    return MethodType.methodType(Void.TYPE, ps2);
                case 3:
                    Class<?>[] ps3 = allocateParameters(2, receiver, intermediate);
                    int i10 = fillParameters(ps3, receiver, intermediate);
                    ps3[i10] = value;
                    ps3[i10 + 1] = value;
                    return MethodType.methodType(Boolean.TYPE, ps3);
                case 4:
                    Class<?>[] ps4 = allocateParameters(2, receiver, intermediate);
                    int i11 = fillParameters(ps4, receiver, intermediate);
                    ps4[i11] = value;
                    ps4[i11 + 1] = value;
                    return MethodType.methodType(value, ps4);
                case 5:
                case 6:
                case 7:
                    Class<?>[] ps5 = allocateParameters(1, receiver, intermediate);
                    ps5[fillParameters(ps5, receiver, intermediate)] = value;
                    return MethodType.methodType(value, ps5);
                default:
                    throw new InternalError("Unknown AccessType");
            }
        }

        private static Class<?>[] allocateParameters(int values, Class<?> receiver, Class<?>... intermediate) {
            int size = (receiver != null ? 1 : 0) + intermediate.length + values;
            return new Class[size];
        }

        private static int fillParameters(Class<?>[] ps, Class<?> receiver, Class<?>... intermediate) {
            int i10 = 0;
            if (receiver != null) {
                int i11 = 0 + 1;
                ps[0] = receiver;
                i10 = i11;
            }
            int j10 = 0;
            while (j10 < intermediate.length) {
                ps[i10] = intermediate[j10];
                j10++;
                i10++;
            }
            return i10;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum AccessMode {
        GET(MonitorConstants.CONNECT_TYPE_GET, AccessType.GET),
        SET("set", AccessType.SET),
        GET_VOLATILE("getVolatile", AccessType.GET),
        SET_VOLATILE("setVolatile", AccessType.SET),
        GET_ACQUIRE("getAcquire", AccessType.GET),
        SET_RELEASE("setRelease", AccessType.SET),
        GET_OPAQUE("getOpaque", AccessType.GET),
        SET_OPAQUE("setOpaque", AccessType.SET),
        COMPARE_AND_SET("compareAndSet", AccessType.COMPARE_AND_SET),
        COMPARE_AND_EXCHANGE("compareAndExchange", AccessType.COMPARE_AND_EXCHANGE),
        COMPARE_AND_EXCHANGE_ACQUIRE("compareAndExchangeAcquire", AccessType.COMPARE_AND_EXCHANGE),
        COMPARE_AND_EXCHANGE_RELEASE("compareAndExchangeRelease", AccessType.COMPARE_AND_EXCHANGE),
        WEAK_COMPARE_AND_SET_PLAIN("weakCompareAndSetPlain", AccessType.COMPARE_AND_SET),
        WEAK_COMPARE_AND_SET("weakCompareAndSet", AccessType.COMPARE_AND_SET),
        WEAK_COMPARE_AND_SET_ACQUIRE("weakCompareAndSetAcquire", AccessType.COMPARE_AND_SET),
        WEAK_COMPARE_AND_SET_RELEASE("weakCompareAndSetRelease", AccessType.COMPARE_AND_SET),
        GET_AND_SET("getAndSet", AccessType.GET_AND_UPDATE),
        GET_AND_SET_ACQUIRE("getAndSetAcquire", AccessType.GET_AND_UPDATE),
        GET_AND_SET_RELEASE("getAndSetRelease", AccessType.GET_AND_UPDATE),
        GET_AND_ADD("getAndAdd", AccessType.GET_AND_UPDATE_NUMERIC),
        GET_AND_ADD_ACQUIRE("getAndAddAcquire", AccessType.GET_AND_UPDATE_NUMERIC),
        GET_AND_ADD_RELEASE("getAndAddRelease", AccessType.GET_AND_UPDATE_NUMERIC),
        GET_AND_BITWISE_OR("getAndBitwiseOr", AccessType.GET_AND_UPDATE_BITWISE),
        GET_AND_BITWISE_OR_RELEASE("getAndBitwiseOrRelease", AccessType.GET_AND_UPDATE_BITWISE),
        GET_AND_BITWISE_OR_ACQUIRE("getAndBitwiseOrAcquire", AccessType.GET_AND_UPDATE_BITWISE),
        GET_AND_BITWISE_AND("getAndBitwiseAnd", AccessType.GET_AND_UPDATE_BITWISE),
        GET_AND_BITWISE_AND_RELEASE("getAndBitwiseAndRelease", AccessType.GET_AND_UPDATE_BITWISE),
        GET_AND_BITWISE_AND_ACQUIRE("getAndBitwiseAndAcquire", AccessType.GET_AND_UPDATE_BITWISE),
        GET_AND_BITWISE_XOR("getAndBitwiseXor", AccessType.GET_AND_UPDATE_BITWISE),
        GET_AND_BITWISE_XOR_RELEASE("getAndBitwiseXorRelease", AccessType.GET_AND_UPDATE_BITWISE),
        GET_AND_BITWISE_XOR_ACQUIRE("getAndBitwiseXorAcquire", AccessType.GET_AND_UPDATE_BITWISE);

        static final Map<String, AccessMode> methodNameToAccessMode;
        final AccessType at;
        final String methodName;

        static {
            AccessMode[] values = values();
            int initialCapacity = ((int) (values.length / 0.75f)) + 1;
            methodNameToAccessMode = new HashMap(initialCapacity);
            for (AccessMode am : values) {
                methodNameToAccessMode.put(am.methodName, am);
            }
        }

        AccessMode(String methodName, AccessType at) {
            this.methodName = methodName;
            this.at = at;
        }

        public String methodName() {
            return this.methodName;
        }

        public static AccessMode valueFromMethodName(String methodName) {
            AccessMode am = methodNameToAccessMode.get(methodName);
            if (am != null) {
                return am;
            }
            throw new IllegalArgumentException("No AccessMode value for method name " + methodName);
        }
    }

    public final Class<?> varType() {
        return this.varType;
    }

    public final List<Class<?>> coordinateTypes() {
        Class<?> cls = this.coordinateType0;
        if (cls == null) {
            return Collections.EMPTY_LIST;
        }
        Class<?> cls2 = this.coordinateType1;
        if (cls2 == null) {
            return Collections.singletonList(cls);
        }
        return Collections.unmodifiableList(Arrays.asList(cls, cls2));
    }

    public final MethodType accessModeType(AccessMode accessMode) {
        if (this.coordinateType1 == null) {
            return accessMode.at.accessModeType(this.coordinateType0, this.varType, new Class[0]);
        }
        return accessMode.at.accessModeType(this.coordinateType0, this.varType, this.coordinateType1);
    }

    public final boolean isAccessModeSupported(AccessMode accessMode) {
        int testBit = 1 << accessMode.ordinal();
        return (this.accessModesBitMask & testBit) == testBit;
    }

    public final MethodHandle toMethodHandle(AccessMode accessMode) {
        MethodType type = accessModeType(accessMode);
        return MethodHandles.varHandleExactInvoker(accessMode, type).bindTo(this);
    }

    public static void fullFence() {
        UNSAFE.fullFence();
    }

    public static void acquireFence() {
        UNSAFE.loadFence();
    }

    public static void releaseFence() {
        UNSAFE.storeFence();
    }

    public static void loadLoadFence() {
        UNSAFE.loadFence();
    }

    public static void storeStoreFence() {
        UNSAFE.storeFence();
    }

    VarHandle(Class<?> varType, boolean isFinal) {
        this.varType = (Class) Objects.requireNonNull(varType);
        this.coordinateType0 = null;
        this.coordinateType1 = null;
        this.accessModesBitMask = alignedAccessModesBitMask(varType, isFinal);
    }

    VarHandle(Class<?> varType, boolean isFinal, Class<?> coordinateType) {
        this.varType = (Class) Objects.requireNonNull(varType);
        this.coordinateType0 = (Class) Objects.requireNonNull(coordinateType);
        this.coordinateType1 = null;
        this.accessModesBitMask = alignedAccessModesBitMask(varType, isFinal);
    }

    VarHandle(Class<?> varType, Class<?> backingArrayType, boolean isFinal, Class<?> coordinateType0, Class<?> coordinateType1) {
        this.varType = (Class) Objects.requireNonNull(varType);
        this.coordinateType0 = (Class) Objects.requireNonNull(coordinateType0);
        this.coordinateType1 = (Class) Objects.requireNonNull(coordinateType1);
        Objects.requireNonNull(backingArrayType);
        Class<?> backingArrayComponentType = backingArrayType.getComponentType();
        if (backingArrayComponentType != varType && backingArrayComponentType != Byte.TYPE) {
            throw new InternalError("Unsupported backingArrayType: " + ((Object) backingArrayType));
        }
        if (backingArrayType.getComponentType() == varType) {
            this.accessModesBitMask = alignedAccessModesBitMask(varType, isFinal);
        } else {
            this.accessModesBitMask = unalignedAccessModesBitMask(varType);
        }
    }

    static int accessTypesToBitMask(EnumSet<AccessType> accessTypes) {
        int m10 = 0;
        for (AccessMode accessMode : AccessMode.values()) {
            if (accessTypes.contains(accessMode.at)) {
                m10 |= 1 << accessMode.ordinal();
            }
        }
        return m10;
    }

    static int alignedAccessModesBitMask(Class<?> varType, boolean isFinal) {
        int bitMask = ALL_MODES_BIT_MASK;
        if (isFinal) {
            bitMask &= READ_ACCESS_MODES_BIT_MASK;
        }
        if (varType != Byte.TYPE && varType != Short.TYPE && varType != Character.TYPE && varType != Integer.TYPE && varType != Long.TYPE && varType != Float.TYPE && varType != Double.TYPE) {
            bitMask &= ~NUMERIC_ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK;
        }
        if (varType != Boolean.TYPE && varType != Byte.TYPE && varType != Short.TYPE && varType != Character.TYPE && varType != Integer.TYPE && varType != Long.TYPE) {
            return bitMask & (~BITWISE_ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK);
        }
        return bitMask;
    }

    static int unalignedAccessModesBitMask(Class<?> varType) {
        int bitMask = READ_ACCESS_MODES_BIT_MASK | WRITE_ACCESS_MODES_BIT_MASK;
        if (varType == Integer.TYPE || varType == Long.TYPE || varType == Float.TYPE || varType == Double.TYPE) {
            bitMask |= ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK;
        }
        if (varType == Integer.TYPE || varType == Long.TYPE) {
            bitMask |= NUMERIC_ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK;
        }
        if (varType == Integer.TYPE || varType == Long.TYPE) {
            return bitMask | BITWISE_ATOMIC_UPDATE_ACCESS_MODES_BIT_MASK;
        }
        return bitMask;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class VarHandleDesc extends DynamicConstantDesc<VarHandle> {
        private final ClassDesc declaringClass;
        private final Kind kind;
        private final ClassDesc varType;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public enum Kind {
            FIELD(ConstantDescs.BSM_VARHANDLE_FIELD),
            STATIC_FIELD(ConstantDescs.BSM_VARHANDLE_STATIC_FIELD),
            ARRAY(ConstantDescs.BSM_VARHANDLE_ARRAY);

            final DirectMethodHandleDesc bootstrapMethod;

            Kind(DirectMethodHandleDesc bootstrapMethod) {
                this.bootstrapMethod = bootstrapMethod;
            }

            ConstantDesc[] toBSMArgs(ClassDesc declaringClass, ClassDesc varType) {
                switch (AnonymousClass1.$SwitchMap$java$lang$invoke$VarHandle$VarHandleDesc$Kind[ordinal()]) {
                    case 1:
                    case 2:
                        return new ConstantDesc[]{declaringClass, varType};
                    case 3:
                        return new ConstantDesc[]{declaringClass};
                    default:
                        throw new InternalError("Cannot reach here");
                }
            }
        }

        private VarHandleDesc(Kind kind, String name, ClassDesc declaringClass, ClassDesc varType) {
            super(kind.bootstrapMethod, name, ConstantDescs.CD_VarHandle, kind.toBSMArgs(declaringClass, varType));
            this.kind = kind;
            this.declaringClass = declaringClass;
            this.varType = varType;
        }

        public static VarHandleDesc ofField(ClassDesc declaringClass, String name, ClassDesc fieldType) {
            Objects.requireNonNull(declaringClass);
            Objects.requireNonNull(name);
            Objects.requireNonNull(fieldType);
            return new VarHandleDesc(Kind.FIELD, name, declaringClass, fieldType);
        }

        public static VarHandleDesc ofStaticField(ClassDesc declaringClass, String name, ClassDesc fieldType) {
            Objects.requireNonNull(declaringClass);
            Objects.requireNonNull(name);
            Objects.requireNonNull(fieldType);
            return new VarHandleDesc(Kind.STATIC_FIELD, name, declaringClass, fieldType);
        }

        public static VarHandleDesc ofArray(ClassDesc arrayClass) {
            Objects.requireNonNull(arrayClass);
            if (!arrayClass.isArray()) {
                throw new IllegalArgumentException("Array class argument not an array: " + ((Object) arrayClass));
            }
            return new VarHandleDesc(Kind.ARRAY, "_", arrayClass, arrayClass.componentType());
        }

        public ClassDesc varType() {
            return this.varType;
        }

        @Override // java.lang.constant.DynamicConstantDesc, java.lang.constant.ConstantDesc
        public VarHandle resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
            switch (AnonymousClass1.$SwitchMap$java$lang$invoke$VarHandle$VarHandleDesc$Kind[this.kind.ordinal()]) {
                case 1:
                    return lookup.findVarHandle((Class) this.declaringClass.resolveConstantDesc(lookup), constantName(), (Class) this.varType.resolveConstantDesc(lookup));
                case 2:
                    return lookup.findStaticVarHandle((Class) this.declaringClass.resolveConstantDesc(lookup), constantName(), (Class) this.varType.resolveConstantDesc(lookup));
                case 3:
                    return MethodHandles.arrayElementVarHandle((Class) this.declaringClass.resolveConstantDesc(lookup));
                default:
                    throw new InternalError("Cannot reach here");
            }
        }

        @Override // java.lang.constant.DynamicConstantDesc
        public String toString() {
            switch (AnonymousClass1.$SwitchMap$java$lang$invoke$VarHandle$VarHandleDesc$Kind[this.kind.ordinal()]) {
                case 1:
                case 2:
                    Object[] objArr = new Object[4];
                    objArr[0] = this.kind == Kind.STATIC_FIELD ? "static " : "";
                    objArr[1] = this.declaringClass.displayName();
                    objArr[2] = constantName();
                    objArr[3] = this.varType.displayName();
                    return String.format("VarHandleDesc[%s%s.%s:%s]", objArr);
                case 3:
                    return String.format("VarHandleDesc[%s[]]", this.declaringClass.displayName());
                default:
                    throw new InternalError("Cannot reach here");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.lang.invoke.VarHandle$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$invoke$VarHandle$AccessType;
        static final /* synthetic */ int[] $SwitchMap$java$lang$invoke$VarHandle$VarHandleDesc$Kind;

        static {
            int[] iArr = new int[VarHandleDesc.Kind.values().length];
            $SwitchMap$java$lang$invoke$VarHandle$VarHandleDesc$Kind = iArr;
            try {
                iArr[VarHandleDesc.Kind.FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$lang$invoke$VarHandle$VarHandleDesc$Kind[VarHandleDesc.Kind.STATIC_FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$lang$invoke$VarHandle$VarHandleDesc$Kind[VarHandleDesc.Kind.ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            int[] iArr2 = new int[AccessType.values().length];
            $SwitchMap$java$lang$invoke$VarHandle$AccessType = iArr2;
            try {
                iArr2[AccessType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$lang$invoke$VarHandle$AccessType[AccessType.SET.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$lang$invoke$VarHandle$AccessType[AccessType.COMPARE_AND_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$lang$invoke$VarHandle$AccessType[AccessType.COMPARE_AND_EXCHANGE.ordinal()] = 4;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$java$lang$invoke$VarHandle$AccessType[AccessType.GET_AND_UPDATE.ordinal()] = 5;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$java$lang$invoke$VarHandle$AccessType[AccessType.GET_AND_UPDATE_BITWISE.ordinal()] = 6;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$java$lang$invoke$VarHandle$AccessType[AccessType.GET_AND_UPDATE_NUMERIC.ordinal()] = 7;
            } catch (NoSuchFieldError e18) {
            }
        }
    }
}
