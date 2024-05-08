package com.cupidapp.live.feed.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.appdialog.model.RateScene;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.CustomIndicator;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.feed.FeedType;
import com.cupidapp.live.feed.layout.FeedAdTipLayout;
import com.cupidapp.live.feed.layout.FeedImageContentLayout;
import com.cupidapp.live.feed.layout.FeedImageViewPager;
import com.cupidapp.live.feed.layout.FeedPraiseLayout;
import com.cupidapp.live.feed.layout.FeedTagLayout;
import com.cupidapp.live.feed.layout.FeedVideoContentLayout;
import com.cupidapp.live.feed.model.AdTipModel;
import com.cupidapp.live.feed.model.FeedLikeResult;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedPraiseGuideModel;
import com.cupidapp.live.feed.model.SponsorModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.m;
import z0.t;
import z0.u;
import z0.v;
import z0.y;

/* compiled from: BaseFeedViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseFeedViewHolder extends FKBaseRecyclerViewHolder implements d2.a, FeedPraiseLayout.b, d {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f14365i = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FeedSensorContext f14366c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Map<String, ? extends Object> f14367d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FeedModel f14368e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.feed.holder.b f14369f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public c f14370g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14371h;

    /* compiled from: BaseFeedViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Pair<Integer, Integer> a(@NotNull ImageModel imageModel) {
            s.i(imageModel, "imageModel");
            int l10 = z0.h.l(this);
            return new Pair<>(Integer.valueOf(l10), Integer.valueOf(imageModel.getScaleHeightByWidth(l10)));
        }
    }

    /* compiled from: BaseFeedViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements FeedImageContentLayout.a {
        public b() {
        }

        @Override // com.cupidapp.live.feed.layout.FeedImageContentLayout.a
        public void a(int i10) {
            ((CustomIndicator) BaseFeedViewHolder.this.itemView.findViewById(R$id.multiImageIndicator)).n(i10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFeedViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f14371h = true;
    }

    public static /* synthetic */ void T(BaseFeedViewHolder baseFeedViewHolder, FeedModel feedModel, boolean z10, float f10, float f11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPraiseAnimation");
        }
        if ((i10 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f11 = 0.0f;
        }
        baseFeedViewHolder.S(feedModel, z10, f10, f11);
    }

    public final void A(FeedModel feedModel) {
        Observable<Result<Object>> D = NetworkClient.f11868a.l().D(feedModel.getPostId());
        Object context = this.itemView.getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = D.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.BaseFeedViewHolder$feedLikeCancel$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        FeedSensorContext feedSensorContext = this.f14366c;
        SensorScene scene = feedSensorContext != null ? feedSensorContext.getScene() : null;
        FeedSensorContext feedSensorContext2 = this.f14366c;
        sensorsLogFeed.n(scene, feedSensorContext2 != null ? feedSensorContext2.getPosition() : null, feedModel.getPostId(), feedModel.getUser().userId(), feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
    }

    public final void B(int i10, int i11) {
        Drawable drawable = ContextCompat.getDrawable(this.itemView.getContext(), R$mipmap.icon_feed_like);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        View view = this.itemView;
        int i12 = R$id.feedPraiseButton;
        ((TextView) view.findViewById(i12)).setCompoundDrawables(drawable, null, null, null);
        if (i10 > i11) {
            TextView textView = (TextView) this.itemView.findViewById(i12);
            int i13 = i10 - i11;
            Context context = this.itemView.getContext();
            s.h(context, "itemView.context");
            textView.setText(m.e(i13, context));
            return;
        }
        ((TextView) this.itemView.findViewById(i12)).setText(this.itemView.getContext().getString(R$string.feed_praise));
    }

    public final void C(int i10, int i11) {
        Drawable drawable = ContextCompat.getDrawable(this.itemView.getContext(), R$mipmap.icon_feed_like_highlight);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        View view = this.itemView;
        int i12 = R$id.feedPraiseButton;
        ((TextView) view.findViewById(i12)).setCompoundDrawables(drawable, null, null, null);
        TextView textView = (TextView) this.itemView.findViewById(i12);
        int i13 = i10 + i11;
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        textView.setText(m.e(i13, context));
    }

    @Nullable
    public final c D() {
        return this.f14370g;
    }

    public final int E(String str, int i10, int i11) {
        if (!StringsKt__StringsKt.K(str, "\n", false, 2, null) && str.length() < i10) {
            return str.length();
        }
        if (StringsKt__StringsKt.K(str, "\n", false, 2, null)) {
            StringBuilder sb2 = new StringBuilder();
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < str.length() && i12 < i11; i14++) {
                sb2.append(str.charAt(i14));
                if (str.charAt(i14) == '\n') {
                    i12++;
                    i13 += 15;
                } else {
                    i13++;
                }
                if (i13 > i10 || i12 >= i11) {
                    break;
                }
            }
            i10 = StringsKt__StringsKt.Q0(sb2, '\n').length();
        }
        return i10;
    }

    @Nullable
    public final FeedSensorContext F() {
        return this.f14366c;
    }

    public final boolean G() {
        return ((ImageView) ((FeedImageContentLayout) this.itemView.findViewById(R$id.feedImageContentLayout)).a(R$id.multiImageGuide)).getVisibility() == 0;
    }

    public final SpannableStringBuilder H(SpannableStringBuilder spannableStringBuilder, Context context) {
        spannableStringBuilder.append((CharSequence) ("...   " + context.getString(R$string.expand)));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.text_gray)), spannableStringBuilder.length() + (-2), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public final void I() {
        View view = this.itemView;
        int i10 = R$id.feedVideoContentLayout;
        if (((FeedVideoContentLayout) view.findViewById(i10)).getVisibility() == 0) {
            ((FeedVideoContentLayout) this.itemView.findViewById(i10)).k();
        }
    }

    public final void J() {
        View view = this.itemView;
        int i10 = R$id.feedVideoContentLayout;
        if (((FeedVideoContentLayout) view.findViewById(i10)).getVisibility() == 0) {
            ((FeedVideoContentLayout) this.itemView.findViewById(i10)).l();
        }
    }

    public final void K() {
        View view = this.itemView;
        int i10 = R$id.feedVideoContentLayout;
        if (((FeedVideoContentLayout) view.findViewById(i10)).getVisibility() == 0) {
            ((FeedVideoContentLayout) this.itemView.findViewById(i10)).m();
        }
    }

    public final void L(@Nullable c cVar) {
        this.f14370g = cVar;
    }

    public final void M(@Nullable com.cupidapp.live.feed.holder.b bVar) {
        this.f14369f = bVar;
    }

    public final void N(boolean z10) {
        this.f14371h = z10;
    }

    public final void O(@Nullable Map<String, ? extends Object> map) {
        this.f14367d = map;
    }

    public final void P(@Nullable FeedSensorContext feedSensorContext) {
        this.f14366c = feedSensorContext;
    }

    public final void Q(List<? extends AppDialogModel> list) {
        FeedSensorContext feedSensorContext = this.f14366c;
        if ((feedSensorContext != null ? feedSensorContext.getPosition() : null) == SensorPosition.Feed) {
            FKAppRatingLayout.f11658f.c(list);
            Context context = this.itemView.getContext();
            if (context != null) {
                new FKAppRatingLayout(context).p(RateScene.FeedPraise);
            }
        }
    }

    public final void R(@NotNull String fileName) {
        s.i(fileName, "fileName");
        ((FeedPraiseLayout) this.itemView.findViewById(R$id.feedPraiseLayout)).j(fileName);
    }

    public final void S(@NotNull FeedModel model, boolean z10, float f10, float f11) {
        s.i(model, "model");
        if (model.getLiked()) {
            B(model.getLikeCount(), 1);
            model.cancelPraise();
            A(model);
        } else {
            C(model.getLikeCount(), 1);
            model.praise();
            z(model);
            ((FeedPraiseLayout) this.itemView.findViewById(R$id.feedPraiseLayout)).k(z10, f10, f11);
        }
        com.cupidapp.live.feed.holder.b bVar = this.f14369f;
        if (bVar != null) {
            bVar.P(model);
        }
    }

    public final void U() {
        ((FeedPraiseLayout) this.itemView.findViewById(R$id.feedPraiseLayout)).m();
    }

    public final void V() {
        View view = this.itemView;
        int i10 = R$id.feedVideoContentLayout;
        if (((FeedVideoContentLayout) view.findViewById(i10)).getVisibility() == 0) {
            ((FeedVideoContentLayout) this.itemView.findViewById(i10)).n();
        }
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void a() {
        J();
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void b() {
        I();
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void c() {
        K();
    }

    @Override // d2.a
    public void d() {
        U();
    }

    @Override // d2.a
    public void e(float f10, float f11) {
        FeedPraiseGuideModel A = p1.g.f52734a.A();
        if (A != null) {
            A.configFeedPraiseGuideNotShow();
        }
        U();
        FeedModel feedModel = this.f14368e;
        if (feedModel != null) {
            if (feedModel.getLiked()) {
                ((FeedPraiseLayout) this.itemView.findViewById(R$id.feedPraiseLayout)).k(false, f10, f11);
            } else {
                S(feedModel, false, f10, f11);
            }
        }
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void f() {
        V();
    }

    @Override // d2.a
    public void g(@Nullable MotionEvent motionEvent, @Nullable ImageModel imageModel) {
        FeedModel feedModel = this.f14368e;
        if (s.d(feedModel != null ? feedModel.getType() : null, FeedType.ImagePost.getValue())) {
            ((FeedPraiseLayout) this.itemView.findViewById(R$id.feedPraiseLayout)).e(motionEvent, imageModel);
        }
    }

    @Override // com.cupidapp.live.feed.layout.FeedPraiseLayout.b
    public void h(boolean z10) {
        ((FeedImageContentLayout) this.itemView.findViewById(R$id.feedImageContentLayout)).setVisibility(z10 ? 4 : 0);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedModel) {
            FeedModel feedModel = (FeedModel) obj;
            this.f14368e = feedModel;
            ((ImageView) this.itemView.findViewById(R$id.close_friend_can_see_icon)).setVisibility(8);
            View view = this.itemView;
            int i10 = R$id.multiImageIndicator;
            ((CustomIndicator) view.findViewById(i10)).setVisibility(4);
            View view2 = this.itemView;
            int i11 = R$id.feedPraiseLayout;
            ViewGroup.LayoutParams layoutParams = ((FeedPraiseLayout) view2.findViewById(i11)).getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            String type = feedModel.getType();
            if (s.d(type, FeedType.ImagePost.getValue())) {
                View view3 = this.itemView;
                int i12 = R$id.feedImageContentLayout;
                ((FeedImageContentLayout) view3.findViewById(i12)).setFeedModel(feedModel);
                FeedImageContentLayout feedImageContentLayout = (FeedImageContentLayout) this.itemView.findViewById(i12);
                FeedSensorContext feedSensorContext = this.f14366c;
                feedImageContentLayout.setSensorScene(feedSensorContext != null ? feedSensorContext.getScene() : null);
                ((FeedImageContentLayout) this.itemView.findViewById(i12)).setOnImageContentListener(new b());
                ((FeedImageContentLayout) this.itemView.findViewById(i12)).setVisibility(0);
                ((FeedVideoContentLayout) this.itemView.findViewById(R$id.feedVideoContentLayout)).setVisibility(8);
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = z0.h.c(this, 0.5f);
                }
                if (layoutParams2 != null) {
                    layoutParams2.height = ((FeedImageViewPager) ((FeedImageContentLayout) this.itemView.findViewById(i12)).a(R$id.multiImageViewPager)).getLayoutParams().height;
                }
                if (feedModel.getImageListCount() > 1) {
                    ((CustomIndicator) this.itemView.findViewById(i10)).setVisibility(0);
                    ((CustomIndicator) this.itemView.findViewById(i10)).setPagerCount(feedModel.getImageListCount());
                }
            } else if (s.d(type, FeedType.VideoPost.getValue())) {
                View view4 = this.itemView;
                int i13 = R$id.feedVideoContentLayout;
                ((FeedVideoContentLayout) view4.findViewById(i13)).setFeedModel(feedModel);
                ((FeedVideoContentLayout) this.itemView.findViewById(i13)).setVisibility(0);
                ((FeedImageContentLayout) this.itemView.findViewById(R$id.feedImageContentLayout)).setVisibility(8);
                ((ImageView) this.itemView.findViewById(R$id.multiImageGuide)).setVisibility(8);
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
                if (layoutParams2 != null) {
                    layoutParams2.height = ((RelativeLayout) ((FeedVideoContentLayout) this.itemView.findViewById(i13)).b(R$id.feedVideoContentRootLayout)).getLayoutParams().height;
                }
            }
            ((FeedPraiseLayout) this.itemView.findViewById(i11)).setFeedClickEventListener(this);
            ((FeedImageContentLayout) this.itemView.findViewById(R$id.feedImageContentLayout)).setFeedImageClickListener(this);
            ((FeedVideoContentLayout) this.itemView.findViewById(R$id.feedVideoContentLayout)).setFeedVideoClickListener(this);
            v(feedModel);
            x(feedModel);
            ((FeedTagLayout) this.itemView.findViewById(R$id.feedTagLayout)).setData(feedModel);
            w(feedModel);
            if (y(feedModel)) {
                return;
            }
            u(feedModel);
        }
    }

    public final void t(boolean z10) {
        ((FeedVideoContentLayout) this.itemView.findViewById(R$id.feedVideoContentLayout)).f(z10);
    }

    public final void u(FeedModel feedModel) {
        AdTipModel adTip = feedModel.getAdTip();
        if ((adTip != null ? adTip.getTitle() : null) == null) {
            ((FeedAdTipLayout) this.itemView.findViewById(R$id.feed_ad_tip_layout)).setVisibility(8);
            return;
        }
        View view = this.itemView;
        int i10 = R$id.feed_ad_tip_layout;
        ((FeedAdTipLayout) view.findViewById(i10)).setVisibility(0);
        FeedAdTipLayout feedAdTipLayout = (FeedAdTipLayout) this.itemView.findViewById(i10);
        AdTipModel adTip2 = feedModel.getAdTip();
        FeedSensorContext feedSensorContext = this.f14366c;
        feedAdTipLayout.j(adTip2, (feedSensorContext != null ? feedSensorContext.getPosition() : null) == SensorPosition.FeedDetail);
    }

    public final void v(final FeedModel feedModel) {
        String str;
        int i10;
        String description = feedModel.getDescription();
        if (description == null || (str = t.e(description)) == null) {
            str = "";
        }
        FeedSensorContext feedSensorContext = this.f14366c;
        if ((feedSensorContext != null ? feedSensorContext.getPosition() : null) == SensorPosition.FeedDetail) {
            String title = feedModel.getTitle();
            if (title == null || title.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.feedTitleTextView)).setVisibility(8);
            } else {
                View view = this.itemView;
                int i11 = R$id.feedTitleTextView;
                ((TextView) view.findViewById(i11)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).setText(feedModel.getTitle());
                TextView textView = (TextView) this.itemView.findViewById(i11);
                s.h(textView, "itemView.feedTitleTextView");
                u.a(textView);
            }
        } else {
            String title2 = feedModel.getTitle();
            if (!(title2 == null || kotlin.text.p.t(title2))) {
                if (!kotlin.text.p.t(str)) {
                    str = feedModel.getTitle() + "\n" + str;
                } else {
                    str = feedModel.getTitle();
                }
            }
            str = StringsKt__StringsKt.R0(StringsKt__StringsKt.P0(str).toString(), '\n');
        }
        if (str.length() == 0) {
            ((TextView) this.itemView.findViewById(R$id.feedIntroductionTextView)).setVisibility(8);
        } else {
            View view2 = this.itemView;
            int i12 = R$id.feedIntroductionTextView;
            ((TextView) view2.findViewById(i12)).setVisibility(0);
            if (!this.f14371h) {
                i10 = Integer.MAX_VALUE;
            } else if (feedModel.getHashtag() != null) {
                i10 = E(str, 18, 1);
            } else {
                i10 = E(str, 50, 2);
            }
            SpannableStringBuilder a10 = com.cupidapp.live.feed.helper.a.f14304a.a(feedModel.getReplaceAtList(), str, i10, new Function1<String, p>() { // from class: com.cupidapp.live.feed.holder.BaseFeedViewHolder$configDescriptionTxt$clickableDes$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(String str2) {
                    invoke2(str2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    s.i(it, "it");
                    c D = BaseFeedViewHolder.this.D();
                    if (D != null) {
                        D.b(it);
                    }
                }
            });
            TextView textView2 = (TextView) this.itemView.findViewById(i12);
            if (this.f14371h && a10.length() < str.length()) {
                Context context = this.itemView.getContext();
                s.h(context, "itemView.context");
                a10 = H(a10, context);
            }
            textView2.setText(a10);
            ((TextView) this.itemView.findViewById(i12)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView3 = (TextView) this.itemView.findViewById(R$id.feedIntroductionTextView);
        s.h(textView3, "itemView.feedIntroductionTextView");
        y.d(textView3, new Function1<View, p>() { // from class: com.cupidapp.live.feed.holder.BaseFeedViewHolder$configDescriptionTxt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view3) {
                invoke2(view3);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view3) {
                c D;
                View view4 = BaseFeedViewHolder.this.itemView;
                int i13 = R$id.feedIntroductionTextView;
                if (((TextView) view4.findViewById(i13)).getSelectionStart() == -1 && ((TextView) BaseFeedViewHolder.this.itemView.findViewById(i13)).getSelectionEnd() == -1 && (D = BaseFeedViewHolder.this.D()) != null) {
                    D.a(feedModel);
                }
            }
        });
    }

    public final void w(FeedModel feedModel) {
        String string;
        ((TextView) this.itemView.findViewById(R$id.feedPraiseButton)).getPaint().setFakeBoldText(true);
        if (feedModel.getLiked()) {
            C(feedModel.getLikeCount(), 0);
        } else {
            B(feedModel.getLikeCount(), 0);
        }
        View view = this.itemView;
        int i10 = R$id.commentButton;
        ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
        TextView textView = (TextView) this.itemView.findViewById(i10);
        if (feedModel.getCommentCount() > 0) {
            int commentCount = feedModel.getCommentCount();
            Context context = this.itemView.getContext();
            s.h(context, "itemView.context");
            string = m.e(commentCount, context);
        } else {
            string = this.itemView.getContext().getString(R$string.comment);
        }
        textView.setText(string);
        if (!feedModel.haveSponsor() && !feedModel.getUser().getMe()) {
            if (feedModel.getUser().getCanSendInboxMessage()) {
                View view2 = this.itemView;
                int i11 = R$id.privateChatButton;
                ((TextView) view2.findViewById(i11)).setVisibility(0);
                TextView textView2 = (TextView) this.itemView.findViewById(i11);
                s.h(textView2, "itemView.privateChatButton");
                u.e(textView2, R$mipmap.icon_feed_chat_online, 0, 0, 0, 14, null);
                return;
            }
            if (p1.g.f52734a.M3()) {
                View view3 = this.itemView;
                int i12 = R$id.privateChatButton;
                ((TextView) view3.findViewById(i12)).setVisibility(0);
                TextView textView3 = (TextView) this.itemView.findViewById(i12);
                s.h(textView3, "itemView.privateChatButton");
                u.e(textView3, R$mipmap.icon_feed_super_like, 0, 0, 0, 14, null);
                return;
            }
            ((TextView) this.itemView.findViewById(R$id.privateChatButton)).setVisibility(8);
            return;
        }
        ((TextView) this.itemView.findViewById(R$id.privateChatButton)).setVisibility(8);
    }

    public final void x(FeedModel feedModel) {
        if (feedModel.getCreateTimeMillis() <= 0) {
            ((TextView) this.itemView.findViewById(R$id.releaseTimeTextView)).setVisibility(8);
            return;
        }
        View view = this.itemView;
        int i10 = R$id.releaseTimeTextView;
        ((TextView) view.findViewById(i10)).setVisibility(0);
        String n10 = v.n(feedModel.getCreateTimeMillis(), this.itemView.getContext());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(n10);
        String publishIpCityName = feedModel.getPublishIpCityName();
        if (!(publishIpCityName == null || publishIpCityName.length() == 0)) {
            sb2.append(" · " + feedModel.getPublishIpCityName());
        }
        String label = feedModel.getLabel();
        if (!(label == null || label.length() == 0)) {
            sb2.append(" · " + feedModel.getLabel());
        }
        if (feedModel.getExposureCount() != null) {
            sb2.append(" · " + this.itemView.getContext().getString(R$string.view_count, feedModel.getExposureCount().toString()));
        }
        ((TextView) this.itemView.findViewById(i10)).setText(sb2);
    }

    public final boolean y(FeedModel feedModel) {
        SponsorModel sponsorExtraInfo = feedModel.getSponsorExtraInfo();
        if (sponsorExtraInfo != null) {
            String title = sponsorExtraInfo.getTitle();
            if (!(title == null || title.length() == 0)) {
                String url = sponsorExtraInfo.getUrl();
                if (!(url == null || url.length() == 0)) {
                    View view = this.itemView;
                    int i10 = R$id.feedSponsorLayout;
                    ((RelativeLayout) view.findViewById(i10)).setVisibility(0);
                    View view2 = this.itemView;
                    int i11 = R$id.sponsorTextView;
                    ((TextView) view2.findViewById(i11)).setText(sponsorExtraInfo.getTitle());
                    int b4 = sponsorExtraInfo.getForegroundColor() != null ? com.cupidapp.live.base.utils.h.b(sponsorExtraInfo.getForegroundColor()) : -1;
                    ((TextView) this.itemView.findViewById(i11)).setTextColor(b4);
                    ((ImageView) this.itemView.findViewById(R$id.sponsorIndicator)).setImageDrawable(z0.i.f54815a.b(ContextCompat.getDrawable(this.itemView.getContext(), R$mipmap.gray_arrow), b4));
                    ((RelativeLayout) this.itemView.findViewById(i10)).setBackgroundColor(sponsorExtraInfo.getBackgroundColor() != null ? com.cupidapp.live.base.utils.h.b(sponsorExtraInfo.getBackgroundColor()) : -44707);
                    return true;
                }
            }
        }
        ((RelativeLayout) this.itemView.findViewById(R$id.feedSponsorLayout)).setVisibility(8);
        return false;
    }

    public final void z(final FeedModel feedModel) {
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.YouBlacklistedTheOtherPerson.getValue()), new Function1<String, p>() { // from class: com.cupidapp.live.feed.holder.BaseFeedViewHolder$feedLike$errorCodeInterceptor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                BaseFeedViewHolder.this.B(feedModel.getLikeCount(), 1);
                feedModel.cancelPraise();
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, BaseFeedViewHolder.this.itemView.getContext(), false, 2, null).n(str), 0, null, null, 7, null), null, 1, null);
            }
        }));
        Observable<Result<FeedLikeResult>> A = NetworkClient.f11868a.l().A(feedModel.getPostId());
        Object context = this.itemView.getContext();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.holder.BaseFeedViewHolder$feedLike$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                j.f(j.f12008a, it, BaseFeedViewHolder.this.itemView.getContext(), h10, null, 8, null);
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = A.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedLikeResult, p>() { // from class: com.cupidapp.live.feed.holder.BaseFeedViewHolder$feedLike$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FeedLikeResult feedLikeResult) {
                m2573invoke(feedLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2573invoke(FeedLikeResult feedLikeResult) {
                BaseFeedViewHolder.this.Q(feedLikeResult.getWindows());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        String userId = feedModel.getUser().userId();
        String postId = feedModel.getPostId();
        FeedSensorContext feedSensorContext = this.f14366c;
        SensorPosition position = feedSensorContext != null ? feedSensorContext.getPosition() : null;
        FeedSensorContext feedSensorContext2 = this.f14366c;
        sensorsLogFeed.m(userId, postId, position, feedSensorContext2 != null ? feedSensorContext2.getScene() : null, SensorsLogFeed.LikeCommentType.Feed, feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
    }
}
