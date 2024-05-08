package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.m;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    private static volatile SdkConfigData atj;
    private static final AtomicBoolean ati = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    public static boolean BA() {
        return c.aqK.getValue().intValue() > 0;
    }

    public static boolean BB() {
        return c.aqL.getValue().intValue() == 1;
    }

    public static int BC() {
        return c.aqK.getValue().intValue();
    }

    @ForInvoker(methodId = "initConfigList")
    private static void BD() {
        com.kwad.components.ad.d.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
    }

    public static List<String> BE() {
        return c.arc.getValue();
    }

    @NonNull
    public static List<String> BF() {
        return c.arb.getValue();
    }

    public static int BG() {
        return c.asw.getValue().intValue();
    }

    public static String BH() {
        return c.aqW.getValue();
    }

    public static String BI() {
        return c.aqX.getValue();
    }

    public static boolean BJ() {
        return c.aqB.getValue().intValue() == 1;
    }

    public static int BK() {
        return c.aqC.getValue().intValue();
    }

    public static boolean BL() {
        return c.aqD.getValue().intValue() == 1;
    }

    public static int BM() {
        return c.aqE.getValue().intValue();
    }

    public static int BN() {
        return c.arj.getValue().intValue();
    }

    public static int BO() {
        return c.ark.getValue().intValue();
    }

    public static int BP() {
        return c.arl.getValue().intValue();
    }

    public static long BQ() {
        return c.arm.getValue().intValue() * 60000;
    }

    public static boolean BR() {
        return c.arv.getValue().intValue() == 1;
    }

    public static boolean BS() {
        return c.arw.getValue().intValue() == 1;
    }

    public static int BT() {
        return c.arD.getValue().intValue();
    }

    public static boolean BU() {
        return c.arE.getValue().booleanValue();
    }

    public static boolean BV() {
        return a(c.arH);
    }

    public static boolean BW() {
        return !c.arJ.getValue().booleanValue();
    }

    public static boolean BX() {
        return a(c.arI);
    }

    public static boolean BY() {
        return c.arL.getValue().intValue() == 1;
    }

    public static int BZ() {
        return c.arM.getValue().intValue();
    }

    public static boolean Bu() {
        return c.aqF.getValue().intValue() == 1;
    }

    public static int Bv() {
        return c.aqG.getValue().intValue();
    }

    public static int Bw() {
        return c.aqH.getValue().intValue();
    }

    public static boolean Bx() {
        return c.aqJ.getValue().intValue() > 0;
    }

    public static boolean By() {
        return c.aqH.getValue().intValue() == 2;
    }

    public static int Bz() {
        return c.aqI.getValue().intValue();
    }

    public static String CA() {
        return c.asz.getValue();
    }

    public static String CB() {
        return c.asA.getValue();
    }

    public static int CC() {
        return c.asD.getValue().intValue();
    }

    public static boolean CD() {
        return c.asG.getValue().booleanValue();
    }

    public static int CE() {
        return c.asH.getValue().intValue();
    }

    public static boolean CF() {
        return c.atd.CM();
    }

    public static boolean CG() {
        return c.atf.CM();
    }

    @NonNull
    public static SdkConfigData Ca() {
        if (atj != null) {
            return atj;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "getSdkConfigData is ui thread");
            atj = Cb();
        } else {
            synchronized (mLock) {
                if (atj == null) {
                    return Cb();
                }
            }
        }
        return atj;
    }

    private static SdkConfigData Cb() {
        atj = new SdkConfigData();
        String ch = y.ch(ServiceProvider.KO());
        if (!TextUtils.isEmpty(ch)) {
            try {
                atj.parseJson(new JSONObject(ch));
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
        } else {
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "configCache is empty");
        }
        return atj;
    }

    public static boolean Cc() {
        return c.aqM.getValue().intValue() == 1;
    }

    public static boolean Cd() {
        return c.aqN.getValue().intValue() == 1;
    }

    public static boolean Ce() {
        return c.aqQ.getValue().booleanValue();
    }

    public static boolean Cf() {
        return c.asl.getValue().intValue() == 1;
    }

    public static int Cg() {
        return c.aqO.getValue().intValue();
    }

    public static int Ch() {
        return c.arT.getValue().intValue();
    }

    public static int Ci() {
        return c.arS.getValue().intValue();
    }

    public static boolean Cj() {
        return c.arU.getValue().intValue() == 1;
    }

    public static boolean Ck() {
        return c.arV.getValue().booleanValue();
    }

    public static float Cl() {
        float floatValue = c.arW.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float Cm() {
        return c.arX.getValue().floatValue();
    }

    public static boolean Cn() {
        return c.arZ.getValue().booleanValue();
    }

    public static boolean Co() {
        return c.asd.getValue().intValue() > 0;
    }

    public static boolean Cp() {
        return c.ask.getValue().intValue() == 1;
    }

    public static long Cq() {
        return c.asi.getValue().longValue();
    }

    public static boolean Cr() {
        return c.aso.CM();
    }

    public static com.kwad.sdk.core.network.idc.a.b Cs() {
        return c.asq.getValue();
    }

    public static int Ct() {
        return c.asr.getValue().intValue();
    }

    public static long Cu() {
        return c.ass.getValue().longValue();
    }

    public static int Cv() {
        return c.ast.getValue().intValue();
    }

    public static boolean Cw() {
        return c.asu.getValue().floatValue() == 1.0f;
    }

    public static boolean Cx() {
        return c.asv.CM();
    }

    public static boolean Cy() {
        return c.asx.CM();
    }

    public static String Cz() {
        return c.asy.getValue();
    }

    public static boolean X(long j10) {
        return (j10 & c.aqR.getValue().longValue()) != 0;
    }

    public static JSONObject a(e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.CH();
    }

    @WorkerThread
    public static synchronized void aS(Context context) {
        synchronized (d.class) {
            AtomicBoolean atomicBoolean = ati;
            if (atomicBoolean.get()) {
                return;
            }
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "loadCache");
            c.init();
            BD();
            b.aR(context);
            Ca();
            atomicBoolean.set(true);
        }
    }

    public static <T> T b(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context KO = ServiceProvider.KO();
            b.a(KO, bVar);
            g.execute(new ay() { // from class: com.kwad.sdk.core.config.d.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    d.aS(KO);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : bVar.CH();
    }

    public static void f(@NonNull SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            atj = sdkConfigData;
        }
    }

    public static String getLogObiwanData() {
        return c.ash.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.ate.getValue().intValue();
    }

    @NonNull
    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.ata.getValue();
    }

    public static String getUserAgent() {
        return c.arQ.getValue();
    }

    public static boolean gs() {
        return c.asc.getValue().booleanValue();
    }

    public static boolean isLoaded() {
        return ati.get();
    }

    public static boolean wJ() {
        return c.asB.getValue().booleanValue();
    }

    public static boolean yA() {
        return c.ars.getValue().intValue() == 1;
    }

    public static boolean yC() {
        return c.art.getValue().intValue() == 1;
    }

    public static boolean yD() {
        return c.arr.getValue().intValue() == 1;
    }

    public static String yE() {
        return c.arF.getImei();
    }

    public static String yF() {
        return c.arF.getOaid();
    }

    public static List<String> yG() {
        return c.ara.getValue();
    }

    public static boolean yH() {
        return c.arP.getValue().intValue() == 1;
    }

    public static boolean yI() {
        return c.arR.getValue().intValue() == 1;
    }

    public static boolean yK() {
        return c.asm.getValue().booleanValue();
    }

    public static boolean yL() {
        return c.asn.getValue().booleanValue();
    }

    public static int yM() {
        if (atj != null) {
            return atj.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int yN() {
        return c.asp.getValue().intValue();
    }

    public static double yO() {
        return c.arY.getValue().floatValue();
    }

    public static boolean yP() {
        return c.asF.getValue().booleanValue();
    }

    public static boolean yT() {
        return c.asS.getValue().booleanValue();
    }

    @Deprecated
    public static int yU() {
        return c.aqP.getValue().intValue();
    }

    public static boolean yV() {
        return c.asW.CM();
    }

    public static int ym() {
        return c.aqv.getValue().intValue();
    }

    public static boolean yn() {
        return false;
    }

    public static boolean yo() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return c.aqA.getValue().intValue() == 1;
    }

    public static int a(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        if (num == null) {
            num = kVar.CH();
        }
        return num.intValue();
    }

    public static long a(m mVar) {
        Long l10 = (Long) b(mVar);
        if (l10 == null) {
            l10 = mVar.CH();
        }
        return l10.longValue();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        return num != null ? num.intValue() > 0 : kVar.CH().intValue() > 0;
    }

    public static double a(f fVar) {
        Double d10 = (Double) b(fVar);
        if (d10 == null) {
            d10 = fVar.CH();
        }
        return d10.doubleValue();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean bool = (Boolean) b(dVar);
        if (bool == null) {
            bool = dVar.CH();
        }
        return bool.booleanValue();
    }

    public static String a(p pVar) {
        String str = (String) b(pVar);
        return str != null ? str : pVar.CH();
    }
}
