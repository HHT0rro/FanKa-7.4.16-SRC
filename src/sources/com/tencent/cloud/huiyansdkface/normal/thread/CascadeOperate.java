package com.tencent.cloud.huiyansdkface.normal.thread;

import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CascadeOperate {
    private LinkedList<a> mStack = new LinkedList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final b f41207a;

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f41208b;

        public a(b bVar, Runnable runnable) {
            this.f41207a = bVar;
            this.f41208b = runnable;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum b {
        UI,
        SUB
    }

    private CascadeOperate() {
    }

    public static CascadeOperate getInstance() {
        return new CascadeOperate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(final LinkedList<a> linkedList) {
        if (linkedList.isEmpty()) {
            return;
        }
        final a removeLast = linkedList.removeLast();
        if (b.UI.equals(removeLast.f41207a)) {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.CascadeOperate.1
                @Override // java.lang.Runnable
                public void run() {
                    removeLast.f41208b.run();
                    CascadeOperate.this.start(linkedList);
                }
            });
        }
        if (b.SUB.equals(removeLast.f41207a)) {
            ThreadOperate.runOnSubThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.CascadeOperate.2
                @Override // java.lang.Runnable
                public void run() {
                    removeLast.f41208b.run();
                    CascadeOperate.this.start(linkedList);
                }
            });
        }
    }

    public CascadeOperate runOnSubThread(Runnable runnable) {
        this.mStack.push(new a(b.SUB, runnable));
        return this;
    }

    public CascadeOperate runOnUiThread(Runnable runnable) {
        this.mStack.push(new a(b.UI, runnable));
        return this;
    }

    public void start() {
        start(this.mStack);
    }
}
