package com.cupidapp.live.chat2.model;

import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatMessageResult {

    @Nullable
    private final MessageBubbleModel bubble;

    @Nullable
    private final Boolean canEdit;

    @Nullable
    private final Boolean insertTop;

    @Nullable
    private final Integer labelId;

    @Nullable
    private final List<ChatMessageModel> list;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final Map<String, Object> recommendContext;

    @Nullable
    private final FKStoryLabelItemModel storyLabel;

    @Nullable
    private final List<AppDialogModel> windows;

    @Nullable
    private final List<ZodiacElfInfoModel> zodiacQuestion;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatMessageResult(@Nullable String str, @Nullable List<ChatMessageModel> list, @Nullable Map<String, ? extends Object> map, @Nullable List<? extends AppDialogModel> list2, @Nullable FKStoryLabelItemModel fKStoryLabelItemModel, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Integer num, @Nullable MessageBubbleModel messageBubbleModel, @Nullable List<ZodiacElfInfoModel> list3) {
        this.nextCursorId = str;
        this.list = list;
        this.recommendContext = map;
        this.windows = list2;
        this.storyLabel = fKStoryLabelItemModel;
        this.canEdit = bool;
        this.insertTop = bool2;
        this.labelId = num;
        this.bubble = messageBubbleModel;
        this.zodiacQuestion = list3;
    }

    @Nullable
    public final String component1() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<ZodiacElfInfoModel> component10() {
        return this.zodiacQuestion;
    }

    @Nullable
    public final List<ChatMessageModel> component2() {
        return this.list;
    }

    @Nullable
    public final Map<String, Object> component3() {
        return this.recommendContext;
    }

    @Nullable
    public final List<AppDialogModel> component4() {
        return this.windows;
    }

    @Nullable
    public final FKStoryLabelItemModel component5() {
        return this.storyLabel;
    }

    @Nullable
    public final Boolean component6() {
        return this.canEdit;
    }

    @Nullable
    public final Boolean component7() {
        return this.insertTop;
    }

    @Nullable
    public final Integer component8() {
        return this.labelId;
    }

    @Nullable
    public final MessageBubbleModel component9() {
        return this.bubble;
    }

    @NotNull
    public final ChatMessageResult copy(@Nullable String str, @Nullable List<ChatMessageModel> list, @Nullable Map<String, ? extends Object> map, @Nullable List<? extends AppDialogModel> list2, @Nullable FKStoryLabelItemModel fKStoryLabelItemModel, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Integer num, @Nullable MessageBubbleModel messageBubbleModel, @Nullable List<ZodiacElfInfoModel> list3) {
        return new ChatMessageResult(str, list, map, list2, fKStoryLabelItemModel, bool, bool2, num, messageBubbleModel, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessageResult)) {
            return false;
        }
        ChatMessageResult chatMessageResult = (ChatMessageResult) obj;
        return s.d(this.nextCursorId, chatMessageResult.nextCursorId) && s.d(this.list, chatMessageResult.list) && s.d(this.recommendContext, chatMessageResult.recommendContext) && s.d(this.windows, chatMessageResult.windows) && s.d(this.storyLabel, chatMessageResult.storyLabel) && s.d(this.canEdit, chatMessageResult.canEdit) && s.d(this.insertTop, chatMessageResult.insertTop) && s.d(this.labelId, chatMessageResult.labelId) && s.d(this.bubble, chatMessageResult.bubble) && s.d(this.zodiacQuestion, chatMessageResult.zodiacQuestion);
    }

    @Nullable
    public final MessageBubbleModel getBubble() {
        return this.bubble;
    }

    @Nullable
    public final Boolean getCanEdit() {
        return this.canEdit;
    }

    @Nullable
    public final Boolean getInsertTop() {
        return this.insertTop;
    }

    @Nullable
    public final Integer getLabelId() {
        return this.labelId;
    }

    @Nullable
    public final List<ChatMessageModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final Map<String, Object> getRecommendContext() {
        return this.recommendContext;
    }

    @Nullable
    public final FKStoryLabelItemModel getStoryLabel() {
        return this.storyLabel;
    }

    @Nullable
    public final List<AppDialogModel> getWindows() {
        return this.windows;
    }

    @Nullable
    public final List<ZodiacElfInfoModel> getZodiacQuestion() {
        return this.zodiacQuestion;
    }

    public int hashCode() {
        String str = this.nextCursorId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ChatMessageModel> list = this.list;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, Object> map = this.recommendContext;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        List<AppDialogModel> list2 = this.windows;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        FKStoryLabelItemModel fKStoryLabelItemModel = this.storyLabel;
        int hashCode5 = (hashCode4 + (fKStoryLabelItemModel == null ? 0 : fKStoryLabelItemModel.hashCode())) * 31;
        Boolean bool = this.canEdit;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.insertTop;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.labelId;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        MessageBubbleModel messageBubbleModel = this.bubble;
        int hashCode9 = (hashCode8 + (messageBubbleModel == null ? 0 : messageBubbleModel.hashCode())) * 31;
        List<ZodiacElfInfoModel> list3 = this.zodiacQuestion;
        return hashCode9 + (list3 != null ? list3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ChatMessageResult(nextCursorId=" + this.nextCursorId + ", list=" + ((Object) this.list) + ", recommendContext=" + ((Object) this.recommendContext) + ", windows=" + ((Object) this.windows) + ", storyLabel=" + ((Object) this.storyLabel) + ", canEdit=" + ((Object) this.canEdit) + ", insertTop=" + ((Object) this.insertTop) + ", labelId=" + ((Object) this.labelId) + ", bubble=" + ((Object) this.bubble) + ", zodiacQuestion=" + ((Object) this.zodiacQuestion) + ")";
    }
}
