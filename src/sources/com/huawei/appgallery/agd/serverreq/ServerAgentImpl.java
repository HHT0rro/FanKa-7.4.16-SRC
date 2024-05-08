package com.huawei.appgallery.agd.serverreq;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.grs.GrsConfigObtainer;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.common.utils.DeviceSession;
import com.huawei.appgallery.agd.common.utils.ThreadPoolUtil;
import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import com.huawei.appgallery.agd.serverreq.bean.RequestBean;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.bean.startup.StartupRequest;
import com.huawei.appgallery.agd.serverreq.bean.startup.StartupTask;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallBack;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;
import com.huawei.appgallery.agd.serverreq.store.SignSession;
import com.huawei.appgallery.agd.serverreq.task.ServerTask;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ServerAgentImpl {

    /* renamed from: a, reason: collision with root package name */
    public static ServerAgentImpl f27518a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ServerCallBackImpl implements IServerCallBack {

        /* renamed from: a, reason: collision with root package name */
        public final IServerCallbackEx f27519a;

        public ServerCallBackImpl(@NonNull IServerCallbackEx iServerCallbackEx) {
            this.f27519a = iServerCallbackEx;
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallBack
        public void notifyResult(RequestBean requestBean, ResponseBean responseBean) {
        }

        @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallBack
        public void prePostResult(RequestBean requestBean, ResponseBean responseBean) {
            this.f27519a.onResponse(responseBean);
        }
    }

    @NonNull
    public static ServerTask a(BaseRequestBean baseRequestBean, IServerCallBack iServerCallBack, Executor executor) {
        ServerTask serverTask = new ServerTask(baseRequestBean, iServerCallBack);
        baseRequestBean.setUrl(GrsConfigObtainer.getServerUrl(ApplicationWrapper.getInstance().getContext(), baseRequestBean.targetServer, FlavorApi.getGrsServerNameV2()));
        ServerReqLog.LOG.i(ServerTask.TAG, "executeTask, method:" + baseRequestBean.getMethod_());
        serverTask.execute(executor);
        return serverTask;
    }

    public static synchronized ServerAgentImpl getInstance() {
        ServerAgentImpl serverAgentImpl;
        synchronized (ServerAgentImpl.class) {
            if (f27518a == null) {
                f27518a = new ServerAgentImpl();
            }
            serverAgentImpl = f27518a;
        }
        return serverAgentImpl;
    }

    public final boolean b() {
        if (TextUtils.isEmpty(SignSession.getInstance().getAGSign())) {
            return (TextUtils.isEmpty(HomeCountryUtils.getHomeCountryOfMedia()) && TextUtils.isEmpty(DeviceSession.getSession().getServiceZone())) || TextUtils.isEmpty(SignSession.getInstance().getSign());
        }
        ServerReqLog.LOG.i(ServerTask.TAG, "get AG sign is valid");
        return false;
    }

    public ResponseBean invokeServer(BaseRequestBean baseRequestBean) {
        ServerTask serverTask = new ServerTask(baseRequestBean, null);
        baseRequestBean.setUrl(GrsConfigObtainer.getServerUrl(ApplicationWrapper.getInstance().getContext(), baseRequestBean.targetServer, FlavorApi.getGrsServerNameV2()));
        return serverTask.excute();
    }

    public ServerTask invokeServer(BaseRequestBean baseRequestBean, IServerCallBack iServerCallBack) {
        return a(baseRequestBean, iServerCallBack, ThreadPoolUtil.CORE_THREAD_POOL);
    }

    public void invokeServerEx(BaseRequestBean baseRequestBean, IServerCallbackEx iServerCallbackEx) {
        if (b()) {
            a(StartupRequest.newInstance(), new StartupTask(baseRequestBean, iServerCallbackEx), ThreadPoolUtil.SERIAL_THREAD);
        } else {
            baseRequestBean.setSign(SignSession.getInstance().getSign());
            a(baseRequestBean, new ServerCallBackImpl(iServerCallbackEx), ThreadPoolUtil.CORE_THREAD_POOL);
        }
    }
}
