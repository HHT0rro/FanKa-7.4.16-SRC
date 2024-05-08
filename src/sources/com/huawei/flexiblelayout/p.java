package com.huawei.flexiblelayout;

import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import com.huawei.flexiblelayout.m;

/* compiled from: DefEffectDrawable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class p extends GradientDrawable implements o {

    /* renamed from: a, reason: collision with root package name */
    private a f28278a;

    /* compiled from: DefEffectDrawable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {
        void a(Canvas canvas);
    }

    public void a(a aVar) {
        this.f28278a = aVar;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        a aVar = this.f28278a;
        if (aVar != null) {
            aVar.a(canvas);
        }
    }

    @Override // com.huawei.flexiblelayout.o
    public void a(m.a aVar) {
        if (aVar != null) {
            setShape(aVar.c());
            if (aVar.b() != null) {
                setCornerRadii(new float[]{r0.d(), r0.d(), r0.e(), r0.e(), r0.b(), r0.b(), r0.a(), r0.a()});
            }
            setStroke(aVar.f(), aVar.a());
            setColor(aVar.d());
        }
    }
}
