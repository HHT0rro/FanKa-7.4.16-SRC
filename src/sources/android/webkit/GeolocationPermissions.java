package android.webkit;

import android.annotation.SystemApi;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GeolocationPermissions {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Callback {
        void invoke(String str, boolean z10, boolean z11);
    }

    public static GeolocationPermissions getInstance() {
        return WebViewFactory.getProvider().getGeolocationPermissions();
    }

    public void getOrigins(ValueCallback<Set<String>> callback) {
    }

    public void getAllowed(String origin, ValueCallback<Boolean> callback) {
    }

    public void clear(String origin) {
    }

    public void allow(String origin) {
    }

    public void clearAll() {
    }

    @SystemApi
    public GeolocationPermissions() {
    }
}
