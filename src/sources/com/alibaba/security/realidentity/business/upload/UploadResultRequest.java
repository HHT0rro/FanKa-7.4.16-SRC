package com.alibaba.security.realidentity.business.upload;

import com.alibaba.security.common.json.annotation.RPJSONField;
import com.alibaba.security.realidentity.build.a;
import com.alibaba.security.realidentity.build.c;
import com.alibaba.security.realidentity.http.BaseHttpRequest;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.Attributes;
import java.io.Serializable;
import java.util.List;

@Api(method = HttpMethod.POST, name = a.f2999e)
@Body
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UploadResultRequest extends BaseHttpRequest {

    @RPJSONField(name = "materials")
    public List<Materials> materials;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ActionLog implements Serializable {

        @RPJSONField(name = "flActionLog")
        public String bh;

        @RPJSONField(name = "sensorActionLog")
        public String sensor;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ActionType implements Serializable {

        @RPJSONField(name = u.ck)
        public String category;

        @RPJSONField(name = CardConstants.KEY_IMAGES)
        public List<String> images;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Material implements Serializable {

        @RPJSONField(name = Attributes.Style.ACTIONS)
        public List<ActionType> actions;

        @RPJSONField(name = c.f3227o)
        public String bigImageOssPath;

        @RPJSONField(name = "faceRect")
        public String faceRect;

        @RPJSONField(name = c.f3229q)
        public String globalImage;

        @RPJSONField(name = c.f3228p)
        public String localImage;

        @RPJSONField(name = "K_FACE_R_ENABLE")
        public int localRecognize;

        @RPJSONField(name = "recognizeResultScore")
        public float recognizeResultScore;

        @RPJSONField(name = "smallImageMode")
        public int smallImageModel = 1;

        @RPJSONField(name = "backgroundDetectResult")
        public String backgroundDetectResult = "";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Materials implements Serializable {

        @RPJSONField(name = u.ck)
        public String category;

        @RPJSONField(name = "material")
        public String material;
    }

    public UploadResultRequest(String str) {
        super(str);
    }
}
