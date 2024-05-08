package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ka extends jp<lv> implements kn<lv> {
    public ka(Context context, lv lvVar) {
        Code((ka) lvVar);
        ((jp) this).V = context;
    }

    @Override // com.huawei.hms.ads.jp
    public String B() {
        return "PlacementVideoViewPresenter_" + hashCode();
    }

    @Override // com.huawei.hms.ads.kn
    public void Code(com.huawei.openalliance.ad.inter.data.p pVar) {
        this.Code = pVar != null ? pVar.l() : null;
    }

    @Override // com.huawei.hms.ads.kn
    public void Code(final com.huawei.openalliance.ad.inter.data.r rVar) {
        if (rVar == null) {
            return;
        }
        gl.V(B(), "checkVideoHash");
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.ka.1
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                final boolean I = rVar.I();
                String Z = rVar.Z();
                if (TextUtils.isEmpty(Z) || !Z.startsWith(bq.CONTENT.toString())) {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32283z, rVar.Z());
                            com.huawei.openalliance.ad.ipc.g.V(((jp) ka.this).V).Code(com.huawei.openalliance.ad.constant.q.f32325h, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ka.1.2
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                    String data = callResult.getData();
                                    if (TextUtils.isEmpty(data) || !data.startsWith(bq.CONTENT.toString())) {
                                        return;
                                    }
                                    gl.V(ka.this.B(), "got video cached url");
                                    rVar.V(data);
                                }
                            }, String.class);
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.ka.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    gl.Code(ka.this.B(), "video path: %s", rVar.e());
                                    ((lv) ka.this.I()).Code(rVar, I);
                                }
                            };
                        } catch (JSONException unused) {
                            gl.Code(ka.this.B(), "check video cache jsonEx");
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.ka.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    gl.Code(ka.this.B(), "video path: %s", rVar.e());
                                    ((lv) ka.this.I()).Code(rVar, I);
                                }
                            };
                        }
                    } catch (Throwable th) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ka.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                gl.Code(ka.this.B(), "video path: %s", rVar.e());
                                ((lv) ka.this.I()).Code(rVar, I);
                            }
                        });
                        throw th;
                    }
                } else {
                    runnable = new Runnable() { // from class: com.huawei.hms.ads.ka.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gl.V(ka.this.B(), "video is cached.");
                            ((lv) ka.this.I()).Code(rVar, I);
                        }
                    };
                }
                com.huawei.openalliance.ad.utils.ba.Code(runnable);
                if (2 == rVar.c() || rVar.I()) {
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ka.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ((lv) ka.this.I()).Code(rVar, true);
                        }
                    });
                }
            }
        });
    }
}
