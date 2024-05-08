package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.setting.fragment.FKEditStoryLabelFragment;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKEditStoryLabelActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKEditStoryLabelActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17956r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17957q = new LinkedHashMap();

    /* compiled from: FKEditStoryLabelActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull FKStoryLabelItemModel label) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(label, "label");
            Intent intent = new Intent(context, (Class<?>) FKEditStoryLabelActivity.class);
            z0.g.c(intent, label);
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
        FKStoryLabelItemModel fKStoryLabelItemModel = (FKStoryLabelItemModel) z0.g.a(intent, FKStoryLabelItemModel.class);
        if (fKStoryLabelItemModel == null) {
            finish();
        } else {
            FKBaseActivity.g1(this, FKEditStoryLabelFragment.f18114h.a(fKStoryLabelItemModel), false, R$id.story_label_frame_layout, false, false, 24, null);
            GroupSocialLog.f18708a.U(fKStoryLabelItemModel.getId());
        }
    }
}
