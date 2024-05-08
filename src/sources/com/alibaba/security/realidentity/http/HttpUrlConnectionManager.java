package com.alibaba.security.realidentity.http;

import android.content.Context;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.gy;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HttpUrlConnectionManager extends BaseHttpManager {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE;
    private static final ExecutorService THREAD_POOL_EXECUTOR;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final gy mTrackLog;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        CORE_POOL_SIZE = max;
        int i10 = (availableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE = i10;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        sPoolWorkQueue = linkedBlockingQueue;
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.alibaba.security.realidentity.http.HttpUrlConnectionManager.1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rp-sdk-http #" + this.mCount.getAndIncrement());
            }
        };
        sThreadFactory = threadFactory;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i10, 30L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public HttpUrlConnectionManager(gy gyVar) {
        this.mTrackLog = gyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseConnection createConnection(String str) throws Exception {
        if (new URL(str).getProtocol().toLowerCase().equals("https")) {
            return new HttpsConnection(str);
        }
        return new HttpConnection(str);
    }

    private void doAsyncRequest(final Context context, final String str, final String str2, final HttpMethod httpMethod, final IHttpCallback iHttpCallback, final boolean z10) {
        THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.alibaba.security.realidentity.http.HttpUrlConnectionManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpUrlConnectionManager httpUrlConnectionManager = HttpUrlConnectionManager.this;
                    RpHttpResponse doRequest = HttpUrlConnectionManager.this.doRequest(context, httpUrlConnectionManager.createConnection(httpUrlConnectionManager.getUrl(str)), str, str2, httpMethod, z10);
                    if (doRequest == null) {
                        IHttpCallback iHttpCallback2 = iHttpCallback;
                        if (iHttpCallback2 != null) {
                            iHttpCallback2.onFailure(new IOException("response data is null"));
                            return;
                        }
                        return;
                    }
                    IHttpCallback iHttpCallback3 = iHttpCallback;
                    if (iHttpCallback3 != null) {
                        iHttpCallback3.onResponse(doRequest);
                    }
                } catch (Exception e2) {
                    HttpUrlConnectionManager.this.uploadErrorLog(CommonUtils.getStackTrace(e2), str, z10);
                    IHttpCallback iHttpCallback4 = iHttpCallback;
                    if (iHttpCallback4 != null) {
                        iHttpCallback4.onFailure(e2);
                    }
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.security.realidentity.http.RpHttpResponse doPostRequest(java.lang.String r6, java.lang.String r7, java.net.HttpURLConnection r8, com.alibaba.security.realidentity.http.model.HttpMethod r9, boolean r10) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r9.toString()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r8.setRequestMethod(r1)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            com.alibaba.security.realidentity.http.model.HttpMethod r1 = com.alibaba.security.realidentity.http.model.HttpMethod.GET     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            boolean r9 = r9.equals(r1)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            if (r9 == 0) goto L13
            r8.connect()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
        L13:
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.lang.String r1 = "UTF-8"
            if (r9 != 0) goto L2f
            java.io.BufferedWriter r9 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.io.OutputStream r3 = r8.getOutputStream()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r9.<init>(r2)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r9.write(r7)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r9.close()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
        L2f:
            int r7 = r8.getResponseCode()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r9 = 200(0xc8, float:2.8E-43)
            if (r7 != r9) goto L7c
            java.io.InputStream r6 = r8.getInputStream()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            r9.<init>(r6, r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            r7.<init>(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d
            r9.<init>()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d
        L4a:
            java.lang.String r10 = r7.readLine()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d
            if (r10 == 0) goto L54
            r9.append(r10)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d
            goto L4a
        L54:
            r10 = 1
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d
            com.alibaba.security.realidentity.http.RpHttpResponse r9 = com.alibaba.security.realidentity.http.RpHttpResponse.create(r10, r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6d
            if (r6 == 0) goto L62
            r6.close()     // Catch: java.io.IOException -> L62
        L62:
            r7.close()     // Catch: java.io.IOException -> L65
        L65:
            r8.disconnect()
            return r9
        L69:
            r9 = move-exception
            r0 = r6
            r6 = r9
            goto Lb0
        L6d:
            r9 = move-exception
            r0 = r7
            r7 = r6
            r6 = r9
            goto Lab
        L72:
            r7 = move-exception
            r4 = r0
            r0 = r6
            r6 = r7
            goto Laf
        L77:
            r7 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
            goto Lab
        L7c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.lang.String r1 = "request fail and reponse msg is "
            r9.<init>(r1)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.lang.String r1 = r8.getResponseMessage()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r9.append(r1)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.lang.String r1 = " code is "
            r9.append(r1)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r9.append(r7)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.lang.String r7 = r9.toString()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r5.uploadErrorLog(r7, r6, r10)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r6 = 0
            java.lang.String r7 = r8.getResponseMessage()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            com.alibaba.security.realidentity.http.RpHttpResponse r6 = com.alibaba.security.realidentity.http.RpHttpResponse.create(r6, r7)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            r8.disconnect()
            return r6
        La6:
            r6 = move-exception
            r7 = r0
            goto Lb0
        La9:
            r6 = move-exception
            r7 = r0
        Lab:
            throw r6     // Catch: java.lang.Throwable -> Lac
        Lac:
            r6 = move-exception
            r4 = r0
            r0 = r7
        Laf:
            r7 = r4
        Lb0:
            if (r0 == 0) goto Lb7
            r0.close()     // Catch: java.io.IOException -> Lb6
            goto Lb7
        Lb6:
        Lb7:
            if (r7 == 0) goto Lbc
            r7.close()     // Catch: java.io.IOException -> Lbc
        Lbc:
            r8.disconnect()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.http.HttpUrlConnectionManager.doPostRequest(java.lang.String, java.lang.String, java.net.HttpURLConnection, com.alibaba.security.realidentity.http.model.HttpMethod, boolean):com.alibaba.security.realidentity.http.RpHttpResponse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RpHttpResponse doRequest(Context context, BaseConnection baseConnection, String str, String str2, HttpMethod httpMethod, boolean z10) throws Exception {
        HttpURLConnection uRLConnection = baseConnection.getURLConnection();
        if (uRLConnection == null) {
            uploadErrorLog("request fail by connection is null", str, z10);
            return RpHttpResponse.create(false, "connection is null");
        }
        setURLConnectionCommonPara(uRLConnection);
        setURLConnectionCookie(buildHeaders(context, str, httpMethod.toString(), str2), uRLConnection);
        return doPostRequest(str, str2, uRLConnection, httpMethod, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.security.realidentity.http.RpHttpResponse doRequestDownload(java.lang.String r10, java.lang.String r11, java.net.HttpURLConnection r12, com.alibaba.security.realidentity.http.ProgressCallback r13) throws java.lang.Exception {
        /*
            r9 = this;
            com.alibaba.security.realidentity.http.model.HttpMethod r0 = com.alibaba.security.realidentity.http.model.HttpMethod.GET
            java.lang.String r0 = r0.toString()
            r12.setRequestMethod(r0)
            r0 = 0
            r12.setDoOutput(r0)
            r12.connect()
            r1 = 0
            int r2 = r12.getResponseCode()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L88
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r2.<init>(r11)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            if (r3 != 0) goto L27
            r2.mkdirs()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
        L27:
            int r2 = r12.getContentLength()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.String r10 = r9.getFileName(r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r12.getContentType()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.io.InputStream r3 = r12.getInputStream()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            r4.<init>()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            r4.append(r11)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            java.lang.String r11 = java.io.File.separator     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            r4.append(r11)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            r4.append(r10)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            java.io.File r11 = new java.io.File     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L84
            r5 = 0
            r11 = 4096(0x1000, float:5.74E-42)
            byte[] r11 = new byte[r11]     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
        L5a:
            int r1 = r3.read(r11)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r7 = -1
            if (r1 == r7) goto L6d
            long r7 = (long) r1     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            long r5 = r5 + r7
            if (r2 <= 0) goto L69
            long r7 = (long) r2     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r13.onProgress(r5, r7)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
        L69:
            r4.write(r11, r0, r1)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            goto L5a
        L6d:
            r11 = 1
            com.alibaba.security.realidentity.http.RpHttpResponse r10 = com.alibaba.security.realidentity.http.RpHttpResponse.create(r11, r10)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r3.close()     // Catch: java.io.IOException -> L75
        L75:
            r4.close()     // Catch: java.io.IOException -> L78
        L78:
            r12.disconnect()
            return r10
        L7c:
            r10 = move-exception
            goto L82
        L7e:
            r10 = move-exception
            goto L86
        L80:
            r10 = move-exception
            r4 = r1
        L82:
            r1 = r3
            goto Lb8
        L84:
            r10 = move-exception
            r4 = r1
        L86:
            r1 = r3
            goto Lb6
        L88:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.String r13 = "request fail and response msg is "
            r10.<init>(r13)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.String r13 = r12.getResponseMessage()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r10.append(r13)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.String r13 = " code is "
            r10.append(r13)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r10.append(r2)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r9.uploadErrorLog(r10, r11)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            java.lang.String r10 = r12.getResponseMessage()     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            com.alibaba.security.realidentity.http.RpHttpResponse r10 = com.alibaba.security.realidentity.http.RpHttpResponse.create(r0, r10)     // Catch: java.lang.Throwable -> Lb1 java.lang.Exception -> Lb4
            r12.disconnect()
            return r10
        Lb1:
            r10 = move-exception
            r4 = r1
            goto Lb8
        Lb4:
            r10 = move-exception
            r4 = r1
        Lb6:
            throw r10     // Catch: java.lang.Throwable -> Lb7
        Lb7:
            r10 = move-exception
        Lb8:
            if (r1 == 0) goto Lbf
            r1.close()     // Catch: java.io.IOException -> Lbe
            goto Lbf
        Lbe:
        Lbf:
            if (r4 == 0) goto Lc4
            r4.close()     // Catch: java.io.IOException -> Lc4
        Lc4:
            r12.disconnect()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.http.HttpUrlConnectionManager.doRequestDownload(java.lang.String, java.lang.String, java.net.HttpURLConnection, com.alibaba.security.realidentity.http.ProgressCallback):com.alibaba.security.realidentity.http.RpHttpResponse");
    }

    private RpHttpResponse doSyncRequest(Context context, String str, String str2, HttpMethod httpMethod, boolean z10) {
        try {
            return doRequest(context, createConnection(getUrl(str)), str, str2, httpMethod, z10);
        } catch (Exception e2) {
            uploadErrorLog(CommonUtils.getStackTrace(e2), str, z10);
            return null;
        }
    }

    private void setURLConnectionCommonPara(HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setUseCaches(false);
    }

    private void setURLConnectionCookie(Map<String, Object> map, HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadErrorLog(String str, String str2, boolean z10) {
        if (z10) {
            HashMap hashMap = new HashMap();
            hashMap.put("params", str);
            hashMap.put("path", str2);
            TrackLog createHttpUrlConnectionLog = TrackLog.createHttpUrlConnectionLog(JsonUtils.toJSON(hashMap));
            gy gyVar = this.mTrackLog;
            if (gyVar != null) {
                gyVar.collectLog(createHttpUrlConnectionLog);
            }
        }
    }

    private void uploadRequestLog(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("path", str);
        TrackLog createHttpRequestLog = TrackLog.createHttpRequestLog(JsonUtils.toJSON(hashMap));
        gy gyVar = this.mTrackLog;
        if (gyVar != null) {
            gyVar.collectLog(createHttpRequestLog);
        }
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncDownloadFile(Context context, final String str, final String str2, final ProgressCallback progressCallback) {
        THREAD_POOL_EXECUTOR.submit(new Runnable() { // from class: com.alibaba.security.realidentity.http.HttpUrlConnectionManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection uRLConnection = HttpUrlConnectionManager.this.createConnection(str).getURLConnection();
                    if (uRLConnection == null) {
                        HttpUrlConnectionManager.this.uploadErrorLog("request fail by connection is null", str);
                        progressCallback.onResponse(RpHttpResponse.create(false, "connection is null"));
                        return;
                    }
                    RpHttpResponse doRequestDownload = HttpUrlConnectionManager.this.doRequestDownload(str, str2, uRLConnection, progressCallback);
                    if (doRequestDownload == null) {
                        ProgressCallback progressCallback2 = progressCallback;
                        if (progressCallback2 != null) {
                            progressCallback2.onFailure(new IOException("response data is null"));
                            return;
                        }
                        return;
                    }
                    ProgressCallback progressCallback3 = progressCallback;
                    if (progressCallback3 != null) {
                        progressCallback3.onResponse(doRequestDownload);
                    }
                } catch (Exception e2) {
                    HttpUrlConnectionManager.this.uploadErrorLog(CommonUtils.getStackTrace(e2), str);
                    ProgressCallback progressCallback4 = progressCallback;
                    if (progressCallback4 != null) {
                        progressCallback4.onFailure(e2);
                    }
                }
            }
        });
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback) {
        doAsyncRequest(context, str, str2, HttpMethod.POST, iHttpCallback, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2) {
        return doSyncRequest(context, str, str2, HttpMethod.POST, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback) {
        doAsyncRequest(context, str, str2, httpMethod, iHttpCallback, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, HttpMethod httpMethod) {
        return doSyncRequest(context, str, str2, httpMethod, true);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, IHttpCallback iHttpCallback, boolean z10) {
        doAsyncRequest(context, str, str2, HttpMethod.POST, iHttpCallback, z10);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, boolean z10) {
        return doSyncRequest(context, str, str2, HttpMethod.POST, z10);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public void asyncRequest(Context context, String str, String str2, HttpMethod httpMethod, IHttpCallback iHttpCallback, boolean z10) {
        doAsyncRequest(context, str, str2, httpMethod, iHttpCallback, z10);
    }

    @Override // com.alibaba.security.realidentity.http.IHttpManager
    public RpHttpResponse syncRequest(Context context, String str, String str2, HttpMethod httpMethod, boolean z10) {
        return doSyncRequest(context, str, str2, httpMethod, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadErrorLog(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("params", str);
        hashMap.put("path", str2);
        TrackLog createHttpUrlConnectionLog = TrackLog.createHttpUrlConnectionLog(JsonUtils.toJSON(hashMap));
        gy gyVar = this.mTrackLog;
        if (gyVar != null) {
            gyVar.collectLog(createHttpUrlConnectionLog);
        }
    }
}
