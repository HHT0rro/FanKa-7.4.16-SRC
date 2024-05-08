package com.alimm.tanx.core.config;

import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.net.NetWorkManager;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import uc.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxCoreConfig implements Serializable {
    public static final String TAG = "AdSdkConfig";
    public String clientId;
    public String guid;
    public Boolean idAllSwitch;
    public boolean imeiSwitch;
    public String mAppId;
    public String mAppKey;
    public String mAppName;
    public String mAppSecret;
    public String mChannel;
    public String mImei;
    public INetWork mNetWork;
    public String mOaid;
    public ITanxUserTracker mTanxUserTracker;
    public a mUserTracker;
    public boolean oaidSwitch;
    public String pseudoId;
    public Map<String, List<String>> userTag;
    public String widevineId;
    public boolean mDebugMode = false;
    public boolean netDebug = false;

    public static String getTAG() {
        return TAG;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getImei() {
        return this.mImei;
    }

    public String getOaid() {
        return this.mOaid;
    }

    public String getPseudoId() {
        return this.pseudoId;
    }

    public Map<String, List<String>> getUserTag() {
        return this.userTag;
    }

    public String getWidevineId() {
        return this.widevineId;
    }

    public boolean isDebugMode() {
        return this.mDebugMode;
    }

    public Boolean isIdAllSwitch() {
        return this.idAllSwitch;
    }

    public boolean isImeiSwitch() {
        return this.imeiSwitch;
    }

    public boolean isNetDebug() {
        return this.netDebug;
    }

    public boolean isOaidSwitch() {
        return this.oaidSwitch;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setAppSecret(String str) {
        this.mAppSecret = str;
    }

    public void setChannel(String str) {
        this.mChannel = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setDebugMode(boolean z10) {
        this.mDebugMode = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setDebugMode: debugMode = ");
        sb2.append(z10);
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setHttpImpl(INetWork iNetWork) {
        if (iNetWork != null) {
            NetWorkManager.getInstance().setINetWork(iNetWork);
        }
    }

    public void setIdAllSwitch(Boolean bool) {
        if (bool != null) {
            this.imeiSwitch = bool.booleanValue();
            this.oaidSwitch = bool.booleanValue();
            this.idAllSwitch = bool;
        }
    }

    public void setImei(String str) {
        this.mImei = str;
    }

    public void setImeiSwitch(boolean z10) {
        this.imeiSwitch = z10;
    }

    public void setNetDebug(boolean z10) {
        this.netDebug = z10;
    }

    public void setOaidSwitch(boolean z10) {
        this.oaidSwitch = z10;
    }

    public void setPseudoId(String str) {
        this.pseudoId = str;
    }

    public void setUserTag(Map<String, List<String>> map) {
        this.userTag = map;
    }

    public void setWidevineId(String str) {
        this.widevineId = str;
    }

    public void setmOaid(String str) {
        this.mOaid = str;
    }
}
