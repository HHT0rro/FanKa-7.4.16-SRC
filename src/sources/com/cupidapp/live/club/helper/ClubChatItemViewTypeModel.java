package com.cupidapp.live.club.helper;

import com.cupidapp.live.club.model.ClubChatMessageType;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatTypeRegistry.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatItemViewTypeModel {

    @NotNull
    private final ClubChatViewHolderFactory factory;
    private final boolean isMe;

    @NotNull
    private final ClubChatMessageType type;

    public ClubChatItemViewTypeModel(@NotNull ClubChatMessageType type, boolean z10, @NotNull ClubChatViewHolderFactory factory) {
        s.i(type, "type");
        s.i(factory, "factory");
        this.type = type;
        this.isMe = z10;
        this.factory = factory;
    }

    public static /* synthetic */ ClubChatItemViewTypeModel copy$default(ClubChatItemViewTypeModel clubChatItemViewTypeModel, ClubChatMessageType clubChatMessageType, boolean z10, ClubChatViewHolderFactory clubChatViewHolderFactory, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            clubChatMessageType = clubChatItemViewTypeModel.type;
        }
        if ((i10 & 2) != 0) {
            z10 = clubChatItemViewTypeModel.isMe;
        }
        if ((i10 & 4) != 0) {
            clubChatViewHolderFactory = clubChatItemViewTypeModel.factory;
        }
        return clubChatItemViewTypeModel.copy(clubChatMessageType, z10, clubChatViewHolderFactory);
    }

    @NotNull
    public final ClubChatMessageType component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.isMe;
    }

    @NotNull
    public final ClubChatViewHolderFactory component3() {
        return this.factory;
    }

    @NotNull
    public final ClubChatItemViewTypeModel copy(@NotNull ClubChatMessageType type, boolean z10, @NotNull ClubChatViewHolderFactory factory) {
        s.i(type, "type");
        s.i(factory, "factory");
        return new ClubChatItemViewTypeModel(type, z10, factory);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubChatItemViewTypeModel)) {
            return false;
        }
        ClubChatItemViewTypeModel clubChatItemViewTypeModel = (ClubChatItemViewTypeModel) obj;
        return this.type == clubChatItemViewTypeModel.type && this.isMe == clubChatItemViewTypeModel.isMe && s.d(this.factory, clubChatItemViewTypeModel.factory);
    }

    @NotNull
    public final ClubChatViewHolderFactory getFactory() {
        return this.factory;
    }

    @NotNull
    public final ClubChatMessageType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        boolean z10 = this.isMe;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode + i10) * 31) + this.factory.hashCode();
    }

    public final boolean isMe() {
        return this.isMe;
    }

    @NotNull
    public String toString() {
        ClubChatMessageType clubChatMessageType = this.type;
        return "ClubChatItemViewTypeModel(type=" + ((Object) clubChatMessageType) + ", isMe=" + this.isMe + ", factory=" + ((Object) this.factory) + ")";
    }
}
