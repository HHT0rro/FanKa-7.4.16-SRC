package com.huawei.hms.ads.template;

import android.util.LruCache;
import android.util.Pair;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.gl;
import org.json.JSONObject;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DTManager {
    private static final byte[] I = new byte[0];
    private static DTManager V;
    private final LruCache<String, String> B = new LruCache<>(100);
    private IImageLoader Z;

    private Pair<String, Integer> Code(String str) {
        int indexOf = str.indexOf(91);
        int indexOf2 = str.indexOf(93);
        if (indexOf == -1 && indexOf2 == -1) {
            return null;
        }
        if (indexOf == 0) {
            throw V("[ is in the first character in field: " + str);
        }
        if (indexOf2 < indexOf) {
            throw V("] is in front of [ bracket in field: " + str);
        }
        int i10 = indexOf + 1;
        if (indexOf2 == i10) {
            throw V("It's empty in [] in field: " + str);
        }
        try {
            return new Pair<>(str.substring(0, indexOf), Integer.valueOf(Integer.parseInt(str.substring(i10, indexOf2))));
        } catch (NumberFormatException unused) {
            throw V("Number in [] is not valid in field: " + str);
        }
    }

    private Object Code(JSONObject jSONObject, String str) {
        Pair<String, Integer> Code = Code(str);
        return Code != null ? jSONObject.getJSONArray((String) Code.first).get(((Integer) Code.second).intValue()) : jSONObject.get(str);
    }

    private String Code(int i10, String str) {
        return this.B.get(V(i10, str));
    }

    private void Code(int i10, String str, String str2) {
        this.B.put(V(i10, str), str2);
    }

    private b V(String str) {
        gl.I("DTManager", str);
        return new b(str);
    }

    private String V(int i10, String str) {
        return i10 + "#" + str;
    }

    @GlobalApi
    public static DTManager getInstance() {
        DTManager dTManager;
        synchronized (I) {
            if (V == null) {
                V = new DTManager();
            }
            dTManager = V;
        }
        return dTManager;
    }

    public IImageLoader Code() {
        return this.Z;
    }

    public String Code(String str, JSONObject jSONObject) {
        Object Code;
        if (str == null || jSONObject == null) {
            return null;
        }
        int hashCode = jSONObject.hashCode();
        String Code2 = Code(hashCode, str);
        if (Code2 != null) {
            return Code2;
        }
        if (str.indexOf(46) > 0) {
            String[] split = str.split("\\.");
            int length = split.length;
            for (int i10 = 0; i10 < length; i10++) {
                Code = Code(jSONObject, split[i10]);
                if (i10 != length - 1) {
                    if (!(Code instanceof JSONObject)) {
                        throw V("Placement " + str + " is mismatch with json data");
                    }
                    jSONObject = (JSONObject) Code;
                }
            }
            return null;
        }
        Code = Code(jSONObject, str);
        String valueOf = String.valueOf(Code);
        Code(hashCode, str, valueOf);
        return valueOf;
    }

    @GlobalApi
    public void setImageLoader(IImageLoader iImageLoader) {
        this.Z = iImageLoader;
    }
}
