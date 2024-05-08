package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {
    private static final String TAG = "c";
    public final double aFb;
    public final boolean aFf;
    public final boolean aFg;
    public final com.kwad.sdk.crash.model.c aFj;
    public final com.kwad.sdk.crash.model.a aFk;
    public final h aFl;
    public final String[] aFm;
    public final String[] aFn;
    public final boolean aFo;
    public final f aFp;
    public final String aFq;
    public final String aFr;
    public final String aFs;
    public final String aFt;
    public final String aFu;
    public final String aFv;
    public final String aFw;
    public final String aFx;
    public final List<com.kwad.sdk.crash.a> aFy;
    public final boolean akW;
    public final String azp;
    public final String channel;
    public final Context context;
    public final String platform;
    public final String sdkVersion;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private String WQ;
        private int WR;
        private h aFA;
        private String[] aFB;
        public String[] aFC;
        private f aFp;
        private String aFq;
        private String aFr;
        private String aFs;
        private String aFt;
        private String aFz;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private int ayM;
        private String azp;
        private String channel;
        private Context context;
        private String platform;
        public int sdkType;
        private String sdkVersion;
        private boolean aFo = false;
        private boolean aFf = false;
        private boolean aFg = false;
        private boolean akW = false;
        private String aFu = "";
        private String aFv = "";
        private String aFw = "";
        private String aFx = "";
        private List<com.kwad.sdk.crash.a> aFy = new ArrayList();
        private double aFb = 1.0d;

        public final a E(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.aFy.add(aVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.c.w(c.TAG, Log.getStackTraceString(e2));
                    }
                }
            }
            return this;
        }

        public final c Ht() {
            return new c(this, (byte) 0);
        }

        public final a bv(Context context) {
            this.context = context;
            return this;
        }

        public final a bx(boolean z10) {
            this.aFf = z10;
            return this;
        }

        public final a by(boolean z10) {
            this.aFg = z10;
            return this;
        }

        public final a bz(boolean z10) {
            this.akW = z10;
            return this;
        }

        public final a dA(int i10) {
            this.sdkType = 1;
            return this;
        }

        public final a dy(int i10) {
            this.ayM = i10;
            return this;
        }

        public final a dz(int i10) {
            this.WR = i10;
            return this;
        }

        public final a eZ(String str) {
            this.aFu = str;
            return this;
        }

        public final a fa(String str) {
            this.aFv = str;
            return this;
        }

        public final a fb(String str) {
            this.platform = str;
            return this;
        }

        public final a fc(String str) {
            this.aFq = str;
            return this;
        }

        public final a fd(String str) {
            this.azp = str;
            return this;
        }

        public final a fe(String str) {
            this.channel = str;
            return this;
        }

        public final a ff(String str) {
            this.aFt = str;
            return this;
        }

        public final a fg(String str) {
            this.aFz = str;
            return this;
        }

        public final a fh(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a fi(String str) {
            this.WQ = str;
            return this;
        }

        public final a fj(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a fk(String str) {
            this.appId = str;
            return this;
        }

        public final a fl(String str) {
            this.appName = str;
            return this;
        }

        public final a fm(String str) {
            this.appVersion = str;
            return this;
        }

        public final a fn(String str) {
            this.aFr = str;
            return this;
        }

        public final a fo(String str) {
            this.aFw = str;
            return this;
        }

        public final a fp(String str) {
            this.aFx = str;
            return this;
        }

        public final a a(f fVar) {
            this.aFp = fVar;
            return this;
        }

        public final a d(String[] strArr) {
            this.aFB = strArr;
            return this;
        }

        public final a e(String[] strArr) {
            this.aFC = strArr;
            return this;
        }

        public final a m(double d10) {
            this.aFb = d10;
            return this;
        }

        public final a a(h hVar) {
            this.aFA = hVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b4) {
        this(aVar);
    }

    public final f Hq() {
        return this.aFp;
    }

    public final boolean Hr() {
        return this.aFo;
    }

    private c(a aVar) {
        com.kwad.sdk.crash.model.c cVar = new com.kwad.sdk.crash.model.c();
        this.aFj = cVar;
        com.kwad.sdk.crash.model.a aVar2 = new com.kwad.sdk.crash.model.a();
        this.aFk = aVar2;
        ArrayList arrayList = new ArrayList();
        this.aFy = arrayList;
        this.aFo = aVar.aFo;
        this.aFf = aVar.aFf;
        this.aFg = aVar.aFg;
        this.akW = aVar.akW;
        this.aFu = aVar.aFu;
        this.aFv = aVar.aFv;
        this.aFw = aVar.aFw;
        this.aFx = aVar.aFx;
        this.context = aVar.context;
        this.aFp = aVar.aFp;
        this.platform = aVar.platform;
        this.aFq = aVar.aFq;
        this.aFr = aVar.aFr;
        this.sdkVersion = aVar.sdkVersion;
        this.azp = aVar.azp;
        this.channel = aVar.channel;
        this.aFs = aVar.aFs;
        this.aFt = aVar.aFt;
        aVar2.aGc = aVar.appId;
        aVar2.mAppName = aVar.appName;
        aVar2.aGe = aVar.appVersion;
        aVar2.aGd = aVar.appPackageName;
        cVar.aGn = aVar.WQ;
        cVar.aGo = aVar.WR;
        cVar.mSdkVersion = aVar.sdkVersion;
        cVar.aGm = aVar.ayM;
        cVar.aGl = aVar.aFz;
        cVar.aGp = aVar.sdkType;
        this.aFl = aVar.aFA;
        this.aFm = aVar.aFB;
        this.aFn = aVar.aFC;
        arrayList.addAll(aVar.aFy);
        this.aFb = aVar.aFb;
    }
}
