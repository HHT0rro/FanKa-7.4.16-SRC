package com.cupidapp.live.superboost.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.superboost.model.DirectSuperBoostFilterModel;
import com.cupidapp.live.superboost.model.FilterItemUiModel;
import com.cupidapp.live.superboost.model.FilterOptionModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.b;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: DirectSuperBoostFilterDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DirectSuperBoostFilterDialog extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f18570f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super FormBody, p> f18571b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AlertDialog f18572c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f18573d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18574e;

    /* compiled from: DirectSuperBoostFilterDialog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DirectSuperBoostFilterDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new DirectSuperBoostFilterDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectSuperBoostFilterDialog(Context context) {
        super(context);
        this.f18574e = new LinkedHashMap();
        this.f18573d = c.b(new Function0<DirectSuperBoostFilterAdapter>() { // from class: com.cupidapp.live.superboost.dialog.DirectSuperBoostFilterDialog$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DirectSuperBoostFilterAdapter invoke() {
                final DirectSuperBoostFilterDialog directSuperBoostFilterDialog = DirectSuperBoostFilterDialog.this;
                return new DirectSuperBoostFilterAdapter(new Function2<FilterOptionModel, FilterItemUiModel, p>() { // from class: com.cupidapp.live.superboost.dialog.DirectSuperBoostFilterDialog$adapter$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(FilterOptionModel filterOptionModel, FilterItemUiModel filterItemUiModel) {
                        invoke2(filterOptionModel, filterItemUiModel);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull FilterOptionModel selectOption, @NotNull FilterItemUiModel itemModel) {
                        FilterOptionModel filterOptionModel;
                        FilterOptionModel filterOptionModel2;
                        DirectSuperBoostFilterAdapter adapter;
                        DirectSuperBoostFilterAdapter adapter2;
                        s.i(selectOption, "selectOption");
                        s.i(itemModel, "itemModel");
                        selectOption.setChecked(!selectOption.getChecked());
                        if (selectOption.getValue() == -1 && selectOption.getChecked()) {
                            for (FilterOptionModel filterOptionModel3 : itemModel.getOptions()) {
                                if (filterOptionModel3.getValue() != -1) {
                                    filterOptionModel3.setChecked(false);
                                }
                            }
                            adapter2 = DirectSuperBoostFilterDialog.this.getAdapter();
                            adapter2.notifyDataSetChanged();
                            return;
                        }
                        Iterator<FilterOptionModel> iterator2 = itemModel.getOptions().iterator2();
                        while (true) {
                            filterOptionModel = null;
                            if (!iterator2.hasNext()) {
                                filterOptionModel2 = null;
                                break;
                            }
                            filterOptionModel2 = iterator2.next();
                            FilterOptionModel filterOptionModel4 = filterOptionModel2;
                            if (filterOptionModel4.getChecked() && filterOptionModel4.getValue() != -1) {
                                break;
                            }
                        }
                        FilterOptionModel filterOptionModel5 = filterOptionModel2;
                        Iterator<FilterOptionModel> iterator22 = itemModel.getOptions().iterator2();
                        while (true) {
                            if (!iterator22.hasNext()) {
                                break;
                            }
                            FilterOptionModel next = iterator22.next();
                            if (next.getValue() == -1) {
                                filterOptionModel = next;
                                break;
                            }
                        }
                        FilterOptionModel filterOptionModel6 = filterOptionModel;
                        if (filterOptionModel6 != null) {
                            filterOptionModel6.setChecked(filterOptionModel5 == null);
                        }
                        adapter = DirectSuperBoostFilterDialog.this.getAdapter();
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
        g();
    }

    public /* synthetic */ DirectSuperBoostFilterDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DirectSuperBoostFilterAdapter getAdapter() {
        return (DirectSuperBoostFilterAdapter) this.f18573d.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18574e;
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

    @NotNull
    public final List<FilterOptionModel> e(@NotNull List<FilterOptionModel> list) {
        FilterOptionModel filterOptionModel;
        s.i(list, "list");
        Iterator<FilterOptionModel> iterator2 = list.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                filterOptionModel = null;
                break;
            }
            filterOptionModel = iterator2.next();
            if (filterOptionModel.getChecked()) {
                break;
            }
        }
        boolean z10 = filterOptionModel != null;
        List<FilterOptionModel> z02 = CollectionsKt___CollectionsKt.z0(list);
        String string = getContext().getString(R$string.infinite);
        s.h(string, "context.getString(R.string.infinite)");
        z02.add(0, new FilterOptionModel(string, -1, true ^ z10));
        return z02;
    }

    public final void f() {
        Observable<Result<DirectSuperBoostFilterModel>> J = NetworkClient.f11868a.N().J();
        Object context = getContext();
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = J.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<DirectSuperBoostFilterModel, p>() { // from class: com.cupidapp.live.superboost.dialog.DirectSuperBoostFilterDialog$initData$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(DirectSuperBoostFilterModel directSuperBoostFilterModel) {
                m2816invoke(directSuperBoostFilterModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2816invoke(DirectSuperBoostFilterModel directSuperBoostFilterModel) {
                DirectSuperBoostFilterAdapter adapter;
                DirectSuperBoostFilterAdapter adapter2;
                DirectSuperBoostFilterAdapter adapter3;
                DirectSuperBoostFilterAdapter adapter4;
                DirectSuperBoostFilterAdapter adapter5;
                DirectSuperBoostFilterAdapter adapter6;
                DirectSuperBoostFilterModel directSuperBoostFilterModel2 = directSuperBoostFilterModel;
                adapter = DirectSuperBoostFilterDialog.this.getAdapter();
                adapter.j().clear();
                List<FilterOptionModel> isLimitFake = directSuperBoostFilterModel2.isLimitFake();
                boolean z10 = false;
                if (isLimitFake != null && (isLimitFake.isEmpty() ^ true)) {
                    adapter6 = DirectSuperBoostFilterDialog.this.getAdapter();
                    String string = DirectSuperBoostFilterDialog.this.getContext().getString(R$string.avatar);
                    s.h(string, "context.getString(R.string.avatar)");
                    adapter6.d(new FilterItemUiModel(string, DirectSuperBoostFilterDialog.this.e(directSuperBoostFilterModel2.isLimitFake()), "isLimitFake"));
                }
                List<FilterOptionModel> roles = directSuperBoostFilterModel2.getRoles();
                if (roles != null && (roles.isEmpty() ^ true)) {
                    adapter5 = DirectSuperBoostFilterDialog.this.getAdapter();
                    String string2 = DirectSuperBoostFilterDialog.this.getContext().getString(R$string.role_with_mul_select);
                    s.h(string2, "context.getString(R.string.role_with_mul_select)");
                    adapter5.d(new FilterItemUiModel(string2, DirectSuperBoostFilterDialog.this.e(directSuperBoostFilterModel2.getRoles()), "roles"));
                }
                List<FilterOptionModel> ages = directSuperBoostFilterModel2.getAges();
                if (ages != null && (ages.isEmpty() ^ true)) {
                    adapter4 = DirectSuperBoostFilterDialog.this.getAdapter();
                    String string3 = DirectSuperBoostFilterDialog.this.getContext().getString(R$string.age_with_mul_select);
                    s.h(string3, "context.getString(R.string.age_with_mul_select)");
                    adapter4.d(new FilterItemUiModel(string3, DirectSuperBoostFilterDialog.this.e(directSuperBoostFilterModel2.getAges()), "ages"));
                }
                if (directSuperBoostFilterModel2.getCities() != null && (!r0.isEmpty())) {
                    z10 = true;
                }
                if (z10) {
                    adapter3 = DirectSuperBoostFilterDialog.this.getAdapter();
                    String string4 = DirectSuperBoostFilterDialog.this.getContext().getString(R$string.city);
                    s.h(string4, "context.getString(R.string.city)");
                    adapter3.d(new FilterItemUiModel(string4, DirectSuperBoostFilterDialog.this.e(directSuperBoostFilterModel2.getCities()), "cities"));
                }
                adapter2 = DirectSuperBoostFilterDialog.this.getAdapter();
                adapter2.notifyDataSetChanged();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void g() {
        z.a(this, R$layout.dialog_direct_super_boost_filter, true);
        TextView direct_boost_title = (TextView) a(R$id.direct_boost_title);
        s.h(direct_boost_title, "direct_boost_title");
        u.a(direct_boost_title);
        int i10 = R$id.boost_rv;
        ((RecyclerView) a(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((RecyclerView) a(i10)).setAdapter(getAdapter());
        ImageView direct_boost_close_img = (ImageView) a(R$id.direct_boost_close_img);
        s.h(direct_boost_close_img, "direct_boost_close_img");
        y.d(direct_boost_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.DirectSuperBoostFilterDialog$initView$1
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
                alertDialog = DirectSuperBoostFilterDialog.this.f18572c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        FKUniversalButton boost_now = (FKUniversalButton) a(R$id.boost_now);
        s.h(boost_now, "boost_now");
        y.d(boost_now, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.DirectSuperBoostFilterDialog$initView$2
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
                DirectSuperBoostFilterDialog.this.i();
                alertDialog = DirectSuperBoostFilterDialog.this.f18572c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        f();
    }

    public final void h(@NotNull Function1<? super FormBody, p> positiveCallback) {
        Window window;
        s.i(positiveCallback, "positiveCallback");
        this.f18571b = positiveCallback;
        AlertDialog create = b.f54812a.e(getContext()).setView(this).create();
        this.f18572c = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(true);
        }
        AlertDialog alertDialog = this.f18572c;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f18572c;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.setGravity(17);
    }

    public final void i() {
        FormBody.Builder builder = new FormBody.Builder(null, 1, null);
        for (Object obj : getAdapter().j()) {
            if (obj instanceof FilterItemUiModel) {
                StringBuilder sb2 = new StringBuilder();
                FilterItemUiModel filterItemUiModel = (FilterItemUiModel) obj;
                for (FilterOptionModel filterOptionModel : filterItemUiModel.getOptions()) {
                    if (filterOptionModel.getChecked() && filterOptionModel.getValue() != -1) {
                        sb2.append(filterOptionModel.getValue() + ",");
                    }
                }
                if (sb2.length() > 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
                String key = filterItemUiModel.getKey();
                String sb3 = sb2.toString();
                s.h(sb3, "value.toString()");
                builder.add(key, sb3);
            }
        }
        builder.add("type", "1");
        Function1<? super FormBody, p> function1 = this.f18571b;
        if (function1 != null) {
            function1.invoke(builder.build());
        }
    }
}
