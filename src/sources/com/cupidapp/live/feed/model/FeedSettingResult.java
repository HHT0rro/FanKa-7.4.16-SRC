package com.cupidapp.live.feed.model;

import com.cupidapp.live.feed.FeedSort;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedSettingResult implements Serializable {
    private final boolean feedSortSwitch;

    @Nullable
    private final String feedSortType;

    public FeedSettingResult(@Nullable String str, boolean z10) {
        this.feedSortType = str;
        this.feedSortSwitch = z10;
    }

    public static /* synthetic */ FeedSettingResult copy$default(FeedSettingResult feedSettingResult, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedSettingResult.feedSortType;
        }
        if ((i10 & 2) != 0) {
            z10 = feedSettingResult.feedSortSwitch;
        }
        return feedSettingResult.copy(str, z10);
    }

    @Nullable
    public final String component1() {
        return this.feedSortType;
    }

    public final boolean component2() {
        return this.feedSortSwitch;
    }

    @NotNull
    public final FeedSettingResult copy(@Nullable String str, boolean z10) {
        return new FeedSettingResult(str, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedSettingResult)) {
            return false;
        }
        FeedSettingResult feedSettingResult = (FeedSettingResult) obj;
        return s.d(this.feedSortType, feedSettingResult.feedSortType) && this.feedSortSwitch == feedSettingResult.feedSortSwitch;
    }

    public final boolean getFeedSortSwitch() {
        return this.feedSortSwitch;
    }

    @Nullable
    public final String getFeedSortType() {
        return this.feedSortType;
    }

    @NotNull
    public final FeedSort getSortType() {
        String str = this.feedSortType;
        FeedSort feedSort = FeedSort.Intimacy;
        if (s.d(str, feedSort.getValue())) {
            return feedSort;
        }
        FeedSort feedSort2 = FeedSort.Time;
        if (!s.d(str, feedSort2.getValue())) {
            feedSort2 = FeedSort.Focus;
            if (!s.d(str, feedSort2.getValue())) {
                feedSort2 = FeedSort.CloseFriend;
                if (!s.d(str, feedSort2.getValue())) {
                    return feedSort;
                }
            }
        }
        return feedSort2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.feedSortType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z10 = this.feedSortSwitch;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        return "FeedSettingResult(feedSortType=" + this.feedSortType + ", feedSortSwitch=" + this.feedSortSwitch + ")";
    }
}
