package com.cupidapp.live.club.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKItemSwitchLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.dialog.h;
import com.cupidapp.live.club.activity.ClubEnterRequestListActivity;
import com.cupidapp.live.club.activity.ClubNoticeActivity;
import com.cupidapp.live.club.model.ClubInfoDetailModel;
import com.cupidapp.live.club.model.ClubInfoModel;
import com.cupidapp.live.club.model.ClubUserRoleType;
import com.cupidapp.live.club.model.DeleteSessionByDeleteAndExitClubEvent;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: ClubInfoDetailActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubInfoDetailActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f13481s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public String f13482q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13483r = new LinkedHashMap();

    /* compiled from: ClubInfoDetailActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ActivityResultLauncher<Intent> launcher, @NotNull String clubId) {
            s.i(context, "context");
            s.i(launcher, "launcher");
            s.i(clubId, "clubId");
            Intent intent = new Intent(context, (Class<?>) ClubInfoDetailActivity.class);
            intent.putExtra("CLUB_ID", clubId);
            launcher.launch(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: ClubInfoDetailActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13484a;

        static {
            int[] iArr = new int[ClubUserRoleType.values().length];
            try {
                iArr[ClubUserRoleType.COMMON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClubUserRoleType.OWNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClubUserRoleType.MANAGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f13484a = iArr;
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f13483r;
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
        setContentView(R$layout.activity_club_info_detail);
        String stringExtra = getIntent().getStringExtra("CLUB_ID");
        if (!(stringExtra == null || stringExtra.length() == 0)) {
            this.f13482q = stringExtra;
        }
        if (this.f13482q == null) {
            finish();
        } else {
            w1();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        v1();
    }

    public final void q1(final ClubInfoDetailModel clubInfoDetailModel) {
        FKItemLayout club_info_notice_layout = (FKItemLayout) j1(R$id.club_info_notice_layout);
        s.h(club_info_notice_layout, "club_info_notice_layout");
        y.d(club_info_notice_layout, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$bindClickEvent$1
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
                String str;
                ClubNoticeActivity.a aVar = ClubNoticeActivity.f13497t;
                ClubInfoDetailActivity clubInfoDetailActivity = ClubInfoDetailActivity.this;
                str = clubInfoDetailActivity.f13482q;
                if (str == null) {
                    s.A("mClubId");
                    str = null;
                }
                aVar.a(clubInfoDetailActivity, str, clubInfoDetailModel.getUserRole());
            }
        });
        FKItemLayout club_info_enter_request_layout = (FKItemLayout) j1(R$id.club_info_enter_request_layout);
        s.h(club_info_enter_request_layout, "club_info_enter_request_layout");
        y.d(club_info_enter_request_layout, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$bindClickEvent$2
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
                String str;
                ClubEnterRequestListActivity.a aVar = ClubEnterRequestListActivity.f13479r;
                ClubInfoDetailActivity clubInfoDetailActivity = ClubInfoDetailActivity.this;
                str = clubInfoDetailActivity.f13482q;
                if (str == null) {
                    s.A("mClubId");
                    str = null;
                }
                aVar.a(clubInfoDetailActivity, str);
            }
        });
        FKItemLayout club_info_invite_join_layout = (FKItemLayout) j1(R$id.club_info_invite_join_layout);
        s.h(club_info_invite_join_layout, "club_info_invite_join_layout");
        y.d(club_info_invite_join_layout, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$bindClickEvent$3
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
                j.a.b(j.f12156c, ClubInfoDetailActivity.this, clubInfoDetailModel.getDetailUrl(), null, 4, null);
            }
        });
        FKItemLayout club_info_report_layout = (FKItemLayout) j1(R$id.club_info_report_layout);
        s.h(club_info_report_layout, "club_info_report_layout");
        y.d(club_info_report_layout, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$bindClickEvent$4
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
                j.a.b(j.f12156c, this, n0.f12353a.c(ClubInfoDetailModel.this.getReportData(), "GroupProfile", null), null, 4, null);
            }
        });
        TextView club_info_delete_and_exit_btn = (TextView) j1(R$id.club_info_delete_and_exit_btn);
        s.h(club_info_delete_and_exit_btn, "club_info_delete_and_exit_btn");
        y.d(club_info_delete_and_exit_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$bindClickEvent$5
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
                ClubInfoDetailActivity.this.x1(clubInfoDetailModel);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.club_ignore_msg_layout)).setOnCheckedChangeListener(new Function1<Boolean, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$bindClickEvent$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                ClubInfoDetailActivity.this.s1(z10);
            }
        });
    }

    public final void r1() {
        String str = null;
        h.d(h.f12743a, null, false, 3, null);
        a2.a u10 = NetworkClient.f11868a.u();
        String str2 = this.f13482q;
        if (str2 == null) {
            s.A("mClubId");
        } else {
            str = str2;
        }
        Disposable disposed = u10.z(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$callDeleteAndExitClubApi$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                String str3;
                EventBus c4 = EventBus.c();
                str3 = ClubInfoDetailActivity.this.f13482q;
                if (str3 == null) {
                    s.A("mClubId");
                    str3 = null;
                }
                c4.o(new DeleteSessionByDeleteAndExitClubEvent(str3));
                h.f12743a.b();
                ClubInfoDetailActivity.this.setResult(-1, new Intent());
                ClubInfoDetailActivity.this.finish();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$callDeleteAndExitClubApi$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                h.f12743a.b();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void s1(final boolean z10) {
        ((FKItemSwitchLayout) j1(R$id.club_ignore_msg_layout)).setChecked(z10);
        a2.a u10 = NetworkClient.f11868a.u();
        String str = this.f13482q;
        if (str == null) {
            s.A("mClubId");
            str = null;
        }
        Disposable disposed = u10.m(str, z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$changeIgnoreMsgState$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$changeIgnoreMsgState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                ((FKItemSwitchLayout) ClubInfoDetailActivity.this.j1(R$id.club_ignore_msg_layout)).setChecked(!z10);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void t1(final User user, final ClubInfoModel clubInfoModel) {
        View layout = View.inflate(this, R$layout.layout_club_info_member_item, null);
        ImageLoaderView imageLoaderView = (ImageLoaderView) layout.findViewById(R$id.club_info_member_item_avatar);
        s.h(imageLoaderView, "layout.club_info_member_item_avatar");
        ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
        ((TextView) layout.findViewById(R$id.club_info_member_item_name)).setText(user.getNickname());
        TextView textView = (TextView) layout.findViewById(R$id.club_info_member_item_role);
        int i10 = b.f13484a[ClubUserRoleType.Companion.a(user.getUserRole()).ordinal()];
        if (i10 == 1) {
            textView.setVisibility(8);
        } else if (i10 == 2) {
            textView.setVisibility(0);
            textView.setText(getString(R$string.club_owner));
        } else if (i10 == 3) {
            textView.setVisibility(0);
            textView.setText(getString(R$string.club_manager));
        }
        s.h(layout, "layout");
        y.d(layout, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$configMemberItemData$1
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
                NearByMiniProfileActivity.f16517r.a(ClubInfoDetailActivity.this, new NearbyUserModel(user.userId(), false, false, false, false, false, user.getAvatarImage(), user.getNickname(), null, null, false, false, false, null, null, null, null, false, false, false, null, 2096958, null), SensorScene.GroupChat, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : clubInfoModel, (r27 & 1024) != 0 ? false : false);
            }
        });
        int l10 = (z0.h.l(this) - (z0.h.c(this, 8.0f) * 2)) / 5;
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.width = l10;
        ((GridLayout) j1(R$id.club_info_member_grid_layout)).addView(layout, layoutParams);
    }

    public final void u1(final ClubInfoDetailModel clubInfoDetailModel) {
        ((GridLayout) j1(R$id.club_info_member_grid_layout)).removeAllViews();
        List<User> members = clubInfoDetailModel.getMembers();
        if (members == null || members.isEmpty()) {
            return;
        }
        int i10 = 0;
        for (User user : members) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            User user2 = user;
            if (i10 < 10) {
                t1(user2, new ClubInfoModel(ClubUserRoleType.Companion.b(clubInfoDetailModel.getUserRole()) && !user2.isMyself(), clubInfoDetailModel.getId(), clubInfoDetailModel.getName()));
            }
            i10 = i11;
        }
        if (clubInfoDetailModel.getMemberCount() != null && clubInfoDetailModel.getMemberCount().intValue() > 10) {
            int i12 = R$id.club_info_view_more_members_layout;
            ((LinearLayout) j1(i12)).setVisibility(0);
            LinearLayout club_info_view_more_members_layout = (LinearLayout) j1(i12);
            s.h(club_info_view_more_members_layout, "club_info_view_more_members_layout");
            y.d(club_info_view_more_members_layout, new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$configMembersData$2
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
                    ClubMemberListActivity.f13489w.a(ClubInfoDetailActivity.this, clubInfoDetailModel.getId(), clubInfoDetailModel.getName(), clubInfoDetailModel.getMemberCount().intValue(), ClubUserRoleType.Companion.b(clubInfoDetailModel.getUserRole()));
                }
            });
            return;
        }
        ((LinearLayout) j1(R$id.club_info_view_more_members_layout)).setVisibility(8);
    }

    public final void v1() {
        a2.a u10 = NetworkClient.f11868a.u();
        String str = this.f13482q;
        if (str == null) {
            s.A("mClubId");
            str = null;
        }
        Disposable disposed = u10.c(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ClubInfoDetailModel, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$getClubInfoDetailData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ClubInfoDetailModel clubInfoDetailModel) {
                m2507invoke(clubInfoDetailModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2507invoke(ClubInfoDetailModel clubInfoDetailModel) {
                ClubInfoDetailModel clubInfoDetailModel2 = clubInfoDetailModel;
                ClubInfoDetailActivity.this.u1(clubInfoDetailModel2);
                FKTitleBarLayout club_info_title_bar = (FKTitleBarLayout) ClubInfoDetailActivity.this.j1(R$id.club_info_title_bar);
                s.h(club_info_title_bar, "club_info_title_bar");
                FKTitleBarLayout.setSingleTitle$default(club_info_title_bar, ClubInfoDetailActivity.this.getString(R$string.club_name_and_count, new Object[]{clubInfoDetailModel2.getName(), clubInfoDetailModel2.getMemberCount()}), null, 2, null);
                ((FKItemLayout) ClubInfoDetailActivity.this.j1(R$id.club_info_name_layout)).setFkValueText(clubInfoDetailModel2.getName());
                ((FKItemLayout) ClubInfoDetailActivity.this.j1(R$id.club_info_summary_layout)).setFkContentText(clubInfoDetailModel2.getSummary());
                if (ClubUserRoleType.Companion.b(clubInfoDetailModel2.getUserRole())) {
                    ClubInfoDetailActivity clubInfoDetailActivity = ClubInfoDetailActivity.this;
                    int i10 = R$id.club_info_enter_request_layout;
                    ((FKItemLayout) clubInfoDetailActivity.j1(i10)).setVisibility(0);
                    ((FKItemLayout) ClubInfoDetailActivity.this.j1(i10)).setFkValueRedTip(clubInfoDetailModel2.getNewApplyRedDot());
                } else {
                    ((FKItemLayout) ClubInfoDetailActivity.this.j1(R$id.club_info_enter_request_layout)).setVisibility(8);
                }
                ((FKItemSwitchLayout) ClubInfoDetailActivity.this.j1(R$id.club_ignore_msg_layout)).setChecked(clubInfoDetailModel2.getMsgSwitch());
                ClubInfoDetailActivity.this.q1(clubInfoDetailModel2);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void w1() {
        FKItemLayout initView$lambda$0 = (FKItemLayout) j1(R$id.club_info_summary_layout);
        initView$lambda$0.setValueLayoutEmpty();
        s.h(initView$lambda$0, "initView$lambda$0");
        int c4 = z0.h.c(initView$lambda$0, 15.0f);
        FKItemLayout.setHeadLayoutMargin$default(initView$lambda$0, null, Integer.valueOf(c4), null, Integer.valueOf(c4), 5, null);
        FKItemLayout.setContentTextMargin$default(initView$lambda$0, null, null, 0, null, 11, null);
        TextView club_info_delete_and_exit_btn = (TextView) j1(R$id.club_info_delete_and_exit_btn);
        s.h(club_info_delete_and_exit_btn, "club_info_delete_and_exit_btn");
        u.a(club_info_delete_and_exit_btn);
        ((FKTitleBarLayout) j1(R$id.club_info_title_bar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$initView$2
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
                ClubInfoDetailActivity.this.onBackPressed();
            }
        });
    }

    public final void x1(ClubInfoDetailModel clubInfoDetailModel) {
        int i10 = b.f13484a[ClubUserRoleType.Companion.a(clubInfoDetailModel.getUserRole()).ordinal()];
        if (i10 == 1) {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.club_common_exit_club_tips, 0, 2, null), 0, null, new Function0<p>() { // from class: com.cupidapp.live.club.activity.ClubInfoDetailActivity$showDeleteAndExitClubAlert$1
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
                    ClubInfoDetailActivity.this.r1();
                }
            }, 3, null), 0, null, 3, null), null, 1, null);
        } else if (i10 == 2 || i10 == 3) {
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.club_owner_or_manager_exit_club_tips, 0, 2, null), R$string.i_know, null, null, 6, null), null, 1, null);
        }
    }
}
