package com.huawei.hianalytics.framework.datahandler;

import android.text.TextUtils;
import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.data.ConfigManager;
import com.huawei.hianalytics.framework.h;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f28811a;

    /* renamed from: b, reason: collision with root package name */
    public String f28812b;

    /* renamed from: c, reason: collision with root package name */
    public List<Event> f28813c;

    /* renamed from: d, reason: collision with root package name */
    public ICollectorConfig f28814d;

    /* renamed from: e, reason: collision with root package name */
    public ICallback f28815e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f28816f;

    /* renamed from: g, reason: collision with root package name */
    public String f28817g;

    public e(String str, String str2, List<Event> list, ICallback iCallback, String str3) {
        this.f28811a = str;
        this.f28812b = str2;
        this.f28813c = list;
        this.f28815e = iCallback;
        this.f28817g = str3;
        this.f28814d = com.huawei.hianalytics.framework.b.b(str);
    }

    public void a(boolean z10) {
        this.f28816f = z10;
    }

    public void a() {
        IStoragePolicy d10 = com.huawei.hianalytics.framework.b.d(this.f28811a);
        if (!d10.decide(IStoragePolicy.PolicyType.PARAMS, this.f28812b)) {
            if (this.f28816f && this.f28813c.size() == 1) {
                this.f28815e.onResult(-1, -1L, this.f28813c);
                return;
            }
            return;
        }
        Event specialEvent = this.f28814d.getSpecialEvent(this.f28812b);
        if (specialEvent != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(specialEvent);
            a((List<Event>) arrayList, HexUtil.initRandomKey(16), true);
        }
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < this.f28813c.size(); i10++) {
            if (TextUtils.isEmpty(this.f28813c.get(i10).getEvtExHashCode())) {
                a(hashMap, this.f28813c.get(i10), "noExHashFlag");
            } else {
                a(hashMap, this.f28813c.get(i10), this.f28813c.get(i10).getEvtExHashCode());
            }
        }
        Iterator<Map.Entry<String, List<Event>>> iterator2 = hashMap.entrySet().iterator2();
        while (iterator2.hasNext()) {
            a(d10, iterator2.next().getValue());
        }
    }

    private void a(IStoragePolicy iStoragePolicy, List<Event> list) {
        IStorageHandler c4;
        int size = (list.size() / 500) + 1;
        HiLog.i("ReportProcessor", "report times :" + size + "，TAG: %s,TYPE: %s", this.f28811a, this.f28812b);
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 * 500;
            List<Event> subList = list.subList(i11, Math.min(list.size(), i11 + 500));
            String initRandomKey = HexUtil.initRandomKey(16);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Event event : subList) {
                int i12 = i10;
                if (iStoragePolicy.decide(IStoragePolicy.PolicyType.STORAGECYCLY, this.f28812b, Long.parseLong(event.getEvttime()))) {
                    arrayList2.add(event);
                } else {
                    arrayList.add(event);
                }
                i10 = i12;
            }
            int i13 = i10;
            if (arrayList.size() > 0) {
                a(arrayList, initRandomKey, this.f28816f);
            } else {
                HiLog.sw("ReportProcessor", "No data to report process，TAG: %s,TYPE: %s", this.f28811a, this.f28812b);
            }
            if (arrayList2.size() > 0 && (c4 = com.huawei.hianalytics.framework.b.c(this.f28811a)) != null) {
                c4.deleteEvents(arrayList2);
            }
            i10 = i13 + 1;
        }
    }

    private void a(List<Event> list, String str, boolean z10) {
        com.huawei.hianalytics.framework.d a10 = a(this.f28812b, str, this.f28817g);
        if (a10 != null) {
            byte[] a11 = a(a10, list, z10);
            if (a11.length == 0) {
                HiLog.sw("ReportProcessor", "request body is empty，TAG: %s,TYPE: %s", this.f28811a, this.f28812b);
                return;
            }
            f fVar = new f(a11, this.f28811a, this.f28812b, str, list);
            fVar.a(this.f28815e);
            fVar.a(z10);
            fVar.run();
            return;
        }
        HiLog.sw("ReportProcessor", "uploadEvtModel is null，TAG: %s,TYPE: %s", this.f28811a, this.f28812b);
        if (z10) {
            IMandatoryParameters parameters = ConfigManager.getInstance().getParameters();
            IStorageHandler c4 = com.huawei.hianalytics.framework.b.c(this.f28811a);
            if (c4 != null) {
                for (Event event : list) {
                    event.setContent(a.b(event.getContent(), parameters));
                    a(c4, event);
                }
            }
        }
    }

    private byte[] a(com.huawei.hianalytics.framework.d dVar, List<Event> list, boolean z10) {
        try {
            JSONObject a10 = dVar.a(list, z10);
            if (a10 != null) {
                return h.a(a10.toString().getBytes("UTF-8"));
            }
            HiLog.sw("ReportProcessor", "uploadEvents is null，TAG: %s,TYPE: %s", this.f28811a, this.f28812b);
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            HiLog.sw("ReportProcessor", "sendData(): getBytes - Unsupported coding format!!，TAG: %s,TYPE: %s", this.f28811a, this.f28812b);
            return new byte[0];
        } catch (JSONException unused2) {
            HiLog.sw("ReportProcessor", "json exception，TAG: %s,TYPE: %s", this.f28811a, this.f28812b);
            return new byte[0];
        }
    }

    private com.huawei.hianalytics.framework.d a(String str, String str2, String str3) {
        if (this.f28814d.isEncrypted(str)) {
            com.huawei.hianalytics.framework.data.b.b().b(this.f28811a, str);
            if (com.huawei.hianalytics.framework.data.b.b().a() == null || com.huawei.hianalytics.framework.data.b.b().a().isEmpty()) {
                return null;
            }
        }
        String appId = this.f28814d.getAppId();
        return new com.huawei.hianalytics.framework.d(this.f28814d.getDeviceAttribute(str), this.f28814d.getEvtCustomHeader(str, a(appId, str2, str, com.huawei.hianalytics.framework.data.b.b().a())), this.f28814d.getRomAttribute(str, str3), com.huawei.hianalytics.framework.data.b.b().d(), this.f28811a, str);
    }

    private JSONObject a(String str, String str2, String str3, String str4) {
        com.huawei.hianalytics.framework.c cVar = new com.huawei.hianalytics.framework.c();
        cVar.a(str);
        if (this.f28814d.isEncrypted(str3)) {
            cVar.b(str4);
            cVar.c("1");
        } else {
            cVar.b("");
            cVar.c("0");
        }
        cVar.d(str2);
        cVar.f(this.f28811a);
        StringBuffer stringBuffer = new StringBuffer(FrameworkConstant.HMSHI);
        stringBuffer.append(str3);
        stringBuffer.append(FrameworkConstant.QRT);
        cVar.e(stringBuffer.toString());
        cVar.g(System.currentTimeMillis() + "");
        return cVar.a();
    }

    public void a(Map<String, List<Event>> map, Event event, String str) {
        List<Event> list = map.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(event);
        map.put(str, list);
    }

    private void a(IStorageHandler iStorageHandler, Event event) {
        IStoragePolicy d10 = com.huawei.hianalytics.framework.b.d(this.f28811a);
        if (iStorageHandler == null || d10 == null) {
            HiLog.e("ReportProcessor", "cache failed , storageHandler is null!，TAG : %s,TYPE: %s ", this.f28811a, this.f28812b);
            return;
        }
        if (d10.decide(IStoragePolicy.PolicyType.STORAGELENGTH, this.f28812b)) {
            HiLog.e("ReportProcessor", "cache failed , db file reach max limited length,clear db file，TAG : %s,TYPE: %s ", this.f28811a, this.f28812b);
            iStorageHandler.deleteAll();
            iStorageHandler.insert(event);
            return;
        }
        long readEventSize = iStorageHandler.readEventSize(this.f28811a);
        if (readEventSize == 0) {
            iStorageHandler.insert(event);
        } else {
            if (readEventSize > 5000) {
                HiLog.e("ReportProcessor", "cache failed , db file reach max limited size,clear db file，TAG : %s,TYPE: %s ", this.f28811a, this.f28812b);
                iStorageHandler.deleteByTag(this.f28811a);
                iStorageHandler.insert(event);
                return;
            }
            iStorageHandler.insert(event);
        }
    }
}
