package com.cupidapp.live.chat.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.PromotionNearGuideLayout;
import com.cupidapp.live.chat.adapter.ChatFriendUserAdapter;
import com.cupidapp.live.chat.event.ClickChatSuperBoostEntranceEvent;
import com.cupidapp.live.chat.event.OpenChatStateEvent;
import com.cupidapp.live.chat.event.OpenChatWindowEvent;
import com.cupidapp.live.chat.model.ChatMatchUIModel;
import com.cupidapp.live.chat.model.ChatSessionTitleUIModel;
import com.cupidapp.live.chat.service.ChatStateEntranceModel;
import com.cupidapp.live.chat.service.ClubEntranceModel;
import com.cupidapp.live.chat.service.SuperBoostEntranceModel;
import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ChatSessionTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSessionTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13247d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f13248c;

    /* compiled from: ChatSessionTitleViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatSessionTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatSessionTitleViewHolder(z.b(parent, R$layout.item_chat_session_title, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSessionTitleViewHolder(@NotNull final View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f13248c = c.b(new Function0<ChatFriendUserAdapter>() { // from class: com.cupidapp.live.chat.viewholder.ChatSessionTitleViewHolder$matchUserAdapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChatFriendUserAdapter invoke() {
                RecyclerView recyclerView = (RecyclerView) View.this.findViewById(R$id.new_match_user_recyclerView);
                s.h(recyclerView, "itemView.new_match_user_recyclerView");
                final ChatFriendUserAdapter chatFriendUserAdapter = new ChatFriendUserAdapter(recyclerView);
                final ChatSessionTitleViewHolder chatSessionTitleViewHolder = this;
                chatFriendUserAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.viewholder.ChatSessionTitleViewHolder$matchUserAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof NewMatchUserModel) {
                            ChatSessionTitleViewHolder.this.t(((NewMatchUserModel) obj).getUser(), chatFriendUserAdapter.j().indexOf(obj));
                        } else if (obj instanceof ChatStateEntranceModel) {
                            EventBus.c().l(new OpenChatStateEvent());
                        } else if (obj instanceof SuperBoostEntranceModel) {
                            EventBus.c().l(new ClickChatSuperBoostEntranceEvent(((SuperBoostEntranceModel) obj).getUrl()));
                        }
                    }
                });
                return chatFriendUserAdapter;
            }
        });
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatSessionTitleUIModel) {
            View view = this.itemView;
            int i10 = R$id.new_match_user_recyclerView;
            boolean z10 = false;
            if (((RecyclerView) view.findViewById(i10)).getAdapter() == null) {
                RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(i10);
                recyclerView.setAdapter(s());
                recyclerView.setLayoutManager(new LinearLayoutManager(this.itemView.getContext(), 0, false));
                RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
                SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
                if (simpleItemAnimator != null) {
                    simpleItemAnimator.setSupportsChangeAnimations(false);
                }
            }
            ChatSessionTitleUIModel chatSessionTitleUIModel = (ChatSessionTitleUIModel) obj;
            u(chatSessionTitleUIModel.getGuide());
            w(chatSessionTitleUIModel.getMatchUserModel());
            ChatMatchUIModel matchUserModel = chatSessionTitleUIModel.getMatchUserModel();
            List<Object> userList = matchUserModel != null ? matchUserModel.getUserList() : null;
            if (userList == null || userList.isEmpty()) {
                ChatMatchUIModel matchUserModel2 = chatSessionTitleUIModel.getMatchUserModel();
                if ((matchUserModel2 != null ? matchUserModel2.getSuperBoostEntrance() : null) == null) {
                    z10 = true;
                }
            }
            v(z10, chatSessionTitleUIModel.getClubEntrance());
            y(chatSessionTitleUIModel.getShowPushStatus());
            x(chatSessionTitleUIModel.getStealthMessage());
        }
    }

    public final ChatFriendUserAdapter s() {
        return (ChatFriendUserAdapter) this.f13248c.getValue();
    }

    public final void t(User user, int i10) {
        user.setNewMatch(false);
        if (i10 >= 0 && i10 < s().getItemCount()) {
            s().notifyItemChanged(i10);
        }
        EventBus.c().l(new OpenChatWindowEvent(user));
        GroupSocialLog.f18708a.u(SensorScene.NewMatchList.getValue(), user.userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
    }

    public final void u(PromotionNearByGuideModel promotionNearByGuideModel) {
        if (promotionNearByGuideModel != null) {
            View view = this.itemView;
            int i10 = R$id.chat_promotion_near_guide;
            ((PromotionNearGuideLayout) view.findViewById(i10)).setVisibility(0);
            ((PromotionNearGuideLayout) this.itemView.findViewById(i10)).b(promotionNearByGuideModel, SensorPosition.Message);
            return;
        }
        ((PromotionNearGuideLayout) this.itemView.findViewById(R$id.chat_promotion_near_guide)).setVisibility(8);
    }

    public final void v(boolean z10, ClubEntranceModel clubEntranceModel) {
        String string;
        View view = this.itemView;
        int i10 = R$id.message_title_text;
        ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
        View view2 = this.itemView;
        int i11 = R$id.chat_all_match_text;
        ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(true);
        g gVar = g.f52734a;
        if (gVar.k() > 0) {
            string = this.itemView.getContext().getString(R$string.messages_count, Integer.valueOf(gVar.k()));
        } else {
            string = this.itemView.getContext().getString(R$string.messages);
        }
        s.h(string, "if (LocalStore.chatUnrea…tring.messages)\n        }");
        ((TextView) this.itemView.findViewById(i10)).setText(string);
        ((TextView) this.itemView.findViewById(i11)).setVisibility(z10 ? 0 : 8);
        if ((clubEntranceModel != null ? clubEntranceModel.getIcon() : null) != null) {
            View view3 = this.itemView;
            int i12 = R$id.club_entrance_imageview;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view3.findViewById(i12);
            s.h(imageLoaderView, "itemView.club_entrance_imageview");
            imageLoaderView.setVisibility(0);
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i12);
            s.h(imageLoaderView2, "itemView.club_entrance_imageview");
            ImageLoaderView.g(imageLoaderView2, clubEntranceModel.getIcon(), null, null, 6, null);
            int scaleWidthByHeight = clubEntranceModel.getIcon().getScaleWidthByHeight(h.c(this, 24.0f));
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(i12);
            s.h(imageLoaderView3, "itemView.club_entrance_imageview");
            y.o(imageLoaderView3, Integer.valueOf(scaleWidthByHeight), null, 2, null);
            return;
        }
        ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(R$id.club_entrance_imageview);
        s.h(imageLoaderView4, "itemView.club_entrance_imageview");
        imageLoaderView4.setVisibility(8);
    }

    public final void w(ChatMatchUIModel chatMatchUIModel) {
        String string;
        List<Object> userList;
        if (!((chatMatchUIModel == null || (userList = chatMatchUIModel.getUserList()) == null || !(userList.isEmpty() ^ true)) ? false : true)) {
            if ((chatMatchUIModel != null ? chatMatchUIModel.getSuperBoostEntrance() : null) == null) {
                this.itemView.findViewById(R$id.chat_match).setVisibility(8);
                return;
            }
        }
        View view = this.itemView;
        int i10 = R$id.new_match_title_text;
        ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
        ((TextView) this.itemView.findViewById(R$id.all_match_text)).getPaint().setFakeBoldText(true);
        this.itemView.findViewById(R$id.chat_match).setVisibility(0);
        s().j().clear();
        SuperBoostEntranceModel superBoostEntrance = chatMatchUIModel.getSuperBoostEntrance();
        if (superBoostEntrance != null) {
            s().d(superBoostEntrance);
        }
        List<Object> userList2 = chatMatchUIModel.getUserList();
        if (userList2 != null && (userList2.isEmpty() ^ true)) {
            s().e(chatMatchUIModel.getUserList());
        }
        s().notifyDataSetChanged();
        ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
        g gVar = g.f52734a;
        if (gVar.L() > 0) {
            string = this.itemView.getContext().getString(R$string.new_match_count, Integer.valueOf(gVar.L()));
        } else {
            string = this.itemView.getContext().getString(R$string.new_match);
        }
        s.h(string, "if (LocalStore.inboxNewM….new_match)\n            }");
        ((TextView) this.itemView.findViewById(i10)).setText(string);
    }

    public final void x(boolean z10) {
        this.itemView.findViewById(R$id.chat_msg_private).setVisibility(z10 ? 0 : 8);
    }

    public final void y(boolean z10) {
        this.itemView.findViewById(R$id.chat_push_tip).setVisibility(z10 ? 0 : 8);
    }

    public final void z() {
        ((RecyclerView) this.itemView.findViewById(R$id.new_match_user_recyclerView)).scrollToPosition(0);
    }
}
