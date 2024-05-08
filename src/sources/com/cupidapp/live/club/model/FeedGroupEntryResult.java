package com.cupidapp.live.club.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedGroupEntryResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedGroupEntryResult {

    @Nullable
    private final String groupActivityFeedEntryName;
    private final boolean groupActivityGuide;
    private final boolean groupPayOrderUnread;

    public FeedGroupEntryResult(boolean z10, boolean z11, @Nullable String str) {
        this.groupActivityGuide = z10;
        this.groupPayOrderUnread = z11;
        this.groupActivityFeedEntryName = str;
    }

    @Nullable
    public final String getGroupActivityFeedEntryName() {
        return this.groupActivityFeedEntryName;
    }

    public final boolean getGroupActivityGuide() {
        return this.groupActivityGuide;
    }

    public final boolean getGroupPayOrderUnread() {
        return this.groupPayOrderUnread;
    }
}
