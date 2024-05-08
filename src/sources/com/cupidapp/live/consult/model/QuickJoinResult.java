package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QuickJoinResult {

    @Nullable
    private final ConsultListModel voiceRoom;

    public QuickJoinResult(@Nullable ConsultListModel consultListModel) {
        this.voiceRoom = consultListModel;
    }

    public static /* synthetic */ QuickJoinResult copy$default(QuickJoinResult quickJoinResult, ConsultListModel consultListModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            consultListModel = quickJoinResult.voiceRoom;
        }
        return quickJoinResult.copy(consultListModel);
    }

    @Nullable
    public final ConsultListModel component1() {
        return this.voiceRoom;
    }

    @NotNull
    public final QuickJoinResult copy(@Nullable ConsultListModel consultListModel) {
        return new QuickJoinResult(consultListModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QuickJoinResult) && s.d(this.voiceRoom, ((QuickJoinResult) obj).voiceRoom);
    }

    @Nullable
    public final ConsultListModel getVoiceRoom() {
        return this.voiceRoom;
    }

    public int hashCode() {
        ConsultListModel consultListModel = this.voiceRoom;
        if (consultListModel == null) {
            return 0;
        }
        return consultListModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "QuickJoinResult(voiceRoom=" + ((Object) this.voiceRoom) + ")";
    }
}
