package com.cupidapp.live.club.helper;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.club.model.ClubChatMessageType;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.viewholder.ClubChatActivityViewHolder;
import com.cupidapp.live.club.viewholder.ClubChatImageViewHolder;
import com.cupidapp.live.club.viewholder.ClubChatNoticeViewHolder;
import com.cupidapp.live.club.viewholder.ClubChatRedPacketViewHolder;
import com.cupidapp.live.club.viewholder.ClubChatTextViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubChatTypeRegistry.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatTypeRegistry {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ClubChatTypeRegistry f13608a = new ClubChatTypeRegistry();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final List<ClubChatItemViewTypeModel> f13609b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Lazy f13610c;

    static {
        ClubChatMessageType clubChatMessageType = ClubChatMessageType.InboxMessageText;
        ClubChatTextViewHolder.a aVar = ClubChatTextViewHolder.f13689d;
        ClubChatMessageType clubChatMessageType2 = ClubChatMessageType.InboxMessageImage;
        ClubChatImageViewHolder.a aVar2 = ClubChatImageViewHolder.f13685d;
        ClubChatMessageType clubChatMessageType3 = ClubChatMessageType.InboxMessageNotice;
        ClubChatNoticeViewHolder.a aVar3 = ClubChatNoticeViewHolder.f13686d;
        ClubChatMessageType clubChatMessageType4 = ClubChatMessageType.InboxMessageRedPacket;
        ClubChatRedPacketViewHolder.a aVar4 = ClubChatRedPacketViewHolder.f13688d;
        ClubChatMessageType clubChatMessageType5 = ClubChatMessageType.InboxMessageActivity;
        ClubChatActivityViewHolder.a aVar5 = ClubChatActivityViewHolder.f13684d;
        f13609b = s.m(new ClubChatItemViewTypeModel(clubChatMessageType, true, aVar), new ClubChatItemViewTypeModel(clubChatMessageType, false, aVar), new ClubChatItemViewTypeModel(clubChatMessageType2, true, aVar2), new ClubChatItemViewTypeModel(clubChatMessageType2, false, aVar2), new ClubChatItemViewTypeModel(clubChatMessageType3, true, aVar3), new ClubChatItemViewTypeModel(clubChatMessageType3, false, aVar3), new ClubChatItemViewTypeModel(clubChatMessageType4, true, aVar4), new ClubChatItemViewTypeModel(clubChatMessageType4, false, aVar4), new ClubChatItemViewTypeModel(clubChatMessageType5, true, aVar5), new ClubChatItemViewTypeModel(clubChatMessageType5, false, aVar5));
        f13610c = c.b(new Function0<Integer>() { // from class: com.cupidapp.live.club.helper.ClubChatTypeRegistry$mLoadingItemViewTypeCode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                List list;
                list = ClubChatTypeRegistry.f13609b;
                return Integer.valueOf(list.size());
            }
        });
    }

    public final int b(@NotNull Object model) {
        kotlin.jvm.internal.s.i(model, "model");
        if (model instanceof ClubChatMsgModel) {
            Iterator<ClubChatItemViewTypeModel> iterator2 = f13609b.iterator2();
            int i10 = 0;
            while (true) {
                if (!iterator2.hasNext()) {
                    i10 = -1;
                    break;
                }
                ClubChatItemViewTypeModel next = iterator2.next();
                ClubChatMsgModel clubChatMsgModel = (ClubChatMsgModel) model;
                if (kotlin.jvm.internal.s.d(next.getType().getValue(), clubChatMsgModel.getType()) && next.isMe() == clubChatMsgModel.getMine()) {
                    break;
                }
                i10++;
            }
            if (i10 >= 0 && i10 < f13609b.size()) {
                return i10;
            }
            throw new IllegalStateException(("ClubChatTypeRegistry getItemViewTypeCode, index:" + i10 + " totalCount:" + f13609b.size()).toString());
        }
        if (model instanceof FKFooterViewModel) {
            return c();
        }
        throw new IllegalStateException(("ClubChatTypeRegistry getItemViewTypeCode model is not specified type， model:" + model).toString());
    }

    public final int c() {
        return ((Number) f13610c.getValue()).intValue();
    }

    @NotNull
    public final FKBaseRecyclerViewHolder d(@NotNull ViewGroup parent, int i10) {
        kotlin.jvm.internal.s.i(parent, "parent");
        if (i10 == c()) {
            return FKFooterViewHolder.f12036c.a(parent);
        }
        ClubChatItemViewTypeModel clubChatItemViewTypeModel = f13609b.get(i10);
        return clubChatItemViewTypeModel.getFactory().a(parent, clubChatItemViewTypeModel.isMe());
    }
}
