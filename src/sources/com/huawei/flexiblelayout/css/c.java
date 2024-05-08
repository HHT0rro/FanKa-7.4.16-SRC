package com.huawei.flexiblelayout.css;

import android.text.TextUtils;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.services.effect.FLEffectService;
import com.huawei.openalliance.ad.constant.u;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: CSSHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28001a = "CSSHelper";

    /* renamed from: b, reason: collision with root package name */
    private static Pattern f28002b = Pattern.compile("\\.[\\w-]+:[\\w-]+((\\s+|((\\s+)~(\\s+)))+\\.[\\w-]+)+\\s*");

    /* renamed from: c, reason: collision with root package name */
    private static Pattern f28003c = Pattern.compile("\\.[\\w-]+:[\\w-]+");

    public static CSSLink a(JSONObject jSONObject) {
        return c(CSSDefinition.INLINE_LINK, jSONObject);
    }

    public static CSSRule b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CSSRule cSSRule = new CSSRule();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            cSSRule.addDeclaration(next, a(jSONObject, next));
        }
        return cSSRule;
    }

    private static CSSLink c(String str, JSONObject jSONObject) {
        CSSDefinition cSSDefinition = new CSSDefinition(a.b().a());
        a(str, jSONObject, cSSDefinition);
        return cSSDefinition.getLink(str);
    }

    private static CSSLink d(String str, JSONObject jSONObject) {
        CSSRule b4;
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        JSONObject a10 = b.a().a(jSONObject);
        CSSLink cSSLink = new CSSLink();
        cSSLink.a(str);
        Iterator<String> keys = a10.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = a10.optJSONObject(next);
            if (optJSONObject != null && (b4 = b(optJSONObject)) != null) {
                cSSLink.addRule(next, b4);
            }
        }
        return cSSLink;
    }

    public static boolean e(String str) {
        return f28002b.matcher(str).matches();
    }

    public static boolean f(String str) {
        return f28003c.matcher(str).matches();
    }

    public static String a(JSONObject jSONObject, String str) {
        if (d(str)) {
            return b(str, jSONObject);
        }
        if (a(str)) {
            return a(str, jSONObject);
        }
        return jSONObject.optString(str);
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("@");
    }

    public static void a(String str, JSONObject jSONObject, CSSDefinition cSSDefinition) {
        if (jSONObject == null || jSONObject.length() == 0 || cSSDefinition == null) {
            return;
        }
        JSONObject a10 = b.a().a(jSONObject);
        CSSLink cSSLink = new CSSLink();
        cSSLink.a(str);
        Iterator<String> keys = a10.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = a10.optJSONObject(next);
            if (optJSONObject != null) {
                if (c(next)) {
                    a(next, str, optJSONObject, cSSDefinition);
                } else if (e(next)) {
                    a(cSSLink, next, optJSONObject);
                } else if (b(next)) {
                    b(cSSLink, next, optJSONObject);
                }
            }
        }
        cSSDefinition.a(str, cSSLink);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(".");
    }

    private static CSSRule b(CSSLink cSSLink, String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        CSSRule rule = cSSLink.getRule(str);
        if (rule == null) {
            rule = new CSSRule();
            cSSLink.addRule(str, rule);
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            rule.addDeclaration(next, a(jSONObject, next));
        }
        return rule;
    }

    private static boolean d(String str) {
        return ((FLEffectService) FLEngine.getInstance(a.b().a()).getService(FLEffectService.class)).isEffect(str);
    }

    private static String b(String str, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject != null) {
            return optJSONObject.toString();
        }
        return null;
    }

    public static void a(CSSLink cSSLink, String str, JSONObject jSONObject) {
        String substring = str.substring(0, str.indexOf(u.bD));
        CSSRule rule = cSSLink.getRule(substring);
        if (rule == null) {
            rule = new CSSRule();
            cSSLink.addRule(substring, rule);
        }
        rule.a(str, jSONObject.toString());
    }

    private static void a(String str, String str2, JSONObject jSONObject, CSSDefinition cSSDefinition) {
        for (String str3 : d.a(str)) {
            CSSLink d10 = d(str2, jSONObject);
            if (d10 != null) {
                cSSDefinition.a(str2, str3, d10);
            }
        }
    }

    private static String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return str + "|" + jSONObject.toString();
    }

    private static boolean a(String str) {
        return com.huawei.flexiblelayout.css.action.a.b().b(str);
    }
}
