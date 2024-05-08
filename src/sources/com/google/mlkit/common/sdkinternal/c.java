package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import java.util.Locale;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.internal.e f27041a = new com.google.android.gms.common.internal.e("CommonUtils", "");

    @RecentlyNonNull
    public static String a(@RecentlyNonNull Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            com.google.android.gms.common.internal.e eVar = f27041a;
            String valueOf = String.valueOf(e2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 48);
            sb2.append("Exception thrown when trying to get app version ");
            sb2.append(valueOf);
            eVar.c("CommonUtils", sb2.toString());
            return "";
        }
    }

    @NonNull
    public static String b(@RecentlyNonNull Locale locale) {
        if (b7.k.e()) {
            return locale.toLanguageTag();
        }
        StringBuilder sb2 = new StringBuilder(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb2.append("-");
            sb2.append(locale.getCountry());
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            sb2.append("-");
            sb2.append(locale.getVariant());
        }
        return sb2.toString();
    }
}
