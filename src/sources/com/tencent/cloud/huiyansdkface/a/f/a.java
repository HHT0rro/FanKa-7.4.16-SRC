package com.tencent.cloud.huiyansdkface.a.f;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public static int a(int i10) {
        if (i10 == 1) {
            return 90;
        }
        if (i10 != 2) {
            return i10 != 3 ? 0 : 270;
        }
        return 180;
    }

    public static int a(Context context) {
        return a(b(context).getOrientation());
    }

    public static int a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar, int i10, int i11) {
        return aVar.b() ? (360 - ((i11 + i10) % 360)) % 360 : ((i11 - i10) + 360) % 360;
    }

    private static Display b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }
}
