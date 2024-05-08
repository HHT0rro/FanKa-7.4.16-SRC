package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.vip.adapter.VipPurchaseTabAdapter;
import com.cupidapp.live.vip.model.VipPurchaseTabModel;
import com.cupidapp.live.vip.model.VipType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: VipPurchaseTabLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseTabLayout extends RecyclerView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f18798b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f18799c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f18800d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18801e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18802f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Function1<? super VipType, p> f18803g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18804h;

    /* compiled from: VipPurchaseTabLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18805a;

        static {
            int[] iArr = new int[VipType.values().length];
            try {
                iArr[VipType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VipType.SUPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VipType.RAINBOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VipType.VISITOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f18805a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseTabLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18804h = new LinkedHashMap();
        this.f18798b = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$visitorTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.VISITOR;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.visitor_tab);
                s.h(string, "context.getString(R.string.visitor_tab)");
                String string2 = VipPurchaseTabLayout.this.getContext().getString(R$string.privileges_package);
                s.h(string2, "context.getString(R.string.privileges_package)");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, r.e(-49088), null, 0, false, 224, null);
            }
        });
        this.f18799c = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$normalVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.NORMAL;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.normal_vip);
                s.h(string, "context.getString(R.string.normal_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …ORMAL).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, r.e(-49088), null, 0, false, 224, null);
            }
        });
        this.f18800d = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$sVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.SUPER;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.diamond_vip);
                s.h(string, "context.getString(R.string.diamond_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …SUPER).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, kotlin.collections.s.m(-137028, -84391, -80264), r.e(-83876), 0, false, 192, null);
            }
        });
        this.f18801e = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$rainbowVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.RAINBOW;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.rainbow_vip);
                s.h(string, "context.getString(R.string.rainbow_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …INBOW).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, kotlin.collections.s.m(-48062, -25525, -7875, -3211419, -13330689, -6085377), null, 0, false, 224, null);
            }
        });
        this.f18802f = kotlin.c.b(new Function0<VipPurchaseTabAdapter>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$tabAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabAdapter invoke() {
                VipPurchaseTabAdapter vipPurchaseTabAdapter = new VipPurchaseTabAdapter();
                final VipPurchaseTabLayout vipPurchaseTabLayout = VipPurchaseTabLayout.this;
                vipPurchaseTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$tabAdapter$2$1$1
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
                        if (obj instanceof VipPurchaseTabModel) {
                            VipPurchaseTabModel vipPurchaseTabModel = (VipPurchaseTabModel) obj;
                            if (vipPurchaseTabModel.getSelect()) {
                                return;
                            }
                            VipPurchaseTabLayout.this.n(vipPurchaseTabModel);
                            Function1<VipType, p> tabSelectCallback = VipPurchaseTabLayout.this.getTabSelectCallback();
                            if (tabSelectCallback != null) {
                                tabSelectCallback.invoke(vipPurchaseTabModel.getVipType());
                            }
                        }
                    }
                });
                return vipPurchaseTabAdapter;
            }
        });
        m();
    }

    private final VipPurchaseTabModel getNormalVipTab() {
        return (VipPurchaseTabModel) this.f18799c.getValue();
    }

    private final VipPurchaseTabModel getRainbowVipTab() {
        return (VipPurchaseTabModel) this.f18801e.getValue();
    }

    private final VipPurchaseTabModel getSVipTab() {
        return (VipPurchaseTabModel) this.f18800d.getValue();
    }

    private final VipPurchaseTabAdapter getTabAdapter() {
        return (VipPurchaseTabAdapter) this.f18802f.getValue();
    }

    private final VipPurchaseTabModel getVisitorTab() {
        return (VipPurchaseTabModel) this.f18798b.getValue();
    }

    public final void f(@Nullable List<? extends VipType> list, @NotNull VipType defaultVipType) {
        s.i(defaultVipType, "defaultVipType");
        if (list == null || list.isEmpty()) {
            return;
        }
        getTabAdapter().j().clear();
        Iterator<? extends VipType> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            int i10 = a.f18805a[iterator2.next().ordinal()];
            if (i10 == 1) {
                getTabAdapter().d(getNormalVipTab());
            } else if (i10 == 2) {
                getTabAdapter().d(getSVipTab());
            } else if (i10 == 3) {
                if (list.size() == 1) {
                    VipPurchaseTabModel rainbowVipTab = getRainbowVipTab();
                    String string = getContext().getString(R$string.rainbow_a_plus_vip);
                    s.h(string, "context.getString(R.string.rainbow_a_plus_vip)");
                    rainbowVipTab.setTitle(string);
                    getRainbowVipTab().setTextSize(20.0f);
                } else {
                    VipPurchaseTabModel rainbowVipTab2 = getRainbowVipTab();
                    String string2 = getContext().getString(R$string.rainbow_vip);
                    s.h(string2, "context.getString(R.string.rainbow_vip)");
                    rainbowVipTab2.setTitle(string2);
                    getRainbowVipTab().setTextSize(18.0f);
                }
                getTabAdapter().d(getRainbowVipTab());
            } else if (i10 == 4) {
                getTabAdapter().d(getVisitorTab());
            }
        }
        List<Object> j10 = getTabAdapter().j();
        ArrayList<VipPurchaseTabModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof VipPurchaseTabModel) {
                arrayList.add(obj);
            }
        }
        for (VipPurchaseTabModel vipPurchaseTabModel : arrayList) {
            if (vipPurchaseTabModel.getVipType() == defaultVipType) {
                n(vipPurchaseTabModel);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Nullable
    public final Function1<VipType, p> getTabSelectCallback() {
        return this.f18803g;
    }

    public final void m() {
        setAdapter(getTabAdapter());
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        addItemDecoration(new ExtraSpacingDecoration(h.c(this, 4.0f), 0, h.c(this, 4.0f), 0, 0, 16, null));
    }

    public final void n(VipPurchaseTabModel vipPurchaseTabModel) {
        int i10 = a.f18805a[vipPurchaseTabModel.getVipType().ordinal()];
        if (i10 == 1) {
            o(VipType.NORMAL, -3750202);
        } else if (i10 == 2) {
            o(VipType.SUPER, com.cupidapp.live.base.utils.h.a(-1, 0.4f));
        } else if (i10 == 3) {
            o(VipType.RAINBOW, com.cupidapp.live.base.utils.h.a(-1, 0.4f));
        } else if (i10 == 4) {
            o(VipType.VISITOR, -3750202);
        }
        getTabAdapter().notifyDataSetChanged();
    }

    public final void o(VipType vipType, int i10) {
        List<Object> j10 = getTabAdapter().j();
        ArrayList<VipPurchaseTabModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof VipPurchaseTabModel) {
                arrayList.add(obj);
            }
        }
        for (VipPurchaseTabModel vipPurchaseTabModel : arrayList) {
            vipPurchaseTabModel.setUnSelectColor(i10);
            vipPurchaseTabModel.setSelect(vipPurchaseTabModel.getVipType() == vipType);
        }
    }

    public final void setTabSelectCallback(@Nullable Function1<? super VipType, p> function1) {
        this.f18803g = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18804h = new LinkedHashMap();
        this.f18798b = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$visitorTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.VISITOR;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.visitor_tab);
                s.h(string, "context.getString(R.string.visitor_tab)");
                String string2 = VipPurchaseTabLayout.this.getContext().getString(R$string.privileges_package);
                s.h(string2, "context.getString(R.string.privileges_package)");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, r.e(-49088), null, 0, false, 224, null);
            }
        });
        this.f18799c = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$normalVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.NORMAL;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.normal_vip);
                s.h(string, "context.getString(R.string.normal_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …ORMAL).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, r.e(-49088), null, 0, false, 224, null);
            }
        });
        this.f18800d = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$sVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.SUPER;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.diamond_vip);
                s.h(string, "context.getString(R.string.diamond_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …SUPER).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, kotlin.collections.s.m(-137028, -84391, -80264), r.e(-83876), 0, false, 192, null);
            }
        });
        this.f18801e = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$rainbowVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.RAINBOW;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.rainbow_vip);
                s.h(string, "context.getString(R.string.rainbow_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …INBOW).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, kotlin.collections.s.m(-48062, -25525, -7875, -3211419, -13330689, -6085377), null, 0, false, 224, null);
            }
        });
        this.f18802f = kotlin.c.b(new Function0<VipPurchaseTabAdapter>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$tabAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabAdapter invoke() {
                VipPurchaseTabAdapter vipPurchaseTabAdapter = new VipPurchaseTabAdapter();
                final VipPurchaseTabLayout vipPurchaseTabLayout = VipPurchaseTabLayout.this;
                vipPurchaseTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$tabAdapter$2$1$1
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
                        if (obj instanceof VipPurchaseTabModel) {
                            VipPurchaseTabModel vipPurchaseTabModel = (VipPurchaseTabModel) obj;
                            if (vipPurchaseTabModel.getSelect()) {
                                return;
                            }
                            VipPurchaseTabLayout.this.n(vipPurchaseTabModel);
                            Function1<VipType, p> tabSelectCallback = VipPurchaseTabLayout.this.getTabSelectCallback();
                            if (tabSelectCallback != null) {
                                tabSelectCallback.invoke(vipPurchaseTabModel.getVipType());
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
    public VipPurchaseTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18804h = new LinkedHashMap();
        this.f18798b = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$visitorTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.VISITOR;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.visitor_tab);
                s.h(string, "context.getString(R.string.visitor_tab)");
                String string2 = VipPurchaseTabLayout.this.getContext().getString(R$string.privileges_package);
                s.h(string2, "context.getString(R.string.privileges_package)");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, r.e(-49088), null, 0, false, 224, null);
            }
        });
        this.f18799c = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$normalVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.NORMAL;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.normal_vip);
                s.h(string, "context.getString(R.string.normal_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …ORMAL).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, r.e(-49088), null, 0, false, 224, null);
            }
        });
        this.f18800d = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$sVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.SUPER;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.diamond_vip);
                s.h(string, "context.getString(R.string.diamond_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …SUPER).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, kotlin.collections.s.m(-137028, -84391, -80264), r.e(-83876), 0, false, 192, null);
            }
        });
        this.f18801e = kotlin.c.b(new Function0<VipPurchaseTabModel>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$rainbowVipTab$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabModel invoke() {
                VipType vipType = VipType.RAINBOW;
                String string = VipPurchaseTabLayout.this.getContext().getString(R$string.rainbow_vip);
                s.h(string, "context.getString(R.string.rainbow_vip)");
                Context context2 = VipPurchaseTabLayout.this.getContext();
                a aVar = a.f18806a;
                Context context3 = VipPurchaseTabLayout.this.getContext();
                s.h(context3, "context");
                String string2 = context2.getString(R$string.several_privileges, Integer.valueOf(aVar.d(context3, vipType).size()));
                s.h(string2, "context.getString(\n     …INBOW).size\n            )");
                return new VipPurchaseTabModel(vipType, string, string2, 18.0f, kotlin.collections.s.m(-48062, -25525, -7875, -3211419, -13330689, -6085377), null, 0, false, 224, null);
            }
        });
        this.f18802f = kotlin.c.b(new Function0<VipPurchaseTabAdapter>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$tabAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseTabAdapter invoke() {
                VipPurchaseTabAdapter vipPurchaseTabAdapter = new VipPurchaseTabAdapter();
                final VipPurchaseTabLayout vipPurchaseTabLayout = VipPurchaseTabLayout.this;
                vipPurchaseTabAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseTabLayout$tabAdapter$2$1$1
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
                        if (obj instanceof VipPurchaseTabModel) {
                            VipPurchaseTabModel vipPurchaseTabModel = (VipPurchaseTabModel) obj;
                            if (vipPurchaseTabModel.getSelect()) {
                                return;
                            }
                            VipPurchaseTabLayout.this.n(vipPurchaseTabModel);
                            Function1<VipType, p> tabSelectCallback = VipPurchaseTabLayout.this.getTabSelectCallback();
                            if (tabSelectCallback != null) {
                                tabSelectCallback.invoke(vipPurchaseTabModel.getVipType());
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
