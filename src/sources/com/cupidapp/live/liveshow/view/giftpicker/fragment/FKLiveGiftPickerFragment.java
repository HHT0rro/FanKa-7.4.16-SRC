package com.cupidapp.live.liveshow.view.giftpicker.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.utils.l;
import com.cupidapp.live.base.view.FKRecyclerTitleLayout;
import com.cupidapp.live.base.view.FKTitleViewModel;
import com.cupidapp.live.base.view.TitleConfigModel;
import com.cupidapp.live.liveshow.activity.FKBaseLiveActivity;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.GiftFragmentsModel;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.GiftListResult;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.LiveGiftActivityModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.NobleCardModel;
import com.cupidapp.live.liveshow.model.ParcelItemModel;
import com.cupidapp.live.liveshow.model.ParcelModel;
import com.cupidapp.live.liveshow.model.ParcelModelType;
import com.cupidapp.live.liveshow.model.PropCardResult;
import com.cupidapp.live.liveshow.model.PropsType;
import com.cupidapp.live.liveshow.model.SingleTabGiftConfigModel;
import com.cupidapp.live.liveshow.model.SingleTabGiftListModel;
import com.cupidapp.live.liveshow.model.SingleTabParcelListModel;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.FKLiveGiftPickerItemViewModel;
import com.cupidapp.live.liveshow.view.giftpicker.adapter.SelectCurrentGiftEvent;
import com.cupidapp.live.liveshow.view.giftpicker.view.FKCustomGiftSendCountLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.FKGiftDetailDescriptionLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftPickerLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.FKSendGiftBottomMenuLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.FKSendGiftCountSelectLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.GiftExperienceLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.h;
import com.cupidapp.live.liveshow.view.giftpicker.view.k;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.google.android.material.badge.BadgeDrawable;
import com.irisdt.client.live.LiveProtos;
import he.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.y;

