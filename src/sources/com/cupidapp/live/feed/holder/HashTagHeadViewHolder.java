package com.cupidapp.live.feed.holder;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.base.web.WebStyleEnum;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.hashtag.model.HashTag;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: HashTagHeadViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagHeadViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14395c = new a(null);

    /* compiled from: HashTagHeadViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashTagHeadViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            HashTagHeadViewHolder hashTagHeadViewHolder = new HashTagHeadViewHolder(z.b(parent, R$layout.view_holder_hashtag_headview, false, 2, null));
            hashTagHeadViewHolder.q();
            return hashTagHeadViewHolder;
        }
    }

    /* compiled from: HashTagHeadViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends h0 {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f14397c;

        public b(Object obj) {
            this.f14397c = obj;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            HashTagHeadViewHolder.this.s((HashTag) this.f14397c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashTagHeadViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        SpannableStringBuilder c4;
        if (obj instanceof HashTag) {
            HashTag hashTag = (HashTag) obj;
            if (hashTag.getBackgroundImage() != null) {
                int scaleHeightByWidth = hashTag.getBackgroundImage().getScaleHeightByWidth(z0.h.l(this));
                FKWebpAnimationView fKWebpAnimationView = (FKWebpAnimationView) this.itemView.findViewById(R$id.head_animation_view);
                s.h(fKWebpAnimationView, "itemView.head_animation_view");
                y.o(fKWebpAnimationView, null, Integer.valueOf(scaleHeightByWidth), 1, null);
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.head_imageview);
                s.h(imageLoaderView, "itemView.head_imageview");
                y.o(imageLoaderView, null, Integer.valueOf(scaleHeightByWidth), 1, null);
                t(hashTag.getPresetImageKey(), hashTag.getBackgroundImage());
            }
            if (hashTag.getUserCount() < 20) {
                ((TextView) this.itemView.findViewById(R$id.hashTagUserCount)).setVisibility(8);
            } else {
                ((TextView) this.itemView.findViewById(R$id.hashTagUserCount)).setText(this.itemView.getContext().getString(R$string.hash_tag_user_count, Integer.valueOf(hashTag.getUserCount())));
            }
            FKWebpAnimationView fKWebpAnimationView2 = (FKWebpAnimationView) this.itemView.findViewById(R$id.head_animation_view);
            s.h(fKWebpAnimationView2, "itemView.head_animation_view");
            y.d(fKWebpAnimationView2, new Function1<View, p>() { // from class: com.cupidapp.live.feed.holder.HashTagHeadViewHolder$config$2
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
                    HashTagHeadViewHolder.this.s((HashTag) obj);
                }
            });
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.head_imageview);
            s.h(imageLoaderView2, "itemView.head_imageview");
            y.d(imageLoaderView2, new Function1<View, p>() { // from class: com.cupidapp.live.feed.holder.HashTagHeadViewHolder$config$3
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
                    HashTagHeadViewHolder.this.s((HashTag) obj);
                }
            });
            if (!TextUtils.isEmpty(hashTag.getUrl())) {
                String string = this.itemView.getContext().getString(R$string.url);
                s.h(string, "itemView.context.getString(R.string.url)");
                c4 = q1.d.f53006a.c(hashTag.getSummary() + "  " + string, kotlin.collections.s.o(string), (r18 & 4) != 0 ? null : -49088, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : kotlin.collections.s.o(new b(obj)), (r18 & 64) != 0 ? null : null);
                View view = this.itemView;
                int i10 = R$id.headSummary;
                ((TextView) view.findViewById(i10)).setText(c4);
                ((TextView) this.itemView.findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
            ((TextView) this.itemView.findViewById(R$id.headSummary)).setText(hashTag.getSummary());
        }
    }

    public final void s(HashTag hashTag) {
        if (TextUtils.isEmpty(hashTag.getUrl())) {
            return;
        }
        j.f12156c.a(this.itemView.getContext(), hashTag.getUrl(), new WebStyleViewModel(WebStyleEnum.CardStyle, false, null, 6, null));
    }

    public final void t(@Nullable String str, @NotNull ImageModel model) {
        s.i(model, "model");
        if (str == null) {
            ((FKWebpAnimationView) this.itemView.findViewById(R$id.head_animation_view)).setVisibility(8);
            View view = this.itemView;
            int i10 = R$id.head_imageview;
            ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView, "itemView.head_imageview");
            ImageLoaderView.g(imageLoaderView, model, null, null, 6, null);
            return;
        }
        ((ImageLoaderView) this.itemView.findViewById(R$id.head_imageview)).setVisibility(8);
        View view2 = this.itemView;
        int i11 = R$id.head_animation_view;
        ((FKWebpAnimationView) view2.findViewById(i11)).setVisibility(0);
        FKWebpAnimationView fKWebpAnimationView = (FKWebpAnimationView) this.itemView.findViewById(i11);
        s.h(fKWebpAnimationView, "itemView.head_animation_view");
        FKWebpAnimationView.h(fKWebpAnimationView, str, 0, null, null, 14, null);
    }

    public final void u() {
        ((FKWebpAnimationView) this.itemView.findViewById(R$id.head_animation_view)).i();
    }
}
