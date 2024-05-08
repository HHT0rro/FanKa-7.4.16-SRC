package com.huawei.flexiblelayout.css.adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.DrawableCompat;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.css.adapter.param.AsyncParameterGenerator;
import com.huawei.flexiblelayout.css.adapter.param.GeneratorCallBack;
import com.huawei.flexiblelayout.css.adapter.param.MethodSignature;
import com.huawei.flexiblelayout.css.adapter.param.Parameter;
import com.huawei.flexiblelayout.css.adapter.type.CSSColor;
import com.huawei.flexiblelayout.css.adapter.type.CSSColorList;
import com.huawei.flexiblelayout.css.adapter.type.CSSImage;
import com.huawei.flexiblelayout.css.adapter.type.CSSMonoColor;
import com.huawei.flexiblelayout.css.adapter.type.CSSPrimitive;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.AlignWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.IAlignWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.CSSDimensValue;
import com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.DimensWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.IDimensWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.fullSpan.FullSpanWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.space.CSSSpaceValue;
import com.huawei.flexiblelayout.css.adapter.value.integrate.space.ISpaceWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.space.MarginWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.space.PaddingWrapper;
import com.huawei.flexiblelayout.css.adapter.value.integrate.tint.DrawableTintWrap;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.imageloader.ImageLoader;
import com.huawei.flexiblelayout.services.imageloader.ImageLoaderService;
import com.huawei.flexiblelayout.services.imageloader.ImageOptions;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ViewAdapter extends RenderAdapter {
    public static final CSSPropertyMethod CSS_PROPERTY_METHOD;
    public static final RenderAdapterFactory FACTORY = new RenderAdapterFactory() { // from class: com.huawei.flexiblelayout.css.adapter.ViewAdapter.1
        @Override // com.huawei.flexiblelayout.css.adapter.RenderAdapterFactory
        public RenderAdapter create(View view) {
            return new ViewAdapter();
        }
    };
    private static final String TAG = "ViewAdapter";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class AlignGenerator implements Parameter.Generator<CSSAlignValue> {
        private AlignGenerator() {
        }

        @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
        public Object get(Object obj, CSSAlignValue cSSAlignValue) {
            return new Object[]{obj, cSSAlignValue.getCssAlign()};
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class BackgroundColorMethod implements Parameter.Generator<CSSColor> {
        private BackgroundColorMethod() {
        }

        @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
        public Object get(Object obj, CSSColor cSSColor) {
            if (cSSColor instanceof CSSColorList) {
                return ((CSSColorList) cSSColor).toStateListDrawable();
            }
            if (cSSColor instanceof CSSMonoColor) {
                return new ColorDrawable(((CSSMonoColor) cSSColor).getColor());
            }
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class BackgroundImageMethod extends AsyncParameterGenerator<CSSImage> {
        private BackgroundImageMethod() {
        }

        @Override // com.huawei.flexiblelayout.css.adapter.param.AsyncParameterGenerator
        public void get(Object obj, CSSImage cSSImage, GeneratorCallBack generatorCallBack) {
            if (!(obj instanceof View)) {
                Log.w(ViewAdapter.TAG, "get failed receiver : " + obj);
                return;
            }
            View view = (View) obj;
            ImageLoader imageLoader = ((ImageLoaderService) FLEngine.getInstance(view.getContext()).getService(ImageLoaderService.class)).getImageLoader();
            if (imageLoader == null) {
                Log.e(ViewAdapter.TAG, "Not registered ImageLoader.");
                return;
            }
            ImageOptions imageOptions = new ImageOptions();
            imageOptions.setUrl(cSSImage.getUrl());
            imageLoader.load(view, imageOptions);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class BackgroundTintMethod implements Parameter.Generator<CSSColor> {
        public Drawable getDrawable(Object obj) {
            return ((View) obj).getBackground();
        }

        @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
        public Object get(Object obj, CSSColor cSSColor) {
            Drawable drawable = getDrawable(obj);
            if (drawable == null) {
                return new Object[2];
            }
            Object[] objArr = new Object[2];
            objArr[0] = DrawableCompat.wrap(drawable.mutate());
            if (cSSColor instanceof CSSColorList) {
                objArr[1] = ((CSSColorList) cSSColor).toColorStateList();
            } else if (cSSColor instanceof CSSMonoColor) {
                objArr[1] = Integer.valueOf(((CSSMonoColor) cSSColor).getColor());
            }
            return objArr;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class DimensGenerator implements Parameter.Generator<CSSDimensValue> {
        private DimensGenerator() {
        }

        @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
        public Object get(Object obj, CSSDimensValue cSSDimensValue) {
            return new Object[]{obj, cSSDimensValue.getCssDimens()};
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class FullSpanGenerator implements Parameter.Generator<CSSPrimitive> {
        private FullSpanGenerator() {
        }

        @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
        public Object get(Object obj, CSSPrimitive cSSPrimitive) {
            return new Object[]{obj, cSSPrimitive.asBool()};
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SpaceGenerator implements Parameter.Generator<CSSSpaceValue> {
        private SpaceGenerator() {
        }

        @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
        public Object get(Object obj, CSSSpaceValue cSSSpaceValue) {
            return new Object[]{obj, cSSSpaceValue};
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class VisibilityMethod implements Parameter.Generator<CSSPrimitive> {
        private VisibilityMethod() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        
            if (r4.equals(com.huawei.quickcard.base.Attributes.Visibility.HIDDEN) == false) goto L4;
         */
        @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object get(java.lang.Object r4, com.huawei.flexiblelayout.css.adapter.type.CSSPrimitive r5) {
            /*
                r3 = this;
                java.lang.String r4 = r5.asString()
                r4.hashCode()
                int r5 = r4.hashCode()
                r0 = 0
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                r2 = -1
                switch(r5) {
                    case -1217487446: goto L2c;
                    case 3178655: goto L21;
                    case 466743410: goto L16;
                    default: goto L14;
                }
            L14:
                r0 = -1
                goto L35
            L16:
                java.lang.String r5 = "visible"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L1f
                goto L14
            L1f:
                r0 = 2
                goto L35
            L21:
                java.lang.String r5 = "gone"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L2a
                goto L14
            L2a:
                r0 = 1
                goto L35
            L2c:
                java.lang.String r5 = "hidden"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L35
                goto L14
            L35:
                switch(r0) {
                    case 0: goto L40;
                    case 1: goto L39;
                    case 2: goto L38;
                    default: goto L38;
                }
            L38:
                return r1
            L39:
                r4 = 8
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                return r4
            L40:
                r4 = 4
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.flexiblelayout.css.adapter.ViewAdapter.VisibilityMethod.get(java.lang.Object, com.huawei.flexiblelayout.css.adapter.type.CSSPrimitive):java.lang.Object");
        }
    }

    static {
        CSSPropertyMethod cSSPropertyMethod = new CSSPropertyMethod();
        CSS_PROPERTY_METHOD = cSSPropertyMethod;
        Method method = RenderAdapter.getMethod(View.class, "setBackground", Drawable.class);
        cSSPropertyMethod.add("backgroundColor", new MethodSignature(method, new BackgroundColorMethod()));
        cSSPropertyMethod.add("backgroundImage", new MethodSignature(method, new BackgroundImageMethod()));
        cSSPropertyMethod.add(CSSPropertyName.BACKGROUND_TINT, new MethodSignature(RenderAdapter.getMethod(DrawableTintWrap.class, "setTint", Drawable.class, Object.class), DrawableTintWrap.class, new BackgroundTintMethod()));
        cSSPropertyMethod.add("visibility", new MethodSignature(RenderAdapter.getMethod(View.class, "setVisibility", Integer.TYPE), new VisibilityMethod()));
        Class<Boolean> cls = Boolean.TYPE;
        cSSPropertyMethod.add(CSSPropertyName.CLIP_CHILDREN, new MethodSignature(RenderAdapter.getMethod(ViewGroup.class, "setClipChildren", cls), new Parameter.Generator() { // from class: com.huawei.flexiblelayout.css.adapter.b
            @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
            public final Object get(Object obj, CSSValue cSSValue) {
                Object a10;
                a10 = ViewAdapter.a(obj, (CSSPrimitive) cSSValue);
                return a10;
            }
        }));
        cSSPropertyMethod.add(CSSPropertyName.CLIP_PADDING, new MethodSignature(RenderAdapter.getMethod(ViewGroup.class, "setClipToPadding", cls), new Parameter.Generator() { // from class: com.huawei.flexiblelayout.css.adapter.c
            @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
            public final Object get(Object obj, CSSValue cSSValue) {
                Object b4;
                b4 = ViewAdapter.b(obj, (CSSPrimitive) cSSValue);
                return b4;
            }
        }));
        cSSPropertyMethod.add(CSSPropertyName.FULL_SPAN, new MethodSignature(RenderAdapter.getMethod(FullSpanWrapper.class, "setFullSpan", ViewGroup.class, cls), FullSpanWrapper.class, new FullSpanGenerator()));
        addSpaceMethod(cSSPropertyMethod, PaddingWrapper.class, "setSpace", CSSPropertyName.FL_PADDING);
        addSpaceMethod(cSSPropertyMethod, MarginWrapper.class, "setSpace", CSSPropertyName.FL_MARGIN);
        addDimensMethod(cSSPropertyMethod, DimensWrapper.class, "setDimens", CSSPropertyName.FL_DIMENS);
        addAlignMethod(cSSPropertyMethod, AlignWrapper.class, "setAlign", CSSPropertyName.ALIGN_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a(Object obj, CSSPrimitive cSSPrimitive) {
        return cSSPrimitive.asBool();
    }

    private static void addAlignMethod(CSSPropertyMethod cSSPropertyMethod, Class<? extends IAlignWrapper> cls, String str, String str2) {
        cSSPropertyMethod.add(str2, new MethodSignature(RenderAdapter.getMethod(cls, str, View.class, CSSAlignValue.CSSAlign.class), cls, new AlignGenerator()));
    }

    private static void addDimensMethod(CSSPropertyMethod cSSPropertyMethod, Class<? extends IDimensWrapper> cls, String str, String str2) {
        cSSPropertyMethod.add(str2, new MethodSignature(RenderAdapter.getMethod(cls, str, View.class, CSSDimensValue.CSSDimens.class), cls, new DimensGenerator()));
    }

    private static void addSpaceMethod(CSSPropertyMethod cSSPropertyMethod, Class<? extends ISpaceWrapper> cls, String str, String str2) {
        cSSPropertyMethod.add(str2, new MethodSignature(RenderAdapter.getMethod(cls, str, View.class, CSSSpaceValue.class), cls, new SpaceGenerator()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object b(Object obj, CSSPrimitive cSSPrimitive) {
        return cSSPrimitive.asBool();
    }

    @Override // com.huawei.flexiblelayout.css.adapter.RenderAdapter
    public MethodSignature getMethod(String str) {
        return CSS_PROPERTY_METHOD.getSignature(str);
    }
}
