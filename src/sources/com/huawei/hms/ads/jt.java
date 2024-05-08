package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jt extends jp<lh> implements kg<lh> {
    public jt(Context context, lh lhVar) {
        Code((jt) lhVar);
        ((jp) this).V = context;
    }

    private void V(final com.huawei.openalliance.ad.inter.data.k kVar) {
        if (kVar == null) {
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(kVar.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(kVar.I());
        sourceParam.V(kVar.S());
        sourceParam.I(true);
        AdContentData adContentData = this.Code;
        com.huawei.openalliance.ad.utils.y.Code(((jp) this).V, sourceParam, adContentData != null ? adContentData.S() : null, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.jt.2
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                gl.I("NativeVideoP", "cover image load fail");
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str, final Drawable drawable) {
                com.huawei.openalliance.ad.inter.data.k kVar2 = kVar;
                if (kVar2 == null || !TextUtils.equals(str, kVar2.Z())) {
                    return;
                }
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jt.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((lh) jt.this.I()).Code(kVar, drawable);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.jp
    public String B() {
        return "NativeVideoP";
    }

    @Override // com.huawei.hms.ads.kg
    public void Code(com.huawei.openalliance.ad.inter.data.k kVar) {
        if (kVar == null) {
            return;
        }
        V(kVar);
    }

    @Override // com.huawei.hms.ads.kg
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.Code = nVar != null ? nVar.l() : null;
    }

    @Override // com.huawei.hms.ads.kg
    public void Code(final com.huawei.openalliance.ad.inter.data.v vVar) {
        if (vVar == null) {
            return;
        }
        final boolean Code = vVar.Code();
        String V = vVar.V();
        if (TextUtils.isEmpty(V) || !V.startsWith(bq.CONTENT.toString())) {
            gl.V("NativeVideoP", "check if video cached.");
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.jt.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.huawei.openalliance.ad.constant.ax.f32283z, vVar.V());
                            com.huawei.openalliance.ad.ipc.g.V(((jp) jt.this).V).Code(com.huawei.openalliance.ad.constant.q.f32325h, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jt.1.1
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                    String data = callResult.getData();
                                    if (TextUtils.isEmpty(data) || !data.startsWith(bq.CONTENT.toString())) {
                                        return;
                                    }
                                    vVar.V(data);
                                }
                            }, String.class);
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.jt.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    gl.Code("NativeVideoP", "video path: %s", vVar.V());
                                    lh lhVar = (lh) jt.this.I();
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    lhVar.Code(vVar, Code);
                                }
                            };
                        } catch (JSONException unused) {
                            gl.Code("NativeVideoP", "check video cache jsonEx");
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.jt.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    gl.Code("NativeVideoP", "video path: %s", vVar.V());
                                    lh lhVar = (lh) jt.this.I();
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    lhVar.Code(vVar, Code);
                                }
                            };
                        }
                        com.huawei.openalliance.ad.utils.ba.Code(runnable);
                    } catch (Throwable th) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jt.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                gl.Code("NativeVideoP", "video path: %s", vVar.V());
                                lh lhVar = (lh) jt.this.I();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                lhVar.Code(vVar, Code);
                            }
                        });
                        throw th;
                    }
                }
            });
        } else {
            gl.V("NativeVideoP", "video is cached.");
            ((lh) I()).Code(vVar, Code);
        }
    }

    @Override // com.huawei.hms.ads.kg
    public void Code(boolean z10) {
        kv.Code(((jp) this).V, this.Code, z10);
    }
}
