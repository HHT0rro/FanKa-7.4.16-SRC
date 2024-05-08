package com.cupidapp.live.club.viewholder;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubListTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListTitleModel {

    @NotNull
    private final String selectTitle;
    private final boolean showSettleIn;

    @NotNull
    private final List<String> title;
    private int topMargin;

    public ClubListTitleModel(@NotNull List<String> title, @NotNull String selectTitle, boolean z10, int i10) {
        s.i(title, "title");
        s.i(selectTitle, "selectTitle");
        this.title = title;
        this.selectTitle = selectTitle;
        this.showSettleIn = z10;
        this.topMargin = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClubListTitleModel copy$default(ClubListTitleModel clubListTitleModel, List list, String str, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = clubListTitleModel.title;
        }
        if ((i11 & 2) != 0) {
            str = clubListTitleModel.selectTitle;
        }
        if ((i11 & 4) != 0) {
            z10 = clubListTitleModel.showSettleIn;
        }
        if ((i11 & 8) != 0) {
            i10 = clubListTitleModel.topMargin;
        }
        return clubListTitleModel.copy(list, str, z10, i10);
    }

    @NotNull
    public final List<String> component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.selectTitle;
    }

    public final boolean component3() {
        return this.showSettleIn;
    }

    public final int component4() {
        return this.topMargin;
    }

    @NotNull
    public final ClubListTitleModel copy(@NotNull List<String> title, @NotNull String selectTitle, boolean z10, int i10) {
        s.i(title, "title");
        s.i(selectTitle, "selectTitle");
        return new ClubListTitleModel(title, selectTitle, z10, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubListTitleModel)) {
            return false;
        }
        ClubListTitleModel clubListTitleModel = (ClubListTitleModel) obj;
        return s.d(this.title, clubListTitleModel.title) && s.d(this.selectTitle, clubListTitleModel.selectTitle) && this.showSettleIn == clubListTitleModel.showSettleIn && this.topMargin == clubListTitleModel.topMargin;
    }

    @NotNull
    public final String getSelectTitle() {
        return this.selectTitle;
    }

    public final boolean getShowSettleIn() {
        return this.showSettleIn;
    }

    @NotNull
    public final List<String> getTitle() {
        return this.title;
    }

    public final int getTopMargin() {
        return this.topMargin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.selectTitle.hashCode()) * 31;
        boolean z10 = this.showSettleIn;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode + i10) * 31) + this.topMargin;
    }

    public final void setTopMargin(int i10) {
        this.topMargin = i10;
    }

    @NotNull
    public String toString() {
        List<String> list = this.title;
        return "ClubListTitleModel(title=" + ((Object) list) + ", selectTitle=" + this.selectTitle + ", showSettleIn=" + this.showSettleIn + ", topMargin=" + this.topMargin + ")";
    }

    public /* synthetic */ ClubListTitleModel(List list, String str, boolean z10, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? 0 : i10);
    }
}
