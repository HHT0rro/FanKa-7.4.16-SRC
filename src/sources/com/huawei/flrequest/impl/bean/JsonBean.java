package com.huawei.flrequest.impl.bean;

import android.text.TextUtils;
import com.huawei.flexiblelayout.json.codec.JsonException;
import com.huawei.flexiblelayout.json.codec.Jsonable;
import com.huawei.flexiblelayout.json.codec.impl.JsonDecode;
import com.huawei.flexiblelayout.json.codec.impl.JsonEncode;
import com.huawei.flexiblelayout.log.Log;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonBean implements Jsonable {
    private static final String TAG = "JsonBean";
    private final JsonEncode mJsonEncode = new JsonEncode(this);
    private final JsonDecode mJsonDecode = new JsonDecode(this);

    public void deserialize(String str) throws JsonException {
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "deserialize, jsonStr is empty");
            return;
        }
        try {
            deserialize(new JSONObject(str));
        } catch (Exception e2) {
            throw new JsonException("deserialize failed : " + e2.getMessage());
        }
    }

    public String serialize() throws JsonException {
        StringBuilder sb2 = new StringBuilder();
        try {
            this.mJsonEncode.toJson(sb2);
            return sb2.toString();
        } catch (Exception e2) {
            throw new JsonException("serialize failed : " + e2.getMessage());
        }
    }

    public void deserialize(JSONObject jSONObject) throws JsonException {
        try {
            this.mJsonDecode.fromJson(jSONObject);
        } catch (Exception e2) {
            throw new JsonException("deserialize failed : " + e2.getMessage());
        }
    }
}
