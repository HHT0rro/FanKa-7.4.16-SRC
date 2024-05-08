package com.cupidapp.live.appdialog.wrapper;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.layout.ExpireTextGuideDialog;
import com.cupidapp.live.appdialog.layout.FKAppBetaDialogLayout;
import com.cupidapp.live.appdialog.layout.FKExpiredToBuyLayout;
import com.cupidapp.live.appdialog.layout.FKFakePromptLayout;
import com.cupidapp.live.appdialog.layout.FKFillBirthdayLayout;
import com.cupidapp.live.appdialog.layout.FKForceUpdateLayout;
import com.cupidapp.live.appdialog.layout.FKFunctionGuideWithVideoBottomDialog;
import com.cupidapp.live.appdialog.layout.FKGuideOpenPushDialogLayout;
import com.cupidapp.live.appdialog.layout.FKIntroduceWithVideoBottomDialog;
import com.cupidapp.live.appdialog.layout.FKLiveWebDialogLayout;
import com.cupidapp.live.appdialog.layout.FKSSVipFunctionGuideWithVideoBottomDialog;
import com.cupidapp.live.appdialog.layout.FunctionGuideWithImgDialog;
import com.cupidapp.live.appdialog.layout.TeenModeLayout;
import com.cupidapp.live.appdialog.model.ActiveMatchFilterModel;
import com.cupidapp.live.appdialog.model.AgreementDialogModel;
import com.cupidapp.live.appdialog.model.AiGraphGuideGuideModel;
import com.cupidapp.live.appdialog.model.AppBetaModel;
import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.appdialog.model.AvatarVideoDialogModel;
import com.cupidapp.live.appdialog.model.CustomProtocolModel;
import com.cupidapp.live.appdialog.model.ExpiredDialogModel;
import com.cupidapp.live.appdialog.model.ExposureDoneModel;
import com.cupidapp.live.appdialog.model.FakeAvatarModel;
import com.cupidapp.live.appdialog.model.FakeMaskPartyModel;
import com.cupidapp.live.appdialog.model.FillBirthdayModel;
import com.cupidapp.live.appdialog.model.ForceUpdateModel;
import com.cupidapp.live.appdialog.model.FriendPraiseGuideModel;
import com.cupidapp.live.appdialog.model.GeneralMatchFilterModel;
import com.cupidapp.live.appdialog.model.GuideOpenPushDialogModel;
import com.cupidapp.live.appdialog.model.LiveTabIconModel;
import com.cupidapp.live.appdialog.model.NearbyMapRcmdModel;
import com.cupidapp.live.appdialog.model.NewUserVasMarketingModel;
import com.cupidapp.live.appdialog.model.SsvipMatchAvatarFrameGuideModel;
import com.cupidapp.live.appdialog.model.SsvipMatchGuideModel;
import com.cupidapp.live.appdialog.model.TeenModeModel;
import com.cupidapp.live.appdialog.model.TravelBoostGuideModel;
import com.cupidapp.live.appdialog.model.VasExpireTextRemindModel;
import com.cupidapp.live.appdialog.model.WebDialogModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.main.view.FKUpdatePrivacyHelper;
import com.cupidapp.live.maskparty.view.FakeMaskPartyLayout;
import com.cupidapp.live.maskparty.view.MaskPartyRecommendLayout;
import com.cupidapp.live.match.activity.FKMatchFilterNewActivity;
import com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity;
import com.cupidapp.live.match.activity.MapFilterNewActivity;
import com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity;
import com.cupidapp.live.notify.activity.NotifyActivity;
import com.cupidapp.live.notify.fragment.NotifyPageType;
import com.cupidapp.live.profile.event.ShowGuideBubbleEvent;
import com.cupidapp.live.setting.activity.EditUserInfoActivity;
import com.cupidapp.live.setting.activity.PersonalAppIconActivity;
import com.cupidapp.live.superboost.dialog.FKSuperBoostDoneDialog;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xb.b;
import z0.h;

