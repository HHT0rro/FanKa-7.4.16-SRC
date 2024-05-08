package com.huawei.appgallery.agd.serverreq.listener;

import com.huawei.appgallery.agd.serverreq.bean.RequestBean;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IServerCallBack {
    void notifyResult(RequestBean requestBean, ResponseBean responseBean);

    void prePostResult(RequestBean requestBean, ResponseBean responseBean);
}
