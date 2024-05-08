package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatMessageResult {

    @Nullable
    private final List<MaskPartyChatMessageModel> list;

    @Nullable
    private final String nextCursorId;
    private final int score;

    public MaskPartyChatMessageResult(int i10, @Nullable String str, @Nullable List<MaskPartyChatMessageModel> list) {
        this.score = i10;
        this.nextCursorId = str;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaskPartyChatMessageResult copy$default(MaskPartyChatMessageResult maskPartyChatMessageResult, int i10, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = maskPartyChatMessageResult.score;
        }
        if ((i11 & 2) != 0) {
            str = maskPartyChatMessageResult.nextCursorId;
        }
        if ((i11 & 4) != 0) {
            list = maskPartyChatMessageResult.list;
        }
        return maskPartyChatMessageResult.copy(i10, str, list);
    }

    public final int component1() {
        return this.score;
    }

    @Nullable
    public final String component2() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<MaskPartyChatMessageModel> component3() {
        return this.list;
    }

    @NotNull
    public final MaskPartyChatMessageResult copy(int i10, @Nullable String str, @Nullable List<MaskPartyChatMessageModel> list) {
        return new MaskPartyChatMessageResult(i10, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyChatMessageResult)) {
            return false;
        }
        MaskPartyChatMessageResult maskPartyChatMessageResult = (MaskPartyChatMessageResult) obj;
        return this.score == maskPartyChatMessageResult.score && s.d(this.nextCursorId, maskPartyChatMessageResult.nextCursorId) && s.d(this.list, maskPartyChatMessageResult.list);
    }

    @Nullable
    public final List<MaskPartyChatMessageModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        int i10 = this.score * 31;
        String str = this.nextCursorId;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        List<MaskPartyChatMessageModel> list = this.list;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MaskPartyChatMessageResult(score=" + this.score + ", nextCursorId=" + this.nextCursorId + ", list=" + ((Object) this.list) + ")";
    }
}
