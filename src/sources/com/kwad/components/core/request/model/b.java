package com.kwad.components.core.request.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.android.internal.os.PowerProfile;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.l.a.d;
import com.kwad.sdk.l.a.e;
import com.kwad.sdk.l.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.kwad.sdk.core.b {
    private int RC;
    private String RD;
    private int RE;
    private Long RF;
    private Long RG;
    private Long RH;
    private Long RI;
    private String RJ;
    private String RK;
    private long RM;
    private String RN;
    private String RO;
    private long RP;
    private String RR;
    private String RS;
    private boolean RT;
    private List<a> RV;
    private f RW;
    private d RX;
    private com.kwad.sdk.l.a.b RY;
    private List<e> RZ;
    private List<bu.a> RL = new CopyOnWriteArrayList();
    private int RQ = -1;
    private float screenBrightness = -1.0f;
    private int RU = -1;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int Sa = -1;
        public int Sb = -1;
        public int Sc = -1;
        public int streamType;

        private a(int i10) {
            this.streamType = i10;
        }

        private static int aG(int i10) {
            if (i10 != 0) {
                if (i10 == 1) {
                    return 1;
                }
                if (i10 == 2) {
                    return 2;
                }
                if (i10 == 3) {
                    return 3;
                }
                if (i10 == 4) {
                    return 4;
                }
                if (i10 == 5) {
                    return 5;
                }
            }
            return 0;
        }

        public static List<a> ag(Context context) {
            AudioManager audioManager;
            ArrayList arrayList = new ArrayList();
            if (context == null || com.kwad.sdk.core.config.d.X(256L)) {
                return arrayList;
            }
            try {
                audioManager = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
            } catch (Exception unused) {
            }
            if (audioManager == null) {
                return arrayList;
            }
            for (int i10 = 0; i10 <= 5; i10++) {
                a aVar = new a(i10);
                int aG = aG(i10);
                aVar.Sc = audioManager.getStreamVolume(aG);
                aVar.Sa = audioManager.getStreamMaxVolume(aG);
                if (Build.VERSION.SDK_INT >= 28) {
                    aVar.Sb = audioManager.getStreamMinVolume(aG);
                }
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:7:0x001e, B:9:0x0024, B:15:0x0037, B:17:0x0041, B:20:0x0046, B:24:0x004c, B:27:0x0052), top: B:6:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void af(@androidx.annotation.NonNull android.content.Context r7) {
        /*
            r6 = this;
            r0 = 512(0x200, double:2.53E-321)
            boolean r0 = com.kwad.sdk.core.config.d.X(r0)
            if (r0 == 0) goto L9
            return
        L9:
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>()
            java.lang.String r1 = "android.intent.action.ACTION_POWER_CONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.addAction(r1)
            r1 = 0
            android.content.Intent r7 = r7.registerReceiver(r1, r0)     // Catch: java.lang.Exception -> L55
            if (r7 == 0) goto L54
            java.lang.String r0 = "status"
            r1 = -1
            int r0 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L55
            r2 = 0
            r3 = 1
            r4 = 2
            if (r0 == r4) goto L36
            r5 = 5
            if (r0 != r5) goto L34
            goto L36
        L34:
            r0 = 0
            goto L37
        L36:
            r0 = 1
        L37:
            r6.RT = r0     // Catch: java.lang.Exception -> L55
            java.lang.String r0 = "plugged"
            int r7 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L55
            if (r7 != r4) goto L44
            r6.RU = r3     // Catch: java.lang.Exception -> L55
            goto L59
        L44:
            if (r7 != r3) goto L49
            r6.RU = r4     // Catch: java.lang.Exception -> L55
            goto L59
        L49:
            r0 = 4
            if (r7 != r0) goto L50
            r7 = 3
            r6.RU = r7     // Catch: java.lang.Exception -> L55
            goto L59
        L50:
            if (r7 != 0) goto L54
            r6.RU = r2     // Catch: java.lang.Exception -> L55
        L54:
            return
        L55:
            r7 = move-exception
            com.kwad.sdk.core.e.c.printStackTrace(r7)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.request.model.b.af(android.content.Context):void");
    }

    private static Context getContext() {
        return ServiceProvider.KO();
    }

    @WorkerThread
    public static b qz() {
        b bVar = new b();
        bVar.RC = bi.MV();
        bVar.RD = AbiUtil.bD(getContext());
        bVar.RE = bi.cW(getContext());
        bVar.RF = Long.valueOf(bi.cX(getContext()));
        bVar.RG = Long.valueOf(bi.cV(getContext()));
        bVar.RH = Long.valueOf(bi.MS());
        bVar.RI = Long.valueOf(bi.MT());
        bVar.RJ = av.cA(getContext());
        bVar.RK = av.cB(getContext());
        bVar.RL.addAll(av.n(getContext(), 15));
        bVar.RM = bi.MZ();
        bVar.RP = bi.Na();
        bVar.RS = bi.Nb();
        bVar.RR = bi.Nc();
        bVar.RN = bi.Nd();
        bVar.RO = bi.Ne();
        Context context = getContext();
        if (context != null) {
            bVar.RQ = bi.de(context);
            bVar.RV = new CopyOnWriteArrayList(a.ag(context));
            bVar.af(context);
        }
        bVar.RX = n.Lg();
        bVar.RY = av.Ky();
        bVar.RZ = bb.MC().MD();
        bVar.RW = av.Kz();
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "cpuCount", this.RC);
        t.putValue(jSONObject, "cpuAbi", this.RD);
        t.putValue(jSONObject, "batteryPercent", this.RE);
        t.putValue(jSONObject, "totalMemorySize", this.RF.longValue());
        t.putValue(jSONObject, "availableMemorySize", this.RG.longValue());
        t.putValue(jSONObject, "totalDiskSize", this.RH.longValue());
        t.putValue(jSONObject, "availableDiskSize", this.RI.longValue());
        t.putValue(jSONObject, "imsi", this.RJ);
        t.putValue(jSONObject, "iccid", this.RK);
        t.putValue(jSONObject, "wifiList", this.RL);
        t.putValue(jSONObject, "bootTime", this.RM);
        t.putValue(jSONObject, "romName", this.RN);
        t.putValue(jSONObject, "romVersion", this.RO);
        t.putValue(jSONObject, "romBuildTimestamp", this.RP);
        t.putValue(jSONObject, "ringerMode", this.RQ);
        t.putValue(jSONObject, "audioStreamInfo", this.RV);
        t.putValue(jSONObject, "baseBandVersion", this.RR);
        t.putValue(jSONObject, "fingerPrint", this.RS);
        t.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        t.putValue(jSONObject, "isCharging", this.RT);
        t.putValue(jSONObject, "chargeType", this.RU);
        f fVar = this.RW;
        if (fVar != null) {
            t.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.RX;
        if (dVar != null) {
            t.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.l.a.b bVar = this.RY;
        if (bVar != null) {
            t.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.RZ;
        if (list != null) {
            t.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
