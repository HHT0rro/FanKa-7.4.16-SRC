package com.huawei.jslite.type;

import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.koushikdutta.quack.JavaScriptObject;
import com.koushikdutta.quack.QuackCoercion;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JavaArray extends AbstractList {
    public static QuackCoercion<JavaArray, Object> COERCION = new QuackCoercion<JavaArray, Object>() { // from class: com.huawei.jslite.type.JavaArray.1
        private JavaArray toArray(JavaScriptObject javaScriptObject) {
            JavaArray javaArray = new JavaArray();
            int intValue = ((Number) javaScriptObject.get(DatabaseSourceInfoStorage.COLUMN_LENGTH)).intValue();
            for (int i10 = 0; i10 < intValue; i10++) {
                javaArray.add(javaScriptObject.get(i10));
            }
            return javaArray;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.koushikdutta.quack.QuackCoercion
        public JavaArray coerce(Class cls, Object obj) {
            if (!(obj instanceof JavaScriptObject)) {
                return null;
            }
            JavaScriptObject javaScriptObject = (JavaScriptObject) obj;
            if (javaScriptObject.isArray()) {
                return toArray(javaScriptObject);
            }
            return null;
        }
    };
    private List<Object> mList = new ArrayList();

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.mList.add(TypeAdapter.jsToJava(obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        return this.mList.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i10, Object obj) {
        return this.mList.set(i10, TypeAdapter.jsToJava(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.mList.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        this.mList.add(i10, TypeAdapter.jsToJava(obj));
    }
}
