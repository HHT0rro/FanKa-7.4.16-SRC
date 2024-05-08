package com.huawei.appgallery.agd.serverreq.bean.startup;

import android.text.TextUtils;
import com.huawei.appgallery.agd.serverreq.bean.BaseResponseBean;
import com.huawei.appgallery.agd.serverreq.store.SignSession;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class StartupResponse extends BaseResponseBean {
    public static final int MUST_LOGIN = 1;
    public static final int SUCCESS = 0;
    public static final int SUPPORT = 1;
    private String serviceZone_;
    private String sign_;
    private int mLogin_ = 1;
    private int isServiceZone_ = 1;

    public StartupResponse() {
        setRtnCode_(1);
    }

    public int getIsServiceZone_() {
        return this.isServiceZone_;
    }

    public String getServiceZone_() {
        return this.serviceZone_;
    }

    public String getSign_() {
        return this.sign_;
    }

    public int getmLogin_() {
        return this.mLogin_;
    }

    public void saveParams(StartupRequest startupRequest) {
        if (TextUtils.isEmpty(getSign_())) {
            return;
        }
        SignSession.getInstance().setSign(getSign_(), startupRequest.getAccountZone_(), startupRequest.getDeviceId_(), startupRequest.getLocale_());
    }
}
