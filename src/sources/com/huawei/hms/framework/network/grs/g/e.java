package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.wangmai.okhttp.cookie.SerializableCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f30009a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f30010b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONArray f30011c;

        public a(long j10, ArrayList arrayList, JSONArray jSONArray) {
            this.f30009a = j10;
            this.f30010b = arrayList;
            this.f30011c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            com.huawei.hms.framework.network.grs.g.j.a aVar = new com.huawei.hms.framework.network.grs.g.j.a();
            aVar.put("total_time", this.f30009a);
            Iterator iterator2 = this.f30010b.iterator2();
            while (iterator2.hasNext()) {
                d dVar = (d) iterator2.next();
                if (dVar.o() || dVar.m()) {
                    aVar.put(e.b(dVar));
                    iterator2.remove();
                    z10 = true;
                    break;
                }
            }
            z10 = false;
            if (!z10 && this.f30010b.size() > 0) {
                ArrayList arrayList = this.f30010b;
                d dVar2 = (d) arrayList.get(arrayList.size() - 1);
                aVar.put(e.b(dVar2));
                this.f30010b.remove(dVar2);
            }
            if (this.f30010b.size() > 0) {
                Iterator iterator22 = this.f30010b.iterator2();
                while (iterator22.hasNext()) {
                    this.f30011c.put(new JSONObject(e.b((d) iterator22.next())));
                }
            }
            if (this.f30011c.length() > 0) {
                aVar.put("failed_info", this.f30011c.toString());
            }
            Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
            HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
        }
    }

    public static void a(ArrayList<d> arrayList, long j10, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReport(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j10, arrayList, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d10 = dVar.d();
        if (d10 != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(d10));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d10.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(d10.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, dVar.c());
        }
        try {
            linkedHashMapPack.put(SerializableCookie.DOMAIN, new URL(dVar.l()).getHost());
        } catch (MalformedURLException e2) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e2);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }
}
