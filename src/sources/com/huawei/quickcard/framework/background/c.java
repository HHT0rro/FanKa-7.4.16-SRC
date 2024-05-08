package com.huawei.quickcard.framework.background;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.f;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends BitmapDrawable implements IBorderRadiusDrawable {

    /* renamed from: a, reason: collision with root package name */
    private final Context f33788a;

    /* renamed from: b, reason: collision with root package name */
    private Border f33789b;

    /* renamed from: c, reason: collision with root package name */
    private f f33790c;

    /* renamed from: d, reason: collision with root package name */
    private final View f33791d;

    public c(@NonNull View view, Bitmap bitmap) {
        super(view.getResources(), bitmap);
        this.f33788a = view.getContext();
        this.f33791d = view;
    }

    private void a(Canvas canvas) {
        if (getGravity() != 119) {
            setGravity(119);
        }
        super.draw(canvas);
    }

    private void b(Canvas canvas) {
        Bitmap bitmap = getBitmap();
        b calculateSize = DrawableUtils.calculateSize(this.f33791d, bitmap, this.f33790c);
        if (calculateSize.f33787b < 0.0f && calculateSize.f33786a < 0.0f) {
            a(canvas);
            return;
        }
        Point calculatePosition = DrawableUtils.calculatePosition(this.f33791d, calculateSize, this.f33790c);
        a calculateRepeat = DrawableUtils.calculateRepeat(this.f33790c);
        if (!calculateRepeat.f33784a && !calculateRepeat.f33785b) {
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect2 = new Rect(0, 0, (int) calculateSize.f33786a, (int) calculateSize.f33787b);
            rect2.offsetTo(calculatePosition.x, calculatePosition.y);
            canvas.drawBitmap(bitmap, rect, rect2, getPaint());
            return;
        }
        a(calculateSize, calculatePosition, calculateRepeat, bitmap, canvas);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        Path a10 = m.a(this.f33788a, this.f33789b, getBounds());
        if (a10 != null) {
            canvas.clipPath(a10);
        }
        if (this.f33790c == null) {
            a(canvas);
        } else {
            b(canvas);
        }
        canvas.restore();
    }

    @Override // com.huawei.quickcard.framework.background.IBorderRadiusDrawable
    public void setBorder(Border border) {
        if (border != this.f33789b) {
            this.f33789b = border;
            invalidateSelf();
        }
    }

    private void a(b bVar, Point point, a aVar, Bitmap bitmap, Canvas canvas) {
        float f10;
        float f11;
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect2 = new Rect(0, 0, (int) bVar.f33786a, (int) bVar.f33787b);
        int i10 = point.x;
        int i11 = point.y;
        if (aVar.f33784a) {
            if (i10 <= 0) {
                f11 = i10 % bVar.f33786a;
            } else {
                float f12 = bVar.f33786a;
                f11 = (i10 % f12) - f12;
            }
            i10 = (int) f11;
        }
        if (aVar.f33785b) {
            if (i11 <= 0) {
                f10 = i11 % bVar.f33787b;
            } else {
                float f13 = bVar.f33787b;
                f10 = (i11 % f13) - f13;
            }
            i11 = (int) f10;
        }
        while (i10 < width) {
            int i12 = i11;
            while (i12 < height) {
                rect2.offsetTo(i10, i12);
                canvas.drawBitmap(bitmap, rect, rect2, getPaint());
                if (!aVar.f33785b) {
                    break;
                } else {
                    i12 = (int) (i12 + bVar.f33787b);
                }
            }
            if (!aVar.f33784a) {
                return;
            } else {
                i10 = (int) (i10 + bVar.f33786a);
            }
        }
    }

    public f a() {
        if (this.f33790c == null) {
            this.f33790c = new f();
        }
        return this.f33790c;
    }

    public void a(f fVar) {
        this.f33790c = fVar;
    }
}
