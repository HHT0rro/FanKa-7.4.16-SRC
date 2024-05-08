package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.h;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AvailabilityException extends Exception {
    private final ArrayMap<com.google.android.gms.common.api.internal.b<?>, ConnectionResult> zaa;

    public AvailabilityException(@RecentlyNonNull ArrayMap<com.google.android.gms.common.api.internal.b<?>, ConnectionResult> arrayMap) {
        this.zaa = arrayMap;
    }

    @NonNull
    public ConnectionResult getConnectionResult(@RecentlyNonNull b<? extends a.d> bVar) {
        com.google.android.gms.common.api.internal.b<? extends a.d> b4 = bVar.b();
        boolean z10 = this.zaa.get(b4) != null;
        String a10 = b4.a();
        StringBuilder sb2 = new StringBuilder(String.valueOf(a10).length() + 58);
        sb2.append("The given API (");
        sb2.append(a10);
        sb2.append(") was not part of the availability request.");
        h.b(z10, sb2.toString());
        return (ConnectionResult) h.h(this.zaa.get(b4));
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        for (com.google.android.gms.common.api.internal.b<?> bVar : this.zaa.h()) {
            ConnectionResult connectionResult = (ConnectionResult) h.h(this.zaa.get(bVar));
            if (connectionResult.isSuccess()) {
                z10 = false;
            }
            String a10 = bVar.a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb2 = new StringBuilder(String.valueOf(a10).length() + 2 + valueOf.length());
            sb2.append(a10);
            sb2.append(": ");
            sb2.append(valueOf);
            arrayList.add(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        if (z10) {
            sb3.append("None of the queried APIs are available. ");
        } else {
            sb3.append("Some of the queried APIs are unavailable. ");
        }
        sb3.append(TextUtils.join("; ", arrayList));
        return sb3.toString();
    }

    @NonNull
    public ConnectionResult getConnectionResult(@RecentlyNonNull c<? extends a.d> cVar) {
        com.google.android.gms.common.api.internal.b<? extends a.d> b4 = cVar.b();
        boolean z10 = this.zaa.get(b4) != null;
        String a10 = b4.a();
        StringBuilder sb2 = new StringBuilder(String.valueOf(a10).length() + 58);
        sb2.append("The given API (");
        sb2.append(a10);
        sb2.append(") was not part of the availability request.");
        h.b(z10, sb2.toString());
        return (ConnectionResult) h.h(this.zaa.get(b4));
    }
}
