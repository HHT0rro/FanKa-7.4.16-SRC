package sun.invoke.util;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum Wrapper {
    BOOLEAN(Boolean.class, "Boolean", Boolean.TYPE, "boolean", 'Z', new boolean[0], Format.unsigned(1)),
    BYTE(Byte.class, "Byte", Byte.TYPE, "byte", 'B', new byte[0], Format.signed(8)),
    SHORT(Short.class, "Short", Short.TYPE, "short", 'S', new short[0], Format.signed(16)),
    CHAR(Character.class, "Character", Character.TYPE, "char", 'C', new char[0], Format.unsigned(16)),
    INT(Integer.class, "Integer", Integer.TYPE, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, 'I', new int[0], Format.signed(32)),
    LONG(Long.class, "Long", Long.TYPE, "long", 'J', new long[0], Format.signed(64)),
    FLOAT(Float.class, "Float", Float.TYPE, "float", 'F', new float[0], Format.floating(32)),
    DOUBLE(Double.class, "Double", Double.TYPE, "double", 'D', new double[0], Format.floating(64)),
    OBJECT(Object.class, "Object", Object.class, "Object", 'L', new Object[0], Format.other(1)),
    VOID(Void.class, "Void", Void.TYPE, "void", 'V', null, Format.other(0));

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int COUNT = 10;
    private final char basicTypeChar;
    private final String basicTypeString;
    private final Object emptyArray;
    private final int format;
    private final String primitiveSimpleName;
    private final Class<?> primitiveType;
    private final String wrapperSimpleName;
    private final Class<?> wrapperType;
    private static final Object DOUBLE_ZERO = Double.valueOf(ShadowDrawableWrapper.COS_45);
    private static final Object FLOAT_ZERO = Float.valueOf(0.0f);
    private static final Wrapper[] FROM_PRIM = new Wrapper[16];
    private static final Wrapper[] FROM_WRAP = new Wrapper[16];
    private static final Wrapper[] FROM_CHAR = new Wrapper[16];

    static {
        for (Wrapper w3 : values()) {
            int pi = hashPrim(w3.primitiveType);
            int wi = hashWrap(w3.wrapperType);
            int ci = hashChar(w3.basicTypeChar);
            FROM_PRIM[pi] = w3;
            FROM_WRAP[wi] = w3;
            FROM_CHAR[ci] = w3;
        }
    }

    Wrapper(Class cls, String wtypeName, Class cls2, String ptypeName, char tchar, Object emptyArray, int format) {
        this.wrapperType = cls;
        this.primitiveType = cls2;
        this.basicTypeChar = tchar;
        this.basicTypeString = String.valueOf(tchar);
        this.emptyArray = emptyArray;
        this.format = format;
        this.wrapperSimpleName = wtypeName;
        this.primitiveSimpleName = ptypeName;
    }

    public String detailString() {
        return this.wrapperSimpleName + ((Object) Arrays.asList(this.wrapperType, this.primitiveType, Character.valueOf(this.basicTypeChar), zero(), "0x" + Integer.toHexString(this.format)));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static abstract class Format {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int BOOLEAN = 5;
        static final int CHAR = 65;
        static final int FLOAT = 4225;
        static final int FLOATING = 4096;
        static final int INT = -3967;
        static final int KIND_SHIFT = 12;
        static final int NUM_MASK = -4;
        static final int SHORT = -4031;
        static final int SIGNED = -4096;
        static final int SIZE_MASK = 1023;
        static final int SIZE_SHIFT = 2;
        static final int SLOT_MASK = 3;
        static final int SLOT_SHIFT = 0;
        static final int UNSIGNED = 0;
        static final int VOID = 0;

        private Format() {
        }

        static int format(int kind, int size, int slots) {
            return (size << 2) | kind | (slots << 0);
        }

        static int signed(int size) {
            return format(SIGNED, size, size > 32 ? 2 : 1);
        }

        static int unsigned(int size) {
            return format(0, size, size > 32 ? 2 : 1);
        }

        static int floating(int size) {
            return format(4096, size, size > 32 ? 2 : 1);
        }

        static int other(int slots) {
            return slots << 0;
        }
    }

    public int bitWidth() {
        return (this.format >> 2) & 1023;
    }

    public int stackSlots() {
        return (this.format >> 0) & 3;
    }

    public boolean isSingleWord() {
        return (this.format & 1) != 0;
    }

    public boolean isDoubleWord() {
        return (this.format & 2) != 0;
    }

    public boolean isNumeric() {
        return (this.format & (-4)) != 0;
    }

    public boolean isIntegral() {
        return isNumeric() && this.format < 4225;
    }

    public boolean isSubwordOrInt() {
        return isIntegral() && isSingleWord();
    }

    public boolean isSigned() {
        return this.format < 0;
    }

    public boolean isUnsigned() {
        int i10 = this.format;
        return i10 >= 5 && i10 < 4225;
    }

    public boolean isFloating() {
        return this.format >= 4225;
    }

    public boolean isOther() {
        return (this.format & (-4)) == 0;
    }

    public boolean isConvertibleFrom(Wrapper source) {
        if (this == source) {
            return true;
        }
        if (compareTo(source) < 0) {
            return false;
        }
        boolean floatOrSigned = ((this.format & source.format) & (-4096)) != 0;
        return floatOrSigned || isOther() || source.format == 65;
    }

    private static boolean checkConvertibleFrom() {
        for (Wrapper w3 : values()) {
            Wrapper wrapper = VOID;
            if (w3 != wrapper) {
            }
            if (w3 == CHAR || !w3.isConvertibleFrom(INT)) {
            }
            if (w3 == BOOLEAN || w3 == wrapper || w3 != OBJECT) {
            }
            if (w3.isSigned()) {
                for (Wrapper x10 : values()) {
                    if (w3 != x10 && !x10.isFloating() && x10.isSigned()) {
                        w3.compareTo(x10);
                    }
                }
            }
            if (w3.isFloating()) {
                for (Wrapper x11 : values()) {
                    if (w3 != x11 && !x11.isSigned() && x11.isFloating()) {
                        w3.compareTo(x11);
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: sun.invoke.util.Wrapper$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$sun$invoke$util$Wrapper;

        static {
            int[] iArr = new int[Wrapper.values().length];
            $SwitchMap$sun$invoke$util$Wrapper = iArr;
            try {
                iArr[Wrapper.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.INT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.CHAR.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.SHORT.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.LONG.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.VOID.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$sun$invoke$util$Wrapper[Wrapper.OBJECT.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    public Object zero() {
        switch (AnonymousClass1.$SwitchMap$sun$invoke$util$Wrapper[ordinal()]) {
            case 1:
                return Boolean.FALSE;
            case 2:
                return 0;
            case 3:
                return (byte) 0;
            case 4:
                return (char) 0;
            case 5:
                return (short) 0;
            case 6:
                return 0L;
            case 7:
                return FLOAT_ZERO;
            case 8:
                return DOUBLE_ZERO;
            default:
                return null;
        }
    }

    public <T> T zero(Class<T> cls) {
        return (T) convert(zero(), cls);
    }

    public static Wrapper forPrimitiveType(Class<?> type) {
        Wrapper w3 = findPrimitiveType(type);
        if (w3 != null) {
            return w3;
        }
        if (type.isPrimitive()) {
            throw new InternalError();
        }
        throw newIllegalArgumentException("not primitive: " + ((Object) type));
    }

    public static Wrapper forPrimitiveType(char basicTypeChar) {
        switch (basicTypeChar) {
            case 'B':
                return BYTE;
            case 'C':
                return CHAR;
            case 'D':
                return DOUBLE;
            case 'F':
                return FLOAT;
            case 'I':
                return INT;
            case 'J':
                return LONG;
            case 'S':
                return SHORT;
            case 'V':
                return VOID;
            case 'Z':
                return BOOLEAN;
            default:
                throw newIllegalArgumentException("not primitive: " + basicTypeChar);
        }
    }

    static Wrapper findPrimitiveType(Class<?> type) {
        Wrapper w3 = FROM_PRIM[hashPrim(type)];
        if (w3 != null && w3.primitiveType == type) {
            return w3;
        }
        return null;
    }

    public static Wrapper forWrapperType(Class<?> type) {
        Wrapper w3 = findWrapperType(type);
        if (w3 != null) {
            return w3;
        }
        for (Wrapper x10 : values()) {
            if (x10.wrapperType == type) {
                throw new InternalError();
            }
        }
        throw newIllegalArgumentException("not wrapper: " + ((Object) type));
    }

    static Wrapper findWrapperType(Class<?> type) {
        Wrapper w3 = FROM_WRAP[hashWrap(type)];
        if (w3 != null && w3.wrapperType == type) {
            return w3;
        }
        return null;
    }

    public static Wrapper forBasicType(char type) {
        Wrapper w3 = FROM_CHAR[hashChar(type)];
        if (w3 != null && w3.basicTypeChar == type) {
            return w3;
        }
        for (Wrapper wrapper : values()) {
            if (w3.basicTypeChar == type) {
                throw new InternalError();
            }
        }
        throw newIllegalArgumentException("not basic type char: " + type);
    }

    public static Wrapper forBasicType(Class<?> type) {
        if (type.isPrimitive()) {
            return forPrimitiveType(type);
        }
        return OBJECT;
    }

    private static int hashPrim(Class<?> x10) {
        String xn = x10.getName();
        if (xn.length() < 3) {
            return 0;
        }
        return (xn.charAt(0) + xn.charAt(2)) % 16;
    }

    private static int hashWrap(Class<?> x10) {
        String xn = x10.getName();
        if (xn.length() < 13) {
            return 0;
        }
        return ((xn.charAt(11) * 3) + xn.charAt(12)) % 16;
    }

    private static int hashChar(char x10) {
        return ((x10 >> 1) + x10) % 16;
    }

    public Class<?> primitiveType() {
        return this.primitiveType;
    }

    public Class<?> wrapperType() {
        return this.wrapperType;
    }

    public <T> Class<T> wrapperType(Class<T> exampleType) {
        Class<?> cls = this.wrapperType;
        if (exampleType == cls) {
            return exampleType;
        }
        if (exampleType == this.primitiveType || cls == Object.class || exampleType.isInterface()) {
            return forceType(this.wrapperType, exampleType);
        }
        throw newClassCastException(exampleType, this.primitiveType);
    }

    private static ClassCastException newClassCastException(Class<?> actual, Class<?> expected) {
        return new ClassCastException(((Object) actual) + " is not compatible with " + ((Object) expected));
    }

    public static <T> Class<T> asWrapperType(Class<T> type) {
        if (type.isPrimitive()) {
            return forPrimitiveType((Class<?>) type).wrapperType(type);
        }
        return type;
    }

    public static <T> Class<T> asPrimitiveType(Class<T> type) {
        Wrapper w3 = findWrapperType(type);
        if (w3 != null) {
            return forceType(w3.primitiveType(), type);
        }
        return type;
    }

    public static boolean isWrapperType(Class<?> type) {
        return findWrapperType(type) != null;
    }

    public static boolean isPrimitiveType(Class<?> type) {
        return type.isPrimitive();
    }

    public static char basicTypeChar(Class<?> type) {
        if (!type.isPrimitive()) {
            return 'L';
        }
        return forPrimitiveType(type).basicTypeChar();
    }

    public char basicTypeChar() {
        return this.basicTypeChar;
    }

    public String basicTypeString() {
        return this.basicTypeString;
    }

    public String wrapperSimpleName() {
        return this.wrapperSimpleName;
    }

    public String primitiveSimpleName() {
        return this.primitiveSimpleName;
    }

    public <T> T cast(Object obj, Class<T> cls) {
        return (T) convert(obj, cls, true);
    }

    public <T> T convert(Object obj, Class<T> cls) {
        return (T) convert(obj, cls, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T convert(Object obj, Class<T> cls, boolean z10) {
        if (this == OBJECT) {
            if (!cls.isInterface()) {
                cls.cast(obj);
            }
            return obj;
        }
        Class<T> wrapperType = wrapperType(cls);
        if (wrapperType.isInstance(obj)) {
            return wrapperType.cast(obj);
        }
        if (!z10) {
            Class<?> cls2 = obj.getClass();
            Wrapper findWrapperType = findWrapperType(cls2);
            if (findWrapperType == null || !isConvertibleFrom(findWrapperType)) {
                throw newClassCastException(wrapperType, cls2);
            }
        } else if (obj == 0) {
            return (T) zero();
        }
        return (T) wrap(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> Class<T> forceType(Class<?> cls, Class<T> exampleType) {
        return cls;
    }

    public Object wrap(Object x10) {
        switch (this.basicTypeChar) {
            case 'L':
                return x10;
            case 'V':
                return null;
            default:
                Number xn = numberValue(x10);
                switch (this.basicTypeChar) {
                    case 'B':
                        return Byte.valueOf((byte) xn.intValue());
                    case 'C':
                        return Character.valueOf((char) xn.intValue());
                    case 'D':
                        return Double.valueOf(xn.doubleValue());
                    case 'F':
                        return Float.valueOf(xn.floatValue());
                    case 'I':
                        return Integer.valueOf(xn.intValue());
                    case 'J':
                        return Long.valueOf(xn.longValue());
                    case 'S':
                        return Short.valueOf((short) xn.intValue());
                    case 'Z':
                        return Boolean.valueOf(boolValue(xn.byteValue()));
                    default:
                        throw new InternalError("bad wrapper");
                }
        }
    }

    public Object wrap(int x10) {
        char c4 = this.basicTypeChar;
        if (c4 == 'L') {
            return Integer.valueOf(x10);
        }
        switch (c4) {
            case 'B':
                return Byte.valueOf((byte) x10);
            case 'C':
                return Character.valueOf((char) x10);
            case 'D':
                return Double.valueOf(x10);
            case 'F':
                return Float.valueOf(x10);
            case 'I':
                return Integer.valueOf(x10);
            case 'J':
                return Long.valueOf(x10);
            case 'L':
                throw newIllegalArgumentException("cannot wrap to object type");
            case 'S':
                return Short.valueOf((short) x10);
            case 'V':
                return null;
            case 'Z':
                return Boolean.valueOf(boolValue((byte) x10));
            default:
                throw new InternalError("bad wrapper");
        }
    }

    private static Number numberValue(Object obj) {
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof Character) {
            return Integer.valueOf(((Character) obj).charValue());
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        return (Number) obj;
    }

    private static boolean boolValue(byte bits) {
        return ((byte) (bits & 1)) != 0;
    }

    private static RuntimeException newIllegalArgumentException(String message, Object x10) {
        return newIllegalArgumentException(message + x10);
    }

    private static RuntimeException newIllegalArgumentException(String message) {
        return new IllegalArgumentException(message);
    }

    public Object makeArray(int len) {
        return Array.newInstance(this.primitiveType, len);
    }

    public Class<?> arrayType() {
        return this.emptyArray.getClass();
    }

    public void copyArrayUnboxing(Object[] values, int vpos, Object a10, int apos, int length) {
        if (a10.getClass() != arrayType()) {
            arrayType().cast(a10);
        }
        for (int i10 = 0; i10 < length; i10++) {
            Object value = values[i10 + vpos];
            Array.set(a10, i10 + apos, convert(value, this.primitiveType));
        }
    }

    public void copyArrayBoxing(Object a10, int apos, Object[] values, int vpos, int length) {
        if (a10.getClass() != arrayType()) {
            arrayType().cast(a10);
        }
        for (int i10 = 0; i10 < length; i10++) {
            Object value = Array.get(a10, i10 + apos);
            values[i10 + vpos] = value;
        }
    }
}
