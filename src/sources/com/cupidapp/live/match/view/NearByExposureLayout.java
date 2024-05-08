package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.match.adapter.NearbySuperBoostAdapter;
import com.cupidapp.live.match.adapter.NearbySuperBoostEntranceModel;
import com.cupidapp.live.match.model.NearbyListModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.track.group.SpreadPositionType;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByExposureLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByExposureLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public z f16976d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16977e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f16978f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16979g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByExposureLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16979g = new LinkedHashMap();
        this.f16977e = 10;
        this.f16978f = kotlin.c.b(new Function0<NearbySuperBoostAdapter>() { // from class: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NearbySuperBoostAdapter invoke() {
                NearbySuperBoostAdapter nearbySuperBoostAdapter = new NearbySuperBoostAdapter();
                final NearByExposureLayout nearByExposureLayout = NearByExposureLayout.this;
                nearbySuperBoostAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
                    
                        r2 = r1.f16976d;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r21) {
                        /*
                            r20 = this;
                            r0 = r20
                            r1 = r21
                            boolean r2 = r1 instanceof com.cupidapp.live.match.adapter.NearbySuperBoostEntranceModel
                            if (r2 == 0) goto L13
                            com.cupidapp.live.match.view.NearByExposureLayout r2 = com.cupidapp.live.match.view.NearByExposureLayout.this
                            com.cupidapp.live.match.view.z r2 = com.cupidapp.live.match.view.NearByExposureLayout.f(r2)
                            if (r2 == 0) goto L13
                            r2.b()
                        L13:
                            boolean r2 = r1 instanceof com.cupidapp.live.match.model.NearbyListModel
                            if (r2 == 0) goto L5d
                            com.cupidapp.live.match.model.NearbyListModel r1 = (com.cupidapp.live.match.model.NearbyListModel) r1
                            com.cupidapp.live.match.model.NearbyUserModel r2 = r1.getNearbyUser()
                            boolean r2 = r2.getHide()
                            if (r2 == 0) goto L36
                            org.greenrobot.eventbus.EventBus r1 = org.greenrobot.eventbus.EventBus.c()
                            com.cupidapp.live.match.event.ShowPurchaseDialogEvent r2 = new com.cupidapp.live.match.event.ShowPurchaseDialogEvent
                            com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType r3 = com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType.Nearby
                            com.cupidapp.live.match.model.PurchaseProductType r4 = com.cupidapp.live.match.model.PurchaseProductType.VIP
                            java.lang.String r5 = ""
                            r2.<init>(r3, r5, r4)
                            r1.l(r2)
                            goto L5d
                        L36:
                            com.cupidapp.live.match.activity.NearByMiniProfileActivity$a r6 = com.cupidapp.live.match.activity.NearByMiniProfileActivity.f16517r
                            com.cupidapp.live.match.view.NearByExposureLayout r2 = com.cupidapp.live.match.view.NearByExposureLayout.this
                            android.content.Context r7 = r2.getContext()
                            com.cupidapp.live.match.model.NearbyUserModel r8 = r1.getNearbyUser()
                            com.cupidapp.live.base.sensorslog.SensorScene r9 = com.cupidapp.live.base.sensorslog.SensorScene.NearbySuperBoost
                            r10 = 0
                            r11 = 0
                            r12 = 0
                            r13 = 0
                            com.cupidapp.live.base.sensorslog.SensorPosition r14 = com.cupidapp.live.base.sensorslog.SensorPosition.Nearby
                            com.cupidapp.live.track.group.MiniProfileShowType r15 = com.cupidapp.live.track.group.MiniProfileShowType.NEARBY_SUPER_EXPOSURE
                            r16 = 0
                            com.cupidapp.live.match.model.NearbyUserModel r1 = r1.getNearbyUser()
                            boolean r17 = r1.getFromSpecialExposure()
                            r18 = 632(0x278, float:8.86E-43)
                            r19 = 0
                            com.cupidapp.live.match.activity.NearByMiniProfileActivity.a.b(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
                        L5d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                });
                return nearbySuperBoostAdapter;
            }
        });
        h();
    }

    private final NearbySuperBoostAdapter getSuperBoostAdapter() {
        return (NearbySuperBoostAdapter) this.f16978f.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16979g;
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

    public final void g(@NotNull List<NearbyListModel> superBoostList, @NotNull z listener) {
        kotlin.jvm.internal.s.i(superBoostList, "superBoostList");
        kotlin.jvm.internal.s.i(listener, "listener");
        ((RecyclerView) e(R$id.super_boost_recyclerview)).scrollToPosition(0);
        this.f16976d = listener;
        getSuperBoostAdapter().j().clear();
        getSuperBoostAdapter().d(new NearbySuperBoostEntranceModel());
        GroupOthersLog.f18702a.j0(SpreadPositionType.SUPER_EXPOSURE_SPREAD, SensorPosition.Nearby);
        int size = superBoostList.size();
        int i10 = this.f16977e;
        if (size > i10) {
            superBoostList = superBoostList.subList(0, i10);
        }
        getSuperBoostAdapter().e(superBoostList);
        getSuperBoostAdapter().notifyDataSetChanged();
        TextView more_super_boost_textview = (TextView) e(R$id.more_super_boost_textview);
        kotlin.jvm.internal.s.h(more_super_boost_textview, "more_super_boost_textview");
        boolean z10 = true;
        if (!(superBoostList instanceof Collection) || !superBoostList.isEmpty()) {
            Iterator<NearbyListModel> iterator2 = superBoostList.iterator2();
            while (iterator2.hasNext()) {
                if (!iterator2.next().getNearbyUser().getHide()) {
                    break;
                }
            }
        }
        z10 = false;
        more_super_boost_textview.setVisibility(z10 ? 0 : 8);
    }

    public final void h() {
        z0.z.a(this, R$layout.layout_near_by_exposure, true);
        ((TextView) e(R$id.super_boost_textview)).getPaint().setFakeBoldText(true);
        int i10 = R$id.super_boost_recyclerview;
        RecyclerView recyclerView = (RecyclerView) e(i10);
        recyclerView.setAdapter(getSuperBoostAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        NearbySuperBoostAdapter superBoostAdapter = getSuperBoostAdapter();
        ExposureScene exposureScene = ExposureScene.SuperBoost;
        RecyclerView super_boost_recyclerview = (RecyclerView) e(i10);
        kotlin.jvm.internal.s.h(super_boost_recyclerview, "super_boost_recyclerview");
        superBoostAdapter.t(new RecyclerExposureHelper(exposureScene, super_boost_recyclerview, 0.0f, 0L, null, new Function1<List<? extends h1.a>, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByExposureLayout$initView$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> list) {
                kotlin.jvm.internal.s.i(list, "list");
                Iterator<h1.a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof NearbyListModel) {
                        NearbyListModel nearbyListModel = (NearbyListModel) a10;
                        if (!nearbyListModel.getNearbyUser().getHide()) {
                            GroupSocialLog.f18708a.w(SensorScene.NearbySuperBoost.getValue(), nearbyListModel.getNearbyUser().getId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : nearbyListModel.getNearbyUser().getFromSpecialExposure(), (r29 & 2048) != 0 ? false : false);
                        }
                    }
                }
            }
        }, 28, null));
        TextView more_super_boost_textview = (TextView) e(R$id.more_super_boost_textview);
        kotlin.jvm.internal.s.h(more_super_boost_textview, "more_super_boost_textview");
        z0.y.d(more_super_boost_textview, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByExposureLayout$initView$3
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
                z zVar;
                zVar = NearByExposureLayout.this.f16976d;
                if (zVar != null) {
                    zVar.a();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByExposureLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16979g = new LinkedHashMap();
        this.f16977e = 10;
        this.f16978f = kotlin.c.b(new Function0<NearbySuperBoostAdapter>() { // from class: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NearbySuperBoostAdapter invoke() {
                NearbySuperBoostAdapter nearbySuperBoostAdapter = new NearbySuperBoostAdapter();
                final NearByExposureLayout nearByExposureLayout = NearByExposureLayout.this;
                nearbySuperBoostAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(@Nullable Object obj) {
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                            	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            */
                        /*
                            this = this;
                            r0 = r20
                            r1 = r21
                            boolean r2 = r1 instanceof com.cupidapp.live.match.adapter.NearbySuperBoostEntranceModel
                            if (r2 == 0) goto L13
                            com.cupidapp.live.match.view.NearByExposureLayout r2 = com.cupidapp.live.match.view.NearByExposureLayout.this
                            com.cupidapp.live.match.view.z r2 = com.cupidapp.live.match.view.NearByExposureLayout.f(r2)
                            if (r2 == 0) goto L13
                            r2.b()
                        L13:
                            boolean r2 = r1 instanceof com.cupidapp.live.match.model.NearbyListModel
                            if (r2 == 0) goto L5d
                            com.cupidapp.live.match.model.NearbyListModel r1 = (com.cupidapp.live.match.model.NearbyListModel) r1
                            com.cupidapp.live.match.model.NearbyUserModel r2 = r1.getNearbyUser()
                            boolean r2 = r2.getHide()
                            if (r2 == 0) goto L36
                            org.greenrobot.eventbus.EventBus r1 = org.greenrobot.eventbus.EventBus.c()
                            com.cupidapp.live.match.event.ShowPurchaseDialogEvent r2 = new com.cupidapp.live.match.event.ShowPurchaseDialogEvent
                            com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType r3 = com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType.Nearby
                            com.cupidapp.live.match.model.PurchaseProductType r4 = com.cupidapp.live.match.model.PurchaseProductType.VIP
                            java.lang.String r5 = ""
                            r2.<init>(r3, r5, r4)
                            r1.l(r2)
                            goto L5d
                        L36:
                            com.cupidapp.live.match.activity.NearByMiniProfileActivity$a r6 = com.cupidapp.live.match.activity.NearByMiniProfileActivity.f16517r
                            com.cupidapp.live.match.view.NearByExposureLayout r2 = com.cupidapp.live.match.view.NearByExposureLayout.this
                            android.content.Context r7 = r2.getContext()
                            com.cupidapp.live.match.model.NearbyUserModel r8 = r1.getNearbyUser()
                            com.cupidapp.live.base.sensorslog.SensorScene r9 = com.cupidapp.live.base.sensorslog.SensorScene.NearbySuperBoost
                            r10 = 0
                            r11 = 0
                            r12 = 0
                            r13 = 0
                            com.cupidapp.live.base.sensorslog.SensorPosition r14 = com.cupidapp.live.base.sensorslog.SensorPosition.Nearby
                            com.cupidapp.live.track.group.MiniProfileShowType r15 = com.cupidapp.live.track.group.MiniProfileShowType.NEARBY_SUPER_EXPOSURE
                            r16 = 0
                            com.cupidapp.live.match.model.NearbyUserModel r1 = r1.getNearbyUser()
                            boolean r17 = r1.getFromSpecialExposure()
                            r18 = 632(0x278, float:8.86E-43)
                            r19 = 0
                            com.cupidapp.live.match.activity.NearByMiniProfileActivity.a.b(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
                        L5d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                });
                return nearbySuperBoostAdapter;
            }
        });
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByExposureLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16979g = new LinkedHashMap();
        this.f16977e = 10;
        this.f16978f = kotlin.c.b(new Function0<NearbySuperBoostAdapter>() { // from class: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NearbySuperBoostAdapter invoke() {
                NearbySuperBoostAdapter nearbySuperBoostAdapter = new NearbySuperBoostAdapter();
                final NearByExposureLayout nearByExposureLayout = NearByExposureLayout.this;
                nearbySuperBoostAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                        	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        */
                    /* renamed from: invoke */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r21) {
                        /*
                            r20 = this;
                            r0 = r20
                            r1 = r21
                            boolean r2 = r1 instanceof com.cupidapp.live.match.adapter.NearbySuperBoostEntranceModel
                            if (r2 == 0) goto L13
                            com.cupidapp.live.match.view.NearByExposureLayout r2 = com.cupidapp.live.match.view.NearByExposureLayout.this
                            com.cupidapp.live.match.view.z r2 = com.cupidapp.live.match.view.NearByExposureLayout.f(r2)
                            if (r2 == 0) goto L13
                            r2.b()
                        L13:
                            boolean r2 = r1 instanceof com.cupidapp.live.match.model.NearbyListModel
                            if (r2 == 0) goto L5d
                            com.cupidapp.live.match.model.NearbyListModel r1 = (com.cupidapp.live.match.model.NearbyListModel) r1
                            com.cupidapp.live.match.model.NearbyUserModel r2 = r1.getNearbyUser()
                            boolean r2 = r2.getHide()
                            if (r2 == 0) goto L36
                            org.greenrobot.eventbus.EventBus r1 = org.greenrobot.eventbus.EventBus.c()
                            com.cupidapp.live.match.event.ShowPurchaseDialogEvent r2 = new com.cupidapp.live.match.event.ShowPurchaseDialogEvent
                            com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType r3 = com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType.Nearby
                            com.cupidapp.live.match.model.PurchaseProductType r4 = com.cupidapp.live.match.model.PurchaseProductType.VIP
                            java.lang.String r5 = ""
                            r2.<init>(r3, r5, r4)
                            r1.l(r2)
                            goto L5d
                        L36:
                            com.cupidapp.live.match.activity.NearByMiniProfileActivity$a r6 = com.cupidapp.live.match.activity.NearByMiniProfileActivity.f16517r
                            com.cupidapp.live.match.view.NearByExposureLayout r2 = com.cupidapp.live.match.view.NearByExposureLayout.this
                            android.content.Context r7 = r2.getContext()
                            com.cupidapp.live.match.model.NearbyUserModel r8 = r1.getNearbyUser()
                            com.cupidapp.live.base.sensorslog.SensorScene r9 = com.cupidapp.live.base.sensorslog.SensorScene.NearbySuperBoost
                            r10 = 0
                            r11 = 0
                            r12 = 0
                            r13 = 0
                            com.cupidapp.live.base.sensorslog.SensorPosition r14 = com.cupidapp.live.base.sensorslog.SensorPosition.Nearby
                            com.cupidapp.live.track.group.MiniProfileShowType r15 = com.cupidapp.live.track.group.MiniProfileShowType.NEARBY_SUPER_EXPOSURE
                            r16 = 0
                            com.cupidapp.live.match.model.NearbyUserModel r1 = r1.getNearbyUser()
                            boolean r17 = r1.getFromSpecialExposure()
                            r18 = 632(0x278, float:8.86E-43)
                            r19 = 0
                            com.cupidapp.live.match.activity.NearByMiniProfileActivity.a.b(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
                        L5d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.NearByExposureLayout$superBoostAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                });
                return nearbySuperBoostAdapter;
            }
        });
        h();
    }
}
