package android.widget;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.huawei.openalliance.ad.ipc.c;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Filter {
    private static final int FILTER_TOKEN = -791613427;
    private static final int FINISH_TOKEN = -559038737;
    private static final String LOG_TAG = "Filter";
    private static final String THREAD_NAME = "Filter";
    private Delayer mDelayer;
    private final Object mLock = new Object();
    private Handler mResultHandler = new ResultsHandler();
    private Handler mThreadHandler;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Delayer {
        long getPostingDelay(CharSequence charSequence);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface FilterListener {
        void onFilterComplete(int i10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    protected static class FilterResults {
        public int count;
        public Object values;
    }

    protected abstract FilterResults performFiltering(CharSequence charSequence);

    protected abstract void publishResults(CharSequence charSequence, FilterResults filterResults);

    public void setDelayer(Delayer delayer) {
        synchronized (this.mLock) {
            this.mDelayer = delayer;
        }
    }

    public final void filter(CharSequence constraint) {
        filter(constraint, null);
    }

    public final void filter(CharSequence charSequence, FilterListener filterListener) {
        synchronized (this.mLock) {
            if (this.mThreadHandler == null) {
                HandlerThread handlerThread = new HandlerThread("Filter", 10);
                handlerThread.start();
                this.mThreadHandler = new RequestHandler(handlerThread.getLooper());
            }
            Delayer delayer = this.mDelayer;
            long postingDelay = delayer == null ? 0L : delayer.getPostingDelay(charSequence);
            Message obtainMessage = this.mThreadHandler.obtainMessage(FILTER_TOKEN);
            RequestArguments requestArguments = new RequestArguments();
            requestArguments.constraint = charSequence != null ? charSequence.toString() : null;
            requestArguments.listener = filterListener;
            obtainMessage.obj = requestArguments;
            this.mThreadHandler.removeMessages(FILTER_TOKEN);
            this.mThreadHandler.removeMessages(FINISH_TOKEN);
            this.mThreadHandler.sendMessageDelayed(obtainMessage, postingDelay);
        }
    }

    public CharSequence convertResultToString(Object resultValue) {
        return resultValue == null ? "" : resultValue.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class RequestHandler extends Handler {
        public RequestHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what) {
                case Filter.FILTER_TOKEN /* -791613427 */:
                    RequestArguments args = (RequestArguments) msg.obj;
                    try {
                        try {
                            args.results = Filter.this.performFiltering(args.constraint);
                        } catch (Exception e2) {
                            args.results = new FilterResults();
                            Log.w("Filter", "An exception occured during performFiltering()!", e2);
                        }
                        synchronized (Filter.this.mLock) {
                            if (Filter.this.mThreadHandler != null) {
                                Message finishMessage = Filter.this.mThreadHandler.obtainMessage(Filter.FINISH_TOKEN);
                                Filter.this.mThreadHandler.sendMessageDelayed(finishMessage, c.Code);
                            }
                        }
                        return;
                    } finally {
                        Message message = Filter.this.mResultHandler.obtainMessage(what);
                        message.obj = args;
                        message.sendToTarget();
                    }
                case Filter.FINISH_TOKEN /* -559038737 */:
                    synchronized (Filter.this.mLock) {
                        if (Filter.this.mThreadHandler != null) {
                            Filter.this.mThreadHandler.getLooper().quit();
                            Filter.this.mThreadHandler = null;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class ResultsHandler extends Handler {
        private ResultsHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            RequestArguments args = (RequestArguments) msg.obj;
            Filter.this.publishResults(args.constraint, args.results);
            if (args.listener != null) {
                int count = args.results != null ? args.results.count : -1;
                args.listener.onFilterComplete(count);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RequestArguments {
        CharSequence constraint;
        FilterListener listener;
        FilterResults results;

        private RequestArguments() {
        }
    }
}
