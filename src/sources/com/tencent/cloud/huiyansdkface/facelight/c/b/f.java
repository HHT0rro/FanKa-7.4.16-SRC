package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.app.Activity;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.c;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f implements c.b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40642a = "f";

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.process.d f40643b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f40644c;

    /* renamed from: d, reason: collision with root package name */
    private FaceVerifyStatus f40645d;

    public f(com.tencent.cloud.huiyansdkface.facelight.process.d dVar, Activity activity, FaceVerifyStatus faceVerifyStatus) {
        this.f40643b = dVar;
        this.f40644c = activity;
        this.f40645d = faceVerifyStatus;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
    public void a() {
        KycWaSDK kycWaSDK;
        Activity activity;
        String str;
        String str2 = f40642a;
        WLogger.e(str2, "onHomePressed");
        if (this.f40643b.b()) {
            WLogger.d(str2, "inUpload home presssed,dont quit.");
            return;
        }
        if (this.f40645d.b() == 6) {
            kycWaSDK = KycWaSDK.getInstance();
            activity = this.f40644c;
            str = "uploadpage_exit_self";
        } else if (this.f40645d.b() != 5) {
            kycWaSDK = KycWaSDK.getInstance();
            activity = this.f40644c;
            str = "facepage_exit_self";
        } else if (this.f40643b.d()) {
            kycWaSDK = KycWaSDK.getInstance();
            activity = this.f40644c;
            str = "willpage_answer_exit_self";
        } else {
            kycWaSDK = KycWaSDK.getInstance();
            activity = this.f40644c;
            str = "willpage_exit_self";
        }
        kycWaSDK.trackCustomKVEvent(activity, str, "点击home键返回", null);
        this.f40645d.b(9);
        this.f40643b.e(true);
        if (this.f40643b.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.f40643b.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
            wbFaceError.setDesc("用户取消");
            wbFaceError.setReason("home键：用户验证中取消");
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.f40643b.a(this.f40644c, WbFaceError.WBFaceErrorCodeUserCancle, properties);
            this.f40643b.y().onFinish(wbFaceVerifyResult);
        }
        WLogger.d(str2, "finish activity");
        this.f40644c.finish();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
    public void b() {
        WLogger.d(f40642a, "onHomeLongPressed");
    }
}
