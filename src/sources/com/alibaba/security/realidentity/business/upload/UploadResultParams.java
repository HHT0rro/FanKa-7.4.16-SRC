package com.alibaba.security.realidentity.business.upload;

import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.ah;
import com.alibaba.security.realidentity.build.c;
import com.alibaba.security.realidentity.build.r;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.upload.UploadResultRequest;
import com.alibaba.security.realidentity.business.uploadresult.AbsUploadResultParams;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UploadResultParams extends AbsUploadResultParams {
    private static final String[] NUMERIC_STR_ARRAY = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String TAG = "UploadResultParams";
    private ALBiometricsResult biometricsResult;
    private StartHttpParams startHttpParams;
    private UploadResultResponse uploadResultResponse;
    private List<ah> uploadTasks;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class EdgeDetectResult implements Serializable {
        public String stare = null;
        public String actionZero = null;
        public String actionOne = null;
        public String actionTwo = null;
        public String actionThree = null;
        public String actionFour = null;
        public String actionFive = null;
        public String actionSix = null;
        public String actionSeven = null;
        public String actionEight = null;
        public String actionNine = null;

        public String getActionEight() {
            return this.actionEight;
        }

        public String getActionFive() {
            return this.actionFive;
        }

        public String getActionFour() {
            return this.actionFour;
        }

        public String getActionNine() {
            return this.actionNine;
        }

        public String getActionOne() {
            return this.actionOne;
        }

        public String getActionSeven() {
            return this.actionSeven;
        }

        public String getActionSix() {
            return this.actionSix;
        }

        public String getActionThree() {
            return this.actionThree;
        }

        public String getActionTwo() {
            return this.actionTwo;
        }

        public String getActionZero() {
            return this.actionZero;
        }

        public String getStare() {
            return this.stare;
        }

        public void setActionEight(String str) {
            this.actionEight = str;
        }

        public void setActionFive(String str) {
            this.actionFive = str;
        }

        public void setActionFour(String str) {
            this.actionFour = str;
        }

        public void setActionNine(String str) {
            this.actionNine = str;
        }

        public void setActionOne(String str) {
            this.actionOne = str;
        }

        public void setActionSeven(String str) {
            this.actionSeven = str;
        }

        public void setActionSix(String str) {
            this.actionSix = str;
        }

        public void setActionThree(String str) {
            this.actionThree = str;
        }

        public void setActionTwo(String str) {
            this.actionTwo = str;
        }

        public void setActionZero(String str) {
            this.actionZero = str;
        }

        public void setStare(String str) {
            this.stare = str;
        }
    }

    private String actionStringBaseOnActionType(int i10) {
        if (i10 == 1) {
            return "BLINK";
        }
        if (i10 == 2) {
            return "MOUTH";
        }
        if (i10 == 3) {
            return "SHAKE_HEAD";
        }
        if (i10 == 4) {
            return "NOD";
        }
        switch (i10) {
            case 7:
            case 8:
                return "SHAKE_HEAD";
            case 9:
            case 10:
                return "NOD";
            case 11:
                return "KEEP_STILL";
            default:
                switch (i10) {
                    case 21:
                        return "BLINK";
                    case 22:
                        return "MOUTH";
                    case 23:
                        return "SHAKE_HEAD";
                    case 24:
                        return "NOD";
                    default:
                        return String.valueOf(i10);
                }
        }
    }

    private UploadResultRequest assemableRequest() {
        UploadResultRequest uploadResultRequest = new UploadResultRequest(this.mVerifyToken);
        ArrayList arrayList = new ArrayList();
        uploadResultRequest.materials = arrayList;
        arrayList.add(createBioResult());
        arrayList.add(createActionResult());
        return uploadResultRequest;
    }

    private UploadResultRequest.Materials createActionResult() {
        UploadResultRequest.Materials materials = new UploadResultRequest.Materials();
        UploadResultRequest.ActionLog actionLog = new UploadResultRequest.ActionLog();
        String uploadTaskPathByType = getUploadTaskPathByType(this.uploadTasks, c.f3232t);
        ALBiometricsResult aLBiometricsResult = this.biometricsResult;
        String bh = aLBiometricsResult == null ? "" : aLBiometricsResult.getBh();
        actionLog.sensor = uploadTaskPathByType;
        actionLog.bh = bh;
        materials.material = JsonUtils.toJSON(actionLog);
        materials.category = "RISK_ACTION";
        return materials;
    }

    private UploadResultRequest.Materials createBioResult() {
        UploadResultRequest.Material material = new UploadResultRequest.Material();
        if (this.biometricsResult.getRecognizeResult() == 1 || this.biometricsResult.getRecognizeResult() == 0) {
            int recognizeResult = this.biometricsResult.getRecognizeResult();
            float recognizeResultScore = this.biometricsResult.getRecognizeResultScore();
            material.localRecognize = recognizeResult;
            material.recognizeResultScore = recognizeResultScore;
        }
        material.bigImageOssPath = getUploadTaskPathByType(this.uploadTasks, c.f3227o);
        material.smallImageModel = 1;
        StartHttpParams startHttpParams = this.startHttpParams;
        if (startHttpParams != null && startHttpParams.mNeedActionImage) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.biometricsResult.getAs().size(); i10++) {
                String actionStringBaseOnActionType = actionStringBaseOnActionType(this.biometricsResult.getAs().get(i10).getAt());
                String uploadTaskPathByType = getUploadTaskPathByType(this.uploadTasks, "action".concat(String.valueOf(i10)));
                UploadResultRequest.ActionType actionType = new UploadResultRequest.ActionType();
                ArrayList arrayList2 = new ArrayList();
                actionType.images = arrayList2;
                arrayList2.add(uploadTaskPathByType);
                actionType.category = actionStringBaseOnActionType;
                arrayList.add(actionType);
            }
            material.actions = arrayList;
        }
        if (this.startHttpParams != null) {
            material.globalImage = getUploadTaskPathByType(this.uploadTasks, c.f3229q);
            material.localImage = getUploadTaskPathByType(this.uploadTasks, c.f3228p);
            int[] fr = this.biometricsResult.getQi().getFr();
            if (fr != null && fr.length == 4) {
                material.faceRect = String.format("%d,%d,%d,%d", Integer.valueOf(fr[0]), Integer.valueOf(fr[1]), Integer.valueOf(fr[2]), Integer.valueOf(fr[3]));
            }
        }
        String bgDetectResult = this.biometricsResult.getBgDetectResult();
        if (bgDetectResult != null) {
            String[] split = bgDetectResult.split(";");
            EdgeDetectResult edgeDetectResult = new EdgeDetectResult();
            for (int i11 = 0; i11 < split.length; i11++) {
                try {
                    EdgeDetectResult.class.getField(i11 == 0 ? "stare" : "action" + NUMERIC_STR_ARRAY[i11]).set(edgeDetectResult, split[i11]);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e10) {
                    e10.printStackTrace();
                }
            }
            material.backgroundDetectResult = JsonUtils.toJSON(edgeDetectResult);
        }
        UploadResultRequest.Materials materials = new UploadResultRequest.Materials();
        materials.material = JsonUtils.toJSON(material);
        materials.category = "FACE_LIVENESS";
        return materials;
    }

    private String getUploadTaskPathByType(List<ah> list, String str) {
        if (list != null && !list.isEmpty()) {
            for (ah ahVar : list) {
                if (TextUtils.equals(str, ahVar.f3021a)) {
                    return ahVar.a();
                }
            }
        }
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public HttpBucketParams doTransform(HttpResponse httpResponse) {
        if (httpResponse instanceof UploadResultResponse) {
            this.uploadResultResponse = (UploadResultResponse) httpResponse;
        }
        return this;
    }

    public ALBiometricsResult getBiometricsResult() {
        return this.biometricsResult;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        return new BusinessHttpWrapper(UploadResultResponse.class, new BusinessRequest(UploadResultRequest.class, assemableRequest()));
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(r rVar) {
        this.biometricsResult = rVar.f3970d.biometricsResult;
        this.uploadTasks = rVar.f3971e.getUploadTaskList();
        this.startHttpParams = rVar.f3969c;
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        UploadResultResponse uploadResultResponse = this.uploadResultResponse;
        if (uploadResultResponse == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", "start api fail, response is null", GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
        }
        if (uploadResultResponse.isSuccessful()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "upload result success", 0);
        }
        int code = this.uploadResultResponse.getCode();
        return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, String.valueOf(code), this.uploadResultResponse.getMsg(), code);
    }
}
