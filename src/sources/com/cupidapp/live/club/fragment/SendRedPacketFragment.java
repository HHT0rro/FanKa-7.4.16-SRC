package com.cupidapp.live.club.fragment;

import a2.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.club.adapter.SendRedPacketAdapter;
import com.cupidapp.live.club.model.ClubRedPacketModel;
import com.cupidapp.live.club.model.ClubRedPacketResult;
import com.cupidapp.live.club.model.ClubSendRedPacketEvent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: SendRedPacketFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendRedPacketFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f13583i = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f13586g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13587h = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f13584e = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.club.fragment.SendRedPacketFragment$mClubId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = SendRedPacketFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("CLUB_ID");
            }
            return null;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final SendRedPacketAdapter f13585f = new SendRedPacketAdapter();

    /* compiled from: SendRedPacketFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager, @NotNull String clubId) {
            kotlin.jvm.internal.s.i(clubId, "clubId");
            if (fragmentManager == null) {
                return;
            }
            SendRedPacketFragment sendRedPacketFragment = new SendRedPacketFragment();
            Bundle bundle = new Bundle();
            bundle.putString("CLUB_ID", clubId);
            sendRedPacketFragment.setArguments(bundle);
            sendRedPacketFragment.show(fragmentManager, SendRedPacketFragment.class.getSimpleName());
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f13587h.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13587h;
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

    public final void a1() {
        this.f13585f.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.SendRedPacketFragment$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                SendRedPacketAdapter sendRedPacketAdapter;
                if (obj instanceof ClubRedPacketModel) {
                    sendRedPacketAdapter = SendRedPacketFragment.this.f13585f;
                    sendRedPacketAdapter.v((ClubRedPacketModel) obj);
                }
            }
        });
        TextView send_red_packet_btn = (TextView) V0(R$id.send_red_packet_btn);
        kotlin.jvm.internal.s.h(send_red_packet_btn, "send_red_packet_btn");
        y.d(send_red_packet_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.SendRedPacketFragment$bindClickEvent$2
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
                SendRedPacketFragment.this.e1();
            }
        });
    }

    public final String b1() {
        return (String) this.f13584e.getValue();
    }

    public final void c1() {
        Disposable disposed = NetworkClient.f11868a.u().q(1009).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ClubRedPacketResult, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.SendRedPacketFragment$getRedPacketListData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ClubRedPacketResult clubRedPacketResult) {
                m2513invoke(clubRedPacketResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2513invoke(ClubRedPacketResult clubRedPacketResult) {
                SendRedPacketAdapter sendRedPacketAdapter;
                ClubRedPacketResult clubRedPacketResult2 = clubRedPacketResult;
                SendRedPacketFragment.this.f13586g = clubRedPacketResult2.getWalletPayUrl();
                List<ClubRedPacketModel> list = clubRedPacketResult2.getList();
                if (list != null) {
                    sendRedPacketAdapter = SendRedPacketFragment.this.f13585f;
                    sendRedPacketAdapter.u(list);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void d1() {
        TextView send_red_packet_count_title = (TextView) V0(R$id.send_red_packet_count_title);
        kotlin.jvm.internal.s.h(send_red_packet_count_title, "send_red_packet_count_title");
        u.a(send_red_packet_count_title);
        EditText send_red_packet_input_count = (EditText) V0(R$id.send_red_packet_input_count);
        kotlin.jvm.internal.s.h(send_red_packet_input_count, "send_red_packet_input_count");
        u.a(send_red_packet_input_count);
        TextView send_red_packet_piece_text = (TextView) V0(R$id.send_red_packet_piece_text);
        kotlin.jvm.internal.s.h(send_red_packet_piece_text, "send_red_packet_piece_text");
        u.a(send_red_packet_piece_text);
        TextView send_red_packet_btn = (TextView) V0(R$id.send_red_packet_btn);
        kotlin.jvm.internal.s.h(send_red_packet_btn, "send_red_packet_btn");
        u.a(send_red_packet_btn);
        RecyclerView recyclerView = (RecyclerView) V0(R$id.send_red_packet_recycler_view);
        kotlin.jvm.internal.s.h(recyclerView, "this");
        U0(recyclerView);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.setAdapter(this.f13585f);
        int c4 = z0.h.c(recyclerView, 5.0f);
        recyclerView.addItemDecoration(new FKAddExtraSpacingDecoration(c4, c4, c4, c4, 0, 0, 48, null));
    }

    public final void e1() {
        String b12 = b1();
        ClubRedPacketModel w3 = this.f13585f.w();
        String giftId = w3 != null ? w3.getGiftId() : null;
        int q10 = z0.t.q(((EditText) V0(R$id.send_red_packet_input_count)).getText().toString());
        if (b12 == null || b12.length() == 0) {
            return;
        }
        if (giftId == null || giftId.length() == 0) {
            return;
        }
        if (q10 <= 0) {
            com.cupidapp.live.base.view.h.f12779a.l(getContext(), R$string.input_red_packet_number);
            return;
        }
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.ClubSendRedPacketInsufficientBalance.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.SendRedPacketFragment$sendRedPacket$errorCodeInterceptor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                FKAlertDialog o10 = FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, SendRedPacketFragment.this.getContext(), false, 2, null), R$string.current_balance_insufficient_please_recharge, 0, 2, null);
                final SendRedPacketFragment sendRedPacketFragment = SendRedPacketFragment.this;
                FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(o10, R$string.liveshow_confirm_purchase, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.club.fragment.SendRedPacketFragment$sendRedPacket$errorCodeInterceptor$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.p invoke() {
                        invoke2();
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        String str2;
                        j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                        Context context = SendRedPacketFragment.this.getContext();
                        str2 = SendRedPacketFragment.this.f13586g;
                        j.a.b(aVar, context, str2, null, 4, null);
                    }
                }, 2, null), 0, null, 3, null), null, 1, null);
            }
        }));
        Disposable disposed = a.C0010a.d(NetworkClient.f11868a.u(), b12, giftId, q10, 0, 8, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.SendRedPacketFragment$sendRedPacket$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                EventBus.c().l(new ClubSendRedPacketEvent());
                SendRedPacketFragment.this.dismiss();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.fragment.SendRedPacketFragment$sendRedPacket$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, SendRedPacketFragment.this.getContext(), h10, null, 8, null);
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_send_red_packet, viewGroup, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        d1();
        a1();
        c1();
    }
}
