package com.huawei.hianalytics.framework.datahandler;

import android.text.TextUtils;
import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.transport.net.HttpTransportHandler;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.data.ConfigManager;
import com.huawei.hianalytics.framework.h;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public String f28795a;

    /* renamed from: b, reason: collision with root package name */
    public String f28796b;

    /* renamed from: c, reason: collision with root package name */
    public Event f28797c;

    /* renamed from: d, reason: collision with root package name */
    public ICallback f28798d;

    /* renamed from: e, reason: collision with root package name */
    public String f28799e;

    public b(String str, String str2, Event event, String str3, ICallback iCallback) {
        this.f28795a = str;
        this.f28796b = str2;
        this.f28797c = event;
        this.f28798d = iCallback;
        this.f28799e = str3;
    }

    private void a(byte[] bArr, String str) {
        Response a10;
        IMandatoryParameters parameters = ConfigManager.getInstance().getParameters();
        HttpTransportHandler httpTransportHandler = new HttpTransportHandler();
        if (TextUtils.isEmpty(a(parameters)[0]) || a(parameters)[0].equals(".none.")) {
            HiLog.sw("DebugReportTask", "Debug Mode No report address,TAG : %s,TYPE: %s ", this.f28795a, this.f28796b);
            return;
        }
        httpTransportHandler.setUrls(a(parameters));
        httpTransportHandler.setReportData(bArr);
        httpTransportHandler.setHttpHeaders(a(str));
        httpTransportHandler.setSSLConfig(parameters.getContext(), parameters.getProtocols(), parameters.getCaCertificatePath(), parameters.isHighCipher());
        try {
            a10 = httpTransportHandler.execute();
        } catch (Exception e2) {
            a10 = a(e2);
        }
        int httpCode = a10.getHttpCode();
        if (this.f28798d != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f28797c);
            this.f28798d.onResult(httpCode, currentTimeMillis, arrayList);
        }
        HiLog.si("DebugReportTask", "Debug events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + str, this.f28796b, this.f28795a, Integer.valueOf(httpCode));
    }

    private Map<String, String> b(String str) {
        ICollectorConfig config = ConfigManager.getInstance().getConfig(this.f28795a);
        String appVer = ConfigManager.getInstance().getParameters().getAppVer();
        String model = ConfigManager.getInstance().getParameters().getModel();
        HashMap hashMap = new HashMap();
        hashMap.put("x-hasdk-debug", "true");
        hashMap.put("App-Id", config.getAppId());
        hashMap.put("App-Ver", appVer);
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "3.0.1.501");
        hashMap.put("Device-Type", model);
        hashMap.put("servicetag", this.f28795a);
        HiLog.i("DebugReportTask", "Debug sendData RequestId : " + str + ",TAG : %s,TYPE: %s ", this.f28795a, this.f28796b);
        hashMap.put("Request-Id", str);
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        String initRandomKey = HexUtil.initRandomKey(16);
        com.huawei.hianalytics.framework.d a10 = a(this.f28796b, initRandomKey);
        if (a10 == null) {
            HiLog.sw("DebugReportTask", "Debug uploadEvtModel is null，TAG: %s,TYPE: %s", this.f28795a, this.f28796b);
            return;
        }
        byte[] a11 = a(a10, this.f28797c);
        if (a11.length == 0) {
            HiLog.sw("DebugReportTask", "Debug request body is empty，TAG: %s,TYPE: %s", this.f28795a, this.f28796b);
        } else {
            a(a11, initRandomKey);
        }
    }

    private String[] a(IMandatoryParameters iMandatoryParameters) {
        String debugModeUrl = iMandatoryParameters.getDebugModeUrl();
        String[] strArr = new String[1];
        if (!TextUtils.isEmpty(debugModeUrl) && !debugModeUrl.equals(".none.")) {
            strArr[0] = debugModeUrl;
            if (FrameworkConstant.DataType.STRING_OPER.equals(this.f28796b)) {
                strArr[0] = FrameworkConstant.HttpUrls.OPER_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, strArr[0]);
            } else if (FrameworkConstant.DataType.STRING_MAINT.equals(this.f28796b)) {
                strArr[0] = FrameworkConstant.HttpUrls.MAINT_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, strArr[0]);
            } else if (FrameworkConstant.DataType.STRING_DIFFPRIVACY.equals(this.f28796b)) {
                strArr[0] = FrameworkConstant.HttpUrls.DIFFPRC_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, strArr[0]);
            } else if (FrameworkConstant.DataType.STRING_PREINS.equals(this.f28796b)) {
                strArr[0] = FrameworkConstant.HttpUrls.PREINS_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, strArr[0]);
            } else {
                strArr[0] = FrameworkConstant.HttpUrls.OPER_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, strArr[0]);
            }
            return strArr;
        }
        HiLog.si("DebugReportTask", "Debug Mode Url is empty");
        return strArr;
    }

    private com.huawei.hianalytics.framework.d a(String str, String str2) {
        com.huawei.hianalytics.framework.data.b.b().b(this.f28795a, str);
        if (com.huawei.hianalytics.framework.data.b.b().a() == null || com.huawei.hianalytics.framework.data.b.b().a().isEmpty()) {
            return null;
        }
        ICollectorConfig config = ConfigManager.getInstance().getConfig(this.f28795a);
        return new com.huawei.hianalytics.framework.d(config.getDeviceAttribute(str), config.getEvtCustomHeader(str, a(config.getAppId(), str2, str, com.huawei.hianalytics.framework.data.b.b().a())), config.getRomAttribute(str, ""), com.huawei.hianalytics.framework.data.b.b().d(), this.f28795a, str);
    }

    private JSONObject a(String str, String str2, String str3, String str4) {
        com.huawei.hianalytics.framework.c cVar = new com.huawei.hianalytics.framework.c();
        cVar.a(str);
        cVar.b(str4);
        cVar.d(str2);
        cVar.f(this.f28795a);
        StringBuffer stringBuffer = new StringBuffer(FrameworkConstant.HMSHI);
        stringBuffer.append(str3);
        stringBuffer.append(FrameworkConstant.QRT);
        cVar.e(stringBuffer.toString());
        cVar.g(System.currentTimeMillis() + "");
        return cVar.a();
    }

    private byte[] a(com.huawei.hianalytics.framework.d dVar, Event event) {
        try {
            JSONObject a10 = dVar.a(event, this.f28799e);
            if (a10 != null) {
                return h.a(a10.toString().getBytes("UTF-8"));
            }
            HiLog.sw("DebugReportTask", "Debug uploadEvents is null，TAG: %s,TYPE: %s", this.f28795a, this.f28796b);
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            HiLog.e("DebugReportTask", "Debug sendData(): getBytes - Unsupported coding format!!，TAG: %s,TYPE: %s", this.f28795a, this.f28796b);
            return new byte[0];
        } catch (JSONException unused2) {
            HiLog.e("DebugReportTask", "Debug json exception，TAG: %s,TYPE: %s", this.f28795a, this.f28796b);
            return new byte[0];
        }
    }

    private Map<String, String> a(String str) {
        ICollectorConfig config = ConfigManager.getInstance().getConfig(this.f28795a);
        Map<String, String> b4 = b(str);
        Map<String, String> httpHeader = config.getHttpHeader(this.f28796b);
        if (httpHeader != null) {
            b4.putAll(httpHeader);
        }
        return b4;
    }

    private Response a(Exception exc) {
        if (exc instanceof SecurityException) {
            return e9.a.a("DebugReportTask", HiLog.ErrorCode.NE003, "No Permission：INTERNET.", Response.Code.INTERNET_PERMISSION_ERROR, "");
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return e9.a.a("DebugReportTask", HiLog.ErrorCode.NE002, "Certificate has not been verified,Request is restricted!", Response.Code.SSL_VALIDATION_ERROR, "");
        }
        if (exc instanceof SSLHandshakeException) {
            return e9.a.a("DebugReportTask", HiLog.ErrorCode.NE002, "Chain validation failed,Certificate expired", Response.Code.SSL_VALIDATION_ERROR, "");
        }
        if (exc instanceof ConnectException) {
            return e9.a.a("DebugReportTask", HiLog.ErrorCode.NE005, "Network is unreachable or Connection refused", Response.Code.CONNECTION_ERROR, "");
        }
        if (exc instanceof UnknownHostException) {
            return e9.a.a("DebugReportTask", HiLog.ErrorCode.NE006, "Invalid URL.No address associated with hostname", -104, "");
        }
        if (exc instanceof IOException) {
            StringBuilder b4 = e9.a.b("IO Exception.");
            b4.append(exc.getMessage());
            HiLog.e("DebugReportTask", HiLog.ErrorCode.NE004, b4.toString());
        } else {
            StringBuilder b10 = e9.a.b("other Exception:");
            b10.append(exc.getMessage());
            HiLog.e("DebugReportTask", b10.toString());
        }
        return new Response(Response.Code.TIMEOUT_OR_OTHER_ERROR, "");
    }
}
