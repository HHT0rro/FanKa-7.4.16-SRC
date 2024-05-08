package com.alimm.tanx.ui.image.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SquaringDrawable extends GlideDrawable {
    public boolean mutated;
    public State state;
    public GlideDrawable wrapped;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class State extends Drawable.ConstantState {
        public final int side;
        public final Drawable.ConstantState wrapped;

        public State(State state) {
            this(state.wrapped, state.side);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public State(Drawable.ConstantState constantState, int i10) {
            this.wrapped = constantState;
            this.side = i10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new SquaringDrawable(this, null, resources);
        }
    }

    public SquaringDrawable(GlideDrawable glideDrawable, int i10) {
        this(new State(glideDrawable.getConstantState(), i10), glideDrawable, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.wrapped.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.wrapped.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.side;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.side;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.wrapped.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return this.wrapped.isAnimated();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.wrapped.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.wrapped = (GlideDrawable) this.wrapped.mutate();
            this.state = new State(this.state);
            this.mutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        super.scheduleSelf(runnable, j10);
        this.wrapped.scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.wrapped.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.wrapped.setBounds(i10, i11, i12, i13);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i10) {
        this.wrapped.setChangingConfigurations(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i10, PorterDuff.Mode mode) {
        this.wrapped.setColorFilter(i10, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.wrapped.setDither(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.wrapped.setFilterBitmap(z10);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i10) {
        this.wrapped.setLoopCount(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return this.wrapped.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.wrapped.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.wrapped.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.wrapped.unscheduleSelf(runnable);
    }

    public SquaringDrawable(State state, GlideDrawable glideDrawable, Resources resources) {
        this.state = state;
        if (glideDrawable != null) {
            this.wrapped = glideDrawable;
        } else if (resources != null) {
            this.wrapped = (GlideDrawable) state.wrapped.newDrawable(resources);
        } else {
            this.wrapped = (GlideDrawable) state.wrapped.newDrawable();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.wrapped.setBounds(rect);
    }
}
