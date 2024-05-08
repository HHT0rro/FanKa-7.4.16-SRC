package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {
    public static void a(Context context, AppStatusRules.Strategy strategy, long j10) {
        if (context == null || strategy == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(b(strategy), j10).apply();
    }

    private static String b(AppStatusRules.Strategy strategy) {
        return "appstatus_strategy_pref_" + (strategy.getName() == null ? "defaultStrategy" : strategy.getName());
    }

    public static List<AppStatusRules.Strategy> c(@Nullable AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return new ArrayList();
        }
        return appStatusRules.obtainNamedStrategyList();
    }

    @NonNull
    public static AppStatusRules.Strategy d(@Nullable AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return AppStatusRules.Strategy.LOCAL_DEFAULT;
        }
        return appStatusRules.obtainDefaultStrategy();
    }

    public static boolean a(Context context, @NonNull AppStatusRules.Strategy strategy) {
        if (context == null) {
            return false;
        }
        long j10 = context.getSharedPreferences("ksadsdk_pref", 0).getLong(b(strategy), -1L);
        if (j10 < 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long minLaunchIntervalWithMS = strategy.getMinLaunchIntervalWithMS();
        return minLaunchIntervalWithMS <= 0 || j10 + minLaunchIntervalWithMS < currentTimeMillis;
    }
}
