package jdk.internal.reflect;

import dalvik.system.VMStack;
import java.lang.reflect.Modifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Reflection {
    public static Class<?> getCallerClass() {
        return VMStack.getStackClass2();
    }

    public static void ensureMemberAccess(Class<?> currentClass, Class<?> memberClass, Object target, int modifiers) throws IllegalAccessException {
        if (currentClass == null || memberClass == null) {
            throw new InternalError();
        }
        if (!verifyMemberAccess(currentClass, memberClass, target, modifiers)) {
            throw new IllegalAccessException("Class " + currentClass.getName() + " can not access a member of class " + memberClass.getName() + " with modifiers \"" + Modifier.toString(modifiers) + "\"");
        }
    }

    public static boolean verifyMemberAccess(Class<?> currentClass, Class<?> memberClass, Object target, int modifiers) {
        boolean gotIsSameClassPackage = false;
        boolean isSameClassPackage = false;
        if (currentClass == memberClass) {
            return true;
        }
        if (!Modifier.isPublic(memberClass.getAccessFlags())) {
            isSameClassPackage = isSameClassPackage(currentClass, memberClass);
            gotIsSameClassPackage = true;
            if (!isSameClassPackage) {
                return false;
            }
        }
        if (Modifier.isPublic(modifiers)) {
            return true;
        }
        boolean successSoFar = false;
        if (Modifier.isProtected(modifiers) && isSubclassOf(currentClass, memberClass)) {
            successSoFar = true;
        }
        if (!successSoFar && !Modifier.isPrivate(modifiers)) {
            if (!gotIsSameClassPackage) {
                isSameClassPackage = isSameClassPackage(currentClass, memberClass);
                gotIsSameClassPackage = true;
            }
            if (isSameClassPackage) {
                successSoFar = true;
            }
        }
        if (!successSoFar) {
            return false;
        }
        if (Modifier.isProtected(modifiers)) {
            Class<?> targetClass = target == null ? memberClass : target.getClass();
            if (targetClass != currentClass) {
                if (!gotIsSameClassPackage) {
                    isSameClassPackage = isSameClassPackage(currentClass, memberClass);
                }
                if (!isSameClassPackage && !isSubclassOf(targetClass, currentClass)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSameClassPackage(Class<?> c12, Class<?> c22) {
        return isSameClassPackage(c12.getClassLoader(), c12.getName(), c22.getClassLoader(), c22.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isSameClassPackage(java.lang.ClassLoader r16, java.lang.String r17, java.lang.ClassLoader r18, java.lang.String r19) {
        /*
            r6 = r17
            r7 = r19
            r0 = 0
            r8 = r16
            r9 = r18
            if (r8 == r9) goto Lc
            return r0
        Lc:
            r1 = 46
            int r10 = r6.lastIndexOf(r1)
            int r11 = r7.lastIndexOf(r1)
            r1 = -1
            r2 = 1
            if (r10 == r1) goto L94
            if (r11 != r1) goto L1e
            goto L94
        L1e:
            r1 = 0
            r3 = 0
            char r4 = r6.charAt(r1)
            java.lang.String r5 = "Illegal class name "
            r12 = 76
            r13 = 91
            if (r4 != r13) goto L52
        L2c:
            int r1 = r1 + r2
            char r4 = r6.charAt(r1)
            if (r4 == r13) goto L2c
            char r4 = r6.charAt(r1)
            if (r4 != r12) goto L3b
            r14 = r1
            goto L53
        L3b:
            java.lang.InternalError r0 = new java.lang.InternalError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L52:
            r14 = r1
        L53:
            char r1 = r7.charAt(r3)
            if (r1 != r13) goto L7f
        L59:
            int r3 = r3 + r2
            char r1 = r7.charAt(r3)
            if (r1 == r13) goto L59
            char r1 = r7.charAt(r3)
            if (r1 != r12) goto L68
            r12 = r3
            goto L80
        L68:
            java.lang.InternalError r0 = new java.lang.InternalError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L7f:
            r12 = r3
        L80:
            int r13 = r10 - r14
            int r15 = r11 - r12
            if (r13 == r15) goto L87
            return r0
        L87:
            r1 = 0
            r0 = r17
            r2 = r14
            r3 = r19
            r4 = r12
            r5 = r13
            boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
            return r0
        L94:
            if (r10 != r11) goto L97
            r0 = r2
        L97:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jdk.internal.reflect.Reflection.isSameClassPackage(java.lang.ClassLoader, java.lang.String, java.lang.ClassLoader, java.lang.String):boolean");
    }

    static boolean isSubclassOf(Class<?> queryClass, Class<?> ofClass) {
        while (queryClass != null) {
            if (queryClass == ofClass) {
                return true;
            }
            queryClass = queryClass.getSuperclass();
        }
        return false;
    }
}
