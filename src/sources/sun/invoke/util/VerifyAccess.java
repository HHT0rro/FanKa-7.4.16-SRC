package sun.invoke.util;

import java.lang.reflect.Modifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class VerifyAccess {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean ALLOW_NESTMATE_ACCESS = false;
    private static final int ALL_ACCESS_MODES = 7;
    private static final int PACKAGE_ALLOWED = 8;
    private static final int PACKAGE_ONLY = 0;
    private static final int PROTECTED_OR_PACKAGE_ALLOWED = 12;

    private VerifyAccess() {
    }

    public static boolean isMemberAccessible(Class<?> refc, Class<?> defc, int mods, Class<?> lookupClass, int allowedModes) {
        if (allowedModes == 0 || !isClassAccessible(refc, lookupClass, allowedModes)) {
            return false;
        }
        if (defc == lookupClass && (allowedModes & 2) != 0) {
            return true;
        }
        switch (mods & 7) {
            case 0:
                if ((allowedModes & 8) == 0 || !isSamePackage(defc, lookupClass)) {
                    return false;
                }
                return true;
            case 1:
                return true;
            case 2:
                return false;
            case 3:
            default:
                throw new IllegalArgumentException("bad modifiers: " + Modifier.toString(mods));
            case 4:
                if ((allowedModes & 12) != 0 && isSamePackage(defc, lookupClass)) {
                    return true;
                }
                if ((allowedModes & 4) == 0) {
                    return false;
                }
                if (((mods & 8) != 0 && !isRelatedClass(refc, lookupClass)) || (allowedModes & 4) == 0 || !isSubClass(lookupClass, defc)) {
                    return false;
                }
                return true;
        }
    }

    static boolean isRelatedClass(Class<?> refc, Class<?> lookupClass) {
        return refc == lookupClass || isSubClass(refc, lookupClass) || isSubClass(lookupClass, refc);
    }

    static boolean isSubClass(Class<?> lookupClass, Class<?> defc) {
        return defc.isAssignableFrom(lookupClass) && !lookupClass.isInterface();
    }

    public static boolean isClassAccessible(Class<?> refc, Class<?> lookupClass, int allowedModes) {
        if (allowedModes == 0) {
            return false;
        }
        if (Modifier.isPublic(refc.getModifiers())) {
            return true;
        }
        return (allowedModes & 8) != 0 && isSamePackage(lookupClass, refc);
    }

    public static boolean isSamePackage(Class<?> class1, Class<?> class2) {
        if (class1.isArray() || class2.isArray()) {
            throw new IllegalArgumentException();
        }
        if (class1 == class2) {
            return true;
        }
        if (class1.getClassLoader() != class2.getClassLoader()) {
            return false;
        }
        String name1 = class1.getName();
        String name2 = class2.getName();
        int dot = name1.lastIndexOf(46);
        if (dot != name2.lastIndexOf(46)) {
            return false;
        }
        for (int i10 = 0; i10 < dot; i10++) {
            if (name1.charAt(i10) != name2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSamePackageMember(Class<?> class1, Class<?> class2) {
        if (class1 == class2) {
            return true;
        }
        return isSamePackage(class1, class2) && getOutermostEnclosingClass(class1) == getOutermostEnclosingClass(class2);
    }

    private static Class<?> getOutermostEnclosingClass(Class<?> c4) {
        Class<?> pkgmem = c4;
        Class<?> enc = c4;
        while (true) {
            Class<?> enclosingClass = enc.getEnclosingClass();
            enc = enclosingClass;
            if (enclosingClass != null) {
                pkgmem = enc;
            } else {
                return pkgmem;
            }
        }
    }
}
