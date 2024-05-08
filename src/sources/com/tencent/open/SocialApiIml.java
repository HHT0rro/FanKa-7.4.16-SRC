package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SocialApiIml extends BaseApi {

    /* renamed from: a, reason: collision with root package name */
    private Activity f45116a;

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends DefaultUiListener {

        /* renamed from: b, reason: collision with root package name */
        private IUiListener f45118b;

        /* renamed from: c, reason: collision with root package name */
        private String f45119c;

        /* renamed from: d, reason: collision with root package name */
        private String f45120d;

        /* renamed from: e, reason: collision with root package name */
        private Bundle f45121e;

        /* renamed from: f, reason: collision with root package name */
        private Activity f45122f;

        public a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.f45118b = iUiListener;
            this.f45119c = str;
            this.f45120d = str2;
            this.f45121e = bundle;
            this.f45122f = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f45118b.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e2) {
                e2.printStackTrace();
                SLog.e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e2);
                str = null;
            }
            this.f45121e.putString("encrytoken", str);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a((Context) socialApiIml.f45116a, this.f45119c, this.f45121e, this.f45120d, this.f45118b);
            if (TextUtils.isEmpty(str)) {
                SLog.d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f45122f);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.f45118b.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    @Override // com.tencent.connect.common.BaseApi
    public Intent b(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        Intent intent3 = new Intent();
        intent3.setClassName(Constants.PACKAGE_QQ_PAD, str);
        if (l.c(f.a()) && i.a(f.a(), intent3)) {
            return intent3;
        }
        if (i.a(f.a(), intent2) && i.c(f.a(), "4.7") >= 0) {
            return intent2;
        }
        if (i.a(f.a(), intent) && i.a(i.a(f.a(), Constants.PACKAGE_QZONE), "4.2") >= 0 && i.a(f.a(), intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
            return intent;
        }
        return null;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f45116a = activity;
        Intent c4 = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c4 == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            c4 = c(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(b());
        a(activity, c4, SocialConstants.ACTION_INVITE, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f45116a = activity;
        Intent c4 = c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(b());
        a(activity, c4, SocialConstants.ACTION_STORY, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    public void writeEncryToken(Context context) {
        String str;
        String accessToken = this.f42565c.getAccessToken();
        String appId = this.f42565c.getAppId();
        String openId = this.f42565c.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            str = l.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        String str2 = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f42565c.getOpenId() + "_" + this.f42565c.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>";
        String a10 = h.a().a(context, "https://login.imgcache.qq.com");
        bVar.loadDataWithBaseURL(a10, str2, "text/html", "utf-8", a10);
    }

    public SocialApiIml(com.tencent.connect.auth.c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.f45116a = activity;
        Intent c4 = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c4 == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            c4 = c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = c4;
        bundle.putAll(b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", "request");
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        a(activity, intent, str, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("-->handleIntent action = ");
        sb2.append(str);
        sb2.append(", activityIntent = null ? ");
        boolean z11 = true;
        sb2.append(intent == null);
        SLog.i("openSDK_LOG.SocialApiIml", sb2.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        g a10 = g.a(f.a(), this.f42565c.getAppId());
        if (!z10 && !a10.b("C_LoginH5")) {
            z11 = false;
        }
        if (z11) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        a(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent b4 = b("com.tencent.open.agent.AgentActivity");
        IUiListener aVar = new a(activity, iUiListener, str, str2, bundle);
        Intent b10 = b("com.tencent.open.agent.EncryTokenActivity");
        if (b10 != null && b4 != null && b4.getComponent() != null && b10.getComponent() != null && b4.getComponent().getPackageName().equals(b10.getComponent().getPackageName())) {
            b10.putExtra("oauth_consumer_key", this.f42565c.getAppId());
            b10.putExtra("openid", this.f42565c.getOpenId());
            b10.putExtra("access_token", this.f42565c.getAccessToken());
            b10.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            if (a(b10)) {
                SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, aVar);
                a(activity, b10, Constants.REQUEST_SOCIAL_H5);
                return;
            }
            return;
        }
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String f10 = l.f("tencent&sdk&qazxc***14969%%" + this.f42565c.getAccessToken() + this.f42565c.getAppId() + this.f42565c.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, f10);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        aVar.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.f42565c.getAppId());
        if (this.f42565c.isSessionValid()) {
            bundle.putString("access_token", this.f42565c.getAccessToken());
        }
        String openId = this.f42565c.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString(Constants.PARAM_PLATFORM_ID, f.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        } catch (Exception e2) {
            e2.printStackTrace();
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            new TDialog(this.f45116a, str, str3, iUiListener, this.f42565c).show();
        } else {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new c(this.f45116a, str, str3, iUiListener, this.f42565c).show();
        }
    }
}
