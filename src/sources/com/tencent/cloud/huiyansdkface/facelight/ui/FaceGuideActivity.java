package com.tencent.cloud.huiyansdkface.facelight.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.c.b.e;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.AuthUploadRequest;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.c;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.IOException;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FaceGuideActivity extends com.tencent.cloud.huiyansdkface.facelight.ui.a.a {

    /* renamed from: a, reason: collision with root package name */
    private static int f40902a;

    /* renamed from: b, reason: collision with root package name */
    private d f40903b;

    /* renamed from: d, reason: collision with root package name */
    private c f40905d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f40906e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f40907f;

    /* renamed from: g, reason: collision with root package name */
    private RelativeLayout f40908g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f40909h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f40910i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f40911j;

    /* renamed from: k, reason: collision with root package name */
    private CheckBox f40912k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f40913l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f40914m;

    /* renamed from: n, reason: collision with root package name */
    private RelativeLayout f40915n;

    /* renamed from: o, reason: collision with root package name */
    private LinearLayout f40916o;

    /* renamed from: p, reason: collision with root package name */
    private LinearLayout f40917p;

    /* renamed from: q, reason: collision with root package name */
    private LinearLayout f40918q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f40919r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f40920s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f40921t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f40922u;

    /* renamed from: v, reason: collision with root package name */
    private int f40923v;

    /* renamed from: w, reason: collision with root package name */
    private CountDownTimer f40924w;

    /* renamed from: x, reason: collision with root package name */
    private String f40925x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f40926y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f40927z;

    /* renamed from: c, reason: collision with root package name */
    private e f40904c = new e(AutofillManager.MAX_TEMP_AUGMENTED_SERVICE_DURATION_MS);
    private View.OnClickListener A = new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WLogger.d("FaceGuideActivity", "点击跳转协议详情页面");
            FaceGuideActivity.this.f40926y = true;
            Intent intent = new Intent();
            intent.putExtra("isChecked", FaceGuideActivity.this.f40927z);
            intent.setClass(FaceGuideActivity.this, FaceProtocalActivity.class);
            FaceGuideActivity.this.startActivity(intent);
            FaceGuideActivity.this.overridePendingTransition(0, 0);
            FaceGuideActivity.this.finish();
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements c.b {

        /* renamed from: a, reason: collision with root package name */
        private d f40937a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f40938b;

        public a(d dVar, Activity activity) {
            this.f40937a = dVar;
            this.f40938b = activity;
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
        public void a() {
            WLogger.e("FaceGuideActivity", "onHomePressed");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f40938b.getApplicationContext(), "authpage_exit_self", "点击home键返回", null);
            this.f40937a.e(true);
            if (this.f40937a.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                wbFaceVerifyResult.setIsSuccess(false);
                wbFaceVerifyResult.setOrderNo(this.f40937a.w());
                wbFaceVerifyResult.setSign(null);
                WbFaceError wbFaceError = new WbFaceError();
                wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
                wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
                wbFaceError.setDesc("用户取消");
                wbFaceError.setReason("home键：用户授权中取消");
                wbFaceVerifyResult.setError(wbFaceError);
                Properties properties = new Properties();
                properties.setProperty("errorDesc", wbFaceError.toString());
                this.f40937a.a(this.f40938b, WbFaceError.WBFaceErrorCodeUserCancle, properties);
                this.f40937a.y().onFinish(wbFaceVerifyResult);
            }
            this.f40938b.finish();
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
        public void b() {
            WLogger.e("FaceGuideActivity", "onHomeLongPressed");
        }
    }

    private void a() {
        int i10;
        WLogger.i("FaceGuideActivity", "setThemeAndTitleBar");
        String J = this.f40903b.x().J();
        this.f40925x = J;
        if (WbCloudFaceContant.BLACK.equals(J)) {
            i10 = R.style.wbcfFaceProtocolThemeBlack;
        } else if ("custom".equals(this.f40925x)) {
            i10 = R.style.wbcfFaceProtocolThemeCustom;
        } else {
            WLogger.e("FaceGuideActivity", "set default WHITE");
            this.f40925x = WbCloudFaceContant.WHITE;
            i10 = R.style.wbcfFaceProtocolThemeWhite;
        }
        setTheme(i10);
        a(this.f40925x);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.b():void");
    }

    private void c() {
        WLogger.d("FaceGuideActivity", "initListeners");
        this.f40906e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WLogger.d("FaceGuideActivity", "左上角返回键，无上一页，退出授权sdk");
                KycWaSDK.getInstance().trackCustomKVEvent(FaceGuideActivity.this.getApplicationContext(), "authpage_exit_self", "左上角返回", null);
                FaceGuideActivity.this.f40903b.e(true);
                if (FaceGuideActivity.this.f40903b.y() != null) {
                    WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                    wbFaceVerifyResult.setIsSuccess(false);
                    wbFaceVerifyResult.setOrderNo(FaceGuideActivity.this.f40903b.w());
                    wbFaceVerifyResult.setSign(null);
                    WbFaceError wbFaceError = new WbFaceError();
                    wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
                    wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
                    wbFaceError.setDesc("用户取消");
                    wbFaceError.setReason("左上角返回键：用户授权中取消");
                    wbFaceVerifyResult.setError(wbFaceError);
                    Properties properties = new Properties();
                    properties.setProperty("errorDesc", wbFaceError.toString());
                    FaceGuideActivity.this.f40903b.a(FaceGuideActivity.this.getApplicationContext(), WbFaceError.WBFaceErrorCodeUserCancle, properties);
                    FaceGuideActivity.this.f40903b.y().onFinish(wbFaceVerifyResult);
                }
                FaceGuideActivity.this.finish();
            }
        });
        this.f40912k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                WLogger.d("FaceGuideActivity", "protocalCb onCheckedChanged");
                FaceGuideActivity.this.f40927z = z10;
                FaceGuideActivity faceGuideActivity = FaceGuideActivity.this;
                if (z10) {
                    faceGuideActivity.e();
                    FaceGuideActivity.this.f40908g.setVisibility(8);
                } else {
                    faceGuideActivity.f();
                    FaceGuideActivity.this.d();
                }
            }
        });
        this.f40912k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WLogger.d("FaceGuideActivity", "protocalCb OnClickListener");
            }
        });
        this.f40913l.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CheckBox checkBox;
                if (FaceGuideActivity.this.f40912k.getVisibility() == 8) {
                    return;
                }
                FaceGuideActivity.h(FaceGuideActivity.this);
                boolean z10 = true;
                if (FaceGuideActivity.this.f40923v % 2 == 1) {
                    checkBox = FaceGuideActivity.this.f40912k;
                } else {
                    checkBox = FaceGuideActivity.this.f40912k;
                    z10 = false;
                }
                checkBox.setChecked(z10);
            }
        });
        this.f40908g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CheckBox checkBox;
                if (FaceGuideActivity.this.f40912k.getVisibility() == 8) {
                    return;
                }
                FaceGuideActivity.h(FaceGuideActivity.this);
                boolean z10 = true;
                if (FaceGuideActivity.this.f40923v % 2 == 1) {
                    checkBox = FaceGuideActivity.this.f40912k;
                } else {
                    checkBox = FaceGuideActivity.this.f40912k;
                    z10 = false;
                }
                checkBox.setChecked(z10);
            }
        });
        this.f40911j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WLogger.d("FaceGuideActivity", "user agreed protocal!");
                KycWaSDK.getInstance().trackCustomKVEvent(FaceGuideActivity.this.getApplicationContext(), "authpage_confirm", null, null);
                FaceGuideActivity.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f40912k.getVisibility() == 0) {
            this.f40908g.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        int i10;
        this.f40911j.setEnabled(true);
        if (this.f40925x.equals("custom")) {
            this.f40911j.setTextColor(getResources().getColor(R.color.wbcf_custom_auth_btn_text_checked));
            textView = this.f40911j;
            i10 = R.drawable.wbcf_custom_auth_btn_checked;
        } else {
            textView = this.f40911j;
            i10 = R.drawable.wbcf_protocol_btn_checked;
        }
        textView.setBackgroundResource(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TextView textView;
        int i10;
        this.f40911j.setEnabled(false);
        if (this.f40925x.equals("custom")) {
            this.f40911j.setTextColor(getResources().getColor(R.color.wbcf_custom_auth_btn_text_unchecked));
            textView = this.f40911j;
            i10 = R.drawable.wbcf_custom_auth_btn_unchecked;
        } else {
            textView = this.f40911j;
            i10 = R.drawable.wbcf_protocol_btn_unchecked;
        }
        textView.setBackgroundResource(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.f40903b.x().S()) {
            WLogger.d("FaceGuideActivity", "uploadAuthInfo");
            h();
        }
        WLogger.d("FaceGuideActivity", "start go to FaceVerify from AuthPage!");
        this.f40926y = true;
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), FaceVerifyActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    public static /* synthetic */ int h(FaceGuideActivity faceGuideActivity) {
        int i10 = faceGuideActivity.f40923v;
        faceGuideActivity.f40923v = i10 + 1;
        return i10;
    }

    private void h() {
        AuthUploadRequest.requestExec(this.f40903b.a(), new WeReq.Callback<AuthUploadRequest.AuthUploadResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.8
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeReq weReq, AuthUploadRequest.AuthUploadResponse authUploadResponse) {
                WLogger.d("FaceGuideActivity", "upload auth success!");
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str, IOException iOException) {
                WLogger.e("FaceGuideActivity", "upload auth failed!errType=" + ((Object) errType) + "i=" + i10 + "s=" + str);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WLogger.d("FaceGuideActivity", "返回键，无上一页可回，退出授权页面");
        super.onBackPressed();
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_exit_self", "返回键", null);
        this.f40903b.e(true);
        if (this.f40903b.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.f40903b.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
            wbFaceError.setDesc("用户取消");
            wbFaceError.setReason("返回键：用户授权中取消");
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.f40903b.a(getApplicationContext(), WbFaceError.WBFaceErrorCodeUserCancle, properties);
            this.f40903b.y().onFinish(wbFaceVerifyResult);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        WLogger.d("FaceGuideActivity", "onCreate：" + getRequestedOrientation());
        WLogger.d("FaceGuideActivity", "setActivityOrientation:" + getWindowManager().getDefaultDisplay().getRotation());
        d z10 = d.z();
        this.f40903b = z10;
        z10.e(false);
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_enter", null, null);
        a();
        super.onCreate(bundle);
        setContentView(R.layout.wbcf_face_guide_layout);
        if (getIntent() != null) {
            this.f40927z = getIntent().getBooleanExtra("isChecked", false);
        }
        b();
        c();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WLogger.i("FaceGuideActivity", "onDestroy");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        WLogger.d("FaceGuideActivity", "onPause");
        c cVar = this.f40905d;
        if (cVar != null) {
            cVar.b();
        }
        this.f40904c.a();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        WLogger.d("FaceGuideActivity", "onResume");
        c cVar = this.f40905d;
        if (cVar != null) {
            cVar.a();
        }
        this.f40904c.a(getApplicationContext());
    }

    @Override // android.app.Activity
    public void onStart() {
        WLogger.d("FaceGuideActivity", "onStart");
        super.onStart();
        f40902a++;
        long X = d.z().e().X();
        this.f40924w = new CountDownTimer(X, X) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.9
            @Override // android.os.CountDownTimer
            public void onFinish() {
                FaceGuideActivity.this.f40906e.setVisibility(0);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
            }
        }.start();
    }

    @Override // android.app.Activity
    public void onStop() {
        WLogger.i("FaceGuideActivity", "onStop");
        super.onStop();
        CountDownTimer countDownTimer = this.f40924w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f40924w = null;
        }
        int i10 = f40902a - 1;
        f40902a = i10;
        if (i10 != 0) {
            WLogger.e("FaceGuideActivity", "not same activity");
            return;
        }
        if (this.f40926y) {
            WLogger.d("FaceGuideActivity", "gotoDetail,dont exit");
            return;
        }
        WLogger.d("FaceGuideActivity", "same activity ");
        if (this.f40903b.t()) {
            return;
        }
        WLogger.i("FaceGuideActivity", "onStop quit authPage");
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_exit_forced", "onStop, 应用被动离开前台", null);
        if (this.f40903b.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.f40903b.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
            wbFaceError.setDesc("用户取消");
            wbFaceError.setReason("用户取消，授权中回到后台activity onStop");
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.f40903b.a(this, WbFaceError.WBFaceErrorCodeUserCancle, properties);
            this.f40903b.y().onFinish(wbFaceVerifyResult);
        }
        finish();
    }
}
