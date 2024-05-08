package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.jsbridge.core.BridgeWebView;
import com.alibaba.security.realidentity.jsbridge.core.ResponseData;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bk implements bg {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3179a = "bk";

    /* renamed from: b, reason: collision with root package name */
    private final Context f3180b;

    /* renamed from: c, reason: collision with root package name */
    private final BridgeWebView f3181c;

    public bk(Context context, BridgeWebView bridgeWebView) {
        this.f3180b = context;
        this.f3181c = bridgeWebView;
    }

    @Override // com.alibaba.security.realidentity.build.bg
    public final void a(String str, final bj bjVar) {
        ResponseData responseData = new ResponseData();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("action");
            String string2 = jSONObject.getString("params");
            if (!TextUtils.isEmpty(string) && JsonUtils.isJsonString(string2)) {
                if (ax.a(this.f3180b, string, string2, new ay() { // from class: com.alibaba.security.realidentity.build.bk.1
                    @Override // com.alibaba.security.realidentity.build.ay
                    public final void a(bf bfVar) {
                        bjVar.a(new ResponseData(bfVar).toJsonString());
                    }

                    @Override // com.alibaba.security.realidentity.build.ay
                    public final void b() {
                        ResponseData responseData2 = new ResponseData(new bf(bf.f3156b));
                        responseData2.success();
                        bjVar.a(responseData2.toJsonString());
                    }

                    @Override // com.alibaba.security.realidentity.build.ay
                    public final void a(String str2) {
                        bjVar.a(new ResponseData(new bf(str2)).toJsonString());
                    }

                    @Override // com.alibaba.security.realidentity.build.ay
                    public final void b(String str2) {
                        bf bfVar = new bf(bf.f3156b);
                        try {
                            if (JsonUtils.isJsonString(str2)) {
                                bfVar.f3166k = new JSONObject(str2);
                            } else {
                                bfVar.a(str2);
                            }
                            ResponseData responseData2 = new ResponseData(bfVar);
                            responseData2.success();
                            bjVar.a(responseData2.toJsonString());
                        } catch (JSONException unused) {
                            RPLogging.e(bk.f3179a, "result is not json str ");
                        }
                    }

                    @Override // com.alibaba.security.realidentity.build.ay
                    public final void a() {
                        bjVar.a(new ResponseData(new bf(bf.f3161g)).toJsonString());
                    }

                    @Override // com.alibaba.security.realidentity.build.ay
                    public final void a(String str2, String str3) {
                        bk.this.f3181c.a(str2, str3, new bj() { // from class: com.alibaba.security.realidentity.build.bk.1.1
                            @Override // com.alibaba.security.realidentity.build.bj
                            public final void a(String str4) {
                            }
                        });
                    }

                    @Override // com.alibaba.security.realidentity.build.ay
                    public final void b(bf bfVar) {
                        if (bfVar != null) {
                            bfVar.f3165a = 1;
                        }
                        ResponseData responseData2 = new ResponseData(bfVar);
                        responseData2.success();
                        bjVar.a(responseData2.toJsonString());
                    }
                })) {
                    return;
                }
                RPLogging.e(f3179a, str);
                responseData.setResult(new bf(bf.f3158d));
                bjVar.a(responseData.toJsonString());
                return;
            }
            RPLogging.e(f3179a, str);
            responseData.setResult(new bf(bf.f3159e));
            bjVar.a(responseData.toJsonString());
        } catch (JSONException e2) {
            RPLogging.e(f3179a, str, e2);
            responseData.setResult(new bf(bf.f3159e));
            bjVar.a(responseData.toJsonString());
        } catch (Exception e10) {
            RPLogging.e(f3179a, str, e10);
            responseData.setResult(new bf(bf.f3162h));
            bjVar.a(responseData.toJsonString());
        }
    }
}
