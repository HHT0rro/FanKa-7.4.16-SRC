package com.ishumei.smantifraud.l111l11111I1l;

import android.app.UiModeManager;
import android.content.Context;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111I1ll {
    public static int l1111l111111Il(Context context) {
        try {
            return ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static HashMap<String, String> l1111l111111Il() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Class<?> loadClass = Context.class.getClassLoader().loadClass("android.os.SystemProperties");
            Method method = loadClass.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
            method.setAccessible(true);
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add("ro.debuggable");
            arrayList.add("ro.boot.hardware");
            arrayList.add("gsm.sim.state");
            arrayList.add("gsm.operator.alpha");
            arrayList.add("sys.usb.state");
            for (String str : arrayList) {
                String str2 = (String) method.invoke(loadClass, str);
                if (str2 != null && !str2.isEmpty()) {
                    hashMap.put(str, str2);
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
