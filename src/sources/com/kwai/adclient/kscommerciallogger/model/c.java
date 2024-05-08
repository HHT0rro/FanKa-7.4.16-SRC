package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private final d aof;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private final String aUh;
        private BusinessType aUi;
        private SubBusinessType aUj;
        private d aUk;
        private JSONObject aUl;
        private String aUm;
        private String mTag;
        private JSONObject msg;

        private a(@NonNull String str) {
            this.aUh = str;
        }

        public static a On() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a Oo() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final a A(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final c Op() {
            if (com.kwai.adclient.kscommerciallogger.a.Oe().isDebug()) {
                if (!TextUtils.isEmpty(this.aUh) && !TextUtils.isEmpty(this.mTag) && !TextUtils.isEmpty(this.aUm)) {
                    if (com.kwai.adclient.kscommerciallogger.a.Oe().Og() && !com.kwai.adclient.kscommerciallogger.b.hk(this.aUm)) {
                        throw new IllegalArgumentException("event_id format error, please check it");
                    }
                } else {
                    throw new IllegalArgumentException("param is error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.aUh) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.aUm)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.Oe().Og() && !com.kwai.adclient.kscommerciallogger.b.hk(this.aUm)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.Oe().Of() != null) {
                this.aUl = com.kwai.adclient.kscommerciallogger.a.Oe().Of();
            }
            return new c(this, (byte) 0);
        }

        public final a hl(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        public final a hm(@NonNull String str) {
            this.aUm = str;
            return this;
        }

        public final a b(BusinessType businessType) {
            this.aUi = businessType;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.aUj = subBusinessType;
            return this;
        }

        public final a b(d dVar) {
            this.aUk = dVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b4) {
        this(aVar);
    }

    public final String Oh() {
        return this.category;
    }

    public final SubBusinessType Oi() {
        return this.subBiz;
    }

    public final d Oj() {
        return this.aof;
    }

    public final JSONObject Ok() {
        return this.msg;
    }

    public final JSONObject Ol() {
        return this.extraParam;
    }

    public final String Om() {
        return this.eventId;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put(com.alipay.sdk.app.statistic.c.f4432b, businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put("tag", this.tag);
            d dVar = this.aof;
            if (dVar != null) {
                jSONObject.put("type", dVar.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put("msg", jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private c(a aVar) {
        this.category = aVar.aUh;
        this.biz = aVar.aUi;
        this.subBiz = aVar.aUj;
        this.tag = aVar.mTag;
        this.aof = aVar.aUk;
        this.extraParam = aVar.aUl;
        this.eventId = aVar.aUm;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }
}
