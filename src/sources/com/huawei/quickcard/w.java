package com.huawei.quickcard;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.JsonUtils;
import com.huawei.quickcard.base.utils.QuickCardPlatformUtils;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.elexecutor.IExpressionContextProxy;
import com.huawei.quickcard.framework.QuickCardField;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo;
import com.huawei.quickcard.utils.DeviceInfoUtils;
import com.huawei.quickcard.utils.NetworkConnectivityMonitor;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.video.VideoAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class w implements View.OnLayoutChangeListener {

    /* renamed from: e, reason: collision with root package name */
    private static final String f34690e = "ConfigurationManager";

    /* renamed from: f, reason: collision with root package name */
    private static final String f34691f = "language.language";

    /* renamed from: g, reason: collision with root package name */
    private static final String f34692g = "language.script";

    /* renamed from: h, reason: collision with root package name */
    private static final String f34693h = "language.country";

    /* renamed from: i, reason: collision with root package name */
    private static final String f34694i = "deviceInfo";

    /* renamed from: j, reason: collision with root package name */
    private static final String f34695j = "platformInfo";

    /* renamed from: k, reason: collision with root package name */
    private static final String f34696k = "themes";

    /* renamed from: l, reason: collision with root package name */
    private static final String f34697l = "onConfigurationChanged";

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f34698a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Set<String> f34699b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f34700c;

    /* renamed from: d, reason: collision with root package name */
    private final CardContext f34701d;

    public w(CardContext cardContext) {
        this.f34701d = cardContext;
        i();
        ViewGroup rootViewGroup = cardContext.getRoot().getRootViewGroup();
        if (rootViewGroup != null) {
            rootViewGroup.removeOnLayoutChangeListener(this);
            rootViewGroup.addOnLayoutChangeListener(this);
        }
    }

    private String a(int i10) {
        return i10 != 1 ? i10 != 2 ? "undefined" : VideoAttributes.CommonValue.DEFAULT_ORIENTATION : "portrait";
    }

    private void b(Map<String, Object> map, Configuration configuration, Set<String> set) {
        ValueUtils.putToMap(map, Integer.valueOf(configuration.screenHeightDp), "screenHeightDp");
        ValueUtils.putToMap(map, Integer.valueOf(configuration.screenWidthDp), "screenWidthDp");
        set.add("$configuration.deviceInfo.screenHeightDp");
        set.add("$configuration.deviceInfo.screenWidthDp");
    }

    private void c(Set<String> set) {
        if (set == null || set.isEmpty() || this.f34701d.getDataContext() == null) {
            return;
        }
        this.f34701d.getWatcherManager().updateByVars(set);
    }

    private String d(String str) {
        return str == null ? "" : str;
    }

    @NonNull
    private Map<String, Object> e() {
        return b(f34695j);
    }

    private void i() {
        HashSet hashSet = new HashSet();
        this.f34700c = hashSet;
        hashSet.add(Attributes.UiMode.LIGHT);
        this.f34700c.add(Attributes.UiMode.DARK);
    }

    public void a(IExpressionContext iExpressionContext, String str) {
        a(iExpressionContext);
    }

    public void d(@NonNull Context context) {
        int deviceScreenWidth = DeviceInfoUtils.getDeviceScreenWidth(context);
        int deviceScreenHeight = DeviceInfoUtils.getDeviceScreenHeight(context);
        float a10 = a(context);
        int pxInt2IntDip = ViewUtils.pxInt2IntDip(a10, deviceScreenWidth);
        int pxInt2IntDip2 = ViewUtils.pxInt2IntDip(a10, deviceScreenHeight);
        ValueUtils.putToMap(d(), Integer.valueOf(pxInt2IntDip), "screenLogicWidth");
        ValueUtils.putToMap(d(), Integer.valueOf(pxInt2IntDip2), "screenLogicHeight");
        HashSet hashSet = new HashSet();
        hashSet.add("$configuration.deviceInfo.screenLogicWidth");
        hashSet.add("$configuration.deviceInfo.screenLogicHeight");
        c(hashSet);
    }

    public Set<String> f() {
        return this.f34699b;
    }

    public Set<String> g() {
        return this.f34700c;
    }

    public Object h() {
        return this.f34698a.get(f34696k);
    }

    public void j() {
        this.f34699b.clear();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        Map<String, Object> d10 = d();
        int integerFromMap = ValueUtils.getIntegerFromMap(d10, -1, "windowWidth");
        int integerFromMap2 = ValueUtils.getIntegerFromMap(d10, -1, "windowHeight");
        int i18 = i12 - i10;
        int i19 = i13 - i11;
        final HashSet hashSet = new HashSet();
        if (integerFromMap != i18) {
            hashSet.add("$configuration.deviceInfo.windowWidth");
            ValueUtils.putToMap(d10, Integer.valueOf(i18), "windowWidth");
            hashSet.add("$configuration.deviceInfo.windowLogicWidth");
            ValueUtils.putToMap(d10, Float.valueOf(ViewUtils.px2dip(a(view.getContext()), i18)), "windowLogicWidth");
        }
        if (integerFromMap2 != i19) {
            hashSet.add("$configuration.deviceInfo.windowHeight");
            ValueUtils.putToMap(d10, Integer.valueOf(i19), "windowHeight");
            hashSet.add("$configuration.deviceInfo.windowLogicHeight");
            ValueUtils.putToMap(d10, Float.valueOf(ViewUtils.px2dip(a(view.getContext()), i19)), "windowLogicHeight");
        }
        if (hashSet.isEmpty()) {
            return;
        }
        view.post(new Runnable() { // from class: com.huawei.quickcard.q2
            @Override // java.lang.Runnable
            public final void run() {
                w.this.b(hashSet);
            }
        });
    }

    public void a(IExpressionContext iExpressionContext) {
        if (iExpressionContext == null || Objects.equals(iExpressionContext.get(QuickCardField.CONFIGURATION), this.f34698a)) {
            return;
        }
        iExpressionContext.set(QuickCardField.CONFIGURATION, this.f34698a);
    }

    private String b() {
        IManufacturerDeviceInfo manufacturerDeviceInfo = SystemUtils.getManufacturerDeviceInfo();
        if (manufacturerDeviceInfo != null && manufacturerDeviceInfo.isFoldable()) {
            CardLogUtils.d(f34690e, "device is foldable");
            return manufacturerDeviceInfo.getFoldedState().a();
        }
        CardLogUtils.d(f34690e, "device is not foldable");
        return h0.UNKNOWN.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x000e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<java.lang.String> r7, android.content.res.Configuration r8, boolean r9) {
        /*
            r6 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.Iterator r2 = r7.iterator2()
        Le:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Lbb
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "onConfigChanged:"
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "ConfigurationManager"
            com.huawei.quickcard.base.log.CardLogUtils.d(r5, r4)
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case -1955718283: goto L7e;
                case -1551473093: goto L73;
                case -1439500848: goto L68;
                case -1360635172: goto L5d;
                case -1097462182: goto L52;
                case -845983145: goto L47;
                case -448526825: goto L3c;
                default: goto L3b;
            }
        L3b:
            goto L88
        L3c:
            java.lang.String r5 = "expandState"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L45
            goto L88
        L45:
            r4 = 6
            goto L88
        L47:
            java.lang.String r5 = "uiMode"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L50
            goto L88
        L50:
            r4 = 5
            goto L88
        L52:
            java.lang.String r5 = "locale"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L5b
            goto L88
        L5b:
            r4 = 4
            goto L88
        L5d:
            java.lang.String r5 = "screenDensity"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L66
            goto L88
        L66:
            r4 = 3
            goto L88
        L68:
            java.lang.String r5 = "orientation"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L71
            goto L88
        L71:
            r4 = 2
            goto L88
        L73:
            java.lang.String r5 = "fontScale"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L7c
            goto L88
        L7c:
            r4 = 1
            goto L88
        L7e:
            java.lang.String r5 = "layoutDirection"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L87
            goto L88
        L87:
            r4 = 0
        L88:
            switch(r4) {
                case 0: goto Lb2;
                case 1: goto Lab;
                case 2: goto La6;
                case 3: goto La1;
                case 4: goto L9a;
                case 5: goto L91;
                case 6: goto L8c;
                default: goto L8b;
            }
        L8b:
            goto Le
        L8c:
            r6.a(r1, r8)
            goto Le
        L91:
            int r3 = r8.uiMode
            r3 = r3 & 48
            r6.b(r3, r1, r0)
            goto Le
        L9a:
            java.util.Locale r3 = r8.locale
            r6.a(r3, r1)
            goto Le
        La1:
            r6.a(r8, r1)
            goto Le
        La6:
            r6.a(r8, r1, r0)
            goto Le
        Lab:
            float r3 = r8.fontScale
            r6.a(r3, r1)
            goto Le
        Lb2:
            int r3 = r8.getLayoutDirection()
            r6.a(r3, r1, r0)
            goto Le
        Lbb:
            if (r9 == 0) goto Lc0
            r6.c(r1)
        Lc0:
            boolean r8 = r0.isEmpty()
            if (r8 != 0) goto Lcb
            com.huawei.quickcard.CardContext r8 = r6.f34701d
            r8.onThemeChange(r0)
        Lcb:
            if (r9 == 0) goto Ld0
            r6.a(r7)
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.w.a(java.util.List, android.content.res.Configuration, boolean):void");
    }

    public void c(Context context) {
        String deviceType = DeviceInfoUtils.getDeviceType();
        Map<String, Object> d10 = d();
        ValueUtils.putToMap(d10, deviceType, "deviceType");
        ValueUtils.putToMap(d10, "android", "osType");
        ValueUtils.putToMap(d10, Build.VERSION.RELEASE, "osVersionName");
        ValueUtils.putToMap(d10, Integer.valueOf(Build.VERSION.SDK_INT), "osVersionCode");
        if (context == null) {
            return;
        }
        ValueUtils.putToMap(d10, Float.valueOf(ViewUtils.getAppDensity(context)), ConfigBean.Field.SCREEN_DENSITY);
        ValueUtils.putToMap(d10, NetworkConnectivityMonitor.getInstance().getNetworkType(), ConfigBean.Field.NETWORK_TYPE);
        Map<String, Object> e2 = e();
        ValueUtils.putToMap(e2, Integer.valueOf(QuickCardPlatformUtils.getLibraryVerCode()), "sdkVersionCode");
        ValueUtils.putToMap(e2, Integer.valueOf(QuickCardPlatformUtils.getEngineVer()), "platformVersionCode");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r4, java.util.Set<java.lang.String> r5, java.util.Set<java.lang.String> r6) {
        /*
            r3 = this;
            java.lang.String r0 = "dark"
            java.lang.String r1 = "light"
            r2 = 16
            if (r4 == r2) goto L16
            r2 = 32
            if (r4 == r2) goto L14
            java.lang.String r4 = "ConfigurationManager"
            java.lang.String r2 = "uiMode is not light or dark, set to light."
            com.huawei.quickcard.base.log.CardLogUtils.w(r4, r2)
            goto L16
        L14:
            r4 = r0
            goto L17
        L16:
            r4 = r1
        L17:
            boolean r2 = com.huawei.quickcard.utils.SystemUtils.isQVersion()
            if (r2 != 0) goto L26
            boolean r4 = com.huawei.quickcard.utils.SystemUtils.isDarkThemeEnabled()
            if (r4 == 0) goto L24
            goto L27
        L24:
            r0 = r1
            goto L27
        L26:
            r0 = r4
        L27:
            java.util.Map r4 = r3.d()
            java.lang.String r1 = "uiMode"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            com.huawei.quickcard.utils.ValueUtils.putToMap(r4, r0, r1)
            boolean r1 = r3.a()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r2 = "powerSavingMode"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            com.huawei.quickcard.utils.ValueUtils.putToMap(r4, r1, r2)
            java.lang.String r4 = "$configuration.deviceInfo.uiMode"
            r5.add(r4)
            java.lang.String r4 = "$configuration.deviceInfo.powerSavingMode"
            r5.add(r4)
            java.util.Set r4 = r3.f()
            boolean r4 = r3.a(r4)
            if (r4 != 0) goto L5c
            r6.add(r0)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.w.b(int, java.util.Set, java.util.Set):void");
    }

    @NonNull
    public Map<String, Object> d() {
        return b("deviceInfo");
    }

    private Object c(String str) {
        Object obj = d().get(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (!(obj instanceof Map)) {
            return null;
        }
        Object obj2 = ((Map) obj).get(str);
        if (!(obj2 instanceof String)) {
            return null;
        }
        String str2 = (String) obj2;
        if (str2.trim().length() > 0) {
            return str2;
        }
        return null;
    }

    private void a(Set<String> set, Configuration configuration) {
        b(d(), configuration, set);
        a(d(), configuration, set);
        c(set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Set set) {
        if (this.f34701d.getDataContext() == null) {
            return;
        }
        this.f34701d.getWatcherManager().updateByVars(set);
    }

    private void a(Map<String, Object> map, Configuration configuration, Set<String> set) {
        ValueUtils.putToMap(map, b(), ConfigBean.Field.EXPAND_STATE);
        set.add("$configuration.deviceInfo.expandState");
    }

    @NonNull
    private Map<String, Object> b(@NonNull String str) {
        Object obj = this.f34698a.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        HashMap hashMap = new HashMap();
        this.f34698a.put(str, hashMap);
        return hashMap;
    }

    private void a(@NonNull List<String> list) {
        CardContext cardContext;
        IExpressionContextProxy dataContext;
        if (list.isEmpty() || (cardContext = this.f34701d) == null || (dataContext = cardContext.getDataContext()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", list);
        this.f34701d.callLifeCycleMethod(dataContext, f34697l, hashMap, true);
    }

    @NonNull
    public String c() {
        return JsonUtils.toJsonString(this.f34698a);
    }

    public float b(Context context) {
        Object obj = d().get(ConfigBean.Field.FONT_SCALE);
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        float f10 = context.getResources().getConfiguration().fontScale;
        ValueUtils.putToMap(d(), Float.valueOf(f10), ConfigBean.Field.FONT_SCALE);
        return f10;
    }

    private void a(Configuration configuration, Set<String> set) {
        Context context;
        ViewGroup rootViewGroup = this.f34701d.getRoot().getRootViewGroup();
        if (rootViewGroup == null || (context = rootViewGroup.getContext()) == null) {
            return;
        }
        float appDensity = ViewUtils.getAppDensity(context);
        Map<String, Object> d10 = d();
        ValueUtils.putToMap(d10, Float.valueOf(appDensity), ConfigBean.Field.SCREEN_DENSITY);
        set.add("$configuration.deviceInfo.screenDensity");
        d(context);
        b(d10, configuration, set);
        this.f34701d.getWatcherManager().updateDPWatchers();
    }

    private void a(Configuration configuration, Set<String> set, Set<String> set2) {
        Context context;
        String a10 = a(configuration.orientation);
        Map<String, Object> d10 = d();
        ValueUtils.putToMap(d10, a10, "orientation");
        set.add("$configuration.deviceInfo.orientation");
        b(d10, configuration, set);
        ViewGroup rootViewGroup = this.f34701d.getRoot().getRootViewGroup();
        if (rootViewGroup != null && (context = rootViewGroup.getContext()) != null) {
            int deviceScreenWidth = DeviceInfoUtils.getDeviceScreenWidth(context.getApplicationContext());
            int deviceScreenHeight = DeviceInfoUtils.getDeviceScreenHeight(context.getApplicationContext());
            ValueUtils.putToMap(d10, Integer.valueOf(deviceScreenWidth), "screenWidth");
            ValueUtils.putToMap(d10, Integer.valueOf(deviceScreenHeight), "screenHeight");
            set.add("$configuration.deviceInfo.screenWidth");
            set.add("$configuration.deviceInfo.screenHeight");
            float a11 = a(d10, configuration);
            int pxInt2IntDip = ViewUtils.pxInt2IntDip(a11, deviceScreenWidth);
            int pxInt2IntDip2 = ViewUtils.pxInt2IntDip(a11, deviceScreenHeight);
            ValueUtils.putToMap(d10, Integer.valueOf(pxInt2IntDip), "screenLogicWidth");
            ValueUtils.putToMap(d10, Integer.valueOf(pxInt2IntDip2), "screenLogicHeight");
            set.add("$configuration.deviceInfo.screenLogicWidth");
            set.add("$configuration.deviceInfo.screenLogicHeight");
        }
        set2.add(a10);
    }

    private float a(Map<String, Object> map, Configuration configuration) {
        Object obj = map.get(ConfigBean.Field.SCREEN_DENSITY);
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return configuration.densityDpi / 160.0f;
    }

    private void a(int i10, Set<String> set, Set<String> set2) {
        String str = Attributes.LayoutDirection.LTR;
        if (i10 != 0) {
            if (i10 != 1) {
                CardLogUtils.w(f34690e, "direction is not ltr or rtl, set to ltr.");
            } else {
                str = Attributes.LayoutDirection.RTL;
            }
        }
        ValueUtils.putToMap(d(), str, ConfigBean.Field.LAYOUT_DIRECTION);
        set.add("$configuration.deviceInfo.layoutDirection");
        set2.add(str);
    }

    private boolean a() {
        ThemeMode themeMode = this.f34701d.getThemeMode();
        if (themeMode == ThemeMode.AUTO) {
            return SystemUtils.isDarkThemeEnabled();
        }
        return themeMode == ThemeMode.DARK;
    }

    private void a(Locale locale, Set<String> set) {
        ValueUtils.putToMap(d(), a(locale), FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
        set.add("$configuration.deviceInfo.language.language");
        set.add("$configuration.deviceInfo.language.script");
        set.add("$configuration.deviceInfo.language.country");
    }

    private Map<String, String> a(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String language = locale.getLanguage();
        String script = locale.getScript();
        String country = locale.getCountry();
        HashMap hashMap = new HashMap(3);
        hashMap.put(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, d(language));
        hashMap.put(QuickCardBean.Field.SCRIPT, d(script));
        hashMap.put("country", d(country));
        return hashMap;
    }

    private void a(float f10, Set<String> set) {
        ValueUtils.putToMap(d(), Float.valueOf(f10), ConfigBean.Field.FONT_SCALE);
        set.add("$configuration.deviceInfo.fontScale");
        this.f34701d.getWatcherManager().updateSPWatchers();
    }

    public float a(Context context) {
        Object obj = d().get(ConfigBean.Field.SCREEN_DENSITY);
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        float appDensity = ViewUtils.getAppDensity(context);
        ValueUtils.putToMap(d(), Float.valueOf(appDensity), ConfigBean.Field.SCREEN_DENSITY);
        return appDensity;
    }

    public Object a(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1955718283:
                if (str.equals(ConfigBean.Field.LAYOUT_DIRECTION)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1654788063:
                if (str.equals(f34692g)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1551473093:
                if (str.equals(ConfigBean.Field.FONT_SCALE)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1439500848:
                if (str.equals("orientation")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1360635172:
                if (str.equals(ConfigBean.Field.SCREEN_DENSITY)) {
                    c4 = 4;
                    break;
                }
                break;
            case -845983145:
                if (str.equals(ConfigBean.Field.UI_MODE)) {
                    c4 = 5;
                    break;
                }
                break;
            case -727506176:
                if (str.equals(f34693h)) {
                    c4 = 6;
                    break;
                }
                break;
            case 1975530798:
                if (str.equals(f34691f)) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return d().get(ConfigBean.Field.LAYOUT_DIRECTION);
            case 1:
                return c(QuickCardBean.Field.SCRIPT);
            case 2:
                return d().get(ConfigBean.Field.FONT_SCALE);
            case 3:
                return d().get("orientation");
            case 4:
                return d().get(ConfigBean.Field.SCREEN_DENSITY);
            case 5:
                return d().get(ConfigBean.Field.UI_MODE);
            case 6:
                return c("country");
            case 7:
                return c(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
            default:
                return null;
        }
    }

    public boolean a(Set<String> set) {
        Iterator<String> iterator2 = g().iterator2();
        while (iterator2.hasNext()) {
            if (set.contains(iterator2.next())) {
                return true;
            }
        }
        return false;
    }
}
