package com.huawei.flexiblelayout.json.codec.impl;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.huawei.flexiblelayout.json.codec.JsonException;
import com.huawei.flexiblelayout.json.codec.Jsonable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonEncode extends a {

    /* renamed from: b, reason: collision with root package name */
    private final Object f28167b;

    public JsonEncode(Object obj) {
        this.f28167b = obj;
    }

    private void a(StringBuilder sb2, Object obj) throws JsonException, IllegalAccessException {
        if (obj instanceof String) {
            sb2.append(JSONObject.quote((String) obj));
            return;
        }
        if (a.a(obj)) {
            sb2.append(obj);
            return;
        }
        if (obj instanceof JSONObject) {
            sb2.append(obj.toString());
            return;
        }
        if (obj instanceof JSONArray) {
            sb2.append(obj.toString());
        } else {
            if (obj instanceof Jsonable) {
                new JsonEncode(obj).toJson(sb2);
                return;
            }
            throw new JsonException("Unsupported type: " + ((Object) obj.getClass()));
        }
    }

    private void b(StringBuilder sb2, Object obj) throws JsonException, IllegalAccessException {
        if (obj instanceof Map) {
            a(sb2, (Map<String, ?>) obj);
            return;
        }
        if (obj instanceof List) {
            a(sb2, (List<?>) obj);
        } else if (obj.getClass().isArray()) {
            a(sb2, Arrays.asList((Object[]) obj));
        } else {
            a(sb2, obj);
        }
    }

    public void toJson(StringBuilder sb2) throws JsonException, IllegalAccessException {
        Object obj;
        Field[] a10 = a.a(this.f28167b.getClass());
        if (a10.length <= 0) {
            return;
        }
        sb2.append("{");
        for (Field field : a10) {
            field.setAccessible(true);
            String jsonName = getJsonName(field);
            if (!TextUtils.isEmpty(jsonName) && (obj = field.get(this.f28167b)) != null) {
                sb2.append("\"");
                sb2.append(jsonName);
                sb2.append("\":");
                b(sb2, obj);
                sb2.append(',');
            }
        }
        a(sb2);
        sb2.append(i.f4738d);
    }

    private void a(StringBuilder sb2, List<?> list) throws JsonException, IllegalAccessException {
        int size = list.size();
        if (size <= 0) {
            sb2.append("[]");
            return;
        }
        sb2.append("[");
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            if (obj != null) {
                a(sb2, obj);
                sb2.append(',');
            }
        }
        a(sb2);
        sb2.append("]");
    }

    private void a(StringBuilder sb2, Map<String, ?> map) throws JsonException, IllegalAccessException {
        if (map.size() <= 0) {
            sb2.append("{}");
            return;
        }
        sb2.append("{");
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                sb2.append("\"");
                sb2.append(key);
                sb2.append("\":");
                a(sb2, value);
                sb2.append(',');
            }
        }
        a(sb2);
        sb2.append(i.f4738d);
    }

    private void a(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }
}
