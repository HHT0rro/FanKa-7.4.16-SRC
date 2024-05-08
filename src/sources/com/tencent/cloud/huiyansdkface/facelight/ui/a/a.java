package com.tencent.cloud.huiyansdkface.facelight.ui.a;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a extends Activity {
    private boolean a() {
        return "EmotionUI_3.1".equals(b());
    }

    private String b() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.version.emui");
        } catch (Exception unused) {
            return "";
        }
    }

    public void a(String str) {
        int i10 = Build.VERSION.SDK_INT;
        View decorView = getWindow().getDecorView();
        if (!a()) {
            getWindow().clearFlags(67108864);
        }
        int i11 = 5378;
        if (i10 >= 23 && !WbCloudFaceContant.BLACK.equals(str)) {
            i11 = 13314;
        }
        decorView.setSystemUiVisibility(i11);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
    }
}
