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
import com.cupidapp.live.maskparty.activity.ChatLookImageActivity;
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

/* compiled from: ClubChatImageViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatImageViewHolder extends BaseClubChatViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13685d = new a(null);

    /* compiled from: ClubChatImageViewHolder.kt */
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
            return new ClubChatImageViewHolder(z.b(parent, z10 ? R$layout.view_holder_club_chat_image_right : R$layout.view_holder_club_chat_image_left, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatImageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ImageLoaderView A() {
        return (ImageLoaderView) this.itemView.findViewById(R$id.club_left_image_avatar_image);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ClubChatLeftUserInfoLayout B() {
        return (ClubChatLeftUserInfoLayout) this.itemView.findViewById(R$id.club_left_image_user_info_layout);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatMessageStateView C() {
        return (ChatMessageStateView) this.itemView.findViewById(R$id.club_right_image_message_state_view);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ChatTimeStampView D() {
        return (ChatTimeStampView) this.itemView.findViewById(R$id.club_chat_image_time_stamp_view);
    }

    public final void F(ImageLoaderView imageLoaderView, final ClubChatMsgModel clubChatMsgModel) {
        String imagePath = clubChatMsgModel.getImagePath();
        if (!(imagePath == null || imagePath.length() == 0)) {
            ImageLoaderView.f(imageLoaderView, new com.cupidapp.live.base.imageloader.b(false, clubChatMsgModel.getImagePath(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        } else if (clubChatMsgModel.getImage() != null) {
            ImageLoaderView.g(imageLoaderView, clubChatMsgModel.getImage(), null, null, 6, null);
        }
        y.d(imageLoaderView, new Function1<View, p>() { // from class: com.cupidapp.live.club.viewholder.ClubChatImageViewHolder$fillViewAndBindClickEvent$1
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
                ChatLookImageActivity.f16224r.a(ClubChatImageViewHolder.this.itemView.getContext(), clubChatMsgModel.assembleChatLookImageData());
            }
        });
        t(imageLoaderView, clubChatMsgModel);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    @Nullable
    public ArrayList<LongClickActionType> v(@NotNull ClubChatMsgModel model) {
        ArrayList<LongClickActionType> arrayList;
        s.i(model, "model");
        if (model.getMine()) {
            arrayList = new ArrayList<>();
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
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.club_left_image_content_image);
        s.h(imageLoaderView, "itemView.club_left_image_content_image");
        F(imageLoaderView, model);
    }

    @Override // com.cupidapp.live.club.viewholder.BaseClubChatViewHolder
    public void z(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.club_right_image_content_image);
        s.h(imageLoaderView, "itemView.club_right_image_content_image");
        F(imageLoaderView, model);
    }
}
