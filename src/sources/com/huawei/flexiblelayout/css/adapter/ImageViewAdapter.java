package com.huawei.flexiblelayout.css.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.huawei.flexiblelayout.css.adapter.ViewAdapter;
import com.huawei.flexiblelayout.css.adapter.param.MethodSignature;
import com.huawei.flexiblelayout.css.adapter.value.integrate.tint.DrawableTintWrap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ImageViewAdapter extends RenderAdapter {
    public static final CSSPropertyMethod CSS_PROPERTY_METHOD;
    public static final RenderAdapterFactory FACTORY = new RenderAdapterFactory() { // from class: com.huawei.flexiblelayout.css.adapter.ImageViewAdapter.1
        @Override // com.huawei.flexiblelayout.css.adapter.RenderAdapterFactory
        public RenderAdapter create(View view) {
            return new ImageViewAdapter();
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class BackgroundTintMethodForImageView extends ViewAdapter.BackgroundTintMethod {
        private BackgroundTintMethodForImageView() {
        }

        @Override // com.huawei.flexiblelayout.css.adapter.ViewAdapter.BackgroundTintMethod
        public Drawable getDrawable(Object obj) {
            Drawable drawable = super.getDrawable(obj);
            return drawable == null ? ((ImageView) obj).getDrawable() : drawable;
        }
    }

    static {
        CSSPropertyMethod cSSPropertyMethod = new CSSPropertyMethod();
        CSS_PROPERTY_METHOD = cSSPropertyMethod;
        cSSPropertyMethod.inherit(ViewAdapter.CSS_PROPERTY_METHOD);
        cSSPropertyMethod.add(CSSPropertyName.BACKGROUND_TINT, new MethodSignature(RenderAdapter.getMethod(DrawableTintWrap.class, "setTint", Drawable.class, Object.class), DrawableTintWrap.class, new BackgroundTintMethodForImageView()));
    }

    @Override // com.huawei.flexiblelayout.css.adapter.RenderAdapter
    public MethodSignature getMethod(String str) {
        return CSS_PROPERTY_METHOD.getSignature(str);
    }
}
