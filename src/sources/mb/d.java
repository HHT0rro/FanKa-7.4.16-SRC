package mb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.imageloader.core.imageaware.ViewAware;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: ViewAware.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public Reference<View> f51976a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f51977b;

    public d(View view) {
        this(view, true);
    }

    public abstract void a(Bitmap bitmap, View view);

    public abstract void b(Drawable drawable, View view);

    @Override // mb.a
    public int getHeight() {
        View view = this.f51976a.get();
        int i10 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f51977b && layoutParams != null && layoutParams.height != -2) {
            i10 = view.getHeight();
        }
        return (i10 > 0 || layoutParams == null) ? i10 : layoutParams.height;
    }

    @Override // mb.a
    public int getId() {
        View view = this.f51976a.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    @Override // mb.a
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    @Override // mb.a
    public int getWidth() {
        View view = this.f51976a.get();
        int i10 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f51977b && layoutParams != null && layoutParams.width != -2) {
            i10 = view.getWidth();
        }
        return (i10 > 0 || layoutParams == null) ? i10 : layoutParams.width;
    }

    @Override // mb.a
    public View getWrappedView() {
        return this.f51976a.get();
    }

    @Override // mb.a
    public boolean isCollected() {
        return this.f51976a.get() == null;
    }

    @Override // mb.a
    public boolean setImageBitmap(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f51976a.get();
            if (view != null) {
                a(bitmap, view);
                return true;
            }
        } else {
            pb.d.f(ViewAware.WARN_CANT_SET_BITMAP, new Object[0]);
        }
        return false;
    }

    @Override // mb.a
    public boolean setImageDrawable(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f51976a.get();
            if (view != null) {
                b(drawable, view);
                return true;
            }
        } else {
            pb.d.f(ViewAware.WARN_CANT_SET_DRAWABLE, new Object[0]);
        }
        return false;
    }

    public d(View view, boolean z10) {
        if (view != null) {
            this.f51976a = new WeakReference(view);
            this.f51977b = z10;
            return;
        }
        throw new IllegalArgumentException("view must not be null");
    }
}
