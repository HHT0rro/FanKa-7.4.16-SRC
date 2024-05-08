package android.webkit;

import android.annotation.SystemApi;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@SystemApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WebViewUpdateService {
    private WebViewUpdateService() {
    }

    public static WebViewProviderInfo[] getAllWebViewPackages() {
        IWebViewUpdateService service = getUpdateService();
        if (service == null) {
            return new WebViewProviderInfo[0];
        }
        try {
            return service.getAllWebViewPackages();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public static WebViewProviderInfo[] getValidWebViewPackages() {
        IWebViewUpdateService service = getUpdateService();
        if (service == null) {
            return new WebViewProviderInfo[0];
        }
        try {
            return service.getValidWebViewPackages();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public static String getCurrentWebViewPackageName() {
        IWebViewUpdateService service = getUpdateService();
        if (service == null) {
            return null;
        }
        try {
            return service.getCurrentWebViewPackageName();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    private static IWebViewUpdateService getUpdateService() {
        return WebViewFactory.getUpdateService();
    }
}
