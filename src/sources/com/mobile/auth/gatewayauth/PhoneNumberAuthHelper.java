package com.mobile.auth.gatewayauth;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import com.mobile.auth.BuildConfig;
import com.mobile.auth.gatewayauth.annotations.AuthNumber;
import com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor;
import com.mobile.auth.gatewayauth.model.LoginPhoneInfo;
import com.mobile.auth.gatewayauth.model.UStruct;
import com.mobile.auth.gatewayauth.utils.g;
import com.nirvana.tools.core.ExecutorManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PhoneNumberAuthHelper {

    @AuthNumber
    public static final int SERVICE_TYPE_AUTH = 1;

    @AuthNumber
    public static final int SERVICE_TYPE_LOGIN = 2;

    /* renamed from: a, reason: collision with root package name */
    public static volatile PhoneNumberAuthHelper f36865a;

    /* renamed from: b, reason: collision with root package name */
    private TokenResultListener f36866b;

    /* renamed from: c, reason: collision with root package name */
    private d f36867c;

    /* renamed from: d, reason: collision with root package name */
    private ResultCodeProcessor f36868d = new com.mobile.auth.gatewayauth.manager.compat.a();

    /* renamed from: e, reason: collision with root package name */
    private ResultCodeProcessor f36869e = new com.mobile.auth.gatewayauth.manager.compat.b();

    /* renamed from: f, reason: collision with root package name */
    private PhoneNumberAuthHelperProxy f36870f;

    private PhoneNumberAuthHelper(Context context, TokenResultListener tokenResultListener) {
        this.f36870f = PhoneNumberAuthHelperProxy.getInstance(context, tokenResultListener);
        this.f36866b = tokenResultListener;
        this.f36867c = new d(context, this.f36870f.b(), this.f36870f.a(), this);
    }

    public static /* synthetic */ ResultCodeProcessor a(PhoneNumberAuthHelper phoneNumberAuthHelper) {
        try {
            return phoneNumberAuthHelper.f36869e;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    private boolean a(long j10, final String str, final ResultCodeProcessor resultCodeProcessor, final TokenResultListener tokenResultListener, LoginPhoneInfo loginPhoneInfo, final String str2) {
        if (loginPhoneInfo != null) {
            try {
                if (!TextUtils.isEmpty(loginPhoneInfo.getPhoneNumber())) {
                    try {
                        this.f36867c.a(j10, loginPhoneInfo.getPhoneNumber(), str, resultCodeProcessor, new e() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelper.3
                            @Override // com.mobile.auth.gatewayauth.e
                            public void a(String str3) {
                                try {
                                    PhoneNumberAuthHelper.b(PhoneNumberAuthHelper.this).a(false, true, Constant.CODE_ERROR_START_AUTH_PAGE_FAIL, "唤起授权页失败", com.mobile.auth.gatewayauth.utils.a.a(Constant.CODE_ERROR_START_AUTH_PAGE_FAIL, "唤起授权页失败"), str, null, tokenResultListener, resultCodeProcessor, str2);
                                } catch (Throwable th) {
                                    ExceptionProcessor.processException(th);
                                }
                            }

                            @Override // com.mobile.auth.gatewayauth.e
                            public void a(String str3, String str4) {
                                try {
                                    PhoneNumberAuthHelper.b(PhoneNumberAuthHelper.this).a(true, false, Constant.CODE_START_AUTH_PAGE_SUCCESS, "唤起授权页成功", "", str, null, tokenResultListener, resultCodeProcessor, str2);
                                } catch (Throwable th) {
                                    ExceptionProcessor.processException(th);
                                }
                            }
                        });
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        ExceptionProcessor.processException(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean a(PhoneNumberAuthHelper phoneNumberAuthHelper, long j10, String str, ResultCodeProcessor resultCodeProcessor, TokenResultListener tokenResultListener, LoginPhoneInfo loginPhoneInfo, String str2) {
        try {
            return phoneNumberAuthHelper.a(j10, str, resultCodeProcessor, tokenResultListener, loginPhoneInfo, str2);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public static /* synthetic */ PhoneNumberAuthHelperProxy b(PhoneNumberAuthHelper phoneNumberAuthHelper) {
        try {
            return phoneNumberAuthHelper.f36870f;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ d c(PhoneNumberAuthHelper phoneNumberAuthHelper) {
        try {
            return phoneNumberAuthHelper.f36867c;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ TokenResultListener d(PhoneNumberAuthHelper phoneNumberAuthHelper) {
        try {
            return phoneNumberAuthHelper.f36866b;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    @AuthNumber
    public static PhoneNumberAuthHelper getInstance(Context context, TokenResultListener tokenResultListener) {
        try {
            if (f36865a == null && context != null) {
                synchronized (PhoneNumberAuthHelper.class) {
                    if (f36865a == null) {
                        f36865a = new PhoneNumberAuthHelper(context, tokenResultListener);
                    }
                }
            }
            f36865a.setAuthListener(tokenResultListener);
            return f36865a;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    @AuthNumber
    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public void a(long j10, TokenResultListener tokenResultListener, ResultCodeProcessor resultCodeProcessor) {
        try {
            this.f36870f.a(j10, tokenResultListener, resultCodeProcessor);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void accelerateLoginPage(int i10, PreLoginResultListener preLoginResultListener) {
        try {
            this.f36870f.accelerateLoginPage(i10, preLoginResultListener, this.f36867c.C());
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void accelerateVerify(int i10, PreLoginResultListener preLoginResultListener) {
        try {
            this.f36870f.accelerateVerify(i10, preLoginResultListener);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void addAuthRegistViewConfig(String str, AuthRegisterViewConfig authRegisterViewConfig) {
        try {
            this.f36867c.a(str, authRegisterViewConfig);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void addAuthRegisterXmlConfig(AuthRegisterXmlConfig authRegisterXmlConfig) {
        try {
            this.f36867c.a(authRegisterXmlConfig);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void addPrivacyAuthRegistViewConfig(String str, AuthRegisterViewConfig authRegisterViewConfig) {
        try {
            this.f36867c.b(str, authRegisterViewConfig);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void addPrivacyRegisterXmlConfig(AuthRegisterXmlConfig authRegisterXmlConfig) {
        try {
            this.f36867c.b(authRegisterXmlConfig);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void checkBoxAnimationStart() {
        try {
            this.f36867c.l();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void checkEnvAvailable(@IntRange(from = 1, to = 2) int i10) {
        try {
            this.f36870f.checkEnvAvailable(i10, this.f36866b);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    @Deprecated
    public boolean checkEnvAvailable() {
        try {
            return this.f36870f.checkEnvAvailable();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    @AuthNumber
    public void clearPreInfo() {
        try {
            this.f36870f.clearPreInfo();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void closeAuthPageReturnBack(boolean z10) {
        try {
            d dVar = this.f36867c;
            if (dVar != null) {
                dVar.a(z10);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void expandAuthPageCheckedScope(boolean z10) {
        try {
            d dVar = this.f36867c;
            if (dVar != null) {
                dVar.c(z10);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public String getCurrentCarrierName() {
        try {
            return this.f36870f.getCurrentCarrierName();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    @AuthNumber
    public void getLoginToken(final Context context, final int i10) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new g.a() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelper.2
                @Override // com.mobile.auth.gatewayauth.utils.g.a
                public void a() {
                    try {
                        if (context instanceof Activity) {
                            PhoneNumberAuthHelper.c(PhoneNumberAuthHelper.this).b((Activity) context);
                        }
                        final String c4 = PhoneNumberAuthHelper.b(PhoneNumberAuthHelper.this).a().c();
                        final String j10 = PhoneNumberAuthHelper.b(PhoneNumberAuthHelper.this).b().j();
                        if (!com.mobile.auth.gatewayauth.utils.d.a().b()) {
                            PhoneNumberAuthHelper.b(PhoneNumberAuthHelper.this).a(true, false, Constant.CODE_ERROR_START_AUTH_PAGE_FAIL, Constant.MSG_ERROR_AUTHPAGE_FAIL, "", c4, null, PhoneNumberAuthHelper.d(PhoneNumberAuthHelper.this), PhoneNumberAuthHelper.a(PhoneNumberAuthHelper.this), j10);
                        } else {
                            com.mobile.auth.gatewayauth.utils.d.a().a(false);
                            PhoneNumberAuthHelper.b(PhoneNumberAuthHelper.this).getLoginMaskPhone(i10, c4, new OnLoginPhoneListener() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelper.2.1
                                @Override // com.mobile.auth.gatewayauth.OnLoginPhoneListener
                                public void onGetFailed(String str) {
                                    try {
                                        com.mobile.auth.gatewayauth.utils.d.a().a(true);
                                        if (PhoneNumberAuthHelper.d(PhoneNumberAuthHelper.this) != null) {
                                            PhoneNumberAuthHelper.d(PhoneNumberAuthHelper.this).onTokenFailed(str);
                                        }
                                    } catch (Throwable th) {
                                        ExceptionProcessor.processException(th);
                                    }
                                }

                                @Override // com.mobile.auth.gatewayauth.OnLoginPhoneListener
                                public void onGetLoginPhone(LoginPhoneInfo loginPhoneInfo) {
                                    try {
                                        PhoneNumberAuthHelper phoneNumberAuthHelper = PhoneNumberAuthHelper.this;
                                        PhoneNumberAuthHelper.a(phoneNumberAuthHelper, i10, c4, PhoneNumberAuthHelper.a(phoneNumberAuthHelper), PhoneNumberAuthHelper.d(PhoneNumberAuthHelper.this), loginPhoneInfo, j10);
                                    } catch (Throwable th) {
                                        ExceptionProcessor.processException(th);
                                    }
                                }
                            }, false, true, j10);
                        }
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public PnsReporter getReporter() {
        try {
            return this.f36870f.getReporter();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    @AuthNumber
    public void getVerifyToken(int i10) {
        try {
            this.f36870f.getVerifyToken(i10, this.f36866b);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void hideLoginLoading() {
        try {
            this.f36867c.j();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void keepAllPageHideNavigationBar() {
        try {
            d dVar = this.f36867c;
            if (dVar != null) {
                dVar.c();
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void keepAuthPageLandscapeFullSreen(boolean z10) {
        try {
            d dVar = this.f36867c;
            if (dVar != null) {
                dVar.b(z10);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void openUserPage(Class<?> cls, int i10, int i11) {
        try {
            this.f36867c.a(cls, i10, i11);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void privacyAnimationStart() {
        try {
            this.f36867c.k();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void prohibitUseUtdid() {
        try {
            this.f36870f.prohibitUseUtdid();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public boolean queryCheckBoxIsChecked() {
        try {
            return this.f36867c.m();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    @AuthNumber
    public void quitLoginPage() {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            this.f36867c.a(this.f36869e);
            this.f36867c.n();
            com.mobile.auth.gatewayauth.utils.d.a().a(true);
            final long currentTimeMillis2 = System.currentTimeMillis();
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.PhoneNumberAuthHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PhoneNumberAuthHelper.b(PhoneNumberAuthHelper.this).c().a(PhoneNumberAuthHelper.b(PhoneNumberAuthHelper.this).b().b("", Constant.ACTION_SDK_QUIT_AUTH_PAGE, UStruct.newUStruct().startTime(currentTimeMillis).endTime(currentTimeMillis2).build(), PhoneNumberAuthHelper.a(PhoneNumberAuthHelper.this).getApiLevel()), 2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void quitPrivacyPage() {
        try {
            this.f36867c.z();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void removeAuthRegisterViewConfig() {
        try {
            this.f36867c.v();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void removeAuthRegisterXmlConfig() {
        try {
            this.f36867c.y();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void removePrivacyAuthRegisterViewConfig() {
        try {
            this.f36867c.w();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void removePrivacyRegisterXmlConfig() {
        try {
            this.f36867c.x();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void setActivityResultListener(ActivityResultListener activityResultListener) {
        try {
            this.f36867c.a(activityResultListener);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void setAuthListener(TokenResultListener tokenResultListener) {
        try {
            this.f36866b = tokenResultListener;
            this.f36870f.setAuthListener(tokenResultListener);
            this.f36867c.a(tokenResultListener);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void setAuthPageUseDayLight(boolean z10) {
        try {
            this.f36867c.e(z10);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void setAuthSDKInfo(String str) {
        try {
            this.f36870f.setAuthSDKInfo(str);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void setAuthUIConfig(AuthUIConfig authUIConfig) {
        try {
            this.f36867c.a(authUIConfig);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void setProtocolChecked(boolean z10) {
        try {
            this.f36867c.f(z10);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void setUIClickListener(AuthUIControlClickListener authUIControlClickListener) {
        try {
            this.f36867c.a(authUIControlClickListener);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @AuthNumber
    public void userControlAuthPageCancel() {
        try {
            d dVar = this.f36867c;
            if (dVar != null) {
                dVar.d(true);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }
}
