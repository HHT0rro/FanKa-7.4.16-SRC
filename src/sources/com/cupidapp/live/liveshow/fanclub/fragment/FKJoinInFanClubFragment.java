package com.cupidapp.live.liveshow.fanclub.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubDataModel;
import com.cupidapp.live.liveshow.model.GiftModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.y;

/* compiled from: FKJoinInFanClubFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKJoinInFanClubFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f14978h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f14979e;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14981g = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f14980f = c.b(new Function0<FKFanClubDataModel>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment$fanClubModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final FKFanClubDataModel invoke() {
            Bundle arguments = FKJoinInFanClubFragment.this.getArguments();
            if (arguments != null) {
                return (FKFanClubDataModel) g.b(arguments, FKFanClubDataModel.class);
            }
            return null;
        }
    });

    /* compiled from: FKJoinInFanClubFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKJoinInFanClubFragment a(@Nullable FragmentManager fragmentManager, @Nullable FKFanClubDataModel fKFanClubDataModel, @NotNull b listener) {
            s.i(listener, "listener");
            if (fragmentManager == null) {
                return null;
            }
            FKJoinInFanClubFragment fKJoinInFanClubFragment = new FKJoinInFanClubFragment();
            Bundle bundle = new Bundle();
            if (fKFanClubDataModel != null) {
                g.d(bundle, fKFanClubDataModel);
            }
            fKJoinInFanClubFragment.setArguments(bundle);
            fKJoinInFanClubFragment.f14979e = listener;
            fKJoinInFanClubFragment.show(fragmentManager, FKJoinInFanClubFragment.class.getSimpleName());
            return fKJoinInFanClubFragment;
        }
    }

    /* compiled from: FKJoinInFanClubFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(@NotNull GiftModel giftModel);

        void b();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f14981g.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14981g;
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

    public final void Z0() {
        ImageView fanClubRuleImageView = (ImageView) V0(R$id.fanClubRuleImageView);
        s.h(fanClubRuleImageView, "fanClubRuleImageView");
        y.d(fanClubRuleImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment$bindClickEvent$1
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
                FKFanClubDataModel a12;
                EventBus c4 = EventBus.c();
                a12 = FKJoinInFanClubFragment.this.a1();
                c4.l(new FKLiveOpenWebFragmentEvent(a12 != null ? a12.getDescRuleUrl() : null, true));
            }
        });
        TextView fanClubMemberTextView = (TextView) V0(R$id.fanClubMemberTextView);
        s.h(fanClubMemberTextView, "fanClubMemberTextView");
        y.d(fanClubMemberTextView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment$bindClickEvent$2
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
                FKFanClubDataModel a12;
                FKJoinInFanClubFragment.b bVar;
                a12 = FKJoinInFanClubFragment.this.a1();
                if (a12 != null) {
                    FKJoinInFanClubFragment fKJoinInFanClubFragment = FKJoinInFanClubFragment.this;
                    if (a12.getMemberCount() > 0) {
                        bVar = fKJoinInFanClubFragment.f14979e;
                        if (bVar != null) {
                            bVar.b();
                            return;
                        }
                        return;
                    }
                    h.f12779a.r(fKJoinInFanClubFragment.getContext(), R$string.no_member_prompt);
                }
            }
        });
        LinearLayout joinInFanClubLayout = (LinearLayout) V0(R$id.joinInFanClubLayout);
        s.h(joinInFanClubLayout, "joinInFanClubLayout");
        y.d(joinInFanClubLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
            
                r0 = r3.this$0.f14979e;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r4) {
                /*
                    r3 = this;
                    com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment r4 = com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment.this
                    com.cupidapp.live.liveshow.fanclub.model.FKFanClubDataModel r4 = com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment.W0(r4)
                    if (r4 == 0) goto L19
                    com.cupidapp.live.liveshow.model.GiftModel r4 = r4.getJoinGift()
                    if (r4 == 0) goto L19
                    com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment r0 = com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment.this
                    com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment$b r0 = com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment.X0(r0)
                    if (r0 == 0) goto L19
                    r0.a(r4)
                L19:
                    j1.i r4 = j1.i.f50236a
                    com.cupidapp.live.base.sensorslog.PopupName r0 = com.cupidapp.live.base.sensorslog.PopupName.FANS_GROUP
                    com.cupidapp.live.base.sensorslog.PopupButtonName r1 = com.cupidapp.live.base.sensorslog.PopupButtonName.JoinFanClub
                    com.cupidapp.live.base.sensorslog.SensorPosition r2 = com.cupidapp.live.base.sensorslog.SensorPosition.LiveShowRoom
                    r4.a(r0, r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment$bindClickEvent$3.invoke2(android.view.View):void");
            }
        });
    }

    public final FKFanClubDataModel a1() {
        return (FKFanClubDataModel) this.f14980f.getValue();
    }

    public final void b1() {
        FKFanClubDataModel a12 = a1();
        if (a12 != null) {
            ImageLoaderView anchorAvatarImageView = (ImageLoaderView) V0(R$id.anchorAvatarImageView);
            s.h(anchorAvatarImageView, "anchorAvatarImageView");
            ImageLoaderView.g(anchorAvatarImageView, a12.getIconImage(), null, null, 6, null);
            ((TextView) V0(R$id.fanClubNameTextView)).setText(a12.getTitle());
            ((TextView) V0(R$id.fanClubMemberTextView)).setText(getString(R$string.club_member, a12.getMemberCountFormatted()));
            ImageLoaderView fanClubGiftImageView = (ImageLoaderView) V0(R$id.fanClubGiftImageView);
            s.h(fanClubGiftImageView, "fanClubGiftImageView");
            ImageLoaderView.g(fanClubGiftImageView, a12.getJoinGift().getImage(), null, null, 6, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_join_in_fan_club, viewGroup, false);
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
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        b1();
        Z0();
    }
}
