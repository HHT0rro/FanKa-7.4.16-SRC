package com.xiaomi.push;

import android.system.Os;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p1 {
    public static long a(String str) {
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0L;
        } catch (Exception e2) {
            fc.c.k(e2);
            return 0L;
        }
    }
}
