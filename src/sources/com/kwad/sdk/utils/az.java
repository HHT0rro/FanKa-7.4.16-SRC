package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class az {
    private static Context aPJ;
    private static Map<String, j> aPK = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends j<com.kwad.sdk.l.a.b> {
        private static com.kwad.sdk.l.a.b aPL;

        public a(boolean z10) {
            super(z10);
        }

        @RequiresApi(api = 17)
        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) s.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.j
        /* renamed from: cQ, reason: merged with bridge method [inline-methods] */
        public com.kwad.sdk.l.a.b bP(Context context) {
            int i10;
            int i11;
            if (!au.Mh() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(64L)) {
                com.kwad.sdk.l.a.b bVar = aPL;
                if (bVar != null) {
                    return bVar;
                }
                CellInfo cellInfo = null;
                if (context == null || au.Mh()) {
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36121g) == -1) {
                    return null;
                }
                if (bi.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36121g) == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i11 = cdmaCellLocation.getBaseStationId();
                        i10 = cdmaCellLocation.getNetworkId();
                    } else if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        i11 = gsmCellLocation.getCid();
                        i10 = gsmCellLocation.getLac();
                    } else {
                        i10 = -1;
                        i11 = -1;
                    }
                    Iterator<CellInfo> iterator2 = telephonyManager.getAllCellInfo().iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        CellInfo next = iterator2.next();
                        if (next != null && next.isRegistered()) {
                            cellInfo = next;
                            break;
                        }
                    }
                    aPL = new com.kwad.sdk.l.a.b(i11, i10, cellInfo != null ? a(cellInfo) : -1);
                }
                return aPL;
            }
            return aPL;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends j<com.kwad.sdk.l.a.f> {
        public b(boolean z10) {
            super(z10);
        }

        @Nullable
        private static com.kwad.sdk.l.a.f cR(Context context) {
            com.kwad.sdk.l.a.f fVar = new com.kwad.sdk.l.a.f();
            fVar.aNe = av.cE(context);
            fVar.aNd = av.cC(context);
            return fVar;
        }

        @Override // com.kwad.sdk.utils.j
        @Nullable
        public final /* synthetic */ com.kwad.sdk.l.a.f bP(Context context) {
            return cR(context);
        }
    }

    @Nullable
    public static com.kwad.sdk.l.a.b Ky() {
        if (MA()) {
            return (com.kwad.sdk.l.a.b) gL("baseStationEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.l.a.f Kz() {
        if (MA()) {
            return (com.kwad.sdk.l.a.f) gL("simCardInfoEnable");
        }
        return null;
    }

    private static boolean MA() {
        return aPJ != null;
    }

    @Nullable
    private static <T> j<T> gK(String str) {
        try {
            return aPK.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static <T> T gL(String str) {
        j gK = gK(str);
        if (gK != null) {
            return (T) gK.bO(aPJ);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (MA()) {
            if (aPK.containsKey("baseStationEnable")) {
                boolean yC = hVar.yC();
                j gK = gK("baseStationEnable");
                if (gK != null) {
                    gK.bQ(yC);
                }
            }
            if (aPK.containsKey("simCardInfoEnable")) {
                boolean yA = hVar.yA();
                j gK2 = gK("simCardInfoEnable");
                if (gK2 != null) {
                    gK2.bQ(yA);
                    return;
                }
                return;
            }
            return;
        }
        aPJ = context.getApplicationContext();
        aPK.put("baseStationEnable", new a(hVar.yC()));
        aPK.put("simCardInfoEnable", new b(hVar.yA()));
    }
}
