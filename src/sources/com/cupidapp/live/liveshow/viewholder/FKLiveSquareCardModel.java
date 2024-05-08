package com.cupidapp.live.liveshow.viewholder;

import com.cupidapp.live.liveshow.model.LiveShowModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveSquareCardViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveSquareCardModel {
    private final boolean haveMore;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f16045id;

    @NotNull
    private final List<LiveShowModel> squareCardList;

    @Nullable
    private final String title;

    public FKLiveSquareCardModel(@NotNull String id2, @Nullable String str, @NotNull List<LiveShowModel> squareCardList, boolean z10) {
        s.i(id2, "id");
        s.i(squareCardList, "squareCardList");
        this.f16045id = id2;
        this.title = str;
        this.squareCardList = squareCardList;
        this.haveMore = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKLiveSquareCardModel copy$default(FKLiveSquareCardModel fKLiveSquareCardModel, String str, String str2, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKLiveSquareCardModel.f16045id;
        }
        if ((i10 & 2) != 0) {
            str2 = fKLiveSquareCardModel.title;
        }
        if ((i10 & 4) != 0) {
            list = fKLiveSquareCardModel.squareCardList;
        }
        if ((i10 & 8) != 0) {
            z10 = fKLiveSquareCardModel.haveMore;
        }
        return fKLiveSquareCardModel.copy(str, str2, list, z10);
    }

    @NotNull
    public final String component1() {
        return this.f16045id;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final List<LiveShowModel> component3() {
        return this.squareCardList;
    }

    public final boolean component4() {
        return this.haveMore;
    }

    @NotNull
    public final FKLiveSquareCardModel copy(@NotNull String id2, @Nullable String str, @NotNull List<LiveShowModel> squareCardList, boolean z10) {
        s.i(id2, "id");
        s.i(squareCardList, "squareCardList");
        return new FKLiveSquareCardModel(id2, str, squareCardList, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveSquareCardModel)) {
            return false;
        }
        FKLiveSquareCardModel fKLiveSquareCardModel = (FKLiveSquareCardModel) obj;
        return s.d(this.f16045id, fKLiveSquareCardModel.f16045id) && s.d(this.title, fKLiveSquareCardModel.title) && s.d(this.squareCardList, fKLiveSquareCardModel.squareCardList) && this.haveMore == fKLiveSquareCardModel.haveMore;
    }

    public final boolean getHaveMore() {
        return this.haveMore;
    }

    @NotNull
    public final String getId() {
        return this.f16045id;
    }

    @NotNull
    public final List<LiveShowModel> getSquareCardList() {
        return this.squareCardList;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f16045id.hashCode() * 31;
        String str = this.title;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.squareCardList.hashCode()) * 31;
        boolean z10 = this.haveMore;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    @NotNull
    public String toString() {
        String str = this.f16045id;
        String str2 = this.title;
        List<LiveShowModel> list = this.squareCardList;
        return "FKLiveSquareCardModel(id=" + str + ", title=" + str2 + ", squareCardList=" + ((Object) list) + ", haveMore=" + this.haveMore + ")";
    }
}
