package com.alibaba.security.biometrics.service.util.params;

import android.os.Bundle;
import com.alibaba.security.common.utils.GenericsUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ParamsHelper<T> {
    private static final String TAG = "ParamsHelper";
    public Parceler<T> paramsParceler;

    public ParamsHelper(Bundle bundle) {
        createParamsByBundle(bundle);
    }

    public void clear() {
        this.paramsParceler = null;
    }

    public void copyParams(Bundle bundle) {
        if (bundle == null || this.paramsParceler == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            this.paramsParceler.put(str, bundle.get(str));
        }
    }

    public void createParamsByBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.paramsParceler = new Parceler().createParceler(GenericsUtils.getSuperClassGenericType(getClass())).addAll(bundle);
    }

    public Object getParam(String str) {
        Parceler<T> parceler = this.paramsParceler;
        if (parceler == null) {
            return null;
        }
        return parceler.get(str);
    }

    public T getParams() {
        Parceler<T> parceler = this.paramsParceler;
        if (parceler == null) {
            return null;
        }
        return parceler.getParamsObject();
    }

    public void setParam(String str, Object obj) {
        Parceler<T> parceler = this.paramsParceler;
        if (parceler == null) {
            return;
        }
        parceler.put(str, obj);
    }

    public void setParams(Bundle bundle) {
        createParamsByBundle(bundle);
    }
}
