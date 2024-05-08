package b7;

import androidx.annotation.RecentlyNonNull;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class j {
    public static void a(@RecentlyNonNull StringBuilder sb2, @RecentlyNonNull HashMap<String, String> hashMap) {
        sb2.append("{");
        boolean z10 = true;
        for (String str : hashMap.h()) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(",");
            }
            String str2 = hashMap.get(str);
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\":");
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append("\"");
                sb2.append(str2);
                sb2.append("\"");
            }
        }
        sb2.append(com.alipay.sdk.util.i.f4738d);
    }
}
