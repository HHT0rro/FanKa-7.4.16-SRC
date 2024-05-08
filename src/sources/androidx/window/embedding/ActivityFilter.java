package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityFilter.kt */
@ExperimentalWindowApi
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ActivityFilter {

    @NotNull
    private final ComponentName componentName;

    @Nullable
    private final String intentAction;

    public ActivityFilter(@NotNull ComponentName componentName, @Nullable String str) {
        s.i(componentName, "componentName");
        this.componentName = componentName;
        this.intentAction = str;
        String packageName = componentName.getPackageName();
        s.h(packageName, "componentName.packageName");
        String className = componentName.getClassName();
        s.h(className, "componentName.className");
        boolean z10 = true;
        if (packageName.length() > 0) {
            if (className.length() > 0) {
                if (!StringsKt__StringsKt.K(packageName, StringUtils.NO_PRINT_CODE, false, 2, null) || StringsKt__StringsKt.X(packageName, StringUtils.NO_PRINT_CODE, 0, false, 6, null) == packageName.length() - 1) {
                    if (StringsKt__StringsKt.K(className, StringUtils.NO_PRINT_CODE, false, 2, null) && StringsKt__StringsKt.X(className, StringUtils.NO_PRINT_CODE, 0, false, 6, null) != className.length() - 1) {
                        z10 = false;
                    }
                    if (!z10) {
                        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
                    }
                    return;
                }
                throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
            }
            throw new IllegalArgumentException("Activity class name must not be empty.".toString());
        }
        throw new IllegalArgumentException("Package name must not be empty".toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        return s.d(this.componentName, activityFilter.componentName) && s.d(this.intentAction, activityFilter.intentAction);
    }

    @NotNull
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    @Nullable
    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int hashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivity(@NotNull Activity activity) {
        s.i(activity, "activity");
        if (MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            String str = this.intentAction;
            if (str != null) {
                Intent intent = activity.getIntent();
                if (s.d(str, intent == null ? null : intent.getAction())) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(@NotNull Intent intent) {
        s.i(intent, "intent");
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        return str == null || s.d(str, intent.getAction());
    }

    @NotNull
    public String toString() {
        return "ActivityFilter(componentName=" + ((Object) this.componentName) + ", intentAction=" + ((Object) this.intentAction) + ')';
    }
}
