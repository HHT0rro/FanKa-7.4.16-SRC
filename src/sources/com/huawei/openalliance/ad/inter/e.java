package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.q;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.aw;
import com.huawei.openalliance.ad.utils.v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e extends IGlobalUtil.b {
    private static final String D = "onActivityStartFinish";
    private static final byte[] F = new byte[0];
    private static e L = null;
    private static final String S = "GlobalUtil";

    /* renamed from: a, reason: collision with root package name */
    private List<IPPSUiEngineCallback> f32497a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private Context f32498b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements RemoteCallResultCallback<String> {
        private Context Code;
        private String I;
        private final IPPSUiEngineCallback V;

        public a(Context context, IPPSUiEngineCallback iPPSUiEngineCallback, String str) {
            this.Code = context;
            this.V = iPPSUiEngineCallback;
            this.I = str;
        }

        private String Code() {
            if (!com.huawei.openalliance.ad.utils.e.Code(com.huawei.openalliance.ad.ipc.g.V(this.Code).Z())) {
                try {
                    if (TextUtils.isEmpty(this.I)) {
                        return null;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", this.I);
                        CallResult Code = com.huawei.openalliance.ad.ipc.b.Code(this.Code).Code(q.f32343z, jSONObject.toString(), String.class, true);
                        if (Code != null && 200 == Code.getCode()) {
                            gl.V(e.S, "getFilePathFromKit success");
                            String optString = new JSONObject((String) Code.getData()).optString("filePath");
                            gl.V(e.S, "filepath from kit : %s", optString);
                            return optString;
                        }
                    } catch (Throwable th) {
                        gl.I(e.S, "getFilePathFromKit err: %s", th.getClass().getSimpleName());
                    }
                } catch (Throwable th2) {
                    gl.V(e.S, "get path err: %s", th2.getClass().getSimpleName());
                }
            }
            return null;
        }

        private void Code(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("filePath", str);
            this.V.onCallResult(bg.c.V, bundle);
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            try {
                if (!au.Code(callResult.getData()) && callResult.getData().startsWith(bq.CONTENT.toString())) {
                    Code(callResult.getData());
                    return;
                }
                String Code = Code();
                if (TextUtils.isEmpty(Code)) {
                    this.V.onCallResult(bg.c.V, null);
                } else {
                    Code(Code);
                }
            } catch (Throwable th) {
                gl.V(e.S, "getFilePath err: %s", th.getClass().getSimpleName());
            }
        }
    }

    private e(Context context) {
        this.f32498b = context;
    }

    public static e Code(Context context) {
        return V(context);
    }

    private static e V(Context context) {
        e eVar;
        synchronized (F) {
            if (L == null) {
                L = new e(context);
            }
            eVar = L;
        }
        return eVar;
    }

    public void V() {
        for (IPPSUiEngineCallback iPPSUiEngineCallback : this.f32497a) {
            if (iPPSUiEngineCallback != null) {
                try {
                    iPPSUiEngineCallback.onCallResult(D, null);
                } catch (Throwable th) {
                    gl.V(S, "onCallResult err: %s", th.getClass().getSimpleName());
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
        com.huawei.openalliance.ad.ipc.g.V(this.f32498b).Code(q.f32341x, str, new a(this.f32498b, iPPSUiEngineCallback, str), String.class);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirect(final String str) {
        String str2;
        try {
            str2 = (String) aw.Code(new Callable<String>() { // from class: com.huawei.openalliance.ad.inter.e.1
                @Override // java.util.concurrent.Callable
                /* renamed from: Code, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return (String) com.huawei.openalliance.ad.ipc.b.Code(e.this.f32498b).Code(q.f32341x, str, String.class).getData();
                }
            }, null);
            gl.Code(S, "filePath = %s", str2);
        } catch (Throwable th) {
            gl.V(S, "getFilePath err: %s", th.getClass().getSimpleName());
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirectByCacheType(final String str, final int i10) {
        String str2;
        try {
            str2 = (String) aw.Code(new Callable<String>() { // from class: com.huawei.openalliance.ad.inter.e.2
                @Override // java.util.concurrent.Callable
                /* renamed from: Code, reason: merged with bridge method [inline-methods] */
                public String call() {
                    CallResult Code;
                    if (v.D(e.this.f32498b)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", str);
                            jSONObject.put("apiVer", i10);
                        } catch (Throwable th) {
                            gl.V(e.S, "make param err: %s", th.getClass().getSimpleName());
                        }
                        Code = com.huawei.openalliance.ad.ipc.b.Code(e.this.f32498b).Code(q.f32341x, jSONObject.toString(), String.class);
                    } else {
                        Code = com.huawei.openalliance.ad.ipc.b.Code(e.this.f32498b).Code(q.f32341x, str, String.class);
                    }
                    return (String) Code.getData();
                }
            }, null);
            gl.Code(S, "filePath = %s", str2);
        } catch (Throwable th) {
            gl.V(S, "getFilePath err: %s", th.getClass().getSimpleName());
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager() {
        dt.Code(this.f32498b).Code(HiAd.Code(this.f32498b).V());
        return dt.Code(this.f32498b);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        gl.V(S, "registerActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.f32497a.add(iPPSUiEngineCallback);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        gl.V(S, "unregisterActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.f32497a.remove(iPPSUiEngineCallback);
        }
    }
}
