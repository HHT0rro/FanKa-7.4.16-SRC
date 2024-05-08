package com.cupidapp.live.liveshow.fanclub.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubResult implements Serializable {

    @Nullable
    private final FKFanClubDataModel club;

    @Nullable
    private final List<FKFanClubMemberDataModel> members;

    @Nullable
    private final List<FKFanClubTaskSummaryDataModel> missionSummary;

    @Nullable
    private final List<FKFanClubTaskDataModel> missions;

    @Nullable
    private final FKFanClubMemberDataModel profile;

    public FKFanClubResult(@Nullable FKFanClubDataModel fKFanClubDataModel, @Nullable FKFanClubMemberDataModel fKFanClubMemberDataModel, @Nullable List<FKFanClubMemberDataModel> list, @Nullable List<FKFanClubTaskDataModel> list2, @Nullable List<FKFanClubTaskSummaryDataModel> list3) {
        this.club = fKFanClubDataModel;
        this.profile = fKFanClubMemberDataModel;
        this.members = list;
        this.missions = list2;
        this.missionSummary = list3;
    }

    @Nullable
    public final FKFanClubDataModel getClub() {
        return this.club;
    }

    @Nullable
    public final List<FKFanClubMemberDataModel> getMembers() {
        return this.members;
    }

    @Nullable
    public final List<FKFanClubTaskSummaryDataModel> getMissionSummary() {
        return this.missionSummary;
    }

    @Nullable
    public final List<FKFanClubTaskDataModel> getMissions() {
        return this.missions;
    }

    @Nullable
    public final FKFanClubMemberDataModel getProfile() {
        return this.profile;
    }
}
