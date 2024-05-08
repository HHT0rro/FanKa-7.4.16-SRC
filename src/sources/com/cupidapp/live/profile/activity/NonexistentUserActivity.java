package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.profile.holder.RelationType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NonexistentUserActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NonexistentUserActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17639r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17640q = new LinkedHashMap();

    /* compiled from: NonexistentUserActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull RelationType relationType) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(relationType, "relationType");
            Intent intent = new Intent(context, (Class<?>) NonexistentUserActivity.class);
            z0.g.c(intent, relationType);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17640q;
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
        setContentView(R$layout.activity_nonexistent_user);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        RelationType relationType = (RelationType) z0.g.a(intent, RelationType.class);
        if (relationType == null) {
            return;
        }
        int i10 = R$id.nonexistentUserTitleLayout;
        FKTitleBarLayout nonexistentUserTitleLayout = (FKTitleBarLayout) j1(i10);
        kotlin.jvm.internal.s.h(nonexistentUserTitleLayout, "nonexistentUserTitleLayout");
        FKTitleBarLayout.setSingleTitle$default(nonexistentUserTitleLayout, getString(R$string.nonexistent_user_title, new Object[]{relationType.getType()}), null, 2, null);
        ((FKTitleBarLayout) j1(i10)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.NonexistentUserActivity$onCreate$1
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
                NonexistentUserActivity.this.onBackPressed();
            }
        });
        FKBaseActivity.g1(this, NonexistentUserFragment.f17641l.a(relationType), false, R$id.nonexistentUserContainerLayout, false, false, 24, null);
    }
}
