package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e implements com.kwad.sdk.i.b {
    public int aIT;
    public b aIU;
    public a aIV;
    public double aor;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements com.kwad.sdk.i.b {
        public List<String> aIW;
        public List<String> aIX;
        public List<String> aIY;

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aIW = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("levelList");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    this.aIW.add(optJSONArray.optString(i10));
                }
            }
            this.aIX = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("tagList");
            if (optJSONArray2 != null) {
                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                    this.aIX.add(optJSONArray2.optString(i11));
                }
            }
            this.aIY = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (optJSONArray3 != null) {
                for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                    this.aIY.add(optJSONArray3.optString(i12));
                }
            }
        }

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b implements com.kwad.sdk.i.b {
        public static int OK = 1;
        public static int aIZ = -1;
        public static int aJa;
        public List<String> aEY;
        public List<String> aEZ;
        public List<String> aJb;
        public int aJc = aIZ;

        public final boolean IW() {
            return this.aJc == OK;
        }

        public final void bD(boolean z10) {
            this.aJc = z10 ? OK : aJa;
        }

        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aEY = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    this.aEY.add(optJSONArray.optString(i10));
                }
            }
            this.aEZ = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (optJSONArray2 != null) {
                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                    this.aEZ.add(optJSONArray2.optString(i11));
                }
            }
            this.aJb = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (optJSONArray3 != null) {
                for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                    this.aJb.add(optJSONArray3.optString(i12));
                }
            }
        }

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }
    }

    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aor = jSONObject.optDouble("ratio");
        this.aIT = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.aIU = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.aIV = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }
}
