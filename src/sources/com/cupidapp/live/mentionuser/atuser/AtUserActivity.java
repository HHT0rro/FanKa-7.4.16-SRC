package com.cupidapp.live.mentionuser.atuser;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.utils.g;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.main.model.SearchResult;
import com.cupidapp.live.mentionuser.model.AtUserModel;
import com.cupidapp.live.mentionuser.model.AtUserTitleUIModel;
import com.cupidapp.live.mentionuser.model.RecentAtUserUIModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.search.model.SearchModel;
import com.cupidapp.live.track.group.AtSelectType;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.h;
import z0.y;

/* compiled from: AtUserActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AtUserActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f17473u = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public AtUserModel f17475r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public Disposable f17476s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17477t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17474q = c.b(new Function0<AtUserAdapter>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$resultAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AtUserAdapter invoke() {
            final AtUserActivity atUserActivity = AtUserActivity.this;
            AtUserAdapter atUserAdapter = new AtUserAdapter(new Function1<User, p>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$resultAdapter$2.1
                {
                    super(1);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable User user) {
                    GroupSocialLog.f18708a.a(AtSelectType.RECENTLY);
                    AtUserActivity.this.z1(user);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(User user) {
                    invoke2(user);
                    return p.f51048a;
                }
            });
            final AtUserActivity atUserActivity2 = AtUserActivity.this;
            atUserAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$resultAdapter$2$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof SearchModel) {
                        GroupSocialLog.f18708a.a(AtSelectType.SEARCH);
                        AtUserActivity.this.z1(((SearchModel) obj).getUser());
                    } else if (obj instanceof User) {
                        GroupSocialLog.f18708a.a(AtSelectType.PROBABLY);
                        AtUserActivity.this.z1((User) obj);
                    }
                }
            });
            return atUserAdapter;
        }
    });

    /* compiled from: AtUserActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, int i10, boolean z10) {
            s.i(activity, "activity");
            Intent intent = new Intent(activity, (Class<?>) AtUserActivity.class);
            intent.putExtra("hasInsertAtSymbol", z10);
            activity.startActivityForResult(intent, i10);
            FKBaseActivity.f11750o.b(activity, R$anim.alpha_in, R$anim.anim_activity_nothing);
        }

        public final void b(@NotNull Fragment fragment, int i10, boolean z10) {
            s.i(fragment, "fragment");
            Intent intent = new Intent(fragment.getContext(), (Class<?>) AtUserActivity.class);
            intent.putExtra("hasInsertAtSymbol", z10);
            fragment.startActivityForResult(intent, i10);
            FKBaseActivity.f11750o.b(fragment.getContext(), R$anim.alpha_in, R$anim.anim_activity_nothing);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17477t;
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
        setContentView(R$layout.activity_at_user);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.alpha_out));
        ConstraintLayout titleLayout = (ConstraintLayout) j1(R$id.titleLayout);
        s.h(titleLayout, "titleLayout");
        h.u(this, titleLayout);
        w1();
        t1();
    }

    public final void t1() {
        AtUserModel atUserModel = this.f17475r;
        if (atUserModel != null) {
            x1(atUserModel);
            return;
        }
        Disposable disposed = NetworkClient.f11868a.l().W().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AtUserModel, p>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$configAtUserData$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AtUserModel atUserModel2) {
                m2741invoke(atUserModel2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2741invoke(AtUserModel atUserModel2) {
                AtUserModel atUserModel3 = atUserModel2;
                AtUserActivity.this.f17475r = atUserModel3;
                AtUserActivity.this.x1(atUserModel3);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$configAtUserData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                AtUserModel atUserModel2;
                s.i(it, "it");
                AtUserActivity atUserActivity = AtUserActivity.this;
                atUserModel2 = atUserActivity.f17475r;
                atUserActivity.x1(atUserModel2);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final AtUserAdapter u1() {
        return (AtUserAdapter) this.f17474q.getValue();
    }

    public final void v1(SearchResult searchResult) {
        ArrayList arrayList;
        u1().j().clear();
        List<User> list = searchResult.getList();
        if (list != null) {
            arrayList = new ArrayList(t.t(list, 10));
            Iterator<User> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new SearchModel(searchResult.getKeyword(), iterator2.next()));
            }
        } else {
            arrayList = null;
        }
        boolean z10 = false;
        if (arrayList != null && (!arrayList.isEmpty())) {
            z10 = true;
        }
        if (z10) {
            u1().e(CollectionsKt___CollectionsKt.z0(arrayList));
        }
        u1().notifyDataSetChanged();
    }

    public final void w1() {
        int i10 = R$id.searchEditText;
        ((EditText) j1(i10)).setHint(R$string.search_at);
        int i11 = R$id.at_user_rv;
        ((RecyclerView) j1(i11)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) j1(i11)).setAdapter(u1());
        ((RecyclerView) j1(i11)).addItemDecoration(new FKAddExtraSpacingDecoration(0, 0, 0, 0, 0, h.c(this, 48.0f)));
        ((RecyclerView) j1(i11)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$initView$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i12) {
                s.i(recyclerView, "recyclerView");
                AtUserActivity atUserActivity = AtUserActivity.this;
                h.p(atUserActivity, (EditText) atUserActivity.j1(R$id.searchEditText));
            }
        });
        new g(r.e((EditText) j1(i10)), new Function1<Boolean, p>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                Disposable disposable;
                if (z10) {
                    AtUserActivity.this.y1(true);
                    disposable = AtUserActivity.this.f17476s;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    AtUserActivity atUserActivity = AtUserActivity.this;
                    Observable delay = a.C0836a.e(NetworkClient.f11868a.N(), ((EditText) AtUserActivity.this.j1(R$id.searchEditText)).getText().toString(), null, 2, null).delay(500L, TimeUnit.MILLISECONDS);
                    s.h(delay, "NetworkClient.userServic…L, TimeUnit.MILLISECONDS)");
                    final AtUserActivity atUserActivity2 = AtUserActivity.this;
                    Disposable disposed = delay.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SearchResult, p>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$initView$2$invoke$$inlined$handle$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(SearchResult searchResult) {
                            m2742invoke(searchResult);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2742invoke(SearchResult searchResult) {
                            SearchResult searchResult2 = searchResult;
                            Editable text = ((EditText) AtUserActivity.this.j1(R$id.searchEditText)).getText();
                            s.h(text, "searchEditText.text");
                            if (text.length() == 0) {
                                ((ImageView) AtUserActivity.this.j1(R$id.clearButton)).setVisibility(8);
                                ((ProgressBar) AtUserActivity.this.j1(R$id.loadingView)).setVisibility(8);
                            } else {
                                AtUserActivity.this.y1(false);
                                AtUserActivity.this.v1(searchResult2);
                            }
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$initView$2.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull Throwable it) {
                            s.i(it, "it");
                            AtUserActivity.this.y1(false);
                            return Boolean.FALSE;
                        }
                    }, atUserActivity2)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (atUserActivity2 != null) {
                            atUserActivity2.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                    atUserActivity.f17476s = disposed;
                    return;
                }
                ((ProgressBar) AtUserActivity.this.j1(R$id.loadingView)).setVisibility(8);
                ((ImageView) AtUserActivity.this.j1(R$id.clearButton)).setVisibility(8);
                AtUserActivity.this.t1();
                AtUserActivity atUserActivity3 = AtUserActivity.this;
                EditText searchEditText = (EditText) atUserActivity3.j1(R$id.searchEditText);
                s.h(searchEditText, "searchEditText");
                h.v(atUserActivity3, searchEditText);
            }
        });
        ImageView clearButton = (ImageView) j1(R$id.clearButton);
        s.h(clearButton, "clearButton");
        y.d(clearButton, new Function1<View, p>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$initView$3
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
                ((EditText) AtUserActivity.this.j1(R$id.searchEditText)).setText("");
            }
        });
        int i12 = R$id.cancelTextView;
        TextView cancelTextView = (TextView) j1(i12);
        s.h(cancelTextView, "cancelTextView");
        y.d(cancelTextView, new Function1<View, p>() { // from class: com.cupidapp.live.mentionuser.atuser.AtUserActivity$initView$4
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
                h.q(AtUserActivity.this, null, 1, null);
                AtUserActivity.this.finish();
            }
        });
        int i13 = R$id.titleLayout;
        ((ConstraintLayout) j1(i13)).setVisibility(0);
        ObjectAnimator.ofFloat((ConstraintLayout) j1(i13), (Property<ConstraintLayout, Float>) View.Y, -200.0f, 0.0f).setDuration(300L).start();
        ((TextView) j1(i12)).getPaint().setFakeBoldText(true);
    }

    public final void x1(AtUserModel atUserModel) {
        u1().j().clear();
        if ((atUserModel != null ? atUserModel.getAtList() : null) != null && (!atUserModel.getAtList().isEmpty())) {
            AtUserAdapter u12 = u1();
            String string = getString(R$string.recent_at);
            s.h(string, "getString(R.string.recent_at)");
            u12.d(new AtUserTitleUIModel(string));
            u1().d(new RecentAtUserUIModel(atUserModel.getAtList()));
        }
        if ((atUserModel != null ? atUserModel.getRcmdList() : null) != null && (!atUserModel.getRcmdList().isEmpty())) {
            AtUserAdapter u13 = u1();
            String string2 = getString(R$string.recommend_at);
            s.h(string2, "getString(R.string.recommend_at)");
            u13.d(new AtUserTitleUIModel(string2));
            u1().e(atUserModel.getRcmdList());
        }
        u1().notifyDataSetChanged();
    }

    public final void y1(boolean z10) {
        if (z10) {
            ((ImageView) j1(R$id.clearButton)).setVisibility(4);
            ((ProgressBar) j1(R$id.loadingView)).setVisibility(0);
        } else {
            ((ImageView) j1(R$id.clearButton)).setVisibility(0);
            ((ProgressBar) j1(R$id.loadingView)).setVisibility(4);
        }
    }

    public final void z1(User user) {
        Intent intent = new Intent();
        intent.putExtra(UserData.NAME, user);
        intent.putExtra("hasInsertAtSymbol", getIntent().getBooleanExtra("hasInsertAtSymbol", false));
        setResult(-1, intent);
        h.q(this, null, 1, null);
        finish();
    }
}
