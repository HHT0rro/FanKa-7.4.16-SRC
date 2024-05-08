package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ViewPropertyAnimatorListener {
    void onAnimationCancel(@NonNull View view);

    void onAnimationEnd(@NonNull View view);

    void onAnimationStart(@NonNull View view);
}
