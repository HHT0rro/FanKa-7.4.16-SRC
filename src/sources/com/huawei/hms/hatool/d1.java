package com.huawei.hms.hatool;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d1 implements g {

    /* renamed from: a, reason: collision with root package name */
    private String f30088a;

    /* renamed from: b, reason: collision with root package name */
    private String f30089b;

    /* renamed from: c, reason: collision with root package name */
    private String f30090c;

    /* renamed from: d, reason: collision with root package name */
    private List<b1> f30091d;

    public d1(List<b1> list, String str, String str2, String str3) {
        this.f30088a = str;
        this.f30089b = str2;
        this.f30090c = str3;
        this.f30091d = list;
    }

    private void a() {
        d.a(q0.i(), "backup_event", n1.a(this.f30088a, this.f30090c, this.f30089b));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<b1> list = this.f30091d;
        if (list == null || list.size() == 0) {
            v.d("hmsSdk", "failed events is empty");
            return;
        }
        if (c0.a(q0.i(), "cached_v2_1", q0.k() * 1048576)) {
            v.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.f30089b);
            return;
        }
        String a10 = n1.a(this.f30088a, this.f30090c);
        List<b1> list2 = c1.b(q0.i(), "cached_v2_1", a10).get(a10);
        if (list2 != null && list2.size() != 0) {
            this.f30091d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<b1> iterator2 = this.f30091d.iterator2();
        while (iterator2.hasNext()) {
            try {
                jSONArray.put(iterator2.next().d());
            } catch (JSONException unused) {
                v.e("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > q0.h() * 1048576) {
            v.e("hmsSdk", "this failed data is too long,can not writing it");
            this.f30091d = null;
            return;
        }
        v.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f30089b);
        d.b(q0.i(), "cached_v2_1", a10, jSONArray2);
        a();
    }
}
