package com.google.common.hash;

import com.google.common.base.t;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class LongAddables {

    /* renamed from: a, reason: collision with root package name */
    public static final t<j> f26627a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements j {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.hash.j
        public void add(long j10) {
            getAndAdd(j10);
        }

        @Override // com.google.common.hash.j
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.hash.j
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements t<j> {
        @Override // com.google.common.base.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j get() {
            return new LongAdder();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements t<j> {
        @Override // com.google.common.base.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        t<j> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f26627a = bVar;
    }

    public static j a() {
        return f26627a.get();
    }
}
