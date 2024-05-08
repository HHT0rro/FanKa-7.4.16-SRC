package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.setting.model.LimitRangeType;
import com.cupidapp.live.setting.viewmodel.PostLimitSettingViewModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitSettingActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostLimitSettingActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f17991u = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17992q;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17995t = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17993r = kotlin.c.b(new Function0<List<LimitRangeModel>>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$rangeReadLimitList$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<LimitRangeModel> invoke() {
            LimitRangeType limitRangeType = LimitRangeType.PUBLIC;
            String string = PostLimitSettingActivity.this.getString(R$string.open);
            kotlin.jvm.internal.s.h(string, "getString(R.string.open)");
            LimitRangeType limitRangeType2 = LimitRangeType.FANS;
            String string2 = PostLimitSettingActivity.this.getString(R$string.fans);
            kotlin.jvm.internal.s.h(string2, "getString(R.string.fans)");
            LimitRangeType limitRangeType3 = LimitRangeType.MATCH;
            String string3 = PostLimitSettingActivity.this.getString(R$string.only_match);
            kotlin.jvm.internal.s.h(string3, "getString(R.string.only_match)");
            return kotlin.collections.s.o(new LimitRangeModel(limitRangeType, string, PostLimitSettingActivity.this.getString(R$string.all_can_see), null, 8, null), new LimitRangeModel(limitRangeType2, string2, PostLimitSettingActivity.this.getString(R$string.fans_can_see), null, 8, null), new LimitRangeModel(limitRangeType3, string3, PostLimitSettingActivity.this.getString(R$string.only_match_can_see), null, 8, null));
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17994s = kotlin.c.b(new Function0<List<LimitRangeModel>>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$rangeMsgLimitList$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<LimitRangeModel> invoke() {
            LimitRangeType limitRangeType = LimitRangeType.PUBLIC;
            String string = PostLimitSettingActivity.this.getString(R$string.all_people);
            kotlin.jvm.internal.s.h(string, "getString(R.string.all_people)");
            LimitRangeType limitRangeType2 = LimitRangeType.FANS;
            String string2 = PostLimitSettingActivity.this.getString(R$string.fans);
            kotlin.jvm.internal.s.h(string2, "getString(R.string.fans)");
            LimitRangeType limitRangeType3 = LimitRangeType.MATCH;
            String string3 = PostLimitSettingActivity.this.getString(R$string.only_match);
            kotlin.jvm.internal.s.h(string3, "getString(R.string.only_match)");
            return kotlin.collections.s.o(new LimitRangeModel(limitRangeType, string, null, null, 8, null), new LimitRangeModel(limitRangeType2, string2, PostLimitSettingActivity.this.getString(R$string.only_follow_can_chat), null, 8, null), new LimitRangeModel(limitRangeType3, string3, PostLimitSettingActivity.this.getString(R$string.only_match_can_chat), null, 8, null));
        }
    });

    /* compiled from: PostLimitSettingActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            context.startActivity(new Intent(context, (Class<?>) PostLimitSettingActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public PostLimitSettingActivity() {
        final Function0 function0 = null;
        this.f17992q = new ViewModelLazy(kotlin.jvm.internal.v.b(PostLimitSettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$special$$inlined$viewModels$default$3
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
                kotlin.jvm.internal.s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void t1(PostLimitSettingActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        if (it.booleanValue()) {
            FKTitleBarLayout title_view = (FKTitleBarLayout) this$0.m1(R$id.title_view);
            kotlin.jvm.internal.s.h(title_view, "title_view");
            FKTitleBarLayout.setRightText$default(title_view, this$0.getString(R$string.done), 0, 0, false, 10, null);
        } else {
            FKTitleBarLayout title_view2 = (FKTitleBarLayout) this$0.m1(R$id.title_view);
            kotlin.jvm.internal.s.h(title_view2, "title_view");
            FKTitleBarLayout.setRightText$default(title_view2, null, 0, 8, false, 10, null);
        }
    }

    public static final void u1(PostLimitSettingActivity this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            LimitRangeType limitRangeType = (LimitRangeType) stateResult.getData();
            if (limitRangeType == null) {
                limitRangeType = LimitRangeType.PUBLIC;
            }
            Iterator<LimitRangeModel> iterator2 = this$0.q1().iterator2();
            while (iterator2.hasNext()) {
                this$0.x1(iterator2.next(), limitRangeType);
            }
        }
    }

    public static final void v1(PostLimitSettingActivity this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            LimitRangeType limitRangeType = (LimitRangeType) stateResult.getData();
            if (limitRangeType == null) {
                limitRangeType = LimitRangeType.PUBLIC;
            }
            Iterator<LimitRangeModel> iterator2 = this$0.p1().iterator2();
            while (iterator2.hasNext()) {
                this$0.x1(iterator2.next(), limitRangeType);
            }
        }
    }

    @Nullable
    public View m1(int i10) {
        Map<Integer, View> map = this.f17995t;
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

    public final void o1(final LimitRangeModel limitRangeModel, LinearLayout linearLayout, final Function1<? super LimitRangeType, kotlin.p> function1) {
        View itemView = LayoutInflater.from(this).inflate(R$layout.item_publish_range, (ViewGroup) null);
        TextView textView = (TextView) itemView.findViewById(R$id.item_range_title);
        TextView textView2 = (TextView) itemView.findViewById(R$id.item_range_content);
        View findViewById = itemView.findViewById(R$id.item_range_checked);
        textView.setText(limitRangeModel.getTitle());
        String content = limitRangeModel.getContent();
        if (content == null || content.length() == 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(limitRangeModel.getContent());
        }
        findViewById.setVisibility(4);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        z0.y.d(itemView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$addChildView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                function1.invoke(limitRangeModel.getType());
            }
        });
        limitRangeModel.setItemView(itemView);
        if (linearLayout != null) {
            linearLayout.addView(itemView, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_post_limit_setting);
        w1();
        s1();
    }

    public final List<LimitRangeModel> p1() {
        return (List) this.f17994s.getValue();
    }

    public final List<LimitRangeModel> q1() {
        return (List) this.f17993r.getValue();
    }

    public final PostLimitSettingViewModel r1() {
        return (PostLimitSettingViewModel) this.f17992q.getValue();
    }

    public final void s1() {
        r1().getDoneBtnLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PostLimitSettingActivity.t1(PostLimitSettingActivity.this, (Boolean) obj);
            }
        });
        r1().getSaveSucLiveDataEvent().observe(this, new EventObserver(new Function1<kotlin.p, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(kotlin.p pVar) {
                invoke2(pVar);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull kotlin.p it) {
                kotlin.jvm.internal.s.i(it, "it");
                com.cupidapp.live.base.view.h hVar = com.cupidapp.live.base.view.h.f12779a;
                PostLimitSettingActivity postLimitSettingActivity = PostLimitSettingActivity.this;
                hVar.d(postLimitSettingActivity, postLimitSettingActivity.getString(R$string.save_success));
                PostLimitSettingActivity.this.finish();
            }
        }));
        r1().getReadLimitLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PostLimitSettingActivity.u1(PostLimitSettingActivity.this, (StateResult) obj);
            }
        });
        r1().getMsgLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PostLimitSettingActivity.v1(PostLimitSettingActivity.this, (StateResult) obj);
            }
        });
    }

    public final void w1() {
        int i10 = R$id.title_view;
        ((FKTitleBarLayout) m1(i10)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$initView$1
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
                PostLimitSettingActivity.this.finish();
            }
        });
        ((FKTitleBarLayout) m1(i10)).setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$initView$2
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
                PostLimitSettingViewModel r12;
                r12 = PostLimitSettingActivity.this.r1();
                r12.saveSetting();
            }
        });
        Iterator<LimitRangeModel> iterator2 = q1().iterator2();
        while (iterator2.hasNext()) {
            o1(iterator2.next(), (LinearLayout) m1(R$id.read_limit_ll), new Function1<LimitRangeType, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$initView$3$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(LimitRangeType limitRangeType) {
                    invoke2(limitRangeType);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull LimitRangeType it) {
                    PostLimitSettingViewModel r12;
                    kotlin.jvm.internal.s.i(it, "it");
                    r12 = PostLimitSettingActivity.this.r1();
                    r12.readLimitChange(it);
                }
            });
        }
        Iterator<LimitRangeModel> iterator22 = p1().iterator2();
        while (iterator22.hasNext()) {
            o1(iterator22.next(), (LinearLayout) m1(R$id.msg_limit_ll), new Function1<LimitRangeType, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PostLimitSettingActivity$initView$4$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(LimitRangeType limitRangeType) {
                    invoke2(limitRangeType);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull LimitRangeType it) {
                    PostLimitSettingViewModel r12;
                    kotlin.jvm.internal.s.i(it, "it");
                    r12 = PostLimitSettingActivity.this.r1();
                    r12.msgLimitChange(it);
                }
            });
        }
    }

    public final void x1(LimitRangeModel limitRangeModel, LimitRangeType limitRangeType) {
        View itemView = limitRangeModel.getItemView();
        View findViewById = itemView != null ? itemView.findViewById(R$id.item_range_checked) : null;
        if (findViewById != null) {
            if (limitRangeModel.getType() == limitRangeType) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(4);
            }
        }
    }
}
