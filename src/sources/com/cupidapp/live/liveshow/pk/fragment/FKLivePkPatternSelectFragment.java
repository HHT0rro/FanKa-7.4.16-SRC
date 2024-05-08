package com.cupidapp.live.liveshow.pk.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.BubbleGuideModel;
import com.cupidapp.live.base.view.FKPopupWindowBubbleGuideView;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.model.LivePkCenterResult;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment;
import com.google.android.material.badge.BadgeDrawable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.m;
import z0.y;

/* compiled from: FKLivePkPatternSelectFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkPatternSelectFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f15122i = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f15123e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public FKPopupWindowBubbleGuideView f15124f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f15125g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15126h = new LinkedHashMap();

    /* compiled from: FKLivePkPatternSelectFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKLivePkPatternSelectFragment a(@Nullable FragmentManager fragmentManager, @NotNull b selectListener) {
            s.i(selectListener, "selectListener");
            if (fragmentManager == null) {
                return null;
            }
            FKLivePkPatternSelectFragment fKLivePkPatternSelectFragment = new FKLivePkPatternSelectFragment();
            fKLivePkPatternSelectFragment.f15123e = selectListener;
            fKLivePkPatternSelectFragment.show(fragmentManager, FKLivePkPatternSelectFragment.class.getSimpleName());
            return fKLivePkPatternSelectFragment;
        }
    }

    /* compiled from: FKLivePkPatternSelectFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a();

        void b();

        void c();
    }

    public static final void g1(FKLivePkPatternSelectFragment this$0) {
        s.i(this$0, "this$0");
        int[] iArr = new int[2];
        int i10 = R$id.hoToPlayButton;
        ((TextView) this$0.W0(i10)).getLocationInWindow(iArr);
        Context context = this$0.getContext();
        if (context != null) {
            FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = new FKPopupWindowBubbleGuideView(context);
            this$0.f15124f = fKPopupWindowBubbleGuideView;
            fKPopupWindowBubbleGuideView.c(new BubbleGuideModel(null, 0, Integer.valueOf(R$mipmap.icon_live_pk_how_to_play_guide), 0, 11, null));
            int c4 = h.c(this$0, 6.0f);
            int height = iArr[1] - ((TextView) this$0.W0(i10)).getHeight();
            FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView2 = this$0.f15124f;
            if (fKPopupWindowBubbleGuideView2 != null) {
                TextView hoToPlayButton = (TextView) this$0.W0(i10);
                s.h(hoToPlayButton, "hoToPlayButton");
                fKPopupWindowBubbleGuideView2.e(hoToPlayButton, BadgeDrawable.TOP_END, c4, height, (r17 & 16) != 0 ? null : 2, (r17 & 32) != 0 ? false : false, (r17 & 64) != 0 ? false : false);
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15126h.clear();
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15126h;
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

    public final void c1() {
        LinearLayout randomMatchLayout = (LinearLayout) W0(R$id.randomMatchLayout);
        s.h(randomMatchLayout, "randomMatchLayout");
        y.d(randomMatchLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment$bindClickEvent$1
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
                FKLivePkPatternSelectFragment.b bVar;
                SensorsLogLiveShow.f12212a.r(SensorsLogLiveShow.PkRequestType.RandomPkMatch);
                FKLivePkPatternSelectFragment.this.dismiss();
                bVar = FKLivePkPatternSelectFragment.this.f15123e;
                if (bVar != null) {
                    bVar.b();
                }
            }
        });
        LinearLayout inviteFriendsLayout = (LinearLayout) W0(R$id.inviteFriendsLayout);
        s.h(inviteFriendsLayout, "inviteFriendsLayout");
        y.d(inviteFriendsLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment$bindClickEvent$2
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
                FKLivePkPatternSelectFragment.b bVar;
                FKLivePkPatternSelectFragment.this.dismiss();
                bVar = FKLivePkPatternSelectFragment.this.f15123e;
                if (bVar != null) {
                    bVar.c();
                }
            }
        });
        TextView hoToPlayButton = (TextView) W0(R$id.hoToPlayButton);
        s.h(hoToPlayButton, "hoToPlayButton");
        y.d(hoToPlayButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment$bindClickEvent$3
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
                String str;
                str = FKLivePkPatternSelectFragment.this.f15125g;
                if (str != null) {
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(str, true));
                }
            }
        });
        LinearLayout multi_person_pk_layout = (LinearLayout) W0(R$id.multi_person_pk_layout);
        s.h(multi_person_pk_layout, "multi_person_pk_layout");
        y.d(multi_person_pk_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment$bindClickEvent$4
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
                FKLivePkPatternSelectFragment.b bVar;
                FKLivePkPatternSelectFragment.this.dismiss();
                bVar = FKLivePkPatternSelectFragment.this.f15123e;
                if (bVar != null) {
                    bVar.a();
                }
                SensorsLogLiveShow.f12212a.r(SensorsLogLiveShow.PkRequestType.MultiPk);
            }
        });
    }

    public final void d1(int i10, TextView textView) {
        String string = getString(R$string.number_of_match_pool);
        s.h(string, "getString(R.string.number_of_match_pool)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5658199), 0, string.length(), 33);
        spannableStringBuilder.append((CharSequence) m.d(i10));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-53457), string.length(), spannableStringBuilder.length(), 33);
        textView.setText(spannableStringBuilder);
    }

    public final void e1() {
        Disposable disposed = NetworkClient.f11868a.r().O0().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LivePkCenterResult, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment$getLivePkInfo$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LivePkCenterResult livePkCenterResult) {
                m2628invoke(livePkCenterResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2628invoke(LivePkCenterResult livePkCenterResult) {
                LivePkCenterResult livePkCenterResult2 = livePkCenterResult;
                FKLivePkPatternSelectFragment.this.f15125g = livePkCenterResult2.getPkRulePath();
                FKLivePkPatternSelectFragment fKLivePkPatternSelectFragment = FKLivePkPatternSelectFragment.this;
                int pkRequestCount = livePkCenterResult2.getPkRequestCount();
                TextView randomMatchTextView = (TextView) FKLivePkPatternSelectFragment.this.W0(R$id.randomMatchTextView);
                s.h(randomMatchTextView, "randomMatchTextView");
                fKLivePkPatternSelectFragment.d1(pkRequestCount, randomMatchTextView);
                FKLivePkPatternSelectFragment fKLivePkPatternSelectFragment2 = FKLivePkPatternSelectFragment.this;
                int onlineLiveFriendCount = livePkCenterResult2.getOnlineLiveFriendCount();
                TextView inviteFriendsTextView = (TextView) FKLivePkPatternSelectFragment.this.W0(R$id.inviteFriendsTextView);
                s.h(inviteFriendsTextView, "inviteFriendsTextView");
                fKLivePkPatternSelectFragment2.d1(onlineLiveFriendCount, inviteFriendsTextView);
                if (s.d(livePkCenterResult2.getMultiplayerSwitch(), Boolean.FALSE)) {
                    ((LinearLayout) FKLivePkPatternSelectFragment.this.W0(R$id.multi_person_pk_layout)).setVisibility(8);
                    LinearLayout randomMatchLayout = (LinearLayout) FKLivePkPatternSelectFragment.this.W0(R$id.randomMatchLayout);
                    s.h(randomMatchLayout, "randomMatchLayout");
                    y.m(randomMatchLayout, null, null, Integer.valueOf(h.c(FKLivePkPatternSelectFragment.this, 22.0f)), null, 11, null);
                    LinearLayout inviteFriendsLayout = (LinearLayout) FKLivePkPatternSelectFragment.this.W0(R$id.inviteFriendsLayout);
                    s.h(inviteFriendsLayout, "inviteFriendsLayout");
                    y.m(inviteFriendsLayout, Integer.valueOf(h.c(FKLivePkPatternSelectFragment.this, 22.0f)), null, null, null, 14, null);
                    return;
                }
                ((LinearLayout) FKLivePkPatternSelectFragment.this.W0(R$id.multi_person_pk_layout)).setVisibility(0);
                FKLivePkPatternSelectFragment fKLivePkPatternSelectFragment3 = FKLivePkPatternSelectFragment.this;
                int onlineLiveShowCount = livePkCenterResult2.getOnlineLiveShowCount();
                TextView multi_person_pk_count_txt = (TextView) FKLivePkPatternSelectFragment.this.W0(R$id.multi_person_pk_count_txt);
                s.h(multi_person_pk_count_txt, "multi_person_pk_count_txt");
                fKLivePkPatternSelectFragment3.d1(onlineLiveShowCount, multi_person_pk_count_txt);
                LinearLayout randomMatchLayout2 = (LinearLayout) FKLivePkPatternSelectFragment.this.W0(R$id.randomMatchLayout);
                s.h(randomMatchLayout2, "randomMatchLayout");
                y.m(randomMatchLayout2, null, null, Integer.valueOf(h.c(FKLivePkPatternSelectFragment.this, 6.0f)), null, 11, null);
                LinearLayout inviteFriendsLayout2 = (LinearLayout) FKLivePkPatternSelectFragment.this.W0(R$id.inviteFriendsLayout);
                s.h(inviteFriendsLayout2, "inviteFriendsLayout");
                y.m(inviteFriendsLayout2, Integer.valueOf(h.c(FKLivePkPatternSelectFragment.this, 6.0f)), null, null, null, 14, null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void f1() {
        g gVar = g.f52734a;
        Boolean c4 = gVar.c1().c();
        Boolean bool = Boolean.TRUE;
        if (s.d(c4, bool)) {
            return;
        }
        gVar.c1().d(bool);
        ((TextView) W0(R$id.hoToPlayButton)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.pk.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                FKLivePkPatternSelectFragment.g1(FKLivePkPatternSelectFragment.this);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_pk_pattern_select, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = this.f15124f;
        if (fKPopupWindowBubbleGuideView != null) {
            fKPopupWindowBubbleGuideView.g();
        }
        this.f15124f = null;
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
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        f1();
        c1();
        e1();
    }
}
