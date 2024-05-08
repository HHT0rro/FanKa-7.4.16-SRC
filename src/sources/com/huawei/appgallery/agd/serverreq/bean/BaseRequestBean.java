package com.huawei.appgallery.agd.serverreq.bean;

import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.utils.DeviceSession;
import com.huawei.appgallery.agd.serverreq.AgdProperties;
import com.huawei.appgallery.agd.serverreq.json.annotation.FieldSecurity;
import com.huawei.appgallery.agd.serverreq.store.SignSession;
import com.huawei.appgallery.agd.serverreq.utils.network.NetworkUtil;
import com.huawei.appgallery.agd.serverreq.utils.os.HwDeviceIdEx;
import com.huawei.appgallery.agd.serverreq.utils.os.HwSystemProperties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BaseRequestBean extends RequestBean {
    public static final String STORE_API = "clientApi";
    public static final String TAG = "BaseRequestBean";
    private static long apsid_;
    private int deviceIdType_;

    @FieldSecurity(security = 1)
    private String deviceId_;
    public String manufacturer_;
    private String sign_;
    private int serviceType_ = AgdProperties.getServiceType().intValue();
    private String clientPackage_ = null;
    private String net_ = null;
    private String cno_ = null;
    private String ts_ = null;
    private String code_ = null;
    private String thirdId_ = null;
    private String locale_ = null;

    @FieldSecurity(security = 1)
    private String authorization_ = "";

    public BaseRequestBean() {
        this.sign_ = null;
        setStoreApi(STORE_API);
        this.sign_ = SignSession.getInstance().getSign();
        setClientPackage_(ApplicationWrapper.getInstance().getContext().getPackageName());
    }

    public static void setApsid_(long j10) {
        apsid_ = j10;
    }

    public String getDeviceId_() {
        return this.deviceId_;
    }

    public String getLocale_() {
        return this.locale_;
    }

    @Override // com.huawei.appgallery.agd.serverreq.bean.RequestBean
    public void onSetValue() {
        setTs_(String.valueOf(System.currentTimeMillis()));
        setNet_(String.valueOf(NetworkUtil.getPsType()));
        setThirdId_(DeviceSession.getSession().getThirdId());
        setCno_(AgdProperties.getCno());
        setCode_(AgdProperties.getCompressionFormatType());
        setDeviceId_(HwDeviceIdEx.getInstance().getDeviceUniqueId());
        setDeviceIdType(HwDeviceIdEx.getInstance().getDeviceIdType());
        this.manufacturer_ = HwSystemProperties.get("ro.product.manufacturer", "");
        setApsid_(System.currentTimeMillis());
    }

    public void setClientPackage_(String str) {
        this.clientPackage_ = str;
    }

    public void setCno_(String str) {
        this.cno_ = str;
    }

    public void setCode_(String str) {
        this.code_ = str;
    }

    public void setDeviceIdType(int i10) {
        this.deviceIdType_ = i10;
    }

    public void setDeviceId_(String str) {
        this.deviceId_ = str;
    }

    public void setLocale_(String str) {
        this.locale_ = str;
    }

    public void setNet_(String str) {
        this.net_ = str;
    }

    public void setServiceType_(int i10) {
        this.serviceType_ = i10;
    }

    public void setSign(String str) {
        setSign_(str);
    }

    public void setSign_(String str) {
        this.sign_ = str;
    }

    public void setThirdId_(String str) {
        this.thirdId_ = str;
    }

    public void setTs_(String str) {
        this.ts_ = str;
    }
}
