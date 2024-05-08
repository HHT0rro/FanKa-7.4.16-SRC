package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.club.helper.ClubChatViewHolderFactory;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.view.ClubChatActivityLayout;
import com.cupidapp.live.club.view.ClubChatLeftUserInfoLayout;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ClubChatActivityViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatActivityViewHolder extends BaseClubChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13684d = new a(null);

    /* compiled from: ClubChatActivityViewHolder.kt */
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
            return new ClubChatActivityViewHolder(z.b(parent, z10 ? R$layout.view_holder_club_chat_activity_right : R$layout.view_holder_club_chat_activity_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatActivityViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.club_left_activity_avatar_image);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ClubChatLeftUserInfoLayout B() {
        return (ClubChatLeftUserInfoLayout) this.itemView.findViewById(R$id.club_left_activity_user_info_layout);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatMessageStateView C() {
        return null;
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatTimeStampView D() {
        return (ChatTimeStampView) this.itemView.findViewById(R$id.club_chat_activity_time_stamp_view);
    }

    public final void F(ClubChatActivityLayout clubChatActivityLayout, final ClubChatMsgModel clubChatMsgModel) {
        clubChatActivityLayout.b(clubChatMsgModel);
        y.d(clubChatActivityLayout, new Function1<View, p>() { // from class: com.cupidapp.live.club.viewholder.ClubChatActivityViewHolder$fillViewAndBindClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                j.a.b(j.f12156c, ClubChatActivityViewHolder.this.itemView.getContext(), clubChatMsgModel.getJumpUrl(), null, 4, null);
            }
        });
        t(clubChatActivityLayout, clubChatMsgModel);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        ArrayList<LongClickActionType> arrayList = new ArrayList<>();
        if (model.hasSender()) {
            arrayList.add(LongClickActionType.Quote);
        }
        arrayList.add(LongClickActionType.Delete);
        return arrayList;
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void y(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        ClubChatActivityLayout clubChatActivityLayout = (ClubChatActivityLayout) this.itemView.findViewById(R$id.club_left_activity_layout);
        s.h(clubChatActivityLayout, "itemView.club_left_activity_layout");
        F(clubChatActivityLayout, model);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void z(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        ClubChatActivityLayout clubChatActivityLayout = (ClubChatActivityLayout) this.itemView.findViewById(R$id.club_right_activity_layout);
        s.h(clubChatActivityLayout, "itemView.club_right_activity_layout");
        F(clubChatActivityLayout, model);
    }
}
