package com.huawei.quickcard.views.image.view;

import android.content.Context;
import android.graphics.Canvas;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.views.image.extension.IImageViewFactory;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlexImageView extends BaseImageView {
    public static final IImageViewFactory<FlexImageView> FACTORY = new IImageViewFactory() { // from class: com.huawei.quickcard.views.image.view.b
        @Override // com.huawei.quickcard.views.image.extension.IImageViewFactory
        public final FlexImageView create(Context context) {
            return new FlexImageView(context);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private final IBorderDrawer f34546d;
    public boolean multiLayerEnable;

    public FlexImageView(Context context) {
        super(context);
        this.f34546d = new BorderDrawer(this);
        setMultiLayerEnable(true);
    }

    private boolean c() {
        return (this.cacheBean.a() == null || this.cacheBean.a().getBorderRadius() == null) ? false : true;
    }

    private boolean d() {
        return (this.cacheBean.a() == null || this.cacheBean.a().getBorderWidth() == null) ? false : true;
    }

    @Override // com.huawei.quickcard.views.image.view.BaseImageView
    public void a(@NonNull Border border) {
        if (this.viewBounds.width() == 0 || this.viewBounds.height() == 0) {
            return;
        }
        this.f34546d.prepare(border, this.viewBounds);
    }

    public void drawBorderStroke(@NonNull Canvas canvas) {
        if (d()) {
            this.f34546d.drawBorderStroke(canvas, this.viewBounds);
        }
    }

    public void drawRadiusMask(@NonNull Canvas canvas) {
        if (c()) {
            this.f34546d.drawMaskLayer(canvas, this.viewBounds);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.multiLayerEnable) {
            canvas.saveLayer(null, null, 31);
            super.onDraw(canvas);
            drawRadiusMask(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
            drawRadiusMask(canvas);
        }
        drawBorderStroke(canvas);
    }

    public void setMultiLayerEnable(boolean z10) {
        this.multiLayerEnable = z10;
    }
}
