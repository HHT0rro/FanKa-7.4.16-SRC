package com.huawei.hmf.orb.tbis.type;

import android.content.Intent;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class IntentRef extends ObjectRef {
    private Intent mIntent;

    public IntentRef() {
        this.mIntent = new Intent();
    }

    public String getAction() {
        return this.mIntent.getAction();
    }

    public Object getExtra(String str) {
        if (this.mIntent.getExtras() == null) {
            return null;
        }
        return this.mIntent.getExtras().get(str);
    }

    public int getFlags() {
        return this.mIntent.getFlags();
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getPackage() {
        return this.mIntent.getPackage();
    }

    public void setAction(String str) {
        this.mIntent.setAction(str);
    }

    public void setExtra(String str, Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof String) {
            this.mIntent.putExtra(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            this.mIntent.putExtra(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            this.mIntent.putExtra(str, (Short) obj);
            return;
        }
        if (obj instanceof Long) {
            this.mIntent.putExtra(str, (Long) obj);
            return;
        }
        if (obj instanceof Float) {
            this.mIntent.putExtra(str, (Float) obj);
            return;
        }
        if (obj instanceof Double) {
            this.mIntent.putExtra(str, (Double) obj);
            return;
        }
        if (obj instanceof Boolean) {
            this.mIntent.putExtra(str, (Boolean) obj);
            return;
        }
        if (obj instanceof CharSequence) {
            this.mIntent.putExtra(str, (CharSequence) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            this.mIntent.putExtra(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            this.mIntent.putExtra(str, (byte[]) obj);
        } else if (obj instanceof Serializable) {
            this.mIntent.putExtra(str, (Serializable) obj);
        }
    }

    public void setFlags(int i10) {
        this.mIntent.setFlags(i10);
    }

    public void setPackage(String str) {
        this.mIntent.setPackage(str);
    }

    @Override // com.huawei.hmf.orb.tbis.type.ObjectRef, com.huawei.hmf.orb.tbis.TBNativeType.Unboxable
    /* renamed from: unboxing */
    public Object unboxing2() {
        Intent intent = (Intent) super.unboxing2();
        if (intent != null) {
            this.mIntent = intent;
        }
        return getIntent();
    }

    public IntentRef(Intent intent) {
        this.mIntent = intent;
    }

    public void setExtra(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            setExtra(entry.getKey(), entry.getValue());
        }
    }
}
