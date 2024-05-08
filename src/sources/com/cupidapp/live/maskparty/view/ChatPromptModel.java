package com.cupidapp.live.maskparty.view;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatPromptLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChatPromptModel {

    @Nullable
    private final String button;

    @NotNull
    private final String content;

    @Nullable
    private final Integer countDown;

    @Nullable
    private final List<String> keys;

    @Nullable
    private final String title;
    private final int topIcon;

    @NotNull
    private final PromptType type;

    public ChatPromptModel(@NotNull PromptType type, @Nullable String str, @NotNull String content, int i10, @Nullable List<String> list, @Nullable String str2, @Nullable Integer num) {
        s.i(type, "type");
        s.i(content, "content");
        this.type = type;
        this.title = str;
        this.content = content;
        this.topIcon = i10;
        this.keys = list;
        this.button = str2;
        this.countDown = num;
    }

    public static /* synthetic */ ChatPromptModel copy$default(ChatPromptModel chatPromptModel, PromptType promptType, String str, String str2, int i10, List list, String str3, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            promptType = chatPromptModel.type;
        }
        if ((i11 & 2) != 0) {
            str = chatPromptModel.title;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            str2 = chatPromptModel.content;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            i10 = chatPromptModel.topIcon;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            list = chatPromptModel.keys;
        }
        List list2 = list;
        if ((i11 & 32) != 0) {
            str3 = chatPromptModel.button;
        }
        String str6 = str3;
        if ((i11 & 64) != 0) {
            num = chatPromptModel.countDown;
        }
        return chatPromptModel.copy(promptType, str4, str5, i12, list2, str6, num);
    }

    @NotNull
    public final PromptType component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.content;
    }

    public final int component4() {
        return this.topIcon;
    }

    @Nullable
    public final List<String> component5() {
        return this.keys;
    }

    @Nullable
    public final String component6() {
        return this.button;
    }

    @Nullable
    public final Integer component7() {
        return this.countDown;
    }

    @NotNull
    public final ChatPromptModel copy(@NotNull PromptType type, @Nullable String str, @NotNull String content, int i10, @Nullable List<String> list, @Nullable String str2, @Nullable Integer num) {
        s.i(type, "type");
        s.i(content, "content");
        return new ChatPromptModel(type, str, content, i10, list, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatPromptModel)) {
            return false;
        }
        ChatPromptModel chatPromptModel = (ChatPromptModel) obj;
        return this.type == chatPromptModel.type && s.d(this.title, chatPromptModel.title) && s.d(this.content, chatPromptModel.content) && this.topIcon == chatPromptModel.topIcon && s.d(this.keys, chatPromptModel.keys) && s.d(this.button, chatPromptModel.button) && s.d(this.countDown, chatPromptModel.countDown);
    }

    @Nullable
    public final String getButton() {
        return this.button;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Integer getCountDown() {
        return this.countDown;
    }

    @Nullable
    public final List<String> getKeys() {
        return this.keys;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getTopIcon() {
        return this.topIcon;
    }

    @NotNull
    public final PromptType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        String str = this.title;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.content.hashCode()) * 31) + this.topIcon) * 31;
        List<String> list = this.keys;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.button;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.countDown;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        PromptType promptType = this.type;
        String str = this.title;
        String str2 = this.content;
        int i10 = this.topIcon;
        List<String> list = this.keys;
        return "ChatPromptModel(type=" + ((Object) promptType) + ", title=" + str + ", content=" + str2 + ", topIcon=" + i10 + ", keys=" + ((Object) list) + ", button=" + this.button + ", countDown=" + ((Object) this.countDown) + ")";
    }

    public /* synthetic */ ChatPromptModel(PromptType promptType, String str, String str2, int i10, List list, String str3, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(promptType, str, str2, i10, list, str3, (i11 & 64) != 0 ? null : num);
    }
}
