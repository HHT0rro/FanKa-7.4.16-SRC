package com.cupidapp.live.chat2.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatTopicModel {

    @Nullable
    private final String content;
    private final int index;

    public ChatTopicModel(int i10, @Nullable String str) {
        this.index = i10;
        this.content = str;
    }

    public static /* synthetic */ ChatTopicModel copy$default(ChatTopicModel chatTopicModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = chatTopicModel.index;
        }
        if ((i11 & 2) != 0) {
            str = chatTopicModel.content;
        }
        return chatTopicModel.copy(i10, str);
    }

    public final int component1() {
        return this.index;
    }

    @Nullable
    public final String component2() {
        return this.content;
    }

    @NotNull
    public final ChatTopicModel copy(int i10, @Nullable String str) {
        return new ChatTopicModel(i10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatTopicModel)) {
            return false;
        }
        ChatTopicModel chatTopicModel = (ChatTopicModel) obj;
        return this.index == chatTopicModel.index && s.d(this.content, chatTopicModel.content);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        int i10 = this.index * 31;
        String str = this.content;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "ChatTopicModel(index=" + this.index + ", content=" + this.content + ")";
    }
}
