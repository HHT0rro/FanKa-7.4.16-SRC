package com.huawei.quickcard;

import android.content.Context;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.action.AbsQuickCardAction;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.base.BuildConfig;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.bi.CardReporter;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.QuickCardPlatformUtils;
import com.huawei.quickcard.elexecutor.IExpressionFactory;
import com.huawei.quickcard.manager.ManagerDependence;
import com.huawei.quickcard.utils.NetworkConnectivityMonitor;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.views.image.ImageConfig;
import com.huawei.quickcard.views.image.view.FlexImageView;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardEngine {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33237a = "QuickCardEngine";

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f33238b;

    /* renamed from: d, reason: collision with root package name */
    private static IExpressionFactory f33240d;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f33242f;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Class<? extends AbsQuickCardAction>> f33239c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static int f33241e = 1002;

    private static void a() {
        if (ImageConfig.getImageFactory() == null) {
            ImageConfig.setImageFactory(FlexImageView.FACTORY);
        }
    }

    public static void destroy(@Nullable Context context) {
        h1.f34011d.b();
        NetworkConnectivityMonitor.getInstance().unregister();
    }

    public static Map<String, Class<? extends AbsQuickCardAction>> getActionsMap() {
        HashMap hashMap = new HashMap(ActionsHelper.getInnerActions());
        hashMap.putAll(f33239c);
        return hashMap;
    }

    @NonNull
    public static IExpressionFactory getExpressionFactory() {
        IExpressionFactory iExpressionFactory = f33240d;
        Objects.requireNonNull(iExpressionFactory, "expressionFactory is not initialized, plz check!!!");
        return iExpressionFactory;
    }

    public static int getMinToolkitLevel() {
        return f33241e;
    }

    public static int getQuickCardVersion() {
        return QuickCardPlatformUtils.getEngineVer();
    }

    public static boolean initialize(Context context) {
        if (context == null) {
            CardLogUtils.e(f33237a, "initialize fail cause context is empty");
            return false;
        }
        ManagerDependence.setDependence();
        CardReporter begin = CardReporter.from(context).begin();
        a();
        SystemUtils.initManufacturerDeviceInfo();
        Context applicationContext = context.getApplicationContext();
        if (!h1.f34011d.a(applicationContext)) {
            CardLogUtils.e(f33237a, "initialize fail cause activity manager init fail");
            begin.end().fail(-1, "initialize fail cause activity manager init fail").reportInit(true);
            return false;
        }
        try {
            f33238b = YogaLoadHelper.loadYogaLibrary(applicationContext);
            if (f33238b) {
                begin.end().success().reportInit(true);
            } else {
                begin.end().fail(-1, "initialize fail maybe so load fail").reportInit(true);
            }
            CardLogUtils.i(f33237a, "init quick card engine " + f33238b + System.lineSeparator() + "SDK-Version::" + BuildConfig.QUICKCARD_ENGINE_VERSION_NAME + System.lineSeparator() + "Platform-Version::" + QuickCardPlatformUtils.getEngineVer());
            return f33238b;
        } catch (RuntimeException e2) {
            CardLogUtils.e(f33237a, "initialize fail cause soLoader init", e2);
            begin.end().fail(-1, "init fail cause: " + e2.getMessage()).reportInit(true);
            return false;
        }
    }

    public static boolean isInitialized() {
        return f33238b;
    }

    public static boolean isStandardExtension() {
        return f33242f;
    }

    public static void registerActions(String str, Class<? extends AbsQuickCardAction> cls) {
        f33239c.put(str, cls);
    }

    public static void registerExpressionFactory(IExpressionFactory iExpressionFactory) {
        f33240d = iExpressionFactory;
    }

    public static void setMinToolkitLevel(@IntRange(from = 1000) int i10) {
        f33241e = i10;
    }

    public static void setStandardExtension(boolean z10) {
        f33242f = z10;
    }
}
