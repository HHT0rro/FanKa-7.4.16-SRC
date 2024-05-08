package com.huawei.quickcard.quackjsadapter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.jslite.type.JavaObjectProxy;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.interfaces.b;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.Utils;
import com.huawei.quickcard.base.wrapper.DataWrapper;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.koushikdutta.quack.JavaScriptObject;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Objects;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardDataWrapper implements JavaObjectProxy, CardDataObject {
    private static final String[] EXPORT_SETS = {"set", "put", MonitorConstants.CONNECT_TYPE_GET, "size", "keys", "isArray", "toString", "toJSON", "add", "slice", "splice"};
    private static final String TAG = "QuickCardDataWrapper";
    private int $contextId;
    private Object $data;
    private DataWrapper $dataWrapper;
    private String $path;

    public QuickCardDataWrapper(Object obj) {
        init(obj);
    }

    private Object getValue(@NonNull String str) {
        String str2;
        DataWrapper dataWrapper;
        Object obj;
        if (this.$path != null) {
            str2 = this.$path + "." + str;
            Utils.notifyDataGet(this.$contextId, str2);
        } else {
            str2 = null;
        }
        Object obj2 = this.$data;
        if (obj2 == null || (dataWrapper = this.$dataWrapper) == null || (obj = dataWrapper.get((DataWrapper) obj2, str)) == null) {
            return null;
        }
        return wrapNewValue(str2, obj);
    }

    private void init(Object obj) {
        this.$data = obj;
        this.$dataWrapper = wrapData();
    }

    private static boolean isExportedMethod(String str) {
        for (String str2 : EXPORT_SETS) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static Object toRealObject(Object obj) {
        return obj instanceof QuickCardDataWrapper ? ((QuickCardDataWrapper) obj).getOriginalObject() : obj;
    }

    private DataWrapper wrapData() {
        Object obj = this.$data;
        if (obj == null) {
            return null;
        }
        return WrapDataUtils.getDataWrapper(obj);
    }

    private Object wrapNewValue(String str, Object obj) {
        if ((obj instanceof JavaScriptObject) && "function".equals(((JavaScriptObject) obj).typeof())) {
            return obj;
        }
        if (WrapDataUtils.getDataWrapper(obj) != null) {
            return new QuickCardDataWrapper(obj, str, this.$contextId);
        }
        return obj instanceof QuickCardDataWrapper ? new QuickCardDataWrapper(((QuickCardDataWrapper) obj).$data, str, this.$contextId) : obj;
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public void add(@NonNull Object obj) {
        DataWrapper dataWrapper;
        Object obj2 = this.$data;
        if (obj2 == null || (dataWrapper = this.$dataWrapper) == null) {
            return;
        }
        dataWrapper.add(obj2, toRealObject(obj));
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public Object call(Object... objArr) {
        Object obj = this.$data;
        if (!(obj instanceof JavaScriptObject) || !((JavaScriptObject) obj).isFunction()) {
            return null;
        }
        try {
            return ((JavaScriptObject) this.$data).call(objArr);
        } catch (Exception e2) {
            String str = "execute callback script error:" + e2.getMessage();
            CardLogUtils.e(TAG, str);
            CardLogUtils.print2Ide(6, TAG, str);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QuickCardDataWrapper quickCardDataWrapper = (QuickCardDataWrapper) obj;
        return this.$contextId == quickCardDataWrapper.$contextId && this.$data.equals(quickCardDataWrapper.$data) && TextUtils.equals(this.$path, quickCardDataWrapper.$path);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    @Nullable
    public Object get(@NonNull String str) {
        return getValue(str);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ boolean getBooleanValue(String str, boolean z10) {
        return com.huawei.quickcard.base.interfaces.a.a(this, str, z10);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ CardDataObject getCardDataObject(String str) {
        return com.huawei.quickcard.base.interfaces.a.b(this, str);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ Double getDouble(String str) {
        return com.huawei.quickcard.base.interfaces.a.c(this, str);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ double getDoubleValue(String str, double d10) {
        return com.huawei.quickcard.base.interfaces.a.d(this, str, d10);
    }

    @Override // com.huawei.jslite.type.JavaObjectProxy
    public Object getFieldValue(String str) throws NoSuchFieldException {
        if (!isExportedMethod(str)) {
            return getValue(str);
        }
        throw new QuickCardNoSuchFieldException();
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ int getIntValue(String str, int i10) {
        return com.huawei.quickcard.base.interfaces.a.e(this, str, i10);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ Integer getInteger(String str) {
        return com.huawei.quickcard.base.interfaces.a.f(this, str);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public Object getOriginalObject() {
        return this.$data;
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ String getString(int i10) {
        return com.huawei.quickcard.base.interfaces.a.g(this, i10);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ String getString(int i10, String str) {
        return com.huawei.quickcard.base.interfaces.a.h(this, i10, str);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ String getString(String str) {
        return com.huawei.quickcard.base.interfaces.a.i(this, str);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public /* synthetic */ String getString(String str, String str2) {
        return com.huawei.quickcard.base.interfaces.a.j(this, str, str2);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.$contextId), this.$data, this.$path);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public boolean isArray() {
        DataWrapper dataWrapper;
        Object obj = this.$data;
        if (obj == null || (dataWrapper = this.$dataWrapper) == null) {
            return false;
        }
        return dataWrapper.isArray(obj);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    @NonNull
    public String[] keys() {
        Object obj = this.$data;
        if (obj == null) {
            return new String[0];
        }
        DataWrapper dataWrapper = this.$dataWrapper;
        return dataWrapper == null ? new String[0] : dataWrapper.keys(obj);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public /* synthetic */ void put(int i10, Object obj) {
        b.b(this, i10, obj);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public /* synthetic */ void put(String str, Object obj) {
        b.c(this, str, obj);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public void set(@NonNull int i10, @Nullable Object obj) {
        setValue(Integer.valueOf(i10), obj);
    }

    public void setContextId(int i10) {
        this.$contextId = i10;
    }

    public void setData(Object obj) {
        this.$data = obj;
        this.$dataWrapper = wrapData();
    }

    @Override // com.huawei.jslite.type.JavaObjectProxy
    public void setFieldValue(String str, Object obj) {
        setValue(str, obj);
    }

    @Override // com.huawei.quickcard.base.interfaces.CardDataObject
    public void setPath(String str) {
        this.$path = str;
    }

    public void setValue(Object obj, Object obj2) {
        String str;
        Object obj3;
        if (this.$data == null) {
            return;
        }
        if (this.$path == null) {
            str = null;
        } else if ((obj instanceof String) && !Utils.isIntNum((String) obj)) {
            str = this.$path + "." + obj;
        } else {
            str = this.$path + "[" + obj + "]";
        }
        Object realObject = toRealObject(obj2);
        DataWrapper dataWrapper = this.$dataWrapper;
        if (dataWrapper != null) {
            if (obj instanceof String) {
                String str2 = (String) obj;
                obj3 = dataWrapper.get((DataWrapper) this.$data, str2);
                this.$dataWrapper.set((DataWrapper) this.$data, str2, obj2);
            } else {
                if (!(obj instanceof Integer)) {
                    return;
                }
                Integer num = (Integer) obj;
                obj3 = dataWrapper.get((DataWrapper) this.$data, num.intValue());
                this.$dataWrapper.set((DataWrapper) this.$data, num.intValue(), obj2);
            }
            if (str == null || Objects.equals(obj3, realObject)) {
                return;
            }
            Utils.notifyDataSet(this.$contextId, str, obj3, realObject);
            return;
        }
        CardLogUtils.e(TAG, "not support class in setvalue:" + ((Object) this.$data.getClass()));
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public int size() {
        DataWrapper dataWrapper;
        Object obj = this.$data;
        if (obj == null || (dataWrapper = this.$dataWrapper) == null) {
            return 0;
        }
        return dataWrapper.size(obj);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public /* synthetic */ Object slice() {
        return b.e(this);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public /* synthetic */ Object slice(int i10) {
        return b.f(this, i10);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public Object slice(int i10, int i11) {
        Object slice;
        DataWrapper dataWrapper = this.$dataWrapper;
        if (dataWrapper == null || (slice = dataWrapper.slice(this.$data, i10, i11)) == null) {
            return null;
        }
        return new QuickCardDataWrapper(slice, null, this.$contextId);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public /* synthetic */ Object splice(int i10) {
        return b.g(this, i10);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public Object splice(int i10, int i11, Object... objArr) {
        Object splice;
        DataWrapper dataWrapper = this.$dataWrapper;
        if (dataWrapper == null || (splice = dataWrapper.splice(this.$path, this.$contextId, this.$data, i10, i11, objArr)) == null) {
            return null;
        }
        return new QuickCardDataWrapper(splice, null, this.$contextId);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    @NonNull
    public Object toJSON() {
        DataWrapper dataWrapper = this.$dataWrapper;
        if (dataWrapper == null) {
            Object obj = this.$data;
            return obj != null ? obj.toString() : "";
        }
        return dataWrapper.stringify(this.$data);
    }

    public String toString() {
        DataWrapper dataWrapper = this.$dataWrapper;
        if (dataWrapper == null) {
            Object obj = this.$data;
            return obj != null ? obj.toString() : "";
        }
        return dataWrapper.toString(this.$data);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    @Nullable
    public Object get(@NonNull int i10) {
        return getValue(i10);
    }

    @Override // com.huawei.quickcard.base.interfaces.IQuickCardData
    public void set(@NonNull String str, Object obj) {
        setFieldValue(str, obj);
    }

    public QuickCardDataWrapper(Object obj, String str, int i10) {
        init(obj);
        this.$path = str;
        this.$contextId = i10;
    }

    private Object getValue(int i10) {
        String str;
        DataWrapper dataWrapper;
        Object obj;
        if (this.$path != null) {
            str = this.$path + "[" + i10 + "]";
            Utils.notifyDataGet(this.$contextId, str);
        } else {
            str = null;
        }
        Object obj2 = this.$data;
        if (obj2 == null || (dataWrapper = this.$dataWrapper) == null || (obj = dataWrapper.get((DataWrapper) obj2, i10)) == null) {
            return null;
        }
        return wrapNewValue(str, obj);
    }
}
