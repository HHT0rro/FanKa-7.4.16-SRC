package com.cupidapp.live.chat2.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MessageBubbleModel {

    @Nullable
    private final String individuationInboxBubbleConfig;

    @Nullable
    private final List<String> textColors;

    public MessageBubbleModel(@Nullable String str, @Nullable List<String> list) {
        this.individuationInboxBubbleConfig = str;
        this.textColors = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageBubbleModel copy$default(MessageBubbleModel messageBubbleModel, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = messageBubbleModel.individuationInboxBubbleConfig;
        }
        if ((i10 & 2) != 0) {
            list = messageBubbleModel.textColors;
        }
        return messageBubbleModel.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.individuationInboxBubbleConfig;
    }

    @Nullable
    public final List<String> component2() {
        return this.textColors;
    }

    @NotNull
    public final MessageBubbleModel copy(@Nullable String str, @Nullable List<String> list) {
        return new MessageBubbleModel(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageBubbleModel)) {
            return false;
        }
        MessageBubbleModel messageBubbleModel = (MessageBubbleModel) obj;
        return s.d(this.individuationInboxBubbleConfig, messageBubbleModel.individuationInboxBubbleConfig) && s.d(this.textColors, messageBubbleModel.textColors);
    }

    @Nullable
    public final String getIndividuationInboxBubbleConfig() {
        return this.individuationInboxBubbleConfig;
    }

    @Nullable
    public final List<String> getTextColors() {
        return this.textColors;
    }

    public int hashCode() {
        String str = this.individuationInboxBubbleConfig;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.textColors;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MessageBubbleModel(individuationInboxBubbleConfig=" + this.individuationInboxBubbleConfig + ", textColors=" + ((Object) this.textColors) + ")";
    }
}
