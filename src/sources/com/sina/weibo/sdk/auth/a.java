package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.auth.AuthActivity;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.b.e;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.h;
import com.sina.weibo.sdk.web.WebActivity;
import com.tencent.connect.common.Constants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public WbAuthListener f38338d;

    public final void a(Activity activity) {
        c.a("WBSsoTag", "startClientAuth()");
        try {
            a.C0571a e2 = com.sina.weibo.sdk.b.a.e(activity);
            Intent intent = new Intent();
            if (e2 == null) {
                intent.setClassName("com.sina.weibo", "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(e2.packageName, e2.f38341ae);
            }
            AuthInfo b4 = com.sina.weibo.sdk.a.b();
            intent.putExtra("appKey", b4.getAppKey());
            intent.putExtra(AuthActivity.f4467b, b4.getRedirectUrl());
            intent.putExtra(Constants.PARAM_SCOPE, b4.getScope());
            intent.putExtra("packagename", b4.getPackageName());
            intent.putExtra("key_hash", b4.getHash());
            intent.putExtra("_weibo_command_type", 3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            intent.putExtra("_weibo_transaction", sb2.toString());
            if (activity == null) {
                this.f38338d.onError(new UiError(-1, "activity is null", ""));
                return;
            }
            if (com.sina.weibo.sdk.b.a.a(activity, intent)) {
                b4.getAppKey();
                intent.putExtra("aid", e.r());
                activity.startActivityForResult(intent, 32973);
                c.a("WBSsoTag", "start SsoActivity ");
                return;
            }
            this.f38338d.onError(new UiError(-2, "your app is illegal", ""));
        } catch (Exception e10) {
            e10.printStackTrace();
            c.b("WBSsoTag", e10.getMessage());
            this.f38338d.onError(new UiError(-3, "occur exception", e10.getMessage()));
        }
    }

    public final void b(Activity activity) {
        h hVar = new h();
        AuthInfo b4 = com.sina.weibo.sdk.a.b();
        if (b4 == null) {
            return;
        }
        hVar.put(Constants.PARAM_CLIENT_ID, b4.getAppKey());
        hVar.put("redirect_uri", b4.getRedirectUrl());
        hVar.put(Constants.PARAM_SCOPE, b4.getScope());
        hVar.put("packagename", b4.getPackageName());
        hVar.put("key_hash", b4.getHash());
        hVar.put("response_type", "code");
        hVar.put("version", "0041005000");
        hVar.put("luicode", "10000360");
        hVar.put("lfid", "OP_" + b4.getAppKey());
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
        if (readAccessToken != null) {
            String accessToken = readAccessToken.getAccessToken();
            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                hVar.put("trans_token", accessToken);
                hVar.put("trans_access_token", accessToken);
            }
        }
        b4.getAppKey();
        String r10 = e.r();
        if (!TextUtils.isEmpty(r10)) {
            hVar.put("aid", r10);
        }
        String str = "https://open.weibo.cn/oauth2/authorize?" + hVar.j();
        if (this.f38338d != null) {
            b d10 = b.d();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            String sb3 = sb2.toString();
            d10.a(sb3, this.f38338d);
            Intent intent = new Intent(activity, (Class<?>) WebActivity.class);
            com.sina.weibo.sdk.web.b.a aVar = new com.sina.weibo.sdk.web.b.a(b4, str, sb3);
            Bundle bundle = new Bundle();
            aVar.writeToBundle(bundle);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
