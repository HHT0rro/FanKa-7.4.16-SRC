package com.cupidapp.live.mediapicker.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.profile.activity.CloseFriendManagerActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FeedPublishRangeActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedPublishRangeActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f17089t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public boolean f17090q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public Integer f17091r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17092s = new LinkedHashMap();

    /* compiled from: FeedPublishRangeActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, int i10, boolean z10) {
            s.i(activity, "activity");
            Intent intent = new Intent(activity, (Class<?>) FeedPublishRangeActivity.class);
            intent.putExtra("closeFriendOnly", z10);
            activity.startActivityForResult(intent, i10);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, activity, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17092s;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_feed_publish_range);
        this.f17090q = getIntent().getBooleanExtra("closeFriendOnly", false);
        v1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        u1();
    }

    public final void r1() {
        ((ImageView) j1(R$id.item_publish_range).findViewById(R$id.item_range_checked)).setVisibility(!this.f17090q ? 0 : 8);
        ((ImageView) j1(R$id.item_close_friend_range).findViewById(R$id.item_range_checked)).setVisibility(this.f17090q ? 0 : 8);
    }

    public final void s1(@NotNull View rootView, boolean z10, @StringRes int i10, @StringRes int i11, final boolean z11) {
        s.i(rootView, "rootView");
        ((ImageView) rootView.findViewById(R$id.item_range_checked)).setVisibility(z10 ? 0 : 8);
        TextView textView = (TextView) rootView.findViewById(R$id.item_range_title);
        textView.getPaint().setFakeBoldText(true);
        textView.setText(i10);
        ((TextView) rootView.findViewById(R$id.item_range_content)).setText(i11);
        y.d(rootView, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishRangeActivity$configData$1
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
                Integer num;
                FeedPublishRangeActivity.this.f17090q = z11;
                FeedPublishRangeActivity.this.r1();
                num = FeedPublishRangeActivity.this.f17091r;
                if (num != null && num.intValue() == 0 && z11) {
                    FeedPublishRangeActivity.this.w1();
                }
            }
        });
    }

    public final void t1() {
        CloseFriendManagerActivity.f17591r.a(this, new FKSensorContext(SensorPosition.FeedPublishRange, SensorPosition.EditFeed, null, SensorScene.Feed));
    }

    public final void u1() {
        Disposable disposed = NetworkClient.f11868a.N().v0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<j3.a, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishRangeActivity$initData$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(j3.a aVar) {
                m2738invoke(aVar);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2738invoke(j3.a aVar) {
                FeedPublishRangeActivity.this.f17091r = aVar.a();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishRangeActivity$initData$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void v1() {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.title_view);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishRangeActivity$initView$1$1
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
                FeedPublishRangeActivity.this.onBackPressed();
            }
        });
        fKTitleBarLayout.setRightTextClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishRangeActivity$initView$1$2
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
                boolean z10;
                Intent intent = new Intent();
                z10 = FeedPublishRangeActivity.this.f17090q;
                intent.putExtra("closeFriendOnly", z10);
                FeedPublishRangeActivity.this.setResult(-1, intent);
                FeedPublishRangeActivity.this.finish();
            }
        });
        View item_publish_range = j1(R$id.item_publish_range);
        s.h(item_publish_range, "item_publish_range");
        s1(item_publish_range, !this.f17090q, R$string.open, R$string.all_can_see, false);
        View item_close_friend_range = j1(R$id.item_close_friend_range);
        s.h(item_close_friend_range, "item_close_friend_range");
        s1(item_close_friend_range, this.f17090q, R$string.close_friend, R$string.close_friend_can_see, true);
    }

    public final void w1() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.f12698l.b(this, true).D(R$string.no_close_friend_list), R$string.go_to_change, null, new Function0<p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishRangeActivity$showNoCloseFriendDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FeedPublishRangeActivity.this.t1();
            }
        }, 2, null), R$string.no_need, null, 2, null), null, 1, null);
    }
}
