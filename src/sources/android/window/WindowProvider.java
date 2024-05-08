package android.window;

import android.os.Bundle;
import android.os.IBinder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface WindowProvider {
    public static final String KEY_IS_WINDOW_PROVIDER_SERVICE = "android.windowContext.isWindowProviderService";

    Bundle getWindowContextOptions();

    IBinder getWindowContextToken();

    int getWindowType();
}
