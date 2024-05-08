package com.cupidapp.live.liveshow.beauty.view;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveBeautyFilterListLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveFilterViewModel {
    private final int filterDefaults;
    private final int filterIcon;

    @Nullable
    private Integer filterIntensity;

    @NotNull
    private final String filterName;

    @Nullable
    private final String filterResource;
    private boolean isSelected;

    public FKLiveFilterViewModel(@NotNull String filterName, int i10, @Nullable String str, int i11, @Nullable Integer num, boolean z10) {
        s.i(filterName, "filterName");
        this.filterName = filterName;
        this.filterIcon = i10;
        this.filterResource = str;
        this.filterDefaults = i11;
        this.filterIntensity = num;
        this.isSelected = z10;
    }

    public static /* synthetic */ FKLiveFilterViewModel copy$default(FKLiveFilterViewModel fKLiveFilterViewModel, String str, int i10, String str2, int i11, Integer num, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = fKLiveFilterViewModel.filterName;
        }
        if ((i12 & 2) != 0) {
            i10 = fKLiveFilterViewModel.filterIcon;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            str2 = fKLiveFilterViewModel.filterResource;
        }
        String str3 = str2;
        if ((i12 & 8) != 0) {
            i11 = fKLiveFilterViewModel.filterDefaults;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            num = fKLiveFilterViewModel.filterIntensity;
        }
        Integer num2 = num;
        if ((i12 & 32) != 0) {
            z10 = fKLiveFilterViewModel.isSelected;
        }
        return fKLiveFilterViewModel.copy(str, i13, str3, i14, num2, z10);
    }

    @NotNull
    public final String component1() {
        return this.filterName;
    }

    public final int component2() {
        return this.filterIcon;
    }

    @Nullable
    public final String component3() {
        return this.filterResource;
    }

    public final int component4() {
        return this.filterDefaults;
    }

    @Nullable
    public final Integer component5() {
        return this.filterIntensity;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    @NotNull
    public final FKLiveFilterViewModel copy(@NotNull String filterName, int i10, @Nullable String str, int i11, @Nullable Integer num, boolean z10) {
        s.i(filterName, "filterName");
        return new FKLiveFilterViewModel(filterName, i10, str, i11, num, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveFilterViewModel)) {
            return false;
        }
        FKLiveFilterViewModel fKLiveFilterViewModel = (FKLiveFilterViewModel) obj;
        return s.d(this.filterName, fKLiveFilterViewModel.filterName) && this.filterIcon == fKLiveFilterViewModel.filterIcon && s.d(this.filterResource, fKLiveFilterViewModel.filterResource) && this.filterDefaults == fKLiveFilterViewModel.filterDefaults && s.d(this.filterIntensity, fKLiveFilterViewModel.filterIntensity) && this.isSelected == fKLiveFilterViewModel.isSelected;
    }

    public final int getFilterDefaults() {
        return this.filterDefaults;
    }

    public final int getFilterIcon() {
        return this.filterIcon;
    }

    @Nullable
    public final Integer getFilterIntensity() {
        return this.filterIntensity;
    }

    @NotNull
    public final String getFilterName() {
        return this.filterName;
    }

    @Nullable
    public final String getFilterResource() {
        return this.filterResource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.filterName.hashCode() * 31) + this.filterIcon) * 31;
        String str = this.filterResource;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.filterDefaults) * 31;
        Integer num = this.filterIntensity;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode3 + i10;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setFilterIntensity(@Nullable Integer num) {
        this.filterIntensity = num;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    @NotNull
    public String toString() {
        String str = this.filterName;
        int i10 = this.filterIcon;
        String str2 = this.filterResource;
        int i11 = this.filterDefaults;
        Integer num = this.filterIntensity;
        return "FKLiveFilterViewModel(filterName=" + str + ", filterIcon=" + i10 + ", filterResource=" + str2 + ", filterDefaults=" + i11 + ", filterIntensity=" + ((Object) num) + ", isSelected=" + this.isSelected + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ FKLiveFilterViewModel(java.lang.String r10, int r11, java.lang.String r12, int r13, java.lang.Integer r14, boolean r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 8
            r1 = 0
            if (r0 == 0) goto L7
            r6 = 0
            goto L8
        L7:
            r6 = r13
        L8:
            r0 = r16 & 16
            if (r0 == 0) goto L12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r7 = r0
            goto L13
        L12:
            r7 = r14
        L13:
            r0 = r16 & 32
            if (r0 == 0) goto L19
            r8 = 0
            goto L1a
        L19:
            r8 = r15
        L1a:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.beauty.view.FKLiveFilterViewModel.<init>(java.lang.String, int, java.lang.String, int, java.lang.Integer, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
