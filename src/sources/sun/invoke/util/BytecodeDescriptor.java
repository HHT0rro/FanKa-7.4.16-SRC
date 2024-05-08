package sun.invoke.util;

import java.lang.invoke.MethodType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BytecodeDescriptor {
    private BytecodeDescriptor() {
    }

    public static List<Class<?>> parseMethod(String bytecodeSignature, ClassLoader loader) {
        return parseMethod(bytecodeSignature, 0, bytecodeSignature.length(), loader);
    }

    static List<Class<?>> parseMethod(String bytecodeSignature, int start, int end, ClassLoader loader) {
        if (loader == null) {
            loader = ClassLoader.getSystemClassLoader();
        }
        int[] i10 = {start};
        ArrayList<Class<?>> ptypes = new ArrayList<>();
        if (i10[0] >= end || bytecodeSignature.charAt(i10[0]) != '(') {
            parseError(bytecodeSignature, "not a method type");
        } else {
            i10[0] = i10[0] + 1;
            while (i10[0] < end && bytecodeSignature.charAt(i10[0]) != ')') {
                Class<?> pt = parseSig(bytecodeSignature, i10, end, loader);
                if (pt == null || pt == Void.TYPE) {
                    parseError(bytecodeSignature, "bad argument type");
                }
                ptypes.add(pt);
            }
            i10[0] = i10[0] + 1;
        }
        Class<?> rtype = parseSig(bytecodeSignature, i10, end, loader);
        if (rtype == null || i10[0] != end) {
            parseError(bytecodeSignature, "bad return type");
        }
        ptypes.add(rtype);
        return ptypes;
    }

    private static void parseError(String str, String msg) {
        throw new IllegalArgumentException("bad signature: " + str + ": " + msg);
    }

    private static Class<?> parseSig(String str, int[] i10, int end, ClassLoader loader) {
        if (i10[0] == end) {
            return null;
        }
        int i11 = i10[0];
        i10[0] = i11 + 1;
        char c4 = str.charAt(i11);
        if (c4 == 'L') {
            int begc = i10[0];
            int endc = str.indexOf(59, begc);
            if (endc < 0) {
                return null;
            }
            i10[0] = endc + 1;
            String name = str.substring(begc, endc).replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
            try {
                return loader.loadClass(name);
            } catch (ClassNotFoundException ex) {
                throw new TypeNotPresentException(name, ex);
            }
        }
        if (c4 == '[') {
            Class<?> t2 = parseSig(str, i10, end, loader);
            if (t2 != null) {
                return Array.newInstance(t2, 0).getClass();
            }
            return t2;
        }
        return Wrapper.forBasicType(c4).primitiveType();
    }

    public static String unparse(Class<?> type) {
        StringBuilder sb2 = new StringBuilder();
        unparseSig(type, sb2);
        return sb2.toString();
    }

    public static String unparse(MethodType type) {
        return unparseMethod(type.returnType(), type.parameterList());
    }

    public static String unparse(Object type) {
        if (type instanceof Class) {
            return unparse((Class<?>) type);
        }
        if (type instanceof MethodType) {
            return unparse((MethodType) type);
        }
        return (String) type;
    }

    public static String unparseMethod(Class<?> rtype, List<Class<?>> ptypes) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        for (Class<?> pt : ptypes) {
            unparseSig(pt, sb2);
        }
        sb2.append(')');
        unparseSig(rtype, sb2);
        return sb2.toString();
    }

    private static void unparseSig(Class<?> t2, StringBuilder sb2) {
        char c4 = Wrapper.forBasicType(t2).basicTypeChar();
        if (c4 != 'L') {
            sb2.append(c4);
            return;
        }
        boolean lsemi = !t2.isArray();
        if (lsemi) {
            sb2.append('L');
        }
        sb2.append(t2.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX));
        if (lsemi) {
            sb2.append(';');
        }
    }
}
