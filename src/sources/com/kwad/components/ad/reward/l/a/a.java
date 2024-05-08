package com.kwad.components.ad.reward.l.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private b xF = new b();
    private final C0432a xG = new C0432a(d.Cg());

    /* renamed from: com.kwad.components.ad.reward.l.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0432a extends com.kwad.components.ad.reward.l.b {
        public C0432a(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            this.xD = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i10);
            this.xE = String.format("进阶奖励：浏览详情页 %ss", sb3.toString());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.xD = "基础奖励：观看视频";
            this.xE = "基础奖励：需再观看%ss视频";
        }
    }

    private void jC() {
        if (this.xG.isCompleted()) {
            js();
        } else {
            jt();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.xG.isCompleted();
    }

    public final void jA() {
        c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.xF.js();
        jC();
    }

    public final boolean jB() {
        return this.xF.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> jq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xF);
        arrayList.add(this.xG);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int jr() {
        Iterator<com.kwad.components.ad.reward.l.c> iterator2 = jq().iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            if (!iterator2.next().isCompleted()) {
                i10++;
            }
        }
        return i10;
    }

    public final void markOpenNsCompleted() {
        c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.xG.js();
        jC();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xF.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xG.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xF);
        t.a(jSONObject, "mOpenNsTask", this.xG);
        return jSONObject;
    }
}
