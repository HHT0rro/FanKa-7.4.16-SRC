package com.cupidapp.live.club.viewholder;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.chat2.model.ChatClickReEditBtnEvent;
import com.cupidapp.live.chat2.model.ChatNoticeBtnType;
import com.cupidapp.live.chat2.model.LongClickActionType;
import com.cupidapp.live.chat2.view.ChatMessageStateView;
import com.cupidapp.live.chat2.view.ChatTimeStampView;
import com.cupidapp.live.club.helper.ClubChatViewHolderFactory;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.view.ClubChatLeftUserInfoLayout;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ClubChatNoticeViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatNoticeViewHolder extends BaseClubChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13686d = new a(null);

    /* compiled from: ClubChatNoticeViewHolder.kt */
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
            return new ClubChatNoticeViewHolder(z.b(parent, R$layout.view_holder_club_chat_notice, false, 2, null));
        }
    }

    /* compiled from: ClubChatNoticeViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends h0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClubChatMsgModel f13687b;

        public b(ClubChatMsgModel clubChatMsgModel) {
            this.f13687b = clubChatMsgModel;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            EventBus.c().l(new ChatClickReEditBtnEvent(this.f13687b.getCancelMsgText()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatNoticeViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return null;
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ClubChatLeftUserInfoLayout B() {
        return null;
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatMessageStateView C() {
        return null;
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatTimeStampView D() {
        return null;
    }

    public final void F(ClubChatMsgModel clubChatMsgModel) {
        SpannableStringBuilder c4;
        if (clubChatMsgModel.getNoticeBtnType() == ChatNoticeBtnType.RE_EDIT) {
            String string = this.itemView.getContext().getString(R$string.reedit);
            s.h(string, "itemView.context.getString(R.string.reedit)");
            c4 = q1.d.f53006a.c(clubChatMsgModel.getText() + " " + string, kotlin.collections.s.o(string), (r18 & 4) != 0 ? null : -16084993, (r18 & 8) != 0 ? null : -1, (r18 & 16) != 0 ? false : true, (r18 & 32) != 0 ? null : kotlin.collections.s.o(new b(clubChatMsgModel)), (r18 & 64) != 0 ? null : null);
            ((TextView) this.itemView.findViewById(R$id.club_chat_notice_text_view)).setText(c4);
        } else {
            ((TextView) this.itemView.findViewById(R$id.club_chat_notice_text_view)).setText(clubChatMsgModel.getText());
        }
        ((TextView) this.itemView.findViewById(R$id.club_chat_notice_text_view)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        return null;
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void y(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        F(model);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void z(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        F(model);
    }
}