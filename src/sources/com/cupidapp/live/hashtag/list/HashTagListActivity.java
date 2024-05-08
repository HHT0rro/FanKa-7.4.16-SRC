package com.cupidapp.live.hashtag.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagListActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f14718r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14719q = new LinkedHashMap();

    /* compiled from: HashTagListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull HashTagListType type, @NotNull FKSensorContext sensorContext) {
            s.i(context, "context");
            s.i(type, "type");
            s.i(sensorContext, "sensorContext");
            Intent intent = new Intent(context, (Class<?>) HashTagListActivity.class);
            intent.putExtra("page_type", type);
            intent.putExtra("sensor_context", sensorContext);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }

        public final void b(@NotNull Activity activity, @NotNull HashTagListType type, int i10) {
            s.i(activity, "activity");
            s.i(type, "type");
            Intent intent = new Intent(activity, (Class<?>) HashTagListActivity.class);
            intent.putExtra("page_type", type);
            activity.startActivityForResult(intent, i10);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, activity, 0, 0, 6, null);
        }
    }

    public static final void l1(HashTagListActivity this$0, View view) {
        s.i(this$0, "this$0");
        this$0.onBackPressed();
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f14719q;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.hash_tag_list_activity);
        int i10 = R$id.toolbar;
        ((Toolbar) k1(i10)).setNavigationIcon(R$mipmap.icon_goback_black);
        ((Toolbar) k1(i10)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.hashtag.list.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HashTagListActivity.l1(HashTagListActivity.this, view);
            }
        });
        HashTagListType hashTagListType = (HashTagListType) getIntent().getSerializableExtra("page_type");
        FKSensorContext fKSensorContext = (FKSensorContext) getIntent().getSerializableExtra("sensor_context");
        if (hashTagListType == null) {
            finish();
            return;
        }
        if (hashTagListType == HashTagListType.DATA_VIEW_HASHTAG) {
            SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
            SensorScene sensorScene = SensorScene.Feed;
            SensorPosition sensorPosition = SensorPosition.HashtagList;
            sensorsLogFeed.M(sensorScene, sensorPosition, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
            j1.c.b(j1.c.f50228a, sensorPosition, null, null, 6, null);
            ((Toolbar) k1(i10)).setTitle(R$string.hashtag_square);
        } else {
            SensorsLogFeed sensorsLogFeed2 = SensorsLogFeed.f12208a;
            SensorScene sensorScene2 = SensorScene.Feed;
            SensorPosition sensorPosition2 = SensorPosition.HashtagSelect;
            sensorsLogFeed2.M(sensorScene2, sensorPosition2, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
            j1.c.b(j1.c.f50228a, sensorPosition2, null, null, 6, null);
            ((Toolbar) k1(i10)).setTitle(R$string.select_hashtag);
        }
        getSupportFragmentManager().beginTransaction().replace(2131363041, HashTagListFragment.f14720k.a(hashTagListType, fKSensorContext)).commitNow();
    }
}
