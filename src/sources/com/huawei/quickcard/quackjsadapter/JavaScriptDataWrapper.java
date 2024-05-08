package com.huawei.quickcard.quackjsadapter;

import androidx.annotation.NonNull;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.Utils;
import com.huawei.quickcard.base.wrapper.DataWrapper;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.ArrayList;
import java.util.Iterator;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JavaScriptDataWrapper implements DataWrapper<JavaScriptObject> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34192a = "JavaScriptDataWrapper";

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ Object slice(JavaScriptObject javaScriptObject, int i10) {
        return com.huawei.quickcard.base.wrapper.a.c(this, javaScriptObject, i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public /* synthetic */ String toString(JavaScriptObject javaScriptObject) {
        return com.huawei.quickcard.base.wrapper.a.f(this, javaScriptObject);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void add(@NonNull JavaScriptObject javaScriptObject, @NonNull Object obj) {
        Object obj2;
        if (!isArray(javaScriptObject) || (obj2 = javaScriptObject.get(DatabaseSourceInfoStorage.COLUMN_LENGTH)) == null) {
            return;
        }
        set(javaScriptObject, obj2.toString(), obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isArray(@NonNull JavaScriptObject javaScriptObject) {
        return javaScriptObject.isArray();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public boolean isObject(@NonNull JavaScriptObject javaScriptObject) {
        return !isArray(javaScriptObject);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    @NonNull
    public String[] keys(@NonNull JavaScriptObject javaScriptObject) {
        ArrayList arrayList = new ArrayList();
        if (isArray(javaScriptObject)) {
            Iterator iterator2 = javaScriptObject.asJSValue().asIterable(JavaScriptObject.class).iterator2();
            int i10 = 0;
            while (iterator2.hasNext()) {
                iterator2.next();
                arrayList.add(String.valueOf(i10));
                i10++;
            }
        } else {
            JavaScriptObject javaScriptObject2 = (JavaScriptObject) javaScriptObject.quackContext.evaluateForJavaScriptObject("Object.keys").call(javaScriptObject);
            Integer num = (Integer) javaScriptObject2.get(DatabaseSourceInfoStorage.COLUMN_LENGTH);
            for (int i11 = 0; i11 < num.intValue(); i11++) {
                arrayList.add(javaScriptObject2.get(i11).toString());
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public int size(@NonNull JavaScriptObject javaScriptObject) {
        if (isArray(javaScriptObject)) {
            return ((Integer) javaScriptObject.get(DatabaseSourceInfoStorage.COLUMN_LENGTH)).intValue();
        }
        return ((Integer) ((JavaScriptObject) javaScriptObject.quackContext.evaluateForJavaScriptObject("Object.keys").call(javaScriptObject)).get(DatabaseSourceInfoStorage.COLUMN_LENGTH)).intValue();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object slice(@NonNull JavaScriptObject javaScriptObject, int i10, int i11) {
        int size = size(javaScriptObject);
        ArrayList arrayList = new ArrayList();
        if (i10 < 0) {
            i10 += size;
        }
        int max = Math.max(i10, 0);
        if (max >= size) {
            return arrayList;
        }
        if (i11 < 0) {
            i11 += size;
        }
        if (i11 <= max) {
            return arrayList;
        }
        int min = Math.min(i11, size);
        while (max < min) {
            try {
                arrayList.add(javaScriptObject.get(max));
            } catch (Exception unused) {
                CardLogUtils.e(f34192a, "slice err");
            }
            max++;
        }
        return arrayList;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object splice(String str, int i10, @NonNull JavaScriptObject javaScriptObject, int i11, int i12, Object... objArr) {
        int size = size(javaScriptObject);
        if (i11 < 0) {
            i11 += size;
        }
        int max = Math.max(Math.min(i11, size), 0);
        int max2 = Math.max(Math.min(size - max, i12), 0);
        ArrayList arrayList = new ArrayList();
        if (max < size) {
            for (int i13 = max; i13 < max + max2; i13++) {
                arrayList.add(javaScriptObject.get(i13));
            }
        }
        int length = objArr.length - max2;
        int i14 = size + length;
        for (int i15 = i14 - 1; i15 >= max; i15--) {
            if (i15 < objArr.length + max) {
                Object obj = javaScriptObject.get(i15);
                int i16 = i15 - max;
                javaScriptObject.set(i15, objArr[i16]);
                if (str != null) {
                    Utils.notifyDataSet(i10, str + "[" + i15 + "]", obj, objArr[i16]);
                }
            } else if (length != 0) {
                Object obj2 = javaScriptObject.get(i15);
                javaScriptObject.set(i15, javaScriptObject.get(i15 - length));
                if (str != null) {
                    Utils.notifyDataSet(i10, str + "[" + i15 + "]", obj2, javaScriptObject.get(i15));
                }
            }
        }
        javaScriptObject.set(DatabaseSourceInfoStorage.COLUMN_LENGTH, (Object) Integer.valueOf(i14));
        return arrayList;
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public String stringify(@NonNull JavaScriptObject javaScriptObject) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        if (isArray(javaScriptObject)) {
            sb2.append('[');
            while (i10 < size(javaScriptObject)) {
                com.huawei.quickcard.base.wrapper.a.g(sb2, javaScriptObject.get(i10));
                if (i10 < size(javaScriptObject) - 1) {
                    sb2.append(',');
                }
                i10++;
            }
            sb2.append(']');
        } else {
            sb2.append('{');
            String[] keys = keys(javaScriptObject);
            while (i10 < keys.length) {
                try {
                    String str = keys[i10];
                    sb2.append("\"");
                    sb2.append(str);
                    sb2.append("\"");
                    sb2.append(u.bD);
                    com.huawei.quickcard.base.wrapper.a.g(sb2, javaScriptObject.get(keys[i10]));
                    if (i10 < keys.length - 1) {
                        sb2.append(',');
                    }
                    i10++;
                } catch (Exception e2) {
                    CardLogUtils.e(f34192a, "stringify error in javascriptobject", e2);
                }
            }
            sb2.append('}');
        }
        return sb2.toString();
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull JavaScriptObject javaScriptObject, @NonNull String str) {
        return javaScriptObject.get(str);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull JavaScriptObject javaScriptObject, @NonNull String str, Object obj) {
        javaScriptObject.set(str, obj);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public Object get(@NonNull JavaScriptObject javaScriptObject, @NonNull int i10) {
        return javaScriptObject.get(i10);
    }

    @Override // com.huawei.quickcard.base.wrapper.DataWrapper
    public void set(@NonNull JavaScriptObject javaScriptObject, @NonNull int i10, Object obj) {
        javaScriptObject.set(i10, obj);
    }
}
