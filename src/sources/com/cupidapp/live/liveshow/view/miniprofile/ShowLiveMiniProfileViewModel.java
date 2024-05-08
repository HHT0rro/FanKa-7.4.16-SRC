package com.cupidapp.live.liveshow.view.miniprofile;

import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMiniProfileFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShowLiveMiniProfileViewModel implements Serializable {

    @Nullable
    private final SensorsLogMatch.AlohaGetPosition alohaGetPosition;
    private final boolean canReport;
    private final boolean careFollowAction;

    @Nullable
    private final String reportData;
    private final boolean reportLiveRoom;

    @NotNull
    private final String userId;

    public ShowLiveMiniProfileViewModel(@NotNull String userId, @Nullable SensorsLogMatch.AlohaGetPosition alohaGetPosition, @Nullable String str, boolean z10, boolean z11, boolean z12) {
        s.i(userId, "userId");
        this.userId = userId;
        this.alohaGetPosition = alohaGetPosition;
        this.reportData = str;
        this.canReport = z10;
        this.reportLiveRoom = z11;
        this.careFollowAction = z12;
    }

    public static /* synthetic */ ShowLiveMiniProfileViewModel copy$default(ShowLiveMiniProfileViewModel showLiveMiniProfileViewModel, String str, SensorsLogMatch.AlohaGetPosition alohaGetPosition, String str2, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = showLiveMiniProfileViewModel.userId;
        }
        if ((i10 & 2) != 0) {
            alohaGetPosition = showLiveMiniProfileViewModel.alohaGetPosition;
        }
        SensorsLogMatch.AlohaGetPosition alohaGetPosition2 = alohaGetPosition;
        if ((i10 & 4) != 0) {
            str2 = showLiveMiniProfileViewModel.reportData;
        }
        String str3 = str2;
        if ((i10 & 8) != 0) {
            z10 = showLiveMiniProfileViewModel.canReport;
        }
        boolean z13 = z10;
        if ((i10 & 16) != 0) {
            z11 = showLiveMiniProfileViewModel.reportLiveRoom;
        }
        boolean z14 = z11;
        if ((i10 & 32) != 0) {
            z12 = showLiveMiniProfileViewModel.careFollowAction;
        }
        return showLiveMiniProfileViewModel.copy(str, alohaGetPosition2, str3, z13, z14, z12);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final SensorsLogMatch.AlohaGetPosition component2() {
        return this.alohaGetPosition;
    }

    @Nullable
    public final String component3() {
        return this.reportData;
    }

    public final boolean component4() {
        return this.canReport;
    }

    public final boolean component5() {
        return this.reportLiveRoom;
    }

    public final boolean component6() {
        return this.careFollowAction;
    }

    @NotNull
    public final ShowLiveMiniProfileViewModel copy(@NotNull String userId, @Nullable SensorsLogMatch.AlohaGetPosition alohaGetPosition, @Nullable String str, boolean z10, boolean z11, boolean z12) {
        s.i(userId, "userId");
        return new ShowLiveMiniProfileViewModel(userId, alohaGetPosition, str, z10, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowLiveMiniProfileViewModel)) {
            return false;
        }
        ShowLiveMiniProfileViewModel showLiveMiniProfileViewModel = (ShowLiveMiniProfileViewModel) obj;
        return s.d(this.userId, showLiveMiniProfileViewModel.userId) && this.alohaGetPosition == showLiveMiniProfileViewModel.alohaGetPosition && s.d(this.reportData, showLiveMiniProfileViewModel.reportData) && this.canReport == showLiveMiniProfileViewModel.canReport && this.reportLiveRoom == showLiveMiniProfileViewModel.reportLiveRoom && this.careFollowAction == showLiveMiniProfileViewModel.careFollowAction;
    }

    @Nullable
    public final SensorsLogMatch.AlohaGetPosition getAlohaGetPosition() {
        return this.alohaGetPosition;
    }

    public final boolean getCanReport() {
        return this.canReport;
    }

    public final boolean getCareFollowAction() {
        return this.careFollowAction;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    public final boolean getReportLiveRoom() {
        return this.reportLiveRoom;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        SensorsLogMatch.AlohaGetPosition alohaGetPosition = this.alohaGetPosition;
        int hashCode2 = (hashCode + (alohaGetPosition == null ? 0 : alohaGetPosition.hashCode())) * 31;
        String str = this.reportData;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z10 = this.canReport;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        boolean z11 = this.reportLiveRoom;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.careFollowAction;
        return i13 + (z12 ? 1 : z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        SensorsLogMatch.AlohaGetPosition alohaGetPosition = this.alohaGetPosition;
        return "ShowLiveMiniProfileViewModel(userId=" + str + ", alohaGetPosition=" + ((Object) alohaGetPosition) + ", reportData=" + this.reportData + ", canReport=" + this.canReport + ", reportLiveRoom=" + this.reportLiveRoom + ", careFollowAction=" + this.careFollowAction + ")";
    }

    public /* synthetic */ ShowLiveMiniProfileViewModel(String str, SensorsLogMatch.AlohaGetPosition alohaGetPosition, String str2, boolean z10, boolean z11, boolean z12, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : alohaGetPosition, (i10 & 4) == 0 ? str2 : null, (i10 & 8) != 0 ? true : z10, (i10 & 16) != 0 ? false : z11, (i10 & 32) == 0 ? z12 : false);
    }
}
