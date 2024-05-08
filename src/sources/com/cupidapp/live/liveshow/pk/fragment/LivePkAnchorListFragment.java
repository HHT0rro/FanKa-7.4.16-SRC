package com.cupidapp.live.liveshow.pk.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.pk.adapter.LivePkEmptyListModel;
import com.cupidapp.live.liveshow.pk.adapter.PkAnchorListAdapter;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorListResult;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInviteStatus;
import com.cupidapp.live.liveshow.pk.model.SendInvitationModel;
import com.cupidapp.live.track.group.GroupLiveLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: LivePkAnchorListFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkAnchorListFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f15134j = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f15135e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f15136f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public b f15137g;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15139i = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f15138h = c.b(new Function0<PkAnchorListAdapter>() { // from class: com.cupidapp.live.liveshow.pk.fragment.LivePkAnchorListFragment$pkAnchorAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PkAnchorListAdapter invoke() {
            PkAnchorListAdapter pkAnchorListAdapter = new PkAnchorListAdapter();
            final LivePkAnchorListFragment livePkAnchorListFragment = LivePkAnchorListFragment.this;
            pkAnchorListAdapter.l().k(i0.h(f.a(Integer.valueOf(R$id.invite_btn), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.LivePkAnchorListFragment$pkAnchorAdapter$2$1$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof MultiPkAnchorModel) {
                        MultiPkAnchorModel multiPkAnchorModel = (MultiPkAnchorModel) obj;
                        String inviteStatus = multiPkAnchorModel.getInviteStatus();
                        if (s.d(inviteStatus, MultiPkInviteStatus.None.getStatus()) ? true : s.d(inviteStatus, MultiPkInviteStatus.Refuse.getStatus()) ? true : s.d(inviteStatus, MultiPkInviteStatus.TimeOut.getStatus())) {
                            LivePkAnchorListFragment.this.k1(multiPkAnchorModel, i10);
                        } else if (s.d(inviteStatus, MultiPkInviteStatus.Wait.getStatus())) {
                            LivePkAnchorListFragment.this.f1(multiPkAnchorModel, i10);
                        }
                    }
                }
            })));
            return pkAnchorListAdapter;
        }
    });

    /* compiled from: LivePkAnchorListFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final LivePkAnchorListFragment a(@Nullable FragmentManager fragmentManager, @Nullable String str, @NotNull b listener) {
            s.i(listener, "listener");
            if (fragmentManager == null) {
                return null;
            }
            LivePkAnchorListFragment livePkAnchorListFragment = new LivePkAnchorListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("PK_PREPARE_ID", str);
            livePkAnchorListFragment.setArguments(bundle);
            livePkAnchorListFragment.f15137g = listener;
            livePkAnchorListFragment.show(fragmentManager, LivePkAnchorListFragment.class.getSimpleName());
            return livePkAnchorListFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15139i.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15139i;
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

    public final void e1() {
        ImageView shield_img = (ImageView) V0(R$id.shield_img);
        s.h(shield_img, "shield_img");
        y.d(shield_img, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.LivePkAnchorListFragment$bindClickEvent$1
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
                LivePkAnchorListFragment livePkAnchorListFragment = LivePkAnchorListFragment.this;
                livePkAnchorListFragment.l1(((ImageView) livePkAnchorListFragment.V0(R$id.shield_img)).isSelected());
            }
        });
    }

    public final void f1(final MultiPkAnchorModel multiPkAnchorModel, final int i10) {
        String str = this.f15136f;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.f15135e;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        u2.a r10 = NetworkClient.f11868a.r();
        String str3 = this.f15136f;
        s.f(str3);
        String liveShowId = multiPkAnchorModel.getLiveShowId();
        String str4 = this.f15135e;
        s.f(str4);
        Disposable disposed = r10.N0(str3, liveShowId, str4).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.LivePkAnchorListFragment$cancelInvitation$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                PkAnchorListAdapter h12;
                b bVar;
                MultiPkAnchorModel.this.setInviteStatus(MultiPkInviteStatus.None.getStatus());
                h12 = this.h1();
                h12.notifyItemChanged(i10);
                bVar = this.f15137g;
                if (bVar != null) {
                    bVar.b(MultiPkAnchorModel.this);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void g1(@NotNull String liveShowId, @NotNull MultiPkInviteStatus inviteStatus) {
        Object obj;
        s.i(liveShowId, "liveShowId");
        s.i(inviteStatus, "inviteStatus");
        List<Object> j10 = h1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : j10) {
            if (obj2 instanceof MultiPkAnchorModel) {
                arrayList.add(obj2);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (true) {
            if (iterator2.hasNext()) {
                obj = iterator2.next();
                if (s.d(((MultiPkAnchorModel) obj).getLiveShowId(), liveShowId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MultiPkAnchorModel multiPkAnchorModel = (MultiPkAnchorModel) obj;
        if (multiPkAnchorModel != null) {
            int indexOf = h1().j().indexOf(multiPkAnchorModel);
            multiPkAnchorModel.setInviteStatus(inviteStatus.getStatus());
            h1().notifyItemChanged(indexOf);
        }
    }

    public final PkAnchorListAdapter h1() {
        return (PkAnchorListAdapter) this.f15138h.getValue();
    }

    public final void i1() {
        String str = this.f15136f;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.f15135e;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        u2.a r10 = NetworkClient.f11868a.r();
        String str3 = this.f15136f;
        s.f(str3);
        String str4 = this.f15135e;
        s.f(str4);
        Disposable disposed = r10.u(str3, str4).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MultiPkAnchorListResult, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.LivePkAnchorListFragment$getPkAnchorList$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MultiPkAnchorListResult multiPkAnchorListResult) {
                m2630invoke(multiPkAnchorListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2630invoke(MultiPkAnchorListResult multiPkAnchorListResult) {
                PkAnchorListAdapter h12;
                PkAnchorListAdapter h13;
                PkAnchorListAdapter h14;
                PkAnchorListAdapter h15;
                MultiPkAnchorListResult multiPkAnchorListResult2 = multiPkAnchorListResult;
                List<MultiPkAnchorModel> list = multiPkAnchorListResult2.getList();
                if (list == null || list.isEmpty()) {
                    h14 = LivePkAnchorListFragment.this.h1();
                    String string = LivePkAnchorListFragment.this.getString(R$string.empty_anchor_prompt);
                    s.h(string, "getString(R.string.empty_anchor_prompt)");
                    h14.d(new LivePkEmptyListModel(string));
                    h15 = LivePkAnchorListFragment.this.h1();
                    h15.notifyItemInserted(0);
                } else {
                    h12 = LivePkAnchorListFragment.this.h1();
                    h12.e(multiPkAnchorListResult2.getList());
                    h13 = LivePkAnchorListFragment.this.h1();
                    h13.notifyItemRangeInserted(0, multiPkAnchorListResult2.getList().size());
                }
                ((ImageView) LivePkAnchorListFragment.this.V0(R$id.shield_img)).setSelected(!multiPkAnchorListResult2.getInviteAccept());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void j1() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        TextView pk_anchor_txt = (TextView) V0(R$id.pk_anchor_txt);
        s.h(pk_anchor_txt, "pk_anchor_txt");
        u.a(pk_anchor_txt);
        int i10 = R$id.pk_anchor_recycler;
        RecyclerView recyclerView = (RecyclerView) V0(i10);
        recyclerView.setAdapter(h1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        RecyclerView pk_anchor_recycler = (RecyclerView) V0(i10);
        s.h(pk_anchor_recycler, "pk_anchor_recycler");
        U0(pk_anchor_recycler);
        LinearLayout linearLayout = (LinearLayout) V0(R$id.shield_pk_invitation_layout);
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        linearLayout.setVisibility(fkLiveShowResult != null ? s.d(fkLiveShowResult.getHideBlockInvitationsButton(), Boolean.TRUE) : false ? 8 : 0);
    }

    public final void k1(final MultiPkAnchorModel multiPkAnchorModel, final int i10) {
        String str = this.f15136f;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.f15135e;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        u2.a r10 = NetworkClient.f11868a.r();
        String str3 = this.f15136f;
        s.f(str3);
        String liveShowId = multiPkAnchorModel.getLiveShowId();
        String str4 = this.f15135e;
        s.f(str4);
        Disposable disposed = r10.L0(str3, liveShowId, str4).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SendInvitationModel, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.LivePkAnchorListFragment$sendInvitation$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SendInvitationModel sendInvitationModel) {
                m2631invoke(sendInvitationModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2631invoke(SendInvitationModel sendInvitationModel) {
                PkAnchorListAdapter h12;
                b bVar;
                String str5;
                String str6;
                SendInvitationModel sendInvitationModel2 = sendInvitationModel;
                MultiPkAnchorModel.this.setInviteStatus(MultiPkInviteStatus.Wait.getStatus());
                h12 = this.h1();
                h12.notifyItemChanged(i10);
                bVar = this.f15137g;
                if (bVar != null) {
                    MultiPkAnchorModel multiPkAnchorModel2 = MultiPkAnchorModel.this;
                    str6 = this.f15135e;
                    multiPkAnchorModel2.setPkPrepareId(str6);
                    bVar.a(multiPkAnchorModel2, sendInvitationModel2.getWaitSec());
                }
                GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
                str5 = this.f15136f;
                groupLiveLog.g(str5, MultiPkAnchorModel.this.getUser().userId());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void l1(final boolean z10) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().M0(itemId, z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.LivePkAnchorListFragment$shieldInvitation$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                ((ImageView) LivePkAnchorListFragment.this.V0(R$id.shield_img)).setSelected(!z10);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_pk_anchor_list, viewGroup, false);
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
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f15135e = arguments != null ? arguments.getString("PK_PREPARE_ID") : null;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        this.f15136f = liveShowModel != null ? liveShowModel.getItemId() : null;
        j1();
        e1();
        i1();
    }
}
