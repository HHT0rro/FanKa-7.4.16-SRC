package com.cupidapp.live.liveshow.view.music.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMusicDataResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MusicDataResult<T> {
    private final int currentPage;
    private final boolean isRecommend;

    @NotNull
    private final List<T> list;
    private final int totalPage;

    /* JADX WARN: Multi-variable type inference failed */
    public MusicDataResult(@NotNull List<? extends T> list, int i10, int i11, boolean z10) {
        s.i(list, "list");
        this.list = list;
        this.totalPage = i10;
        this.currentPage = i11;
        this.isRecommend = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MusicDataResult copy$default(MusicDataResult musicDataResult, List list, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = musicDataResult.list;
        }
        if ((i12 & 2) != 0) {
            i10 = musicDataResult.totalPage;
        }
        if ((i12 & 4) != 0) {
            i11 = musicDataResult.currentPage;
        }
        if ((i12 & 8) != 0) {
            z10 = musicDataResult.isRecommend;
        }
        return musicDataResult.copy(list, i10, i11, z10);
    }

    @NotNull
    public final List<T> component1() {
        return this.list;
    }

    public final int component2() {
        return this.totalPage;
    }

    public final int component3() {
        return this.currentPage;
    }

    public final boolean component4() {
        return this.isRecommend;
    }

    @NotNull
    public final MusicDataResult<T> copy(@NotNull List<? extends T> list, int i10, int i11, boolean z10) {
        s.i(list, "list");
        return new MusicDataResult<>(list, i10, i11, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicDataResult)) {
            return false;
        }
        MusicDataResult musicDataResult = (MusicDataResult) obj;
        return s.d(this.list, musicDataResult.list) && this.totalPage == musicDataResult.totalPage && this.currentPage == musicDataResult.currentPage && this.isRecommend == musicDataResult.isRecommend;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    @NotNull
    public final List<T> getList() {
        return this.list;
    }

    public final int getTotalPage() {
        return this.totalPage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.list.hashCode() * 31) + this.totalPage) * 31) + this.currentPage) * 31;
        boolean z10 = this.isRecommend;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isRecommend() {
        return this.isRecommend;
    }

    @NotNull
    public String toString() {
        List<T> list = this.list;
        return "MusicDataResult(list=" + ((Object) list) + ", totalPage=" + this.totalPage + ", currentPage=" + this.currentPage + ", isRecommend=" + this.isRecommend + ")";
    }

    public /* synthetic */ MusicDataResult(List list, int i10, int i11, boolean z10, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i10, i11, (i12 & 8) != 0 ? false : z10);
    }
}
