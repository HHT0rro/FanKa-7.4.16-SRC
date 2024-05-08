package androidx.core.splashscreen;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ThemeUtils.kt */
@RequiresApi(31)
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ThemeUtils {

    @NotNull
    public static final ThemeUtils INSTANCE = new ThemeUtils();

    /* compiled from: ThemeUtils.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Api31 {

        @NotNull
        public static final Api31 INSTANCE = new Api31();

        private Api31() {
        }

        @DoNotInline
        public static final void applyThemesSystemBarAppearance(@NotNull Resources.Theme theme, @NotNull View decor) {
            s.i(theme, "theme");
            s.i(decor, "decor");
            applyThemesSystemBarAppearance$default(theme, decor, null, 4, null);
        }

        @DoNotInline
        public static final void applyThemesSystemBarAppearance(@NotNull Resources.Theme theme, @NotNull View decor, @NotNull TypedValue tv) {
            s.i(theme, "theme");
            s.i(decor, "decor");
            s.i(tv, "tv");
            int i10 = (!theme.resolveAttribute(16844000, tv, true) || tv.data == 0) ? 0 : 8;
            if (theme.resolveAttribute(16844140, tv, true) && tv.data != 0) {
                i10 |= 16;
            }
            WindowInsetsController windowInsetsController = decor.getWindowInsetsController();
            s.f(windowInsetsController);
            windowInsetsController.setSystemBarsAppearance(i10, 24);
        }

        public static /* synthetic */ void applyThemesSystemBarAppearance$default(Resources.Theme theme, View view, TypedValue typedValue, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                typedValue = new TypedValue();
            }
            applyThemesSystemBarAppearance(theme, view, typedValue);
        }
    }

    private ThemeUtils() {
    }
}
