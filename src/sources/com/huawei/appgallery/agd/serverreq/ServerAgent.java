package com.huawei.appgallery.agd.serverreq;

import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallBack;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;
import com.huawei.appgallery.agd.serverreq.task.ServerTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ServerAgent {
    public static ResponseBean invokeServer(BaseRequestBean baseRequestBean) {
        return ServerAgentImpl.getInstance().invokeServer(baseRequestBean);
    }

    public static ServerTask invokeServer(BaseRequestBean baseRequestBean, IServerCallBack iServerCallBack) {
        return ServerAgentImpl.getInstance().invokeServer(baseRequestBean, iServerCallBack);
    }

    public static void invokeServerEx(BaseRequestBean baseRequestBean, IServerCallbackEx iServerCallbackEx) {
        ServerAgentImpl.getInstance().invokeServerEx(baseRequestBean, iServerCallbackEx);
    }

    public static void registerResponse(String str, Class cls) {
        ServerReqRegister.registerResponse(str, cls);
    }
}
