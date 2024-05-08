package com.huawei.qcardsupport;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.huawei.flexiblelayout.services.imageloader.ImageOptions;
import com.huawei.flexiblelayout.services.imageloader.Length;
import com.huawei.quickcard.framework.unit.LengthUnit;
import com.huawei.quickcard.framework.unit.LengthValue;
import com.huawei.quickcard.views.image.extension.ClipRect;

/* compiled from: QuickImageOptionsWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e extends ImageOptions {

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.quickcard.views.image.extension.ImageOptions f33127a;

    public e(ImageOptions imageOptions) {
        setUrl(imageOptions.getUrl());
        setSkipCache(imageOptions.isSkipCache());
        setPlaceholder(imageOptions.getPlaceholder());
        int[] size = imageOptions.getSize();
        if (size != null) {
            setSize(size[0], size[1]);
        }
        Length[] clipRect = imageOptions.getClipRect();
        if (clipRect != null) {
            setClipRect(clipRect[0], clipRect[1], clipRect[2], clipRect[3]);
        }
    }

    @NonNull
    public com.huawei.quickcard.views.image.extension.ImageOptions a() {
        if (this.f33127a == null) {
            com.huawei.quickcard.views.image.extension.ImageOptions imageOptions = new com.huawei.quickcard.views.image.extension.ImageOptions();
            this.f33127a = imageOptions;
            imageOptions.setUrl(getUrl());
            this.f33127a.setEnableCache(!isSkipCache());
            this.f33127a.setPlaceHolder(Pair.create("", getPlaceholder()));
            int[] size = getSize();
            if (size != null) {
                this.f33127a.setWidth(size[0]);
                this.f33127a.setHeight(size[1]);
            }
            ClipRect a10 = a(getClipRect());
            if (a10 != null) {
                this.f33127a.setClipRect(a10);
            }
        }
        return this.f33127a;
    }

    public e(com.huawei.quickcard.views.image.extension.ImageOptions imageOptions) {
        Drawable drawable;
        this.f33127a = imageOptions;
        setUrl(imageOptions.getUrl());
        setSkipCache(!imageOptions.isEnableCache());
        Pair<String, Drawable> placeHolder = imageOptions.getPlaceHolder();
        if (placeHolder != null && (drawable = placeHolder.second) != null) {
            setPlaceholder(drawable);
        }
        setSize(imageOptions.getWidth(), imageOptions.getHeight());
        Length[] a10 = a(imageOptions.getClipRect());
        if (a10 != null) {
            setClipRect(a10[0], a10[1], a10[2], a10[3]);
        }
    }

    public static Length[] a(ClipRect clipRect) {
        if (clipRect != null) {
            return new Length[]{a(clipRect.getLeft()), a(clipRect.getTop()), a(clipRect.getRight()), a(clipRect.getBottom())};
        }
        return null;
    }

    public static ClipRect a(Length[] lengthArr) {
        if (lengthArr != null) {
            return new ClipRect(a(lengthArr[0]), a(lengthArr[1]), a(lengthArr[2]), a(lengthArr[3]));
        }
        return null;
    }

    public static Length a(LengthValue lengthValue) {
        if (lengthValue != null) {
            return Length.make(lengthValue.value, a(lengthValue.unit));
        }
        return Length.make(0.0f, Length.Unit.DEFAULT);
    }

    public static LengthValue a(Length length) {
        if (length != null) {
            return new LengthValue(length.value, a(length.unit));
        }
        return new LengthValue(0.0f, LengthUnit.DP);
    }

    public static Length.Unit a(LengthUnit lengthUnit) {
        if (lengthUnit == LengthUnit.PERCENT) {
            return Length.Unit.PERCENT;
        }
        return Length.Unit.DEFAULT;
    }

    public static LengthUnit a(Length.Unit unit) {
        if (unit == Length.Unit.PERCENT) {
            return LengthUnit.PERCENT;
        }
        return LengthUnit.DP;
    }
}
