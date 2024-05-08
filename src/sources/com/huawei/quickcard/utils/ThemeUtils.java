package com.huawei.quickcard.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.ThemeMode;
import com.huawei.quickcard.b2;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.framework.IVirtualViewParent;
import com.huawei.quickcard.framework.bean.ThemeBean;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.framework.ui.ComponentRegistry;
import com.huawei.quickcard.framework.ui.RenderCommand;
import com.huawei.quickcard.framework.ui.RenderPipeline;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.views.text.utils.SpannableUtils;
import com.huawei.quickcard.z0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ThemeUtils {
    private static void a(String str, String str2, String str3, QuickCardValue quickCardValue, Map<String, Map<String, Map<String, QuickCardValue>>> map) {
        Map<String, Map<String, QuickCardValue>> map2 = map.get(str);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str, map2);
        }
        Map<String, QuickCardValue> map3 = map2.get(str2);
        if (map3 == null) {
            map3 = new HashMap<>();
            map2.put(str2, map3);
        }
        map3.put(str3, quickCardValue);
    }

    public static void adaptUiMode(@NonNull Configuration configuration, @NonNull ThemeMode themeMode, @NonNull Context context) {
        boolean isDarkThemeEnabled = SystemUtils.isDarkThemeEnabled(configuration);
        if (themeMode == ThemeMode.LIGHT && isDarkThemeEnabled) {
            configuration.uiMode = SystemUtils.buildConfigUiMode(configuration, 16);
        } else if (themeMode == ThemeMode.DARK && !isDarkThemeEnabled) {
            configuration.uiMode = SystemUtils.buildConfigUiMode(configuration, 32);
        } else {
            configuration.uiMode = context.getApplicationContext().getResources().getConfiguration().uiMode;
        }
    }

    private static void b(CardContext cardContext, ThemeBean themeBean, String str, Map<Integer, Map<View, RenderPipeline>> map) {
        View view;
        Component component;
        Map<String, Map<String, QuickCardValue>> value;
        Iterator<Map.Entry<String, Map<String, Map<String, QuickCardValue>>>> it;
        Map<String, QuickCardValue> map2;
        Map<String, Map<String, Map<String, QuickCardValue>>> map3 = themeBean.getThemeStylesMap().get(str);
        if (map3 == null || map3.isEmpty()) {
            return;
        }
        Map<String, Set<WeakReference<View>>> themeViewMap = themeBean.getThemeViewMap();
        Iterator<Map.Entry<String, Map<String, Map<String, QuickCardValue>>>> iterator2 = map3.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map.Entry<String, Map<String, Map<String, QuickCardValue>>> next = iterator2.next();
            Set<WeakReference<View>> set = themeViewMap.get(next.getKey());
            if (set != null) {
                for (WeakReference<View> weakReference : set) {
                    if (weakReference != null && (component = ViewUtils.getComponent((view = weakReference.get()))) != null && (value = next.getValue()) != null) {
                        RenderPipeline a10 = a(map, view);
                        for (Map.Entry<String, Map<String, QuickCardValue>> entry : value.entrySet()) {
                            z0 z0Var = (z0) view.getTag(R.id.quick_card_pseudo_class);
                            if (z0Var != null) {
                                String key = entry.getKey();
                                Map<String, QuickCardValue> value2 = entry.getValue();
                                if (value2 != null) {
                                    boolean z10 = false;
                                    Iterator<Map.Entry<String, Boolean>> iterator22 = z0Var.b().entrySet().iterator2();
                                    while (true) {
                                        if (!iterator22.hasNext()) {
                                            it = iterator2;
                                            map2 = value2;
                                            break;
                                        }
                                        Map.Entry<String, Boolean> next2 = iterator22.next();
                                        String key2 = next2.getKey();
                                        if (next2.getValue().booleanValue() && value2.containsKey(key2)) {
                                            it = iterator2;
                                            map2 = value2;
                                            a(key, value2.get(key2), cardContext, view, component, a10);
                                            z10 = true;
                                            break;
                                        }
                                    }
                                    if (!z10) {
                                        a(key, map2.get("normal"), cardContext, view, component, a10);
                                    }
                                    iterator2 = it;
                                }
                            }
                        }
                        component.updateHostViewStyles(view, value);
                    }
                }
            }
        }
    }

    public static Map<String, b2> getVirtualInfos(int i10, ThemeBean themeBean) {
        if (themeBean == null) {
            return null;
        }
        Map<String, b2> map = themeBean.getVirtualViewInfos().get(Integer.valueOf(i10));
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        themeBean.getVirtualViewInfos().put(Integer.valueOf(i10), hashMap);
        return hashMap;
    }

    public static Set<Object> getVirtualRefs(int i10, ThemeBean themeBean) {
        if (themeBean == null) {
            return null;
        }
        Set<Object> set = themeBean.getVirtualViewRefs().get(Integer.valueOf(i10));
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        themeBean.getVirtualViewRefs().put(Integer.valueOf(i10), hashSet);
        return hashSet;
    }

    public static void onThemeChange(@NonNull ThemeBean themeBean, CardContext cardContext, Set<String> set) {
        if (set == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (String str : set) {
            a(cardContext, themeBean, str, hashMap);
            b(cardContext, themeBean, str, hashMap);
        }
        Iterator iterator2 = hashMap.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map map = (Map) ((Map.Entry) iterator2.next()).getValue();
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) entry.getKey();
                    RenderPipeline renderPipeline = (RenderPipeline) entry.getValue();
                    if (view != null && renderPipeline != null) {
                        renderPipeline.render(cardContext, view);
                    }
                }
            }
        }
        Iterator<String> iterator22 = set.iterator2();
        while (iterator22.hasNext()) {
            a(themeBean, iterator22.next(), cardContext);
        }
    }

    public static void replaceAttrsAndStyles(@NonNull ThemeBean themeBean, Set<String> set, @NonNull Map<String, QuickCardValue> map, @NonNull Map<String, Map<String, QuickCardValue>> map2, String str) {
        Map<String, Map<String, QuickCardValue>> map3;
        Map<String, QuickCardValue> map4;
        if (set == null) {
            return;
        }
        for (String str2 : set) {
            Map<String, Map<String, QuickCardValue>> map5 = themeBean.getThemeAttrsMap().get(str2);
            if (map5 != null && (map4 = map5.get(str)) != null) {
                map.putAll(map4);
            }
            Map<String, Map<String, Map<String, QuickCardValue>>> map6 = themeBean.getThemeStylesMap().get(str2);
            if (map6 != null && (map3 = map6.get(str)) != null) {
                for (Map.Entry<String, Map<String, QuickCardValue>> entry : map3.entrySet()) {
                    String key = entry.getKey();
                    HashMap hashMap = new HashMap(entry.getValue());
                    if (map2.containsKey(key)) {
                        map2.get(key).putAll(hashMap);
                    } else {
                        map2.put(key, hashMap);
                    }
                }
            }
        }
    }

    public static void replaceVirtualAttrsAndStyles(Set<String> set, b2 b2Var, @NonNull Map<String, QuickCardValue> map, @NonNull Map<String, Map<String, QuickCardValue>> map2) {
        if (b2Var == null || set == null) {
            return;
        }
        for (String str : set) {
            Map<String, QuickCardValue> map3 = b2Var.c().get(str);
            if (map3 != null) {
                map.putAll(map3);
            }
            Map<String, QuickCardValue> map4 = b2Var.d().get(str);
            if (map4 != null) {
                for (Map.Entry<String, QuickCardValue> entry : map4.entrySet()) {
                    String key = entry.getKey();
                    QuickCardValue value = entry.getValue();
                    HashMap hashMap = new HashMap();
                    hashMap.put("normal", value);
                    map2.put(key, hashMap);
                }
            }
        }
    }

    public static void splitAttrsAndStyles(@NonNull ThemeBean themeBean, Map<String, String> map) {
        Component component;
        JSONObject themeContent = themeBean.getThemeContent();
        if (themeContent == null) {
            return;
        }
        Set<String> refs = themeBean.getRefs();
        Iterator<String> keys = themeContent.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = themeContent.optJSONObject(next);
            if (optJSONObject != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(key);
                    if (optJSONObject2 != null && ComponentRegistry.getVirtualView(entry.getValue()) == null && (component = ComponentRegistry.get(entry.getValue())) != null) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("attrs");
                        if (optJSONObject3 != null) {
                            refs.add(key);
                            Iterator<String> keys2 = optJSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                a(next, key, next2, component.toQuickCardValue(next2, optJSONObject3.opt(next2)), themeBean.getThemeAttrsMap());
                            }
                        }
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("styles");
                        if (optJSONObject4 != null) {
                            refs.add(key);
                            Iterator<String> keys3 = optJSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                a(next, key, next3, optJSONObject4.opt(next3), component, themeBean.getThemeStylesMap());
                            }
                        }
                    }
                }
            }
        }
    }

    public static b2 splitVirtualAttrsAndStyles(IVirtualViewParent iVirtualViewParent, String str, String str2, @NonNull ThemeBean themeBean) {
        JSONObject optJSONObject;
        JSONObject themeContent = themeBean.getThemeContent();
        Map<String, b2> virtualInfos = getVirtualInfos(iVirtualViewParent.hashCode(), themeBean);
        b2 b2Var = null;
        if (themeContent == null) {
            return null;
        }
        Iterator<String> keys = themeContent.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject2 = themeContent.optJSONObject(next);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(str)) != null) {
                b2Var = virtualInfos.get(str);
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("attrs");
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("styles");
                if (b2Var == null && (optJSONObject3 != null || optJSONObject4 != null)) {
                    b2Var = new b2();
                    virtualInfos.put(str, b2Var);
                    b2Var.a(str);
                    b2Var.b(str2);
                    b2Var.a(iVirtualViewParent);
                }
                if (optJSONObject3 != null) {
                    a(next, optJSONObject3, b2Var.c());
                }
                if (optJSONObject4 != null) {
                    a(next, optJSONObject4, b2Var.d());
                }
            }
        }
        return b2Var;
    }

    private static void a(String str, String str2, String str3, Object obj, Component component, Map<String, Map<String, Map<String, Map<String, QuickCardValue>>>> map) {
        Map<String, Map<String, Map<String, QuickCardValue>>> map2 = map.get(str);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str, map2);
        }
        Map<String, Map<String, QuickCardValue>> map3 = map2.get(str2);
        if (map3 == null) {
            map3 = new HashMap<>();
            map2.put(str2, map3);
        }
        int indexOf = str3.indexOf(u.bD);
        if (indexOf != -1) {
            String substring = str3.substring(indexOf + 1);
            String substring2 = str3.substring(0, indexOf);
            Map<String, QuickCardValue> map4 = map3.get(substring2);
            if (map4 == null) {
                map4 = new HashMap<>(1);
                map3.put(substring2, map4);
            }
            map4.put(substring, component.toQuickCardValue(substring2, obj));
            return;
        }
        Map<String, QuickCardValue> map5 = map3.get(str3);
        if (map5 == null) {
            map5 = new HashMap<>(1);
            map3.put(str3, map5);
        }
        map5.put("normal", component.toQuickCardValue(str3, obj));
    }

    private static void a(CardContext cardContext, ThemeBean themeBean, String str, Map<Integer, Map<View, RenderPipeline>> map) {
        View view;
        Component component;
        Map<String, QuickCardValue> value;
        Map<String, Map<String, QuickCardValue>> map2 = themeBean.getThemeAttrsMap().get(str);
        if (map2 == null || map2.isEmpty()) {
            return;
        }
        Map<String, Set<WeakReference<View>>> themeViewMap = themeBean.getThemeViewMap();
        for (Map.Entry<String, Map<String, QuickCardValue>> entry : map2.entrySet()) {
            Set<WeakReference<View>> set = themeViewMap.get(entry.getKey());
            if (set != null) {
                for (WeakReference<View> weakReference : set) {
                    if (weakReference != null && (component = ViewUtils.getComponent((view = weakReference.get()))) != null && (value = entry.getValue()) != null) {
                        RenderPipeline a10 = a(map, view);
                        for (Map.Entry<String, QuickCardValue> entry2 : value.entrySet()) {
                            a(entry2.getKey(), entry2.getValue(), cardContext, view, component, a10);
                        }
                    }
                }
            }
        }
    }

    private static RenderPipeline a(Map<Integer, Map<View, RenderPipeline>> map, View view) {
        Map<View, RenderPipeline> map2 = map.get(Integer.valueOf(view.hashCode()));
        if (map2 == null) {
            RenderPipeline renderPipeline = new RenderPipeline();
            HashMap hashMap = new HashMap(1);
            hashMap.put(view, renderPipeline);
            map.put(Integer.valueOf(view.hashCode()), hashMap);
            return renderPipeline;
        }
        RenderPipeline renderPipeline2 = map2.get(view);
        if (renderPipeline2 == null) {
            renderPipeline2 = new RenderPipeline();
            map2.put(view, renderPipeline2);
        }
        return renderPipeline2;
    }

    private static void a(String str, QuickCardValue quickCardValue, CardContext cardContext, View view, Component component, RenderPipeline renderPipeline) {
        if (quickCardValue != null && quickCardValue.getExpression() != null) {
            quickCardValue = component.toQuickCardValue(str, cardContext.executeExpr(ViewUtils.composeForItemScript(view, quickCardValue.getExpression().getSrc(), true), false));
        }
        ValueUtils.obtainPropertyCacheBeanFromView(view).saveAttrOrStyle(str, quickCardValue);
        RenderCommand buildRenderCommand = component.buildRenderCommand(view, str, quickCardValue);
        if (buildRenderCommand == null || quickCardValue == null) {
            return;
        }
        renderPipeline.addCommand(buildRenderCommand);
    }

    private static void a(String str, JSONObject jSONObject, Map<String, Map<String, QuickCardValue>> map) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            Map<String, QuickCardValue> map2 = map.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(str, map2);
            }
            map2.put(next, a(next, opt));
        }
    }

    private static QuickCardValue a(String str, Object obj) {
        QuickCardValue wrap = QuickCardValue.wrap(obj);
        return wrap.isExpression() ? wrap : SpannableUtils.wrapQuickcardValue(str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(@NonNull ThemeBean themeBean, String str, CardContext cardContext) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<Integer, Set<Object>> virtualViewRefs = themeBean.getVirtualViewRefs();
        Map<Integer, Map<String, b2>> virtualViewInfos = themeBean.getVirtualViewInfos();
        for (Map.Entry<Integer, Set<Object>> entry : virtualViewRefs.entrySet()) {
            int intValue = entry.getKey().intValue();
            Set<Object> value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(value);
            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                for (Object obj : (Set) arrayList2.get(i10)) {
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        for (Object obj2 : map.h()) {
                            if (obj2 instanceof String) {
                                arrayList.add(String.valueOf(obj2));
                                Object obj3 = map.get(String.valueOf(obj2));
                                if (obj3 instanceof Set) {
                                    arrayList2.add((Set) obj3);
                                }
                            }
                        }
                    } else if (obj instanceof String) {
                        arrayList.add(String.valueOf(obj));
                    }
                }
            }
            Map<String, b2> map2 = virtualViewInfos.get(Integer.valueOf(intValue));
            IVirtualViewParent iVirtualViewParent = null;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                b2 b2Var = map2.get((String) arrayList.get(i11));
                if (b2Var != null && (iVirtualViewParent = b2Var.b()) != null) {
                    a(b2Var.c().get(str), cardContext, iVirtualViewParent, b2Var);
                    a(b2Var.d().get(str), cardContext, iVirtualViewParent, b2Var);
                }
            }
            if (iVirtualViewParent != null) {
                iVirtualViewParent.renderChildren();
            }
        }
    }

    private static void a(Map<String, QuickCardValue> map, CardContext cardContext, IVirtualViewParent iVirtualViewParent, b2 b2Var) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, QuickCardValue> entry : map.entrySet()) {
            QuickCardValue value = entry.getValue();
            if (value != null && value.getExpression() != null) {
                value = a(entry.getKey(), cardContext.executeExpr(value.getExpression().getSrc(), false));
            }
            iVirtualViewParent.setChildProperties(b2Var.a(), b2Var.e(), entry.getKey(), value);
        }
    }
}
