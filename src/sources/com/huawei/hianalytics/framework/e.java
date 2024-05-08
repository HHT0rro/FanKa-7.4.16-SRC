package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.datahandler.ReportTask;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static e f28825a;

    public static e a() {
        if (f28825a == null) {
            b();
        }
        return f28825a;
    }

    public static synchronized void b() {
        synchronized (e.class) {
            if (f28825a == null) {
                f28825a = new e();
            }
        }
    }

    public void b(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback) {
        try {
            com.huawei.hianalytics.framework.datahandler.d dVar = new com.huawei.hianalytics.framework.datahandler.d(str, str2, str3, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis());
            dVar.a(true);
            dVar.a(iCallback);
            TaskThread.getRecordThread().addToQueue(dVar);
        } catch (JSONException unused) {
            HiLog.w("HiAnalyticsEventServer", "onStreamEventEx() headerEx or commonEx is not json");
        }
    }

    public synchronized void a(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback) {
        try {
            com.huawei.hianalytics.framework.datahandler.d dVar = new com.huawei.hianalytics.framework.datahandler.d(str, str2, str3, jSONObject, jSONObject2, jSONObject3, System.currentTimeMillis());
            dVar.a(iCallback);
            TaskThread.getRecordThread().addToQueue(dVar);
        } catch (JSONException unused) {
            HiLog.w("HiAnalyticsEventServer", "onEventEx() headerEx or commonEx is not json");
        }
    }

    public synchronized void a(String str, String str2, String str3, JSONObject jSONObject, ICallback iCallback) {
        com.huawei.hianalytics.framework.datahandler.c cVar = new com.huawei.hianalytics.framework.datahandler.c(str, str2, str3, jSONObject, System.currentTimeMillis());
        cVar.a(iCallback);
        TaskThread.getRecordThread().addToQueue(cVar);
    }

    public void b(String str, String str2, String str3, JSONObject jSONObject, ICallback iCallback) {
        com.huawei.hianalytics.framework.datahandler.c cVar = new com.huawei.hianalytics.framework.datahandler.c(str, str2, str3, jSONObject, System.currentTimeMillis());
        cVar.a(true);
        cVar.a(iCallback);
        TaskThread.getRecordThread().addToQueue(cVar);
    }

    public void a(String str, String str2, ICallback iCallback, String str3) {
        IStoragePolicy d10 = b.d(str);
        if (d10 == null || !d10.decide(IStoragePolicy.PolicyType.NETWORK, str2)) {
            return;
        }
        TaskThread.getReportThread().addToQueue(new ReportTask(str, str2, iCallback, str3));
    }

    public synchronized void a(String str, String str2) {
        IStorageHandler c4 = b.c(str);
        if (c4 != null) {
            c4.deleteByTagType(str, str2);
        }
    }

    public synchronized void a(String str) {
        IStorageHandler c4 = b.c(str);
        if (c4 != null) {
            c4.deleteByTag(str);
        }
    }
}
