package com.cupidapp.live.setting.fragment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelDetailFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class StoryLabelFollowEvent {
    private final boolean isFollow;

    public StoryLabelFollowEvent(boolean z10) {
        this.isFollow = z10;
    }

    public static /* synthetic */ StoryLabelFollowEvent copy$default(StoryLabelFollowEvent storyLabelFollowEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = storyLabelFollowEvent.isFollow;
        }
        return storyLabelFollowEvent.copy(z10);
    }

    public final boolean component1() {
        return this.isFollow;
    }

    @NotNull
    public final StoryLabelFollowEvent copy(boolean z10) {
        return new StoryLabelFollowEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StoryLabelFollowEvent) && this.isFollow == ((StoryLabelFollowEvent) obj).isFollow;
    }

    public int hashCode() {
        boolean z10 = this.isFollow;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    public final boolean isFollow() {
        return this.isFollow;
    }

    @NotNull
    public String toString() {
        return "StoryLabelFollowEvent(isFollow=" + this.isFollow + ")";
    }
}
