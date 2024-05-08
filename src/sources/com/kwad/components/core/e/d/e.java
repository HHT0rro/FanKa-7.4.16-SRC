package com.kwad.components.core.e.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private static boolean Lj;

    public static boolean E(AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo;
        return (adInfo == null || (smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo) == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static int a(Context context, String str, String str2, String str3, AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Cursor cursor = null;
            try {
                com.kwad.sdk.commercial.i.a.a(adTemplate, str, str2, str3);
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(268435456);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{str, str2, str3, "0", ""}, null);
                if (query != null) {
                    try {
                        com.kwad.sdk.crash.utils.b.closeQuietly(query);
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        try {
                            com.kwad.sdk.commercial.i.a.a(adTemplate, str, str2, str3, bn.t(th));
                            com.kwad.sdk.core.adlog.c.j(adTemplate, 2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                            return -1;
                        } catch (Throwable th2) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                            throw th2;
                        }
                    }
                }
                com.kwad.sdk.commercial.i.a.b(adTemplate, str, str2, str3);
                com.kwad.sdk.core.adlog.c.a(adTemplate, "wxsmallapp", 1, (com.kwad.sdk.core.adlog.c.a) null);
                a(str, str2, str3, adTemplate);
                com.kwad.sdk.crash.utils.b.closeQuietly(query);
                return 1;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            com.kwad.sdk.core.adlog.c.j(adTemplate, 1);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aA(boolean z10) {
        Lj = z10;
    }

    public static int d(Context context, AdTemplate adTemplate) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (com.kwad.sdk.core.response.b.a.S(dQ) || com.kwad.sdk.core.response.b.a.T(dQ)) {
            return 0;
        }
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = dQ.adConversionInfo.smallAppJumpInfo;
        return a(context, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
    }

    private static boolean op() {
        return Lj;
    }

    private static void a(final String str, final String str2, final String str3, final AdTemplate adTemplate) {
        if (op()) {
            return;
        }
        aA(true);
        int abs = Math.abs(com.kwad.sdk.core.config.d.BT());
        if (abs > 0) {
            bn.a(new Runnable() { // from class: com.kwad.components.core.e.d.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.aA(false);
                    com.kwad.sdk.core.c.b.DD();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.commercial.i.a.c(AdTemplate.this, str, str2, str3);
                    com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "wxsmallapp", 1);
                }
            }, null, abs * 1000);
        } else {
            aA(false);
        }
    }
}
