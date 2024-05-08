package com.huawei.hianalytics.framework.datahandler;

import android.text.TextUtils;
import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.core.transport.net.HttpTransportHandler;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.data.ConfigManager;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f28818a;

    /* renamed from: b, reason: collision with root package name */
    public String f28819b;

    /* renamed from: c, reason: collision with root package name */
    public String f28820c;

    /* renamed from: d, reason: collision with root package name */
    public String f28821d;

    /* renamed from: e, reason: collision with root package name */
    public List<Event> f28822e;

    /* renamed from: f, reason: collision with root package name */
    public ICallback f28823f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f28824g;

    public f(byte[] bArr, String str, String str2, String str3, List<Event> list) {
        this.f28818a = (byte[]) bArr.clone();
        this.f28819b = str;
        this.f28820c = str3;
        this.f28821d = str2;
        this.f28822e = list;
    }

    private void a(IStorageHandler iStorageHandler) {
        IMandatoryParameters parameters = ConfigManager.getInstance().getParameters();
        if (parameters.isFlashKey() && iStorageHandler.readEventsAll().size() == 0) {
            parameters.refreshKey(HexUtil.initRandomKey(16), 1);
            iStorageHandler.deleteCommonHeaderExAll();
        }
    }

    private Map<String, String> b() {
        ICollectorConfig config = ConfigManager.getInstance().getConfig(this.f28819b);
        Map<String, String> a10 = a(this.f28820c);
        Map<String, String> httpHeader = config.getHttpHeader(this.f28821d);
        if (httpHeader != null) {
            a10.putAll(httpHeader);
        }
        return a10;
    }

    @Override // java.lang.Runnable
    public void run() {
        Response a10;
        IStorageHandler c4;
        IStorageHandler c10;
        List<Event> list;
        HiLog.i("SendTask", "send data running，TAG: %s,TYPE: %s", this.f28819b, this.f28821d);
        long currentTimeMillis = System.currentTimeMillis();
        IMandatoryParameters parameters = ConfigManager.getInstance().getParameters();
        if (FrameworkConstant.DataType.STRING_PREINS.equals(this.f28821d) && parameters.getPreInstallURL().length == 0) {
            StringBuilder b4 = e9.a.b("upload url now : preins ,reqID:");
            b4.append(this.f28820c);
            b4.append("，TAG: %s,TYPE: %s");
            HiLog.si("SendTask", b4.toString(), this.f28819b, this.f28821d);
            ConfigManager.getInstance().getConfig(this.f28819b).getServerAddrGetTask().run();
        }
        HttpTransportHandler httpTransportHandler = new HttpTransportHandler();
        if (FrameworkConstant.DataType.STRING_PREINS.equals(this.f28821d) && parameters.getPreInstallURL().length > 0) {
            a10 = ConfigManager.getInstance().getConfig(this.f28819b).getReportManager().sendPostRequest(this.f28818a, b(), this.f28819b);
        } else {
            if (TextUtils.isEmpty(a()[0])) {
                HiLog.w("SendTask", "No report address,TAG : %s,TYPE: %s ", this.f28819b, this.f28821d);
                return;
            }
            httpTransportHandler.setUrls(a());
            httpTransportHandler.setReportData(this.f28818a);
            httpTransportHandler.setHttpHeaders(b());
            httpTransportHandler.setSSLConfig(parameters.getContext(), parameters.getProtocols(), parameters.getCaCertificatePath(), parameters.isHighCipher());
            try {
                a10 = httpTransportHandler.execute();
            } catch (Exception e2) {
                a10 = a(e2);
            }
        }
        int httpCode = a10.getHttpCode();
        try {
            if (httpCode == 200) {
                if (!this.f28824g && (c10 = com.huawei.hianalytics.framework.b.c(this.f28819b)) != null && (list = this.f28822e) != null && list.size() > 0) {
                    HiLog.i("SendTask", "storageHandler deleteEvents,TAG : %s,TYPE: %s ", this.f28819b, this.f28821d);
                    c10.deleteEvents(this.f28822e);
                    a(c10);
                }
            } else if (this.f28824g && (c4 = com.huawei.hianalytics.framework.b.c(this.f28819b)) != null) {
                for (Event event : this.f28822e) {
                    event.setContent(a.b(event.getContent(), parameters));
                    a(c4, event);
                }
            }
            ICallback iCallback = this.f28823f;
            if (iCallback != null) {
                iCallback.onResult(httpCode, currentTimeMillis, this.f28822e);
            }
            StringBuilder b10 = e9.a.b("events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:");
            b10.append(this.f28820c);
            HiLog.si("SendTask", b10.toString(), this.f28821d, this.f28819b, Integer.valueOf(httpCode));
        } catch (Throwable th) {
            ICallback iCallback2 = this.f28823f;
            if (iCallback2 != null) {
                iCallback2.onResult(httpCode, currentTimeMillis, this.f28822e);
            }
            StringBuilder b11 = e9.a.b("events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:");
            b11.append(this.f28820c);
            HiLog.si("SendTask", b11.toString(), this.f28821d, this.f28819b, Integer.valueOf(httpCode));
            throw th;
        }
    }

    private String[] a() {
        String[] collectUrls = ConfigManager.getInstance().getConfig(this.f28819b).getCollectUrls(this.f28821d);
        for (int i10 = 0; i10 < collectUrls.length; i10++) {
            if (FrameworkConstant.DataType.STRING_OPER.equals(this.f28821d)) {
                collectUrls[i10] = FrameworkConstant.HttpUrls.OPER_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, collectUrls[i10]);
            } else if (FrameworkConstant.DataType.STRING_MAINT.equals(this.f28821d)) {
                collectUrls[i10] = FrameworkConstant.HttpUrls.MAINT_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, collectUrls[i10]);
            } else if (FrameworkConstant.DataType.STRING_DIFFPRIVACY.equals(this.f28821d)) {
                collectUrls[i10] = FrameworkConstant.HttpUrls.DIFFPRC_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, collectUrls[i10]);
            } else if (FrameworkConstant.DataType.STRING_PREINS.equals(this.f28821d)) {
                collectUrls[i10] = FrameworkConstant.HttpUrls.PREINS_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, collectUrls[i10]);
            } else {
                collectUrls[i10] = FrameworkConstant.HttpUrls.OPER_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, collectUrls[i10]);
            }
        }
        return collectUrls;
    }

    private Response a(Exception exc) {
        if (exc instanceof SecurityException) {
            return e9.a.a("SendTask", HiLog.ErrorCode.NE003, "No Permission：INTERNET.", Response.Code.INTERNET_PERMISSION_ERROR, "");
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return e9.a.a("SendTask", HiLog.ErrorCode.NE002, "Certificate has not been verified,Request is restricted!", Response.Code.SSL_VALIDATION_ERROR, "");
        }
        if (exc instanceof SSLHandshakeException) {
            return e9.a.a("SendTask", HiLog.ErrorCode.NE002, "Chain validation failed,Certificate expired", Response.Code.SSL_VALIDATION_ERROR, "");
        }
        if (exc instanceof ConnectException) {
            return e9.a.a("SendTask", HiLog.ErrorCode.NE005, "Network is unreachable or Connection refused", Response.Code.CONNECTION_ERROR, "");
        }
        if (exc instanceof UnknownHostException) {
            return e9.a.a("SendTask", HiLog.ErrorCode.NE006, "Invalid URL.No address associated with hostname", -104, "");
        }
        if (exc instanceof IOException) {
            StringBuilder b4 = e9.a.b("IO Exception.");
            b4.append(exc.getMessage());
            HiLog.e("SendTask", HiLog.ErrorCode.NE004, b4.toString());
        } else {
            StringBuilder b10 = e9.a.b("other Exception:");
            b10.append(exc.getMessage());
            HiLog.e("SendTask", b10.toString());
        }
        return new Response(Response.Code.TIMEOUT_OR_OTHER_ERROR, "");
    }

    private Map<String, String> a(String str) {
        ICollectorConfig config = ConfigManager.getInstance().getConfig(this.f28819b);
        String appVer = ConfigManager.getInstance().getParameters().getAppVer();
        String model = ConfigManager.getInstance().getParameters().getModel();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", config.getAppId());
        hashMap.put("App-Ver", appVer);
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "3.0.1.501");
        hashMap.put("Device-Type", model);
        hashMap.put("servicetag", this.f28819b);
        HiLog.i("SendTask", "sendData RequestId : " + str + ",TAG : %s,TYPE: %s ", this.f28819b, this.f28821d);
        hashMap.put("Request-Id", str);
        return hashMap;
    }

    public void a(ICallback iCallback) {
        this.f28823f = iCallback;
    }

    public void a(boolean z10) {
        this.f28824g = z10;
    }

    private void a(IStorageHandler iStorageHandler, Event event) {
        IStoragePolicy d10 = com.huawei.hianalytics.framework.b.d(this.f28819b);
        if (iStorageHandler == null || d10 == null) {
            HiLog.e("SendTask", "cache failed , storageHandler is null!，TAG : %s,TYPE: %s ", this.f28819b, this.f28821d);
            return;
        }
        if (d10.decide(IStoragePolicy.PolicyType.STORAGELENGTH, this.f28821d)) {
            HiLog.e("SendTask", "cache failed , db file reach max limited length,clear db file，TAG : %s,TYPE: %s ", this.f28819b, this.f28821d);
            iStorageHandler.deleteAll();
            iStorageHandler.insert(event);
            return;
        }
        long readEventSize = iStorageHandler.readEventSize(this.f28819b);
        if (readEventSize == 0) {
            iStorageHandler.insert(event);
        } else {
            if (readEventSize > 5000) {
                HiLog.e("SendTask", "cache failed , db file reach max limited size,clear db file，TAG : %s,TYPE: %s ", this.f28819b, this.f28821d);
                iStorageHandler.deleteByTag(this.f28819b);
                iStorageHandler.insert(event);
                return;
            }
            iStorageHandler.insert(event);
        }
    }
}
