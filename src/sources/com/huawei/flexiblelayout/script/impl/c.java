package com.huawei.flexiblelayout.script.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.script.IScriptContext;
import com.huawei.flexiblelayout.script.IScriptService;
import com.huawei.jslite.JSRuntime;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

/* compiled from: ScriptContextPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c implements IScriptService {

    /* renamed from: c, reason: collision with root package name */
    private static final String f28464c = "ScriptContextPool";

    /* renamed from: d, reason: collision with root package name */
    private static final int f28465d = 200;

    /* renamed from: e, reason: collision with root package name */
    private static final int f28466e = 500;

    /* renamed from: f, reason: collision with root package name */
    private static final int f28467f = 20;

    /* renamed from: a, reason: collision with root package name */
    private final int f28468a;

    /* renamed from: b, reason: collision with root package name */
    private b f28469b;

    /* compiled from: ScriptContextPool.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final JSRuntime f28470a;

        /* renamed from: b, reason: collision with root package name */
        private int f28471b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f28472c;

        /* renamed from: d, reason: collision with root package name */
        private final Set<com.huawei.flexiblelayout.script.impl.b> f28473d;

        /* renamed from: e, reason: collision with root package name */
        private final Queue<com.huawei.flexiblelayout.script.impl.b> f28474e;

        private b() {
            this.f28470a = new JSRuntime();
            this.f28471b = 0;
            this.f28472c = false;
            this.f28473d = new HashSet();
            this.f28474e = new ArrayDeque();
        }

        public static /* synthetic */ int f(b bVar) {
            int i10 = bVar.f28471b;
            bVar.f28471b = i10 + 1;
            return i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.f28472c) {
                return;
            }
            this.f28472c = true;
            Iterator<com.huawei.flexiblelayout.script.impl.b> iterator2 = this.f28473d.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a();
            }
            this.f28473d.clear();
            Iterator<com.huawei.flexiblelayout.script.impl.b> it = this.f28474e.iterator2();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f28474e.clear();
            this.f28470a.close();
        }
    }

    public c() {
        this(200);
    }

    @Nullable
    private IScriptContext a(@Nullable String str) {
        if (this.f28469b.f28472c) {
            Log.w(f28464c, "acquire context failed, null runtime");
            return null;
        }
        if (this.f28469b.f28473d.size() >= this.f28468a) {
            Log.w(f28464c, "acquire context failed. quantity exceeds limit.");
            return null;
        }
        com.huawei.flexiblelayout.script.impl.b bVar = (com.huawei.flexiblelayout.script.impl.b) this.f28469b.f28474e.poll();
        if (bVar == null) {
            bVar = new com.huawei.flexiblelayout.script.impl.b(this.f28469b.f28470a.createContext(), this);
        }
        bVar.a(str);
        this.f28469b.f28473d.add(bVar);
        b.f(this.f28469b);
        return bVar;
    }

    @Override // com.huawei.flexiblelayout.script.IScriptService
    @Nullable
    public IScriptContext acquireContext() {
        return a((String) null);
    }

    @Override // com.huawei.flexiblelayout.script.IScriptService
    public void close() {
        this.f28469b.a();
    }

    @Override // com.huawei.flexiblelayout.script.IScriptService
    @Nullable
    public IScriptContext findContext(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.huawei.flexiblelayout.script.impl.b bVar : this.f28469b.f28473d) {
            if (TextUtils.equals(str, bVar.b())) {
                return bVar;
            }
        }
        return null;
    }

    public c(int i10) {
        this.f28469b = new b();
        this.f28468a = i10;
    }

    @Override // com.huawei.flexiblelayout.script.IScriptService
    @Nullable
    public IScriptContext acquireContext(@Nullable String str) {
        if (!TextUtils.isEmpty(str) && findContext(str) == null) {
            return a(str);
        }
        return null;
    }

    public void a(@NonNull com.huawei.flexiblelayout.script.impl.b bVar) {
        int c4 = bVar.c();
        if (c4 < 20) {
            bVar.a(c4 + 1);
            bVar.a((String) null);
            bVar.setCoerceJavaScriptToJava(null);
            try {
                this.f28469b.f28474e.offer(bVar);
            } catch (ClassCastException | IllegalArgumentException | NullPointerException unused) {
                Log.w(f28464c, "notifyReleased, add to availableObjects failed");
            }
        } else {
            bVar.a();
        }
        this.f28469b.f28473d.remove(bVar);
        a();
    }

    private void a() {
        if (!this.f28469b.f28473d.isEmpty() || this.f28469b.f28471b < 500) {
            return;
        }
        this.f28469b.a();
        this.f28469b = new b();
    }
}
