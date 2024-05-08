package wa;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    public static String a(Uri uri, String str) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getQueryParameter: ");
                sb2.append(e2.getMessage());
            }
        }
        return "";
    }
}
