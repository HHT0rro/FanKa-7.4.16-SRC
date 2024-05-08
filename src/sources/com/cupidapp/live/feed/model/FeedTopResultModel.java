package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTopResultModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTopResultModel {

    @Nullable
    private final String toastMsg;

    public FeedTopResultModel(@Nullable String str) {
        this.toastMsg = str;
    }

    public static /* synthetic */ FeedTopResultModel copy$default(FeedTopResultModel feedTopResultModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedTopResultModel.toastMsg;
        }
        return feedTopResultModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.toastMsg;
    }

    @NotNull
    public final FeedTopResultModel copy(@Nullable String str) {
        return new FeedTopResultModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedTopResultModel) && s.d(this.toastMsg, ((FeedTopResultModel) obj).toastMsg);
    }

    @Nullable
    public final String getToastMsg() {
        return this.toastMsg;
    }

    public int hashCode() {
        String str = this.toastMsg;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedTopResultModel(toastMsg=" + this.toastMsg + ")";
    }
}
