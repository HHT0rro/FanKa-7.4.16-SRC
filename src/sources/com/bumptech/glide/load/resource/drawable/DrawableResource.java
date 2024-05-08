package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    public final T drawable;

    public DrawableResource(T t2) {
        this.drawable = (T) Preconditions.checkNotNull(t2);
    }

    public void initialize() {
        T t2 = this.drawable;
        if (t2 instanceof BitmapDrawable) {
            ((BitmapDrawable) t2).getBitmap().prepareToDraw();
        } else if (t2 instanceof GifDrawable) {
            ((GifDrawable) t2).getFirstFrame().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public final T get() {
        Drawable.ConstantState constantState = this.drawable.getConstantState();
        if (constantState == null) {
            return this.drawable;
        }
        return (T) constantState.newDrawable();
    }
}
