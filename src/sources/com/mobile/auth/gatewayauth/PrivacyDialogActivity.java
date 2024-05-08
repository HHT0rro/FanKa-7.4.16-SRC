package com.mobile.auth.gatewayauth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.mobile.auth.gatewayauth.annotations.AuthNumber;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.utils.k;
import com.mobile.auth.gatewayauth.utils.l;
import com.nirvana.tools.core.AppUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@AuthNumber
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PrivacyDialogActivity extends Activity {
    private static final int DP_MODE = 1073741824;
    public static final String EXIST = "exist";
    private static final int MODE_MASK = -1073741824;
    private static final int MODE_SHIFT = 30;
    public static final String STOP_LOADING = "stop_loading";
    private int dailogWidth;
    private TextView mAgreeBtn;
    private RelativeLayout mBodyRL;
    private RelativeLayout mBtnRL;
    private RelativeLayout mMainBackground;
    private RelativeLayout mMainRelativeLayout;
    private com.mobile.auth.q.a mPnsLogger;
    private com.mobile.auth.y.a mProgressDialog;
    private String mProtocol = "";
    private List<com.mobile.auth.gatewayauth.ui.b> mProtocolConfigs = new ArrayList(3);
    private RelativeLayout mProtocolRL;
    private TextView mProtocolTV;
    private RelativeLayout mTitleRL;
    private AuthUIConfig mUIConfig;
    private d mUIManager;
    private int mUIManagerID;
    private String mVendorClick;
    private String mVendorKey;
    private String mVendorProtocol;

    /* renamed from: com.mobile.auth.gatewayauth.PrivacyDialogActivity$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f37027a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37028b;

        public AnonymousClass1(LinkedHashMap linkedHashMap, String str) {
            this.f37027a = linkedHashMap;
            this.f37028b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomInterface customInterface;
            try {
                AuthRegisterViewConfig authRegisterViewConfig = (AuthRegisterViewConfig) this.f37027a.get(this.f37028b);
                if (authRegisterViewConfig == null || (customInterface = authRegisterViewConfig.getCustomInterface()) == null) {
                    return;
                }
                customInterface.onClick(PrivacyDialogActivity.this);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PrivacyDialogActivity$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f37030a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37031b;

        public AnonymousClass2(LinkedHashMap linkedHashMap, String str) {
            this.f37030a = linkedHashMap;
            this.f37031b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomInterface customInterface;
            try {
                AuthRegisterViewConfig authRegisterViewConfig = (AuthRegisterViewConfig) this.f37030a.get(this.f37031b);
                if (authRegisterViewConfig == null || (customInterface = authRegisterViewConfig.getCustomInterface()) == null) {
                    return;
                }
                customInterface.onClick(PrivacyDialogActivity.this);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PrivacyDialogActivity$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f37033a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37034b;

        public AnonymousClass3(LinkedHashMap linkedHashMap, String str) {
            this.f37033a = linkedHashMap;
            this.f37034b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomInterface customInterface;
            try {
                AuthRegisterViewConfig authRegisterViewConfig = (AuthRegisterViewConfig) this.f37033a.get(this.f37034b);
                if (authRegisterViewConfig == null || (customInterface = authRegisterViewConfig.getCustomInterface()) == null) {
                    return;
                }
                customInterface.onClick(PrivacyDialogActivity.this);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PrivacyDialogActivity$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                PrivacyDialogActivity.access$100(PrivacyDialogActivity.this).e(PrivacyDialogActivity.access$000(PrivacyDialogActivity.this));
                PrivacyDialogActivity.access$100(PrivacyDialogActivity.this).f(PrivacyDialogActivity.access$000(PrivacyDialogActivity.this));
                PrivacyDialogActivity.access$200(PrivacyDialogActivity.this, false, ResultCode.CODE_AUTH_PRIVACY_CLOSE, ResultCode.MSG_AUTH_PRIVACY_CLOSE);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PrivacyDialogActivity$6, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass6 implements View.OnTouchListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PrivacyDialogActivity$7, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                PrivacyDialogActivity.access$100(PrivacyDialogActivity.this).f(PrivacyDialogActivity.access$000(PrivacyDialogActivity.this));
                PrivacyDialogActivity.access$200(PrivacyDialogActivity.this, true, ResultCode.CODE_AUTH_PRIVACY_CLOSE, ResultCode.MSG_AUTH_PRIVACY_CLOSE);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    /* renamed from: com.mobile.auth.gatewayauth.PrivacyDialogActivity$9, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass9 extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37044a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37045b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f37046c;

        public AnonymousClass9(String str, String str2, int i10) {
            this.f37044a = str;
            this.f37045b = str2;
            this.f37046c = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            try {
                PrivacyDialogActivity.access$100(PrivacyDialogActivity.this).b(PrivacyDialogActivity.access$000(PrivacyDialogActivity.this), this.f37044a, this.f37045b, false);
                PrivacyDialogActivity.access$100(PrivacyDialogActivity.this).a(this.f37044a, this.f37045b);
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            try {
                super.updateDrawState(textPaint);
                textPaint.setColor(this.f37046c);
                if (PrivacyDialogActivity.access$300(PrivacyDialogActivity.this).isPrivacyAlertProtocolNameUseUnderLine()) {
                    textPaint.setUnderlineText(true);
                } else {
                    textPaint.setUnderlineText(false);
                }
                if (PrivacyDialogActivity.access$300(PrivacyDialogActivity.this).getPrivacyAlertProtocolNameTypeface() != null) {
                    textPaint.setTypeface(PrivacyDialogActivity.access$300(PrivacyDialogActivity.this).getPrivacyAlertProtocolNameTypeface());
                }
            } catch (Throwable th) {
                ExceptionProcessor.processException(th);
            }
        }
    }

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
    }

    public static /* synthetic */ String access$000(PrivacyDialogActivity privacyDialogActivity) {
        try {
            return privacyDialogActivity.mVendorKey;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ d access$100(PrivacyDialogActivity privacyDialogActivity) {
        try {
            return privacyDialogActivity.mUIManager;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ void access$200(PrivacyDialogActivity privacyDialogActivity, boolean z10, String str, String str2) {
        try {
            privacyDialogActivity.finishAuthPage(z10, str, str2);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    public static /* synthetic */ AuthUIConfig access$300(PrivacyDialogActivity privacyDialogActivity) {
        try {
            return privacyDialogActivity.mUIConfig;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    private SpannableString dealProtocol(String str, List<com.mobile.auth.gatewayauth.ui.b> list) {
        try {
            SpannableString spannableString = new SpannableString(str);
            ClickableSpan vendorProtocol = getVendorProtocol(this.mVendorProtocol, this.mVendorClick, !l.a(this.mUIConfig.getPrivacyAlertOperatorColor()) ? this.mUIConfig.getPrivacyAlertOperatorColor() : this.mUIConfig.getPrivacyAlertContentColor() != 0 ? this.mUIConfig.getPrivacyAlertContentColor() : this.mUIConfig.getProtocolOneColor());
            for (com.mobile.auth.gatewayauth.ui.b bVar : list) {
                ClickableSpan protocol = getProtocol(bVar.b(), bVar.c(), bVar.d());
                int indexOf = str.indexOf(bVar.b());
                spannableString.setSpan(protocol, indexOf, bVar.b().length() + indexOf, 34);
            }
            spannableString.setSpan(vendorProtocol, str.indexOf(this.mVendorProtocol), str.indexOf(this.mVendorProtocol) + this.mVendorProtocol.length(), 34);
            return spannableString;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    private void finishAuthPage(boolean z10, String str, String str2) {
        try {
            Intent intent = getIntent();
            intent.putExtra("HasAgree", !z10);
            intent.putExtra("code", str);
            intent.putExtra("msg", str2);
            setResult(-1, intent);
            this.mUIManager.d(this);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    private native ClickableSpan getProtocol(String str, String str2, int i10);

    private ClickableSpan getVendorProtocol(final String str, final String str2, final int i10) {
        try {
            return new ClickableSpan() { // from class: com.mobile.auth.gatewayauth.PrivacyDialogActivity.8
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    try {
                        PrivacyDialogActivity.access$100(PrivacyDialogActivity.this).b(PrivacyDialogActivity.access$000(PrivacyDialogActivity.this), str, str2, true);
                        PrivacyDialogActivity.access$100(PrivacyDialogActivity.this).a(str, str2);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    try {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(i10);
                        if (PrivacyDialogActivity.access$300(PrivacyDialogActivity.this).isPrivacyAlertProtocolNameUseUnderLine()) {
                            textPaint.setUnderlineText(true);
                        } else {
                            textPaint.setUnderlineText(false);
                        }
                        if (PrivacyDialogActivity.access$300(PrivacyDialogActivity.this).getPrivacyAlertProtocolNameTypeface() != null) {
                            textPaint.setTypeface(PrivacyDialogActivity.access$300(PrivacyDialogActivity.this).getPrivacyAlertProtocolNameTypeface());
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
    private native void initBtnLayoutDynamicView();

    private View initBtnLayoutView() {
        try {
            this.mBtnRL = new RelativeLayout(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.mUIConfig.getPrivacyAlertCornerRadiusArray() == null || this.mUIConfig.getPrivacyAlertCornerRadiusArray().length < 4) {
                this.mBtnRL.setBackgroundColor(this.mUIConfig.getPrivacyAlertBackgroundColor());
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, transferCorner(this.mUIConfig.getPrivacyAlertCornerRadiusArray()[2]), transferCorner(this.mUIConfig.getPrivacyAlertCornerRadiusArray()[2]), transferCorner(this.mUIConfig.getPrivacyAlertCornerRadiusArray()[3]), transferCorner(this.mUIConfig.getPrivacyAlertCornerRadiusArray()[3])});
                gradientDrawable.setColor(this.mUIConfig.getPrivacyAlertBackgroundColor());
                setBackground(this.mBtnRL, gradientDrawable);
            }
            layoutParams.addRule(3, this.mBodyRL.getId());
            this.mBtnRL.setLayoutParams(layoutParams);
            k.a(this.mBtnRL, initBtnView(), 0);
            initBtnLayoutDynamicView();
            return this.mBtnRL;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    private native View initBtnView();

    @SafeProtector
    private native void initContentLayoutDynamicView();

    @SafeProtector
    private void initIntentData() {
        try {
            Intent intent = getIntent();
            this.mVendorKey = intent.getStringExtra(Constant.LOGIN_ACTIVITY_VENDOR_KEY);
            this.mUIManagerID = intent.getIntExtra(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, 0);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @SafeProtector
    private native RelativeLayout initProtocolView();

    @SafeProtector
    private native void initTitleLayoutDynamicView();

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

    private native void removeDynamicXmlView();

    private native void restAllChildViews(View view);

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

    private float transferCorner(float f10) {
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        try {
            return AppUtils.dp2px(this, f10);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1.0f;
        }
    }

    public native void cancelPrivacyDialog();

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (this.mUIConfig.isTapPrivacyAlertMaskCloseAlert() && motionEvent.getAction() == 1 && !isTouchPointInView(this.mMainRelativeLayout, x10, y10)) {
                this.mUIManager.f(this.mVendorKey);
                finishAuthPage(true, ResultCode.CODE_AUTH_PRIVACY_CLOSE, ResultCode.MSG_AUTH_PRIVACY_CLOSE);
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return false;
        }
    }

    public int getProtroColor(int i10) {
        try {
            return this.mUIConfig.getPrivacyAlertContentColor() == 0 ? i10 : this.mUIConfig.getPrivacyAlertContentColor();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
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
    public void onBackPressed() {
        try {
            this.mUIManager.f(this.mVendorKey);
            finishAuthPage(true, ResultCode.CODE_AUTH_PRIVACY_CLOSE, ResultCode.MSG_AUTH_PRIVACY_CLOSE);
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
            removeDynamicXmlView();
            removeDynamicView();
            d dVar = this.mUIManager;
            if (dVar != null) {
                dVar.c((Activity) null);
            }
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
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        try {
            bundle.putString(Constant.LOGIN_ACTIVITY_VENDOR_KEY, this.mVendorKey);
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
            intent.putExtra(Constant.LOGIN_ACTIVITY_VENDOR_KEY, this.mVendorKey);
            intent.putExtra(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, this.mUIManagerID);
            super.onStop();
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

    public void showLoadingDialog() {
        try {
            if (this.mUIConfig.isHiddenLoading()) {
                return;
            }
            this.mPnsLogger.a("PrivacyDialogActivity showLoadingDialog = ", String.valueOf(this.mProgressDialog), "; isShowLoadingDialog = true");
            if (this.mProgressDialog == null) {
                com.mobile.auth.y.a aVar = new com.mobile.auth.y.a(this, this.mUIConfig);
                this.mProgressDialog = aVar;
                aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.mobile.auth.gatewayauth.PrivacyDialogActivity.5
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
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
