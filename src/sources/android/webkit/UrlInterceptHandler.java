package android.webkit;

import android.webkit.CacheManager;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface UrlInterceptHandler {
    @Deprecated
    PluginData getPluginData(String str, Map<String, String> map);

    @Deprecated
    CacheManager.CacheResult service(String str, Map<String, String> map);
}
