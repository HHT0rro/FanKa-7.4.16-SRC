package androidx.core.util;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Pair.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PairKt {
    public static final <F, S> F component1(@NotNull Pair<F, S> pair) {
        s.i(pair, "<this>");
        return pair.first;
    }

    public static final <F, S> S component2(@NotNull Pair<F, S> pair) {
        s.i(pair, "<this>");
        return pair.second;
    }

    @NotNull
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        s.i(pair, "<this>");
        return new android.util.Pair<>(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final <F, S> Pair<F, S> toAndroidXPair(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        s.i(pair, "<this>");
        return new Pair<>(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull Pair<F, S> pair) {
        s.i(pair, "<this>");
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    public static final <F, S> F component1(@NotNull android.util.Pair<F, S> pair) {
        s.i(pair, "<this>");
        return (F) pair.first;
    }

    public static final <F, S> S component2(@NotNull android.util.Pair<F, S> pair) {
        s.i(pair, "<this>");
        return (S) pair.second;
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull android.util.Pair<F, S> pair) {
        s.i(pair, "<this>");
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}
