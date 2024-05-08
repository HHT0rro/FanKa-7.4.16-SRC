package com.cupidapp.live.base.imageloader;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: ImageLoaderView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ImageLoaderView extends AppCompatImageView {

    /* renamed from: b */
    @Nullable
    public ImageModel f11834b;

    /* renamed from: c */
    @Nullable
    public b f11835c;

    /* renamed from: d */
    @Nullable
    public c f11836d;

    /* renamed from: e */
    public int f11837e;

    /* renamed from: f */
    @ColorInt
    public int f11838f;

    /* renamed from: g */
    @DrawableRes
    public int f11839g;

    /* renamed from: h */
    public int f11840h;

    /* renamed from: i */
    @Nullable
    public RoundCornerModel f11841i;

    /* renamed from: j */
    public boolean f11842j;

    /* renamed from: k */
    @NotNull
    public Map<Integer, View> f11843k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f11843k = new LinkedHashMap();
        this.f11838f = -2302756;
        this.f11840h = -1;
        c(this, context, null, 2, null);
    }

    public static /* synthetic */ void c(ImageLoaderView imageLoaderView, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initView");
        }
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        imageLoaderView.b(context, attributeSet);
    }

    public static /* synthetic */ void f(ImageLoaderView imageLoaderView, b bVar, c cVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadImage");
        }
        if ((i10 & 2) != 0) {
            cVar = null;
        }
        imageLoaderView.d(bVar, cVar);
    }

    public static /* synthetic */ void g(ImageLoaderView imageLoaderView, ImageModel imageModel, b bVar, c cVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadImage");
        }
        if ((i10 & 2) != 0) {
            bVar = null;
        }
        if ((i10 & 4) != 0) {
            cVar = null;
        }
        imageLoaderView.e(imageModel, bVar, cVar);
    }

    private final void setMImageViewWidth(int i10) {
        ImageModel imageModel;
        if (this.f11837e == 0 && (imageModel = this.f11834b) != null) {
            this.f11837e = i10;
            e(imageModel, this.f11835c, this.f11836d);
        } else {
            this.f11837e = i10;
        }
    }

    public final RoundCornerModel a(TypedArray typedArray) {
        boolean z10 = typedArray.getBoolean(4, false);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(11, 0);
        boolean z11 = typedArray.getBoolean(12, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(6, 0);
        int c4 = (dimensionPixelSize2 > 0 || !z11) ? dimensionPixelSize2 : h.c(this, 1.0f);
        if (z10 || dimensionPixelSize > 0 || c4 > 0) {
            return new RoundCornerModel(z10, dimensionPixelSize, c4, typedArray.getColor(5, com.cupidapp.live.base.utils.h.a(-16777216, 0.1f)), typedArray.getBoolean(9, true), typedArray.getBoolean(10, true), typedArray.getBoolean(8, true), typedArray.getBoolean(7, true));
        }
        return null;
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ImageLoaderView);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.ImageLoaderView)");
        this.f11838f = obtainStyledAttributes.getColor(2, -2302756);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.f11839g = resourceId;
        }
        int i10 = obtainStyledAttributes.getInt(0, -1);
        if (i10 >= 0) {
            this.f11840h = i10;
        }
        this.f11841i = a(obtainStyledAttributes);
        this.f11842j = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    public final void d(@NotNull b options, @Nullable c cVar) {
        s.i(options, "options");
        if (options.h() == -2302756) {
            options.u(this.f11838f);
        }
        int i10 = this.f11839g;
        if (i10 != 0) {
            options.v(i10);
        }
        int i11 = this.f11840h;
        if (i11 >= 0) {
            if (i11 == 0) {
                options.x(TransformationType.FitCenter);
            } else if (i11 == 1) {
                options.x(TransformationType.CenterCrop);
            }
        }
        RoundCornerModel roundCornerModel = this.f11841i;
        if (roundCornerModel != null) {
            options.w(roundCornerModel);
        }
        if (this.f11842j) {
            options.t(new BlurModel(0.0f, 0, 3, null));
        }
        ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
        Context context = getContext();
        s.h(context, "context");
        imageLoaderUtil.f(context, this, options, cVar);
    }

    public final void e(@Nullable ImageModel imageModel, @Nullable b bVar, @Nullable c cVar) {
        this.f11834b = imageModel;
        this.f11835c = bVar;
        this.f11836d = cVar;
        int i10 = this.f11837e;
        if (i10 > 0) {
            String url = imageModel != null ? imageModel.getUrl(i10) : null;
            if (this.f11835c == null) {
                this.f11835c = new b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524287, null);
            }
            b bVar2 = this.f11835c;
            if (bVar2 != null) {
                bVar2.y(url);
            }
            b bVar3 = this.f11835c;
            if (bVar3 != null) {
                d(bVar3, cVar);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        if (size > 0) {
            setMImageViewWidth(size);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f11843k = new LinkedHashMap();
        this.f11838f = -2302756;
        this.f11840h = -1;
        b(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoaderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f11843k = new LinkedHashMap();
        this.f11838f = -2302756;
        this.f11840h = -1;
        b(context, attributeSet);
    }
}
