package com.alimm.tanx.core.net;

import com.alimm.tanx.core.TanxCoreManager;
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
    public static INetWork iNetWork;
    public static NetWorkManager instance;

    public NetWorkManager() {
    }

    public static NetWorkManager getInstance() {
        if (instance == null) {
            synchronized (NetWorkManager.class) {
                if (instance == null) {
                    instance = new NetWorkManager(TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getNetWork());
                }
            }
        }
        return instance;
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void cancelOkHttpTag(String str) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.cancelOkHttpTag(str);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "cancelOkHttpTag ->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpDownload(requestBean, onDownloadListener);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendHttpDownload->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpGet(requestBean, cls, netWorkCallBack);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendHttpGet->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpPost(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpPost(requestBean, cls, netWorkCallBack);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendHttpPost->iNetWork == null,清设置请求网络库实例", "");
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            return (T) iNetWork2.sendSyncHttpPost2Gzip(requestBean, cls);
        }
        LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
        TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendSyncHttpPost2Gzip->iNetWork == null,清设置请求网络库实例", "");
        return null;
    }

    public void setINetWork(INetWork iNetWork2) {
        iNetWork = iNetWork2;
    }

    public NetWorkManager(INetWork iNetWork2) {
        iNetWork = iNetWork2;
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(RequestBean requestBean, Class cls, boolean z10, boolean z11, NetWorkCallBack netWorkCallBack) {
        INetWork iNetWork2 = iNetWork;
        if (iNetWork2 != null) {
            iNetWork2.sendHttpGet(requestBean, cls, z10, z11, netWorkCallBack);
        } else {
            LogUtils.e("NetWorkManager", "iNetWork == null,清设置请求网络库实例");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "NetWorkManager", "sendHttpGet->iNetWork == null,清设置请求网络库实例", "");
        }
    }
}
