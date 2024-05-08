package java.lang.invoke;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface MethodHandleInfo {
    public static final int REF_getField = 1;
    public static final int REF_getStatic = 2;
    public static final int REF_invokeInterface = 9;
    public static final int REF_invokeSpecial = 7;
    public static final int REF_invokeStatic = 6;
    public static final int REF_invokeVirtual = 5;
    public static final int REF_newInvokeSpecial = 8;
    public static final int REF_putField = 3;
    public static final int REF_putStatic = 4;

    Class<?> getDeclaringClass();

    MethodType getMethodType();

    int getModifiers();

    String getName();

    int getReferenceKind();

    <T extends Member> T reflectAs(Class<T> cls, MethodHandles.Lookup lookup);

    default boolean isVarArgs() {
        if (MethodHandleNatives.refKindIsField((byte) getReferenceKind())) {
            return false;
        }
        return Modifier.isTransient(getModifiers());
    }

    static String referenceKindToString(int referenceKind) {
        if (!MethodHandleNatives.refKindIsValid(referenceKind)) {
            throw MethodHandleStatics.newIllegalArgumentException("invalid reference kind", Integer.valueOf(referenceKind));
        }
        return MethodHandleNatives.refKindName((byte) referenceKind);
    }

    static String toString(int kind, Class<?> defc, String name, MethodType type) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        return String.format("%s %s.%s:%s", referenceKindToString(kind), defc.getName(), name, type);
    }

    @Deprecated
    static boolean refKindIsValid(int refKind) {
        return MethodHandleNatives.refKindIsValid(refKind);
    }

    @Deprecated
    static boolean refKindIsField(int refKind) {
        return MethodHandleNatives.refKindIsField((byte) refKind);
    }

    @Deprecated
    static String refKindName(int refKind) {
        return MethodHandleNatives.refKindName((byte) refKind);
    }
}
