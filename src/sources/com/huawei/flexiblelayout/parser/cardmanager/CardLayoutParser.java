package com.huawei.flexiblelayout.parser.cardmanager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.ParseException;
import com.huawei.flexiblelayout.parser.cardmanager.d;
import com.huawei.flexiblelayout.parser.directive.ForDirective;
import com.huawei.flexiblelayout.parser.directive.IfDirective;
import com.huawei.flexiblelayout.parser.directive.ImportData;
import com.huawei.flexiblelayout.parser.directive.ModelBinding;
import com.huawei.flexiblelayout.parser.directive.PreloadDirective;
import com.huawei.flexiblelayout.parser.directive.SelfForDirective;
import com.huawei.flexiblelayout.parser.directive.ShowDirective;
import com.huawei.flexiblelayout.parser.directive.StyleDirective;
import com.huawei.flexiblelayout.parser.directive.VarFormula;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardLayoutParser {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28318b = "CardLayoutParser";

    /* renamed from: a, reason: collision with root package name */
    private final FLEngine f28319a;

    public CardLayoutParser(@NonNull FLEngine fLEngine) {
        this.f28319a = fLEngine;
    }

    public static boolean a(String str) {
        return str != null && str.startsWith("{{") && str.endsWith("}}");
    }

    public void b(FLayoutSpec.FCardSpec fCardSpec, JSONObject jSONObject) {
        String optString = jSONObject.optString(d.f28339i);
        if (a(optString)) {
            fCardSpec.directive(new SelfForDirective(optString));
        }
    }

    public void c(FLayoutSpec.FCardSpec fCardSpec, JSONObject jSONObject) {
        String optString = jSONObject.optString("show");
        if (a(optString)) {
            fCardSpec.directive(new ShowDirective(optString));
        }
    }

    public void d(FLayoutSpec.FNodeSpec fNodeSpec, JSONObject jSONObject) {
        String optString = jSONObject.optString(d.f28339i);
        if (a(optString)) {
            fNodeSpec.directive(new SelfForDirective(optString));
        }
    }

    public void e(FLayoutSpec.FNodeSpec fNodeSpec, JSONObject jSONObject) {
        String optString = jSONObject.optString("show");
        if (a(optString)) {
            fNodeSpec.directive(new ShowDirective(optString));
        }
    }

    @NonNull
    public FLayoutSpec.FNodeSpec parseObject(@NonNull JSONObject jSONObject) throws ParseException {
        String optString = jSONObject.optString("name");
        if (!TextUtils.isEmpty(optString)) {
            String optString2 = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString2)) {
                JSONArray optJSONArray = jSONObject.optJSONArray("children");
                if (optJSONArray != null) {
                    FLayoutSpec.FNodeSpec name = FLayoutSpec.node(optString2).id(jSONObject.optString("id")).data(a(jSONObject.opt("data"))).name(optString);
                    a(name, jSONObject);
                    b(name, jSONObject);
                    e(name, jSONObject);
                    a(name, jSONObject.optJSONObject(d.f28337g), jSONObject);
                    c(name, jSONObject);
                    a(name, name, jSONObject, optJSONArray);
                    return name;
                }
                Log.w(f28318b, "'children' must not be null.");
                throw new ParseException("'children' must not be null.");
            }
            Log.w(f28318b, "'type' must not be empty.");
            throw new ParseException("'type' must not be empty.");
        }
        Log.w(f28318b, "'name' must not be empty.");
        throw new ParseException("'name' must not be empty.");
    }

    public void a(FLayoutSpec.FNodeSpec fNodeSpec, JSONObject jSONObject) {
        String optString = jSONObject.optString("for");
        if (a(optString)) {
            fNodeSpec.directive(new ForDirective(optString));
        }
    }

    public void b(FLayoutSpec.FNodeSpec fNodeSpec, JSONObject jSONObject) {
        String optString = jSONObject.optString("if");
        if (a(optString)) {
            fNodeSpec.directive(new IfDirective(optString));
        }
    }

    public void c(FLayoutSpec.FNodeSpec fNodeSpec, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(d.a.f28342a);
        if (optJSONObject != null) {
            String optString = optJSONObject.optString(d.a.f28343b);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            fNodeSpec.directive(new PreloadDirective(this.f28319a, optString, a((Object) optJSONObject.optJSONObject("data"))));
        }
    }

    public void a(FLayoutSpec.FCardSpec fCardSpec, JSONObject jSONObject) {
        String optString = jSONObject.optString("if");
        if (a(optString)) {
            fCardSpec.directive(new IfDirective(optString));
        }
    }

    private void a(FLayoutSpec.FNodeSpec fNodeSpec, FLayoutSpec.FNodeSpec fNodeSpec2, JSONObject jSONObject, JSONArray jSONArray) throws ParseException {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                a(fNodeSpec, fNodeSpec2, jSONObject, optJSONObject);
            }
        }
    }

    private void a(FLayoutSpec.FNodeSpec fNodeSpec, FLayoutSpec.FNodeSpec fNodeSpec2, JSONObject jSONObject, JSONObject jSONObject2) throws ParseException {
        String optString = jSONObject2.optString("type");
        if (!TextUtils.isEmpty(optString)) {
            if (FLResolverRegistry.isDefinedNode(optString)) {
                JSONArray optJSONArray = jSONObject2.optJSONArray("children");
                if (optJSONArray != null) {
                    FLayoutSpec.FNodeSpec data = FLayoutSpec.node(optString).id(jSONObject2.optString("id")).data(a(jSONObject2.opt("data")));
                    a(data, jSONObject2);
                    b(data, jSONObject2);
                    d(data, jSONObject2);
                    e(data, jSONObject2);
                    a(data, jSONObject.optJSONObject(d.f28337g), jSONObject2);
                    c(data, jSONObject2);
                    a(fNodeSpec, data, jSONObject, optJSONArray);
                    fNodeSpec2.child(data);
                    String optString2 = jSONObject2.optString("name");
                    if (TextUtils.isEmpty(optString2)) {
                        return;
                    }
                    data.name(fNodeSpec.name() + "#" + optString2);
                    this.f28319a.registerNodeSpec(data);
                    return;
                }
                Log.w(f28318b, "'children' must not be null.");
                throw new ParseException("'children' must not be null.");
            }
            if (FLResolverRegistry.isDefinedCard(optString)) {
                FLayoutSpec.FCardSpec data2 = FLayoutSpec.card(optString).id(jSONObject2.optString("id")).data(a(jSONObject2.opt("data")));
                a(data2, jSONObject2);
                b(data2, jSONObject2);
                c(data2, jSONObject2);
                a(data2, jSONObject.optJSONObject(d.f28337g), jSONObject2);
                fNodeSpec2.child(data2);
                return;
            }
            Log.w(f28318b, "Ignore, '" + optString + "' is not a node or card.");
            return;
        }
        Log.w(f28318b, "'type' must not be empty.");
        throw new ParseException("'type' must not be empty.");
    }

    public void a(FLayoutSpec.FCardSpec fCardSpec, JSONObject jSONObject, JSONObject jSONObject2) {
        Object opt = jSONObject2.opt("style");
        if (opt instanceof String) {
            fCardSpec.directive(new StyleDirective((String) opt, jSONObject));
        } else if (opt instanceof JSONObject) {
            fCardSpec.directive(new StyleDirective((JSONObject) opt, jSONObject));
        } else if (jSONObject != null) {
            fCardSpec.directive(new StyleDirective(new JSONObject(), jSONObject));
        }
    }

    public void a(FLayoutSpec.FNodeSpec fNodeSpec, JSONObject jSONObject, JSONObject jSONObject2) {
        Object opt = jSONObject2.opt("style");
        if (opt instanceof String) {
            fNodeSpec.directive(new StyleDirective((String) opt, jSONObject));
        } else if (opt instanceof JSONObject) {
            fNodeSpec.directive(new StyleDirective((JSONObject) opt, jSONObject));
        } else if (jSONObject != null) {
            fNodeSpec.directive(new StyleDirective(new JSONObject(), jSONObject));
        }
    }

    public FLMap a(Object obj) {
        if (obj instanceof JSONObject) {
            VarFormula a10 = a((JSONObject) obj);
            if (a10 != null) {
                return new ModelBinding(Jsons.toJson(obj), a10);
            }
            return Jsons.toJson(obj);
        }
        return Jsons.toJson(obj);
    }

    @Nullable
    public VarFormula a(@NonNull JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        ImportData importData = null;
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (StringUtils.NO_PRINT_CODE.equals(next)) {
                if (a(optString)) {
                    importData = new ImportData(optString);
                }
                keys.remove();
            } else if (a(optString)) {
                try {
                    jSONObject.put(next, new VarFormula(optString));
                } catch (JSONException unused) {
                }
            }
        }
        return importData;
    }
}
