package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.hv;
import com.xiaomi.push.ip;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m0 {
    public static void b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j10 = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a10 = kc.j.d(context).a(hv.SyncInfoFrequency.a(), 1209600);
        if (j10 != -1) {
            if (Math.abs(currentTimeMillis - j10) <= a10) {
                return;
            } else {
                d(context, true);
            }
        }
        sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
    }

    public static void c(Context context, ip ipVar) {
        fc.c.i("need to update local info with: " + ((Object) ipVar.m3017a()));
        String str = ipVar.m3017a().get("accept_time");
        if (str != null) {
            MiPushClient.M(context);
            String[] split = str.split("-");
            if (split.length == 2) {
                MiPushClient.d(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    o0.c(context).j(true);
                } else {
                    o0.c(context).j(false);
                }
            }
        }
        String str2 = ipVar.m3017a().get("aliases");
        if (str2 != null) {
            MiPushClient.Q(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(",")) {
                    MiPushClient.f(context, str3);
                }
            }
        }
        String str4 = ipVar.m3017a().get("topics");
        if (str4 != null) {
            MiPushClient.R(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(",")) {
                    MiPushClient.i(context, str5);
                }
            }
        }
        String str6 = ipVar.m3017a().get("user_accounts");
        if (str6 != null) {
            MiPushClient.P(context);
            if ("".equals(str6)) {
                return;
            }
            for (String str7 : str6.split(",")) {
                MiPushClient.e(context, str7);
            }
        }
    }

    public static void d(Context context, boolean z10) {
        com.xiaomi.push.n.c(context).g(new n0(context, z10));
    }

    public static String f(List<String> list) {
        String b4 = com.xiaomi.push.p0.b(g(list));
        return (TextUtils.isEmpty(b4) || b4.length() <= 4) ? "" : b4.substring(0, 4).toLowerCase();
    }

    public static String g(List<String> list) {
        String str = "";
        if (com.xiaomi.push.h.a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }
}
