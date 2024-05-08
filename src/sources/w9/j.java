package w9;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static GrsClient f54313a;

    public static synchronized Map<String, String> a(Context context, String str) {
        synchronized (j.class) {
            if (f54313a == null) {
                m.d("GrsConfigObtainer", "grs not init ,do init ");
                if (!b(context)) {
                    m.d("GrsConfigObtainer", "grs init failed");
                    return null;
                }
            }
            return f54313a.synGetGrsUrls(str);
        }
    }

    public static boolean b(Context context) {
        i b4 = i.b();
        String a10 = b4.a(context);
        String d10 = b4.d(context);
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        if (!TextUtils.isEmpty(a10)) {
            grsBaseInfo.setAppName(a10);
        }
        if (!TextUtils.isEmpty(d10)) {
            grsBaseInfo.setSerCountry(d10);
        }
        try {
            f54313a = new GrsClient(context, grsBaseInfo);
            return true;
        } catch (NullPointerException unused) {
            m.c("GrsConfigObtainer", "init grs failed,context is null");
            return false;
        }
    }

    public static String c(Context context, String str) {
        return k.a(context, str);
    }
}
