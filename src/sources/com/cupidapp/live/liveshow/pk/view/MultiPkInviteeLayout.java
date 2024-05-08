package com.cupidapp.live.liveshow.pk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInviteStatus;
import com.cupidapp.live.liveshow.pk.model.MultiPkRankModel;
import com.cupidapp.live.liveshow.pk.view.l;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: MultiPkInviteeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkInviteeLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public d f15191d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15192e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public MultiPkAnchorModel f15193f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Disposable f15194g;

    /* renamed from: h, reason: collision with root package name */
    public int f15195h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15196i;

    /* compiled from: MultiPkInviteeLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements l {
        public a() {
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void a() {
            d dVar = MultiPkInviteeLayout.this.f15191d;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void b(boolean z10) {
            MultiPkInviteeLayout.this.u(z10);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.l
        public void c() {
            l.a.b(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkInviteeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15196i = new LinkedHashMap();
        t();
    }

    public static final void B(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void r(MultiPkInviteeLayout multiPkInviteeLayout, MultiPkAnchorModel multiPkAnchorModel, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        multiPkInviteeLayout.q(multiPkAnchorModel, i10);
    }

    public final void A() {
        if (this.f15194g == null) {
            ((TextView) f(R$id.cancel_invite_txt)).setText(getContext().getString(R$string.cancel_inviting_count_down, v.j(this.f15195h)));
            Observable<Long> observeOn = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkInviteeLayout$startCountDown$1
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
                    i10 = MultiPkInviteeLayout.this.f15195h;
                    if (i10 != 0) {
                        MultiPkInviteeLayout multiPkInviteeLayout = MultiPkInviteeLayout.this;
                        i12 = multiPkInviteeLayout.f15195h;
                        multiPkInviteeLayout.f15195h = i12 - 1;
                    } else {
                        MultiPkInviteeLayout.this.m(MultiPkInviteStatus.TimeOut);
                    }
                    TextView textView = (TextView) MultiPkInviteeLayout.this.f(R$id.cancel_invite_txt);
                    Context context = MultiPkInviteeLayout.this.getContext();
                    i11 = MultiPkInviteeLayout.this.f15195h;
                    textView.setText(context.getString(R$string.cancel_inviting_count_down, v.j(i11)));
                }
            };
            this.f15194g = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.liveshow.pk.view.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MultiPkInviteeLayout.B(Function1.this, obj);
                }
            });
        }
    }

    public final void C() {
        Disposable disposable = this.f15194g;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f15194g = null;
        this.f15195h = 0;
    }

    public final void D(@NotNull MultiPkRankModel scoreModel, boolean z10) {
        s.i(scoreModel, "scoreModel");
        MultiPkUserInfoLayout multiPkUserInfoLayout = (MultiPkUserInfoLayout) f(R$id.pk_user_info_layout);
        multiPkUserInfoLayout.o(scoreModel.getCredit(), scoreModel.getSort(), z10);
        multiPkUserInfoLayout.l(scoreModel.getList());
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f15196i;
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
    public final MultiPkAnchorModel getPkAnchorModel() {
        return this.f15193f;
    }

    public final void m(final MultiPkInviteStatus multiPkInviteStatus) {
        String itemId;
        MultiPkAnchorModel multiPkAnchorModel;
        String liveShowId;
        MultiPkAnchorModel multiPkAnchorModel2;
        String pkPrepareId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || (multiPkAnchorModel = this.f15193f) == null || (liveShowId = multiPkAnchorModel.getLiveShowId()) == null || (multiPkAnchorModel2 = this.f15193f) == null || (pkPrepareId = multiPkAnchorModel2.getPkPrepareId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().N0(itemId, liveShowId, pkPrepareId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkInviteeLayout$cancelInvitation$$inlined$handle$default$1
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
                d dVar = MultiPkInviteeLayout.this.f15191d;
                if (dVar != null) {
                    dVar.d(multiPkInviteStatus);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void o() {
        int i10 = R$id.pk_user_info_layout;
        ((MultiPkUserInfoLayout) f(i10)).t();
        ((MultiPkUserInfoLayout) f(i10)).setVisibility(8);
        ((TextureView) f(R$id.pk_invitee_texture)).setVisibility(8);
        f(R$id.pk_texture_bg).setVisibility(0);
        ((ConstraintLayout) f(R$id.invitee_info_layout)).setVisibility(8);
        ((LinearLayout) f(R$id.invite_anchor_layout)).setVisibility(this.f15192e ? 0 : 8);
        ((TextView) f(R$id.waiting_txt)).setVisibility(this.f15192e ? 8 : 0);
    }

    public final void p(User user, int i10) {
        ((ConstraintLayout) f(R$id.invitee_info_layout)).setVisibility(0);
        ImageLoaderView pk_invitee_avatar_img = (ImageLoaderView) f(R$id.pk_invitee_avatar_img);
        s.h(pk_invitee_avatar_img, "pk_invitee_avatar_img");
        ImageLoaderView.g(pk_invitee_avatar_img, user.getAvatarImage(), null, null, 6, null);
        ((TextView) f(R$id.pk_invitee_name_txt)).setText(user.getName());
        ((TextView) f(R$id.cancel_invite_txt)).setVisibility(this.f15192e ? 0 : 8);
        ((TextView) f(R$id.wait_invite_txt)).setVisibility(this.f15192e ? 8 : 0);
        if (this.f15192e) {
            this.f15195h = i10;
            A();
        }
    }

    public final void q(@Nullable MultiPkAnchorModel multiPkAnchorModel, int i10) {
        this.f15193f = multiPkAnchorModel;
        if (multiPkAnchorModel == null) {
            o();
            if (this.f15192e) {
                C();
                return;
            }
            return;
        }
        ((LinearLayout) f(R$id.invite_anchor_layout)).setVisibility(8);
        ((TextView) f(R$id.waiting_txt)).setVisibility(8);
        if (multiPkAnchorModel.hasStream()) {
            String pkStreamId = multiPkAnchorModel.getPkStreamId();
            s.f(pkStreamId);
            v(pkStreamId);
            return;
        }
        p(multiPkAnchorModel.getUser(), i10);
    }

    public final void s(@Nullable String str) {
        ((MultiPkUserInfoLayout) f(R$id.pk_user_info_layout)).m(str);
    }

    public final void setIsInitiator(boolean z10) {
        this.f15192e = z10;
        o();
    }

    public final void setMultiPkInviteeListener(@NotNull d listener) {
        s.i(listener, "listener");
        this.f15191d = listener;
    }

    public final void setPkAnchorModel(@Nullable MultiPkAnchorModel multiPkAnchorModel) {
        this.f15193f = multiPkAnchorModel;
    }

    public final void t() {
        z.a(this, R$layout.layout_multi_person_pk_invitee, true);
        TextView waiting_txt = (TextView) f(R$id.waiting_txt);
        s.h(waiting_txt, "waiting_txt");
        u.a(waiting_txt);
        LinearLayout invite_anchor_layout = (LinearLayout) f(R$id.invite_anchor_layout);
        s.h(invite_anchor_layout, "invite_anchor_layout");
        y.d(invite_anchor_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkInviteeLayout$initView$1
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
                d dVar = MultiPkInviteeLayout.this.f15191d;
                if (dVar != null) {
                    dVar.b();
                }
            }
        });
        TextView cancel_invite_txt = (TextView) f(R$id.cancel_invite_txt);
        s.h(cancel_invite_txt, "cancel_invite_txt");
        y.d(cancel_invite_txt, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkInviteeLayout$initView$2
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
                MultiPkInviteeLayout.this.m(MultiPkInviteStatus.None);
            }
        });
        ((MultiPkUserInfoLayout) f(R$id.pk_user_info_layout)).setPkInfoListener(new a());
    }

    public final void u(final boolean z10) {
        String itemId;
        MultiPkAnchorModel multiPkAnchorModel;
        String liveShowId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || (multiPkAnchorModel = this.f15193f) == null || (liveShowId = multiPkAnchorModel.getLiveShowId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().L(itemId, liveShowId, z10).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkInviteeLayout$mutePkUer$$inlined$handle$default$1
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
                String pkStreamId;
                d dVar = MultiPkInviteeLayout.this.f15191d;
                if (dVar != null) {
                    dVar.c(z10);
                }
                ((MultiPkUserInfoLayout) MultiPkInviteeLayout.this.f(R$id.pk_user_info_layout)).setPkHornSelect(z10);
                MultiPkAnchorModel pkAnchorModel = MultiPkInviteeLayout.this.getPkAnchorModel();
                if (pkAnchorModel != null && (pkStreamId = pkAnchorModel.getPkStreamId()) != null) {
                    FKLiveUtil.f14913a.w(z10, pkStreamId);
                }
                MultiPkInviteeLayout.this.z(z10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void v(@NotNull String pkStreamId) {
        User user;
        s.i(pkStreamId, "pkStreamId");
        MultiPkAnchorModel multiPkAnchorModel = this.f15193f;
        if (multiPkAnchorModel != null) {
            multiPkAnchorModel.setPkStreamId(pkStreamId);
        }
        if (this.f15192e) {
            C();
        }
        f(R$id.pk_texture_bg).setVisibility(8);
        ((ConstraintLayout) f(R$id.invitee_info_layout)).setVisibility(8);
        int i10 = R$id.pk_invitee_texture;
        ((TextureView) f(i10)).setVisibility(0);
        int i11 = R$id.pk_user_info_layout;
        ((MultiPkUserInfoLayout) f(i11)).setVisibility(0);
        MultiPkAnchorModel multiPkAnchorModel2 = this.f15193f;
        if (multiPkAnchorModel2 != null && (user = multiPkAnchorModel2.getUser()) != null) {
            MultiPkUserInfoLayout pk_user_info_layout = (MultiPkUserInfoLayout) f(i11);
            s.h(pk_user_info_layout, "pk_user_info_layout");
            MultiPkUserInfoLayout.q(pk_user_info_layout, user, false, 2, null);
        }
        FKLiveUtil.D(FKLiveUtil.f14913a, pkStreamId, (TextureView) f(i10), null, null, 12, null);
    }

    public final void w() {
        MultiPkAnchorModel multiPkAnchorModel = this.f15193f;
        if (multiPkAnchorModel != null && multiPkAnchorModel.hasStream()) {
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            MultiPkAnchorModel multiPkAnchorModel2 = this.f15193f;
            s.f(multiPkAnchorModel2);
            FKLiveUtil.J(fKLiveUtil, multiPkAnchorModel2.getPkStreamId(), false, 2, null);
        }
        r(this, null, 0, 2, null);
    }

    public final void x() {
        ((MultiPkUserInfoLayout) f(R$id.pk_user_info_layout)).t();
    }

    public final void y() {
        ((MultiPkUserInfoLayout) f(R$id.pk_user_info_layout)).u();
    }

    public final void z(boolean z10) {
        User user;
        User user2;
        String str = null;
        if (z10) {
            com.cupidapp.live.base.view.h hVar = com.cupidapp.live.base.view.h.f12779a;
            Context context = getContext();
            Context context2 = getContext();
            Object[] objArr = new Object[1];
            MultiPkAnchorModel multiPkAnchorModel = this.f15193f;
            if (multiPkAnchorModel != null && (user2 = multiPkAnchorModel.getUser()) != null) {
                str = user2.getName();
            }
            objArr[0] = str;
            hVar.m(context, context2.getString(R$string.has_close_others_volume, objArr));
            return;
        }
        com.cupidapp.live.base.view.h hVar2 = com.cupidapp.live.base.view.h.f12779a;
        Context context3 = getContext();
        Context context4 = getContext();
        Object[] objArr2 = new Object[1];
        MultiPkAnchorModel multiPkAnchorModel2 = this.f15193f;
        if (multiPkAnchorModel2 != null && (user = multiPkAnchorModel2.getUser()) != null) {
            str = user.getName();
        }
        objArr2[0] = str;
        hVar2.m(context3, context4.getString(R$string.has_open_others_volume, objArr2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkInviteeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15196i = new LinkedHashMap();
        t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkInviteeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15196i = new LinkedHashMap();
        t();
    }
}