/* compiled from: AppDialogWrapper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AppDialogWrapper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AppDialogWrapper f11746a = new AppDialogWrapper();

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(String str, String str2, Context context) {
        Observable<Result<Object>> m10 = NetworkClient.f11868a.i().m(str, str2);
        AppDialogWrapper$notRemindClick$2 appDialogWrapper$notRemindClick$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$notRemindClick$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = m10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$notRemindClick$$inlined$handleByContext$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(appDialogWrapper$notRemindClick$2, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void c(final Context context, final SensorPosition sensorPosition) {
        if (context == null) {
            return;
        }
        j1.i.g(j1.i.f50236a, PopupName.ONLINE_FILTER_GUIDE, sensorPosition, null, 4, null);
        FKIntroduceWithVideoBottomDialog a10 = FKIntroduceWithVideoBottomDialog.f11685f.a(context);
        String string = context.getString(R$string.active_match_filter_guide);
        s.h(string, "context.getString(R.stri…ctive_match_filter_guide)");
        FKIntroduceWithVideoBottomDialog.m(a10.o(string).e(false), "active_time_filter_guide.svga", null, 2, null).j(R$string.go_to_try, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showActiveMatchFilterGuide$1
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
                j1.i.f50236a.a(PopupName.ONLINE_FILTER_GUIDE, PopupButtonName.TRY, SensorPosition.this);
                FKMatchFilterNewActivity.f16488t.a(context, false, false, "");
            }
        }).f(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showActiveMatchFilterGuide$2
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
                j1.i.f50236a.a(PopupName.ONLINE_FILTER_GUIDE, PopupButtonName.Close, SensorPosition.this);
            }
        }).q();
    }

    public final void d(final Context context, final SensorPosition sensorPosition, final String str) {
        j1.i.g(j1.i.f50236a, PopupName.AI_FACE_IDENTITY_ONLINE, sensorPosition, null, 4, null);
        FKSSVipFunctionGuideWithVideoBottomDialog a10 = FKSSVipFunctionGuideWithVideoBottomDialog.f11694e.a(context);
        String string = context.getString(R$string.ai_identify);
        s.h(string, "context.getString(R.string.ai_identify)");
        a10.l(string).h(R$string.ai_identify_intro).d(false).f(false).k("home_guide_ai_find.svga", Integer.valueOf((int) (h.l(context) * 0.5866666666666667d))).i(R$string.go_to_try, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showAiGraphGuide$1
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
                j1.i.f50236a.a(PopupName.AI_FACE_IDENTITY_ONLINE, PopupButtonName.TRY, SensorPosition.this);
                j.a.b(j.f12156c, context, str, null, 4, null);
            }
        }).g(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showAiGraphGuide$2
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
                j1.i.f50236a.a(PopupName.AI_FACE_IDENTITY_ONLINE, PopupButtonName.Close, SensorPosition.this);
            }
        }).m();
    }

    public final void e(@Nullable Context context, @Nullable AppDialogModel appDialogModel, @NotNull SensorPosition position) {
        s.i(position, "position");
        if (context == null || appDialogModel == null) {
            return;
        }
        String windowType = appDialogModel.getWindowType();
        if (s.d(windowType, WindowType.FakeAvatar.getType())) {
            FakeAvatarModel fakeAvatarModel = appDialogModel instanceof FakeAvatarModel ? (FakeAvatarModel) appDialogModel : null;
            if (fakeAvatarModel != null) {
                new FKFakePromptLayout(context).i(fakeAvatarModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.Web.getType())) {
            WebDialogModel webDialogModel = appDialogModel instanceof WebDialogModel ? (WebDialogModel) appDialogModel : null;
            if (webDialogModel != null) {
                new FKLiveWebDialogLayout(context).E(webDialogModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.Agreement.getType())) {
            AgreementDialogModel agreementDialogModel = appDialogModel instanceof AgreementDialogModel ? (AgreementDialogModel) appDialogModel : null;
            if (agreementDialogModel != null) {
                FKUpdatePrivacyHelper.f16202a.k(context, agreementDialogModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.Birthday.getType())) {
            FillBirthdayModel fillBirthdayModel = appDialogModel instanceof FillBirthdayModel ? (FillBirthdayModel) appDialogModel : null;
            if (fillBirthdayModel != null) {
                new FKFillBirthdayLayout(context).l(fillBirthdayModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.TestVersion.getType())) {
            AppBetaModel appBetaModel = appDialogModel instanceof AppBetaModel ? (AppBetaModel) appDialogModel : null;
            if (appBetaModel != null) {
                new FKAppBetaDialogLayout(context).k(appBetaModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.PushPriWindow.getType())) {
            GuideOpenPushDialogModel guideOpenPushDialogModel = appDialogModel instanceof GuideOpenPushDialogModel ? (GuideOpenPushDialogModel) appDialogModel : null;
            if (guideOpenPushDialogModel != null) {
                FKGuideOpenPushDialogLayout.f11679c.a(context, guideOpenPushDialogModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.ForceUpdate.getType())) {
            ForceUpdateModel forceUpdateModel = appDialogModel instanceof ForceUpdateModel ? (ForceUpdateModel) appDialogModel : null;
            if (forceUpdateModel != null) {
                new FKForceUpdateLayout(context).r(forceUpdateModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.PrivacyExpire.getType())) {
            ExpiredDialogModel expiredDialogModel = appDialogModel instanceof ExpiredDialogModel ? (ExpiredDialogModel) appDialogModel : null;
            if (expiredDialogModel != null) {
                new FKExpiredToBuyLayout(context).k(expiredDialogModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.SecretLounge.getType())) {
            if (MaskPartyRecommendLayout.f16437o.b()) {
                return;
            }
            FakeMaskPartyModel fakeMaskPartyModel = appDialogModel instanceof FakeMaskPartyModel ? (FakeMaskPartyModel) appDialogModel : null;
            if (fakeMaskPartyModel != null) {
                new FakeMaskPartyLayout(context).m(fakeMaskPartyModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.AvatarVideo.getType())) {
            AvatarVideoDialogModel avatarVideoDialogModel = appDialogModel instanceof AvatarVideoDialogModel ? (AvatarVideoDialogModel) appDialogModel : null;
            if (avatarVideoDialogModel != null) {
                f11746a.r(context, avatarVideoDialogModel.getTitle(), position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.ActiveMatchFilterGuide.getType())) {
            if ((appDialogModel instanceof ActiveMatchFilterModel ? (ActiveMatchFilterModel) appDialogModel : null) != null) {
                f11746a.c(context, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.GeneralMatchFilterGuide.getType())) {
            GeneralMatchFilterModel generalMatchFilterModel = appDialogModel instanceof GeneralMatchFilterModel ? (GeneralMatchFilterModel) appDialogModel : null;
            if (generalMatchFilterModel != null) {
                f11746a.j(context, position, generalMatchFilterModel);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.MatchFilterGuide.getType())) {
            FKMatchFilterRcmdActivity.a.b(FKMatchFilterRcmdActivity.f16492s, context, null, 2, null);
            return;
        }
        if (s.d(windowType, WindowType.CustomIcon.getType())) {
            o(context, position);
            return;
        }
        if (s.d(windowType, WindowType.LiveTabTextBubble.getType())) {
            LiveTabIconModel liveTabIconModel = appDialogModel instanceof LiveTabIconModel ? (LiveTabIconModel) appDialogModel : null;
            if (liveTabIconModel != null) {
                f11746a.k(context, liveTabIconModel);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.DailyHeart.getType())) {
            f(context, position);
            return;
        }
        if (s.d(windowType, WindowType.Exposure.getType())) {
            ExposureDoneModel exposureDoneModel = appDialogModel instanceof ExposureDoneModel ? (ExposureDoneModel) appDialogModel : null;
            if (exposureDoneModel != null) {
                f11746a.h(context, exposureDoneModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.CustomProtocol.getType())) {
            CustomProtocolModel customProtocolModel = appDialogModel instanceof CustomProtocolModel ? (CustomProtocolModel) appDialogModel : null;
            if (customProtocolModel != null) {
                j.a.b(j.f12156c, context, customProtocolModel.getUrl(), null, 4, null);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.UserPraiseGuide.getType())) {
            FriendPraiseGuideModel friendPraiseGuideModel = appDialogModel instanceof FriendPraiseGuideModel ? (FriendPraiseGuideModel) appDialogModel : null;
            if (friendPraiseGuideModel != null) {
                f11746a.i(context, friendPraiseGuideModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.TeenMode.getType())) {
            TeenModeModel teenModeModel = appDialogModel instanceof TeenModeModel ? (TeenModeModel) appDialogModel : null;
            if (teenModeModel != null) {
                new TeenModeLayout(context).F(teenModeModel, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.SsvipMatchGuide.getType())) {
            if ((appDialogModel instanceof SsvipMatchGuideModel ? (SsvipMatchGuideModel) appDialogModel : null) != null) {
                f11746a.l(context, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.SsvipMatchAvatarFrameGuide.getType())) {
            if ((appDialogModel instanceof SsvipMatchAvatarFrameGuideModel ? (SsvipMatchAvatarFrameGuideModel) appDialogModel : null) != null) {
                f11746a.p(context, position);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.TravelBoostGuide.getType())) {
            TravelBoostGuideModel travelBoostGuideModel = appDialogModel instanceof TravelBoostGuideModel ? (TravelBoostGuideModel) appDialogModel : null;
            if (travelBoostGuideModel != null) {
                f11746a.q(context, position, travelBoostGuideModel);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.AiGraphGuide.getType())) {
            AiGraphGuideGuideModel aiGraphGuideGuideModel = appDialogModel instanceof AiGraphGuideGuideModel ? (AiGraphGuideGuideModel) appDialogModel : null;
            if (aiGraphGuideGuideModel != null) {
                f11746a.d(context, position, aiGraphGuideGuideModel.getUrl());
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.VasExpireTextRemind.getType())) {
            VasExpireTextRemindModel vasExpireTextRemindModel = appDialogModel instanceof VasExpireTextRemindModel ? (VasExpireTextRemindModel) appDialogModel : null;
            if (vasExpireTextRemindModel != null) {
                f11746a.g(context, position, vasExpireTextRemindModel.getText());
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.NewUserVasMarketing.getType())) {
            NewUserVasMarketingModel newUserVasMarketingModel = appDialogModel instanceof NewUserVasMarketingModel ? (NewUserVasMarketingModel) appDialogModel : null;
            if (newUserVasMarketingModel != null) {
                f11746a.n(context, newUserVasMarketingModel);
                return;
            }
            return;
        }
        if (s.d(windowType, WindowType.NearbyMapRcmdV2.getType())) {
            NearbyMapRcmdModel nearbyMapRcmdModel = appDialogModel instanceof NearbyMapRcmdModel ? (NearbyMapRcmdModel) appDialogModel : null;
            if (nearbyMapRcmdModel != null) {
                f11746a.m(context, nearbyMapRcmdModel, position);
            }
        }
    }

    public final void f(final Context context, final SensorPosition sensorPosition) {
        if (context == null) {
            return;
        }
        j1.i.g(j1.i.f50236a, PopupName.DAILY_HEART_GUIDE, sensorPosition, null, 4, null);
        FKIntroduceWithVideoBottomDialog a10 = FKIntroduceWithVideoBottomDialog.f11685f.a(context);
        String string = context.getString(R$string.daily_guide);
        s.h(string, "context.getString(R.string.daily_guide)");
        a10.o(string).e(false).l("daily_heart_guide.svga", Integer.valueOf((int) (h.l(context) * 0.5866666666666667d))).j(R$string.go_to_try, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showDailyHeart$1
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
                j1.i.f50236a.a(PopupName.DAILY_HEART_GUIDE, PopupButtonName.TRY, SensorPosition.this);
                NotifyActivity.a.b(NotifyActivity.f17492s, context, NotifyPageType.DailyHeart, false, 4, null);
            }
        }).f(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showDailyHeart$2
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
                j1.i.f50236a.a(PopupName.DAILY_HEART_GUIDE, PopupButtonName.Close, SensorPosition.this);
            }
        }).q();
    }

    public final void g(Context context, SensorPosition sensorPosition, String str) {
        if (str != null) {
            ExpireTextGuideDialog.f11654d.a(context).d(str).f();
        }
    }

    public final void h(Context context, ExposureDoneModel exposureDoneModel, SensorPosition sensorPosition) {
        j1.i.g(j1.i.f50236a, PopupName.SUPER_EXPOSURE_COMPLETE, sensorPosition, null, 4, null);
        FKSuperBoostDoneDialog.f18577d.a(context).c(exposureDoneModel).e();
    }

    public final void i(final Context context, final FriendPraiseGuideModel friendPraiseGuideModel, final SensorPosition sensorPosition) {
        if (context == null) {
            return;
        }
        j1.i.g(j1.i.f50236a, PopupName.PRAISE_NEW_GUIDE, sensorPosition, null, 4, null);
        FKIntroduceWithVideoBottomDialog.g(FKIntroduceWithVideoBottomDialog.f11685f.a(context).n(R$string.friend_praise_guide_title).h(R$string.friend_praise_guide_desc), null, 1, null).e(false).l("friend_praise_guide.svga", Integer.valueOf((int) (h.l(context) * 0.5866666666666667d))).j(R$string.go_to_try, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showFriendPraiseGuideDialog$1
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
                j1.i.f50236a.a(PopupName.PRAISE_NEW_GUIDE, PopupButtonName.TRY, SensorPosition.this);
                j.a.b(j.f12156c, context, friendPraiseGuideModel.getSkipUrl(), null, 4, null);
            }
        }).q();
    }

    public final void j(final Context context, final SensorPosition sensorPosition, final GeneralMatchFilterModel generalMatchFilterModel) {
        if (context == null) {
            return;
        }
        j1.i.g(j1.i.f50236a, PopupName.PRECISION_FILTER_GUIDE, sensorPosition, null, 4, null);
        FKIntroduceWithVideoBottomDialog a10 = FKIntroduceWithVideoBottomDialog.f11685f.a(context);
        String string = context.getString(R$string.general_filter_guide);
        s.h(string, "context.getString(R.string.general_filter_guide)");
        FKIntroduceWithVideoBottomDialog.m(a10.o(string).e(false), "filter_guide.svga", null, 2, null).j(R$string.go_to_try, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showGeneralMatchFilterGuide$1
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
                j1.i.f50236a.a(PopupName.PRECISION_FILTER_GUIDE, PopupButtonName.TRY, SensorPosition.this);
                FKMatchFilterNewActivity.f16488t.a(context, false, false, "");
            }
        }).i(R$string.do_not_remind_me, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showGeneralMatchFilterGuide$2
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
                AppDialogWrapper.f11746a.b(GeneralMatchFilterModel.this.getScene(), GeneralMatchFilterModel.this.getWindowType(), context);
                j1.i.f50236a.a(PopupName.PRECISION_FILTER_GUIDE, PopupButtonName.NO_REMIND, sensorPosition);
            }
        }).f(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showGeneralMatchFilterGuide$3
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
                j1.i.f50236a.a(PopupName.PRECISION_FILTER_GUIDE, PopupButtonName.Close, SensorPosition.this);
            }
        }).q();
    }

    public final void k(Context context, LiveTabIconModel liveTabIconModel) {
        if (context instanceof MainActivity) {
            ((MainActivity) context).L1(liveTabIconModel);
        }
    }

    public final void l(final Context context, final SensorPosition sensorPosition) {
        j1.i.g(j1.i.f50236a, PopupName.TRY_INTELLIGENT_FILTER, sensorPosition, null, 4, null);
        FKSSVipFunctionGuideWithVideoBottomDialog a10 = FKSSVipFunctionGuideWithVideoBottomDialog.f11694e.a(context);
        String string = context.getString(R$string.try_use_filter);
        s.h(string, "context.getString(R.string.try_use_filter)");
        FKSSVipFunctionGuideWithVideoBottomDialog.j(a10.l(string).h(R$string.try_use_filter_content).f(false).k("filter_intelligent_guide.svga", Integer.valueOf((int) (h.l(context) * 0.5866666666666667d))), 0, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showMatchFilterGuide$1
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
                j1.i.f50236a.a(PopupName.TRY_INTELLIGENT_FILTER, PopupButtonName.TRY, SensorPosition.this);
                FKMatchFilterNewActivity.f16488t.a(context, false, false, "");
            }
        }, 1, null).g(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showMatchFilterGuide$2
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
                j1.i.f50236a.a(PopupName.TRY_INTELLIGENT_FILTER, PopupButtonName.Close, SensorPosition.this);
            }
        }).m();
    }

    public final void m(final Context context, NearbyMapRcmdModel nearbyMapRcmdModel, final SensorPosition sensorPosition) {
        FunctionGuideWithImgDialog a10 = FunctionGuideWithImgDialog.f11698e.a(context);
        String title = nearbyMapRcmdModel.getTitle();
        if (title == null) {
            title = "";
        }
        FunctionGuideWithImgDialog i10 = a10.i(title);
        String text = nearbyMapRcmdModel.getText();
        FunctionGuideWithImgDialog.e(i10.g(text != null ? text : "").h(R$mipmap.ic_map_guide_top).f(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showNearByMapRcmd$1
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
                j1.i.f50236a.a(PopupName.BETTER_MAP_FIND_GUIDE, PopupButtonName.Close, SensorPosition.this);
            }
        }), 0, 0, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showNearByMapRcmd$2
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
                final Context context2 = context;
                FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null;
                if (fragmentActivity != null) {
                    final SensorPosition sensorPosition2 = sensorPosition;
                    LocationUtils.f12270h.e(context2, new b(fragmentActivity), new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showNearByMapRcmd$2$1$1
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
                            CoordinateModel j10 = LocationUtils.f12270h.a().j();
                            Context context3 = context2;
                            if (context3 != null) {
                                MapFilterNewActivity.f16502z.a(context3, Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude()), sensorPosition2, VipPurchaseEntranceType.GuideMap);
                            }
                        }
                    });
                    j1.i.f50236a.a(PopupName.BETTER_MAP_FIND_GUIDE, PopupButtonName.TRY, sensorPosition2);
                }
            }
        }, 3, null).j();
        j1.i.g(j1.i.f50236a, PopupName.BETTER_MAP_FIND_GUIDE, sensorPosition, null, 4, null);
    }

    public final void n(Context context, NewUserVasMarketingModel newUserVasMarketingModel) {
        p1.g.f52734a.a(newUserVasMarketingModel.getActivationType());
        if (s.d(newUserVasMarketingModel.getFullscreen(), Boolean.TRUE)) {
            String activationType = newUserVasMarketingModel.getActivationType();
            if (activationType != null) {
                RegisterUserMatchBtnDesActivity.f16544s.a(context, activationType);
                return;
            }
            return;
        }
        EventBus.c().o(new ShowGuideBubbleEvent(newUserVasMarketingModel.getActivationType()));
    }

    public final void o(final Context context, final SensorPosition sensorPosition) {
        if (context == null) {
            return;
        }
        j1.i.g(j1.i.f50236a, PopupName.PERSONAL_ICON_GUIDE, sensorPosition, null, 4, null);
        FKIntroduceWithVideoBottomDialog a10 = FKIntroduceWithVideoBottomDialog.f11685f.a(context);
        String string = context.getString(R$string.personal_icon_guide);
        s.h(string, "context.getString(R.string.personal_icon_guide)");
        a10.o(string).e(false).l("personal_icon_guide.svga", Integer.valueOf((int) (h.l(context) * 0.5866666666666667d))).j(R$string.go_to_try, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showPersonalIconGuide$1
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
                j1.i.f50236a.a(PopupName.PERSONAL_ICON_GUIDE, PopupButtonName.TRY, SensorPosition.this);
                PersonalAppIconActivity.f17982u.a(context);
            }
        }).f(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showPersonalIconGuide$2
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
                j1.i.f50236a.a(PopupName.PERSONAL_ICON_GUIDE, PopupButtonName.Close, SensorPosition.this);
            }
        }).q();
    }

    public final void p(final Context context, final SensorPosition sensorPosition) {
        j1.i.g(j1.i.f50236a, PopupName.RAINBOW_FRAME, sensorPosition, null, 4, null);
        FKSSVipFunctionGuideWithVideoBottomDialog a10 = FKSSVipFunctionGuideWithVideoBottomDialog.f11694e.a(context);
        String string = context.getString(R$string.try_use_rainbow_border);
        s.h(string, "context.getString(R.string.try_use_rainbow_border)");
        FKSSVipFunctionGuideWithVideoBottomDialog.j(a10.l(string).h(R$string.try_use_rainbow_border_content).f(false).k("guide_avatar_border.svga", Integer.valueOf((int) (h.l(context) * 0.5866666666666667d))), 0, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showRainbowBorderGuide$1
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
                ConstantsUrlModel urlModel;
                j1.i.f50236a.a(PopupName.RAINBOW_FRAME, PopupButtonName.TRY, SensorPosition.this);
                j.a aVar = j.f12156c;
                Context context2 = context;
                ConstantsResult q10 = p1.g.f52734a.q();
                j.a.b(aVar, context2, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getIndividuationFrameConfigJumpUrl(), null, 4, null);
            }
        }, 1, null).g(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showRainbowBorderGuide$2
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
                j1.i.f50236a.a(PopupName.RAINBOW_FRAME, PopupButtonName.Close, SensorPosition.this);
            }
        }).m();
    }

    public final void q(final Context context, final SensorPosition sensorPosition, final TravelBoostGuideModel travelBoostGuideModel) {
        double l10 = h.l(context) * 0.5866666666666667d;
        FKFunctionGuideWithVideoBottomDialog a10 = FKFunctionGuideWithVideoBottomDialog.f11675e.a(context);
        String title = travelBoostGuideModel.getTitle();
        if (title == null) {
            title = "";
        }
        FKFunctionGuideWithVideoBottomDialog i10 = a10.i(title);
        String text = travelBoostGuideModel.getText();
        i10.f(text != null ? text : "").h("travel_guide.svga", Integer.valueOf((int) l10)).e(new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showTravelBoostGuide$1
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
                j1.i.f50236a.a(PopupName.TRAVEL_MODE_ONLINE, PopupButtonName.Close, SensorPosition.this);
            }
        }).g(R$string.try_now, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showTravelBoostGuide$2
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
                Context context2 = context;
                if ((context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null) != null) {
                    TravelBoostGuideModel travelBoostGuideModel2 = travelBoostGuideModel;
                    SensorPosition sensorPosition2 = sensorPosition;
                    j.a.b(j.f12156c, context2, travelBoostGuideModel2.getUrl(), null, 4, null);
                    j1.i.f50236a.a(PopupName.TRAVEL_MODE_ONLINE, PopupButtonName.TRY, sensorPosition2);
                }
            }
        }).j();
        j1.i.g(j1.i.f50236a, PopupName.TRAVEL_MODE_ONLINE, sensorPosition, null, 4, null);
    }

    public final void r(final Context context, String str, final SensorPosition sensorPosition) {
        j1.i.g(j1.i.f50236a, PopupName.ANM_DYNAMIC_AVATAR_GUIDE, sensorPosition, null, 4, null);
        FKIntroduceWithVideoBottomDialog e2 = FKIntroduceWithVideoBottomDialog.g(FKIntroduceWithVideoBottomDialog.f11685f.a(context).o(str), null, 1, null).e(false);
        String str2 = File.separator;
        FKIntroduceWithVideoBottomDialog.k(e2.p("file:///android_asset" + str2 + "video" + str2 + "avatar_video_guide.mp4"), 0, new Function0<p>() { // from class: com.cupidapp.live.appdialog.wrapper.AppDialogWrapper$showVideoAvatarGuideDialog$1
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
                j1.i.f50236a.a(PopupName.ANM_DYNAMIC_AVATAR_GUIDE, PopupButtonName.TRY, SensorPosition.this);
                EditUserInfoActivity.a.b(EditUserInfoActivity.f17947y, context, null, false, 6, null);
            }
        }, 1, null).q();
    }
}
