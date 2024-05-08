package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.AnchorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EndMessage {

    @NotNull
    private final AnchorModel anchorInfo;

    @Nullable
    private final String message;

    @Nullable
    private final List<LiveShowModel> rcmdLiveShows;

    @Nullable
    private final String style;

    public EndMessage(@Nullable String str, @Nullable String str2, @NotNull AnchorModel anchorInfo, @Nullable List<LiveShowModel> list) {
        kotlin.jvm.internal.s.i(anchorInfo, "anchorInfo");
        this.message = str;
        this.style = str2;
        this.anchorInfo = anchorInfo;
        this.rcmdLiveShows = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EndMessage copy$default(EndMessage endMessage, String str, String str2, AnchorModel anchorModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = endMessage.message;
        }
        if ((i10 & 2) != 0) {
            str2 = endMessage.style;
        }
        if ((i10 & 4) != 0) {
            anchorModel = endMessage.anchorInfo;
        }
        if ((i10 & 8) != 0) {
            list = endMessage.rcmdLiveShows;
        }
        return endMessage.copy(str, str2, anchorModel, list);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final String component2() {
        return this.style;
    }

    @NotNull
    public final AnchorModel component3() {
        return this.anchorInfo;
    }

    @Nullable
    public final List<LiveShowModel> component4() {
        return this.rcmdLiveShows;
    }

    @NotNull
    public final EndMessage copy(@Nullable String str, @Nullable String str2, @NotNull AnchorModel anchorInfo, @Nullable List<LiveShowModel> list) {
        kotlin.jvm.internal.s.i(anchorInfo, "anchorInfo");
        return new EndMessage(str, str2, anchorInfo, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EndMessage)) {
            return false;
        }
        EndMessage endMessage = (EndMessage) obj;
        return kotlin.jvm.internal.s.d(this.message, endMessage.message) && kotlin.jvm.internal.s.d(this.style, endMessage.style) && kotlin.jvm.internal.s.d(this.anchorInfo, endMessage.anchorInfo) && kotlin.jvm.internal.s.d(this.rcmdLiveShows, endMessage.rcmdLiveShows);
    }

    @NotNull
    public final AnchorModel getAnchorInfo() {
        return this.anchorInfo;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final List<LiveShowModel> getRcmdLiveShows() {
        return this.rcmdLiveShows;
    }

    @Nullable
    public final String getStyle() {
        return this.style;
    }

    public int hashCode() {
        String str = this.message;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.style;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.anchorInfo.hashCode()) * 31;
        List<LiveShowModel> list = this.rcmdLiveShows;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EndMessage(message=" + this.message + ", style=" + this.style + ", anchorInfo=" + ((Object) this.anchorInfo) + ", rcmdLiveShows=" + ((Object) this.rcmdLiveShows) + ")";
    }
}
