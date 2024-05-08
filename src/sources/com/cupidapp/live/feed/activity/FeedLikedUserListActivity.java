package com.cupidapp.live.feed.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedLikedUserListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedLikedUserListActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f14069r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14070q = new LinkedHashMap();

    /* compiled from: FeedLikedUserListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String postId, int i10) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(postId, "postId");
            Intent intent = new Intent(context, (Class<?>) FeedLikedUserListActivity.class);
            intent.putExtra("FEED_LIKED_ACTIVITY_POST_ID", postId);
            intent.putExtra("FEED_LIKED_ACTIVITY_POST_LIKE_COUNT", i10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f14070q;
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
        setContentView(R$layout.activity_feed_liked_user_list);
        String stringExtra = getIntent().getStringExtra("FEED_LIKED_ACTIVITY_POST_ID");
        int intExtra = getIntent().getIntExtra("FEED_LIKED_ACTIVITY_POST_LIKE_COUNT", 0);
        if (stringExtra != null) {
            FKBaseActivity.g1(this, FeedLikedUserListFragment.f14071k.a(stringExtra), false, R$id.containerLayout, false, false, 24, null);
        }
        FKTitleBarLayout onCreate$lambda$1 = (FKTitleBarLayout) j1(R$id.titleLayout);
        kotlin.jvm.internal.s.h(onCreate$lambda$1, "onCreate$lambda$1");
        FKTitleBarLayout.setSingleTitle$default(onCreate$lambda$1, getString(R$string.feed_like_title, new Object[]{Integer.valueOf(intExtra)}), null, 2, null);
        onCreate$lambda$1.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedLikedUserListActivity$onCreate$2$1
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
                FeedLikedUserListActivity.this.finish();
            }
        });
    }
}
