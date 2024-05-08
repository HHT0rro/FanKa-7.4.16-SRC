package com.tencent.cloud.huiyansdkface.facelight.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.c.c.c;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.PermissionInfo;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.a;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FaceVerifyActivity extends com.tencent.cloud.huiyansdkface.facelight.ui.a.a {

    /* renamed from: j, reason: collision with root package name */
    private static Map<a, Class<?>> f40959j;

    /* renamed from: k, reason: collision with root package name */
    private static int f40960k;

    /* renamed from: a, reason: collision with root package name */
    private Activity f40961a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a f40962b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a f40963c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f40964d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f40965e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f40966f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f40967g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f40968h;

    /* renamed from: i, reason: collision with root package name */
    private d f40969i;

    /* renamed from: l, reason: collision with root package name */
    private PermissionInfo f40970l;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        FaceLiveFragment
    }

    static {
        HashMap hashMap = new HashMap();
        f40959j = hashMap;
        hashMap.put(a.FaceLiveFragment, com.tencent.cloud.huiyansdkface.facelight.ui.b.a.class);
    }

    private void a(a.InterfaceC0627a interfaceC0627a, PermissionInfo.PermissionTip permissionTip) {
        WLogger.d("FaceVerifyActivity", "showPermissionConfirmDialog");
        if (this.f40962b == null) {
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a d10 = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(this.f40961a).a(permissionTip.title).b(permissionTip.content).c(this.f40969i.f().kyc_set_up).d(this.f40969i.f().kyc_cancel);
            this.f40962b = d10;
            d10.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
        }
        this.f40962b.a(interfaceC0627a);
        if (isFinishing()) {
            return;
        }
        this.f40962b.show();
        KycWaSDK.getInstance().trackCustomKVEvent(this, "camera_face_alert_show", null, null);
    }

    private void a(String[] strArr, int[] iArr) {
        final PermissionInfo.PermissionTip d10 = d(strArr, iArr);
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a d11 = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(this.f40961a).a("设置").b("是否去设置页面申请权限").c("继续").d("取消");
        this.f40963c = d11;
        d11.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
        this.f40963c.a(new a.InterfaceC0627a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceVerifyActivity.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
            public void a() {
                if (FaceVerifyActivity.this.f40962b != null) {
                    FaceVerifyActivity.this.f40962b.dismiss();
                }
                FaceVerifyActivity.this.g();
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
            public void b() {
                if (FaceVerifyActivity.this.f40962b != null) {
                    FaceVerifyActivity.this.f40962b.dismiss();
                }
                FaceVerifyActivity.this.c(d10.noPermissionTip);
            }
        });
        this.f40963c.show();
    }

    private boolean a(int[] iArr) {
        for (int i10 : iArr) {
            if (i10 != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] a(String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            iArr[i10] = b(strArr[i10]);
        }
        return iArr;
    }

    private int b(String str) {
        return Build.VERSION.SDK_INT >= 23 ? checkSelfPermission(str) : getPackageManager().checkPermission(str, getPackageName());
    }

    private void b() {
        setRequestedOrientation(this.f40969i.x().Q() ? 0 : 1);
        int requestedOrientation = getRequestedOrientation();
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        WLogger.d("FaceVerifyActivity", "getActivityOrientation:" + requestedOrientation + ",screenRotation:" + rotation);
        KycWaSDK.getInstance().trackCustomKVEvent(this, "faceservice_activity_create", "ori=" + requestedOrientation + ",rotation:" + rotation, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String[] strArr, int[] iArr) {
        WLogger.e("FaceVerifyActivity", "Didn't get all permission!");
        final PermissionInfo.PermissionTip d10 = d(strArr, iArr);
        if (this.f40967g || this.f40968h) {
            WLogger.d("FaceVerifyActivity", "reject,quit sdk");
            c(d10.noPermissionTip);
        } else {
            WLogger.d("FaceVerifyActivity", "first reject,show confirm dialog");
            this.f40967g = true;
            a(new a.InterfaceC0627a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceVerifyActivity.3
                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
                public void a() {
                    WLogger.e("FaceVerifyActivity", "user try permission again!");
                    if (FaceVerifyActivity.this.f40962b != null) {
                        FaceVerifyActivity.this.f40962b.dismiss();
                    }
                    FaceVerifyActivity.this.j();
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
                public void b() {
                    WLogger.e("FaceVerifyActivity", "user didnt open permissions!");
                    if (FaceVerifyActivity.this.f40962b != null) {
                        FaceVerifyActivity.this.f40962b.dismiss();
                    }
                    FaceVerifyActivity.this.c(d10.noPermissionTip);
                }
            }, d10);
        }
    }

    private void c() {
        String y10;
        TextView textView;
        String g3;
        this.f40964d = (RelativeLayout) findViewById(R.id.wbcf_permission_tip_rl);
        this.f40965e = (TextView) findViewById(R.id.wbcf_permission_tip);
        this.f40966f = (TextView) findViewById(R.id.wbcf_permission_reason);
        if (WbFaceModeProviders.isUseWillSdk()) {
            this.f40965e.setText(this.f40969i.f().kyc_auth_tip_use_cam_mic);
            y10 = this.f40969i.x().z();
            if (TextUtils.isEmpty(y10)) {
                textView = this.f40966f;
                g3 = this.f40969i.e().f();
                textView.setText(g3);
                return;
            }
            this.f40966f.setText(y10);
        }
        this.f40965e.setText(this.f40969i.f().kyc_auth_tip_use_cam);
        y10 = this.f40969i.x().y();
        if (TextUtils.isEmpty(y10)) {
            textView = this.f40966f;
            g3 = this.f40969i.e().g();
            textView.setText(g3);
            return;
        }
        this.f40966f.setText(y10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        WLogger.d("FaceVerifyActivity", "askPermissionError");
        KycWaSDK.getInstance().trackCustomKVEvent(this.f40961a, "camera_auth_reject", null, null);
        this.f40969i.e(true);
        if (this.f40969i.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.f40969i.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeNoPermission);
            wbFaceError.setDesc("权限异常，未获取权限");
            wbFaceError.setReason(str);
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.f40969i.a(this.f40961a, WbFaceError.WBFaceErrorCodeNoPermission, properties);
            this.f40969i.y().onFinish(wbFaceVerifyResult);
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.f40962b;
        if (aVar != null) {
            aVar.dismiss();
            this.f40962b = null;
        }
        WLogger.d("FaceVerifyActivity", "finish activity");
        finish();
    }

    private boolean c(String[] strArr, int[] iArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (iArr[i10] != 0 && !shouldShowRequestPermissionRationale(strArr[i10])) {
                return true;
            }
        }
        return false;
    }

    private PermissionInfo.PermissionTip d(String[] strArr, int[] iArr) {
        String str;
        int i10 = 0;
        while (true) {
            if (i10 >= strArr.length) {
                str = "";
                break;
            }
            if (iArr[i10] != 0) {
                str = strArr[i10];
                break;
            }
            i10++;
        }
        return e().getPermissionTip(str);
    }

    private boolean d(String str) {
        KycWaSDK kycWaSDK;
        Context applicationContext;
        String str2;
        String str3;
        if (this.f40969i.t()) {
            return false;
        }
        WLogger.i("FaceVerifyActivity", str + "quit faceVerify");
        if (!d.z().c()) {
            kycWaSDK = KycWaSDK.getInstance();
            applicationContext = getApplicationContext();
            str2 = str + ", 应用被动离开前台";
            str3 = "facepage_exit_forced";
        } else if (d.z().d()) {
            kycWaSDK = KycWaSDK.getInstance();
            applicationContext = getApplicationContext();
            str2 = str + ", 应用被动离开前台";
            str3 = "willpage_answer_exit_forced";
        } else {
            kycWaSDK = KycWaSDK.getInstance();
            applicationContext = getApplicationContext();
            str2 = str + ", 应用被动离开前台";
            str3 = "willpage_exit_forced";
        }
        kycWaSDK.trackCustomKVEvent(applicationContext, str3, str2, null);
        this.f40969i.e(true);
        if (this.f40969i.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.f40969i.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
            wbFaceError.setDesc("用户取消");
            wbFaceError.setReason("用户取消，回到后台activity," + str);
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.f40969i.a(this.f40961a, WbFaceError.WBFaceErrorCodeUserCancle, properties);
            this.f40969i.y().onFinish(wbFaceVerifyResult);
        }
        return true;
    }

    private String[] d() {
        return e().getPermissionArray();
    }

    private PermissionInfo e() {
        if (this.f40970l == null) {
            this.f40970l = WbFaceModeProviders.faceMode().getPermissionList();
        }
        return this.f40970l;
    }

    private boolean f() {
        for (String str : d()) {
            if (shouldShowRequestPermissionRationale(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", getApplicationContext().getPackageName(), null));
            if (getPackageManager().resolveActivity(intent, 0) != null) {
                startActivityForResult(intent, 1024);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            a(1024);
        }
    }

    private void h() {
        KycWaSDK.getInstance().trackCustomKVEvent(this, "camera_auth_agree", null, null);
        i();
    }

    private void i() {
        WLogger.d("FaceVerifyActivity", "updateUI");
        this.f40964d.setVisibility(8);
        com.tencent.cloud.huiyansdkface.facelight.ui.b.a aVar = new com.tencent.cloud.huiyansdkface.facelight.ui.b.a();
        if (getFragmentManager().findFragmentByTag("rootFragment") != null) {
            WLogger.d("FaceVerifyActivity", "rootFragment already exists:" + ((Object) aVar));
            return;
        }
        WLogger.d("FaceVerifyActivity", "addRootFragment:" + ((Object) aVar));
        getFragmentManager().beginTransaction().add(R.id.wbcf_fragment_container, aVar, "rootFragment").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            ActivityCompat.requestPermissions(this, d(), 1024);
        } catch (Exception e2) {
            e2.printStackTrace();
            onRequestPermissionsResult(1024, d(), new int[]{-1});
        }
    }

    private void k() {
        if (this.f40969i.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.f40969i.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeSdkInitFail);
            wbFaceError.setDesc("初始化sdk异常");
            wbFaceError.setReason("mWbCloudFaceVerifySdk not init!");
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.f40969i.a(getApplicationContext(), WbFaceError.WBFaceErrorCodeSdkInitFail, properties);
            this.f40969i.y().onFinish(wbFaceVerifyResult);
        }
        WLogger.d("FaceVerifyActivity", "finish activity");
        finish();
    }

    public void a() {
        WLogger.d("FaceVerifyActivity", "startWithPermissionCheck");
        String[] d10 = d();
        int[] a10 = a(d10);
        if (a(a10)) {
            h();
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            a(d10, a10);
        } else if (f()) {
            a(d10, a10, false);
        } else {
            requestPermissions(d10, 1024);
        }
    }

    public void a(int i10) {
        try {
            startActivityForResult(new Intent("android.settings.SETTINGS"), i10);
        } catch (Exception e2) {
            e2.printStackTrace();
            onRequestPermissionsResult(1024, d(), new int[]{-1});
        }
    }

    public boolean a(final String[] strArr, final int[] iArr, final boolean z10) {
        WLogger.d("FaceVerifyActivity", "onShouldTipUser");
        this.f40968h = true;
        a(new a.InterfaceC0627a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceVerifyActivity.2
            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
            public void a() {
                if (FaceVerifyActivity.this.f40962b != null) {
                    FaceVerifyActivity.this.f40962b.dismiss();
                }
                if (z10) {
                    FaceVerifyActivity.this.g();
                } else {
                    FaceVerifyActivity.this.j();
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
            public void b() {
                WLogger.e("FaceVerifyActivity", "user didnt open permissions!");
                if (FaceVerifyActivity.this.f40962b != null) {
                    FaceVerifyActivity.this.f40962b.dismiss();
                }
                FaceVerifyActivity.this.b(strArr, iArr);
            }
        }, d(strArr, iArr));
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WLogger.d("FaceVerifyActivity", "onConfigurationChanged");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10;
        super.onCreate(bundle);
        WLogger.d("FaceVerifyActivity", "Activity onCreate");
        d z10 = d.z();
        this.f40969i = z10;
        if (z10 == null || !z10.g()) {
            WLogger.e("FaceVerifyActivity", "mWbCloudFaceVerifySdk null or mWbCloudFaceVerifySdk not init");
            k();
            return;
        }
        b();
        String J = this.f40969i.x().J();
        if (WbCloudFaceContant.BLACK.equals(J)) {
            i10 = R.style.wbcfFaceThemeBlack;
        } else if ("custom".equals(J)) {
            i10 = R.style.wbcfFaceThemeCustom;
        } else {
            WLogger.d("FaceVerifyActivity", "set default white");
            i10 = R.style.wbcfFaceThemeWhite;
        }
        setTheme(i10);
        a(J);
        setContentView(R.layout.wbcf_face_verify_layout);
        KycWaSDK.getInstance().trackCustomKVEvent(this, "faceservice_load_ui", null, null);
        this.f40961a = this;
        this.f40969i.e(false);
        c();
        a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (f40960k != 0) {
            WLogger.d("FaceVerifyActivity", "NOT Same Activity onDestroy ");
            return;
        }
        WLogger.d("FaceVerifyActivity", "Activity onDestroy");
        d("onDestroy");
        this.f40969i.h();
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.f40962b;
        if (aVar != null) {
            aVar.dismiss();
            this.f40962b = null;
        }
        if (this.f40961a != null) {
            this.f40961a = null;
        }
        WLogger.i("FaceVerifyActivity", "close bugly report");
        c.a().a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        WLogger.d("FaceVerifyActivity", "onNewIntent()");
    }

    @Override // android.app.Activity
    public void onPause() {
        WLogger.d("FaceVerifyActivity", "Activity onPause");
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i10 == 1024 && strArr.length > 0 && iArr.length > 0) {
            int length = iArr.length;
            boolean z10 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z10 = true;
                    break;
                } else if (iArr[i11] != 0) {
                    break;
                } else {
                    i11++;
                }
            }
            if (z10) {
                h();
            } else if (Build.VERSION.SDK_INT < 23 || c(strArr, iArr)) {
                a(strArr, iArr);
            } else {
                b(strArr, iArr);
            }
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        WLogger.d("FaceVerifyActivity", "Activity onResume");
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        f40960k++;
        WLogger.d("FaceVerifyActivity", "Activity onStart:" + f40960k);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        f40960k--;
        WLogger.d("FaceVerifyActivity", "Activity onStop:" + f40960k);
        if (f40960k != 0) {
            WLogger.e("FaceVerifyActivity", "not same activity");
            KycWaSDK.getInstance().trackCustomKVEvent(this, "facepage_not_same_activity", null, null);
            return;
        }
        if (this.f40969i.b()) {
            WLogger.d("FaceVerifyActivity", "inUpload stop,no finish verify");
            return;
        }
        if (d("onStop")) {
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.f40962b;
            if (aVar != null) {
                aVar.dismiss();
                this.f40962b = null;
            }
            WLogger.d("FaceVerifyActivity", "finish activity");
            finish();
        }
    }
}
