package com.cupidapp.live.chat.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatStatusItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatStatusItemModel implements Serializable {

    @NotNull
    private final String content;

    @Nullable
    private final ImageModel icon;
    private final int statusVal;

    public ChatStatusItemModel(@Nullable ImageModel imageModel, int i10, @NotNull String content) {
        s.i(content, "content");
        this.icon = imageModel;
        this.statusVal = i10;
        this.content = content;
    }

    public static /* synthetic */ ChatStatusItemModel copy$default(ChatStatusItemModel chatStatusItemModel, ImageModel imageModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            imageModel = chatStatusItemModel.icon;
        }
        if ((i11 & 2) != 0) {
            i10 = chatStatusItemModel.statusVal;
        }
        if ((i11 & 4) != 0) {
            str = chatStatusItemModel.content;
        }
        return chatStatusItemModel.copy(imageModel, i10, str);
    }

    @Nullable
    public final ImageModel component1() {
        return this.icon;
    }

    public final int component2() {
        return this.statusVal;
    }

    @NotNull
    public final String component3() {
        return this.content;
    }

    @NotNull
    public final ChatStatusItemModel copy(@Nullable ImageModel imageModel, int i10, @NotNull String content) {
        s.i(content, "content");
        return new ChatStatusItemModel(imageModel, i10, content);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatStatusItemModel)) {
            return false;
        }
        ChatStatusItemModel chatStatusItemModel = (ChatStatusItemModel) obj;
        return s.d(this.icon, chatStatusItemModel.icon) && this.statusVal == chatStatusItemModel.statusVal && s.d(this.content, chatStatusItemModel.content);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    public final int getStatusVal() {
        return this.statusVal;
    }

    public int hashCode() {
        ImageModel imageModel = this.icon;
        return ((((imageModel == null ? 0 : imageModel.hashCode()) * 31) + this.statusVal) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "ChatStatusItemModel(icon=" + ((Object) imageModel) + ", statusVal=" + this.statusVal + ", content=" + this.content + ")";
    }
}
