package com.huawei.hianalytics.framework.config;

import com.huawei.hianalytics.core.transport.net.Response;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ReportManager {
    Response sendPostRequest(byte[] bArr, Map<String, String> map, String str);
}
