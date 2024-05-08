package com.cupidapp.live.liveshow.view.tag;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveShowTagView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveShowTagListModel implements Serializable {

    @NotNull
    private final List<LiveShowTagModel> list;
    private final int scrollType;

    public LiveShowTagListModel(int i10, @NotNull List<LiveShowTagModel> list) {
        s.i(list, "list");
        this.scrollType = i10;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveShowTagListModel copy$default(LiveShowTagListModel liveShowTagListModel, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = liveShowTagListModel.scrollType;
        }
        if ((i11 & 2) != 0) {
            list = liveShowTagListModel.list;
        }
        return liveShowTagListModel.copy(i10, list);
    }

    public final int component1() {
        return this.scrollType;
    }

    @NotNull
    public final List<LiveShowTagModel> component2() {
        return this.list;
    }

    @NotNull
    public final LiveShowTagListModel copy(int i10, @NotNull List<LiveShowTagModel> list) {
        s.i(list, "list");
        return new LiveShowTagListModel(i10, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowTagListModel)) {
            return false;
        }
        LiveShowTagListModel liveShowTagListModel = (LiveShowTagListModel) obj;
        return this.scrollType == liveShowTagListModel.scrollType && s.d(this.list, liveShowTagListModel.list);
    }

    @NotNull
    public final List<LiveShowTagModel> getList() {
        return this.list;
    }

    public final int getScrollType() {
        return this.scrollType;
    }

    public int hashCode() {
        return (this.scrollType * 31) + this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveShowTagListModel(scrollType=" + this.scrollType + ", list=" + ((Object) this.list) + ")";
    }
}
