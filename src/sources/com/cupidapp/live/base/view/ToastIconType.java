package com.cupidapp.live.base.view;

import androidx.annotation.DrawableRes;
import com.cupidapp.live.R$mipmap;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKToastView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ToastIconType {
    SUCCESS(Integer.valueOf(R$mipmap.icon_toast_success)),
    WARNING(Integer.valueOf(R$mipmap.icon_toast_warning)),
    NONE(null);


    @Nullable
    private final Integer iconResId;

    ToastIconType(@DrawableRes Integer num) {
        this.iconResId = num;
    }

    @Nullable
    public final Integer getIconResId() {
        return this.iconResId;
    }
}
