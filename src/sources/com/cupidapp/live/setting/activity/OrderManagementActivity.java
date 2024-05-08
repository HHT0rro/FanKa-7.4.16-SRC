package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.setting.adapter.OrderManagementAdapter;
import com.cupidapp.live.setting.model.OrderManagementResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OrderManagementActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OrderManagementActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17980r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17981q = new LinkedHashMap();

    /* compiled from: OrderManagementActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ArrayList<OrderManagementResult> list) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(list, "list");
            Intent intent = new Intent(context, (Class<?>) OrderManagementActivity.class);
            intent.putExtra("orderManagements", list);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public final void init() {
        ((FKTitleBarLayout) j1(R$id.manageTitleBar)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.OrderManagementActivity$init$1
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
                OrderManagementActivity.this.finish();
            }
        });
        OrderManagementAdapter orderManagementAdapter = new OrderManagementAdapter();
        boolean z10 = true;
        orderManagementAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.manageTxt), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.OrderManagementActivity$init$adapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof OrderManagementResult) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, OrderManagementActivity.this, ((OrderManagementResult) obj).getSubscriptionRenewUrl(), null, 4, null);
                }
            }
        })));
        int i10 = R$id.manageRecyclerView;
        ((RecyclerView) j1(i10)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) j1(i10)).setAdapter(orderManagementAdapter);
        orderManagementAdapter.j().clear();
        Serializable serializableExtra = getIntent().getSerializableExtra("orderManagements");
        List list = serializableExtra instanceof List ? (List) serializableExtra : null;
        if (list != null && !list.isEmpty()) {
            z10 = false;
        }
        if (z10) {
            orderManagementAdapter.j().add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_warn_placeholder), Integer.valueOf(R$string.no_order_tip), null, -5658199, null, null, null, false, null, null, 1012, null));
        } else {
            orderManagementAdapter.j().addAll(list);
        }
        orderManagementAdapter.notifyDataSetChanged();
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17981q;
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
        setContentView(R$layout.activity_order_manangement);
        init();
    }
}
