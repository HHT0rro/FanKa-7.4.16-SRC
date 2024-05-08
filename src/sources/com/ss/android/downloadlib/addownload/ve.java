package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ve implements IReserveWifiStatusListener {
    @Override // com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener
    public void onStatusChanged(DownloadInfo downloadInfo, int i10, int i11) {
        com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i11));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i10));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("pause_reserve_wifi", jSONObject, m10);
    }
}
