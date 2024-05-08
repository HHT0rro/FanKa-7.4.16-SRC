package com.cupidapp.live.consult.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.g;
import z0.y;

/* compiled from: ConsultMiniProfileFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultMiniProfileFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f13774g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13776f = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public boolean f13775e = true;

    /* compiled from: ConsultMiniProfileFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager, @NotNull ShowConsultMiniProfileModel model) {
            s.i(model, "model");
            if (fragmentManager == null) {
                return;
            }
            ConsultMiniProfileFragment consultMiniProfileFragment = new ConsultMiniProfileFragment();
            Bundle bundle = new Bundle();
            g.d(bundle, model);
            consultMiniProfileFragment.setArguments(bundle);
            consultMiniProfileFragment.show(fragmentManager, ConsultMiniProfileFragment.class.getSimpleName());
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f13776f.clear();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public boolean P0() {
        return this.f13775e;
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13776f;
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

    public final void X0(final ShowConsultMiniProfileModel showConsultMiniProfileModel) {
        TextView consult_mini_profile_report_btn = (TextView) V0(R$id.consult_mini_profile_report_btn);
        s.h(consult_mini_profile_report_btn, "consult_mini_profile_report_btn");
        y.d(consult_mini_profile_report_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultMiniProfileFragment$bindClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                j.a.b(j.f12156c, this.getContext(), n0.f12353a.b(ShowConsultMiniProfileModel.this.getReportData(), SensorPosition.CONSULT_ROOM, ShowConsultMiniProfileModel.this.getUserId()), null, 4, null);
                this.dismiss();
            }
        });
        ImageView consult_mini_profile_close_btn = (ImageView) V0(R$id.consult_mini_profile_close_btn);
        s.h(consult_mini_profile_close_btn, "consult_mini_profile_close_btn");
        y.d(consult_mini_profile_close_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultMiniProfileFragment$bindClickEvent$2
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
                ConsultMiniProfileFragment.this.dismiss();
            }
        });
        FKUniversalButton consult_mini_profile_go_to_profile_btn = (FKUniversalButton) V0(R$id.consult_mini_profile_go_to_profile_btn);
        s.h(consult_mini_profile_go_to_profile_btn, "consult_mini_profile_go_to_profile_btn");
        y.d(consult_mini_profile_go_to_profile_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultMiniProfileFragment$bindClickEvent$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                String userProfileUrl = ShowConsultMiniProfileModel.this.getUserProfileUrl();
                if (userProfileUrl == null || userProfileUrl.length() == 0) {
                    this.Y0(ShowConsultMiniProfileModel.this.getUserId());
                } else {
                    j.a.b(j.f12156c, this.getContext(), ShowConsultMiniProfileModel.this.getUserProfileUrl(), null, 4, null);
                    this.dismiss();
                }
            }
        });
    }

    public final void Y0(String str) {
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultMiniProfileFragment$goToProfile$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2538invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2538invoke(ProfileResult profileResult) {
                ProfileResult profileResult2 = profileResult;
                UserProfileActivity.G.a(ConsultMiniProfileFragment.this.getContext(), profileResult2.getUser(), new ProfileSensorContext(ViewProfilePrefer.VoiceRoom.getValue(), null, profileResult2.getUser().getMe(), SensorPosition.CONSULT_ROOM, null, SensorScene.CONSULT_LIVE), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                ConsultMiniProfileFragment.this.dismiss();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void Z0(ShowConsultMiniProfileModel showConsultMiniProfileModel) {
        ImageLoaderView consult_mini_profile_avatar_img = (ImageLoaderView) V0(R$id.consult_mini_profile_avatar_img);
        s.h(consult_mini_profile_avatar_img, "consult_mini_profile_avatar_img");
        ImageLoaderView.g(consult_mini_profile_avatar_img, showConsultMiniProfileModel.getAvatarImage(), null, null, 6, null);
        ((TextView) V0(R$id.consult_mini_profile_name_text)).setText(showConsultMiniProfileModel.getName());
        ImageLoaderView consult_mini_profile_level_img = (ImageLoaderView) V0(R$id.consult_mini_profile_level_img);
        s.h(consult_mini_profile_level_img, "consult_mini_profile_level_img");
        ImageLoaderView.g(consult_mini_profile_level_img, showConsultMiniProfileModel.getLevelIcon(), null, null, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_consult_mini_profile, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BaseBottomSheetDialogFragment.S0(this, 3, false, 2, null);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        ShowConsultMiniProfileModel showConsultMiniProfileModel = arguments != null ? (ShowConsultMiniProfileModel) g.b(arguments, ShowConsultMiniProfileModel.class) : null;
        if (showConsultMiniProfileModel == null) {
            dismiss();
            return;
        }
        Z0(showConsultMiniProfileModel);
        X0(showConsultMiniProfileModel);
        GroupSocialLog.F(GroupSocialLog.f18708a, SensorScene.CONSULT_LIVE.getValue(), showConsultMiniProfileModel.getUserId(), null, false, false, 28, null);
    }
}
