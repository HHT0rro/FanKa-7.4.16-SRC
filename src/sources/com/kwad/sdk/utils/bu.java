package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bu {
    private static boolean aRg;
    private static final List<a> aRh = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements com.kwad.sdk.core.b {
        public String aRi;
        public String aRj;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, this.level);
            t.putValue(jSONObject, "ssid", this.aRi);
            t.putValue(jSONObject, "bssid", this.aRj);
            return jSONObject;
        }
    }

    public static boolean dj(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36121g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36122h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36121g) == -1;
    }

    public static List<a> n(Context context, int i10) {
        WifiManager wifiManager;
        if (au.Mq()) {
            return new ArrayList();
        }
        if (!aRg && ServiceProvider.KP().canReadNearbyWifiList()) {
            List<a> list = aRh;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(32L)) {
                    return list;
                }
                try {
                } catch (Exception e2) {
                    aRg = true;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                }
                if (dj(context) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
                    return list;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        a aVar = new a();
                        aVar.aRi = scanResult.SSID;
                        aVar.aRj = scanResult.BSSID;
                        aVar.level = scanResult.level;
                        if (connectionInfo.getBSSID() != null && scanResult.BSSID != null && TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) && connectionInfo.getSSID() != null && scanResult.SSID != null && TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            aRh.add(0, aVar);
                        } else {
                            aRh.add(aVar);
                        }
                        List<a> list2 = aRh;
                        if (list2.size() >= i10) {
                            return list2;
                        }
                    }
                }
                return aRh;
            }
        }
        return aRh;
    }
}
