package com.alibaba.security.realidentity.business.start;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DataBean implements Serializable {
    private ExtrasBean extras;
    private UploadToken ossUploadToken;
    private List<StepsBean> steps;
    private Map<String, String> verifyConf;

    public ExtrasBean getExtras() {
        return this.extras;
    }

    public UploadToken getOssUploadToken() {
        return this.ossUploadToken;
    }

    public List<StepsBean> getSteps() {
        return this.steps;
    }

    public Map<String, String> getVerifyConf() {
        return this.verifyConf;
    }

    public void setExtras(ExtrasBean extrasBean) {
        this.extras = extrasBean;
    }

    public void setOssUploadToken(UploadToken uploadToken) {
        this.ossUploadToken = uploadToken;
    }

    public void setSteps(List<StepsBean> list) {
        this.steps = list;
    }

    public void setVerifyConf(Map<String, String> map) {
        this.verifyConf = map;
    }
}
