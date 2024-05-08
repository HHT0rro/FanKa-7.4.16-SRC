package com.huawei.hianalytics;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.log.LogTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l0 {
    public static final String ikl = LogTag.get(l0.class, new Class[0]);
    public static l0 ijk = new l0();
    public boolean lmn = false;
    public Context klm = d.lmn();

    public boolean lmn() {
        if (!this.lmn) {
            Context context = this.klm;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    UserManager userManager = (UserManager) context.getSystemService(UserData.NAME);
                    if (userManager != null) {
                        this.lmn = userManager.isUserUnlocked();
                    } else {
                        this.lmn = false;
                    }
                } catch (RuntimeException e2) {
                    this.lmn = false;
                    String str = ikl;
                    StringBuilder b4 = e9.a.b("userManager isUserUnlocked RuntimeException : ");
                    b4.append(e2.getMessage());
                    HiLog.e(str, b4.toString());
                } catch (Exception e10) {
                    this.lmn = false;
                    String str2 = ikl;
                    StringBuilder b10 = e9.a.b("userManager isUserUnlocked Exception : ");
                    b10.append(e10.getMessage());
                    HiLog.e(str2, b10.toString());
                }
            } else {
                this.lmn = true;
            }
        }
        return this.lmn;
    }
}
