package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10);

    void onSelected(View view);
}
