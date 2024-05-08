package com.huawei.hianalytics.framework.datahandler;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.data.ConfigManager;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import com.huawei.hianalytics.framework.session.SessionHandler;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public String f28800a;

    /* renamed from: b, reason: collision with root package name */
    public String f28801b;

    /* renamed from: c, reason: collision with root package name */
    public String f28802c;

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f28803d;

    /* renamed from: e, reason: collision with root package name */
    public long f28804e;

    /* renamed from: f, reason: collision with root package name */
    public String f28805f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f28806g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f28807h;

    /* renamed from: i, reason: collision with root package name */
    public ICallback f28808i;

    /* renamed from: j, reason: collision with root package name */
    public String f28809j;

    /* renamed from: k, reason: collision with root package name */
    public String f28810k;

    public c(String str, String str2, String str3, JSONObject jSONObject, long j10) {
        this.f28800a = str;
        this.f28802c = str3;
        this.f28803d = jSONObject;
        this.f28804e = j10;
        this.f28801b = str2;
        if (FrameworkConstant.DataType.STRING_OPER.equals(str2) && ConfigManager.getInstance().getConfig(str).isEnableSession(FrameworkConstant.DataType.STRING_OPER)) {
            com.huawei.hianalytics.framework.session.a refreshSession = SessionHandler.getInstance().refreshSession(str, j10);
            this.f28805f = refreshSession.b();
            this.f28806g = Boolean.valueOf(refreshSession.c());
        }
    }

    private void b(Event event) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(event);
        e eVar = new e(this.f28800a, this.f28801b, arrayList, this.f28808i, "");
        eVar.a(true);
        eVar.a();
    }

    public void a(boolean z10) {
        this.f28807h = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        Event event = new Event();
        event.setServicetag(this.f28800a);
        event.setEvttype(this.f28801b);
        event.setEvtid(this.f28802c);
        JSONObject jSONObject = this.f28803d;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        event.setEvttime(String.valueOf(this.f28804e));
        Boolean bool = this.f28806g;
        event.setSessionid(bool == null ? null : String.valueOf(bool));
        event.setSessionname(this.f28805f);
        event.setEvtExHashCode(this.f28809j);
        IMandatoryParameters parameters = ConfigManager.getInstance().getParameters();
        if (parameters != null) {
            event.setProcessname(parameters.getProcessName());
            if (parameters.checkDebugModeEnabled()) {
                event.setContent(jSONObject2);
                new b(this.f28800a, this.f28801b, event, this.f28810k, this.f28808i).run();
            } else if (this.f28807h) {
                event.setContent(jSONObject2);
                b(event);
            } else {
                if (com.huawei.hianalytics.framework.b.b(this.f28800a).isEncrypted(this.f28801b)) {
                    event.setContent(a.b(jSONObject2, parameters));
                } else {
                    event.setContent(jSONObject2);
                }
                a(event);
            }
        }
    }

    public void a(ICallback iCallback) {
        this.f28808i = iCallback;
    }

    private void a(Event event) {
        IStorageHandler c4 = com.huawei.hianalytics.framework.b.c(this.f28800a);
        IStoragePolicy d10 = com.huawei.hianalytics.framework.b.d(this.f28800a);
        if (c4 != null && d10 != null) {
            if (d10.decide(IStoragePolicy.PolicyType.STORAGELENGTH, this.f28801b)) {
                HiLog.e("RecordTask", "db file reach max limited length,clear db file，TAG: %s", this.f28800a);
                c4.deleteAll();
                c4.insert(event);
                return;
            }
            long readEventSize = c4.readEventSize(this.f28800a);
            if (readEventSize == 0) {
                c4.insert(event);
                return;
            }
            if (readEventSize > 5000) {
                HiLog.e("RecordTask", "db file reach max limited size,clear db file，TAG: %s", this.f28800a);
                c4.deleteByTag(this.f28800a);
                c4.insert(event);
                return;
            } else {
                c4.insert(event);
                a(d10, c4);
                return;
            }
        }
        HiLog.e("RecordTask", "storageHandler is null!，TAG: %s", this.f28800a);
    }

    private void a(IStoragePolicy iStoragePolicy, IStorageHandler iStorageHandler) {
        com.huawei.hianalytics.framework.data.a a10 = com.huawei.hianalytics.framework.b.a(this.f28800a);
        if (a10 == null) {
            HiLog.w("RecordTask", "get framework config info error，TAG: %s", this.f28800a);
            return;
        }
        if (System.currentTimeMillis() - a10.a(this.f28801b) <= 30000) {
            HiLog.i("RecordTask", "autoReport timeout. interval < 30s ，TAG: %s,TYPE: %s", this.f28800a, this.f28801b);
            return;
        }
        long readEventSize = iStorageHandler.readEventSize(this.f28800a, this.f28801b);
        HiLog.i("RecordTask", "record evt size : " + readEventSize + "，TAG: %s,TYPE: %s", this.f28800a, this.f28801b);
        if (!iStoragePolicy.decide(IStoragePolicy.PolicyType.STORAGESIZE, this.f28801b, readEventSize)) {
            HiLog.i("RecordTask", "storagesize is less 30 ，TAG: %s,TYPE: %s", this.f28800a, this.f28801b);
        } else {
            if (!iStoragePolicy.decide(IStoragePolicy.PolicyType.NETWORK, this.f28801b)) {
                HiLog.w("RecordTask", "network is invalid，TAG: %s,TYPE: %s", this.f28800a, this.f28801b);
                return;
            }
            HiLog.i("RecordTask", "begin to auto report!，TAG: %s,TYPE: %s", this.f28800a, this.f28801b);
            TaskThread.getReportThread().addToQueue(new ReportTask(this.f28800a, this.f28801b, this.f28808i, ""));
            a10.a(this.f28801b, System.currentTimeMillis());
        }
    }
}
