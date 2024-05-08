package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private c xH = new c();
    private C0433a xI = new C0433a();
    private final b xJ = new b(com.kwad.components.ad.reward.a.b.gr());

    /* renamed from: com.kwad.components.ad.reward.l.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0433a extends com.kwad.components.ad.reward.l.b {
        public C0433a() {
            this.xD = "安装应用";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends com.kwad.components.ad.reward.l.b {
        public b(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            this.xD = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i10);
            this.xE = String.format("进阶奖励：安装并激活APP %ss", sb3.toString());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.xD = "基础奖励：观看视频";
            this.xE = "基础奖励：需再观看%ss视频";
        }
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (ak.an(context, com.kwad.sdk.core.response.b.a.ay(e.dQ(adTemplate)))) {
            aVar.jD();
        } else {
            aVar.jE();
        }
    }

    private void jC() {
        if (this.xH.isCompleted() && this.xI.isCompleted() && this.xJ.isCompleted()) {
            js();
        } else {
            jt();
        }
    }

    private void jE() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markInstallUncompleted");
        this.xI.jt();
        jC();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.xI.isCompleted() && this.xJ.isCompleted();
    }

    public final void jA() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.xH.js();
        jC();
    }

    public final boolean jB() {
        return this.xH.isCompleted();
    }

    public final void jD() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markInstallCompleted");
        this.xI.js();
        jC();
    }

    public final void jF() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markUseAppCompleted");
        this.xJ.js();
        jC();
    }

    public final boolean jG() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "isInstallCompleted");
        return this.xI.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> jq() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xH);
        arrayList.add(this.xJ);
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

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xH.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xJ.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xH);
        t.a(jSONObject, "mInstallAppTask", this.xI);
        t.a(jSONObject, "mUseAppTask", this.xJ);
        return jSONObject;
    }
}
