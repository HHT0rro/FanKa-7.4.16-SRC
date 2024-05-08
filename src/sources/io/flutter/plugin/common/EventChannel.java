package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import sun.security.util.SecurityConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class EventChannel {
    private static final String TAG = "EventChannel#";
    private final MethodCodec codec;
    private final BinaryMessenger messenger;
    private final String name;

    @Nullable
    private final BinaryMessenger.TaskQueue taskQueue;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface EventSink {
        void endOfStream();

        void error(String str, String str2, Object obj);

        void success(Object obj);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class IncomingStreamRequestHandler implements BinaryMessenger.BinaryMessageHandler {
        private final AtomicReference<EventSink> activeSink = new AtomicReference<>(null);
        private final StreamHandler handler;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class EventSinkImplementation implements EventSink {
            public final AtomicBoolean hasEnded;

            private EventSinkImplementation() {
                this.hasEnded = new AtomicBoolean(false);
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void endOfStream() {
                if (this.hasEnded.getAndSet(true) || IncomingStreamRequestHandler.this.activeSink.get() != this) {
                    return;
                }
                EventChannel.this.messenger.send(EventChannel.this.name, null);
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void error(String str, String str2, Object obj) {
                if (this.hasEnded.get() || IncomingStreamRequestHandler.this.activeSink.get() != this) {
                    return;
                }
                EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeErrorEnvelope(str, str2, obj));
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void success(Object obj) {
                if (this.hasEnded.get() || IncomingStreamRequestHandler.this.activeSink.get() != this) {
                    return;
                }
                EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeSuccessEnvelope(obj));
            }
        }

        public IncomingStreamRequestHandler(StreamHandler streamHandler) {
            this.handler = streamHandler;
        }

        private void onCancel(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            if (this.activeSink.getAndSet(null) != null) {
                try {
                    this.handler.onCancel(obj);
                    binaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope(null));
                    return;
                } catch (RuntimeException e2) {
                    Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to close event stream", e2);
                    binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", e2.getMessage(), null));
                    return;
                }
            }
            binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", "No active stream to cancel", null));
        }

        private void onListen(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            EventSinkImplementation eventSinkImplementation = new EventSinkImplementation();
            if (this.activeSink.getAndSet(eventSinkImplementation) != null) {
                try {
                    this.handler.onCancel(null);
                } catch (RuntimeException e2) {
                    Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to close existing event stream", e2);
                }
            }
            try {
                this.handler.onListen(obj, eventSinkImplementation);
                binaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope(null));
            } catch (RuntimeException e10) {
                this.activeSink.set(null);
                Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to open event stream", e10);
                binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", e10.getMessage(), null));
            }
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            MethodCall decodeMethodCall = EventChannel.this.codec.decodeMethodCall(byteBuffer);
            if (decodeMethodCall.method.equals(SecurityConstants.SOCKET_LISTEN_ACTION)) {
                onListen(decodeMethodCall.arguments, binaryReply);
            } else if (decodeMethodCall.method.equals(CardEventType.CLICK_ACTION_CANCEL)) {
                onCancel(decodeMethodCall.arguments, binaryReply);
            } else {
                binaryReply.reply(null);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface StreamHandler {
        void onCancel(Object obj);

        void onListen(Object obj, EventSink eventSink);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    @UiThread
    public void setStreamHandler(StreamHandler streamHandler) {
        if (this.taskQueue != null) {
            this.messenger.setMessageHandler(this.name, streamHandler != null ? new IncomingStreamRequestHandler(streamHandler) : null, this.taskQueue);
        } else {
            this.messenger.setMessageHandler(this.name, streamHandler != null ? new IncomingStreamRequestHandler(streamHandler) : null);
        }
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this(binaryMessenger, str, methodCodec, null);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec, BinaryMessenger.TaskQueue taskQueue) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = methodCodec;
        this.taskQueue = taskQueue;
    }
}
