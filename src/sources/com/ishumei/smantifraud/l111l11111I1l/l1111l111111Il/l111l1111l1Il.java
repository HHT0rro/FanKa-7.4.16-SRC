package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111l1Il extends l111l1111lI1l {
    private final Context l1111l111111Il;

    public l111l1111l1Il(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i10 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = this.l1111l111111Il.getContentResolver().acquireContentProviderClient(parse);
            Bundle bundle = null;
            if (acquireContentProviderClient != null) {
                bundle = acquireContentProviderClient.call("getOAID", null, null);
                if (i10 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            }
            return (bundle != null ? bundle.getInt("code", -1) : -1) == 0 ? bundle.getString("id") : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
