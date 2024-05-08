package com.cupidapp.live.chat2.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatMessageResult {

    @Nullable
    private final List<SurveyChatMessageModel> list;

    @NotNull
    private final User sender;

    @Nullable
    private final String topTips;

    public SurveyChatMessageResult(@NotNull User sender, @Nullable String str, @Nullable List<SurveyChatMessageModel> list) {
        s.i(sender, "sender");
        this.sender = sender;
        this.topTips = str;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyChatMessageResult copy$default(SurveyChatMessageResult surveyChatMessageResult, User user, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = surveyChatMessageResult.sender;
        }
        if ((i10 & 2) != 0) {
            str = surveyChatMessageResult.topTips;
        }
        if ((i10 & 4) != 0) {
            list = surveyChatMessageResult.list;
        }
        return surveyChatMessageResult.copy(user, str, list);
    }

    @NotNull
    public final User component1() {
        return this.sender;
    }

    @Nullable
    public final String component2() {
        return this.topTips;
    }

    @Nullable
    public final List<SurveyChatMessageModel> component3() {
        return this.list;
    }

    @NotNull
    public final SurveyChatMessageResult copy(@NotNull User sender, @Nullable String str, @Nullable List<SurveyChatMessageModel> list) {
        s.i(sender, "sender");
        return new SurveyChatMessageResult(sender, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurveyChatMessageResult)) {
            return false;
        }
        SurveyChatMessageResult surveyChatMessageResult = (SurveyChatMessageResult) obj;
        return s.d(this.sender, surveyChatMessageResult.sender) && s.d(this.topTips, surveyChatMessageResult.topTips) && s.d(this.list, surveyChatMessageResult.list);
    }

    @Nullable
    public final List<SurveyChatMessageModel> getList() {
        return this.list;
    }

    @NotNull
    public final User getSender() {
        return this.sender;
    }

    @Nullable
    public final String getTopTips() {
        return this.topTips;
    }

    public int hashCode() {
        int hashCode = this.sender.hashCode() * 31;
        String str = this.topTips;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<SurveyChatMessageModel> list = this.list;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.sender;
        return "SurveyChatMessageResult(sender=" + ((Object) user) + ", topTips=" + this.topTips + ", list=" + ((Object) this.list) + ")";
    }
}
