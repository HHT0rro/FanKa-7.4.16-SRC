package com.google.common.cache;

import com.google.common.base.t;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class LongAddables {

    /* renamed from: a, reason: collision with root package name */
    public static final t<g> f26121a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements g {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.g
        public void add(long j10) {
            getAndAdd(j10);
        }

        @Override // com.google.common.cache.g
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.g
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements t<g> {
        @Override // com.google.common.base.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g get() {
            return new LongAdder();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements t<g> {
        @Override // com.google.common.base.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        t<g> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f26121a = bVar;
    }

    public static g a() {
        return f26121a.get();
    }
}
