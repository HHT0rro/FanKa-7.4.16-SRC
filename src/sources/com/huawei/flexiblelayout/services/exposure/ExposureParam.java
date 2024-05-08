package com.huawei.flexiblelayout.services.exposure;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExposureParam {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private LifecycleOwner f28513a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private VisibleAreaCalculator f28514b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    @ExposureMode
    private String f28515c = "default";

    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public @interface ExposureMode {
        public static final String CUSTOM = "custom";
        public static final String DEFAULT = "default";
        public static final String NONE = "none";
        public static final List<String> values = Collections.unmodifiableList(Arrays.asList("none", "default", "custom"));
    }

    @NonNull
    @ExposureMode
    public String getExposureMode() {
        return this.f28515c;
    }

    @Nullable
    public LifecycleOwner getLifecycleOwner() {
        return this.f28513a;
    }

    @NonNull
    public VisibleAreaCalculator getVisibleAreaCalculator() {
        if (this.f28514b == null) {
            this.f28514b = new VisibleAreaCalculator();
        }
        return this.f28514b;
    }

    public void setExposureMode(@NonNull @ExposureMode String str) {
        this.f28515c = str;
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        this.f28513a = lifecycleOwner;
    }

    public void setVisibleAreaCalculator(@Nullable VisibleAreaCalculator visibleAreaCalculator) {
        this.f28514b = visibleAreaCalculator;
    }
}
