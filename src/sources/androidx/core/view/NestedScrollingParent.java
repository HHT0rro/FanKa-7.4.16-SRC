package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f10, float f11, boolean z10);

    boolean onNestedPreFling(@NonNull View view, float f10, float f11);

    void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10);

    void onStopNestedScroll(@NonNull View view);
}
