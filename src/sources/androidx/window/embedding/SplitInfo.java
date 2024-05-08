package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SplitInfo.kt */
@ExperimentalWindowApi
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SplitInfo {

    @NotNull
    private final ActivityStack primaryActivityStack;

    @NotNull
    private final ActivityStack secondaryActivityStack;
    private final float splitRatio;

    public SplitInfo(@NotNull ActivityStack primaryActivityStack, @NotNull ActivityStack secondaryActivityStack, float f10) {
        s.i(primaryActivityStack, "primaryActivityStack");
        s.i(secondaryActivityStack, "secondaryActivityStack");
        this.primaryActivityStack = primaryActivityStack;
        this.secondaryActivityStack = secondaryActivityStack;
        this.splitRatio = f10;
    }

    public final boolean contains(@NotNull Activity activity) {
        s.i(activity, "activity");
        return this.primaryActivityStack.contains(activity) || this.secondaryActivityStack.contains(activity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        if (s.d(this.primaryActivityStack, splitInfo.primaryActivityStack) && s.d(this.secondaryActivityStack, splitInfo.secondaryActivityStack)) {
            return (this.splitRatio > splitInfo.splitRatio ? 1 : (this.splitRatio == splitInfo.splitRatio ? 0 : -1)) == 0;
        }
        return false;
    }

    @NotNull
    public final ActivityStack getPrimaryActivityStack() {
        return this.primaryActivityStack;
    }

    @NotNull
    public final ActivityStack getSecondaryActivityStack() {
        return this.secondaryActivityStack;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public int hashCode() {
        return (((this.primaryActivityStack.hashCode() * 31) + this.secondaryActivityStack.hashCode()) * 31) + Float.floatToIntBits(this.splitRatio);
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SplitInfo:{");
        sb2.append("primaryActivityStack=" + ((Object) getPrimaryActivityStack()) + ',');
        sb2.append("secondaryActivityStack=" + ((Object) getSecondaryActivityStack()) + ',');
        sb2.append("splitRatio=" + getSplitRatio() + '}');
        String sb3 = sb2.toString();
        s.h(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
