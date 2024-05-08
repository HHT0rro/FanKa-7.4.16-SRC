package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.club.helper.ClubChatViewHolderFactory;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.view.ClubChatLeftUserInfoLayout;
import com.cupidapp.live.club.view.ClubChatRedPacketLayout;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ClubChatRedPacketViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatRedPacketViewHolder extends BaseClubChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13688d = new a(null);

    /* compiled from: ClubChatRedPacketViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements ClubChatViewHolderFactory {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.cupidapp.live.club.helper.ClubChatViewHolderFactory
        @NotNull
        public BaseClubChatViewHolder a(@NotNull ViewGroup parent, boolean z10) {
            s.i(parent, "parent");
            return new ClubChatRedPacketViewHolder(z.b(parent, z10 ? R$layout.view_holder_club_chat_red_packet_right : R$layout.view_holder_club_chat_red_packet_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatRedPacketViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.club_left_red_packet_avatar_image);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ClubChatLeftUserInfoLayout B() {
        return (ClubChatLeftUserInfoLayout) this.itemView.findViewById(R$id.club_left_red_packet_user_info_layout);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatMessageStateView C() {
        return null;
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatTimeStampView D() {
        return (ChatTimeStampView) this.itemView.findViewById(R$id.club_chat_red_packet_time_stamp_view);
    }

    public final void F(ClubChatRedPacketLayout clubChatRedPacketLayout, final ClubChatMsgModel clubChatMsgModel) {
        clubChatRedPacketLayout.b(clubChatMsgModel);
        y.d(clubChatRedPacketLayout, new Function1<View, p>() { // from class: com.cupidapp.live.club.viewholder.ClubChatRedPacketViewHolder$fillViewAndBindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                EventBus.c().l(new OpenRedEnvelopeEvent(ClubChatMsgModel.this));
            }
        });
        t(clubChatRedPacketLayout, clubChatMsgModel);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        return kotlin.collections.s.f(LongClickActionType.Delete);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void y(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        ClubChatRedPacketLayout clubChatRedPacketLayout = (ClubChatRedPacketLayout) this.itemView.findViewById(R$id.club_left_red_packet_layout);
        s.h(clubChatRedPacketLayout, "itemView.club_left_red_packet_layout");
        F(clubChatRedPacketLayout, model);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void z(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        ClubChatRedPacketLayout clubChatRedPacketLayout = (ClubChatRedPacketLayout) this.itemView.findViewById(R$id.club_right_red_packet_layout);
        s.h(clubChatRedPacketLayout, "itemView.club_right_red_packet_layout");
        F(clubChatRedPacketLayout, model);
    }
}
