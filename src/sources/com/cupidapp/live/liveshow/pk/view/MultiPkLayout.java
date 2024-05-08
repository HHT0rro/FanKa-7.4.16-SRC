package com.cupidapp.live.liveshow.pk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.MultiPkAnchorInfoModel;
import com.cupidapp.live.liveshow.model.MultiPkInfoModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInteractModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInviteStatus;
import com.cupidapp.live.liveshow.pk.model.MultiPkRankModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkResultModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkScoreUpdateModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkUserInfoModel;
import com.cupidapp.live.liveshow.pk.view.l;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.x;
import z0.y;
import z0.z;

/* compiled from: MultiPkLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkLayout extends BaseLayout {

    /* renamed from: y */
    @NotNull
    public static final a f15198y = new a(null);

    /* renamed from: d */
    @Nullable
    public com.cupidapp.live.liveshow.pk.view.e f15199d;

    /* renamed from: e */
    @Nullable
    public com.cupidapp.live.liveshow.entity.l f15200e;

    /* renamed from: f */
    public int f15201f;

    /* renamed from: g */
    public int f15202g;

    /* renamed from: h */
    public int f15203h;

    /* renamed from: i */
    public int f15204i;

    /* renamed from: j */
    @NotNull
    public MultiPersonPkState f15205j;

    /* renamed from: k */
    @NotNull
    public final List<MultiPkInviteeLayout> f15206k;

    /* renamed from: l */
    @NotNull
    public final List<Pair<Float, Float>> f15207l;

    /* renamed from: m */
    public boolean f15208m;

    /* renamed from: n */
    @Nullable
    public String f15209n;

    /* renamed from: o */
    @Nullable
    public String f15210o;

    /* renamed from: p */
    @Nullable
    public String f15211p;

    /* renamed from: q */
    @Nullable
    public Disposable f15212q;

    /* renamed from: r */
    public int f15213r;

    /* renamed from: s */
    public int f15214s;

    /* renamed from: t */
    public boolean f15215t;

    /* renamed from: u */
    @Nullable
    public Long f15216u;

    /* renamed from: v */
    @Nullable
    public Integer f15217v;

    /* renamed from: w */
    @Nullable
    public String f15218w;

    /* renamed from: x */
    @NotNull
    public Map<Integer, View> f15219x;

    /* compiled from: MultiPkLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MultiPkLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15220a;

        static {
            int[] iArr = new int[MultiPersonPkState.values().length];
            try {
                iArr[MultiPersonPkState.PKing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MultiPersonPkState.PKInteract.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15220a = iArr;
        }
    }

    /* compiled from: MultiPkLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements l {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void a() {
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (liveShowModel != null) {
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(MultiPkLayout.this.z(liveShowModel.getItemId(), PkRankFlag.ViewMySelf.getValue()), true));
            }
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void b(boolean z10) {
            l.a.a(this, z10);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void c() {
            l.a.b(this);
        }
    }

    /* compiled from: MultiPkLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.liveshow.pk.view.d {

        /* renamed from: b */
        public final /* synthetic */ MultiPkInviteeLayout f15223b;

        public d(MultiPkInviteeLayout multiPkInviteeLayout) {
            this.f15223b = multiPkInviteeLayout;
        }

        @Override // com.cupidapp.live.liveshow.pk.view.d
        public void a() {
            MultiPkAnchorModel pkAnchorModel = this.f15223b.getPkAnchorModel();
            if (pkAnchorModel != null) {
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(MultiPkLayout.this.z(pkAnchorModel.getLiveShowId(), PkRankFlag.ViewOthers.getValue()), true));
            }
        }

        @Override // com.cupidapp.live.liveshow.pk.view.d
        public void b() {
            com.cupidapp.live.liveshow.pk.view.e eVar = MultiPkLayout.this.f15199d;
            if (eVar != null) {
                eVar.b();
            }
        }

        @Override // com.cupidapp.live.liveshow.pk.view.d
        public void c(boolean z10) {
            MultiPkLayout multiPkLayout;
            com.cupidapp.live.liveshow.entity.l lVar;
            MultiPkAnchorModel pkAnchorModel = this.f15223b.getPkAnchorModel();
            if (pkAnchorModel == null || (lVar = (multiPkLayout = MultiPkLayout.this).f15200e) == null) {
                return;
            }
            lVar.j(pkAnchorModel.getLiveShowId(), z10, multiPkLayout.f15209n);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.d
        public void d(@NotNull MultiPkInviteStatus inviteStatus) {
            com.cupidapp.live.liveshow.pk.view.e eVar;
            s.i(inviteStatus, "inviteStatus");
            MultiPkAnchorModel pkAnchorModel = this.f15223b.getPkAnchorModel();
            if (pkAnchorModel != null && (eVar = MultiPkLayout.this.f15199d) != null) {
                eVar.g(pkAnchorModel.getLiveShowId(), inviteStatus);
            }
            MultiPkInviteeLayout.r(this.f15223b, null, 0, 2, null);
            MultiPkLayout.this.N();
        }
    }

    /* compiled from: Comparisons.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t2, T t10) {
            return qd.a.a(Boolean.valueOf(((MultiPkInviteeLayout) t10).getPkAnchorModel() != null), Boolean.valueOf(((MultiPkInviteeLayout) t2).getPkAnchorModel() != null));
        }
    }

    /* compiled from: Comparisons.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class f<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t2, T t10) {
            MultiPkAnchorModel pkAnchorModel = ((MultiPkInviteeLayout) t10).getPkAnchorModel();
            Boolean valueOf = Boolean.valueOf(pkAnchorModel != null && pkAnchorModel.hasStream());
            MultiPkAnchorModel pkAnchorModel2 = ((MultiPkInviteeLayout) t2).getPkAnchorModel();
            return qd.a.a(valueOf, Boolean.valueOf(pkAnchorModel2 != null && pkAnchorModel2.hasStream()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15219x = new LinkedHashMap();
        this.f15205j = MultiPersonPkState.PKPrepare;
        this.f15206k = new ArrayList();
        this.f15207l = new ArrayList();
        this.f15215t = true;
        A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void C(MultiPkLayout multiPkLayout, boolean z10, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            list = null;
        }
        multiPkLayout.B(z10, str, str2, list);
    }

    public static final void Y(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void y(MultiPkLayout multiPkLayout, MultiPkAnchorModel multiPkAnchorModel, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        multiPkLayout.x(multiPkAnchorModel, i10);
    }

    public final void A() {
        z.a(this, R$layout.layout_multi_person_pk, true);
        setVisibility(8);
        this.f15201f = z0.h.l(this) - z0.h.c(this, 4.0f);
        int l10 = (int) ((z0.h.l(this) * 1.5555556f) / 2.0f);
        this.f15202g = l10;
        this.f15203h = (int) (this.f15201f / 2.0f);
        this.f15204i = (int) (l10 / 2.0f);
        com.cupidapp.live.liveshow.entity.l lVar = new com.cupidapp.live.liveshow.entity.l();
        lVar.n(this.f15201f, this.f15202g);
        this.f15200e = lVar;
        RelativeLayout multi_pk_container_layout = (RelativeLayout) f(R$id.multi_pk_container_layout);
        s.h(multi_pk_container_layout, "multi_pk_container_layout");
        y.n(multi_pk_container_layout, Integer.valueOf(this.f15201f), Integer.valueOf(this.f15202g));
        FrameLayout first_anchor_layout = (FrameLayout) f(R$id.first_anchor_layout);
        s.h(first_anchor_layout, "first_anchor_layout");
        y.n(first_anchor_layout, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15204i));
        int i10 = R$id.second_invitee_layout;
        MultiPkInviteeLayout second_invitee_layout = (MultiPkInviteeLayout) f(i10);
        s.h(second_invitee_layout, "second_invitee_layout");
        y.n(second_invitee_layout, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15204i));
        int i11 = R$id.third_invitee_layout;
        MultiPkInviteeLayout third_invitee_layout = (MultiPkInviteeLayout) f(i11);
        s.h(third_invitee_layout, "third_invitee_layout");
        y.n(third_invitee_layout, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15204i));
        int i12 = R$id.fourth_invitee_layout;
        MultiPkInviteeLayout fourth_invitee_layout = (MultiPkInviteeLayout) f(i12);
        s.h(fourth_invitee_layout, "fourth_invitee_layout");
        y.n(fourth_invitee_layout, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15204i));
        List<Pair<Float, Float>> list = this.f15207l;
        Float valueOf = Float.valueOf(this.f15203h);
        Float valueOf2 = Float.valueOf(0.0f);
        list.add(new Pair<>(valueOf, valueOf2));
        this.f15207l.add(new Pair<>(valueOf2, Float.valueOf(this.f15204i)));
        this.f15207l.add(new Pair<>(Float.valueOf(this.f15203h), Float.valueOf(this.f15204i)));
        List<MultiPkInviteeLayout> list2 = this.f15206k;
        MultiPkInviteeLayout second_invitee_layout2 = (MultiPkInviteeLayout) f(i10);
        s.h(second_invitee_layout2, "second_invitee_layout");
        list2.add(second_invitee_layout2);
        List<MultiPkInviteeLayout> list3 = this.f15206k;
        MultiPkInviteeLayout third_invitee_layout2 = (MultiPkInviteeLayout) f(i11);
        s.h(third_invitee_layout2, "third_invitee_layout");
        list3.add(third_invitee_layout2);
        List<MultiPkInviteeLayout> list4 = this.f15206k;
        MultiPkInviteeLayout fourth_invitee_layout2 = (MultiPkInviteeLayout) f(i12);
        s.h(fourth_invitee_layout2, "fourth_invitee_layout");
        list4.add(fourth_invitee_layout2);
        int i13 = 0;
        for (MultiPkInviteeLayout multiPkInviteeLayout : this.f15206k) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                kotlin.collections.s.s();
            }
            v(multiPkInviteeLayout, this.f15207l.get(i13));
            i13 = i14;
        }
        t();
    }

    public final void B(boolean z10, @Nullable String str, @NotNull String mixStreamId, @Nullable List<MultiPkUserInfoModel> list) {
        com.cupidapp.live.liveshow.entity.l lVar;
        s.i(mixStreamId, "mixStreamId");
        this.f15208m = z10;
        this.f15209n = mixStreamId;
        this.f15205j = MultiPersonPkState.PKPrepare;
        setVisibility(0);
        ((TextView) f(R$id.pk_status_txt)).setText(getContext().getString(R$string.prepare));
        if (z10) {
            int i10 = R$id.start_pk_btn;
            ((ImageView) f(i10)).setVisibility(0);
            ((ImageView) f(i10)).setEnabled(false);
        } else {
            ((ImageView) f(R$id.start_pk_btn)).setVisibility(8);
        }
        com.cupidapp.live.liveshow.entity.l lVar2 = this.f15200e;
        if (lVar2 != null) {
            lVar2.l(new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkLayout$openMultiPk$1
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
                    boolean z11;
                    z11 = MultiPkLayout.this.f15215t;
                    if (z11) {
                        MultiPkLayout.this.f15215t = false;
                        e eVar = MultiPkLayout.this.f15199d;
                        if (eVar != null) {
                            eVar.e();
                        }
                    }
                }
            });
        }
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            com.cupidapp.live.liveshow.entity.l lVar3 = this.f15200e;
            if (lVar3 != null) {
                lVar3.k(liveShowModel.getItemId(), liveShowModel.getStreamId(), MultiPkPlaceType.ThreePkPlace, 0);
            }
            MultiPkUserInfoLayout first_anchor_info_layout = (MultiPkUserInfoLayout) f(R$id.first_anchor_info_layout);
            s.h(first_anchor_info_layout, "first_anchor_info_layout");
            MultiPkUserInfoLayout.q(first_anchor_info_layout, liveShowModel.getUser(), false, 2, null);
        }
        Iterator<MultiPkInviteeLayout> iterator2 = this.f15206k.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().setIsInitiator(z10);
        }
        if (!(list == null || list.isEmpty())) {
            int i11 = 0;
            for (MultiPkUserInfoModel multiPkUserInfoModel : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                MultiPkUserInfoModel multiPkUserInfoModel2 = multiPkUserInfoModel;
                MultiPkInviteeLayout.r(this.f15206k.get(i11), multiPkUserInfoModel2.getMultiPkAnchorModel(), 0, 2, null);
                String streamId = multiPkUserInfoModel2.getStreamId();
                if (!(streamId == null || streamId.length() == 0) && (lVar = this.f15200e) != null) {
                    lVar.k(multiPkUserInfoModel2.getLiveShowId(), multiPkUserInfoModel2.getStreamId(), MultiPkPlaceType.ThreePkPlace, i12);
                }
                i11 = i12;
            }
        }
        com.cupidapp.live.liveshow.entity.l lVar4 = this.f15200e;
        if (lVar4 != null) {
            lVar4.o(mixStreamId, str);
        }
        com.cupidapp.live.liveshow.pk.view.e eVar = this.f15199d;
        if (eVar != null) {
            eVar.c(this.f15203h, this.f15204i);
        }
    }

    public final void D(@NotNull MultiPkScoreUpdateModel model) {
        Object obj;
        Object obj2;
        s.i(model, "model");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            Iterator<E> iterator2 = CollectionsKt___CollectionsKt.Q(model.getAnchors()).iterator2();
            while (true) {
                if (iterator2.hasNext()) {
                    obj2 = iterator2.next();
                    if (s.d(((MultiPkRankModel) obj2).getLiveShowId(), liveShowModel.getItemId())) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            MultiPkRankModel multiPkRankModel = (MultiPkRankModel) obj2;
            if (multiPkRankModel != null) {
                MultiPkUserInfoLayout multiPkUserInfoLayout = (MultiPkUserInfoLayout) f(R$id.first_anchor_info_layout);
                this.f15217v = multiPkRankModel.getDiamond();
                multiPkUserInfoLayout.o(multiPkRankModel.getCredit(), multiPkRankModel.getSort(), model.getShowBorder());
                multiPkUserInfoLayout.l(multiPkRankModel.getList());
            }
        }
        int i10 = 0;
        for (MultiPkInviteeLayout multiPkInviteeLayout : this.f15206k) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkInviteeLayout multiPkInviteeLayout2 = multiPkInviteeLayout;
            MultiPkAnchorModel pkAnchorModel = multiPkInviteeLayout2.getPkAnchorModel();
            String liveShowId = pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null;
            if (!(liveShowId == null || liveShowId.length() == 0)) {
                Iterator<E> iterator22 = CollectionsKt___CollectionsKt.Q(model.getAnchors()).iterator2();
                while (true) {
                    if (iterator22.hasNext()) {
                        obj = iterator22.next();
                        if (s.d(((MultiPkRankModel) obj).getLiveShowId(), liveShowId)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                MultiPkRankModel multiPkRankModel2 = (MultiPkRankModel) obj;
                if (multiPkRankModel2 != null) {
                    multiPkInviteeLayout2.D(multiPkRankModel2, model.getShowBorder());
                }
            }
            i10 = i11;
        }
    }

    public final void E(@NotNull MultiPkInfoModel pkInfo) {
        s.i(pkInfo, "pkInfo");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null) {
            return;
        }
        List<MultiPkAnchorInfoModel> anchors = pkInfo.getAnchors();
        ArrayList arrayList = new ArrayList();
        for (MultiPkAnchorInfoModel multiPkAnchorInfoModel : anchors) {
            if (true ^ s.d(multiPkAnchorInfoModel.getLiveShowId(), liveShowModel.getItemId())) {
                arrayList.add(multiPkAnchorInfoModel);
            }
        }
        List<MultiPkInviteeLayout> list = this.f15206k;
        ArrayList arrayList2 = new ArrayList();
        Iterator<MultiPkInviteeLayout> iterator2 = list.iterator2();
        while (true) {
            boolean z10 = false;
            if (!iterator2.hasNext()) {
                break;
            }
            MultiPkInviteeLayout next = iterator2.next();
            MultiPkAnchorModel pkAnchorModel = next.getPkAnchorModel();
            if (pkAnchorModel != null && pkAnchorModel.hasStream()) {
                z10 = true;
            }
            if (z10) {
                arrayList2.add(next);
            }
        }
        if (arrayList.size() != arrayList2.size()) {
            int i10 = 0;
            for (MultiPkInviteeLayout multiPkInviteeLayout : this.f15206k) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                multiPkInviteeLayout.w();
                i10 = i11;
            }
        }
        int i12 = 0;
        for (Object obj : arrayList) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkAnchorInfoModel multiPkAnchorInfoModel2 = (MultiPkAnchorInfoModel) obj;
            MultiPkInviteeLayout multiPkInviteeLayout2 = this.f15206k.get(i12);
            MultiPkAnchorModel pkAnchorModel2 = multiPkInviteeLayout2.getPkAnchorModel();
            if (!s.d(pkAnchorModel2 != null ? pkAnchorModel2.getLiveShowId() : null, multiPkAnchorInfoModel2.getLiveShowId())) {
                MultiPkInviteeLayout.r(multiPkInviteeLayout2, multiPkAnchorInfoModel2.getMultiPkAnchorModel(), 0, 2, null);
            }
            i12 = i13;
        }
        String stage = pkInfo.getStage();
        if (s.d(stage, MultiPersonPkState.PKing.getValue())) {
            Long startTimeMills = pkInfo.getStartTimeMills();
            int currentTimeMillis = (int) ((System.currentTimeMillis() - (startTimeMills != null ? startTimeMills.longValue() : System.currentTimeMillis())) / 1000);
            Integer countdownSeconds = pkInfo.getCountdownSeconds();
            U(currentTimeMillis >= 0 ? (countdownSeconds != null ? countdownSeconds.intValue() : 0) - currentTimeMillis : 0, pkInfo.getJumpUrl(), pkInfo.getPkPairId(), false);
            List<MultiPkAnchorInfoModel> anchors2 = pkInfo.getAnchors();
            ArrayList arrayList3 = new ArrayList(t.t(anchors2, 10));
            Iterator<MultiPkAnchorInfoModel> iterator22 = anchors2.iterator2();
            while (iterator22.hasNext()) {
                arrayList3.add(iterator22.next().getMultiPkRankModel());
            }
            D(new MultiPkScoreUpdateModel(arrayList3, pkInfo.getShowBorder()));
            return;
        }
        if (s.d(stage, MultiPersonPkState.PKInteract.getValue())) {
            List<MultiPkAnchorInfoModel> anchors3 = pkInfo.getAnchors();
            ArrayList arrayList4 = new ArrayList(t.t(anchors3, 10));
            Iterator<MultiPkAnchorInfoModel> iterator23 = anchors3.iterator2();
            while (iterator23.hasNext()) {
                arrayList4.add(iterator23.next().getMultiPkResultModel());
            }
            V(new MultiPkInteractModel(arrayList4));
            List<MultiPkAnchorInfoModel> anchors4 = pkInfo.getAnchors();
            ArrayList arrayList5 = new ArrayList(t.t(anchors4, 10));
            Iterator<MultiPkAnchorInfoModel> iterator24 = anchors4.iterator2();
            while (iterator24.hasNext()) {
                arrayList5.add(iterator24.next().getMultiPkRankModel());
            }
            D(new MultiPkScoreUpdateModel(arrayList5, pkInfo.getShowBorder()));
        }
    }

    public final void F(@NotNull String liveShowId) {
        Object obj;
        s.i(liveShowId, "liveShowId");
        Iterator<MultiPkInviteeLayout> iterator2 = this.f15206k.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            MultiPkInviteeLayout next = iterator2.next();
            MultiPkAnchorModel pkAnchorModel = next.getPkAnchorModel();
            if (s.d(pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null, liveShowId)) {
                obj = next;
                break;
            }
        }
        MultiPkInviteeLayout multiPkInviteeLayout = (MultiPkInviteeLayout) obj;
        if (multiPkInviteeLayout != null) {
            multiPkInviteeLayout.w();
        }
        N();
    }

    public final void G(@NotNull String liveShowId) {
        Object obj;
        s.i(liveShowId, "liveShowId");
        com.cupidapp.live.liveshow.entity.l lVar = this.f15200e;
        if (lVar != null) {
            lVar.i(liveShowId);
        }
        Iterator<MultiPkInviteeLayout> iterator2 = this.f15206k.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            MultiPkInviteeLayout next = iterator2.next();
            MultiPkAnchorModel pkAnchorModel = next.getPkAnchorModel();
            if (s.d(pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null, liveShowId)) {
                obj = next;
                break;
            }
        }
        MultiPkInviteeLayout multiPkInviteeLayout = (MultiPkInviteeLayout) obj;
        if (multiPkInviteeLayout != null) {
            multiPkInviteeLayout.w();
        }
        List<MultiPkInviteeLayout> list = this.f15206k;
        ArrayList arrayList = new ArrayList();
        Iterator<MultiPkInviteeLayout> iterator22 = list.iterator2();
        while (true) {
            if (!iterator22.hasNext()) {
                break;
            }
            MultiPkInviteeLayout next2 = iterator22.next();
            MultiPkAnchorModel pkAnchorModel2 = next2.getPkAnchorModel();
            if (pkAnchorModel2 != null && pkAnchorModel2.hasStream()) {
                arrayList.add(next2);
            }
        }
        int i10 = b.f15220a[this.f15205j.ordinal()];
        if (i10 == 1) {
            if (arrayList.isEmpty()) {
                w();
                return;
            } else {
                P();
                return;
            }
        }
        if (i10 != 2) {
            N();
            MultiPkPlaceType multiPkPlaceType = MultiPkPlaceType.ThreePkPlace;
            ArrayList arrayList2 = new ArrayList(t.t(arrayList, 10));
            Iterator<E> iterator23 = arrayList.iterator2();
            while (iterator23.hasNext()) {
                MultiPkAnchorModel pkAnchorModel3 = ((MultiPkInviteeLayout) iterator23.next()).getPkAnchorModel();
                s.f(pkAnchorModel3);
                arrayList2.add(pkAnchorModel3.getLiveShowId());
            }
            a0(multiPkPlaceType, arrayList2);
            return;
        }
        if (arrayList.isEmpty()) {
            w();
            return;
        }
        N();
        MultiPkPlaceType multiPkPlaceType2 = MultiPkPlaceType.ThreePkPlace;
        ArrayList arrayList3 = new ArrayList(t.t(arrayList, 10));
        Iterator<E> iterator24 = arrayList.iterator2();
        while (iterator24.hasNext()) {
            MultiPkAnchorModel pkAnchorModel4 = ((MultiPkInviteeLayout) iterator24.next()).getPkAnchorModel();
            s.f(pkAnchorModel4);
            arrayList3.add(pkAnchorModel4.getLiveShowId());
        }
        a0(multiPkPlaceType2, arrayList3);
    }

    public final void I(int i10) {
        User user;
        if (this.f15205j == MultiPersonPkState.PKPrepare) {
            return;
        }
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        GroupLiveLog.f18698a.c(this.f15211p, liveShowModel != null ? liveShowModel.getItemId() : null, (liveShowModel == null || (user = liveShowModel.getUser()) == null) ? null : user.userId(), this.f15205j, this.f15218w, this.f15217v, i10);
    }

    public final void J(String str) {
        User user;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
        String str2 = null;
        String itemId = liveShowModel != null ? liveShowModel.getItemId() : null;
        if (liveShowModel != null && (user = liveShowModel.getUser()) != null) {
            str2 = user.userId();
        }
        groupLiveLog.M(str, itemId, str2, this.f15208m);
    }

    public final void K(MultiPkInviteeLayout multiPkInviteeLayout, int i10, boolean z10) {
        multiPkInviteeLayout.setVisibility(0);
        if (z10) {
            multiPkInviteeLayout.w();
        }
        if (multiPkInviteeLayout.getWidth() != this.f15203h || multiPkInviteeLayout.getHeight() != this.f15204i) {
            y.n(multiPkInviteeLayout, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15204i));
        }
        v(multiPkInviteeLayout, this.f15207l.get(i10));
    }

    public final void L(List<MultiPkResultModel> list) {
        MultiPkResultModel multiPkResultModel;
        int i10 = 0;
        for (MultiPkInviteeLayout multiPkInviteeLayout : this.f15206k) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkInviteeLayout multiPkInviteeLayout2 = multiPkInviteeLayout;
            K(multiPkInviteeLayout2, i10, false);
            MultiPkAnchorModel pkAnchorModel = multiPkInviteeLayout2.getPkAnchorModel();
            String str = null;
            String liveShowId = pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null;
            Iterator<MultiPkResultModel> iterator2 = list.iterator2();
            while (true) {
                if (iterator2.hasNext()) {
                    multiPkResultModel = iterator2.next();
                    if (s.d(multiPkResultModel.getLiveShowId(), liveShowId)) {
                        break;
                    }
                } else {
                    multiPkResultModel = null;
                    break;
                }
            }
            MultiPkResultModel multiPkResultModel2 = multiPkResultModel;
            if (multiPkResultModel2 != null) {
                str = multiPkResultModel2.getPkResult();
            }
            multiPkInviteeLayout2.s(str);
            i10 = i11;
        }
        N();
        List<MultiPkInviteeLayout> list2 = this.f15206k;
        ArrayList arrayList = new ArrayList();
        for (MultiPkInviteeLayout multiPkInviteeLayout3 : list2) {
            MultiPkAnchorModel pkAnchorModel2 = multiPkInviteeLayout3.getPkAnchorModel();
            if (pkAnchorModel2 != null && pkAnchorModel2.hasStream()) {
                arrayList.add(multiPkInviteeLayout3);
            }
        }
        MultiPkPlaceType multiPkPlaceType = MultiPkPlaceType.ThreePkPlace;
        ArrayList arrayList2 = new ArrayList(t.t(arrayList, 10));
        Iterator<E> iterator22 = arrayList.iterator2();
        while (iterator22.hasNext()) {
            MultiPkAnchorModel pkAnchorModel3 = ((MultiPkInviteeLayout) iterator22.next()).getPkAnchorModel();
            s.f(pkAnchorModel3);
            arrayList2.add(pkAnchorModel3.getLiveShowId());
        }
        a0(multiPkPlaceType, arrayList2);
    }

    public final void M() {
        int i10 = 0;
        for (MultiPkInviteeLayout multiPkInviteeLayout : this.f15206k) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            v(multiPkInviteeLayout, this.f15207l.get(i10));
            i10 = i11;
        }
    }

    public final void N() {
        List<MultiPkInviteeLayout> list = this.f15206k;
        if (list.size() > 1) {
            w.w(list, new e());
        }
        M();
        W();
    }

    public final void O() {
        List<MultiPkInviteeLayout> list = this.f15206k;
        if (list.size() > 1) {
            w.w(list, new f());
        }
        M();
        W();
    }

    public final void P() {
        Iterator<MultiPkInviteeLayout> iterator2 = this.f15206k.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            MultiPkInviteeLayout next = iterator2.next();
            MultiPkAnchorModel pkAnchorModel = next.getPkAnchorModel();
            if (!(pkAnchorModel != null && pkAnchorModel.hasStream())) {
                MultiPkInviteeLayout.r(next, null, 0, 2, null);
                next.setVisibility(8);
            } else {
                next.x();
            }
        }
        List<MultiPkInviteeLayout> list = this.f15206k;
        ArrayList arrayList = new ArrayList();
        for (MultiPkInviteeLayout multiPkInviteeLayout : list) {
            MultiPkAnchorModel pkAnchorModel2 = multiPkInviteeLayout.getPkAnchorModel();
            if (pkAnchorModel2 != null && pkAnchorModel2.hasStream()) {
                arrayList.add(multiPkInviteeLayout);
            }
        }
        int size = arrayList.size();
        if (size == MultiPkPlaceType.ThreePkPlace.getType()) {
            return;
        }
        MultiPkPlaceType multiPkPlaceType = MultiPkPlaceType.TwoPkPlace;
        if (size == multiPkPlaceType.getType()) {
            FrameLayout first_anchor_layout = (FrameLayout) f(R$id.first_anchor_layout);
            s.h(first_anchor_layout, "first_anchor_layout");
            y.n(first_anchor_layout, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15202g));
            com.cupidapp.live.liveshow.pk.view.e eVar = this.f15199d;
            if (eVar != null) {
                eVar.h(this.f15203h, this.f15202g);
            }
            v((View) CollectionsKt___CollectionsKt.T(arrayList), (Pair) CollectionsKt___CollectionsKt.T(this.f15207l));
            v((View) CollectionsKt___CollectionsKt.e0(arrayList), (Pair) CollectionsKt___CollectionsKt.e0(this.f15207l));
            ArrayList arrayList2 = new ArrayList(t.t(arrayList, 10));
            Iterator<E> iterator22 = arrayList.iterator2();
            while (iterator22.hasNext()) {
                MultiPkAnchorModel pkAnchorModel3 = ((MultiPkInviteeLayout) iterator22.next()).getPkAnchorModel();
                s.f(pkAnchorModel3);
                arrayList2.add(pkAnchorModel3.getLiveShowId());
            }
            a0(multiPkPlaceType, arrayList2);
            return;
        }
        MultiPkPlaceType multiPkPlaceType2 = MultiPkPlaceType.OnePkPlace;
        if (size == multiPkPlaceType2.getType()) {
            FrameLayout first_anchor_layout2 = (FrameLayout) f(R$id.first_anchor_layout);
            s.h(first_anchor_layout2, "first_anchor_layout");
            y.n(first_anchor_layout2, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15202g));
            com.cupidapp.live.liveshow.pk.view.e eVar2 = this.f15199d;
            if (eVar2 != null) {
                eVar2.h(this.f15203h, this.f15202g);
            }
            MultiPkInviteeLayout multiPkInviteeLayout2 = (MultiPkInviteeLayout) CollectionsKt___CollectionsKt.e0(arrayList);
            v(multiPkInviteeLayout2, (Pair) CollectionsKt___CollectionsKt.T(this.f15207l));
            y.n(multiPkInviteeLayout2, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15202g));
            ArrayList arrayList3 = new ArrayList(t.t(arrayList, 10));
            Iterator<E> iterator23 = arrayList.iterator2();
            while (iterator23.hasNext()) {
                MultiPkAnchorModel pkAnchorModel4 = ((MultiPkInviteeLayout) iterator23.next()).getPkAnchorModel();
                s.f(pkAnchorModel4);
                arrayList3.add(pkAnchorModel4.getLiveShowId());
            }
            a0(multiPkPlaceType2, arrayList3);
        }
    }

    public final void Q() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.close_multi_pk_prompt, 0, 2, null), R$string.confirm_close, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkLayout$showCloseMultiPkPrompt$1
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
                MultiPersonPkState multiPersonPkState;
                e eVar = MultiPkLayout.this.f15199d;
                if (eVar != null) {
                    multiPersonPkState = MultiPkLayout.this.f15205j;
                    eVar.f(multiPersonPkState);
                }
            }
        }, 2, null), R$string.continue_the_PK, null, 2, null).k(true), null, 1, null);
    }

    public final void R(@NotNull String liveShowId) {
        s.i(liveShowId, "liveShowId");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null && s.d(liveShowId, liveShowModel.getItemId())) {
            ((MultiPkUserInfoLayout) f(R$id.first_anchor_info_layout)).u();
        }
        int i10 = 0;
        for (MultiPkInviteeLayout multiPkInviteeLayout : this.f15206k) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkInviteeLayout multiPkInviteeLayout2 = multiPkInviteeLayout;
            MultiPkAnchorModel pkAnchorModel = multiPkInviteeLayout2.getPkAnchorModel();
            if (s.d(liveShowId, pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null)) {
                multiPkInviteeLayout2.y();
            }
            i10 = i11;
        }
    }

    public final void S(String str) {
        int i10 = R$id.pk_moment_animation;
        ((FKSVGAImageView) f(i10)).setVisibility(0);
        FKSVGAImageView pk_moment_animation = (FKSVGAImageView) f(i10);
        s.h(pk_moment_animation, "pk_moment_animation");
        FKSVGAImageView.F(pk_moment_animation, str, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkLayout$showPkMomentAnimation$1
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
                ((FKSVGAImageView) MultiPkLayout.this.f(R$id.pk_moment_animation)).setVisibility(8);
            }
        }, 2, null);
    }

    public final void T() {
        int i10 = R$id.pk_start_animation;
        ((FKWebpAnimationView) f(i10)).setVisibility(0);
        FKWebpAnimationView pk_start_animation = (FKWebpAnimationView) f(i10);
        s.h(pk_start_animation, "pk_start_animation");
        FKWebpAnimationView.d(pk_start_animation, "start_pk.webp", 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkLayout$showPkStartAnimation$1
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
                MultiPkLayout multiPkLayout = MultiPkLayout.this;
                int i11 = R$id.pk_start_animation;
                ((FKWebpAnimationView) multiPkLayout.f(i11)).i();
                ((FKWebpAnimationView) MultiPkLayout.this.f(i11)).setVisibility(8);
                MultiPkLayout.this.S("first_blood.svga");
            }
        }, 2, null);
    }

    public final void U(int i10, @NotNull String rankUrl, @Nullable String str, boolean z10) {
        s.i(rankUrl, "rankUrl");
        MultiPersonPkState multiPersonPkState = this.f15205j;
        if (multiPersonPkState == MultiPersonPkState.PKPrepare || multiPersonPkState == MultiPersonPkState.PKInteract) {
            this.f15216u = Long.valueOf(System.currentTimeMillis());
            this.f15211p = str;
            this.f15210o = rankUrl;
            this.f15213r = i10;
            this.f15205j = MultiPersonPkState.PKing;
            this.f15214s = i10;
            this.f15217v = null;
            this.f15218w = null;
            ((ImageView) f(R$id.start_pk_btn)).setVisibility(8);
            ((MultiPkUserInfoLayout) f(R$id.first_anchor_info_layout)).t();
            X();
            T();
            P();
            if (z10) {
                J(str);
            }
        }
    }

    public final void V(@NotNull MultiPkInteractModel model) {
        MultiPkResultModel multiPkResultModel;
        s.i(model, "model");
        if (this.f15205j == MultiPersonPkState.PKing) {
            Z();
            ((TextView) f(R$id.pk_status_txt)).setText(getContext().getString(R$string.interacting));
            if (this.f15208m) {
                ((ImageView) f(R$id.start_pk_btn)).setVisibility(0);
            }
            FrameLayout first_anchor_layout = (FrameLayout) f(R$id.first_anchor_layout);
            s.h(first_anchor_layout, "first_anchor_layout");
            y.n(first_anchor_layout, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15204i));
            com.cupidapp.live.liveshow.pk.view.e eVar = this.f15199d;
            if (eVar != null) {
                eVar.h(this.f15203h, this.f15204i);
            }
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (liveShowModel != null) {
                Iterator<MultiPkResultModel> iterator2 = model.getResult().iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        multiPkResultModel = null;
                        break;
                    } else {
                        multiPkResultModel = iterator2.next();
                        if (s.d(multiPkResultModel.getLiveShowId(), liveShowModel.getItemId())) {
                            break;
                        }
                    }
                }
                MultiPkResultModel multiPkResultModel2 = multiPkResultModel;
                String pkResult = multiPkResultModel2 != null ? multiPkResultModel2.getPkResult() : null;
                this.f15218w = pkResult;
                ((MultiPkUserInfoLayout) f(R$id.first_anchor_info_layout)).m(pkResult);
            }
            L(model.getResult());
            I(this.f15213r);
            this.f15205j = MultiPersonPkState.PKInteract;
        }
    }

    public final void W() {
        ImageView start_pk_btn = (ImageView) f(R$id.start_pk_btn);
        s.h(start_pk_btn, "start_pk_btn");
        if (start_pk_btn.getVisibility() == 0) {
            List<MultiPkInviteeLayout> list = this.f15206k;
            ArrayList arrayList = new ArrayList();
            for (MultiPkInviteeLayout multiPkInviteeLayout : list) {
                MultiPkAnchorModel pkAnchorModel = multiPkInviteeLayout.getPkAnchorModel();
                if (pkAnchorModel != null && pkAnchorModel.hasStream()) {
                    arrayList.add(multiPkInviteeLayout);
                }
            }
            ((ImageView) f(R$id.start_pk_btn)).setEnabled(!arrayList.isEmpty());
        }
    }

    public final void X() {
        if (this.f15212q == null) {
            ((TextView) f(R$id.pk_status_txt)).setText(v.j(this.f15214s));
            Observable<Long> observeOn = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkLayout$startPkCountDown$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke2(l10);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                    int i10;
                    int i11;
                    int i12;
                    int i13;
                    i10 = MultiPkLayout.this.f15214s;
                    if (i10 > 0) {
                        MultiPkLayout multiPkLayout = MultiPkLayout.this;
                        i13 = multiPkLayout.f15214s;
                        multiPkLayout.f15214s = i13 - 1;
                    }
                    i11 = MultiPkLayout.this.f15214s;
                    if (i11 == 30) {
                        MultiPkLayout.this.S("steal_tower.svga");
                    }
                    TextView textView = (TextView) MultiPkLayout.this.f(R$id.pk_status_txt);
                    i12 = MultiPkLayout.this.f15214s;
                    textView.setText(v.j(i12));
                }
            };
            this.f15212q = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.liveshow.pk.view.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MultiPkLayout.Y(Function1.this, obj);
                }
            });
        }
    }

    public final void Z() {
        Disposable disposable = this.f15212q;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f15212q = null;
        this.f15214s = 0;
    }

    public final void a0(MultiPkPlaceType multiPkPlaceType, List<String> list) {
        ArrayList arrayList = new ArrayList();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            arrayList.add(liveShowModel.getItemId());
        }
        arrayList.addAll(list);
        com.cupidapp.live.liveshow.entity.l lVar = this.f15200e;
        if (lVar != null) {
            lVar.r(multiPkPlaceType, arrayList, this.f15209n);
        }
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f15219x;
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

    public final void g(@NotNull String pkLiveShowId, @NotNull String pkStreamId) {
        Object obj;
        s.i(pkLiveShowId, "pkLiveShowId");
        s.i(pkStreamId, "pkStreamId");
        Iterator<MultiPkInviteeLayout> iterator2 = this.f15206k.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            MultiPkInviteeLayout next = iterator2.next();
            MultiPkAnchorModel pkAnchorModel = next.getPkAnchorModel();
            if (s.d(pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null, pkLiveShowId)) {
                obj = next;
                break;
            }
        }
        MultiPkInviteeLayout multiPkInviteeLayout = (MultiPkInviteeLayout) obj;
        if (multiPkInviteeLayout != null) {
            multiPkInviteeLayout.v(pkStreamId);
            O();
            int indexOf = this.f15206k.indexOf(multiPkInviteeLayout) + 1;
            com.cupidapp.live.liveshow.entity.l lVar = this.f15200e;
            if (lVar != null) {
                lVar.h(pkLiveShowId, pkStreamId, MultiPkPlaceType.ThreePkPlace, indexOf, this.f15209n);
            }
        }
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.cupidapp.live.liveshow.entity.l lVar;
        super.onDetachedFromWindow();
        String str = this.f15209n;
        if ((str == null || str.length() == 0) || (lVar = this.f15200e) == null) {
            return;
        }
        lVar.q(this.f15209n);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        com.cupidapp.live.liveshow.pk.view.e eVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (getVisibility() == 0 && z10 && (eVar = this.f15199d) != null) {
            eVar.d(i11);
        }
    }

    public final void setMultiPkListener(@NotNull com.cupidapp.live.liveshow.pk.view.e listener) {
        s.i(listener, "listener");
        this.f15199d = listener;
    }

    public final void t() {
        ImageView close_multi_pk_img = (ImageView) f(R$id.close_multi_pk_img);
        s.h(close_multi_pk_img, "close_multi_pk_img");
        y.d(close_multi_pk_img, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkLayout$bindClickEvent$1
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
                MultiPkLayout.this.Q();
            }
        });
        ImageView start_pk_btn = (ImageView) f(R$id.start_pk_btn);
        s.h(start_pk_btn, "start_pk_btn");
        y.d(start_pk_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkLayout$bindClickEvent$2
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
                MultiPersonPkState multiPersonPkState;
                MultiPersonPkState multiPersonPkState2;
                multiPersonPkState = MultiPkLayout.this.f15205j;
                if (multiPersonPkState != MultiPersonPkState.PKPrepare) {
                    multiPersonPkState2 = MultiPkLayout.this.f15205j;
                    if (multiPersonPkState2 != MultiPersonPkState.PKInteract) {
                        return;
                    }
                }
                e eVar = MultiPkLayout.this.f15199d;
                if (eVar != null) {
                    eVar.i();
                }
            }
        });
        ((MultiPkUserInfoLayout) f(R$id.first_anchor_info_layout)).setPkInfoListener(new c());
        MultiPkInviteeLayout second_invitee_layout = (MultiPkInviteeLayout) f(R$id.second_invitee_layout);
        s.h(second_invitee_layout, "second_invitee_layout");
        u(second_invitee_layout);
        MultiPkInviteeLayout third_invitee_layout = (MultiPkInviteeLayout) f(R$id.third_invitee_layout);
        s.h(third_invitee_layout, "third_invitee_layout");
        u(third_invitee_layout);
        MultiPkInviteeLayout fourth_invitee_layout = (MultiPkInviteeLayout) f(R$id.fourth_invitee_layout);
        s.h(fourth_invitee_layout, "fourth_invitee_layout");
        u(fourth_invitee_layout);
    }

    public final void u(MultiPkInviteeLayout multiPkInviteeLayout) {
        multiPkInviteeLayout.setMultiPkInviteeListener(new d(multiPkInviteeLayout));
    }

    public final void v(View view, Pair<Float, Float> pair) {
        if (view.getX() == pair.getFirst().floatValue()) {
            if (view.getY() == pair.getSecond().floatValue()) {
                return;
            }
        }
        view.setX(pair.getFirst().floatValue());
        view.setY(pair.getSecond().floatValue());
    }

    public final void w() {
        MultiPersonPkState multiPersonPkState = this.f15205j;
        MultiPersonPkState multiPersonPkState2 = MultiPersonPkState.PKEnd;
        if (multiPersonPkState == multiPersonPkState2) {
            return;
        }
        com.cupidapp.live.base.fragment.b.f11807a.b();
        long currentTimeMillis = System.currentTimeMillis();
        Long l10 = this.f15216u;
        I((int) ((currentTimeMillis - (l10 != null ? l10.longValue() : System.currentTimeMillis())) / 1000));
        this.f15205j = multiPersonPkState2;
        this.f15215t = true;
        Z();
        com.cupidapp.live.liveshow.entity.l lVar = this.f15200e;
        if (lVar != null) {
            lVar.q(this.f15209n);
        }
        this.f15209n = null;
        this.f15217v = null;
        this.f15218w = null;
        ((MultiPkUserInfoLayout) f(R$id.first_anchor_info_layout)).t();
        FrameLayout first_anchor_layout = (FrameLayout) f(R$id.first_anchor_layout);
        s.h(first_anchor_layout, "first_anchor_layout");
        y.n(first_anchor_layout, Integer.valueOf(this.f15203h), Integer.valueOf(this.f15204i));
        com.cupidapp.live.liveshow.pk.view.e eVar = this.f15199d;
        if (eVar != null) {
            eVar.a();
        }
        int i10 = 0;
        for (MultiPkInviteeLayout multiPkInviteeLayout : this.f15206k) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            K(multiPkInviteeLayout, i10, true);
            i10 = i11;
        }
        setVisibility(8);
    }

    public final void x(@NotNull MultiPkAnchorModel model, int i10) {
        s.i(model, "model");
        int i11 = 0;
        for (MultiPkInviteeLayout multiPkInviteeLayout : this.f15206k) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkInviteeLayout multiPkInviteeLayout2 = multiPkInviteeLayout;
            if (multiPkInviteeLayout2.getPkAnchorModel() == null) {
                multiPkInviteeLayout2.q(model, i10);
                return;
            }
            i11 = i12;
        }
    }

    public final String z(String str, int i10) {
        String str2;
        String a10;
        if (this.f15211p == null || (str2 = this.f15210o) == null || (a10 = x.a(str2, "liveShowId", str)) == null) {
            return null;
        }
        String str3 = this.f15211p;
        s.f(str3);
        String a11 = x.a(a10, "pkPairId", str3);
        if (a11 != null) {
            return x.a(a11, "flag", String.valueOf(i10));
        }
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15219x = new LinkedHashMap();
        this.f15205j = MultiPersonPkState.PKPrepare;
        this.f15206k = new ArrayList();
        this.f15207l = new ArrayList();
        this.f15215t = true;
        A();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15219x = new LinkedHashMap();
        this.f15205j = MultiPersonPkState.PKPrepare;
        this.f15206k = new ArrayList();
        this.f15207l = new ArrayList();
        this.f15215t = true;
        A();
    }
}
