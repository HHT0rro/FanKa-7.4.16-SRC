package com.alimm.tanx.core.ad.model;

import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.AdRequest;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseModel implements IModel, NotConfused, Runnable {
    public TanxAdSlot adSlot;
    public BidInfo bidInfo;
    public boolean hasRequest;
    public boolean hasTimeOut;
    public boolean isCancel;
    public ITanxRequestLoader.ITanxRequestListener requestListener;
    public final String TAG = "BaseModel";
    public Handler handler = new Handler(Looper.getMainLooper());

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void cancel() {
        this.isCancel = true;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this);
        }
        LogUtils.d("BaseModel", "计时器取消");
    }

    public void checkSuccess(AdInfo adInfo) {
        if (adInfo == null) {
            ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.requestListener;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onError(new TanxError(TanxError.ERROR_ADINFO_NULL));
                return;
            }
            return;
        }
        onSuccess(adInfo);
    }

    public abstract String getScene();

    public abstract void onSuccess(AdInfo adInfo);

    public void requestSucc(AdInfo adInfo) {
        if (this.isCancel || this.hasTimeOut) {
            return;
        }
        checkSuccess(adInfo);
        cancel();
        timerCancelNotify(adInfo, true, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hasTimeOut = true;
        ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = this.requestListener;
        if (iTanxRequestListener != null) {
            iTanxRequestListener.onTimeOut();
            LogUtils.d("BaseModel", "计时器达到超时");
        }
        timerCancelNotify(null, false, UtErrorCode.TIMER_OUT.getIntCode());
    }

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    public void startTimer(long j10) {
        LogUtils.d("BaseModel", "启动计时器 timeOut=" + j10);
        if (j10 > 0) {
            this.handler.postDelayed(this, j10);
        }
    }

    public abstract void timerCancelNotify(AdInfo adInfo, boolean z10, int i10);

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, final ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j10) {
        this.adSlot = tanxAdSlot;
        this.requestListener = iTanxRequestListener;
        LogUtils.d("BaseModel", "发起请求 hasRequest=" + this.hasRequest);
        if (!this.hasRequest) {
            this.hasRequest = true;
            startTimer(j10);
            AdRequest.request(tanxAdSlot, getScene(), new NetWorkCallBack<AdInfo>() { // from class: com.alimm.tanx.core.ad.model.BaseModel.1
                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void error(int i10, String str, String str2) {
                    LogUtils.e("BaseModel", "发起请求 error=" + str2);
                    BaseModel baseModel = BaseModel.this;
                    if (baseModel.isCancel || baseModel.hasTimeOut) {
                        return;
                    }
                    ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                    if (iTanxRequestListener2 != null) {
                        iTanxRequestListener2.onError(new TanxError(str, i10, str2));
                    }
                    BaseModel.this.cancel();
                    BaseModel.this.timerCancelNotify(null, true, 0);
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
                public void succ(AdInfo adInfo) {
                    LogUtils.d("BaseModel", "发起请求 isCancel=" + BaseModel.this.isCancel + "--- hasTimeOut= " + BaseModel.this.hasTimeOut);
                    BaseModel.this.requestSucc(adInfo);
                }
            });
            return;
        }
        throw new IllegalStateException("has request");
    }
}
