package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.FlagSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ListenerSet<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f22914a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerWrapper f22915b;

    /* renamed from: c, reason: collision with root package name */
    public final IterationFinishedEvent<T> f22916c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet<a<T>> f22917d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque<Runnable> f22918e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque<Runnable> f22919f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22920g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface Event<T> {
        void invoke(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface IterationFinishedEvent<T> {
        void invoke(T t2, FlagSet flagSet);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f22921a;

        /* renamed from: b, reason: collision with root package name */
        public FlagSet.b f22922b = new FlagSet.b();

        /* renamed from: c, reason: collision with root package name */
        public boolean f22923c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f22924d;

        public a(T t2) {
            this.f22921a = t2;
        }

        public void a(int i10, Event<T> event) {
            if (this.f22924d) {
                return;
            }
            if (i10 != -1) {
                this.f22922b.a(i10);
            }
            this.f22923c = true;
            event.invoke(this.f22921a);
        }

        public void b(IterationFinishedEvent<T> iterationFinishedEvent) {
            if (this.f22924d || !this.f22923c) {
                return;
            }
            FlagSet e2 = this.f22922b.e();
            this.f22922b = new FlagSet.b();
            this.f22923c = false;
            iterationFinishedEvent.invoke(this.f22921a, e2);
        }

        public void c(IterationFinishedEvent<T> iterationFinishedEvent) {
            this.f22924d = true;
            if (this.f22923c) {
                iterationFinishedEvent.invoke(this.f22921a, this.f22922b.e());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            return this.f22921a.equals(((a) obj).f22921a);
        }

        public int hashCode() {
            return this.f22921a.hashCode();
        }
    }

    public ListenerSet(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent);
    }

    public static /* synthetic */ void g(CopyOnWriteArraySet copyOnWriteArraySet, int i10, Event event) {
        Iterator iterator2 = copyOnWriteArraySet.iterator2();
        while (iterator2.hasNext()) {
            ((a) iterator2.next()).a(i10, event);
        }
    }

    public void c(T t2) {
        if (this.f22920g) {
            return;
        }
        com.google.android.exoplayer2.util.a.e(t2);
        this.f22917d.add(new a<>(t2));
    }

    @CheckResult
    public ListenerSet<T> d(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent) {
        return new ListenerSet<>(this.f22917d, looper, this.f22914a, iterationFinishedEvent);
    }

    public void e() {
        if (this.f22919f.isEmpty()) {
            return;
        }
        if (!this.f22915b.b(0)) {
            HandlerWrapper handlerWrapper = this.f22915b;
            handlerWrapper.f(handlerWrapper.a(0));
        }
        boolean z10 = !this.f22918e.isEmpty();
        this.f22918e.addAll(this.f22919f);
        this.f22919f.clear();
        if (z10) {
            return;
        }
        while (!this.f22918e.isEmpty()) {
            this.f22918e.peekFirst().run();
            this.f22918e.removeFirst();
        }
    }

    public final boolean f(Message message) {
        Iterator<a<T>> iterator2 = this.f22917d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().b(this.f22916c);
            if (this.f22915b.b(0)) {
                return true;
            }
        }
        return true;
    }

    public void h(final int i10, final Event<T> event) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f22917d);
        this.f22919f.add(new Runnable() { // from class: com.google.android.exoplayer2.util.l
            @Override // java.lang.Runnable
            public final void run() {
                ListenerSet.g(CopyOnWriteArraySet.this, i10, event);
            }
        });
    }

    public void i() {
        Iterator<a<T>> iterator2 = this.f22917d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().c(this.f22916c);
        }
        this.f22917d.clear();
        this.f22920g = true;
    }

    public void j(T t2) {
        Iterator<a<T>> iterator2 = this.f22917d.iterator2();
        while (iterator2.hasNext()) {
            a<T> next = iterator2.next();
            if (next.f22921a.equals(t2)) {
                next.c(this.f22916c);
                this.f22917d.remove(next);
            }
        }
    }

    public void k(int i10, Event<T> event) {
        h(i10, event);
        e();
    }

    public ListenerSet(CopyOnWriteArraySet<a<T>> copyOnWriteArraySet, Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this.f22914a = clock;
        this.f22917d = copyOnWriteArraySet;
        this.f22916c = iterationFinishedEvent;
        this.f22918e = new ArrayDeque<>();
        this.f22919f = new ArrayDeque<>();
        this.f22915b = clock.d(looper, new Handler.Callback() { // from class: com.google.android.exoplayer2.util.k
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean f10;
                f10 = ListenerSet.this.f(message);
                return f10;
            }
        });
    }
}
