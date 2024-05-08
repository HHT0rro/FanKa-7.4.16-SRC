package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.setting.fragment.FKStoryLabelListFragment;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelListActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17962r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17963q = new LinkedHashMap();

    /* compiled from: FKStoryLabelListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, SensorPosition sensorPosition, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                sensorPosition = null;
            }
            aVar.a(context, sensorPosition);
        }

        public final void a(@Nullable Context context, @Nullable SensorPosition sensorPosition) {
            Intent intent = new Intent(context, (Class<?>) FKStoryLabelListActivity.class);
            if (sensorPosition != null) {
                z0.g.c(intent, sensorPosition);
            }
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_story_label);
        FKBaseActivity.g1(this, new FKStoryLabelListFragment(), false, R$id.story_label_frame_layout, false, false, 24, null);
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        groupSocialLog.W((SensorPosition) z0.g.a(intent, SensorPosition.class));
    }
}
