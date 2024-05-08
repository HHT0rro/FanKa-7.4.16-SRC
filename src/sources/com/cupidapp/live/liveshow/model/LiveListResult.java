package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveListResult {

    @Nullable
    private final List<LiveShowModel> list;

    @Nullable
    private final List<LiveModuleListModel> moduleList;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final String recommendTitle;

    @Nullable
    private final String userType;

    public LiveListResult(@Nullable List<LiveModuleListModel> list, @Nullable List<LiveShowModel> list2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.moduleList = list;
        this.list = list2;
        this.recommendTitle = str;
        this.nextCursorId = str2;
        this.userType = str3;
    }

    public static /* synthetic */ LiveListResult copy$default(LiveListResult liveListResult, List list, List list2, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = liveListResult.moduleList;
        }
        if ((i10 & 2) != 0) {
            list2 = liveListResult.list;
        }
        List list3 = list2;
        if ((i10 & 4) != 0) {
            str = liveListResult.recommendTitle;
        }
        String str4 = str;
        if ((i10 & 8) != 0) {
            str2 = liveListResult.nextCursorId;
        }
        String str5 = str2;
        if ((i10 & 16) != 0) {
            str3 = liveListResult.userType;
        }
        return liveListResult.copy(list, list3, str4, str5, str3);
    }

    @Nullable
    public final List<LiveModuleListModel> component1() {
        return this.moduleList;
    }

    @Nullable
    public final List<LiveShowModel> component2() {
        return this.list;
    }

    @Nullable
    public final String component3() {
        return this.recommendTitle;
    }

    @Nullable
    public final String component4() {
        return this.nextCursorId;
    }

    @Nullable
    public final String component5() {
        return this.userType;
    }

    @NotNull
    public final LiveListResult copy(@Nullable List<LiveModuleListModel> list, @Nullable List<LiveShowModel> list2, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new LiveListResult(list, list2, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveListResult)) {
            return false;
        }
        LiveListResult liveListResult = (LiveListResult) obj;
        return s.d(this.moduleList, liveListResult.moduleList) && s.d(this.list, liveListResult.list) && s.d(this.recommendTitle, liveListResult.recommendTitle) && s.d(this.nextCursorId, liveListResult.nextCursorId) && s.d(this.userType, liveListResult.userType);
    }

    @Nullable
    public final List<LiveShowModel> getList() {
        return this.list;
    }

    @Nullable
    public final List<LiveModuleListModel> getModuleList() {
        return this.moduleList;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final String getRecommendTitle() {
        return this.recommendTitle;
    }

    @Nullable
    public final String getUserType() {
        return this.userType;
    }

    public int hashCode() {
        List<LiveModuleListModel> list = this.moduleList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<LiveShowModel> list2 = this.list;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.recommendTitle;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nextCursorId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userType;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<LiveModuleListModel> list = this.moduleList;
        List<LiveShowModel> list2 = this.list;
        return "LiveListResult(moduleList=" + ((Object) list) + ", list=" + ((Object) list2) + ", recommendTitle=" + this.recommendTitle + ", nextCursorId=" + this.nextCursorId + ", userType=" + this.userType + ")";
    }
}
