package com.huawei.quickcard.views.image.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.border.Border;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IBorderDrawer {
    void drawBorderStroke(@NonNull Canvas canvas, @NonNull Rect rect);

    void drawMaskLayer(@NonNull Canvas canvas, @NonNull Rect rect);

    void prepare(@NonNull Border border, @NonNull Rect rect);
}
