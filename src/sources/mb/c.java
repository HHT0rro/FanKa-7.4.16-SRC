package mb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

/* compiled from: NonViewAware.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final String f51973a;

    /* renamed from: b, reason: collision with root package name */
    public final jb.c f51974b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewScaleType f51975c;

    public c(String str, jb.c cVar, ViewScaleType viewScaleType) {
        if (cVar == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (viewScaleType != null) {
            this.f51973a = str;
            this.f51974b = cVar;
            this.f51975c = viewScaleType;
            return;
        }
        throw new IllegalArgumentException("scaleType must not be null");
    }

    @Override // mb.a
    public int getHeight() {
        return this.f51974b.a();
    }

    @Override // mb.a
    public int getId() {
        return TextUtils.isEmpty(this.f51973a) ? super.hashCode() : this.f51973a.hashCode();
    }

    @Override // mb.a
    public ViewScaleType getScaleType() {
        return this.f51975c;
    }

    @Override // mb.a
    public int getWidth() {
        return this.f51974b.b();
    }

    @Override // mb.a
    public View getWrappedView() {
        return null;
    }

    @Override // mb.a
    public boolean isCollected() {
        return false;
    }

    @Override // mb.a
    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }

    @Override // mb.a
    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }
}
