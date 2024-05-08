package com.cupidapp.live.liveshow.pk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.entity.MixStreamLayoutListModel;
import com.cupidapp.live.liveshow.entity.MixStreamLayoutModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.MultiPkAnchorInfoModel;
import com.cupidapp.live.liveshow.model.MultiPkInfoModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkMixSuccessModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkRankModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkResultModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkScoreUpdateModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkUserInfoModel;
import com.cupidapp.live.profile.model.User;
import com.zego.zegoavkit2.mediaside.IZegoMediaSideCallback;
import com.zego.zegoavkit2.mediaside.ZegoMediaSideInfo;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.x;
import z0.y;
import z0.z;

/* compiled from: MultiPkForViewerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkForViewerLayout extends BaseLayout {

    /* renamed from: d */
    @Nullable
    public i f15175d;

    /* renamed from: e */
    public int f15176e;

    /* renamed from: f */
    public int f15177f;

    /* renamed from: g */
    public int f15178g;

    /* renamed from: h */
    public int f15179h;

    /* renamed from: i */
    @NotNull
    public final List<MultiPkUserInfoForViewerLayout> f15180i;

    /* renamed from: j */
    @NotNull
    public final List<Pair<Float, Float>> f15181j;

    /* renamed from: k */
    @Nullable
    public ZegoMediaSideInfo f15182k;

    /* renamed from: l */
    @Nullable
    public String f15183l;

    /* renamed from: m */
    @Nullable
    public Disposable f15184m;

    /* renamed from: n */
    public int f15185n;

    /* renamed from: o */
    @Nullable
    public MultiPersonPkState f15186o;

    /* renamed from: p */
    @Nullable
    public String f15187p;

    /* renamed from: q */
    @Nullable
    public String f15188q;

    /* renamed from: r */
    @NotNull
    public Map<Integer, View> f15189r;

    /* compiled from: MultiPkForViewerLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15190a;

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
            f15190a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkForViewerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15189r = new LinkedHashMap();
        this.f15180i = new ArrayList();
        this.f15181j = new ArrayList();
        w();
    }

    public static final void G(final MultiPkForViewerLayout this$0, String str, ByteBuffer inData, int i10) {
        s.i(this$0, "this$0");
        if (s.d(str, this$0.f15183l)) {
            s.h(inData, "inData");
            if (this$0.t(inData, i10) != 1003) {
                return;
            }
            final MixStreamLayoutListModel mixStreamLayoutListModel = (MixStreamLayoutListModel) GsonUtil.f12000a.b().fromJson(this$0.v(inData, i10), MixStreamLayoutListModel.class);
            int i11 = 0;
            for (MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout : this$0.f15180i) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                final MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout2 = multiPkUserInfoForViewerLayout;
                multiPkUserInfoForViewerLayout2.post(new Runnable() { // from class: com.cupidapp.live.liveshow.pk.view.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        MultiPkForViewerLayout.I(MultiPkUserInfoForViewerLayout.this, mixStreamLayoutListModel, this$0);
                    }
                });
                i11 = i12;
            }
        }
    }

    public static final void I(MultiPkUserInfoForViewerLayout layout, MixStreamLayoutListModel mixStreamLayoutListModel, MultiPkForViewerLayout this$0) {
        s.i(layout, "$layout");
        s.i(this$0, "this$0");
        MultiPkAnchorModel pkAnchorModel = layout.getPkAnchorModel();
        MixStreamLayoutModel mixStreamLayoutModel = null;
        String liveShowId = pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null;
        if (liveShowId != null) {
            Iterator<MixStreamLayoutModel> iterator2 = mixStreamLayoutListModel.getLayoutList().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                MixStreamLayoutModel next = iterator2.next();
                if (s.d(next.getLiveShowId(), liveShowId)) {
                    mixStreamLayoutModel = next;
                    break;
                }
            }
            MixStreamLayoutModel mixStreamLayoutModel2 = mixStreamLayoutModel;
            if (mixStreamLayoutModel2 != null) {
                float x10 = mixStreamLayoutModel2.getX() * this$0.f15176e;
                float y10 = mixStreamLayoutModel2.getY() * this$0.f15177f;
                int width = (int) (mixStreamLayoutModel2.getWidth() * this$0.f15176e);
                int height = (int) (mixStreamLayoutModel2.getHeight() * this$0.f15177f);
                this$0.o(layout, new Pair<>(Float.valueOf(x10), Float.valueOf(y10)));
                this$0.p(layout, width, height);
            }
        }
    }

    public static final void N(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void r(MultiPkForViewerLayout multiPkForViewerLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        multiPkForViewerLayout.q(z10);
    }

    public final void A(String str) {
        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
        List<String> c4 = fKLiveUtil.c();
        if (c4 != null && c4.contains(str)) {
            TextureView multi_pk_viewer_texture = (TextureView) h(R$id.multi_pk_viewer_texture);
            s.h(multi_pk_viewer_texture, "multi_pk_viewer_texture");
            fKLiveUtil.M(str, multi_pk_viewer_texture);
        } else {
            FKLiveUtil.D(fKLiveUtil, str, (TextureView) h(R$id.multi_pk_viewer_texture), null, null, 12, null);
        }
        this.f15183l = str;
        F();
    }

    public final void B(@NotNull MultiPkScoreUpdateModel model) {
        s.i(model, "model");
        int i10 = 0;
        for (MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout : this.f15180i) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout2 = multiPkUserInfoForViewerLayout;
            MultiPkAnchorModel pkAnchorModel = multiPkUserInfoForViewerLayout2.getPkAnchorModel();
            Object obj = null;
            String liveShowId = pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null;
            if (!(liveShowId == null || liveShowId.length() == 0)) {
                Iterator<E> iterator2 = CollectionsKt___CollectionsKt.Q(model.getAnchors()).iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    Object next = iterator2.next();
                    if (s.d(((MultiPkRankModel) next).getLiveShowId(), liveShowId)) {
                        obj = next;
                        break;
                    }
                }
                MultiPkRankModel multiPkRankModel = (MultiPkRankModel) obj;
                if (multiPkRankModel != null) {
                    multiPkUserInfoForViewerLayout2.p(multiPkRankModel, model.getShowBorder());
                }
            }
            i10 = i11;
        }
    }

    public final void C(@NotNull String liveShowId) {
        MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout;
        s.i(liveShowId, "liveShowId");
        Iterator<MultiPkUserInfoForViewerLayout> iterator2 = this.f15180i.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                multiPkUserInfoForViewerLayout = null;
                break;
            }
            multiPkUserInfoForViewerLayout = iterator2.next();
            MultiPkAnchorModel pkAnchorModel = multiPkUserInfoForViewerLayout.getPkAnchorModel();
            if (s.d(pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null, liveShowId)) {
                break;
            }
        }
        MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout2 = multiPkUserInfoForViewerLayout;
        if (multiPkUserInfoForViewerLayout2 != null) {
            multiPkUserInfoForViewerLayout2.i(null);
        }
        MultiPersonPkState multiPersonPkState = this.f15186o;
        int i10 = multiPersonPkState == null ? -1 : a.f15190a[multiPersonPkState.ordinal()];
        if (i10 == 1 || i10 == 2) {
            List<MultiPkUserInfoForViewerLayout> list = this.f15180i;
            ArrayList arrayList = new ArrayList();
            Iterator<MultiPkUserInfoForViewerLayout> iterator22 = list.iterator2();
            while (true) {
                if (!iterator22.hasNext()) {
                    break;
                }
                MultiPkUserInfoForViewerLayout next = iterator22.next();
                if (next.getPkAnchorModel() != null) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() <= 1) {
                r(this, false, 1, null);
            }
        }
    }

    public final void D(MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout, int i10) {
        multiPkUserInfoForViewerLayout.i(null);
        p(multiPkUserInfoForViewerLayout, this.f15178g, this.f15179h);
        o(multiPkUserInfoForViewerLayout, this.f15181j.get(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E() {
        List<MultiPkUserInfoForViewerLayout> list = this.f15180i;
        ArrayList arrayList = new ArrayList();
        Iterator<MultiPkUserInfoForViewerLayout> iterator2 = list.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            MultiPkUserInfoForViewerLayout next = iterator2.next();
            if (next.getPkAnchorModel() != null) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        if (size == 2) {
            p((View) arrayList.get(0), this.f15178g, this.f15177f);
            o((View) arrayList.get(1), this.f15181j.get(1));
            p((View) arrayList.get(1), this.f15178g, this.f15177f);
        } else {
            if (size != 3) {
                return;
            }
            p((View) arrayList.get(0), this.f15178g, this.f15177f);
            o((View) arrayList.get(1), this.f15181j.get(1));
            o((View) arrayList.get(2), this.f15181j.get(3));
        }
    }

    public final void F() {
        if (this.f15182k == null) {
            ZegoMediaSideInfo zegoMediaSideInfo = new ZegoMediaSideInfo();
            zegoMediaSideInfo.setZegoMediaSideCallback(new IZegoMediaSideCallback() { // from class: com.cupidapp.live.liveshow.pk.view.f
                @Override // com.zego.zegoavkit2.mediaside.IZegoMediaSideCallback
                public final void onRecvMediaSideInfo(String str, ByteBuffer byteBuffer, int i10) {
                    MultiPkForViewerLayout.G(MultiPkForViewerLayout.this, str, byteBuffer, i10);
                }
            });
            this.f15182k = zegoMediaSideInfo;
        }
    }

    public final void J(@NotNull String liveShowId) {
        s.i(liveShowId, "liveShowId");
        int i10 = 0;
        for (MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout : this.f15180i) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout2 = multiPkUserInfoForViewerLayout;
            MultiPkAnchorModel pkAnchorModel = multiPkUserInfoForViewerLayout2.getPkAnchorModel();
            if (s.d(pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null, liveShowId)) {
                multiPkUserInfoForViewerLayout2.o();
            }
            i10 = i11;
        }
    }

    public final void K(String str) {
        FKWebpAnimationView pk_start_animation = (FKWebpAnimationView) h(R$id.pk_start_animation);
        s.h(pk_start_animation, "pk_start_animation");
        if (pk_start_animation.getVisibility() == 0) {
            return;
        }
        int i10 = R$id.pk_moment_animation;
        ((FKSVGAImageView) h(i10)).setVisibility(0);
        FKSVGAImageView pk_moment_animation = (FKSVGAImageView) h(i10);
        s.h(pk_moment_animation, "pk_moment_animation");
        FKSVGAImageView.F(pk_moment_animation, str, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkForViewerLayout$showPkMomentAnimation$1
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
                ((FKSVGAImageView) MultiPkForViewerLayout.this.h(R$id.pk_moment_animation)).setVisibility(8);
            }
        }, 2, null);
    }

    public final void L(final boolean z10) {
        if (((FKSVGAImageView) h(R$id.pk_moment_animation)).k()) {
            return;
        }
        int i10 = R$id.pk_start_animation;
        ((FKWebpAnimationView) h(i10)).setVisibility(0);
        FKWebpAnimationView pk_start_animation = (FKWebpAnimationView) h(i10);
        s.h(pk_start_animation, "pk_start_animation");
        FKWebpAnimationView.d(pk_start_animation, "start_pk.webp", 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkForViewerLayout$showPkStartAnimation$1
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
                MultiPkForViewerLayout multiPkForViewerLayout = MultiPkForViewerLayout.this;
                int i11 = R$id.pk_start_animation;
                ((FKWebpAnimationView) multiPkForViewerLayout.h(i11)).i();
                ((FKWebpAnimationView) MultiPkForViewerLayout.this.h(i11)).setVisibility(8);
                if (z10) {
                    MultiPkForViewerLayout.this.K("first_blood.svga");
                }
            }
        }, 2, null);
    }

    public final void M() {
        if (this.f15184m == null) {
            ((TextView) h(R$id.pk_status_txt)).setText(v.j(this.f15185n));
            Observable<Long> observeOn = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkForViewerLayout$startCountDown$1
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
                    i10 = MultiPkForViewerLayout.this.f15185n;
                    if (i10 > 0) {
                        MultiPkForViewerLayout multiPkForViewerLayout = MultiPkForViewerLayout.this;
                        i13 = multiPkForViewerLayout.f15185n;
                        multiPkForViewerLayout.f15185n = i13 - 1;
                    }
                    i11 = MultiPkForViewerLayout.this.f15185n;
                    if (i11 == 30) {
                        MultiPkForViewerLayout.this.K("steal_tower.svga");
                    }
                    TextView textView = (TextView) MultiPkForViewerLayout.this.h(R$id.pk_status_txt);
                    i12 = MultiPkForViewerLayout.this.f15185n;
                    textView.setText(v.j(i12));
                }
            };
            this.f15184m = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.liveshow.pk.view.g
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MultiPkForViewerLayout.N(Function1.this, obj);
                }
            });
        }
    }

    public final void O(int i10, @Nullable String str, @Nullable String str2, boolean z10) {
        this.f15186o = MultiPersonPkState.PKing;
        this.f15187p = str;
        this.f15188q = str2;
        this.f15185n = i10;
        M();
        L(z10);
        int i11 = 0;
        for (MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout : this.f15180i) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            multiPkUserInfoForViewerLayout.l();
            i11 = i12;
        }
    }

    public final void P(@NotNull List<MultiPkResultModel> resultList) {
        MultiPkResultModel multiPkResultModel;
        s.i(resultList, "resultList");
        this.f15186o = MultiPersonPkState.PKInteract;
        ((TextView) h(R$id.pk_status_txt)).setText(getContext().getString(R$string.interacting));
        Q();
        int i10 = 0;
        for (MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout : this.f15180i) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout2 = multiPkUserInfoForViewerLayout;
            MultiPkAnchorModel pkAnchorModel = multiPkUserInfoForViewerLayout2.getPkAnchorModel();
            String str = null;
            String liveShowId = pkAnchorModel != null ? pkAnchorModel.getLiveShowId() : null;
            Iterator<MultiPkResultModel> iterator2 = resultList.iterator2();
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
            multiPkUserInfoForViewerLayout2.h(str);
            i10 = i11;
        }
    }

    public final void Q() {
        Disposable disposable = this.f15184m;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f15184m = null;
        this.f15185n = 0;
    }

    @Nullable
    public View h(int i10) {
        Map<Integer, View> map = this.f15189r;
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

    public final void i(@NotNull String liveShowId, @NotNull User user) {
        s.i(liveShowId, "liveShowId");
        s.i(user, "user");
        int i10 = 0;
        for (MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout : this.f15180i) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout2 = multiPkUserInfoForViewerLayout;
            if (multiPkUserInfoForViewerLayout2.getPkAnchorModel() == null) {
                multiPkUserInfoForViewerLayout2.i(new MultiPkAnchorModel(liveShowId, user, null, 4, null));
                return;
            }
            i10 = i11;
        }
    }

    public final void o(View view, Pair<Float, Float> pair) {
        if (view.getX() == pair.getFirst().floatValue()) {
            if (view.getY() == pair.getSecond().floatValue()) {
                return;
            }
        }
        view.setX(pair.getFirst().floatValue());
        view.setY(pair.getSecond().floatValue());
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q(false);
        ((FKWebpAnimationView) h(R$id.pk_start_animation)).i();
        ((FKSVGAImageView) h(R$id.pk_moment_animation)).K();
    }

    public final void p(View view, int i10, int i11) {
        if (view.getWidth() == i10 && view.getHeight() == i11) {
            return;
        }
        y.n(view, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public final void q(boolean z10) {
        Q();
        int i10 = 0;
        if (z10) {
            FKLiveUtil.J(FKLiveUtil.f14913a, this.f15183l, false, 2, null);
            i iVar = this.f15175d;
            if (iVar != null) {
                iVar.a();
            }
        }
        ZegoMediaSideInfo zegoMediaSideInfo = this.f15182k;
        if (zegoMediaSideInfo != null) {
            zegoMediaSideInfo.setZegoMediaSideCallback(null);
        }
        this.f15186o = MultiPersonPkState.PKEnd;
        this.f15183l = null;
        this.f15182k = null;
        for (MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout : this.f15180i) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            D(multiPkUserInfoForViewerLayout, i10);
            i10 = i11;
        }
        setVisibility(8);
    }

    public final void s(List<MultiPkAnchorModel> list) {
        int i10 = 0;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (MultiPkAnchorModel multiPkAnchorModel : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            this.f15180i.get(i10).i(multiPkAnchorModel);
            i10 = i11;
        }
    }

    public final void setMultiPkForViewerListener(@NotNull i listener) {
        s.i(listener, "listener");
        this.f15175d = listener;
    }

    public final int t(ByteBuffer byteBuffer, int i10) {
        if (i10 == 0) {
            return -1;
        }
        return (byteBuffer.get(3) & 255) | ((((((byteBuffer.get(0) & 255) << 24) | (byteBuffer.get(1) & 255)) << 16) | (byteBuffer.get(2) & 255)) << 8);
    }

    public final String u(String str, int i10) {
        String str2;
        String a10;
        if (this.f15188q == null || (str2 = this.f15187p) == null || (a10 = x.a(str2, "liveShowId", str)) == null) {
            return null;
        }
        String str3 = this.f15188q;
        s.f(str3);
        String a11 = x.a(a10, "pkPairId", str3);
        if (a11 != null) {
            return x.a(a11, "flag", String.valueOf(i10));
        }
        return null;
    }

    public final String v(ByteBuffer byteBuffer, int i10) {
        if (i10 == 0) {
            return "";
        }
        int i11 = i10 - 4;
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = byteBuffer.get(i12 + 4);
        }
        return new String(bArr, kotlin.text.c.f51097b);
    }

    public final void w() {
        z.a(this, R$layout.layout_multi_person_pk_for_viewer, true);
        setVisibility(8);
        this.f15176e = z0.h.l(this) - z0.h.c(this, 4.0f);
        int l10 = (int) ((z0.h.l(this) * 1.5555556f) / 2.0f);
        this.f15177f = l10;
        this.f15178g = (int) (this.f15176e / 2.0f);
        this.f15179h = (int) (l10 / 2.0f);
        RelativeLayout multi_pk_viewer_container_layout = (RelativeLayout) h(R$id.multi_pk_viewer_container_layout);
        s.h(multi_pk_viewer_container_layout, "multi_pk_viewer_container_layout");
        y.n(multi_pk_viewer_container_layout, Integer.valueOf(this.f15176e), Integer.valueOf(this.f15177f));
        int i10 = R$id.first_pk_anchor_layout;
        MultiPkUserInfoForViewerLayout first_pk_anchor_layout = (MultiPkUserInfoForViewerLayout) h(i10);
        s.h(first_pk_anchor_layout, "first_pk_anchor_layout");
        y.n(first_pk_anchor_layout, Integer.valueOf(this.f15178g), Integer.valueOf(this.f15179h));
        int i11 = R$id.second_pk_anchor_layout;
        MultiPkUserInfoForViewerLayout second_pk_anchor_layout = (MultiPkUserInfoForViewerLayout) h(i11);
        s.h(second_pk_anchor_layout, "second_pk_anchor_layout");
        y.n(second_pk_anchor_layout, Integer.valueOf(this.f15178g), Integer.valueOf(this.f15179h));
        int i12 = R$id.third_pk_anchor_layout;
        MultiPkUserInfoForViewerLayout third_pk_anchor_layout = (MultiPkUserInfoForViewerLayout) h(i12);
        s.h(third_pk_anchor_layout, "third_pk_anchor_layout");
        y.n(third_pk_anchor_layout, Integer.valueOf(this.f15178g), Integer.valueOf(this.f15179h));
        int i13 = R$id.fourth_pk_anchor_layout;
        MultiPkUserInfoForViewerLayout fourth_pk_anchor_layout = (MultiPkUserInfoForViewerLayout) h(i13);
        s.h(fourth_pk_anchor_layout, "fourth_pk_anchor_layout");
        y.n(fourth_pk_anchor_layout, Integer.valueOf(this.f15178g), Integer.valueOf(this.f15179h));
        List<Pair<Float, Float>> list = this.f15181j;
        Float valueOf = Float.valueOf(0.0f);
        list.add(new Pair<>(valueOf, valueOf));
        this.f15181j.add(new Pair<>(Float.valueOf(this.f15178g), valueOf));
        this.f15181j.add(new Pair<>(valueOf, Float.valueOf(this.f15179h)));
        this.f15181j.add(new Pair<>(Float.valueOf(this.f15178g), Float.valueOf(this.f15179h)));
        List<MultiPkUserInfoForViewerLayout> list2 = this.f15180i;
        MultiPkUserInfoForViewerLayout first_pk_anchor_layout2 = (MultiPkUserInfoForViewerLayout) h(i10);
        s.h(first_pk_anchor_layout2, "first_pk_anchor_layout");
        list2.add(first_pk_anchor_layout2);
        List<MultiPkUserInfoForViewerLayout> list3 = this.f15180i;
        MultiPkUserInfoForViewerLayout second_pk_anchor_layout2 = (MultiPkUserInfoForViewerLayout) h(i11);
        s.h(second_pk_anchor_layout2, "second_pk_anchor_layout");
        list3.add(second_pk_anchor_layout2);
        List<MultiPkUserInfoForViewerLayout> list4 = this.f15180i;
        MultiPkUserInfoForViewerLayout third_pk_anchor_layout2 = (MultiPkUserInfoForViewerLayout) h(i12);
        s.h(third_pk_anchor_layout2, "third_pk_anchor_layout");
        list4.add(third_pk_anchor_layout2);
        List<MultiPkUserInfoForViewerLayout> list5 = this.f15180i;
        MultiPkUserInfoForViewerLayout fourth_pk_anchor_layout2 = (MultiPkUserInfoForViewerLayout) h(i13);
        s.h(fourth_pk_anchor_layout2, "fourth_pk_anchor_layout");
        list5.add(fourth_pk_anchor_layout2);
        int i14 = 0;
        for (MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout : this.f15180i) {
            int i15 = i14 + 1;
            if (i14 < 0) {
                kotlin.collections.s.s();
            }
            final MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout2 = multiPkUserInfoForViewerLayout;
            multiPkUserInfoForViewerLayout2.setOpenPkRankCallback(new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkForViewerLayout$initView$1$1
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
                    int value;
                    String u10;
                    MultiPkAnchorModel pkAnchorModel = MultiPkUserInfoForViewerLayout.this.getPkAnchorModel();
                    if (pkAnchorModel != null) {
                        MultiPkForViewerLayout multiPkForViewerLayout = this;
                        String liveShowId = pkAnchorModel.getLiveShowId();
                        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                        if (s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null)) {
                            value = PkRankFlag.ViewMyAnchor.getValue();
                        } else {
                            value = PkRankFlag.ViewOthers.getValue();
                        }
                        EventBus c4 = EventBus.c();
                        u10 = multiPkForViewerLayout.u(pkAnchorModel.getLiveShowId(), value);
                        c4.l(new FKLiveOpenWebFragmentEvent(u10, true));
                    }
                }
            });
            o(multiPkUserInfoForViewerLayout2, this.f15181j.get(i14));
            i14 = i15;
        }
    }

    public final void x(@NotNull String liveShowId, boolean z10) {
        String str;
        MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout;
        String string;
        MultiPkAnchorModel pkAnchorModel;
        User user;
        s.i(liveShowId, "liveShowId");
        Iterator<MultiPkUserInfoForViewerLayout> iterator2 = this.f15180i.iterator2();
        while (true) {
            str = null;
            if (!iterator2.hasNext()) {
                multiPkUserInfoForViewerLayout = null;
                break;
            }
            multiPkUserInfoForViewerLayout = iterator2.next();
            MultiPkAnchorModel pkAnchorModel2 = multiPkUserInfoForViewerLayout.getPkAnchorModel();
            if (s.d(pkAnchorModel2 != null ? pkAnchorModel2.getLiveShowId() : null, liveShowId)) {
                break;
            }
        }
        MultiPkUserInfoForViewerLayout multiPkUserInfoForViewerLayout2 = multiPkUserInfoForViewerLayout;
        if (multiPkUserInfoForViewerLayout2 != null && (pkAnchorModel = multiPkUserInfoForViewerLayout2.getPkAnchorModel()) != null && (user = pkAnchorModel.getUser()) != null) {
            str = user.getName();
        }
        if (str != null) {
            if (z10) {
                string = getContext().getString(R$string.close_others_audio, str);
            } else {
                string = getContext().getString(R$string.open_others_audio, str);
            }
            s.h(string, "if (close) {\n           …udio, name)\n            }");
            com.cupidapp.live.base.view.h.f12779a.m(getContext(), string);
        }
    }

    public final void y(MultiPkInfoModel multiPkInfoModel) {
        String stage = multiPkInfoModel.getStage();
        MultiPersonPkState multiPersonPkState = MultiPersonPkState.PKPrepare;
        if (s.d(stage, multiPersonPkState.getValue())) {
            this.f15186o = multiPersonPkState;
            ((TextView) h(R$id.pk_status_txt)).setText(getContext().getString(R$string.prepare));
            return;
        }
        if (s.d(stage, MultiPersonPkState.PKing.getValue())) {
            Long startTimeMills = multiPkInfoModel.getStartTimeMills();
            int currentTimeMillis = (int) ((System.currentTimeMillis() - (startTimeMills != null ? startTimeMills.longValue() : System.currentTimeMillis())) / 1000);
            Integer countdownSeconds = multiPkInfoModel.getCountdownSeconds();
            int intValue = currentTimeMillis >= 0 ? (countdownSeconds != null ? countdownSeconds.intValue() : 0) - currentTimeMillis : 0;
            if (intValue <= 0) {
                intValue = 0;
            }
            O(intValue, multiPkInfoModel.getJumpUrl(), multiPkInfoModel.getPkPairId(), false);
            List<MultiPkAnchorInfoModel> anchors = multiPkInfoModel.getAnchors();
            ArrayList arrayList = new ArrayList(t.t(anchors, 10));
            Iterator<MultiPkAnchorInfoModel> iterator2 = anchors.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().getMultiPkRankModel());
            }
            B(new MultiPkScoreUpdateModel(arrayList, multiPkInfoModel.getShowBorder()));
            E();
            return;
        }
        if (s.d(stage, MultiPersonPkState.PKInteract.getValue())) {
            this.f15187p = multiPkInfoModel.getJumpUrl();
            this.f15188q = multiPkInfoModel.getPkPairId();
            List<MultiPkAnchorInfoModel> anchors2 = multiPkInfoModel.getAnchors();
            ArrayList arrayList2 = new ArrayList(t.t(anchors2, 10));
            Iterator<MultiPkAnchorInfoModel> iterator22 = anchors2.iterator2();
            while (iterator22.hasNext()) {
                arrayList2.add(iterator22.next().getMultiPkResultModel());
            }
            P(arrayList2);
            List<MultiPkAnchorInfoModel> anchors3 = multiPkInfoModel.getAnchors();
            ArrayList arrayList3 = new ArrayList(t.t(anchors3, 10));
            Iterator<MultiPkAnchorInfoModel> iterator23 = anchors3.iterator2();
            while (iterator23.hasNext()) {
                arrayList3.add(iterator23.next().getMultiPkRankModel());
            }
            B(new MultiPkScoreUpdateModel(arrayList3, multiPkInfoModel.getShowBorder()));
        }
    }

    public final void z(@Nullable MultiPkMixSuccessModel multiPkMixSuccessModel, @Nullable MultiPkInfoModel multiPkInfoModel) {
        ArrayList arrayList;
        setVisibility(0);
        if (multiPkMixSuccessModel != null) {
            this.f15186o = MultiPersonPkState.PKPrepare;
            ((TextView) h(R$id.pk_status_txt)).setText(getContext().getString(R$string.prepare));
            A(multiPkMixSuccessModel.getMixStreamId());
            List<MultiPkUserInfoModel> pkUsers = multiPkMixSuccessModel.getPkUsers();
            if (pkUsers != null) {
                arrayList = new ArrayList(t.t(pkUsers, 10));
                Iterator<MultiPkUserInfoModel> iterator2 = pkUsers.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(iterator2.next().getMultiPkAnchorModel());
                }
            } else {
                arrayList = null;
            }
            s(arrayList);
            return;
        }
        if (multiPkInfoModel != null) {
            A(multiPkInfoModel.getMixStreamId());
            List<MultiPkAnchorInfoModel> anchors = multiPkInfoModel.getAnchors();
            ArrayList arrayList2 = new ArrayList(t.t(anchors, 10));
            Iterator<MultiPkAnchorInfoModel> iterator22 = anchors.iterator2();
            while (iterator22.hasNext()) {
                arrayList2.add(iterator22.next().getMultiPkAnchorModel());
            }
            s(arrayList2);
            MultiPersonPkState multiPersonPkState = this.f15186o;
            if (multiPersonPkState != null) {
                s.f(multiPersonPkState);
                if (!s.d(multiPersonPkState.getValue(), multiPkInfoModel.getStage())) {
                    i iVar = this.f15175d;
                    if (iVar != null) {
                        iVar.b();
                        return;
                    }
                    return;
                }
            }
            y(multiPkInfoModel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkForViewerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15189r = new LinkedHashMap();
        this.f15180i = new ArrayList();
        this.f15181j = new ArrayList();
        w();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkForViewerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15189r = new LinkedHashMap();
        this.f15180i = new ArrayList();
        this.f15181j = new ArrayList();
        w();
    }
}
