package com.huawei.hms.support.api.safetydetect;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.safetydetect.AntiFraudRequest;
import com.huawei.hms.support.api.entity.safetydetect.EnableAppsCheckReq;
import com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsListReq;
import com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsListResp;
import com.huawei.hms.support.api.entity.safetydetect.RiskTokenResponse;
import com.huawei.hms.support.api.entity.safetydetect.SysIntegrityReq;
import com.huawei.hms.support.api.entity.safetydetect.SysIntegrityResp;
import com.huawei.hms.support.api.entity.safetydetect.UrlCheckRequest;
import com.huawei.hms.support.api.entity.safetydetect.UrlCheckResponse;
import com.huawei.hms.support.api.entity.safetydetect.UserDetectRequest;
import com.huawei.hms.support.api.entity.safetydetect.UserDetectResponse;
import com.huawei.hms.support.api.entity.safetydetect.VerifyAppsCheckEnabledReq;
import com.huawei.hms.support.api.entity.safetydetect.VerifyAppsCheckEnabledResp;
import com.huawei.hms.support.api.entity.safetydetect.WifiDetectResponse;
import com.huawei.hms.support.api.safetydetect.callback.AllowlistApiCall;
import com.huawei.hms.support.api.safetydetect.callback.EnableAppsCheckTaskApiCall;
import com.huawei.hms.support.api.safetydetect.callback.GetMaliciousAppsListTaskApiCall;
import com.huawei.hms.support.api.safetydetect.callback.GetRiskTokenApiCall;
import com.huawei.hms.support.api.safetydetect.callback.GetWifiDetectStatusTaskApiCall;
import com.huawei.hms.support.api.safetydetect.callback.InitAntiFraudApiCall;
import com.huawei.hms.support.api.safetydetect.callback.InitUserDetectApiCall;
import com.huawei.hms.support.api.safetydetect.callback.ReleaseAntiFraud;
import com.huawei.hms.support.api.safetydetect.callback.ShutDownUserDetectApiCall;
import com.huawei.hms.support.api.safetydetect.callback.ShutdownApiCall;
import com.huawei.hms.support.api.safetydetect.callback.SysIntegrityTaskApiCall;
import com.huawei.hms.support.api.safetydetect.callback.UrlCheckApiCall;
import com.huawei.hms.support.api.safetydetect.callback.UserDetectApiCall;
import com.huawei.hms.support.api.safetydetect.callback.VerifyAppsCheckTaskApiCall;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.SHA256;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafetyDetectClientImpl extends HuaweiApi<SafetyDetectOptions> implements SafetyDetectClient {
    public static final int MIN_API_LEVEL = 1;
    public static final int NONCE_MIN_SIZE = 16;
    public static final String TAG = "SafetyDetectClientImpl";
    public Context mCxt;
    public static final SafetyDetectClientBuilder CLIENT_BUILDER = new SafetyDetectClientBuilder();
    public static final Api<SafetyDetectOptions> SYS_INTEGRITY_OPTIONS_API = new Api<>("HuaweiSafetyDetect.API");

    public SafetyDetectClientImpl(Activity activity, SafetyDetectOptions safetyDetectOptions) {
        super(activity, SYS_INTEGRITY_OPTIONS_API, safetyDetectOptions, (AbstractClientBuilder) CLIENT_BUILDER, 5003301);
        this.mCxt = activity;
    }

    public SafetyDetectClientImpl(Context context, SafetyDetectOptions safetyDetectOptions) {
        super(context, SYS_INTEGRITY_OPTIONS_API, safetyDetectOptions, CLIENT_BUILDER, 5003301);
        this.mCxt = context;
    }

    public static String getApkDigest(String str) {
        System.currentTimeMillis();
        try {
            DigestInputStream digestInputStream = new DigestInputStream(new FileInputStream(str), MessageDigest.getInstance("SHA-256"));
            try {
                do {
                } while (digestInputStream.read(new byte[131072]) > 0);
                String encode = Base64.encode(digestInputStream.getMessageDigest().digest());
                digestInputStream.close();
                return encode;
            } finally {
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private SysIntegrityReq prepareReq(byte[] bArr, String str, Context context) {
        SysIntegrityReq sysIntegrityReq = new SysIntegrityReq();
        String str2 = context.getApplicationInfo().sourceDir;
        sysIntegrityReq.setNonce(Base64.encode(bArr));
        sysIntegrityReq.setAppId(str);
        sysIntegrityReq.setPackageName(context.getApplicationInfo().packageName);
        sysIntegrityReq.setApkDigestSha256(getApkDigest(str2));
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            String[] strArr = new String[packageInfo.signatures.length];
            int i10 = 0;
            while (true) {
                Signature[] signatureArr = packageInfo.signatures;
                if (i10 >= signatureArr.length) {
                    break;
                }
                strArr[i10] = Base64.encode(SHA256.digest(signatureArr[i10].toByteArray()));
                i10++;
            }
            sysIntegrityReq.setApkCertificateDigestSha256(strArr);
        } catch (PackageManager.NameNotFoundException unused) {
            sysIntegrityReq.setApkCertificateDigestSha256(null);
        }
        return sysIntegrityReq;
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<VerifyAppsCheckEnabledResp> enableAppsCheck() {
        return doWrite(new EnableAppsCheckTaskApiCall(getContext(), SafetyDetectNaming.ENABLE_APPS_CHECK, new EnableAppsCheckReq().toJson(), true));
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<MaliciousAppsListResp> getMaliciousAppsList() {
        return doWrite(new GetMaliciousAppsListTaskApiCall(getContext(), SafetyDetectNaming.GET_MALICIOUS_APPS_LIST, new MaliciousAppsListReq().toJson(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<RiskTokenResponse> getRiskToken() {
        return doWrite(new GetRiskTokenApiCall(getContext(), SafetyDetectNaming.GET_RISK_TOKEN, "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<WifiDetectResponse> getWifiDetectStatus() {
        return doWrite(new GetWifiDetectStatusTaskApiCall(getContext(), SafetyDetectNaming.GET_WIFI_DETECT_STATUS, "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> initAntiFraud(String str) {
        Checker.checkNonNull(str);
        return doWrite(new InitAntiFraudApiCall(getContext(), SafetyDetectNaming.INIT_ANTI_FRAUD, new AntiFraudRequest(str).toJsonString(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> initUrlCheck() {
        return doWrite(new AllowlistApiCall(getContext(), SafetyDetectNaming.INIT_URL_CHECKER, "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> initUserDetect() {
        return doWrite(new InitUserDetectApiCall(getContext(), SafetyDetectNaming.INIT_USER_DETECT, "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<VerifyAppsCheckEnabledResp> isVerifyAppsCheck() {
        return doWrite(new VerifyAppsCheckTaskApiCall(getContext(), SafetyDetectNaming.IS_VERIFY_APPS_CHECK, new VerifyAppsCheckEnabledReq().toJson(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> releaseAntiFraud() {
        return doWrite(new ReleaseAntiFraud(getContext(), SafetyDetectNaming.RELEASE_ANTI_FRAUD, "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> shutdownUrlCheck() {
        return doWrite(new ShutdownApiCall(getContext(), SafetyDetectNaming.SHUTDOWN_URL_CHECKER, "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<Void> shutdownUserDetect() {
        return doWrite(new ShutDownUserDetectApiCall(getContext(), SafetyDetectNaming.SHUTDOWN_USER_DETECT, "", true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<SysIntegrityResp> sysIntegrity(byte[] bArr, String str) {
        ApiException e2;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (TextUtils.isEmpty(str)) {
                        throw new ApiException(new Status(SafetyDetectStatusCodes.PARAM_ERROR_EMPTY, SafetyDetectStatusCodes.getStatusCodeString(SafetyDetectStatusCodes.PARAM_ERROR_EMPTY)));
                    }
                    if (bArr.length < 16) {
                        throw new ApiException(new Status(SafetyDetectStatusCodes.PARAM_ERROR_INVALID, SafetyDetectStatusCodes.getStatusCodeString(SafetyDetectStatusCodes.PARAM_ERROR_INVALID)));
                    }
                    SysIntegrityReq prepareReq = prepareReq(bArr, str, this.mCxt);
                    return doWrite(new SysIntegrityTaskApiCall(getContext(), SafetyDetectNaming.SYS_INTEGRITY, prepareReq.toJsonString(), true));
                }
            } catch (ApiException e10) {
                e2 = e10;
                taskCompletionSource.setException(e2);
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                e2 = new ApiException(new Status(SafetyDetectStatusCodes.SDK_INTERNAL_ERROR, SafetyDetectStatusCodes.getStatusCodeString(SafetyDetectStatusCodes.SDK_INTERNAL_ERROR)));
                taskCompletionSource.setException(e2);
                return taskCompletionSource.getTask();
            }
        }
        throw new ApiException(new Status(SafetyDetectStatusCodes.PARAM_ERROR_EMPTY, SafetyDetectStatusCodes.getStatusCodeString(SafetyDetectStatusCodes.PARAM_ERROR_EMPTY)));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<UrlCheckResponse> urlCheck(String str, String str2, int... iArr) {
        Checker.checkNonNull(str);
        Checker.checkNonNull(str2);
        return doWrite(new UrlCheckApiCall(getContext(), SafetyDetectNaming.CALL_URL_CHECKER, new UrlCheckRequest(str, str2, iArr).toJsonString(), true));
    }

    @Override // com.huawei.hms.support.api.safetydetect.SafetyDetectClient
    public Task<UserDetectResponse> userDetection(String str) {
        Checker.checkNonNull(str);
        return doWrite(new UserDetectApiCall(getContext(), SafetyDetectNaming.USER_DETECTION, new UserDetectRequest(str).toJsonString(), true));
    }
}
