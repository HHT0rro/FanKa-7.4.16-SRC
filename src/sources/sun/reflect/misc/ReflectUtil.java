package sun.reflect.misc;

import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import org.apache.commons.io.IOUtils;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ReflectUtil {
    private ReflectUtil() {
    }

    public static Class<?> forName(String name) throws ClassNotFoundException {
        checkPackageAccess(name);
        return Class.forName(name);
    }

    public static Object newInstance(Class<?> cls) throws InstantiationException, IllegalAccessException {
        checkPackageAccess(cls);
        return cls.newInstance();
    }

    public static void ensureMemberAccess(Class<?> currentClass, Class<?> memberClass, Object target, int modifiers) throws IllegalAccessException {
        if (target == null && Modifier.isProtected(modifiers)) {
            int mods = (modifiers & (-5)) | 1;
            Reflection.ensureMemberAccess(currentClass, memberClass, target, mods);
            try {
                Reflection.ensureMemberAccess(currentClass, memberClass, target, mods & (-2));
                return;
            } catch (IllegalAccessException e2) {
                if (isSubclassOf(currentClass, memberClass)) {
                    return;
                } else {
                    throw e2;
                }
            }
        }
        Reflection.ensureMemberAccess(currentClass, memberClass, target, modifiers);
    }

    private static boolean isSubclassOf(Class<?> queryClass, Class<?> ofClass) {
        while (queryClass != null) {
            if (queryClass == ofClass) {
                return true;
            }
            queryClass = queryClass.getSuperclass();
        }
        return false;
    }

    public static void checkPackageAccess(Class<?> clazz) {
        checkPackageAccess(clazz.getName());
        if (isNonPublicProxyClass(clazz)) {
            checkProxyPackageAccess(clazz);
        }
    }

    public static void checkPackageAccess(String name) {
        int b4;
        SecurityManager s2 = System.getSecurityManager();
        if (s2 != null) {
            String cname = name.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
            if (cname.startsWith("[") && (b4 = cname.lastIndexOf(91) + 2) > 1 && b4 < cname.length()) {
                cname = cname.substring(b4);
            }
            int i10 = cname.lastIndexOf(46);
            if (i10 != -1) {
                s2.checkPackageAccess(cname.substring(0, i10));
            }
        }
    }

    public static boolean isPackageAccessible(Class<?> clazz) {
        try {
            checkPackageAccess(clazz);
            return true;
        } catch (SecurityException e2) {
            return false;
        }
    }

    private static boolean isAncestor(ClassLoader p10, ClassLoader cl) {
        ClassLoader acl = cl;
        do {
            acl = acl.getParent();
            if (p10 == acl) {
                return true;
            }
        } while (acl != null);
        return false;
    }

    public static boolean needsPackageAccessCheck(ClassLoader from, ClassLoader to) {
        if (from == null || from == to) {
            return false;
        }
        if (to == null) {
            return true;
        }
        return true ^ isAncestor(from, to);
    }

    public static void checkProxyPackageAccess(Class<?> clazz) {
        SecurityManager s2 = System.getSecurityManager();
        if (s2 != null && Proxy.isProxyClass(clazz)) {
            for (Class<?> intf : clazz.getInterfaces()) {
                checkPackageAccess(intf);
            }
        }
    }

    public static void checkProxyPackageAccess(ClassLoader ccl, Class<?>... interfaces) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            for (Class<?> intf : interfaces) {
                ClassLoader cl = intf.getClassLoader();
                if (needsPackageAccessCheck(ccl, cl)) {
                    checkPackageAccess(intf);
                }
            }
        }
    }

    public static boolean isNonPublicProxyClass(Class<?> cls) {
        String name = cls.getName();
        int i10 = name.lastIndexOf(46);
        String pkg = i10 != -1 ? name.substring(0, i10) : "";
        return Proxy.isProxyClass(cls) && !pkg.isEmpty();
    }
}
