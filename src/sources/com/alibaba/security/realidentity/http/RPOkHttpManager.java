package com.alibaba.security.realidentity.http;

import android.content.Context;
import com.alibaba.security.common.http.ok.Callback;
import com.alibaba.security.common.http.ok.MediaType;
import com.alibaba.security.common.http.ok.RPCall;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.RequestBody;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.realidentity.build.gy;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPOkHttpManager extends BaseHttpManager {
    private static final String TAG = "RPOkHttpManager";
    private final RPHttpClient mOkHttpClient;
    private final gy mTrackLog;

    public RPOkHttpManager(gy gyVar) {
        this.mTrackLog = gyVar;
        RPHttpClient.Builder builder = new RPHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.mOkHttpClient = builder.connectTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).build();
    }

    private RPRequest buildRequest(Context context, String str, HttpMethod httpMethod, String str2, boolean z10) {
        Map<String, Object> buildHeaders = buildHeaders(context, str, httpMethod.toString(), str2);
        if (buildHeaders != null && !buildHeaders.isEmpty()) {
            RPRequest.Builder builder = new RPRequest.Builder();
            for (Map.Entry<String, Object> entry : buildHeaders.entrySet()) {
                builder.addHeader(entry.getKey(), String.valueOf(entry.getValue()));
            }
            return builder.url(getUrl(str)).method(httpMethod.toString(), RequestBody.create(MediaType.parse("application/json"), str2)).build();
        }
        uploadErrorLog(str, "execute http exception: build request is null", z10);
        return null;
    }

    private void doAsyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback, boolean z10) {
        RPRequest buildRequest = buildRequest(context, str, httpMethod, str2, z10);
        if (buildRequest == null) {
            return;
        }
        doAsyncRequest(buildRequest, str, iHttpCallback, z10);
    }

    private RpHttpResponse doSyncRequest(Context context, String str, HttpMethod httpMethod, String str2, boolean z10) {
        try {
            RPRequest buildRequest = buildRequest(context, str, httpMethod, str2, z10);
            if (buildRequest == null) {
                return null;
            }
            Response execute = this.mOkHttpClient.newCall(buildRequest).execute();
            if (execute == null) {
                uploadErrorLog(str, "execute http exception: response is null", z10);
                return null;
            }
            if (execute.body() == null) {
                uploadErrorLog(str, "execute http exception: response body is null", z10);
                return null;
            }
            String string = execute.body().string();
            if (!execute.isSuccessful()) {
                uploadErrorLog(str, "execute http exception: response body is fail: ".concat(String.valueOf(string)), z10);
            }
            return RpHttpResponse.create(execute.isSuccessful(), string);
        } catch (Exception e2) {
            uploadErrorLog(str, "execute http exception: catch exception, " + CommonUtils.getStackTrace(e2), z10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadErrorLog(String str, String str2, boolean z10) {
        if (z10) {
            TrackLog createRPOkHttpConnectionExpLog = TrackLog.createRPOkHttpConnectionExpLog(str2, str);
            gy gyVar = this.mTrackLog;
            if (gyVar != null) {
                gyVar.collectLog(createRPOkHttpConnectionExpLog);
            }
        }
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncDownloadFile(Context context, final String str, final String str2, final ProgressCallback progressCallback) {
        this.mOkHttpClient.newCall(new RPRequest.Builder().url(str).build()).enqueue(new Callback() { // from class: com.alibaba.security.realidentity.http.RPOkHttpManager.1
            @Override // com.alibaba.security.common.http.ok.Callback
            public void onFailure(RPCall rPCall, IOException iOException) {
                progressCallback.onFailure(iOException);
            }

            /* JADX WARN: Removed duplicated region for block: B:49:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.alibaba.security.common.http.ok.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.alibaba.security.common.http.ok.RPCall r10, com.alibaba.security.common.http.ok.Response r11) throws java.io.IOException {
                /*
                    r9 = this;
                    r10 = 2048(0x800, float:2.87E-42)
                    byte[] r10 = new byte[r10]
                    java.io.File r0 = new java.io.File
                    java.lang.String r1 = r3
                    r0.<init>(r1)
                    boolean r1 = r0.exists()
                    if (r1 != 0) goto L14
                    r0.mkdirs()
                L14:
                    r0 = 0
                    com.alibaba.security.realidentity.http.RPOkHttpManager r1 = com.alibaba.security.realidentity.http.RPOkHttpManager.this     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
                    java.lang.String r2 = r4     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
                    java.lang.String r1 = r1.getFileName(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
                    com.alibaba.security.common.http.ok.ResponseBody r2 = r11.body()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
                    java.io.InputStream r2 = r2.byteStream()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
                    com.alibaba.security.common.http.ok.ResponseBody r11 = r11.body()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
                    long r3 = r11.contentLength()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
                    java.io.File r11 = new java.io.File     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
                    java.lang.String r5 = r3     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
                    r11.<init>(r5, r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
                    java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
                    r1.<init>(r11)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
                    r5 = 0
                L3b:
                    int r0 = r2.read(r10)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    r7 = -1
                    if (r0 == r7) goto L4e
                    r7 = 0
                    r1.write(r10, r7, r0)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    long r7 = (long) r0     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    long r5 = r5 + r7
                    com.alibaba.security.realidentity.http.ProgressCallback r0 = r2     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    r0.onProgress(r5, r3)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    goto L3b
                L4e:
                    r1.flush()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    com.alibaba.security.realidentity.http.ProgressCallback r10 = r2     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    r0 = 1
                    java.lang.String r11 = r11.getAbsolutePath()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    com.alibaba.security.realidentity.http.RpHttpResponse r11 = com.alibaba.security.realidentity.http.RpHttpResponse.create(r0, r11)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    r10.onResponse(r11)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
                    r2.close()     // Catch: java.io.IOException -> L62
                L62:
                    r1.close()     // Catch: java.io.IOException -> L65
                L65:
                    return
                L66:
                    r10 = move-exception
                    goto L6c
                L68:
                    r10 = move-exception
                    goto L70
                L6a:
                    r10 = move-exception
                    r1 = r0
                L6c:
                    r0 = r2
                    goto L8b
                L6e:
                    r10 = move-exception
                    r1 = r0
                L70:
                    r0 = r2
                    goto L77
                L72:
                    r10 = move-exception
                    r1 = r0
                    goto L8b
                L75:
                    r10 = move-exception
                    r1 = r0
                L77:
                    com.alibaba.security.realidentity.http.ProgressCallback r11 = r2     // Catch: java.lang.Throwable -> L8a
                    r11.onFailure(r10)     // Catch: java.lang.Throwable -> L8a
                    if (r0 == 0) goto L83
                    r0.close()     // Catch: java.io.IOException -> L82
                    goto L83
                L82:
                L83:
                    if (r1 == 0) goto L89
                    r1.close()     // Catch: java.io.IOException -> L89
                L89:
                    return
                L8a:
                    r10 = move-exception
                L8b:
                    if (r0 == 0) goto L92
                    r0.close()     // Catch: java.io.IOException -> L91
                    goto L92
                L91:
                L92:
                    if (r1 == 0) goto L97
                    r1.close()     // Catch: java.io.IOException -> L97
                L97:
                    throw r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.http.RPOkHttpManager.AnonymousClass1.onResponse(com.alibaba.security.common.http.ok.RPCall, com.alibaba.security.common.http.ok.Response):void");
            }
        });
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback, boolean z10) {
        doAsyncRequest(context, str, str2, HttpMethod.POST, iHttpCallback, z10);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2) {
        return doSyncRequest(context, str, HttpMethod.POST, str2, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback, boolean z10) {
        doAsyncRequest(context, str, str2, httpMethod, iHttpCallback, z10);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, HttpMethod httpMethod) {
        return doSyncRequest(context, str, httpMethod, str2, true);
    }

    private RPCall doAsyncRequest(RPRequest rPRequest, final String str, final IHttpCallback iHttpCallback, final boolean z10) {
        RPCall newCall = this.mOkHttpClient.newCall(rPRequest);
        newCall.enqueue(new Callback() { // from class: com.alibaba.security.realidentity.http.RPOkHttpManager.2
            @Override // com.alibaba.security.common.http.ok.Callback
            public void onFailure(RPCall rPCall, IOException iOException) {
                IHttpCallback iHttpCallback2 = iHttpCallback;
                if (iHttpCallback2 != null) {
                    iHttpCallback2.onFailure(iOException);
                }
                RPOkHttpManager.this.uploadErrorLog(str, "execute http exception: onFailure, " + CommonUtils.getStackTrace(iOException), z10);
            }

            @Override // com.alibaba.security.common.http.ok.Callback
            public void onResponse(RPCall rPCall, Response response) throws IOException {
                if (iHttpCallback != null) {
                    if (response == null) {
                        RPOkHttpManager.this.uploadErrorLog(str, "execute http exception: response is null", z10);
                        iHttpCallback.onResponse(null);
                    } else if (response.body() == null) {
                        RPOkHttpManager.this.uploadErrorLog(str, "execute http exception: response body is null", z10);
                        iHttpCallback.onResponse(null);
                    } else {
                        String string = response.body().string();
                        if (!response.isSuccessful()) {
                            RPOkHttpManager.this.uploadErrorLog(str, "execute http exception: response body is fail: ".concat(String.valueOf(string)), z10);
                        }
                        iHttpCallback.onResponse(RpHttpResponse.create(response.isSuccessful(), string));
                    }
                }
            }
        });
        return newCall;
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback) {
        doAsyncRequest(context, str2, str, HttpMethod.POST, iHttpCallback, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, boolean z10) {
        return doSyncRequest(context, str, HttpMethod.POST, str2, z10);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback) {
        doAsyncRequest(context, str, str2, httpMethod, iHttpCallback, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, HttpMethod httpMethod, boolean z10) {
        return doSyncRequest(context, str, httpMethod, str2, z10);
    }
}
