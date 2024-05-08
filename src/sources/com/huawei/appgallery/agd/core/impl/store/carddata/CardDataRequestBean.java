package com.huawei.appgallery.agd.core.impl.store.carddata;

import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.core.impl.store.base.MasRequestBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.FieldSecurity;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import com.huawei.appgallery.agd.serverreq.utils.device.DeviceUtil;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardDataRequestBean extends MasRequestBean {
    public static final String APIMETHOD = "client.getCardData";
    public static final int VERSION = 0;

    @NetworkTransmission
    private int adCount;

    @NetworkTransmission
    private String agdProSdkVer;

    @NetworkTransmission
    private String channelId;

    @NetworkTransmission
    private Integer childProtection;

    @NetworkTransmission
    private String contextIntent;

    @NetworkTransmission
    private int gradeLevel;

    @NetworkTransmission
    private int gradeType;

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String mcc;

    @NetworkTransmission
    private String mediaId;

    @NetworkTransmission
    private String osv;

    @NetworkTransmission
    private PersonalizeInfo personalize;

    @NetworkTransmission
    private String referrer;

    @NetworkTransmission
    private Long roamingTime = 0L;

    @NetworkTransmission
    private String serviceCountry;

    @NetworkTransmission
    private String userProfile;

    @NetworkTransmission
    private int ver;

    public CardDataRequestBean() {
        setMethod_(APIMETHOD);
        this.ver = 0;
    }

    public String getAgdProSdkVer() {
        return this.agdProSdkVer;
    }

    public String getContextIntent() {
        return this.contextIntent;
    }

    public int getGradeLevel() {
        return this.gradeLevel;
    }

    public int getGradeType() {
        return this.gradeType;
    }

    public String getMcc() {
        return this.mcc;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getOSV() {
        return this.osv;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public Long getRoamingTime() {
        return this.roamingTime;
    }

    public String getUserProfile() {
        return this.userProfile;
    }

    @Override // com.huawei.appgallery.agd.core.impl.store.base.MasRequestBean, com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean, com.huawei.appgallery.agd.serverreq.bean.RequestBean
    public void onSetValue() {
        super.onSetValue();
        setServiceCountry(HomeCountryUtils.getHomeCountry());
        setRequestType(1);
        this.mediaId = this.callerPkg;
        setOSV(DeviceUtil.getOSVersion());
    }

    public void setAdCount(int i10) {
        this.adCount = i10;
    }

    public void setAgdProSdkVer(String str) {
        this.agdProSdkVer = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setChildProtection(Integer num) {
        this.childProtection = num;
    }

    public void setContextIntent(String str) {
        this.contextIntent = str;
    }

    public void setGradeLevel(int i10) {
        this.gradeLevel = i10;
    }

    public void setGradeType(int i10) {
        this.gradeType = i10;
    }

    public void setMcc(String str) {
        this.mcc = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setOSV(String str) {
        this.osv = str;
    }

    public void setPersonalize(JSONObject jSONObject) {
        this.personalize = PersonalizeInfo.parse(jSONObject);
    }

    public void setReferrer(String str) {
        this.referrer = str;
    }

    public void setRoamingTime(Long l10) {
        this.roamingTime = l10;
    }

    public void setServiceCountry(String str) {
        this.serviceCountry = str;
    }

    public void setUserProfile(String str) {
        this.userProfile = str;
    }
}
