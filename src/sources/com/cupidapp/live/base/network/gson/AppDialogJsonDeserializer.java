package com.cupidapp.live.base.network.gson;

import com.cupidapp.live.appdialog.model.ActiveMatchFilterModel;
import com.cupidapp.live.appdialog.model.AgreementDialogModel;
import com.cupidapp.live.appdialog.model.AiGraphGuideGuideModel;
import com.cupidapp.live.appdialog.model.AppBetaModel;
import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.appdialog.model.AppRatingModel;
import com.cupidapp.live.appdialog.model.AvatarVideoDialogModel;
import com.cupidapp.live.appdialog.model.CustomProtocolModel;
import com.cupidapp.live.appdialog.model.DailyHeartModel;
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
import com.cupidapp.live.appdialog.model.MatchFilterRcmdModel;
import com.cupidapp.live.appdialog.model.NearbyMapRcmdModel;
import com.cupidapp.live.appdialog.model.NewUserVasMarketingModel;
import com.cupidapp.live.appdialog.model.PersonalIconModel;
import com.cupidapp.live.appdialog.model.SsvipMatchAvatarFrameGuideModel;
import com.cupidapp.live.appdialog.model.SsvipMatchGuideModel;
import com.cupidapp.live.appdialog.model.TeenModeModel;
import com.cupidapp.live.appdialog.model.TravelBoostGuideModel;
import com.cupidapp.live.appdialog.model.VasExpireTextRemindModel;
import com.cupidapp.live.appdialog.model.WebDialogModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogJsonDeserializer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AppDialogJsonDeserializer implements JsonDeserializer<Object> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f11998a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Map<String, Class<? extends AppDialogModel>> f11999b;

    /* compiled from: AppDialogJsonDeserializer.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        WindowType windowType = WindowType.UserPraiseGuide;
        f11999b = i0.g(f.a(WindowType.AppRate.getType(), AppRatingModel.class), f.a(WindowType.FakeAvatar.getType(), FakeAvatarModel.class), f.a(WindowType.Web.getType(), WebDialogModel.class), f.a(WindowType.Agreement.getType(), AgreementDialogModel.class), f.a(WindowType.Birthday.getType(), FillBirthdayModel.class), f.a(WindowType.TestVersion.getType(), AppBetaModel.class), f.a(WindowType.PushPriWindow.getType(), GuideOpenPushDialogModel.class), f.a(WindowType.ForceUpdate.getType(), ForceUpdateModel.class), f.a(WindowType.PrivacyExpire.getType(), ExpiredDialogModel.class), f.a(WindowType.SecretLounge.getType(), FakeMaskPartyModel.class), f.a(WindowType.AvatarVideo.getType(), AvatarVideoDialogModel.class), f.a(WindowType.ActiveMatchFilterGuide.getType(), ActiveMatchFilterModel.class), f.a(WindowType.GeneralMatchFilterGuide.getType(), GeneralMatchFilterModel.class), f.a(WindowType.MatchFilterGuide.getType(), MatchFilterRcmdModel.class), f.a(WindowType.LiveTabTextBubble.getType(), LiveTabIconModel.class), f.a(WindowType.CustomIcon.getType(), PersonalIconModel.class), f.a(WindowType.DailyHeart.getType(), DailyHeartModel.class), f.a(WindowType.Exposure.getType(), ExposureDoneModel.class), f.a(WindowType.CustomProtocol.getType(), CustomProtocolModel.class), f.a(windowType.getType(), FriendPraiseGuideModel.class), f.a(WindowType.TeenMode.getType(), TeenModeModel.class), f.a(windowType.getType(), FriendPraiseGuideModel.class), f.a(WindowType.SsvipMatchGuide.getType(), SsvipMatchGuideModel.class), f.a(WindowType.SsvipMatchAvatarFrameGuide.getType(), SsvipMatchAvatarFrameGuideModel.class), f.a(WindowType.TravelBoostGuide.getType(), TravelBoostGuideModel.class), f.a(WindowType.AiGraphGuide.getType(), AiGraphGuideGuideModel.class), f.a(WindowType.VasExpireTextRemind.getType(), VasExpireTextRemindModel.class), f.a(WindowType.NewUserVasMarketing.getType(), NewUserVasMarketingModel.class), f.a(WindowType.NearbyMapRcmdV2.getType(), NearbyMapRcmdModel.class));
    }

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public Object deserialize(@Nullable JsonElement jsonElement, @Nullable Type type, @Nullable JsonDeserializationContext jsonDeserializationContext) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return null;
        }
        Class<? extends AppDialogModel> cls = f11999b.get(jsonElement.getAsJsonObject().get("windowType").getAsString());
        if (jsonDeserializationContext != null) {
            return jsonDeserializationContext.deserialize(jsonElement, cls);
        }
        return null;
    }
}
