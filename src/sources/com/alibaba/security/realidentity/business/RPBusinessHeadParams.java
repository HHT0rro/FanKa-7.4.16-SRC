package com.alibaba.security.realidentity.business;

import com.alibaba.security.realidentity.bean.ClientInfo;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.start.ExtrasBean;
import com.alibaba.security.realidentity.business.start.UploadToken;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPBusinessHeadParams extends BusinessHeadParams {
    private ClientInfo clientInfo;
    private RPExtrasBean extras;
    private ExtrasBean extrasOrigin;
    private List<String> materialCategories;
    private boolean needActionImage = true;
    private boolean needGaze;
    private UploadToken ossUploadToken;
    private Map<String, String> verifyConf;
    private String verifyToken;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RPExtrasBean implements Serializable {
        private String actionCount;
        private String actionDetail;

        public String getActionCount() {
            return this.actionCount;
        }

        public String getActionDetail() {
            return this.actionDetail;
        }

        public void setActionCount(String str) {
            this.actionCount = str;
        }

        public void setActionDetail(String str) {
            this.actionDetail = str;
        }
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public RPExtrasBean getExtras() {
        return this.extras;
    }

    public ExtrasBean getExtrasOrigin() {
        return this.extrasOrigin;
    }

    public List<String> getMaterialCategories() {
        return this.materialCategories;
    }

    public UploadToken getOssUploadToken() {
        return this.ossUploadToken;
    }

    public Map<String, String> getVerifyConf() {
        return this.verifyConf;
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public boolean isNeedActionImage() {
        return this.needActionImage;
    }

    public boolean isNeedGaze() {
        return this.needGaze;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void setExtras(RPExtrasBean rPExtrasBean) {
        this.extras = rPExtrasBean;
    }

    public void setExtrasOrigin(ExtrasBean extrasBean) {
        this.extrasOrigin = extrasBean;
    }

    public void setMaterialCategories(List<String> list) {
        this.materialCategories = list;
    }

    public void setNeedActionImage(boolean z10) {
        this.needActionImage = z10;
    }

    public void setNeedGaze(boolean z10) {
        this.needGaze = z10;
    }

    public void setOssUploadToken(UploadToken uploadToken) {
        this.ossUploadToken = uploadToken;
    }

    public void setVerifyConf(Map<String, String> map) {
        this.verifyConf = map;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }
}
