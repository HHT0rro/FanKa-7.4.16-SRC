package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12);

    void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, int i14);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10, int i11);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10, int i11);

    void onStopNestedScroll(@NonNull View view, int i10);
}
