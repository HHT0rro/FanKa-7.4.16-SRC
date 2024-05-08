package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.feed.activity.MapActivity;
import com.cupidapp.live.feed.model.FeedModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedDetailTitleBarLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailTitleBarLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public d f14460b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14461c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailTitleBarLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14461c = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14461c;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void c(@Nullable final FeedModel feedModel) {
        if (feedModel == null) {
            return;
        }
        ImageLoaderView feedDetailAvatar = (ImageLoaderView) a(R$id.feedDetailAvatar);
        kotlin.jvm.internal.s.h(feedDetailAvatar, "feedDetailAvatar");
        ImageLoaderView.g(feedDetailAvatar, feedModel.getUser().getAvatarImage(), null, null, 6, null);
        ((TextView) a(R$id.feedDetailUserName)).setText(feedModel.getUser().getName());
        if (feedModel.getVenue() != null) {
            int i10 = R$id.feedDetailUserLocationTxt;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(feedModel.getVenue());
            TextView feedDetailUserLocationTxt = (TextView) a(i10);
            kotlin.jvm.internal.s.h(feedDetailUserLocationTxt, "feedDetailUserLocationTxt");
            y.d(feedDetailUserLocationTxt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailTitleBarLayout$configFeedUserInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                    invoke2(view);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    MapActivity.f14086t.a(FeedDetailTitleBarLayout.this.getContext(), feedModel.getVenue(), feedModel.getLatitude(), feedModel.getLongitude(), feedModel.getVenueAbroad());
                }
            });
        } else {
            ((TextView) a(R$id.feedDetailUserLocationTxt)).setVisibility(8);
        }
        UserIconViewLayout feedVipIconImageView = (UserIconViewLayout) a(R$id.feedVipIconImageView);
        kotlin.jvm.internal.s.h(feedVipIconImageView, "feedVipIconImageView");
        UserIconViewLayout.d(feedVipIconImageView, feedModel.getUser().getUserVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
    }

    public final void d() {
        z.a(this, R$layout.layout_feed_detail_title, true);
        int i10 = R$id.feedDetailUserName;
        ((TextView) a(i10)).getPaint().setFakeBoldText(true);
        int i11 = R$id.feedDetailAlohaButton;
        ((TextView) a(i11)).getPaint().setFakeBoldText(true);
        ImageView returnImageView = (ImageView) a(R$id.returnImageView);
        kotlin.jvm.internal.s.h(returnImageView, "returnImageView");
        y.d(returnImageView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailTitleBarLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                d dVar;
                dVar = FeedDetailTitleBarLayout.this.f14460b;
                if (dVar != null) {
                    dVar.d();
                }
            }
        });
        ImageLoaderView feedDetailAvatar = (ImageLoaderView) a(R$id.feedDetailAvatar);
        kotlin.jvm.internal.s.h(feedDetailAvatar, "feedDetailAvatar");
        y.d(feedDetailAvatar, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailTitleBarLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                d dVar;
                dVar = FeedDetailTitleBarLayout.this.f14460b;
                if (dVar != null) {
                    dVar.b();
                }
            }
        });
        TextView feedDetailUserName = (TextView) a(i10);
        kotlin.jvm.internal.s.h(feedDetailUserName, "feedDetailUserName");
        y.d(feedDetailUserName, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailTitleBarLayout$initView$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                d dVar;
                dVar = FeedDetailTitleBarLayout.this.f14460b;
                if (dVar != null) {
                    dVar.e();
                }
            }
        });
        TextView feedDetailAlohaButton = (TextView) a(i11);
        kotlin.jvm.internal.s.h(feedDetailAlohaButton, "feedDetailAlohaButton");
        y.d(feedDetailAlohaButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailTitleBarLayout$initView$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                d dVar;
                dVar = FeedDetailTitleBarLayout.this.f14460b;
                if (dVar != null) {
                    dVar.a();
                }
            }
        });
        ImageView feedDetailShareButton = (ImageView) a(R$id.feedDetailShareButton);
        kotlin.jvm.internal.s.h(feedDetailShareButton, "feedDetailShareButton");
        y.d(feedDetailShareButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedDetailTitleBarLayout$initView$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                d dVar;
                dVar = FeedDetailTitleBarLayout.this.f14460b;
                if (dVar != null) {
                    dVar.c();
                }
            }
        });
    }

    public final void setAlohaButtonVisible(boolean z10) {
        if (z10) {
            ((TextView) a(R$id.feedDetailAlohaButton)).setVisibility(0);
        } else {
            ((TextView) a(R$id.feedDetailAlohaButton)).setVisibility(8);
        }
    }

    public final void setListener(@NotNull d listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f14460b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailTitleBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14461c = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailTitleBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14461c = new LinkedHashMap();
        d();
    }
}
