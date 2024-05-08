package com.huawei.appgallery.agd.serverreq.task;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.utils.PackageKit;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.appgallery.agd.serverreq.ServerReqLog;
import com.huawei.appgallery.agd.serverreq.ServerReqRegister;
import com.huawei.appgallery.agd.serverreq.bean.RequestBean;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallBack;
import com.huawei.appgallery.agd.serverreq.utils.HttpUtil;
import com.huawei.appgallery.agd.serverreq.utils.device.DeviceUtil;
import com.huawei.appgallery.agd.serverreq.utils.network.NetworkUtil;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ServerTask extends AsyncTask<RequestBean, Void, ResponseBean> implements IResponseProcessor {
    public static final int MAX_RETRY_TIMES = 3;
    public static final String TAG = "ServerAgentImpl";

    /* renamed from: a, reason: collision with root package name */
    public RequestBean f27541a;

    /* renamed from: b, reason: collision with root package name */
    public ResponseBean f27542b;

    /* renamed from: c, reason: collision with root package name */
    public String f27543c;
    public IServerCallBack callback;
    public TaskListener listener;
    public int retryTimes = 0;
    public HttpUtil httpUtil = null;

    /* renamed from: d, reason: collision with root package name */
    public ResponseHandler f27544d = new ResponseHandler(this);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface TaskListener {
        void onCancelled(ServerTask serverTask);

        void onPostExecute(ServerTask serverTask);
    }

    public ServerTask(RequestBean requestBean, IServerCallBack iServerCallBack) {
        this.f27541a = requestBean;
        this.callback = iServerCallBack;
        this.f27543c = RequestBean.getCacheID(requestBean);
        if (iServerCallBack != null) {
            this.f27543c += iServerCallBack.hashCode();
        }
    }

    public final ResponseBean a(String str, ResponseBean responseBean) {
        if (RequestBean.getRequestType(getRequest()) == 1) {
            responseBean.setOriginalData(str);
            responseBean.setResponseType(2);
        }
        return e(str, responseBean);
    }

    public final HttpUtil.HttpResponseParams b(String str, String str2) throws IOException {
        HttpUtil httpUtil = new HttpUtil();
        this.httpUtil = httpUtil;
        httpUtil.setTargetServer(getRequest().targetServer);
        return c(str, getRequest().getHost(), str2, getUserAgent(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.huawei.appgallery.agd.serverreq.utils.HttpUtil$HttpResponseParams] */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final HttpUtil.HttpResponseParams c(String str, String str2, String str3, String str4, String str5) throws IOException {
        HttpUtil httpUtil = new HttpUtil();
        this.httpUtil = httpUtil;
        httpUtil.setTargetServer(getRequest().targetServer);
        try {
            str = str5 != null ? this.httpUtil.doPost(str, str2, str3, str4, str5) : this.httpUtil.doPost(str, str2, str3, str4);
            return str;
        } catch (IOException e2) {
            ServerReqLog.LOG.w(TAG, "doPostWithDnsParse() error, method:" + RequestBean.getMethod_(getRequest()) + ", url:" + str + ", , currentTime:" + System.currentTimeMillis() + e2.getClass().getSimpleName());
            throw e2;
        }
    }

    public ResponseBean callStore() {
        ResponseBean responseBean;
        String str;
        ResponseBean responseBean2 = null;
        try {
            responseBean = ServerReqRegister.createResponseBean(RequestBean.getMethod_(getRequest()));
            try {
                if (NetworkUtil.hasActiveNetwork(ApplicationWrapper.getInstance().getContext())) {
                    String genBody = RequestBean.genBody(getRequest(), false);
                    String reqUrl = RequestBean.getReqUrl(getRequest());
                    String genBody2 = RequestBean.genBody(getRequest(), true);
                    ServerReqLog serverReqLog = ServerReqLog.LOG;
                    serverReqLog.d(TAG, "callStore request,  method:" + RequestBean.getMethod_(getRequest()) + ", url:" + reqUrl + ", body hash:" + genBody2.hashCode() + ", body:" + genBody2);
                    String reqUrl2 = RequestBean.getReqUrl(getRequest());
                    HttpUtil.HttpResponseParams b4 = b(reqUrl2, genBody);
                    String responseMsg = b4.getResponseMsg();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Store response error, method:");
                    sb2.append(RequestBean.getMethod_(getRequest()));
                    if (TextUtils.isEmpty(responseMsg)) {
                        ResponseBean.setResponseCode(responseBean, 1);
                        ResponseBean.setErrCause(responseBean, 4);
                        sb2.append(",resData == null");
                        serverReqLog.w(TAG, sb2.toString());
                    } else {
                        if (StringUtils.isJSONString(responseMsg)) {
                            responseBean = a(responseMsg, responseBean);
                            str = "callStore response, method:" + RequestBean.getMethod_(getRequest()) + ", url:" + reqUrl2 + ", body hash:" + genBody2.hashCode() + ", Receive Json msg:" + ResponseBean.getSafeData(responseBean);
                        } else {
                            ResponseBean.setResponseCode(responseBean, 1);
                            ResponseBean.setErrCause(responseBean, 2);
                            sb2.append(", resData is not json string");
                            serverReqLog.w(TAG, sb2.toString());
                            str = "resData:" + genBody2;
                        }
                        serverReqLog.d(TAG, str);
                    }
                    ResponseBean.setHttpStatusCode(responseBean, b4.getResponseCode());
                } else {
                    this.f27544d.b(responseBean, 3, 1, null);
                }
            } catch (Exception e2) {
                e = e2;
                responseBean2 = responseBean;
                this.f27544d.c(responseBean2, e);
                responseBean = responseBean2;
                return this.f27544d.a(responseBean);
            }
        } catch (Exception e10) {
            e = e10;
        }
        return this.f27544d.a(responseBean);
    }

    public void cancelTask(boolean z10) {
        if (isFinished()) {
            return;
        }
        ServerReqLog.LOG.i(TAG, "cancelTask, method:" + RequestBean.getMethod_(getRequest()));
        HttpUtil httpUtil = this.httpUtil;
        if (httpUtil != null) {
            httpUtil.abort();
            this.httpUtil = null;
        }
        cancel(z10);
    }

    public final void d(ResponseBean responseBean) {
        int i10;
        if (isCancelled() || this.callback == null) {
            return;
        }
        if (responseBean == null) {
            ServerReqLog.LOG.e(TAG, "notifyResult, response is null");
            try {
                responseBean = ServerReqRegister.createResponseBean(RequestBean.getMethod_(getRequest()));
            } catch (IllegalAccessException | InstantiationException e2) {
                ServerReqLog.LOG.e(TAG, "notifyResult, create response error, method:" + RequestBean.getMethod_(getRequest()), e2);
            }
            if (responseBean == null) {
                responseBean = new ResponseBean();
                i10 = 3;
            } else {
                i10 = 5;
            }
            ResponseBean.setErrCause(responseBean, i10);
            ResponseBean.setResponseCode(responseBean, 1);
        }
        this.callback.prePostResult(getRequest(), getResponse());
    }

    @Override // android.os.AsyncTask
    public ResponseBean doInBackground(RequestBean... requestBeanArr) {
        ServerReqLog.LOG.i(TAG, "doInBackground, method:" + RequestBean.getMethod_(getRequest()));
        ResponseBean excute = excute();
        d(excute);
        return excute;
    }

    public final ResponseBean e(String str, ResponseBean responseBean) {
        try {
            responseBean.fromJson(new JSONObject(str));
            ResponseBean.setResponseCode(responseBean, 0);
        } catch (JSONException unused) {
            ServerReqLog.LOG.e(TAG, "parse json error");
        }
        return responseBean;
    }

    public final ResponseBean excute() {
        ResponseBean responseBean = null;
        do {
            if (this.retryTimes > 0 && responseBean != null) {
                ServerReqLog.LOG.w(TAG, "call store error! method:" + RequestBean.getMethod_(getRequest()) + ", responseCode:" + ResponseBean.getResponseCode(responseBean) + ", retryTimes:" + this.retryTimes);
            }
            responseBean = callStore();
        } while (retry(responseBean));
        setResponse(responseBean);
        return getResponse();
    }

    public final void execute(Executor executor) {
        if (getStatus() == AsyncTask.Status.PENDING) {
            executeOnExecutor(executor, getRequest());
        } else {
            ServerReqLog.LOG.w(TAG, "execute fail");
        }
    }

    @Override // com.huawei.appgallery.agd.serverreq.task.IResponseProcessor
    public RequestBean getRequest() {
        return this.f27541a;
    }

    public ResponseBean getResponse() {
        return this.f27542b;
    }

    public String getSessionID() {
        return this.f27543c;
    }

    public String getUserAgent() {
        Context context = ApplicationWrapper.getInstance().getContext();
        return BaseIPCRequest.CALL_TYPE_AGD_PRO_SDK + "##3.1.1.300##" + DeviceUtil.getBrand() + "##" + DeviceUtil.getDeviceModel() + "##" + (context != null ? context.getPackageName() : "") + "##" + PackageKit.getCpVersionName();
    }

    public boolean isFinished() {
        return getStatus() == AsyncTask.Status.FINISHED || isCancelled();
    }

    public void notifyResult() {
        notifyResult(getResponse());
    }

    public void notifyResult(ResponseBean responseBean) {
        int i10;
        if (isCancelled() || this.callback == null) {
            return;
        }
        if (responseBean == null) {
            try {
                responseBean = ServerReqRegister.createResponseBean(RequestBean.getMethod_(getRequest()));
            } catch (IllegalAccessException | InstantiationException e2) {
                ServerReqLog.LOG.e(TAG, "notifyResult, create response error, method:" + RequestBean.getMethod_(getRequest()), e2);
            }
            if (responseBean == null) {
                responseBean = new ResponseBean();
                i10 = 3;
            } else {
                i10 = 5;
            }
            ResponseBean.setErrCause(responseBean, i10);
            ResponseBean.setResponseCode(responseBean, 1);
        }
        this.callback.notifyResult(getRequest(), responseBean);
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        TaskListener taskListener = this.listener;
        if (taskListener != null) {
            taskListener.onCancelled(this);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ResponseBean responseBean) {
        ServerReqLog.LOG.d(TAG, "onPostExecute, method:" + RequestBean.getMethod_(getRequest()));
        TaskListener taskListener = this.listener;
        if (taskListener != null) {
            taskListener.onPostExecute(this);
        } else {
            notifyResult();
        }
    }

    public boolean onRetryCompleted(ResponseBean responseBean) {
        return false;
    }

    @Override // com.huawei.appgallery.agd.serverreq.task.IResponseProcessor
    public void printErrorInfo(String str, Throwable th) {
        ServerReqLog.LOG.e(TAG, "invoke store error, exceptionType:" + th.getClass().getSimpleName() + ", url:" + str + ", method:" + RequestBean.getMethod_(getRequest()) + ", retryTimes:" + this.retryTimes);
    }

    public boolean retry(ResponseBean responseBean) {
        if (isCancelled()) {
            return false;
        }
        if (ResponseBean.getResponseCode(responseBean) != 1 && ResponseBean.getResponseCode(responseBean) != 2) {
            return false;
        }
        int i10 = this.retryTimes;
        this.retryTimes = i10 + 1;
        if (i10 >= 3) {
            return onRetryCompleted(responseBean);
        }
        return true;
    }

    public void setResponse(ResponseBean responseBean) {
        this.f27542b = responseBean;
    }
}
