package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.net.HttpTransportHandler;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.config.ReportManager;
import com.huawei.hianalytics.framework.data.ConfigManager;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class u implements ReportManager {
    public static u klm;
    public Map<String, t> lmn = new ConcurrentHashMap();

    public static u lmn() {
        if (klm == null) {
            synchronized (u.class) {
                if (klm == null) {
                    klm = new u();
                }
            }
        }
        return klm;
    }

    @Override // com.huawei.hianalytics.framework.config.ReportManager
    public Response sendPostRequest(byte[] bArr, Map<String, String> map, String str) {
        Response response;
        t tVar = this.lmn.get(str);
        if (tVar == null) {
            HiLog.i("ReportManager", "report instance is null");
            return new Response(-100, "");
        }
        int size = tVar.klm.size();
        for (int i10 = 0; i10 < size; i10++) {
            v vVar = tVar.klm.get(i10);
            if (vVar.klm < 5) {
                String[] strArr = {vVar.lmn};
                HttpTransportHandler httpTransportHandler = new HttpTransportHandler();
                IMandatoryParameters parameters = ConfigManager.getInstance().getParameters();
                httpTransportHandler.setUrls(strArr);
                httpTransportHandler.setReportData(bArr);
                httpTransportHandler.setHttpHeaders(map);
                httpTransportHandler.setSSLConfig(parameters.getContext(), parameters.getProtocols(), parameters.getCaCertificatePath(), parameters.isHighCipher());
                try {
                    response = httpTransportHandler.execute();
                } catch (Exception e2) {
                    if (e2 instanceof SecurityException) {
                        response = e9.a.a("ReportInstance", HiLog.ErrorCode.NE003, "No Permission：INTERNET.", Response.Code.INTERNET_PERMISSION_ERROR, "");
                    } else if (e2 instanceof SSLPeerUnverifiedException) {
                        response = e9.a.a("ReportInstance", HiLog.ErrorCode.NE002, "Certificate has not been verified,Request is restricted!", Response.Code.SSL_VALIDATION_ERROR, "");
                    } else if (e2 instanceof SSLHandshakeException) {
                        response = e9.a.a("ReportInstance", HiLog.ErrorCode.NE002, "Chain validation failed,Certificate expired", Response.Code.SSL_VALIDATION_ERROR, "");
                    } else if (e2 instanceof ConnectException) {
                        response = e9.a.a("ReportInstance", HiLog.ErrorCode.NE005, "Network is unreachable or Connection refused", Response.Code.CONNECTION_ERROR, "");
                    } else if (e2 instanceof UnknownHostException) {
                        response = e9.a.a("ReportInstance", HiLog.ErrorCode.NE006, "Invalid URL.No address associated with hostname", -104, "");
                    } else {
                        if (e2 instanceof IOException) {
                            StringBuilder b4 = e9.a.b("IO Exception.");
                            b4.append(e2.getMessage());
                            HiLog.e("ReportInstance", HiLog.ErrorCode.NE004, b4.toString());
                        } else {
                            StringBuilder b10 = e9.a.b("other Exception:");
                            b10.append(e2.getMessage());
                            HiLog.e("ReportInstance", b10.toString());
                        }
                        response = new Response(Response.Code.TIMEOUT_OR_OTHER_ERROR, "");
                    }
                }
                StringBuilder b11 = e9.a.b("response code : ");
                b11.append(response.getHttpCode());
                HiLog.i("ReportInstance", b11.toString());
                if (-104 != response.getHttpCode()) {
                    return response;
                }
                vVar.klm++;
            } else {
                StringBuilder b12 = e9.a.b("ReportInstance ");
                b12.append(tVar.lmn);
                HiLog.i(b12.toString(), "No." + i10 + " address failed more than 5 times. Try with backup address...");
            }
        }
        StringBuilder b13 = e9.a.b("ReportInstance ");
        b13.append(tVar.lmn);
        HiLog.i(b13.toString(), "All backup address not valid.");
        return new Response(Response.Code.BACKUP_ADDRESS_INVALID, "");
    }

    public synchronized void lmn(String str, String[] strArr) {
        HiLog.i("ReportManager", "ReportManager:init instance with url");
        t tVar = new t(str);
        for (String str2 : strArr) {
            tVar.klm.add(new v(str2));
        }
        this.lmn.put(str, tVar);
    }
}
