package com.cupidapp.live.chat2.helper;

import com.cupidapp.live.chat2.model.ChatMessageType;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatTypeRegistry.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatItemViewTypeModel {

    @NotNull
    private final ChatViewHolderFactory factory;
    private final boolean isMe;

    @NotNull
    private final ChatMessageType type;

    public ChatItemViewTypeModel(@NotNull ChatMessageType type, boolean z10, @NotNull ChatViewHolderFactory factory) {
        s.i(type, "type");
        s.i(factory, "factory");
        this.type = type;
        this.isMe = z10;
        this.factory = factory;
    }

    public static /* synthetic */ ChatItemViewTypeModel copy$default(ChatItemViewTypeModel chatItemViewTypeModel, ChatMessageType chatMessageType, boolean z10, ChatViewHolderFactory chatViewHolderFactory, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            chatMessageType = chatItemViewTypeModel.type;
        }
        if ((i10 & 2) != 0) {
            z10 = chatItemViewTypeModel.isMe;
        }
        if ((i10 & 4) != 0) {
            chatViewHolderFactory = chatItemViewTypeModel.factory;
        }
        return chatItemViewTypeModel.copy(chatMessageType, z10, chatViewHolderFactory);
    }

    @NotNull
    public final ChatMessageType component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.isMe;
    }

    @NotNull
    public final ChatViewHolderFactory component3() {
        return this.factory;
    }

    @NotNull
    public final ChatItemViewTypeModel copy(@NotNull ChatMessageType type, boolean z10, @NotNull ChatViewHolderFactory factory) {
        s.i(type, "type");
        s.i(factory, "factory");
        return new ChatItemViewTypeModel(type, z10, factory);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatItemViewTypeModel)) {
            return false;
        }
        ChatItemViewTypeModel chatItemViewTypeModel = (ChatItemViewTypeModel) obj;
        return this.type == chatItemViewTypeModel.type && this.isMe == chatItemViewTypeModel.isMe && s.d(this.factory, chatItemViewTypeModel.factory);
    }

    @NotNull
    public final ChatViewHolderFactory getFactory() {
        return this.factory;
    }

    @NotNull
    public final ChatMessageType getType() {
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
        ChatMessageType chatMessageType = this.type;
        return "ChatItemViewTypeModel(type=" + ((Object) chatMessageType) + ", isMe=" + this.isMe + ", factory=" + ((Object) this.factory) + ")";
    }
}
