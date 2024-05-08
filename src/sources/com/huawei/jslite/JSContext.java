package com.huawei.jslite;

import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.jslite.JSContext;
import com.huawei.jslite.type.CoerceJavaScriptToJava;
import com.huawei.jslite.type.JavaArray;
import com.huawei.jslite.type.JavaJson;
import com.koushikdutta.quack.JavaScriptObject;
import com.koushikdutta.quack.QuackCoercion;
import com.koushikdutta.quack.QuackContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JSContext {
    private static final String TAG = "JSContext";
    private QuackContext mContext;
    private Set<String> mPropertyKeys = new HashSet();

    public JSContext(long j10) {
        QuackContext create = QuackContext.create(j10);
        this.mContext = create;
        create.setReferrer(this);
        this.mContext.putJavaScriptToJavaCoercion(JavaJson.class, JavaJson.COERCION);
        this.mContext.putJavaScriptToJavaCoercion(JavaArray.class, JavaArray.COERCION);
        this.mContext.putJavaToJavaScriptCoercion(String.class, new QuackCoercion() { // from class: qa.e
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$0;
                lambda$new$0 = JSContext.lambda$new$0(cls, (String) obj);
                return lambda$new$0;
            }
        });
        this.mContext.putJavaToJavaScriptCoercion(Integer.TYPE, new QuackCoercion() { // from class: qa.d
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$1;
                lambda$new$1 = JSContext.lambda$new$1(cls, (Integer) obj);
                return lambda$new$1;
            }
        });
        this.mContext.putJavaToJavaScriptCoercion(Integer.class, new QuackCoercion() { // from class: qa.c
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$2;
                lambda$new$2 = JSContext.lambda$new$2(cls, (Integer) obj);
                return lambda$new$2;
            }
        });
        this.mContext.putJavaToJavaScriptCoercion(Boolean.TYPE, new QuackCoercion() { // from class: qa.a
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$3;
                lambda$new$3 = JSContext.lambda$new$3(cls, (Boolean) obj);
                return lambda$new$3;
            }
        });
        this.mContext.putJavaToJavaScriptCoercion(Boolean.class, new QuackCoercion() { // from class: qa.b
            @Override // com.koushikdutta.quack.QuackCoercion
            public final Object coerce(Class cls, Object obj) {
                Object lambda$new$4;
                lambda$new$4 = JSContext.lambda$new$4(cls, (Boolean) obj);
                return lambda$new$4;
            }
        });
    }

    public static JSContext from(QuackContext quackContext) {
        Object referrer = quackContext.getReferrer();
        if (referrer instanceof JSContext) {
            return (JSContext) referrer;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$0(Class cls, String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$1(Class cls, Integer num) {
        return num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$2(Class cls, Integer num) {
        return num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$3(Class cls, Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$4(Class cls, Boolean bool) {
        return bool;
    }

    public void clear() {
        this.mPropertyKeys.clear();
    }

    public void close() {
        clear();
        this.mContext.close();
    }

    public Object coerceJavaToJavaScript(Class cls, Object obj) {
        return this.mContext.coerceJavaToJavaScript(cls, obj);
    }

    public Object evaluate(String str) {
        return this.mContext.evaluate(str);
    }

    public Object get(String str) {
        return getGlobalObject().get(str);
    }

    public JavaScriptObject getGlobalObject() {
        return this.mContext.getGlobalObject();
    }

    public boolean isClose() {
        return this.mContext.isClose();
    }

    public boolean set(String str, Object obj) {
        boolean z10 = getGlobalObject().set(str, obj);
        if (z10) {
            this.mPropertyKeys.add(str);
        }
        return z10;
    }

    public void setCoerceJavaScriptToJava(CoerceJavaScriptToJava coerceJavaScriptToJava) {
        this.mContext.setCoerceJavaScriptToJava(coerceJavaScriptToJava);
    }

    public <T> T evaluate(String str, Class<T> cls) {
        return (T) this.mContext.evaluate(str, cls);
    }

    public Map<String, Object> get() {
        HashMap hashMap = new HashMap(this.mPropertyKeys.size());
        for (String str : this.mPropertyKeys) {
            hashMap.put(str, get(str));
        }
        return hashMap;
    }

    public Object evaluate(String str, JavaScriptObject javaScriptObject) {
        return this.mContext.evaluate(null, javaScriptObject, str, SymbolValues.QUESTION_EN_SYMBOL);
    }

    public <T> T evaluate(String str, JavaScriptObject javaScriptObject, Class<T> cls) {
        return (T) this.mContext.evaluate(cls, javaScriptObject, str, SymbolValues.QUESTION_EN_SYMBOL);
    }
}
