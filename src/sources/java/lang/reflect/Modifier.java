package java.lang.reflect;

import com.huawei.appgallery.agd.base.api.AgdManager;
import java.util.StringJoiner;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Modifier {
    public static final int ABSTRACT = 1024;
    static final int ACCESS_MODIFIERS = 7;
    static final int ANNOTATION = 8192;
    static final int BRIDGE = 64;
    private static final int CLASS_MODIFIERS = 3103;
    public static final int CONSTRUCTOR = 65536;
    private static final int CONSTRUCTOR_MODIFIERS = 7;
    public static final int DEFAULT = 4194304;
    static final int ENUM = 16384;
    private static final int FIELD_MODIFIERS = 223;
    public static final int FINAL = 16;
    public static final int INTERFACE = 512;
    private static final int INTERFACE_MODIFIERS = 3087;
    static final int MANDATED = 32768;
    private static final int METHOD_MODIFIERS = 3391;
    public static final int NATIVE = 256;
    private static final int PARAMETER_MODIFIERS = 16;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;
    public static final int PUBLIC = 1;
    public static final int STATIC = 8;
    public static final int STRICT = 2048;
    public static final int SYNCHRONIZED = 32;
    public static final int SYNTHETIC = 4096;
    public static final int TRANSIENT = 128;
    static final int VARARGS = 128;
    public static final int VOLATILE = 64;

    public static boolean isPublic(int mod) {
        return (mod & 1) != 0;
    }

    public static boolean isPrivate(int mod) {
        return (mod & 2) != 0;
    }

    public static boolean isProtected(int mod) {
        return (mod & 4) != 0;
    }

    public static boolean isStatic(int mod) {
        return (mod & 8) != 0;
    }

    public static boolean isFinal(int mod) {
        return (mod & 16) != 0;
    }

    public static boolean isSynchronized(int mod) {
        return (mod & 32) != 0;
    }

    public static boolean isVolatile(int mod) {
        return (mod & 64) != 0;
    }

    public static boolean isConstructor(int modifiers) {
        return (65536 & modifiers) != 0;
    }

    public static boolean isTransient(int mod) {
        return (mod & 128) != 0;
    }

    public static boolean isNative(int mod) {
        return (mod & 256) != 0;
    }

    public static boolean isInterface(int mod) {
        return (mod & 512) != 0;
    }

    public static boolean isAbstract(int mod) {
        return (mod & 1024) != 0;
    }

    public static boolean isStrict(int mod) {
        return (mod & 2048) != 0;
    }

    public static String toString(int mod) {
        StringJoiner sj = new StringJoiner(" ");
        if ((mod & 1) != 0) {
            sj.add("public");
        }
        if ((mod & 4) != 0) {
            sj.add("protected");
        }
        if ((mod & 2) != 0) {
            sj.add("private");
        }
        if ((mod & 1024) != 0) {
            sj.add("abstract");
        }
        if ((mod & 8) != 0) {
            sj.add("static");
        }
        if ((mod & 16) != 0) {
            sj.add("final");
        }
        if ((mod & 128) != 0) {
            sj.add("transient");
        }
        if ((mod & 64) != 0) {
            sj.add("volatile");
        }
        if ((mod & 32) != 0) {
            sj.add("synchronized");
        }
        if ((mod & 256) != 0) {
            sj.add(AgdManager.SOURCE_NATIVE);
        }
        if ((mod & 2048) != 0) {
            sj.add("strictfp");
        }
        if ((mod & 512) != 0) {
            sj.add("interface");
        }
        return sj.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSynthetic(int mod) {
        return (mod & 4096) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isMandated(int mod) {
        return (32768 & mod) != 0;
    }

    public static int classModifiers() {
        return 3103;
    }

    public static int interfaceModifiers() {
        return INTERFACE_MODIFIERS;
    }

    public static int constructorModifiers() {
        return 7;
    }

    public static int methodModifiers() {
        return METHOD_MODIFIERS;
    }

    public static int fieldModifiers() {
        return 223;
    }

    public static int parameterModifiers() {
        return 16;
    }
}
