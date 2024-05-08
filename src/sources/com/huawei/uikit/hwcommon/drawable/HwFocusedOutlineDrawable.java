package com.huawei.uikit.hwcommon.drawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwFocusedOutlineDrawable extends HwOutlineDrawable {

    /* renamed from: v, reason: collision with root package name */
    public static final String f34936v = "HwFocusedOutlineDrawable";

    /* renamed from: w, reason: collision with root package name */
    public View f34937w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f34938x;

    public HwFocusedOutlineDrawable(@NonNull Context context, @Nullable Drawable drawable, @NonNull View view, @NonNull View view2, boolean z10) {
        super(context, drawable, view2, z10);
        this.f34938x = true;
        this.f34937w = view;
    }

    @Override // com.huawei.uikit.hwcommon.drawable.HwOutlineDrawable
    public boolean isDrawOutline() {
        if (this.f34938x) {
            return this.f34937w.hasWindowFocus() && this.f34937w.isFocused();
        }
        return this.f34937w.isFocused();
    }

    public void setWindowFocusSensitive(boolean z10) {
        this.f34938x = z10;
    }
}
