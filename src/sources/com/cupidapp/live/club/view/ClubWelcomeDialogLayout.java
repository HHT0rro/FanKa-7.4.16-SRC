package com.cupidapp.live.club.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.club.model.ClubWelcomeConfirmModel;
import com.cupidapp.live.club.model.ClubWelcomeLevelBenefitModel;
import com.cupidapp.live.club.view.ClubWelcomeDialogLayout;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.y;
import z0.z;

/* compiled from: ClubWelcomeDialogLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubWelcomeDialogLayout extends BaseLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final Companion f13647f = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function0<p> f13648d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13649e;

    /* compiled from: ClubWelcomeDialogLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void c(SensorPosition position, DialogInterface dialogInterface) {
            s.i(position, "$position");
            j1.i.g(j1.i.f50236a, PopupName.CLUB_SHOULD_KNOW, position, null, 4, null);
        }

        public final void b(@NotNull Context context, @NotNull String clubId, @NotNull ClubWelcomeConfirmModel model, @NotNull final SensorPosition position, @NotNull final Function0<p> unlockChatCallback) {
            s.i(context, "context");
            s.i(clubId, "clubId");
            s.i(model, "model");
            s.i(position, "position");
            s.i(unlockChatCallback, "unlockChatCallback");
            ClubWelcomeDialogLayout clubWelcomeDialogLayout = new ClubWelcomeDialogLayout(context);
            final AlertDialog create = z0.b.f54812a.e(context).setView(clubWelcomeDialogLayout).create();
            clubWelcomeDialogLayout.setMUnlockChatCallback(new Function0<p>() { // from class: com.cupidapp.live.club.view.ClubWelcomeDialogLayout$Companion$show$1
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
                    create.dismiss();
                    unlockChatCallback.invoke();
                }
            });
            clubWelcomeDialogLayout.g(clubId, model, position);
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.club.view.j
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ClubWelcomeDialogLayout.Companion.c(SensorPosition.this, dialogInterface);
                }
            });
            create.show();
            Window window = create.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setWindowAnimations(R$style.dialog_translate_anim);
                window.setLayout(-1, -2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubWelcomeDialogLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13649e = new LinkedHashMap();
        k();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f13649e;
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

    public final void g(@NotNull String clubId, @NotNull ClubWelcomeConfirmModel model, @NotNull SensorPosition position) {
        s.i(clubId, "clubId");
        s.i(model, "model");
        s.i(position, "position");
        Integer stage = model.getStage();
        if (stage != null && stage.intValue() == 1) {
            h(clubId, model, position);
        } else {
            j(clubId, model, position);
        }
    }

    @Nullable
    public final Function0<p> getMUnlockChatCallback() {
        return this.f13648d;
    }

    public final void h(final String str, final ClubWelcomeConfirmModel clubWelcomeConfirmModel, final SensorPosition sensorPosition) {
        int i10 = R$id.club_welcome_first_page_mark;
        ((TextView) e(i10)).setBackgroundResource(R$drawable.rect_cor_18_sd_c1926a);
        ((TextView) e(i10)).setTextColor(-1);
        int i11 = R$id.club_welcome_second_page_mark;
        ((TextView) e(i11)).setBackgroundResource(R$drawable.shape_f7_bg_100_corners);
        ((TextView) e(i11)).setTextColor(-5658199);
        ((ImageView) e(R$id.club_welcome_first_page_top_arrow)).setVisibility(0);
        ((ImageView) e(R$id.club_welcome_second_page_top_arrow)).setVisibility(8);
        ((ConstraintLayout) e(R$id.club_welcome_first_page_layout)).setVisibility(0);
        ((ScrollView) e(R$id.club_welcome_second_page_layout)).setVisibility(8);
        ImageLoaderView club_welcome_me_avatar_img = (ImageLoaderView) e(R$id.club_welcome_me_avatar_img);
        s.h(club_welcome_me_avatar_img, "club_welcome_me_avatar_img");
        User user = clubWelcomeConfirmModel.getUser();
        ImageLoaderView.g(club_welcome_me_avatar_img, user != null ? user.getAvatarImage() : null, null, null, 6, null);
        TextView textView = (TextView) e(R$id.club_welcome_me_name_text);
        User user2 = clubWelcomeConfirmModel.getUser();
        textView.setText(user2 != null ? user2.getName() : null);
        ((ClubChatLeftUserInfoLayout) e(R$id.club_welcome_me_user_info_layout)).d(clubWelcomeConfirmModel.getUser(), null, clubWelcomeConfirmModel.getMedalLevel(), false);
        ImageLoaderView club_welcome_get_medal_img = (ImageLoaderView) e(R$id.club_welcome_get_medal_img);
        s.h(club_welcome_get_medal_img, "club_welcome_get_medal_img");
        ImageLoaderView.g(club_welcome_get_medal_img, clubWelcomeConfirmModel.getMedalIcon(), null, null, 6, null);
        String groupDesc = clubWelcomeConfirmModel.getGroupDesc();
        ((TextView) e(R$id.club_welcome_get_medal_desc_text)).setText(groupDesc != null ? t.a(groupDesc, -8891597) : null);
        int i12 = R$id.club_welcome_next_btn;
        ((TextView) e(i12)).setText(getContext().getString(R$string.go_on));
        TextView club_welcome_next_btn = (TextView) e(i12);
        s.h(club_welcome_next_btn, "club_welcome_next_btn");
        y.d(club_welcome_next_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubWelcomeDialogLayout$configFirstPageData$1
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
                j1.i.f50236a.a(PopupName.CLUB_SHOULD_KNOW, PopupButtonName.CONTINUE, SensorPosition.this);
                Observable<Result<Object>> a10 = NetworkClient.f11868a.u().a(str, 1);
                final ClubWelcomeDialogLayout clubWelcomeDialogLayout = this;
                final ClubWelcomeConfirmModel clubWelcomeConfirmModel2 = clubWelcomeConfirmModel;
                final String str2 = str;
                final SensorPosition sensorPosition2 = SensorPosition.this;
                Disposable disposed = a10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.club.view.ClubWelcomeDialogLayout$configFirstPageData$1$invoke$$inlined$handle$default$1
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
                        ClubWelcomeConfirmModel.this.setStage(2);
                        com.cupidapp.live.base.view.h.f12779a.l(clubWelcomeDialogLayout.getContext(), R$string.receive_successfully);
                        clubWelcomeDialogLayout.j(str2, ClubWelcomeConfirmModel.this, sensorPosition2);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, clubWelcomeDialogLayout)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (clubWelcomeDialogLayout != null) {
                        clubWelcomeDialogLayout.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
            }
        });
    }

    public final void i(List<ClubWelcomeLevelBenefitModel> list) {
        ((LinearLayout) e(R$id.club_welcome_level_benefit_linear_layout)).removeAllViews();
        if (list == null || list.isEmpty()) {
            ((TextView) e(R$id.club_welcome_level_benefit_text)).setVisibility(8);
        } else {
            ((TextView) e(R$id.club_welcome_level_benefit_text)).setVisibility(0);
        }
        if (list != null) {
            for (ClubWelcomeLevelBenefitModel clubWelcomeLevelBenefitModel : list) {
                View inflate = View.inflate(getContext(), R$layout.item_club_welcome_level_benefit, null);
                ImageLoaderView imageLoaderView = (ImageLoaderView) inflate.findViewById(R$id.level_benefit_img);
                s.h(imageLoaderView, "item.level_benefit_img");
                ImageLoaderView.g(imageLoaderView, clubWelcomeLevelBenefitModel.getImage(), null, null, 6, null);
                ((TextView) inflate.findViewById(R$id.level_benefit_title)).setText(clubWelcomeLevelBenefitModel.getTitle());
                ((TextView) inflate.findViewById(R$id.level_benefit_desc)).setText(clubWelcomeLevelBenefitModel.getDesc());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = z0.h.c(this, 8.0f);
                ((LinearLayout) e(R$id.club_welcome_level_benefit_linear_layout)).addView(inflate, layoutParams);
            }
        }
    }

    public final void j(final String str, final ClubWelcomeConfirmModel clubWelcomeConfirmModel, final SensorPosition sensorPosition) {
        int i10 = R$id.club_welcome_second_page_mark;
        ((TextView) e(i10)).setBackgroundResource(R$drawable.rect_cor_18_sd_c1926a);
        ((TextView) e(i10)).setTextColor(-1);
        int i11 = R$id.club_welcome_first_page_mark;
        ((TextView) e(i11)).setBackgroundResource(R$drawable.shape_f7_bg_100_corners);
        ((TextView) e(i11)).setTextColor(-5658199);
        ((ImageView) e(R$id.club_welcome_first_page_top_arrow)).setVisibility(8);
        ((ImageView) e(R$id.club_welcome_second_page_top_arrow)).setVisibility(0);
        ((ConstraintLayout) e(R$id.club_welcome_first_page_layout)).setVisibility(8);
        ((ScrollView) e(R$id.club_welcome_second_page_layout)).setVisibility(0);
        if (clubWelcomeConfirmModel.getActivityInfo() == null) {
            ((ImageView) e(R$id.club_welcome_no_activity_img)).setVisibility(0);
            ((ActivityListItemLayout) e(R$id.club_welcome_activity_layout)).setVisibility(8);
        } else {
            ((ImageView) e(R$id.club_welcome_no_activity_img)).setVisibility(8);
            int i12 = R$id.club_welcome_activity_layout;
            ((ActivityListItemLayout) e(i12)).setVisibility(0);
            ((ActivityListItemLayout) e(i12)).b(-526345);
            ((ActivityListItemLayout) e(i12)).c(clubWelcomeConfirmModel.getActivityInfo());
            ActivityListItemLayout club_welcome_activity_layout = (ActivityListItemLayout) e(i12);
            s.h(club_welcome_activity_layout, "club_welcome_activity_layout");
            y.d(club_welcome_activity_layout, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubWelcomeDialogLayout$configSecondPageData$1
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
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, ClubWelcomeDialogLayout.this.getContext(), clubWelcomeConfirmModel.getActivityInfo().getJumpUrl(), null, 4, null);
                }
            });
        }
        ImageLoaderView club_welcome_second_medal_img = (ImageLoaderView) e(R$id.club_welcome_second_medal_img);
        s.h(club_welcome_second_medal_img, "club_welcome_second_medal_img");
        ImageLoaderView.g(club_welcome_second_medal_img, clubWelcomeConfirmModel.getMedalIcon(), null, null, 6, null);
        ((TextView) e(R$id.club_welcome_medal_exp_desc)).setText(clubWelcomeConfirmModel.getGroupExpMsg());
        if (clubWelcomeConfirmModel.getGroupEquity() != null) {
            int i13 = R$id.club_welcome_benefit_level_img;
            ((ImageLoaderView) e(i13)).setVisibility(0);
            int c4 = z0.h.c(this, 14.0f);
            ImageLoaderView club_welcome_benefit_level_img = (ImageLoaderView) e(i13);
            s.h(club_welcome_benefit_level_img, "club_welcome_benefit_level_img");
            y.n(club_welcome_benefit_level_img, Integer.valueOf(clubWelcomeConfirmModel.getGroupEquity().getScaleWidthByHeight(c4)), Integer.valueOf(c4));
            ImageLoaderView club_welcome_benefit_level_img2 = (ImageLoaderView) e(i13);
            s.h(club_welcome_benefit_level_img2, "club_welcome_benefit_level_img");
            ImageLoaderView.g(club_welcome_benefit_level_img2, clubWelcomeConfirmModel.getGroupEquity(), null, null, 6, null);
        } else {
            ((ImageLoaderView) e(R$id.club_welcome_benefit_level_img)).setVisibility(8);
        }
        i(clubWelcomeConfirmModel.getLevelEquities());
        int i14 = R$id.club_welcome_next_btn;
        ((TextView) e(i14)).setText(getContext().getString(R$string.i_already_know_unlock_chat));
        TextView club_welcome_next_btn = (TextView) e(i14);
        s.h(club_welcome_next_btn, "club_welcome_next_btn");
        y.d(club_welcome_next_btn, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.ClubWelcomeDialogLayout$configSecondPageData$2
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
                j1.i.f50236a.a(PopupName.CLUB_SHOULD_KNOW, PopupButtonName.UNLOCK_CHAT, SensorPosition.this);
                Observable<Result<Object>> a10 = NetworkClient.f11868a.u().a(str, 2);
                final ClubWelcomeDialogLayout clubWelcomeDialogLayout = this;
                Disposable disposed = a10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.club.view.ClubWelcomeDialogLayout$configSecondPageData$2$invoke$$inlined$handle$default$1
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
                        Function0<p> mUnlockChatCallback = ClubWelcomeDialogLayout.this.getMUnlockChatCallback();
                        if (mUnlockChatCallback != null) {
                            mUnlockChatCallback.invoke();
                        }
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, clubWelcomeDialogLayout)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (clubWelcomeDialogLayout != null) {
                        clubWelcomeDialogLayout.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
            }
        });
    }

    public final void k() {
        z.a(this, R$layout.layout_club_welcome_dialog, true);
    }

    public final void setMUnlockChatCallback(@Nullable Function0<p> function0) {
        this.f13648d = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubWelcomeDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13649e = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubWelcomeDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13649e = new LinkedHashMap();
        k();
    }
}
