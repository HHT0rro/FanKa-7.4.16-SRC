package com.jd.ad.sdk.jad_xi;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.jad_xi.jad_cp;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_fs implements jad_dq {
    @NonNull
    public jad_cp jad_an(@NonNull Context context, @NonNull jad_cp.jad_an jad_anVar) {
        boolean z10 = ContextCompat.checkSelfPermission(context, g.f36116b) == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Object[] objArr = new Object[1];
            objArr[0] = z10 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            Logger.d("ConnectivityMonitor", objArr);
        }
        return z10 ? new jad_er(context, jad_anVar) : new jad_na();
    }
}
