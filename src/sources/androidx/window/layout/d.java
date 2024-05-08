package androidx.window.layout;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.layout.WindowMetricsCalculator;
import org.jetbrains.annotations.NotNull;

/* compiled from: WindowMetricsCalculator.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final /* synthetic */ class d {
    static {
        WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.Companion;
    }

    @NotNull
    public static WindowMetricsCalculator a() {
        return WindowMetricsCalculator.Companion.getOrCreate();
    }

    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void b(@NotNull WindowMetricsCalculatorDecorator windowMetricsCalculatorDecorator) {
        WindowMetricsCalculator.Companion.overrideDecorator(windowMetricsCalculatorDecorator);
    }

    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void c() {
        WindowMetricsCalculator.Companion.reset();
    }
}
