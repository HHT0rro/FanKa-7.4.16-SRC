package com.huawei.quickcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import com.huawei.quickcard.framework.background.IBorderRadiusDrawable;
import com.huawei.quickcard.framework.border.Border;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d extends ColorDrawable implements IBorderRadiusDrawable {

    /* renamed from: a, reason: collision with root package name */
    private final Context f33570a;

    /* renamed from: b, reason: collision with root package name */
    private Border f33571b;

    public d(Context context, int i10) {
        super(i10);
        this.f33570a = context;
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        Path a10 = m.a(this.f33570a, this.f33571b, getBounds());
        if (a10 != null) {
            canvas.clipPath(a10);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // com.huawei.quickcard.framework.background.IBorderRadiusDrawable
    public void setBorder(Border border) {
        if (border != this.f33571b) {
            this.f33571b = border;
            invalidateSelf();
        }
    }
}
