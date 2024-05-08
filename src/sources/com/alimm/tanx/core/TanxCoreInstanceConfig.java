package com.alimm.tanx.core;

import com.alimm.tanx.core.ad.listener.bean.IAdInfo;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.ad.listener.bean.IClickBean;
import com.alimm.tanx.core.ad.listener.bean.IMaterialBean;
import com.alimm.tanx.core.ad.listener.bean.IMonitorBean;
import com.alimm.tanx.core.ad.listener.bean.ISeatInfo;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.listener.request.IAdRequest;
import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.image.IImageLoader;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import uc.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxCoreInstanceConfig implements NotConfused {
    public static TanxCoreInstanceConfig instance;
    public IAdInfo iAdInfo;
    public IAdRequest iAdRequest;
    public IBidInfo iBidInfo;
    public IImageLoader iImageLoader;
    public INetWork iNetWork;
    public ISeatInfo iSeatInfo;
    public IModel iSplashModel;
    public ITanxPlayer iTanxPlayer;
    public ITanxUserTracker iTanxUserTracker;
    public a iUserTracker;

    public static TanxCoreInstanceConfig getInstance() {
        if (instance == null) {
            synchronized (NetWorkManager.class) {
                if (instance == null) {
                    instance = new TanxCoreInstanceConfig();
                }
            }
        }
        return instance;
    }

    public IAdInfo getAdInfo() {
        return this.iAdInfo;
    }

    public IAdRequest getAdRequest() {
        return this.iAdRequest;
    }

    public IBidInfo getBidInfo() {
        return this.iBidInfo;
    }

    public IClickBean getClickBean() {
        IBidInfo iBidInfo = this.iBidInfo;
        if (iBidInfo != null) {
            return iBidInfo.getClickBean();
        }
        return null;
    }

    public IImageLoader getImageLoader() {
        return this.iImageLoader;
    }

    public IMaterialBean getMaterialBean() {
        IBidInfo iBidInfo = this.iBidInfo;
        if (iBidInfo != null) {
            return iBidInfo.getMaterialBean();
        }
        return null;
    }

    public IMonitorBean getMonitorBean() {
        IBidInfo iBidInfo = this.iBidInfo;
        if (iBidInfo != null) {
            return iBidInfo.getMonitorBean();
        }
        return null;
    }

    public INetWork getNetWork() {
        return this.iNetWork;
    }

    public ISeatInfo getSeatInfo() {
        return this.iSeatInfo;
    }

    public IModel getSplashModel() {
        return this.iSplashModel;
    }

    public ITanxPlayer getTanxPlayer() {
        return this.iTanxPlayer;
    }

    public ITanxUserTracker getTanxUserTracker() {
        return this.iTanxUserTracker;
    }

    public a getUserTracker() {
        return this.iUserTracker;
    }

    public void setAdInfo(IAdInfo iAdInfo) {
        this.iAdInfo = iAdInfo;
    }

    public void setAdRequest(IAdRequest iAdRequest) {
        this.iAdRequest = iAdRequest;
    }

    public void setBidInfo(IBidInfo iBidInfo) {
        this.iBidInfo = iBidInfo;
    }

    public void setImageLoader(IImageLoader iImageLoader) {
        this.iImageLoader = iImageLoader;
    }

    public void setNetWork(INetWork iNetWork) {
        this.iNetWork = iNetWork;
    }

    public void setSeatInfo(ISeatInfo iSeatInfo) {
        this.iSeatInfo = iSeatInfo;
    }

    public void setSplashModel(IModel iModel) {
        this.iSplashModel = iModel;
    }

    public void setTanxPlayer(ITanxPlayer iTanxPlayer) {
        this.iTanxPlayer = iTanxPlayer;
    }

    public void setTanxUserTracker(ITanxUserTracker iTanxUserTracker) {
        this.iTanxUserTracker = iTanxUserTracker;
    }

    public void setUserTracker(a aVar) {
        this.iUserTracker = aVar;
    }
}
