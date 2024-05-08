package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.google.android.gms.base.R$string;
import com.huawei.quickcard.base.Attributes;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleArrayMap<String, String> f23684a = new SimpleArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Locale f23685b;

    public static String a(Context context) {
        return context.getResources().getString(R$string.common_google_play_services_notification_channel_name);
    }

    @Nullable
    public static String b(Context context, int i10) {
        Resources resources = context.getResources();
        switch (i10) {
            case 1:
                return resources.getString(R$string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R$string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R$string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                return c(context, "common_google_play_services_invalid_account_title");
            case 7:
                return c(context, "common_google_play_services_network_error_title");
            case 8:
            case 9:
            case 10:
            case 11:
            case 16:
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Unexpected error code ");
                sb2.append(i10);
                return null;
            case 17:
                return c(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                return c(context, "common_google_play_services_restricted_profile_title");
        }
    }

    @Nullable
    public static String c(Context context, String str) {
        SimpleArrayMap<String, String> simpleArrayMap = f23684a;
        synchronized (simpleArrayMap) {
            Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(f23685b)) {
                simpleArrayMap.clear();
                f23685b = locale;
            }
            String str2 = simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources d10 = com.google.android.gms.common.c.d(context);
            if (d10 == null) {
                return null;
            }
            int identifier = d10.getIdentifier(str, Attributes.TextOverflow.STRING, "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Missing resource: ".concat(valueOf);
                }
                return null;
            }
            String string = d10.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                if (valueOf2.length() != 0) {
                    "Got empty resource: ".concat(valueOf2);
                }
                return null;
            }
            simpleArrayMap.put(str, string);
            return string;
        }
    }

    public static String d(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String c4 = c(context, str);
        if (c4 == null) {
            c4 = resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, c4, str2);
    }

    public static String e(Context context) {
        String packageName = context.getPackageName();
        try {
            return d7.b.a(context).c(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    @NonNull
    public static String f(Context context, int i10) {
        String b4;
        if (i10 == 6) {
            b4 = c(context, "common_google_play_services_resolution_required_title");
        } else {
            b4 = b(context, i10);
        }
        return b4 == null ? context.getResources().getString(R$string.common_google_play_services_notification_ticker) : b4;
    }

    @NonNull
    public static String g(Context context, int i10) {
        Resources resources = context.getResources();
        String e2 = e(context);
        if (i10 == 1) {
            return resources.getString(R$string.common_google_play_services_install_text, e2);
        }
        if (i10 == 2) {
            return b7.g.e(context) ? resources.getString(R$string.common_google_play_services_wear_update_text) : resources.getString(R$string.common_google_play_services_update_text, e2);
        }
        if (i10 == 3) {
            return resources.getString(R$string.common_google_play_services_enable_text, e2);
        }
        if (i10 == 5) {
            return d(context, "common_google_play_services_invalid_account_text", e2);
        }
        if (i10 == 7) {
            return d(context, "common_google_play_services_network_error_text", e2);
        }
        if (i10 == 9) {
            return resources.getString(R$string.common_google_play_services_unsupported_text, e2);
        }
        if (i10 != 20) {
            switch (i10) {
                case 16:
                    return d(context, "common_google_play_services_api_unavailable_text", e2);
                case 17:
                    return d(context, "common_google_play_services_sign_in_failed_text", e2);
                case 18:
                    return resources.getString(R$string.common_google_play_services_updating_text, e2);
                default:
                    return resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue, e2);
            }
        }
        return d(context, "common_google_play_services_restricted_profile_text", e2);
    }

    @NonNull
    public static String h(Context context, int i10) {
        if (i10 != 6 && i10 != 19) {
            return g(context, i10);
        }
        return d(context, "common_google_play_services_resolution_required_text", e(context));
    }

    @NonNull
    public static String i(Context context, int i10) {
        Resources resources = context.getResources();
        if (i10 == 1) {
            return resources.getString(R$string.common_google_play_services_install_button);
        }
        if (i10 == 2) {
            return resources.getString(R$string.common_google_play_services_update_button);
        }
        if (i10 != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(R$string.common_google_play_services_enable_button);
    }
}
