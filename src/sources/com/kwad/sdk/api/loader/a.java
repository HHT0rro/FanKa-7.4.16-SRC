package com.kwad.sdk.api.loader;

import com.huawei.openalliance.ad.constant.bg;
import com.huawei.quickcard.base.Attributes;
import java.io.File;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0509a {
        public int alW;
        public String alX;
        public transient File alY;
        public long interval;
        public String md5;
        public String sdkVersion;

        public final boolean Aa() {
            return this.alW == 1;
        }

        public final boolean Ab() {
            return this.alW == -1;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.alW = jSONObject.optInt("dynamicType");
            this.alX = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong(Attributes.Style.INTERVAL);
            this.sdkVersion = jSONObject.optString(bg.e.Code);
        }

        public final String toString() {
            return "Data{dynamicType=" + this.alW + ", dynamicUrl='" + this.alX + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + ((Object) this.alY) + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        public long alZ;
        public C0509a ama;
        public String errorMsg;

        public final boolean Ac() {
            return this.alZ == 1 && this.ama != null;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.alZ = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString("errorMsg");
            C0509a c0509a = new C0509a();
            this.ama = c0509a;
            c0509a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.alZ + ", errorMsg='" + this.errorMsg + "', data=" + ((Object) this.ama) + '}';
        }
    }
}
