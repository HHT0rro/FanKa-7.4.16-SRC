package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.ALBiometricsNavigator;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.hb;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.build.t;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/* compiled from: BiometricsBusinessWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class y extends t {

    /* renamed from: d, reason: collision with root package name */
    public static final String f3998d = "4";

    /* renamed from: e, reason: collision with root package name */
    public static final String f3999e = "10";

    /* renamed from: i, reason: collision with root package name */
    private static final String f4000i = "BiometricFail";

    /* renamed from: j, reason: collision with root package name */
    private static final String f4001j = "INITIATIVE_QUIT";

    /* renamed from: f, reason: collision with root package name */
    public AbsBiometricsBucketParams f4002f;

    /* renamed from: g, reason: collision with root package name */
    public ALBiometricsResult f4003g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4004h;

    /* renamed from: k, reason: collision with root package name */
    private final hc f4005k;

    /* renamed from: l, reason: collision with root package name */
    private final hm f4006l;

    /* compiled from: BiometricsBusinessWorker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements ALBiometricsEventListener {

        /* renamed from: b, reason: collision with root package name */
        private final t.a f4017b;

        /* renamed from: c, reason: collision with root package name */
        private final RPEventListener f4018c = j.a.f3944a.f3899i;

        /* renamed from: d, reason: collision with root package name */
        private final y f4019d;

        public a(t.a aVar) {
            this.f4017b = aVar;
            this.f4019d = y.this;
        }

        private static String a(ALBiometricsResult aLBiometricsResult, boolean z10) {
            if (aLBiometricsResult == null) {
                return null;
            }
            return z10 ? aLBiometricsResult.getVideoS() : aLBiometricsResult.getVideoF();
        }

        @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
        public final String getAppKey() {
            return j.a.f3944a.f3901k.f();
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBeforeRetry(OnRetryListener onRetryListener, String str) {
            y yVar = y.this;
            AbsBiometricsBucketParams absBiometricsBucketParams = yVar.f4002f;
            if (absBiometricsBucketParams == null) {
                onRetryListener.onRetry(0);
            } else {
                absBiometricsBucketParams.riskEvent(yVar.f3979b, onRetryListener, str, y.f4000i, "1");
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBiometricsFinish(int i10) {
            RPEventListener rPEventListener = this.f4018c;
            if (rPEventListener != null) {
                rPEventListener.onBiometricsFinish(i10);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBiometricsStart() {
            RPEventListener rPEventListener = this.f4018c;
            if (rPEventListener != null) {
                rPEventListener.onBiometricsStart();
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onBusinessOk() {
            b bVar = j.a.f3944a.f3899i;
            if (bVar != null) {
                bVar.onFinish(RPResult.AUDIT_PASS, "0", "");
                j.a.f3944a.f3899i = null;
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onCancel(int i10, String str) {
            onSensorStop();
            y yVar = y.this;
            yVar.f4002f.riskEvent(yVar.f3979b, null, str, y.f4001j, "6");
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
            aLBiometricsCallBackBean.errorCode = i10;
            aLBiometricsCallBackBean.errorMsg = "onCancel";
            y.this.f4002f.setBiometricsCallBackBean(aLBiometricsCallBackBean);
            t.a aVar = this.f4017b;
            if (aVar != null) {
                aVar.b(y.this.f4002f, true);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onError(int i10, Bundle bundle) {
            if (bundle == null || !bundle.containsKey(ALBiometricsKeys.KEY_RESULT_DATA)) {
                return;
            }
            ALBiometricsResult aLBiometricsResult = (ALBiometricsResult) bundle.getSerializable(ALBiometricsKeys.KEY_RESULT_DATA);
            onSensorStop();
            y.a(y.this, a(aLBiometricsResult, false), false, "4");
            this.f4019d.f4003g = aLBiometricsResult;
            if (this.f4017b != null) {
                AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
                aLBiometricsCallBackBean.errorCode = i10;
                aLBiometricsCallBackBean.errorMsg = "onError";
                y.this.f4002f.setBiometricsCallBackBean(aLBiometricsCallBackBean);
                y.this.f4002f.setAlBiometricsResult(aLBiometricsResult);
                this.f4019d.f4004h = false;
                this.f4017b.b(y.this.f4002f, true);
            }
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onFinish(int i10, boolean z10) {
            if (z10) {
                AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
                aLBiometricsCallBackBean.errorCode = i10;
                aLBiometricsCallBackBean.errorMsg = "";
                y.this.f4002f.setBiometricsCallBackBean(aLBiometricsCallBackBean);
                if (i10 == 0) {
                    onSensorStop();
                    this.f4019d.f4002f.setCalledFinishSuccessfully(true);
                    this.f4017b.a(y.this.f4002f, true);
                    return;
                }
                this.f4017b.b(y.this.f4002f, true);
            }
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
        public final void onLogTrack(TrackLog trackLog) {
            j unused = j.a.f3944a;
            j.a(y.this.f3980c, trackLog);
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
        public final void onOldLogRecord(Bundle bundle) {
            HashMap hashMap = new HashMap();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                try {
                    d.a().a(hashMap);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorReset() {
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorStart() {
        }

        @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
        public final void onSensorStop() {
        }

        @Override // com.alibaba.security.biometrics.ALBiometricsEventListener
        public final void onSuccess(ALBiometricsResult aLBiometricsResult) {
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
            this.f4019d.f4003g = aLBiometricsResult;
            aLBiometricsCallBackBean.errorMsg = "";
            aLBiometricsCallBackBean.errorCode = 0;
            y.this.f4002f.setBiometricsCallBackBean(aLBiometricsCallBackBean);
            if (aLBiometricsResult == null) {
                aLBiometricsCallBackBean.errorCode = -10000;
                aLBiometricsCallBackBean.errorMsg = "biometricsResult is null";
                this.f4017b.b(y.this.f4002f, true);
                return;
            }
            y.this.f4002f.setAlBiometricsResult(aLBiometricsResult);
            if (aLBiometricsResult.getQi() == null) {
                aLBiometricsCallBackBean.errorCode = -10000;
                aLBiometricsCallBackBean.errorMsg = "biometricsResult qi result is null";
                this.f4017b.b(y.this.f4002f, true);
            } else {
                y.a(y.this, a(aLBiometricsResult, true), true, "4");
                onSensorStop();
                this.f4019d.f4004h = true;
                this.f4017b.a(y.this.f4002f, true);
            }
        }

        @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
        public final String sign(String str) {
            return j.a.f3944a.f3901k.b(str);
        }

        private static String a(ALBiometricsResult aLBiometricsResult) {
            if (aLBiometricsResult == null) {
                return null;
            }
            return aLBiometricsResult.getDazzleVideoPath();
        }
    }

    public y(Context context) {
        super(context);
        this.f4003g = null;
        this.f4004h = false;
        hb unused = hb.a.f3807a;
        this.f4005k = hb.a(context);
        this.f4006l = new hm(context);
    }

    private static void j() {
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String b() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String c() {
        return "";
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String d() {
        return TrackConstants.Service.BIOMETRICS;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String e() {
        return TrackConstants.Method.DETECT;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final String f() {
        return TrackConstants.Method.DETECT;
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void g() {
        this.f4002f.finishTask(this.f3979b, this.f4004h, new BucketParams.a() { // from class: com.alibaba.security.realidentity.build.y.2
            @Override // com.alibaba.security.realidentity.business.bucket.BucketParams.a
            public final void a() {
            }
        }, this.f4003g);
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final BusinessType h() {
        return BusinessType.ALBIOMETERICS;
    }

    private void c(r rVar, BucketParams bucketParams) {
        ALBiometricsNavigator aLBiometricsNavigator = rVar.f3970d.biometricsNavigator;
        int i10 = bucketParams.getErrorCode().globalErrorCode;
        String str = bucketParams.getErrorCode().errorMsg;
        if (this.f4002f.isNeedBioResultPage) {
            Bundle bundle = new Bundle();
            bundle.putInt(ALBiometricsKeys.KEY_ERROR_DETECT_K, i10);
            bundle.putString(ALBiometricsKeys.KEY_ERROR_DETECT_MSG_K, str);
            aLBiometricsNavigator.restart(this.f3979b, bundle);
            rVar.d();
            return;
        }
        aLBiometricsNavigator.finish(this.f3979b);
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void b(r rVar, BucketParams bucketParams) {
        c(rVar, bucketParams);
    }

    private void b(r rVar) {
        ALBiometricsNavigator aLBiometricsNavigator = rVar.f3970d.biometricsNavigator;
        if (this.f4002f.isNeedBioResultPage) {
            aLBiometricsNavigator.restart(this.f3979b, null);
        } else {
            aLBiometricsNavigator.finish(this.f3979b);
        }
    }

    /* compiled from: BiometricsBusinessWorker.java */
    /* renamed from: com.alibaba.security.realidentity.build.y$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass3 implements he {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4010a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4011b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f4012c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f4013d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f4014e;

        public AnonymousClass3(String str, String str2, String str3, String str4, String str5) {
            this.f4010a = str;
            this.f4011b = str2;
            this.f4012c = str3;
            this.f4013d = str4;
            this.f4014e = str5;
        }

        @Override // com.alibaba.security.realidentity.build.he
        public final void a(long j10, long j11) {
        }

        @Override // com.alibaba.security.realidentity.build.he
        public final void a(String str) {
            y.this.f4002f.getBundle().getBoolean(ALBiometricsKeys.KEY_SESSION_LESS);
            FileUtils.delete(this.f4014e);
        }

        @Override // com.alibaba.security.realidentity.build.he
        public final void b(String str) {
            FileUtils.delete(this.f4014e);
        }

        @Override // com.alibaba.security.realidentity.build.he
        public final void a() {
            FileUtils.delete(this.f4014e);
        }
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar, BucketParams bucketParams) {
        c(rVar, bucketParams);
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar, final t.a aVar) {
        this.f4002f = rVar.f3970d;
        ALBiometricsConfig biometricsConfig = j.a.f3944a.c() != null ? j.a.f3944a.c().getBiometricsConfig() : null;
        StartHttpParams startHttpParams = rVar.f3969c;
        if (startHttpParams != null) {
            this.f4002f.isNeedBioResultPage = startHttpParams.mShowResult;
        }
        this.f4002f.setCalledFinishSuccessfully(false);
        ALBiometricsNavigator aLBiometricsNavigator = new ALBiometricsNavigator(this.f3979b) { // from class: com.alibaba.security.realidentity.build.y.1
            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final ALBiometricsEventListener getEventListener() {
                return new a(aVar);
            }

            @Override // com.alibaba.security.biometrics.ALBiometricsNavigator
            public final Bundle getParams() {
                return y.this.f4002f.getBundle();
            }
        };
        this.f4002f.biometricsNavigator = aLBiometricsNavigator;
        aLBiometricsNavigator.start(this.f3979b, biometricsConfig);
    }

    private void a(String str, boolean z10, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UploadFileModel uploadFileModel = new UploadFileModel();
        String str4 = this.f3980c;
        String format = new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis()));
        String str5 = z10 ? "success" : "failure";
        uploadFileModel.setDestDir("biometric/video/" + format + "/" + str4 + "/" + str5);
        uploadFileModel.setFileType("h264");
        uploadFileModel.setLocalFilePath(str);
        uploadFileModel.setRemoteFileName(new File(str).getName());
        this.f4005k.a(null, uploadFileModel, new AnonymousClass3(str4, str5, str2, str3, str));
    }

    @Override // com.alibaba.security.realidentity.build.t
    public final void a(r rVar) {
        ALBiometricsNavigator aLBiometricsNavigator = rVar.f3970d.biometricsNavigator;
        if (this.f4002f.isNeedBioResultPage) {
            aLBiometricsNavigator.restart(this.f3979b, null);
        } else {
            aLBiometricsNavigator.finish(this.f3979b);
        }
    }

    public static /* synthetic */ void a(y yVar, String str, boolean z10, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UploadFileModel uploadFileModel = new UploadFileModel();
        String str3 = yVar.f3980c;
        String format = new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis()));
        String str4 = z10 ? "success" : "failure";
        uploadFileModel.setDestDir("biometric/video/" + format + "/" + str3 + "/" + str4);
        uploadFileModel.setFileType("h264");
        uploadFileModel.setLocalFilePath(str);
        uploadFileModel.setRemoteFileName(new File(str).getName());
        yVar.f4005k.a(null, uploadFileModel, new AnonymousClass3(str3, str4, str2, null, str));
    }
}
