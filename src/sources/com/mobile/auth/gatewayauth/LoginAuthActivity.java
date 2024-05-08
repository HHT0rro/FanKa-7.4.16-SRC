package com.mobile.auth.gatewayauth;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.mobile.auth.gatewayauth.annotations.AuthNumber;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.utils.i;
import com.mobile.auth.gatewayauth.utils.j;
import com.mobile.auth.gatewayauth.utils.k;
import com.mobile.auth.gatewayauth.utils.l;
import com.nirvana.tools.core.AppUtils;
import com.nirvana.tools.core.ExecutorManager;
import com.nirvana.tools.core.SupportJarUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@AuthNumber
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LoginAuthActivity extends Activity {
    private static final int DP_MODE = 1073741824;
    public static final String EXIST = "exist";
    private static final int MODE_MASK = -1073741824;
    private static final int MODE_SHIFT = 30;
    public static final String STOP_LOADING = "stop_loading";
    private String mAccessCode;
    private String mBeginProtocol;
    private RelativeLayout mBodyDYVRL;
    private RelativeLayout mBodyRL;
    private RelativeLayout mLoginRL;
    private TextView mLoginTV;
    private ImageView mLogoIV;
    private RelativeLayout mMainRelativeLayout;
    private TextView mMaskNumberTV;
    private RelativeLayout mNumberDYVRL;
    private String mNumberPhone;
    private RelativeLayout mNumberRL;
    private com.mobile.auth.q.a mPnsLogger;
    private com.mobile.auth.y.a mProgressDialog;
    private String mProtocol;
    private FrameLayout mProtocolCbContainer;
    private RelativeLayout mProtocolRL;
    private CheckBox mProtocolSelectCB;
    private TextView mProtocolTV;
    private String mSlogan;
    private TextView mSloganTV;
    private TextView mSwitchTV;
    private RelativeLayout mTitleDYVRL;
    private RelativeLayout mTitleRL;
    private AuthUIConfig mUIConfig;
    private d mUIManager;
    private int mUIManagerID;
    private String mVendorClick;
    private String mVendorKey;
    private String mVendorProtocol;
    private long startTime;
    private boolean mIsDialog = false;
    private List<com.mobile.auth.gatewayauth.ui.b> mProtocolConfigs = new ArrayList(3);
    private boolean orientationIsLandscape = false;

    /* renamed from: com.mobile.auth.gatewayauth.LoginAuthActivity$10, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass10 implements View.OnClickListener {
        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                LoginAuthActivity.access$100(LoginAuthActivity.this).d(LoginAuthActivity.access$200(LoginAuthActivity.this));
                LoginAuthActivity.access$300(LoginAuthActivity.this, true, Constant.CODE_ERROR_USER_SWITCH, "用户切换其他登录方式");
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.LoginAuthActivity$11, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass11 implements View.OnClickListener {
        public AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                LoginAuthActivity.access$700(LoginAuthActivity.this).setChecked(!LoginAuthActivity.access$700(LoginAuthActivity.this).isChecked());
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.LoginAuthActivity$12, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass12 implements CompoundButton.OnCheckedChangeListener {
        public AnonymousClass12() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            try {
                if (z10) {
                    LoginAuthActivity.access$100(LoginAuthActivity.this).g(true);
                } else {
                    LoginAuthActivity.access$100(LoginAuthActivity.this).g(false);
                }
                LoginAuthActivity.access$000(LoginAuthActivity.this).setActivated(LoginAuthActivity.access$700(LoginAuthActivity.this).isChecked());
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.LoginAuthActivity$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass3 extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f36851a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f36852b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f36853c;

        public AnonymousClass3(String str, String str2, int i10) {
            this.f36851a = str;
            this.f36852b = str2;
            this.f36853c = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            try {
                LoginAuthActivity.access$100(LoginAuthActivity.this).a(LoginAuthActivity.access$200(LoginAuthActivity.this), this.f36851a, this.f36852b, false);
                LoginAuthActivity.access$100(LoginAuthActivity.this).a(this.f36851a, this.f36852b);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            try {
                super.updateDrawState(textPaint);
                textPaint.setColor(this.f36853c);
                if (LoginAuthActivity.access$600(LoginAuthActivity.this).isProtocolNameUseUnderLine()) {
                    textPaint.setUnderlineText(true);
                } else {
                    textPaint.setUnderlineText(false);
                }
                if (LoginAuthActivity.access$600(LoginAuthActivity.this).getProtocolNameTypeface() != null) {
                    textPaint.setTypeface(LoginAuthActivity.access$600(LoginAuthActivity.this).getProtocolNameTypeface());
                }
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.LoginAuthActivity$5, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass5 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f36856a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f36857b;

        public AnonymousClass5(LinkedHashMap linkedHashMap, String str) {
            this.f36856a = linkedHashMap;
            this.f36857b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomInterface customInterface;
            try {
                AuthRegisterViewConfig authRegisterViewConfig = (AuthRegisterViewConfig) this.f36856a.get(this.f36857b);
                if (authRegisterViewConfig == null || (customInterface = authRegisterViewConfig.getCustomInterface()) == null) {
                    return;
                }
                customInterface.onClick(LoginAuthActivity.this);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.LoginAuthActivity$6, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass6 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f36859a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f36860b;

        public AnonymousClass6(LinkedHashMap linkedHashMap, String str) {
            this.f36859a = linkedHashMap;
            this.f36860b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomInterface customInterface;
            try {
                AuthRegisterViewConfig authRegisterViewConfig = (AuthRegisterViewConfig) this.f36859a.get(this.f36860b);
                if (authRegisterViewConfig == null || (customInterface = authRegisterViewConfig.getCustomInterface()) == null) {
                    return;
                }
                customInterface.onClick(LoginAuthActivity.this);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.LoginAuthActivity$7, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (LoginAuthActivity.access$100(LoginAuthActivity.this).h()) {
                    LoginAuthActivity.access$100(LoginAuthActivity.this).b(LoginAuthActivity.access$200(LoginAuthActivity.this));
                } else {
                    LoginAuthActivity.access$100(LoginAuthActivity.this).a(LoginAuthActivity.access$200(LoginAuthActivity.this));
                    LoginAuthActivity.access$300(LoginAuthActivity.this, true, Constant.CODE_ERROR_USER_CANCEL, Constant.MSG_ERROR_USER_CANCEL);
                }
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.LoginAuthActivity$8, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                LoginAuthActivity.access$000(LoginAuthActivity.this).setClickable(false);
                boolean access$400 = LoginAuthActivity.access$400(LoginAuthActivity.this);
                if (!access$400) {
                    LoginAuthActivity.access$500(LoginAuthActivity.this).e("LoginAuthActivity errorCode = ", ResultCode.CODE_ERROR_PHONE_UNSAFE_FAIL, "; errorMsg = 页面非法修改");
                    LoginAuthActivity.access$000(LoginAuthActivity.this).setClickable(true);
                    if (k.a(LoginAuthActivity.this.getApplicationContext())) {
                        Toast.makeText(LoginAuthActivity.this.getApplicationContext(), "页面非法修改！", 1).show();
                        return;
                    }
                }
                if (LoginAuthActivity.access$600(LoginAuthActivity.this).isCheckboxHidden() || LoginAuthActivity.access$700(LoginAuthActivity.this).isChecked()) {
                    LoginAuthActivity.access$100(LoginAuthActivity.this).a(LoginAuthActivity.access$200(LoginAuthActivity.this), true, access$400);
                    LoginAuthActivity.this.showLoadingDialog();
                    LoginAuthActivity.access$500(LoginAuthActivity.this).a("LoginAuthActivity", "; PhoneNumberAuthHelper2 = ", String.valueOf(LoginAuthActivity.access$100(LoginAuthActivity.this)));
                    LoginAuthActivity.access$100(LoginAuthActivity.this).b(LoginAuthActivity.access$100(LoginAuthActivity.this).a());
                    return;
                }
                LoginAuthActivity.this.animateProtocolTV();
                LoginAuthActivity.this.animateCheckBox();
                if (!LoginAuthActivity.access$600(LoginAuthActivity.this).isLogBtnToastHidden()) {
                    Toast.makeText(LoginAuthActivity.this.getApplicationContext(), "请同意服务条款", 1).show();
                }
                LoginAuthActivity.access$100(LoginAuthActivity.this).a(LoginAuthActivity.access$200(LoginAuthActivity.this), false, access$400);
                if (LoginAuthActivity.access$600(LoginAuthActivity.this).isPrivacyAlertIsNeedShow()) {
                    LoginAuthActivity.access$800(LoginAuthActivity.this, access$400);
                } else {
                    LoginAuthActivity.access$000(LoginAuthActivity.this).setClickable(true);
                }
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
    }

    public static /* synthetic */ RelativeLayout access$000(LoginAuthActivity loginAuthActivity) {
        try {
            return loginAuthActivity.mLoginRL;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ d access$100(LoginAuthActivity loginAuthActivity) {
        try {
            return loginAuthActivity.mUIManager;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ String access$200(LoginAuthActivity loginAuthActivity) {
        try {
            return loginAuthActivity.mVendorKey;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ void access$300(LoginAuthActivity loginAuthActivity, boolean z10, String str, String str2) {
        try {
            loginAuthActivity.finishAuthPage(z10, str, str2);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public static /* synthetic */ boolean access$400(LoginAuthActivity loginAuthActivity) {
        try {
            return loginAuthActivity.checkAuthPageUILegal();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public static /* synthetic */ com.mobile.auth.q.a access$500(LoginAuthActivity loginAuthActivity) {
        try {
            return loginAuthActivity.mPnsLogger;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ AuthUIConfig access$600(LoginAuthActivity loginAuthActivity) {
        try {
            return loginAuthActivity.mUIConfig;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ CheckBox access$700(LoginAuthActivity loginAuthActivity) {
        try {
            return loginAuthActivity.mProtocolSelectCB;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ void access$800(LoginAuthActivity loginAuthActivity, boolean z10) {
        try {
            loginAuthActivity.showPrivacyDialog(z10);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public static /* synthetic */ void access$900(LoginAuthActivity loginAuthActivity) {
        try {
            loginAuthActivity.changeStatueBarColor();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void changeStatueBarColor() {
        try {
            String str = j.a(Long.valueOf(this.mUIConfig.getPrivacyAlertMaskAlpha() * 255.0f), 2) + j.a(this.mUIConfig.getPrivacyAlertMaskColor()).substring(2);
            d.a(this.mUIConfig, Color.parseColor("#" + str), this);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private boolean checkAuthPageUILegal() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        try {
            if (l.a(this.mProtocolTV) || l.a(this.mLoginTV) || l.a(this.mMaskNumberTV) || (textView = this.mLoginTV) == null || l.a(textView.getCurrentTextColor()) || (textView2 = this.mProtocolTV) == null || l.a(textView2.getCurrentTextColor()) || (textView3 = this.mMaskNumberTV) == null) {
                return false;
            }
            return !l.a(textView3.getCurrentTextColor());
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    private SpannableString dealProtocol(String str, List<com.mobile.auth.gatewayauth.ui.b> list) {
        String str2;
        String str3;
        int protocolOneColor;
        try {
            SpannableString spannableString = new SpannableString(str);
            if (l.a(this.mUIConfig.getProtocolOwnColor())) {
                str2 = this.mVendorProtocol;
                str3 = this.mVendorClick;
                protocolOneColor = this.mUIConfig.getProtocolOneColor();
            } else {
                str2 = this.mVendorProtocol;
                str3 = this.mVendorClick;
                protocolOneColor = this.mUIConfig.getProtocolOwnColor();
            }
            ClickableSpan vendorProtocol = getVendorProtocol(str2, str3, protocolOneColor);
            for (com.mobile.auth.gatewayauth.ui.b bVar : list) {
                ClickableSpan protocol = getProtocol(bVar.b(), bVar.c(), bVar.d());
                int indexOf = str.indexOf(bVar.b());
                spannableString.setSpan(protocol, indexOf, bVar.b().length() + indexOf, 34);
            }
            spannableString.setSpan(vendorProtocol, str.indexOf(this.mVendorProtocol), str.indexOf(this.mVendorProtocol) + this.mVendorProtocol.length(), 34);
            if (this.mUIManager.g() && !this.mUIConfig.isCheckboxHidden()) {
                spannableString.setSpan(new ClickableSpan() { // from class: com.mobile.auth.gatewayauth.LoginAuthActivity.4
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        try {
                            LoginAuthActivity.access$700(LoginAuthActivity.this).setChecked(!LoginAuthActivity.access$700(LoginAuthActivity.this).isChecked());
                        } catch (Throwable th) {
                            ExceptionProcessor.processException(th);
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        try {
                            super.updateDrawState(textPaint);
                            textPaint.setUnderlineText(false);
                            textPaint.setColor(LoginAuthActivity.access$600(LoginAuthActivity.this).getProtocolColor());
                        } catch (Throwable th) {
                            ExceptionProcessor.processException(th);
                        }
                    }
                }, str.indexOf(this.mBeginProtocol), str.indexOf(this.mBeginProtocol) + this.mBeginProtocol.length(), 34);
            }
            return spannableString;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    private void finishAuthPage(boolean z10, String str, String str2) {
        try {
            d dVar = this.mUIManager;
            if (dVar != null) {
                dVar.a(z10, str, str2);
            } else {
                this.mPnsLogger.e("Exception finish!");
                finish();
            }
            if (this.mUIConfig.getAuthPageActOut() == null || this.mUIConfig.getActivityIn() == null) {
                return;
            }
            overridePendingTransition(AppUtils.getAnimResID(this, this.mUIConfig.getAuthPageActOut()), AppUtils.getAnimResID(this, this.mUIConfig.getActivityIn()));
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private native ClickableSpan getProtocol(String str, String str2, int i10);

    private int getResId(String str) {
        try {
            return getResources().getIdentifier(str, "anim", getPackageName());
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    private int getStatusBarHeight(Context context) {
        try {
            return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    private ClickableSpan getVendorProtocol(final String str, final String str2, final int i10) {
        try {
            return new ClickableSpan() { // from class: com.mobile.auth.gatewayauth.LoginAuthActivity.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    try {
                        LoginAuthActivity.access$100(LoginAuthActivity.this).a(LoginAuthActivity.access$200(LoginAuthActivity.this), str, str2, true);
                        LoginAuthActivity.access$100(LoginAuthActivity.this).a(str, str2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    try {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(i10);
                        if (LoginAuthActivity.access$600(LoginAuthActivity.this).isProtocolNameUseUnderLine()) {
                            textPaint.setUnderlineText(true);
                        } else {
                            textPaint.setUnderlineText(false);
                        }
                        if (LoginAuthActivity.access$600(LoginAuthActivity.this).getProtocolNameTypeface() != null) {
                            textPaint.setTypeface(LoginAuthActivity.access$600(LoginAuthActivity.this).getProtocolNameTypeface());
                        }
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            };
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    @SafeProtector
    private native void init();

    @SafeProtector
    private native RelativeLayout initBodyView();

    @SafeProtector
    private native void initDynamicView();

    @SafeProtector
    private void initIntentData() {
        try {
            Intent intent = getIntent();
            this.mNumberPhone = intent.getStringExtra("number");
            this.mVendorKey = intent.getStringExtra(Constant.LOGIN_ACTIVITY_VENDOR_KEY);
            this.mAccessCode = intent.getStringExtra(Constant.LOGIN_ACTIVITY_ACCESS_CODE);
            this.startTime = intent.getLongExtra("startTime", 0L);
            this.mUIManagerID = intent.getIntExtra(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, 0);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @SafeProtector
    private native RelativeLayout initLoginRL();

    @SafeProtector
    private native ImageView initLogoView();

    @SafeProtector
    private native void initMaskNumberDynamicView();

    @SafeProtector
    private native RelativeLayout initNumberView();

    @SafeProtector
    private native RelativeLayout initProtocolView();

    @SafeProtector
    private native TextView initSloganView();

    @SafeProtector
    private native TextView initSwitchView();

    @SafeProtector
    private native RelativeLayout initTitleView();

    @SafeProtector
    private native void initView();

    @SafeProtector
    private native void initXMLDynamicView();

    private boolean isTouchPointInView(View view, int i10, int i11) {
        if (view == null) {
            return false;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i12 = iArr[0];
            int i13 = iArr[1];
            return i11 >= i13 && i11 <= view.getMeasuredHeight() + i13 && i10 >= i12 && i10 <= view.getMeasuredWidth() + i12;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    @SafeProtector
    private native void removeDynamicView();

    private void removeDynamicXmlView() {
        ArrayList<AuthRegisterXmlConfig> t2;
        try {
            d dVar = this.mUIManager;
            if (dVar != null && (t2 = dVar.t()) != null && t2.size() != 0) {
                Iterator<AuthRegisterXmlConfig> iterator2 = t2.iterator2();
                while (iterator2.hasNext()) {
                    try {
                        View rootView = iterator2.next().getViewDelegate().getRootView();
                        rootView.setOnClickListener(null);
                        this.mMainRelativeLayout.removeView(rootView);
                    } catch (Exception e2) {
                        i.a(e2);
                    }
                }
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @SafeProtector
    private native void removeNumberView();

    private void restAllChildViews(View view) {
        try {
            if (!(view instanceof ViewGroup)) {
                if (view instanceof TextView) {
                    float textSize = ((TextView) view).getTextSize();
                    float a10 = textSize / a.a();
                    if (textSize != 0.0f) {
                        this.mUIConfig.setTextSize((TextView) view, makeTextSizeSpec(px2dp(a10), 1073741824));
                        return;
                    }
                    return;
                }
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt instanceof TextView) {
                    float textSize2 = ((TextView) childAt).getTextSize();
                    float a11 = textSize2 / a.a();
                    if (textSize2 != 0.0f) {
                        this.mUIConfig.setTextSize((TextView) childAt, makeTextSizeSpec(px2dp(a11), 1073741824));
                    }
                } else if (childAt instanceof ViewGroup) {
                    restAllChildViews(childAt);
                }
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void setBackground(View view, Drawable drawable) {
        try {
            view.setBackground(drawable);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void setDialogBackGroundAlpha(float f10) {
        try {
            getWindow().setDimAmount(f10);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void showPrivacyDialog(boolean z10) {
        try {
            this.mUIManager.b(this.mVendorKey, false, z10);
            Intent intent = new Intent(this, (Class<?>) PrivacyDialogActivity.class);
            intent.putExtra(Constant.LOGIN_ACTIVITY_VENDOR_KEY, this.mVendorKey);
            intent.putExtra(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, this.mUIManagerID);
            if (this.mUIConfig.getPrivacyAlertEntryAnimation() == null || this.mUIConfig.getPrivacyAlertExitAnimation() == null) {
                startActivityForResult(intent, 1);
            } else {
                String privacyAlertEntryAnimation = this.mUIConfig.getPrivacyAlertEntryAnimation();
                String privacyAlertExitAnimation = this.mUIConfig.getPrivacyAlertExitAnimation();
                if (!TextUtils.isEmpty(privacyAlertEntryAnimation) && !TextUtils.isEmpty(privacyAlertExitAnimation)) {
                    SupportJarUtils.startActivityForResult(this, intent, 1, privacyAlertEntryAnimation, privacyAlertExitAnimation);
                    ExecutorManager.getInstance().postMain(new Runnable() { // from class: com.mobile.auth.gatewayauth.LoginAuthActivity.9
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                LoginAuthActivity.access$900(LoginAuthActivity.this);
                            } catch (Throwable th) {
                                ExceptionProcessor.processException(th);
                            }
                        }
                    }, AnimationUtils.loadAnimation(this, getResId(privacyAlertEntryAnimation)).getDuration());
                    return;
                }
                SupportJarUtils.startActivityForResult(this, intent, 1, null, null);
            }
            changeStatueBarColor();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private void xmlLoadErrorCB() {
        try {
            d dVar = this.mUIManager;
            if (dVar != null) {
                dVar.p();
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void animateCheckBox() {
        try {
            if (TextUtils.isEmpty(this.mUIConfig.getCheckBoxShakePath()) || this.mUIConfig.isCheckboxHidden()) {
                return;
            }
            this.mProtocolSelectCB.startAnimation(AnimationUtils.loadAnimation(this, AppUtils.getAnimResID(this, this.mUIConfig.getCheckBoxShakePath())));
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void animateProtocolTV() {
        try {
            if (TextUtils.isEmpty(this.mUIConfig.getProtocolShakePath())) {
                return;
            }
            this.mProtocolTV.startAnimation(AnimationUtils.loadAnimation(this, AppUtils.getAnimResID(this, this.mUIConfig.getProtocolShakePath())));
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (this.mIsDialog && this.mUIConfig.isTapAuthPageMaskClosePage() && motionEvent.getAction() == 1 && !isTouchPointInView(this.mMainRelativeLayout, rawX, rawY)) {
                this.mUIManager.a(this.mVendorKey);
                finishAuthPage(true, Constant.CODE_ERROR_USER_CANCEL, Constant.MSG_ERROR_USER_CANCEL);
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public int getUIManagerID() {
        try {
            return this.mUIManagerID;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public void hideLoadingDialog() {
        com.mobile.auth.y.a aVar;
        try {
            AuthUIConfig authUIConfig = this.mUIConfig;
            if (authUIConfig == null || authUIConfig.isHiddenLoading() || this.mUIManager == null || (aVar = this.mProgressDialog) == null || !aVar.isShowing()) {
                return;
            }
            this.mProgressDialog.dismiss();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public int makeTextSizeSpec(int i10, int i11) {
        return (i10 & View.LAST_APP_AUTOFILL_ID) | (i11 & MODE_MASK);
    }

    @Override // android.app.Activity
    @SafeProtector
    public native void onActivityResult(int i10, int i11, Intent intent);

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            if (this.mUIManager.h()) {
                this.mUIManager.c(this.mVendorKey);
            } else if (!this.mUIManager.e()) {
                super.onBackPressed();
                finishAuthPage(true, Constant.CODE_ERROR_USER_CANCEL, Constant.MSG_ERROR_USER_CANCEL);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            hideLoadingDialog();
            removeDynamicView();
            removeNumberView();
            removeDynamicXmlView();
            this.mUIManager = null;
            this.mUIConfig = null;
            super.onDestroy();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
            this.mUIManager.d();
            this.mUIManager.a((Activity) this);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            this.mLoginRL.setClickable(true);
            AuthUIConfig authUIConfig = this.mUIConfig;
            d.a(authUIConfig, authUIConfig.getStatusBarColor(), this);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        try {
            bundle.putString("number", this.mNumberPhone);
            bundle.putString(Constant.LOGIN_ACTIVITY_VENDOR_KEY, this.mVendorKey);
            bundle.putString(Constant.LOGIN_ACTIVITY_ACCESS_CODE, this.mAccessCode);
            bundle.putLong("startTime", this.startTime);
            bundle.putInt(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, this.mUIManagerID);
            super.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        try {
            Intent intent = getIntent();
            intent.putExtra("number", this.mNumberPhone);
            intent.putExtra(Constant.LOGIN_ACTIVITY_VENDOR_KEY, this.mVendorKey);
            intent.putExtra(Constant.LOGIN_ACTIVITY_ACCESS_CODE, this.mAccessCode);
            intent.putExtra("startTime", this.startTime);
            intent.putExtra(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, this.mUIManagerID);
            super.onStop();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void openUserPage(Class<?> cls, int i10, int i11) {
        try {
            Intent intent = new Intent(this, cls);
            if (i11 > 0) {
                intent.addFlags(i11);
            }
            startActivityForResult(intent, i10);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public int px2dp(float f10) {
        try {
            return (int) ((f10 / getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception unused) {
            return (int) f10;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public boolean queryCheckBoxIsChecked() {
        try {
            if (this.mUIConfig.isCheckboxHidden()) {
                return true;
            }
            return this.mProtocolSelectCB.isChecked();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public void setProtocolChecked(boolean z10) {
        try {
            CheckBox checkBox = this.mProtocolSelectCB;
            if (checkBox != null) {
                checkBox.setChecked(z10);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public void showLoadingDialog() {
        try {
            if (this.mUIConfig.isHiddenLoading()) {
                return;
            }
            this.mPnsLogger.a("LoginAuthActivity showLoadingDialog = ", String.valueOf(this.mProgressDialog), "; isShowLoadingDialog = true");
            if (this.mProgressDialog == null) {
                com.mobile.auth.y.a aVar = new com.mobile.auth.y.a(this, this.mUIConfig);
                this.mProgressDialog = aVar;
                aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.mobile.auth.gatewayauth.LoginAuthActivity.1
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        try {
                            LoginAuthActivity.access$000(LoginAuthActivity.this).setClickable(true);
                        } catch (Throwable th) {
                            ExceptionProcessor.processException(th);
                        }
                    }
                });
            }
            this.mProgressDialog.setCancelable(true);
            this.mProgressDialog.show();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }
}
