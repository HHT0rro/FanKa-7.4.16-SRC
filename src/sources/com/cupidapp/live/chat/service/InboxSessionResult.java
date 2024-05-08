package com.cupidapp.live.chat.service;

import com.cupidapp.live.chat.model.InboxSessionModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class InboxSessionResult {

    @Nullable
    private final List<NewUserGuideItemModel> guideList;

    @Nullable
    private final Boolean hasPrivilege;

    @Nullable
    private final List<InboxSessionModel> list;
    private final int messageCount;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final Boolean stealthMessage;

    public InboxSessionResult(int i10, @Nullable String str, @Nullable List<InboxSessionModel> list, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable List<NewUserGuideItemModel> list2) {
        this.messageCount = i10;
        this.nextCursorId = str;
        this.list = list;
        this.hasPrivilege = bool;
        this.stealthMessage = bool2;
        this.guideList = list2;
    }

    public static /* synthetic */ InboxSessionResult copy$default(InboxSessionResult inboxSessionResult, int i10, String str, List list, Boolean bool, Boolean bool2, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = inboxSessionResult.messageCount;
        }
        if ((i11 & 2) != 0) {
            str = inboxSessionResult.nextCursorId;
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            list = inboxSessionResult.list;
        }
        List list3 = list;
        if ((i11 & 8) != 0) {
            bool = inboxSessionResult.hasPrivilege;
        }
        Boolean bool3 = bool;
        if ((i11 & 16) != 0) {
            bool2 = inboxSessionResult.stealthMessage;
        }
        Boolean bool4 = bool2;
        if ((i11 & 32) != 0) {
            list2 = inboxSessionResult.guideList;
        }
        return inboxSessionResult.copy(i10, str2, list3, bool3, bool4, list2);
    }

    public final int component1() {
        return this.messageCount;
    }

    @Nullable
    public final String component2() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<InboxSessionModel> component3() {
        return this.list;
    }

    @Nullable
    public final Boolean component4() {
        return this.hasPrivilege;
    }

    @Nullable
    public final Boolean component5() {
        return this.stealthMessage;
    }

    @Nullable
    public final List<NewUserGuideItemModel> component6() {
        return this.guideList;
    }

    @NotNull
    public final InboxSessionResult copy(int i10, @Nullable String str, @Nullable List<InboxSessionModel> list, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable List<NewUserGuideItemModel> list2) {
        return new InboxSessionResult(i10, str, list, bool, bool2, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InboxSessionResult)) {
            return false;
        }
        InboxSessionResult inboxSessionResult = (InboxSessionResult) obj;
        return this.messageCount == inboxSessionResult.messageCount && s.d(this.nextCursorId, inboxSessionResult.nextCursorId) && s.d(this.list, inboxSessionResult.list) && s.d(this.hasPrivilege, inboxSessionResult.hasPrivilege) && s.d(this.stealthMessage, inboxSessionResult.stealthMessage) && s.d(this.guideList, inboxSessionResult.guideList);
    }

    @Nullable
    public final List<NewUserGuideItemModel> getGuideList() {
        return this.guideList;
    }

    @Nullable
    public final Boolean getHasPrivilege() {
        return this.hasPrivilege;
    }

    @Nullable
    public final List<InboxSessionModel> getList() {
        return this.list;
    }

    public final int getMessageCount() {
        return this.messageCount;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final Boolean getStealthMessage() {
        return this.stealthMessage;
    }

    public int hashCode() {
        int i10 = this.messageCount * 31;
        String str = this.nextCursorId;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        List<InboxSessionModel> list = this.list;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.hasPrivilege;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.stealthMessage;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        List<NewUserGuideItemModel> list2 = this.guideList;
        return hashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "InboxSessionResult(messageCount=" + this.messageCount + ", nextCursorId=" + this.nextCursorId + ", list=" + ((Object) this.list) + ", hasPrivilege=" + ((Object) this.hasPrivilege) + ", stealthMessage=" + ((Object) this.stealthMessage) + ", guideList=" + ((Object) this.guideList) + ")";
    }

    public /* synthetic */ InboxSessionResult(int i10, String str, List list, Boolean bool, Boolean bool2, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : list, bool, bool2, list2);
    }
}
