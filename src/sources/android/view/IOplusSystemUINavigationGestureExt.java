package android.view;

import android.content.Context;
import android.graphics.Region;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IOplusSystemUINavigationGestureExt {
    default void registerSmartSideBarRegion(Context context) {
    }

    default void unregisterSmartSideBarRegion() {
    }

    default Region getSmartSideBarRegion() {
        return new Region();
    }
}
