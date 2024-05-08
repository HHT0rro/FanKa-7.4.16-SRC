package com.cupidapp.live.notify.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.ai.AiPhotoIdentifyModel;
import com.cupidapp.live.ai.AiPhotoIdentifyResultActivity;
import com.cupidapp.live.ai.model.AiIdentifyGraphModel;
import com.cupidapp.live.ai.model.AiRcmdModel;
import com.cupidapp.live.ai.viewmodel.AiIdentifyViewModel;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.match.model.NearbyUserProfileModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.notify.activity.AiPhotoSelectActivity;
import com.cupidapp.live.notify.dialog.AiSearchingLayout;
import com.cupidapp.live.notify.layout.AiPreviewLayout;
import com.cupidapp.live.notify.layout.AiReadyLayout;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.u;
import z0.y;

/* compiled from: AiPhotoIdentifyFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiPhotoIdentifyFragment extends FKBaseFragment implements com.cupidapp.live.notify.layout.a {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f17500f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public ActivityResultLauncher<Intent> f17501g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f17502h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f17503i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17504j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17505k = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17499e = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = AiPhotoIdentifyFragment.this.getContext();
            Lifecycle lifecycle = AiPhotoIdentifyFragment.this.getLifecycle();
            s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    public AiPhotoIdentifyFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f17500f = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(AiIdentifyViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f17502h = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$mRxPermissions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final xb.b invoke() {
                return new xb.b(AiPhotoIdentifyFragment.this);
            }
        });
        this.f17503i = kotlin.c.b(new Function0<AiSearchingLayout>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$loadingView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final AiSearchingLayout invoke() {
                Context context = AiPhotoIdentifyFragment.this.getContext();
                if (context != null) {
                    return new AiSearchingLayout(context);
                }
                return null;
            }
        });
    }

    public static final String j1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public static final void k1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void r1(AiPhotoIdentifyFragment this$0, AiIdentifyGraphModel aiIdentifyGraphModel) {
        s.i(this$0, "this$0");
        AiPreviewLayout aiPreviewLayout = (AiPreviewLayout) this$0.Y0(R$id.preview_layout);
        if (aiPreviewLayout != null) {
            aiPreviewLayout.f(aiIdentifyGraphModel != null ? aiIdentifyGraphModel.getImageExamples() : null);
        }
    }

    public static final void s1(AiPhotoIdentifyFragment this$0, Pair pair) {
        s.i(this$0, "this$0");
        CharSequence charSequence = (CharSequence) pair.getFirst();
        boolean z10 = true;
        if (charSequence == null || charSequence.length() == 0) {
            this$0.x1();
            CharSequence charSequence2 = (CharSequence) pair.getSecond();
            if (charSequence2 != null && charSequence2.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) this$0.Y0(R$id.identify_purchase_svip_angle)).setVisibility(8);
            } else {
                int i10 = R$id.identify_purchase_svip_angle;
                ((TextView) this$0.Y0(i10)).setVisibility(0);
                ((TextView) this$0.Y0(i10)).setText((CharSequence) pair.getSecond());
            }
            ((TextView) this$0.Y0(R$id.ai_identify_click_tip)).setText(this$0.getString(R$string.ai_function_use_tip));
            return;
        }
        this$0.y1((String) pair.getFirst());
        ((TextView) this$0.Y0(R$id.identify_purchase_svip_angle)).setVisibility(8);
        int i11 = R$id.ai_identify_click_tip;
        ((TextView) this$0.Y0(i11)).setVisibility(0);
        TextView textView = (TextView) this$0.Y0(i11);
        String str = (String) pair.getSecond();
        textView.setText(str != null ? t.a(str, -49088) : null);
    }

    public static final void v1(AiPhotoIdentifyFragment this$0, ActivityResult activityResult) {
        s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            this$0.p1().selectPhoto(data != null ? data.getStringExtra("RESULT_IMAGE_PATH") : null);
        }
    }

    public final void A1(String str) {
        ViewGroup viewGroup;
        w1();
        AiSearchingLayout m12 = m1();
        if (m12 != null) {
            m12.b(str);
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null) {
            return;
        }
        viewGroup.addView(getContext() != null ? m1() : null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17505k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.AiIdentify;
    }

    @Nullable
    public View Y0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17505k;
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

    public final void h1(AiRcmdModel aiRcmdModel) {
        AiIdentifyGraphModel value = p1().getIdentifyInfoLiveData().getValue();
        if (value == null) {
            com.cupidapp.live.base.view.h.f12779a.m(getContext(), getString(R$string.net_error_tip_then_try));
            p1().loadData();
        } else if (PurchaseProductType.Companion.f(value.getProductRequire()) != PurchaseProductType.NO) {
            PurchaseDialogManager.q(o1(), VipPurchaseEntranceType.AiIdentify, null, null, false, false, 30, null);
        } else if (p1().noFreeCount()) {
            PurchaseDialogManager.q(o1(), VipPurchaseEntranceType.AiIdentify, null, null, false, false, 30, null);
        } else {
            if ((aiRcmdModel != null ? aiRcmdModel.getImage() : null) == null) {
                z1();
                z3.d.f54832a.a("COMMON");
            } else {
                i1(aiRcmdModel);
                z3.d.f54832a.a(aiRcmdModel.getTrackname());
            }
        }
        SensorsLogKeyButtonClick.AiIdentify.UPLOAD_PICTURE.click();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i1(final com.cupidapp.live.ai.model.AiRcmdModel r13) {
        /*
            r12 = this;
            boolean r0 = r12.f17504j
            if (r0 != 0) goto L9e
            com.cupidapp.live.base.network.model.ImageModel r0 = r13.getImage()
            if (r0 != 0) goto Lc
            goto L9e
        Lc:
            java.lang.String r0 = r13.getLocalPath()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L21
            int r0 = r0.length()
            if (r0 <= 0) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 != r1) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 == 0) goto L3f
            android.content.Context r4 = r12.getContext()
            if (r4 == 0) goto L3e
            com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion r3 = com.cupidapp.live.base.permission.FKRxPermissionAlertDialog.f12016a
            xb.b r5 = r12.n1()
            com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$downLoadImage$1$1 r6 = new com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$downLoadImage$1$1
            r6.<init>()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 56
            r11 = 0
            com.cupidapp.live.base.permission.FKRxPermissionAlertDialog.Companion.n(r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L3e:
            return
        L3f:
            android.content.Context r0 = r12.getContext()
            if (r0 == 0) goto L9e
            r12.f17504j = r1
            r12.R0()
            com.cupidapp.live.base.utils.NetWorkDrawableHelper r1 = com.cupidapp.live.base.utils.NetWorkDrawableHelper.f12282a
            com.cupidapp.live.base.utils.ImageWithHeightModel r9 = new com.cupidapp.live.base.utils.ImageWithHeightModel
            com.cupidapp.live.base.network.model.ImageModel r4 = r13.getImage()
            r3 = 1135050752(0x43a78000, float:335.0)
            int r5 = z0.h.c(r12, r3)
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            java.util.List r3 = kotlin.collections.r.e(r9)
            io.reactivex.Flowable r0 = r1.f(r0, r3, r2)
            com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$downLoadImage$2$1 r1 = new com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$downLoadImage$2$1
            r1.<init>()
            com.cupidapp.live.notify.fragment.f r13 = new com.cupidapp.live.notify.fragment.f
            r13.<init>()
            io.reactivex.Flowable r13 = r0.map(r13)
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Flowable r13 = r13.observeOn(r0)
            com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$downLoadImage$2$2 r0 = new com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$downLoadImage$2$2
            r0.<init>()
            com.cupidapp.live.notify.fragment.e r1 = new com.cupidapp.live.notify.fragment.e
            r1.<init>()
            com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$downLoadImage$2$3 r0 = new com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$downLoadImage$2$3
            r0.<init>()
            com.cupidapp.live.notify.fragment.d r2 = new com.cupidapp.live.notify.fragment.d
            r2.<init>()
            io.reactivex.disposables.Disposable r13 = r13.subscribe(r1, r2)
            java.lang.String r0 = "private fun downLoadImag…        )\n        }\n    }"
            kotlin.jvm.internal.s.h(r13, r0)
            r12.H(r13)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment.i1(com.cupidapp.live.ai.model.AiRcmdModel):void");
    }

    public final AiSearchingLayout m1() {
        return (AiSearchingLayout) this.f17503i.getValue();
    }

    public final xb.b n1() {
        return (xb.b) this.f17502h.getValue();
    }

    public final PurchaseDialogManager o1() {
        return (PurchaseDialogManager) this.f17499e.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_ai_identify_photo, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        w1();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        p1().loadData();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        AiPreviewLayout aiPreviewLayout;
        super.onPause();
        String value = p1().getSourceImgPath().getValue();
        if (!(value == null || value.length() == 0) || (aiPreviewLayout = (AiPreviewLayout) Y0(R$id.preview_layout)) == null) {
            return;
        }
        aiPreviewLayout.h();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        AiPreviewLayout aiPreviewLayout;
        super.onResume();
        String value = p1().getSourceImgPath().getValue();
        if (!(value == null || value.length() == 0) || (aiPreviewLayout = (AiPreviewLayout) Y0(R$id.preview_layout)) == null) {
            return;
        }
        aiPreviewLayout.i();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        t1();
        u1();
        q1();
    }

    public final AiIdentifyViewModel p1() {
        return (AiIdentifyViewModel) this.f17500f.getValue();
    }

    public final void q1() {
        p1().getIdentifyInfoLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.notify.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AiPhotoIdentifyFragment.r1(AiPhotoIdentifyFragment.this, (AiIdentifyGraphModel) obj);
            }
        });
        p1().getCurrentImageSelectLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.notify.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AiPhotoIdentifyFragment.s1(AiPhotoIdentifyFragment.this, (Pair) obj);
            }
        });
        p1().getListLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends StateResult<List<? extends NearbyUserProfileModel>>, ? extends String>, p>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends StateResult<List<? extends NearbyUserProfileModel>>, ? extends String> pair) {
                invoke2((Pair<? extends StateResult<List<NearbyUserProfileModel>>, String>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<? extends StateResult<List<NearbyUserProfileModel>>, String> it) {
                s.i(it, "it");
                if (it.getFirst() instanceof StateResult.b) {
                    AiPhotoIdentifyFragment.this.A1(it.getSecond());
                    return;
                }
                if (it.getFirst() instanceof StateResult.c) {
                    List<NearbyUserProfileModel> data = it.getFirst().getData();
                    if (data == null || data.isEmpty()) {
                        com.cupidapp.live.base.view.h.f12779a.t(AiPhotoIdentifyFragment.this.getString(R$string.ai_search_photo_no_data));
                    } else {
                        Context context = AiPhotoIdentifyFragment.this.getContext();
                        if (context != null) {
                            AiPhotoIdentifyResultActivity.f11641s.a(context, new AiPhotoIdentifyModel(data, it.getSecond()));
                        }
                    }
                }
                AiPhotoIdentifyFragment.this.w1();
            }
        }));
    }

    public final void t1() {
        TextView ai_identify_purchase_txt = (TextView) Y0(R$id.ai_identify_purchase_txt);
        s.h(ai_identify_purchase_txt, "ai_identify_purchase_txt");
        u.a(ai_identify_purchase_txt);
        ((TextView) Y0(R$id.ai_identify_click_tip)).setText(getString(R$string.ai_function_use_tip));
        ((AiReadyLayout) Y0(R$id.ready_layout)).g(this);
    }

    public final void u1() {
        this.f17501g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.notify.fragment.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AiPhotoIdentifyFragment.v1(AiPhotoIdentifyFragment.this, (ActivityResult) obj);
            }
        });
    }

    public final void w1() {
        AiSearchingLayout m12 = m1();
        ViewGroup viewGroup = (ViewGroup) (m12 != null ? m12.getParent() : null);
        if (viewGroup != null) {
            viewGroup.removeView(m1());
        }
    }

    public final void x1() {
        ((AiReadyLayout) Y0(R$id.ready_layout)).setVisibility(8);
        int i10 = R$id.ai_identify_purchase_txt;
        ((TextView) Y0(i10)).setText(getString(R$string.upload_photo));
        TextView ai_identify_purchase_txt = (TextView) Y0(i10);
        s.h(ai_identify_purchase_txt, "ai_identify_purchase_txt");
        u.e(ai_identify_purchase_txt, 0, 0, 0, 0, 14, null);
        TextView ai_identify_purchase_txt2 = (TextView) Y0(i10);
        s.h(ai_identify_purchase_txt2, "ai_identify_purchase_txt");
        y.d(ai_identify_purchase_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$renderGuideToUploadImage$1
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
                AiPhotoIdentifyFragment aiPhotoIdentifyFragment = AiPhotoIdentifyFragment.this;
                aiPhotoIdentifyFragment.h1(((AiPreviewLayout) aiPhotoIdentifyFragment.Y0(R$id.preview_layout)).getSelectedItem());
            }
        });
        ((AiPreviewLayout) Y0(R$id.preview_layout)).setVisibility(0);
    }

    public final void y1(String str) {
        int i10 = R$id.preview_layout;
        ((AiPreviewLayout) Y0(i10)).setVisibility(8);
        int i11 = R$id.ready_layout;
        ((AiReadyLayout) Y0(i11)).setVisibility(0);
        ((AiPreviewLayout) Y0(i10)).j();
        if (str != null) {
            ((AiReadyLayout) Y0(i11)).i(str);
        }
        int i12 = R$id.ai_identify_purchase_txt;
        ((TextView) Y0(i12)).setText(getString(R$string.ai_photo_search));
        TextView ai_identify_purchase_txt = (TextView) Y0(i12);
        s.h(ai_identify_purchase_txt, "ai_identify_purchase_txt");
        y.d(ai_identify_purchase_txt, new Function1<View, p>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$renderHasUploadImage$2
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
                AiIdentifyViewModel p12;
                AiIdentifyViewModel p13;
                PurchaseDialogManager o12;
                p12 = AiPhotoIdentifyFragment.this.p1();
                if (p12.noFreeCount()) {
                    o12 = AiPhotoIdentifyFragment.this.o1();
                    PurchaseDialogManager.q(o12, VipPurchaseEntranceType.AiIdentify, null, null, false, false, 30, null);
                } else {
                    p13 = AiPhotoIdentifyFragment.this.p1();
                    p13.searchImage();
                }
                SensorsLogKeyButtonClick.AiIdentify.BEGIN_AI_SEARCH.click();
            }
        });
    }

    @Override // com.cupidapp.live.notify.layout.a
    public void z0() {
        h1(null);
    }

    public final void z1() {
        final Context context = getContext();
        if (context != null) {
            FKRxPermissionAlertDialog.f12016a.m(context, n1(), (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.notify.fragment.AiPhotoIdentifyFragment$selectLocalImage$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ActivityResultLauncher<Intent> activityResultLauncher;
                    activityResultLauncher = AiPhotoIdentifyFragment.this.f17501g;
                    if (activityResultLauncher != null) {
                        AiPhotoIdentifyFragment aiPhotoIdentifyFragment = AiPhotoIdentifyFragment.this;
                        Context cont = context;
                        MediaPickerFragment.Config config = new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, CameraStartPosition.AIPhotoIdentify, aiPhotoIdentifyFragment.O0(), null, 152, null);
                        AiPhotoSelectActivity.a aVar = AiPhotoSelectActivity.f17489w;
                        s.h(cont, "cont");
                        aVar.a(cont, activityResultLauncher, config);
                    }
                }
            }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
        }
    }
}
