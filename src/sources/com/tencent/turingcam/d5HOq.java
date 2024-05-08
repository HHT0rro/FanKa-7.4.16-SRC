package com.tencent.turingcam;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.flexiblelayout.n;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d5HOq {

    /* renamed from: a, reason: collision with root package name */
    private static final d5HOq f45412a = new d5HOq();

    /* renamed from: b, reason: collision with root package name */
    private final List<wmqhz> f45413b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ShGzN implements wmqhz {
        @Override // com.tencent.turingcam.d5HOq.wmqhz
        public void a(Context context, JSONObject jSONObject) throws JSONException {
            try {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver == null || !TextUtils.equals(registerReceiver.getAction(), "android.intent.action.BATTERY_CHANGED")) {
                    return;
                }
                int intExtra = registerReceiver.getIntExtra(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, 0);
                int i10 = 100;
                int intExtra2 = registerReceiver.getIntExtra(n.f28264e, 100);
                int intExtra3 = registerReceiver.getIntExtra("status", -1);
                int intExtra4 = registerReceiver.getIntExtra("plugged", -1);
                boolean z10 = intExtra3 == 2 || intExtra3 == 5;
                if (z10 && intExtra4 == 2) {
                    jSONObject.put("chargeState", 1);
                } else if (z10 && intExtra4 == 1) {
                    jSONObject.put("chargeState", 2);
                } else {
                    jSONObject.put("chargeState", 0);
                }
                if (intExtra2 != 0) {
                    int i11 = (intExtra * 100) / intExtra2;
                    int i12 = i11 >= 0 ? i11 : 0;
                    if (i12 <= 100) {
                        i10 = i12;
                    }
                } else {
                    i10 = -1;
                }
                jSONObject.put("batterLevel", i10);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class SkEpO implements wmqhz {
        @Override // com.tencent.turingcam.d5HOq.wmqhz
        public void a(Context context, JSONObject jSONObject) throws JSONException {
            Ringtone ringtone;
            Object property = System.getProperty("ro.config.ringtone");
            if (property != null) {
                jSONObject.put("defaultRingTone", property);
            }
            Uri uriFor = Settings.System.getUriFor("DEFAULT_RINGTONE_URI");
            if (uriFor == null || (ringtone = RingtoneManager.getRingtone(context, uriFor)) == null) {
                return;
            }
            String title = ringtone.getTitle(context);
            if (TextUtils.isEmpty(title)) {
                return;
            }
            jSONObject.put("defaultRingTone", title);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg implements wmqhz {
        @Override // com.tencent.turingcam.d5HOq.wmqhz
        public void a(Context context, JSONObject jSONObject) throws JSONException {
            jSONObject.put("bootTime", System.currentTimeMillis() - SystemClock.elapsedRealtime());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface wmqhz {
        void a(Context context, JSONObject jSONObject) throws JSONException;
    }

    private d5HOq() {
        ArrayList arrayList = new ArrayList();
        this.f45413b = arrayList;
        arrayList.add(new ShGzN());
        arrayList.add(new spXPg());
        arrayList.add(new SkEpO());
    }

    public static d5HOq a() {
        return f45412a;
    }

    public JSONObject a(Context context) {
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<wmqhz> iterator2 = this.f45413b.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().a(context, jSONObject);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
