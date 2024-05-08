package com.huawei.quickcard.framework.processor.background;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.d;
import com.huawei.quickcard.framework.background.DrawableUtils;
import com.huawei.quickcard.framework.background.IBorderRadiusDrawable;
import com.huawei.quickcard.framework.background.c;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.u0;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ValueUtils;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BackgroundStyle<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33945a = "BackgroundStyle";

    private Drawable a(T t2, QuickCardValue quickCardValue) {
        if (quickCardValue == null || !quickCardValue.isString() || QuickCardValue.EMPTY.equals(quickCardValue)) {
            return null;
        }
        return u0.a(t2.getContext(), quickCardValue.getString());
    }

    private d b(T t2, QuickCardValue quickCardValue) {
        return DrawableUtils.parseToColorDrawable(t2, (quickCardValue == null || QuickCardValue.EMPTY.equals(quickCardValue) || !quickCardValue.isNumber()) ? 0 : quickCardValue.getNumber().intValue());
    }

    private c c(T t2, QuickCardValue quickCardValue) {
        if (!QuickCardValueUtil.isInvalidValue(quickCardValue) && quickCardValue.isObject() && (quickCardValue.getObject() instanceof Bitmap)) {
            return DrawableUtils.parseToImageDrawable(t2, (Bitmap) quickCardValue.getObject());
        }
        return null;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean isImmediate() {
        return b.a(this);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1332194002:
                if (str.equals(Attributes.Style.BACKGROUND)) {
                    c4 = 0;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return ParserHelper.parseToString(obj, "");
            case 1:
                return ParserHelper.parseToColor(obj, 0);
            case 2:
                String string = ParserHelper.parseToString(obj, "").getString();
                if (!TextUtils.isEmpty(string) && string.trim().startsWith("data:image/")) {
                    return new QuickCardValue.ObjectValue(DrawableUtils.translateToBitmap(string));
                }
                return QuickCardValue.EMPTY;
            default:
                return QuickCardValue.EMPTY;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackground(T t2, Drawable drawable, String str) {
        Drawable background = t2.getBackground();
        if (background == null) {
            background = DrawableUtils.createLayerDrawable(t2.getContext());
            t2.setBackground(background);
        }
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        Border border = obtainPropertyCacheBeanFromView.getBorder();
        if (drawable instanceof IBorderRadiusDrawable) {
            ((IBorderRadiusDrawable) drawable).setBorder(border);
        }
        if (background instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) background;
            str.hashCode();
            char c4 = 65535;
            switch (str.hashCode()) {
                case -1332194002:
                    if (str.equals(Attributes.Style.BACKGROUND)) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals("backgroundColor")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c4 = 2;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    layerDrawable.setDrawableByLayerId(R.id.quick_card_background_linear, drawable);
                    break;
                case 1:
                    layerDrawable.setDrawableByLayerId(R.id.quick_card_background_color, drawable);
                    break;
                case 2:
                    if (drawable instanceof c) {
                        ((c) drawable).a(obtainPropertyCacheBeanFromView.getBackgroundImageStyle());
                    }
                    layerDrawable.setDrawableByLayerId(R.id.quick_card_background_image, drawable);
                    break;
                default:
                    CardLogUtils.e(f33945a, "[setBackground] error attr undefine");
                    break;
            }
            layerDrawable.invalidateSelf();
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        Drawable a10;
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        if (obtainPropertyCacheBeanFromView.isAnimationView()) {
            obtainPropertyCacheBeanFromView.getQAnimatorSet(t2).b().put(str, quickCardValue);
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1332194002:
                if (str.equals(Attributes.Style.BACKGROUND)) {
                    c4 = 0;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                a10 = a(t2, quickCardValue);
                break;
            case 1:
                a10 = b(t2, quickCardValue);
                break;
            case 2:
                a10 = c(t2, quickCardValue);
                break;
            default:
                a10 = null;
                break;
        }
        if (a10 == null) {
            a10 = new d(t2.getContext(), 0);
        }
        setBackground(t2, a10, str);
    }
}
