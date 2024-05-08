package y9;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, InstallCallback> f54689a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, MarketInfo> f54690b = new ConcurrentHashMap();

    public static InstallCallback a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f54689a.get(str);
    }

    public static String b(InstallCallback installCallback) {
        if (installCallback == null) {
            return "";
        }
        String uuid = UUID.randomUUID().toString();
        f54689a.put(uuid, installCallback);
        return uuid;
    }

    public static void c(String str, MarketInfo marketInfo) {
        if (str == null) {
            return;
        }
        f54690b.put(str, marketInfo);
    }

    @Nullable
    public static MarketInfo d(String str) {
        if (str == null) {
            return null;
        }
        return f54690b.get(str);
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f54689a.remove(str);
    }

    public static void f(String str) {
        if (str == null) {
            return;
        }
        f54690b.remove(str);
    }
}
