package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.club.model.ClubInfoModel;
import com.cupidapp.live.match.fragment.NearByMiniProfileFragment;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.view.TipUiModel;
import com.cupidapp.live.track.group.MiniProfileShowType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByMiniProfileActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByMiniProfileActivity extends FKBaseActivity {

    /* renamed from: r */
    @NotNull
    public static final a f16517r = new a(null);

    /* renamed from: q */
    @NotNull
    public Map<Integer, View> f16518q = new LinkedHashMap();

    /* compiled from: NearByMiniProfileActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, NearbyUserModel nearbyUserModel, SensorScene sensorScene, boolean z10, TipUiModel tipUiModel, boolean z11, VipPurchaseEntranceType vipPurchaseEntranceType, SensorPosition sensorPosition, MiniProfileShowType miniProfileShowType, ClubInfoModel clubInfoModel, boolean z12, int i10, Object obj) {
            aVar.a(context, nearbyUserModel, sensorScene, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? null : tipUiModel, (i10 & 32) != 0 ? false : z11, (i10 & 64) != 0 ? null : vipPurchaseEntranceType, (i10 & 128) != 0 ? null : sensorPosition, (i10 & 256) != 0 ? null : miniProfileShowType, (i10 & 512) != 0 ? null : clubInfoModel, (i10 & 1024) != 0 ? false : z12);
        }

        public final void a(@Nullable Context context, @NotNull NearbyUserModel model, @NotNull SensorScene scene, boolean z10, @Nullable TipUiModel tipUiModel, boolean z11, @Nullable VipPurchaseEntranceType vipPurchaseEntranceType, @Nullable SensorPosition sensorPosition, @Nullable MiniProfileShowType miniProfileShowType, @Nullable ClubInfoModel clubInfoModel, boolean z12) {
            kotlin.jvm.internal.s.i(model, "model");
            kotlin.jvm.internal.s.i(scene, "scene");
            Intent intent = new Intent(context, (Class<?>) NearByMiniProfileActivity.class);
            z0.g.c(intent, model);
            z0.g.c(intent, scene);
            intent.putExtra("tip", tipUiModel);
            intent.putExtra("isUsingMap", z10);
            intent.putExtra("data_type", vipPurchaseEntranceType);
            intent.putExtra("data_source", sensorPosition);
            intent.putExtra("data_need_buy", z11);
            if (miniProfileShowType != null) {
                z0.g.c(intent, miniProfileShowType);
            }
            if (clubInfoModel != null) {
                z0.g.c(intent, clubInfoModel);
            }
            intent.putExtra("IS_FROM_SPECIAL_EXPOSURE", z12);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.f11750o.b(context, R$anim.alpha_in, R$anim.anim_activity_nothing_no_duration);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_nearby_mini_profile);
        p0.c(this, true, 0, 2, null);
        d1(R$anim.anim_activity_nothing_no_duration, Integer.valueOf(R$anim.anim_activity_nothing_no_duration));
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        NearbyUserModel nearbyUserModel = (NearbyUserModel) z0.g.a(intent, NearbyUserModel.class);
        Intent intent2 = getIntent();
        kotlin.jvm.internal.s.h(intent2, "intent");
        SensorScene sensorScene = (SensorScene) z0.g.a(intent2, SensorScene.class);
        Serializable serializableExtra = getIntent().getSerializableExtra("tip");
        TipUiModel tipUiModel = serializableExtra instanceof TipUiModel ? (TipUiModel) serializableExtra : null;
        Serializable serializableExtra2 = getIntent().getSerializableExtra("data_type");
        VipPurchaseEntranceType vipPurchaseEntranceType = serializableExtra2 instanceof VipPurchaseEntranceType ? (VipPurchaseEntranceType) serializableExtra2 : null;
        Serializable serializableExtra3 = getIntent().getSerializableExtra("data_source");
        SensorPosition sensorPosition = serializableExtra3 instanceof SensorPosition ? (SensorPosition) serializableExtra3 : null;
        boolean booleanExtra = getIntent().getBooleanExtra("data_need_buy", false);
        Intent intent3 = getIntent();
        kotlin.jvm.internal.s.h(intent3, "intent");
        MiniProfileShowType miniProfileShowType = (MiniProfileShowType) z0.g.a(intent3, MiniProfileShowType.class);
        Intent intent4 = getIntent();
        kotlin.jvm.internal.s.h(intent4, "intent");
        ClubInfoModel clubInfoModel = (ClubInfoModel) z0.g.a(intent4, ClubInfoModel.class);
        boolean booleanExtra2 = getIntent().getBooleanExtra("IS_FROM_SPECIAL_EXPOSURE", false);
        if (nearbyUserModel != null && sensorScene != null) {
            FKBaseActivity.g1(this, NearByMiniProfileFragment.f16699r.b(nearbyUserModel, sensorScene, getIntent().getBooleanExtra("isUsingMap", false), tipUiModel, booleanExtra, vipPurchaseEntranceType, sensorPosition, miniProfileShowType, clubInfoModel, booleanExtra2), false, R$id.nearby_mini_profile_root_layout, false, false, 24, null);
        } else {
            finish();
        }
    }
}
