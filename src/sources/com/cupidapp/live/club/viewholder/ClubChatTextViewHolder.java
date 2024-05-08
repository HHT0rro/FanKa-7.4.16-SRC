package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$array;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.MessageUiType;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatQuoteMessageLayout;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.club.helper.ClubChatViewHolderFactory;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.view.ClubChatLeftUserInfoLayout;
import java.util.ArrayList;
import kotlin.collections.m;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q1.e;
import z0.h;
import z0.t;
import z0.y;
import z0.z;

/* compiled from: ClubChatTextViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatTextViewHolder extends BaseClubChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13689d = new a(null);

    /* compiled from: ClubChatTextViewHolder.kt */
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
            return new ClubChatTextViewHolder(z.b(parent, z10 ? R$layout.view_holder_club_chat_text_right : R$layout.view_holder_club_chat_text_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatTextViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.club_left_text_avatar_image);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ClubChatLeftUserInfoLayout B() {
        return (ClubChatLeftUserInfoLayout) this.itemView.findViewById(R$id.club_left_text_user_info_layout);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatMessageStateView C() {
        return (ChatMessageStateView) this.itemView.findViewById(R$id.club_right_text_message_state_view);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatTimeStampView D() {
        return (ChatTimeStampView) this.itemView.findViewById(R$id.club_chat_text_time_stamp_view);
    }

    public final void F(ClubChatMsgModel clubChatMsgModel, TextView textView, TextView textView2, ImageView imageView, ClubChatLeftUserInfoLayout clubChatLeftUserInfoLayout, ChatQuoteMessageLayout chatQuoteMessageLayout) {
        textView.setVisibility(8);
        textView2.setVisibility(8);
        imageView.setVisibility(8);
        int a10 = w1.a.f54094a.a(clubChatMsgModel.getText());
        if (a10 != -1) {
            imageView.setVisibility(0);
            imageView.setImageResource(a10);
            if (clubChatLeftUserInfoLayout != null) {
                y.m(clubChatLeftUserInfoLayout, 0, null, null, null, 14, null);
            }
        } else if (H(clubChatMsgModel.getText())) {
            textView2.setVisibility(0);
            textView2.setText(clubChatMsgModel.getText());
            if (clubChatLeftUserInfoLayout != null) {
                y.m(clubChatLeftUserInfoLayout, 0, null, null, null, 14, null);
            }
        } else {
            textView.setVisibility(0);
            G(textView, clubChatMsgModel.getText());
            if (clubChatLeftUserInfoLayout != null) {
                y.m(clubChatLeftUserInfoLayout, Integer.valueOf(h.c(this, 10.0f)), null, null, null, 14, null);
            }
        }
        if (clubChatMsgModel.getQuoteInfo() == null) {
            chatQuoteMessageLayout.setVisibility(8);
        } else {
            chatQuoteMessageLayout.setVisibility(0);
            chatQuoteMessageLayout.b(clubChatMsgModel.getQuoteInfo());
        }
    }

    public final void G(TextView textView, final String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        e.f53007a.a(textView, str, Integer.valueOf(textView.getCurrentTextColor()), new Function1<String, p>() { // from class: com.cupidapp.live.club.viewholder.ClubChatTextViewHolder$handleHyperLink$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str2) {
                invoke2(str2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String url) {
                s.i(url, "url");
                j1.e.f50230a.a(String.this, url, MessageUiType.OnlyText.getValue());
                j.a.b(j.f12156c, this.itemView.getContext(), url, null, 4, null);
            }
        });
    }

    public final boolean H(String str) {
        if (str == null || str.length() > 2 || !t.b(str)) {
            return false;
        }
        String[] stringArray = this.itemView.getContext().getResources().getStringArray(R$array.emoji_face);
        s.h(stringArray, "itemView.context.resourc…Array(R.array.emoji_face)");
        return m.t(stringArray, str);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ClubChatMsgModel model) {
        ArrayList<LongClickActionType> arrayList;
        s.i(model, "model");
        if (model.getMine()) {
            arrayList = new ArrayList<>();
            arrayList.add(LongClickActionType.Copy);
            String messageId = model.getMessageId();
            if (!(messageId == null || messageId.length() == 0)) {
                if (model.hasSender()) {
                    arrayList.add(LongClickActionType.Quote);
                }
                if (model.less2Min()) {
                    arrayList.add(LongClickActionType.Cancel);
                }
                arrayList.add(LongClickActionType.Delete);
            }
        } else {
            arrayList = new ArrayList<>();
            arrayList.add(LongClickActionType.Copy);
            if (model.hasSender()) {
                arrayList.add(LongClickActionType.Quote);
            }
            arrayList.add(LongClickActionType.Delete);
            arrayList.add(LongClickActionType.Report);
        }
        return arrayList;
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void y(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        View view = this.itemView;
        int i10 = R$id.club_left_text_bubble_text_view;
        TextView textView = (TextView) view.findViewById(i10);
        s.h(textView, "itemView.club_left_text_bubble_text_view");
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.club_left_text_single_emoji_text);
        s.h(textView2, "itemView.club_left_text_single_emoji_text");
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.club_left_text_emoji_image);
        s.h(imageView, "itemView.club_left_text_emoji_image");
        ClubChatLeftUserInfoLayout clubChatLeftUserInfoLayout = (ClubChatLeftUserInfoLayout) this.itemView.findViewById(R$id.club_left_text_user_info_layout);
        ChatQuoteMessageLayout chatQuoteMessageLayout = (ChatQuoteMessageLayout) this.itemView.findViewById(R$id.club_left_text_quote_msg_layout);
        s.h(chatQuoteMessageLayout, "itemView.club_left_text_quote_msg_layout");
        F(model, textView, textView2, imageView, clubChatLeftUserInfoLayout, chatQuoteMessageLayout);
        FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.club_left_text_content_frame_layout);
        s.h(frameLayout, "itemView.club_left_text_content_frame_layout");
        t(frameLayout, model);
        TextView textView3 = (TextView) this.itemView.findViewById(i10);
        s.h(textView3, "itemView.club_left_text_bubble_text_view");
        t(textView3, model);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void z(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        View view = this.itemView;
        int i10 = R$id.club_right_text_bubble_text_view;
        TextView textView = (TextView) view.findViewById(i10);
        s.h(textView, "itemView.club_right_text_bubble_text_view");
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.club_right_text_single_emoji_text);
        s.h(textView2, "itemView.club_right_text_single_emoji_text");
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.club_right_text_emoji_image);
        s.h(imageView, "itemView.club_right_text_emoji_image");
        ChatQuoteMessageLayout chatQuoteMessageLayout = (ChatQuoteMessageLayout) this.itemView.findViewById(R$id.club_right_text_quote_msg_layout);
        s.h(chatQuoteMessageLayout, "itemView.club_right_text_quote_msg_layout");
        F(model, textView, textView2, imageView, null, chatQuoteMessageLayout);
        FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.club_right_text_content_frame_layout);
        s.h(frameLayout, "itemView.club_right_text_content_frame_layout");
        t(frameLayout, model);
        TextView textView3 = (TextView) this.itemView.findViewById(i10);
        s.h(textView3, "itemView.club_right_text_bubble_text_view");
        t(textView3, model);
    }
}
