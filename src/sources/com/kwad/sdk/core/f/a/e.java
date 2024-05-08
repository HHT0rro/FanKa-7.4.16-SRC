package com.kwad.sdk.core.f.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i10 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(parse);
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i10 >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call != null) {
                str = call.getInt("code", -1) == 0 ? call.getString("id") : "";
                call.getString("message");
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
