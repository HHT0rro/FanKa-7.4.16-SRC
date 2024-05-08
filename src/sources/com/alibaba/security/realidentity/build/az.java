package com.alibaba.security.realidentity.build;

import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.business.RPBusinessHeadParams;
import org.json.JSONObject;

/* compiled from: LivenessApi.java */
@aw(a = "liveness,rpLiveness")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class az extends aq {
    private static final int ao = 1;

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "liveness";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, final ay ayVar) {
        if (TextUtils.isEmpty(str)) {
            aq.a(ayVar, aq.f3104ad);
            aq.b("LivenessApi parse params is null");
            return true;
        }
        RPBusinessHeadParams rPBusinessHeadParams = (RPBusinessHeadParams) JsonUtils.parseObject(str, RPBusinessHeadParams.class);
        if (rPBusinessHeadParams == null) {
            aq.a(ayVar, aq.f3104ad);
            aq.b("LivenessApi parse params is invalid");
            return true;
        }
        String verifyToken = rPBusinessHeadParams.getVerifyToken();
        j.a.f3944a.f3895e = verifyToken;
        o oVar = new o(this.al, verifyToken, new RPEventListener() { // from class: com.alibaba.security.realidentity.build.az.1
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str2, String str3) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "-10000";
                }
                RPLogging.d(aq.f3100a, "LivenessApi Code: ".concat(String.valueOf(str2)));
                JSONObject jSONObject = new JSONObject();
                try {
                    bf bfVar = new bf();
                    jSONObject.put("code", str2);
                    jSONObject.put("message", str3);
                    bfVar.f3166k = jSONObject;
                    bfVar.f3165a = 1;
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = bfVar;
                    az.this.a(obtain);
                } catch (Exception e2) {
                    aq.a(ayVar, "LivenessApi start liveness error");
                    aq.a("LivenessApi start liveness error", e2);
                }
            }
        }, true);
        j.a.f3944a.f3910t = oVar;
        oVar.a(rPBusinessHeadParams);
        return true;
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final void b(Message message) {
        super.b(message);
        if (message.what != 1) {
            return;
        }
        bf bfVar = (bf) message.obj;
        bfVar.f3165a = 1;
        this.ak.b(bfVar);
        a("code: " + bfVar.b("code", "unknow") + " msg: " + bfVar.b("message", "unknow"));
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean b() {
        return true;
    }

    private void a(bf bfVar) {
        bfVar.f3165a = 1;
        this.ak.b(bfVar);
        a("code: " + bfVar.b("code", "unknow") + " msg: " + bfVar.b("message", "unknow"));
    }
}
