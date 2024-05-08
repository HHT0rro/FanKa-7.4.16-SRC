package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bc {
    private static String TAG = "plugin.signature";
    public static Signature[] aPZ = new Signature[0];

    @Nullable
    private static Signature[] cS(Context context) {
        Signature[] signatureArr = aPZ;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                aPZ = packageInfo.signatures;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            com.kwad.sdk.core.e.c.w(TAG, "Can not get signature, error = " + e2.getLocalizedMessage());
            com.kwad.sdk.core.e.c.w(TAG, e2);
        }
        return aPZ;
    }

    public static String cT(Context context) {
        try {
            Signature[] cS = cS(context);
            if (cS != null && cS.length > 0) {
                return ad.l(cS[0].toByteArray());
            }
            return "";
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.w(TAG, e2);
            return "";
        }
    }
}
