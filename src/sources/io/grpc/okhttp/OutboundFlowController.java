package io.grpc.okhttp;

import androidx.core.app.NotificationCompat;
import com.google.common.base.o;
import io.grpc.okhttp.internal.framed.FrameWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import okio.Buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class OutboundFlowController {
    private final FrameWriter frameWriter;
    private final Transport transport;
    private int initialWindowSize = 65535;
    private final StreamState connectionState = new StreamState(0, 65535, null);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Stream {
        void onSentBytes(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class StreamState {
        private int allocatedBytes;
        private Runnable noPendingDataRunnable;
        private final Stream stream;
        private final int streamId;
        private int window;
        private final Buffer pendingWriteBuffer = new Buffer();
        private boolean pendingBufferHasEndOfStream = false;

        public StreamState(int i10, int i11, Stream stream) {
            this.streamId = i10;
            this.window = i11;
            this.stream = stream;
        }

        public void allocateBytes(int i10) {
            this.allocatedBytes += i10;
        }

        public int allocatedBytes() {
            return this.allocatedBytes;
        }

        public void clearAllocatedBytes() {
            this.allocatedBytes = 0;
        }

        public void enqueueData(Buffer buffer, int i10, boolean z10) {
            this.pendingWriteBuffer.write(buffer, i10);
            this.pendingBufferHasEndOfStream |= z10;
        }

        public boolean hasPendingData() {
            return this.pendingWriteBuffer.size() > 0;
        }

        public int incrementStreamWindow(int i10) {
            if (i10 > 0 && Integer.MAX_VALUE - i10 < this.window) {
                throw new IllegalArgumentException("Window size overflow for stream: " + this.streamId);
            }
            int i11 = this.window + i10;
            this.window = i11;
            return i11;
        }

        public void notifyWhenNoPendingData(Runnable runnable) {
            o.y(this.noPendingDataRunnable == null, "pending data notification already requested");
            this.noPendingDataRunnable = runnable;
        }

        public int streamableBytes() {
            return Math.max(0, Math.min(this.window, (int) this.pendingWriteBuffer.size()));
        }

        public int unallocatedBytes() {
            return streamableBytes() - this.allocatedBytes;
        }

        public int window() {
            return this.window;
        }

        public int writableWindow() {
            return Math.min(this.window, OutboundFlowController.this.connectionState.window());
        }

        public void write(Buffer buffer, int i10, boolean z10) {
            do {
                int min = Math.min(i10, OutboundFlowController.this.frameWriter.maxDataLength());
                int i11 = -min;
                OutboundFlowController.this.connectionState.incrementStreamWindow(i11);
                incrementStreamWindow(i11);
                try {
                    OutboundFlowController.this.frameWriter.data(buffer.size() == ((long) min) && z10, this.streamId, buffer, min);
                    this.stream.onSentBytes(min);
                    i10 -= min;
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } while (i10 > 0);
        }

        public int writeBytes(int i10, WriteStatus writeStatus) {
            Runnable runnable;
            int min = Math.min(i10, writableWindow());
            int i11 = 0;
            while (hasPendingData() && min > 0) {
                if (min >= this.pendingWriteBuffer.size()) {
                    i11 += (int) this.pendingWriteBuffer.size();
                    Buffer buffer = this.pendingWriteBuffer;
                    write(buffer, (int) buffer.size(), this.pendingBufferHasEndOfStream);
                } else {
                    i11 += min;
                    write(this.pendingWriteBuffer, min, false);
                }
                writeStatus.incrementNumWrites();
                min = Math.min(i10 - i11, writableWindow());
            }
            if (!hasPendingData() && (runnable = this.noPendingDataRunnable) != null) {
                runnable.run();
                this.noPendingDataRunnable = null;
            }
            return i11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Transport {
        StreamState[] getActiveStreams();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class WriteStatus {
        public int numWrites;

        private WriteStatus() {
        }

        public boolean hasWritten() {
            return this.numWrites > 0;
        }

        public void incrementNumWrites() {
            this.numWrites++;
        }
    }

    public OutboundFlowController(Transport transport, FrameWriter frameWriter) {
        this.transport = (Transport) o.s(transport, NotificationCompat.CATEGORY_TRANSPORT);
        this.frameWriter = (FrameWriter) o.s(frameWriter, "frameWriter");
    }

    public StreamState createState(Stream stream, int i10) {
        return new StreamState(i10, this.initialWindowSize, (Stream) o.s(stream, "stream"));
    }

    public void data(boolean z10, StreamState streamState, Buffer buffer, boolean z11) {
        o.s(buffer, "source");
        int writableWindow = streamState.writableWindow();
        boolean hasPendingData = streamState.hasPendingData();
        int size = (int) buffer.size();
        if (!hasPendingData && writableWindow >= size) {
            streamState.write(buffer, size, z10);
        } else {
            if (!hasPendingData && writableWindow > 0) {
                streamState.write(buffer, writableWindow, false);
            }
            streamState.enqueueData(buffer, (int) buffer.size(), z10);
        }
        if (z11) {
            flush();
        }
    }

    public void flush() {
        try {
            this.frameWriter.flush();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean initialOutboundWindowSize(int i10) {
        if (i10 >= 0) {
            int i11 = i10 - this.initialWindowSize;
            this.initialWindowSize = i10;
            for (StreamState streamState : this.transport.getActiveStreams()) {
                streamState.incrementStreamWindow(i11);
            }
            return i11 > 0;
        }
        throw new IllegalArgumentException("Invalid initial window size: " + i10);
    }

    public void notifyWhenNoPendingData(StreamState streamState, Runnable runnable) {
        o.s(runnable, "noPendingDataRunnable");
        if (streamState.hasPendingData()) {
            streamState.notifyWhenNoPendingData(runnable);
        } else {
            runnable.run();
        }
    }

    public int windowUpdate(StreamState streamState, int i10) {
        if (streamState == null) {
            int incrementStreamWindow = this.connectionState.incrementStreamWindow(i10);
            writeStreams();
            return incrementStreamWindow;
        }
        int incrementStreamWindow2 = streamState.incrementStreamWindow(i10);
        WriteStatus writeStatus = new WriteStatus();
        streamState.writeBytes(streamState.writableWindow(), writeStatus);
        if (writeStatus.hasWritten()) {
            flush();
        }
        return incrementStreamWindow2;
    }

    public void writeStreams() {
        int i10;
        StreamState[] activeStreams = this.transport.getActiveStreams();
        Collections.shuffle(Arrays.asList(activeStreams));
        int window = this.connectionState.window();
        int length = activeStreams.length;
        while (true) {
            i10 = 0;
            if (length <= 0 || window <= 0) {
                break;
            }
            int ceil = (int) Math.ceil(window / length);
            for (int i11 = 0; i11 < length && window > 0; i11++) {
                StreamState streamState = activeStreams[i11];
                int min = Math.min(window, Math.min(streamState.unallocatedBytes(), ceil));
                if (min > 0) {
                    streamState.allocateBytes(min);
                    window -= min;
                }
                if (streamState.unallocatedBytes() > 0) {
                    activeStreams[i10] = streamState;
                    i10++;
                }
            }
            length = i10;
        }
        WriteStatus writeStatus = new WriteStatus();
        StreamState[] activeStreams2 = this.transport.getActiveStreams();
        int length2 = activeStreams2.length;
        while (i10 < length2) {
            StreamState streamState2 = activeStreams2[i10];
            streamState2.writeBytes(streamState2.allocatedBytes(), writeStatus);
            streamState2.clearAllocatedBytes();
            i10++;
        }
        if (writeStatus.hasWritten()) {
            flush();
        }
    }
}
