package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.DiamondBalanceAdapter;
import com.cupidapp.live.liveshow.view.giftpicker.model.DiamondModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: DiamondSkuLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiamondSkuLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super DiamondModel, p> f15499b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f15500c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f15501d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15502e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondSkuLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15502e = new LinkedHashMap();
        this.f15501d = kotlin.c.b(new Function0<DiamondBalanceAdapter>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondSkuLayout$diamondBalanceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DiamondBalanceAdapter invoke() {
                DiamondBalanceAdapter diamondBalanceAdapter = new DiamondBalanceAdapter();
                final DiamondSkuLayout diamondSkuLayout = DiamondSkuLayout.this;
                diamondBalanceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondSkuLayout$diamondBalanceAdapter$2$1$1
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
                        if (obj instanceof DiamondModel) {
                            DiamondModel diamondModel = (DiamondModel) obj;
                            if (diamondModel.isSelect()) {
                                return;
                            }
                            DiamondSkuLayout.this.d(diamondModel);
                        }
                    }
                });
                return diamondBalanceAdapter;
            }
        });
        f();
    }

    private final DiamondBalanceAdapter getDiamondBalanceAdapter() {
        return (DiamondBalanceAdapter) this.f15501d.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15502e;
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

    public final void d(DiamondModel diamondModel) {
        List<Object> j10 = getDiamondBalanceAdapter().j();
        ArrayList<DiamondModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof DiamondModel) {
                arrayList.add(obj);
            }
        }
        for (DiamondModel diamondModel2 : arrayList) {
            diamondModel2.setSelect(s.d(diamondModel.getCode(), diamondModel2.getCode()));
        }
        getDiamondBalanceAdapter().notifyItemRangeChanged(0, getDiamondBalanceAdapter().n());
        Function1<? super DiamondModel, p> function1 = this.f15499b;
        if (function1 != null) {
            function1.invoke(diamondModel);
        }
    }

    public final void e(@NotNull List<DiamondModel> products, @Nullable String str) {
        s.i(products, "products");
        this.f15500c = str;
        getDiamondBalanceAdapter().j().clear();
        if (!products.isEmpty()) {
            getDiamondBalanceAdapter().e(products);
            d((DiamondModel) CollectionsKt___CollectionsKt.T(products));
        }
    }

    public final void f() {
        z.a(this, R$layout.layout_diamond_sku, true);
        int i10 = R$id.recharge_record_textview;
        TextView recharge_record_textview = (TextView) a(i10);
        s.h(recharge_record_textview, "recharge_record_textview");
        u.a(recharge_record_textview);
        RecyclerView recyclerView = (RecyclerView) a(R$id.diamond_sku_recyclerview);
        recyclerView.setAdapter(getDiamondBalanceAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.setNestedScrollingEnabled(false);
        TextView recharge_record_textview2 = (TextView) a(i10);
        s.h(recharge_record_textview2, "recharge_record_textview");
        y.d(recharge_record_textview2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondSkuLayout$initView$2
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
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                Context context = DiamondSkuLayout.this.getContext();
                str = DiamondSkuLayout.this.f15500c;
                j.a.b(aVar, context, str, null, 4, null);
            }
        });
    }

    @Nullable
    public final Function1<DiamondModel, p> getItemClick() {
        return this.f15499b;
    }

    public final void setItemClick(@Nullable Function1<? super DiamondModel, p> function1) {
        this.f15499b = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondSkuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15502e = new LinkedHashMap();
        this.f15501d = kotlin.c.b(new Function0<DiamondBalanceAdapter>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondSkuLayout$diamondBalanceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DiamondBalanceAdapter invoke() {
                DiamondBalanceAdapter diamondBalanceAdapter = new DiamondBalanceAdapter();
                final DiamondSkuLayout diamondSkuLayout = DiamondSkuLayout.this;
                diamondBalanceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondSkuLayout$diamondBalanceAdapter$2$1$1
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
                        if (obj instanceof DiamondModel) {
                            DiamondModel diamondModel = (DiamondModel) obj;
                            if (diamondModel.isSelect()) {
                                return;
                            }
                            DiamondSkuLayout.this.d(diamondModel);
                        }
                    }
                });
                return diamondBalanceAdapter;
            }
        });
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondSkuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15502e = new LinkedHashMap();
        this.f15501d = kotlin.c.b(new Function0<DiamondBalanceAdapter>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondSkuLayout$diamondBalanceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DiamondBalanceAdapter invoke() {
                DiamondBalanceAdapter diamondBalanceAdapter = new DiamondBalanceAdapter();
                final DiamondSkuLayout diamondSkuLayout = DiamondSkuLayout.this;
                diamondBalanceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondSkuLayout$diamondBalanceAdapter$2$1$1
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
                        if (obj instanceof DiamondModel) {
                            DiamondModel diamondModel = (DiamondModel) obj;
                            if (diamondModel.isSelect()) {
                                return;
                            }
                            DiamondSkuLayout.this.d(diamondModel);
                        }
                    }
                });
                return diamondBalanceAdapter;
            }
        });
        f();
    }
}
