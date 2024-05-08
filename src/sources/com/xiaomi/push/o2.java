package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class o2 implements s2 {
    @Override // com.xiaomi.push.s2
    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        n.c(context).g(new p2(this, context, intent));
    }

    public final void b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (q2.b(context, String.valueOf(12), 1L)) {
                return;
            }
            hy hyVar = new hy();
            hyVar.a(str + com.huawei.openalliance.ad.constant.u.bD + str2);
            hyVar.a(System.currentTimeMillis());
            hyVar.a(hs.BroadcastAction);
            a3.d(context, hyVar);
        } catch (Throwable unused) {
        }
    }

    public final void d(Context context, Intent intent) {
        int a10;
        try {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return;
            }
            String[] split = dataString.split(com.huawei.openalliance.ad.constant.u.bD);
            if (split.length >= 2 && !TextUtils.isEmpty(split[1])) {
                String str = split[1];
                long currentTimeMillis = System.currentTimeMillis();
                boolean i10 = kc.j.d(context).i(hv.BroadcastActionCollectionSwitch.a(), true);
                if (TextUtils.equals("android.intent.action.PACKAGE_RESTARTED", intent.getAction())) {
                    if (!q2.b(context, String.valueOf(12), 1L) && i10) {
                        if (TextUtils.isEmpty(z2.f48538d)) {
                            z2.f48538d += r2.f48128b + com.huawei.openalliance.ad.constant.u.bD;
                        }
                        z2.f48538d += str + "(" + currentTimeMillis + "),";
                        return;
                    }
                    return;
                }
                if (TextUtils.equals("android.intent.action.PACKAGE_CHANGED", intent.getAction())) {
                    if (!q2.b(context, String.valueOf(12), 1L) && i10) {
                        if (TextUtils.isEmpty(z2.f48539e)) {
                            z2.f48539e += r2.f48129c + com.huawei.openalliance.ad.constant.u.bD;
                        }
                        z2.f48539e += str + "(" + currentTimeMillis + "),";
                        return;
                    }
                    return;
                }
                if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                    if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !i10) {
                        return;
                    } else {
                        a10 = hs.BroadcastActionAdded.a();
                    }
                } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                    if (intent.getExtras().getBoolean("android.intent.extra.REPLACING") || !i10) {
                        return;
                    } else {
                        a10 = hs.BroadcastActionRemoved.a();
                    }
                } else if (TextUtils.equals("android.intent.action.PACKAGE_REPLACED", intent.getAction())) {
                    if (!i10) {
                        return;
                    } else {
                        a10 = hs.BroadcastActionReplaced.a();
                    }
                } else if (!TextUtils.equals("android.intent.action.PACKAGE_DATA_CLEARED", intent.getAction()) || !i10) {
                    return;
                } else {
                    a10 = hs.BroadcastActionDataCleared.a();
                }
                b(context, String.valueOf(a10), str);
            }
        } catch (Throwable unused) {
        }
    }
}
