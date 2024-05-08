package mb;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;

/* compiled from: ImageViewAware.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends d {
    public b(ImageView imageView) {
        super(imageView);
    }

    public static int c(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e2) {
            pb.d.c(e2);
            return 0;
        }
    }

    @Override // mb.d
    public void a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // mb.d
    public void b(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // mb.d, mb.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }

    @Override // mb.d, mb.a
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        return (height > 0 || (imageView = (ImageView) this.f51976a.get()) == null) ? height : c(imageView, "mMaxHeight");
    }

    @Override // mb.d, mb.a
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.f51976a.get();
        if (imageView != null) {
            return ViewScaleType.fromImageView(imageView);
        }
        return super.getScaleType();
    }

    @Override // mb.d, mb.a
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        return (width > 0 || (imageView = (ImageView) this.f51976a.get()) == null) ? width : c(imageView, "mMaxWidth");
    }
}
