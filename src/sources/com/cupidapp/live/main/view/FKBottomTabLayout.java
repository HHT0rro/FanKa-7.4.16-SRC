package com.cupidapp.live.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.c;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.LivePromotionModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.main.model.BottomTabViewModel;
import com.cupidapp.live.match.fragment.FKMatchContainerFragment;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.google.android.material.tabs.TabLayout;
import com.irisdt.client.others.OthersProtos;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import o1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FKBottomTabLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKBottomTabLayout extends TabLayout implements DefaultLifecycleObserver {

    /* renamed from: b */
    @NotNull
    public List<BottomTabViewModel> f16198b;

    /* renamed from: c */
    @NotNull
    public final i f16199c;

    /* renamed from: d */
    @NotNull
    public Map<Integer, View> f16200d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBottomTabLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16200d = new LinkedHashMap();
        this.f16198b = kotlin.collections.s.o(new BottomTabViewModel(R$mipmap.icon_main_btn_match_selected, R$mipmap.icon_main_btn_match_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_live_selected, R$mipmap.icon_main_btn_live_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_feed_selected, R$mipmap.icon_main_btn_feed_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_chat_selected, R$mipmap.icon_main_btn_chat_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_setting_selected, R$mipmap.icon_main_btn_setting_unselected));
        this.f16199c = new i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(FKBottomTabLayout fKBottomTabLayout, boolean z10, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        fKBottomTabLayout.f(z10, function0);
    }

    private final int getDefaultTabPosition() {
        int pageIndex;
        g gVar = g.f52734a;
        ConstantsResult q10 = gVar.q();
        Integer valueOf = q10 != null ? Integer.valueOf(q10.getDefaultTabIndex()) : null;
        if (valueOf != null && !s.d(gVar.w0().c(), Boolean.TRUE)) {
            pageIndex = valueOf.intValue();
        } else {
            pageIndex = MainActivity.MainPagerType.Match.getPageIndex();
        }
        gVar.w0().d(Boolean.FALSE);
        return pageIndex;
    }

    public static /* synthetic */ void l(FKBottomTabLayout fKBottomTabLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        fKBottomTabLayout.k(z10);
    }

    public static /* synthetic */ void t(FKBottomTabLayout fKBottomTabLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        fKBottomTabLayout.s(z10);
    }

    public final ImageView A(TabLayout.Tab tab) {
        View customView;
        if (tab == null || (customView = tab.getCustomView()) == null) {
            return null;
        }
        return (ImageView) customView.findViewById(R$id.bottomTabImage);
    }

    public final FollowLiveAvatarTabLayout B(TabLayout.Tab tab) {
        View customView;
        if (tab == null || (customView = tab.getCustomView()) == null) {
            return null;
        }
        return (FollowLiveAvatarTabLayout) customView.findViewById(R$id.follow_live_avatar_layout);
    }

    public final View C(TabLayout.Tab tab) {
        View customView;
        if (tab == null || (customView = tab.getCustomView()) == null) {
            return null;
        }
        return customView.findViewById(R$id.signView);
    }

    public final FKUnreadCountTextView D(TabLayout.Tab tab) {
        View customView;
        if (tab == null || (customView = tab.getCustomView()) == null) {
            return null;
        }
        return (FKUnreadCountTextView) customView.findViewById(R$id.unreadCountTextView);
    }

    public final void b(@Nullable Integer num) {
        int intValue = num != null ? num.intValue() : getDefaultTabPosition();
        int i10 = 0;
        for (BottomTabViewModel bottomTabViewModel : this.f16198b) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            BottomTabViewModel bottomTabViewModel2 = bottomTabViewModel;
            TabLayout.Tab newTab = newTab();
            s.h(newTab, "newTab()");
            newTab.setCustomView(R$layout.layout_bottom_tab_item);
            ImageView A = A(newTab);
            if (A != null) {
                A.setImageResource(bottomTabViewModel2.getUnSelectedResId());
            }
            addTab(newTab, intValue == i10);
            i10 = i11;
        }
        a.f52250a.a(this);
    }

    public final void c(@NotNull LifecycleOwner lifecycleOwner) {
        s.i(lifecycleOwner, "lifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public final boolean d() {
        g gVar = g.f52734a;
        return gVar.k() > 0 || gVar.A0() > 0 || gVar.t0() > 0;
    }

    public final boolean e() {
        View C = C(getTabAt(MainActivity.MainPagerType.Match.getPageIndex()));
        boolean z10 = false;
        if (C != null && C.getVisibility() == 0) {
            z10 = true;
        }
        return !z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        if (r0 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        if (r0.getVisibility() != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        if (r3 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if (r11 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        com.cupidapp.live.track.group.GroupOthersLog.p(com.cupidapp.live.track.group.GroupOthersLog.f18702a, com.irisdt.client.others.OthersProtos.Enum_type.LIVE_AVATAR, null, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0034, code lost:
    
        if ((r0 != null && r0.g()) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
    
        if ((r1 != null && r1.getVisibility() == 0) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        if (r12 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        r12.invoke();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(boolean r11, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.p> r12) {
        /*
            r10 = this;
            com.cupidapp.live.MainActivity$MainPagerType r0 = com.cupidapp.live.MainActivity.MainPagerType.Live
            int r0 = r0.getPageIndex()
            com.google.android.material.tabs.TabLayout$Tab r0 = r10.getTabAt(r0)
            com.cupidapp.live.main.view.FKUnreadCountTextView r1 = r10.D(r0)
            com.cupidapp.live.main.view.FollowLiveAvatarTabLayout r0 = r10.B(r0)
            p1.g r2 = p1.g.f52734a
            int r2 = r2.t0()
            r3 = 1
            r4 = 0
            if (r2 <= 0) goto L29
            if (r1 == 0) goto L26
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L26
            r1 = 1
            goto L27
        L26:
            r1 = 0
        L27:
            if (r1 != 0) goto L36
        L29:
            if (r0 == 0) goto L33
            boolean r1 = r0.g()
            if (r1 != r3) goto L33
            r1 = 1
            goto L34
        L33:
            r1 = 0
        L34:
            if (r1 == 0) goto L3b
        L36:
            if (r12 == 0) goto L3b
            r12.invoke()
        L3b:
            if (r0 == 0) goto L44
            int r12 = r0.getVisibility()
            if (r12 != 0) goto L44
            goto L45
        L44:
            r3 = 0
        L45:
            if (r3 == 0) goto L57
            r0.h()
            if (r11 == 0) goto L57
            com.cupidapp.live.track.group.GroupOthersLog r4 = com.cupidapp.live.track.group.GroupOthersLog.f18702a
            com.irisdt.client.others.OthersProtos$Enum_type r5 = com.irisdt.client.others.OthersProtos.Enum_type.LIVE_AVATAR
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            com.cupidapp.live.track.group.GroupOthersLog.p(r4, r5, r6, r7, r8, r9)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.main.view.FKBottomTabLayout.f(boolean, kotlin.jvm.functions.Function0):void");
    }

    public final void h(@NotNull Function0<p> clickCallback) {
        s.i(clickCallback, "clickCallback");
        View C = C(getTabAt(MainActivity.MainPagerType.Live.getPageIndex()));
        g gVar = g.f52734a;
        if (gVar.W()) {
            if (C != null && C.getVisibility() == 0) {
                gVar.z2(false);
                C.setVisibility(8);
                clickCallback.invoke();
                GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_ENTRANCE_SOLID_RED_DOT, null, null, 6, null);
            }
        }
    }

    public final void i(@NotNull TabLayout.Tab tab, boolean z10) {
        int unSelectedResId;
        s.i(tab, "tab");
        if (tab.getPosition() < 0 || tab.getPosition() >= this.f16198b.size()) {
            return;
        }
        if (z10) {
            unSelectedResId = this.f16198b.get(tab.getPosition()).getSelectedResId();
        } else {
            unSelectedResId = this.f16198b.get(tab.getPosition()).getUnSelectedResId();
        }
        ImageView A = A(tab);
        if (A != null) {
            A.setImageResource(unSelectedResId);
        }
    }

    public final void j() {
        l(this, false, 1, null);
        o();
        v();
    }

    public final void k(boolean z10) {
        int pageIndex = MainActivity.MainPagerType.Chat.getPageIndex();
        FKUnreadCountTextView D = D(getTabAt(pageIndex));
        View C = C(getTabAt(pageIndex));
        if (!z10) {
            g gVar = g.f52734a;
            if (gVar.k() <= 0) {
                if (D != null) {
                    D.setUnreadCount(0);
                }
                if (C == null) {
                    return;
                }
                C.setVisibility(gVar.L() > 0 ? 0 : 8);
                return;
            }
        }
        if (D != null) {
            D.setUnreadCount(g.f52734a.k());
        }
        if (C == null) {
            return;
        }
        C.setVisibility(8);
    }

    public final void m() {
        g gVar = g.f52734a;
        if (gVar.L() > 0) {
            l(this, false, 1, null);
            return;
        }
        Context context = getContext();
        MainActivity mainActivity = context instanceof MainActivity ? (MainActivity) context : null;
        if (((mainActivity != null ? mainActivity.S1() : null) instanceof FKMatchContainerFragment) || !gVar.N1()) {
            return;
        }
        u(true);
    }

    public final void o() {
        FKUnreadCountTextView D = D(getTabAt(MainActivity.MainPagerType.Feed.getPageIndex()));
        if (D != null) {
            D.setUnreadCount(g.f52734a.A0());
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        this.f16199c.g();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        c.f(this, lifecycleOwner);
    }

    public final void p() {
        List<ImageModel> I = g.f52734a.I();
        if (I == null || I.isEmpty()) {
            g(this, false, null, 3, null);
            return;
        }
        TabLayout.Tab tabAt = getTabAt(MainActivity.MainPagerType.Live.getPageIndex());
        ImageLoaderView z10 = z(tabAt);
        if (z10 != null && z10.getVisibility() == 0) {
            return;
        }
        ImageView A = A(tabAt);
        FollowLiveAvatarTabLayout B = B(tabAt);
        if (B != null) {
            B.i(I, A);
        }
        GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_AVATAR, null, 2, null);
    }

    public final void q(@Nullable LivePromotionModel livePromotionModel) {
        int pageIndex = MainActivity.MainPagerType.Live.getPageIndex();
        TabLayout.Tab tabAt = getTabAt(pageIndex);
        FKUnreadCountTextView D = D(tabAt);
        View C = C(getTabAt(pageIndex));
        FollowLiveAvatarTabLayout B = B(tabAt);
        ImageLoaderView z10 = z(tabAt);
        ImageView A = A(tabAt);
        if (livePromotionModel == null) {
            if (z10 != null) {
                z10.setVisibility(8);
            }
            if (A == null) {
                return;
            }
            A.setVisibility(0);
            return;
        }
        if (D != null && D.getVisibility() == 0) {
            D.setVisibility(8);
        }
        if (C != null && C.getVisibility() == 0) {
            C.setVisibility(8);
        }
        if (B != null && B.g()) {
            B.h();
        }
        if (A != null) {
            A.setVisibility(4);
        }
        if (z10 != null) {
            ImageLoaderView.g(z10, livePromotionModel.getIconImage(), null, null, 6, null);
        }
        if (z10 != null) {
            z10.setVisibility(0);
        }
        GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_EXTEND, null, 2, null);
    }

    public final void r(@NotNull Function1<? super String, p> clickCallback) {
        LivePromotionModel liveTabPromotionInfo;
        s.i(clickCallback, "clickCallback");
        TabLayout.Tab tabAt = getTabAt(MainActivity.MainPagerType.Live.getPageIndex());
        ImageLoaderView z10 = z(tabAt);
        ImageView A = A(tabAt);
        if (z10 != null && z10.getVisibility() == 0) {
            z10.setVisibility(8);
            if (A != null) {
                A.setVisibility(0);
            }
            ConstantsResult q10 = g.f52734a.q();
            if (q10 != null && (liveTabPromotionInfo = q10.getLiveTabPromotionInfo()) != null) {
                j.a.b(j.f12156c, getContext(), liveTabPromotionInfo.getJumpUrl(), null, 4, null);
                clickCallback.invoke(liveTabPromotionInfo.getConfigId());
            }
            GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_EXTEND, null, null, 6, null);
        }
    }

    public final void s(boolean z10) {
        int pageIndex = MainActivity.MainPagerType.Live.getPageIndex();
        ImageLoaderView z11 = z(getTabAt(pageIndex));
        if (z11 != null && z11.getVisibility() == 0) {
            return;
        }
        FKUnreadCountTextView D = D(getTabAt(pageIndex));
        View C = C(getTabAt(pageIndex));
        g gVar = g.f52734a;
        if (gVar.t0() > 0) {
            if (C != null) {
                C.setVisibility(8);
            }
            if (D != null) {
                D.setVisibility(0);
            }
            if (D != null) {
                D.setUnreadCount(gVar.t0());
            }
            GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_ENTRANCE_RED_DOT, null, 2, null);
        } else {
            if (D != null) {
                D.setVisibility(8);
            }
            if (gVar.W()) {
                if (C != null) {
                    C.setVisibility(0);
                }
                GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_ENTRANCE_SOLID_RED_DOT, null, 2, null);
            } else if (C != null) {
                C.setVisibility(8);
            }
        }
        if (z10) {
            p();
        }
    }

    public final void u(boolean z10) {
        View C = C(getTabAt(MainActivity.MainPagerType.Match.getPageIndex()));
        if ((C != null && C.getVisibility() == 0) && !z10) {
            w2.a.f54095a.c();
            g.f52734a.M0().d(Long.valueOf(System.currentTimeMillis()));
            GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.FINKA_TAB, null, null, 6, null);
        }
        if (!(C != null && C.getVisibility() == 0) && z10) {
            GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.FINKA_TAB, null, 2, null);
        }
        g.f52734a.G2(z10);
        if (C == null) {
            return;
        }
        C.setVisibility(z10 ? 0 : 8);
    }

    public final void v() {
        View C = C(getTabAt(MainActivity.MainPagerType.Setting.getPageIndex()));
        if (C != null) {
            C.setVisibility(g.f52734a.D0() ? 0 : 8);
        }
        if (g.f52734a.D0()) {
            GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.PROFILE_RED_DOT, null, 2, null);
        }
    }

    public final void w() {
        Integer matchTabRedDotWaitSecondWhenChangeTab;
        l(this, false, 1, null);
        if (e() && w2.a.f54095a.b()) {
            ConstantsResult q10 = g.f52734a.q();
            i.d(this.f16199c, Integer.valueOf((q10 == null || (matchTabRedDotWaitSecondWhenChangeTab = q10.getMatchTabRedDotWaitSecondWhenChangeTab()) == null) ? 15 : matchTabRedDotWaitSecondWhenChangeTab.intValue()), 1, new Function0<p>() { // from class: com.cupidapp.live.main.view.FKBottomTabLayout$configTestGroupRedDot$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean x10;
                    x10 = FKBottomTabLayout.this.x();
                    if (x10) {
                        FKBottomTabLayout.this.u(true);
                    }
                }
            }, null, 8, null);
        }
    }

    public final boolean x() {
        Context context = getContext();
        return !(((context instanceof MainActivity ? (MainActivity) context : null) != null ? r0.S1() : null) instanceof FKMatchContainerFragment);
    }

    public final void y() {
        o();
        k(true);
        v();
        if (d()) {
            return;
        }
        if (u0.a.f53817a.b()) {
            w();
        } else {
            m();
        }
    }

    public final ImageLoaderView z(TabLayout.Tab tab) {
        View customView;
        if (tab == null || (customView = tab.getCustomView()) == null) {
            return null;
        }
        return (ImageLoaderView) customView.findViewById(R$id.activity_imageview);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBottomTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16200d = new LinkedHashMap();
        this.f16198b = kotlin.collections.s.o(new BottomTabViewModel(R$mipmap.icon_main_btn_match_selected, R$mipmap.icon_main_btn_match_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_live_selected, R$mipmap.icon_main_btn_live_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_feed_selected, R$mipmap.icon_main_btn_feed_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_chat_selected, R$mipmap.icon_main_btn_chat_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_setting_selected, R$mipmap.icon_main_btn_setting_unselected));
        this.f16199c = new i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBottomTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16200d = new LinkedHashMap();
        this.f16198b = kotlin.collections.s.o(new BottomTabViewModel(R$mipmap.icon_main_btn_match_selected, R$mipmap.icon_main_btn_match_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_live_selected, R$mipmap.icon_main_btn_live_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_feed_selected, R$mipmap.icon_main_btn_feed_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_chat_selected, R$mipmap.icon_main_btn_chat_unselected), new BottomTabViewModel(R$mipmap.icon_main_btn_setting_selected, R$mipmap.icon_main_btn_setting_unselected));
        this.f16199c = new i();
    }
}
