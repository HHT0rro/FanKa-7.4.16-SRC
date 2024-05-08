package com.huawei.quickcard.watcher;

import com.huawei.quickcard.framework.condition.ConditionalData;
import com.huawei.quickcard.framework.value.QuickCardValue;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IWatcherManager {
    void associatePathAndWatcher(String str, Watcher watcher);

    void collectNewWatchers(Collection collection);

    ConditionalData getRootConditionData();

    List<Watcher> getWatchersByField(String str);

    void removeConditionalDPSWatcher(ConditionalData conditionalData);

    void removeDPWatcher(int i10, String str);

    void removeSPWatcher(int i10, String str);

    void removeWatchersByConditionData(ConditionalData conditionalData);

    void resetByVar(Collection<String> collection);

    void setCommonWatchers(List<Watcher> list);

    void setMessageKeys(Collection<String> collection);

    void setValueByExpr(String str, Object obj);

    void stopCollectNewWatchers(Collection collection);

    int updateAll();

    int updateByFields(Set<String> set);

    void updateByScripts(Collection<String> collection);

    void updateByVar(String str);

    void updateByVars(Collection<String> collection);

    void updateDPWatchers();

    void updateExprWatchersMap(String str, Watcher watcher);

    int updateOnBind();

    void updateSPWatchers();

    void updateWatchers(Collection<Watcher> collection);

    Watcher watchAttr(String str, Expression expression, IWatchAttrCallback iWatchAttrCallback);

    void watchDPAttr(int i10, String str, QuickCardValue quickCardValue, IWatchAttrCallback iWatchAttrCallback);

    Watcher watchIfCondition(String str, Expression expression, IWatchConditionCallback iWatchConditionCallback);

    void watchSPAttr(int i10, String str, QuickCardValue quickCardValue, IWatchAttrCallback iWatchAttrCallback);

    Watcher watchVirtualViewAttr(String str, String str2, String str3, Expression expression, IVirtualViewWatchCallback iVirtualViewWatchCallback);

    ForWatcher watcherForCondition(String str, Expression expression, IWatchConditionCallback iWatchConditionCallback);
}
