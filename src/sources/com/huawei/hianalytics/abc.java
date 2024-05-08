package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.config.RomAttributeCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class abc implements RomAttributeCollector {

    /* renamed from: a, reason: collision with root package name */
    public String f28728a;
    public String abc;

    /* renamed from: b, reason: collision with root package name */
    public String f28729b;
    public String bcd;

    /* renamed from: c, reason: collision with root package name */
    public int f28730c;
    public String cde;

    /* renamed from: d, reason: collision with root package name */
    public int f28731d;
    public String def;

    /* renamed from: e, reason: collision with root package name */
    public String f28732e;
    public String efg;

    /* renamed from: f, reason: collision with root package name */
    public String f28733f;
    public String fgh;

    /* renamed from: g, reason: collision with root package name */
    public String f28734g;
    public String ghi;
    public String hij;
    public String ijk;
    public String ikl;
    public String klm;
    public String lmn;

    @Override // com.huawei.hianalytics.framework.config.RomAttributeCollector
    public JSONObject doCollector() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_rom_ver", this.lmn);
            jSONObject.put("_emui_ver", this.klm);
            jSONObject.put("_model", this.ikl);
            jSONObject.put("_package_name", this.ijk);
            jSONObject.put("_app_ver", this.hij);
            jSONObject.put("_lib_ver", this.ghi);
            jSONObject.put("_lib_name", this.efg);
            jSONObject.put("_channel", this.fgh);
            jSONObject.put("_sys_language", (Object) null);
            jSONObject.put("_manufacturer", this.def);
            jSONObject.put("_oaid_tracking_flag", this.abc);
            jSONObject.put("_app_brand", this.cde);
            jSONObject.put("_brand", this.bcd);
            jSONObject.put("_mcc", this.f28733f);
            jSONObject.put("_mnc", this.f28734g);
            jSONObject.put("_os", this.f28728a);
            jSONObject.put("_os_ver", this.f28729b);
            jSONObject.put("_screen_height", this.f28730c);
            jSONObject.put("_screen_width", this.f28731d);
            jSONObject.put("_language", this.f28732e);
            jSONObject.put("_product_form", (Object) null);
        } catch (JSONException unused) {
            HiLog.e("OpennessRomCollector", "HiAnalyticsRomCollector doCollector JSONException");
        }
        return jSONObject;
    }
}
