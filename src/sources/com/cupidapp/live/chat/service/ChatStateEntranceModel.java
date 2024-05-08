package com.cupidapp.live.chat.service;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStateEntranceModel {

    @Nullable
    private final ImageModel background;

    @Nullable
    private final String content;

    @Nullable
    private final ImageModel icon;

    public ChatStateEntranceModel(@Nullable String str, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2) {
        this.content = str;
        this.background = imageModel;
        this.icon = imageModel2;
    }

    public static /* synthetic */ ChatStateEntranceModel copy$default(ChatStateEntranceModel chatStateEntranceModel, String str, ImageModel imageModel, ImageModel imageModel2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = chatStateEntranceModel.content;
        }
        if ((i10 & 2) != 0) {
            imageModel = chatStateEntranceModel.background;
        }
        if ((i10 & 4) != 0) {
            imageModel2 = chatStateEntranceModel.icon;
        }
        return chatStateEntranceModel.copy(str, imageModel, imageModel2);
    }

    @Nullable
    public final String component1() {
        return this.content;
    }

    @Nullable
    public final ImageModel component2() {
        return this.background;
    }

    @Nullable
    public final ImageModel component3() {
        return this.icon;
    }

    @NotNull
    public final ChatStateEntranceModel copy(@Nullable String str, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2) {
        return new ChatStateEntranceModel(str, imageModel, imageModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatStateEntranceModel)) {
            return false;
        }
        ChatStateEntranceModel chatStateEntranceModel = (ChatStateEntranceModel) obj;
        return s.d(this.content, chatStateEntranceModel.content) && s.d(this.background, chatStateEntranceModel.background) && s.d(this.icon, chatStateEntranceModel.icon);
    }

    @Nullable
    public final ImageModel getBackground() {
        return this.background;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    public int hashCode() {
        String str = this.content;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.background;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.icon;
        return hashCode2 + (imageModel2 != null ? imageModel2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ChatStateEntranceModel(content=" + this.content + ", background=" + ((Object) this.background) + ", icon=" + ((Object) this.icon) + ")";
    }
}
