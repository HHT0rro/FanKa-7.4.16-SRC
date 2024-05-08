package sun.misc;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MessageUtils {
    public static String subst(String patt, String arg) {
        String[] args = {arg};
        return subst(patt, args);
    }

    public static String subst(String patt, String arg1, String arg2) {
        String[] args = {arg1, arg2};
        return subst(patt, args);
    }

    public static String subst(String patt, String arg1, String arg2, String arg3) {
        String[] args = {arg1, arg2, arg3};
        return subst(patt, args);
    }

    public static String subst(String patt, String[] args) {
        StringBuffer result = new StringBuffer();
        int len = patt.length();
        int i10 = 0;
        while (i10 >= 0 && i10 < len) {
            char ch = patt.charAt(i10);
            if (ch == '%') {
                if (i10 != len) {
                    int index = Character.digit(patt.charAt(i10 + 1), 10);
                    if (index == -1) {
                        result.append(patt.charAt(i10 + 1));
                        i10++;
                    } else if (index < args.length) {
                        result.append(args[index]);
                        i10++;
                    }
                }
            } else {
                result.append(ch);
            }
            i10++;
        }
        return result.toString();
    }

    public static String substProp(String propName, String arg) {
        return subst(System.getProperty(propName), arg);
    }

    public static String substProp(String propName, String arg1, String arg2) {
        return subst(System.getProperty(propName), arg1, arg2);
    }

    public static String substProp(String propName, String arg1, String arg2, String arg3) {
        return subst(System.getProperty(propName), arg1, arg2, arg3);
    }

    public static void err(String s2) {
        System.err.println(s2);
    }

    public static void out(String s2) {
        System.out.println(s2);
    }

    public static void where() {
        Throwable t2 = new Throwable();
        StackTraceElement[] es = t2.getStackTrace();
        for (int i10 = 1; i10 < es.length; i10++) {
            System.err.println("\t" + es[i10].toString());
        }
    }
}
