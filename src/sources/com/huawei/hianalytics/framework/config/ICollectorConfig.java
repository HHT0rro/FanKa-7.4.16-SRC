package com.huawei.hianalytics.framework.config;

import com.huawei.hianalytics.core.storage.Event;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ICollectorConfig {
    String getAppId();

    String[] getCollectUrls(String str);

    DeviceAttributeCollector getDeviceAttribute(String str);

    EvtHeaderAttributeCollector getEvtCustomHeader(String str, JSONObject jSONObject);

    Map<String, String> getHttpHeader(String str);

    ReportManager getReportManager();

    RomAttributeCollector getRomAttribute(String str, String str2);

    ServerAddrGetTask getServerAddrGetTask();

    Event getSpecialEvent(String str);

    boolean isEnableSession(String str);

    boolean isEncrypted(String str);
}
