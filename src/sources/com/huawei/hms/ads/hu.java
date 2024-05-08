package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hu {
    private static final String B = "AppNotificationEvtProcessor";
    private static String C = "AppNotificationExceptionCmd";
    public static final String Code = "70";
    public static final String I = "1";
    public static final String V = "0";
    public static final String Z = "2";

    public static void Code(Context context, AdContentData adContentData) {
        Code(context, adContentData, Code, "2", null, null);
    }

    private static <T> void Code(Context context, AdContentData adContentData, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", adContentData.S());
            jSONObject.put("templateId", adContentData.az());
            jSONObject.put("slotid", adContentData.C());
            jSONObject.put("apiVer", adContentData.aA());
            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32252a, str);
            jSONObject.put("action", str2);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(C, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            gl.I(B, "reportAnalysisEvent JSONException");
            if (remoteCallResultCallback != null) {
                CallResult<T> callResult = new CallResult<>();
                callResult.setCode(-1);
                callResult.setMsg("reportAnalysisEvent JSONException");
                remoteCallResultCallback.onRemoteCallResult(C, callResult);
            }
        }
    }

    public static void I(Context context, AdContentData adContentData) {
        Code(context, adContentData, Code, "0", null, null);
    }

    public static void V(Context context, AdContentData adContentData) {
        Code(context, adContentData, Code, "1", null, null);
    }
}
