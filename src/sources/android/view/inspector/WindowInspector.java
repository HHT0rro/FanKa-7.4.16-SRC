package android.view.inspector;

import android.view.View;
import android.view.WindowManagerGlobal;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WindowInspector {
    private WindowInspector() {
    }

    public static List<View> getGlobalWindowViews() {
        return WindowManagerGlobal.getInstance().getWindowViews();
    }
}
