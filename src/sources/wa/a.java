package wa;

import android.content.Intent;
import com.huawei.secure.android.common.intent.SafeIntent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {
    public static boolean a(Intent intent) {
        boolean z10 = true;
        if (intent == null) {
            ra.a.c("IntentUtils", "intent is null");
        } else if (intent instanceof SafeIntent) {
            ra.a.g("IntentUtils", "safe intent");
            z10 = ((SafeIntent) intent).a();
        } else {
            try {
                intent.getStringExtra("ANYTHING");
                z10 = false;
            } catch (Throwable unused) {
            }
        }
        if (z10) {
            ra.a.c("IntentUtils", "hasIntentBomb");
        }
        return z10;
    }
}
