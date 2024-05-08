package com.cupidapp.live.chat.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ChatRecommendViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatRecommendViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13245d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public int f13246c;

    /* compiled from: ChatRecommendViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChatRecommendViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ChatRecommendViewHolder(z.b(parent, R$layout.view_holder_chat_recommend, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRecommendViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ChatRecommendImageUiModel) {
            ChatRecommendImageUiModel chatRecommendImageUiModel = (ChatRecommendImageUiModel) obj;
            v(chatRecommendImageUiModel);
            ((TopIndicatorLayout) this.itemView.findViewById(R$id.chat_recommend_top_indicator)).setPagerCount(chatRecommendImageUiModel.getImageList().size());
            u(chatRecommendImageUiModel);
        }
    }

    public final void u(final ChatRecommendImageUiModel chatRecommendImageUiModel) {
        View findViewById = this.itemView.findViewById(R$id.chat_recommend_left_click_view);
        s.h(findViewById, "itemView.chat_recommend_left_click_view");
        y.d(findViewById, new Function1<View, p>() { // from class: com.cupidapp.live.chat.viewholder.ChatRecommendViewHolder$bindClickEvent$1
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
                int i10;
                int i11;
                i10 = ChatRecommendViewHolder.this.f13246c;
                if (i10 >= 1) {
                    ChatRecommendViewHolder chatRecommendViewHolder = ChatRecommendViewHolder.this;
                    i11 = chatRecommendViewHolder.f13246c;
                    chatRecommendViewHolder.f13246c = i11 - 1;
                    ChatRecommendViewHolder.this.v(chatRecommendImageUiModel);
                }
            }
        });
        View findViewById2 = this.itemView.findViewById(R$id.chat_recommend_right_click_view);
        s.h(findViewById2, "itemView.chat_recommend_right_click_view");
        y.d(findViewById2, new Function1<View, p>() { // from class: com.cupidapp.live.chat.viewholder.ChatRecommendViewHolder$bindClickEvent$2
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
                int i10;
                int i11;
                i10 = ChatRecommendViewHolder.this.f13246c;
                if (i10 < chatRecommendImageUiModel.getImageList().size() - 1) {
                    ChatRecommendViewHolder chatRecommendViewHolder = ChatRecommendViewHolder.this;
                    i11 = chatRecommendViewHolder.f13246c;
                    chatRecommendViewHolder.f13246c = i11 + 1;
                    ChatRecommendViewHolder.this.v(chatRecommendImageUiModel);
                }
            }
        });
    }

    public final void v(ChatRecommendImageUiModel chatRecommendImageUiModel) {
        int i10 = this.f13246c;
        if (i10 >= 0 && i10 < chatRecommendImageUiModel.getImageList().size()) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.chat_recommend_avatar_img);
            s.h(imageLoaderView, "itemView.chat_recommend_avatar_img");
            ImageLoaderView.g(imageLoaderView, chatRecommendImageUiModel.getImageList().get(this.f13246c), null, null, 6, null);
            ((TopIndicatorLayout) this.itemView.findViewById(R$id.chat_recommend_top_indicator)).setCurrentPager(this.f13246c);
            return;
        }
        ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.chat_recommend_avatar_img);
        s.h(imageLoaderView2, "itemView.chat_recommend_avatar_img");
        ImageLoaderView.f(imageLoaderView2, new b(false, null, null, null, null, null, null, -1, 0, null, null, null, null, false, 0, 0, false, null, null, 524159, null), null, 2, null);
    }
}
