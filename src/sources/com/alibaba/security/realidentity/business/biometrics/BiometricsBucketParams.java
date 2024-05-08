package com.alibaba.security.realidentity.business.biometrics;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.build.aq;
import com.alibaba.security.realidentity.build.c;
import com.alibaba.security.realidentity.build.d;
import com.alibaba.security.realidentity.build.hj;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.build.r;
import com.alibaba.security.realidentity.business.RPBusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.ActionInfo;
import com.alibaba.security.realidentity.business.start.ExtrasBean;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.http.HttpRequestManager;
import com.alibaba.security.realidentity.http.RpHttpResponse;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BiometricsBucketParams extends AbsBiometricsBucketParams {
    private static final String TAG = "BiometricsBucketParams";
    private final ThreadPoolExecutor mExecutorService;
    private final Bundle params = new Bundle();
    public StartHttpParams startHttpParams = null;
    private BusinessHeadParams baseHeadParams = null;
    private RPBusinessHeadParams headParams = null;
    private final a mUiHandler = new a(this);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final BiometricsBucketParams f4031a;

        public a(BiometricsBucketParams biometricsBucketParams) {
            super(Looper.getMainLooper());
            this.f4031a = biometricsBucketParams;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
        }
    }

    public BiometricsBucketParams() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-biometrics");
            }
        });
        this.mExecutorService = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private int actionTypeBaseOnActionString(String str) {
        if (TextUtils.equals(str, "BLINK")) {
            return 1;
        }
        if (TextUtils.equals(str, "MOUTH")) {
            return 2;
        }
        if (TextUtils.equals(str, "SHAKE_HEAD")) {
            return 3;
        }
        return TextUtils.equals(str, "NOD") ? 10 : 11;
    }

    private void buildBiometricsBundleParamsByStartHttpParams(StartHttpParams startHttpParams) {
        List<ActionInfo> list;
        boolean z10 = startHttpParams.mShowNav;
        boolean z11 = startHttpParams.mShowPrivacy;
        boolean z12 = startHttpParams.mShowResult;
        boolean z13 = startHttpParams.mNeedGaze;
        this.params.putBoolean(ALBiometricsKeys.KEY_SOUND_ON, true);
        this.params.putBoolean(ALBiometricsKeys.KEY_SHOW_SOUND_SWITCH, true);
        int i10 = startHttpParams.mActionCount;
        this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, i10);
        List<ActionInfo> list2 = startHttpParams.mActionDetail;
        if (list2 != null) {
            int size = list2.size();
            int i11 = 0;
            if (size == 1) {
                this.params.putBoolean(ALBiometricsKeys.KEY_DETECT_WRONG_ACTION, false);
            }
            if (size > 0) {
                int[] iArr = new int[size];
                while (i11 < size) {
                    String[] strArr = list2.get(i11).actionNames;
                    if (strArr.length > 0) {
                        list = list2;
                        iArr[i11] = actionTypeBaseOnActionString(strArr[(int) (strArr.length * Math.random())]);
                    } else {
                        list = list2;
                    }
                    i11++;
                    list2 = list;
                }
                this.params.putInt(ALBiometricsKeys.KEY_ACTION_COUNT, size);
                this.params.putIntArray("strategy", iArr);
            } else if (i10 <= 0) {
                this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, true);
            }
        } else if (i10 <= 0) {
            this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, true);
        }
        this.params.putBoolean(ALBiometricsKeys.KEY_SOUND_ON, j.a.f3944a.c().getBiometricsConfig().isNeedSound());
        this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA2_OPEN, parseCamera2Config(startHttpParams.mVerifyDowngradConfig));
        this.params.putBoolean(ALBiometricsKeys.KEY_CAMERA_PREVIEW_SWITCH, parseCameraPreviewConfig(startHttpParams.mVerifyDowngradConfig));
        this.params.putBoolean(ALBiometricsKeys.KEY_DAZZLE_COLLECT_SWITCH, parseDazzleCollectSwitch(startHttpParams.mVerifyDowngradConfig));
        HttpRequestManager.getInstance().setRequestType(parseNetRequestConfig(startHttpParams.mVerifyDowngradConfig));
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_NAV, z10);
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_PRIVACY, z11);
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_RESULT, z12);
        this.params.putBoolean(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, true);
        this.params.putBoolean(ALBiometricsKeys.KEY_STEP_ADJUST, z13);
        this.params.putBoolean(ALBiometricsKeys.KEY_SHOW_CHECK_DIALOG, true);
        this.params.putString(ALBiometricsKeys.KEY_VERIFY_TOKEN, this.mVerifyToken);
        this.params.putString(ALBiometricsKeys.KEY_START_VERIFY_TYPE, j.a.f3944a.f3906p);
        String str = startHttpParams.mLivenessConfig;
        if (!TextUtils.isEmpty(str)) {
            this.params.putString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG, str);
        }
        this.params.putString(ALBiometricsKeys.KEY_SEC_TOKEN, this.mVerifyToken);
        ExtrasBean extrasBean = startHttpParams.mExtrasBean;
        if (extrasBean == null || TextUtils.isEmpty(extrasBean.getName())) {
            return;
        }
        this.params.putString("userName", startHttpParams.mExtrasBean.getName());
    }

    private List<ActionInfo> getActionNames(RPBusinessHeadParams.RPExtrasBean rPExtrasBean) {
        if (rPExtrasBean == null) {
            return new ArrayList();
        }
        return JsonUtils.parseArray(rPExtrasBean.getActionDetail(), ActionInfo.class);
    }

    private AbsBiometricsBucketParams.ALBiometricsCallBackBean onLivenessDetectFailed(Context context, ALBiometricsResult aLBiometricsResult) {
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
        if (this.isLimited) {
            aLBiometricsCallBackBean.errorCode = GlobalErrorCode.ERROR_USER_RETRY_LIMITED;
            aLBiometricsCallBackBean.isSuccessful = true;
            return aLBiometricsCallBackBean;
        }
        if (aLBiometricsResult != null) {
            int r10 = aLBiometricsResult.getR();
            if (r10 == -1) {
                aLBiometricsCallBackBean.errorCode = -1;
            }
            if (r10 == -10405) {
                aLBiometricsCallBackBean.errorCode = GlobalErrorCode.ERROR_USER_RETRY_LIMITED;
            }
            if (r10 == -10407) {
                aLBiometricsCallBackBean.errorCode = GlobalErrorCode.ERROR_BUSINESS_RETRY_REACH_THRESHOLD;
            } else {
                aLBiometricsCallBackBean.errorCode = -1;
                HashMap hashMap = new HashMap();
                hashMap.put("errorMsg", String.format("验证失败，ErrorCode=%s", Integer.valueOf(aLBiometricsResult.getR())));
                d.a().a(0, c.f3222j, "livenessFailed", hashMap);
            }
        } else {
            aLBiometricsCallBackBean.errorCode = -1;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "livenessResult is null");
            d.a().a(0, c.f3222j, "livenessFailed", hashMap2);
        }
        aLBiometricsCallBackBean.isSuccessful = false;
        return aLBiometricsCallBackBean;
    }

    private AbsBiometricsBucketParams.ALBiometricsCallBackBean onLivenessDetectSuccess(Context context, ALBiometricsResult aLBiometricsResult) {
        if (aLBiometricsResult != null && aLBiometricsResult.getQi() != null) {
            AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
            aLBiometricsCallBackBean.errorCode = 0;
            aLBiometricsCallBackBean.isSuccessful = true;
            return aLBiometricsCallBackBean;
        }
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean2 = new AbsBiometricsBucketParams.ALBiometricsCallBackBean();
        aLBiometricsCallBackBean2.errorCode = -1;
        aLBiometricsCallBackBean2.errorMsg = "验证不通过，请按提示做动作";
        aLBiometricsCallBackBean2.isSuccessful = false;
        return aLBiometricsCallBackBean2;
    }

    private void reportEvent(final OnRetryListener onRetryListener, final String str, final String str2) {
        this.mExecutorService.execute(new Runnable() { // from class: com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.2
            @Override // java.lang.Runnable
            public final void run() {
                HashMap hashMap = new HashMap();
                hashMap.put(aq.f3108d, BiometricsBucketParams.this.mVerifyToken);
                ClientInfo clientInfo = new ClientInfo();
                clientInfo.setClientType(GrsBaseInfo.CountryCodeSource.APP);
                clientInfo.setAppInfo(hj.a(BiometricsBucketParams.this.mVerifyToken));
                clientInfo.setDeviceInfo(hj.a());
                clientInfo.setNetWorkInfo(hj.b(BiometricsBucketParams.this.mVerifyToken));
                hashMap.put(aq.f3110f, JsonUtils.toJsonObject(JsonUtils.toJSON(clientInfo)));
                hashMap.put("name", str2);
                hashMap.put("details", "");
                hashMap.put("flActionLog", str);
                BiometricsBucketParams biometricsBucketParams = BiometricsBucketParams.this;
                biometricsBucketParams.isLimited = biometricsBucketParams.verifyLimitedEvent(hashMap);
                if (onRetryListener != null) {
                    BiometricsBucketParams.this.mUiHandler.post(new Runnable() { // from class: com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            onRetryListener.onRetry(!BiometricsBucketParams.this.isLimited ? 1 : 0);
                        }
                    });
                }
            }
        });
    }

    private StartHttpParams transformBusinessHeadParamsToStartHttpParams(BusinessHeadParams businessHeadParams, r rVar) {
        this.headParams = (RPBusinessHeadParams) businessHeadParams;
        StartHttpParams startHttpParams = new StartHttpParams();
        RPBusinessHeadParams.RPExtrasBean extras = this.headParams.getExtras();
        if (extras != null) {
            startHttpParams.mActionDetail = getActionNames(extras);
            try {
                if (!TextUtils.isEmpty(extras.getActionCount())) {
                    startHttpParams.mActionCount = Integer.parseInt(extras.getActionCount());
                }
            } catch (Exception e2) {
                RPLogging.e(TAG, e2);
            }
        }
        startHttpParams.setVerifyToken(this.headParams.getVerifyToken());
        startHttpParams.mUploadToken = this.headParams.getOssUploadToken();
        startHttpParams.mNeedGaze = this.headParams.isNeedGaze();
        startHttpParams.mExtrasBean = this.headParams.getExtrasOrigin();
        startHttpParams.mVerifyDowngradConfig = this.headParams.getVerifyConf();
        startHttpParams.mNeedActionImage = this.headParams.isNeedActionImage();
        rVar.f3969c = startHttpParams;
        return startHttpParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean verifyLimitedEvent(HashMap<String, Object> hashMap) {
        RpHttpResponse syncRequest = HttpRequestManager.getInstance().syncRequest(j.a.f3944a.f3894d, com.alibaba.security.realidentity.build.a.f3002h, JsonUtils.toJsonString(hashMap));
        if (syncRequest == null || !syncRequest.isSuccessful()) {
            return false;
        }
        try {
            return new JSONObject(syncRequest.getResponseBody()).optInt("code") != 3204;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean finishTask(Context context, boolean z10, BucketParams.a aVar, Object... objArr) {
        if (z10) {
            onLivenessDetectSuccess(context, this.biometricsResult);
            return true;
        }
        onLivenessDetectFailed(context, this.biometricsResult);
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public Bundle getBundle() {
        return this.params;
    }

    public StartHttpParams getStartHttpParams() {
        return this.startHttpParams;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(r rVar) {
        StartHttpParams startHttpParams = rVar.f3969c;
        if (startHttpParams != null) {
            this.startHttpParams = startHttpParams;
            buildBiometricsBundleParamsByStartHttpParams(startHttpParams);
            return true;
        }
        BusinessHeadParams businessHeadParams = rVar.f3968b;
        this.baseHeadParams = businessHeadParams;
        if (businessHeadParams != null) {
            StartHttpParams transformBusinessHeadParamsToStartHttpParams = transformBusinessHeadParamsToStartHttpParams(businessHeadParams, rVar);
            this.startHttpParams = transformBusinessHeadParamsToStartHttpParams;
            buildBiometricsBundleParamsByStartHttpParams(transformBusinessHeadParamsToStartHttpParams);
        }
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        if (this.isSuccessful) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "bio success", 0);
        }
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean = this.biometricsCallBackBean;
        if (aLBiometricsCallBackBean == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10000", "biometrics bean is null", -10000);
        }
        RPResult rPResult = RPResult.AUDIT_NOT;
        String valueOf = String.valueOf(aLBiometricsCallBackBean.errorCode);
        AbsBiometricsBucketParams.ALBiometricsCallBackBean aLBiometricsCallBackBean2 = this.biometricsCallBackBean;
        return new BucketParams.ErrorCode(rPResult, valueOf, aLBiometricsCallBackBean2.errorMsg, aLBiometricsCallBackBean2.errorCode);
    }

    @Override // com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams
    public void riskEvent(Context context, OnRetryListener onRetryListener, String str, String str2, String str3) {
        super.riskEvent(context, onRetryListener, str, str2, str3);
        reportEvent(onRetryListener, str, str2);
    }
}
