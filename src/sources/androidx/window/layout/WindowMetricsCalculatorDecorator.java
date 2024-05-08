package androidx.window.layout;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: WindowMetricsCalculator.kt */
@ExperimentalWindowApi
@kotlin.d
@RestrictTo({RestrictTo.Scope.TESTS})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface WindowMetricsCalculatorDecorator {
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    @NotNull
    WindowMetricsCalculator decorate(@NotNull WindowMetricsCalculator windowMetricsCalculator);
}
