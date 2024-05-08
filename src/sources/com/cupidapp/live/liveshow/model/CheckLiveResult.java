package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.LinkDictModel;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CheckLiveResult implements Serializable {

    @Nullable
    private final List<LiveActivityItemModel> activities;

    @Nullable
    private final Boolean activitySelectEnable;

    @Nullable
    private final LinkDictModel liveAgreement;

    @Nullable
    private final List<LiveActivityItemModel> selectedActivities;

    public CheckLiveResult(@Nullable LinkDictModel linkDictModel, @Nullable List<LiveActivityItemModel> list, @Nullable List<LiveActivityItemModel> list2, @Nullable Boolean bool) {
        this.liveAgreement = linkDictModel;
        this.activities = list;
        this.selectedActivities = list2;
        this.activitySelectEnable = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CheckLiveResult copy$default(CheckLiveResult checkLiveResult, LinkDictModel linkDictModel, List list, List list2, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            linkDictModel = checkLiveResult.liveAgreement;
        }
        if ((i10 & 2) != 0) {
            list = checkLiveResult.activities;
        }
        if ((i10 & 4) != 0) {
            list2 = checkLiveResult.selectedActivities;
        }
        if ((i10 & 8) != 0) {
            bool = checkLiveResult.activitySelectEnable;
        }
        return checkLiveResult.copy(linkDictModel, list, list2, bool);
    }

    @Nullable
    public final LinkDictModel component1() {
        return this.liveAgreement;
    }

    @Nullable
    public final List<LiveActivityItemModel> component2() {
        return this.activities;
    }

    @Nullable
    public final List<LiveActivityItemModel> component3() {
        return this.selectedActivities;
    }

    @Nullable
    public final Boolean component4() {
        return this.activitySelectEnable;
    }

    @NotNull
    public final CheckLiveResult copy(@Nullable LinkDictModel linkDictModel, @Nullable List<LiveActivityItemModel> list, @Nullable List<LiveActivityItemModel> list2, @Nullable Boolean bool) {
        return new CheckLiveResult(linkDictModel, list, list2, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckLiveResult)) {
            return false;
        }
        CheckLiveResult checkLiveResult = (CheckLiveResult) obj;
        return s.d(this.liveAgreement, checkLiveResult.liveAgreement) && s.d(this.activities, checkLiveResult.activities) && s.d(this.selectedActivities, checkLiveResult.selectedActivities) && s.d(this.activitySelectEnable, checkLiveResult.activitySelectEnable);
    }

    @Nullable
    public final List<LiveActivityItemModel> getActivities() {
        return this.activities;
    }

    @Nullable
    public final Boolean getActivitySelectEnable() {
        return this.activitySelectEnable;
    }

    @Nullable
    public final LinkDictModel getLiveAgreement() {
        return this.liveAgreement;
    }

    @Nullable
    public final List<LiveActivityItemModel> getSelectedActivities() {
        return this.selectedActivities;
    }

    public int hashCode() {
        LinkDictModel linkDictModel = this.liveAgreement;
        int hashCode = (linkDictModel == null ? 0 : linkDictModel.hashCode()) * 31;
        List<LiveActivityItemModel> list = this.activities;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<LiveActivityItemModel> list2 = this.selectedActivities;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Boolean bool = this.activitySelectEnable;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CheckLiveResult(liveAgreement=" + ((Object) this.liveAgreement) + ", activities=" + ((Object) this.activities) + ", selectedActivities=" + ((Object) this.selectedActivities) + ", activitySelectEnable=" + ((Object) this.activitySelectEnable) + ")";
    }
}
