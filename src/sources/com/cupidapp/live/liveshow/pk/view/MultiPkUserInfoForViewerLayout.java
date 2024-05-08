package com.cupidapp.live.liveshow.pk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkRankModel;
import com.cupidapp.live.liveshow.pk.view.l;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;
import z0.z;

/* compiled from: MultiPkUserInfoForViewerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkUserInfoForViewerLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function0<p> f15224d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public MultiPkAnchorModel f15225e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15226f;

    /* compiled from: MultiPkUserInfoForViewerLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements l {
        public a() {
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void a() {
            Function0<p> openPkRankCallback = MultiPkUserInfoForViewerLayout.this.getOpenPkRankCallback();
            if (openPkRankCallback != null) {
                openPkRankCallback.invoke();
            }
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void b(boolean z10) {
            l.a.a(this, z10);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void c() {
            MultiPkAnchorModel pkAnchorModel = MultiPkUserInfoForViewerLayout.this.getPkAnchorModel();
            if (pkAnchorModel != null) {
                MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout = MultiPkUserInfoForViewerLayout.this;
                String liveShowId = pkAnchorModel.getLiveShowId();
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null)) {
                    return;
                }
                multiPkUserInfoForViewerLayout.m(pkAnchorModel.getLiveShowId());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkUserInfoForViewerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15226f = new LinkedHashMap();
        k();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15226f;
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

    @Nullable
    public final Function0<p> getOpenPkRankCallback() {
        return this.f15224d;
    }

    @Nullable
    public final MultiPkAnchorModel getPkAnchorModel() {
        return this.f15225e;
    }

    public final void h(@Nullable String str) {
        ((MultiPkUserInfoLayout) e(R$id.pk_anchor_info_layout)).m(str);
    }

    public final void i(@Nullable MultiPkAnchorModel multiPkAnchorModel) {
        this.f15225e = multiPkAnchorModel;
        if (multiPkAnchorModel == null) {
            int i10 = R$id.pk_anchor_info_layout;
            ((MultiPkUserInfoLayout) e(i10)).t();
            ((MultiPkUserInfoLayout) e(i10)).setVisibility(8);
        } else {
            int i11 = R$id.pk_anchor_info_layout;
            ((MultiPkUserInfoLayout) e(i11)).setVisibility(0);
            ((MultiPkUserInfoLayout) e(i11)).p(multiPkAnchorModel.getUser(), false);
        }
    }

    public final void j(String str) {
        Disposable disposed = a.C0826a.g(NetworkClient.f11868a.r(), str, null, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowResult, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoForViewerLayout$enterOthersLive$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowResult liveShowResult) {
                m2635invoke(liveShowResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2635invoke(LiveShowResult liveShowResult) {
                LiveShowResult liveShowResult2 = liveShowResult;
                Context context = MultiPkUserInfoForViewerLayout.this.getContext();
                FKLiveForViewerActivity fKLiveForViewerActivity = context instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) context : null;
                if (fKLiveForViewerActivity != null) {
                    fKLiveForViewerActivity.T1();
                }
                FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, MultiPkUserInfoForViewerLayout.this.getContext(), new FKLiveForViewerViewModel(liveShowResult2.getLiveShow(), null, new LiveInRoomSensorModel("MULTI_PK", null, SensorScene.Live, SensorPosition.LiveShowRoom, null, null, 48, null), true), false, 4, null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void k() {
        z.a(this, R$layout.layout_multi_person_pk_user_info_for_viewer, true);
        ((MultiPkUserInfoLayout) e(R$id.pk_anchor_info_layout)).setPkInfoListener(new a());
    }

    public final void l() {
        ((MultiPkUserInfoLayout) e(R$id.pk_anchor_info_layout)).t();
    }

    public final void m(final String str) {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null).D(R$string.enter_others_live_room_prompt), R$string.enter_others_live_room_description, 0, 2, null), 0, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoForViewerLayout$showEnterOthersPrompt$1
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
                MultiPkUserInfoForViewerLayout.this.j(str);
            }
        }, 3, null), 0, null, 3, null), null, 1, null);
    }

    public final void o() {
        ((MultiPkUserInfoLayout) e(R$id.pk_anchor_info_layout)).u();
    }

    public final void p(@NotNull MultiPkRankModel scoreModel, boolean z10) {
        s.i(scoreModel, "scoreModel");
        MultiPkUserInfoLayout multiPkUserInfoLayout = (MultiPkUserInfoLayout) e(R$id.pk_anchor_info_layout);
        multiPkUserInfoLayout.o(scoreModel.getCredit(), scoreModel.getSort(), z10);
        multiPkUserInfoLayout.l(scoreModel.getList());
    }

    public final void setOpenPkRankCallback(@Nullable Function0<p> function0) {
        this.f15224d = function0;
    }

    public final void setPkAnchorModel(@Nullable MultiPkAnchorModel multiPkAnchorModel) {
        this.f15225e = multiPkAnchorModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkUserInfoForViewerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15226f = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkUserInfoForViewerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15226f = new LinkedHashMap();
        k();
    }
}
