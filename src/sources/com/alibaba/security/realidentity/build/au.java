package com.alibaba.security.realidentity.build;

import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.BytesUtils;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.bean.AppInfo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetDeviceInfoApi.java */
@aw(a = "deviceInfo,rpDeviceInfo")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class au extends aq {
    private static final int ao = 10;

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return aq.F;
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        try {
            final String optString = new JSONObject(str).optString(aq.f3108d);
            aq.am.execute(new Runnable() { // from class: com.alibaba.security.realidentity.build.au.1
                @Override // java.lang.Runnable
                public final void run() {
                    HashMap hashMap = new HashMap();
                    AppInfo a10 = hj.a(optString);
                    a10.setVersionTag(BytesUtils.toBase64String(ALBiometricsJni.genVersionTag(au.this.al, optString)));
                    try {
                        hashMap.put(aq.D, aq.af);
                        hashMap.put("appInfo", new JSONObject(JsonUtils.toJSON(a10)));
                        hashMap.put(aq.F, new JSONObject(JsonUtils.toJSON(hj.a())));
                    } catch (JSONException e2) {
                        if (RPLogging.isEnable()) {
                            RPLogging.e(aq.f3100a, "GetDeviceInfoApi json assemble error", e2);
                        }
                        aq.a("GetDeviceInfoApi json assemble error", CommonUtils.getStackTrace(e2));
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 10;
                    obtain.obj = JsonUtils.toJsonObject(hashMap);
                    au.this.a(obtain);
                }
            });
            return true;
        } catch (JSONException e2) {
            if (RPLogging.isEnable()) {
                RPLogging.e(aq.f3100a, "GetDeviceInfoApi params parse error", e2);
            }
            aq.a(ayVar, aq.f3106b);
            aq.a("GetDeviceInfoApi params parse error", CommonUtils.getStackTrace(e2));
            return false;
        }
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final void b(Message message) {
        super.b(message);
        if (message.what == 10) {
            JSONObject jSONObject = (JSONObject) message.obj;
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
                bf bfVar = new bf();
                i.b(jSONObject.toString());
                bfVar.f3165a = 1;
                bfVar.a(aq.f3110f, jSONObject);
                this.ak.b(bfVar);
                a(bfVar, true);
                return;
            }
            a(aq.a(this.ak, aq.f3106b), false);
        }
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean b() {
        return true;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            bf bfVar = new bf();
            i.b(jSONObject.toString());
            bfVar.f3165a = 1;
            bfVar.a(aq.f3110f, jSONObject);
            this.ak.b(bfVar);
            a(bfVar, true);
            return;
        }
        a(aq.a(this.ak, aq.f3106b), false);
    }
}
