package com.huawei.hmf.services.inject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class Selector {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class Binder {
        public String mName;
        public Class mService;

        public Binder(String str) {
            this.mName = str;
        }

        public void bind(Class cls) {
            this.mService = cls;
            Selector.this.add(this);
        }
    }

    public abstract void add(Binder binder);

    public abstract Binder alias(String str);

    public abstract boolean isEmpty();
}
