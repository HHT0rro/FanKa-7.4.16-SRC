package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.profile.holder.FKProfileStoryLabelModel;
import com.cupidapp.live.setting.fragment.FKStoryLabelDetailFragment;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelDetailActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelDetailActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17960r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17961q = new LinkedHashMap();

    /* compiled from: FKStoryLabelDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull FKProfileStoryLabelModel profileLabelModel, @Nullable FKSensorContext fKSensorContext) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(profileLabelModel, "profileLabelModel");
            Intent intent = new Intent(context, (Class<?>) FKStoryLabelDetailActivity.class);
            z0.g.c(intent, profileLabelModel);
            if (fKSensorContext != null) {
                z0.g.c(intent, fKSensorContext);
            }
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_story_label);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        FKProfileStoryLabelModel fKProfileStoryLabelModel = (FKProfileStoryLabelModel) z0.g.a(intent, FKProfileStoryLabelModel.class);
        if (fKProfileStoryLabelModel == null) {
            finish();
            return;
        }
        FKStoryLabelDetailFragment.a aVar = FKStoryLabelDetailFragment.f18119l;
        Intent intent2 = getIntent();
        kotlin.jvm.internal.s.h(intent2, "intent");
        FKBaseActivity.g1(this, aVar.a(fKProfileStoryLabelModel, (FKSensorContext) z0.g.a(intent2, FKSensorContext.class)), false, R$id.story_label_frame_layout, false, false, 24, null);
        GroupSocialLog.f18708a.M();
    }
}
