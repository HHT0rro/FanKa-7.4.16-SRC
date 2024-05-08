package io.grpc.internal;

import com.google.common.base.o;
import com.huawei.openalliance.ad.constant.bg;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframerListener;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ApplicationThreadDeframer implements Deframer {
    private final ApplicationThreadDeframerListener appListener;
    private final MessageDeframer deframer;
    private final MessageDeframer.Listener storedListener;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class CloseableInitializingMessageProducer extends InitializingMessageProducer implements Closeable {
        private final Closeable closeable;

        public CloseableInitializingMessageProducer(Runnable runnable, Closeable closeable) {
            super(runnable);
            this.closeable = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closeable.close();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class InitializingMessageProducer implements StreamListener.MessageProducer {
        private boolean initialized;
        private final Runnable runnable;

        private void initialize() {
            if (this.initialized) {
                return;
            }
            this.runnable.run();
            this.initialized = true;
        }

        @Override // io.grpc.internal.StreamListener.MessageProducer
        public InputStream next() {
            initialize();
            return ApplicationThreadDeframer.this.appListener.messageReadQueuePoll();
        }

        private InitializingMessageProducer(Runnable runnable) {
            this.initialized = false;
            this.runnable = runnable;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface TransportExecutor extends ApplicationThreadDeframerListener.TransportExecutor {
    }

    public ApplicationThreadDeframer(MessageDeframer.Listener listener, TransportExecutor transportExecutor, MessageDeframer messageDeframer) {
        SquelchLateMessagesAvailableDeframerListener squelchLateMessagesAvailableDeframerListener = new SquelchLateMessagesAvailableDeframerListener((MessageDeframer.Listener) o.s(listener, bg.e.f32299p));
        this.storedListener = squelchLateMessagesAvailableDeframerListener;
        ApplicationThreadDeframerListener applicationThreadDeframerListener = new ApplicationThreadDeframerListener(squelchLateMessagesAvailableDeframerListener, transportExecutor);
        this.appListener = applicationThreadDeframerListener;
        messageDeframer.setListener(applicationThreadDeframerListener);
        this.deframer = messageDeframer;
    }

    @Override // io.grpc.internal.Deframer
    public void close() {
        this.deframer.stopDelivery();
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.5
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.deframer.close();
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.4
            @Override // java.lang.Runnable
            public void run() {
                ApplicationThreadDeframer.this.deframer.closeWhenComplete();
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(final ReadableBuffer readableBuffer) {
        this.storedListener.messagesAvailable(new CloseableInitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ApplicationThreadDeframer.this.deframer.deframe(readableBuffer);
                } catch (Throwable th) {
                    ApplicationThreadDeframer.this.appListener.deframeFailed(th);
                    ApplicationThreadDeframer.this.deframer.close();
                }
            }
        }, new Closeable() { // from class: io.grpc.internal.ApplicationThreadDeframer.3
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                readableBuffer.close();
            }
        }));
    }

    public MessageDeframer.Listener getAppListener() {
        return this.appListener;
    }

    @Override // io.grpc.internal.Deframer
    public void request(final int i10) {
        this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() { // from class: io.grpc.internal.ApplicationThreadDeframer.1
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationThreadDeframer.this.deframer.isClosed()) {
                    return;
                }
                try {
                    ApplicationThreadDeframer.this.deframer.request(i10);
                } catch (Throwable th) {
                    ApplicationThreadDeframer.this.appListener.deframeFailed(th);
                    ApplicationThreadDeframer.this.deframer.close();
                }
            }
        }));
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
        this.deframer.setFullStreamDecompressor(gzipInflatingBuffer);
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int i10) {
        this.deframer.setMaxInboundMessageSize(i10);
    }
}
