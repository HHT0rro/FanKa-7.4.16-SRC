package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WbSecureProviders;
import com.tencent.cloud.huiyansdkface.facelight.common.WbTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.GetFaceActiveCompareType;
import com.tencent.cloud.huiyansdkface.facelight.net.GetGradeFaceCompareResult;
import com.tencent.cloud.huiyansdkface.facelight.net.LoginRequest;
import com.tencent.cloud.huiyansdkface.facelight.net.QueryFaceResultRequest;
import com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillRes;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.CompareResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.GetActResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.LoginResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.QueryResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.RiskInfo;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.PermissionInfo;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.WeMediaManager;
import com.tencent.cloud.huiyansdkface.wehttp2.BaseCallback;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.IOException;
import java.util.Properties;
import java.util.TimerTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbFaceLiveImpl implements WbFaceModeInterface {

    /* renamed from: a, reason: collision with root package name */
    private Context f40835a;

    /* renamed from: b, reason: collision with root package name */
    private d f40836b;

    /* renamed from: c, reason: collision with root package name */
    private int f40837c;

    /* renamed from: d, reason: collision with root package name */
    private int f40838d;

    /* renamed from: e, reason: collision with root package name */
    private int f40839e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f40840f;

    /* renamed from: g, reason: collision with root package name */
    private CloudFaceCountDownTimer f40841g;

    /* renamed from: i, reason: collision with root package name */
    private ProcessCallback<FaceWillResult> f40843i;

    /* renamed from: h, reason: collision with root package name */
    private WbTimer f40842h = new WbTimer();

    /* renamed from: j, reason: collision with root package name */
    private Handler f40844j = new Handler() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                WbFaceLiveImpl.this.a("");
            }
            super.handleMessage(message);
        }
    };

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass4 implements WeReq.Callback<GetGradeFaceCompareResult.GetResultReflectModeResponse> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f40855a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f40856b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f40857c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f40858d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f40859e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FlashReq f40860f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f40861g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f40862h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f40863i;

        public AnonymousClass4(byte[] bArr, byte[] bArr2, String str, String str2, String str3, FlashReq flashReq, boolean z10, String str4, String str5) {
            this.f40855a = bArr;
            this.f40856b = bArr2;
            this.f40857c = str;
            this.f40858d = str2;
            this.f40859e = str3;
            this.f40860f = flashReq;
            this.f40861g = z10;
            this.f40862h = str4;
            this.f40863i = str5;
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeReq weReq, GetGradeFaceCompareResult.GetResultReflectModeResponse getResultReflectModeResponse) {
            if (WbFaceLiveImpl.this.f40840f) {
                WLogger.d("WbFaceLiveImpl", "Already getResult,no need handle upload result!");
                return;
            }
            WLogger.d("WbFaceLiveImpl", "upload onSuccess");
            if (getResultReflectModeResponse == null) {
                WLogger.i("WbFaceLiveImpl", "Reflect Mode upload failed! baseResponse is null！");
                WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainSeverFailed, WbFaceError.WBFaceErrorCodeCompareServerError, "报文解析异常", "Reflect Mode upload failed! baseResponse is null！"));
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_server_error", "51200+Reflect Mode upload failed! baseResponse is null！", null);
                return;
            }
            String str = this.f40861g ? getResultReflectModeResponse.encryptBody : getResultReflectModeResponse.enMsg;
            if (TextUtils.isEmpty(str)) {
                WLogger.i("WbFaceLiveImpl", "upload failed,enMsg is null！" + getResultReflectModeResponse.code + "," + getResultReflectModeResponse.msg + "," + getResultReflectModeResponse.debugMsg);
                String str2 = "upload failed!enMsg is null！" + getResultReflectModeResponse.code + "," + getResultReflectModeResponse.msg + "," + getResultReflectModeResponse.debugMsg;
                WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainSeverFailed, WbFaceError.WBFaceErrorCodeCompareServerError, "报文解析异常", str2));
                String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(this.f40861g, this.f40862h, "faceCompare:");
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_server_error", "51200+" + str2 + ";" + this.f40863i + ";" + encryptAESKey, null);
                return;
            }
            try {
                CompareResult compareResult = (CompareResult) WbCloudNetSecurityManger.decry(this.f40861g, str, CompareResult.class, this.f40862h);
                if (compareResult != null) {
                    WLogger.i("WbFaceLiveImpl", "Reflect Mode upload success!" + compareResult.toString());
                    String valueOf = String.valueOf(compareResult.code);
                    String str3 = compareResult.msg;
                    String str4 = "1".equals(compareResult.retry) ? "1" : "0";
                    String str5 = compareResult.sign;
                    String str6 = compareResult.liveRate;
                    String str7 = compareResult.similarity;
                    String str8 = str6 == null ? "分数为空" : str6;
                    if (str7 == null) {
                        str7 = "分数为空";
                    }
                    RiskInfo riskInfo = compareResult.riskInfo;
                    String str9 = compareResult.isRecorded;
                    if (TextUtils.isEmpty(valueOf)) {
                        WLogger.e("WbFaceLiveImpl", "Reflect Mode upload failed! faceCode is null!");
                        KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_server_error", "51200+Reflect Mode upload failed! faceCode is null!", null);
                        WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceLiveImpl.this.a(WbFaceError.WBFaceErrorDomainCompareServer, str9), WbFaceError.WBFaceErrorCodeCompareServerError, "报文解析异常", "Reflect Mode upload failed! faceCode is null!"));
                        return;
                    }
                    if ("0".equals(valueOf)) {
                        WLogger.i("WbFaceLiveImpl", "Reflect Mode verify success!");
                        KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_response", null, null);
                        WbFaceLiveImpl.this.a(true, new FaceWillResult(valueOf, str3, str7, str8, str4, riskInfo, str5, str9), (WbFaceInnerError) null);
                        return;
                    }
                    WLogger.i("WbFaceLiveImpl", "Reflect Mode verify failed!");
                    if ("66660018".equals(valueOf)) {
                        WbFaceLiveImpl.this.a();
                        WbFaceLiveImpl.this.a(valueOf);
                        return;
                    }
                    KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_server_error", valueOf + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + str3, null);
                    WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceLiveImpl.this.a(WbFaceError.WBFaceErrorDomainCompareServer, str9), valueOf, str3, str3, str7, str8, str4, riskInfo, str5, str9));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                WLogger.w("WbFaceLiveImpl", "Compare Result decry failed！" + e2.toString());
                String str10 = "Compare Result decry failed！ " + e2.toString();
                Properties properties = new Properties();
                properties.setProperty("enKey", this.f40863i);
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "faceservice_data_serialize_decry_fail", str10, properties);
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_server_error", str10, null);
                WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainSeverFailed, WbFaceError.WBFaceErrorCodeDataSerilizerError, "报文解析异常", str10));
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str, IOException iOException) {
            if (WbFaceLiveImpl.this.f40840f) {
                WLogger.d("WbFaceLiveImpl", "Already getResult,no need handle upload result");
                return;
            }
            WLogger.e("WbFaceLiveImpl", "upload onFailed！" + ((Object) errType) + "," + i10 + "," + str);
            if (WbFaceLiveImpl.this.f40838d == 0) {
                KycWaSDK.getInstance().trackIMSWarnVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_network_error", ((Object) errType) + "," + i10 + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + str, null);
            } else {
                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_retry", "retry=" + WbFaceLiveImpl.this.f40838d + ((Object) errType) + "," + i10 + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + str, null);
            }
            if (errType == WeReq.ErrType.NETWORK) {
                WLogger.d("WbFaceLiveImpl", "check is need retry");
                int ae2 = WbFaceLiveImpl.this.f40836b.e().ae();
                WLogger.d("WbFaceLiveImpl", "total=" + ae2 + ",cur=" + WbFaceLiveImpl.this.f40838d);
                if (!WbFaceLiveImpl.this.f40840f && ae2 > 0 && WbFaceLiveImpl.this.f40838d < ae2) {
                    if (WbFaceLiveImpl.this.f40843i != null) {
                        WLogger.d("WbFaceLiveImpl", "need retry");
                        WbFaceLiveImpl.h(WbFaceLiveImpl.this);
                        WbFaceLiveImpl.this.f40843i.onUiNetworkRetryTip();
                        WbFaceLiveImpl.this.a(this.f40855a, this.f40856b, this.f40857c, this.f40858d, this.f40859e, this.f40860f);
                        return;
                    }
                    return;
                }
            }
            WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainCompareNetwork, WbFaceError.WBFaceErrorCodeCompareNetworkError, "网络异常", "code=" + i10 + "msg=" + str));
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        public void onFinish() {
            WLogger.d("WbFaceLiveImpl", "upload onFinish!need delete video.");
            WeMediaManager.getInstance().resetVideoByte();
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        public void onStart(WeReq weReq) {
            if (WbFaceLiveImpl.this.f40838d == 0) {
                WLogger.d("WbFaceLiveImpl", "first compareRequest begin");
                final long ag = WbFaceLiveImpl.this.f40836b.e().ag();
                WbFaceLiveImpl.this.f40841g = new CloudFaceCountDownTimer(ag, ag / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.4.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onFinish() {
                        long j10;
                        WLogger.d("WbFaceLiveImpl", "queryCdt finished!");
                        if (WbFaceLiveImpl.this.f40840f) {
                            return;
                        }
                        WLogger.d("WbFaceLiveImpl", "first compareRequest didnt finished,start query");
                        TimerTask timerTask = new TimerTask() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.4.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                Message message = new Message();
                                message.what = 1;
                                WbFaceLiveImpl.this.f40844j.sendMessage(message);
                            }
                        };
                        long j11 = ag;
                        if (j11 <= 0) {
                            WLogger.d("WbFaceLiveImpl", "Illegal period,use default.");
                            j10 = 4000;
                        } else {
                            j10 = j11;
                        }
                        WbFaceLiveImpl.this.f40842h.scheduleAtFixedRate(timerTask, 0L, j10);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onTick(long j10) {
                    }
                }.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2) {
        return "1".equals(str2) ? str : WbFaceError.WBFaceErrorDomainSeverFailed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.f40841g;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.f40841g = null;
        }
        this.f40842h.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        if (this.f40837c == 9) {
            WLogger.d("WbFaceLiveImpl", "On finish Step,No more queryFaceResult!");
            return;
        }
        if (this.f40840f) {
            WLogger.e("WbFaceLiveImpl", "isAlreadyGetFaceResult!no more query!");
            return;
        }
        WLogger.d("WbFaceLiveImpl", "queryFaceResult");
        final String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        final boolean isUseGm = WbSecureProviders.isUseGm();
        final String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "faceCompare:");
        QueryFaceResultRequest.requestExec(this.f40836b.a(), this.f40839e, "none".equals(this.f40836b.x().k()) ? "2" : "1", generateAESKey, encryptAESKey, isUseGm, new WeReq.Callback<QueryFaceResultRequest.QueryResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.5
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeReq weReq, QueryFaceResultRequest.QueryResponse queryResponse) {
                if (WbFaceLiveImpl.this.f40840f) {
                    WLogger.d("WbFaceLiveImpl", "Already getResult,no need handle query result!");
                    return;
                }
                WLogger.d("WbFaceLiveImpl", "query onSuccess!");
                if (queryResponse == null) {
                    WLogger.i("WbFaceLiveImpl", "Query failed! baseResponse is null！");
                    return;
                }
                String str2 = isUseGm ? queryResponse.encryptBody : queryResponse.enMsg;
                if (TextUtils.isEmpty(str2)) {
                    WLogger.i("WbFaceLiveImpl", "Query failed,enMsg is null！" + queryResponse.code + "," + queryResponse.msg + "," + queryResponse.debugMsg);
                    return;
                }
                try {
                    QueryResult queryResult = (QueryResult) WbCloudNetSecurityManger.decry(isUseGm, str2, QueryResult.class, generateAESKey);
                    WLogger.i("WbFaceLiveImpl", "Query success!" + queryResult.toString());
                    String valueOf = String.valueOf(queryResult.code);
                    if (TextUtils.isEmpty(valueOf)) {
                        WLogger.e("WbFaceLiveImpl", "Query failed! resultCode is null!");
                        return;
                    }
                    if ("66660011".equals(valueOf)) {
                        if (!"66660018".equals(str)) {
                            WLogger.w("WbFaceLiveImpl", "query no result;Go on RETRY!");
                            return;
                        } else {
                            KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_server_error", "51100+FACEID_INVALID+QUERY_NO_RESULT", null);
                            WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainCompareNetwork, WbFaceError.WBFaceErrorCodeCompareNetworkError, "网络异常", "Query response error!"));
                            return;
                        }
                    }
                    String str3 = "1".equals(queryResult.retry) ? "1" : "0";
                    String str4 = queryResult.liveRate;
                    String str5 = queryResult.similarity;
                    String str6 = TextUtils.isEmpty(str4) ? "分数为空" : str4;
                    String str7 = TextUtils.isEmpty(str5) ? "分数为空" : str5;
                    String str8 = queryResult.isRecorded;
                    if ("0".equals(valueOf)) {
                        WLogger.i("WbFaceLiveImpl", "verify success!");
                        KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_query_response", "0", null);
                        WbFaceLiveImpl.this.a(true, new FaceWillResult(valueOf, queryResult.msg, str7, str6, str3, queryResult.riskInfo, queryResult.sign, str8), (WbFaceInnerError) null);
                    } else {
                        WLogger.i("WbFaceLiveImpl", "verify failed!");
                        KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_upload_query_response", valueOf, null);
                        String a10 = WbFaceLiveImpl.this.a(WbFaceError.WBFaceErrorDomainCompareServer, str8);
                        String str9 = queryResult.msg;
                        WbFaceLiveImpl.this.a(false, (FaceWillResult) null, WbFaceInnerError.create(a10, valueOf, str9, str9, str7, str6, str3, queryResult.riskInfo, queryResult.sign, str8));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    WLogger.w("WbFaceLiveImpl", "Query Result decry failed！" + e2.toString());
                    Properties properties = new Properties();
                    properties.setProperty("enKey", encryptAESKey);
                    KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "faceservice_data_serialize_decry_fail", "Query Result decry failed！ " + e2.toString(), properties);
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str2, IOException iOException) {
                WLogger.e("WbFaceLiveImpl", "query failed:" + ((Object) errType) + ",code=" + i10 + ",s=" + str2);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
            }
        });
        this.f40839e++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10, FaceWillResult faceWillResult, WbFaceInnerError wbFaceInnerError) {
        if (this.f40840f) {
            WLogger.d("WbFaceLiveImpl", "Already getResult,no more endLoading!");
            return;
        }
        WLogger.d("WbFaceLiveImpl", "endLoading:" + this.f40840f);
        this.f40840f = true;
        WLogger.d("WbFaceLiveImpl", "isGetFaceResult =" + this.f40840f);
        a();
        ProcessCallback<FaceWillResult> processCallback = this.f40843i;
        if (processCallback != null) {
            if (z10) {
                processCallback.onSuccess(faceWillResult);
            } else {
                processCallback.onFailed(wbFaceInnerError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, byte[] bArr2, String str, String str2, String str3, FlashReq flashReq) {
        if (this.f40838d != 0 && this.f40840f) {
            WLogger.e("WbFaceLiveImpl", "isAlreadyGetFaceResult!no more upload!");
            return;
        }
        WLogger.d("WbFaceLiveImpl", "startNetworkUpload");
        String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        boolean isUseGm = WbSecureProviders.isUseGm();
        String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "faceCompare:");
        GetGradeFaceCompareResult.requestExec(this.f40836b.a(), generateAESKey, encryptAESKey, isUseGm, bArr, bArr2, str, str2, str3, flashReq, this.f40838d, new AnonymousClass4(bArr, bArr2, str, str2, str3, flashReq, isUseGm, generateAESKey, encryptAESKey));
    }

    public static /* synthetic */ int h(WbFaceLiveImpl wbFaceLiveImpl) {
        int i10 = wbFaceLiveImpl.f40838d;
        wbFaceLiveImpl.f40838d = i10 + 1;
        return i10;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void getFaceResource(boolean z10, String str, final ProcessCallback<WbFaceWillRes> processCallback) {
        SelectData selectData = new SelectData(Float.valueOf(str).floatValue());
        WLogger.d("WbFaceLiveImpl", "selectData=" + selectData.toString());
        final String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        final boolean isUseGm = WbSecureProviders.isUseGm();
        final String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(isUseGm, generateAESKey, "getActRes:");
        KycWaSDK.getInstance().trackCustomKVEvent(this.f40835a, "facepage_get_flash_res", null, null);
        GetFaceActiveCompareType.requestExec(this.f40836b.a(), generateAESKey, encryptAESKey, isUseGm, Param.getGradeCompareType(), selectData, new BaseCallback<GetFaceActiveCompareType.GetFaceCompareTypeResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.3
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeReq weReq, GetFaceActiveCompareType.GetFaceCompareTypeResponse getFaceCompareTypeResponse) {
                if (getFaceCompareTypeResponse == null) {
                    WLogger.w("WbFaceLiveImpl", "baseResponse is null!");
                    KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_get_flash_res_server_error", "baseResponse is null!", null);
                    processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, WbFaceLiveImpl.this.f40836b.f().kyc_get_error, "baseResponse is null!"));
                    return;
                }
                String str2 = isUseGm ? getFaceCompareTypeResponse.encryptBody : getFaceCompareTypeResponse.enMsg;
                if (TextUtils.isEmpty(str2)) {
                    WLogger.w("WbFaceLiveImpl", "enMsg is null!" + getFaceCompareTypeResponse.code + "," + getFaceCompareTypeResponse.msg + "," + getFaceCompareTypeResponse.debugMsg);
                    KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_get_flash_res_server_error", "enMsg is null!" + getFaceCompareTypeResponse.code + "," + getFaceCompareTypeResponse.msg + "," + getFaceCompareTypeResponse.debugMsg, null);
                    processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, WbFaceLiveImpl.this.f40836b.f().kyc_get_error, "enMsg is null!" + getFaceCompareTypeResponse.code + "," + getFaceCompareTypeResponse.msg + "," + getFaceCompareTypeResponse.debugMsg));
                    return;
                }
                WLogger.d("WbFaceLiveImpl", "start decry response");
                try {
                    GetActResult getActResult = (GetActResult) WbCloudNetSecurityManger.decry(isUseGm, str2, GetActResult.class, generateAESKey);
                    if (getActResult != null) {
                        WLogger.d("WbFaceLiveImpl", getActResult.toString());
                        if (TextUtils.isEmpty(getActResult.code)) {
                            WLogger.w("WbFaceLiveImpl", "code is null!");
                            KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_get_flash_res_server_error", "code is null!" + getActResult.msg, null);
                            processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, WbFaceLiveImpl.this.f40836b.f().kyc_get_error, "code is null!" + getActResult.msg));
                            return;
                        }
                        if (!getActResult.code.equals("0")) {
                            WLogger.w("WbFaceLiveImpl", "code:" + getActResult.code + "; Msg: " + getActResult.msg);
                            KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_get_flash_res_server_error", "code:" + getActResult.code + "; Msg: " + getActResult.msg, null);
                            processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, getActResult.code, WbFaceLiveImpl.this.f40836b.f().kyc_get_error, getActResult.msg));
                            return;
                        }
                        if (WbFaceLiveImpl.this.f40836b.x().N().contains("2")) {
                            if (TextUtils.isEmpty(getActResult.activeType)) {
                                WLogger.w("WbFaceLiveImpl", "act mode but no activeType!");
                                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_get_flash_res_server_error", "act mode but no activeType!" + getActResult.msg, null);
                                processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, WbFaceLiveImpl.this.f40836b.f().kyc_get_error, "act mode but no activeType!" + getActResult.msg));
                                return;
                            }
                            WLogger.d("WbFaceLiveImpl", "getFlashRes result.activeType=" + getActResult.activeType);
                            WbFaceLiveImpl.this.f40836b.x().k(getActResult.activeType);
                        }
                        if (WbFaceLiveImpl.this.f40836b.x().N().contains("3")) {
                            if (TextUtils.isEmpty(getActResult.colorData)) {
                                WLogger.w("WbFaceLiveImpl", "light mode but no colorData!");
                                KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_get_flash_res_server_error", "light mode but no colorData!" + getActResult.msg, null);
                                processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeGetInfoServerError, WbFaceLiveImpl.this.f40836b.f().kyc_get_error, "light mode but no colorData!" + getActResult.msg));
                                return;
                            }
                            WLogger.d("WbFaceLiveImpl", "getFlashRes set result.colordata");
                            WbFaceLiveImpl.this.f40836b.x().j(getActResult.colorData);
                        }
                        KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "facepage_get_flash_res_success", null, null);
                        processCallback.onSuccess(null);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    WLogger.w("WbFaceLiveImpl", "decry failed!" + e2.toString());
                    Properties properties = new Properties();
                    properties.setProperty("enKey", encryptAESKey);
                    KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "faceservice_data_serialize_decry_fail", "decry GetActType failed!" + e2.toString(), properties);
                    processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoServer, WbFaceError.WBFaceErrorCodeDataSerilizerError, WbFaceLiveImpl.this.f40836b.f().kyc_get_error, "decry GetActType failed!" + e2.toString()));
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str2, IOException iOException) {
                WLogger.w("WbFaceLiveImpl", "getflashresourceEn onfail：" + ((Object) errType) + ";" + i10 + ";" + str2);
                KycWaSDK.getInstance().trackIMSWarnVEvent(WbFaceLiveImpl.this.f40835a, "facepage_get_flash_res_network_error", "getflashresourceEn onfail：" + ((Object) errType) + ";" + i10 + ";" + str2, null);
                processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainGetInfoNetwork, WbFaceError.WBFaceErrorCodeGetInfoNetworkError, WbFaceLiveImpl.this.f40836b.f().kyc_internet_check, ((Object) errType) + "," + i10 + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + str2));
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void getFaceResult(int i10, byte[] bArr, byte[] bArr2, String str, String str2, String str3, FlashReq flashReq, String str4, String str5, String str6, String str7, String str8, ProcessCallback<FaceWillResult> processCallback) {
        this.f40843i = processCallback;
        a(bArr, bArr2, str, str2, str3, flashReq);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public PermissionInfo getPermissionList() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.addPermission("android.permission.CAMERA", new PermissionInfo.PermissionTip(this.f40836b.f().kyc_camera_open_ios, this.f40836b.f().kyc_camera_setup_ios, this.f40836b.f().kyc_camera_setup_android, "用户没有授权相机权限"));
        return permissionInfo;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public int getProtocolImgSrc() {
        return R.mipmap.wbcf_protocal_b;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void login(String str, String str2, long j10, final ProcessCallback<LoginResult> processCallback) {
        String userId = Param.getUserId();
        final String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        final String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(false, generateAESKey, "login:");
        String str3 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getLoginPath(false) + "?app_id=" + Param.getAppId() + "&version=" + Param.getVersion(false) + "&nonce=" + str + "&user_id=" + userId + "&sign=" + str2;
        WLogger.d("WbFaceLiveImpl", "start login request.");
        LoginRequest.requestExec(this.f40836b.a(), str3, j10, generateAESKey, encryptAESKey, false, new WeReq.Callback<LoginRequest.LoginResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceLiveImpl.2
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeReq weReq, LoginRequest.LoginResponse loginResponse) {
                ProcessCallback processCallback2;
                String str4;
                String str5;
                ProcessCallback processCallback3;
                WLogger.d("WbFaceLiveImpl", "login onSuccess");
                String str6 = WbFaceError.WBFaceErrorCodeLoginServerError;
                if (loginResponse != null) {
                    String str7 = loginResponse.enMsg;
                    if (TextUtils.isEmpty(str7)) {
                        WLogger.w("WbFaceLiveImpl", "enMsg is null!" + loginResponse.code + "," + loginResponse.msg + "," + loginResponse.debugMsg);
                        processCallback2 = processCallback;
                        str4 = "enMsg is null!" + loginResponse.code + "," + loginResponse.msg + "," + loginResponse.debugMsg;
                    } else {
                        WLogger.d("WbFaceLiveImpl", "start decry response");
                        try {
                            LoginResult loginResult = (LoginResult) WbCloudNetSecurityManger.decry(false, str7, LoginResult.class, generateAESKey);
                            if (loginResult != null) {
                                WLogger.d("WbFaceLiveImpl", loginResult.toString());
                                if (TextUtils.isEmpty(loginResult.code)) {
                                    str5 = "code is null!";
                                } else {
                                    if (!loginResult.code.equals("0")) {
                                        WLogger.w("WbFaceLiveImpl", "code:" + loginResult.code + "; Msg: " + loginResult.msg);
                                        processCallback3 = processCallback;
                                        str6 = loginResult.code;
                                        str5 = loginResult.code + "," + loginResult.msg;
                                        processCallback3.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginServer, str6, "网络异常", str5));
                                        return;
                                    }
                                    if (TextUtils.isEmpty(loginResult.gradeCompareType)) {
                                        str4 = "gradeCompareType is null!";
                                    } else {
                                        Param.setGradeCompareType(loginResult.gradeCompareType);
                                        KycWaSDK.getInstance().updateFiled_y("field_y_0", loginResult.gradeCompareType);
                                        if (TextUtils.isEmpty(loginResult.optimalGradeType)) {
                                            str4 = "optimalGradeType is null!";
                                        } else {
                                            String str8 = loginResult.csrfToken;
                                            if (str8 != null) {
                                                Param.setCsrfToken(str8);
                                                processCallback.onSuccess(loginResult);
                                                return;
                                            }
                                            str5 = "csrfToken is null!";
                                        }
                                    }
                                }
                                WLogger.w("WbFaceLiveImpl", str5);
                                processCallback3 = processCallback;
                                processCallback3.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginServer, str6, "网络异常", str5));
                                return;
                            }
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            WLogger.w("WbFaceLiveImpl", "decry LoginResult failed!" + e2.toString());
                            Properties properties = new Properties();
                            properties.setProperty("enKey", encryptAESKey);
                            KycWaSDK.getInstance().trackCustomKVEvent(WbFaceLiveImpl.this.f40835a, "faceservice_data_serialize_decry_fail", "decry LoginResult failed!" + e2.toString(), properties);
                            processCallback2 = processCallback;
                            str4 = "decry LoginResult failed!" + e2.toString();
                            str6 = WbFaceError.WBFaceErrorCodeDataSerilizerError;
                        }
                    }
                    processCallback2.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginServer, str6, "网络异常", str4));
                }
                str4 = "baseResponse is null!";
                WLogger.w("WbFaceLiveImpl", str4);
                processCallback2 = processCallback;
                processCallback2.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginServer, str6, "网络异常", str4));
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str4, IOException iOException) {
                WLogger.e("WbFaceLiveImpl", "LoginRequest failed! type=" + ((Object) errType) + ",code=" + i10 + ",msg=" + str4);
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) errType);
                sb2.append(",");
                sb2.append(i10);
                sb2.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb2.append(str4);
                processCallback.onFailed(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainLoginNetwork, WbFaceError.WBFaceErrorCodeLoginNetworkError, "网络异常", sb2.toString()));
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onEnterFaceLivePage(WbUiTips wbUiTips) {
        WLogger.d("WbFaceLiveImpl", "onEnterFaceLivePage:" + this.f40840f);
        this.f40840f = false;
        WLogger.d("WbFaceLiveImpl", "isGetFaceResult =" + this.f40840f);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onFaceStatusChanged(int i10) {
        this.f40837c = i10;
        if (i10 == 2) {
            this.f40842h.reset();
        } else if (i10 == 9) {
            a();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onPreviewFrame(byte[] bArr) {
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onQuitFaceLivePage() {
        WLogger.d("WbFaceLiveImpl", "onQuitFaceLivePage:" + this.f40840f);
        this.f40840f = true;
        WLogger.d("WbFaceLiveImpl", "isGetFaceResult =" + this.f40840f);
        this.f40843i = null;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void onStartFaceVerify(Context context) {
        this.f40835a = context;
        this.f40836b = d.z();
        this.f40838d = 0;
        this.f40839e = 0;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void startWill(FragmentManager fragmentManager, int i10, WillParam willParam, WbWillVideoEncodeFinishCallback wbWillVideoEncodeFinishCallback, WbWillFinishCallback wbWillFinishCallback, WbWillProcessCallback wbWillProcessCallback) {
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void stopWill(FragmentManager fragmentManager) {
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeInterface
    public void uploadFaceWillVideo(int i10, String str, String str2, ProcessCallback processCallback) {
    }
}
