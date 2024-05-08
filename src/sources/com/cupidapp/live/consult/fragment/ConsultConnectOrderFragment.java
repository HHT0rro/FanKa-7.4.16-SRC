package com.cupidapp.live.consult.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c2.a;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.recyclerview.decoration.ExtraSpacingDecoration;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.consult.model.ConnectOrderModel;
import com.cupidapp.live.consult.model.ConsultConnectState;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.h;
import z0.y;

/* compiled from: ConsultConnectOrderFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectOrderFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f13757k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public static ConsultConnectOrderFragment f13758l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f13759m;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.consult.fragment.a f13761f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public ConsultConnectState f13763h;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13765j = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public boolean f13760e = true;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f13762g = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment$roomId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = ConsultConnectOrderFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("ROOM_ID");
            }
            return null;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f13764i = kotlin.c.b(new Function0<ConsultConnectOrderAdapter>() { // from class: com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment$connectOrderAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ConsultConnectOrderAdapter invoke() {
            return new ConsultConnectOrderAdapter();
        }
    });

    /* compiled from: ConsultConnectOrderFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            ConsultConnectOrderFragment consultConnectOrderFragment;
            if (!ConsultConnectOrderFragment.f13759m || (consultConnectOrderFragment = ConsultConnectOrderFragment.f13758l) == null) {
                return;
            }
            consultConnectOrderFragment.dismiss();
        }

        public final void b() {
            ConsultConnectOrderFragment consultConnectOrderFragment;
            if (!ConsultConnectOrderFragment.f13759m || (consultConnectOrderFragment = ConsultConnectOrderFragment.f13758l) == null) {
                return;
            }
            consultConnectOrderFragment.k1();
        }

        public final void c() {
            ConsultConnectOrderFragment consultConnectOrderFragment;
            if (!ConsultConnectOrderFragment.f13759m || (consultConnectOrderFragment = ConsultConnectOrderFragment.f13758l) == null) {
                return;
            }
            consultConnectOrderFragment.g1();
        }

        public final void d(@Nullable FragmentManager fragmentManager, boolean z10, @NotNull String roomId, @Nullable ConsultConnectState consultConnectState, @Nullable com.cupidapp.live.consult.fragment.a aVar) {
            s.i(roomId, "roomId");
            if (fragmentManager == null || ConsultConnectOrderFragment.f13759m) {
                return;
            }
            ConsultConnectOrderFragment.f13758l = new ConsultConnectOrderFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_VIEWER", z10);
            bundle.putString("ROOM_ID", roomId);
            if (consultConnectState != null) {
                g.d(bundle, consultConnectState);
            }
            ConsultConnectOrderFragment consultConnectOrderFragment = ConsultConnectOrderFragment.f13758l;
            if (consultConnectOrderFragment != null) {
                consultConnectOrderFragment.setArguments(bundle);
            }
            ConsultConnectOrderFragment consultConnectOrderFragment2 = ConsultConnectOrderFragment.f13758l;
            if (consultConnectOrderFragment2 != null) {
                consultConnectOrderFragment2.f13761f = aVar;
            }
            ConsultConnectOrderFragment consultConnectOrderFragment3 = ConsultConnectOrderFragment.f13758l;
            if (consultConnectOrderFragment3 != null) {
                consultConnectOrderFragment3.show(fragmentManager, ConsultConnectOrderFragment.class.getSimpleName());
            }
        }
    }

    /* compiled from: ConsultConnectOrderFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13766a;

        static {
            int[] iArr = new int[ConsultConnectState.values().length];
            try {
                iArr[ConsultConnectState.FreeState.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConsultConnectState.WaitConnect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConsultConnectState.Answering.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f13766a = iArr;
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f13765j.clear();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public boolean P0() {
        return this.f13760e;
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13765j;
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

    public final void f1() {
        FKUniversalButton request_connect_btn = (FKUniversalButton) V0(R$id.request_connect_btn);
        s.h(request_connect_btn, "request_connect_btn");
        y.d(request_connect_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment$bindClickEvent$1

            /* compiled from: ConsultConnectOrderFragment.kt */
            @d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f13767a;

                static {
                    int[] iArr = new int[ConsultConnectState.values().length];
                    try {
                        iArr[ConsultConnectState.FreeState.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ConsultConnectState.WaitConnect.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ConsultConnectState.Answering.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f13767a = iArr;
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

            /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
            
                r2 = r1.this$0.f13761f;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r2) {
                /*
                    r1 = this;
                    com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment r2 = com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment.this
                    com.cupidapp.live.consult.model.ConsultConnectState r2 = com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment.Y0(r2)
                    if (r2 != 0) goto La
                    r2 = -1
                    goto L12
                La:
                    int[] r0 = com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment$bindClickEvent$1.a.f13767a
                    int r2 = r2.ordinal()
                    r2 = r0[r2]
                L12:
                    r0 = 1
                    if (r2 == r0) goto L28
                    r0 = 2
                    if (r2 == r0) goto L1c
                    r0 = 3
                    if (r2 == r0) goto L1c
                    goto L38
                L1c:
                    com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment r2 = com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment.this
                    com.cupidapp.live.consult.fragment.a r2 = com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment.a1(r2)
                    if (r2 == 0) goto L38
                    r2.b()
                    goto L38
                L28:
                    com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment r2 = com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment.this
                    r2.dismiss()
                    com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment r2 = com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment.this
                    com.cupidapp.live.consult.fragment.a r2 = com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment.a1(r2)
                    if (r2 == 0) goto L38
                    r2.a()
                L38:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment$bindClickEvent$1.invoke2(android.view.View):void");
            }
        });
    }

    public final void g1() {
        String i12 = i1();
        if (i12 == null || i12.length() == 0) {
            return;
        }
        c2.a v2 = NetworkClient.f11868a.v();
        String i13 = i1();
        s.f(i13);
        Disposable disposed = a.C0025a.b(v2, i13, null, 2, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<ConnectOrderModel>, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment$getConnectOrder$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<ConnectOrderModel> listResult) {
                m2535invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2535invoke(ListResult<ConnectOrderModel> listResult) {
                ConsultConnectOrderAdapter h12;
                ConsultConnectOrderAdapter h13;
                ConsultConnectOrderAdapter h14;
                ListResult<ConnectOrderModel> listResult2 = listResult;
                h12 = ConsultConnectOrderFragment.this.h1();
                h12.j().clear();
                List<ConnectOrderModel> list = listResult2.getList();
                if (list == null || list.isEmpty()) {
                    ((TextView) ConsultConnectOrderFragment.this.V0(R$id.empty_connect_txt)).setVisibility(0);
                } else {
                    ((TextView) ConsultConnectOrderFragment.this.V0(R$id.empty_connect_txt)).setVisibility(8);
                    h13 = ConsultConnectOrderFragment.this.h1();
                    h13.e(listResult2.getList());
                }
                h14 = ConsultConnectOrderFragment.this.h1();
                h14.notifyDataSetChanged();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final ConsultConnectOrderAdapter h1() {
        return (ConsultConnectOrderAdapter) this.f13764i.getValue();
    }

    public final String i1() {
        return (String) this.f13762g.getValue();
    }

    public final void j1() {
        int i10 = R$id.connect_order_recycler;
        RecyclerView initView$lambda$0 = (RecyclerView) V0(i10);
        initView$lambda$0.setAdapter(h1());
        initView$lambda$0.setLayoutManager(new LinearLayoutManager(initView$lambda$0.getContext()));
        s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.addItemDecoration(new ExtraSpacingDecoration(0, h.c(initView$lambda$0, 6.0f), 0, h.c(initView$lambda$0, 6.0f), 0, 16, null), -h.c(initView$lambda$0, 6.0f));
        RecyclerView connect_order_recycler = (RecyclerView) V0(i10);
        s.h(connect_order_recycler, "connect_order_recycler");
        U0(connect_order_recycler);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean("IS_VIEWER")) {
            int i11 = R$id.request_connect_btn;
            ((FKUniversalButton) V0(i11)).setVisibility(0);
            ((ConstraintLayout) V0(R$id.connect_container_layout)).setPadding(h.c(this, 16.0f), h.c(this, 18.0f), h.c(this, 16.0f), h.c(this, 28.0f));
            RecyclerView connect_order_recycler2 = (RecyclerView) V0(i10);
            s.h(connect_order_recycler2, "connect_order_recycler");
            y.o(connect_order_recycler2, null, Integer.valueOf(h.c(this, 254.0f)), 1, null);
            ConsultConnectState consultConnectState = this.f13763h;
            int i12 = consultConnectState == null ? -1 : b.f13766a[consultConnectState.ordinal()];
            if (i12 == 1) {
                ((FKUniversalButton) V0(i11)).setText(getString(R$string.request_connect));
                return;
            } else {
                if (i12 == 2 || i12 == 3) {
                    ((FKUniversalButton) V0(i11)).setText(getString(R$string.cancel_request));
                    return;
                }
                return;
            }
        }
        ((FKUniversalButton) V0(R$id.request_connect_btn)).setVisibility(8);
        ((ConstraintLayout) V0(R$id.connect_container_layout)).setPadding(h.c(this, 16.0f), h.c(this, 18.0f), h.c(this, 16.0f), h.c(this, 54.0f));
        RecyclerView connect_order_recycler3 = (RecyclerView) V0(i10);
        s.h(connect_order_recycler3, "connect_order_recycler");
        y.o(connect_order_recycler3, null, Integer.valueOf(h.c(this, 292.0f)), 1, null);
    }

    public final void k1() {
        this.f13763h = ConsultConnectState.FreeState;
        ((FKUniversalButton) V0(R$id.request_connect_btn)).setText(getString(R$string.request_connect));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_consult_connect_order, viewGroup);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        f13759m = false;
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
        f13759m = true;
        Bundle arguments = getArguments();
        this.f13763h = arguments != null ? (ConsultConnectState) g.b(arguments, ConsultConnectState.class) : null;
        j1();
        f1();
        g1();
    }
}
