package com.huawei.hwwidgetsupport.api;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface HwWidgetService {
    @NonNull
    <T> T createWidget(@NonNull Class<T> cls, @NonNull Context context);

    @NonNull
    <T> T createWidget(@NonNull Class<T> cls, @NonNull Context context, @Nullable AttributeSet attributeSet);

    @NonNull
    <T> T createWidget(@NonNull Class<T> cls, @NonNull Context context, @Nullable AttributeSet attributeSet, int i10);

    @NonNull
    <T> T createWidget(@NonNull Class<T> cls, @NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11);

    <T> void registerCreator(@NonNull Class<T> cls, @NonNull HwWidgetCreator<? extends T> hwWidgetCreator);
}
