package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m {
    public static boolean m(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback) {
        try {
            LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean m() {
        try {
            com.bytedance.sdk.openadsdk.np.m.m().dk(new Runnable() { // from class: com.bytedance.sdk.openadsdk.live.m.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LivePluginHelper.initLiveCommerce();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean m(Context context, Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey(TTLiveConstants.ROOMID_KEY)) {
            long j10 = bundle.getLong(TTLiveConstants.ROOMID_KEY);
            try {
                IOuterLiveService iOuterLiveService = (IOuterLiveService) LivePluginHelper.getLiveRoomService();
                if (iOuterLiveService == null) {
                    return false;
                }
                iOuterLiveService.enterLiveRoom(context, j10, bundle);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean m(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                IOuterLiveService iOuterLiveService = (IOuterLiveService) LivePluginHelper.getLiveRoomService();
                if (iOuterLiveService != null) {
                    return iOuterLiveService.handleSchema(context, uri);
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
