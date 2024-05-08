package com.huawei.appgallery.agd.serverreq.bean.startup;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.common.utils.DeviceSession;
import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import com.huawei.appgallery.agd.serverreq.utils.device.DeviceUtil;
import com.huawei.appgallery.agd.serverreq.utils.device.TelphoneInformationManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class StartupRequest extends BaseRequestBean {
    public static final String APIMETHOD = "client.front2";
    private static final String DEFAULT_VERSION = "11.2.2";
    private static final int DEFAULT_VERSIONCODE = 110202300;
    public static final String IS_SUPPORT_THEME = "true";
    public static final int NEED_STORE_SERVICE_ZONE = 1;
    public static final int UNNEED_STORE_SERVICE_ZONE = 0;
    private String buildNumber_;
    private String firmwareVersion_;
    private String packageName_;
    private String phoneType_;
    private String theme_;
    public int versionCode_;
    private String version_;
    private int zone_;
    private String accountZone_ = "";
    private int needServiceZone_ = 0;

    @NonNull
    public static StartupRequest newInstance() {
        StartupRequest startupRequest = new StartupRequest();
        setReqData(startupRequest);
        if (HomeCountryUtils.isNeedStoreServiceZone() && TextUtils.isEmpty(DeviceSession.getSession().getServiceZone())) {
            startupRequest.setNeedServiceZone_(1);
            startupRequest.setAccountZone_(HomeCountryUtils.getHomeCountryFromRom());
        }
        return startupRequest;
    }

    public static void setReqData(@NonNull StartupRequest startupRequest) {
        Context context = ApplicationWrapper.getInstance().getContext();
        startupRequest.setSign_(null);
        startupRequest.setMethod_(APIMETHOD);
        startupRequest.firmwareVersion_ = TelphoneInformationManager.getTelphoneFirmVersionFromSys();
        startupRequest.setLocale_(TelphoneInformationManager.getTelephoneLanguage());
        startupRequest.setZone_(1);
        startupRequest.version_ = DEFAULT_VERSION;
        startupRequest.buildNumber_ = DeviceUtil.getBuildVersion();
        startupRequest.phoneType_ = DeviceUtil.getDeviceModel();
        startupRequest.versionCode_ = DEFAULT_VERSIONCODE;
        startupRequest.theme_ = "true";
        startupRequest.setStoreApi(BaseRequestBean.STORE_API);
        startupRequest.packageName_ = context.getPackageName();
        startupRequest.setAccountZone_(HomeCountryUtils.getHomeCountry());
        startupRequest.setCacheID(APIMETHOD + startupRequest.getAccountZone_() + startupRequest.getVersion_() + startupRequest.getLocale_());
    }

    public String getAccountZone_() {
        return this.accountZone_;
    }

    public int getNeedServiceZone_() {
        return this.needServiceZone_;
    }

    public String getVersion_() {
        return this.version_;
    }

    public void setAccountZone_(String str) {
        this.accountZone_ = str;
    }

    public void setNeedServiceZone_(int i10) {
        this.needServiceZone_ = i10;
    }

    public void setVersion_(String str) {
        this.version_ = str;
    }

    public void setZone_(int i10) {
        this.zone_ = i10;
    }
}
