package com.alibaba.security.realidentity.business.start;

import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.r;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StartHttpParams extends AbsStartHttpParams {
    public List<ActionInfo> mActionDetail;
    public StepsBean mActionStepBean;
    private StartHttpResponse mStartHttpResponse;
    private SensorInfo sensorInfo;

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        return new BusinessHttpWrapper(StartHttpResponse.class, new BusinessRequest(StartHttpRequest.class, new StartHttpRequest(this.mVerifyToken)));
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(r rVar) {
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        StartHttpResponse startHttpResponse = this.mStartHttpResponse;
        if (startHttpResponse == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", "start api fail, response is null", GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
        }
        if (startHttpResponse.isSuccessful()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "start api success", 0);
        }
        if (this.mStartHttpResponse.isRepeatedSubmitted()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "the verification has passed", 0);
        }
        String str = this.mStartHttpResponse.Code;
        if (!TextUtils.isEmpty(str) && str.equals("InvalidTimeStamp.Expired")) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10413", "invalid_timestamp_expired", GlobalErrorCode.ERROR_INVALID_TIMESTAMP_EXPIRED);
        }
        int code = this.mStartHttpResponse.getCode();
        return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, String.valueOf(code), this.mStartHttpResponse.getMsg(), code);
    }

    public void setSensorInfo(SensorInfo sensorInfo) {
        this.sensorInfo = sensorInfo;
    }

    @Override // com.alibaba.security.realidentity.business.start.AbsStartHttpParams, com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public StartHttpParams doTransform(HttpResponse httpResponse) {
        if (httpResponse instanceof StartHttpResponse) {
            StartHttpResponse startHttpResponse = (StartHttpResponse) httpResponse;
            this.mStartHttpResponse = startHttpResponse;
            DataBean data = startHttpResponse.getData();
            this.mNeedActionImage = true;
            this.mNeedGaze = false;
            this.mVerifyDowngradConfig = data == null ? null : data.getVerifyConf();
            if (data != null) {
                for (StepsBean stepsBean : data.getSteps()) {
                    if (stepsBean.getName() != null) {
                        if ("GUIDE".equals(stepsBean.getName())) {
                            this.mShowNav = true;
                        }
                        if ("PRIVACY".equals(stepsBean.getName())) {
                            this.mShowPrivacy = true;
                        }
                        if ("FACE_LIVENESS".equals(stepsBean.getName())) {
                            StepsExtras extras = stepsBean.getExtras();
                            this.mActionStepBean = stepsBean;
                            this.mNeedGaze = extras.isNeedGaze();
                            this.mNeedActionImage = extras.isNeedActionImage();
                            this.mLivenessConfig = extras.getLivenessConfig();
                            this.mActionDetail = extras.getActionDetailList();
                            try {
                                if (!TextUtils.isEmpty(extras.getActionCount())) {
                                    this.mActionCount = Integer.parseInt(extras.getActionCount());
                                }
                            } catch (Exception unused) {
                                this.mActionCount = 0;
                            }
                        }
                        if ("RESULT".equals(stepsBean.getName())) {
                            this.mShowResult = true;
                        }
                    }
                }
                this.mExtrasBean = data.getExtras();
                this.mUploadToken = data.getOssUploadToken();
            }
        }
        return this;
    }
}
