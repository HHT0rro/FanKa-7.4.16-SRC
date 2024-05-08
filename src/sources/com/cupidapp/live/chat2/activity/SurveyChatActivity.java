package com.cupidapp.live.chat2.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.chat2.adapter.SurveyChatAdapter;
import com.cupidapp.live.chat2.holder.SelectionOptionEvent;
import com.cupidapp.live.chat2.model.BaseSurveyChatMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatOptionsMessageModel;
import com.cupidapp.live.chat2.model.SurveyChatOptionsModel;
import com.cupidapp.live.chat2.model.SurveyChatUserInfoModel;
import com.cupidapp.live.chat2.view.SurveyChatTitleLayout;
import com.cupidapp.live.chat2.view.k;
import com.cupidapp.live.chat2.viewmodel.SurveyChatViewModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import he.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SurveyChatActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f13293u = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f13295r;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13297t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f13294q = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$chatId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return SurveyChatActivity.this.getIntent().getStringExtra("SURVEY_CHAT_ID");
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f13296s = kotlin.c.b(new Function0<SurveyChatAdapter>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$chatAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SurveyChatAdapter invoke() {
            return new SurveyChatAdapter();
        }
    });

    /* compiled from: SurveyChatActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable String str) {
            Intent intent = new Intent(context, (Class<?>) SurveyChatActivity.class);
            intent.putExtra("SURVEY_CHAT_ID", str);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: SurveyChatActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements k {
        public b() {
        }

        @Override // com.cupidapp.live.chat2.view.k
        public void a() {
            SurveyChatActivity.this.finish();
        }

        @Override // com.cupidapp.live.chat2.view.k
        public void b() {
            SurveyChatActivity.this.o1().openProfile();
        }
    }

    /* compiled from: SurveyChatActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements Observer, p {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f13299a;

        public c(Function1 function) {
            s.i(function, "function");
            this.f13299a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof p)) {
                return s.d(getFunctionDelegate(), ((p) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.p
        @NotNull
        public final kotlin.b<?> getFunctionDelegate() {
            return this.f13299a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f13299a.invoke(obj);
        }
    }

    public SurveyChatActivity() {
        final Function0 function0 = null;
        this.f13295r = new ViewModelLazy(v.b(SurveyChatViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$special$$inlined$viewModels$default$3
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

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f13297t;
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

    public final SurveyChatAdapter m1() {
        return (SurveyChatAdapter) this.f13296s.getValue();
    }

    public final String n1() {
        return (String) this.f13294q.getValue();
    }

    public final SurveyChatViewModel o1() {
        return (SurveyChatViewModel) this.f13295r.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_survey_chat);
        r1();
        q1();
        p1();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SelectionOptionEvent event) {
        s.i(event, "event");
        s1(event.getMessageId(), event.getOptionId());
    }

    public final void p1() {
        String n12 = n1();
        if (n12 == null || n12.length() == 0) {
            finish();
            return;
        }
        SurveyChatViewModel o12 = o1();
        String n13 = n1();
        s.f(n13);
        o12.getOperationMessageInfo(n13);
    }

    public final void q1() {
        o1().getSurveyChatUserInfoLiveData().observe(this, new c(new Function1<SurveyChatUserInfoModel, kotlin.p>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SurveyChatUserInfoModel surveyChatUserInfoModel) {
                invoke2(surveyChatUserInfoModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SurveyChatUserInfoModel it) {
                SurveyChatTitleLayout surveyChatTitleLayout = (SurveyChatTitleLayout) SurveyChatActivity.this.j1(R$id.survey_chat_title_layout);
                s.h(it, "it");
                surveyChatTitleLayout.c(it);
            }
        }));
        o1().getSurveyChatMessageListLiveData().observe(this, new c(new Function1<List<? extends BaseSurveyChatMessageModel>, kotlin.p>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends BaseSurveyChatMessageModel> list) {
                invoke2(list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends BaseSurveyChatMessageModel> list) {
                SurveyChatAdapter m12;
                SurveyChatAdapter m13;
                SurveyChatAdapter m14;
                SurveyChatAdapter m15;
                m12 = SurveyChatActivity.this.m1();
                int size = m12.j().size();
                m13 = SurveyChatActivity.this.m1();
                m13.e(list);
                m14 = SurveyChatActivity.this.m1();
                int size2 = m14.j().size();
                m15 = SurveyChatActivity.this.m1();
                m15.notifyItemRangeInserted(size, size2);
                ((RecyclerView) SurveyChatActivity.this.j1(R$id.survey_chat_recyclerview)).scrollToPosition(size2 - 1);
            }
        }));
        o1().getRefreshMessageStatusLiveData().observe(this, new c(new Function1<Pair<? extends String, ? extends String>, kotlin.p>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends String, ? extends String> pair) {
                invoke2((Pair<String, String>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, String> pair) {
                SurveyChatAdapter m12;
                Object obj;
                SurveyChatAdapter m13;
                SurveyChatAdapter m14;
                m12 = SurveyChatActivity.this.m1();
                List<Object> j10 = m12.j();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : j10) {
                    if (obj2 instanceof BaseSurveyChatMessageModel) {
                        arrayList.add(obj2);
                    }
                }
                Iterator<E> iterator2 = arrayList.iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        obj = iterator2.next();
                        if (s.d(((BaseSurveyChatMessageModel) obj).getId(), pair.getFirst())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                BaseSurveyChatMessageModel baseSurveyChatMessageModel = (BaseSurveyChatMessageModel) obj;
                if (baseSurveyChatMessageModel instanceof SurveyChatOptionsMessageModel) {
                    for (SurveyChatOptionsModel surveyChatOptionsModel : ((SurveyChatOptionsMessageModel) baseSurveyChatMessageModel).getOptions()) {
                        surveyChatOptionsModel.setSelected(s.d(surveyChatOptionsModel.getOptionId(), pair.getSecond()));
                        surveyChatOptionsModel.setSelectable(false);
                    }
                    m13 = SurveyChatActivity.this.m1();
                    int indexOf = m13.j().indexOf(baseSurveyChatMessageModel);
                    m14 = SurveyChatActivity.this.m1();
                    m14.notifyItemChanged(indexOf);
                }
            }
        }));
        o1().getOpenProfileEventLiveData().observe(this, new EventObserver(new Function1<User, kotlin.p>() { // from class: com.cupidapp.live.chat2.activity.SurveyChatActivity$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(User user) {
                invoke2(user);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull User it) {
                s.i(it, "it");
                UserProfileActivity.G.a(SurveyChatActivity.this, it, new ProfileSensorContext(ViewProfilePrefer.ChatToProfile.getValue(), null, it.getMe(), SensorPosition.ChatRoom, null, null), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
            }
        }));
    }

    public final void r1() {
        RecyclerView recyclerView = (RecyclerView) j1(R$id.survey_chat_recyclerview);
        recyclerView.setAdapter(m1());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        ((SurveyChatTitleLayout) j1(R$id.survey_chat_title_layout)).setListener(new b());
    }

    public final void s1(String str, String str2) {
        String n12 = n1();
        if (n12 == null || n12.length() == 0) {
            return;
        }
        SurveyChatViewModel o12 = o1();
        String n13 = n1();
        s.f(n13);
        o12.selectOption(n13, str, str2);
    }
}
