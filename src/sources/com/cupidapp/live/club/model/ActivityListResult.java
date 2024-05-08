package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActivityListResult {

    @Nullable
    private final Boolean activityOrderUnread;
    private final boolean endedActivity;

    @Nullable
    private final String medalListUrl;

    @Nullable
    private final String myCoinUrl;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final String payOrderListUrl;

    @Nullable
    private final ImageModel recentActivityIcon;

    @Nullable
    private final List<ActivityModel> recentList;

    public ActivityListResult(@Nullable List<ActivityModel> list, @Nullable ImageModel imageModel, @Nullable String str, boolean z10, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.recentList = list;
        this.recentActivityIcon = imageModel;
        this.nextCursorId = str;
        this.endedActivity = z10;
        this.activityOrderUnread = bool;
        this.payOrderListUrl = str2;
        this.medalListUrl = str3;
        this.myCoinUrl = str4;
    }

    @Nullable
    public final List<ActivityModel> component1() {
        return this.recentList;
    }

    @Nullable
    public final ImageModel component2() {
        return this.recentActivityIcon;
    }

    @Nullable
    public final String component3() {
        return this.nextCursorId;
    }

    public final boolean component4() {
        return this.endedActivity;
    }

    @Nullable
    public final Boolean component5() {
        return this.activityOrderUnread;
    }

    @Nullable
    public final String component6() {
        return this.payOrderListUrl;
    }

    @Nullable
    public final String component7() {
        return this.medalListUrl;
    }

    @Nullable
    public final String component8() {
        return this.myCoinUrl;
    }

    @NotNull
    public final ActivityListResult copy(@Nullable List<ActivityModel> list, @Nullable ImageModel imageModel, @Nullable String str, boolean z10, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new ActivityListResult(list, imageModel, str, z10, bool, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityListResult)) {
            return false;
        }
        ActivityListResult activityListResult = (ActivityListResult) obj;
        return s.d(this.recentList, activityListResult.recentList) && s.d(this.recentActivityIcon, activityListResult.recentActivityIcon) && s.d(this.nextCursorId, activityListResult.nextCursorId) && this.endedActivity == activityListResult.endedActivity && s.d(this.activityOrderUnread, activityListResult.activityOrderUnread) && s.d(this.payOrderListUrl, activityListResult.payOrderListUrl) && s.d(this.medalListUrl, activityListResult.medalListUrl) && s.d(this.myCoinUrl, activityListResult.myCoinUrl);
    }

    @Nullable
    public final Boolean getActivityOrderUnread() {
        return this.activityOrderUnread;
    }

    public final boolean getEndedActivity() {
        return this.endedActivity;
    }

    @Nullable
    public final String getMedalListUrl() {
        return this.medalListUrl;
    }

    @Nullable
    public final String getMyCoinUrl() {
        return this.myCoinUrl;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final String getPayOrderListUrl() {
        return this.payOrderListUrl;
    }

    @Nullable
    public final ImageModel getRecentActivityIcon() {
        return this.recentActivityIcon;
    }

    @Nullable
    public final List<ActivityModel> getRecentList() {
        return this.recentList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<ActivityModel> list = this.recentList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        ImageModel imageModel = this.recentActivityIcon;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.nextCursorId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.endedActivity;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        Boolean bool = this.activityOrderUnread;
        int hashCode4 = (i11 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.payOrderListUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.medalListUrl;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.myCoinUrl;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<ActivityModel> list = this.recentList;
        ImageModel imageModel = this.recentActivityIcon;
        String str = this.nextCursorId;
        boolean z10 = this.endedActivity;
        Boolean bool = this.activityOrderUnread;
        return "ActivityListResult(recentList=" + ((Object) list) + ", recentActivityIcon=" + ((Object) imageModel) + ", nextCursorId=" + str + ", endedActivity=" + z10 + ", activityOrderUnread=" + ((Object) bool) + ", payOrderListUrl=" + this.payOrderListUrl + ", medalListUrl=" + this.medalListUrl + ", myCoinUrl=" + this.myCoinUrl + ")";
    }
}
