package com.huawei.appgallery.agd.serverreq.utils;

import android.content.Context;
import android.webkit.WebSettings;
import com.alibaba.security.realidentity.build.cs;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.utils.FileUtil;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.appgallery.agd.serverreq.ServerReqLog;
import com.huawei.appgallery.agd.serverreq.http.OKHttpManager;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ConcurrentModificationException;
import java.util.zip.GZIPOutputStream;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HttpUtil {

    /* renamed from: a, reason: collision with root package name */
    public Call f27545a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f27546b = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class GZIPUtil {
        public static byte[] gzipData(byte[] bArr) {
            DataOutputStream dataOutputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
                    try {
                        dataOutputStream.write(bArr, 0, bArr.length);
                        dataOutputStream.flush();
                    } catch (IOException e2) {
                        e = e2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            ServerReqLog.LOG.e("GZIPUtil", "gzip error!", e);
                            byteArrayOutputStream = byteArrayOutputStream2;
                            FileUtil.close(dataOutputStream);
                            FileUtil.close(byteArrayOutputStream);
                            return byteArrayOutputStream.toByteArray();
                        } catch (Throwable th) {
                            th = th;
                            FileUtil.close(dataOutputStream);
                            FileUtil.close(byteArrayOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        FileUtil.close(dataOutputStream);
                        FileUtil.close(byteArrayOutputStream2);
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    dataOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                }
            } catch (IOException e11) {
                e = e11;
                dataOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
            }
            FileUtil.close(dataOutputStream);
            FileUtil.close(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class HttpResponseParams {

        /* renamed from: a, reason: collision with root package name */
        public String f27547a;

        /* renamed from: b, reason: collision with root package name */
        public int f27548b;

        public int getResponseCode() {
            return this.f27548b;
        }

        public String getResponseMsg() {
            return this.f27547a;
        }
    }

    public final String a() {
        Context context;
        ApplicationWrapper applicationWrapper = ApplicationWrapper.getInstance();
        return (applicationWrapper == null || (context = applicationWrapper.getContext()) == null) ? "" : WebSettings.getDefaultUserAgent(context);
    }

    public void abort() {
        Call call = this.f27545a;
        if (call != null) {
            try {
                call.cancel();
            } catch (Exception e2) {
                ServerReqLog.LOG.e("HttpUtil", "httputil abort exception:" + e2.getMessage());
            }
        }
    }

    public final void b(Response response, HttpResponseParams httpResponseParams) throws IOException {
        if (response.isSuccessful()) {
            httpResponseParams.f27547a = response.body().string();
            return;
        }
        ServerReqLog.LOG.e("HttpUtil", "bad response:" + httpResponseParams.f27548b);
    }

    public HttpResponseParams doPost(String str, String str2, String str3, String str4) throws IOException {
        return doPost(str, str2, str3, str4, "application/x-gzip");
    }

    public HttpResponseParams doPost(String str, String str2, String str3, String str4, String str5) throws IOException {
        ServerReqLog serverReqLog;
        StringBuilder sb2;
        HttpResponseParams httpResponseParams = new HttpResponseParams();
        Response response = null;
        try {
            try {
                OkHttpClient okHttpClient = OKHttpManager.getOkHttpClient(this.f27546b);
                byte[] bytes = str3.getBytes("UTF-8");
                if ("application/x-gzip".equals(str5)) {
                    bytes = GZIPUtil.gzipData(bytes);
                }
                Request.Builder post = new Request.Builder().url(str).post(RequestBody.create(MediaType.parse(str5), bytes));
                post.addHeader("Content-Type", str5);
                if ("application/x-gzip".equals(str5)) {
                    post.addHeader("Content-Encoding", "gzip");
                }
                post.addHeader(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
                post.addHeader("User-Agent", str4);
                String a10 = a();
                post.addHeader("sysUserAgent", a10);
                ServerReqLog.LOG.i("HttpUtil", "User-Agent: " + str4 + " sysUserAgent: " + a10);
                if (!StringUtils.isBlank(str2)) {
                    post.addHeader(cs.U, str2);
                }
                Call newCall = okHttpClient.newCall(post.build());
                this.f27545a = newCall;
                response = newCall.execute();
                httpResponseParams.f27548b = response.code();
                b(response, httpResponseParams);
            } catch (UnsupportedEncodingException e2) {
                serverReqLog = ServerReqLog.LOG;
                sb2 = new StringBuilder();
                sb2.append("doPost UnsupportedEncodingException error:");
                sb2.append(e2.getMessage());
                serverReqLog.e("HttpUtil", sb2.toString());
            } catch (IllegalStateException e10) {
                serverReqLog = ServerReqLog.LOG;
                sb2 = new StringBuilder();
                sb2.append("doPost IllegalStateException error:");
                sb2.append(e10.getMessage());
                serverReqLog.e("HttpUtil", sb2.toString());
            } catch (ConcurrentModificationException unused) {
                ServerReqLog.LOG.e("HttpUtil", "doPost ConcurrentModificationException error:");
            }
            return httpResponseParams;
        } finally {
            FileUtil.close(response);
        }
    }

    public void setTargetServer(String str) {
        this.f27546b = str;
    }
}
