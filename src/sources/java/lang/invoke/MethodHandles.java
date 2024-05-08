package java.lang.invoke;

import java.lang.invoke.Transformers;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import sun.invoke.util.VerifyAccess;
import sun.invoke.util.Wrapper;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MethodHandles {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MH_Array_newInstance = 11;
    static final int MH_LIMIT = 12;
    static final int MH_arrayIdentity = 5;
    static final int MH_cast = 0;
    static final int MH_copyAsPrimitiveArray = 2;
    static final int MH_countedLoopPred = 6;
    static final int MH_countedLoopStep = 7;
    static final int MH_fillNewArray = 4;
    static final int MH_fillNewTypedArray = 3;
    static final int MH_initIterator = 8;
    static final int MH_iterateNext = 10;
    static final int MH_iteratePred = 9;
    static final int MH_selectAlternative = 1;
    private static final MethodHandle[] IDENTITY_MHS = new MethodHandle[10];
    private static final MethodHandle[] ZERO_MHS = new MethodHandle[10];

    @Stable
    private static final MethodHandle[] HANDLES = new MethodHandle[12];

    private MethodHandles() {
    }

    public static Lookup lookup() {
        return new Lookup(Reflection.getCallerClass());
    }

    public static Lookup publicLookup() {
        return Lookup.PUBLIC_LOOKUP;
    }

    public static Lookup privateLookupIn(Class<?> targetClass, Lookup lookup) throws IllegalAccessException {
        if (targetClass.isPrimitive()) {
            throw new IllegalArgumentException(((Object) targetClass) + " is a primitive class");
        }
        if (targetClass.isArray()) {
            throw new IllegalArgumentException(((Object) targetClass) + " is an array class");
        }
        return new Lookup(targetClass);
    }

    public static <T extends Member> T reflectAs(Class<T> expected, MethodHandle target) {
        MethodHandleImpl directTarget = getMethodHandleImpl(target);
        return expected.cast(directTarget.getMemberInternal());
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Lookup {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int ALL_MODES = 15;
        public static final int PACKAGE = 8;
        public static final int PRIVATE = 2;
        public static final int PROTECTED = 4;
        public static final int PUBLIC = 1;
        private final int allowedModes;
        private final Class<?> lookupClass;
        static final Lookup PUBLIC_LOOKUP = new Lookup(Object.class, 1);
        static final Lookup IMPL_LOOKUP = new Lookup(Object.class, 15);

        private static int fixmods(int mods) {
            int mods2 = mods & 7;
            if (mods2 != 0) {
                return mods2;
            }
            return 8;
        }

        public Class<?> lookupClass() {
            return this.lookupClass;
        }

        public int lookupModes() {
            return this.allowedModes & 15;
        }

        Lookup(Class<?> lookupClass) {
            this(lookupClass, 15);
            checkUnprivilegedlookupClass(lookupClass, 15);
        }

        private Lookup(Class<?> lookupClass, int allowedModes) {
            this.lookupClass = lookupClass;
            this.allowedModes = allowedModes;
        }

        public Lookup in(Class<?> requestedLookupClass) {
            requestedLookupClass.getClass();
            Class<?> cls = this.lookupClass;
            if (requestedLookupClass == cls) {
                return this;
            }
            int newModes = this.allowedModes & 11;
            if ((newModes & 8) != 0 && !VerifyAccess.isSamePackage(cls, requestedLookupClass)) {
                newModes &= -11;
            }
            if ((newModes & 2) != 0 && !VerifyAccess.isSamePackageMember(this.lookupClass, requestedLookupClass)) {
                newModes &= -3;
            }
            if ((newModes & 1) != 0 && !VerifyAccess.isClassAccessible(requestedLookupClass, this.lookupClass, this.allowedModes)) {
                newModes = 0;
            }
            checkUnprivilegedlookupClass(requestedLookupClass, newModes);
            return new Lookup(requestedLookupClass, newModes);
        }

        private static void checkUnprivilegedlookupClass(Class<?> lookupClass, int allowedModes) {
            String name = lookupClass.getName();
            if (name.startsWith("java.lang.invoke.")) {
                throw MethodHandleStatics.newIllegalArgumentException("illegal lookupClass: " + ((Object) lookupClass));
            }
            if (allowedModes == 15 && lookupClass.getClassLoader() == Object.class.getClassLoader()) {
                if ((name.startsWith("java.") && !name.startsWith("java.io.ObjectStreamClass") && !name.startsWith("java.util.concurrent.") && !name.equals("java.lang.Daemons$FinalizerWatchdogDaemon") && !name.equals("java.lang.runtime.ObjectMethods") && !name.equals("java.lang.Thread")) || (name.startsWith("sun.") && !name.startsWith("sun.invoke.") && !name.equals("sun.reflect.ReflectionFactory"))) {
                    throw MethodHandleStatics.newIllegalArgumentException("illegal lookupClass: " + ((Object) lookupClass));
                }
            }
        }

        public String toString() {
            String cname = this.lookupClass.getName();
            switch (this.allowedModes) {
                case 0:
                    return cname + "/noaccess";
                case 1:
                    return cname + "/public";
                case 9:
                    return cname + "/package";
                case 11:
                    return cname + "/private";
                case 15:
                    return cname;
                default:
                    return cname + "/" + Integer.toHexString(this.allowedModes);
            }
        }

        public MethodHandle findStatic(Class<?> refc, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException {
            Method method = refc.getDeclaredMethod(name, type.ptypes());
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                throw new IllegalAccessException("Method" + ((Object) method) + " is not static");
            }
            checkReturnType(method, type);
            checkAccess(refc, method.getDeclaringClass(), modifiers, method.getName());
            return createMethodHandle(method, 3, type);
        }

        private MethodHandle findVirtualForMH(String name, MethodType type) {
            if ("invoke".equals(name)) {
                return MethodHandles.invoker(type);
            }
            if ("invokeExact".equals(name)) {
                return MethodHandles.exactInvoker(type);
            }
            return null;
        }

        private MethodHandle findVirtualForVH(String name, MethodType type) {
            try {
                VarHandle.AccessMode accessMode = VarHandle.AccessMode.valueFromMethodName(name);
                return MethodHandles.varHandleInvoker(accessMode, type);
            } catch (IllegalArgumentException e2) {
                return null;
            }
        }

        private static MethodHandle createMethodHandle(Method method, int handleKind, MethodType methodType) {
            MethodHandle mh = new MethodHandleImpl(method.getArtMethod(), handleKind, methodType);
            if (method.isVarArgs()) {
                return new Transformers.VarargsCollector(mh);
            }
            return mh;
        }

        public MethodHandle findVirtual(Class<?> refc, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException {
            MethodHandle mh;
            if (refc == MethodHandle.class) {
                MethodHandle mh2 = findVirtualForMH(name, type);
                if (mh2 != null) {
                    return mh2;
                }
            } else if (refc == VarHandle.class && (mh = findVirtualForVH(name, type)) != null) {
                return mh;
            }
            Method method = refc.getInstanceMethod(name, type.ptypes());
            if (method == null) {
                try {
                    Method m10 = refc.getDeclaredMethod(name, type.ptypes());
                    if (Modifier.isStatic(m10.getModifiers())) {
                        throw new IllegalAccessException("Method" + ((Object) m10) + " is static");
                    }
                } catch (NoSuchMethodException e2) {
                }
                throw new NoSuchMethodException(name + " " + Arrays.toString(type.ptypes()));
            }
            checkReturnType(method, type);
            checkAccess(refc, method.getDeclaringClass(), method.getModifiers(), method.getName());
            MethodType handleType = type.insertParameterTypes(0, refc);
            return createMethodHandle(method, 0, handleType);
        }

        public MethodHandle findConstructor(Class<?> refc, MethodType type) throws NoSuchMethodException, IllegalAccessException {
            if (refc.isArray()) {
                throw new NoSuchMethodException("no constructor for array class: " + refc.getName());
            }
            Constructor constructor = refc.getDeclaredConstructor(type.ptypes());
            if (constructor == null) {
                throw new NoSuchMethodException("No constructor for " + ((Object) constructor.getDeclaringClass()) + " matching " + ((Object) type));
            }
            checkAccess(refc, constructor.getDeclaringClass(), constructor.getModifiers(), constructor.getName());
            return createMethodHandleForConstructor(constructor);
        }

        public Class<?> findClass(String targetName) throws ClassNotFoundException, IllegalAccessException {
            Class<?> targetClass = Class.forName(targetName, false, this.lookupClass.getClassLoader());
            return accessClass(targetClass);
        }

        private MethodHandle createMethodHandleForConstructor(Constructor constructor) {
            MethodHandle mh;
            Class<?> refc = constructor.getDeclaringClass();
            MethodType constructorType = MethodType.methodType(refc, constructor.getParameterTypes());
            if (refc == String.class) {
                mh = new MethodHandleImpl(constructor.getArtMethod(), 2, constructorType);
            } else {
                MethodType initType = initMethodType(constructorType);
                MethodHandle initHandle = new MethodHandleImpl(constructor.getArtMethod(), 2, initType);
                mh = new Transformers.Construct(initHandle, constructorType);
            }
            if (constructor.isVarArgs()) {
                return new Transformers.VarargsCollector(mh);
            }
            return mh;
        }

        private static MethodType initMethodType(MethodType constructorType) {
            Class<?>[] initPtypes = new Class[constructorType.ptypes().length + 1];
            initPtypes[0] = constructorType.rtype();
            System.arraycopy(constructorType.ptypes(), 0, initPtypes, 1, constructorType.ptypes().length);
            return MethodType.methodType(Void.TYPE, initPtypes);
        }

        private IllegalAccessException makeAccessException(Class<?> targetClass) {
            String message;
            String message2 = "access violation: " + ((Object) targetClass);
            if (this == MethodHandles.publicLookup()) {
                message = message2 + ", from public Lookup";
            } else {
                message = message2 + ", from " + ((Object) lookupClass());
            }
            return new IllegalAccessException(message);
        }

        public Class<?> accessClass(Class<?> targetClass) throws IllegalAccessException {
            if (!isClassAccessible(targetClass)) {
                throw makeAccessException(targetClass);
            }
            return targetClass;
        }

        boolean isClassAccessible(Class<?> refc) {
            Objects.requireNonNull(refc);
            Class<?> caller = lookupClassOrNull();
            Class<?> type = refc;
            while (type.isArray()) {
                type = type.getComponentType();
            }
            return caller == null || VerifyAccess.isClassAccessible(type, caller, this.allowedModes);
        }

        private Class<?> lookupClassOrNull() {
            return this.lookupClass;
        }

        public MethodHandle findSpecial(Class<?> refc, String name, MethodType type, Class<?> specialCaller) throws NoSuchMethodException, IllegalAccessException {
            if (specialCaller == null) {
                throw new NullPointerException("specialCaller == null");
            }
            if (type == null) {
                throw new NullPointerException("type == null");
            }
            if (name == null) {
                throw new NullPointerException("name == null");
            }
            if (refc == null) {
                throw new NullPointerException("ref == null");
            }
            checkSpecialCaller(specialCaller, refc);
            if (name.startsWith("<")) {
                throw new NoSuchMethodException(name + " is not a valid method name.");
            }
            Method method = refc.getDeclaredMethod(name, type.ptypes());
            checkReturnType(method, type);
            return findSpecial(method, type, refc, specialCaller);
        }

        private MethodHandle findSpecial(Method method, MethodType type, Class<?> refc, Class<?> specialCaller) throws IllegalAccessException {
            if (Modifier.isStatic(method.getModifiers())) {
                throw new IllegalAccessException("expected a non-static method:" + ((Object) method));
            }
            if (Modifier.isPrivate(method.getModifiers())) {
                if (refc != lookupClass()) {
                    throw new IllegalAccessException("no private access for invokespecial : " + ((Object) refc) + ", from" + ((Object) this));
                }
                MethodType handleType = type.insertParameterTypes(0, refc);
                return createMethodHandle(method, 2, handleType);
            }
            if (!method.getDeclaringClass().isAssignableFrom(specialCaller)) {
                throw new IllegalAccessException(((Object) refc) + "is not assignable from " + ((Object) specialCaller));
            }
            MethodType handleType2 = type.insertParameterTypes(0, specialCaller);
            return createMethodHandle(method, 1, handleType2);
        }

        public MethodHandle findGetter(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException {
            return findAccessor(refc, name, type, 8);
        }

        private MethodHandle findAccessor(Class<?> refc, String name, Class<?> type, int kind) throws NoSuchFieldException, IllegalAccessException {
            Field field = findFieldOfType(refc, name, type);
            return findAccessor(field, refc, type, kind, true);
        }

        private MethodHandle findAccessor(Field field, Class<?> refc, Class<?> type, int kind, boolean performAccessChecks) throws IllegalAccessException {
            MethodType methodType;
            boolean isSetterKind = kind == 9 || kind == 11;
            boolean isStaticKind = kind == 10 || kind == 11;
            commonFieldChecks(field, refc, type, isStaticKind, performAccessChecks);
            if (performAccessChecks) {
                int modifiers = field.getModifiers();
                if (isSetterKind && Modifier.isFinal(modifiers)) {
                    throw new IllegalAccessException("Field " + ((Object) field) + " is final");
                }
            }
            switch (kind) {
                case 8:
                    methodType = MethodType.methodType(type, refc);
                    break;
                case 9:
                    methodType = MethodType.methodType(Void.TYPE, refc, type);
                    break;
                case 10:
                    methodType = MethodType.methodType(type);
                    break;
                case 11:
                    methodType = MethodType.methodType(Void.TYPE, type);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid kind " + kind);
            }
            return new MethodHandleImpl(field.getArtField(), kind, methodType);
        }

        public MethodHandle findSetter(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException {
            return findAccessor(refc, name, type, 9);
        }

        public VarHandle findVarHandle(Class<?> recv, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException {
            Field field = findFieldOfType(recv, name, type);
            commonFieldChecks(field, recv, type, false, true);
            return FieldVarHandle.create(field);
        }

        private Field findFieldOfType(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException {
            Field field = null;
            Class<?> cls = refc;
            while (true) {
                if (cls == null) {
                    break;
                }
                try {
                    field = cls.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException e2) {
                    cls = cls.getSuperclass();
                }
            }
            if (field == null) {
                field = refc.getDeclaredField(name);
            }
            Class<?> fieldType = field.getType();
            if (fieldType != type) {
                throw new NoSuchFieldException(name);
            }
            return field;
        }

        private void commonFieldChecks(Field field, Class<?> refc, Class<?> type, boolean isStatic, boolean performAccessChecks) throws IllegalAccessException {
            int modifiers = field.getModifiers();
            if (performAccessChecks) {
                checkAccess(refc, field.getDeclaringClass(), modifiers, field.getName());
            }
            if (Modifier.isStatic(modifiers) != isStatic) {
                String reason = "Field " + ((Object) field) + " is " + (isStatic ? "not " : "") + "static";
                throw new IllegalAccessException(reason);
            }
        }

        public MethodHandle findStaticGetter(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException {
            return findAccessor(refc, name, type, 10);
        }

        public MethodHandle findStaticSetter(Class<?> refc, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException {
            return findAccessor(refc, name, type, 11);
        }

        public VarHandle findStaticVarHandle(Class<?> decl, String name, Class<?> type) throws NoSuchFieldException, IllegalAccessException {
            Field field = findFieldOfType(decl, name, type);
            commonFieldChecks(field, decl, type, true, true);
            return StaticFieldVarHandle.create(field);
        }

        public MethodHandle bind(Object receiver, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException {
            MethodHandle handle = findVirtual(receiver.getClass(), name, type);
            MethodHandle adapter = handle.bindTo(receiver);
            MethodType adapterType = adapter.type();
            if (handle.isVarargsCollector()) {
                return adapter.asVarargsCollector(adapterType.parameterType(adapterType.parameterCount() - 1));
            }
            return adapter;
        }

        public MethodHandle unreflect(Method m10) throws IllegalAccessException {
            if (m10 == null) {
                throw new NullPointerException("m == null");
            }
            MethodType methodType = MethodType.methodType(m10.getReturnType(), m10.getParameterTypes());
            if (!m10.isAccessible()) {
                checkAccess(m10.getDeclaringClass(), m10.getDeclaringClass(), m10.getModifiers(), m10.getName());
            }
            if (Modifier.isStatic(m10.getModifiers())) {
                return createMethodHandle(m10, 3, methodType);
            }
            return createMethodHandle(m10, 0, methodType.insertParameterTypes(0, m10.getDeclaringClass()));
        }

        public MethodHandle unreflectSpecial(Method m10, Class<?> specialCaller) throws IllegalAccessException {
            if (m10 == null) {
                throw new NullPointerException("m == null");
            }
            if (specialCaller == null) {
                throw new NullPointerException("specialCaller == null");
            }
            if (!m10.isAccessible()) {
                checkSpecialCaller(specialCaller, null);
            }
            MethodType methodType = MethodType.methodType(m10.getReturnType(), m10.getParameterTypes());
            return findSpecial(m10, methodType, m10.getDeclaringClass(), specialCaller);
        }

        public MethodHandle unreflectConstructor(Constructor<?> c4) throws IllegalAccessException {
            if (c4 == null) {
                throw new NullPointerException("c == null");
            }
            if (!c4.isAccessible()) {
                checkAccess(c4.getDeclaringClass(), c4.getDeclaringClass(), c4.getModifiers(), c4.getName());
            }
            return createMethodHandleForConstructor(c4);
        }

        public MethodHandle unreflectGetter(Field f10) throws IllegalAccessException {
            return findAccessor(f10, f10.getDeclaringClass(), f10.getType(), Modifier.isStatic(f10.getModifiers()) ? 10 : 8, !f10.isAccessible());
        }

        public MethodHandle unreflectSetter(Field f10) throws IllegalAccessException {
            return findAccessor(f10, f10.getDeclaringClass(), f10.getType(), Modifier.isStatic(f10.getModifiers()) ? 11 : 9, !f10.isAccessible());
        }

        public VarHandle unreflectVarHandle(Field f10) throws IllegalAccessException {
            boolean isStatic = Modifier.isStatic(f10.getModifiers());
            commonFieldChecks(f10, f10.getDeclaringClass(), f10.getType(), isStatic, true);
            return isStatic ? StaticFieldVarHandle.create(f10) : FieldVarHandle.create(f10);
        }

        public MethodHandleInfo revealDirect(MethodHandle target) {
            MethodHandleImpl directTarget = MethodHandles.getMethodHandleImpl(target);
            MethodHandleInfo info = directTarget.reveal();
            try {
                checkAccess(lookupClass(), info.getDeclaringClass(), info.getModifiers(), info.getName());
                return info;
            } catch (IllegalAccessException exception) {
                throw new IllegalArgumentException("Unable to access memeber.", exception);
            }
        }

        private boolean hasPrivateAccess() {
            return (this.allowedModes & 2) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void checkAccess(Class<?> refc, Class<?> defc, int mods, String methName) throws IllegalAccessException {
            int allowedModes = this.allowedModes;
            if (Modifier.isProtected(mods) && defc == Object.class && "clone".equals(methName) && refc.isArray()) {
                mods ^= 5;
            }
            if (Modifier.isProtected(mods) && Modifier.isConstructor(mods)) {
                mods ^= 4;
            }
            if (Modifier.isPublic(mods) && Modifier.isPublic(refc.getModifiers()) && allowedModes != 0) {
                return;
            }
            int requestedModes = fixmods(mods);
            if ((requestedModes & allowedModes) != 0) {
                if (VerifyAccess.isMemberAccessible(refc, defc, mods, lookupClass(), allowedModes)) {
                    return;
                }
            } else if ((requestedModes & 4) != 0 && (allowedModes & 8) != 0 && VerifyAccess.isSamePackage(defc, lookupClass())) {
                return;
            }
            throwMakeAccessException(accessFailedMessage(refc, defc, mods), this);
        }

        String accessFailedMessage(Class<?> refc, Class<?> defc, int mods) {
            boolean z10 = true;
            boolean classOK = Modifier.isPublic(defc.getModifiers()) && (defc == refc || Modifier.isPublic(refc.getModifiers()));
            if (!classOK && (this.allowedModes & 8) != 0) {
                if (!VerifyAccess.isClassAccessible(defc, lookupClass(), 15) || (defc != refc && !VerifyAccess.isClassAccessible(refc, lookupClass(), 15))) {
                    z10 = false;
                }
                classOK = z10;
            }
            if (!classOK) {
                return "class is not public";
            }
            if (Modifier.isPublic(mods)) {
                return "access to public member failed";
            }
            if (Modifier.isPrivate(mods)) {
                return "member is private";
            }
            if (Modifier.isProtected(mods)) {
                return "member is protected";
            }
            return "member is private to package";
        }

        private void checkSpecialCaller(Class<?> specialCaller, Class<?> refc) throws IllegalAccessException {
            boolean isInterfaceLookup = refc != null && refc.isInterface() && refc.isAssignableFrom(specialCaller);
            if (!hasPrivateAccess() || (specialCaller != lookupClass() && !isInterfaceLookup)) {
                throw new IllegalAccessException("no private access for invokespecial : " + ((Object) specialCaller) + ", from" + ((Object) this));
            }
        }

        private void throwMakeAccessException(String message, Object from) throws IllegalAccessException {
            String message2 = message + ": " + toString();
            if (from != null) {
                message2 = message2 + ", from " + from;
            }
            throw new IllegalAccessException(message2);
        }

        private void checkReturnType(Method method, MethodType methodType) throws NoSuchMethodException {
            if (method.getReturnType() != methodType.rtype()) {
                throw new NoSuchMethodException(method.getName() + ((Object) methodType));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MethodHandleImpl getMethodHandleImpl(MethodHandle target) {
        if (target instanceof Transformers.Construct) {
            target = ((Transformers.Construct) target).getConstructorHandle();
        }
        if (target instanceof Transformers.VarargsCollector) {
            target = target.asFixedArity();
        }
        if (target instanceof MethodHandleImpl) {
            return (MethodHandleImpl) target;
        }
        throw new IllegalArgumentException(((Object) target) + " is not a direct handle");
    }

    public static MethodHandle arrayConstructor(Class<?> arrayClass) throws IllegalArgumentException {
        if (!arrayClass.isArray()) {
            throw MethodHandleStatics.newIllegalArgumentException("not an array class: " + arrayClass.getName());
        }
        return new Transformers.ArrayConstructor(arrayClass);
    }

    public static MethodHandle arrayLength(Class<?> arrayClass) throws IllegalArgumentException {
        if (!arrayClass.isArray()) {
            throw MethodHandleStatics.newIllegalArgumentException("not an array class: " + arrayClass.getName());
        }
        return new Transformers.ArrayLength(arrayClass);
    }

    private static void checkClassIsArray(Class<?> c4) {
        if (!c4.isArray()) {
            throw new IllegalArgumentException("Not an array type: " + ((Object) c4));
        }
    }

    private static void checkTypeIsViewable(Class<?> componentType) {
        if (componentType == Short.TYPE || componentType == Character.TYPE || componentType == Integer.TYPE || componentType == Long.TYPE || componentType == Float.TYPE || componentType == Double.TYPE) {
        } else {
            throw new UnsupportedOperationException("Component type not supported: " + ((Object) componentType));
        }
    }

    public static MethodHandle arrayElementGetter(Class<?> arrayClass) throws IllegalArgumentException {
        checkClassIsArray(arrayClass);
        Class<?> componentType = arrayClass.getComponentType();
        if (componentType.isPrimitive()) {
            try {
                return Lookup.PUBLIC_LOOKUP.findStatic(MethodHandles.class, "arrayElementGetter", MethodType.methodType(componentType, arrayClass, Integer.TYPE));
            } catch (IllegalAccessException | NoSuchMethodException exception) {
                throw new AssertionError(exception);
            }
        }
        return new Transformers.ReferenceArrayElementGetter(arrayClass);
    }

    public static byte arrayElementGetter(byte[] array, int i10) {
        return array[i10];
    }

    public static boolean arrayElementGetter(boolean[] array, int i10) {
        return array[i10];
    }

    public static char arrayElementGetter(char[] array, int i10) {
        return array[i10];
    }

    public static short arrayElementGetter(short[] array, int i10) {
        return array[i10];
    }

    public static int arrayElementGetter(int[] array, int i10) {
        return array[i10];
    }

    public static long arrayElementGetter(long[] array, int i10) {
        return array[i10];
    }

    public static float arrayElementGetter(float[] array, int i10) {
        return array[i10];
    }

    public static double arrayElementGetter(double[] array, int i10) {
        return array[i10];
    }

    public static MethodHandle arrayElementSetter(Class<?> arrayClass) throws IllegalArgumentException {
        checkClassIsArray(arrayClass);
        Class<?> componentType = arrayClass.getComponentType();
        if (componentType.isPrimitive()) {
            try {
                return Lookup.PUBLIC_LOOKUP.findStatic(MethodHandles.class, "arrayElementSetter", MethodType.methodType(Void.TYPE, arrayClass, Integer.TYPE, componentType));
            } catch (IllegalAccessException | NoSuchMethodException exception) {
                throw new AssertionError(exception);
            }
        }
        return new Transformers.ReferenceArrayElementSetter(arrayClass);
    }

    public static void arrayElementSetter(byte[] array, int i10, byte val) {
        array[i10] = val;
    }

    public static void arrayElementSetter(boolean[] array, int i10, boolean val) {
        array[i10] = val;
    }

    public static void arrayElementSetter(char[] array, int i10, char val) {
        array[i10] = val;
    }

    public static void arrayElementSetter(short[] array, int i10, short val) {
        array[i10] = val;
    }

    public static void arrayElementSetter(int[] array, int i10, int val) {
        array[i10] = val;
    }

    public static void arrayElementSetter(long[] array, int i10, long val) {
        array[i10] = val;
    }

    public static void arrayElementSetter(float[] array, int i10, float val) {
        array[i10] = val;
    }

    public static void arrayElementSetter(double[] array, int i10, double val) {
        array[i10] = val;
    }

    public static VarHandle arrayElementVarHandle(Class<?> arrayClass) throws IllegalArgumentException {
        checkClassIsArray(arrayClass);
        return ArrayElementVarHandle.create(arrayClass);
    }

    public static VarHandle byteArrayViewVarHandle(Class<?> viewArrayClass, ByteOrder byteOrder) throws IllegalArgumentException {
        checkClassIsArray(viewArrayClass);
        checkTypeIsViewable(viewArrayClass.getComponentType());
        return ByteArrayViewVarHandle.create(viewArrayClass, byteOrder);
    }

    public static VarHandle byteBufferViewVarHandle(Class<?> viewArrayClass, ByteOrder byteOrder) throws IllegalArgumentException {
        checkClassIsArray(viewArrayClass);
        checkTypeIsViewable(viewArrayClass.getComponentType());
        return ByteBufferViewVarHandle.create(viewArrayClass, byteOrder);
    }

    public static MethodHandle spreadInvoker(MethodType type, int leadingArgCount) {
        if (leadingArgCount < 0 || leadingArgCount > type.parameterCount()) {
            throw MethodHandleStatics.newIllegalArgumentException("bad argument count", Integer.valueOf(leadingArgCount));
        }
        MethodHandle invoker = invoker(type);
        int spreadArgCount = type.parameterCount() - leadingArgCount;
        return invoker.asSpreader(Object[].class, spreadArgCount);
    }

    public static MethodHandle exactInvoker(MethodType type) {
        return new Transformers.Invoker(type, true);
    }

    public static MethodHandle invoker(MethodType type) {
        return new Transformers.Invoker(type, false);
    }

    private static MethodHandle methodHandleForVarHandleAccessor(VarHandle.AccessMode accessMode, MethodType type, boolean isExactInvoker) {
        try {
            Method method = VarHandle.class.getDeclaredMethod(accessMode.methodName(), Object[].class);
            MethodType methodType = type.insertParameterTypes(0, VarHandle.class);
            int kind = isExactInvoker ? 7 : 6;
            return new MethodHandleImpl(method.getArtMethod(), kind, methodType);
        } catch (NoSuchMethodException e2) {
            throw new InternalError("No method for AccessMode " + ((Object) accessMode), e2);
        }
    }

    public static MethodHandle varHandleExactInvoker(VarHandle.AccessMode accessMode, MethodType type) {
        return methodHandleForVarHandleAccessor(accessMode, type, true);
    }

    public static MethodHandle varHandleInvoker(VarHandle.AccessMode accessMode, MethodType type) {
        return methodHandleForVarHandleAccessor(accessMode, type, false);
    }

    public static MethodHandle explicitCastArguments(MethodHandle target, MethodType newType) {
        explicitCastArgumentsChecks(target, newType);
        MethodType oldType = target.type();
        if (oldType == newType) {
            return target;
        }
        if (oldType.explicitCastEquivalentToAsType(newType)) {
            if (Transformers.Transformer.class.isAssignableFrom(target.getClass())) {
                return new Transformers.ExplicitCastArguments(target.asFixedArity(), newType);
            }
            return target.asFixedArity().asType(newType);
        }
        return new Transformers.ExplicitCastArguments(target, newType);
    }

    private static void explicitCastArgumentsChecks(MethodHandle target, MethodType newType) {
        if (target.type().parameterCount() != newType.parameterCount()) {
            throw new WrongMethodTypeException("cannot explicitly cast " + ((Object) target) + " to " + ((Object) newType));
        }
    }

    public static MethodHandle permuteArguments(MethodHandle target, MethodType newType, int... reorder) {
        int[] reorder2 = (int[]) reorder.clone();
        MethodType oldType = target.type();
        permuteArgumentChecks(reorder2, newType, oldType);
        return new Transformers.PermuteArguments(newType, target, reorder2);
    }

    private static boolean permuteArgumentChecks(int[] reorder, MethodType newType, MethodType oldType) {
        if (newType.returnType() != oldType.returnType()) {
            throw MethodHandleStatics.newIllegalArgumentException("return types do not match", oldType, newType);
        }
        if (reorder.length == oldType.parameterCount()) {
            int limit = newType.parameterCount();
            boolean bad = false;
            for (int j10 = 0; j10 < reorder.length; j10++) {
                int i10 = reorder[j10];
                if (i10 < 0 || i10 >= limit) {
                    bad = true;
                    break;
                }
                Class<?> src = newType.parameterType(i10);
                Class<?> dst = oldType.parameterType(j10);
                if (src != dst) {
                    throw MethodHandleStatics.newIllegalArgumentException("parameter types do not match after reorder", oldType, newType);
                }
            }
            if (!bad) {
                return true;
            }
        }
        throw MethodHandleStatics.newIllegalArgumentException("bad reorder array: " + Arrays.toString(reorder));
    }

    public static MethodHandle constant(Class<?> type, Object value) {
        if (type.isPrimitive()) {
            if (type == Void.TYPE) {
                throw MethodHandleStatics.newIllegalArgumentException("void type");
            }
            Wrapper w3 = Wrapper.forPrimitiveType(type);
            Object value2 = w3.convert(value, type);
            if (w3.zero().equals(value2)) {
                return zero(w3, type);
            }
            return insertArguments(identity(type), 0, value2);
        }
        if (value == null) {
            return zero(Wrapper.OBJECT, type);
        }
        return identity(type).bindTo(value);
    }

    public static MethodHandle identity(Class<?> type) {
        Objects.requireNonNull(type);
        Wrapper btw = type.isPrimitive() ? Wrapper.forPrimitiveType(type) : Wrapper.OBJECT;
        int pos = btw.ordinal();
        MethodHandle[] methodHandleArr = IDENTITY_MHS;
        MethodHandle ident = methodHandleArr[pos];
        if (ident == null) {
            ident = setCachedMethodHandle(methodHandleArr, pos, makeIdentity(btw.primitiveType()));
        }
        if (ident.type().returnType() == type) {
            return ident;
        }
        return makeIdentity(type);
    }

    public static MethodHandle zero(Class<?> type) {
        Objects.requireNonNull(type);
        return zero(type.isPrimitive() ? Wrapper.forPrimitiveType(type) : Wrapper.OBJECT, type);
    }

    private static MethodHandle identityOrVoid(Class<?> type) {
        return type == Void.TYPE ? zero(type) : identity(type);
    }

    public static MethodHandle empty(MethodType type) {
        Objects.requireNonNull(type);
        return dropArguments(zero(type.returnType()), 0, type.parameterList());
    }

    private static MethodHandle makeIdentity(Class<?> ptype) {
        if (ptype.isPrimitive()) {
            try {
                MethodType mt = MethodType.methodType(ptype, ptype);
                return Lookup.PUBLIC_LOOKUP.findStatic(MethodHandles.class, "identity", mt);
            } catch (IllegalAccessException | NoSuchMethodException e2) {
                throw new AssertionError(e2);
            }
        }
        return new Transformers.ReferenceIdentity(ptype);
    }

    public static byte identity(byte val) {
        return val;
    }

    public static boolean identity(boolean val) {
        return val;
    }

    public static char identity(char val) {
        return val;
    }

    public static short identity(short val) {
        return val;
    }

    public static int identity(int val) {
        return val;
    }

    public static long identity(long val) {
        return val;
    }

    public static float identity(float val) {
        return val;
    }

    public static double identity(double val) {
        return val;
    }

    private static MethodHandle zero(Wrapper btw, Class<?> rtype) {
        int pos = btw.ordinal();
        MethodHandle[] methodHandleArr = ZERO_MHS;
        MethodHandle zero = methodHandleArr[pos];
        if (zero == null) {
            zero = setCachedMethodHandle(methodHandleArr, pos, makeZero(btw.primitiveType()));
        }
        if (zero.type().returnType() == rtype) {
            return zero;
        }
        return makeZero(rtype);
    }

    private static MethodHandle makeZero(Class<?> rtype) {
        return new Transformers.ZeroValue(rtype);
    }

    private static synchronized MethodHandle setCachedMethodHandle(MethodHandle[] cache, int pos, MethodHandle value) {
        synchronized (MethodHandles.class) {
            MethodHandle prev = cache[pos];
            if (prev != null) {
                return prev;
            }
            cache[pos] = value;
            return value;
        }
    }

    public static MethodHandle insertArguments(MethodHandle target, int pos, Object... values) {
        int insCount = values.length;
        Class<?>[] ptypes = insertArgumentsChecks(target, insCount, pos);
        if (insCount == 0) {
            return target;
        }
        for (int i10 = 0; i10 < insCount; i10++) {
            Class<?> ptype = ptypes[pos + i10];
            if (!ptype.isPrimitive()) {
                ptypes[pos + i10].cast(values[i10]);
            } else {
                values[i10] = Wrapper.forPrimitiveType(ptype).convert(values[i10], ptype);
            }
        }
        return new Transformers.InsertArguments(target, pos, values);
    }

    private static Class<?>[] insertArgumentsChecks(MethodHandle target, int insCount, int pos) throws RuntimeException {
        MethodType oldType = target.type();
        int outargs = oldType.parameterCount();
        int inargs = outargs - insCount;
        if (inargs < 0) {
            throw MethodHandleStatics.newIllegalArgumentException("too many values to insert");
        }
        if (pos < 0 || pos > inargs) {
            throw MethodHandleStatics.newIllegalArgumentException("no argument type to append");
        }
        return oldType.ptypes();
    }

    public static MethodHandle dropArguments(MethodHandle target, int pos, List<Class<?>> valueTypes) {
        return dropArguments0(target, pos, copyTypes(valueTypes.toArray()));
    }

    private static List<Class<?>> copyTypes(Object[] array) {
        return Arrays.asList((Class[]) Arrays.copyOf(array, array.length, Class[].class));
    }

    private static MethodHandle dropArguments0(MethodHandle target, int pos, List<Class<?>> valueTypes) {
        MethodType oldType = target.type();
        int dropped = dropArgumentChecks(oldType, pos, valueTypes);
        MethodType newType = oldType.insertParameterTypes(pos, valueTypes);
        return dropped == 0 ? target : new Transformers.DropArguments(newType, target, pos, dropped);
    }

    private static int dropArgumentChecks(MethodType oldType, int pos, List<Class<?>> valueTypes) {
        int dropped = valueTypes.size();
        MethodType.checkSlotCount(dropped);
        int outargs = oldType.parameterCount();
        int inargs = outargs + dropped;
        if (pos < 0 || pos > outargs) {
            throw MethodHandleStatics.newIllegalArgumentException("no argument type to remove" + ((Object) Arrays.asList(oldType, Integer.valueOf(pos), valueTypes, Integer.valueOf(inargs), Integer.valueOf(outargs))));
        }
        return dropped;
    }

    public static MethodHandle dropArguments(MethodHandle target, int pos, Class<?>... valueTypes) {
        return dropArguments0(target, pos, copyTypes(valueTypes));
    }

    private static MethodHandle dropArgumentsToMatch(MethodHandle target, int skip, List<Class<?>> newTypes, int pos, boolean nullOnFailure) {
        List<Class<?>> newTypes2 = copyTypes(newTypes.toArray());
        List<Class<?>> oldTypes = target.type().parameterList();
        int match = oldTypes.size();
        if (skip != 0) {
            if (skip < 0 || skip > match) {
                throw MethodHandleStatics.newIllegalArgumentException("illegal skip", Integer.valueOf(skip), target);
            }
            oldTypes = oldTypes.subList(skip, match);
            match -= skip;
        }
        List<Class<?>> addTypes = newTypes2;
        int add = addTypes.size();
        if (pos != 0) {
            if (pos < 0 || pos > add) {
                throw MethodHandleStatics.newIllegalArgumentException("illegal pos", Integer.valueOf(pos), newTypes2);
            }
            addTypes = addTypes.subList(pos, add);
            add -= pos;
        }
        if (match > add || !oldTypes.equals(addTypes.subList(0, match))) {
            if (nullOnFailure) {
                return null;
            }
            throw MethodHandleStatics.newIllegalArgumentException("argument lists do not match", oldTypes, newTypes2);
        }
        List<Class<?>> addTypes2 = addTypes.subList(match, add);
        MethodHandle adapter = target;
        if (add - match > 0) {
            adapter = dropArguments0(adapter, skip + match, addTypes2);
        }
        if (pos > 0) {
            return dropArguments0(adapter, skip, newTypes2.subList(0, pos));
        }
        return adapter;
    }

    public static MethodHandle dropArgumentsToMatch(MethodHandle target, int skip, List<Class<?>> newTypes, int pos) {
        Objects.requireNonNull(target);
        Objects.requireNonNull(newTypes);
        return dropArgumentsToMatch(target, skip, newTypes, pos, false);
    }

    public static MethodHandle dropReturn(MethodHandle target) {
        Objects.requireNonNull(target);
        MethodType oldType = target.type();
        Class<?> oldReturnType = oldType.returnType();
        if (oldReturnType == Void.TYPE) {
            return target;
        }
        MethodType newType = oldType.changeReturnType((Class<?>) Void.TYPE);
        return target.asType(newType);
    }

    public static MethodHandle filterArguments(MethodHandle target, int pos, MethodHandle... filters) {
        filterArgumentsCheckArity(target, pos, filters);
        for (int i10 = 0; i10 < filters.length; i10++) {
            filterArgumentChecks(target, i10 + pos, filters[i10]);
        }
        return new Transformers.FilterArguments(target, pos, filters);
    }

    static MethodHandle filterArgument(MethodHandle target, int pos, MethodHandle filter) {
        filterArgumentChecks(target, pos, filter);
        return new Transformers.FilterArguments(target, pos, filter);
    }

    private static void filterArgumentsCheckArity(MethodHandle target, int pos, MethodHandle[] filters) {
        MethodType targetType = target.type();
        int maxPos = targetType.parameterCount();
        if (filters.length + pos > maxPos) {
            throw MethodHandleStatics.newIllegalArgumentException("too many filters");
        }
    }

    private static void filterArgumentChecks(MethodHandle target, int pos, MethodHandle filter) throws RuntimeException {
        MethodType targetType = target.type();
        MethodType filterType = filter.type();
        if (filterType.parameterCount() != 1 || filterType.returnType() != targetType.parameterType(pos)) {
            throw MethodHandleStatics.newIllegalArgumentException("target and filter types do not match", targetType, filterType);
        }
    }

    public static MethodHandle collectArguments(MethodHandle target, int pos, MethodHandle filter) {
        MethodType newType = collectArgumentsChecks(target, pos, filter);
        return new Transformers.CollectArguments(target, filter, pos, newType);
    }

    private static MethodType collectArgumentsChecks(MethodHandle target, int pos, MethodHandle filter) throws RuntimeException {
        MethodType targetType = target.type();
        MethodType filterType = filter.type();
        Class<?> rtype = filterType.returnType();
        List<Class<?>> filterArgs = filterType.parameterList();
        if (rtype == Void.TYPE) {
            return targetType.insertParameterTypes(pos, filterArgs);
        }
        if (rtype != targetType.parameterType(pos)) {
            throw MethodHandleStatics.newIllegalArgumentException("target and filter types do not match", targetType, filterType);
        }
        return targetType.dropParameterTypes(pos, pos + 1).insertParameterTypes(pos, filterArgs);
    }

    public static MethodHandle filterReturnValue(MethodHandle target, MethodHandle filter) {
        MethodType targetType = target.type();
        MethodType filterType = filter.type();
        filterReturnValueChecks(targetType, filterType);
        return new Transformers.FilterReturnValue(target, filter);
    }

    private static void filterReturnValueChecks(MethodType targetType, MethodType filterType) throws RuntimeException {
        Class<?> rtype = targetType.returnType();
        int filterValues = filterType.parameterCount();
        if (filterValues == 0) {
            if (rtype == Void.TYPE) {
                return;
            }
        } else if (rtype == filterType.parameterType(0) && filterValues == 1) {
            return;
        }
        throw MethodHandleStatics.newIllegalArgumentException("target and filter types do not match", targetType, filterType);
    }

    public static MethodHandle foldArguments(MethodHandle target, MethodHandle combiner) {
        return foldArguments(target, 0, combiner);
    }

    public static MethodHandle foldArguments(MethodHandle target, int pos, MethodHandle combiner) {
        MethodType targetType = target.type();
        MethodType combinerType = combiner.type();
        foldArgumentChecks(pos, targetType, combinerType);
        return new Transformers.FoldArguments(target, pos, combiner);
    }

    private static Class<?> foldArgumentChecks(int foldPos, MethodType targetType, MethodType combinerType) {
        int foldArgs = combinerType.parameterCount();
        Class<?> rtype = combinerType.returnType();
        int foldVals = rtype == Void.TYPE ? 0 : 1;
        int afterInsertPos = foldPos + foldVals;
        boolean ok = targetType.parameterCount() >= afterInsertPos + foldArgs;
        if (ok) {
            int i10 = 0;
            while (true) {
                if (i10 >= foldArgs) {
                    break;
                }
                if (combinerType.parameterType(i10) == targetType.parameterType(i10 + afterInsertPos)) {
                    i10++;
                } else {
                    ok = false;
                    break;
                }
            }
        }
        if (ok && foldVals != 0 && combinerType.returnType() != targetType.parameterType(foldPos)) {
            ok = false;
        }
        if (!ok) {
            throw misMatchedTypes("target and combiner types", targetType, combinerType);
        }
        return rtype;
    }

    public static MethodHandle guardWithTest(MethodHandle test, MethodHandle target, MethodHandle fallback) {
        MethodType gtype = test.type();
        MethodType ttype = target.type();
        MethodType ftype = fallback.type();
        if (!ttype.equals((Object) ftype)) {
            throw misMatchedTypes("target and fallback types", ttype, ftype);
        }
        if (gtype.returnType() != Boolean.TYPE) {
            throw MethodHandleStatics.newIllegalArgumentException("guard type is not a predicate " + ((Object) gtype));
        }
        List<Class<?>> targs = ttype.parameterList();
        List<Class<?>> gargs = gtype.parameterList();
        if (!targs.equals(gargs)) {
            int gpc = gargs.size();
            int tpc = targs.size();
            if (gpc >= tpc || !targs.subList(0, gpc).equals(gargs)) {
                throw misMatchedTypes("target and test types", ttype, gtype);
            }
            test = dropArguments(test, gpc, targs.subList(gpc, tpc));
            test.type();
        }
        return new Transformers.GuardWithTest(test, target, fallback);
    }

    static <T> RuntimeException misMatchedTypes(String what, T t12, T t2) {
        return MethodHandleStatics.newIllegalArgumentException(what + " must match: " + ((Object) t12) + " != " + ((Object) t2));
    }

    public static MethodHandle catchException(MethodHandle target, Class<? extends Throwable> exType, MethodHandle handler) {
        MethodType ttype = target.type();
        MethodType htype = handler.type();
        if (!Throwable.class.isAssignableFrom(exType)) {
            throw new ClassCastException(exType.getName());
        }
        if (htype.parameterCount() < 1 || !htype.parameterType(0).isAssignableFrom(exType)) {
            throw MethodHandleStatics.newIllegalArgumentException("handler does not accept exception type " + ((Object) exType));
        }
        if (htype.returnType() == ttype.returnType()) {
            MethodHandle handler2 = dropArgumentsToMatch(handler, 1, ttype.parameterList(), 0, true);
            if (handler2 == null) {
                throw misMatchedTypes("target and handler types", ttype, htype);
            }
            return new Transformers.CatchException(target, handler2, exType);
        }
        throw misMatchedTypes("target and handler return types", ttype, htype);
    }

    public static MethodHandle throwException(Class<?> returnType, Class<? extends Throwable> exType) {
        if (!Throwable.class.isAssignableFrom(exType)) {
            throw new ClassCastException(exType.getName());
        }
        return new Transformers.AlwaysThrow(returnType, exType);
    }

    public static MethodHandle loop(MethodHandle[]... clauses) {
        loopChecks0(clauses);
        final List<MethodHandle> init = new ArrayList<>();
        final List<MethodHandle> step = new ArrayList<>();
        final List<MethodHandle> pred = new ArrayList<>();
        final List<MethodHandle> fini = new ArrayList<>();
        Stream.of((Object[]) clauses).filter(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda9
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean anyMatch;
                anyMatch = Stream.of((Object[]) ((MethodHandle[]) obj)).anyMatch(new MethodHandles$$ExternalSyntheticLambda1());
                return anyMatch;
            }
        }).forEach(new Consumer() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MethodHandles.lambda$loop$1(List.this, step, pred, fini, (MethodHandle[]) obj);
            }
        });
        int nclauses = init.size();
        List<Class<?>> iterationVariableTypes = new ArrayList<>();
        for (int i10 = 0; i10 < nclauses; i10++) {
            MethodHandle in = init.get(i10);
            MethodHandle st = step.get(i10);
            if (in == null && st == null) {
                iterationVariableTypes.add(Void.TYPE);
            } else if (in == null || st == null) {
                iterationVariableTypes.add((in == null ? st.type() : in.type()).returnType());
            } else {
                loopChecks1a(i10, in, st);
                iterationVariableTypes.add(in.type().returnType());
            }
        }
        List<Class<?>> commonPrefix = (List) iterationVariableTypes.stream().filter(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda17
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodHandles.lambda$loop$2((Class) obj);
            }
        }).collect(Collectors.toList());
        List<Class<?>> commonSuffix = buildCommonSuffix(init, step, pred, fini, commonPrefix.size());
        loopChecks1b(init, commonSuffix);
        Stream<Class<?>> cstream = fini.stream().filter(new MethodHandles$$ExternalSyntheticLambda1()).map(new MethodHandles$$ExternalSyntheticLambda2()).map(new MethodHandles$$ExternalSyntheticLambda18());
        Class<?> loopReturnType = cstream.findFirst().orElse(Void.TYPE);
        loopChecks1cd(pred, fini, loopReturnType);
        List<Class<?>> commonParameterSequence = new ArrayList<>(commonPrefix);
        commonParameterSequence.addAll(commonSuffix);
        loopChecks2(step, pred, fini, commonParameterSequence);
        for (int i11 = 0; i11 < nclauses; i11++) {
            Class<?> t2 = iterationVariableTypes.get(i11);
            if (init.get(i11) == null) {
                init.set(i11, empty(MethodType.methodType(t2, commonSuffix)));
            }
            if (step.get(i11) == null) {
                step.set(i11, dropArgumentsToMatch(identityOrVoid(t2), 0, commonParameterSequence, i11));
            }
            if (pred.get(i11) == null) {
                pred.set(i11, dropArguments0(constant(Boolean.TYPE, true), 0, commonParameterSequence));
            }
            if (fini.get(i11) == null) {
                fini.set(i11, empty(MethodType.methodType(t2, commonParameterSequence)));
            }
        }
        List<MethodHandle> finit = fixArities(fillParameterTypes(init, commonSuffix));
        List<MethodHandle> fstep = fixArities(fillParameterTypes(step, commonParameterSequence));
        List<MethodHandle> fpred = fixArities(fillParameterTypes(pred, commonParameterSequence));
        List<MethodHandle> ffini = fixArities(fillParameterTypes(fini, commonParameterSequence));
        return new Transformers.Loop(loopReturnType, commonSuffix, (MethodHandle[]) finit.toArray(new IntFunction() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda11
            @Override // java.util.function.IntFunction
            public final Object apply(int i12) {
                return MethodHandles.lambda$loop$5(i12);
            }
        }), (MethodHandle[]) fstep.toArray(new IntFunction() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda12
            @Override // java.util.function.IntFunction
            public final Object apply(int i12) {
                return MethodHandles.lambda$loop$6(i12);
            }
        }), (MethodHandle[]) fpred.toArray(new IntFunction() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda13
            @Override // java.util.function.IntFunction
            public final Object apply(int i12) {
                return MethodHandles.lambda$loop$7(i12);
            }
        }), (MethodHandle[]) ffini.toArray(new IntFunction() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda14
            @Override // java.util.function.IntFunction
            public final Object apply(int i12) {
                return MethodHandles.lambda$loop$8(i12);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$loop$1(List init, List step, List pred, List fini, MethodHandle[] clause) {
        init.add(clause[0]);
        step.add(clause.length <= 1 ? null : clause[1]);
        pred.add(clause.length <= 2 ? null : clause[2]);
        fini.add(clause.length > 3 ? clause[3] : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$loop$2(Class t2) {
        return t2 != Void.TYPE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MethodHandle[] lambda$loop$5(int x$0) {
        return new MethodHandle[x$0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MethodHandle[] lambda$loop$6(int x$0) {
        return new MethodHandle[x$0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MethodHandle[] lambda$loop$7(int x$0) {
        return new MethodHandle[x$0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MethodHandle[] lambda$loop$8(int x$0) {
        return new MethodHandle[x$0];
    }

    private static void loopChecks0(MethodHandle[][] clauses) {
        if (clauses == null || clauses.length == 0) {
            throw MethodHandleStatics.newIllegalArgumentException("null or no clauses passed");
        }
        if (Stream.of((Object[]) clauses).anyMatch(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda21
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.isNull((MethodHandle[]) obj);
            }
        })) {
            throw MethodHandleStatics.newIllegalArgumentException("null clauses are not allowed");
        }
        if (Stream.of((Object[]) clauses).anyMatch(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda22
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodHandles.lambda$loopChecks0$9((MethodHandle[]) obj);
            }
        })) {
            throw MethodHandleStatics.newIllegalArgumentException("All loop clauses must be represented as MethodHandle arrays with at most 4 elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$loopChecks0$9(MethodHandle[] c4) {
        return c4.length > 4;
    }

    private static void loopChecks1a(int i10, MethodHandle in, MethodHandle st) {
        if (in.type().returnType() != st.type().returnType()) {
            throw misMatchedTypes("clause " + i10 + ": init and step return types", in.type().returnType(), st.type().returnType());
        }
    }

    private static List<Class<?>> longestParameterList(Stream<MethodHandle> mhs, final int skipSize) {
        List<Class<?>> empty = List.of();
        List<Class<?>> longest = (List) mhs.filter(new MethodHandles$$ExternalSyntheticLambda1()).map(new MethodHandles$$ExternalSyntheticLambda2()).filter(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodHandles.lambda$longestParameterList$10(skipSize, (MethodType) obj);
            }
        }).map(new Function() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((MethodType) obj).parameterList();
            }
        }).reduce(new BinaryOperator() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda6
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return MethodHandles.lambda$longestParameterList$11((List) obj, (List) obj2);
            }
        }).orElse(empty);
        return longest.size() == 0 ? empty : longest.subList(skipSize, longest.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$longestParameterList$10(int skipSize, MethodType t2) {
        return t2.parameterCount() > skipSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List lambda$longestParameterList$11(List p10, List q10) {
        return p10.size() >= q10.size() ? p10 : q10;
    }

    private static List<Class<?>> longestParameterList(List<List<Class<?>>> lists) {
        List<Class<?>> empty = List.of();
        return lists.stream().reduce(new BinaryOperator() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda8
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return MethodHandles.lambda$longestParameterList$12((List) obj, (List) obj2);
            }
        }).orElse(empty);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List lambda$longestParameterList$12(List p10, List q10) {
        return p10.size() >= q10.size() ? p10 : q10;
    }

    private static List<Class<?>> buildCommonSuffix(List<MethodHandle> init, List<MethodHandle> step, List<MethodHandle> pred, List<MethodHandle> fini, int cpSize) {
        List<Class<?>> longest1 = longestParameterList(Stream.of((Object[]) new List[]{step, pred, fini}).flatMap(new MethodHandles$$ExternalSyntheticLambda0()), cpSize);
        List<Class<?>> longest2 = longestParameterList(init.stream(), 0);
        return longestParameterList(Arrays.asList(longest1, longest2));
    }

    private static void loopChecks1b(List<MethodHandle> init, final List<Class<?>> commonSuffix) {
        if (init.stream().filter(new MethodHandles$$ExternalSyntheticLambda1()).map(new MethodHandles$$ExternalSyntheticLambda2()).anyMatch(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda20
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodHandles.lambda$loopChecks1b$13(List.this, (MethodType) obj);
            }
        })) {
            throw MethodHandleStatics.newIllegalArgumentException("found non-effectively identical init parameter type lists: " + ((Object) init) + " (common suffix: " + ((Object) commonSuffix) + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$loopChecks1b$13(List commonSuffix, MethodType t2) {
        return !t2.effectivelyIdenticalParameters(0, commonSuffix);
    }

    private static void loopChecks1cd(List<MethodHandle> pred, List<MethodHandle> fini, final Class<?> loopReturnType) {
        if (fini.stream().filter(new MethodHandles$$ExternalSyntheticLambda1()).map(new MethodHandles$$ExternalSyntheticLambda2()).map(new MethodHandles$$ExternalSyntheticLambda18()).anyMatch(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda24
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodHandles.lambda$loopChecks1cd$14(Class.this, (Class) obj);
            }
        })) {
            throw MethodHandleStatics.newIllegalArgumentException("found non-identical finalizer return types: " + ((Object) fini) + " (return type: " + ((Object) loopReturnType) + ")");
        }
        if (!pred.stream().filter(new MethodHandles$$ExternalSyntheticLambda1()).findFirst().isPresent()) {
            throw MethodHandleStatics.newIllegalArgumentException("no predicate found", pred);
        }
        if (pred.stream().filter(new MethodHandles$$ExternalSyntheticLambda1()).map(new MethodHandles$$ExternalSyntheticLambda2()).map(new MethodHandles$$ExternalSyntheticLambda18()).anyMatch(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda25
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodHandles.lambda$loopChecks1cd$15((Class) obj);
            }
        })) {
            throw MethodHandleStatics.newIllegalArgumentException("predicates must have boolean return type", pred);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$loopChecks1cd$14(Class loopReturnType, Class t2) {
        return t2 != loopReturnType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$loopChecks1cd$15(Class t2) {
        return t2 != Boolean.TYPE;
    }

    private static void loopChecks2(List<MethodHandle> step, List<MethodHandle> pred, List<MethodHandle> fini, final List<Class<?>> commonParameterSequence) {
        if (Stream.of((Object[]) new List[]{step, pred, fini}).flatMap(new MethodHandles$$ExternalSyntheticLambda0()).filter(new MethodHandles$$ExternalSyntheticLambda1()).map(new MethodHandles$$ExternalSyntheticLambda2()).anyMatch(new Predicate() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MethodHandles.lambda$loopChecks2$16(List.this, (MethodType) obj);
            }
        })) {
            throw MethodHandleStatics.newIllegalArgumentException("found non-effectively identical parameter type lists:\nstep: " + ((Object) step) + "\npred: " + ((Object) pred) + "\nfini: " + ((Object) fini) + " (common parameter sequence: " + ((Object) commonParameterSequence) + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$loopChecks2$16(List commonParameterSequence, MethodType t2) {
        return !t2.effectivelyIdenticalParameters(0, commonParameterSequence);
    }

    private static List<MethodHandle> fillParameterTypes(List<MethodHandle> hs, final List<Class<?>> targetParams) {
        return (List) hs.stream().map(new Function() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MethodHandles.lambda$fillParameterTypes$17(List.this, (MethodHandle) obj);
            }
        }).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MethodHandle lambda$fillParameterTypes$17(List targetParams, MethodHandle h10) {
        int pc2 = h10.type().parameterCount();
        int tpsize = targetParams.size();
        return pc2 < tpsize ? dropArguments0(h10, pc2, targetParams.subList(pc2, tpsize)) : h10;
    }

    private static List<MethodHandle> fixArities(List<MethodHandle> hs) {
        return (List) hs.stream().map(new Function() { // from class: java.lang.invoke.MethodHandles$$ExternalSyntheticLambda23
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((MethodHandle) obj).asFixedArity();
            }
        }).collect(Collectors.toList());
    }

    public static MethodHandle whileLoop(MethodHandle init, MethodHandle pred, MethodHandle body) {
        whileLoopChecks(init, pred, body);
        MethodHandle fini = identityOrVoid(body.type().returnType());
        MethodHandle[] checkExit = {null, null, pred, fini};
        MethodHandle[] varBody = {init, body};
        return loop(checkExit, varBody);
    }

    public static MethodHandle doWhileLoop(MethodHandle init, MethodHandle body, MethodHandle pred) {
        whileLoopChecks(init, pred, body);
        MethodHandle fini = identityOrVoid(body.type().returnType());
        MethodHandle[] clause = {init, body, pred, fini};
        return loop(clause);
    }

    private static void whileLoopChecks(MethodHandle init, MethodHandle pred, MethodHandle body) {
        Objects.requireNonNull(pred);
        Objects.requireNonNull(body);
        MethodType bodyType = body.type();
        Class<?> returnType = bodyType.returnType();
        List<Class<?>> innerList = bodyType.parameterList();
        List<Class<?>> outerList = innerList;
        if (returnType != Void.TYPE) {
            if (innerList.size() == 0 || innerList.get(0) != returnType) {
                MethodType expected = bodyType.insertParameterTypes(0, returnType);
                throw misMatchedTypes("body function", bodyType, expected);
            }
            outerList = innerList.subList(1, innerList.size());
        }
        MethodType predType = pred.type();
        if (predType.returnType() != Boolean.TYPE || !predType.effectivelyIdenticalParameters(0, innerList)) {
            throw misMatchedTypes("loop predicate", predType, MethodType.methodType(Boolean.TYPE, innerList));
        }
        if (init != null) {
            MethodType initType = init.type();
            if (initType.returnType() != returnType || !initType.effectivelyIdenticalParameters(0, outerList)) {
                throw misMatchedTypes("loop initializer", initType, MethodType.methodType(returnType, outerList));
            }
        }
    }

    public static MethodHandle countedLoop(MethodHandle iterations, MethodHandle init, MethodHandle body) {
        return countedLoop(empty(iterations.type()), iterations, init, body);
    }

    public static MethodHandle countedLoop(MethodHandle start, MethodHandle end, MethodHandle init, MethodHandle body) {
        countedLoopChecks(start, end, init, body);
        Class<?> counterType = start.type().returnType();
        end.type().returnType();
        Class<?> returnType = body.type().returnType();
        MethodHandle incr = getConstantHandle(7);
        MethodHandle pred = getConstantHandle(6);
        MethodHandle retv = null;
        if (returnType != Void.TYPE) {
            incr = dropArguments(incr, 1, (Class<?>[]) new Class[]{returnType});
            pred = dropArguments(pred, 1, (Class<?>[]) new Class[]{returnType});
            retv = dropArguments(identity(returnType), 0, (Class<?>[]) new Class[]{counterType});
        }
        MethodHandle[] loopLimit = {end, null, pred, retv};
        MethodHandle[] bodyClause = {init, dropArguments(body, 0, (Class<?>[]) new Class[]{counterType})};
        MethodHandle[] indexVar = {start, incr};
        return loop(loopLimit, bodyClause, indexVar);
    }

    private static void countedLoopChecks(MethodHandle start, MethodHandle end, MethodHandle init, MethodHandle body) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(end);
        Objects.requireNonNull(body);
        Class<?> counterType = start.type().returnType();
        if (counterType != Integer.TYPE) {
            MethodType expected = start.type();
            throw misMatchedTypes("start function", start.type(), expected.changeReturnType((Class<?>) Integer.TYPE));
        }
        if (end.type().returnType() != counterType) {
            MethodType expected2 = end.type().changeReturnType(counterType);
            throw misMatchedTypes("end function", end.type(), expected2);
        }
        MethodType bodyType = body.type();
        Class<?> returnType = bodyType.returnType();
        List<Class<?>> innerList = bodyType.parameterList();
        int vsize = returnType == Void.TYPE ? 0 : 1;
        if (vsize != 0 && (innerList.size() == 0 || innerList.get(0) != returnType)) {
            MethodType expected3 = bodyType.insertParameterTypes(0, returnType);
            throw misMatchedTypes("body function", bodyType, expected3);
        }
        if (innerList.size() <= vsize || innerList.get(vsize) != counterType) {
            MethodType expected4 = bodyType.insertParameterTypes(vsize, counterType);
            throw misMatchedTypes("body function", bodyType, expected4);
        }
        List<Class<?>> outerList = innerList.subList(vsize + 1, innerList.size());
        if (outerList.isEmpty()) {
            outerList = end.type().parameterList();
            bodyType.insertParameterTypes(vsize + 1, outerList).parameterList();
        }
        MethodType expected5 = MethodType.methodType(counterType, outerList);
        if (!start.type().effectivelyIdenticalParameters(0, outerList)) {
            throw misMatchedTypes("start parameter types", start.type(), expected5);
        }
        if (end.type() != start.type() && !end.type().effectivelyIdenticalParameters(0, outerList)) {
            throw misMatchedTypes("end parameter types", end.type(), expected5);
        }
        if (init != null) {
            MethodType initType = init.type();
            if (initType.returnType() != returnType || !initType.effectivelyIdenticalParameters(0, outerList)) {
                throw misMatchedTypes("loop initializer", initType, MethodType.methodType(returnType, outerList));
            }
        }
    }

    public static MethodHandle iteratedLoop(MethodHandle iterator, MethodHandle init, MethodHandle body) {
        MethodType iteratorType;
        MethodHandle startIter;
        Class<?> iterableType = iteratedLoopChecks(iterator, init, body);
        Class<?> returnType = body.type().returnType();
        MethodHandle hasNext = getConstantHandle(9);
        MethodHandle nextRaw = getConstantHandle(10);
        if (iterator == null) {
            startIter = getConstantHandle(8);
            iteratorType = startIter.type().changeParameterType(0, iterableType);
        } else {
            iteratorType = iterator.type().changeReturnType(Iterator.class);
            startIter = iterator;
        }
        Class<?> ttype = body.type().parameterType(returnType == Void.TYPE ? 0 : 1);
        MethodType nextValType = nextRaw.type().changeReturnType(ttype);
        try {
            MethodHandle startIter2 = startIter.asType(iteratorType);
            MethodHandle nextVal = nextRaw.asType(nextValType);
            MethodHandle retv = null;
            MethodHandle step = body;
            if (returnType != Void.TYPE) {
                retv = dropArguments(identity(returnType), 0, (Class<?>[]) new Class[]{Iterator.class});
                step = swapArguments(body, 0, 1);
            }
            MethodHandle[] iterVar = {startIter2, null, hasNext, retv};
            MethodHandle[] bodyClause = {init, filterArgument(step, 0, nextVal)};
            return loop(iterVar, bodyClause);
        } catch (WrongMethodTypeException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    private static Class<?> iteratedLoopChecks(MethodHandle iterator, MethodHandle init, MethodHandle body) {
        Objects.requireNonNull(body);
        MethodType bodyType = body.type();
        Class<?> returnType = bodyType.returnType();
        List<Class<?>> internalParamList = bodyType.parameterList();
        int vsize = returnType == Void.TYPE ? 0 : 1;
        if (vsize != 0 && (internalParamList.size() == 0 || internalParamList.get(0) != returnType)) {
            MethodType expected = bodyType.insertParameterTypes(0, returnType);
            throw misMatchedTypes("body function", bodyType, expected);
        }
        if (internalParamList.size() <= vsize) {
            MethodType expected2 = bodyType.insertParameterTypes(vsize, Object.class);
            throw misMatchedTypes("body function", bodyType, expected2);
        }
        List<Class<?>> externalParamList = internalParamList.subList(vsize + 1, internalParamList.size());
        Class<?> iterableType = null;
        if (iterator != null) {
            if (externalParamList.isEmpty()) {
                externalParamList = iterator.type().parameterList();
            }
            MethodType itype = iterator.type();
            if (!Iterator.class.isAssignableFrom(itype.returnType())) {
                throw MethodHandleStatics.newIllegalArgumentException("iteratedLoop first argument must have Iterator return type");
            }
            if (!itype.effectivelyIdenticalParameters(0, externalParamList)) {
                MethodType expected3 = MethodType.methodType(itype.returnType(), externalParamList);
                throw misMatchedTypes("iterator parameters", itype, expected3);
            }
        } else if (externalParamList.isEmpty()) {
            externalParamList = Arrays.asList(Iterable.class);
            iterableType = Iterable.class;
        } else {
            Class<?> iterableType2 = externalParamList.get(0);
            iterableType = iterableType2;
            if (!Iterable.class.isAssignableFrom(iterableType)) {
                throw MethodHandleStatics.newIllegalArgumentException("inferred first loop argument must inherit from Iterable: " + ((Object) iterableType));
            }
        }
        if (init != null) {
            MethodType initType = init.type();
            if (initType.returnType() != returnType || !initType.effectivelyIdenticalParameters(0, externalParamList)) {
                throw misMatchedTypes("loop initializer", initType, MethodType.methodType(returnType, externalParamList));
            }
        }
        return iterableType;
    }

    static MethodHandle swapArguments(MethodHandle mh, int i10, int j10) {
        int arity = mh.type().parameterCount();
        int[] order = new int[arity];
        for (int k10 = 0; k10 < arity; k10++) {
            order[k10] = k10;
        }
        order[i10] = j10;
        order[j10] = i10;
        Class<?>[] types = mh.type().parameterArray();
        Class<?> ti = types[i10];
        types[i10] = types[j10];
        types[j10] = ti;
        MethodType swapType = MethodType.methodType(mh.type().returnType(), types);
        return permuteArguments(mh, swapType, order);
    }

    public static MethodHandle tryFinally(MethodHandle target, MethodHandle cleanup) {
        List<Class<?>> targetParamTypes = target.type().parameterList();
        Class<?> rtype = target.type().returnType();
        tryFinallyChecks(target, cleanup);
        MethodHandle cleanup2 = dropArgumentsToMatch(cleanup, rtype == Void.TYPE ? 1 : 2, targetParamTypes, 0);
        return new Transformers.TryFinally(target.asFixedArity(), cleanup2.asType(cleanup2.type().changeParameterType(0, Throwable.class)).asFixedArity());
    }

    private static void tryFinallyChecks(MethodHandle target, MethodHandle cleanup) {
        Class<?> rtype = target.type().returnType();
        if (rtype != cleanup.type().returnType()) {
            throw misMatchedTypes("target and return types", cleanup.type().returnType(), rtype);
        }
        MethodType cleanupType = cleanup.type();
        if (!Throwable.class.isAssignableFrom(cleanupType.parameterType(0))) {
            throw misMatchedTypes("cleanup first argument and Throwable", cleanup.type(), Throwable.class);
        }
        if (rtype != Void.TYPE && cleanupType.parameterType(1) != rtype) {
            throw misMatchedTypes("cleanup second argument and target return type", cleanup.type(), rtype);
        }
        int cleanupArgIndex = rtype != Void.TYPE ? 2 : 1;
        if (!cleanupType.effectivelyIdenticalParameters(cleanupArgIndex, target.type().parameterList())) {
            throw misMatchedTypes("cleanup parameters after (Throwable,result) and target parameter list prefix", cleanup.type(), target.type());
        }
    }

    public static MethodHandle tableSwitch(MethodHandle fallback, MethodHandle... targets) {
        Objects.requireNonNull(fallback);
        Objects.requireNonNull(targets);
        MethodHandle[] targets2 = (MethodHandle[]) targets.clone();
        MethodType type = tableSwitchChecks(fallback, targets2);
        return new Transformers.TableSwitch(type, fallback, targets2);
    }

    private static MethodType tableSwitchChecks(MethodHandle defaultCase, MethodHandle[] caseActions) {
        if (caseActions.length == 0) {
            throw new IllegalArgumentException("Not enough cases: " + Arrays.toString(caseActions));
        }
        MethodType expectedType = defaultCase.type();
        if (expectedType.parameterCount() >= 1) {
            if (expectedType.parameterType(0) == Integer.TYPE) {
                for (MethodHandle mh : caseActions) {
                    Objects.requireNonNull(mh);
                    if (!mh.type().equals((Object) expectedType)) {
                        throw new IllegalArgumentException("Case actions must have the same type: " + Arrays.toString(caseActions));
                    }
                }
                return expectedType;
            }
        }
        throw new IllegalArgumentException("Case actions must have int as leading parameter: " + Arrays.toString(caseActions));
    }

    public static boolean countedLoopPredicate(int limit, int counter) {
        return counter < limit;
    }

    public static int countedLoopStep(int limit, int counter) {
        return counter + 1;
    }

    public static Iterator<?> initIterator(Iterable<?> it) {
        return it.iterator2();
    }

    public static boolean iteratePredicate(Iterator<?> it) {
        return it.hasNext();
    }

    public static Object iterateNext(Iterator<?> it) {
        return it.next();
    }

    static MethodHandle getConstantHandle(int idx) {
        MethodHandle handle = HANDLES[idx];
        if (handle != null) {
            return handle;
        }
        return setCachedHandle(idx, makeConstantHandle(idx));
    }

    private static synchronized MethodHandle setCachedHandle(int idx, MethodHandle method) {
        synchronized (MethodHandles.class) {
            MethodHandle[] methodHandleArr = HANDLES;
            MethodHandle prev = methodHandleArr[idx];
            if (prev != null) {
                return prev;
            }
            methodHandleArr[idx] = method;
            return method;
        }
    }

    private static MethodHandle makeConstantHandle(int idx) {
        try {
            Lookup IMPL_LOOKUP = Lookup.IMPL_LOOKUP;
            switch (idx) {
                case 6:
                    return IMPL_LOOKUP.findStatic(MethodHandles.class, "countedLoopPredicate", MethodType.methodType(Boolean.TYPE, Integer.TYPE, Integer.TYPE));
                case 7:
                    return IMPL_LOOKUP.findStatic(MethodHandles.class, "countedLoopStep", MethodType.methodType(Integer.TYPE, Integer.TYPE, Integer.TYPE));
                case 8:
                    return IMPL_LOOKUP.findStatic(MethodHandles.class, "initIterator", MethodType.methodType((Class<?>) Iterator.class, (Class<?>) Iterable.class));
                case 9:
                    return IMPL_LOOKUP.findStatic(MethodHandles.class, "iteratePredicate", MethodType.methodType(Boolean.TYPE, (Class<?>) Iterator.class));
                case 10:
                    return IMPL_LOOKUP.findStatic(MethodHandles.class, "iterateNext", MethodType.methodType((Class<?>) Object.class, (Class<?>) Iterator.class));
                default:
                    throw MethodHandleStatics.newInternalError("Unknown function index: " + idx);
            }
        } catch (ReflectiveOperationException ex) {
            throw MethodHandleStatics.newInternalError(ex);
        }
    }
}
