package com.huawei.appgallery.agd.serverreq.task;

import com.huawei.appgallery.agd.serverreq.bean.RequestBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IResponseProcessor {
    RequestBean getRequest();

    void printErrorInfo(String str, Throwable th);
}
