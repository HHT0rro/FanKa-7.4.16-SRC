package com.huawei.appgallery.agd.common.report;

import com.huawei.appgallery.agd.common.CommonLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReportUtils {
    public static String mapToJson(Map map) {
        if (map == null) {
            CommonLog.LOG.e("ReportUtils", "input is null!");
            return null;
        }
        try {
            return new JSONObject(map).toString();
        } catch (Exception e2) {
            CommonLog.LOG.e("ReportUtils", "mapToJson error: " + e2.getMessage());
            return null;
        }
    }
}
