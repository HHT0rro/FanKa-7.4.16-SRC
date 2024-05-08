package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.parser.expr.ProcessorResult;
import com.huawei.flexiblelayout.parser.expr.expression.Identifier;
import com.huawei.flexiblelayout.parser.expr.expression.Var;
import java.util.LinkedHashMap;

/* compiled from: ForStatement.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class u0 implements w0 {

    /* renamed from: d, reason: collision with root package name */
    public static final String f28636d = "for";

    /* renamed from: e, reason: collision with root package name */
    public static final String f28637e = "in";

    /* renamed from: f, reason: collision with root package name */
    private static final String f28638f = "ForStatement";

    /* renamed from: a, reason: collision with root package name */
    private final Identifier f28639a;

    /* renamed from: b, reason: collision with root package name */
    private final Identifier f28640b;

    /* renamed from: c, reason: collision with root package name */
    private final Var f28641c;

    public u0(Identifier identifier, Identifier identifier2, Var var) {
        this.f28639a = identifier;
        this.f28640b = identifier2;
        this.f28641c = var;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.Processor
    public void process(o0 o0Var, ProcessorResult processorResult) {
        String str;
        Var var = this.f28641c;
        if (var == null) {
            Log.w(f28638f, "Undefined list.");
            return;
        }
        if (this.f28640b == null) {
            Log.w(f28638f, "Undefined item.");
            return;
        }
        try {
            String name = var.getName(o0Var);
            if (name == null) {
                return;
            }
            try {
                Object model = this.f28641c.getModel(o0Var);
                if (!(model instanceof ListModel)) {
                    Log.w(f28638f, "Expected a ListModel.");
                    return;
                }
                String str2 = null;
                try {
                    str = this.f28639a.getName(o0Var);
                } catch (ExprException e2) {
                    Log.w(f28638f, "Failed to get name of list index.", e2);
                    str = null;
                }
                if (str == null) {
                    return;
                }
                try {
                    str2 = this.f28640b.getName(o0Var);
                } catch (ExprException e10) {
                    Log.w(f28638f, "Failed to get name of list item.", e10);
                }
                if (str2 == null) {
                    return;
                }
                ListModel listModel = (ListModel) model;
                for (int i10 = 0; i10 < listModel.size(); i10++) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Object obj = listModel.get(i10);
                    linkedHashMap.put(str, Integer.valueOf(i10));
                    linkedHashMap.put(str2, obj);
                    if (processorResult != null) {
                        processorResult.processed(new r0(o0Var.a(), linkedHashMap));
                    }
                }
            } catch (ExprException e11) {
                Log.w(f28638f, "Failed to get list-referent of '" + name + "'.", e11);
            }
        } catch (ExprException e12) {
            Log.w(f28638f, "Failed to get name of list.", e12);
        }
    }
}
