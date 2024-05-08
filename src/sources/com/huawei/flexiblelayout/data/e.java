package com.huawei.flexiblelayout.data;

import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.parser.expr.ProcessorResult;
import com.huawei.flexiblelayout.services.task.TaskHandler;

/* compiled from: DirectiveResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class e implements ProcessorResult {
    public static void buildChildren(FLayoutSpec.FNodeSpec fNodeSpec, FLNodeData fLNodeData, b bVar) {
        fNodeSpec.a(fLNodeData, bVar);
    }

    public static FLCardData buildSelf(FLayoutSpec.Spec spec, b bVar) {
        if (spec instanceof FLayoutSpec.FCardSpec) {
            return ((FLayoutSpec.FCardSpec) spec).a(bVar);
        }
        return ((FLayoutSpec.FNodeSpec) spec).a(bVar);
    }

    public static void setCssRule(FLCardData fLCardData, CSSRule cSSRule) {
        fLCardData.a(cSSRule);
    }

    public static void setTaskHandler(FLNodeData fLNodeData, TaskHandler taskHandler) {
        fLNodeData.a(taskHandler);
    }

    @Override // com.huawei.flexiblelayout.parser.expr.ProcessorResult
    public abstract void processed(Object obj);
}
