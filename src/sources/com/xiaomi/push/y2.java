package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y2 extends a3 {
    public y2(Context context, int i10) {
        super(context, i10);
    }

    private String g() {
        Bundle extras;
        StringBuilder sb2 = new StringBuilder();
        try {
            Intent registerReceiver = this.f47110c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null && (extras = registerReceiver.getExtras()) != null) {
                Set<String> keySet = extras.keySet();
                JSONObject jSONObject = new JSONObject();
                if (keySet != null && keySet.size() > 0) {
                    for (String str : keySet) {
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject.put(str, String.valueOf(extras.get(str)));
                            } catch (Exception unused) {
                            }
                        }
                    }
                    sb2.append((Object) jSONObject);
                }
            }
        } catch (Exception unused2) {
        }
        return sb2.toString();
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 20;
    }

    @Override // com.xiaomi.push.a3
    public hs b() {
        return hs.Battery;
    }

    @Override // com.xiaomi.push.a3
    public String c() {
        return g();
    }
}
