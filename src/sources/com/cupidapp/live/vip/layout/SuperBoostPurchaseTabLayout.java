package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$string;
import com.cupidapp.live.superboost.purchase.SuperBoostType;
import com.cupidapp.live.vip.adapter.VipPurchaseTabAdapter;
import com.cupidapp.live.vip.model.SuperBoostPurchaseTabModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperBoostPurchaseTabLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostPurchaseTabLayout extends RecyclerView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f18772b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f18773c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f18774d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18775e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function1<? super SuperBoostType, p> f18776f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18777g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostPurchaseTabLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18777g = new LinkedHashMap();
        this.f18772b = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$directTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.DIRECT;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.direct_exposure_purchase_title);
                s.h(string, "context.getString(R.stri…_exposure_purchase_title)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18773c = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$nonDirectTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.NON_DIRECT;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.exposure);
                s.h(string, "context.getString(R.string.exposure)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18774d = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$travelTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.TRAVEL;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.travel);
                s.h(string, "context.getString(R.string.travel)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18775e = kotlin.c.b(new Function0<VipPurchaseTabAdapter>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$tabAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabAdapter invoke() {
                VipPurchaseTabAdapter vipPurchaseTabAdapter = new VipPurchaseTabAdapter();
                final SuperBoostPurchaseTabLayout superBoostPurchaseTabLayout = SuperBoostPurchaseTabLayout.this;
                vipPurchaseTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$tabAdapter$2$1$1
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
                        if (obj instanceof SuperBoostPurchaseTabModel) {
                            SuperBoostPurchaseTabModel superBoostPurchaseTabModel = (SuperBoostPurchaseTabModel) obj;
                            if (superBoostPurchaseTabModel.getSelect()) {
                                return;
                            }
                            SuperBoostPurchaseTabLayout.this.n(superBoostPurchaseTabModel.getPurchaseType());
                            Function1<SuperBoostType, p> tabSelectCallback = SuperBoostPurchaseTabLayout.this.getTabSelectCallback();
                            if (tabSelectCallback != null) {
                                tabSelectCallback.invoke(superBoostPurchaseTabModel.getPurchaseType());
                            }
                        }
                    }
                });
                return vipPurchaseTabAdapter;
            }
        });
        m();
    }

    private final SuperBoostPurchaseTabModel getDirectTab() {
        return (SuperBoostPurchaseTabModel) this.f18772b.getValue();
    }

    private final SuperBoostPurchaseTabModel getNonDirectTab() {
        return (SuperBoostPurchaseTabModel) this.f18773c.getValue();
    }

    private final VipPurchaseTabAdapter getTabAdapter() {
        return (VipPurchaseTabAdapter) this.f18775e.getValue();
    }

    private final SuperBoostPurchaseTabModel getTravelTab() {
        return (SuperBoostPurchaseTabModel) this.f18774d.getValue();
    }

    public final void f(@NotNull SuperBoostType defaultTab) {
        s.i(defaultTab, "defaultTab");
        getTabAdapter().j().clear();
        getTabAdapter().d(getNonDirectTab());
        getTabAdapter().d(getDirectTab());
        getTabAdapter().d(getTravelTab());
        n(defaultTab);
        Function1<? super SuperBoostType, p> function1 = this.f18776f;
        if (function1 != null) {
            function1.invoke(defaultTab);
        }
    }

    @Nullable
    public final Function1<SuperBoostType, p> getTabSelectCallback() {
        return this.f18776f;
    }

    public final void m() {
        setAdapter(getTabAdapter());
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }

    public final void n(SuperBoostType superBoostType) {
        List<Object> j10 = getTabAdapter().j();
        ArrayList<SuperBoostPurchaseTabModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof SuperBoostPurchaseTabModel) {
                arrayList.add(obj);
            }
        }
        for (SuperBoostPurchaseTabModel superBoostPurchaseTabModel : arrayList) {
            superBoostPurchaseTabModel.setSelect(superBoostPurchaseTabModel.getPurchaseType() == superBoostType);
        }
        getTabAdapter().notifyDataSetChanged();
    }

    public final void setTabSelectCallback(@Nullable Function1<? super SuperBoostType, p> function1) {
        this.f18776f = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostPurchaseTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18777g = new LinkedHashMap();
        this.f18772b = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$directTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.DIRECT;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.direct_exposure_purchase_title);
                s.h(string, "context.getString(R.stri…_exposure_purchase_title)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18773c = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$nonDirectTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.NON_DIRECT;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.exposure);
                s.h(string, "context.getString(R.string.exposure)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18774d = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$travelTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.TRAVEL;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.travel);
                s.h(string, "context.getString(R.string.travel)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18775e = kotlin.c.b(new Function0<VipPurchaseTabAdapter>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$tabAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabAdapter invoke() {
                VipPurchaseTabAdapter vipPurchaseTabAdapter = new VipPurchaseTabAdapter();
                final SuperBoostPurchaseTabLayout superBoostPurchaseTabLayout = SuperBoostPurchaseTabLayout.this;
                vipPurchaseTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$tabAdapter$2$1$1
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
                        if (obj instanceof SuperBoostPurchaseTabModel) {
                            SuperBoostPurchaseTabModel superBoostPurchaseTabModel = (SuperBoostPurchaseTabModel) obj;
                            if (superBoostPurchaseTabModel.getSelect()) {
                                return;
                            }
                            SuperBoostPurchaseTabLayout.this.n(superBoostPurchaseTabModel.getPurchaseType());
                            Function1<SuperBoostType, p> tabSelectCallback = SuperBoostPurchaseTabLayout.this.getTabSelectCallback();
                            if (tabSelectCallback != null) {
                                tabSelectCallback.invoke(superBoostPurchaseTabModel.getPurchaseType());
                            }
                        }
                    }
                });
                return vipPurchaseTabAdapter;
            }
        });
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostPurchaseTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18777g = new LinkedHashMap();
        this.f18772b = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$directTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.DIRECT;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.direct_exposure_purchase_title);
                s.h(string, "context.getString(R.stri…_exposure_purchase_title)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18773c = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$nonDirectTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.NON_DIRECT;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.exposure);
                s.h(string, "context.getString(R.string.exposure)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18774d = kotlin.c.b(new Function0<SuperBoostPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$travelTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseTabModel invoke() {
                SuperBoostType superBoostType = SuperBoostType.TRAVEL;
                String string = SuperBoostPurchaseTabLayout.this.getContext().getString(R$string.travel);
                s.h(string, "context.getString(R.string.travel)");
                return new SuperBoostPurchaseTabModel(superBoostType, string, null, 18.0f, null, null, 0, false, false, null, 12.0f, 12.0f, 1012, null);
            }
        });
        this.f18775e = kotlin.c.b(new Function0<VipPurchaseTabAdapter>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$tabAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabAdapter invoke() {
                VipPurchaseTabAdapter vipPurchaseTabAdapter = new VipPurchaseTabAdapter();
                final SuperBoostPurchaseTabLayout superBoostPurchaseTabLayout = SuperBoostPurchaseTabLayout.this;
                vipPurchaseTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.SuperBoostPurchaseTabLayout$tabAdapter$2$1$1
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
                        if (obj instanceof SuperBoostPurchaseTabModel) {
                            SuperBoostPurchaseTabModel superBoostPurchaseTabModel = (SuperBoostPurchaseTabModel) obj;
                            if (superBoostPurchaseTabModel.getSelect()) {
                                return;
                            }
                            SuperBoostPurchaseTabLayout.this.n(superBoostPurchaseTabModel.getPurchaseType());
                            Function1<SuperBoostType, p> tabSelectCallback = SuperBoostPurchaseTabLayout.this.getTabSelectCallback();
                            if (tabSelectCallback != null) {
                                tabSelectCallback.invoke(superBoostPurchaseTabModel.getPurchaseType());
                            }
                        }
                    }
                });
                return vipPurchaseTabAdapter;
            }
        });
        m();
    }
}
