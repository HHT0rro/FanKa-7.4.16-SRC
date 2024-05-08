package com.cupidapp.live.profile.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.profile.adapter.FriendPraiseDetailPageType;
import com.cupidapp.live.profile.model.FriendPraiseDetailModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.m;
import z0.z;

/* compiled from: FriendPraiseDetailViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseDetailViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17808d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FKPointerDialog f17809c;

    /* compiled from: FriendPraiseDetailViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FriendPraiseDetailViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FriendPraiseDetailViewHolder(z.b(parent, R$layout.view_holder_friend_praise_detail, false, 2, null));
        }
    }

    /* compiled from: FriendPraiseDetailViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17810a;

        static {
            int[] iArr = new int[FriendPraiseDetailPageType.values().length];
            try {
                iArr[FriendPraiseDetailPageType.RECEIVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FriendPraiseDetailPageType.SEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FriendPraiseDetailPageType.PRAISE_DETAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f17810a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendPraiseDetailViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final void u(FriendPraiseDetailViewHolder this$0, ImageView imageView) {
        s.i(this$0, "this$0");
        FKPointerDialog.a aVar = FKPointerDialog.f12718p;
        Context context = this$0.itemView.getContext();
        s.h(context, "itemView.context");
        FKPointerDialog a10 = aVar.a(context);
        String string = this$0.itemView.getContext().getString(R$string.set_profile_show);
        s.h(string, "itemView.context.getStri….string.set_profile_show)");
        FKPointerDialog j10 = a10.n(string).q(PointerPos.TOP_RIGHT, BgColor.DEFAULT).m(false).j(Float.valueOf(0.0f));
        this$0.f17809c = j10;
        if (j10 != null) {
            FKPointerDialog.y(j10, imageView, -h.c(this$0, 17.0f), h.c(this$0, 4.0f), 0, 8, null);
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FriendPraiseDetailModel) {
            FriendPraiseDetailModel friendPraiseDetailModel = (FriendPraiseDetailModel) obj;
            int i10 = b.f17810a[friendPraiseDetailModel.getPageType().ordinal()];
            if (i10 == 1) {
                ((TextView) this.itemView.findViewById(R$id.send_friend_praise_start_text)).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.send_friend_praise_end_text)).setVisibility(8);
                ((ImageView) this.itemView.findViewById(R$id.send_friend_praise_anonymous_img)).setVisibility(8);
                if (s.d(friendPraiseDetailModel.getHomePageDisplay(), Boolean.TRUE)) {
                    ((TextView) this.itemView.findViewById(R$id.praise_detail_show_in_profile_view)).setVisibility(0);
                } else {
                    ((TextView) this.itemView.findViewById(R$id.praise_detail_show_in_profile_view)).setVisibility(8);
                }
            } else if (i10 == 2) {
                ((TextView) this.itemView.findViewById(R$id.send_friend_praise_start_text)).setVisibility(0);
                ((TextView) this.itemView.findViewById(R$id.send_friend_praise_end_text)).setVisibility(0);
                ImageView imageView = (ImageView) this.itemView.findViewById(R$id.send_friend_praise_anonymous_img);
                s.h(imageView, "itemView.send_friend_praise_anonymous_img");
                imageView.setVisibility(s.d(friendPraiseDetailModel.getAnonymous(), Boolean.TRUE) ? 0 : 8);
                ((TextView) this.itemView.findViewById(R$id.praise_detail_show_in_profile_view)).setVisibility(8);
            } else if (i10 == 3) {
                ((TextView) this.itemView.findViewById(R$id.send_friend_praise_start_text)).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.send_friend_praise_end_text)).setVisibility(8);
                ((ImageView) this.itemView.findViewById(R$id.send_friend_praise_anonymous_img)).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.praise_detail_show_in_profile_view)).setVisibility(8);
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.praise_detail_user_avatar_img);
            s.h(imageLoaderView, "itemView.praise_detail_user_avatar_img");
            ImageLoaderView.g(imageLoaderView, friendPraiseDetailModel.getUserIcon(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.praise_detail_user_name_text)).setText(friendPraiseDetailModel.getUsername());
            int likeCount = friendPraiseDetailModel.getLikeCount();
            Context context = this.itemView.getContext();
            s.h(context, "itemView.context");
            String e2 = m.e(likeCount, context);
            View view = this.itemView;
            int i11 = R$id.praise_detail_praise_count_text;
            ((TextView) view.findViewById(i11)).setText(e2);
            if (s.d(friendPraiseDetailModel.getLiked(), Boolean.TRUE)) {
                ((ImageView) this.itemView.findViewById(R$id.praise_detail_praise_img)).setImageResource(R$mipmap.icon_friend_praise_detail_liked);
                ((TextView) this.itemView.findViewById(i11)).setTextColor(-49088);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.praise_detail_praise_img)).setImageResource(R$mipmap.icon_friend_praise_detail_un_liked);
                ((TextView) this.itemView.findViewById(i11)).setTextColor(com.cupidapp.live.base.utils.h.a(-16777216, 0.4f));
            }
            ((TextView) this.itemView.findViewById(R$id.praise_detail_content_text)).setText(friendPraiseDetailModel.getContent());
            t(friendPraiseDetailModel);
        }
    }

    public final void s() {
        FKPointerDialog fKPointerDialog = this.f17809c;
        if (fKPointerDialog != null) {
            fKPointerDialog.g(false);
        }
        this.f17809c = null;
    }

    public final void t(FriendPraiseDetailModel friendPraiseDetailModel) {
        final ImageView imageView = (ImageView) this.itemView.findViewById(R$id.praise_detail_more_img);
        if (imageView.getVisibility() == 0) {
            g gVar = g.f52734a;
            Boolean Q0 = gVar.Q0();
            Boolean bool = Boolean.FALSE;
            if (s.d(Q0, bool) || friendPraiseDetailModel.getPageType() != FriendPraiseDetailPageType.RECEIVED) {
                return;
            }
            gVar.h3(bool);
            imageView.post(new Runnable() { // from class: com.cupidapp.live.profile.holder.a
                @Override // java.lang.Runnable
                public final void run() {
                    FriendPraiseDetailViewHolder.u(FriendPraiseDetailViewHolder.this, imageView);
                }
            });
        }
    }
}
