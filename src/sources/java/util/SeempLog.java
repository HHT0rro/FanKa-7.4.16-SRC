package java.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class SeempLog {
    private static Method seemp_record_method = null;
    private static boolean seemp_record_method_looked_up = false;

    private SeempLog() {
    }

    public static int record_str(int api, String msg) {
        if (seemp_record_method == null) {
            if (!seemp_record_method_looked_up) {
                try {
                    Class c4 = Class.forName("android.util.SeempLog");
                    if (c4 != null) {
                        seemp_record_method = c4.getDeclaredMethod("record_str", Integer.TYPE, String.class);
                    }
                } catch (ClassNotFoundException e2) {
                    seemp_record_method = null;
                } catch (NoSuchMethodException e10) {
                    seemp_record_method = null;
                }
            }
            seemp_record_method_looked_up = true;
        }
        Method method = seemp_record_method;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(null, Integer.valueOf(api), msg)).intValue();
        } catch (IllegalAccessException e11) {
            return 0;
        } catch (InvocationTargetException e12) {
            return 0;
        }
    }
}
