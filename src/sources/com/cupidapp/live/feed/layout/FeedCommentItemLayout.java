package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.PostCommentModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.y;
import z0.z;

/* compiled from: FeedCommentItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedCommentItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14448b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentItemLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14448b = new LinkedHashMap();
        e();
    }

    public static final void d(FeedCommentItemLayout this$0, FeedSensorContext feedSensorContext, FeedModel feedModel, PostCommentModel model, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(feedModel, "$feedModel");
        kotlin.jvm.internal.s.i(model, "$model");
        int i10 = R$id.feedCommentContentTextView;
        if (((TextView) this$0.b(i10)).getSelectionStart() == -1 && ((TextView) this$0.b(i10)).getSelectionEnd() == -1 && feedSensorContext != null) {
            SensorsLogFeed.f12208a.q(SensorsLogFeed.BtnName.COMMENT);
            FeedDetailActivity.Q.a(this$0.getContext(), feedModel, false, feedSensorContext, (r25 & 16) != 0 ? false : true, (r25 & 32) != 0 ? false : true, (r25 & 64) != 0 ? null : model.getId(), (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : null, (r25 & 512) != 0 ? null : null);
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f14448b;
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

    public final void c(@NotNull final PostCommentModel model, @Nullable final FeedSensorContext feedSensorContext, @NotNull final FeedModel feedModel) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(feedModel, "feedModel");
        b(R$id.feedCommentVerticalBarView).setVisibility(kotlin.jvm.internal.s.d(model.getParent(), Boolean.FALSE) ? 0 : 8);
        int i10 = R$id.feedCommentUserNameTextView;
        ((TextView) b(i10)).setText(getContext().getString(R$string.feed_comment_user, model.getUser().getName()));
        SpannableStringBuilder a10 = com.cupidapp.live.feed.helper.a.f14304a.a(model.getReplaceAtList(), StringsKt__StringsKt.O0(model.getComment(), "\n", null, 2, null), 20, new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedCommentItemLayout$configFeedCommentData$clickableComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                kotlin.jvm.internal.s.i(it, "it");
                Observable z10 = a.C0836a.z(NetworkClient.f11868a.N(), it, null, null, false, null, 30, null);
                Object context = ((TextView) FeedCommentItemLayout.this.b(R$id.feedCommentContentTextView)).getContext();
                final FeedSensorContext feedSensorContext2 = feedSensorContext;
                final FeedCommentItemLayout feedCommentItemLayout = FeedCommentItemLayout.this;
                final FeedModel feedModel2 = feedModel;
                com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
                Disposable disposed = z10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedCommentItemLayout$configFeedCommentData$clickableComment$1$invoke$$inlined$handleByContext$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                        m2574invoke(profileResult);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2574invoke(ProfileResult profileResult) {
                        ProfileResult profileResult2 = profileResult;
                        String value = ViewProfilePrefer.FeedCommentToProfile.getValue();
                        boolean me2 = profileResult2.getUser().getMe();
                        SensorPosition sensorPosition = SensorPosition.Comment;
                        FeedSensorContext feedSensorContext3 = FeedSensorContext.this;
                        SensorPosition position = feedSensorContext3 != null ? feedSensorContext3.getPosition() : null;
                        FeedSensorContext feedSensorContext4 = FeedSensorContext.this;
                        UserProfileActivity.G.a(feedCommentItemLayout.getContext(), profileResult2.getUser(), new ProfileSensorContext(value, null, me2, sensorPosition, position, feedSensorContext4 != null ? feedSensorContext4.getScene() : null), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : feedModel2.getPostStatisticsSource(), (r21 & 128) != 0 ? false : false);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (gVar != null) {
                        gVar.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
        int i11 = R$id.feedCommentContentTextView;
        TextView textView = (TextView) b(i11);
        if (a10.length() < model.getComment().length()) {
            a10 = a10.append((CharSequence) "...");
        }
        textView.setText(a10);
        ((TextView) b(i11)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) b(i11)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.feed.layout.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedCommentItemLayout.d(FeedCommentItemLayout.this, feedSensorContext, feedModel, model, view);
            }
        });
        TextView feedCommentUserNameTextView = (TextView) b(i10);
        kotlin.jvm.internal.s.h(feedCommentUserNameTextView, "feedCommentUserNameTextView");
        y.d(feedCommentUserNameTextView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedCommentItemLayout$configFeedCommentData$2
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
                String value = ViewProfilePrefer.FeedCommentToProfile.getValue();
                boolean me2 = PostCommentModel.this.getUser().getMe();
                SensorPosition sensorPosition = SensorPosition.Comment;
                FeedSensorContext feedSensorContext2 = feedSensorContext;
                SensorPosition position = feedSensorContext2 != null ? feedSensorContext2.getPosition() : null;
                FeedSensorContext feedSensorContext3 = feedSensorContext;
                UserProfileActivity.G.a(this.getContext(), PostCommentModel.this.getUser(), new ProfileSensorContext(value, null, me2, sensorPosition, position, feedSensorContext3 != null ? feedSensorContext3.getScene() : null), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : feedModel.getPostStatisticsSource(), (r21 & 128) != 0 ? false : false);
            }
        });
    }

    public final void e() {
        z.a(this, R$layout.layout_feed_comment_item, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14448b = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14448b = new LinkedHashMap();
        e();
    }
}
