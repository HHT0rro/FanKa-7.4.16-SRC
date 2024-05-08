package com.huawei.quickcard.flexiblelayoutadapter;

import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.quickcard.base.wrapper.IQuickCardDataWrapper;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.base.wrapper.impl.ArrDataWrapper;
import com.huawei.quickcard.base.wrapper.impl.HashMapDataWrapper;
import com.huawei.quickcard.base.wrapper.impl.JsonArrayDataWrapper;
import com.huawei.quickcard.base.wrapper.impl.JsonObjectDataWrapper;
import com.huawei.quickcard.base.wrapper.impl.ListDataWrapper;
import com.huawei.quickcard.base.wrapper.impl.MapDataWrapper;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.elexecutor.IExpressionContextProxy;
import com.huawei.quickcard.elexecutor.IExpressionFactory;
import com.huawei.quickcard.quackjsadapter.JavaScriptDataWrapper;
import com.huawei.quickcard.quackjsadapter.QuickCardDataWrapper;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlexibleLayoutExpressionFactory implements IExpressionFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33697a = "ExpressionFactory";

    public FlexibleLayoutExpressionFactory() {
        WrapDataUtils.registerDataWrapper(JavaScriptObject.class, new JavaScriptDataWrapper());
        WrapDataUtils.registerDataWrapper(JSONObject.class, new JsonObjectDataWrapper());
        WrapDataUtils.registerDataWrapper(JSONArray.class, new JsonArrayDataWrapper());
        WrapDataUtils.registerDataWrapper(Map.class, new MapDataWrapper());
        WrapDataUtils.registerDataWrapper(HashMap.class, new HashMapDataWrapper());
        WrapDataUtils.registerDataWrapper(List.class, new ListDataWrapper());
        WrapDataUtils.registerDataWrapper(Object[].class, new ArrDataWrapper());
        WrapDataUtils.registerDataWrapper(FLMap.class, new FlexibleLayoutDataObjWrapper());
        WrapDataUtils.registerDataWrapper(FLArray.class, new FlexibleLayoutDataArrWrapper());
        WrapDataUtils.registerDataWrapper(FLImmutableMap.class, new FlexibleLayoutDataObjWrapper());
        WrapDataUtils.registerDataWrapper(FLImmutableArray.class, new FlexibleLayoutDataArrWrapper());
        WrapDataUtils.setWrapperMethod(new IQuickCardDataWrapper() { // from class: com.huawei.quickcard.flexiblelayoutadapter.a
            @Override // com.huawei.quickcard.base.wrapper.IQuickCardDataWrapper
            public final Object wrap(Object obj) {
                return FlexibleLayoutExpressionFactory.wrap(obj);
            }
        });
    }

    public static Object wrap(Object obj) {
        return WrapDataUtils.getDataWrapper(obj) != null ? new QuickCardDataWrapper(obj) : obj;
    }

    @Override // com.huawei.quickcard.elexecutor.IExpressionFactory
    public IExpressionContextProxy createExpressionContextProxy(IExpressionContext iExpressionContext) {
        return new FlexibleLayoutExpressionContextProxy(iExpressionContext);
    }
}
