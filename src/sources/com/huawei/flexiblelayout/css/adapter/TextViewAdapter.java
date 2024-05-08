package com.huawei.flexiblelayout.css.adapter;

import android.view.View;
import android.widget.TextView;
import com.huawei.flexiblelayout.css.adapter.param.MethodSignature;
import com.huawei.flexiblelayout.css.adapter.param.Parameter;
import com.huawei.flexiblelayout.css.adapter.type.CSSColor;
import com.huawei.flexiblelayout.css.adapter.type.CSSPrimitive;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.adapter.wrapper.CSSFontWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TextViewAdapter extends RenderAdapter {
    public static final CSSPropertyMethod CSS_PROPERTY_METHOD;
    public static final RenderAdapterFactory FACTORY = new RenderAdapterFactory() { // from class: com.huawei.flexiblelayout.css.adapter.TextViewAdapter.1
        @Override // com.huawei.flexiblelayout.css.adapter.RenderAdapterFactory
        public RenderAdapter create(View view) {
            return new TextViewAdapter();
        }
    };

    static {
        CSSPropertyMethod cSSPropertyMethod = new CSSPropertyMethod();
        CSS_PROPERTY_METHOD = cSSPropertyMethod;
        cSSPropertyMethod.inherit(ViewAdapter.CSS_PROPERTY_METHOD);
        cSSPropertyMethod.add(CSSPropertyName.FONT_COLOR, new MethodSignature(RenderAdapter.getMethod(CSSFontWrapper.class, "setTextColor", TextView.class, CSSColor.class), CSSFontWrapper.class, new Parameter.Generator() { // from class: com.huawei.flexiblelayout.css.adapter.a
            @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
            public final Object get(Object obj, CSSValue cSSValue) {
                Object a10;
                a10 = TextViewAdapter.a(obj, (CSSColor) cSSValue);
                return a10;
            }
        }));
        cSSPropertyMethod.add("fontSize", new MethodSignature(RenderAdapter.getMethod(TextView.class, "setTextSize", Float.TYPE), new Parameter.Generator<CSSPrimitive>() { // from class: com.huawei.flexiblelayout.css.adapter.TextViewAdapter.2
            @Override // com.huawei.flexiblelayout.css.adapter.param.Parameter.Generator
            public Object get(Object obj, CSSPrimitive cSSPrimitive) {
                return cSSPrimitive.asFloat();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a(Object obj, CSSColor cSSColor) {
        return new Object[]{obj, cSSColor};
    }

    @Override // com.huawei.flexiblelayout.css.adapter.RenderAdapter
    public MethodSignature getMethod(String str) {
        return CSS_PROPERTY_METHOD.getSignature(str);
    }
}
