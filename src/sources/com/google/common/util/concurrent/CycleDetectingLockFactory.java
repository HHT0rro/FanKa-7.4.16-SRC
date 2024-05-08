package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CycleDetectingLockFactory {

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, c>> f26793b = new MapMaker().l().i();

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f26794c = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<c>> f26795d = new a();

    /* renamed from: a, reason: collision with root package name */
    public final d f26796a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class CycleDetectingReentrantLock extends ReentrantLock implements b {
        private final c lockGraphNode;

        public /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, c cVar, boolean z10, a aVar) {
            this(cVar, z10);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public c getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }

        private CycleDetectingReentrantLock(c cVar, boolean z10) {
            super(z10);
            this.lockGraphNode = (c) com.google.common.base.o.r(cVar);
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock(j10, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements b {
        private final c lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;

        public /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, c cVar, boolean z10, a aVar) {
            this(cycleDetectingLockFactory, cVar, z10);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public c getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, c cVar, boolean z10) {
            super(z10);
            this.readLock = new CycleDetectingReentrantReadLock(this);
            this.writeLock = new CycleDetectingReentrantWriteLock(this);
            this.lockGraphNode = (c) com.google.common.base.o.r(cVar);
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ExampleStackTrace extends IllegalStateException {
        public static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        public static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), c.class.getName());

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ExampleStackTrace(com.google.common.util.concurrent.CycleDetectingLockFactory.c r4, com.google.common.util.concurrent.CycleDetectingLockFactory.c r5) {
            /*
                r3 = this;
                java.lang.String r4 = r4.d()
                java.lang.String r5 = r5.d()
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r0 = r0.length()
                int r0 = r0 + 4
                java.lang.String r1 = java.lang.String.valueOf(r5)
                int r1 = r1.length()
                int r0 = r0 + r1
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                r1.append(r4)
                java.lang.String r4 = " -> "
                r1.append(r4)
                r1.append(r5)
                java.lang.String r4 = r1.toString()
                r3.<init>(r4)
                java.lang.StackTraceElement[] r4 = r3.getStackTrace()
                int r5 = r4.length
                r0 = 0
            L38:
                if (r0 >= r5) goto L6d
                java.lang.Class<com.google.common.util.concurrent.CycleDetectingLockFactory$e> r1 = com.google.common.util.concurrent.CycleDetectingLockFactory.e.class
                java.lang.String r1 = r1.getName()
                r2 = r4[r0]
                java.lang.String r2 = r2.getClassName()
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L52
                java.lang.StackTraceElement[] r4 = com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace.EMPTY_STACK_TRACE
                r3.setStackTrace(r4)
                goto L6d
            L52:
                com.google.common.collect.ImmutableSet<java.lang.String> r1 = com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace.EXCLUDED_CLASS_NAMES
                r2 = r4[r0]
                java.lang.String r2 = r2.getClassName()
                boolean r1 = r1.contains(r2)
                if (r1 != 0) goto L6a
                java.lang.Object[] r4 = java.util.Arrays.copyOfRange(r4, r0, r5)
                java.lang.StackTraceElement[] r4 = (java.lang.StackTraceElement[]) r4
                r3.setStackTrace(r4)
                goto L6d
            L6a:
                int r0 = r0 + 1
                goto L38
            L6d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.CycleDetectingLockFactory.ExampleStackTrace.<init>(com.google.common.util.concurrent.CycleDetectingLockFactory$c, com.google.common.util.concurrent.CycleDetectingLockFactory$c):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Policies implements d {
        THROW { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies, com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies, com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f26794c.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies, com.google.common.util.concurrent.CycleDetectingLockFactory.d
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.d
        public abstract /* synthetic */ void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);

        /* synthetic */ Policies(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        public /* synthetic */ PotentialDeadlockException(c cVar, c cVar2, ExampleStackTrace exampleStackTrace, a aVar) {
            this(cVar, cVar2, exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb2 = new StringBuilder(message);
            for (Throwable th = this.conflictingStackTrace; th != null; th = th.getCause()) {
                sb2.append(", ");
                sb2.append(th.getMessage());
            }
            return sb2.toString();
        }

        private PotentialDeadlockException(c cVar, c cVar2, ExampleStackTrace exampleStackTrace) {
            super(cVar, cVar2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends ThreadLocal<ArrayList<c>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<c> initialValue() {
            return Lists.n(3);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface b {
        c getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Map<c, ExampleStackTrace> f26797a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<c, PotentialDeadlockException> f26798b;

        /* renamed from: c, reason: collision with root package name */
        public final String f26799c;

        public void a(d dVar, c cVar) {
            com.google.common.base.o.B(this != cVar, "Attempted to acquire multiple locks with the same rank %s", cVar.d());
            if (this.f26797a.containsKey(cVar)) {
                return;
            }
            PotentialDeadlockException potentialDeadlockException = this.f26798b.get(cVar);
            a aVar = null;
            if (potentialDeadlockException != null) {
                dVar.handlePotentialDeadlock(new PotentialDeadlockException(cVar, this, potentialDeadlockException.getConflictingStackTrace(), aVar));
                return;
            }
            ExampleStackTrace c4 = cVar.c(this, Sets.f());
            if (c4 == null) {
                this.f26797a.put(cVar, new ExampleStackTrace(cVar, this));
                return;
            }
            PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(cVar, this, c4, aVar);
            this.f26798b.put(cVar, potentialDeadlockException2);
            dVar.handlePotentialDeadlock(potentialDeadlockException2);
        }

        public void b(d dVar, List<c> list) {
            Iterator<c> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                a(dVar, iterator2.next());
            }
        }

        public final ExampleStackTrace c(c cVar, Set<c> set) {
            if (!set.add(this)) {
                return null;
            }
            ExampleStackTrace exampleStackTrace = this.f26797a.get(cVar);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (Map.Entry<c, ExampleStackTrace> entry : this.f26797a.entrySet()) {
                c key = entry.getKey();
                ExampleStackTrace c4 = key.c(cVar, set);
                if (c4 != null) {
                    ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(key, this);
                    exampleStackTrace2.setStackTrace(entry.getValue().getStackTrace());
                    exampleStackTrace2.initCause(c4);
                    return exampleStackTrace2;
                }
            }
            return null;
        }

        public String d() {
            return this.f26799c;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface d {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class e<E extends Enum<E>> extends CycleDetectingLockFactory {
    }

    public static void e(b bVar) {
        if (bVar.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<c> arrayList = f26795d.get();
        c lockGraphNode = bVar.getLockGraphNode();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == lockGraphNode) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public final void a(b bVar) {
        if (bVar.isAcquiredByCurrentThread()) {
            return;
        }
        ArrayList<c> arrayList = f26795d.get();
        c lockGraphNode = bVar.getLockGraphNode();
        lockGraphNode.b(this.f26796a, arrayList);
        arrayList.add(lockGraphNode);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        public final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j10, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        public final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.readWriteLock);
            try {
                return super.tryLock(j10, timeUnit);
            } finally {
                CycleDetectingLockFactory.e(this.readWriteLock);
            }
        }
    }
}
