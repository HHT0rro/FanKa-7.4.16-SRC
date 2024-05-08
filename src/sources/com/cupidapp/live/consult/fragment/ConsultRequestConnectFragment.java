package com.cupidapp.live.consult.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.permission.b;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment;
import com.cupidapp.live.consult.model.ConsultConnectAgreementModel;
import com.cupidapp.live.consult.model.ConsultConnectInfoModel;
import com.cupidapp.live.consult.model.ConsultConnectInfoResult;
import com.cupidapp.live.consult.model.ConsultConnectType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;

/* compiled from: ConsultRequestConnectFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultRequestConnectFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f13777k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public static ConsultRequestConnectFragment f13778l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f13779m;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.consult.fragment.b f13782g;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public ConsultConnectInfoModel f13784i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13785j = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public boolean f13780e = true;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f13781f = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(ConsultRequestConnectFragment.this);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public ConsultConnectType f13783h = ConsultConnectType.NORMAL;

    /* compiled from: ConsultRequestConnectFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager, @NotNull String roomId, @NotNull com.cupidapp.live.consult.fragment.b listener) {
            s.i(roomId, "roomId");
            s.i(listener, "listener");
            if (fragmentManager == null || ConsultRequestConnectFragment.f13779m) {
                return;
            }
            ConsultRequestConnectFragment.f13778l = new ConsultRequestConnectFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ROOM_ID", roomId);
            ConsultRequestConnectFragment consultRequestConnectFragment = ConsultRequestConnectFragment.f13778l;
            if (consultRequestConnectFragment != null) {
                consultRequestConnectFragment.setArguments(bundle);
            }
            ConsultRequestConnectFragment consultRequestConnectFragment2 = ConsultRequestConnectFragment.f13778l;
            if (consultRequestConnectFragment2 != null) {
                consultRequestConnectFragment2.f13782g = listener;
            }
            ConsultRequestConnectFragment consultRequestConnectFragment3 = ConsultRequestConnectFragment.f13778l;
            if (consultRequestConnectFragment3 != null) {
                consultRequestConnectFragment3.show(fragmentManager, ConsultRequestConnectFragment.class.getSimpleName());
            }
        }
    }

    /* compiled from: ConsultRequestConnectFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13786a;

        static {
            int[] iArr = new int[ConsultConnectType.values().length];
            try {
                iArr[ConsultConnectType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConsultConnectType.ONE_ON_ONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13786a = iArr;
        }
    }

    /* compiled from: ConsultRequestConnectFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends h0 {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f13789c;

        public c(Map.Entry<String, String> entry) {
            this.f13789c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, ConsultRequestConnectFragment.this.getContext(), this.f13789c.getValue(), null, 4, null);
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f13785j.clear();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public boolean P0() {
        return this.f13780e;
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13785j;
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

    public final void i1() {
        LinearLayout normal_consult_layout = (LinearLayout) V0(R$id.normal_consult_layout);
        s.h(normal_consult_layout, "normal_consult_layout");
        y.d(normal_consult_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment$bindClickEvent$1
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
                ConsultConnectType consultConnectType;
                ConsultConnectInfoModel consultConnectInfoModel;
                consultConnectType = ConsultRequestConnectFragment.this.f13783h;
                ConsultConnectType consultConnectType2 = ConsultConnectType.NORMAL;
                if (consultConnectType == consultConnectType2) {
                    return;
                }
                ConsultRequestConnectFragment.this.f13783h = consultConnectType2;
                ConsultRequestConnectFragment.this.n1();
                TextView textView = (TextView) ConsultRequestConnectFragment.this.V0(R$id.diamond_spent_txt);
                consultConnectInfoModel = ConsultRequestConnectFragment.this.f13784i;
                textView.setText(String.valueOf(consultConnectInfoModel != null ? Integer.valueOf(consultConnectInfoModel.getC2gPrice()) : null));
                i.d(i.f50236a, PopupName.CONSULT_CONNECT_TO_ANCHOR, PopupButtonName.ConnectConsult, null, 4, null);
            }
        });
        LinearLayout one_for_one_layout = (LinearLayout) V0(R$id.one_for_one_layout);
        s.h(one_for_one_layout, "one_for_one_layout");
        y.d(one_for_one_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment$bindClickEvent$2
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
                ConsultConnectType consultConnectType;
                ConsultConnectInfoModel consultConnectInfoModel;
                consultConnectType = ConsultRequestConnectFragment.this.f13783h;
                ConsultConnectType consultConnectType2 = ConsultConnectType.ONE_ON_ONE;
                if (consultConnectType == consultConnectType2) {
                    return;
                }
                ConsultRequestConnectFragment.this.f13783h = consultConnectType2;
                ConsultRequestConnectFragment.this.n1();
                TextView textView = (TextView) ConsultRequestConnectFragment.this.V0(R$id.diamond_spent_txt);
                consultConnectInfoModel = ConsultRequestConnectFragment.this.f13784i;
                textView.setText(String.valueOf(consultConnectInfoModel != null ? Integer.valueOf(consultConnectInfoModel.getC2cPrice()) : null));
                i.d(i.f50236a, PopupName.CONSULT_CONNECT_TO_ANCHOR, PopupButtonName.OneToOne, null, 4, null);
            }
        });
        LinearLayout recharge_diamond_layout = (LinearLayout) V0(R$id.recharge_diamond_layout);
        s.h(recharge_diamond_layout, "recharge_diamond_layout");
        y.d(recharge_diamond_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment$bindClickEvent$3
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
                b bVar;
                ConsultRequestConnectFragment.this.dismiss();
                bVar = ConsultRequestConnectFragment.this.f13782g;
                if (bVar != null) {
                    bVar.b();
                }
                i.d(i.f50236a, PopupName.CONSULT_CONNECT_TO_ANCHOR, PopupButtonName.Recharge, null, 4, null);
            }
        });
        ImageView agree_img = (ImageView) V0(R$id.agree_img);
        s.h(agree_img, "agree_img");
        y.d(agree_img, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment$bindClickEvent$4
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
                ConsultRequestConnectFragment consultRequestConnectFragment = ConsultRequestConnectFragment.this;
                int i10 = R$id.agree_img;
                ((ImageView) consultRequestConnectFragment.V0(i10)).setSelected(!((ImageView) ConsultRequestConnectFragment.this.V0(i10)).isSelected());
                ((FKUniversalButton) ConsultRequestConnectFragment.this.V0(R$id.connect_btn)).a(((ImageView) ConsultRequestConnectFragment.this.V0(i10)).isSelected());
            }
        });
        FKUniversalButton connect_btn = (FKUniversalButton) V0(R$id.connect_btn);
        s.h(connect_btn, "connect_btn");
        y.d(connect_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment$bindClickEvent$5

            /* compiled from: ConsultRequestConnectFragment.kt */
            @d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public static final class a implements com.cupidapp.live.base.permission.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ConsultRequestConnectFragment f13787a;

                public a(ConsultRequestConnectFragment consultRequestConnectFragment) {
                    this.f13787a = consultRequestConnectFragment;
                }

                @Override // com.cupidapp.live.base.permission.b
                public void a() {
                    b bVar;
                    ConsultConnectType consultConnectType;
                    this.f13787a.dismiss();
                    bVar = this.f13787a.f13782g;
                    if (bVar != null) {
                        consultConnectType = this.f13787a.f13783h;
                        bVar.a(consultConnectType);
                    }
                }

                @Override // com.cupidapp.live.base.permission.b
                public void b() {
                    b.a.b(this);
                }

                @Override // com.cupidapp.live.base.permission.b
                public void c() {
                    b.a.c(this);
                }

                @Override // com.cupidapp.live.base.permission.b
                public void d() {
                    b.a.a(this);
                }
            }

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
                xb.b l12;
                Context context = ConsultRequestConnectFragment.this.getContext();
                if (context != null) {
                    ConsultRequestConnectFragment consultRequestConnectFragment = ConsultRequestConnectFragment.this;
                    l12 = consultRequestConnectFragment.l1();
                    RxPermissionHelperKt.m(context, l12, r.e(PermissionType.AudioPermission), new a(consultRequestConnectFragment), false, 16, null);
                }
            }
        });
        View blank_view = V0(R$id.blank_view);
        s.h(blank_view, "blank_view");
        y.d(blank_view, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment$bindClickEvent$6
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
                ConsultRequestConnectFragment.this.dismiss();
            }
        });
    }

    public final void j1(ConsultConnectAgreementModel consultConnectAgreementModel) {
        SpannableStringBuilder c4;
        if (consultConnectAgreementModel == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, String> entry : consultConnectAgreementModel.getLinkDict().entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(new c(entry));
        }
        c4 = q1.d.f53006a.c(consultConnectAgreementModel.getContent(), CollectionsKt___CollectionsKt.z0(consultConnectAgreementModel.getLinkDict().h()), (r18 & 4) != 0 ? null : -15066598, (r18 & 8) != 0 ? null : -855310, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
        int i10 = R$id.connect_agreement_txt;
        ((TextView) V0(i10)).setText(c4);
        ((TextView) V0(i10)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void k1() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("ROOM_ID")) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().k(string).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultConnectInfoResult, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultRequestConnectFragment$getConnectInfo$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultConnectInfoResult consultConnectInfoResult) {
                m2539invoke(consultConnectInfoResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2539invoke(ConsultConnectInfoResult consultConnectInfoResult) {
                ConsultConnectInfoModel consultConnectInfoModel;
                ConsultConnectType consultConnectType;
                ConsultConnectInfoModel consultConnectInfoModel2;
                String valueOf;
                ConsultConnectInfoModel consultConnectInfoModel3;
                ConsultConnectInfoModel consultConnectInfoModel4;
                ConsultConnectInfoModel consultConnectInfoModel5;
                ConsultConnectInfoModel consultConnectInfoModel6;
                ConsultConnectInfoModel consultConnectInfoModel7;
                ConsultConnectInfoModel consultConnectInfoModel8;
                ConsultConnectInfoResult consultConnectInfoResult2 = consultConnectInfoResult;
                if (ConsultRequestConnectFragment.f13779m) {
                    ConsultRequestConnectFragment.this.f13784i = consultConnectInfoResult2.getConnectInfo();
                    ((TextView) ConsultRequestConnectFragment.this.V0(R$id.account_diamond_count_txt)).setText(String.valueOf(consultConnectInfoResult2.getBalance()));
                    TextView textView = (TextView) ConsultRequestConnectFragment.this.V0(R$id.connect_tips_txt);
                    consultConnectInfoModel = ConsultRequestConnectFragment.this.f13784i;
                    textView.setText(consultConnectInfoModel != null ? consultConnectInfoModel.getTipText() : null);
                    TextView textView2 = (TextView) ConsultRequestConnectFragment.this.V0(R$id.diamond_spent_txt);
                    consultConnectType = ConsultRequestConnectFragment.this.f13783h;
                    int i10 = ConsultRequestConnectFragment.b.f13786a[consultConnectType.ordinal()];
                    if (i10 == 1) {
                        consultConnectInfoModel2 = ConsultRequestConnectFragment.this.f13784i;
                        valueOf = String.valueOf(consultConnectInfoModel2 != null ? Integer.valueOf(consultConnectInfoModel2.getC2gPrice()) : null);
                    } else {
                        if (i10 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        consultConnectInfoModel8 = ConsultRequestConnectFragment.this.f13784i;
                        valueOf = String.valueOf(consultConnectInfoModel8 != null ? Integer.valueOf(consultConnectInfoModel8.getC2cPrice()) : null);
                    }
                    textView2.setText(valueOf);
                    consultConnectInfoModel3 = ConsultRequestConnectFragment.this.f13784i;
                    if ((consultConnectInfoModel3 != null ? consultConnectInfoModel3.getBanner() : null) == null) {
                        ((ImageLoaderView) ConsultRequestConnectFragment.this.V0(R$id.connect_banner_img)).setVisibility(8);
                    } else {
                        ConsultRequestConnectFragment consultRequestConnectFragment = ConsultRequestConnectFragment.this;
                        int i11 = R$id.connect_banner_img;
                        ((ImageLoaderView) consultRequestConnectFragment.V0(i11)).setVisibility(0);
                        int l10 = h.l(ConsultRequestConnectFragment.this) - h.c(ConsultRequestConnectFragment.this, 48.0f);
                        consultConnectInfoModel4 = ConsultRequestConnectFragment.this.f13784i;
                        s.f(consultConnectInfoModel4);
                        ImageModel banner = consultConnectInfoModel4.getBanner();
                        s.f(banner);
                        int scaleHeightByWidth = banner.getScaleHeightByWidth(l10);
                        ImageLoaderView connect_banner_img = (ImageLoaderView) ConsultRequestConnectFragment.this.V0(i11);
                        s.h(connect_banner_img, "connect_banner_img");
                        y.n(connect_banner_img, Integer.valueOf(l10), Integer.valueOf(scaleHeightByWidth));
                        ImageLoaderView connect_banner_img2 = (ImageLoaderView) ConsultRequestConnectFragment.this.V0(i11);
                        s.h(connect_banner_img2, "connect_banner_img");
                        consultConnectInfoModel5 = ConsultRequestConnectFragment.this.f13784i;
                        s.f(consultConnectInfoModel5);
                        ImageLoaderView.g(connect_banner_img2, consultConnectInfoModel5.getBanner(), null, null, 6, null);
                    }
                    TextView textView3 = (TextView) ConsultRequestConnectFragment.this.V0(R$id.consult_tips_txt);
                    consultConnectInfoModel6 = ConsultRequestConnectFragment.this.f13784i;
                    textView3.setText(consultConnectInfoModel6 != null ? consultConnectInfoModel6.getNotice() : null);
                    ConsultRequestConnectFragment consultRequestConnectFragment2 = ConsultRequestConnectFragment.this;
                    consultConnectInfoModel7 = consultRequestConnectFragment2.f13784i;
                    consultRequestConnectFragment2.j1(consultConnectInfoModel7 != null ? consultConnectInfoModel7.getAgreement() : null);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final xb.b l1() {
        return (xb.b) this.f13781f.getValue();
    }

    public final void m1() {
        TextView consult_spent_txt = (TextView) V0(R$id.consult_spent_txt);
        s.h(consult_spent_txt, "consult_spent_txt");
        u.a(consult_spent_txt);
        TextView recharge_txt = (TextView) V0(R$id.recharge_txt);
        s.h(recharge_txt, "recharge_txt");
        u.a(recharge_txt);
        ((ImageView) V0(R$id.agree_img)).setSelected(true);
        n1();
    }

    public final void n1() {
        int i10 = b.f13786a[this.f13783h.ordinal()];
        if (i10 == 1) {
            ((TextView) V0(R$id.normal_consult_txt)).setTextColor(-15066598);
            ((TextView) V0(R$id.normal_consult_content_txt)).setTextColor(-15066598);
            ((LinearLayout) V0(R$id.normal_consult_layout)).setBackground(null);
            ((TextView) V0(R$id.one_for_one_txt)).setTextColor(-8618884);
            ((TextView) V0(R$id.one_for_one_content_txt)).setTextColor(-8618884);
            ((LinearLayout) V0(R$id.one_for_one_layout)).setBackgroundResource(R$drawable.rect_bl_tr_cor_12_sd_1a000000);
            return;
        }
        if (i10 != 2) {
            return;
        }
        ((TextView) V0(R$id.normal_consult_txt)).setTextColor(-8618884);
        ((TextView) V0(R$id.normal_consult_content_txt)).setTextColor(-8618884);
        ((LinearLayout) V0(R$id.normal_consult_layout)).setBackgroundResource(R$drawable.rect_tl_br_cor_12_sd_1a000000);
        ((TextView) V0(R$id.one_for_one_txt)).setTextColor(-15066598);
        ((TextView) V0(R$id.one_for_one_content_txt)).setTextColor(-15066598);
        ((LinearLayout) V0(R$id.one_for_one_layout)).setBackground(null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_consult_request_connect, viewGroup);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        f13779m = false;
        O0();
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
        f13779m = true;
        m1();
        i1();
        k1();
    }
}
