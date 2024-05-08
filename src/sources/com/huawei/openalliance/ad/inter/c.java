package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kw;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends BroadcastReceiver {
    private Context C;
    private fr S;

    public c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.C = applicationContext;
        this.S = fr.Code(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdContentData Code(JSONObject jSONObject) {
        AdContentData adContentData = null;
        try {
            String optString = jSONObject.optString("contentRecord");
            AdContentData adContentData2 = (AdContentData) z.V(optString, AdContentData.class, new Class[0]);
            try {
                if (gl.Code()) {
                    gl.Code("ExLinkedSplashReceiver", " adContent content=%s", bc.Code(optString));
                }
                if (adContentData2 == null) {
                    return adContentData2;
                }
                V(jSONObject);
                return adContentData2;
            } catch (Throwable th) {
                th = th;
                adContentData = adContentData2;
                gl.I("ExLinkedSplashReceiver", "handleResponse exception: %s", th.getClass().getSimpleName());
                return adContentData;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code() {
        com.huawei.openalliance.ad.ipc.d.Code(this.C).Code("showSplash", null, null, null);
    }

    private void V(JSONObject jSONObject) {
        int optInt = jSONObject.optInt(ax.H);
        String optString = jSONObject.optString(ax.G);
        if (gl.Code()) {
            gl.Code("ExLinkedSplashReceiver", "splashSkipArea=%s", Integer.valueOf(optInt));
            gl.Code("ExLinkedSplashReceiver", "globalSwitch=%s", bc.Code(optString));
        }
        fr frVar = this.S;
        if (frVar != null) {
            frVar.C(optInt);
            this.S.I(optString);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (u.bk.equals(intent.getAction())) {
                gl.V("ExLinkedSplashReceiver", "receiver exlinkedsplash action");
                Long valueOf = Long.valueOf(intent.getLongExtra("exsplash_slogan_start_time", 0L));
                int intExtra = intent.getIntExtra("exsplash_slogan_show_time", 0);
                String stringExtra = intent.getStringExtra("linked_content_id");
                int intExtra2 = intent.getIntExtra("exsplash_redundancy_time", 0);
                gl.Code("ExLinkedSplashReceiver", "ExLinkedSplashReceiver, startTime: %s, showTime: %s, contentId: %s", valueOf, Integer.valueOf(intExtra), stringExtra);
                context.removeStickyBroadcast(intent);
                fr frVar = this.S;
                if (frVar != null) {
                    frVar.V(valueOf.longValue());
                    this.S.Z(intExtra);
                    this.S.V(stringExtra);
                    this.S.B(intExtra2);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_id", stringExtra);
                jSONObject.put("package_name", this.C.getPackageName());
                jSONObject.put(ax.E, false);
                com.huawei.openalliance.ad.ipc.d.Code(context).Code("reqLinkedVideo", jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.c.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            gl.I("ExLinkedSplashReceiver", "call reqExLinked failed");
                            c.this.Code();
                            return;
                        }
                        gl.V("ExLinkedSplashReceiver", "reqExLinkedVideo success");
                        try {
                            final AdContentData Code = c.this.Code(new JSONObject(callResult.getData()));
                            if (Code != null) {
                                Code.B(true);
                                final l Code2 = kw.Code(Code);
                                Code2.Code(true);
                                final com.huawei.openalliance.ad.inter.listeners.e C = g.Code(context).C();
                                if (C != null) {
                                    com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.c.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            String str2;
                                            String str3;
                                            boolean Code3 = C.Code(Code2);
                                            gl.V("ExLinkedSplashReceiver", "onReceive, isCanDisplay: %s", Boolean.valueOf(Code3));
                                            if (Code3) {
                                                return;
                                            }
                                            gl.I("ExLinkedSplashReceiver", "isCanDisplay false, start show normal splash. ");
                                            c.this.Code();
                                            l lVar = Code2;
                                            if (lVar != null) {
                                                String D = lVar.D();
                                                str2 = Code2.m();
                                                str3 = D;
                                            } else {
                                                str2 = null;
                                                str3 = null;
                                            }
                                            eo.Code(context, str2, str3, 0L, Code, "82");
                                        }
                                    });
                                    return;
                                }
                                gl.I("ExLinkedSplashReceiver", "exSplashCallback is null");
                            } else {
                                gl.I("ExLinkedSplashReceiver", "content is null");
                            }
                            c.this.Code();
                        } catch (JSONException unused) {
                            gl.I("ExLinkedSplashReceiver", "reqLinkedVideo onRemoteCallResult JSONException ");
                        }
                    }
                }, String.class);
            }
        } catch (JSONException unused) {
            gl.I("ExLinkedSplashReceiver", "reqExLinkedVideo JSONException");
            Code();
        } catch (Throwable th) {
            gl.I("ExLinkedSplashReceiver", "reqLinkedVideo exception: %s", th.getClass().getSimpleName());
        }
    }
}
