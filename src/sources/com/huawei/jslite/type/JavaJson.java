package com.huawei.jslite.type;

import com.koushikdutta.quack.JavaScriptObject;
import com.koushikdutta.quack.QuackCoercion;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JavaJson implements JavaObjectProxy {
    public static QuackCoercion<JavaJson, Object> COERCION = new QuackCoercion<JavaJson, Object>() { // from class: com.huawei.jslite.type.JavaJson.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.koushikdutta.quack.QuackCoercion
        public JavaJson coerce(Class cls, Object obj) {
            try {
                return new JavaJson(new JSONObject(((JavaScriptObject) obj).stringify()));
            } catch (JSONException unused) {
                return null;
            }
        }
    };
    private JSONObject mValue;

    public JavaJson(JSONObject jSONObject) {
        this.mValue = jSONObject;
    }

    @Override // com.huawei.jslite.type.JavaObjectProxy
    public Object getFieldValue(String str) {
        try {
            Object obj = this.mValue.get(str);
            Object jsonToJava = TypeAdapter.jsonToJava(obj);
            if (obj != jsonToJava) {
                setFieldValue(str, jsonToJava);
            }
            return jsonToJava;
        } catch (JSONException unused) {
            return null;
        }
    }

    public Object getValue() {
        return this.mValue;
    }

    @Override // com.huawei.jslite.type.JavaObjectProxy
    public void setFieldValue(String str, Object obj) {
        try {
            this.mValue.put(str, TypeAdapter.jsToJava(obj));
        } catch (JSONException unused) {
        }
    }

    public void setValue(JSONObject jSONObject) {
        this.mValue = jSONObject;
    }
}
