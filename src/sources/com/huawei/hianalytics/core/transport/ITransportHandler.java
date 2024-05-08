package com.huawei.hianalytics.core.transport;

import android.content.Context;
import com.huawei.hianalytics.core.transport.net.Response;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ITransportHandler {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Protocols {
        TLS1_2("TLSv1.2"),
        TLS1_3("TLSv1.3");

        public String protocol;

        Protocols(String str) {
            this.protocol = str;
        }

        public String getProtocol() {
            return this.protocol;
        }
    }

    Response execute();

    void execute(a aVar);

    Response executePublicKey();

    void setHttpHeaders(Map<String, String> map);

    void setReportData(String str);

    void setReportData(byte[] bArr);

    void setSSLConfig(Context context, Protocols protocols, String str, boolean z10);

    void setUrls(String[] strArr);
}
