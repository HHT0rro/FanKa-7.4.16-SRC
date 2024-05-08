package com.alibaba.security.common.track.model;

import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.aq;
import com.alipay.sdk.util.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TrackLog implements Serializable {
    private String layer;
    private String method;
    private String msg;
    private String params;
    private String result;
    private String service;
    private List<String> tags;
    private String verifyToken;
    private int code = 0;
    private long ts = System.currentTimeMillis();
    private long rt = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Code {
        public static final int CLIENT_ERROR = -1;
        public static final int SERVICE_ERROR = -2;
        public static final int SUCCESS = 0;
    }

    public static TrackLog create(String str, String str2, String str3, String str4, String str5, String str6) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = str;
        trackLog.service = str2;
        trackLog.method = str3;
        trackLog.msg = str4;
        trackLog.params = str5;
        trackLog.result = str6;
        return trackLog;
    }

    public static TrackLog createBioActivityEnterLog(String str, String str2) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.ENTER);
        trackLog.setParams(str);
        trackLog.setMsg(str2);
        return trackLog;
    }

    public static TrackLog createBioActivityExitLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod("exit");
        trackLog.setMsg(str);
        return trackLog;
    }

    public static TrackLog createBioDazzleCollectLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.COLORFUL_BIO);
        return trackLog;
    }

    public static TrackLog createBioGuidePageLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.GUIDE_PAGE);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createBioMonitorAlgoStartLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.ALGO_START);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createBioMonitorExpLog(int i10, String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod("exception");
        trackLog.addTag1(String.valueOf(i10));
        trackLog.setMsg(str);
        return trackLog;
    }

    public static TrackLog createBioMonitorStartLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod("start");
        return trackLog;
    }

    public static TrackLog createBioMonitorUploadFinishLog(CommonTrackResult commonTrackResult, boolean z10, long j10) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.UPLOAD_FINISH);
        trackLog.setResult(JsonUtils.toJSON(commonTrackResult));
        trackLog.setCode(z10 ? 0 : -1);
        trackLog.setRt(j10);
        return trackLog;
    }

    public static TrackLog createBioMonitorUploadStartLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.UPLOAD_START);
        return trackLog;
    }

    public static TrackLog createBioPrivacyPageLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.PRIVACY_PAGE);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createCtidAppEndLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "identity";
        trackLog.method = TrackConstants.Method.INVOKE_CTID_APP_END;
        trackLog.result = str;
        return trackLog;
    }

    public static TrackLog createCtidAppStartLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "identity";
        trackLog.method = TrackConstants.Method.INVOKE_CTID_APP_BEGIN;
        trackLog.params = str;
        return trackLog;
    }

    public static TrackLog createDynamicBegin(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "identity";
        trackLog.method = TrackConstants.Method.DYNAMIC_API_BEGIN;
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createDynamicEnd(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "identity";
        trackLog.method = TrackConstants.Method.DYNAMIC_API_END;
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createDynamicInterruptLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = TrackConstants.Service.BIOMETRICS;
        trackLog.method = TrackConstants.Method.DYNAMIC_REQUEST_INTERRUPT;
        return trackLog;
    }

    public static TrackLog createFinishCameraParametersLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.CAMERA_FINISH);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createHttpRequestLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "identity";
        trackLog.method = TrackConstants.Method.HTTP_REQUEST;
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = "";
        return trackLog;
    }

    public static TrackLog createHttpUrlConnectionLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "exception";
        trackLog.method = TrackConstants.Method.HTTP_URL_CONNECTION;
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = "";
        return trackLog;
    }

    public static TrackLog createNetWorkCostMonitor(String str, long j10, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("api", str);
        hashMap.put("costTime", Long.valueOf(j10));
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.NETWORK);
        trackLog.setMethod("costTime");
        trackLog.setRt(j10);
        trackLog.setMsg(str2);
        trackLog.setParams(JsonUtils.toJSON(hashMap));
        return trackLog;
    }

    public static TrackLog createOssUploadFileBeginLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "identity";
        trackLog.method = TrackConstants.Method.UPLOAD_FILE_API_BEGIN;
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = "";
        return trackLog;
    }

    public static TrackLog createOssUploadFileEndLog(String str, String str2, long j10) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "identity";
        trackLog.method = TrackConstants.Method.UPLOAD_FILE_API_END;
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = str2;
        trackLog.setRt(j10);
        return trackLog;
    }

    public static TrackLog createRPOkHttpConnectionExpLog(String str, String str2) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "exception";
        trackLog.method = TrackConstants.Method.HTTP_RP_OK;
        trackLog.msg = str;
        trackLog.result = str2;
        return trackLog;
    }

    public static TrackLog createSdkCrashLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "crash";
        trackLog.method = "crash";
        trackLog.params = str;
        return trackLog;
    }

    public static TrackLog createSdkExceptionLog(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "exception";
        trackLog.method = "exception";
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createSdkLoadingEnterLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = TrackConstants.Service.BIOMETRICS;
        trackLog.method = TrackConstants.Method.LOADING_PAGE_START;
        trackLog.params = str;
        return trackLog;
    }

    public static TrackLog createSdkLoadingExitLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = TrackConstants.Service.BIOMETRICS;
        trackLog.method = TrackConstants.Method.LOADING_PAGE_END;
        return trackLog;
    }

    public static TrackLog createSdkWebViewEnterLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "webview";
        trackLog.method = TrackConstants.Method.ENTER;
        trackLog.params = str;
        return trackLog;
    }

    public static TrackLog createSdkWebViewErrorLog(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "webview";
        trackLog.method = "error";
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createSdkWebViewExitLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "webview";
        trackLog.method = "exit";
        return trackLog;
    }

    public static TrackLog createSdkWebViewLoadLog(String str, String str2, String str3) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "webview";
        trackLog.method = TrackConstants.Method.LOAD;
        trackLog.msg = str;
        trackLog.params = str2;
        trackLog.result = str3;
        return trackLog;
    }

    public static TrackLog createSimpleSdk(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("class", str);
        hashMap.put("method", str2);
        hashMap.put("extras", str3);
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = TrackConstants.Service.RP_TEST_LOG;
        trackLog.method = "";
        trackLog.msg = "";
        trackLog.params = JsonUtils.toJSON(hashMap);
        trackLog.result = "";
        return trackLog;
    }

    public static TrackLog createSoundClickLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = TrackConstants.Service.BIOMETRICS;
        trackLog.method = TrackConstants.Method.SOUND_SWITCH;
        trackLog.msg = "";
        trackLog.params = str;
        trackLog.result = "";
        return trackLog;
    }

    public static TrackLog createStartBeginLog(String str, String str2, boolean z10) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService("identity");
        trackLog.setMethod(TrackConstants.Method.START_BEGIN);
        HashMap hashMap = new HashMap();
        hashMap.put("startType", str);
        hashMap.put("fromSouce", str2);
        hashMap.put("isCustomUi", Integer.valueOf(z10 ? 1 : 0));
        trackLog.setParams(JsonUtils.toJsonString(hashMap));
        trackLog.setMsg("call start");
        trackLog.setResult("");
        trackLog.addTag1(str);
        return trackLog;
    }

    public static TrackLog createStartCameraParametersLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.CAMERA_START);
        trackLog.setParams(str);
        return trackLog;
    }

    public static TrackLog createStartEndLog(String str, String str2, long j10, String str3, String str4) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService("identity");
        trackLog.setMethod(TrackConstants.Method.START_END);
        trackLog.setParams("{\"startType\":" + str + i.f4738d);
        trackLog.setMsg(str2);
        HashMap hashMap = new HashMap();
        hashMap.put(aq.f3103ac, RPTrack.getLastStepTrackMsg());
        trackLog.setResult(JsonUtils.toJSON(hashMap));
        trackLog.setRt(System.currentTimeMillis() - j10);
        trackLog.addTag1(str);
        trackLog.addTag2(str3);
        trackLog.addTag3(str4);
        return trackLog;
    }

    public static TrackLog createStartInterruptLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = TrackConstants.Service.BIOMETRICS;
        trackLog.method = TrackConstants.Method.START_REQUEST_INTERRUPT;
        return trackLog;
    }

    public static TrackLog createTakePhotoFinishLog(CommonTrackResult commonTrackResult, boolean z10) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService("takePhoto");
        trackLog.setMethod("finish");
        trackLog.setResult(JsonUtils.toJSON(commonTrackResult));
        trackLog.setCode(z10 ? 0 : -1);
        return trackLog;
    }

    public static TrackLog createTakePhotoStartLog() {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService("takePhoto");
        trackLog.setMethod("start");
        return trackLog;
    }

    public static TrackLog createTakePhotoUploadLog(CommonTrackResult commonTrackResult) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService("takePhoto");
        trackLog.setMethod(TrackConstants.Method.UPLOAD_FINISH);
        return trackLog;
    }

    public static TrackLog createVmEncryptLog(int i10, String str, String str2) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "identity";
        trackLog.method = TrackConstants.Method.VM_ENCRYPT;
        trackLog.code = i10;
        trackLog.msg = str;
        trackLog.result = str2;
        return trackLog;
    }

    private void initTags() {
        if (this.tags == null) {
            ArrayList arrayList = new ArrayList(10);
            this.tags = arrayList;
            arrayList.addAll(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
        }
    }

    public void addTag1(String str) {
        initTags();
        this.tags.add(0, str);
    }

    public void addTag10(String str) {
        initTags();
        this.tags.add(9, str);
    }

    public void addTag2(String str) {
        initTags();
        this.tags.add(1, str);
    }

    public void addTag3(String str) {
        initTags();
        this.tags.add(2, str);
    }

    public void addTag4(String str) {
        initTags();
        this.tags.add(3, str);
    }

    public void addTag5(String str) {
        initTags();
        this.tags.add(4, str);
    }

    public void addTag6(String str) {
        initTags();
        this.tags.add(5, str);
    }

    public void addTag7(String str) {
        initTags();
        this.tags.add(6, str);
    }

    public void addTag8(String str) {
        initTags();
        this.tags.add(7, str);
    }

    public void addTag9(String str) {
        initTags();
        this.tags.add(8, str);
    }

    public int getCode() {
        return this.code;
    }

    public String getLayer() {
        return this.layer;
    }

    public String getMethod() {
        return this.method;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getParams() {
        return this.params;
    }

    public String getResult() {
        return this.result;
    }

    public long getRt() {
        return this.rt;
    }

    public String getService() {
        return this.service;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public long getTs() {
        return this.ts;
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setLayer(String str) {
        this.layer = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setRt(long j10) {
        this.rt = j10;
    }

    public void setService(String str) {
        this.service = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setTs(long j10) {
        this.ts = j10;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }

    public static TrackLog createSdkExceptionLog(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.layer = "sdk";
        trackLog.service = "exception";
        trackLog.method = "exception";
        trackLog.msg = str;
        trackLog.params = "";
        trackLog.result = "";
        return trackLog;
    }
}
