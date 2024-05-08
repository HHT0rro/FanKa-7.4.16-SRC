package com.bun.miitmdid.content;

import android.content.Context;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ContextKeeper {
    public static Context mContext;

    public static Context ReflectAppContext() {
        Object[] objArr = new Object[3];
        objArr[1] = 2;
        objArr[2] = 1598952044224L;
        return (Context) Utils.rL(objArr);
    }

    public static Context getAppContext() {
        Object[] objArr = new Object[3];
        objArr[1] = 3;
        objArr[2] = 1598952044225L;
        return (Context) Utils.rL(objArr);
    }

    public static Context getApplicationContext() {
        Object[] objArr = new Object[3];
        objArr[1] = 4;
        objArr[2] = 1598952044226L;
        return (Context) Utils.rL(objArr);
    }

    public static void init(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 5;
        objArr[3] = 1598952044227L;
        Utils.rL(objArr);
    }
}
