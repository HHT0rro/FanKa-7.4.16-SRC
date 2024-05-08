package com.bun.miitmdid.provider.xiaomi;

import android.content.Context;
import com.netease.nis.sdkwrapper.Utils;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class IdentifierManager {
    public static final String TAG = "IdentifierManager";
    public static Class<?> sClass;
    public static Method sGetAAID;
    public static Method sGetOAID;
    public static Method sGetVAID;
    public static Object sIdProivderImpl;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sClass = cls;
            sIdProivderImpl = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            Class<?> cls2 = sClass;
            if (cls2 != null) {
                sGetOAID = cls2.getMethod("getOAID", Context.class);
            }
        } catch (Exception unused2) {
        }
        try {
            Class<?> cls3 = sClass;
            if (cls3 != null) {
                sGetVAID = cls3.getMethod("getVAID", Context.class);
            }
        } catch (Exception unused3) {
        }
        try {
            Class<?> cls4 = sClass;
            if (cls4 != null) {
                sGetAAID = cls4.getMethod("getAAID", Context.class);
            }
        } catch (Exception unused4) {
        }
    }

    public static String getAAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 98;
        objArr[3] = 1598952044320L;
        return (String) Utils.rL(objArr);
    }

    public static String getOAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 99;
        objArr[3] = 1598952044321L;
        return (String) Utils.rL(objArr);
    }

    public static String getUDID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 100;
        objArr[3] = 1598952044322L;
        return (String) Utils.rL(objArr);
    }

    public static String getVAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 101;
        objArr[3] = 1598952044323L;
        return (String) Utils.rL(objArr);
    }

    public static String invokeMethod(Context context, Method method) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = method;
        objArr[3] = 102;
        objArr[4] = 1598952044324L;
        return (String) Utils.rL(objArr);
    }

    public static boolean isSupported() {
        Object[] objArr = new Object[3];
        objArr[1] = 103;
        objArr[2] = 1598952044325L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }
}
