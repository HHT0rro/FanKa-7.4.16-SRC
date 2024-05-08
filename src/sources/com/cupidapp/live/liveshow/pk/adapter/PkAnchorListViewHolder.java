package com.cupidapp.live.liveshow.pk.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInviteStatus;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: PkAnchorListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PkAnchorListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15108c = new a(null);

    /* compiled from: PkAnchorListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PkAnchorListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new PkAnchorListViewHolder(z.b(parent, R$layout.view_holder_pk_anchor_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PkAnchorListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.friend_tab_txt);
        s.h(textView, "itemView.friend_tab_txt");
        u.a(textView);
    }

    public static /* synthetic */ void s(PkAnchorListViewHolder pkAnchorListViewHolder, int i10, int i11, int i12, Integer num, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            num = null;
        }
        pkAnchorListViewHolder.r(i10, i11, i12, num);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MultiPkAnchorModel) {
            if (getAbsoluteAdapterPosition() == 0) {
                View itemView = this.itemView;
                s.h(itemView, "itemView");
                y.m(itemView, null, Integer.valueOf(h.c(this, 4.0f)), null, null, 13, null);
            } else {
                View itemView2 = this.itemView;
                s.h(itemView2, "itemView");
                y.m(itemView2, null, 0, null, null, 13, null);
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.anchor_img);
            s.h(imageLoaderView, "itemView.anchor_img");
            MultiPkAnchorModel multiPkAnchorModel = (MultiPkAnchorModel) obj;
            ImageLoaderView.g(imageLoaderView, multiPkAnchorModel.getUser().getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.friend_tab_txt)).setVisibility(multiPkAnchorModel.getUser().getMatch() ? 0 : 8);
            ((TextView) this.itemView.findViewById(R$id.anchor_name_txt)).setText(multiPkAnchorModel.getUser().getName());
            String inviteStatus = multiPkAnchorModel.getInviteStatus();
            if (s.d(inviteStatus, MultiPkInviteStatus.None.getStatus())) {
                s(this, R$string.issue_a_challenge, R$drawable.rect_cor_100_sd_ff4040, -1, null, 8, null);
                return;
            }
            if (s.d(inviteStatus, MultiPkInviteStatus.Wait.getStatus())) {
                r(R$string.cancel_inviting, R$drawable.rect_cor_100_sd_33ffffff, -1, Integer.valueOf(R$string.wait_for_response));
                return;
            }
            if (s.d(inviteStatus, MultiPkInviteStatus.Accept.getStatus())) {
                s(this, R$string.invite_success, R$drawable.rect_cor_100_sd_33ffffff, com.cupidapp.live.base.utils.h.a(-1, 0.4f), null, 8, null);
            } else if (s.d(inviteStatus, MultiPkInviteStatus.Refuse.getStatus())) {
                r(R$string.try_again, R$drawable.rect_cor_100_sd_ff4040, -1, Integer.valueOf(R$string.other_has_refused));
            } else if (s.d(inviteStatus, MultiPkInviteStatus.TimeOut.getStatus())) {
                r(R$string.try_again, R$drawable.rect_cor_100_sd_ff4040, -1, Integer.valueOf(R$string.other_did_not_respond));
            }
        }
    }

    public final void r(int i10, int i11, int i12, Integer num) {
        TextView textView = (TextView) this.itemView.findViewById(R$id.invite_btn);
        textView.setText(this.itemView.getContext().getString(i10));
        textView.setBackgroundResource(i11);
        textView.setTextColor(i12);
        if (num == null) {
            ((TextView) this.itemView.findViewById(R$id.invite_status_txt)).setVisibility(8);
            return;
        }
        View view = this.itemView;
        int i13 = R$id.invite_status_txt;
        ((TextView) view.findViewById(i13)).setVisibility(0);
        ((TextView) this.itemView.findViewById(i13)).setText(this.itemView.getContext().getString(num.intValue()));
    }
}
