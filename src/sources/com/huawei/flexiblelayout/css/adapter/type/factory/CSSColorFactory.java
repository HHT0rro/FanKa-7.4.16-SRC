package com.huawei.flexiblelayout.css.adapter.type.factory;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.flexiblelayout.css.adapter.type.CSSColorList;
import com.huawei.flexiblelayout.css.adapter.type.CSSMonoColor;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSColorFactory implements CSSValueFactory {
    private static List<Pair<String, Integer>> STATE_TABLE = new ArrayList<Pair<String, Integer>>() { // from class: com.huawei.flexiblelayout.css.adapter.type.factory.CSSColorFactory.1
        private static final long serialVersionUID = 3836495972812820826L;

        {
            add(new Pair("pressed", 16842919));
            add(new Pair("focused", 16842908));
            add(new Pair(Attributes.Style.SELECTED, 16842913));
            add(new Pair("checkable", 16842911));
            add(new Pair(Attributes.Style.CHECKED, 16842912));
            add(new Pair("enabled", 16842910));
            add(new Pair("window_focused", 16842909));
            add(new Pair("default", -1));
        }
    };
    private static final String TAG = "CSSColorFactory";

    private boolean isJsonString(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private CSSMonoColor parserColor(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new CSSMonoColor(Color.parseColor(str));
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, str + " Argument format error." + e2.getMessage());
            return null;
        }
    }

    @Override // com.huawei.flexiblelayout.css.adapter.type.factory.CSSValueFactory
    public CSSValue create(String str) {
        if (isJsonString(str)) {
            return parserColorList(str);
        }
        return parserColor(str);
    }

    public CSSColorList parserColorList(String str) {
        CSSMonoColor parserColor;
        try {
            JSONObject jSONObject = new JSONObject(str);
            CSSColorList cSSColorList = new CSSColorList();
            for (Pair<String, Integer> pair : STATE_TABLE) {
                String optString = jSONObject.optString((String) pair.first);
                if (!TextUtils.isEmpty(optString) && (parserColor = parserColor(optString)) != null) {
                    cSSColorList.add(((Integer) pair.second).intValue(), parserColor);
                }
            }
            return cSSColorList;
        } catch (Exception e2) {
            Log.e(TAG, "parser colorList parameter failed from: " + str, e2);
            return null;
        }
    }
}
