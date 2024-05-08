package com.huawei.quickcard.utils;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.framework.condition.ConditionalData;
import com.huawei.quickcard.j0;
import com.huawei.quickcard.watcher.IWatcherManager;
import com.huawei.quickcard.watcher.Watcher;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ExpressionUtils {
    public static final String ALT_TEMPLATE_V1 = "$globalData={}";
    public static final String ALT_TEMPLATE_V2 = "let $qc_global_data$ = {};";
    public static volatile String sEngineFramework = "";

    @NonNull
    public static String bindData(@NonNull String str, @NonNull String str2) {
        return "$qc_global_data$['" + str2 + "'] = JSON.parse(" + str + ");";
    }

    public static void buildInJavaObject(@NonNull IExpressionContext iExpressionContext, String str, String str2, Object obj) {
        Object wrap = WrapDataUtils.wrap(iExpressionContext.get("$cardInstance" + str));
        if (wrap instanceof CardDataObject) {
            Object wrap2 = WrapDataUtils.wrap(obj);
            if (wrap2 instanceof CardDataObject) {
                ((CardDataObject) wrap2).setPath(str2);
            }
            ((CardDataObject) wrap).set(str2, wrap2);
        }
    }

    @NonNull
    public static String cleanValueCollector() {
        return "this.$valueCollector && this.$valueCollector.length && (this.$valueCollector.length = 0);";
    }

    @NonNull
    public static Set<String> collectWatcherScript(@NonNull IExpressionContext iExpressionContext) {
        HashSet hashSet = new HashSet();
        collectWatcherScript(iExpressionContext, hashSet);
        return hashSet;
    }

    @NonNull
    public static String composeLifeCycle(String str) {
        return "$lifecycle().apply(" + str + ".proxy);";
    }

    @NonNull
    public static String computeExpression(String str) {
        return "(function () { if (this.valueCollector.size == 0) {return;} let result = Array.from(this.valueCollector); this.valueCollector.clear(); return result; }).apply(" + str + ")";
    }

    public static String computeForChains(@NonNull j0 j0Var, int i10, String str) {
        return str + j0Var.a(i10);
    }

    @NonNull
    public static String createCardInstance(@NonNull String str) {
        return "$createVm('" + str + "', $qc_global_data$);";
    }

    @NonNull
    public static String deleteCardInstance(String str) {
        return "$deleteVm('" + str + "');";
    }

    @Nullable
    public static Object exeScript(@NonNull IExpressionContext iExpressionContext, @NonNull String str, boolean z10) {
        String watcherScript;
        if (z10) {
            try {
                watcherScript = watcherScript(str);
            } catch (Throwable th) {
                CardLogUtils.e("expression", "execute script failed::" + str + "::cause" + th.getMessage());
                return null;
            }
        } else {
            watcherScript = str;
        }
        return iExpressionContext.evaluate(watcherScript);
    }

    public static String getForChains(@NonNull View view) {
        ConditionalData findNearlyConditionData = ConditionalData.findNearlyConditionData(view);
        return findNearlyConditionData != null ? StrUtils.null2Empty(findNearlyConditionData.getSelfForChains()) : "";
    }

    public static void initFramework(@NonNull IExpressionContext iExpressionContext, @NonNull String str) {
        iExpressionContext.evaluate(sEngineFramework + str);
    }

    public static boolean isTrue(Object obj) {
        return isTrue(obj, false);
    }

    @NonNull
    public static String toggleContext(@NonNull String str) {
        return "$switchVm('" + str + "');";
    }

    public static String updateForScript(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (z10) {
            return "(function() {" + str + "return " + str2 + "}.apply(this))";
        }
        return "(function() {" + str + str2 + "}.apply(this))";
    }

    public static void updateWatcherScript(@NonNull Collection<Watcher> collection, String str, IWatcherManager iWatcherManager, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Watcher watcher : collection) {
            String updateForScript = updateForScript(str, watcher.getExpr().getSrc(), true);
            watcher.setScript(updateForScript);
            if (z10) {
                watcher.reset();
            }
            iWatcherManager.updateExprWatchersMap(updateForScript, watcher);
        }
    }

    @NonNull
    public static String watcherScript(@NonNull String str) {
        return "$watcherScript(\"" + str + "\");";
    }

    public static String computeForChains(@NonNull j0 j0Var, int i10, String str, String str2) {
        return str2 + j0Var.a(str, i10);
    }

    public static boolean isTrue(Object obj, boolean z10) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return !"".equals(obj.toString()) || z10;
        }
        if (!(obj instanceof Number)) {
            return obj != null || z10;
        }
        Number number = (Number) obj;
        return ((number instanceof Double) || (number instanceof Float)) ? (Float.compare(number.floatValue(), 0.0f) == 0 || Float.compare(number.floatValue(), Float.NaN) == 0) ? false : true : number.intValue() != 0;
    }

    public static void collectWatcherScript(@NonNull IExpressionContext iExpressionContext, @NonNull Set<String> set) {
        Object wrap = WrapDataUtils.wrap(iExpressionContext.evaluate("$collectWatcherScript()"));
        if (wrap instanceof CardDataObject) {
            CardDataObject cardDataObject = (CardDataObject) wrap;
            if (cardDataObject.isArray()) {
                for (int i10 = 0; i10 < cardDataObject.size(); i10++) {
                    set.add(cardDataObject.getString(i10, ""));
                }
            }
        }
    }
}
