package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TitleViewModel {

    @Nullable
    private String description;
    private final boolean fromNearby;
    private boolean showVipIcon;

    @NotNull
    private final String title;

    public TitleViewModel(@NotNull String title, boolean z10, @Nullable String str, boolean z11) {
        s.i(title, "title");
        this.title = title;
        this.fromNearby = z10;
        this.description = str;
        this.showVipIcon = z11;
    }

    public static /* synthetic */ TitleViewModel copy$default(TitleViewModel titleViewModel, String str, boolean z10, String str2, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = titleViewModel.title;
        }
        if ((i10 & 2) != 0) {
            z10 = titleViewModel.fromNearby;
        }
        if ((i10 & 4) != 0) {
            str2 = titleViewModel.description;
        }
        if ((i10 & 8) != 0) {
            z11 = titleViewModel.showVipIcon;
        }
        return titleViewModel.copy(str, z10, str2, z11);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    public final boolean component2() {
        return this.fromNearby;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    public final boolean component4() {
        return this.showVipIcon;
    }

    @NotNull
    public final TitleViewModel copy(@NotNull String title, boolean z10, @Nullable String str, boolean z11) {
        s.i(title, "title");
        return new TitleViewModel(title, z10, str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleViewModel)) {
            return false;
        }
        TitleViewModel titleViewModel = (TitleViewModel) obj;
        return s.d(this.title, titleViewModel.title) && this.fromNearby == titleViewModel.fromNearby && s.d(this.description, titleViewModel.description) && this.showVipIcon == titleViewModel.showVipIcon;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    public final boolean getFromNearby() {
        return this.fromNearby;
    }

    public final boolean getShowVipIcon() {
        return this.showVipIcon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        boolean z10 = this.fromNearby;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        String str = this.description;
        int hashCode2 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z11 = this.showVipIcon;
        return hashCode2 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setShowVipIcon(boolean z10) {
        this.showVipIcon = z10;
    }

    @NotNull
    public String toString() {
        return "TitleViewModel(title=" + this.title + ", fromNearby=" + this.fromNearby + ", description=" + this.description + ", showVipIcon=" + this.showVipIcon + ")";
    }

    public /* synthetic */ TitleViewModel(String str, boolean z10, String str2, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z10, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? false : z11);
    }
}
