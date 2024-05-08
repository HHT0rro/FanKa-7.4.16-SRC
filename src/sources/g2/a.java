package g2;

import android.content.Context;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.flutter.interactive.b;
import com.cupidapp.live.flutter.model.BaseTransModel;
import com.cupidapp.live.flutter.model.PageChannel;
import com.cupidapp.live.flutter.model.PageName;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterEngineGroup;
import io.flutter.embedding.engine.dart.DartExecutor;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpenFlutterPageHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f49362a = new a();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static FlutterEngineGroup f49363b;

    public static /* synthetic */ void b(a aVar, Context context, String str, String str2, BaseTransModel baseTransModel, FKBaseActivity fKBaseActivity, int i10, Object obj) {
        aVar.a(context, str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : baseTransModel, (i10 & 16) != 0 ? null : fKBaseActivity);
    }

    public final void a(@NotNull Context applicationContext, @NotNull String pageName, @Nullable String str, @Nullable BaseTransModel baseTransModel, @Nullable FKBaseActivity fKBaseActivity) {
        s.i(applicationContext, "applicationContext");
        s.i(pageName, "pageName");
        FlutterEngineGroup flutterEngineGroup = f49363b;
        FlutterEngine createAndRunEngine = flutterEngineGroup != null ? flutterEngineGroup.createAndRunEngine(applicationContext, new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), pageName)) : null;
        b.f14666a.a(createAndRunEngine != null ? createAndRunEngine.getDartExecutor() : null, str, baseTransModel, fKBaseActivity);
        FlutterEngineCache.getInstance().put(pageName, createAndRunEngine);
    }

    public final void c(@NotNull Context context) {
        s.i(context, "context");
        if (f49363b == null) {
            f49363b = new FlutterEngineGroup(context);
        }
        b(this, context, PageName.Empty.getValue(), PageChannel.ALL_NEED_CHANNEL_NAME.getValue(), null, null, 24, null);
    }
}
