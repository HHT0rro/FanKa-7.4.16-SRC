package com.alibaba.security.realidentity.business.biometrics;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.ALBiometricsNavigator;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.model.RequestType;
import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AbsBiometricsBucketParams extends BucketParams {
    public ALBiometricsCallBackBean biometricsCallBackBean;
    public ALBiometricsNavigator biometricsNavigator;
    public ALBiometricsResult biometricsResult;
    public boolean isLimited;
    public boolean isNeedBioResultPage = false;
    public boolean bCalledFinishSuccessfully = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ALBiometricsCallBackBean implements Serializable {
        public int errorCode;
        public String errorMsg;
        public boolean isSuccessful = false;
    }

    public ALBiometricsResult getBiometricsResult() {
        return this.biometricsResult;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        return null;
    }

    public boolean isCalledFinishSuccessfully() {
        return this.bCalledFinishSuccessfully;
    }

    public boolean parseBeautySwitch(Map<String, String> map) {
        Map map2;
        if (map == null || map.isEmpty()) {
            return true;
        }
        String str = map.get("rpsdkBiometricsBeautyEffect");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            map2 = (Map) JsonUtils.parseObject(str, Map.class);
        } catch (Exception unused) {
        }
        if (map2 == null || map2.isEmpty() || !map2.containsKey("closeBeautyEffect")) {
            return false;
        }
        return Integer.parseInt(map2.get("closeBeautyEffect").toString()) != 1;
    }

    public boolean parseCamera2Config(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str = map.get("rpCamera2Close");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (Integer.valueOf(str).intValue() != 0) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean parseCameraPreviewConfig(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str = map.get("rpCameraPreview");
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                return Integer.parseInt(str) != 0;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public boolean parseDazzleCollectSwitch(Map<String, String> map) {
        Map map2;
        if (map == null || map.isEmpty()) {
            return true;
        }
        String str = map.get("rpsdkBiometricsColorfulBio");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            map2 = (Map) JsonUtils.parseObject(str, Map.class);
        } catch (Exception unused) {
        }
        if (map2 == null || map2.isEmpty() || !map2.containsKey("closeColorfulBio")) {
            return false;
        }
        return Integer.parseInt(map2.get("closeColorfulBio").toString()) != 1;
    }

    public RequestType parseNetRequestConfig(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str = map.get("rpHttpRequestType");
            if (TextUtils.isEmpty(str)) {
                return RequestType.OK_HTTP;
            }
            try {
                Map map2 = (Map) JsonUtils.parseObject(str, Map.class);
                if (map2 != null && !map2.isEmpty()) {
                    if (!map2.containsKey("netRequestType")) {
                        return RequestType.OK_HTTP;
                    }
                    return RequestType.create(Integer.parseInt(map2.get("netRequestType").toString()));
                }
                return RequestType.OK_HTTP;
            } catch (Exception unused) {
                return RequestType.OK_HTTP;
            }
        }
        return RequestType.OK_HTTP;
    }

    public void riskEvent(Context context, OnRetryListener onRetryListener, String str, String str2, String str3) {
    }

    public void setAlBiometricsResult(ALBiometricsResult aLBiometricsResult) {
        this.biometricsResult = aLBiometricsResult;
    }

    public void setBiometricsCallBackBean(ALBiometricsCallBackBean aLBiometricsCallBackBean) {
        this.biometricsCallBackBean = aLBiometricsCallBackBean;
    }

    public void setCalledFinishSuccessfully(boolean z10) {
        this.bCalledFinishSuccessfully = z10;
    }
}
