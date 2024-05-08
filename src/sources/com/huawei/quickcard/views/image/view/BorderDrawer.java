package com.huawei.quickcard.views.image.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.k;
import com.huawei.quickcard.u1;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BorderDrawer<T extends View> implements IBorderDrawer {

    /* renamed from: a, reason: collision with root package name */
    private final u1 f34544a;

    /* renamed from: b, reason: collision with root package name */
    private final k f34545b;

    public BorderDrawer(@NonNull T t2) {
        this.f34544a = new u1(true, (View) t2);
        this.f34545b = new k(t2.getContext());
    }

    @Override // com.huawei.quickcard.views.image.view.IBorderDrawer
    public void drawBorderStroke(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f34545b.draw(canvas);
    }

    @Override // com.huawei.quickcard.views.image.view.IBorderDrawer
    public void drawMaskLayer(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f34544a.draw(canvas);
    }

    @Override // com.huawei.quickcard.views.image.view.IBorderDrawer
    public void prepare(@NonNull Border border, @NonNull Rect rect) {
        this.f34544a.updateBorder(border);
        this.f34545b.a(border);
        this.f34544a.setBounds(rect);
        this.f34545b.setBounds(rect);
        this.f34544a.a();
    }
}
