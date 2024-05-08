package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.utils.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dw {
    private static final String Code = "AppDownloadUtils";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r1.S() > 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.openalliance.ad.download.app.k Code(com.huawei.openalliance.ad.download.app.AppDownloadTask r1) {
        /*
            int r0 = r1.B()
            switch(r0) {
                case 0: goto L20;
                case 1: goto L1d;
                case 2: goto L1a;
                case 3: goto L17;
                case 4: goto L10;
                case 5: goto Ld;
                case 6: goto La;
                default: goto L7;
            }
        L7:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            goto L22
        La:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.INSTALLED
            goto L22
        Ld:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.INSTALLING
            goto L22
        L10:
            int r1 = r1.S()
            if (r1 <= 0) goto L7
            goto L20
        L17:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.INSTALL
            goto L22
        L1a:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.DOWNLOADING
            goto L22
        L1d:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.WAITING
            goto L22
        L20:
            com.huawei.openalliance.ad.download.app.k r1 = com.huawei.openalliance.ad.download.app.k.PAUSE
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dw.Code(com.huawei.openalliance.ad.download.app.AppDownloadTask):com.huawei.openalliance.ad.download.app.k");
    }

    public static String Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        return (context == null || appInfo == null) ? "" : Code(appInfo.j(), context.getString(R.string.hiad_download_download));
    }

    public static String Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, int i10) {
        int i11;
        if (context == null || appInfo == null) {
            return "";
        }
        String k10 = appInfo.k();
        if (!Code(appInfo)) {
            i11 = R.string.hiad_download_open;
        } else {
            if (i10 == 1) {
                return context.getString(R.string.hiad_app_preordered);
            }
            i11 = R.string.hiad_app_preorder;
        }
        return Code(k10, context.getString(i11));
    }

    public static String Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, String str) {
        return (appInfo == null || context == null || com.huawei.openalliance.ad.utils.e.V(context, appInfo.Code()) == null || !TextUtils.isEmpty(appInfo.G())) ? str : context.getString(R.string.hiad_download_open);
    }

    public static String Code(String str, String str2) {
        return (TextUtils.isEmpty(str) || (!(com.huawei.openalliance.ad.utils.ay.B() && "zh-CN".equalsIgnoreCase(c.V())) && com.huawei.openalliance.ad.utils.ay.B())) ? str2 : str;
    }

    public static boolean Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        return (appInfo == null || TextUtils.isEmpty(appInfo.G())) ? false : true;
    }
}
