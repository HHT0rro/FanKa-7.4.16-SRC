package io.grpc.internal;

import com.google.common.base.o;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SharedResourceHolder {
    public static final long DESTROY_DELAY_SECONDS = 1;
    private static final SharedResourceHolder holder = new SharedResourceHolder(new ScheduledExecutorFactory() { // from class: io.grpc.internal.SharedResourceHolder.1
        @Override // io.grpc.internal.SharedResourceHolder.ScheduledExecutorFactory
        public ScheduledExecutorService createScheduledExecutor() {
            return Executors.newSingleThreadScheduledExecutor(GrpcUtil.getThreadFactory("grpc-shared-destroyer-%d", true));
        }
    });
    private ScheduledExecutorService destroyer;
    private final ScheduledExecutorFactory destroyerFactory;
    private final IdentityHashMap<Resource<?>, Instance> instances = new IdentityHashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Instance {
        public ScheduledFuture<?> destroyTask;
        public final Object payload;
        public int refcount;

        public Instance(Object obj) {
            this.payload = obj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Resource<T> {
        void close(T t2);

        T create();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ScheduledExecutorFactory {
        ScheduledExecutorService createScheduledExecutor();
    }

    public SharedResourceHolder(ScheduledExecutorFactory scheduledExecutorFactory) {
        this.destroyerFactory = scheduledExecutorFactory;
    }

    public static <T> T get(Resource<T> resource) {
        return (T) holder.getInternal(resource);
    }

    public static <T> T release(Resource<T> resource, T t2) {
        return (T) holder.releaseInternal(resource, t2);
    }

    public synchronized <T> T getInternal(Resource<T> resource) {
        Instance instance;
        instance = this.instances.get(resource);
        if (instance == null) {
            instance = new Instance(resource.create());
            this.instances.put(resource, instance);
        }
        ScheduledFuture<?> scheduledFuture = instance.destroyTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            instance.destroyTask = null;
        }
        instance.refcount++;
        return (T) instance.payload;
    }

    public synchronized <T> T releaseInternal(final Resource<T> resource, final T t2) {
        final Instance instance = this.instances.get(resource);
        if (instance != null) {
            o.e(t2 == instance.payload, "Releasing the wrong instance");
            o.y(instance.refcount > 0, "Refcount has already reached zero");
            int i10 = instance.refcount - 1;
            instance.refcount = i10;
            if (i10 == 0) {
                o.y(instance.destroyTask == null, "Destroy task already scheduled");
                if (this.destroyer == null) {
                    this.destroyer = this.destroyerFactory.createScheduledExecutor();
                }
                instance.destroyTask = this.destroyer.schedule(new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.SharedResourceHolder.2
                    /* JADX WARN: Finally extract failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SharedResourceHolder.this) {
                            if (instance.refcount == 0) {
                                try {
                                    resource.close(t2);
                                    SharedResourceHolder.this.instances.remove(resource);
                                    if (SharedResourceHolder.this.instances.isEmpty()) {
                                        SharedResourceHolder.this.destroyer.shutdown();
                                        SharedResourceHolder.this.destroyer = null;
                                    }
                                } catch (Throwable th) {
                                    SharedResourceHolder.this.instances.remove(resource);
                                    if (SharedResourceHolder.this.instances.isEmpty()) {
                                        SharedResourceHolder.this.destroyer.shutdown();
                                        SharedResourceHolder.this.destroyer = null;
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                }), 1L, TimeUnit.SECONDS);
            }
        } else {
            throw new IllegalArgumentException("No cached instance found for " + ((Object) resource));
        }
        return null;
    }
}
