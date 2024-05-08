package com.huawei.flexiblelayout.json;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import com.huawei.flexiblelayout.json.impl.JsonArrImpl;
import com.huawei.flexiblelayout.json.impl.JsonArrReaderImpl;
import com.huawei.flexiblelayout.json.impl.JsonArrReaderWrapper;
import com.huawei.flexiblelayout.json.impl.JsonObjImpl;
import com.huawei.flexiblelayout.json.impl.JsonObjReaderImpl;
import com.huawei.flexiblelayout.json.impl.JsonObjReaderWrapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Jsons {
    @NonNull
    public static FLMap newJson() {
        return new JsonObjImpl(new JSONObject());
    }

    @NonNull
    public static FLArray newJsonArray() {
        return new JsonArrImpl(new JSONArray());
    }

    @NonNull
    public static FLImmutableMap toImmutableJson(Object obj) {
        if (obj instanceof String) {
            try {
                obj = new JSONObject((String) obj);
            } catch (JSONException unused) {
            }
        }
        Object immutableJsonIf = toImmutableJsonIf(obj);
        if (immutableJsonIf instanceof FLImmutableMap) {
            return (FLImmutableMap) immutableJsonIf;
        }
        return new JsonObjReaderImpl(new JSONObject());
    }

    public static Object toImmutableJsonIf(Object obj) {
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof FLMap) {
            return new JsonObjReaderWrapper((FLMap) obj);
        }
        if (obj instanceof FLArray) {
            return new JsonArrReaderWrapper((FLArray) obj);
        }
        if ((obj instanceof FLImmutableMap) || (obj instanceof FLImmutableArray)) {
            return obj;
        }
        if (obj instanceof MapModel) {
            return new JsonObjReaderImpl((MapModel) obj);
        }
        if (obj instanceof ListModel) {
            return new JsonArrReaderImpl((ListModel) obj);
        }
        if (obj instanceof JSONObject) {
            return new JsonObjReaderImpl((JSONObject) obj);
        }
        return obj instanceof JSONArray ? new JsonArrReaderImpl((JSONArray) obj) : obj;
    }

    @NonNull
    public static FLMap toJson(Object obj) {
        if (obj instanceof String) {
            try {
                obj = new JSONObject((String) obj);
            } catch (JSONException unused) {
            }
        }
        Object jsonIf = toJsonIf(obj);
        if (jsonIf instanceof FLMap) {
            return (FLMap) jsonIf;
        }
        return new JsonObjImpl(new JSONObject());
    }

    @NonNull
    public static FLArray toJsonArray(Object obj) {
        if (obj instanceof String) {
            try {
                obj = new JSONArray((String) obj);
            } catch (JSONException unused) {
            }
        }
        Object jsonIf = toJsonIf(obj);
        if (jsonIf instanceof FLArray) {
            return (FLArray) jsonIf;
        }
        return new JsonArrImpl(new JSONArray());
    }

    public static Object toJsonIf(Object obj) {
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        if ((obj instanceof FLMap) || (obj instanceof FLArray)) {
            return obj;
        }
        if (obj instanceof MapModel) {
            return new JsonObjImpl((MapModel) obj);
        }
        if (obj instanceof ListModel) {
            return new JsonArrImpl((ListModel) obj);
        }
        if (obj instanceof JSONObject) {
            return new JsonObjImpl((JSONObject) obj);
        }
        return obj instanceof JSONArray ? new JsonArrImpl((JSONArray) obj) : obj;
    }
}
