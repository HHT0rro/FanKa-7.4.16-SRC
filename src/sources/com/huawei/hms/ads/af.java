package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class af implements ac {
    private static final String Z = "JsbBaseCommand";
    private final byte[] B;
    private WeakReference<Activity> C;
    public String Code;
    public String I;
    public String V;

    public af() {
        this.B = new byte[0];
    }

    public af(String str) {
        this.B = new byte[0];
        this.Code = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, String str) {
        if (adContentData != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!TextUtils.isEmpty(jSONObject.optString(com.huawei.openalliance.ad.constant.as.C))) {
                    adContentData.V(jSONObject.optString(com.huawei.openalliance.ad.constant.as.C));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("requestId"))) {
                    adContentData.F(jSONObject.optString("requestId"));
                }
                String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.as.f32245t);
                String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.as.f32242q);
                if (!TextUtils.isEmpty(optString)) {
                    adContentData.p(optString);
                }
                if (TextUtils.isEmpty(optString2)) {
                    return;
                }
                adContentData.q(optString2);
            } catch (Throwable unused) {
                gl.I(Z, "update content failed");
            }
        }
    }

    public static void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i10, JsbCallBackData jsbCallBackData) {
        if (remoteCallResultCallback != null) {
            CallResult<String> callResult = new CallResult<>();
            callResult.setCode(i10);
            try {
                callResult.setData(com.huawei.openalliance.ad.utils.z.V(jsbCallBackData));
            } catch (Throwable th) {
                gl.I(Z, "onCallResult " + th.getClass().getSimpleName());
            }
            remoteCallResultCallback.onRemoteCallResult(str, callResult);
        }
    }

    public static <T> void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i10, T t2, boolean z10) {
        Code(remoteCallResultCallback, str, i10, new JsbCallBackData(t2, z10, null));
    }

    public Integer B(String str) {
        try {
            int optInt = new JSONObject(str).optInt("source", -111111);
            if (optInt != -111111) {
                return Integer.valueOf(optInt);
            }
            return null;
        } catch (Throwable unused) {
            gl.Code(Z, "getDownloadSource error");
            return null;
        }
    }

    public com.huawei.openalliance.ad.inter.data.m C(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Integer valueOf = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ax.aj, -111111));
            Integer valueOf2 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ax.ak, -111111));
            String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.ax.al, "");
            if (valueOf.intValue() == -111111) {
                valueOf = null;
            }
            if (valueOf2.intValue() == -111111) {
                valueOf2 = null;
            }
            if (!com.huawei.openalliance.ad.utils.au.D(optString)) {
                optString = null;
            }
            return new com.huawei.openalliance.ad.inter.data.m(valueOf, valueOf2, optString);
        } catch (Throwable unused) {
            gl.Code(Z, "getClickInfo error");
            return null;
        }
    }

    @Override // com.huawei.hms.ads.ac
    public Context Code(Context context) {
        synchronized (this.B) {
            WeakReference<Activity> weakReference = this.C;
            if (weakReference == null || weakReference.get() == null) {
                return context;
            }
            return this.C.get();
        }
    }

    @Override // com.huawei.hms.ads.ac
    public f.a Code() {
        return f.a.IO;
    }

    @Override // com.huawei.hms.ads.ac
    public Object Code(Context context, String str) {
        gl.I(Z, "direct call is not implemented!");
        throw new IllegalStateException("direct call is not implemented!");
    }

    @Override // com.huawei.hms.ads.ac
    public void Code(Activity activity) {
        synchronized (this.B) {
            WeakReference<Activity> weakReference = this.C;
            if (weakReference == null || weakReference.get() == null) {
                this.C = new WeakReference<>(activity);
            }
        }
    }

    public void Code(Context context, String str, ab abVar) {
        Code(context, str, false, abVar);
    }

    public void Code(Context context, final String str, boolean z10, final ab abVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject.put("content_id", jSONObject2.optString(com.huawei.openalliance.ad.constant.as.f32246u));
            jSONObject.put("unique_id", jSONObject2.optString("adId"));
            jSONObject.put(com.huawei.openalliance.ad.constant.as.I, z10);
            jSONObject.put(com.huawei.openalliance.ad.constant.as.Z, this.V);
            if (!TextUtils.isEmpty(jSONObject2.optString("apiVer"))) {
                jSONObject.put("apiVer", jSONObject2.optString("apiVer"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("templateId"))) {
                jSONObject.put("templateId", jSONObject2.optString("templateId"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("slotid"))) {
                jSONObject.put("slotid", jSONObject2.optString("slotid"));
            }
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.q.f32336s, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.af.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    if (callResult.getCode() != 200) {
                        gl.I(af.Z, "request ad content, retCode: %s", Integer.valueOf(callResult.getCode()));
                        abVar.Code(null);
                        return;
                    }
                    AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.z.V(callResult.getData(), AdContentData.class, new Class[0]);
                    af.this.Code(adContentData, str);
                    if (adContentData == null) {
                        gl.I(af.Z, "request ad content is null");
                    }
                    abVar.Code(adContentData);
                }
            }, String.class);
        } catch (Throwable unused) {
            gl.I(Z, "request ad content error");
        }
    }

    public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z10) {
        Code(remoteCallResultCallback, this.Code, 1011, "", z10);
    }

    @Override // com.huawei.hms.ads.ac
    public void Code(String str) {
        this.V = str;
    }

    public boolean Code(AdContentData adContentData) {
        return adContentData != null && adContentData.ar() && kt.Z(adContentData.r());
    }

    public void V(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z10) {
        Code(remoteCallResultCallback, this.Code, 1000, "ok", z10);
    }

    @Override // com.huawei.hms.ads.ac
    public void V(String str) {
        this.I = str;
    }

    @Override // com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        gl.I(Z, "async execute is not implemented!");
        throw new IllegalStateException("async execute is not implemented!");
    }
}
