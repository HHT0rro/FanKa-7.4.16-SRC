package com.huawei.flexiblelayout.css;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.huawei.flexiblelayout.C0862r;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.css.adapter.CSSValueDecoder;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.adapter.value.integrate.CSSValueIntegrator;
import com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSValueWrapper;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.effect.FLEffectService;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSRule {
    public static final String CSSRULE_TAG = "_cssrule_tag_";

    /* renamed from: d, reason: collision with root package name */
    private static final String f27952d = "CSSRule";

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap<String, CSSValue> f27953a = new ArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final TreeMap<String, String> f27954b = new TreeMap<>();

    /* renamed from: c, reason: collision with root package name */
    private CSSLink f27955c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final ArrayList<CSSRule> f27956a = new ArrayList<>();

        public a a(CSSRule cSSRule) {
            if (cSSRule != null) {
                this.f27956a.add(cSSRule);
            }
            return this;
        }

        @NonNull
        public CSSRule a() {
            if (this.f27956a.size() == 1) {
                return this.f27956a.get(0);
            }
            CSSRule cSSRule = new CSSRule();
            for (int size = this.f27956a.size() - 1; size >= 0; size--) {
                a(cSSRule.f27954b, this.f27956a.get(size).f27954b);
            }
            HashSet<String> hashSet = null;
            for (String str : cSSRule.f27954b.h()) {
                if (!c.e(str)) {
                    cSSRule.b(str, (String) cSSRule.f27954b.get(str));
                } else {
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(str);
                }
            }
            if (hashSet != null) {
                for (String str2 : hashSet) {
                    cSSRule.a(str2, (String) cSSRule.f27954b.get(str2));
                }
            }
            return cSSRule;
        }

        private void a(Map<String, String> map, Map<String, String> map2) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                if (map.get(key) == null) {
                    map.put(key, entry.getValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        CSSValue decode;
        CSSValue aVar;
        CSSValueWrapper cSSValueWrapper = CSSValueIntegrator.getInstance().getCSSValueWrapper(str);
        if (cSSValueWrapper != null) {
            str = cSSValueWrapper.getPropertyTag();
            decode = cSSValueWrapper.invoke(this.f27953a.get(str), str2);
        } else {
            if (b(str)) {
                aVar = new C0862r(str2);
            } else if (a(str)) {
                aVar = new com.huawei.flexiblelayout.css.action.value.a(str2);
            } else {
                decode = CSSValueDecoder.getInstance().decode(str, str2);
            }
            decode = aVar;
        }
        if (decode != null) {
            this.f27953a.put(str, decode);
        }
    }

    public void addDeclaration(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f27954b.put(str, str2);
        b(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CSSRule.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(toString(), obj.toString());
    }

    public CSSLink getParent() {
        return this.f27955c;
    }

    @NonNull
    public String[] getPropertyNames() {
        return (String[]) this.f27953a.h().toArray(new String[0]);
    }

    public <T extends CSSValue> T getPropertyValue(String str) {
        T t2 = (T) this.f27953a.get(str);
        if (t2 == null) {
            return null;
        }
        t2.setParent(this);
        return t2;
    }

    public int hashCode() {
        return Objects.hash(toString());
    }

    public void setParent(CSSLink cSSLink) {
        this.f27955c = cSSLink;
    }

    public String toString() {
        return this.f27954b.toString();
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf(u.bD);
            if (indexOf < 2) {
                Log.w(f27952d, "addLinkedDeclaration, key = " + str + "firstColon = " + indexOf);
                return;
            }
            try {
                CSSRule b4 = c.b(new JSONObject(str2));
                if (b4 == null) {
                    Log.w(f27952d, "addLinkedDeclaration, rule == null");
                    return;
                }
                this.f27954b.put(str, str2);
                String substring = str.substring(indexOf);
                int indexOf2 = substring.indexOf(" ");
                CSSValue propertyValue = getPropertyValue(substring.substring(0, indexOf2));
                if (propertyValue != null) {
                    propertyValue.addLinkedRule(new CSSValue.LinkedRule.Builder(substring.substring(indexOf2), b4).build());
                    return;
                }
                return;
            } catch (Exception e2) {
                Log.w(f27952d, "addLinkedDeclaration, key = " + str + ", e: " + e2.getMessage());
                return;
            }
        }
        Log.w(f27952d, "addLinkedDeclaration, key = " + str + "value = " + str2);
    }

    private static boolean b(String str) {
        return ((FLEffectService) FLEngine.getInstance(com.huawei.flexiblelayout.css.a.b().a()).getService(FLEffectService.class)).isEffect(str);
    }

    private static boolean a(String str) {
        return com.huawei.flexiblelayout.css.action.a.b().b(str);
    }
}
