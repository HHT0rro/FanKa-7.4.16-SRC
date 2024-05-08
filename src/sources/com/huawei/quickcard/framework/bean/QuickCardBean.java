package com.huawei.quickcard.framework.bean;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import org.json.JSONObject;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardBean {

    /* renamed from: a, reason: collision with root package name */
    private String f33803a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f33804b = "";

    /* renamed from: c, reason: collision with root package name */
    private I18nBean f33805c;

    /* renamed from: d, reason: collision with root package name */
    private String f33806d;

    /* renamed from: e, reason: collision with root package name */
    private CardElement f33807e;

    /* renamed from: f, reason: collision with root package name */
    private ThemeBean f33808f;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f33809g;

    /* renamed from: h, reason: collision with root package name */
    private int f33810h;

    /* renamed from: i, reason: collision with root package name */
    private int f33811i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Field {
        public static final String CARD = "card";
        public static final String CARD_1005 = "card1005";
        public static final String I18N = "i18n";
        public static final String MIN_PLATFORM_VER = "minPlatformVer";
        public static final String OPTIONS = "options";
        public static final String SCRIPT = "script";
        public static final String SCRIPT_1005 = "script1005";
        public static final String SCRIPT_ENGINE = "scriptEngine";
        public static final String THEME = "theme";
        public static final String TOOLKIT_LEVEL = "toolkitLevel";
    }

    public CardElement getCard() {
        return this.f33807e;
    }

    public String getCardScript() {
        return this.f33804b;
    }

    public I18nBean getI18n() {
        return this.f33805c;
    }

    public int getMinPLatFormVer() {
        return this.f33810h;
    }

    public JSONObject getOptions() {
        return this.f33809g;
    }

    @NonNull
    public String getScript() {
        return this.f33803a;
    }

    public String getScriptEngine() {
        return this.f33806d;
    }

    public ThemeBean getThemeBean() {
        return this.f33808f;
    }

    public int getToolkitLevel() {
        return this.f33811i;
    }

    public void setCard(CardElement cardElement) {
        this.f33807e = cardElement;
    }

    public void setCardScript(String str) {
        this.f33804b = str;
    }

    public void setI18n(I18nBean i18nBean) {
        this.f33805c = i18nBean;
    }

    public void setMinPLatFormVer(int i10) {
        this.f33810h = i10;
    }

    public void setOptions(JSONObject jSONObject) {
        this.f33809g = jSONObject;
    }

    public void setScript(String str) {
        if (str == null) {
            str = "";
        }
        this.f33803a = str;
    }

    public void setScriptEngine(String str) {
        this.f33806d = str;
    }

    public void setThemeBean(ThemeBean themeBean) {
        this.f33808f = themeBean;
    }

    public void setToolkitLevel(int i10) {
        this.f33811i = i10;
    }
}
