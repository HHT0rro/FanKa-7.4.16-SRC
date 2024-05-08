package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.openalliance.ad.constant.u;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (!scheme.equalsIgnoreCase("tel") && !scheme.equalsIgnoreCase("sip") && !scheme.equalsIgnoreCase("sms") && !scheme.equalsIgnoreCase("smsto") && !scheme.equalsIgnoreCase("mailto") && !scheme.equalsIgnoreCase("nfc")) {
                if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("//");
                    sb2.append(uri.getHost() != null ? uri.getHost() : "");
                    sb2.append(uri.getPort() != -1 ? u.bD + uri.getPort() : "");
                    sb2.append("/...");
                    schemeSpecificPart = sb2.toString();
                }
            } else {
                StringBuilder sb3 = new StringBuilder(64);
                sb3.append(scheme);
                sb3.append(ShortcutConstants.SERVICES_SEPARATOR);
                if (schemeSpecificPart != null) {
                    for (int i10 = 0; i10 < schemeSpecificPart.length(); i10++) {
                        char charAt = schemeSpecificPart.charAt(i10);
                        if (charAt != '-' && charAt != '@' && charAt != '.') {
                            sb3.append(Locale.PRIVATE_USE_EXTENSION);
                        } else {
                            sb3.append(charAt);
                        }
                    }
                }
                return sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder(64);
        if (scheme != null) {
            sb4.append(scheme);
            sb4.append(ShortcutConstants.SERVICES_SEPARATOR);
        }
        if (schemeSpecificPart != null) {
            sb4.append(schemeSpecificPart);
        }
        return sb4.toString();
    }
}
