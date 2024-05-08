package com.tencent.bugly.idasc.crashreport.inner;

import com.tencent.bugly.idasc.proguard.al;
import com.tencent.bugly.idasc.proguard.au;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i10, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            al.e("post cocos2d-x fail args null", new Object[0]);
        } else if (i10 != 5 && i10 != 6) {
            al.e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i10));
        } else {
            al.a("post cocos2d-x crash %s %s", str, str2);
            au.a(Thread.currentThread(), i10, str, str2, str3, null);
        }
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null) {
            al.e("post h5 fail args null", new Object[0]);
        } else {
            al.a("post h5 crash %s %s", str, str2);
            au.a(thread, 8, str, str2, str3, map);
        }
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            al.e("post u3d fail args null", new Object[0]);
        }
        al.a("post u3d crash %s %s", str, str2);
        au.a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}
