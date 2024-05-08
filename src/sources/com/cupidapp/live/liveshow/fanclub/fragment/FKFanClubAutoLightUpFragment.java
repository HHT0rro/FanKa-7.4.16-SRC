package com.cupidapp.live.liveshow.fanclub.fragment;

import android.app.Dialog;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubMemberDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubResult;
import com.cupidapp.live.liveshow.fanclub.view.FKFanClubMedalLayout;
import com.cupidapp.live.liveshow.fanclub.view.FKFanClubMedalModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.r;
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

/* compiled from: FKFanClubAutoLightUpFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubAutoLightUpFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f14961h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f14962e;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14964g = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f14963f = c.b(new Function0<FKFanClubResult>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubAutoLightUpFragment$clubResult$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final FKFanClubResult invoke() {
            Bundle arguments = FKFanClubAutoLightUpFragment.this.getArguments();
            if (arguments != null) {
                return (FKFanClubResult) g.b(arguments, FKFanClubResult.class);
            }
            return null;
        }
    });

    /* compiled from: FKFanClubAutoLightUpFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKFanClubAutoLightUpFragment a(@Nullable FragmentManager fragmentManager, @Nullable FKFanClubResult fKFanClubResult, @NotNull b listener) {
            s.i(listener, "listener");
            if (fragmentManager == null) {
                return null;
            }
            FKFanClubAutoLightUpFragment fKFanClubAutoLightUpFragment = new FKFanClubAutoLightUpFragment();
            Bundle bundle = new Bundle();
            if (fKFanClubResult != null) {
                g.d(bundle, fKFanClubResult);
            }
            fKFanClubAutoLightUpFragment.setArguments(bundle);
            fKFanClubAutoLightUpFragment.f14962e = listener;
            fKFanClubAutoLightUpFragment.show(fragmentManager, FKFanClubAutoLightUpFragment.class.getSimpleName());
            return fKFanClubAutoLightUpFragment;
        }
    }

    /* compiled from: FKFanClubAutoLightUpFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(boolean z10);
    }

    public static final void Z0(FKFanClubAutoLightUpFragment this$0, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        if (compoundButton.isPressed()) {
            if (z10) {
                ((CheckBox) this$0.W0(R$id.lightUpCheckBox)).setChecked(false);
                b bVar = this$0.f14962e;
                if (bVar != null) {
                    bVar.a(true);
                    return;
                }
                return;
            }
            b bVar2 = this$0.f14962e;
            if (bVar2 != null) {
                bVar2.a(false);
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f14964g.clear();
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14964g;
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

    public final void Y0() {
        ImageView fanClubLightUpBackView = (ImageView) W0(R$id.fanClubLightUpBackView);
        s.h(fanClubLightUpBackView, "fanClubLightUpBackView");
        y.d(fanClubLightUpBackView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubAutoLightUpFragment$bindClickEvent$1
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
                FKFanClubAutoLightUpFragment.this.dismiss();
            }
        });
        ((CheckBox) W0(R$id.lightUpCheckBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.liveshow.fanclub.fragment.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                FKFanClubAutoLightUpFragment.Z0(FKFanClubAutoLightUpFragment.this, compoundButton, z10);
            }
        });
    }

    public final void a1(boolean z10) {
        ConstraintLayout lightUpFanClubInfoLayout = (ConstraintLayout) W0(R$id.lightUpFanClubInfoLayout);
        s.h(lightUpFanClubInfoLayout, "lightUpFanClubInfoLayout");
        y.i(lightUpFanClubInfoLayout, (r18 & 1) != 0 ? 0.0f : h.c(this, 12.0f), z10 ? kotlin.collections.s.m(-50851, -23207) : r.e(-1973791), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        ((TextView) W0(R$id.lightUpClubNameTextView)).setTextColor(z10 ? -1 : -15066598);
    }

    public final FKFanClubResult b1() {
        return (FKFanClubResult) this.f14963f.getValue();
    }

    public final void c1() {
        FKFanClubMemberDataModel profile;
        FKFanClubDataModel club;
        FKFanClubDataModel club2;
        ImageLoaderView lightUpAnchorAvatarImageView = (ImageLoaderView) W0(R$id.lightUpAnchorAvatarImageView);
        s.h(lightUpAnchorAvatarImageView, "lightUpAnchorAvatarImageView");
        FKFanClubResult b12 = b1();
        String str = null;
        ImageLoaderView.g(lightUpAnchorAvatarImageView, (b12 == null || (club2 = b12.getClub()) == null) ? null : club2.getIconImage(), null, null, 6, null);
        TextView textView = (TextView) W0(R$id.lightUpClubNameTextView);
        FKFanClubResult b13 = b1();
        if (b13 != null && (club = b13.getClub()) != null) {
            str = club.getTitle();
        }
        textView.setText(str);
        FKFanClubResult b14 = b1();
        if (b14 == null || (profile = b14.getProfile()) == null) {
            return;
        }
        ((FKFanClubMedalLayout) W0(R$id.lightUpMedalImageView)).b(new FKFanClubMedalModel(profile.getLevel(), profile.getBadgeName(), profile.getBadgeIcon(), profile.getBadgeBgColor()));
        d1(profile.getAutoLightUp());
        a1(profile.getAutoLightUp());
    }

    public final void d1(boolean z10) {
        ((CheckBox) W0(R$id.lightUpCheckBox)).setChecked(z10);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_fan_club_auto_light_up, viewGroup, false);
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
        ConstraintLayout fanClubAutoLightUpLayout = (ConstraintLayout) W0(R$id.fanClubAutoLightUpLayout);
        s.h(fanClubAutoLightUpLayout, "fanClubAutoLightUpLayout");
        y.o(fanClubAutoLightUpLayout, null, Integer.valueOf((h.k(this) / 3) * 2), 1, null);
        c1();
        Y0();
    }
}
