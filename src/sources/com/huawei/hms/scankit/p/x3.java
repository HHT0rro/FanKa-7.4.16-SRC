package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;
import java.util.LinkedHashMap;

/* compiled from: HaLog60002.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class x3 extends u3 {

    /* compiled from: HaLog60002.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends LinkedHashMap<String, String> {
        public a() {
            x3.this.g();
            putAll(x3.this.f31577b);
        }
    }

    public x3() {
        super(null, DynamicModuleInitializer.getContext());
    }

    public void c(Bundle bundle) {
        if (bundle == null || !a()) {
            return;
        }
        try {
            if (bundle.containsKey("scanType") && (bundle.get("scanType") instanceof Integer)) {
                bundle.putString("scanType", u3.a(bundle.getInt("scanType")));
            }
            a aVar = new a();
            for (String str : bundle.keySet()) {
                aVar.put(str, String.valueOf(bundle.get(str)));
            }
            a4.b().b("60002", aVar);
        } catch (RuntimeException unused) {
            o4.b("HaLog60002", "RuntimeException");
        } catch (Exception unused2) {
            o4.b("HaLog60002", "Exception");
        }
    }
}
