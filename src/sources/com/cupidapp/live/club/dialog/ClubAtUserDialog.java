package com.cupidapp.live.club.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.club.adapter.ClubAtUserListAdapter;
import com.cupidapp.live.profile.model.User;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: ClubAtUserDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubAtUserDialog extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f13520j = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f13521b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Disposable f13522c;

    /* renamed from: d, reason: collision with root package name */
    public int f13523d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public f f13524e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public AlertDialog f13525f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public List<User> f13526g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public BehaviorSubject<String> f13527h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13528i;

    /* compiled from: ClubAtUserDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubAtUserDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new ClubAtUserDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubAtUserDialog(Context context) {
        super(context);
        this.f13528i = new LinkedHashMap();
        this.f13521b = kotlin.c.b(new Function0<ClubAtUserListAdapter>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ClubAtUserListAdapter invoke() {
                ClubAtUserListAdapter clubAtUserListAdapter = new ClubAtUserListAdapter();
                final ClubAtUserDialog clubAtUserDialog = ClubAtUserDialog.this;
                clubAtUserListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$adapter$2$1$1
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
                        ClubAtUserListAdapter adapter;
                        ClubAtUserListAdapter adapter2;
                        int q10;
                        ClubAtUserListAdapter adapter3;
                        ClubAtUserListAdapter adapter4;
                        int q11;
                        ClubAtUserListAdapter adapter5;
                        if (obj instanceof User) {
                            adapter = ClubAtUserDialog.this.getAdapter();
                            if (adapter.x()) {
                                adapter3 = ClubAtUserDialog.this.getAdapter();
                                User user = (User) obj;
                                if (adapter3.w().contains(user.userId())) {
                                    adapter5 = ClubAtUserDialog.this.getAdapter();
                                    adapter5.z(user.userId());
                                } else {
                                    adapter4 = ClubAtUserDialog.this.getAdapter();
                                    String userId = user.userId();
                                    q11 = ClubAtUserDialog.this.q();
                                    adapter4.u(userId, q11);
                                }
                                ClubAtUserDialog.this.s();
                                return;
                            }
                            adapter2 = ClubAtUserDialog.this.getAdapter();
                            int size = adapter2.w().size();
                            q10 = ClubAtUserDialog.this.q();
                            if (size >= q10) {
                                h.f12779a.k(R$string.club_at_user_max_nine);
                            } else {
                                ClubAtUserDialog.this.D(r.e(obj));
                            }
                        }
                    }
                });
                clubAtUserListAdapter.l().i(i0.h(kotlin.f.a(Integer.valueOf(R$id.item_match_select_cb), new Function3<Object, Boolean, Integer, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$adapter$2$1$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ p invoke(Object obj, Boolean bool, Integer num) {
                        invoke(obj, bool.booleanValue(), num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, boolean z10, int i10) {
                        ClubAtUserListAdapter adapter;
                        ClubAtUserListAdapter adapter2;
                        int q10;
                        if (obj instanceof User) {
                            if (z10) {
                                adapter2 = ClubAtUserDialog.this.getAdapter();
                                String userId = ((User) obj).userId();
                                q10 = ClubAtUserDialog.this.q();
                                adapter2.u(userId, q10);
                            } else {
                                adapter = ClubAtUserDialog.this.getAdapter();
                                adapter.z(((User) obj).userId());
                            }
                            ClubAtUserDialog.this.s();
                        }
                    }
                })));
                return clubAtUserListAdapter;
            }
        });
        w();
    }

    public /* synthetic */ ClubAtUserDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final List A(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public static final void B(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void C(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void H(ClubAtUserDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        f fVar = this$0.f13524e;
        if (fVar != null) {
            fVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClubAtUserListAdapter getAdapter() {
        return (ClubAtUserListAdapter) this.f13521b.getValue();
    }

    public static final boolean x(View view, int i10, KeyEvent keyEvent) {
        return i10 == 6;
    }

    public final void D(List<User> list) {
        f fVar = this.f13524e;
        if (fVar != null) {
            fVar.b(list);
        }
        t();
        Context context = getContext();
        s.h(context, "context");
        z0.h.q(context, null, 1, null);
        AlertDialog alertDialog = this.f13525f;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @NotNull
    public final ClubAtUserDialog E(int i10) {
        this.f13523d = i10;
        return this;
    }

    @NotNull
    public final ClubAtUserDialog F(@NotNull f listener) {
        s.i(listener, "listener");
        this.f13524e = listener;
        return this;
    }

    public final void G(@NotNull String clubId) {
        Window window;
        s.i(clubId, "clubId");
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f13525f = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(true);
        }
        AlertDialog alertDialog = this.f13525f;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f13525f;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        AlertDialog alertDialog3 = this.f13525f;
        if (alertDialog3 != null) {
            alertDialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.club.dialog.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ClubAtUserDialog.H(ClubAtUserDialog.this, dialogInterface);
                }
            });
        }
        v(clubId);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f13528i;
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

    public final int q() {
        return 9 - this.f13523d;
    }

    public final void r(boolean z10) {
        if (z10) {
            getAdapter().v(true);
            ((TextView) f(R$id.dialog_club_at_select_cancel)).setVisibility(0);
            ((ImageView) f(R$id.club_at_user_back)).setVisibility(4);
            ((TextView) f(R$id.dialog_club_at_select)).setVisibility(4);
            ((TextView) f(R$id.dialog_club_at_confirm)).setVisibility(0);
            s();
            return;
        }
        getAdapter().v(false);
        ((TextView) f(R$id.dialog_club_at_select_cancel)).setVisibility(4);
        ((ImageView) f(R$id.club_at_user_back)).setVisibility(0);
        ((TextView) f(R$id.dialog_club_at_select)).setVisibility(0);
        ((TextView) f(R$id.dialog_club_at_confirm)).setVisibility(4);
        ((TextView) f(R$id.dialog_club_at_title)).setText(getContext().getString(R$string.select_at_user));
    }

    public final void s() {
        int size = getAdapter().w().size();
        if (size > 0) {
            int i10 = R$id.dialog_club_at_confirm;
            ((TextView) f(i10)).setEnabled(true);
            ((TextView) f(i10)).setTextColor(-49088);
            ((TextView) f(R$id.dialog_club_at_title)).setText(getContext().getString(R$string.select_at_user) + "（" + size + "）");
            return;
        }
        int i11 = R$id.dialog_club_at_confirm;
        ((TextView) f(i11)).setEnabled(false);
        ((TextView) f(i11)).setTextColor(-5658199);
        ((TextView) f(R$id.dialog_club_at_title)).setText(getContext().getString(R$string.select_at_user));
    }

    public final void t() {
        Disposable disposable = this.f13522c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f13527h = null;
        this.f13522c = null;
    }

    public final void u() {
        ImageView club_at_user_back = (ImageView) f(R$id.club_at_user_back);
        s.h(club_at_user_back, "club_at_user_back");
        y.d(club_at_user_back, new Function1<View, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$initClick$1
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
                AlertDialog alertDialog;
                Context context = ClubAtUserDialog.this.getContext();
                s.h(context, "context");
                z0.h.q(context, null, 1, null);
                alertDialog = ClubAtUserDialog.this.f13525f;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        TextView dialog_club_at_select_cancel = (TextView) f(R$id.dialog_club_at_select_cancel);
        s.h(dialog_club_at_select_cancel, "dialog_club_at_select_cancel");
        y.d(dialog_club_at_select_cancel, new Function1<View, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$initClick$2
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
                ClubAtUserDialog.this.r(false);
            }
        });
        TextView dialog_club_at_select = (TextView) f(R$id.dialog_club_at_select);
        s.h(dialog_club_at_select, "dialog_club_at_select");
        y.d(dialog_club_at_select, new Function1<View, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$initClick$3
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
                ClubAtUserDialog.this.r(true);
            }
        });
        TextView dialog_club_at_confirm = (TextView) f(R$id.dialog_club_at_confirm);
        s.h(dialog_club_at_confirm, "dialog_club_at_confirm");
        y.d(dialog_club_at_confirm, new Function1<View, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$initClick$4
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
                List list;
                List j10;
                ClubAtUserListAdapter adapter;
                list = ClubAtUserDialog.this.f13526g;
                if (list != null) {
                    ClubAtUserDialog clubAtUserDialog = ClubAtUserDialog.this;
                    j10 = new ArrayList();
                    for (Object obj : list) {
                        adapter = clubAtUserDialog.getAdapter();
                        if (adapter.w().contains(((User) obj).userId())) {
                            j10.add(obj);
                        }
                    }
                } else {
                    j10 = kotlin.collections.s.j();
                }
                ClubAtUserDialog.this.D(j10);
            }
        });
        ImageView clearButton = (ImageView) f(R$id.clearButton);
        s.h(clearButton, "clearButton");
        y.d(clearButton, new Function1<View, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$initClick$5
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
                ((EditText) ClubAtUserDialog.this.f(R$id.searchEditText)).setText("");
            }
        });
    }

    public final void v(String str) {
        Observable<Result<ListResult<User>>> k10 = NetworkClient.f11868a.u().k(str);
        Object context = getContext();
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = k10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<User>, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$initData$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<User> listResult) {
                m2511invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2511invoke(ListResult<User> listResult) {
                ListResult<User> listResult2 = listResult;
                ClubAtUserDialog.this.f13526g = listResult2.getList();
                ClubAtUserDialog.this.y(listResult2.getList());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void w() {
        z.a(this, R$layout.dialog_club_at_user, true);
        TextView dialog_club_at_title = (TextView) f(R$id.dialog_club_at_title);
        s.h(dialog_club_at_title, "dialog_club_at_title");
        u.a(dialog_club_at_title);
        ConstraintLayout root = (ConstraintLayout) f(R$id.root);
        s.h(root, "root");
        y.o(root, null, Integer.valueOf((z0.h.k(this) / 3) * 2), 1, null);
        u();
        int i10 = R$id.searchEditText;
        new com.cupidapp.live.base.utils.g(r.e((EditText) f(i10)), new Function1<Boolean, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                List list;
                if (z10) {
                    ((ImageView) ClubAtUserDialog.this.f(R$id.clearButton)).setVisibility(0);
                    ClubAtUserDialog clubAtUserDialog = ClubAtUserDialog.this;
                    clubAtUserDialog.z(((EditText) clubAtUserDialog.f(R$id.searchEditText)).getText().toString());
                } else {
                    ((ImageView) ClubAtUserDialog.this.f(R$id.clearButton)).setVisibility(8);
                    ClubAtUserDialog clubAtUserDialog2 = ClubAtUserDialog.this;
                    list = clubAtUserDialog2.f13526g;
                    clubAtUserDialog2.y(list);
                }
            }
        });
        int i11 = R$id.club_at_rv;
        ((RecyclerView) f(i11)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$initView$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i12) {
                s.i(recyclerView, "recyclerView");
                Context context = ClubAtUserDialog.this.getContext();
                s.h(context, "context");
                z0.h.p(context, (EditText) ClubAtUserDialog.this.f(R$id.searchEditText));
            }
        });
        ((RecyclerView) f(i11)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) f(i11)).setAdapter(getAdapter());
        ((EditText) f(i10)).setOnKeyListener(new View.OnKeyListener() { // from class: com.cupidapp.live.club.dialog.b
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i12, KeyEvent keyEvent) {
                boolean x10;
                x10 = ClubAtUserDialog.x(view, i12, keyEvent);
                return x10;
            }
        });
    }

    public final void y(List<User> list) {
        getAdapter().j().clear();
        if (list == null || list.isEmpty()) {
            getAdapter().d(new FKEmptyViewModel(null, Integer.valueOf(R$string.no_search_result_people), null, -5658199, null, Integer.valueOf(z0.h.c(this, 160.0f)), null, false, null, null, 981, null));
        } else {
            getAdapter().e(list);
            getAdapter().d(new FKFooterWithSpaceModel(false, false, null, 0, 0, z0.h.c(this, 30.0f), 30, null));
        }
        getAdapter().notifyDataSetChanged();
    }

    public final void z(String str) {
        Disposable disposable;
        Flowable<String> flowable;
        Flowable<String> subscribeOn;
        Flowable observeOn;
        BehaviorSubject<String> behaviorSubject = this.f13527h;
        if (behaviorSubject != null) {
            if (behaviorSubject != null) {
                behaviorSubject.onNext(str);
                return;
            }
            return;
        }
        BehaviorSubject<String> createDefault = BehaviorSubject.createDefault(str);
        this.f13527h = createDefault;
        if (createDefault != null && (flowable = createDefault.toFlowable(BackpressureStrategy.LATEST)) != null && (subscribeOn = flowable.subscribeOn(Schedulers.computation())) != null) {
            final Function1<String, List<? extends User>> function1 = new Function1<String, List<? extends User>>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$searchUser$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<User> invoke(@NotNull String key) {
                    List list;
                    s.i(key, "key");
                    list = ClubAtUserDialog.this.f13526g;
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            String nickname = ((User) obj).getNickname();
                            if (nickname != null && StringsKt__StringsKt.K(nickname, key, false, 2, null)) {
                                arrayList.add(obj);
                            }
                        }
                        return arrayList;
                    }
                    return kotlin.collections.s.j();
                }
            };
            Flowable<R> map = subscribeOn.map(new Function() { // from class: com.cupidapp.live.club.dialog.e
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    List A;
                    A = ClubAtUserDialog.A(Function1.this, obj);
                    return A;
                }
            });
            if (map != 0 && (observeOn = map.observeOn(AndroidSchedulers.mainThread())) != null) {
                final Function1<List<? extends User>, p> function12 = new Function1<List<? extends User>, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$searchUser$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(List<? extends User> list) {
                        invoke2((List<User>) list);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<User> list) {
                        ClubAtUserDialog.this.y(list);
                    }
                };
                Consumer consumer = new Consumer() { // from class: com.cupidapp.live.club.dialog.d
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ClubAtUserDialog.B(Function1.this, obj);
                    }
                };
                final ClubAtUserDialog$searchUser$3 clubAtUserDialog$searchUser$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.club.dialog.ClubAtUserDialog$searchUser$3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                        invoke2(th);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                    }
                };
                disposable = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.club.dialog.c
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ClubAtUserDialog.C(Function1.this, obj);
                    }
                });
                this.f13522c = disposable;
            }
        }
        disposable = null;
        this.f13522c = disposable;
    }
}
