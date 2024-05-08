package android.view.translation;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ViewTranslationCallback {
    boolean onClearTranslation(View view);

    boolean onHideTranslation(View view);

    boolean onShowTranslation(View view);

    default void enableContentPadding() {
    }

    default void setAnimationDurationMillis(int durationMillis) {
    }
}
