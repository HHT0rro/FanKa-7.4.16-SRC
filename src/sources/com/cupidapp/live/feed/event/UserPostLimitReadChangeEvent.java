package com.cupidapp.live.feed.event;

import java.util.Set;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PostLimitEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UserPostLimitReadChangeEvent {
    private final boolean isDelAllMyPostLimit;
    private final boolean isUploadedPostLimit;

    @NotNull
    private final Set<String> readUserIds;

    public UserPostLimitReadChangeEvent(@NotNull Set<String> readUserIds, boolean z10, boolean z11) {
        s.i(readUserIds, "readUserIds");
        this.readUserIds = readUserIds;
        this.isUploadedPostLimit = z10;
        this.isDelAllMyPostLimit = z11;
    }

    @NotNull
    public final Set<String> getReadUserIds() {
        return this.readUserIds;
    }

    public final boolean isDelAllMyPostLimit() {
        return this.isDelAllMyPostLimit;
    }

    public final boolean isUploadedPostLimit() {
        return this.isUploadedPostLimit;
    }
}
