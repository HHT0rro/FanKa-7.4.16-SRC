package com.bytedance.pangle.log;

import com.bytedance.pangle.util.k;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {
    public static String a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static int b(Object obj) {
        if (obj == null) {
            return -1;
        }
        return k.a(obj.toString());
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
