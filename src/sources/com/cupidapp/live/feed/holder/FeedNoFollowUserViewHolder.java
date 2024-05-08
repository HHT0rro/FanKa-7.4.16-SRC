package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.FeedAlohaGuideModel;
import com.cupidapp.live.feed.model.FeedModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: FeedNoFollowUserViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedNoFollowUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14384c = new a(null);

    /* compiled from: FeedNoFollowUserViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedNoFollowUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedNoFollowUserViewHolder(z.b(parent, R$layout.item_no_follwed_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedNoFollowUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedAlohaGuideModel) {
            FeedModel feedModel = ((FeedAlohaGuideModel) obj).getFeedModel();
            String buttonText = feedModel.getButtonText();
            boolean z10 = true;
            if (buttonText == null || buttonText.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.no_follow_btn)).setVisibility(8);
            } else {
                View view = this.itemView;
                int i10 = R$id.no_follow_btn;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                TextView textView = (TextView) this.itemView.findViewById(i10);
                s.h(textView, "itemView.no_follow_btn");
                u.a(textView);
                ((TextView) this.itemView.findViewById(i10)).setText(feedModel.getButtonText());
            }
            ((TextView) this.itemView.findViewById(R$id.no_follow_title)).setText(feedModel.getTitle());
            String description = feedModel.getDescription();
            if (description != null && description.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) this.itemView.findViewById(R$id.no_follow_des)).setVisibility(8);
            } else {
                View view2 = this.itemView;
                int i11 = R$id.no_follow_des;
                ((TextView) view2.findViewById(i11)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).setText(feedModel.getDescription());
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.no_follow_img);
            s.h(imageLoaderView, "itemView.no_follow_img");
            ImageLoaderView.g(imageLoaderView, feedModel.getImage(), null, null, 6, null);
        }
    }
}
