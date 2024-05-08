package com.google.common.util.concurrent;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ExecutionSequencer {

    /* renamed from: a, reason: collision with root package name */
    public a f26800a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        public Executor delegate;
        public ExecutionSequencer sequencer;
        public Thread submitting;
        public Runnable task;

        public /* synthetic */ TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer, g gVar) {
            this(executor, executionSequencer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.sequencer;
                Objects.requireNonNull(executionSequencer);
                a aVar = executionSequencer.f26800a;
                if (aVar.f26801a == this.submitting) {
                    this.sequencer = null;
                    com.google.common.base.o.x(aVar.f26802b == null);
                    aVar.f26802b = runnable;
                    Executor executor = this.delegate;
                    Objects.requireNonNull(executor);
                    aVar.f26803c = executor;
                    this.delegate = null;
                } else {
                    Executor executor2 = this.delegate;
                    Objects.requireNonNull(executor2);
                    this.delegate = null;
                    this.task = runnable;
                    executor2.execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Executor executor;
            Thread currentThread = Thread.currentThread();
            Thread thread = null;
            byte b4 = 0;
            if (currentThread != this.submitting) {
                Runnable runnable = this.task;
                Objects.requireNonNull(runnable);
                this.task = null;
                runnable.run();
                return;
            }
            a aVar = new a(b4 == true ? 1 : 0);
            aVar.f26801a = currentThread;
            ExecutionSequencer executionSequencer = this.sequencer;
            Objects.requireNonNull(executionSequencer);
            executionSequencer.f26800a = aVar;
            this.sequencer = null;
            try {
                Runnable runnable2 = this.task;
                Objects.requireNonNull(runnable2);
                this.task = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = aVar.f26802b;
                    if (runnable3 == null || (executor = aVar.f26803c) == null) {
                        break;
                    }
                    aVar.f26802b = null;
                    aVar.f26803c = null;
                    executor.execute(runnable3);
                }
            } finally {
                aVar.f26801a = null;
            }
        }

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
            this.sequencer = executionSequencer;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Thread f26801a;

        /* renamed from: b, reason: collision with root package name */
        public Runnable f26802b;

        /* renamed from: c, reason: collision with root package name */
        public Executor f26803c;

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}
