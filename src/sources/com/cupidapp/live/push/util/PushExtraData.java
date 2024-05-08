package com.cupidapp.live.push.util;

import com.cupidapp.live.base.network.gson.GsonUtil;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPushExtraData.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushExtraData {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final Boolean initiativeMatch;

    @Nullable
    private final String messageId;

    @Nullable
    private final List<String> messageIds;

    @Nullable
    private final String sessionId;

    @Nullable
    private final String userId;

    /* compiled from: FKPushExtraData.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final PushExtraData a(@Nullable String str) {
            if (str != null) {
                return (PushExtraData) GsonUtil.f12000a.b().fromJson(str, PushExtraData.class);
            }
            return null;
        }
    }

    public PushExtraData() {
        this(null, null, null, null, null, 31, null);
    }

    public PushExtraData(@Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<String> list) {
        this.initiativeMatch = bool;
        this.userId = str;
        this.sessionId = str2;
        this.messageId = str3;
        this.messageIds = list;
    }

    @Nullable
    public final Boolean getInitiativeMatch() {
        return this.initiativeMatch;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final List<String> getMessageIds() {
        return this.messageIds;
    }

    @Nullable
    public final String getSessionId() {
        return this.sessionId;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public /* synthetic */ PushExtraData(Boolean bool, String str, String str2, String str3, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : list);
    }
}
