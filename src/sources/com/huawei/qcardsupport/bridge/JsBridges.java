package com.huawei.qcardsupport.bridge;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.json.Jsons;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsBridges {
    public static Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof FLImmutableMap) {
            return new JsObjectBridge((FLImmutableMap) obj);
        }
        return obj instanceof FLImmutableArray ? new JsArrayBridge((FLImmutableArray) obj) : obj;
    }

    @NonNull
    public static JsObjectBridge toJsObjectBridge(FLImmutableMap fLImmutableMap) {
        if (fLImmutableMap == null) {
            return new JsObjectBridge(Jsons.toImmutableJson(new JSONObject()));
        }
        return new JsObjectBridge(fLImmutableMap);
    }
}