/* compiled from: FKLiveGiftPickerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final a f15447n = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public static boolean f15448o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public static FKLiveGiftPickerFragment f15449p;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f15451f;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public FKCustomGiftSendCountLayout f15454i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public LiveGiftActivityModel f15455j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.liveshow.view.giftpicker.fragment.b f15456k;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15458m = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15450e = kotlin.c.b(new Function0<GiftListResult>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$giftListResult$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final GiftListResult invoke() {
            Bundle arguments = FKLiveGiftPickerFragment.this.getArguments();
            if (arguments != null) {
                return (GiftListResult) g.b(arguments, GiftListResult.class);
            }
            return null;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    public int f15452g = 1;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f15453h = kotlin.c.b(new Function0<l>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$popupWindowWrapper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final l invoke() {
            return new l();
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public boolean f15457l = true;

    /* compiled from: FKLiveGiftPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            FKLiveGiftPickerFragment fKLiveGiftPickerFragment;
            if (!b() || (fKLiveGiftPickerFragment = FKLiveGiftPickerFragment.f15449p) == null) {
                return;
            }
            fKLiveGiftPickerFragment.dismiss();
        }

        public final boolean b() {
            return FKLiveGiftPickerFragment.f15448o;
        }

        public final void c(@Nullable FragmentManager fragmentManager, @NotNull GiftListResult model, @Nullable String str, @Nullable String str2, @NotNull com.cupidapp.live.liveshow.view.giftpicker.fragment.b listener) {
            s.i(model, "model");
            s.i(listener, "listener");
            if (fragmentManager == null || b()) {
                return;
            }
            FKLiveGiftPickerFragment.f15449p = new FKLiveGiftPickerFragment();
            FKLiveGiftPickerFragment fKLiveGiftPickerFragment = FKLiveGiftPickerFragment.f15449p;
            if (fKLiveGiftPickerFragment != null) {
                Bundle bundle = new Bundle();
                g.d(bundle, model);
                bundle.putString("GIFT_ID", str);
                bundle.putString("FENCE_ID", str2);
                fKLiveGiftPickerFragment.setArguments(bundle);
            }
            FKLiveGiftPickerFragment fKLiveGiftPickerFragment2 = FKLiveGiftPickerFragment.f15449p;
            if (fKLiveGiftPickerFragment2 != null) {
                fKLiveGiftPickerFragment2.f15456k = listener;
            }
            FKLiveGiftPickerFragment fKLiveGiftPickerFragment3 = FKLiveGiftPickerFragment.f15449p;
            if (fKLiveGiftPickerFragment3 != null) {
                fKLiveGiftPickerFragment3.show(fragmentManager, FKLiveGiftPickerFragment.class.getSimpleName());
            }
        }
    }

    /* compiled from: FKLiveGiftPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements k {
        public b() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.k
        public void a(int i10) {
            Object obj;
            GiftItemModel giftItemModel;
            List A1 = FKLiveGiftPickerFragment.this.A1();
            if (A1 != null) {
                Iterator<E> iterator2 = A1.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = iterator2.next();
                        if (((FKLiveGiftPickerItemViewModel) obj).isSelected()) {
                            break;
                        }
                    }
                }
                FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel = (FKLiveGiftPickerItemViewModel) obj;
                if (fKLiveGiftPickerItemViewModel == null || (giftItemModel = fKLiveGiftPickerItemViewModel.getGiftItemModel()) == null) {
                    return;
                }
                FKLiveGiftPickerFragment.this.M1(giftItemModel.getPrice(), i10);
            }
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.k
        public void b() {
            EventBus.c().l(new OpenDiamondBalanceEvent());
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.k
        public void c() {
            FKLiveGiftPickerFragment.this.L1();
        }
    }

    /* compiled from: FKLiveGiftPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements h {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.h
        public void a(int i10, @NotNull String tabName) {
            s.i(tabName, "tabName");
            FKLiveGiftPickerFragment.this.O1(i10, tabName, false);
        }
    }

    /* compiled from: FKLiveGiftPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements h {
        public d() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.h
        public void a(int i10, @NotNull String tabName) {
            s.i(tabName, "tabName");
            FKLiveGiftPickerFragment.this.N1(i10, tabName, false);
        }
    }

    public final List<FKLiveGiftPickerItemViewModel> A1() {
        if (((LinearLayout) V0(R$id.giftPickerContainerLayout)).getVisibility() == 0) {
            return ((FKLiveGiftPickerLayout) V0(R$id.giftPickerLayout)).getCurrentTabGiftList();
        }
        if (((LinearLayout) V0(R$id.backpackPickerLayout)).getVisibility() == 0) {
            return ((FKLiveGiftPickerLayout) V0(R$id.backpackGiftPickerLayout)).getCurrentTabGiftList();
        }
        if (((LinearLayout) V0(R$id.upgrade_gift_container_Layout)).getVisibility() == 0) {
            return ((FKLiveGiftPickerLayout) V0(R$id.upgrade_gift_picker_layout)).getCurrentTabGiftList();
        }
        return null;
    }

    public final int B1(List<String> list, String str) {
        if (CollectionsKt___CollectionsKt.L(list, str)) {
            return CollectionsKt___CollectionsKt.Y(list, str);
        }
        return 0;
    }

    public final GiftListResult C1() {
        return (GiftListResult) this.f15450e.getValue();
    }

    public final l D1() {
        return (l) this.f15453h.getValue();
    }

    public final Function1<GiftItemModel, Boolean> E1(final GiftModel giftModel) {
        return new Function1<GiftItemModel, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$getUpgradeGiftSelectedCondition$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GiftItemModel it) {
                s.i(it, "it");
                GiftModel giftModel2 = GiftModel.this;
                String itemId = giftModel2 != null ? giftModel2.getItemId() : null;
                GiftModel giftModel3 = GiftModel.this;
                return Boolean.valueOf(s.d(itemId + "_" + (giftModel3 != null ? giftModel3.getName() : null), it.getItemId() + "_" + it.getName()));
            }
        };
    }

    public final void F1(GiftItemModel giftItemModel) {
        Long valueOf;
        if (giftItemModel instanceof ParcelItemModel) {
            if (((ParcelItemModel) giftItemModel).getType() == ParcelModelType.ParcelGiftType.getType()) {
                Long experience = giftItemModel.getExperience();
                valueOf = Long.valueOf((experience != null ? experience.longValue() : 0L) * (giftItemModel.getRushEnable() ? this.f15452g : 1));
            } else {
                valueOf = null;
            }
        } else {
            Long experience2 = giftItemModel.getExperience();
            valueOf = Long.valueOf((experience2 != null ? experience2.longValue() : 0L) * (giftItemModel.getRushEnable() ? this.f15452g : 1));
        }
        ((GiftExperienceLayout) V0(R$id.experience_layout)).e(valueOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016a A[LOOP:1: B:51:0x0164->B:53:0x016a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void G1() {
        /*
            Method dump skipped, instructions count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment.G1():void");
    }

    public final void H1() {
        Long experience;
        FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel;
        List<FKLiveGiftPickerItemViewModel> A1 = A1();
        GiftItemModel giftItemModel = null;
        if (A1 != null) {
            Iterator<FKLiveGiftPickerItemViewModel> iterator2 = A1.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    fKLiveGiftPickerItemViewModel = null;
                    break;
                } else {
                    fKLiveGiftPickerItemViewModel = iterator2.next();
                    if (fKLiveGiftPickerItemViewModel.isSelected()) {
                        break;
                    }
                }
            }
            FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel2 = fKLiveGiftPickerItemViewModel;
            if (fKLiveGiftPickerItemViewModel2 != null) {
                giftItemModel = fKLiveGiftPickerItemViewModel2.getGiftItemModel();
            }
        }
        ((GiftExperienceLayout) V0(R$id.experience_layout)).e(Long.valueOf(((giftItemModel == null || (experience = giftItemModel.getExperience()) == null) ? 0L : experience.longValue()) * this.f15452g));
    }

    public final void I1(LiveProtos.Type type) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.f(liveShowModel.getItemId(), liveShowModel.getUser().userId(), type, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        }
    }

    public final void J1(String str) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.i(liveShowModel.getItemId(), liveShowModel.getUser().userId(), str);
        }
    }

    public final void K1() {
        ((FKGiftDetailDescriptionLayout) V0(R$id.giftDetailDescriptionLayout)).setVisibility(8);
        FKSendGiftBottomMenuLayout sendGiftBottomMenuLayout = (FKSendGiftBottomMenuLayout) V0(R$id.sendGiftBottomMenuLayout);
        s.h(sendGiftBottomMenuLayout, "sendGiftBottomMenuLayout");
        String string = getString(R$string.give);
        s.h(string, "getString(R.string.give)");
        sendGiftBottomMenuLayout.i(false, string, (r13 & 4) != 0 ? false : false, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? false : false);
        ((GiftExperienceLayout) V0(R$id.experience_layout)).e(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00af, code lost:
    
        if (r3.intValue() != r4) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void L1() {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment.L1():void");
    }

    public final void M1(int i10, int i11) {
        final Context context = getContext();
        if (context != null) {
            FKSendGiftCountSelectLayout fKSendGiftCountSelectLayout = new FKSendGiftCountSelectLayout(context);
            GiftListResult C1 = C1();
            if (C1 != null) {
                fKSendGiftCountSelectLayout.b(C1.getBulkGiftsCountDesc(), this.f15452g, i10, C1.getSmallHornTriggerDiamonds(), C1.getBigHornTriggerDiamonds(), new com.cupidapp.live.liveshow.view.giftpicker.view.g() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$showPopupWindow$1$1$1
                    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.g
                    public void a(int i12) {
                        l D1;
                        FKLiveGiftPickerFragment.this.f15452g = i12;
                        FKLiveGiftPickerFragment.this.H1();
                        ((FKSendGiftBottomMenuLayout) FKLiveGiftPickerFragment.this.V0(R$id.sendGiftBottomMenuLayout)).setGiftCountText(i12);
                        D1 = FKLiveGiftPickerFragment.this.D1();
                        D1.d();
                    }

                    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.g
                    public void b() {
                        FKCustomGiftSendCountLayout fKCustomGiftSendCountLayout;
                        FKLiveGiftPickerFragment fKLiveGiftPickerFragment = FKLiveGiftPickerFragment.this;
                        Context it = context;
                        s.h(it, "it");
                        fKLiveGiftPickerFragment.f15454i = new FKCustomGiftSendCountLayout(it);
                        fKCustomGiftSendCountLayout = FKLiveGiftPickerFragment.this.f15454i;
                        if (fKCustomGiftSendCountLayout != null) {
                            final FKLiveGiftPickerFragment fKLiveGiftPickerFragment2 = FKLiveGiftPickerFragment.this;
                            Function0<p> function0 = new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$showPopupWindow$1$1$1$customGiftCount$1
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
                                    FragmentActivity activity = FKLiveGiftPickerFragment.this.getActivity();
                                    final FKBaseLiveActivity fKBaseLiveActivity = activity instanceof FKBaseLiveActivity ? (FKBaseLiveActivity) activity : null;
                                    if (fKBaseLiveActivity != null) {
                                        final FKLiveGiftPickerFragment fKLiveGiftPickerFragment3 = FKLiveGiftPickerFragment.this;
                                        fKBaseLiveActivity.w1(new Function2<Integer, Boolean, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$showPopupWindow$1$1$1$customGiftCount$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            /* renamed from: invoke */
                                            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, Boolean bool) {
                                                invoke(num.intValue(), bool.booleanValue());
                                                return p.f51048a;
                                            }

                                            public final void invoke(int i12, boolean z10) {
                                                FKCustomGiftSendCountLayout fKCustomGiftSendCountLayout2;
                                                if (z10) {
                                                    return;
                                                }
                                                fKCustomGiftSendCountLayout2 = FKLiveGiftPickerFragment.this.f15454i;
                                                if (fKCustomGiftSendCountLayout2 != null) {
                                                    fKCustomGiftSendCountLayout2.e();
                                                }
                                                fKBaseLiveActivity.D1();
                                            }
                                        });
                                    }
                                }
                            };
                            final FKLiveGiftPickerFragment fKLiveGiftPickerFragment3 = FKLiveGiftPickerFragment.this;
                            fKCustomGiftSendCountLayout.g(function0, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$showPopupWindow$1$1$1$customGiftCount$2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ p invoke(Integer num) {
                                    invoke(num.intValue());
                                    return p.f51048a;
                                }

                                public final void invoke(int i12) {
                                    l D1;
                                    FKLiveGiftPickerFragment.this.f15452g = i12;
                                    FKLiveGiftPickerFragment.this.H1();
                                    ((FKSendGiftBottomMenuLayout) FKLiveGiftPickerFragment.this.V0(R$id.sendGiftBottomMenuLayout)).setGiftCountText(i12);
                                    D1 = FKLiveGiftPickerFragment.this.D1();
                                    D1.d();
                                }
                            });
                        }
                    }
                });
            }
            l h10 = l.f(D1(), fKSendGiftCountSelectLayout, 0, 0, 6, null).h(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$showPopupWindow$1$2
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
                    ((FKSendGiftBottomMenuLayout) FKLiveGiftPickerFragment.this.V0(R$id.sendGiftBottomMenuLayout)).l(false);
                }
            });
            int i12 = R$id.sendGiftBottomMenuLayout;
            FKSendGiftBottomMenuLayout sendGiftBottomMenuLayout = (FKSendGiftBottomMenuLayout) V0(i12);
            s.h(sendGiftBottomMenuLayout, "sendGiftBottomMenuLayout");
            h10.j(sendGiftBottomMenuLayout, BadgeDrawable.BOTTOM_END, z0.h.c(this, 20.0f), z0.h.k(this) - i11);
            ((FKSendGiftBottomMenuLayout) V0(i12)).l(true);
        }
    }

    public final void N1(int i10, String str, boolean z10) {
        ((FKRecyclerTitleLayout) V0(R$id.backpackTitleLayout)).g(i10);
        K1();
        int i11 = R$id.backpackGiftPickerLayout;
        ((FKLiveGiftPickerLayout) V0(i11)).l();
        w1(i10);
        if (z10) {
            ((FKLiveGiftPickerLayout) V0(i11)).m(i10);
        }
        J1(str);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15458m.clear();
    }

    public final void O1(int i10, String str, boolean z10) {
        List<SingleTabGiftListModel> giftList;
        ((FKRecyclerTitleLayout) V0(R$id.giftTitleLayout)).g(i10);
        K1();
        int i11 = R$id.giftPickerLayout;
        ((FKLiveGiftPickerLayout) V0(i11)).l();
        GiftListResult C1 = C1();
        if (C1 != null && (giftList = C1.getGiftList()) != null) {
            this.f15455j = giftList.get(i10).getBanner();
            ((FKGiftDetailDescriptionLayout) V0(R$id.giftDetailDescriptionLayout)).j(this.f15455j);
        }
        if (z10) {
            ((FKLiveGiftPickerLayout) V0(i11)).m(i10);
        }
        J1(str);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public boolean P0() {
        return this.f15457l;
    }

    public final void P1(SingleTabGiftListModel singleTabGiftListModel) {
        List<SingleTabGiftListModel> giftList;
        GiftListResult C1 = C1();
        if (C1 == null || (giftList = C1.getGiftList()) == null) {
            return;
        }
        ((FKLiveGiftPickerLayout) V0(R$id.backpackGiftPickerLayout)).l();
        LinearLayout giftPickerContainerLayout = (LinearLayout) V0(R$id.giftPickerContainerLayout);
        s.h(giftPickerContainerLayout, "giftPickerContainerLayout");
        x1(giftPickerContainerLayout);
        ArrayList arrayList = new ArrayList(t.t(giftList, 10));
        Iterator<SingleTabGiftListModel> iterator2 = giftList.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getFenceId());
        }
        int B1 = B1(arrayList, singleTabGiftListModel != null ? singleTabGiftListModel.getFenceId() : null);
        ((FKRecyclerTitleLayout) V0(R$id.giftTitleLayout)).g(B1);
        ((FKLiveGiftPickerLayout) V0(R$id.giftPickerLayout)).i(B1, singleTabGiftListModel);
        this.f15455j = giftList.get(B1).getBanner();
        ((FKGiftDetailDescriptionLayout) V0(R$id.giftDetailDescriptionLayout)).j(this.f15455j);
        FKSendGiftBottomMenuLayout sendGiftBottomMenuLayout = (FKSendGiftBottomMenuLayout) V0(R$id.sendGiftBottomMenuLayout);
        s.h(sendGiftBottomMenuLayout, "sendGiftBottomMenuLayout");
        String string = getString(R$string.give);
        s.h(string, "getString(R.string.give)");
        sendGiftBottomMenuLayout.i(false, string, (r13 & 4) != 0 ? false : false, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? false : false);
    }

    public final void Q1(final ParcelItemModel parcelItemModel) {
        String itemId;
        User X;
        String userId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || (X = p1.g.f52734a.X()) == null || (userId = X.userId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().O(itemId, userId, parcelItemModel.getItemId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<PropCardResult, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$usePropCard$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PropCardResult propCardResult) {
                m2644invoke(propCardResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2644invoke(PropCardResult propCardResult) {
                NobleCardModel nobilityCard;
                PropCardResult propCardResult2 = propCardResult;
                Integer category = ParcelItemModel.this.getCategory();
                int value = PropsType.DiscountCard.getValue();
                if (category != null && category.intValue() == value) {
                    this.f15451f = ParcelItemModel.this.getItemId();
                    this.P1(propCardResult2.getGiftDiscountCard());
                    return;
                }
                int value2 = PropsType.NobleExperienceCard.getValue();
                if (category == null || category.intValue() != value2 || (nobilityCard = propCardResult2.getNobilityCard()) == null) {
                    return;
                }
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult != null) {
                    fkLiveShowResult.setBarrageCardCount(nobilityCard.getBarrageCardCount());
                }
                com.cupidapp.live.base.view.h.f12779a.d(this.getContext(), nobilityCard.getToast());
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(nobilityCard.getPath(), false, 2, null));
                this.dismiss();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void R1(Integer num) {
        User user;
        GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        String str = null;
        String itemId = liveShowModel != null ? liveShowModel.getItemId() : null;
        LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel2 != null && (user = liveShowModel2.getUser()) != null) {
            str = user.userId();
        }
        groupLiveLog.t(itemId, str, num);
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15458m;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_gift_picker, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        f15448o = false;
        com.cupidapp.live.liveshow.view.giftpicker.fragment.b bVar = this.f15456k;
        if (bVar != null) {
            bVar.a();
        }
        O0();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SelectCurrentGiftEvent event) {
        s.i(event, "event");
        GiftItemModel giftItemModel = event.getGiftItemModel();
        boolean z10 = giftItemModel instanceof GiftModel;
        if (z10 && s.d(((GiftModel) giftItemModel).getUnlocked(), Boolean.FALSE)) {
            return;
        }
        if (z10 && this.f15451f != null && s.d(((GiftModel) giftItemModel).getCanUseGiftDiscount(), Boolean.FALSE)) {
            com.cupidapp.live.base.view.h.f12779a.r(getContext(), R$string.can_not_use_discount);
            return;
        }
        y1(giftItemModel);
        ((FKGiftDetailDescriptionLayout) V0(R$id.giftDetailDescriptionLayout)).i(giftItemModel);
        v1(giftItemModel);
        if (((LinearLayout) V0(R$id.giftPickerContainerLayout)).getVisibility() == 0) {
            ((FKLiveGiftPickerLayout) V0(R$id.giftPickerLayout)).j(giftItemModel.getItemId());
        } else if (((LinearLayout) V0(R$id.backpackPickerLayout)).getVisibility() == 0) {
            ((FKLiveGiftPickerLayout) V0(R$id.backpackGiftPickerLayout)).j(giftItemModel.getItemId());
        } else if (((LinearLayout) V0(R$id.upgrade_gift_container_Layout)).getVisibility() == 0 && z10) {
            ((FKLiveGiftPickerLayout) V0(R$id.upgrade_gift_picker_layout)).k(E1((GiftModel) giftItemModel));
        }
        F1(giftItemModel);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        f15448o = true;
        G1();
        u1();
    }

    public final void u1() {
        ((FKGiftDetailDescriptionLayout) V0(R$id.giftDetailDescriptionLayout)).setBlankClickCallback(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$bindClickEvent$1
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
                FKLiveGiftPickerFragment.this.dismiss();
            }
        });
        ((FKRecyclerTitleLayout) V0(R$id.giftTitleLayout)).setTitleClickListener(new Function2<Integer, FKTitleViewModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$bindClickEvent$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, FKTitleViewModel fKTitleViewModel) {
                invoke(num.intValue(), fKTitleViewModel);
                return p.f51048a;
            }

            public final void invoke(int i10, @NotNull FKTitleViewModel model) {
                s.i(model, "model");
                if (model.isSelected()) {
                    return;
                }
                FKLiveGiftPickerFragment.this.O1(i10, model.getText(), true);
            }
        });
        ((FKRecyclerTitleLayout) V0(R$id.backpackTitleLayout)).setTitleClickListener(new Function2<Integer, FKTitleViewModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$bindClickEvent$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, FKTitleViewModel fKTitleViewModel) {
                invoke(num.intValue(), fKTitleViewModel);
                return p.f51048a;
            }

            public final void invoke(int i10, @NotNull FKTitleViewModel model) {
                s.i(model, "model");
                if (model.isSelected()) {
                    return;
                }
                FKLiveGiftPickerFragment.this.N1(i10, model.getText(), true);
            }
        });
        ((FKSendGiftBottomMenuLayout) V0(R$id.sendGiftBottomMenuLayout)).setSendGiftListener(new b());
        TextView backpackButton = (TextView) V0(R$id.backpackButton);
        s.h(backpackButton, "backpackButton");
        y.d(backpackButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$bindClickEvent$5
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
                FKLiveGiftPickerFragment.this.K1();
                ((FKLiveGiftPickerLayout) FKLiveGiftPickerFragment.this.V0(R$id.giftPickerLayout)).l();
                FKLiveGiftPickerFragment fKLiveGiftPickerFragment = FKLiveGiftPickerFragment.this;
                LinearLayout backpackPickerLayout = (LinearLayout) fKLiveGiftPickerFragment.V0(R$id.backpackPickerLayout);
                s.h(backpackPickerLayout, "backpackPickerLayout");
                fKLiveGiftPickerFragment.x1(backpackPickerLayout);
                ((FKGiftDetailDescriptionLayout) FKLiveGiftPickerFragment.this.V0(R$id.giftDetailDescriptionLayout)).j(null);
                FKLiveGiftPickerFragment fKLiveGiftPickerFragment2 = FKLiveGiftPickerFragment.this;
                fKLiveGiftPickerFragment2.J1(((FKRecyclerTitleLayout) fKLiveGiftPickerFragment2.V0(R$id.backpackTitleLayout)).getCurrentTitle());
            }
        });
        ImageView backpackBackButton = (ImageView) V0(R$id.backpackBackButton);
        s.h(backpackBackButton, "backpackBackButton");
        y.d(backpackBackButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$bindClickEvent$6
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
                LiveGiftActivityModel liveGiftActivityModel;
                FKLiveGiftPickerFragment.this.K1();
                ((FKLiveGiftPickerLayout) FKLiveGiftPickerFragment.this.V0(R$id.backpackGiftPickerLayout)).l();
                FKLiveGiftPickerFragment fKLiveGiftPickerFragment = FKLiveGiftPickerFragment.this;
                LinearLayout giftPickerContainerLayout = (LinearLayout) fKLiveGiftPickerFragment.V0(R$id.giftPickerContainerLayout);
                s.h(giftPickerContainerLayout, "giftPickerContainerLayout");
                fKLiveGiftPickerFragment.x1(giftPickerContainerLayout);
                FKGiftDetailDescriptionLayout fKGiftDetailDescriptionLayout = (FKGiftDetailDescriptionLayout) FKLiveGiftPickerFragment.this.V0(R$id.giftDetailDescriptionLayout);
                liveGiftActivityModel = FKLiveGiftPickerFragment.this.f15455j;
                fKGiftDetailDescriptionLayout.j(liveGiftActivityModel);
                FKLiveGiftPickerFragment fKLiveGiftPickerFragment2 = FKLiveGiftPickerFragment.this;
                fKLiveGiftPickerFragment2.J1(((FKRecyclerTitleLayout) fKLiveGiftPickerFragment2.V0(R$id.giftTitleLayout)).getCurrentTitle());
            }
        });
        TextView gift_fragments_textview = (TextView) V0(R$id.gift_fragments_textview);
        s.h(gift_fragments_textview, "gift_fragments_textview");
        y.d(gift_fragments_textview, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$bindClickEvent$7
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
                GiftListResult C1;
                ParcelModel parcel;
                GiftFragmentsModel clientButton;
                C1 = FKLiveGiftPickerFragment.this.C1();
                if (C1 != null && (parcel = C1.getParcel()) != null && (clientButton = parcel.getClientButton()) != null) {
                    FKLiveGiftPickerFragment fKLiveGiftPickerFragment = FKLiveGiftPickerFragment.this;
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(clientButton.getUrl(), false, 2, null));
                    fKLiveGiftPickerFragment.dismiss();
                }
                FKLiveGiftPickerFragment.this.I1(LiveProtos.Type.PACKSACK_COLLECT_FRAGMENT);
            }
        });
        ImageView upgrade_gift_back_btn = (ImageView) V0(R$id.upgrade_gift_back_btn);
        s.h(upgrade_gift_back_btn, "upgrade_gift_back_btn");
        y.d(upgrade_gift_back_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$bindClickEvent$8
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
                LiveGiftActivityModel liveGiftActivityModel;
                FKLiveGiftPickerFragment.this.K1();
                ((FKLiveGiftPickerLayout) FKLiveGiftPickerFragment.this.V0(R$id.upgrade_gift_picker_layout)).l();
                FKLiveGiftPickerFragment fKLiveGiftPickerFragment = FKLiveGiftPickerFragment.this;
                LinearLayout giftPickerContainerLayout = (LinearLayout) fKLiveGiftPickerFragment.V0(R$id.giftPickerContainerLayout);
                s.h(giftPickerContainerLayout, "giftPickerContainerLayout");
                fKLiveGiftPickerFragment.x1(giftPickerContainerLayout);
                FKGiftDetailDescriptionLayout fKGiftDetailDescriptionLayout = (FKGiftDetailDescriptionLayout) FKLiveGiftPickerFragment.this.V0(R$id.giftDetailDescriptionLayout);
                liveGiftActivityModel = FKLiveGiftPickerFragment.this.f15455j;
                fKGiftDetailDescriptionLayout.j(liveGiftActivityModel);
                FKLiveGiftPickerFragment fKLiveGiftPickerFragment2 = FKLiveGiftPickerFragment.this;
                fKLiveGiftPickerFragment2.J1(((FKRecyclerTitleLayout) fKLiveGiftPickerFragment2.V0(R$id.giftTitleLayout)).getCurrentTitle());
            }
        });
        ((GiftExperienceLayout) V0(R$id.experience_layout)).setClickNobleCallback(new Function1<String, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$bindClickEvent$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                s.i(it, "it");
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(it, true));
                FKLiveGiftPickerFragment.this.I1(LiveProtos.Type.GIFT_NOBILITY);
            }
        });
    }

    public final void v1(GiftItemModel giftItemModel) {
        if (giftItemModel.getNewArrivalTag() != null) {
            giftItemModel.setNewArrivalTag(null);
            Disposable disposed = NetworkClient.f11868a.r().s0(giftItemModel.getItemId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$clearGiftNewTag$$inlined$handle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$clearGiftNewTag$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final void w1(int i10) {
        ParcelModel parcel;
        GiftListResult C1 = C1();
        List<SingleTabParcelListModel> parcelList = (C1 == null || (parcel = C1.getParcel()) == null) ? null : parcel.getParcelList();
        if (!(parcelList == null || parcelList.isEmpty()) && i10 >= 0 && i10 < parcelList.size()) {
            ((FKSendGiftBottomMenuLayout) V0(R$id.sendGiftBottomMenuLayout)).m(parcelList.get(i10).getParcelType() != ParcelModelType.GiftFragments.getType());
        }
    }

    public final void x1(LinearLayout linearLayout) {
        ((LinearLayout) V0(R$id.giftPickerContainerLayout)).setVisibility(4);
        ((LinearLayout) V0(R$id.backpackPickerLayout)).setVisibility(4);
        ((LinearLayout) V0(R$id.upgrade_gift_container_Layout)).setVisibility(4);
        linearLayout.setVisibility(0);
    }

    public final void y1(GiftItemModel giftItemModel) {
        if (giftItemModel instanceof GiftModel) {
            FKSendGiftBottomMenuLayout fKSendGiftBottomMenuLayout = (FKSendGiftBottomMenuLayout) V0(R$id.sendGiftBottomMenuLayout);
            String string = getString(R$string.give);
            s.h(string, "getString(R.string.give)");
            boolean canSelectRushCount = giftItemModel.getCanSelectRushCount();
            GiftModel giftModel = (GiftModel) giftItemModel;
            fKSendGiftBottomMenuLayout.i(true, string, canSelectRushCount, giftModel.getFreeChance(), this.f15451f != null && s.d(giftModel.getCanUseGiftDiscount(), Boolean.TRUE));
            return;
        }
        if (giftItemModel instanceof ParcelItemModel) {
            int type = ((ParcelItemModel) giftItemModel).getType();
            if (type == ParcelModelType.PropCardType.getType()) {
                FKSendGiftBottomMenuLayout sendGiftBottomMenuLayout = (FKSendGiftBottomMenuLayout) V0(R$id.sendGiftBottomMenuLayout);
                s.h(sendGiftBottomMenuLayout, "sendGiftBottomMenuLayout");
                String string2 = getString(R$string.go_to_use);
                s.h(string2, "getString(R.string.go_to_use)");
                sendGiftBottomMenuLayout.i(true, string2, (r13 & 4) != 0 ? false : false, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? false : false);
                return;
            }
            if (type == ParcelModelType.ParcelGiftType.getType()) {
                FKSendGiftBottomMenuLayout sendGiftBottomMenuLayout2 = (FKSendGiftBottomMenuLayout) V0(R$id.sendGiftBottomMenuLayout);
                s.h(sendGiftBottomMenuLayout2, "sendGiftBottomMenuLayout");
                String string3 = getString(R$string.give);
                s.h(string3, "getString(R.string.give)");
                sendGiftBottomMenuLayout2.i(true, string3, (r13 & 4) != 0 ? false : giftItemModel.getCanSelectRushCount(), (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? false : false);
            }
        }
    }

    public final void z1(FKRecyclerTitleLayout fKRecyclerTitleLayout, List<String> list, int i10) {
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new FKTitleViewModel(iterator2.next(), new TitleConfigModel(14.0f, -1, true), new TitleConfigModel(14.0f, -7829368, true), null, false, 24, null));
        }
        fKRecyclerTitleLayout.c(arrayList, i10);
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull com.cupidapp.live.liveshow.view.giftpicker.adapter.a event) {
        GiftModel giftModel;
        s.i(event, "event");
        n1.a.b(n1.a.f52091a, getContext(), 0L, 2, null);
        K1();
        ((FKLiveGiftPickerLayout) V0(R$id.giftPickerLayout)).l();
        LinearLayout upgrade_gift_container_Layout = (LinearLayout) V0(R$id.upgrade_gift_container_Layout);
        s.h(upgrade_gift_container_Layout, "upgrade_gift_container_Layout");
        x1(upgrade_gift_container_Layout);
        ((TextView) V0(R$id.upgrade_gift_title_text)).setText(event.a().getName());
        List<GiftModel> a10 = com.cupidapp.live.liveshow.view.giftpicker.helper.b.f15473a.a(event.a());
        ListIterator<GiftModel> listIterator = a10.listIterator(a10.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                giftModel = null;
                break;
            } else {
                giftModel = listIterator.previous();
                if (s.d(giftModel.getUnlocked(), Boolean.TRUE)) {
                    break;
                }
            }
        }
        ((FKLiveGiftPickerLayout) V0(R$id.upgrade_gift_picker_layout)).e(r.e(new SingleTabGiftConfigModel(a10, event.a().getName(), null, 4, null)), E1(giftModel), new Function1<GiftItemModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment$onEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(GiftItemModel giftItemModel) {
                invoke2(giftItemModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GiftItemModel it) {
                s.i(it, "it");
                FKLiveGiftPickerFragment.this.y1(it);
                ((FKGiftDetailDescriptionLayout) FKLiveGiftPickerFragment.this.V0(R$id.giftDetailDescriptionLayout)).i(it);
                FKLiveGiftPickerFragment.this.F1(it);
            }
        });
        J1(event.a().getItemId() + "_UPGRADE");
    }
}
