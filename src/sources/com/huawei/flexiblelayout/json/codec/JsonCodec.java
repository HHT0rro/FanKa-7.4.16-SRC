package com.huawei.flexiblelayout.json.codec;

import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.json.codec.impl.JsonDecode;
import com.huawei.flexiblelayout.json.codec.impl.JsonEncode;
import com.huawei.flexiblelayout.json.codec.impl.JsonReaderDecode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonCodec {
    private JsonCodec() {
    }

    public static String toJson(Object obj, StringBuilder sb2) throws JsonException {
        if (obj != null && sb2 != null) {
            try {
                new JsonEncode(obj).toJson(sb2);
                return sb2.toString();
            } catch (IllegalAccessException e2) {
                throw new JsonException(e2);
            }
        }
        throw new JsonException("obj or jsonStr must not be null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T toObject(Object obj, Object obj2) throws JsonException {
        if (obj2 != 0 && obj != null) {
            if (obj instanceof JSONObject) {
                try {
                    new JsonDecode(obj2).fromJson((JSONObject) obj);
                } catch (IllegalAccessException e2) {
                    throw new JsonException(e2);
                }
            } else if (obj instanceof String) {
                try {
                    new JsonDecode(obj2).fromJson(new JSONObject((String) obj));
                } catch (IllegalAccessException | JSONException e10) {
                    throw new JsonException(e10);
                }
            } else if (obj instanceof FLImmutableMap) {
                new JsonReaderDecode(obj2).fromJson((FLImmutableMap) obj);
            } else {
                throw new JsonException("Unsupported type: " + ((Object) obj.getClass()));
            }
            return obj2;
        }
        throw new JsonException("obj or json must not be null.");
    }
}
