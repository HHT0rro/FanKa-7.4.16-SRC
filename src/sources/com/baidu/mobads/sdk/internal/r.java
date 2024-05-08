package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class r implements ICommonModuleObj {

    /* renamed from: a, reason: collision with root package name */
    private static volatile r f10298a;

    /* renamed from: b, reason: collision with root package name */
    private CustomNotification f10299b = new CustomNotification();

    private r() {
    }

    public static r a() {
        if (f10298a == null) {
            synchronized (r.class) {
                if (f10298a == null) {
                    f10298a = new r();
                }
            }
        }
        return f10298a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str) || jSONObject == null) {
            return null;
        }
        Context context = (Context) jSONObject.opt("context");
        int optInt = jSONObject.optInt("version", 0);
        String optString = jSONObject.optString("channelId");
        String optString2 = jSONObject.optString(RemoteMessageConst.Notification.TICKER);
        Bitmap bitmap = (Bitmap) jSONObject.opt("icon");
        String optString3 = jSONObject.optString("title");
        String optString4 = jSONObject.optString("content");
        String optString5 = jSONObject.optString("status");
        boolean optBoolean = jSONObject.optBoolean(RemoteMessageConst.Notification.AUTO_CANCEL);
        int optInt2 = jSONObject.optInt("progress");
        boolean optBoolean2 = jSONObject.optBoolean("indeterminate", false);
        int optInt3 = jSONObject.optInt("smallIcon");
        String optString6 = jSONObject.optString("action");
        PendingIntent pendingIntent = (PendingIntent) jSONObject.opt(com.huawei.openalliance.ad.download.app.d.f32414d);
        String optString7 = jSONObject.optString("action2");
        PendingIntent pendingIntent2 = (PendingIntent) jSONObject.opt("pendingIntent2");
        if (optInt == 1) {
            return this.f10299b.getNewNotification(context, optString2, optBoolean, bitmap, optString3, optString4, optInt2, optBoolean2, optString6, pendingIntent, optString7, pendingIntent2);
        }
        return this.f10299b.getCustomNotification(context, optString, optString2, bitmap, optString3, optString4, optString5, optBoolean, optInt2, optInt3, optString6, pendingIntent);
    }
}
