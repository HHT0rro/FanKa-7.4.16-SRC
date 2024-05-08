package com.alimm.tanx.core.image.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: TanxDrawable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if extends Drawable {
    public final Bitmap tanxc_do;
    public final tanxc_do tanxc_if;
    public final Paint tanxc_new = new Paint(1);
    public final Rect tanxc_for = new Rect();
    public final Rect tanxc_int = new Rect();

    public tanxc_if(Bitmap bitmap, tanxc_do tanxc_doVar) {
        this.tanxc_do = tanxc_do(bitmap, tanxc_doVar);
        this.tanxc_if = tanxc_doVar;
    }

    private Bitmap tanxc_do(Bitmap bitmap, tanxc_do tanxc_doVar) {
        if (tanxc_doVar == null || tanxc_doVar.tanxc_if() != ShapeMode.RECT_ROUND || tanxc_doVar.tanxc_for() <= 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, height), tanxc_doVar.tanxc_for(), tanxc_doVar.tanxc_for(), paint);
        return createBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f10;
        float f11;
        Rect bounds = getBounds();
        Bitmap bitmap = this.tanxc_do;
        if (bitmap == null || bitmap.getHeight() == 0 || this.tanxc_do.getWidth() == 0 || bounds == null || bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        tanxc_do tanxc_doVar = this.tanxc_if;
        ScaleMode tanxc_do = tanxc_doVar == null ? ScaleMode.CENTER_CROP : tanxc_doVar.tanxc_do();
        if (tanxc_do == ScaleMode.FIT_XY) {
            Rect rect = this.tanxc_for;
            rect.left = 0;
            rect.top = 0;
            rect.right = this.tanxc_do.getWidth();
            this.tanxc_for.bottom = this.tanxc_do.getHeight();
            Rect rect2 = this.tanxc_int;
            rect2.left = 0;
            rect2.top = 0;
            rect2.right = getBounds().width();
            this.tanxc_int.bottom = getBounds().height();
        } else {
            float f12 = 0.0f;
            if (tanxc_do == ScaleMode.CENTER_CROP) {
                if (this.tanxc_do.getWidth() * bounds.height() < bounds.width() * this.tanxc_do.getHeight()) {
                    f11 = (this.tanxc_do.getHeight() - (bounds.height() * (this.tanxc_do.getWidth() / bounds.width()))) * 0.5f;
                } else {
                    f12 = (this.tanxc_do.getWidth() - (bounds.width() * (this.tanxc_do.getHeight() / bounds.height()))) * 0.5f;
                    f11 = 0.0f;
                }
                Rect rect3 = this.tanxc_for;
                rect3.left = (int) f12;
                rect3.right = (int) (this.tanxc_do.getWidth() - f12);
                Rect rect4 = this.tanxc_for;
                rect4.top = (int) f11;
                rect4.bottom = (int) (this.tanxc_do.getHeight() - f11);
                Rect rect5 = this.tanxc_int;
                rect5.left = 0;
                rect5.top = 0;
                rect5.right = getBounds().right;
                this.tanxc_int.bottom = getBounds().bottom;
            } else {
                if (this.tanxc_do.getWidth() * bounds.height() < bounds.width() * this.tanxc_do.getHeight()) {
                    f10 = (bounds.width() - (this.tanxc_do.getWidth() * (bounds.height() / this.tanxc_do.getHeight()))) * 0.5f;
                } else {
                    f12 = (bounds.height() - (this.tanxc_do.getHeight() * (bounds.width() / this.tanxc_do.getWidth()))) * 0.5f;
                    f10 = 0.0f;
                }
                Rect rect6 = this.tanxc_for;
                rect6.left = 0;
                rect6.top = 0;
                rect6.right = this.tanxc_do.getWidth();
                this.tanxc_for.bottom = this.tanxc_do.getHeight();
                Rect rect7 = this.tanxc_int;
                rect7.left = (int) f10;
                rect7.top = (int) f12;
                int width = bounds.width();
                Rect rect8 = this.tanxc_int;
                rect7.right = width - rect8.left;
                rect8.bottom = bounds.height() - this.tanxc_int.top;
            }
        }
        canvas.drawBitmap(this.tanxc_do, this.tanxc_for, this.tanxc_int, this.tanxc_new);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
