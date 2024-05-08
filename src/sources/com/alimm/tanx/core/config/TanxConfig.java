package com.alimm.tanx.core.config;

import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.image.ILoader;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import java.util.List;
import java.util.Map;
import uc.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxConfig extends TanxCoreConfig implements NotConfused {
    public SettingConfig mSettingConfig;
    public HttpProxyCacheServer proxyCacheServer;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Builder implements NotConfused {
        public Boolean idAllSwitch;
        public String imei;
        public boolean imeiSwitch;
        public String mAppId;
        public String mAppKey;
        public String mAppName;
        public String mAppSecret;
        public String mChannel;
        public boolean mDebugMode;
        public ILoader mImageLoader;
        public INetWork mNetWork;
        public SettingConfig mSettingConfig = new SettingConfig();
        public ITanxUserTracker mTanxUserTracker;
        public a mUserTracker;
        public boolean netDebug;
        public String oaid;
        public boolean oaidSwitch;
        public Map<String, List<String>> userTag;

        public Builder() {
            this.mDebugMode = false;
            this.netDebug = false;
            this.mDebugMode = false;
            this.netDebug = false;
        }

        public Builder appId(String str) {
            this.mAppId = str;
            return this;
        }

        public Builder appKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public Builder appName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder appSecret(String str) {
            this.mAppSecret = str;
            return this;
        }

        public TanxConfig build() {
            return new TanxConfig(this);
        }

        public Builder channel(String str) {
            this.mChannel = str;
            return this;
        }

        public Builder dark(SettingConfig settingConfig) {
            this.mSettingConfig = settingConfig;
            return this;
        }

        public Builder debug(boolean z10) {
            this.mDebugMode = z10;
            return this;
        }

        public Builder idAllSwitch(boolean z10) {
            this.idAllSwitch = Boolean.valueOf(z10);
            return this;
        }

        @Deprecated
        public Builder imageLoader(ILoader iLoader) {
            this.mImageLoader = iLoader;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder imeiSwitch(boolean z10) {
            this.imeiSwitch = z10;
            return this;
        }

        public Builder netDebug(boolean z10) {
            this.netDebug = z10;
            return this;
        }

        public Builder network(INetWork iNetWork) {
            this.mNetWork = iNetWork;
            return this;
        }

        public Builder oaid(String str) {
            this.oaid = str;
            return this;
        }

        public Builder oaidSwitch(boolean z10) {
            this.oaidSwitch = z10;
            return this;
        }

        public Builder setUserTag(Map<String, List<String>> map) {
            this.userTag = map;
            return this;
        }

        public Builder tanxUserTracker(ITanxUserTracker iTanxUserTracker) {
            this.mTanxUserTracker = iTanxUserTracker;
            return this;
        }

        public Builder userTracker(a aVar) {
            this.mUserTracker = aVar;
            return this;
        }
    }

    public TanxConfig() {
    }

    public ILoader getImageLoader() {
        return ImageManager.getLoader();
    }

    public SettingConfig getSettingConfig() {
        return this.mSettingConfig;
    }

    public void setImageLoader(ILoader iLoader) {
        if (iLoader != null) {
            ImageManager.setLoader(iLoader);
        }
    }

    public void setSettingConfig(SettingConfig settingConfig) {
        this.mSettingConfig = settingConfig;
    }

    public TanxConfig(Builder builder) {
        setDebugMode(builder.mDebugMode);
        setAppName(builder.mAppName);
        setChannel(builder.mChannel);
        setAppId(builder.mAppId);
        setAppName(builder.mAppName);
        setAppKey(builder.mAppKey);
        setNetDebug(builder.netDebug);
        setAppSecret(builder.mAppSecret);
        setmOaid(builder.oaid);
        setImei(builder.imei);
        setOaidSwitch(builder.oaidSwitch);
        setImeiSwitch(builder.imeiSwitch);
        setIdAllSwitch(builder.idAllSwitch);
        setImageLoader(builder.mImageLoader);
        this.mSettingConfig = builder.mSettingConfig;
        setUserTag(builder.userTag);
    }
}
