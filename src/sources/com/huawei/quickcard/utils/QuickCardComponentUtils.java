package com.huawei.quickcard.utils;

import android.view.View;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.framework.value.QuickCardValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardComponentUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class QuickCardComponentInfo {

        /* renamed from: a, reason: collision with root package name */
        private final View f34293a;

        private Map<String, String> a(Set<String> set, PropertyCacheBean propertyCacheBean) {
            HashMap hashMap = new HashMap();
            if (set != null) {
                Map<String, QuickCardValue> attrAndStyle = propertyCacheBean.getAttrAndStyle();
                for (String str : set) {
                    QuickCardValue quickCardValue = attrAndStyle.get(str);
                    if (quickCardValue != null) {
                        hashMap.put(str, quickCardValue.toString());
                    }
                }
            }
            return hashMap;
        }

        public Map<String, String> getAttrs() {
            View view = this.f34293a;
            if (view != null) {
                PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(view);
                return a(obtainPropertyCacheBeanFromView.getAttrNames(), obtainPropertyCacheBeanFromView);
            }
            return new HashMap();
        }

        public String getName() {
            String componentName;
            View view = this.f34293a;
            return (view == null || (componentName = ValueUtils.obtainPropertyCacheBeanFromView(view).getComponentName()) == null) ? "" : componentName;
        }

        public Map<String, String> getStyles() {
            View view = this.f34293a;
            if (view != null) {
                PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(view);
                return a(obtainPropertyCacheBeanFromView.getStyleNames(), obtainPropertyCacheBeanFromView);
            }
            return new HashMap();
        }

        private QuickCardComponentInfo(View view) {
            this.f34293a = view;
        }
    }

    public static QuickCardComponentInfo getComponentInfo(View view) {
        return new QuickCardComponentInfo(view);
    }
}
