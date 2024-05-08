package com.cupidapp.live.maskparty.helper;

import com.cupidapp.live.maskparty.model.MaskPartyChatMessageType;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatTypeRegistry.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatItemViewTypeModel {

    @NotNull
    private final MaskPartyChatViewHolderFactory factory;
    private final boolean isMe;

    @NotNull
    private final MaskPartyChatMessageType type;

    public MaskPartyChatItemViewTypeModel(@NotNull MaskPartyChatMessageType type, boolean z10, @NotNull MaskPartyChatViewHolderFactory factory) {
        s.i(type, "type");
        s.i(factory, "factory");
        this.type = type;
        this.isMe = z10;
        this.factory = factory;
    }

    public static /* synthetic */ MaskPartyChatItemViewTypeModel copy$default(MaskPartyChatItemViewTypeModel maskPartyChatItemViewTypeModel, MaskPartyChatMessageType maskPartyChatMessageType, boolean z10, MaskPartyChatViewHolderFactory maskPartyChatViewHolderFactory, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            maskPartyChatMessageType = maskPartyChatItemViewTypeModel.type;
        }
        if ((i10 & 2) != 0) {
            z10 = maskPartyChatItemViewTypeModel.isMe;
        }
        if ((i10 & 4) != 0) {
            maskPartyChatViewHolderFactory = maskPartyChatItemViewTypeModel.factory;
        }
        return maskPartyChatItemViewTypeModel.copy(maskPartyChatMessageType, z10, maskPartyChatViewHolderFactory);
    }

    @NotNull
    public final MaskPartyChatMessageType component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.isMe;
    }

    @NotNull
    public final MaskPartyChatViewHolderFactory component3() {
        return this.factory;
    }

    @NotNull
    public final MaskPartyChatItemViewTypeModel copy(@NotNull MaskPartyChatMessageType type, boolean z10, @NotNull MaskPartyChatViewHolderFactory factory) {
        s.i(type, "type");
        s.i(factory, "factory");
        return new MaskPartyChatItemViewTypeModel(type, z10, factory);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyChatItemViewTypeModel)) {
            return false;
        }
        MaskPartyChatItemViewTypeModel maskPartyChatItemViewTypeModel = (MaskPartyChatItemViewTypeModel) obj;
        return this.type == maskPartyChatItemViewTypeModel.type && this.isMe == maskPartyChatItemViewTypeModel.isMe && s.d(this.factory, maskPartyChatItemViewTypeModel.factory);
    }

    @NotNull
    public final MaskPartyChatViewHolderFactory getFactory() {
        return this.factory;
    }

    @NotNull
    public final MaskPartyChatMessageType getType() {
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
        MaskPartyChatMessageType maskPartyChatMessageType = this.type;
        return "MaskPartyChatItemViewTypeModel(type=" + ((Object) maskPartyChatMessageType) + ", isMe=" + this.isMe + ", factory=" + ((Object) this.factory) + ")";
    }
}
