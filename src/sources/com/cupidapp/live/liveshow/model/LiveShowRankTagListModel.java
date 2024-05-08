package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.liveshow.view.tag.LiveShowTagListModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowRankTagListModel {

    @Nullable
    private final String cursor;

    @Nullable
    private final List<LiveShowTagListModel> liveShowTagList;

    public LiveShowRankTagListModel(@Nullable List<LiveShowTagListModel> list, @Nullable String str) {
        this.liveShowTagList = list;
        this.cursor = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveShowRankTagListModel copy$default(LiveShowRankTagListModel liveShowRankTagListModel, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = liveShowRankTagListModel.liveShowTagList;
        }
        if ((i10 & 2) != 0) {
            str = liveShowRankTagListModel.cursor;
        }
        return liveShowRankTagListModel.copy(list, str);
    }

    @Nullable
    public final List<LiveShowTagListModel> component1() {
        return this.liveShowTagList;
    }

    @Nullable
    public final String component2() {
        return this.cursor;
    }

    @NotNull
    public final LiveShowRankTagListModel copy(@Nullable List<LiveShowTagListModel> list, @Nullable String str) {
        return new LiveShowRankTagListModel(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowRankTagListModel)) {
            return false;
        }
        LiveShowRankTagListModel liveShowRankTagListModel = (LiveShowRankTagListModel) obj;
        return s.d(this.liveShowTagList, liveShowRankTagListModel.liveShowTagList) && s.d(this.cursor, liveShowRankTagListModel.cursor);
    }

    @Nullable
    public final String getCursor() {
        return this.cursor;
    }

    @Nullable
    public final List<LiveShowTagListModel> getLiveShowTagList() {
        return this.liveShowTagList;
    }

    public int hashCode() {
        List<LiveShowTagListModel> list = this.liveShowTagList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.cursor;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<LiveShowTagListModel> list = this.liveShowTagList;
        return "LiveShowRankTagListModel(liveShowTagList=" + ((Object) list) + ", cursor=" + this.cursor + ")";
    }
}
