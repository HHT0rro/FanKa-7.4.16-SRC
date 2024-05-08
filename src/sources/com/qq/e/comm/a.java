package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.kuaishou.weapon.p0.g;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public static boolean a(Context context) {
        boolean z10;
        boolean z11;
        Class<?> cls;
        Intent intent;
        String str;
        try {
            String[] strArr = {g.f36115a, g.f36116b};
            for (int i10 = 0; i10 < 2; i10++) {
                try {
                    str = strArr[i10];
                } catch (Throwable th) {
                    GDTLogger.e("检查权限时发生异常", th);
                }
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.e(String.format("Permission[%s]需要在AndroidManifest.xml中声明", str));
                    z10 = false;
                    break;
                }
            }
            z10 = true;
            if (!z10 || !a(context, Class.forName(CustomPkgConstants.getADActivityName())) || !a(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) || !a(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                return false;
            }
            Class<?>[] clsArr = {Class.forName(CustomPkgConstants.getDownLoadServiceName())};
            for (int i11 = 0; i11 < 1; i11++) {
                try {
                    cls = clsArr[i11];
                    intent = new Intent();
                    intent.setClass(context, cls);
                } catch (Throwable th2) {
                    GDTLogger.e("检查Service时发生异常", th2);
                }
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.e(String.format("Service[%s]需要在AndroidManifest.xml中声明", cls.getName()));
                    z11 = false;
                    break;
                }
            }
            z11 = true;
            return z11;
        } catch (Throwable th3) {
            GDTLogger.e("检查AndroidManifest.xml时发生异常", th3);
            return false;
        }
    }

    private static boolean a(Context context, Class<?>... clsArr) {
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i10]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i10].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }
}
