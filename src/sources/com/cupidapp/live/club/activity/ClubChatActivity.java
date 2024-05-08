package com.cupidapp.live.club.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.activity.g;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.club.activity.ClubInfoDetailActivity;
import com.cupidapp.live.club.fragment.ClubChatEventFragment;
import com.cupidapp.live.club.fragment.ClubChatRoomFragment;
import com.cupidapp.live.club.model.ClubInfoDetailModel;
import com.cupidapp.live.club.model.ClubUserRoleType;
import com.cupidapp.live.club.view.ClubChatTitleLayout;
import com.cupidapp.live.club.view.i;
import com.cupidapp.live.club.viewmodel.ClubChatRoomViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatActivity extends FKBaseActivity {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f13469x = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public String f13470q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f13471r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public ClubChatRoomFragment f13472s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public ClubChatEventFragment f13473t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public ActivityResultLauncher<Intent> f13474u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13475v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13476w = new LinkedHashMap();

    /* compiled from: ClubChatActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull String clubId) {
            s.i(clubId, "clubId");
            Intent intent = new Intent(context, (Class<?>) ClubChatActivity.class);
            intent.putExtra("CLUB_ID", clubId);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: ClubChatActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements i {
        public b() {
        }

        @Override // com.cupidapp.live.club.view.i
        public void a() {
            ClubChatActivity.this.onBackPressed();
        }

        @Override // com.cupidapp.live.club.view.i
        public void b() {
            ActivityResultLauncher<Intent> activityResultLauncher = ClubChatActivity.this.f13474u;
            if (activityResultLauncher != null) {
                ClubChatActivity clubChatActivity = ClubChatActivity.this;
                ClubInfoDetailActivity.a aVar = ClubInfoDetailActivity.f13481s;
                String str = clubChatActivity.f13470q;
                if (str == null) {
                    s.A("mClubId");
                    str = null;
                }
                aVar.a(clubChatActivity, activityResultLauncher, str);
            }
        }

        @Override // com.cupidapp.live.club.view.i
        public void c() {
            ClubChatActivity.this.x1();
        }

        @Override // com.cupidapp.live.club.view.i
        public void d() {
            ClubChatActivity.this.y1();
        }
    }

    /* compiled from: ClubChatActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements g {
        public c() {
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            ClubChatRoomFragment clubChatRoomFragment = ClubChatActivity.this.f13472s;
            if (clubChatRoomFragment != null) {
                return clubChatRoomFragment.onBackPressed();
            }
            return false;
        }
    }

    public ClubChatActivity() {
        final Function0 function0 = null;
        this.f13471r = new ViewModelLazy(v.b(ClubChatRoomViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.club.activity.ClubChatActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.club.activity.ClubChatActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.club.activity.ClubChatActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void u1(ClubChatActivity this$0, ClubInfoDetailModel model) {
        s.i(this$0, "this$0");
        ClubChatTitleLayout clubChatTitleLayout = (ClubChatTitleLayout) this$0.l1(R$id.club_chat_title_layout);
        s.h(model, "model");
        clubChatTitleLayout.f(model);
    }

    public static final void w1(ClubChatActivity this$0, ActivityResult activityResult) {
        s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.finish();
        }
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f13476w;
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
        setContentView(R$layout.activity_club_chat);
        String stringExtra = getIntent().getStringExtra("CLUB_ID");
        if (!(stringExtra == null || stringExtra.length() == 0)) {
            this.f13470q = stringExtra;
        }
        if (this.f13470q == null) {
            finish();
            return;
        }
        this.f13475v = true;
        ClubChatRoomViewModel s12 = s1();
        String str = this.f13470q;
        if (str == null) {
            s.A("mClubId");
            str = null;
        }
        s12.initClubInfo(str);
        t1();
        r1();
        y1();
        v1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f13475v) {
            this.f13475v = false;
        } else {
            s1().loadClubInfo();
        }
    }

    public final void r1() {
        ((ClubChatTitleLayout) l1(R$id.club_chat_title_layout)).setListener(new b());
        z0(new c());
    }

    public final ClubChatRoomViewModel s1() {
        return (ClubChatRoomViewModel) this.f13471r.getValue();
    }

    public final void t1() {
        s1().getClubInfo().observe(this, new Observer() { // from class: com.cupidapp.live.club.activity.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubChatActivity.u1(ClubChatActivity.this, (ClubInfoDetailModel) obj);
            }
        });
        s1().getNewEnterRequest().observe(this, new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.club.activity.ClubChatActivity$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((ClubChatTitleLayout) ClubChatActivity.this.l1(R$id.club_chat_title_layout)).h();
            }
        }));
    }

    public final void v1() {
        this.f13474u = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.club.activity.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ClubChatActivity.w1(ClubChatActivity.this, (ActivityResult) obj);
            }
        });
    }

    public final void x1() {
        ClubChatRoomFragment clubChatRoomFragment = this.f13472s;
        if (clubChatRoomFragment != null) {
            clubChatRoomFragment.r1();
        }
        if (this.f13473t == null) {
            ClubInfoDetailModel m2515getClubInfo = s1().m2515getClubInfo();
            if (m2515getClubInfo == null) {
                return;
            } else {
                this.f13473t = ClubChatEventFragment.f13546k.a(m2515getClubInfo.getId(), ClubUserRoleType.Companion.b(m2515getClubInfo.getUserRole()), m2515getClubInfo.getActivityCreationUrl());
            }
        }
        FKBaseActivity.g1(this, this.f13473t, false, R$id.club_chat_fragment_layout, false, false, 16, null);
        j1.c.b(j1.c.f50228a, SensorPosition.ClubGroupActivity, null, null, 6, null);
    }

    public final void y1() {
        if (this.f13472s == null) {
            ClubChatRoomFragment.a aVar = ClubChatRoomFragment.f13553n;
            String str = this.f13470q;
            if (str == null) {
                s.A("mClubId");
                str = null;
            }
            this.f13472s = aVar.a(str);
        }
        FKBaseActivity.g1(this, this.f13472s, false, R$id.club_chat_fragment_layout, false, false, 16, null);
        j1.c.b(j1.c.f50228a, SensorPosition.ClubGroupChat, null, null, 6, null);
    }
}
