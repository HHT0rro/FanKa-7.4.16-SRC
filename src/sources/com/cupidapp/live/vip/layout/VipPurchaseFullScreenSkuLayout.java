package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.view.CustomLayoutManager;
import com.cupidapp.live.base.view.ScrollTo;
import com.cupidapp.live.base.view.decoration.AddExtraSpacingDecoration;
import com.cupidapp.live.vip.adapter.APlusFullScreenVipPriceAdapter;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.model.VipType;
import java.util.Iterator;
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
import z0.h;

/* compiled from: VipPurchaseFullScreenSkuLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseFullScreenSkuLayout extends RecyclerView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f18785b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function1<? super VipPurchasePriceModel, p> f18786c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18787d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseFullScreenSkuLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18787d = new LinkedHashMap();
        this.f18785b = kotlin.c.b(new Function0<APlusFullScreenVipPriceAdapter>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseFullScreenSkuLayout$vipPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final APlusFullScreenVipPriceAdapter invoke() {
                final APlusFullScreenVipPriceAdapter aPlusFullScreenVipPriceAdapter = new APlusFullScreenVipPriceAdapter();
                final VipPurchaseFullScreenSkuLayout vipPurchaseFullScreenSkuLayout = VipPurchaseFullScreenSkuLayout.this;
                aPlusFullScreenVipPriceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseFullScreenSkuLayout$vipPurchasePriceAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (obj instanceof VipPurchasePriceModel) {
                            VipPurchaseFullScreenSkuLayout.this.n((VipPurchasePriceModel) obj);
                            VipPurchaseFullScreenSkuLayout.this.smoothScrollToPosition(aPlusFullScreenVipPriceAdapter.j().indexOf(obj));
                        }
                    }
                });
                return aPlusFullScreenVipPriceAdapter;
            }
        });
        m();
    }

    private final APlusFullScreenVipPriceAdapter getVipPurchasePriceAdapter() {
        return (APlusFullScreenVipPriceAdapter) this.f18785b.getValue();
    }

    public final void f(@Nullable List<VipPurchasePriceModel> list, @Nullable VipPurchasePriceModel vipPurchasePriceModel, @NotNull VipType vipType) {
        VipPurchasePriceModel vipPurchasePriceModel2;
        s.i(vipType, "vipType");
        getVipPurchasePriceAdapter().j().clear();
        if (list == null || list.isEmpty()) {
            getVipPurchasePriceAdapter().notifyDataSetChanged();
            return;
        }
        Iterator<VipPurchasePriceModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().setVipType(vipType);
        }
        getVipPurchasePriceAdapter().e(list);
        VipPurchasePriceModel vipPurchasePriceModel3 = null;
        if (vipPurchasePriceModel != null) {
            Iterator<VipPurchasePriceModel> iterator22 = list.iterator2();
            while (true) {
                if (!iterator22.hasNext()) {
                    vipPurchasePriceModel2 = null;
                    break;
                } else {
                    vipPurchasePriceModel2 = iterator22.next();
                    if (s.d(vipPurchasePriceModel2.getSkuCode(), vipPurchasePriceModel.getSkuCode())) {
                        break;
                    }
                }
            }
            VipPurchasePriceModel vipPurchasePriceModel4 = vipPurchasePriceModel2;
            if (vipPurchasePriceModel4 == null) {
                Iterator<VipPurchasePriceModel> iterator23 = list.iterator2();
                while (true) {
                    if (!iterator23.hasNext()) {
                        break;
                    }
                    VipPurchasePriceModel next = iterator23.next();
                    if (next.getMonth() == vipPurchasePriceModel.getMonth()) {
                        vipPurchasePriceModel3 = next;
                        break;
                    }
                }
                vipPurchasePriceModel3 = vipPurchasePriceModel3;
            } else {
                vipPurchasePriceModel3 = vipPurchasePriceModel4;
            }
        }
        if (vipPurchasePriceModel3 == null) {
            vipPurchasePriceModel3 = (VipPurchasePriceModel) CollectionsKt___CollectionsKt.T(list);
        }
        n(vipPurchasePriceModel3);
        scrollToPosition(list.indexOf(vipPurchasePriceModel3));
    }

    @Nullable
    public final Function1<VipPurchasePriceModel, p> getSelectCurrentPriceCallback() {
        return this.f18786c;
    }

    public final void m() {
        setAdapter(getVipPurchasePriceAdapter());
        Context context = getContext();
        s.h(context, "context");
        setLayoutManager(new CustomLayoutManager(context, 0, ScrollTo.Center, Float.valueOf(0.5f)));
        addItemDecoration(new AddExtraSpacingDecoration(h.c(this, 6.0f), 0, h.c(this, 6.0f), 0, h.c(this, 10.0f)));
    }

    public final void n(VipPurchasePriceModel vipPurchasePriceModel) {
        for (Object obj : getVipPurchasePriceAdapter().j()) {
            if (obj instanceof VipPurchasePriceModel) {
                VipPurchasePriceModel vipPurchasePriceModel2 = (VipPurchasePriceModel) obj;
                vipPurchasePriceModel2.setSelected(s.d(vipPurchasePriceModel2.getSkuCode(), vipPurchasePriceModel.getSkuCode()));
            }
        }
        getVipPurchasePriceAdapter().notifyDataSetChanged();
        Function1<? super VipPurchasePriceModel, p> function1 = this.f18786c;
        if (function1 != null) {
            function1.invoke(vipPurchasePriceModel);
        }
    }

    public final void setSelectCurrentPriceCallback(@Nullable Function1<? super VipPurchasePriceModel, p> function1) {
        this.f18786c = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseFullScreenSkuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18787d = new LinkedHashMap();
        this.f18785b = kotlin.c.b(new Function0<APlusFullScreenVipPriceAdapter>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseFullScreenSkuLayout$vipPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final APlusFullScreenVipPriceAdapter invoke() {
                final APlusFullScreenVipPriceAdapter aPlusFullScreenVipPriceAdapter = new APlusFullScreenVipPriceAdapter();
                final VipPurchaseFullScreenSkuLayout vipPurchaseFullScreenSkuLayout = VipPurchaseFullScreenSkuLayout.this;
                aPlusFullScreenVipPriceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseFullScreenSkuLayout$vipPurchasePriceAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (obj instanceof VipPurchasePriceModel) {
                            VipPurchaseFullScreenSkuLayout.this.n((VipPurchasePriceModel) obj);
                            VipPurchaseFullScreenSkuLayout.this.smoothScrollToPosition(aPlusFullScreenVipPriceAdapter.j().indexOf(obj));
                        }
                    }
                });
                return aPlusFullScreenVipPriceAdapter;
            }
        });
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseFullScreenSkuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18787d = new LinkedHashMap();
        this.f18785b = kotlin.c.b(new Function0<APlusFullScreenVipPriceAdapter>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseFullScreenSkuLayout$vipPurchasePriceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final APlusFullScreenVipPriceAdapter invoke() {
                final APlusFullScreenVipPriceAdapter aPlusFullScreenVipPriceAdapter = new APlusFullScreenVipPriceAdapter();
                final VipPurchaseFullScreenSkuLayout vipPurchaseFullScreenSkuLayout = VipPurchaseFullScreenSkuLayout.this;
                aPlusFullScreenVipPriceAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseFullScreenSkuLayout$vipPurchasePriceAdapter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        if (obj instanceof VipPurchasePriceModel) {
                            VipPurchaseFullScreenSkuLayout.this.n((VipPurchasePriceModel) obj);
                            VipPurchaseFullScreenSkuLayout.this.smoothScrollToPosition(aPlusFullScreenVipPriceAdapter.j().indexOf(obj));
                        }
                    }
                });
                return aPlusFullScreenVipPriceAdapter;
            }
        });
        m();
    }
}
