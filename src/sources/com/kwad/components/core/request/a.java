package com.kwad.components.core.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean Ro = true;
    public ImpInfo Mv;
    private int Rn;

    public a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, AdLabelImpl adLabelImpl) {
        int i10 = adLabelImpl.thirdAge;
        if (i10 != 0) {
            gVar.thirdAge = i10;
        }
        int i11 = adLabelImpl.thirdGender;
        if (i11 != 0) {
            gVar.thirdGender = i11;
        }
        if (TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            return;
        }
        gVar.thirdInterest = adLabelImpl.thirdInterest;
    }

    private static int c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String d(ImpInfo impInfo) {
        com.kwad.sdk.service.a.f fVar;
        if (Ro && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
            try {
                return (String) s.f(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), fVar.getContext());
            } catch (Exception unused) {
                Ro = false;
            }
        }
        return "";
    }

    public final void aF(int i10) {
        this.Rn = i10;
    }

    public final int getAdNum() {
        return this.Mv.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.Mv;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        return com.kwad.sdk.g.xW();
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        o.bR(true);
        b.qn().qo();
        super.onCreate();
    }

    private a(ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        this(impInfo, null, false, null);
    }

    public a(com.kwad.components.core.request.model.a aVar) {
        this(aVar.Mv, aVar.Rw, aVar.Rx, aVar.Rz);
        this.Rn = aVar.Ry ? 1 : 0;
    }

    public a(ImpInfo impInfo, @Nullable List<String> list, boolean z10, com.kwad.components.core.request.model.c cVar) {
        super(c(impInfo), impInfo.adScene);
        this.Mv = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            a(com.kwad.sdk.core.request.model.a.EY(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", cVar);
        int i10 = this.Rn;
        if (i10 > 0) {
            putBody("calledUnionType", i10);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String AY = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)).AY() : "";
        if (!TextUtils.isEmpty(AY)) {
            putBody("universeDebugParam", AY);
        }
        String d10 = d(impInfo);
        if (!TextUtils.isEmpty(d10)) {
            putBody("sdkDebugReqInfo", d10);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z10);
        }
        putBody("appTag", y.LK());
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.Mv.getRewardCallbackExtraByKey("thirdUserId");
        com.kwad.sdk.core.request.model.g Ff = com.kwad.sdk.core.request.model.g.Ff();
        if (rewardCallbackExtraByKey != null) {
            Ff.eo(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            a(Ff, adLabelFromAdScene);
        }
        putBody("userInfo", Ff);
    }

    private void a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            t.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            t.putValue(jSONObject2, "postTitle", adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            t.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            t.putValue(jSONObject2, TTLiveConstants.INIT_CHANNEL, adLabelImpl.channel);
        }
        t.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }
}
