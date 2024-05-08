package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q1 {

    /* renamed from: c, reason: collision with root package name */
    private static q1 f30201c = new q1();

    /* renamed from: a, reason: collision with root package name */
    private boolean f30202a = false;

    /* renamed from: b, reason: collision with root package name */
    private Context f30203b = q0.i();

    private q1() {
    }

    public static q1 b() {
        return f30201c;
    }

    public boolean a() {
        boolean z10;
        if (!this.f30202a) {
            Context context = this.f30203b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService(UserData.NAME);
                if (userManager != null) {
                    z10 = userManager.isUserUnlocked();
                } else {
                    this.f30202a = false;
                }
            } else {
                z10 = true;
            }
            this.f30202a = z10;
        }
        return this.f30202a;
    }
}
