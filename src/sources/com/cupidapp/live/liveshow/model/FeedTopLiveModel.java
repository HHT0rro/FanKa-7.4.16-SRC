package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTopLiveModel {

    @Nullable
    private final List<LiveShowModel> list;

    @Nullable
    private final String title;
    private boolean useNewUi;

    public FeedTopLiveModel(@Nullable List<LiveShowModel> list, @Nullable String str, boolean z10) {
        this.list = list;
        this.title = str;
        this.useNewUi = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedTopLiveModel copy$default(FeedTopLiveModel feedTopLiveModel, List list, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedTopLiveModel.list;
        }
        if ((i10 & 2) != 0) {
            str = feedTopLiveModel.title;
        }
        if ((i10 & 4) != 0) {
            z10 = feedTopLiveModel.useNewUi;
        }
        return feedTopLiveModel.copy(list, str, z10);
    }

    @Nullable
    public final List<LiveShowModel> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    public final boolean component3() {
        return this.useNewUi;
    }

    @NotNull
    public final FeedTopLiveModel copy(@Nullable List<LiveShowModel> list, @Nullable String str, boolean z10) {
        return new FeedTopLiveModel(list, str, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedTopLiveModel)) {
            return false;
        }
        FeedTopLiveModel feedTopLiveModel = (FeedTopLiveModel) obj;
        return s.d(this.list, feedTopLiveModel.list) && s.d(this.title, feedTopLiveModel.title) && this.useNewUi == feedTopLiveModel.useNewUi;
    }

    @Nullable
    public final List<LiveShowModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final boolean getUseNewUi() {
        return this.useNewUi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<LiveShowModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z10 = this.useNewUi;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    public final void setUseNewUi(boolean z10) {
        this.useNewUi = z10;
    }

    @NotNull
    public String toString() {
        List<LiveShowModel> list = this.list;
        return "FeedTopLiveModel(list=" + ((Object) list) + ", title=" + this.title + ", useNewUi=" + this.useNewUi + ")";
    }

    public /* synthetic */ FeedTopLiveModel(List list, String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i10 & 4) != 0 ? false : z10);
    }
}
