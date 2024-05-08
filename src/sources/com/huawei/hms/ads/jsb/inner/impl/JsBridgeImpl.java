package com.huawei.hms.ads.jsb.inner.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ac;
import com.huawei.hms.ads.af;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.jsb.JsbConfig;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.f;
import org.json.JSONObject;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsBridgeImpl {
    private static final String Code = "JsBridgeImpl";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a<T> implements Runnable {
        private ac B;
        private final Context Code;
        private final String I;
        private final String V;
        private final RemoteCallResultCallback<String> Z;

        public a(Context context, ac acVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.Code = context;
            this.V = str;
            this.I = str2;
            this.Z = remoteCallResultCallback;
            this.B = acVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsBridgeImpl.V(this.Code, this.B, this.V, this.I, this.Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, ac acVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (acVar == null) {
            String str3 = "api for " + str + " is not found";
            gl.V(Code, "call " + str3);
            af.Code(remoteCallResultCallback, str, 1011, str3, true);
            return;
        }
        gl.V(Code, "call method: " + str);
        if (gl.Code()) {
            gl.Code(Code, "param: %s", bc.Code(str2));
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("content");
            acVar.Code(jSONObject.optString("url"));
            acVar.V(jSONObject.optString("cid"));
            acVar.execute(context, optString, remoteCallResultCallback);
        } catch (Throwable th) {
            gl.I(Code, "call method %s, ex: %s", str, th.getClass().getSimpleName());
            af.Code(remoteCallResultCallback, str, 1011, th.getClass().getSimpleName() + u.bD + th.getMessage(), true);
            gl.Code(3, th);
        }
    }

    @AllApi
    public static void initConfig(Context context, JsbConfig jsbConfig) {
        com.huawei.hms.ads.jsb.a.Code(context).Code(jsbConfig);
    }

    @AllApi
    public static String invoke(Context context, String str, String str2) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        int i10 = 1011;
        if (context != null) {
            try {
            } catch (Throwable th) {
                gl.I(Code, "call method : " + th.getClass().getSimpleName());
                obj = "call " + str + " " + th.getClass().getSimpleName() + u.bD + th.getMessage();
            }
            if (!TextUtils.isEmpty(str2)) {
                ac Code2 = ah.Code().Code(str);
                if (Code2 != null) {
                    gl.V(Code, "call api: " + str);
                    obj = Code2.Code(context.getApplicationContext(), new JSONObject(str2).optString("content"));
                    i10 = 1000;
                } else {
                    obj = null;
                }
                try {
                    jSONObject.put("code", i10);
                    jSONObject.put("data", obj);
                } catch (Throwable th2) {
                    gl.I(Code, "call method : " + th2.getClass().getSimpleName());
                }
                return jSONObject.toString();
            }
        }
        gl.Z(Code, "param is invalid, please check it!");
        jSONObject.put("msg", "invalid params");
        jSONObject.put("code", 1011);
        return jSONObject.toString();
    }

    @AllApi
    public static void invoke(Context context, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback, Class<String> cls) {
        if (context == null || TextUtils.isEmpty(str2)) {
            gl.Z(Code, "param is invalid, please check it!");
            af.Code(remoteCallResultCallback, str, 1001, null, true);
            return;
        }
        ac Code2 = ah.Code().Code(str);
        f.a aVar = f.a.IO;
        if (Code2 != null) {
            aVar = Code2.Code();
            if (ah.Code().Code(str, context)) {
                Code2.Code((Activity) context);
            }
        }
        f.Code(new a(context.getApplicationContext(), Code2, str, str2, remoteCallResultCallback), aVar, false);
    }
}
