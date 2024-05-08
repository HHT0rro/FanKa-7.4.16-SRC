package com.huawei.hwwidgetsupport.api;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface HwWidgetCreator<T> {
    @NonNull
    T createWidget(@NonNull Context context);

    @NonNull
    T createWidget(@NonNull Context context, @Nullable AttributeSet attributeSet);

    @NonNull
    T createWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10);

    @NonNull
    T createWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11);
}
