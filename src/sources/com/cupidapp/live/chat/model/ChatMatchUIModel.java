package com.cupidapp.live.chat.model;

import com.cupidapp.live.chat.service.ChatStateEntranceModel;
import com.cupidapp.live.chat.service.SuperBoostEntranceModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMatchUIModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatMatchUIModel {

    @Nullable
    private ChatStateEntranceModel chatEntranceModel;

    @Nullable
    private final SuperBoostEntranceModel superBoostEntrance;

    @Nullable
    private List<? extends Object> userList;

    public ChatMatchUIModel(@Nullable List<? extends Object> list, @Nullable ChatStateEntranceModel chatStateEntranceModel, @Nullable SuperBoostEntranceModel superBoostEntranceModel) {
        this.userList = list;
        this.chatEntranceModel = chatStateEntranceModel;
        this.superBoostEntrance = superBoostEntranceModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatMatchUIModel copy$default(ChatMatchUIModel chatMatchUIModel, List list, ChatStateEntranceModel chatStateEntranceModel, SuperBoostEntranceModel superBoostEntranceModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = chatMatchUIModel.userList;
        }
        if ((i10 & 2) != 0) {
            chatStateEntranceModel = chatMatchUIModel.chatEntranceModel;
        }
        if ((i10 & 4) != 0) {
            superBoostEntranceModel = chatMatchUIModel.superBoostEntrance;
        }
        return chatMatchUIModel.copy(list, chatStateEntranceModel, superBoostEntranceModel);
    }

    @Nullable
    public final List<Object> component1() {
        return this.userList;
    }

    @Nullable
    public final ChatStateEntranceModel component2() {
        return this.chatEntranceModel;
    }

    @Nullable
    public final SuperBoostEntranceModel component3() {
        return this.superBoostEntrance;
    }

    @NotNull
    public final ChatMatchUIModel copy(@Nullable List<? extends Object> list, @Nullable ChatStateEntranceModel chatStateEntranceModel, @Nullable SuperBoostEntranceModel superBoostEntranceModel) {
        return new ChatMatchUIModel(list, chatStateEntranceModel, superBoostEntranceModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMatchUIModel)) {
            return false;
        }
        ChatMatchUIModel chatMatchUIModel = (ChatMatchUIModel) obj;
        return s.d(this.userList, chatMatchUIModel.userList) && s.d(this.chatEntranceModel, chatMatchUIModel.chatEntranceModel) && s.d(this.superBoostEntrance, chatMatchUIModel.superBoostEntrance);
    }

    @Nullable
    public final ChatStateEntranceModel getChatEntranceModel() {
        return this.chatEntranceModel;
    }

    @Nullable
    public final SuperBoostEntranceModel getSuperBoostEntrance() {
        return this.superBoostEntrance;
    }

    @Nullable
    public final List<Object> getUserList() {
        return this.userList;
    }

    public int hashCode() {
        List<? extends Object> list = this.userList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        ChatStateEntranceModel chatStateEntranceModel = this.chatEntranceModel;
        int hashCode2 = (hashCode + (chatStateEntranceModel == null ? 0 : chatStateEntranceModel.hashCode())) * 31;
        SuperBoostEntranceModel superBoostEntranceModel = this.superBoostEntrance;
        return hashCode2 + (superBoostEntranceModel != null ? superBoostEntranceModel.hashCode() : 0);
    }

    public final void setChatEntranceModel(@Nullable ChatStateEntranceModel chatStateEntranceModel) {
        this.chatEntranceModel = chatStateEntranceModel;
    }

    public final void setUserList(@Nullable List<? extends Object> list) {
        this.userList = list;
    }

    @NotNull
    public String toString() {
        return "ChatMatchUIModel(userList=" + ((Object) this.userList) + ", chatEntranceModel=" + ((Object) this.chatEntranceModel) + ", superBoostEntrance=" + ((Object) this.superBoostEntrance) + ")";
    }

    public /* synthetic */ ChatMatchUIModel(List list, ChatStateEntranceModel chatStateEntranceModel, SuperBoostEntranceModel superBoostEntranceModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i10 & 2) != 0 ? null : chatStateEntranceModel, (i10 & 4) != 0 ? null : superBoostEntranceModel);
    }
}
