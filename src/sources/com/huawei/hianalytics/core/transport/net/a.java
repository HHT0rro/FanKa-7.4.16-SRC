package com.huawei.hianalytics.core.transport.net;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hms.ads.uiengineloader.ae;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HiLog.w(ae.f29427a, "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }
}
