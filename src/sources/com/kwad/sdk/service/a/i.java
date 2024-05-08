package com.kwad.sdk.service.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface i {
    void load(@NonNull Context context, ImageView imageView, Object obj, @DrawableRes int i10, @DrawableRes int i11);

    void load(ImageView imageView, Object obj);

    void load(ImageView imageView, Object obj, AdTemplate adTemplate);

    void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2);

    void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, float f10);
}
