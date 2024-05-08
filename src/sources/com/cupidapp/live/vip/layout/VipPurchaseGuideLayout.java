package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.NormalLoopScrollLayout;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.indicator.scroll.ScrollingPagerIndicator;
import com.cupidapp.live.vip.model.VipPrivilegeType;
import com.cupidapp.live.vip.model.VipPurchaseGuideUiModel;
import com.cupidapp.live.vip.model.VipType;
import com.cupidapp.live.vip.wrapper.DynamicEntranceType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: VipPurchaseGuideLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseGuideLayout extends NormalLoopScrollLayout {

    /* renamed from: n, reason: collision with root package name */
    public final long f18789n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public final VipPurchaseGuideAdapter f18790o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18791p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseGuideLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18791p = new LinkedHashMap();
        this.f18789n = com.huawei.openalliance.ad.ipc.c.Code;
        VipPurchaseGuideAdapter vipPurchaseGuideAdapter = new VipPurchaseGuideAdapter();
        vipPurchaseGuideAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.vip_purchase_help), new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseGuideLayout$adapter$1$1
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
                if (obj instanceof VipPurchaseGuideUiModel) {
                    VipPurchaseGuideLayout vipPurchaseGuideLayout = VipPurchaseGuideLayout.this;
                    String help = ((VipPurchaseGuideUiModel) obj).getHelp();
                    View findViewById = VipPurchaseGuideLayout.this.findViewById(R$id.vip_purchase_help);
                    s.h(findViewById, "findViewById(R.id.vip_purchase_help)");
                    vipPurchaseGuideLayout.z(help, findViewById);
                }
            }
        })));
        this.f18790o = vipPurchaseGuideAdapter;
        o();
    }

    public static final void A(VipPurchaseGuideLayout this$0) {
        s.i(this$0, "this$0");
        this$0.q();
    }

    @Override // com.cupidapp.live.base.recyclerview.NormalLoopScrollLayout
    public long getPagerLife() {
        return this.f18789n;
    }

    @Override // com.cupidapp.live.base.recyclerview.NormalLoopScrollLayout
    public void m() {
        z.a(this, R$layout.layout_vip_purchase_guide, true);
        ViewPager2 vip_purchase_guide_viewpager = (ViewPager2) t(R$id.vip_purchase_guide_viewpager);
        s.h(vip_purchase_guide_viewpager, "vip_purchase_guide_viewpager");
        setViewPager(vip_purchase_guide_viewpager);
    }

    @Nullable
    public View t(int i10) {
        Map<Integer, View> map = this.f18791p;
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

    public final void v(@NotNull VipType vipType, @NotNull VipPurchaseEntranceType entranceType) {
        s.i(vipType, "vipType");
        s.i(entranceType, "entranceType");
        int i10 = R$id.guide_indicator_layout;
        ((ScrollingPagerIndicator) t(i10)).k();
        setVisibility(0);
        getAdapter().j().clear();
        List<VipPurchaseGuideUiModel> y10 = y(vipType, entranceType);
        if (y10.size() == 1) {
            getAdapter().e(y10);
            getAdapter().notifyDataSetChanged();
            ((ScrollingPagerIndicator) t(i10)).setVisibility(8);
            return;
        }
        getAdapter().e(y10);
        getAdapter().notifyDataSetChanged();
        Iterator<VipPurchaseGuideUiModel> iterator2 = y10.iterator2();
        int i11 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i11 = -1;
                break;
            } else if (x(iterator2.next(), entranceType)) {
                break;
            } else {
                i11++;
            }
        }
        getViewPager().setCurrentItem(i11, false);
        ScrollingPagerIndicator scrollingPagerIndicator = (ScrollingPagerIndicator) t(R$id.guide_indicator_layout);
        scrollingPagerIndicator.setVisibility(0);
        VipType vipType2 = VipType.NORMAL;
        scrollingPagerIndicator.setSelectedDotColor(vipType == vipType2 ? -7434610 : -1);
        scrollingPagerIndicator.setDotColor(vipType == vipType2 ? -2236963 : h.a(-1, 0.3f));
        scrollingPagerIndicator.g(getViewPager());
        scrollingPagerIndicator.setDotCount(getAdapter().getItemCount());
        q();
    }

    public final VipPrivilegeType w(VipPurchaseEntranceType vipPurchaseEntranceType) {
        String from = vipPurchaseEntranceType.getFrom();
        if (s.d(from, VipPurchaseEntranceType.PersonalFrame.getFrom())) {
            return VipPrivilegeType.CardBorder;
        }
        if (s.d(from, VipPurchaseEntranceType.CustomChatBubble.getFrom())) {
            return VipPrivilegeType.ChatBubble;
        }
        if (s.d(from, VipPurchaseEntranceType.FeedSpread.getFrom())) {
            return VipPrivilegeType.DynamicPromotion;
        }
        if (s.d(from, DynamicEntranceType.Nearby.getFrom())) {
            return VipPrivilegeType.PeopleNearby;
        }
        if (s.d(from, DynamicEntranceType.CustomHide.getFrom())) {
            return VipPrivilegeType.CustomStealth;
        }
        if (s.d(from, DynamicEntranceType.MapLookingSomeone.getFrom())) {
            return VipPrivilegeType.MapForPeople;
        }
        if (s.d(from, DynamicEntranceType.FastCancelFollow.getFrom())) {
            return VipPrivilegeType.AddressBook;
        }
        if (s.d(from, DynamicEntranceType.SpecialExposure.getFrom())) {
            return VipPrivilegeType.RainbowRecommend;
        }
        return null;
    }

    public final boolean x(VipPurchaseGuideUiModel vipPurchaseGuideUiModel, VipPurchaseEntranceType vipPurchaseEntranceType) {
        if (vipPurchaseEntranceType == VipPurchaseEntranceType.DynEntrance) {
            VipPrivilegeType w3 = w(vipPurchaseEntranceType);
            List<VipPurchaseEntranceType> typeList = vipPurchaseGuideUiModel.getTypeList();
            if ((typeList != null && typeList.contains(vipPurchaseEntranceType)) && vipPurchaseGuideUiModel.getPrivilegeType() == w3) {
                return true;
            }
        } else {
            List<VipPurchaseEntranceType> typeList2 = vipPurchaseGuideUiModel.getTypeList();
            if (typeList2 != null && typeList2.contains(vipPurchaseEntranceType)) {
                return true;
            }
        }
        return false;
    }

    public final List<VipPurchaseGuideUiModel> y(VipType vipType, VipPurchaseEntranceType vipPurchaseEntranceType) {
        a aVar = a.f18806a;
        Context context = getContext();
        s.h(context, "context");
        List<VipPurchaseGuideUiModel> z02 = CollectionsKt___CollectionsKt.z0(aVar.d(context, vipType));
        if (vipType == VipType.RAINBOW) {
            VipPurchaseGuideUiModel vipPurchaseGuideUiModel = null;
            Iterator<VipPurchaseGuideUiModel> iterator2 = z02.iterator2();
            while (true) {
                boolean z10 = false;
                if (!iterator2.hasNext()) {
                    break;
                }
                VipPurchaseGuideUiModel next = iterator2.next();
                next.setVipType(vipType);
                List<VipPurchaseEntranceType> typeList = next.getTypeList();
                if (typeList != null && typeList.contains(vipPurchaseEntranceType)) {
                    z10 = true;
                }
                if (z10) {
                    if (vipPurchaseEntranceType == VipPurchaseEntranceType.DynEntrance) {
                        if (next.getPrivilegeType() == w(vipPurchaseEntranceType)) {
                            iterator2.remove();
                        }
                    } else {
                        iterator2.remove();
                    }
                    vipPurchaseGuideUiModel = next;
                }
            }
            if (vipPurchaseGuideUiModel != null) {
                z02.add(0, vipPurchaseGuideUiModel);
            }
        } else {
            Iterator<VipPurchaseGuideUiModel> iterator22 = z02.iterator2();
            while (iterator22.hasNext()) {
                iterator22.next().setVipType(vipType);
            }
        }
        return z02;
    }

    public final void z(String str, View view) {
        if (str == null || str.length() == 0) {
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setBackgroundResource(R$drawable.bg_vip_skip_ad_help);
        textView.setTextColor(-16777216);
        textView.setTextSize(12.0f);
        textView.setText(str);
        PopupWindow popupWindow = new PopupWindow(textView, z0.h.c(this, 170.0f), -2);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.cupidapp.live.vip.layout.d
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                VipPurchaseGuideLayout.A(VipPurchaseGuideLayout.this);
            }
        });
        popupWindow.showAsDropDown(view, z0.h.c(this, 40.0f) - (view.getWidth() / 2), 0, 8388613);
        r();
    }

    @Override // com.cupidapp.live.base.recyclerview.NormalLoopScrollLayout
    @NotNull
    public VipPurchaseGuideAdapter getAdapter() {
        return this.f18790o;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18791p = new LinkedHashMap();
        this.f18789n = com.huawei.openalliance.ad.ipc.c.Code;
        VipPurchaseGuideAdapter vipPurchaseGuideAdapter = new VipPurchaseGuideAdapter();
        vipPurchaseGuideAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.vip_purchase_help), new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseGuideLayout$adapter$1$1
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
                if (obj instanceof VipPurchaseGuideUiModel) {
                    VipPurchaseGuideLayout vipPurchaseGuideLayout = VipPurchaseGuideLayout.this;
                    String help = ((VipPurchaseGuideUiModel) obj).getHelp();
                    View findViewById = VipPurchaseGuideLayout.this.findViewById(R$id.vip_purchase_help);
                    s.h(findViewById, "findViewById(R.id.vip_purchase_help)");
                    vipPurchaseGuideLayout.z(help, findViewById);
                }
            }
        })));
        this.f18790o = vipPurchaseGuideAdapter;
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18791p = new LinkedHashMap();
        this.f18789n = com.huawei.openalliance.ad.ipc.c.Code;
        VipPurchaseGuideAdapter vipPurchaseGuideAdapter = new VipPurchaseGuideAdapter();
        vipPurchaseGuideAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.vip_purchase_help), new Function1<Object, p>() { // from class: com.cupidapp.live.vip.layout.VipPurchaseGuideLayout$adapter$1$1
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
                if (obj instanceof VipPurchaseGuideUiModel) {
                    VipPurchaseGuideLayout vipPurchaseGuideLayout = VipPurchaseGuideLayout.this;
                    String help = ((VipPurchaseGuideUiModel) obj).getHelp();
                    View findViewById = VipPurchaseGuideLayout.this.findViewById(R$id.vip_purchase_help);
                    s.h(findViewById, "findViewById(R.id.vip_purchase_help)");
                    vipPurchaseGuideLayout.z(help, findViewById);
                }
            }
        })));
        this.f18790o = vipPurchaseGuideAdapter;
        o();
    }
}
