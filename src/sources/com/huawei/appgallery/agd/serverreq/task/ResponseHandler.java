package com.huawei.appgallery.agd.serverreq.task;

import com.huawei.appgallery.agd.serverreq.ServerReqLog;
import com.huawei.appgallery.agd.serverreq.bean.RequestBean;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import java.net.MalformedURLException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ResponseHandler {

    /* renamed from: a, reason: collision with root package name */
    public IResponseProcessor f27540a;

    public ResponseHandler(IResponseProcessor iResponseProcessor) {
        this.f27540a = iResponseProcessor;
    }

    public ResponseBean a(ResponseBean responseBean) {
        if (responseBean != null) {
            return responseBean;
        }
        ResponseBean responseBean2 = new ResponseBean();
        ResponseBean.setResponseCode(responseBean2, 5);
        ResponseBean.setErrCause(responseBean2, 3);
        return responseBean2;
    }

    public void b(ResponseBean responseBean, int i10, int i11, Exception exc) {
        if (responseBean != null) {
            ResponseBean.setResponseCode(responseBean, i10);
            ResponseBean.setErrCause(responseBean, i11);
        }
    }

    public void c(ResponseBean responseBean, Exception exc) {
        if (responseBean == null || (exc instanceof IllegalAccessException)) {
            b(responseBean, 1, 5, exc);
            ServerReqLog.LOG.e("ResponseHandler", "filterResponseException, response = " + ((Object) responseBean));
            return;
        }
        if ((exc instanceof IllegalArgumentException) || (exc instanceof MalformedURLException)) {
            b(responseBean, 5, 3, exc);
        } else {
            IResponseProcessor iResponseProcessor = this.f27540a;
            iResponseProcessor.printErrorInfo(RequestBean.getReqUrl(iResponseProcessor.getRequest()), exc);
        }
    }
}
