package com.huawei.quickcard.views.image.processor;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.views.image.ImageUtils;
import com.huawei.quickcard.views.image.view.IImageHost;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AltAttribute extends BaseProcessor {
    public static final int DEFAULT_ALT = -1118482;

    private Drawable a(@NonNull IImageHost iImageHost, String str, @NonNull ImageView imageView) {
        Drawable drawable;
        Pair<String, Drawable> placeHolder = iImageHost.getPlaceHolder(str);
        return (placeHolder == null || !TextUtils.equals(placeHolder.first, str) || (drawable = placeHolder.second) == null) ? a(str, imageView) : drawable;
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        return ParserHelper.parseToString(obj, null);
    }

    @Override // com.huawei.quickcard.views.image.processor.BaseProcessor
    public void setProperty(@NonNull ImageView imageView, @NonNull IImageHost iImageHost, String str, QuickCardValue quickCardValue) {
        iImageHost.setPlaceHolder(quickCardValue.getString(), a(iImageHost, quickCardValue.getString(), imageView));
    }

    private Drawable a(String str, @NonNull ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return new ColorDrawable(DEFAULT_ALT);
        }
        if (isBase64Img(str)) {
            Bitmap base64ToBitmap = ResourceUtils.base64ToBitmap(str);
            if (base64ToBitmap != null) {
                return new BitmapDrawable(imageView.getResources(), base64ToBitmap);
            }
            return null;
        }
        if ("blank".equals(str) || ImageUtils.isAppImage(str)) {
            return null;
        }
        return new ColorDrawable(ResourceUtils.getColor(str, DEFAULT_ALT));
    }
}
