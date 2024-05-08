package com.huawei.appgallery.agd.serverreq.listener;

import androidx.annotation.WorkerThread;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IServerCallbackEx {
    @WorkerThread
    void onFail(int i10, String str);

    @WorkerThread
    void onResponse(ResponseBean responseBean);
}
