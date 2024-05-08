package com.cupidapp.live.consult.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultListResult {

    @Nullable
    private final String emptyJumpTitle;

    @Nullable
    private final String emptyJumpUrl;

    @Nullable
    private final List<ConsultListModel> list;

    @Nullable
    private final String nextCursorId;

    public ConsultListResult(@Nullable String str, @Nullable List<ConsultListModel> list, @Nullable String str2, @Nullable String str3) {
        this.nextCursorId = str;
        this.list = list;
        this.emptyJumpTitle = str2;
        this.emptyJumpUrl = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsultListResult copy$default(ConsultListResult consultListResult, String str, List list, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = consultListResult.nextCursorId;
        }
        if ((i10 & 2) != 0) {
            list = consultListResult.list;
        }
        if ((i10 & 4) != 0) {
            str2 = consultListResult.emptyJumpTitle;
        }
        if ((i10 & 8) != 0) {
            str3 = consultListResult.emptyJumpUrl;
        }
        return consultListResult.copy(str, list, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<ConsultListModel> component2() {
        return this.list;
    }

    @Nullable
    public final String component3() {
        return this.emptyJumpTitle;
    }

    @Nullable
    public final String component4() {
        return this.emptyJumpUrl;
    }

    @NotNull
    public final ConsultListResult copy(@Nullable String str, @Nullable List<ConsultListModel> list, @Nullable String str2, @Nullable String str3) {
        return new ConsultListResult(str, list, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultListResult)) {
            return false;
        }
        ConsultListResult consultListResult = (ConsultListResult) obj;
        return s.d(this.nextCursorId, consultListResult.nextCursorId) && s.d(this.list, consultListResult.list) && s.d(this.emptyJumpTitle, consultListResult.emptyJumpTitle) && s.d(this.emptyJumpUrl, consultListResult.emptyJumpUrl);
    }

    @Nullable
    public final String getEmptyJumpTitle() {
        return this.emptyJumpTitle;
    }

    @Nullable
    public final String getEmptyJumpUrl() {
        return this.emptyJumpUrl;
    }

    @Nullable
    public final List<ConsultListModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public int hashCode() {
        String str = this.nextCursorId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ConsultListModel> list = this.list;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.emptyJumpTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.emptyJumpUrl;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.nextCursorId;
        List<ConsultListModel> list = this.list;
        return "ConsultListResult(nextCursorId=" + str + ", list=" + ((Object) list) + ", emptyJumpTitle=" + this.emptyJumpTitle + ", emptyJumpUrl=" + this.emptyJumpUrl + ")";
    }
}
