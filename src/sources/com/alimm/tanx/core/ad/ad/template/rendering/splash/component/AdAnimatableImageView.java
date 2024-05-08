package com.alimm.tanx.core.ad.ad.template.rendering.splash.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Region;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AdAnimatableImageView extends AppCompatImageView {
    public int tanxc_byte;
    public final Context tanxc_case;
    public final Set<OnAnimationEndListener> tanxc_do;
    public Paint tanxc_for;
    public boolean tanxc_if;
    public int tanxc_int;
    public int tanxc_new;
    public int tanxc_try;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface OnAnimationEndListener {
        void onAnimationEnd();
    }

    public AdAnimatableImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.tanxc_if) {
            canvas.save();
            canvas.translate(0.0f, this.tanxc_byte);
            canvas.clipRect(0.0f, this.tanxc_new, getRight(), this.tanxc_try, Region.Op.INTERSECT);
            super.onDraw(canvas);
            canvas.restore();
            canvas.drawRect(0.0f, 0.0f, getRight(), this.tanxc_new + this.tanxc_byte, this.tanxc_for);
            canvas.drawRect(0.0f, this.tanxc_try + this.tanxc_byte, getRight(), this.tanxc_int, this.tanxc_for);
            return;
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public AdAnimatableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdAnimatableImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.tanxc_do = new CopyOnWriteArraySet();
        this.tanxc_if = false;
        this.tanxc_case = context;
    }
}
