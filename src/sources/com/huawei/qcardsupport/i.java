package com.huawei.qcardsupport;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.flexiblelayout.script.vm.ScriptVM;
import com.huawei.flexiblelayout.script.vm.VMCoercion;

/* compiled from: VMQContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i extends g {

    /* renamed from: g, reason: collision with root package name */
    private static final SparseArray<SparseArray<ScriptVM>> f33141g = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name */
    private static final String f33142h = "(function () {\n  let $qc_global_data$; \n  %s\n  let model = $qc_global_data$ || {}\n  function VM() {\n    Object.keys(model).forEach((key) => {\n      if (typeof model[key] != \"function\") {\n        Object.defineProperty(this, key, {\n          configurable: true,\n          get: () => {\n            let ret = this.$extra.get(key);\n            if (ret != null) {\n              return ret;\n            }\n            ret = model[key];\n            if (ret) {\n              this.$extra.put(key, ret);\n            }\n            return ret;\n          },\n          set: (newVal) => {\n            this.$extra.put(key, newVal);\n          },\n        });\n      }\n    });\n  }\n  Object.keys(model).forEach((key) => {\n    if (typeof model[key] == \"function\") {\n      VM.prototype[key] = model[key];\n    }\n  });\n  return {\n    createObject: function () {\n      return new VM();\n    }\n  };\n})();";

    public i(@NonNull IScriptContext iScriptContext, @NonNull f fVar) {
        super(iScriptContext, fVar);
    }

    @Override // com.huawei.qcardsupport.g
    public void a(@NonNull String str) {
        j a10 = a(this.f33131a, str);
        this.f33131a = a10;
        a10.setCoerceJavaScriptToJava(new VMCoercion());
        a(this.f33132b);
    }

    @Override // com.huawei.qcardsupport.g
    public void b() {
        IScriptContext iScriptContext = this.f33131a;
        if (iScriptContext instanceof j) {
            ((j) iScriptContext).a();
        }
    }

    private static j a(@NonNull IScriptContext iScriptContext, @NonNull String str) {
        int identityHashCode = System.identityHashCode(iScriptContext);
        SparseArray<SparseArray<ScriptVM>> sparseArray = f33141g;
        SparseArray<ScriptVM> sparseArray2 = sparseArray.get(identityHashCode);
        if (sparseArray2 == null) {
            sparseArray2 = new SparseArray<>();
            sparseArray.put(identityHashCode, sparseArray2);
        }
        int hashCode = str.hashCode();
        ScriptVM scriptVM = sparseArray2.get(hashCode);
        if (scriptVM == null) {
            scriptVM = new ScriptVM(iScriptContext, String.format(f33142h, str));
            sparseArray2.put(hashCode, scriptVM);
        }
        return new j(iScriptContext, scriptVM.createObject(null));
    }
}
