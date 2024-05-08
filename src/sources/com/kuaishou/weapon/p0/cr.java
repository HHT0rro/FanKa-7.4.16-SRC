package com.kuaishou.weapon.p0;

import dalvik.system.VMRuntime;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f35987a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f35988b = true;

    static {
        try {
            f35987a = ((Boolean) VMRuntime.class.getDeclaredMethod("is64Bit", new Class[0]).invoke(VMRuntime.class.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f35987a = false;
        }
        f35988b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f35987a;
    }

    public static boolean b() {
        return f35988b;
    }
}
