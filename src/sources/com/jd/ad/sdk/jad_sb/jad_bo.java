package com.jd.ad.sdk.jad_sb;

import androidx.annotation.NonNull;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo {
    @NonNull
    public jad_an jad_an(@NonNull String str) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();
        return new jad_an(httpsURLConnection);
    }
}