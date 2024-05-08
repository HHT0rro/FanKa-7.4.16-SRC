package com.alimm.tanx.core.net;

import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface INetWork<T> {
    void cancelOkHttpTag(String str);

    void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener);

    void sendHttpGet(RequestBean requestBean, Class<T> cls, NetWorkCallBack netWorkCallBack);

    void sendHttpGet(RequestBean requestBean, Class<T> cls, boolean z10, boolean z11, NetWorkCallBack netWorkCallBack);

    void sendHttpPost(RequestBean requestBean, Class<T> cls, NetWorkCallBack netWorkCallBack);

    T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls);
}
