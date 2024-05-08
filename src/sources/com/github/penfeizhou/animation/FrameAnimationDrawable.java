package com.github.penfeizhou.animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import i4.c;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class FrameAnimationDrawable<Decoder extends FrameSeqDecoder<?, ?>> extends Drawable implements Animatable2Compat, FrameSeqDecoder.j {

    /* renamed from: m, reason: collision with root package name */
    public static final String f19204m = FrameAnimationDrawable.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final Paint f19205b;

    /* renamed from: c, reason: collision with root package name */
    public final Decoder f19206c;

    /* renamed from: d, reason: collision with root package name */
    public final DrawFilter f19207d;

    /* renamed from: e, reason: collision with root package name */
    public final Matrix f19208e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<Animatable2Compat.AnimationCallback> f19209f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f19210g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f19211h;

    /* renamed from: i, reason: collision with root package name */
    public final Runnable f19212i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f19213j;

    /* renamed from: k, reason: collision with root package name */
    public final Set<WeakReference<Drawable.Callback>> f19214k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f19215l;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                Iterator iterator2 = new ArrayList(FrameAnimationDrawable.this.f19209f).iterator2();
                while (iterator2.hasNext()) {
                    ((Animatable2Compat.AnimationCallback) iterator2.next()).onAnimationStart(FrameAnimationDrawable.this);
                }
            } else {
                if (i10 != 2) {
                    return;
                }
                Iterator iterator22 = new ArrayList(FrameAnimationDrawable.this.f19209f).iterator2();
                while (iterator22.hasNext()) {
                    ((Animatable2Compat.AnimationCallback) iterator22.next()).onAnimationEnd(FrameAnimationDrawable.this);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameAnimationDrawable.this.invalidateSelf();
        }
    }

    public FrameAnimationDrawable(c cVar) {
        Paint paint = new Paint();
        this.f19205b = paint;
        this.f19207d = new PaintFlagsDrawFilter(0, 3);
        this.f19208e = new Matrix();
        this.f19209f = new HashSet();
        this.f19211h = new a(Looper.getMainLooper());
        this.f19212i = new b();
        this.f19213j = true;
        this.f19214k = new HashSet();
        this.f19215l = false;
        paint.setAntiAlias(true);
        this.f19206c = c(cVar, this);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder.j
    public void a(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.f19210g;
            if (bitmap == null || bitmap.isRecycled()) {
                this.f19210g = Bitmap.createBitmap(this.f19206c.r().width() / this.f19206c.y(), this.f19206c.r().height() / this.f19206c.y(), Bitmap.Config.ARGB_8888);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.f19210g.getByteCount()) {
                return;
            }
            this.f19210g.copyPixelsFromBuffer(byteBuffer);
            this.f19211h.post(this.f19212i);
        }
    }

    public abstract Decoder c(c cVar, FrameSeqDecoder.j jVar);

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.f19209f.clear();
    }

    public final void d() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z10 = false;
        for (WeakReference weakReference : new HashSet(this.f19214k)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z10 = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            this.f19214k.remove((WeakReference) iterator2.next());
        }
        if (z10) {
            return;
        }
        this.f19214k.add(new WeakReference<>(callback));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f19210g;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.f19207d);
        canvas.drawBitmap(this.f19210g, this.f19208e, this.f19205b);
    }

    public final void e() {
        this.f19206c.o(this);
        if (this.f19213j) {
            this.f19206c.P();
        } else {
            if (this.f19206c.D()) {
                return;
            }
            this.f19206c.P();
        }
    }

    public final void f() {
        this.f19206c.J(this);
        if (this.f19213j) {
            this.f19206c.R();
        } else {
            this.f19206c.S();
        }
    }

    public void g() {
        this.f19206c.F();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f19215l) {
            return -1;
        }
        try {
            return this.f19206c.r().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f19215l) {
            return -1;
        }
        try {
            return this.f19206c.r().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h() {
        this.f19206c.M();
    }

    public void i(int i10) {
        this.f19206c.O(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator<E> iterator2 = new HashSet(this.f19214k).iterator2();
        while (iterator2.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) iterator2.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f19206c.D();
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder.j
    public void onEnd() {
        Message.obtain(this.f19211h, 2).sendToTarget();
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder.j
    public void onStart() {
        Message.obtain(this.f19211h, 1).sendToTarget();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f19209f.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f19205b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        boolean N = this.f19206c.N(getBounds().width(), getBounds().height());
        this.f19208e.setScale(((getBounds().width() * 1.0f) * this.f19206c.y()) / this.f19206c.r().width(), ((getBounds().height() * 1.0f) * this.f19206c.y()) / this.f19206c.r().height());
        if (N) {
            this.f19210g = Bitmap.createBitmap(this.f19206c.r().width() / this.f19206c.y(), this.f19206c.r().height() / this.f19206c.y(), Bitmap.Config.ARGB_8888);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f19205b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        d();
        if (this.f19213j) {
            if (z10) {
                if (!isRunning()) {
                    e();
                }
            } else if (isRunning()) {
                f();
            }
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f19206c.D()) {
            this.f19206c.R();
        }
        this.f19206c.L();
        e();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        f();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return this.f19209f.remove(animationCallback);
    }
}
