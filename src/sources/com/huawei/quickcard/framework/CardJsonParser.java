package com.huawei.quickcard.framework;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.CardIOUtils;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.extension.Experiment;
import com.huawei.quickcard.framework.bean.CardElement;
import com.huawei.quickcard.framework.bean.I18nBean;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.bean.ThemeBean;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.framework.ui.ComponentRegistry;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ExpressionUtils;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.utils.ThemeUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardJsonParser {
    public static final String ENGINE_FRAMEWORK_PATH = "quickcardsdk_framework.js";
    public static final String QUICKCARDSDK_JSFRAMEWORK = "quickcardsdk_template.js";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33729b = "JsonParser";

    /* renamed from: a, reason: collision with root package name */
    private Context f33730a;

    private String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? str3 : String.format(Locale.ENGLISH, str2, str);
    }

    public static int adaptToolkitLevel(JSONObject jSONObject, int i10) {
        if (jSONObject == null || !jSONObject.has(QuickCardBean.Field.TOOLKIT_LEVEL)) {
            return 1001;
        }
        int optInt = jSONObject.optInt(QuickCardBean.Field.TOOLKIT_LEVEL);
        if (optInt != 1002 || i10 >= 1005) {
            return optInt;
        }
        try {
            jSONObject.putOpt(QuickCardBean.Field.TOOLKIT_LEVEL, 1001);
            return 1001;
        } catch (JSONException unused) {
            CardLogUtils.w(f33729b, "unsupported level1001");
            return 1001;
        }
    }

    public static Map<String, QuickCardValue> makeAttrs(String str, JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        IVirtualView virtualView = ComponentRegistry.getVirtualView(str);
        Component component = ComponentRegistry.get(str);
        if ((component != null || virtualView != null) && jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (virtualView != null) {
                    hashMap.put(next, virtualView.makeAttr(next, obj));
                } else {
                    hashMap.put(next, component.toQuickCardValue(next, obj));
                }
            }
        }
        return hashMap;
    }

    public static Set<String> makeEvents(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                hashSet.add(jSONArray.getString(i10));
            }
        }
        return hashSet;
    }

    public static Map<String, Map<String, QuickCardValue>> makeStyles(String str, JSONObject jSONObject) throws JSONException {
        QuickCardValue quickCardValue;
        QuickCardValue quickCardValue2;
        HashMap hashMap = new HashMap(20);
        if (jSONObject != null && jSONObject.length() != 0) {
            IVirtualView virtualView = ComponentRegistry.getVirtualView(str);
            Component component = ComponentRegistry.get(str);
            if (component == null && virtualView == null) {
                return hashMap;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (!"_meta".equals(next)) {
                    int indexOf = next.indexOf(u.bD);
                    if (indexOf != -1) {
                        String substring = next.substring(indexOf + 1);
                        String substring2 = next.substring(0, indexOf);
                        Map map = (Map) hashMap.get(substring2);
                        if (map == null) {
                            map = new HashMap(1);
                        }
                        if (virtualView != null) {
                            quickCardValue = virtualView.makeAttr(substring2, obj);
                        } else {
                            quickCardValue = component.toQuickCardValue(substring2, obj);
                        }
                        map.put(substring, quickCardValue);
                        hashMap.put(substring2, map);
                    } else {
                        Map map2 = (Map) hashMap.get(next);
                        if (map2 == null) {
                            map2 = new HashMap(1);
                        }
                        if (virtualView != null) {
                            quickCardValue2 = virtualView.makeAttr(next, obj);
                        } else {
                            quickCardValue2 = component.toQuickCardValue(next, obj);
                        }
                        map2.put("normal", quickCardValue2);
                        hashMap.put(next, map2);
                    }
                }
            }
        }
        return hashMap;
    }

    @NonNull
    public static JSONObject readCardNode(@NonNull QuickCardBean quickCardBean, @NonNull JSONObject jSONObject, JSONObject jSONObject2, int i10) throws JSONException {
        if (jSONObject2 != null && jSONObject2.has(QuickCardBean.Field.TOOLKIT_LEVEL)) {
            int optInt = jSONObject2.optInt(QuickCardBean.Field.TOOLKIT_LEVEL, 1001);
            if (optInt == 1002 && i10 < 1005) {
                jSONObject2.putOpt(QuickCardBean.Field.TOOLKIT_LEVEL, 1001);
                quickCardBean.setToolkitLevel(1001);
                return jSONObject.getJSONObject(QuickCardBean.Field.CARD);
            }
            quickCardBean.setToolkitLevel(optInt);
        } else {
            quickCardBean.setToolkitLevel(1001);
        }
        return a(jSONObject);
    }

    public static int readToolkitLevel(JSONObject jSONObject) {
        return readToolkitLevel(jSONObject, 1000);
    }

    public boolean parse(String str, @NonNull QuickCardBean quickCardBean) {
        if (str == null) {
            CardLogUtils.w(f33729b, "card json string is null.");
            return false;
        }
        try {
            return parse(new JSONObject(str), quickCardBean);
        } catch (JSONException e2) {
            CardLogUtils.w(f33729b, "parse card content failed", e2);
            return false;
        }
    }

    public void setCtx(Context context) {
        this.f33730a = context;
    }

    private boolean a(@NonNull JSONObject jSONObject, @NonNull CardElement cardElement, Map<String, String> map) {
        try {
            String string = jSONObject.getString("type");
            cardElement.setComponentType(string);
            String string2 = jSONObject.getString(CardElement.Field.REF);
            cardElement.setRef(string2);
            String a10 = a(jSONObject, cardElement, string);
            cardElement.setType(a10);
            map.put(string2, a10);
            Map<String, QuickCardValue> makeAttrs = makeAttrs(a10, jSONObject.optJSONObject(CardElement.Field.ATTRIBUTES));
            if (!makeAttrs.isEmpty()) {
                cardElement.setAttributes(makeAttrs);
            }
            Map<String, Map<String, QuickCardValue>> makeStyles = makeStyles(a10, jSONObject.optJSONObject("style"));
            if (!makeStyles.isEmpty()) {
                cardElement.setStyles(makeStyles);
                Map<String, QuickCardValue> map2 = makeStyles.get(Attributes.AnimationStyle.ANIMATION_NAME);
                if (map2 != null) {
                    QuickCardValue quickCardValue = map2.get("normal");
                    cardElement.setHasAnimation((quickCardValue == null || (quickCardValue.getJsonArray() == null && quickCardValue.getExpression() == null)) ? false : true);
                }
            }
            Set<String> makeEvents = makeEvents(jSONObject.optJSONArray("event"));
            if (!makeEvents.isEmpty()) {
                cardElement.setEvents(makeEvents);
            }
            if (jSONObject.has("children")) {
                JSONArray jSONArray = jSONObject.getJSONArray("children");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    CardElement cardElement2 = new CardElement();
                    a(jSONArray.getJSONObject(i10), cardElement2, map);
                    cardElement.addChild(cardElement2);
                }
            }
            return true;
        } catch (JSONException e2) {
            CardLogUtils.w(f33729b, "parse card element exception:", e2);
            return false;
        }
    }

    public static int readToolkitLevel(JSONObject jSONObject, int i10) {
        return jSONObject != null ? jSONObject.optInt(QuickCardBean.Field.TOOLKIT_LEVEL, i10) : i10;
    }

    public boolean parse(JSONObject jSONObject, @NonNull QuickCardBean quickCardBean) {
        String a10;
        boolean z10 = false;
        if (jSONObject == null) {
            CardLogUtils.w(f33729b, "card json object is null.");
            return false;
        }
        a();
        String a11 = a(jSONObject, "");
        quickCardBean.setCardScript(a11);
        if (Experiment.isTurboMode()) {
            a10 = ExpressionUtils.ALT_TEMPLATE_V2 + StrUtils.null2Empty(a11);
        } else {
            a10 = a(a11, CardIOUtils.readAsset(this.f33730a, QUICKCARDSDK_JSFRAMEWORK), (String) null);
        }
        quickCardBean.setScript(a10);
        quickCardBean.setScriptEngine(jSONObject.optString(QuickCardBean.Field.SCRIPT_ENGINE, null));
        a(jSONObject, quickCardBean);
        JSONObject optJSONObject = jSONObject.optJSONObject(QuickCardBean.Field.OPTIONS);
        quickCardBean.setOptions(optJSONObject);
        HashMap hashMap = new HashMap();
        try {
            JSONObject readCardNode = readCardNode(quickCardBean, jSONObject, optJSONObject, quickCardBean.getMinPLatFormVer());
            CardElement cardElement = new CardElement();
            quickCardBean.setCard(cardElement);
            z10 = a(readCardNode, cardElement, hashMap);
        } catch (JSONException e2) {
            CardLogUtils.w(f33729b, "parse card json exception.", e2);
        }
        if (z10) {
            a(jSONObject, quickCardBean, hashMap);
        }
        return z10;
    }

    private String a(@NonNull JSONObject jSONObject, @NonNull CardElement cardElement, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(CardElement.Field.ATTRIBUTES);
        if (optJSONObject == null) {
            return str;
        }
        String optString = optJSONObject.optString("type");
        if (TextUtils.isEmpty(optString)) {
            return str;
        }
        if ("view".equals(str)) {
            return optString;
        }
        if (Attributes.Component.LIST_ITEM.equals(str)) {
            return str;
        }
        return str + "_" + optString;
    }

    private static void a(JSONObject jSONObject, @NonNull QuickCardBean quickCardBean) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(QuickCardBean.Field.I18N);
        if (optJSONObject2 == null || optJSONObject2.length() == 0 || (optJSONObject = optJSONObject2.optJSONObject(I18nBean.Field.I18N_OBJECT)) == null || optJSONObject.length() == 0) {
            return;
        }
        String optString = optJSONObject2.optString(I18nBean.Field.FALLBACK, null);
        if (optJSONObject.has(optString)) {
            I18nBean i18nBean = new I18nBean(optJSONObject, optString);
            quickCardBean.setI18n(i18nBean);
            String optString2 = optJSONObject2.optString("locale", null);
            if (optJSONObject.has(optString2)) {
                i18nBean.a(optString2);
            }
        }
    }

    private static void a(JSONObject jSONObject, @NonNull QuickCardBean quickCardBean, Map<String, String> map) {
        JSONObject optJSONObject = jSONObject.optJSONObject(QuickCardBean.Field.THEME);
        if (optJSONObject == null || optJSONObject.length() == 0) {
            return;
        }
        ThemeBean themeBean = new ThemeBean(optJSONObject);
        ThemeUtils.splitAttrsAndStyles(themeBean, map);
        quickCardBean.setThemeBean(themeBean);
    }

    private void a() {
        if (TextUtils.isEmpty(ExpressionUtils.sEngineFramework)) {
            ExpressionUtils.sEngineFramework = CardIOUtils.readAsset(this.f33730a, ENGINE_FRAMEWORK_PATH);
        }
    }

    @NonNull
    private String a(@NonNull JSONObject jSONObject, String str) {
        if (jSONObject.has(QuickCardBean.Field.SCRIPT_1005)) {
            CardLogUtils.d(f33729b, "read script1005 node");
            return jSONObject.optString(QuickCardBean.Field.SCRIPT_1005, str);
        }
        CardLogUtils.d(f33729b, "read script node");
        return jSONObject.optString(QuickCardBean.Field.SCRIPT, str);
    }

    @NonNull
    private static JSONObject a(@NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(QuickCardBean.Field.CARD_1005)) {
            CardLogUtils.d(f33729b, "read card1005 node");
            return jSONObject.getJSONObject(QuickCardBean.Field.CARD_1005);
        }
        CardLogUtils.d(f33729b, "read card node");
        return jSONObject.getJSONObject(QuickCardBean.Field.CARD);
    }
}
