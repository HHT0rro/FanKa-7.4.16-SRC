package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jx extends ju<lp> implements kj {

    /* renamed from: com.huawei.hms.ads.jx$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ String Code;

        public AnonymousClass1(String str) {
            this.Code = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32283z, this.Code);
                com.huawei.openalliance.ad.ipc.g.V(((ju) jx.this).V).Code(com.huawei.openalliance.ad.constant.q.f32325h, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jx.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        final String data = callResult.getData();
                        if (TextUtils.isEmpty(data) || !data.startsWith(bq.CONTENT.toString())) {
                            return;
                        }
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jx.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((lp) jx.this.I()).Code(data);
                            }
                        });
                    }
                }, String.class);
            } catch (JSONException unused) {
                gl.Code("PPSVideoViewPresenter", "check video cache jsonEx");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jx.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((lp) jx.this.I()).Code(AnonymousClass1.this.Code);
                    }
                });
            }
        }
    }

    public jx(Context context, lp lpVar) {
        super(context, lpVar);
    }

    @Override // com.huawei.hms.ads.kj
    public void C() {
        kv.Code(((ju) this).V, this.Code, com.huawei.openalliance.ad.constant.ae.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.kj
    public void Code(long j10, long j11, long j12, long j13) {
        kv.Code(((ju) this).V, this.Code, com.huawei.openalliance.ad.constant.ae.Z, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf((int) j12), Integer.valueOf((int) j13));
    }

    @Override // com.huawei.hms.ads.kj
    public void Code(boolean z10) {
        AdEventReport Code = kv.Code(this.Code);
        Code.V(z10);
        com.huawei.openalliance.ad.ipc.g.V(((ju) this).V).Code(com.huawei.openalliance.ad.constant.q.f32326i, com.huawei.openalliance.ad.utils.z.V(Code), null, null);
    }

    @Override // com.huawei.hms.ads.ju
    public void V(String str) {
        ((lp) I()).B();
        gl.V("PPSVideoViewPresenter", "onMaterialLoaded - begin to load video");
        if (TextUtils.isEmpty(str) || !str.startsWith(bq.CONTENT.toString())) {
            gl.V("PPSVideoViewPresenter", "check if video cached.");
            com.huawei.openalliance.ad.utils.f.I(new AnonymousClass1(str));
        } else {
            gl.V("PPSVideoViewPresenter", "video is cached.");
            ((lp) I()).Code(str);
        }
    }
}
