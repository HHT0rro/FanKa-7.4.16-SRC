package java.lang.invoke;

import dalvik.system.EmulatedStackFrame;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.invoke.Transformers;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class MethodHandle {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int IGET = 8;
    public static final int INVOKE_DIRECT = 2;
    public static final int INVOKE_INTERFACE = 4;
    public static final int INVOKE_STATIC = 3;
    public static final int INVOKE_SUPER = 1;
    public static final int INVOKE_TRANSFORM = 5;
    public static final int INVOKE_VAR_HANDLE = 6;
    public static final int INVOKE_VAR_HANDLE_EXACT = 7;
    public static final int INVOKE_VIRTUAL = 0;
    public static final int IPUT = 9;
    public static final int SGET = 10;
    public static final int SPUT = 11;
    protected final long artFieldOrMethod;
    MethodHandle asTypeCache;
    private MethodHandle cachedSpreadInvoker;
    protected final int handleKind;
    private final MethodType type;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public @interface PolymorphicSignature {
    }

    @PolymorphicSignature
    public final native Object invoke(Object... objArr) throws Throwable;

    @PolymorphicSignature
    public final native Object invokeExact(Object... objArr) throws Throwable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void invokeExactWithFrame(EmulatedStackFrame emulatedStackFrame) throws Throwable;

    /* JADX INFO: Access modifiers changed from: protected */
    public MethodHandle(long artFieldOrMethod, int handleKind, MethodType type) {
        this.artFieldOrMethod = artFieldOrMethod;
        this.handleKind = handleKind;
        this.type = type;
    }

    public MethodType type() {
        return this.type;
    }

    public Object invokeWithArguments(Object... arguments) throws Throwable {
        MethodType invocationType = MethodType.genericMethodType(arguments == null ? 0 : arguments.length);
        MethodHandle invoker = this.cachedSpreadInvoker;
        if (invoker == null || !invoker.type().equals((Object) invocationType)) {
            invoker = MethodHandles.spreadInvoker(invocationType, 0);
            this.cachedSpreadInvoker = invoker;
        }
        return (Object) invoker.invoke(asType(invocationType), arguments);
    }

    public Object invokeWithArguments(List<?> arguments) throws Throwable {
        return invokeWithArguments(arguments.toArray());
    }

    public MethodHandle asType(MethodType newType) {
        if (newType.equals((Object) this.type)) {
            return this;
        }
        MethodHandle atc = asTypeCached(newType);
        if (atc != null) {
            return atc;
        }
        return asTypeUncached(newType);
    }

    private MethodHandle asTypeCached(MethodType newType) {
        MethodHandle atc = this.asTypeCache;
        if (atc != null && newType.equals((Object) atc.type)) {
            return atc;
        }
        return null;
    }

    MethodHandle asTypeUncached(MethodType newType) {
        if (!this.type.isConvertibleTo(newType)) {
            throw new WrongMethodTypeException("cannot convert " + ((Object) this) + " to " + ((Object) newType));
        }
        Transformers.AsTypeAdapter asTypeAdapter = new Transformers.AsTypeAdapter(this, newType);
        this.asTypeCache = asTypeAdapter;
        return asTypeAdapter;
    }

    public MethodHandle asSpreader(Class<?> arrayType, int arrayLength) {
        return asSpreader(type().parameterCount() - arrayLength, arrayType, arrayLength);
    }

    public MethodHandle asSpreader(int spreadArgPos, Class<?> arrayType, int arrayLength) {
        MethodType postSpreadType = asSpreaderChecks(arrayType, spreadArgPos, arrayLength);
        int spreadEnd = spreadArgPos + arrayLength;
        MethodType adapterType = postSpreadType.replaceParameterTypes(spreadArgPos, spreadEnd, arrayType);
        return new Transformers.Spreader(asType(postSpreadType), adapterType, spreadArgPos, arrayLength);
    }

    private MethodType asSpreaderChecks(Class<?> arrayType, int pos, int arrayLength) {
        spreadArrayChecks(arrayType, arrayLength);
        int nargs = type().parameterCount();
        if (nargs < arrayLength || arrayLength < 0) {
            throw MethodHandleStatics.newIllegalArgumentException("bad spread array length");
        }
        if (pos < 0 || pos + arrayLength > nargs) {
            throw MethodHandleStatics.newIllegalArgumentException("bad spread position");
        }
        Class<?> arrayElement = arrayType.getComponentType();
        MethodType mtype = type();
        boolean match = true;
        boolean fail = false;
        int i10 = pos;
        while (true) {
            if (i10 >= pos + arrayLength) {
                break;
            }
            Class<?> ptype = mtype.parameterType(i10);
            if (ptype != arrayElement) {
                match = false;
                if (!MethodType.canConvert(arrayElement, ptype)) {
                    fail = true;
                    break;
                }
            }
            i10++;
        }
        if (match) {
            return mtype;
        }
        MethodType needType = mtype.asSpreaderType(arrayType, pos, arrayLength);
        if (!fail) {
            return needType;
        }
        asType(needType);
        throw MethodHandleStatics.newInternalError("should not return");
    }

    private void spreadArrayChecks(Class<?> arrayType, int arrayLength) {
        Class<?> arrayElement = arrayType.getComponentType();
        if (arrayElement == null) {
            throw MethodHandleStatics.newIllegalArgumentException("not an array type", arrayType);
        }
        if ((arrayLength & 127) != arrayLength) {
            if ((arrayLength & 255) != arrayLength) {
                throw MethodHandleStatics.newIllegalArgumentException("array length is not legal", Integer.valueOf(arrayLength));
            }
            if (arrayElement == Long.TYPE || arrayElement == Double.TYPE) {
                throw MethodHandleStatics.newIllegalArgumentException("array length is not legal for long[] or double[]", Integer.valueOf(arrayLength));
            }
        }
    }

    public MethodHandle withVarargs(boolean makeVarargs) {
        if (makeVarargs) {
            return asVarargsCollector(type().lastParameterType());
        }
        return this;
    }

    public MethodHandle asCollector(Class<?> arrayType, int arrayLength) {
        return asCollector(type().parameterCount() - 1, arrayType, arrayLength);
    }

    public MethodHandle asCollector(int collectArgPos, Class<?> arrayType, int arrayLength) {
        asCollectorChecks(arrayType, collectArgPos, arrayLength);
        return new Transformers.Collector(this, arrayType, collectArgPos, arrayLength);
    }

    boolean asCollectorChecks(Class<?> arrayType, int pos, int arrayLength) {
        spreadArrayChecks(arrayType, arrayLength);
        int nargs = type().parameterCount();
        if (pos < 0 || pos >= nargs) {
            throw MethodHandleStatics.newIllegalArgumentException("bad collect position");
        }
        if (nargs != 0) {
            Class<?> param = type().parameterType(pos);
            if (param == arrayType) {
                return true;
            }
            if (param.isAssignableFrom(arrayType)) {
                return false;
            }
        }
        throw MethodHandleStatics.newIllegalArgumentException("array type not assignable to argument", this, arrayType);
    }

    public MethodHandle asVarargsCollector(Class<?> arrayType) {
        Objects.requireNonNull(arrayType);
        boolean lastMatch = asCollectorChecks(arrayType, type().parameterCount() - 1, 0);
        if (isVarargsCollector() && lastMatch) {
            return this;
        }
        return new Transformers.VarargsCollector(this);
    }

    public boolean isVarargsCollector() {
        return false;
    }

    public MethodHandle asFixedArity() {
        if (!isVarargsCollector()) {
            return this;
        }
        return ((Transformers.VarargsCollector) this).asFixedArity();
    }

    public MethodHandle bindTo(Object x10) {
        return new Transformers.BindTo(this, this.type.leadingReferenceParameter().cast(x10));
    }

    public String toString() {
        return standardString();
    }

    String standardString() {
        return "MethodHandle" + ((Object) this.type);
    }

    public int getHandleKind() {
        int i10 = this.handleKind;
        if (i10 == 7 || i10 == 6) {
            return 0;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void transform(EmulatedStackFrame arguments) throws Throwable {
        throw new AssertionError((Object) "MethodHandle.transform should never be called.");
    }

    protected MethodHandle duplicate() {
        try {
            return (MethodHandle) clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError((Object) "Subclass of Transformer is not cloneable");
        }
    }

    private void transformInternal(EmulatedStackFrame arguments) throws Throwable {
        transform(arguments);
    }
}
