package com.huawei.flexiblelayout.parser.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class UriUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28432a = "UriUtils";

    @NonNull
    public static String getHost(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String host = Uri.parse(str).getHost();
                return host != null ? host : "";
            } catch (Throwable unused) {
                Log.e(f28432a, "getHost, Failed to parse the uri: '" + str + "'.");
            }
        }
        return "";
    }

    @NonNull
    public static String getScheme(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String scheme = Uri.parse(str).getScheme();
                return scheme != null ? scheme : "";
            } catch (Throwable unused) {
                Log.e(f28432a, "Failed to parse the uri: '" + str + "'.");
            }
        }
        return "";
    }
}
