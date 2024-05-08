package com.huawei.hmf.orb.tbis.type;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BundleRef extends ObjectRef {
    private Bundle mBundle;

    public BundleRef() {
        this.mBundle = new Bundle();
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public Object getData(String str) {
        Bundle bundle = this.mBundle;
        if (bundle == null) {
            return null;
        }
        return bundle.get(str);
    }

    public void setData(String str, Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof String) {
            this.mBundle.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            this.mBundle.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            this.mBundle.putShort(str, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Long) {
            this.mBundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            this.mBundle.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            this.mBundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Boolean) {
            this.mBundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof CharSequence) {
            this.mBundle.putCharSequence(str, (CharSequence) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            this.mBundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            this.mBundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof Serializable) {
            this.mBundle.putSerializable(str, (Serializable) obj);
        }
    }

    @Override // com.huawei.hmf.orb.tbis.type.ObjectRef, com.huawei.hmf.orb.tbis.TBNativeType.Unboxable
    /* renamed from: unboxing, reason: merged with bridge method [inline-methods] */
    public Object unboxing2() {
        Bundle bundle = (Bundle) super.unboxing2();
        if (bundle != null) {
            this.mBundle = bundle;
        }
        return getBundle();
    }

    public BundleRef(Bundle bundle) {
        this.mBundle = bundle;
    }

    public void setData(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            setData(entry.getKey(), entry.getValue());
        }
    }
}
