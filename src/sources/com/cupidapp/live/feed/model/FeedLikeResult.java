package com.cupidapp.live.feed.model;

import com.cupidapp.live.appdialog.model.AppDialogModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedLikeResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedLikeResult {

    @Nullable
    private final List<AppDialogModel> windows;

    /* JADX WARN: Multi-variable type inference failed */
    public FeedLikeResult(@Nullable List<? extends AppDialogModel> list) {
        this.windows = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedLikeResult copy$default(FeedLikeResult feedLikeResult, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedLikeResult.windows;
        }
        return feedLikeResult.copy(list);
    }

    @Nullable
    public final List<AppDialogModel> component1() {
        return this.windows;
    }

    @NotNull
    public final FeedLikeResult copy(@Nullable List<? extends AppDialogModel> list) {
        return new FeedLikeResult(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedLikeResult) && s.d(this.windows, ((FeedLikeResult) obj).windows);
    }

    @Nullable
    public final List<AppDialogModel> getWindows() {
        return this.windows;
    }

    public int hashCode() {
        List<AppDialogModel> list = this.windows;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedLikeResult(windows=" + ((Object) this.windows) + ")";
    }
}
