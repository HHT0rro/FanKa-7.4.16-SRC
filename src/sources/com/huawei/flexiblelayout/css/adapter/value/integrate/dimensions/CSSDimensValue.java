package com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions;

import android.text.TextUtils;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.log.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSDimensValue extends CSSValue {
    private static final String MATCH_PARENT = "inherit";
    private static final String PERCENT_SIGN = "%";
    private static final String TAG = "CSSDimensValue";
    private static final String UNIT_DP = "dp";
    private static final String UNIT_PX = "px";
    private static final String WRAP_CONTENT = "auto";
    private CSSDimens cssDimens;
    private Map<String, Integer> dimensMap;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CSSDimens {
        private Dimens height = null;
        private Dimens width = null;

        public Dimens getHeight() {
            return this.height;
        }

        public Dimens getWidth() {
            return this.width;
        }

        public void setHeight(Dimens dimens) {
            this.height = dimens;
        }

        public void setWidth(Dimens dimens) {
            this.width = dimens;
        }
    }

    public CSSDimensValue() {
        HashMap hashMap = new HashMap();
        this.dimensMap = hashMap;
        hashMap.put(MATCH_PARENT, -1);
        this.dimensMap.put("auto", -2);
        this.cssDimens = new CSSDimens();
    }

    private Dimens createFixedDimens(String str, String str2) {
        FixedDimens fixedDimens = new FixedDimens();
        int indexOf = str.indexOf(str2);
        if (indexOf <= 0 || !str.endsWith(str2)) {
            str2 = null;
        } else {
            str = str.substring(0, indexOf);
        }
        try {
            fixedDimens.setDimens(Float.parseFloat(str));
            fixedDimens.setUnit(str2);
            return fixedDimens;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private Dimens getDimens(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(PERCENT_SIGN);
            if (indexOf == 0) {
                throw new IllegalArgumentException("getDimens param dimens is %");
            }
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                try {
                    float parseFloat = Float.parseFloat(substring);
                    WeightDimens weightDimens = new WeightDimens();
                    weightDimens.setDimens(parseFloat / 100.0f);
                    return weightDimens;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("getDimens dimens is weight: " + substring);
                }
            }
            FixedDimens fixedDimens = new FixedDimens();
            if (this.dimensMap.containsKey(str)) {
                fixedDimens.setDimens(this.dimensMap.get(str).intValue());
                return fixedDimens;
            }
            Dimens createFixedDimens = createFixedDimens(str, "dp");
            return createFixedDimens == null ? createFixedDimens(str, UNIT_PX) : createFixedDimens;
        }
        throw new IllegalArgumentException("getDimens param dimens is empty");
    }

    public CSSDimens getCssDimens() {
        return this.cssDimens;
    }

    public void setHeight(String str) {
        try {
            this.cssDimens.setHeight(getDimens(str));
        } catch (Exception e2) {
            Log.w(TAG, "setHeight, e: ", e2);
        }
    }

    public void setWidth(String str) {
        try {
            this.cssDimens.setWidth(getDimens(str));
        } catch (Exception e2) {
            Log.w(TAG, "setWidth, e: ", e2);
        }
    }
}
