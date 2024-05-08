package com.cupidapp.live.chat2.helper;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.chat2.holder.ChatImageViewHolder;
import com.cupidapp.live.chat2.holder.ChatMarketViewHolder;
import com.cupidapp.live.chat2.holder.ChatNoticeViewHolder;
import com.cupidapp.live.chat2.holder.ChatOtherStoryLabelUiModel;
import com.cupidapp.live.chat2.holder.ChatOtherStoryLabelViewHolder;
import com.cupidapp.live.chat2.holder.ChatPostLimitRefererViewHolder;
import com.cupidapp.live.chat2.holder.ChatPostRefererViewHolder;
import com.cupidapp.live.chat2.holder.ChatRichViewHolder;
import com.cupidapp.live.chat2.holder.ChatSnapImageViewHolder;
import com.cupidapp.live.chat2.holder.ChatSnapTextViewHolder;
import com.cupidapp.live.chat2.holder.ChatStatusGreetViewHolder;
import com.cupidapp.live.chat2.holder.ChatStoryLabelPromptViewHolder;
import com.cupidapp.live.chat2.holder.ChatTextViewHolder;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatMessageType;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatTypeRegistry.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatTypeRegistry {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChatTypeRegistry f13347a = new ChatTypeRegistry();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final List<ChatItemViewTypeModel> f13348b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Lazy f13349c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Lazy f13350d;

    static {
        ChatMessageType chatMessageType = ChatMessageType.InboxMessageText;
        ChatTextViewHolder.a aVar = ChatTextViewHolder.f13393e;
        ChatMessageType chatMessageType2 = ChatMessageType.InboxMessageSnapText;
        ChatSnapTextViewHolder.a aVar2 = ChatSnapTextViewHolder.f13388d;
        ChatMessageType chatMessageType3 = ChatMessageType.InboxMessageImage;
        ChatImageViewHolder.a aVar3 = ChatImageViewHolder.f13375d;
        ChatMessageType chatMessageType4 = ChatMessageType.InboxMessageSnapImage;
        ChatSnapImageViewHolder.a aVar4 = ChatSnapImageViewHolder.f13387d;
        ChatMessageType chatMessageType5 = ChatMessageType.InboxMessageNotice;
        ChatNoticeViewHolder.a aVar5 = ChatNoticeViewHolder.f13380d;
        ChatMessageType chatMessageType6 = ChatMessageType.InboxMessageMarket;
        ChatMarketViewHolder.a aVar6 = ChatMarketViewHolder.f13376d;
        ChatMessageType chatMessageType7 = ChatMessageType.InboxMessagePostReferer;
        ChatPostRefererViewHolder.a aVar7 = ChatPostRefererViewHolder.f13385d;
        ChatMessageType chatMessageType8 = ChatMessageType.InboxMessageRich;
        ChatRichViewHolder.a aVar8 = ChatRichViewHolder.f13386d;
        ChatMessageType chatMessageType9 = ChatMessageType.InboxMessageScreenCaptureNotice;
        ChatMessageType chatMessageType10 = ChatMessageType.InboxMessageUserLabel;
        ChatStoryLabelPromptViewHolder.a aVar9 = ChatStoryLabelPromptViewHolder.f13390d;
        ChatMessageType chatMessageType11 = ChatMessageType.InboxMessageChatStatusGreet;
        ChatStatusGreetViewHolder.a aVar10 = ChatStatusGreetViewHolder.f13389d;
        ChatMessageType chatMessageType12 = ChatMessageType.InboxMessagePostLimitReferer;
        ChatPostLimitRefererViewHolder.a aVar11 = ChatPostLimitRefererViewHolder.f13384d;
        f13348b = s.m(new ChatItemViewTypeModel(chatMessageType, true, aVar), new ChatItemViewTypeModel(chatMessageType, false, aVar), new ChatItemViewTypeModel(chatMessageType2, true, aVar2), new ChatItemViewTypeModel(chatMessageType2, false, aVar2), new ChatItemViewTypeModel(chatMessageType3, true, aVar3), new ChatItemViewTypeModel(chatMessageType3, false, aVar3), new ChatItemViewTypeModel(chatMessageType4, true, aVar4), new ChatItemViewTypeModel(chatMessageType4, false, aVar4), new ChatItemViewTypeModel(chatMessageType5, true, aVar5), new ChatItemViewTypeModel(chatMessageType5, false, aVar5), new ChatItemViewTypeModel(chatMessageType6, true, aVar6), new ChatItemViewTypeModel(chatMessageType6, false, aVar6), new ChatItemViewTypeModel(chatMessageType7, true, aVar7), new ChatItemViewTypeModel(chatMessageType7, false, aVar7), new ChatItemViewTypeModel(chatMessageType8, true, aVar8), new ChatItemViewTypeModel(chatMessageType8, false, aVar8), new ChatItemViewTypeModel(chatMessageType9, true, aVar5), new ChatItemViewTypeModel(chatMessageType9, false, aVar5), new ChatItemViewTypeModel(chatMessageType10, true, aVar9), new ChatItemViewTypeModel(chatMessageType10, false, aVar9), new ChatItemViewTypeModel(chatMessageType11, true, aVar10), new ChatItemViewTypeModel(chatMessageType11, false, aVar10), new ChatItemViewTypeModel(chatMessageType12, true, aVar11), new ChatItemViewTypeModel(chatMessageType12, false, aVar11));
        f13349c = kotlin.c.b(new Function0<Integer>() { // from class: com.cupidapp.live.chat2.helper.ChatTypeRegistry$mLoadingItemViewTypeCode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                List list;
                list = ChatTypeRegistry.f13348b;
                return Integer.valueOf(list.size());
            }
        });
        f13350d = kotlin.c.b(new Function0<Integer>() { // from class: com.cupidapp.live.chat2.helper.ChatTypeRegistry$mOtherStoryLabelViewTypeCode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                List list;
                list = ChatTypeRegistry.f13348b;
                return Integer.valueOf(list.size() + 1);
            }
        });
    }

    public final int b(@NotNull Object model) {
        kotlin.jvm.internal.s.i(model, "model");
        if (model instanceof ChatMessageModel) {
            Iterator<ChatItemViewTypeModel> iterator2 = f13348b.iterator2();
            int i10 = 0;
            while (true) {
                if (!iterator2.hasNext()) {
                    i10 = -1;
                    break;
                }
                ChatItemViewTypeModel next = iterator2.next();
                ChatMessageModel chatMessageModel = (ChatMessageModel) model;
                if (kotlin.jvm.internal.s.d(next.getType().getValue(), chatMessageModel.getType()) && next.isMe() == chatMessageModel.getMine()) {
                    break;
                }
                i10++;
            }
            if (i10 >= 0 && i10 < f13348b.size()) {
                return i10;
            }
            throw new IllegalStateException(("ChatTypeRegistry getItemViewTypeCode, index:" + i10 + " totalCount:" + f13348b.size()).toString());
        }
        if (model instanceof FKFooterViewModel) {
            return c();
        }
        if (model instanceof ChatOtherStoryLabelUiModel) {
            return d();
        }
        throw new IllegalStateException(("ChatTypeRegistry getItemViewTypeCode model invalid, model:" + model).toString());
    }

    public final int c() {
        return ((Number) f13349c.getValue()).intValue();
    }

    public final int d() {
        return ((Number) f13350d.getValue()).intValue();
    }

    @NotNull
    public final FKBaseRecyclerViewHolder e(@NotNull ViewGroup parent, int i10) {
        kotlin.jvm.internal.s.i(parent, "parent");
        if (i10 == c()) {
            return FKFooterViewHolder.f12036c.a(parent);
        }
        if (i10 == d()) {
            return ChatOtherStoryLabelViewHolder.f13382d.a(parent);
        }
        ChatItemViewTypeModel chatItemViewTypeModel = f13348b.get(i10);
        return chatItemViewTypeModel.getFactory().a(parent, chatItemViewTypeModel.isMe());
    }
}
