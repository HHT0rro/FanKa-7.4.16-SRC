package f0;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {
    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.d();
        dataReportRequest.rpcVersion = dVar.a();
        dataReportRequest.bizType = "1";
        HashMap hashMap = new HashMap();
        dataReportRequest.bizData = hashMap;
        hashMap.put("apdid", dVar.f());
        dataReportRequest.bizData.put("apdidToken", dVar.h());
        dataReportRequest.bizData.put("umidToken", dVar.j());
        dataReportRequest.bizData.put("dynamicKey", dVar.n());
        dataReportRequest.deviceData = dVar.l();
        return dataReportRequest;
    }

    public static c b(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f49086a = dataReportResult.success;
        cVar.f49087b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.f49088c = map.get("apdid");
            cVar.f49089d = map.get("apdidToken");
            cVar.f49092g = map.get("dynamicKey");
            cVar.f49093h = map.get("timeInterval");
            cVar.f49094i = map.get("webrtcUrl");
            cVar.f49095j = "";
            String str = map.get("drmSwitch");
            if (z.a.g(str)) {
                if (str.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(0));
                    cVar.f49090e = sb2.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str.charAt(2));
                    cVar.f49091f = sb3.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.b(map.get("apse_degrade"));
            }
        }
        return cVar;
    }
}
