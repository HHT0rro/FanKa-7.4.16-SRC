package com.cupidapp.live.club.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.club.fragment.ClubEnterRequestListFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubEnterRequestListActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubEnterRequestListActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f13479r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13480q = new LinkedHashMap();

    /* compiled from: ClubEnterRequestListActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String clubId) {
            s.i(context, "context");
            s.i(clubId, "clubId");
            Intent intent = new Intent(context, (Class<?>) ClubEnterRequestListActivity.class);
            intent.putExtra("CLUB_ENTER_REQUEST_CLUB_ID", clubId);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f13480q;
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
        setContentView(R$layout.activity_club_enter_request);
        String stringExtra = getIntent().getStringExtra("CLUB_ENTER_REQUEST_CLUB_ID");
        if (stringExtra == null || stringExtra.length() == 0) {
            finish();
        } else {
            FKBaseActivity.g1(this, ClubEnterRequestListFragment.f13567l.a(stringExtra), false, R$id.club_enter_request_frame_layout, false, false, 24, null);
            ((FKTitleBarLayout) j1(R$id.club_enter_request_title_bar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubEnterRequestListActivity$onCreate$1
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
                    ClubEnterRequestListActivity.this.onBackPressed();
                }
            });
        }
    }
}
