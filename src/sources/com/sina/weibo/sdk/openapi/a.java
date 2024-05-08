package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.e;
import com.sina.weibo.sdk.web.b.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements IWBAPI {
    private Context mContext;

    /* renamed from: r, reason: collision with root package name */
    private com.sina.weibo.sdk.auth.a f38360r = new com.sina.weibo.sdk.auth.a();

    /* renamed from: s, reason: collision with root package name */
    private e f38361s = new e();

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorize(Activity activity, WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.f38360r;
        c.a("WBSsoTag", "authorize()");
        if (wbAuthListener != null) {
            aVar.f38338d = wbAuthListener;
            if (com.sina.weibo.sdk.a.a(activity)) {
                if (com.sina.weibo.sdk.b.a.e(activity) != null) {
                    aVar.a(activity);
                    return;
                }
            }
            aVar.b(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeCallback(Activity activity, int i10, int i11, Intent intent) {
        com.sina.weibo.sdk.auth.a aVar = this.f38360r;
        c.a("WBSsoTag", "authorizeCallback()");
        WbAuthListener wbAuthListener = aVar.f38338d;
        if (wbAuthListener != null) {
            if (32973 != i10) {
                wbAuthListener.onError(new UiError(-7, "request code is error", "requestCode is error"));
                return;
            }
            if (i11 != -1) {
                if (i11 == 0) {
                    wbAuthListener.onCancel();
                    return;
                } else {
                    wbAuthListener.onError(new UiError(-6, "result code is error", "result code is error"));
                    return;
                }
            }
            if (intent != null) {
                String stringExtra = intent.getStringExtra("error");
                String stringExtra2 = intent.getStringExtra("error_type");
                String stringExtra3 = intent.getStringExtra("error_description");
                if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra3)) {
                    Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                    if (parseAccessToken != null) {
                        AccessTokenHelper.writeAccessToken(activity, parseAccessToken);
                        aVar.f38338d.onComplete(parseAccessToken);
                        return;
                    } else {
                        aVar.f38338d.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
                        return;
                    }
                }
                if (!"access_denied".equals(stringExtra) && !"OAuthAccessDeniedException".equals(stringExtra)) {
                    aVar.f38338d.onError(new UiError(-5, stringExtra2, stringExtra3));
                } else {
                    aVar.f38338d.onCancel();
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeClient(Activity activity, WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.f38360r;
        c.a("WBSsoTag", "authorizeClient()");
        if (wbAuthListener != null) {
            aVar.f38338d = wbAuthListener;
            aVar.a(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeWeb(Activity activity, WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.f38360r;
        c.a("WBSsoTag", "authorizeWeb()");
        if (wbAuthListener != null) {
            aVar.f38338d = wbAuthListener;
            aVar.b(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        if (intent == null || wbShareCallback == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            int i10 = extras.getInt("_weibo_resp_errcode", -1);
            if (i10 == 0) {
                wbShareCallback.onComplete();
            } else if (i10 == 1) {
                wbShareCallback.onCancel();
            } else {
                if (i10 != 2) {
                    return;
                }
                wbShareCallback.onError(new UiError(i10, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
            }
        } catch (Exception e2) {
            wbShareCallback.onError(new UiError(-1, e2.getMessage(), e2.getMessage()));
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppInstalled() {
        return com.sina.weibo.sdk.a.a(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppSupportMultipleImage() {
        return com.sina.weibo.sdk.a.b(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo) {
        registerApp(context, authInfo, null);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void setLoggerEnable(boolean z10) {
        c.setLoggerEnable(z10);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareMessage(Activity activity, WeiboMultiMessage weiboMultiMessage, boolean z10) {
        e eVar = this.f38361s;
        if (activity != null) {
            if (com.sina.weibo.sdk.a.a(activity) || !z10) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - eVar.D >= 5000) {
                    eVar.D = currentTimeMillis;
                    if (z10) {
                        e.a(activity, weiboMultiMessage);
                        return;
                    }
                    a.C0571a e2 = com.sina.weibo.sdk.b.a.e(activity);
                    if (com.sina.weibo.sdk.a.a(activity) && e2 != null) {
                        a.C0571a e10 = com.sina.weibo.sdk.b.a.e(activity);
                        boolean z11 = false;
                        if (e10 != null && e10.af > 10000) {
                            z11 = true;
                        }
                        if (z11) {
                            e.a(activity, weiboMultiMessage);
                            return;
                        }
                    }
                    AuthInfo b4 = com.sina.weibo.sdk.a.b();
                    if (b4 != null) {
                        d dVar = new d(b4);
                        dVar.setContext(activity);
                        dVar.aC = weiboMultiMessage;
                        dVar.packageName = activity.getPackageName();
                        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
                        if (readAccessToken != null) {
                            String accessToken = readAccessToken.getAccessToken();
                            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                                dVar.f38372ac = accessToken;
                            }
                        }
                        Bundle bundle = new Bundle();
                        dVar.writeToBundle(bundle);
                        Intent intent = new Intent(activity, (Class<?>) ShareTransActivity.class);
                        intent.putExtra("start_flag", 1001);
                        intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                        intent.putExtras(bundle);
                        activity.startActivityForResult(intent, 10001);
                    }
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener) {
        registerApp(context, authInfo, sdkListener, null);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener, SdkConfig sdkConfig) {
        com.sina.weibo.sdk.a.a(context, authInfo, sdkListener, sdkConfig);
    }
}
