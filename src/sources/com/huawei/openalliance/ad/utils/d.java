package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {
    private static final String Code = "AdSourceUtil";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements RemoteCallResultCallback<String> {
        private final WeakReference<Context> Code;

        public a(Context context) {
            this.Code = new WeakReference<>(context);
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            String data = callResult.getData();
            Context context = this.Code.get();
            if (context == null || TextUtils.isEmpty(data) || !data.startsWith(bq.CONTENT.toString())) {
                return;
            }
            SourceParam sourceParam = new SourceParam();
            sourceParam.V(false);
            sourceParam.I(true);
            sourceParam.I(data);
            y.Code(context, sourceParam, (aj) null);
        }
    }

    public static void Code(Context context, AdContentData adContentData) {
        AdSource Code2;
        if (adContentData != null) {
            try {
                if (adContentData.Z() == null || adContentData.Z().i() == null || (Code2 = AdSource.Code(adContentData.Z().i())) == null || Code2.V() == null) {
                    return;
                }
                gl.V(Code, "preloadDspLogo");
                String V = Code2.V();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32283z, V);
                com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.q.f32325h, jSONObject.toString(), new a(context), String.class);
            } catch (Throwable unused) {
                gl.I(Code, "preloadDspLogo error");
            }
        }
    }
}
