package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bb {
    private static final String Code = "HUAApi";
    private static final String V = "handleUriAction";

    public static <T> T Code(final Context context, final AdContentData adContentData, final int i10, final Class<T> cls) {
        if (adContentData != null) {
            return (T) aw.Code(new Callable<T>() { // from class: com.huawei.openalliance.ad.utils.bb.1
                @Override // java.util.concurrent.Callable
                public T call() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("content_id", AdContentData.this.S());
                        jSONObject.put("templateId", AdContentData.this.az());
                        jSONObject.put("slotid", AdContentData.this.C());
                        jSONObject.put("apiVer", AdContentData.this.aA());
                        jSONObject.put(com.huawei.openalliance.ad.constant.ax.R, i10);
                        jSONObject.put(com.huawei.openalliance.ad.constant.ax.X, bb.V(AdContentData.this));
                        return com.huawei.openalliance.ad.ipc.b.Code(context).Code(bb.V, jSONObject.toString(), cls).getData();
                    } catch (Throwable unused) {
                        gl.I(bb.Code, "handle harmony service enter action fail");
                        return null;
                    }
                }
            }, null);
        }
        gl.V(Code, "contentRecord is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject V(AdContentData adContentData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.Y, adContentData.B());
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.O, adContentData.ap());
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.N, adContentData.ao());
        } catch (Throwable th) {
            gl.I(Code, "getParamContent ex:%s", th.getClass().getSimpleName());
        }
        return jSONObject;
    }
}
