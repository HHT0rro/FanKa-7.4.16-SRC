package android.view;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ViewGroupOverlay extends ViewOverlay {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupOverlay(Context context, View hostView) {
        super(context, hostView);
    }

    public void add(View view) {
        this.mOverlayViewGroup.add(view);
    }

    public void remove(View view) {
        this.mOverlayViewGroup.remove(view);
    }
}
