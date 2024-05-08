package java.lang.runtime;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.TypeDescriptor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ObjectMethods {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final MethodHandle CLASS_IS_INSTANCE;
    private static final MethodHandle HASH_COMBINER;
    private static final MethodHandle OBJECTS_EQUALS;
    private static final MethodHandle OBJECTS_HASHCODE;
    private static final MethodHandle OBJECTS_TOSTRING;
    private static final MethodHandle OBJECT_EQ;
    private static final MethodHandle OBJECT_EQUALS;
    private static final MethodHandle OBJECT_HASHCODE;
    private static final MethodHandle OBJECT_TO_STRING;
    private static final MethodHandle STRING_FORMAT;
    private static final HashMap<Class<?>, MethodHandle> primitiveEquals;
    private static final HashMap<Class<?>, MethodHandle> primitiveHashers;
    private static final HashMap<Class<?>, MethodHandle> primitiveToString;
    private static final MethodType DESCRIPTOR_MT = MethodType.methodType(MethodType.class);
    private static final MethodType NAMES_MT = MethodType.methodType(List.class);
    private static final MethodHandle FALSE = MethodHandles.constant(Boolean.TYPE, false);
    private static final MethodHandle TRUE = MethodHandles.constant(Boolean.TYPE, true);
    private static final MethodHandle ZERO = MethodHandles.constant(Integer.TYPE, 0);

    static {
        HashMap<Class<?>, MethodHandle> hashMap = new HashMap<>();
        primitiveEquals = hashMap;
        HashMap<Class<?>, MethodHandle> hashMap2 = new HashMap<>();
        primitiveHashers = hashMap2;
        HashMap<Class<?>, MethodHandle> hashMap3 = new HashMap<>();
        primitiveToString = hashMap3;
        try {
            MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            ClassLoader loader = ObjectMethods.class.getClassLoader();
            CLASS_IS_INSTANCE = publicLookup.findVirtual(Class.class, "isInstance", MethodType.methodType(Boolean.TYPE, (Class<?>) Object.class));
            OBJECT_EQUALS = publicLookup.findVirtual(Object.class, "equals", MethodType.methodType(Boolean.TYPE, (Class<?>) Object.class));
            OBJECT_HASHCODE = publicLookup.findVirtual(Object.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("()I", loader));
            OBJECT_TO_STRING = publicLookup.findVirtual(Object.class, "toString", MethodType.methodType(String.class));
            STRING_FORMAT = publicLookup.findStatic(String.class, "format", MethodType.methodType(String.class, String.class, Object[].class));
            OBJECTS_EQUALS = publicLookup.findStatic(Objects.class, "equals", MethodType.methodType(Boolean.TYPE, Object.class, Object.class));
            OBJECTS_HASHCODE = publicLookup.findStatic(Objects.class, TTDownloadField.TT_HASHCODE, MethodType.methodType(Integer.TYPE, (Class<?>) Object.class));
            OBJECTS_TOSTRING = publicLookup.findStatic(Objects.class, "toString", MethodType.methodType((Class<?>) String.class, (Class<?>) Object.class));
            OBJECT_EQ = lookup.findStatic(ObjectMethods.class, "eq", MethodType.methodType(Boolean.TYPE, Object.class, Object.class));
            HASH_COMBINER = lookup.findStatic(ObjectMethods.class, "hashCombiner", MethodType.fromMethodDescriptorString("(II)I", loader));
            hashMap.put(Byte.TYPE, lookup.findStatic(ObjectMethods.class, "eq", MethodType.fromMethodDescriptorString("(BB)Z", loader)));
            hashMap.put(Short.TYPE, lookup.findStatic(ObjectMethods.class, "eq", MethodType.fromMethodDescriptorString("(SS)Z", loader)));
            hashMap.put(Character.TYPE, lookup.findStatic(ObjectMethods.class, "eq", MethodType.fromMethodDescriptorString("(CC)Z", loader)));
            hashMap.put(Integer.TYPE, lookup.findStatic(ObjectMethods.class, "eq", MethodType.fromMethodDescriptorString("(II)Z", loader)));
            hashMap.put(Long.TYPE, lookup.findStatic(ObjectMethods.class, "eq", MethodType.fromMethodDescriptorString("(JJ)Z", loader)));
            hashMap.put(Float.TYPE, lookup.findStatic(ObjectMethods.class, "eq", MethodType.fromMethodDescriptorString("(FF)Z", loader)));
            hashMap.put(Double.TYPE, lookup.findStatic(ObjectMethods.class, "eq", MethodType.fromMethodDescriptorString("(DD)Z", loader)));
            hashMap.put(Boolean.TYPE, lookup.findStatic(ObjectMethods.class, "eq", MethodType.fromMethodDescriptorString("(ZZ)Z", loader)));
            hashMap2.put(Byte.TYPE, lookup.findStatic(Byte.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("(B)I", loader)));
            hashMap2.put(Short.TYPE, lookup.findStatic(Short.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("(S)I", loader)));
            hashMap2.put(Character.TYPE, lookup.findStatic(Character.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("(C)I", loader)));
            hashMap2.put(Integer.TYPE, lookup.findStatic(Integer.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("(I)I", loader)));
            hashMap2.put(Long.TYPE, lookup.findStatic(Long.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("(J)I", loader)));
            hashMap2.put(Float.TYPE, lookup.findStatic(Float.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("(F)I", loader)));
            hashMap2.put(Double.TYPE, lookup.findStatic(Double.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("(D)I", loader)));
            hashMap2.put(Boolean.TYPE, lookup.findStatic(Boolean.class, TTDownloadField.TT_HASHCODE, MethodType.fromMethodDescriptorString("(Z)I", loader)));
            hashMap3.put(Byte.TYPE, lookup.findStatic(Byte.class, "toString", MethodType.methodType((Class<?>) String.class, Byte.TYPE)));
            hashMap3.put(Short.TYPE, lookup.findStatic(Short.class, "toString", MethodType.methodType((Class<?>) String.class, Short.TYPE)));
            hashMap3.put(Character.TYPE, lookup.findStatic(Character.class, "toString", MethodType.methodType((Class<?>) String.class, Character.TYPE)));
            hashMap3.put(Integer.TYPE, lookup.findStatic(Integer.class, "toString", MethodType.methodType((Class<?>) String.class, Integer.TYPE)));
            hashMap3.put(Long.TYPE, lookup.findStatic(Long.class, "toString", MethodType.methodType((Class<?>) String.class, Long.TYPE)));
            hashMap3.put(Float.TYPE, lookup.findStatic(Float.class, "toString", MethodType.methodType((Class<?>) String.class, Float.TYPE)));
            hashMap3.put(Double.TYPE, lookup.findStatic(Double.class, "toString", MethodType.methodType((Class<?>) String.class, Double.TYPE)));
            hashMap3.put(Boolean.TYPE, lookup.findStatic(Boolean.class, "toString", MethodType.methodType((Class<?>) String.class, Boolean.TYPE)));
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException(e2);
        }
    }

    private ObjectMethods() {
    }

    private static int hashCombiner(int x10, int y10) {
        return (x10 * 31) + y10;
    }

    private static boolean eq(Object a10, Object b4) {
        return a10 == b4;
    }

    private static boolean eq(byte a10, byte b4) {
        return a10 == b4;
    }

    private static boolean eq(short a10, short b4) {
        return a10 == b4;
    }

    private static boolean eq(char a10, char b4) {
        return a10 == b4;
    }

    private static boolean eq(int a10, int b4) {
        return a10 == b4;
    }

    private static boolean eq(long a10, long b4) {
        return a10 == b4;
    }

    private static boolean eq(float a10, float b4) {
        return Float.compare(a10, b4) == 0;
    }

    private static boolean eq(double a10, double b4) {
        return Double.compare(a10, b4) == 0;
    }

    private static boolean eq(boolean a10, boolean b4) {
        return a10 == b4;
    }

    private static MethodHandle equalator(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            return primitiveEquals.get(clazz);
        }
        return OBJECTS_EQUALS.asType(MethodType.methodType(Boolean.TYPE, clazz, clazz));
    }

    private static MethodHandle hasher(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            return primitiveHashers.get(clazz);
        }
        return OBJECTS_HASHCODE.asType(MethodType.methodType(Integer.TYPE, clazz));
    }

    private static MethodHandle stringifier(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            return primitiveToString.get(clazz);
        }
        return OBJECTS_TOSTRING.asType(MethodType.methodType((Class<?>) String.class, clazz));
    }

    private static MethodHandle makeEquals(Class<?> receiverClass, List<MethodHandle> getters) {
        MethodType rr = MethodType.methodType(Boolean.TYPE, receiverClass, receiverClass);
        MethodType ro = MethodType.methodType(Boolean.TYPE, receiverClass, Object.class);
        MethodHandle instanceFalse = MethodHandles.dropArguments(FALSE, 0, (Class<?>[]) new Class[]{receiverClass, Object.class});
        MethodHandle methodHandle = TRUE;
        MethodHandle instanceTrue = MethodHandles.dropArguments(methodHandle, 0, (Class<?>[]) new Class[]{receiverClass, Object.class});
        MethodHandle isSameObject = OBJECT_EQ.asType(ro);
        MethodHandle isInstance = MethodHandles.dropArguments(CLASS_IS_INSTANCE.bindTo(receiverClass), 0, (Class<?>[]) new Class[]{receiverClass});
        MethodHandle accumulator = MethodHandles.dropArguments(methodHandle, 0, (Class<?>[]) new Class[]{receiverClass, receiverClass});
        for (MethodHandle getter : getters) {
            MethodHandle equalator = equalator(getter.type().returnType());
            MethodHandle thisFieldEqual = MethodHandles.filterArguments(equalator, 0, getter, getter);
            accumulator = MethodHandles.guardWithTest(thisFieldEqual, accumulator, instanceFalse.asType(rr));
        }
        return MethodHandles.guardWithTest(isSameObject, instanceTrue, MethodHandles.guardWithTest(isInstance, accumulator.asType(ro), instanceFalse));
    }

    private static MethodHandle makeHashCode(Class<?> receiverClass, List<MethodHandle> getters) {
        MethodHandle accumulator = MethodHandles.dropArguments(ZERO, 0, (Class<?>[]) new Class[]{receiverClass});
        for (MethodHandle getter : getters) {
            MethodHandle hasher = hasher(getter.type().returnType());
            MethodHandle hashThisField = MethodHandles.filterArguments(hasher, 0, getter);
            MethodHandle combineHashes = MethodHandles.filterArguments(HASH_COMBINER, 0, accumulator, hashThisField);
            accumulator = MethodHandles.permuteArguments(combineHashes, accumulator.type(), 0, 0);
        }
        return accumulator;
    }

    private static MethodHandle makeToString(Class<?> receiverClass, List<MethodHandle> getters, List<String> names) {
        int[] invArgs = new int[getters.size()];
        Arrays.fill(invArgs, 0);
        MethodHandle[] filters = new MethodHandle[getters.size()];
        StringBuilder sb2 = new StringBuilder();
        sb2.append(receiverClass.getSimpleName()).append("[");
        for (int i10 = 0; i10 < getters.size(); i10++) {
            MethodHandle getter = getters.get(i10);
            MethodHandle stringify = stringifier(getter.type().returnType());
            MethodHandle stringifyThisField = MethodHandles.filterArguments(stringify, 0, getter);
            filters[i10] = stringifyThisField;
            sb2.append(names.get(i10)).append("=%s");
            if (i10 != getters.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
        String formatString = sb2.toString();
        MethodHandle formatter = MethodHandles.insertArguments(STRING_FORMAT, 0, formatString).asCollector(String[].class, getters.size());
        if (getters.size() == 0) {
            return MethodHandles.dropArguments(formatter, 0, (Class<?>[]) new Class[]{receiverClass});
        }
        MethodHandle filtered = MethodHandles.filterArguments(formatter, 0, filters);
        return MethodHandles.permuteArguments(filtered, MethodType.methodType((Class<?>) String.class, receiverClass), invArgs);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Object bootstrap(MethodHandles.Lookup lookup, String methodName, TypeDescriptor type, Class<?> recordClass, String names, MethodHandle... getters) throws Throwable {
        MethodType methodType;
        char c4;
        MethodHandle makeEquals;
        if (type instanceof MethodType) {
            methodType = (MethodType) type;
        } else {
            methodType = null;
            if (!MethodHandle.class.equals(type)) {
                throw new IllegalArgumentException(type.toString());
            }
        }
        List<MethodHandle> getterList = List.of((Object[]) getters);
        switch (methodName.hashCode()) {
            case -1776922004:
                if (methodName.equals("toString")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -1295482945:
                if (methodName.equals("equals")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 147696667:
                if (methodName.equals(TTDownloadField.TT_HASHCODE)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                if (methodType != null && !methodType.equals((Object) MethodType.methodType(Boolean.TYPE, recordClass, Object.class))) {
                    throw new IllegalArgumentException("Bad method type: " + ((Object) methodType));
                }
                makeEquals = makeEquals(recordClass, getterList);
                break;
            case 1:
                if (methodType != null && !methodType.equals((Object) MethodType.methodType(Integer.TYPE, recordClass))) {
                    throw new IllegalArgumentException("Bad method type: " + ((Object) methodType));
                }
                makeEquals = makeHashCode(recordClass, getterList);
                break;
            case 2:
                if (methodType != null && !methodType.equals((Object) MethodType.methodType((Class<?>) String.class, recordClass))) {
                    throw new IllegalArgumentException("Bad method type: " + ((Object) methodType));
                }
                List<String> nameList = "".equals(names) ? List.of() : List.of((Object[]) names.split(";"));
                if (nameList.size() != getterList.size()) {
                    throw new IllegalArgumentException("Name list and accessor list do not match");
                }
                makeEquals = makeToString(recordClass, getterList, nameList);
                break;
                break;
            default:
                throw new IllegalArgumentException(methodName);
        }
        MethodHandle handle = makeEquals;
        return methodType != null ? new ConstantCallSite(handle) : handle;
    }
}
