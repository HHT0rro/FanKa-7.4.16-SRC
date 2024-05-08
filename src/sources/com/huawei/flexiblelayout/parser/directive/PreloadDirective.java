package com.huawei.flexiblelayout.parser.directive;

import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.d;
import com.huawei.flexiblelayout.data.e;
import com.huawei.flexiblelayout.data.g;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.services.task.TaskHandler;
import com.huawei.flexiblelayout.services.task.TaskHandlerRegistryService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PreloadDirective extends e implements g {

    /* renamed from: a, reason: collision with root package name */
    private final FLEngine f28379a;

    /* renamed from: b, reason: collision with root package name */
    private final String f28380b;

    /* renamed from: c, reason: collision with root package name */
    private final FLMap f28381c;

    /* renamed from: d, reason: collision with root package name */
    private d f28382d;

    public PreloadDirective(FLEngine fLEngine, String str, FLMap fLMap) {
        this.f28379a = fLEngine;
        this.f28380b = str;
        this.f28381c = fLMap;
    }

    private TaskHandler a(b bVar) {
        TaskHandlerRegistryService taskHandlerRegistryService = (TaskHandlerRegistryService) this.f28379a.getService(TaskHandlerRegistryService.class);
        if (bVar != null) {
            return taskHandlerRegistryService.create(this.f28380b, new FormulaMap(this.f28381c, bVar));
        }
        return taskHandlerRegistryService.create(this.f28380b, this.f28381c);
    }

    @Override // com.huawei.flexiblelayout.data.d
    public FLCardData execute(FLayoutSpec.Spec spec, b bVar) {
        TaskHandler a10;
        d dVar = this.f28382d;
        if (dVar == null) {
            return null;
        }
        FLCardData execute = dVar.execute(spec, bVar);
        if ((execute instanceof FLNodeData) && (a10 = a(bVar)) != null) {
            e.setTaskHandler((FLNodeData) execute, a10);
        }
        return execute;
    }

    @Override // com.huawei.flexiblelayout.data.e, com.huawei.flexiblelayout.parser.expr.ProcessorResult
    public void processed(Object obj) {
    }

    @Override // com.huawei.flexiblelayout.data.d
    public void setTarget(d dVar) {
        this.f28382d = dVar;
    }
}
