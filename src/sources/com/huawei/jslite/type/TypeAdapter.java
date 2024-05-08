package com.huawei.jslite.type;

import com.koushikdutta.quack.JavaScriptObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class TypeAdapter {
    public static Object jsToJava(Object obj) {
        if (!(obj instanceof JavaScriptObject)) {
            return obj;
        }
        JavaScriptObject javaScriptObject = (JavaScriptObject) obj;
        if (javaScriptObject.isArray()) {
            return javaScriptObject.quackContext.coerceJavaScriptToJava(JavaArray.class, javaScriptObject);
        }
        return javaScriptObject.quackContext.coerceJavaScriptToJava(JavaJson.class, javaScriptObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.huawei.jslite.type.JavaArray] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.huawei.jslite.type.JavaJson] */
    public static Object jsonToJava(Object obj) {
        Object javaArray;
        if (obj instanceof JSONObject) {
            javaArray = new JavaJson((JSONObject) obj);
        } else {
            if (!(obj instanceof JSONArray)) {
                return obj;
            }
            javaArray = new JavaArray();
            JSONArray jSONArray = (JSONArray) obj;
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    javaArray.add(jsonToJava(jSONArray.get(i10)));
                } catch (JSONException unused) {
                }
            }
        }
        return javaArray;
    }
}
