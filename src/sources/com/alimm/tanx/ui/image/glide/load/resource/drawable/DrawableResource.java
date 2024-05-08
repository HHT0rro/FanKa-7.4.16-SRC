package com.alimm.tanx.ui.image.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T> {
    public final T drawable;

    public DrawableResource(T t2) {
        Objects.requireNonNull(t2, "Drawable must not be null!");
        this.drawable = t2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final T get() {
        return (T) this.drawable.getConstantState().newDrawable();
    }
}
