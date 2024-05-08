package com.huawei.flexiblelayout.parser.directive;

import android.text.TextUtils;
import com.huawei.flexiblelayout.css.CSSLink;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.CSSSelector;
import com.huawei.flexiblelayout.css.c;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.d;
import com.huawei.flexiblelayout.data.e;
import com.huawei.flexiblelayout.data.f;
import com.huawei.flexiblelayout.data.g;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class StyleDirective extends e implements g, f {

    /* renamed from: g, reason: collision with root package name */
    private static final int f28391g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f28392h = 2;

    /* renamed from: i, reason: collision with root package name */
    private static final int f28393i = 3;

    /* renamed from: a, reason: collision with root package name */
    private int f28394a;

    /* renamed from: b, reason: collision with root package name */
    private VarFormula f28395b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f28396c;

    /* renamed from: d, reason: collision with root package name */
    private String f28397d;

    /* renamed from: e, reason: collision with root package name */
    private final CSSLink f28398e;

    /* renamed from: f, reason: collision with root package name */
    private d f28399f;

    public StyleDirective(String str) {
        this(str, (JSONObject) null);
    }

    public static boolean a(String str) {
        return str != null && str.startsWith("{{") && str.endsWith("}}");
    }

    @Override // com.huawei.flexiblelayout.data.d
    public FLCardData execute(FLayoutSpec.Spec spec, b bVar) {
        FLCardData execute;
        d dVar = this.f28399f;
        if (dVar == null || (execute = dVar.execute(spec, bVar)) == null) {
            return null;
        }
        CSSRule a10 = a(bVar);
        if (a10 != null) {
            e.setCssRule(execute, a10);
        }
        return execute;
    }

    @Override // com.huawei.flexiblelayout.data.e, com.huawei.flexiblelayout.parser.expr.ProcessorResult
    public void processed(Object obj) {
    }

    @Override // com.huawei.flexiblelayout.data.d
    public void setTarget(d dVar) {
        this.f28399f = dVar;
    }

    public StyleDirective(String str, JSONObject jSONObject) {
        if (a(str)) {
            this.f28395b = new VarFormula(str);
            this.f28394a = 1;
        } else {
            try {
                this.f28396c = new JSONObject(str);
                this.f28394a = 2;
            } catch (JSONException unused) {
                this.f28397d = str;
                this.f28394a = 3;
            }
        }
        this.f28398e = c.a(jSONObject);
    }

    public CSSRule a(b bVar) {
        CSSRule cSSRule = null;
        CSSLink a10 = a((bVar == null || bVar.b() == null) ? null : bVar.b().getCssLink(), this.f28398e);
        int i10 = this.f28394a;
        if (i10 == 1) {
            cSSRule = a(a10, this.f28395b, bVar);
        } else if (i10 == 2) {
            cSSRule = a(this.f28396c);
        } else if (i10 == 3) {
            cSSRule = a(a10, this.f28397d);
        }
        if (cSSRule != null) {
            cSSRule.setParent(a10);
        }
        return cSSRule;
    }

    public CSSLink a(CSSLink cSSLink, CSSLink cSSLink2) {
        if (cSSLink == null) {
            return cSSLink2;
        }
        if (cSSLink2 == null) {
            return cSSLink;
        }
        CSSLink.a aVar = new CSSLink.a();
        aVar.a(cSSLink);
        aVar.a(cSSLink2);
        return aVar.a();
    }

    public StyleDirective(JSONObject jSONObject) {
        this(jSONObject, (JSONObject) null);
    }

    public StyleDirective(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f28396c = jSONObject;
        this.f28394a = 2;
        this.f28398e = c.a(jSONObject2);
    }

    public CSSRule a(CSSLink cSSLink, VarFormula varFormula, b bVar) {
        if (varFormula == null) {
            return null;
        }
        Object evaluate = varFormula.evaluate(bVar);
        if (evaluate instanceof MapModel) {
            return a((MapModel) evaluate);
        }
        if (evaluate instanceof JSONObject) {
            return a((JSONObject) evaluate);
        }
        if (evaluate instanceof String) {
            String str = (String) evaluate;
            if (!str.isEmpty()) {
                try {
                    return a(new JSONObject((String) evaluate));
                } catch (JSONException unused) {
                    return a(cSSLink, str);
                }
            }
        }
        return null;
    }

    public CSSRule a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CSSRule cSSRule = new CSSRule();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            cSSRule.addDeclaration(next, c.a(jSONObject, next));
        }
        return cSSRule;
    }

    public CSSRule a(MapModel mapModel) {
        if (mapModel == null) {
            return null;
        }
        CSSRule cSSRule = new CSSRule();
        for (String str : mapModel.keys()) {
            Object obj = mapModel.get(str);
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (!str2.isEmpty()) {
                    cSSRule.addDeclaration(str, str2);
                }
            }
        }
        return cSSRule;
    }

    public CSSRule a(CSSLink cSSLink, String str) {
        if (cSSLink == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return CSSSelector.build(str).getRule(cSSLink);
    }
}
