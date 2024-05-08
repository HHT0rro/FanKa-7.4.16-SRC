package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class x2 extends a3 {
    public x2(Context context, int i10) {
        super(context, i10);
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 4;
    }

    @Override // com.xiaomi.push.a3
    public hs b() {
        return hs.AppInstallList;
    }

    @Override // com.xiaomi.push.a3
    public String c() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager packageManager = this.f47110c.getPackageManager();
        StringBuilder sb2 = new StringBuilder();
        try {
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 128)) {
                if ((resolveInfo.activityInfo.applicationInfo.flags & 1) == 0) {
                    if (sb2.length() > 0) {
                        sb2.append(";");
                    }
                    String charSequence = resolveInfo.activityInfo.applicationInfo.loadLabel(packageManager).toString();
                    String str = resolveInfo.activityInfo.packageName;
                    sb2.append(charSequence);
                    sb2.append(",");
                    sb2.append(str);
                }
            }
        } catch (Exception unused) {
        }
        return sb2.toString();
    }

    @Override // com.xiaomi.push.a3
    public boolean f() {
        return true;
    }
}
