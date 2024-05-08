package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTabModel {

    @Nullable
    private final String tab;

    @Nullable
    private final String tabName;

    public FeedTabModel(@Nullable String str, @Nullable String str2) {
        this.tabName = str;
        this.tab = str2;
    }

    public static /* synthetic */ FeedTabModel copy$default(FeedTabModel feedTabModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedTabModel.tabName;
        }
        if ((i10 & 2) != 0) {
            str2 = feedTabModel.tab;
        }
        return feedTabModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.tabName;
    }

    @Nullable
    public final String component2() {
        return this.tab;
    }

    @NotNull
    public final FeedTabModel copy(@Nullable String str, @Nullable String str2) {
        return new FeedTabModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedTabModel)) {
            return false;
        }
        FeedTabModel feedTabModel = (FeedTabModel) obj;
        return s.d(this.tabName, feedTabModel.tabName) && s.d(this.tab, feedTabModel.tab);
    }

    @Nullable
    public final String getTab() {
        return this.tab;
    }

    @Nullable
    public final String getTabName() {
        return this.tabName;
    }

    public int hashCode() {
        String str = this.tabName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tab;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FeedTabModel(tabName=" + this.tabName + ", tab=" + this.tab + ")";
    }
}
