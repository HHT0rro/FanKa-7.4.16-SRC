package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.huawei.openalliance.ad.constant.u;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bn;
import com.mobile.auth.gatewayauth.ResultCode;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";

    @Nullable
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.Ej();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.dg(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.DM() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !ag.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.II();
    }

    private String getHostTypeByUrl(@NonNull String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(@NonNull R r10, c cVar, String str) {
        String url = r10.getUrl();
        DomainException domainException = new DomainException(cVar.avq, cVar.avr);
        com.kwad.sdk.core.network.idc.a.DU().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((l<R, T>) r10, cVar.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r10) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r10);
    }

    private void notifyOnSuccess(@NonNull R r10, T t2) {
        if (com.kwad.sdk.core.network.idc.a.DU().DW()) {
            String hostTypeByUrl = getHostTypeByUrl(r10.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.DU().dR(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r10, t2);
        this.mMonitorRecorder.Ei();
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mMonitorRecorder.Ec();
        this.mListener = gVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.DQ().U(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    private void setMonitorRequestId(@NonNull f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.eb(str);
        }
    }

    public void afterParseData(T t2) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public boolean enableCrashReport() {
        return true;
    }

    public boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void fetchImpl() {
        R r10;
        Throwable th;
        c cVar = null;
        try {
            this.mMonitorRecorder.Eg();
            r10 = createRequest();
        } catch (Throwable th2) {
            r10 = null;
            th = th2;
        }
        try {
            notifyOnStartRequest(r10);
            this.mMonitorRecorder.dX(r10.getUrl()).dY(r10.getUrl());
            setMonitorRequestId(r10);
            if (!ag.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                e eVar = e.avw;
                notifyOnErrorListener((l<R, T>) r10, eVar.errorCode, eVar.msg);
                this.mMonitorRecorder.df(e.avw.errorCode).dZ(e.avw.msg);
            } else {
                try {
                    String url = r10.getUrl();
                    AdHttpProxy xT = com.kwad.sdk.f.xT();
                    if (xT instanceof com.kwad.sdk.core.network.c.b) {
                        this.mMonitorRecorder.ea("ok_http").Ef();
                    } else {
                        this.mMonitorRecorder.ea("http").Ef();
                    }
                    if (isPostByJson()) {
                        cVar = xT.doPost(url, r10.getHeader(), r10.getBody());
                    } else {
                        cVar = xT.doPost(url, r10.getHeader(), r10.getBodyMap());
                    }
                    com.kwad.sdk.core.e.c.i(TAG, "url: " + url + ", response: " + ((Object) cVar));
                } catch (Exception e2) {
                    notifyOnErrorListener((l<R, T>) r10, e.avD.errorCode, bn.t(e2));
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                    this.mMonitorRecorder.dZ("requestError:" + e2.getMessage());
                }
                this.mMonitorRecorder.Ed().Ee().di(com.kwad.sdk.ip.direct.a.getType());
                try {
                    onResponse(r10, cVar);
                } catch (Exception e10) {
                    notifyOnErrorListener((l<R, T>) r10, e.avD.errorCode, bn.t(e10));
                    this.mMonitorRecorder.dZ("onResponseError:" + e10.getMessage());
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e10);
                }
            }
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                try {
                    this.mMonitorRecorder.dZ("requestError:" + th.getMessage());
                } catch (Exception unused2) {
                    notifyOnErrorListener((l<R, T>) r10, e.avD.errorCode, bn.t(th));
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th4) {
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.report();
                    }
                } catch (Exception unused4) {
                }
                throw th4;
            }
        }
    }

    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r10, c cVar) {
        if (cVar == null) {
            e eVar = e.avw;
            notifyOnErrorListener((l<R, T>) r10, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.dZ("responseBase is null");
            com.kwad.sdk.core.e.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.df(cVar.code);
        checkIpDirect(cVar);
        if (!TextUtils.isEmpty(cVar.avs) && cVar.DM()) {
            try {
                parseCommonData(r10.getUrl(), cVar.avs);
                T parseData = parseData(cVar.avs);
                afterParseData(parseData);
                if (cVar.avs != null) {
                    this.mMonitorRecorder.ak(r7.length()).Eh().dh(parseData.result);
                }
                if (!parseData.isResultOk()) {
                    this.mMonitorRecorder.dZ("serverCodeError:" + parseData.result + u.bD + parseData.errorMsg);
                    if (parseData.notifyFailOnResultError()) {
                        notifyOnErrorListener((l<R, T>) r10, parseData.result, parseData.errorMsg);
                        return;
                    }
                }
                if (parseData.isDataEmpty()) {
                    notifyOnErrorListener((l<R, T>) r10, e.avy.errorCode, !TextUtils.isEmpty(parseData.testErrorMsg) ? parseData.testErrorMsg : e.avy.msg);
                    return;
                } else {
                    checkAndSetHasData(parseData);
                    notifyOnSuccess(r10, parseData);
                    return;
                }
            } catch (Exception e2) {
                e eVar2 = e.avx;
                notifyOnErrorListener((l<R, T>) r10, eVar2.errorCode, eVar2.msg);
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                this.mMonitorRecorder.dZ("parseDataError:" + e2.getMessage());
                return;
            }
        }
        notifyOnErrorListener((l<R, T>) r10, cVar, ResultCode.MSG_ERROR_NETWORK);
        this.mMonitorRecorder.dZ("httpCodeError:" + cVar.code + u.bD + cVar.avs);
        StringBuilder sb2 = new StringBuilder("request responseBase httpCodeError:");
        sb2.append(cVar.code);
        com.kwad.sdk.core.e.c.w(TAG, sb2.toString());
    }

    @NonNull
    public abstract T parseData(String str);

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((l<R, T>) null, e.avD.errorCode, bn.t(th));
            reportSdkCaughtException(th);
        }
    }

    private void notifyOnErrorListener(@NonNull R r10, int i10, String str) {
        try {
            h.DN().b(r10, i10);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r10, i10, str);
        this.mMonitorRecorder.Ei();
    }
}
