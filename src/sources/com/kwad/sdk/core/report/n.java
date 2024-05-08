package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n extends e {
    public String IB;
    public String IC;
    public long IE;
    public String KG;
    public String Ra;
    public long Rh;
    public long Ri;
    public long Rj;
    public long Sd;
    public long VU;
    public String WQ;
    public int Xt;
    public long actionType;
    public transient SceneImpl adScene;
    public long auc;
    public long axI;
    public JSONObject axJ;
    public JSONObject axK;
    public long axL;
    public long axM;
    public long axN;
    public long axO;
    public long axP;
    public long axR;
    public URLPackage axS;
    public String axT;
    public JSONArray axU;
    public JSONArray axV;
    public a axW;
    public int axX;
    public int axY;
    public int axZ;
    public long ayA;
    public long ayB;
    public JSONArray ayC;
    public String ayD;
    public String ayE;
    public String ayF;
    public String ayG;
    public String ayH;
    public String ayJ;
    public String ayK;
    public int ayL;
    public long ayO;
    public long ayP;
    public String ayQ;
    public int aya;
    public String ayb;
    public int ayc;
    public int ayd;
    public String aye;
    public JSONObject ayf;
    public JSONArray ayg;
    public int ayh;
    public int ayi;
    public int ayj;
    public JSONArray ayl;
    public boolean aym;
    public String ayn;
    public long ayq;
    public int ayr;
    public String ays;
    public long ayt;
    public long ayu;
    public long ayv;
    public long ayw;
    public String ayx;
    public int ayy;
    public JSONArray ayz;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;

    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long axQ = -1;
    public int apY = 0;
    public long ayk = 0;
    public int ayo = 0;
    public int ayp = -1;
    public int ayI = 0;
    public int ayM = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String ayN = BuildConfig.VERSION_NAME;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int ayR;
        public int ayS;

        public static a EO() {
            a aVar = new a();
            aVar.ayR = b.ayR;
            aVar.ayS = b.ayS;
            return aVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        public static int ayR;
        public static int ayS;
    }

    public n(long j10) {
        this.WQ = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.ayQ = "";
        this.actionType = j10;
    }

    private void bX(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        try {
            this.axY = 3;
            s sVar = (s) ServiceProvider.get(s.class);
            if (sVar != null) {
                this.ayo = sVar.tA();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = t.ET();
            try {
                this.IE = t.EU();
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            }
            this.axI = t.EV();
            SceneImpl sceneImpl2 = this.adScene;
            if (sceneImpl2 != null) {
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                this.adScene = sceneImpl;
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.axL = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.b.e.dN(adTemplate);
                String dO = com.kwad.sdk.core.response.b.e.dO(adTemplate);
                if (!TextUtils.isEmpty(dO)) {
                    try {
                        this.axJ = new JSONObject(dO);
                    } catch (Exception e10) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e10);
                    }
                }
                String dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
                if (!TextUtils.isEmpty(dP)) {
                    try {
                        this.axK = new JSONObject(dP);
                    } catch (Exception e11) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e11);
                    }
                }
                this.posId = com.kwad.sdk.core.response.b.e.dJ(adTemplate);
                this.contentType = com.kwad.sdk.core.response.b.e.dM(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.b.e.dW(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
                    this.creativeId = dQ.adBaseInfo.creativeId;
                    this.axM = com.kwad.sdk.core.response.b.a.L(dQ) * 1000;
                    this.Sd = dQ.advertiserInfo.userId;
                }
                this.axX = adTemplate.mMediaPlayerType;
                this.axZ = adTemplate.mIsLeftSlipStatus;
                this.aya = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.pageType = pageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.b.e.dX(adTemplate);
            }
            this.axW = a.EO();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e12) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e12);
        }
    }

    public final n EM() {
        bX(this.mAdTemplate);
        return this;
    }

    public final void EN() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.ayh = jVar.qB() ? 1 : 0;
        this.ayi = jVar.qC();
        this.ayj = jVar.qD();
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.axY = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.ayd = jSONObject.optInt("num");
        this.ayc = jSONObject.optInt("state");
        this.ayk = jSONObject.optLong("timeSpend");
        this.ayA = jSONObject.optLong("loadingDuration");
        this.ayB = jSONObject.optLong("loadingDurationLimt");
        this.ayp = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actionId", this.actionId);
        int i10 = this.adStyle;
        if (i10 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i10);
        }
        int i11 = this.ayd;
        if (i11 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "num", i11);
        }
        int i12 = this.ayc;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "state", i12);
        }
        long j10 = this.ayk;
        if (j10 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timeSpend", j10);
        }
        long j11 = this.ayA;
        if (j11 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDuration", j11);
        }
        long j12 = this.ayB;
        if (j12 > 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadingDurationLimt", j12);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "playerTypeInfo", this.ayp);
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        if (TextUtils.isEmpty(this.ayQ)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.ayQ + '}';
    }

    public n(long j10, @Nullable AdTemplate adTemplate) {
        this.WQ = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.ayQ = "";
        this.actionType = j10;
        this.mAdTemplate = adTemplate;
    }

    public n(long j10, @Nullable AdTemplate adTemplate, String str) {
        this.WQ = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.ayQ = "";
        this.actionType = j10;
        this.mAdTemplate = adTemplate;
        this.KG = str;
    }

    public n(String str, String str2, boolean z10) {
        this.WQ = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.actionId = str;
        this.ayQ = str2;
    }
}
