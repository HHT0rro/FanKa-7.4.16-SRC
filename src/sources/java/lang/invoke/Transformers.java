package java.lang.invoke;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import dalvik.system.EmulatedStackFrame;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import sun.invoke.util.Wrapper;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Transformers {
    private static final Method TRANSFORM_INTERNAL;

    private Transformers() {
    }

    static {
        try {
            TRANSFORM_INTERNAL = MethodHandle.class.getDeclaredMethod("transformInternal", EmulatedStackFrame.class);
        } catch (NoSuchMethodException e2) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Transformer extends MethodHandle implements Cloneable {
        protected Transformer(MethodType type) {
            super(Transformers.TRANSFORM_INTERNAL.getArtMethod(), 5, type);
        }

        protected Transformer(MethodType type, int invokeKind) {
            super(Transformers.TRANSFORM_INTERNAL.getArtMethod(), invokeKind, type);
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        protected static void invokeFromTransform(MethodHandle target, EmulatedStackFrame stackFrame) throws Throwable {
            if (target instanceof Transformer) {
                ((Transformer) target).transform(stackFrame);
            } else {
                MethodHandle adaptedTarget = target.asType(stackFrame.getMethodType());
                adaptedTarget.invokeExactWithFrame(stackFrame);
            }
        }

        protected void invokeExactFromTransform(MethodHandle target, EmulatedStackFrame stackFrame) throws Throwable {
            if (target instanceof Transformer) {
                ((Transformer) target).transform(stackFrame);
            } else {
                target.invokeExactWithFrame(stackFrame);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class AlwaysThrow extends Transformer {
        private final Class<? extends Throwable> exceptionType;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AlwaysThrow(Class<?> nominalReturnType, Class<? extends Throwable> exType) {
            super(MethodType.methodType(nominalReturnType, exType));
            this.exceptionType = exType;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            throw ((Throwable) emulatedStackFrame.getReference(0, this.exceptionType));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DropArguments extends Transformer {
        private final MethodHandle delegate;
        private final EmulatedStackFrame.Range range1;
        private final EmulatedStackFrame.Range range2;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DropArguments(MethodType type, MethodHandle delegate, int startPos, int numDropped) {
            super(type);
            this.delegate = delegate;
            this.range1 = EmulatedStackFrame.Range.of(type, 0, startPos);
            this.range2 = EmulatedStackFrame.Range.from(type, startPos + numDropped);
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame calleeFrame = EmulatedStackFrame.create(this.delegate.type());
            emulatedStackFrame.copyRangeTo(calleeFrame, this.range1, 0, 0);
            emulatedStackFrame.copyRangeTo(calleeFrame, this.range2, this.range1.numReferences, this.range1.numBytes);
            invokeFromTransform(this.delegate, calleeFrame);
            calleeFrame.copyReturnValueTo(emulatedStackFrame);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class CatchException extends Transformer {
        private final Class<?> exType;
        private final MethodHandle handler;
        private final EmulatedStackFrame.Range handlerArgsRange;
        private final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CatchException(MethodHandle target, MethodHandle handler, Class<?> exType) {
            super(target.type());
            this.target = target;
            this.handler = handler;
            this.exType = exType;
            this.handlerArgsRange = EmulatedStackFrame.Range.of(target.type(), 0, handler.type().parameterCount() - 1);
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            try {
                invokeFromTransform(this.target, emulatedStackFrame);
            } catch (Throwable th) {
                if (th.getClass() == this.exType) {
                    EmulatedStackFrame fallback = EmulatedStackFrame.create(this.handler.type());
                    fallback.setReference(0, th);
                    emulatedStackFrame.copyRangeTo(fallback, this.handlerArgsRange, 1, 0);
                    invokeFromTransform(this.handler, fallback);
                    fallback.copyReturnValueTo(emulatedStackFrame);
                    return;
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class TryFinally extends Transformer {
        private final MethodHandle cleanup;
        private final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TryFinally(MethodHandle target, MethodHandle cleanup) {
            super(target.type());
            this.target = target;
            this.cleanup = cleanup;
        }

        @Override // java.lang.invoke.MethodHandle
        protected void transform(EmulatedStackFrame callerFrame) throws Throwable {
            try {
                invokeExactFromTransform(this.target, callerFrame);
                EmulatedStackFrame cleanupFrame = prepareCleanupFrame(callerFrame, null);
                invokeExactFromTransform(this.cleanup, cleanupFrame);
                if (this.cleanup.type().returnType() != Void.TYPE) {
                    cleanupFrame.copyReturnValueTo(callerFrame);
                }
            } catch (Throwable t2) {
                try {
                    throw t2;
                } catch (Throwable t10) {
                    EmulatedStackFrame cleanupFrame2 = prepareCleanupFrame(callerFrame, t2);
                    invokeExactFromTransform(this.cleanup, cleanupFrame2);
                    if (this.cleanup.type().returnType() != Void.TYPE) {
                        cleanupFrame2.copyReturnValueTo(callerFrame);
                    }
                    throw t10;
                }
            }
        }

        private EmulatedStackFrame prepareCleanupFrame(EmulatedStackFrame callerFrame, Throwable throwable) {
            EmulatedStackFrame cleanupFrame = EmulatedStackFrame.create(this.cleanup.type());
            EmulatedStackFrame.StackFrameWriter cleanupWriter = new EmulatedStackFrame.StackFrameWriter();
            cleanupWriter.attach(cleanupFrame);
            cleanupWriter.putNextReference(throwable, Throwable.class);
            int added = 1;
            Class<?> targetReturnType = this.target.type().returnType();
            EmulatedStackFrame.StackFrameReader targetReader = new EmulatedStackFrame.StackFrameReader();
            targetReader.attach(callerFrame);
            if (targetReturnType != Void.TYPE) {
                targetReader.makeReturnValueAccessor();
                EmulatedStackFrame.StackFrameAccessor.copyNext(targetReader, cleanupWriter, targetReturnType);
                added = 1 + 1;
                targetReader.attach(callerFrame);
            }
            Class<?>[] cleanupTypes = this.cleanup.type().parameterArray();
            while (added != cleanupTypes.length) {
                EmulatedStackFrame.StackFrameAccessor.copyNext(targetReader, cleanupWriter, cleanupTypes[added]);
                added++;
            }
            return cleanupFrame;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class GuardWithTest extends Transformer {
        private final MethodHandle fallback;
        private final MethodHandle target;
        private final MethodHandle test;
        private final EmulatedStackFrame.Range testArgsRange;

        /* JADX INFO: Access modifiers changed from: package-private */
        public GuardWithTest(MethodHandle test, MethodHandle target, MethodHandle fallback) {
            super(target.type());
            this.test = test;
            this.target = target;
            this.fallback = fallback;
            this.testArgsRange = EmulatedStackFrame.Range.of(target.type(), 0, test.type().parameterCount());
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame testFrame = EmulatedStackFrame.create(this.test.type());
            emulatedStackFrame.copyRangeTo(testFrame, this.testArgsRange, 0, 0);
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(testFrame);
            reader.makeReturnValueAccessor();
            invokeFromTransform(this.test, testFrame);
            boolean testResult = reader.nextBoolean();
            if (testResult) {
                invokeFromTransform(this.target, emulatedStackFrame);
            } else {
                invokeFromTransform(this.fallback, emulatedStackFrame);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ReferenceArrayElementGetter extends Transformer {
        private final Class<?> arrayClass;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReferenceArrayElementGetter(Class<?> arrayClass) {
            super(MethodType.methodType(arrayClass.getComponentType(), (Class<?>[]) new Class[]{arrayClass, Integer.TYPE}));
            this.arrayClass = arrayClass;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(emulatedStackFrame);
            Object[] array = (Object[]) reader.nextReference(this.arrayClass);
            int index = reader.nextInt();
            EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
            writer.attach(emulatedStackFrame);
            writer.makeReturnValueAccessor();
            writer.putNextReference(array[index], this.arrayClass.getComponentType());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class ReferenceArrayElementSetter extends Transformer {
        private final Class<?> arrayClass;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReferenceArrayElementSetter(Class<?> arrayClass) {
            super(MethodType.methodType(Void.TYPE, (Class<?>[]) new Class[]{arrayClass, Integer.TYPE, arrayClass.getComponentType()}));
            this.arrayClass = arrayClass;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(emulatedStackFrame);
            Object[] array = (Object[]) reader.nextReference(this.arrayClass);
            int index = reader.nextInt();
            Object value = reader.nextReference(this.arrayClass.getComponentType());
            array[index] = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ReferenceIdentity extends Transformer {
        private final Class<?> type;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReferenceIdentity(Class<?> type) {
            super(MethodType.methodType(type, type));
            this.type = type;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(emulatedStackFrame);
            EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
            writer.attach(emulatedStackFrame);
            writer.makeReturnValueAccessor();
            writer.putNextReference(reader.nextReference(this.type), this.type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ZeroValue extends Transformer {
        public ZeroValue(Class<?> type) {
            super(MethodType.methodType(type));
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class ArrayConstructor extends Transformer {
        private final Class<?> componentType;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ArrayConstructor(Class<?> arrayType) {
            super(MethodType.methodType(arrayType, Integer.TYPE));
            this.componentType = arrayType.getComponentType();
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(emulatedStackFrame);
            int length = reader.nextInt();
            Object array = Array.newInstance(this.componentType, length);
            emulatedStackFrame.setReturnValueTo(array);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class ArrayLength extends Transformer {
        private final Class<?> arrayType;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ArrayLength(Class<?> arrayType) {
            super(MethodType.methodType(Integer.TYPE, arrayType));
            this.arrayType = arrayType;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            int length;
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(emulatedStackFrame);
            Object arrayObject = reader.nextReference(this.arrayType);
            switch (Wrapper.basicTypeChar(this.arrayType.getComponentType())) {
                case 'B':
                    length = ((byte[]) arrayObject).length;
                    break;
                case 'C':
                    length = ((char[]) arrayObject).length;
                    break;
                case 'D':
                    length = ((double[]) arrayObject).length;
                    break;
                case 'F':
                    length = ((float[]) arrayObject).length;
                    break;
                case 'I':
                    length = ((int[]) arrayObject).length;
                    break;
                case 'J':
                    length = ((long[]) arrayObject).length;
                    break;
                case 'L':
                    length = ((Object[]) arrayObject).length;
                    break;
                case 'S':
                    length = ((short[]) arrayObject).length;
                    break;
                case 'Z':
                    length = ((boolean[]) arrayObject).length;
                    break;
                default:
                    throw new IllegalStateException("Unsupported type: " + ((Object) this.arrayType));
            }
            EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
            writer.attach(emulatedStackFrame).makeReturnValueAccessor();
            writer.putNextInt(length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Construct extends Transformer {
        private final EmulatedStackFrame.Range callerRange;
        private final MethodHandle constructorHandle;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Construct(MethodHandle constructorHandle, MethodType returnedType) {
            super(returnedType);
            this.constructorHandle = constructorHandle;
            this.callerRange = EmulatedStackFrame.Range.all(type());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public MethodHandle getConstructorHandle() {
            return this.constructorHandle;
        }

        private static boolean isAbstract(Class<?> klass) {
            return (klass.getModifiers() & 1024) == 1024;
        }

        private static void checkInstantiable(Class<?> klass) throws InstantiationException {
            if (isAbstract(klass)) {
                String s2 = klass.isInterface() ? "interface " : "abstract class ";
                throw new InstantiationException("Can't instantiate " + s2 + ((Object) klass));
            }
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            Class<?> receiverType = this.constructorHandle.type().parameterType(0);
            checkInstantiable(receiverType);
            Object receiver = Unsafe.getUnsafe().allocateInstance(receiverType);
            EmulatedStackFrame constructorFrame = EmulatedStackFrame.create(this.constructorHandle.type());
            constructorFrame.setReference(0, receiver);
            emulatedStackFrame.copyRangeTo(constructorFrame, this.callerRange, 1, 0);
            invokeExactFromTransform(this.constructorHandle, constructorFrame);
            emulatedStackFrame.setReturnValueTo(receiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class BindTo extends Transformer {
        private final MethodHandle delegate;
        private final EmulatedStackFrame.Range range;
        private final Object receiver;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BindTo(MethodHandle delegate, Object receiver) {
            super(delegate.type().dropParameterTypes(0, 1));
            this.delegate = delegate;
            this.receiver = receiver;
            this.range = EmulatedStackFrame.Range.all(type());
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame stackFrame = EmulatedStackFrame.create(this.delegate.type());
            stackFrame.setReference(0, this.receiver);
            emulatedStackFrame.copyRangeTo(stackFrame, this.range, 1, 0);
            invokeFromTransform(this.delegate, stackFrame);
            stackFrame.copyReturnValueTo(emulatedStackFrame);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class FilterReturnValue extends Transformer {
        private final EmulatedStackFrame.Range allArgs;
        private final MethodHandle filter;
        private final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FilterReturnValue(MethodHandle target, MethodHandle filter) {
            super(MethodType.methodType(filter.type().rtype(), target.type().ptypes()));
            this.target = target;
            this.filter = filter;
            this.allArgs = EmulatedStackFrame.Range.all(type());
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(this.target.type());
            emulatedStackFrame.copyRangeTo(targetFrame, this.allArgs, 0, 0);
            invokeFromTransform(this.target, targetFrame);
            EmulatedStackFrame filterFrame = EmulatedStackFrame.create(this.filter.type());
            Class<?> filterArgumentType = this.target.type().rtype();
            if (filterArgumentType != Void.TYPE) {
                EmulatedStackFrame.StackFrameReader returnValueReader = new EmulatedStackFrame.StackFrameReader();
                returnValueReader.attach(targetFrame).makeReturnValueAccessor();
                EmulatedStackFrame.StackFrameWriter filterWriter = new EmulatedStackFrame.StackFrameWriter();
                filterWriter.attach(filterFrame);
                EmulatedStackFrame.StackFrameAccessor.copyNext(returnValueReader, filterWriter, filterArgumentType);
            }
            invokeExactFromTransform(this.filter, filterFrame);
            filterFrame.copyReturnValueTo(emulatedStackFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PermuteArguments extends Transformer {
        private final int[] reorder;
        private final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PermuteArguments(MethodType type, MethodHandle target, int[] reorder) {
            super(type);
            this.target = target;
            this.reorder = reorder;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            EmulatedStackFrame.RandomOrderStackFrameReader reader = new EmulatedStackFrame.RandomOrderStackFrameReader();
            reader.attach(emulatedStackFrame);
            EmulatedStackFrame calleeFrame = EmulatedStackFrame.create(this.target.type());
            EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
            writer.attach(calleeFrame);
            Class<?>[] ptypes = emulatedStackFrame.getMethodType().parameterArray();
            int i10 = 0;
            while (true) {
                int[] iArr = this.reorder;
                if (i10 < iArr.length) {
                    int readerIndex = iArr[i10];
                    reader.moveTo(readerIndex);
                    EmulatedStackFrame.StackFrameAccessor.copyNext(reader, writer, ptypes[readerIndex]);
                    i10++;
                } else {
                    invokeFromTransform(this.target, calleeFrame);
                    calleeFrame.copyReturnValueTo(emulatedStackFrame);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class VarargsCollector extends Transformer {
        private final Class<?> arrayType;
        final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public VarargsCollector(MethodHandle target) {
            super(target.type());
            Class<?>[] parameterTypes = target.type().ptypes();
            if (!lastParameterTypeIsAnArray(parameterTypes)) {
                throw new IllegalArgumentException("target does not have array as last parameter");
            }
            this.target = target;
            this.arrayType = parameterTypes[parameterTypes.length - 1];
        }

        private static boolean lastParameterTypeIsAnArray(Class<?>[] parameterTypes) {
            if (parameterTypes.length == 0) {
                return false;
            }
            return parameterTypes[parameterTypes.length - 1].isArray();
        }

        @Override // java.lang.invoke.MethodHandle
        public boolean isVarargsCollector() {
            return true;
        }

        @Override // java.lang.invoke.MethodHandle
        public MethodHandle asFixedArity() {
            return this.target;
        }

        @Override // java.lang.invoke.MethodHandle
        MethodHandle asTypeUncached(MethodType newType) {
            MethodType currentType = type();
            MethodHandle currentFixedArity = asFixedArity();
            if (currentType.parameterCount() == newType.parameterCount() && currentType.lastParameterType().isAssignableFrom(newType.lastParameterType())) {
                MethodHandle asType = currentFixedArity.asType(newType);
                this.asTypeCache = asType;
                return asType;
            }
            int arrayLength = (newType.parameterCount() - currentType.parameterCount()) + 1;
            if (arrayLength < 0) {
                throwWrongMethodTypeException(currentType, newType);
            }
            MethodHandle collector = null;
            try {
                collector = currentFixedArity.asCollector(this.arrayType, arrayLength).asType(newType);
            } catch (IllegalArgumentException e2) {
                throwWrongMethodTypeException(currentType, newType);
            }
            this.asTypeCache = collector;
            return collector;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame callerFrame) throws Throwable {
            MethodType callerFrameType = callerFrame.getMethodType();
            Class<?>[] callerPTypes = callerFrameType.ptypes();
            Class<?>[] targetPTypes = type().ptypes();
            int lastTargetIndex = targetPTypes.length - 1;
            if (callerPTypes.length == targetPTypes.length && targetPTypes[lastTargetIndex].isAssignableFrom(callerPTypes[lastTargetIndex])) {
                invokeFromTransform(this.target, callerFrame);
                return;
            }
            if (callerPTypes.length < targetPTypes.length - 1) {
                throwWrongMethodTypeException(callerFrameType, type());
            }
            if (!MethodType.canConvert(type().rtype(), callerFrameType.rtype())) {
                throwWrongMethodTypeException(callerFrameType, type());
            }
            Class<?> elementType = targetPTypes[lastTargetIndex].getComponentType();
            if (!arityArgumentsConvertible(callerPTypes, lastTargetIndex, elementType)) {
                throwWrongMethodTypeException(callerFrameType, type());
            }
            MethodType targetFrameType = makeTargetFrameType(callerFrameType, type());
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(targetFrameType);
            prepareFrame(callerFrame, targetFrame);
            invokeExactFromTransform(this.target, targetFrame);
            targetFrame.copyReturnValueTo(callerFrame);
        }

        @Override // java.lang.invoke.MethodHandle
        public MethodHandle withVarargs(boolean makeVarargs) {
            return makeVarargs ? this : this.target;
        }

        private static void throwWrongMethodTypeException(MethodType from, MethodType to) {
            throw new WrongMethodTypeException("Cannot convert " + ((Object) from) + " to " + ((Object) to));
        }

        private static boolean arityArgumentsConvertible(Class<?>[] ptypes, int arityStart, Class<?> elementType) {
            if (ptypes.length - 1 == arityStart && ptypes[arityStart].isArray() && ptypes[arityStart].getComponentType() == elementType) {
                return true;
            }
            for (int i10 = arityStart; i10 < ptypes.length; i10++) {
                if (!MethodType.canConvert(ptypes[i10], elementType)) {
                    return false;
                }
            }
            return true;
        }

        private static Object referenceArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, Class<?> elementType, int offset, int length) {
            Object arityArray = Array.newInstance(elementType, length);
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                Object o10 = null;
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'B':
                        o10 = Byte.valueOf(reader.nextByte());
                        break;
                    case 'C':
                        o10 = Character.valueOf(reader.nextChar());
                        break;
                    case 'D':
                        o10 = Double.valueOf(reader.nextDouble());
                        break;
                    case 'F':
                        o10 = Float.valueOf(reader.nextFloat());
                        break;
                    case 'I':
                        o10 = Integer.valueOf(reader.nextInt());
                        break;
                    case 'J':
                        o10 = Long.valueOf(reader.nextLong());
                        break;
                    case 'L':
                        o10 = reader.nextReference(argumentType);
                        break;
                    case 'S':
                        o10 = Short.valueOf(reader.nextShort());
                        break;
                    case 'Z':
                        o10 = Boolean.valueOf(reader.nextBoolean());
                        break;
                }
                Array.set(arityArray, i10, elementType.cast(o10));
            }
            return arityArray;
        }

        private static Object intArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, int offset, int length) {
            int[] arityArray = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'B':
                        arityArray[i10] = reader.nextByte();
                        break;
                    case 'I':
                        arityArray[i10] = reader.nextInt();
                        break;
                    case 'S':
                        arityArray[i10] = reader.nextShort();
                        break;
                    default:
                        arityArray[i10] = ((Integer) reader.nextReference(argumentType)).intValue();
                        break;
                }
            }
            return arityArray;
        }

        private static Object longArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, int offset, int length) {
            long[] arityArray = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'B':
                        arityArray[i10] = reader.nextByte();
                        break;
                    case 'I':
                        arityArray[i10] = reader.nextInt();
                        break;
                    case 'J':
                        arityArray[i10] = reader.nextLong();
                        break;
                    case 'S':
                        arityArray[i10] = reader.nextShort();
                        break;
                    default:
                        arityArray[i10] = ((Long) reader.nextReference(argumentType)).longValue();
                        break;
                }
            }
            return arityArray;
        }

        private static Object byteArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, int offset, int length) {
            byte[] arityArray = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'B':
                        arityArray[i10] = reader.nextByte();
                        break;
                    default:
                        arityArray[i10] = ((Byte) reader.nextReference(argumentType)).byteValue();
                        break;
                }
            }
            return arityArray;
        }

        private static Object shortArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, int offset, int length) {
            short[] arityArray = new short[length];
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'B':
                        arityArray[i10] = reader.nextByte();
                        break;
                    case 'S':
                        arityArray[i10] = reader.nextShort();
                        break;
                    default:
                        arityArray[i10] = ((Short) reader.nextReference(argumentType)).shortValue();
                        break;
                }
            }
            return arityArray;
        }

        private static Object charArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, int offset, int length) {
            char[] arityArray = new char[length];
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'C':
                        arityArray[i10] = reader.nextChar();
                        break;
                    default:
                        arityArray[i10] = ((Character) reader.nextReference(argumentType)).charValue();
                        break;
                }
            }
            return arityArray;
        }

        private static Object booleanArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, int offset, int length) {
            boolean[] arityArray = new boolean[length];
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'Z':
                        arityArray[i10] = reader.nextBoolean();
                        break;
                    default:
                        arityArray[i10] = ((Boolean) reader.nextReference(argumentType)).booleanValue();
                        break;
                }
            }
            return arityArray;
        }

        private static Object floatArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, int offset, int length) {
            float[] arityArray = new float[length];
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'B':
                        arityArray[i10] = reader.nextByte();
                        break;
                    case 'F':
                        arityArray[i10] = reader.nextFloat();
                        break;
                    case 'I':
                        arityArray[i10] = reader.nextInt();
                        break;
                    case 'J':
                        arityArray[i10] = (float) reader.nextLong();
                        break;
                    case 'S':
                        arityArray[i10] = reader.nextShort();
                        break;
                    default:
                        arityArray[i10] = ((Float) reader.nextReference(argumentType)).floatValue();
                        break;
                }
            }
            return arityArray;
        }

        private static Object doubleArray(EmulatedStackFrame.StackFrameReader reader, Class<?>[] ptypes, int offset, int length) {
            double[] arityArray = new double[length];
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> argumentType = ptypes[i10 + offset];
                switch (Wrapper.basicTypeChar(argumentType)) {
                    case 'B':
                        arityArray[i10] = reader.nextByte();
                        break;
                    case 'D':
                        arityArray[i10] = reader.nextDouble();
                        break;
                    case 'F':
                        arityArray[i10] = reader.nextFloat();
                        break;
                    case 'I':
                        arityArray[i10] = reader.nextInt();
                        break;
                    case 'J':
                        arityArray[i10] = reader.nextLong();
                        break;
                    case 'S':
                        arityArray[i10] = reader.nextShort();
                        break;
                    default:
                        arityArray[i10] = ((Double) reader.nextReference(argumentType)).doubleValue();
                        break;
                }
            }
            return arityArray;
        }

        private static Object makeArityArray(MethodType callerFrameType, EmulatedStackFrame.StackFrameReader callerFrameReader, int indexOfArityArray, Class<?> arityArrayType) {
            int arityArrayLength = callerFrameType.ptypes().length - indexOfArityArray;
            Class<?> elementType = arityArrayType.getComponentType();
            Class<?>[] callerPTypes = callerFrameType.ptypes();
            char elementBasicType = Wrapper.basicTypeChar(elementType);
            switch (elementBasicType) {
                case 'B':
                    return byteArray(callerFrameReader, callerPTypes, indexOfArityArray, arityArrayLength);
                case 'C':
                    return charArray(callerFrameReader, callerPTypes, indexOfArityArray, arityArrayLength);
                case 'D':
                    return doubleArray(callerFrameReader, callerPTypes, indexOfArityArray, arityArrayLength);
                case 'F':
                    return floatArray(callerFrameReader, callerPTypes, indexOfArityArray, arityArrayLength);
                case 'I':
                    return intArray(callerFrameReader, callerPTypes, indexOfArityArray, arityArrayLength);
                case 'J':
                    return longArray(callerFrameReader, callerPTypes, indexOfArityArray, arityArrayLength);
                case 'L':
                    return referenceArray(callerFrameReader, callerPTypes, elementType, indexOfArityArray, arityArrayLength);
                case 'S':
                    return shortArray(callerFrameReader, callerPTypes, indexOfArityArray, arityArrayLength);
                case 'Z':
                    return booleanArray(callerFrameReader, callerPTypes, indexOfArityArray, arityArrayLength);
                default:
                    throw new InternalError("Unexpected type: " + ((Object) elementType));
            }
        }

        public static Object collectArguments(char basicComponentType, Class<?> componentType, EmulatedStackFrame.StackFrameReader reader, Class<?>[] types, int startIdx, int length) {
            switch (basicComponentType) {
                case 'B':
                    return byteArray(reader, types, startIdx, length);
                case 'C':
                    return charArray(reader, types, startIdx, length);
                case 'D':
                    return doubleArray(reader, types, startIdx, length);
                case 'F':
                    return floatArray(reader, types, startIdx, length);
                case 'I':
                    return intArray(reader, types, startIdx, length);
                case 'J':
                    return longArray(reader, types, startIdx, length);
                case 'L':
                    return referenceArray(reader, types, componentType, startIdx, length);
                case 'S':
                    return shortArray(reader, types, startIdx, length);
                case 'Z':
                    return booleanArray(reader, types, startIdx, length);
                default:
                    throw new InternalError("Unexpected type: " + basicComponentType);
            }
        }

        private static void copyParameter(EmulatedStackFrame.StackFrameReader reader, EmulatedStackFrame.StackFrameWriter writer, Class<?> ptype) {
            switch (Wrapper.basicTypeChar(ptype)) {
                case 'B':
                    writer.putNextByte(reader.nextByte());
                    return;
                case 'C':
                    writer.putNextChar(reader.nextChar());
                    return;
                case 'D':
                    writer.putNextDouble(reader.nextDouble());
                    return;
                case 'F':
                    writer.putNextFloat(reader.nextFloat());
                    return;
                case 'I':
                    writer.putNextInt(reader.nextInt());
                    return;
                case 'J':
                    writer.putNextLong(reader.nextLong());
                    return;
                case 'L':
                    writer.putNextReference(reader.nextReference(ptype), ptype);
                    return;
                case 'S':
                    writer.putNextShort(reader.nextShort());
                    return;
                case 'Z':
                    writer.putNextBoolean(reader.nextBoolean());
                    return;
                default:
                    throw new InternalError("Unexpected type: " + ((Object) ptype));
            }
        }

        private static void prepareFrame(EmulatedStackFrame callerFrame, EmulatedStackFrame targetFrame) {
            EmulatedStackFrame.StackFrameWriter targetWriter = new EmulatedStackFrame.StackFrameWriter();
            targetWriter.attach(targetFrame);
            EmulatedStackFrame.StackFrameReader callerReader = new EmulatedStackFrame.StackFrameReader();
            callerReader.attach(callerFrame);
            MethodType targetMethodType = targetFrame.getMethodType();
            int indexOfArityArray = targetMethodType.ptypes().length - 1;
            for (int i10 = 0; i10 < indexOfArityArray; i10++) {
                Class<?> ptype = targetMethodType.ptypes()[i10];
                copyParameter(callerReader, targetWriter, ptype);
            }
            Class<?> arityArrayType = targetMethodType.ptypes()[indexOfArityArray];
            Object arityArray = makeArityArray(callerFrame.getMethodType(), callerReader, indexOfArityArray, arityArrayType);
            targetWriter.putNextReference(arityArray, arityArrayType);
        }

        private static MethodType makeTargetFrameType(MethodType callerType, MethodType targetType) {
            int ptypesLength = targetType.ptypes().length;
            Class<?>[] ptypes = new Class[ptypesLength];
            System.arraycopy(callerType.ptypes(), 0, ptypes, 0, ptypesLength - 1);
            ptypes[ptypesLength - 1] = targetType.ptypes()[ptypesLength - 1];
            return MethodType.methodType(callerType.rtype(), ptypes);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Invoker extends Transformer {
        private final EmulatedStackFrame.Range copyRange;
        private final boolean isExactInvoker;
        private final MethodType targetType;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Invoker(MethodType targetType, boolean isExactInvoker) {
            super(targetType.insertParameterTypes(0, MethodHandle.class));
            this.targetType = targetType;
            this.isExactInvoker = isExactInvoker;
            this.copyRange = EmulatedStackFrame.Range.from(type(), 1);
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame emulatedStackFrame) throws Throwable {
            MethodHandle target = (MethodHandle) emulatedStackFrame.getReference(0, MethodHandle.class);
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(this.targetType);
            emulatedStackFrame.copyRangeTo(targetFrame, this.copyRange, 0, 0);
            if (this.isExactInvoker) {
                invokeExactFromTransform(target, targetFrame);
            } else {
                invokeFromTransform(target, targetFrame);
            }
            targetFrame.copyReturnValueTo(emulatedStackFrame);
        }

        private static boolean exactMatch(MethodType callsiteType, MethodType targetType) {
            int parameterCount = callsiteType.parameterCount();
            if (callsiteType.parameterCount() != targetType.parameterCount()) {
                return false;
            }
            for (int i10 = 0; i10 < parameterCount; i10++) {
                Class argumentType = callsiteType.parameterType(i10);
                Class parameterType = targetType.parameterType(i10);
                if (!exactMatch(argumentType, parameterType)) {
                    return false;
                }
            }
            return callsiteType.returnType() == Void.TYPE || exactMatch(callsiteType.returnType(), targetType.returnType());
        }

        private static boolean exactMatch(Class lhs, Class rhs) {
            return !(lhs.isPrimitive() || rhs.isPrimitive()) || lhs == rhs;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class Spreader extends Transformer {
        private final int arrayOffset;
        private final Class<?> componentType;
        private final EmulatedStackFrame.Range leadingRange;
        private final int numArrayArgs;
        private final MethodHandle target;
        private final EmulatedStackFrame.Range trailingRange;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Spreader(MethodHandle target, MethodType spreaderType, int spreadArgPos, int numArrayArgs) {
            super(spreaderType);
            this.target = target;
            this.arrayOffset = spreadArgPos;
            Class<?> componentType = spreaderType.ptypes()[spreadArgPos].getComponentType();
            this.componentType = componentType;
            if (componentType == null) {
                throw new AssertionError((Object) ("Argument " + spreadArgPos + " must be an array."));
            }
            this.numArrayArgs = numArrayArgs;
            this.leadingRange = EmulatedStackFrame.Range.of(spreaderType, 0, spreadArgPos);
            this.trailingRange = EmulatedStackFrame.Range.from(spreaderType, spreadArgPos + 1);
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame callerFrame) throws Throwable {
            Class<?> arrayType = type().parameterType(this.arrayOffset);
            Object arrayObj = callerFrame.getReference(this.arrayOffset, arrayType);
            int arrayLength = (this.numArrayArgs == 0 && arrayObj == null) ? 0 : Array.getLength(arrayObj);
            if (arrayLength != this.numArrayArgs) {
                throw new IllegalArgumentException("Invalid array length " + arrayLength + " expected " + this.numArrayArgs);
            }
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(this.target.type());
            callerFrame.copyRangeTo(targetFrame, this.leadingRange, 0, 0);
            if (this.componentType.isPrimitive()) {
                int elementBytes = EmulatedStackFrame.getSize(this.componentType);
                int spreadBytes = elementBytes * arrayLength;
                callerFrame.copyRangeTo(targetFrame, this.trailingRange, this.leadingRange.numReferences, this.leadingRange.numBytes + spreadBytes);
            } else {
                callerFrame.copyRangeTo(targetFrame, this.trailingRange, this.leadingRange.numReferences + this.numArrayArgs, this.leadingRange.numBytes);
            }
            if (arrayLength != 0) {
                EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
                writer.attach(targetFrame, this.arrayOffset, this.leadingRange.numReferences, this.leadingRange.numBytes);
                spreadArray(arrayType, arrayObj, writer);
            }
            invokeExactFromTransform(this.target, targetFrame);
            targetFrame.copyReturnValueTo(callerFrame);
        }

        private void spreadArray(Class<?> arrayType, Object arrayObj, EmulatedStackFrame.StackFrameWriter writer) {
            Class<?> componentType = arrayType.getComponentType();
            switch (Wrapper.basicTypeChar(componentType)) {
                case 'B':
                    for (byte b4 : (byte[]) arrayObj) {
                        writer.putNextByte(b4);
                    }
                    return;
                case 'C':
                    for (char c4 : (char[]) arrayObj) {
                        writer.putNextChar(c4);
                    }
                    return;
                case 'D':
                    for (double d10 : (double[]) arrayObj) {
                        writer.putNextDouble(d10);
                    }
                    return;
                case 'F':
                    for (float f10 : (float[]) arrayObj) {
                        writer.putNextFloat(f10);
                    }
                    return;
                case 'I':
                    for (int i10 : (int[]) arrayObj) {
                        writer.putNextInt(i10);
                    }
                    return;
                case 'J':
                    for (long j10 : (long[]) arrayObj) {
                        writer.putNextLong(j10);
                    }
                    return;
                case 'L':
                    for (Object obj : (Object[]) arrayObj) {
                        writer.putNextReference(obj, componentType);
                    }
                    return;
                case 'S':
                    for (short s2 : (short[]) arrayObj) {
                        writer.putNextShort(s2);
                    }
                    return;
                case 'Z':
                    boolean[] array = (boolean[]) arrayObj;
                    for (boolean z10 : array) {
                        writer.putNextBoolean(z10);
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class Collector extends Transformer {
        private final int arrayLength;
        private final int arrayOffset;
        private final Class arrayType;
        private final EmulatedStackFrame.Range leadingRange;
        private final MethodHandle target;
        private final EmulatedStackFrame.Range trailingRange;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Collector(MethodHandle delegate, Class<?> arrayType, int start, int length) {
            super(delegate.type().asCollectorType(arrayType, start, length));
            this.target = delegate;
            this.arrayOffset = start;
            this.arrayLength = length;
            this.arrayType = arrayType;
            this.leadingRange = EmulatedStackFrame.Range.of(type(), 0, start);
            this.trailingRange = EmulatedStackFrame.Range.from(type(), start + length);
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame callerFrame) throws Throwable {
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(this.target.type());
            callerFrame.copyRangeTo(targetFrame, this.leadingRange, 0, 0);
            callerFrame.copyRangeTo(targetFrame, this.trailingRange, this.leadingRange.numReferences + 1, this.leadingRange.numBytes);
            EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
            writer.attach(targetFrame, this.arrayOffset, this.leadingRange.numReferences, this.leadingRange.numBytes);
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(callerFrame, this.arrayOffset, this.leadingRange.numReferences, this.leadingRange.numBytes);
            char arrayTypeChar = Wrapper.basicTypeChar(this.arrayType.getComponentType());
            switch (arrayTypeChar) {
                case 'B':
                    byte[] array = new byte[this.arrayLength];
                    for (int i10 = 0; i10 < this.arrayLength; i10++) {
                        array[i10] = reader.nextByte();
                    }
                    writer.putNextReference(array, byte[].class);
                    break;
                case 'C':
                    char[] array2 = new char[this.arrayLength];
                    for (int i11 = 0; i11 < this.arrayLength; i11++) {
                        array2[i11] = reader.nextChar();
                    }
                    writer.putNextReference(array2, char[].class);
                    break;
                case 'D':
                    double[] array3 = new double[this.arrayLength];
                    for (int i12 = 0; i12 < this.arrayLength; i12++) {
                        array3[i12] = reader.nextDouble();
                    }
                    writer.putNextReference(array3, double[].class);
                    break;
                case 'F':
                    float[] array4 = new float[this.arrayLength];
                    for (int i13 = 0; i13 < this.arrayLength; i13++) {
                        array4[i13] = reader.nextFloat();
                    }
                    writer.putNextReference(array4, float[].class);
                    break;
                case 'I':
                    int[] array5 = new int[this.arrayLength];
                    for (int i14 = 0; i14 < this.arrayLength; i14++) {
                        array5[i14] = reader.nextInt();
                    }
                    writer.putNextReference(array5, int[].class);
                    break;
                case 'J':
                    long[] array6 = new long[this.arrayLength];
                    for (int i15 = 0; i15 < this.arrayLength; i15++) {
                        array6[i15] = reader.nextLong();
                    }
                    writer.putNextReference(array6, long[].class);
                    break;
                case 'L':
                    Class<?> targetType = this.target.type().ptypes()[this.arrayOffset];
                    Class<?> arrayComponentType = this.arrayType.getComponentType();
                    Object[] arr = (Object[]) Array.newInstance(arrayComponentType, this.arrayLength);
                    for (int i16 = 0; i16 < this.arrayLength; i16++) {
                        arr[i16] = reader.nextReference(arrayComponentType);
                    }
                    writer.putNextReference(arr, targetType);
                    break;
                case 'S':
                    short[] array7 = new short[this.arrayLength];
                    for (int i17 = 0; i17 < this.arrayLength; i17++) {
                        array7[i17] = reader.nextShort();
                    }
                    writer.putNextReference(array7, short[].class);
                    break;
                case 'Z':
                    boolean[] array8 = new boolean[this.arrayLength];
                    for (int i18 = 0; i18 < this.arrayLength; i18++) {
                        array8[i18] = reader.nextBoolean();
                    }
                    writer.putNextReference(array8, boolean[].class);
                    break;
            }
            invokeFromTransform(this.target, targetFrame);
            targetFrame.copyReturnValueTo(callerFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class FilterArguments extends Transformer {
        private final MethodHandle[] filters;
        private final int pos;
        private final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FilterArguments(MethodHandle target, int pos, MethodHandle... filters) {
            super(deriveType(target, pos, filters));
            this.target = target;
            this.pos = pos;
            this.filters = filters;
        }

        private static MethodType deriveType(MethodHandle target, int pos, MethodHandle[] filters) {
            Class<?>[] filterArgs = new Class[filters.length];
            for (int i10 = 0; i10 < filters.length; i10++) {
                filterArgs[i10] = filters[i10].type().parameterType(0);
            }
            return target.type().replaceParameterTypes(pos, filters.length + pos, filterArgs);
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame stackFrame) throws Throwable {
            MethodHandle filter;
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(stackFrame);
            EmulatedStackFrame transformedFrame = EmulatedStackFrame.create(this.target.type());
            EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
            writer.attach(transformedFrame);
            Class<?>[] ptypes = this.target.type().ptypes();
            for (int i10 = 0; i10 < ptypes.length; i10++) {
                Class<?> ptype = ptypes[i10];
                int i11 = this.pos;
                if (i10 < i11) {
                    filter = null;
                } else {
                    MethodHandle[] methodHandleArr = this.filters;
                    if (i10 >= methodHandleArr.length + i11) {
                        filter = null;
                    } else {
                        filter = methodHandleArr[i10 - i11];
                    }
                }
                if (filter != null) {
                    EmulatedStackFrame filterFrame = EmulatedStackFrame.create(filter.type());
                    EmulatedStackFrame.StackFrameWriter filterWriter = new EmulatedStackFrame.StackFrameWriter();
                    filterWriter.attach(filterFrame);
                    EmulatedStackFrame.StackFrameAccessor.copyNext(reader, filterWriter, filter.type().ptypes()[0]);
                    invokeFromTransform(filter, filterFrame);
                    EmulatedStackFrame.StackFrameReader filterReader = new EmulatedStackFrame.StackFrameReader();
                    filterReader.attach(filterFrame);
                    filterReader.makeReturnValueAccessor();
                    EmulatedStackFrame.StackFrameAccessor.copyNext(filterReader, writer, ptype);
                } else {
                    EmulatedStackFrame.StackFrameAccessor.copyNext(reader, writer, ptype);
                }
            }
            invokeFromTransform(this.target, transformedFrame);
            transformedFrame.copyReturnValueTo(stackFrame);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class CollectArguments extends Transformer {
        private final MethodHandle collector;
        private final EmulatedStackFrame.Range collectorRange;
        private final int pos;
        private final EmulatedStackFrame.Range range1;
        private final EmulatedStackFrame.Range range2;
        private final int referencesOffset;
        private final int stackFrameOffset;
        private final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CollectArguments(MethodHandle target, MethodHandle collector, int pos, MethodType adapterType) {
            super(adapterType);
            this.target = target;
            this.collector = collector;
            this.pos = pos;
            int numFilterArgs = collector.type().parameterCount();
            this.collectorRange = EmulatedStackFrame.Range.of(type(), pos, pos + numFilterArgs);
            this.range1 = EmulatedStackFrame.Range.of(type(), 0, pos);
            this.range2 = EmulatedStackFrame.Range.from(type(), pos + numFilterArgs);
            Class<?> collectorRType = collector.type().rtype();
            if (collectorRType == Void.TYPE) {
                this.stackFrameOffset = 0;
                this.referencesOffset = 0;
            } else if (collectorRType.isPrimitive()) {
                this.stackFrameOffset = EmulatedStackFrame.getSize(collectorRType);
                this.referencesOffset = 0;
            } else {
                this.stackFrameOffset = 0;
                this.referencesOffset = 1;
            }
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame stackFrame) throws Throwable {
            EmulatedStackFrame filterFrame = EmulatedStackFrame.create(this.collector.type());
            stackFrame.copyRangeTo(filterFrame, this.collectorRange, 0, 0);
            invokeFromTransform(this.collector, filterFrame);
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(this.target.type());
            stackFrame.copyRangeTo(targetFrame, this.range1, 0, 0);
            if (this.referencesOffset != 0 || this.stackFrameOffset != 0) {
                EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
                reader.attach(filterFrame).makeReturnValueAccessor();
                EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
                writer.attach(targetFrame, this.pos, this.range1.numReferences, this.range1.numBytes);
                EmulatedStackFrame.StackFrameAccessor.copyNext(reader, writer, this.target.type().ptypes()[this.pos]);
            }
            stackFrame.copyRangeTo(targetFrame, this.range2, this.range1.numReferences + this.referencesOffset, this.range1.numBytes + this.stackFrameOffset);
            invokeFromTransform(this.target, targetFrame);
            targetFrame.copyReturnValueTo(stackFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class FoldArguments extends Transformer {
        private final MethodHandle combiner;
        private final EmulatedStackFrame.Range combinerArgs;
        private final EmulatedStackFrame.Range leadingArgs;
        private final int position;
        private final int referencesOffset;
        private final int stackFrameOffset;
        private final MethodHandle target;
        private final EmulatedStackFrame.Range trailingArgs;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FoldArguments(MethodHandle target, int position, MethodHandle combiner) {
            super(deriveType(target, position, combiner));
            this.target = target;
            this.combiner = combiner;
            this.position = position;
            this.combinerArgs = EmulatedStackFrame.Range.of(type(), position, combiner.type().parameterCount() + position);
            this.leadingArgs = EmulatedStackFrame.Range.of(type(), 0, position);
            this.trailingArgs = EmulatedStackFrame.Range.from(type(), position);
            Class<?> combinerRType = combiner.type().rtype();
            if (combinerRType == Void.TYPE) {
                this.stackFrameOffset = 0;
                this.referencesOffset = 0;
            } else if (combinerRType.isPrimitive()) {
                this.stackFrameOffset = EmulatedStackFrame.getSize(combinerRType);
                this.referencesOffset = 0;
            } else {
                this.stackFrameOffset = 0;
                this.referencesOffset = 1;
            }
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame stackFrame) throws Throwable {
            EmulatedStackFrame combinerFrame = EmulatedStackFrame.create(this.combiner.type());
            stackFrame.copyRangeTo(combinerFrame, this.combinerArgs, 0, 0);
            invokeExactFromTransform(this.combiner, combinerFrame);
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(this.target.type());
            stackFrame.copyRangeTo(targetFrame, this.leadingArgs, 0, 0);
            if (this.referencesOffset != 0 || this.stackFrameOffset != 0) {
                EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
                reader.attach(combinerFrame).makeReturnValueAccessor();
                EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
                writer.attach(targetFrame, this.position, this.leadingArgs.numReferences, this.leadingArgs.numBytes);
                EmulatedStackFrame.StackFrameAccessor.copyNext(reader, writer, this.target.type().ptypes()[this.position]);
            }
            stackFrame.copyRangeTo(targetFrame, this.trailingArgs, this.leadingArgs.numReferences + this.referencesOffset, this.leadingArgs.numBytes + this.stackFrameOffset);
            invokeExactFromTransform(this.target, targetFrame);
            targetFrame.copyReturnValueTo(stackFrame);
        }

        private static MethodType deriveType(MethodHandle target, int position, MethodHandle combiner) {
            if (combiner.type().rtype() == Void.TYPE) {
                return target.type();
            }
            return target.type().dropParameterTypes(position, position + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class InsertArguments extends Transformer {
        private final int pos;
        private final EmulatedStackFrame.Range range1;
        private final EmulatedStackFrame.Range range2;
        private final MethodHandle target;
        private final Object[] values;

        /* JADX INFO: Access modifiers changed from: package-private */
        public InsertArguments(MethodHandle target, int pos, Object[] values) {
            super(target.type().dropParameterTypes(pos, values.length + pos));
            this.target = target;
            this.pos = pos;
            this.values = values;
            MethodType type = type();
            this.range1 = EmulatedStackFrame.Range.of(type, 0, pos);
            this.range2 = EmulatedStackFrame.Range.of(type, pos, type.parameterCount());
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00c1, code lost:
        
            r3 = r3 + dalvik.system.EmulatedStackFrame.getSize(r6);
         */
        @Override // java.lang.invoke.MethodHandle
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void transform(dalvik.system.EmulatedStackFrame r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.invoke.MethodHandle r0 = r10.target
                java.lang.invoke.MethodType r0 = r0.type()
                dalvik.system.EmulatedStackFrame r0 = dalvik.system.EmulatedStackFrame.create(r0)
                dalvik.system.EmulatedStackFrame$Range r1 = r10.range1
                r2 = 0
                r11.copyRangeTo(r0, r1, r2, r2)
                dalvik.system.EmulatedStackFrame$StackFrameWriter r1 = new dalvik.system.EmulatedStackFrame$StackFrameWriter
                r1.<init>()
                int r2 = r10.pos
                dalvik.system.EmulatedStackFrame$Range r3 = r10.range1
                int r3 = r3.numReferences
                dalvik.system.EmulatedStackFrame$Range r4 = r10.range1
                int r4 = r4.numBytes
                r1.attach(r0, r2, r3, r4)
                r2 = 0
                r3 = 0
                java.lang.invoke.MethodHandle r4 = r10.target
                java.lang.invoke.MethodType r4 = r4.type()
                java.lang.Class[] r4 = r4.ptypes()
                r5 = 0
            L2f:
                java.lang.Object[] r6 = r10.values
                int r6 = r6.length
                if (r5 >= r6) goto Lca
                int r6 = r10.pos
                int r6 = r6 + r5
                r6 = r4[r6]
                char r7 = sun.invoke.util.Wrapper.basicTypeChar(r6)
                r8 = 76
                if (r7 != r8) goto L4c
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                r1.putNextReference(r8, r6)
                int r2 = r2 + 1
                goto Lc6
            L4c:
                switch(r7) {
                    case 66: goto Lb3;
                    case 67: goto La5;
                    case 68: goto L97;
                    case 70: goto L89;
                    case 73: goto L7b;
                    case 74: goto L6d;
                    case 83: goto L5f;
                    case 90: goto L51;
                    default: goto L4f;
                }
            L4f:
                goto Lc1
            L51:
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                r1.putNextBoolean(r8)
                goto Lc1
            L5f:
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                java.lang.Short r8 = (java.lang.Short) r8
                short r8 = r8.shortValue()
                r1.putNextShort(r8)
                goto Lc1
            L6d:
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                java.lang.Long r8 = (java.lang.Long) r8
                long r8 = r8.longValue()
                r1.putNextLong(r8)
                goto Lc1
            L7b:
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                java.lang.Integer r8 = (java.lang.Integer) r8
                int r8 = r8.intValue()
                r1.putNextInt(r8)
                goto Lc1
            L89:
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                java.lang.Float r8 = (java.lang.Float) r8
                float r8 = r8.floatValue()
                r1.putNextFloat(r8)
                goto Lc1
            L97:
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                java.lang.Double r8 = (java.lang.Double) r8
                double r8 = r8.doubleValue()
                r1.putNextDouble(r8)
                goto Lc1
            La5:
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                java.lang.Character r8 = (java.lang.Character) r8
                char r8 = r8.charValue()
                r1.putNextChar(r8)
                goto Lc1
            Lb3:
                java.lang.Object[] r8 = r10.values
                r8 = r8[r5]
                java.lang.Byte r8 = (java.lang.Byte) r8
                byte r8 = r8.byteValue()
                r1.putNextByte(r8)
            Lc1:
                int r8 = dalvik.system.EmulatedStackFrame.getSize(r6)
                int r3 = r3 + r8
            Lc6:
                int r5 = r5 + 1
                goto L2f
            Lca:
                dalvik.system.EmulatedStackFrame$Range r5 = r10.range2
                if (r5 == 0) goto Ldb
                dalvik.system.EmulatedStackFrame$Range r6 = r10.range1
                int r6 = r6.numReferences
                int r6 = r6 + r2
                dalvik.system.EmulatedStackFrame$Range r7 = r10.range1
                int r7 = r7.numBytes
                int r7 = r7 + r3
                r11.copyRangeTo(r0, r5, r6, r7)
            Ldb:
                java.lang.invoke.MethodHandle r5 = r10.target
                invokeFromTransform(r5, r0)
                r0.copyReturnValueTo(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.lang.invoke.Transformers.InsertArguments.transform(dalvik.system.EmulatedStackFrame):void");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class AsTypeAdapter extends Transformer {
        private final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AsTypeAdapter(MethodHandle target, MethodType type) {
            super(type);
            this.target = target;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame callerFrame) throws Throwable {
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(this.target.type());
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
            reader.attach(callerFrame);
            writer.attach(targetFrame);
            adaptArguments(reader, writer);
            invokeFromTransform(this.target, targetFrame);
            if (callerFrame.getMethodType().rtype() != Void.TYPE) {
                reader.attach(targetFrame).makeReturnValueAccessor();
                writer.attach(callerFrame).makeReturnValueAccessor();
                adaptReturnValue(reader, writer);
            }
        }

        private void adaptArguments(EmulatedStackFrame.StackFrameReader reader, EmulatedStackFrame.StackFrameWriter writer) {
            Class<?>[] fromTypes = type().ptypes();
            Class<?>[] toTypes = this.target.type().ptypes();
            for (int i10 = 0; i10 < fromTypes.length; i10++) {
                adaptArgument(reader, fromTypes[i10], writer, toTypes[i10]);
            }
        }

        private void adaptReturnValue(EmulatedStackFrame.StackFrameReader reader, EmulatedStackFrame.StackFrameWriter writer) {
            Class<?> fromType = this.target.type().rtype();
            Class<?> toType = type().rtype();
            adaptArgument(reader, fromType, writer, toType);
        }

        private void throwWrongMethodTypeException() throws WrongMethodTypeException {
            throw new WrongMethodTypeException("Cannot convert from " + ((Object) type()) + " to " + ((Object) this.target.type()));
        }

        private static void throwClassCastException(Class from, Class to) throws ClassCastException {
            throw new ClassCastException("Cannot cast from " + ((Object) from) + " to " + ((Object) to));
        }

        private void writePrimitiveByteAs(EmulatedStackFrame.StackFrameWriter writer, char baseType, byte value) throws WrongMethodTypeException {
            switch (baseType) {
                case 'B':
                    writer.putNextByte(value);
                    return;
                case 'D':
                    writer.putNextDouble(value);
                    return;
                case 'F':
                    writer.putNextFloat(value);
                    return;
                case 'I':
                    writer.putNextInt(value);
                    return;
                case 'J':
                    writer.putNextLong(value);
                    return;
                case 'S':
                    writer.putNextShort(value);
                    return;
                default:
                    throwWrongMethodTypeException();
                    return;
            }
        }

        private void writePrimitiveShortAs(EmulatedStackFrame.StackFrameWriter writer, char baseType, short value) throws WrongMethodTypeException {
            switch (baseType) {
                case 'D':
                    writer.putNextDouble(value);
                    return;
                case 'F':
                    writer.putNextFloat(value);
                    return;
                case 'I':
                    writer.putNextInt(value);
                    return;
                case 'J':
                    writer.putNextLong(value);
                    return;
                case 'S':
                    writer.putNextShort(value);
                    return;
                default:
                    throwWrongMethodTypeException();
                    return;
            }
        }

        private void writePrimitiveCharAs(EmulatedStackFrame.StackFrameWriter writer, char baseType, char value) throws WrongMethodTypeException {
            switch (baseType) {
                case 'C':
                    writer.putNextChar(value);
                    return;
                case 'D':
                    writer.putNextDouble(value);
                    return;
                case 'E':
                case 'G':
                case 'H':
                default:
                    throwWrongMethodTypeException();
                    return;
                case 'F':
                    writer.putNextFloat(value);
                    return;
                case 'I':
                    writer.putNextInt(value);
                    return;
                case 'J':
                    writer.putNextLong(value);
                    return;
            }
        }

        private void writePrimitiveIntAs(EmulatedStackFrame.StackFrameWriter writer, char baseType, int value) throws WrongMethodTypeException {
            switch (baseType) {
                case 'D':
                    writer.putNextDouble(value);
                    return;
                case 'E':
                case 'G':
                case 'H':
                default:
                    throwWrongMethodTypeException();
                    throwWrongMethodTypeException();
                    return;
                case 'F':
                    writer.putNextFloat(value);
                    return;
                case 'I':
                    writer.putNextInt(value);
                    return;
                case 'J':
                    writer.putNextLong(value);
                    return;
            }
        }

        private void writePrimitiveLongAs(EmulatedStackFrame.StackFrameWriter writer, char baseType, long value) throws WrongMethodTypeException {
            switch (baseType) {
                case 'D':
                    writer.putNextDouble(value);
                    return;
                case 'F':
                    writer.putNextFloat((float) value);
                    return;
                case 'J':
                    writer.putNextLong(value);
                    return;
                default:
                    throwWrongMethodTypeException();
                    return;
            }
        }

        private void writePrimitiveFloatAs(EmulatedStackFrame.StackFrameWriter writer, char baseType, float value) throws WrongMethodTypeException {
            switch (baseType) {
                case 'D':
                    writer.putNextDouble(value);
                    return;
                case 'E':
                default:
                    throwWrongMethodTypeException();
                    return;
                case 'F':
                    writer.putNextFloat(value);
                    return;
            }
        }

        private void writePrimitiveDoubleAs(EmulatedStackFrame.StackFrameWriter writer, char baseType, double value) throws WrongMethodTypeException {
            switch (baseType) {
                case 'D':
                    writer.putNextDouble(value);
                    return;
                default:
                    throwWrongMethodTypeException();
                    return;
            }
        }

        private void writePrimitiveVoidAs(EmulatedStackFrame.StackFrameWriter writer, char baseType) {
            switch (baseType) {
                case 'B':
                    writer.putNextByte((byte) 0);
                    return;
                case 'C':
                    writer.putNextChar((char) 0);
                    return;
                case 'D':
                    writer.putNextDouble(ShadowDrawableWrapper.COS_45);
                    return;
                case 'F':
                    writer.putNextFloat(0.0f);
                    return;
                case 'I':
                    writer.putNextInt(0);
                    return;
                case 'J':
                    writer.putNextLong(0L);
                    return;
                case 'S':
                    writer.putNextShort((short) 0);
                    return;
                case 'Z':
                    writer.putNextBoolean(false);
                    return;
                default:
                    throwWrongMethodTypeException();
                    return;
            }
        }

        private static Class getBoxedPrimitiveClass(char baseType) {
            switch (baseType) {
                case 'B':
                    return Byte.class;
                case 'C':
                    return Character.class;
                case 'D':
                    return Double.class;
                case 'F':
                    return Float.class;
                case 'I':
                    return Integer.class;
                case 'J':
                    return Long.class;
                case 'S':
                    return Short.class;
                case 'Z':
                    return Boolean.class;
                default:
                    return null;
            }
        }

        private void adaptArgument(EmulatedStackFrame.StackFrameReader reader, Class<?> from, EmulatedStackFrame.StackFrameWriter writer, Class<?> to) {
            Object boxed;
            if (from.equals(to)) {
                EmulatedStackFrame.StackFrameAccessor.copyNext(reader, writer, from);
                return;
            }
            if (to.isPrimitive()) {
                if (from.isPrimitive()) {
                    char fromBaseType = Wrapper.basicTypeChar(from);
                    char toBaseType = Wrapper.basicTypeChar(to);
                    switch (fromBaseType) {
                        case 'B':
                            writePrimitiveByteAs(writer, toBaseType, reader.nextByte());
                            return;
                        case 'C':
                            writePrimitiveCharAs(writer, toBaseType, reader.nextChar());
                            return;
                        case 'F':
                            writePrimitiveFloatAs(writer, toBaseType, reader.nextFloat());
                            return;
                        case 'I':
                            writePrimitiveIntAs(writer, toBaseType, reader.nextInt());
                            return;
                        case 'J':
                            writePrimitiveLongAs(writer, toBaseType, reader.nextLong());
                            return;
                        case 'S':
                            writePrimitiveShortAs(writer, toBaseType, reader.nextShort());
                            return;
                        case 'V':
                            writePrimitiveVoidAs(writer, toBaseType);
                            return;
                        default:
                            throwWrongMethodTypeException();
                            return;
                    }
                }
                Object value = reader.nextReference(Object.class);
                if (to == Void.TYPE) {
                    return;
                }
                if (value == null) {
                    throw new NullPointerException();
                }
                if (!Wrapper.isWrapperType(value.getClass())) {
                    throwClassCastException(value.getClass(), to);
                }
                Wrapper fromWrapper = Wrapper.forWrapperType(value.getClass());
                Wrapper toWrapper = Wrapper.forPrimitiveType(to);
                if (!toWrapper.isConvertibleFrom(fromWrapper)) {
                    throwClassCastException(from, to);
                }
                char toChar = toWrapper.basicTypeChar();
                switch (fromWrapper.basicTypeChar()) {
                    case 'B':
                        writePrimitiveByteAs(writer, toChar, ((Byte) value).byteValue());
                        return;
                    case 'C':
                        writePrimitiveCharAs(writer, toChar, ((Character) value).charValue());
                        return;
                    case 'D':
                        writePrimitiveDoubleAs(writer, toChar, ((Double) value).doubleValue());
                        return;
                    case 'F':
                        writePrimitiveFloatAs(writer, toChar, ((Float) value).floatValue());
                        return;
                    case 'I':
                        writePrimitiveIntAs(writer, toChar, ((Integer) value).intValue());
                        return;
                    case 'J':
                        writePrimitiveLongAs(writer, toChar, ((Long) value).longValue());
                        return;
                    case 'S':
                        writePrimitiveShortAs(writer, toChar, ((Short) value).shortValue());
                        return;
                    case 'Z':
                        writer.putNextBoolean(((Boolean) value).booleanValue());
                        return;
                    default:
                        throw new IllegalStateException();
                }
            }
            if (from.isPrimitive()) {
                char fromBaseType2 = Wrapper.basicTypeChar(from);
                Class fromBoxed = getBoxedPrimitiveClass(fromBaseType2);
                if (fromBoxed != null && !to.isAssignableFrom(fromBoxed)) {
                    throwWrongMethodTypeException();
                }
                switch (fromBaseType2) {
                    case 'B':
                        boxed = Byte.valueOf(reader.nextByte());
                        break;
                    case 'C':
                        boxed = Character.valueOf(reader.nextChar());
                        break;
                    case 'D':
                        boxed = Double.valueOf(reader.nextDouble());
                        break;
                    case 'F':
                        boxed = Float.valueOf(reader.nextFloat());
                        break;
                    case 'I':
                        boxed = Integer.valueOf(reader.nextInt());
                        break;
                    case 'J':
                        boxed = Long.valueOf(reader.nextLong());
                        break;
                    case 'S':
                        boxed = Short.valueOf(reader.nextShort());
                        break;
                    case 'V':
                        boxed = null;
                        break;
                    case 'Z':
                        boxed = Boolean.valueOf(reader.nextBoolean());
                        break;
                    default:
                        throw new IllegalStateException();
                }
                writer.putNextReference(boxed, to);
                return;
            }
            Object value2 = reader.nextReference(Object.class);
            if (value2 != null && !to.isAssignableFrom(value2.getClass())) {
                throwClassCastException(value2.getClass(), to);
            }
            writer.putNextReference(value2, to);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ExplicitCastArguments extends Transformer {
        private final MethodHandle target;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ExplicitCastArguments(MethodHandle target, MethodType type) {
            super(type);
            this.target = target;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame callerFrame) throws Throwable {
            EmulatedStackFrame targetFrame = EmulatedStackFrame.create(this.target.type());
            explicitCastArguments(callerFrame, targetFrame);
            invokeFromTransform(this.target, targetFrame);
            explicitCastReturnValue(callerFrame, targetFrame);
        }

        private void explicitCastArguments(EmulatedStackFrame callerFrame, EmulatedStackFrame targetFrame) {
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(callerFrame);
            EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
            writer.attach(targetFrame);
            Class<?>[] fromTypes = type().ptypes();
            Class<?>[] toTypes = this.target.type().ptypes();
            for (int i10 = 0; i10 < fromTypes.length; i10++) {
                explicitCast(reader, fromTypes[i10], writer, toTypes[i10]);
            }
        }

        private void explicitCastReturnValue(EmulatedStackFrame callerFrame, EmulatedStackFrame targetFrame) {
            Class<?> from = this.target.type().rtype();
            Class<?> to = type().rtype();
            if (to != Void.TYPE) {
                EmulatedStackFrame.StackFrameWriter writer = new EmulatedStackFrame.StackFrameWriter();
                writer.attach(callerFrame);
                writer.makeReturnValueAccessor();
                if (from == Void.TYPE) {
                    if (to.isPrimitive()) {
                        unboxNull(writer, to);
                        return;
                    } else {
                        writer.putNextReference((Object) null, to);
                        return;
                    }
                }
                EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
                reader.attach(targetFrame);
                reader.makeReturnValueAccessor();
                explicitCast(reader, this.target.type().rtype(), writer, type().rtype());
            }
        }

        private static void throwUnexpectedType(Class<?> unexpectedType) {
            throw new InternalError("Unexpected type: " + ((Object) unexpectedType));
        }

        private static void badCast(Class<?> from, Class<?> to) {
            throw new ClassCastException("Cannot cast " + from.getName() + " to " + to.getName());
        }

        private static boolean toBoolean(byte value) {
            return (value & 1) == 1;
        }

        private static byte readPrimitiveAsByte(EmulatedStackFrame.StackFrameReader stackFrameReader, Class<?> cls) {
            switch (Wrapper.basicTypeChar(cls)) {
                case 'B':
                    return stackFrameReader.nextByte();
                case 'C':
                    return (byte) stackFrameReader.nextChar();
                case 'D':
                    return (byte) stackFrameReader.nextDouble();
                case 'F':
                    return (byte) stackFrameReader.nextFloat();
                case 'I':
                    return (byte) stackFrameReader.nextInt();
                case 'J':
                    return (byte) stackFrameReader.nextLong();
                case 'S':
                    return (byte) stackFrameReader.nextShort();
                case 'Z':
                    return stackFrameReader.nextBoolean() ? (byte) 1 : (byte) 0;
                default:
                    throwUnexpectedType(cls);
                    return (byte) 0;
            }
        }

        private static char readPrimitiveAsChar(EmulatedStackFrame.StackFrameReader stackFrameReader, Class<?> cls) {
            switch (Wrapper.basicTypeChar(cls)) {
                case 'B':
                    return (char) stackFrameReader.nextByte();
                case 'C':
                    return stackFrameReader.nextChar();
                case 'D':
                    return (char) stackFrameReader.nextDouble();
                case 'F':
                    return (char) stackFrameReader.nextFloat();
                case 'I':
                    return (char) stackFrameReader.nextInt();
                case 'J':
                    return (char) stackFrameReader.nextLong();
                case 'S':
                    return (char) stackFrameReader.nextShort();
                case 'Z':
                    return stackFrameReader.nextBoolean() ? (char) 1 : (char) 0;
                default:
                    throwUnexpectedType(cls);
                    return (char) 0;
            }
        }

        private static short readPrimitiveAsShort(EmulatedStackFrame.StackFrameReader stackFrameReader, Class<?> cls) {
            switch (Wrapper.basicTypeChar(cls)) {
                case 'B':
                    return stackFrameReader.nextByte();
                case 'C':
                    return (short) stackFrameReader.nextChar();
                case 'D':
                    return (short) stackFrameReader.nextDouble();
                case 'F':
                    return (short) stackFrameReader.nextFloat();
                case 'I':
                    return (short) stackFrameReader.nextInt();
                case 'J':
                    return (short) stackFrameReader.nextLong();
                case 'S':
                    return stackFrameReader.nextShort();
                case 'Z':
                    return stackFrameReader.nextBoolean() ? (short) 1 : (short) 0;
                default:
                    throwUnexpectedType(cls);
                    return (short) 0;
            }
        }

        private static int readPrimitiveAsInt(EmulatedStackFrame.StackFrameReader stackFrameReader, Class<?> cls) {
            switch (Wrapper.basicTypeChar(cls)) {
                case 'B':
                    return stackFrameReader.nextByte();
                case 'C':
                    return stackFrameReader.nextChar();
                case 'D':
                    return (int) stackFrameReader.nextDouble();
                case 'F':
                    return (int) stackFrameReader.nextFloat();
                case 'I':
                    return stackFrameReader.nextInt();
                case 'J':
                    return (int) stackFrameReader.nextLong();
                case 'S':
                    return stackFrameReader.nextShort();
                case 'Z':
                    return stackFrameReader.nextBoolean() ? 1 : 0;
                default:
                    throwUnexpectedType(cls);
                    return 0;
            }
        }

        private static long readPrimitiveAsLong(EmulatedStackFrame.StackFrameReader reader, Class<?> from) {
            switch (Wrapper.basicTypeChar(from)) {
                case 'B':
                    return reader.nextByte();
                case 'C':
                    return reader.nextChar();
                case 'D':
                    return (long) reader.nextDouble();
                case 'F':
                    return reader.nextFloat();
                case 'I':
                    return reader.nextInt();
                case 'J':
                    return reader.nextLong();
                case 'S':
                    return reader.nextShort();
                case 'Z':
                    return reader.nextBoolean() ? 1L : 0L;
                default:
                    throwUnexpectedType(from);
                    return 0L;
            }
        }

        private static float readPrimitiveAsFloat(EmulatedStackFrame.StackFrameReader reader, Class<?> from) {
            switch (Wrapper.basicTypeChar(from)) {
                case 'B':
                    return reader.nextByte();
                case 'C':
                    return reader.nextChar();
                case 'D':
                    return (float) reader.nextDouble();
                case 'F':
                    return reader.nextFloat();
                case 'I':
                    return reader.nextInt();
                case 'J':
                    return (float) reader.nextLong();
                case 'S':
                    return reader.nextShort();
                case 'Z':
                    return reader.nextBoolean() ? 1.0f : 0.0f;
                default:
                    throwUnexpectedType(from);
                    return 0.0f;
            }
        }

        private static double readPrimitiveAsDouble(EmulatedStackFrame.StackFrameReader reader, Class<?> from) {
            switch (Wrapper.basicTypeChar(from)) {
                case 'B':
                    return reader.nextByte();
                case 'C':
                    return reader.nextChar();
                case 'D':
                    return reader.nextDouble();
                case 'F':
                    return reader.nextFloat();
                case 'I':
                    return reader.nextInt();
                case 'J':
                    return reader.nextLong();
                case 'S':
                    return reader.nextShort();
                case 'Z':
                    if (reader.nextBoolean()) {
                        return 1.0d;
                    }
                    return ShadowDrawableWrapper.COS_45;
                default:
                    throwUnexpectedType(from);
                    return ShadowDrawableWrapper.COS_45;
            }
        }

        private static void explicitCastPrimitives(EmulatedStackFrame.StackFrameReader reader, Class<?> from, EmulatedStackFrame.StackFrameWriter writer, Class<?> to) {
            switch (Wrapper.basicTypeChar(to)) {
                case 'B':
                    writer.putNextByte(readPrimitiveAsByte(reader, from));
                    return;
                case 'C':
                    writer.putNextChar(readPrimitiveAsChar(reader, from));
                    return;
                case 'D':
                    writer.putNextDouble(readPrimitiveAsDouble(reader, from));
                    return;
                case 'F':
                    writer.putNextFloat(readPrimitiveAsFloat(reader, from));
                    return;
                case 'I':
                    writer.putNextInt(readPrimitiveAsInt(reader, from));
                    return;
                case 'J':
                    writer.putNextLong(readPrimitiveAsLong(reader, from));
                    return;
                case 'S':
                    writer.putNextShort(readPrimitiveAsShort(reader, from));
                    return;
                case 'Z':
                    writer.putNextBoolean(toBoolean(readPrimitiveAsByte(reader, from)));
                    return;
                default:
                    throwUnexpectedType(to);
                    return;
            }
        }

        private static void unboxNull(EmulatedStackFrame.StackFrameWriter writer, Class<?> to) {
            switch (Wrapper.basicTypeChar(to)) {
                case 'B':
                    writer.putNextByte((byte) 0);
                    return;
                case 'C':
                    writer.putNextChar((char) 0);
                    return;
                case 'D':
                    writer.putNextDouble(ShadowDrawableWrapper.COS_45);
                    return;
                case 'F':
                    writer.putNextFloat(0.0f);
                    return;
                case 'I':
                    writer.putNextInt(0);
                    return;
                case 'J':
                    writer.putNextLong(0L);
                    return;
                case 'S':
                    writer.putNextShort((short) 0);
                    return;
                case 'Z':
                    writer.putNextBoolean(false);
                    return;
                default:
                    throwUnexpectedType(to);
                    return;
            }
        }

        private static void unboxNonNull(Object obj, EmulatedStackFrame.StackFrameWriter stackFrameWriter, Class<?> cls) {
            Class<?> cls2 = obj.getClass();
            switch (Wrapper.basicTypeChar(Wrapper.asPrimitiveType(cls2))) {
                case 'B':
                    byte byteValue = ((Byte) obj).byteValue();
                    switch (Wrapper.basicTypeChar(cls)) {
                        case 'B':
                            stackFrameWriter.putNextByte(byteValue);
                            return;
                        case 'C':
                            stackFrameWriter.putNextChar((char) byteValue);
                            return;
                        case 'D':
                            stackFrameWriter.putNextDouble(byteValue);
                            return;
                        case 'F':
                            stackFrameWriter.putNextFloat(byteValue);
                            return;
                        case 'I':
                            stackFrameWriter.putNextInt(byteValue);
                            return;
                        case 'J':
                            stackFrameWriter.putNextLong(byteValue);
                            return;
                        case 'S':
                            stackFrameWriter.putNextShort(byteValue);
                            return;
                        case 'Z':
                            stackFrameWriter.putNextBoolean(toBoolean(byteValue));
                            return;
                        default:
                            badCast(cls2, cls);
                            return;
                    }
                case 'C':
                    char charValue = ((Character) obj).charValue();
                    switch (Wrapper.basicTypeChar(cls)) {
                        case 'B':
                            stackFrameWriter.putNextByte((byte) charValue);
                            return;
                        case 'C':
                            stackFrameWriter.putNextChar(charValue);
                            return;
                        case 'D':
                            stackFrameWriter.putNextDouble(charValue);
                            return;
                        case 'F':
                            stackFrameWriter.putNextFloat(charValue);
                            return;
                        case 'I':
                            stackFrameWriter.putNextInt(charValue);
                            return;
                        case 'J':
                            stackFrameWriter.putNextLong(charValue);
                            return;
                        case 'S':
                            stackFrameWriter.putNextShort((short) charValue);
                            return;
                        case 'Z':
                            stackFrameWriter.putNextBoolean((charValue & 1) == 1);
                            return;
                        default:
                            badCast(cls2, cls);
                            return;
                    }
                case 'D':
                    double doubleValue = ((Double) obj).doubleValue();
                    switch (Wrapper.basicTypeChar(cls)) {
                        case 'B':
                            stackFrameWriter.putNextByte((byte) doubleValue);
                            return;
                        case 'C':
                            stackFrameWriter.putNextChar((char) doubleValue);
                            return;
                        case 'D':
                            stackFrameWriter.putNextDouble(doubleValue);
                            return;
                        case 'F':
                            stackFrameWriter.putNextFloat((float) doubleValue);
                            return;
                        case 'I':
                            stackFrameWriter.putNextInt((int) doubleValue);
                            return;
                        case 'J':
                            stackFrameWriter.putNextLong((long) doubleValue);
                            return;
                        case 'S':
                            stackFrameWriter.putNextShort((short) doubleValue);
                            return;
                        case 'Z':
                            stackFrameWriter.putNextBoolean((((byte) ((int) doubleValue)) & 1) != 0);
                            return;
                        default:
                            badCast(cls2, cls);
                            return;
                    }
                case 'F':
                    float floatValue = ((Float) obj).floatValue();
                    switch (Wrapper.basicTypeChar(cls)) {
                        case 'B':
                            stackFrameWriter.putNextByte((byte) floatValue);
                            return;
                        case 'C':
                            stackFrameWriter.putNextChar((char) floatValue);
                            return;
                        case 'D':
                            stackFrameWriter.putNextDouble(floatValue);
                            return;
                        case 'F':
                            stackFrameWriter.putNextFloat(floatValue);
                            return;
                        case 'I':
                            stackFrameWriter.putNextInt((int) floatValue);
                            return;
                        case 'J':
                            stackFrameWriter.putNextLong(floatValue);
                            return;
                        case 'S':
                            stackFrameWriter.putNextShort((short) floatValue);
                            return;
                        case 'Z':
                            stackFrameWriter.putNextBoolean((((byte) ((int) floatValue)) & 1) != 0);
                            return;
                        default:
                            badCast(cls2, cls);
                            return;
                    }
                case 'I':
                    int intValue = ((Integer) obj).intValue();
                    switch (Wrapper.basicTypeChar(cls)) {
                        case 'B':
                            stackFrameWriter.putNextByte((byte) intValue);
                            return;
                        case 'C':
                            stackFrameWriter.putNextChar((char) intValue);
                            return;
                        case 'D':
                            stackFrameWriter.putNextDouble(intValue);
                            return;
                        case 'F':
                            stackFrameWriter.putNextFloat(intValue);
                            return;
                        case 'I':
                            stackFrameWriter.putNextInt(intValue);
                            return;
                        case 'J':
                            stackFrameWriter.putNextLong(intValue);
                            return;
                        case 'S':
                            stackFrameWriter.putNextShort((short) intValue);
                            return;
                        case 'Z':
                            stackFrameWriter.putNextBoolean((intValue & 1) == 1);
                            return;
                        default:
                            badCast(cls2, cls);
                            return;
                    }
                case 'J':
                    long longValue = ((Long) obj).longValue();
                    switch (Wrapper.basicTypeChar(cls)) {
                        case 'B':
                            stackFrameWriter.putNextByte((byte) longValue);
                            return;
                        case 'C':
                            stackFrameWriter.putNextChar((char) longValue);
                            return;
                        case 'D':
                            stackFrameWriter.putNextDouble(longValue);
                            return;
                        case 'F':
                            stackFrameWriter.putNextFloat((float) longValue);
                            return;
                        case 'I':
                            stackFrameWriter.putNextInt((int) longValue);
                            return;
                        case 'J':
                            stackFrameWriter.putNextLong(longValue);
                            return;
                        case 'S':
                            stackFrameWriter.putNextShort((short) longValue);
                            return;
                        case 'Z':
                            stackFrameWriter.putNextBoolean((longValue & 1) == 1);
                            return;
                        default:
                            badCast(cls2, cls);
                            return;
                    }
                case 'S':
                    short shortValue = ((Short) obj).shortValue();
                    switch (Wrapper.basicTypeChar(cls)) {
                        case 'B':
                            stackFrameWriter.putNextByte((byte) shortValue);
                            return;
                        case 'C':
                            stackFrameWriter.putNextChar((char) shortValue);
                            return;
                        case 'D':
                            stackFrameWriter.putNextDouble(shortValue);
                            return;
                        case 'F':
                            stackFrameWriter.putNextFloat(shortValue);
                            return;
                        case 'I':
                            stackFrameWriter.putNextInt(shortValue);
                            return;
                        case 'J':
                            stackFrameWriter.putNextLong(shortValue);
                            return;
                        case 'S':
                            stackFrameWriter.putNextShort(shortValue);
                            return;
                        case 'Z':
                            stackFrameWriter.putNextBoolean((shortValue & 1) == 1);
                            return;
                        default:
                            badCast(cls2, cls);
                            return;
                    }
                case 'Z':
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    switch (Wrapper.basicTypeChar(cls)) {
                        case 'B':
                            stackFrameWriter.putNextByte(booleanValue ? (byte) 1 : (byte) 0);
                            return;
                        case 'C':
                            stackFrameWriter.putNextChar(booleanValue ? (char) 1 : (char) 0);
                            return;
                        case 'D':
                            stackFrameWriter.putNextDouble(booleanValue ? 1.0d : ShadowDrawableWrapper.COS_45);
                            return;
                        case 'F':
                            stackFrameWriter.putNextFloat(booleanValue ? 1.0f : 0.0f);
                            return;
                        case 'I':
                            stackFrameWriter.putNextInt(booleanValue ? 1 : 0);
                            return;
                        case 'J':
                            stackFrameWriter.putNextLong(booleanValue ? 1L : 0L);
                            return;
                        case 'S':
                            stackFrameWriter.putNextShort(booleanValue ? (short) 1 : (short) 0);
                            return;
                        case 'Z':
                            stackFrameWriter.putNextBoolean(booleanValue);
                            return;
                        default:
                            badCast(cls2, cls);
                            return;
                    }
                default:
                    badCast(cls2, cls);
                    return;
            }
        }

        private static void unbox(Object ref, EmulatedStackFrame.StackFrameWriter writer, Class<?> to) {
            if (ref == null) {
                unboxNull(writer, to);
            } else {
                unboxNonNull(ref, writer, to);
            }
        }

        private static void box(EmulatedStackFrame.StackFrameReader reader, Class<?> from, EmulatedStackFrame.StackFrameWriter writer, Class<?> to) {
            Object boxed = null;
            switch (Wrapper.basicTypeChar(from)) {
                case 'B':
                    boxed = Byte.valueOf(reader.nextByte());
                    break;
                case 'C':
                    boxed = Character.valueOf(reader.nextChar());
                    break;
                case 'D':
                    boxed = Double.valueOf(reader.nextDouble());
                    break;
                case 'F':
                    boxed = Float.valueOf(reader.nextFloat());
                    break;
                case 'I':
                    boxed = Integer.valueOf(reader.nextInt());
                    break;
                case 'J':
                    boxed = Long.valueOf(reader.nextLong());
                    break;
                case 'S':
                    boxed = Short.valueOf(reader.nextShort());
                    break;
                case 'Z':
                    boxed = Boolean.valueOf(reader.nextBoolean());
                    break;
                default:
                    throwUnexpectedType(from);
                    break;
            }
            writer.putNextReference(to.cast(boxed), to);
        }

        private static void explicitCast(EmulatedStackFrame.StackFrameReader reader, Class<?> from, EmulatedStackFrame.StackFrameWriter writer, Class<?> to) {
            if (from.equals(to)) {
                EmulatedStackFrame.StackFrameAccessor.copyNext(reader, writer, from);
                return;
            }
            if (from.isPrimitive()) {
                if (to.isPrimitive()) {
                    explicitCastPrimitives(reader, from, writer, to);
                    return;
                } else {
                    box(reader, from, writer, to);
                    return;
                }
            }
            Object ref = reader.nextReference(from);
            if (to.isPrimitive()) {
                unbox(ref, writer, to);
            } else if (to.isInterface()) {
                writer.putNextReference(ref, to);
            } else {
                writer.putNextReference(to.cast(ref), to);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Loop extends Transformer {
        final MethodHandle[] finis;
        final MethodHandle[] inits;
        final EmulatedStackFrame.Range loopVarsRange;
        final MethodType loopVarsType;
        final MethodHandle[] preds;
        final MethodHandle[] steps;
        final EmulatedStackFrame.Range suffixRange;

        public Loop(Class<?> loopReturnType, List<Class<?>> commonSuffix, MethodHandle[] finit, MethodHandle[] fstep, MethodHandle[] fpred, MethodHandle[] ffini) {
            super(MethodType.methodType(loopReturnType, commonSuffix));
            this.inits = finit;
            this.steps = fstep;
            this.preds = fpred;
            this.finis = ffini;
            MethodType deduceLoopVarsType = deduceLoopVarsType(finit);
            this.loopVarsType = deduceLoopVarsType;
            this.loopVarsRange = EmulatedStackFrame.Range.all(deduceLoopVarsType);
            this.suffixRange = EmulatedStackFrame.Range.all(type());
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame callerFrame) throws Throwable {
            EmulatedStackFrame loopVarsFrame = EmulatedStackFrame.create(this.loopVarsType);
            EmulatedStackFrame.StackFrameWriter loopVarsWriter = new EmulatedStackFrame.StackFrameWriter();
            init(callerFrame, loopVarsFrame, loopVarsWriter);
            while (true) {
                loopVarsWriter.attach(loopVarsFrame);
                int i10 = 0;
                while (true) {
                    MethodHandle[] methodHandleArr = this.steps;
                    if (i10 < methodHandleArr.length) {
                        doStep(methodHandleArr[i10], callerFrame, loopVarsFrame, loopVarsWriter);
                        boolean keepGoing = doPredicate(this.preds[i10], callerFrame, loopVarsFrame);
                        if (keepGoing) {
                            i10++;
                        } else {
                            doFinish(this.finis[i10], callerFrame, loopVarsFrame);
                            return;
                        }
                    }
                }
            }
        }

        private static MethodType deduceLoopVarsType(MethodHandle[] inits) {
            List<Class<?>> loopVarTypes = new ArrayList<>(inits.length);
            for (MethodHandle init : inits) {
                Class<?> returnType = init.type().returnType();
                if (returnType != Void.TYPE) {
                    loopVarTypes.add(returnType);
                }
            }
            return MethodType.methodType(Void.TYPE, loopVarTypes);
        }

        private void init(EmulatedStackFrame callerFrame, EmulatedStackFrame loopVarsFrame, EmulatedStackFrame.StackFrameWriter loopVarsWriter) throws Throwable {
            loopVarsWriter.attach(loopVarsFrame);
            for (MethodHandle init : this.inits) {
                EmulatedStackFrame initFrame = EmulatedStackFrame.create(init.type());
                callerFrame.copyRangeTo(initFrame, this.suffixRange, 0, 0);
                invokeExactFromTransform(init, initFrame);
                Class<?> loopVarType = init.type().returnType();
                if (loopVarType != Void.TYPE) {
                    EmulatedStackFrame.StackFrameReader initReader = new EmulatedStackFrame.StackFrameReader();
                    initReader.attach(initFrame).makeReturnValueAccessor();
                    EmulatedStackFrame.StackFrameAccessor.copyNext(initReader, loopVarsWriter, loopVarType);
                }
            }
        }

        private EmulatedStackFrame prepareFrame(MethodType mt, EmulatedStackFrame callerFrame, EmulatedStackFrame loopVarsFrame) {
            EmulatedStackFrame frame = EmulatedStackFrame.create(mt);
            loopVarsFrame.copyRangeTo(frame, this.loopVarsRange, 0, 0);
            callerFrame.copyRangeTo(frame, this.suffixRange, this.loopVarsRange.numReferences, this.loopVarsRange.numBytes);
            return frame;
        }

        private void doStep(MethodHandle step, EmulatedStackFrame callerFrame, EmulatedStackFrame loopVarsFrame, EmulatedStackFrame.StackFrameWriter loopVarsWriter) throws Throwable {
            EmulatedStackFrame stepFrame = prepareFrame(step.type(), callerFrame, loopVarsFrame);
            invokeExactFromTransform(step, stepFrame);
            Class<?> loopVarType = step.type().returnType();
            if (loopVarType != Void.TYPE) {
                EmulatedStackFrame.StackFrameReader stepReader = new EmulatedStackFrame.StackFrameReader();
                stepReader.attach(stepFrame).makeReturnValueAccessor();
                EmulatedStackFrame.StackFrameAccessor.copyNext(stepReader, loopVarsWriter, loopVarType);
            }
        }

        private boolean doPredicate(MethodHandle pred, EmulatedStackFrame callerFrame, EmulatedStackFrame loopVarsFrame) throws Throwable {
            EmulatedStackFrame predFrame = prepareFrame(pred.type(), callerFrame, loopVarsFrame);
            invokeExactFromTransform(pred, predFrame);
            EmulatedStackFrame.StackFrameReader predReader = new EmulatedStackFrame.StackFrameReader();
            predReader.attach(predFrame).makeReturnValueAccessor();
            return predReader.nextBoolean();
        }

        private void doFinish(MethodHandle fini, EmulatedStackFrame callerFrame, EmulatedStackFrame loopVarsFrame) throws Throwable {
            EmulatedStackFrame finiFrame = prepareFrame(fini.type(), callerFrame, loopVarsFrame);
            invokeExactFromTransform(fini, finiFrame);
            finiFrame.copyReturnValueTo(callerFrame);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class TableSwitch extends Transformer {
        private final MethodHandle fallback;
        private final MethodHandle[] targets;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TableSwitch(MethodType type, MethodHandle fallback, MethodHandle[] targets) {
            super(type);
            this.fallback = fallback;
            this.targets = targets;
        }

        @Override // java.lang.invoke.MethodHandle
        public void transform(EmulatedStackFrame callerFrame) throws Throwable {
            MethodHandle selected = selectMethodHandle(callerFrame);
            invokeExactFromTransform(selected, callerFrame);
        }

        private MethodHandle selectMethodHandle(EmulatedStackFrame callerFrame) {
            EmulatedStackFrame.StackFrameReader reader = new EmulatedStackFrame.StackFrameReader();
            reader.attach(callerFrame);
            int index = reader.nextInt();
            if (index >= 0) {
                MethodHandle[] methodHandleArr = this.targets;
                if (index < methodHandleArr.length) {
                    return methodHandleArr[index];
                }
            }
            return this.fallback;
        }
    }
}
