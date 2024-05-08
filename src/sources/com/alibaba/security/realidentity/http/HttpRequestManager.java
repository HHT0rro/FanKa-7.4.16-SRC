package com.alibaba.security.realidentity.http;

import android.content.Context;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.build.gw;
import com.alibaba.security.realidentity.build.gy;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import com.alibaba.security.realidentity.http.model.RequestType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HttpRequestManager implements gy, IHttpManager {
    private static final String TAG = "HttpRequestManager";
    private gy mTrackLog;
    private final boolean debug = false;
    private RequestType mRequestType = RequestType.OK_HTTP;
    private final BaseHttpManager mOkHttpManager = new RPOkHttpManager(this);
    private final BaseHttpManager mHttpUrlConnectionManager = new HttpUrlConnectionManager(this);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class HOLDER {
        private static final HttpRequestManager SINGLE = new HttpRequestManager();

        private HOLDER() {
        }
    }

    public static HttpRequestManager getInstance() {
        return HOLDER.SINGLE;
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncDownloadFile(Context context, String str, String str2, ProgressCallback progressCallback) {
        if (this.mRequestType == RequestType.OK_HTTP) {
            this.mOkHttpManager.asyncDownloadFile(context, str, str2, progressCallback);
        } else {
            this.mHttpUrlConnectionManager.asyncDownloadFile(context, str, str2, progressCallback);
        }
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback) {
        asyncRequest(context, str, str2, iHttpCallback, true);
    }

    @Override // com.alibaba.security.realidentity.build.gy
    public void collectLog(TrackLog trackLog) {
        gy gyVar = this.mTrackLog;
        if (gyVar != null) {
            gyVar.collectLog(trackLog);
        }
    }

    public void init(gw gwVar, RPEnv rPEnv) {
        this.mOkHttpManager.init(gwVar, rPEnv);
        this.mHttpUrlConnectionManager.init(gwVar, rPEnv);
    }

    public void setCurEnv(RPEnv rPEnv) {
        this.mOkHttpManager.setRPEnv(rPEnv);
        this.mHttpUrlConnectionManager.setRPEnv(rPEnv);
    }

    public void setRequestType(RequestType requestType) {
        this.mRequestType = requestType;
    }

    public void setTrackLog(gy gyVar) {
        this.mTrackLog = gyVar;
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2) {
        return syncRequest(context, str, str2, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback) {
        asyncRequest(context, str, str2, httpMethod, iHttpCallback, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, HttpMethod httpMethod) {
        return syncRequest(context, str, str2, httpMethod, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback, boolean z10) {
        asyncRequest(context, str, str2, HttpMethod.POST, iHttpCallback, z10);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, boolean z10) {
        return syncRequest(context, str, str2, HttpMethod.POST, z10);
    }

    public void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback, boolean z10, boolean z11) {
        if (z11) {
            this.mOkHttpManager.asyncRequest(context, str, str2, HttpMethod.POST, iHttpCallback, z10);
        } else {
            asyncRequest(context, str, str2, HttpMethod.POST, iHttpCallback, z10);
        }
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, HttpMethod httpMethod, boolean z10) {
        if (this.mRequestType == RequestType.OK_HTTP) {
            return this.mOkHttpManager.syncRequest(context, str, str2, httpMethod, z10);
        }
        return this.mHttpUrlConnectionManager.syncRequest(context, str, str2, httpMethod, z10);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback, boolean z10) {
        if (this.mRequestType == RequestType.OK_HTTP) {
            this.mOkHttpManager.asyncRequest(context, str, str2, httpMethod, iHttpCallback, z10);
        } else {
            this.mHttpUrlConnectionManager.asyncRequest(context, str, str2, httpMethod, iHttpCallback, z10);
        }
    }
}
