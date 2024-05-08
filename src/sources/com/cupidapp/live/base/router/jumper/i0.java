package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.R$string;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpenAppJumperManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("name");
        String queryParameter2 = uri.getQueryParameter("path");
        boolean z10 = true;
        if (queryParameter == null || queryParameter.length() == 0) {
            return;
        }
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wxbb62cffc9aa42285");
        if (!createWXAPI.isWXAppInstalled()) {
            com.cupidapp.live.base.view.h.f12779a.r(context, R$string.install_wechat_please);
            return;
        }
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = queryParameter;
        if (queryParameter2 != null && queryParameter2.length() != 0) {
            z10 = false;
        }
        if (!z10) {
            req.path = queryParameter2;
        }
        req.miniprogramType = 0;
        createWXAPI.sendReq(req);
    }
}
