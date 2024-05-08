package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    private static c f10887d;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, a> f10888a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> f10889b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Set<Integer> f10890c = new CopyOnWriteArraySet();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f10891a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<PluginBroadcastReceiver> f10892b = new CopyOnWriteArraySet();

        public final void a(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.f10892b.add(pluginBroadcastReceiver);
            }
        }

        public final void a(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set = this.f10892b;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.f10892b) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + (intent != null ? intent.getAction() : "") + "[exception]:", th);
                    }
                }
            }
        }
    }

    private c() {
    }

    public static c a() {
        if (f10887d == null) {
            synchronized (com.bytedance.pangle.service.a.a.class) {
                if (f10887d == null) {
                    f10887d = new c();
                }
            }
        }
        return f10887d;
    }

    public final void a(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> actionsIterator = intentFilter.actionsIterator();
        while (actionsIterator.hasNext()) {
            String next = actionsIterator.next();
            if (next != null) {
                a aVar = this.f10888a.get(next);
                if (aVar != null) {
                    aVar.a(pluginBroadcastReceiver);
                } else {
                    a aVar2 = new a();
                    aVar2.f10891a = next;
                    aVar2.a(pluginBroadcastReceiver);
                    this.f10888a.put(next, aVar2);
                }
            }
        }
    }

    public final void a(Context context, Intent intent) {
        a value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, a> map = this.f10888a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, a> entry : this.f10888a.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.a(context, intent);
            }
        }
    }
}
