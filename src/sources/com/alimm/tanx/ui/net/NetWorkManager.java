package com.alimm.tanx.ui.net;

import com.alimm.tanx.core.ad.listener.net.INetWork;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NetWorkManager<T> implements INetWork<T>, NotConfused {
    public static final String TAG = "NetWorkManager";
    public static NetWorkManager instance;
    public INetWork iNetWork;

    public NetWorkManager() {
    }

    public static NetWorkManager getInstance() {
        if (instance == null) {
            synchronized (NetWorkManager.class) {
            }
        }
        return instance;
    }

    @Override // com.alimm.tanx.core.ad.listener.net.INetWork
    public void cancelOkHttpTag(String str) {
        INetWork iNetWork = this.iNetWork;
        if (iNetWork != null) {
            iNetWork.cancelOkHttpTag(str);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "cancelOkHttpTag ->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.net.INetWork
    public void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        INetWork iNetWork = this.iNetWork;
        if (iNetWork != null) {
            iNetWork.sendHttpDownload(requestBean, onDownloadListener);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendHttpDownload->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.net.INetWork
    public void sendHttpGet(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork = this.iNetWork;
        if (iNetWork != null) {
            iNetWork.sendHttpGet(requestBean, cls, netWorkCallBack);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendHttpGet->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.net.INetWork
    public void sendHttpPost(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork = this.iNetWork;
        if (iNetWork != null) {
            iNetWork.sendHttpPost(requestBean, cls, netWorkCallBack);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendHttpPost->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.net.INetWork
    public T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls) {
        INetWork iNetWork = this.iNetWork;
        if (iNetWork != null) {
            return (T) iNetWork.sendSyncHttpPost2Gzip(requestBean, cls);
        }
        LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
        TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendSyncHttpPost2Gzip->iNetWork == null,清设置请求网络库实例", "");
        return null;
    }

    public void setINetWork(INetWork iNetWork) {
        this.iNetWork = iNetWork;
    }

    public NetWorkManager(INetWork iNetWork) {
        this.iNetWork = iNetWork;
    }

    @Override // com.alimm.tanx.core.ad.listener.net.INetWork
    public void sendHttpGet(RequestBean requestBean, Class cls, boolean z10, boolean z11, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork = this.iNetWork;
        if (iNetWork != null) {
            iNetWork.sendHttpGet(requestBean, cls, z10, z11, netWorkCallBack);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendHttpGet->iNetWork == null,清设置请求网络库实例", "");
        }
    }
}