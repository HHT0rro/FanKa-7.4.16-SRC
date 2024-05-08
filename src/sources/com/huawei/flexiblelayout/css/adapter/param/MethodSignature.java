package com.huawei.flexiblelayout.css.adapter.param;

import android.view.View;
import com.huawei.flexiblelayout.css.adapter.param.Parameter;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.log.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MethodSignature {
    private static final String TAG = "MethodSignature";
    private Parameter.Generator generator;
    private Method method;
    private Class methodClass;

    public MethodSignature(Method method, Parameter.Generator generator) {
        this.method = method;
        this.generator = generator;
    }

    public final void invoke(View view, CSSValue cSSValue) {
        Object obj = this.generator.get(view, cSSValue);
        if (this.generator instanceof Parameter.AsyncGenerator) {
            final WeakReference weakReference = new WeakReference(view);
            ((Parameter.AsyncGenerator) this.generator).call(obj, new GeneratorCallBack() { // from class: com.huawei.flexiblelayout.css.adapter.param.MethodSignature.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.huawei.flexiblelayout.css.adapter.param.GeneratorCallBack
                public void done(Object obj2) {
                    View view2 = (View) weakReference.get();
                    if (view2 != null) {
                        MethodSignature.this.invoke(view2, obj2);
                    }
                }
            });
        } else {
            invoke(view, obj);
        }
    }

    public void setGenerator(Parameter.Generator generator) {
        this.generator = generator;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public MethodSignature(Method method, Class cls, Parameter.Generator generator) {
        this.method = method;
        this.methodClass = cls;
        this.generator = generator;
    }

    public void invoke(View view, Object obj) {
        try {
            Class cls = this.methodClass;
            Object obj2 = view;
            if (cls != null) {
                obj2 = cls.newInstance();
            }
            if (obj != null && obj.getClass().isArray()) {
                this.method.invoke(obj2, (Object[]) obj);
            } else {
                this.method.invoke(obj2, obj);
            }
        } catch (RuntimeException e2) {
            Log.e(TAG, "invoke failed, RuntimeException:" + this.method.getName() + ", e: " + e2.getMessage());
        } catch (Exception e10) {
            Log.e(TAG, "invoke failed:" + this.method.getName() + ", e: " + e10.getMessage());
        }
    }
}
