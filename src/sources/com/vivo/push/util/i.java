package com.vivo.push.util;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ConvertMsgToIntentImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i extends b {

    /* renamed from: e, reason: collision with root package name */
    private int f46425e = 0;

    /* JADX WARN: Removed duplicated region for block: B:45:0x00df A[Catch: Exception -> 0x0153, TryCatch #1 {Exception -> 0x0153, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:17:0x003b, B:20:0x011f, B:23:0x0135, B:25:0x0045, B:26:0x0062, B:28:0x007f, B:35:0x00a1, B:36:0x00b3, B:37:0x00bd, B:39:0x00c7, B:41:0x00d3, B:45:0x00df, B:46:0x0105, B:48:0x0115, B:49:0x014b, B:30:0x0084, B:32:0x009d), top: B:2:0x0005, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105 A[Catch: Exception -> 0x0153, TryCatch #1 {Exception -> 0x0153, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:17:0x003b, B:20:0x011f, B:23:0x0135, B:25:0x0045, B:26:0x0062, B:28:0x007f, B:35:0x00a1, B:36:0x00b3, B:37:0x00bd, B:39:0x00c7, B:41:0x00d3, B:45:0x00df, B:46:0x0105, B:48:0x0115, B:49:0x014b, B:30:0x0084, B:32:0x009d), top: B:2:0x0005, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.Intent b(android.content.Context r9, com.vivo.push.model.InsideNotificationItem r10, com.vivo.push.model.NotifyArriveCallbackByUser r11) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.i.b(android.content.Context, com.vivo.push.model.InsideNotificationItem, com.vivo.push.model.NotifyArriveCallbackByUser):android.content.Intent");
    }

    @Override // com.vivo.push.util.b
    public final int a() {
        return this.f46425e;
    }

    @Override // com.vivo.push.util.b
    public final Intent a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        return b(context, insideNotificationItem, notifyArriveCallbackByUser);
    }

    @Override // com.vivo.push.util.b
    public final PendingIntent a(Context context, Intent intent) {
        return PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), intent, 201326592);
    }

    private Intent a(String str, String str2, InsideNotificationItem insideNotificationItem, Context context) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setSelector(null);
            parseUri.setPackage(str2);
            parseUri.setFlags(335544320);
            a(parseUri, insideNotificationItem.getParams());
            int a10 = a(parseUri, str2);
            if (a10 <= 0) {
                return parseUri;
            }
            this.f46425e = a10;
            u.c(context, " 落地页未找到，通知不展示：  " + this.f46425e);
            return null;
        } catch (Exception e2) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient open activity error : ".concat(String.valueOf(str)), e2);
            this.f46425e = 2158;
            return null;
        }
    }

    private static Intent a(Map<String, String> map, String str, Context context) {
        Intent intent = new Intent();
        intent.setPackage(str);
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(50);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> iterator2 = runningTasks.iterator2();
                while (iterator2.hasNext()) {
                    ComponentName componentName = iterator2.next().topActivity;
                    if (componentName.getPackageName().equals(str)) {
                        u.d("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient topClassName=" + componentName.getClassName());
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        a(intent, map);
                        return intent;
                    }
                }
            }
        } catch (Exception e2) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient ActivityManager", e2);
        }
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
            if (intent != null) {
                intent.setFlags(335544320);
                a(intent, map);
            } else {
                u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent is null");
            }
        } catch (Exception e10) {
            u.a("AndroidTwelveNotifyClickIntentParam", "sendFakeNoticeToClient LaunchIntent Exception" + e10.getMessage());
        }
        return intent;
    }

    private static Intent a(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int a(Intent intent, String str) {
        int a10 = a(intent);
        u.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal canfindactivity code : ".concat(String.valueOf(a10)));
        if (a10 != 0) {
            return a10;
        }
        int b4 = b(intent, str);
        u.d("AndroidTwelveNotifyClickIntentParam", "checkSkipContentParameterLegal packagefit code : ".concat(String.valueOf(b4)));
        if (b4 != 0) {
            return b4;
        }
        return 0;
    }

    private int a(Intent intent) {
        if (intent.resolveActivityInfo(this.f46411c.getPackageManager(), 65536) != null) {
            return 0;
        }
        u.a("AndroidTwelveNotifyClickIntentParam", "activity is null  ");
        u.c(this.f46411c, " 跳转参数对应的Activity找不到 通知不展示   2162");
        return 2162;
    }

    private static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && !intent.hasExtra(entry.getKey())) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    private int b(Intent intent, String str) {
        if (intent != null && !TextUtils.isEmpty(str)) {
            try {
                String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : intent.getPackage();
                if (TextUtils.isEmpty(packageName) || TextUtils.equals(str, packageName)) {
                    return 0;
                }
                u.d("AndroidTwelveNotifyClickIntentParam", "activity component error : local pkgName is " + str + "; but remote pkgName is " + packageName);
                u.a(this.f46411c, " 跳转参数对应的包名不是当前应用包名    local pkgName is " + str + "; but remote pkgName is " + packageName + " code =2813");
                return 2813;
            } catch (Exception e2) {
                u.a("AndroidTwelveNotifyClickIntentParam", "checkSkipContentPackage open activity error :  error " + e2.getMessage());
                return 2158;
            }
        }
        StringBuilder sb2 = new StringBuilder("checkSkipContentPackageFit intent = : ");
        Object obj = intent;
        if (intent == null) {
            obj = "";
        }
        sb2.append(obj);
        sb2.append(" mPkgName = ");
        sb2.append(str);
        u.a("AndroidTwelveNotifyClickIntentParam", sb2.toString());
        return 2158;
    }
}
