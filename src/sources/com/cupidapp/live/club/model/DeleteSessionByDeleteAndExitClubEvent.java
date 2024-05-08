package com.cupidapp.live.club.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DeleteSessionByDeleteAndExitClubEvent {

    @NotNull
    private final String clubId;

    public DeleteSessionByDeleteAndExitClubEvent(@NotNull String clubId) {
        s.i(clubId, "clubId");
        this.clubId = clubId;
    }

    @NotNull
    public final String getClubId() {
        return this.clubId;
    }
}
