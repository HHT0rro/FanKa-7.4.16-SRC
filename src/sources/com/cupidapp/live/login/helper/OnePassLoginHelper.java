package com.cupidapp.live.login.helper;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogAccount;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.dialog.FKBottomLoft;
import com.mobile.auth.gatewayauth.AuthRegisterXmlConfig;
import com.mobile.auth.gatewayauth.AuthUIConfig;
import com.mobile.auth.gatewayauth.AuthUIControlClickListener;
import com.mobile.auth.gatewayauth.PhoneNumberAuthHelper;
import com.mobile.auth.gatewayauth.PreLoginResultListener;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.TokenResultListener;
import com.mobile.auth.gatewayauth.model.TokenRet;
import com.mobile.auth.gatewayauth.ui.AbstractPnsViewDelegate;
import j1.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: OnePassLoginHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OnePassLoginHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final OnePassLoginHelper f16139a = new OnePassLoginHelper();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static TokenResultListener f16140b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static TokenResultListener f16141c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static PhoneNumberAuthHelper f16142d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static h f16143e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f16144f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f16145g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f16146h;

    /* compiled from: OnePassLoginHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements PreLoginResultListener {
        @Override // com.mobile.auth.gatewayauth.PreLoginResultListener
        public void onTokenFailed(@Nullable String str, @Nullable String str2) {
            j.f12332a.a("OnePassLoginHelper", "accelerateLoginPage onTokenFailed vendor: " + str + " ret: " + str2);
        }

        @Override // com.mobile.auth.gatewayauth.PreLoginResultListener
        public void onTokenSuccess(@Nullable String str) {
            j.f12332a.a("OnePassLoginHelper", "accelerateLoginPage onTokenSuccess vendor: " + str);
        }
    }

    /* compiled from: OnePassLoginHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TokenResultListener {
        @Override // com.mobile.auth.gatewayauth.TokenResultListener
        public void onTokenFailed(@Nullable String str) {
            j.f12332a.a("OnePassLoginHelper", "initAliAuthSDK onTokenFailed ret: " + str);
            try {
                OnePassLoginHelper onePassLoginHelper = OnePassLoginHelper.f16139a;
                OnePassLoginHelper.f16144f = false;
                TokenRet tokenRet = (TokenRet) JSON.parseObject(str, TokenRet.class);
                SensorsLogAccount sensorsLogAccount = SensorsLogAccount.f12205a;
                String code = tokenRet.getCode();
                String msg = tokenRet.getMsg();
                s.h(msg, "tokenRet.msg");
                sensorsLogAccount.m(code, msg, OnePassLoginStage.CHECK_AUTH);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.mobile.auth.gatewayauth.TokenResultListener
        public void onTokenSuccess(@Nullable String str) {
            j.f12332a.a("OnePassLoginHelper", "initAliAuthSDK onTokenSuccess ret: " + str);
            try {
                OnePassLoginHelper onePassLoginHelper = OnePassLoginHelper.f16139a;
                OnePassLoginHelper.f16144f = true;
                if (s.d(((TokenRet) JSON.parseObject(str, TokenRet.class)).getCode(), ResultCode.CODE_ERROR_ENV_CHECK_SUCCESS)) {
                    onePassLoginHelper.b();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static final void k(String str, Context context, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 1620409947:
                    if (str.equals(ResultCode.CODE_ERROR_USER_LOGIN_BTN) && !f16145g) {
                        SensorsLogKeyButtonClick.OnePassLogin.OnePassClick.click();
                        break;
                    }
                    break;
                case 1620409948:
                    if (str.equals(ResultCode.CODE_ERROR_USER_CHECKBOX)) {
                        Object obj = JSON.parseObject(str2).get("isChecked");
                        if (s.d(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE) && !f16145g) {
                            z3.e eVar = z3.e.f54837a;
                            PhoneNumberAuthHelper phoneNumberAuthHelper = f16142d;
                            eVar.E(phoneNumberAuthHelper != null ? phoneNumberAuthHelper.getCurrentCarrierName() : null);
                            break;
                        }
                    }
                    break;
                case 1620409951:
                    if (str.equals(ResultCode.CODE_START_AUTH_PRIVACY)) {
                        i.g(i.f50236a, PopupName.CARRIER_PRIVACY, SensorPosition.OnePassLogin, null, 4, null);
                        break;
                    }
                    break;
                case 1620409953:
                    if (str.equals(ResultCode.CODE_CLICK_AUTH_PRIVACY_CONFIRM)) {
                        f16145g = true;
                        i.f50236a.a(PopupName.CARRIER_PRIVACY, PopupButtonName.Agree, SensorPosition.OnePassLogin);
                        break;
                    }
                    break;
            }
        }
        j.f12332a.a("OnePassLoginHelper", "code: " + str + " jsonObj: " + str2);
    }

    public final void b() {
        PhoneNumberAuthHelper phoneNumberAuthHelper = f16142d;
        if (phoneNumberAuthHelper != null) {
            phoneNumberAuthHelper.accelerateLoginPage(5000, new a());
        }
    }

    public final void j(FKBaseActivity fKBaseActivity) {
        PhoneNumberAuthHelper phoneNumberAuthHelper = f16142d;
        if (phoneNumberAuthHelper != null) {
            phoneNumberAuthHelper.removeAuthRegisterXmlConfig();
        }
        PhoneNumberAuthHelper phoneNumberAuthHelper2 = f16142d;
        if (phoneNumberAuthHelper2 != null) {
            phoneNumberAuthHelper2.removeAuthRegisterViewConfig();
        }
        PhoneNumberAuthHelper phoneNumberAuthHelper3 = f16142d;
        if (phoneNumberAuthHelper3 != null) {
            phoneNumberAuthHelper3.addAuthRegisterXmlConfig(new AuthRegisterXmlConfig.Builder().setLayout(R$layout.custom_full_auth, new AbstractPnsViewDelegate() { // from class: com.cupidapp.live.login.helper.OnePassLoginHelper$configAuthUI$1
                @Override // com.mobile.auth.gatewayauth.ui.AbstractPnsViewDelegate
                public void onViewCreated(@Nullable View view) {
                    View onViewCreated$lambda$0 = findViewById(R$id.other_account_login);
                    s.h(onViewCreated$lambda$0, "onViewCreated$lambda$0");
                    y.m(onViewCreated$lambda$0, null, null, null, Integer.valueOf((z0.h.k(onViewCreated$lambda$0) / 2) - z0.h.c(onViewCreated$lambda$0, 52.0f)), 7, null);
                    y.d(onViewCreated$lambda$0, new Function1<View, p>() { // from class: com.cupidapp.live.login.helper.OnePassLoginHelper$configAuthUI$1$onViewCreated$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(View view2) {
                            invoke2(view2);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable View view2) {
                            h hVar;
                            OnePassLoginHelper.f16139a.o();
                            hVar = OnePassLoginHelper.f16143e;
                            if (hVar != null) {
                                hVar.b();
                            }
                            SensorsLogKeyButtonClick.OnePassLogin.OthersWayClick.click();
                        }
                    });
                }
            }).build());
        }
        PhoneNumberAuthHelper phoneNumberAuthHelper4 = f16142d;
        if (phoneNumberAuthHelper4 != null) {
            phoneNumberAuthHelper4.setAuthUIConfig(new AuthUIConfig.Builder().setStatusBarColor(-1).setLightColor(true).setNavHidden(true).setNumberSizeDp(32).setNumberColor(-12566464).setNumFieldOffsetY_B((z0.h.t(this, z0.h.k(this)) / 2) + 98).setSloganTextSizeDp(12).setSloganTextColor(-5658199).setSloganOffsetY_B((z0.h.t(this, z0.h.k(this)) / 2) + 70).setLogBtnWidth(z0.h.t(this, z0.h.l(this)) - 136).setLogBtnHeight(44).setLogBtnText(fKBaseActivity.getString(R$string.one_pass_login)).setLogBtnTextSizeDp(14).setLogBtnTextColor(-1).setLogBtnBackgroundPath("shape_welcome_login_bg").setLogBtnOffsetY_B(z0.h.t(this, z0.h.k(this)) / 2).setSwitchAccHidden(true).setAppPrivacyColor(-8618884, -8618884).setProtocolLayoutGravity(16).setProtocolGravity(16).setPrivacyTextSizeDp(10).setCheckboxHidden(false).setCheckedImgPath("icon_protocol_selected").setUncheckedImgPath("icon_protocol_gray_unselected").setCheckBoxWidth(14).setCheckBoxHeight(14).setPrivacyState(false).setVendorPrivacyPrefix("《").setVendorPrivacySuffix("》").setPrivacyOffsetY_B(43).setLogBtnToastHidden(true).setAuthPageActIn("alpha_in", "0").setAuthPageActOut("0", "alpha_out").setPrivacyAlertIsNeedShow(true).setPrivacyAlertIsNeedAutoLogin(true).setPrivacyAlertMaskIsNeedShow(true).setPrivacyAlertWidth(z0.h.t(this, z0.h.l(this))).setPrivacyAlertHeight(220).setPrivacyAlertBackgroundColor(-1).setPrivacyAlertTitleTextSize(20).setPrivacyAlertTitleColor(-13421773).setPrivacyAlertTitleOffsetY(26).setPrivacyAlertCornerRadiusArray(new int[]{24, 24, 0, 0}).setPrivacyAlertContentTextSize(13).setPrivacyAlertContentColor(-8618884).setPrivacyAlertContentBaseColor(-8618884).setPrivacyAlertContentHorizontalMargin(64).setPrivacyAlertContentVerticalMargin(16).setPrivacyAlertBtnWidth(z0.h.t(this, z0.h.l(this)) - 136).setPrivacyAlertBtnHeigth(44).setPrivacyAlertBtnTextSize(13).setPrivacyAlertBtnTextColor(-1).setPrivacyAlertBtnBackgroundImgPath("shape_prime_red_bg_round_corners").setPrivacyAlertCloseBtnShow(false).setPrivacyAlertAlignment(80).setPrivacyAlertEntryAnimation("anim_activity_bottom_to_top").setPrivacyAlertExitAnimation("anim_activity_top_to_bottom").create());
        }
        PhoneNumberAuthHelper phoneNumberAuthHelper5 = f16142d;
        if (phoneNumberAuthHelper5 != null) {
            phoneNumberAuthHelper5.expandAuthPageCheckedScope(true);
        }
        PhoneNumberAuthHelper phoneNumberAuthHelper6 = f16142d;
        if (phoneNumberAuthHelper6 != null) {
            phoneNumberAuthHelper6.setUIClickListener(new AuthUIControlClickListener() { // from class: com.cupidapp.live.login.helper.g
                @Override // com.mobile.auth.gatewayauth.AuthUIControlClickListener
                public final void onClick(String str, Context context, String str2) {
                    OnePassLoginHelper.k(str, context, str2);
                }
            });
        }
    }

    public final void l(final FKBaseActivity fKBaseActivity) {
        fKBaseActivity.e1();
        TokenResultListener tokenResultListener = new TokenResultListener() { // from class: com.cupidapp.live.login.helper.OnePassLoginHelper$getLoginToken$1
            @Override // com.mobile.auth.gatewayauth.TokenResultListener
            public void onTokenFailed(@Nullable String str) {
                PhoneNumberAuthHelper phoneNumberAuthHelper;
                h hVar;
                boolean z10;
                OnePassLoginStage onePassLoginStage;
                j.f12332a.a("OnePassLoginHelper", "getLoginToken onTokenFailed ret: " + str);
                try {
                    FKBaseActivity.this.V0();
                    phoneNumberAuthHelper = OnePassLoginHelper.f16142d;
                    if (phoneNumberAuthHelper != null) {
                        phoneNumberAuthHelper.hideLoginLoading();
                    }
                    TokenRet tokenRet = (TokenRet) JSON.parseObject(str, TokenRet.class);
                    if (s.d(tokenRet.getCode(), ResultCode.CODE_GET_TOKEN_FAIL)) {
                        FKBottomLoft.j(FKBottomLoft.g(FKBottomLoft.f12709e.a(FKBaseActivity.this), R$string.one_pass_login_failed, 0, 0, 6, null).k(R$string.enter_account_login, new Function0<p>() { // from class: com.cupidapp.live.login.helper.OnePassLoginHelper$getLoginToken$1$onTokenFailed$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ p invoke() {
                                invoke2();
                                return p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                h hVar2;
                                OnePassLoginHelper.f16139a.o();
                                hVar2 = OnePassLoginHelper.f16143e;
                                if (hVar2 != null) {
                                    hVar2.b();
                                }
                            }
                        }), 2131886363, null, 2, null).n();
                    } else {
                        OnePassLoginHelper.f16139a.o();
                        hVar = OnePassLoginHelper.f16143e;
                        if (hVar != null) {
                            hVar.b();
                        }
                    }
                    z10 = OnePassLoginHelper.f16146h;
                    if (z10) {
                        OnePassLoginHelper onePassLoginHelper = OnePassLoginHelper.f16139a;
                        OnePassLoginHelper.f16146h = false;
                        onePassLoginStage = OnePassLoginStage.START_AUTH_PAGE;
                    } else {
                        onePassLoginStage = OnePassLoginStage.ONE_PASS_LOGIN;
                    }
                    SensorsLogAccount sensorsLogAccount = SensorsLogAccount.f12205a;
                    String code = tokenRet.getCode();
                    String msg = tokenRet.getMsg();
                    s.h(msg, "tokenRet.msg");
                    sensorsLogAccount.m(code, msg, onePassLoginStage);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.mobile.auth.gatewayauth.TokenResultListener
            public void onTokenSuccess(@Nullable String str) {
                h hVar;
                j.f12332a.a("OnePassLoginHelper", "getLoginToken onTokenSuccess ret: " + str);
                try {
                    FKBaseActivity.this.V0();
                    TokenRet tokenRet = (TokenRet) JSON.parseObject(str, TokenRet.class);
                    String code = tokenRet.getCode();
                    if (s.d(code, ResultCode.CODE_START_AUTHPAGE_SUCCESS)) {
                        OnePassLoginHelper onePassLoginHelper = OnePassLoginHelper.f16139a;
                        OnePassLoginHelper.f16146h = false;
                        j1.c.b(j1.c.f50228a, SensorPosition.OnePassLogin, null, null, 6, null);
                    } else if (s.d(code, "600000")) {
                        hVar = OnePassLoginHelper.f16143e;
                        if (hVar != null) {
                            hVar.a(tokenRet.getToken());
                        }
                        OnePassLoginHelper.f16139a.o();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        f16141c = tokenResultListener;
        PhoneNumberAuthHelper phoneNumberAuthHelper = f16142d;
        if (phoneNumberAuthHelper != null) {
            phoneNumberAuthHelper.setAuthListener(tokenResultListener);
        }
        PhoneNumberAuthHelper phoneNumberAuthHelper2 = f16142d;
        if (phoneNumberAuthHelper2 != null) {
            phoneNumberAuthHelper2.getLoginToken(fKBaseActivity, 5000);
        }
    }

    public final void m(@Nullable FKBaseActivity fKBaseActivity) {
        if (fKBaseActivity != null && f16142d == null) {
            b bVar = new b();
            f16140b = bVar;
            PhoneNumberAuthHelper phoneNumberAuthHelper = PhoneNumberAuthHelper.getInstance(fKBaseActivity, bVar);
            f16142d = phoneNumberAuthHelper;
            if (phoneNumberAuthHelper != null) {
                phoneNumberAuthHelper.setAuthSDKInfo("xWKCLtNlP+wCVec9mT8iXqrr/aKDZyAaeZxGHxRXOIDs0QZg9PXR6NTQRAbyLlxsqNmziSy9/qrnQ+PAYq3hXjnD5T0kRSRUfR/krBbfV5mLW9gx+Dr/UrBNNFXZ869MXagLvjKZe6XOpHqLS3/X3Hst/xZ6nb4gtCz/VFZhDkjX0KQec0ZvmfBOoJOwxV2eS9WV+WQI+qWKmXdvYGQCyjirBBF48nbJdKmlnMUwH44/bKalLzWn/Gk+LQGqsY9LncdwDHnyq5R23UBctOL0jM/W92l0A34ZvcLQoI0ISNjyKBNwOIUk9A==");
            }
            PhoneNumberAuthHelper phoneNumberAuthHelper2 = f16142d;
            if (phoneNumberAuthHelper2 != null) {
                phoneNumberAuthHelper2.checkEnvAvailable(2);
            }
        }
    }

    public final void n(@Nullable FKBaseActivity fKBaseActivity, @NotNull h listener) {
        s.i(listener, "listener");
        f16143e = listener;
        if (fKBaseActivity == null) {
            if (listener != null) {
                listener.b();
            }
        } else if (f16144f) {
            f16146h = true;
            j(fKBaseActivity);
            l(fKBaseActivity);
        } else {
            o();
            h hVar = f16143e;
            if (hVar != null) {
                hVar.b();
            }
        }
    }

    public final void o() {
        PhoneNumberAuthHelper phoneNumberAuthHelper = f16142d;
        if (phoneNumberAuthHelper != null) {
            phoneNumberAuthHelper.setAuthListener(null);
        }
        PhoneNumberAuthHelper phoneNumberAuthHelper2 = f16142d;
        if (phoneNumberAuthHelper2 != null) {
            phoneNumberAuthHelper2.hideLoginLoading();
        }
        PhoneNumberAuthHelper phoneNumberAuthHelper3 = f16142d;
        if (phoneNumberAuthHelper3 != null) {
            phoneNumberAuthHelper3.quitLoginPage();
        }
    }

    public final void p() {
        f16140b = null;
        f16141c = null;
        f16142d = null;
        f16143e = null;
        f16144f = false;
        f16145g = false;
    }
}
