package android.widget;

import android.app.IServiceConnection;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.RemoteViewsAdapter;
import com.android.internal.widget.IRemoteViewsFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RemoteViewsAdapter extends BaseAdapter implements Handler.Callback {
    private static final int CACHE_RESET_CONFIG_FLAGS = -1073737216;
    private static final int DEFAULT_CACHE_SIZE = 40;
    private static final int DEFAULT_LOADING_VIEW_HEIGHT = 50;
    static final int MSG_LOAD_NEXT_ITEM = 3;
    private static final int MSG_MAIN_HANDLER_COMMIT_METADATA = 1;
    private static final int MSG_MAIN_HANDLER_REMOTE_ADAPTER_CONNECTED = 3;
    private static final int MSG_MAIN_HANDLER_REMOTE_ADAPTER_DISCONNECTED = 4;
    private static final int MSG_MAIN_HANDLER_REMOTE_VIEWS_LOADED = 5;
    private static final int MSG_MAIN_HANDLER_SUPER_NOTIFY_DATA_SET_CHANGED = 2;
    static final int MSG_NOTIFY_DATA_SET_CHANGED = 2;
    static final int MSG_REQUEST_BIND = 1;
    static final int MSG_UNBIND_SERVICE = 4;
    private static final int REMOTE_VIEWS_CACHE_DURATION = 5000;
    private static final String TAG = "RemoteViewsAdapter";
    private static final int UNBIND_SERVICE_DELAY = 5000;
    private static Handler sCacheRemovalQueue;
    private static HandlerThread sCacheRemovalThread;
    private static final HashMap<RemoteViewsCacheKey, FixedSizeRemoteViewsCache> sCachedRemoteViewsCaches = new HashMap<>();
    private static final HashMap<RemoteViewsCacheKey, Runnable> sRemoteViewsCacheRemoveRunnables = new HashMap<>();
    private final int mAppWidgetId;
    private final Executor mAsyncViewLoadExecutor;
    private final FixedSizeRemoteViewsCache mCache;
    private final RemoteAdapterConnectionCallback mCallback;
    private final Context mContext;
    private boolean mDataReady;
    private final Intent mIntent;
    private ApplicationInfo mLastRemoteViewAppInfo;
    private final Handler mMainHandler;
    private final boolean mOnLightBackground;
    private RemoteViews.InteractionHandler mRemoteViewsInteractionHandler;
    private RemoteViewsFrameLayoutRefSet mRequestedViews;
    private final RemoteServiceHandler mServiceHandler;
    private int mVisibleWindowLowerBound;
    private int mVisibleWindowUpperBound;
    private final HandlerThread mWorkerThread;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface RemoteAdapterConnectionCallback {
        void deferNotifyDataSetChanged();

        boolean onRemoteAdapterConnected();

        void onRemoteAdapterDisconnected();

        void setRemoteViewsAdapter(Intent intent, boolean z10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class AsyncRemoteAdapterAction implements Runnable {
        private final RemoteAdapterConnectionCallback mCallback;
        private final Intent mIntent;

        public AsyncRemoteAdapterAction(RemoteAdapterConnectionCallback callback, Intent intent) {
            this.mCallback = callback;
            this.mIntent = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCallback.setRemoteViewsAdapter(this.mIntent, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RemoteServiceHandler extends Handler implements ServiceConnection {
        private final WeakReference<RemoteViewsAdapter> mAdapter;
        private boolean mBindRequested;
        private final Context mContext;
        private boolean mNotifyDataSetChangedPending;
        private IRemoteViewsFactory mRemoteViewsFactory;

        RemoteServiceHandler(Looper workerLooper, RemoteViewsAdapter adapter, Context context) {
            super(workerLooper);
            this.mNotifyDataSetChangedPending = false;
            this.mBindRequested = false;
            this.mAdapter = new WeakReference<>(adapter);
            this.mContext = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            this.mRemoteViewsFactory = IRemoteViewsFactory.Stub.asInterface(service);
            enqueueDeferredUnbindServiceMessage();
            RemoteViewsAdapter adapter = this.mAdapter.get();
            if (adapter == null) {
                return;
            }
            if (this.mNotifyDataSetChangedPending) {
                this.mNotifyDataSetChangedPending = false;
                Message msg = Message.obtain(this, 2);
                handleMessage(msg);
                msg.recycle();
                return;
            }
            if (!sendNotifyDataSetChange(false)) {
                return;
            }
            adapter.updateTemporaryMetaData(this.mRemoteViewsFactory);
            adapter.mMainHandler.sendEmptyMessage(1);
            adapter.mMainHandler.sendEmptyMessage(3);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            this.mRemoteViewsFactory = null;
            RemoteViewsAdapter adapter = this.mAdapter.get();
            if (adapter != null) {
                adapter.mMainHandler.sendEmptyMessage(4);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int newCount;
            int[] visibleWindow;
            RemoteViewsAdapter adapter = this.mAdapter.get();
            switch (msg.what) {
                case 1:
                    if (adapter == null || this.mRemoteViewsFactory != null) {
                        enqueueDeferredUnbindServiceMessage();
                    }
                    if (this.mBindRequested) {
                        return;
                    }
                    IServiceConnection sd2 = this.mContext.getServiceDispatcher(this, this, 33554433);
                    Intent intent = (Intent) msg.obj;
                    int appWidgetId = msg.arg1;
                    try {
                        this.mBindRequested = AppWidgetManager.getInstance(this.mContext).bindRemoteViewsService(this.mContext, appWidgetId, intent, sd2, 33554433);
                        return;
                    } catch (Exception e2) {
                        Log.e(RemoteViewsAdapter.TAG, "Failed to bind remoteViewsService: " + e2.getMessage());
                        return;
                    }
                case 2:
                    enqueueDeferredUnbindServiceMessage();
                    if (adapter == null) {
                        return;
                    }
                    if (this.mRemoteViewsFactory == null) {
                        this.mNotifyDataSetChangedPending = true;
                        adapter.requestBindService();
                        return;
                    }
                    if (!sendNotifyDataSetChange(true)) {
                        return;
                    }
                    synchronized (adapter.mCache) {
                        adapter.mCache.reset();
                    }
                    adapter.updateTemporaryMetaData(this.mRemoteViewsFactory);
                    synchronized (adapter.mCache.getTemporaryMetaData()) {
                        newCount = adapter.mCache.getTemporaryMetaData().count;
                        visibleWindow = adapter.getVisibleWindow(newCount);
                    }
                    for (int position : visibleWindow) {
                        if (position < newCount) {
                            adapter.updateRemoteViews(this.mRemoteViewsFactory, position, false);
                        }
                    }
                    adapter.mMainHandler.sendEmptyMessage(1);
                    adapter.mMainHandler.sendEmptyMessage(2);
                    return;
                case 3:
                    if (adapter == null || this.mRemoteViewsFactory == null) {
                        return;
                    }
                    removeMessages(4);
                    int position2 = adapter.mCache.getNextIndexToLoad();
                    if (position2 > -1) {
                        adapter.updateRemoteViews(this.mRemoteViewsFactory, position2, true);
                        sendEmptyMessage(3);
                        return;
                    } else {
                        enqueueDeferredUnbindServiceMessage();
                        return;
                    }
                case 4:
                    unbindNow();
                    return;
                default:
                    return;
            }
        }

        protected void unbindNow() {
            if (this.mBindRequested) {
                this.mBindRequested = false;
                this.mContext.unbindService(this);
            }
            this.mRemoteViewsFactory = null;
        }

        private boolean sendNotifyDataSetChange(boolean always) {
            if (!always) {
                try {
                    if (this.mRemoteViewsFactory.isCreated()) {
                        return true;
                    }
                } catch (RemoteException | RuntimeException e2) {
                    Log.e(RemoteViewsAdapter.TAG, "Error in updateNotifyDataSetChanged(): " + e2.getMessage());
                    return false;
                }
            }
            this.mRemoteViewsFactory.onDataSetChanged();
            return true;
        }

        private void enqueueDeferredUnbindServiceMessage() {
            removeMessages(4);
            sendEmptyMessageDelayed(4, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RemoteViewsFrameLayout extends AppWidgetHostView {
        public int cacheIndex;
        private final FixedSizeRemoteViewsCache mCache;

        public RemoteViewsFrameLayout(Context context, FixedSizeRemoteViewsCache cache) {
            super(context);
            this.cacheIndex = -1;
            this.mCache = cache;
        }

        public void onRemoteViewsLoaded(RemoteViews view, RemoteViews.InteractionHandler handler, boolean forceApplyAsync) {
            setInteractionHandler(handler);
            applyRemoteViews(view, forceApplyAsync || (view != null && view.prefersAsyncApply()));
        }

        @Override // android.appwidget.AppWidgetHostView
        protected View getDefaultView() {
            int viewHeight = this.mCache.getMetaData().getLoadingTemplate(getContext()).defaultHeight;
            TextView loadingTextView = (TextView) LayoutInflater.from(getContext()).inflate(17367293, (ViewGroup) this, false);
            loadingTextView.setHeight(viewHeight);
            return loadingTextView;
        }

        protected Context getRemoteContextEnsuringCorrectCachedApkPath() {
            return null;
        }

        @Override // android.appwidget.AppWidgetHostView
        protected View getErrorView() {
            return getDefaultView();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class RemoteViewsFrameLayoutRefSet extends SparseArray<ArrayList<RemoteViewsFrameLayout>> {
        private RemoteViewsFrameLayoutRefSet() {
        }

        public void add(int position, RemoteViewsFrameLayout layout) {
            ArrayList<RemoteViewsFrameLayout> refs = get(position);
            if (refs == null) {
                refs = new ArrayList<>();
                put(position, refs);
            }
            layout.cacheIndex = position;
            refs.add(layout);
        }

        public void notifyOnRemoteViewsLoaded(int position, RemoteViews view) {
            ArrayList<RemoteViewsFrameLayout> refs;
            if (view != null && (refs = (ArrayList) removeReturnOld(position)) != null) {
                Iterator<RemoteViewsFrameLayout> iterator2 = refs.iterator2();
                while (iterator2.hasNext()) {
                    RemoteViewsFrameLayout ref = iterator2.next();
                    ref.onRemoteViewsLoaded(view, RemoteViewsAdapter.this.mRemoteViewsInteractionHandler, true);
                }
            }
        }

        public void removeView(RemoteViewsFrameLayout rvfl) {
            if (rvfl.cacheIndex < 0) {
                return;
            }
            ArrayList<RemoteViewsFrameLayout> refs = get(rvfl.cacheIndex);
            if (refs != null) {
                refs.remove(rvfl);
            }
            rvfl.cacheIndex = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RemoteViewsMetaData {
        int count;
        boolean hasStableIds;
        LoadingViewTemplate loadingTemplate;
        private final SparseIntArray mTypeIdIndexMap = new SparseIntArray();
        int viewTypeCount;

        public RemoteViewsMetaData() {
            reset();
        }

        public void set(RemoteViewsMetaData d10) {
            synchronized (d10) {
                this.count = d10.count;
                this.viewTypeCount = d10.viewTypeCount;
                this.hasStableIds = d10.hasStableIds;
                this.loadingTemplate = d10.loadingTemplate;
            }
        }

        public void reset() {
            this.count = 0;
            this.viewTypeCount = 1;
            this.hasStableIds = true;
            this.loadingTemplate = null;
            this.mTypeIdIndexMap.clear();
        }

        public int getMappedViewType(int typeId) {
            int mappedTypeId = this.mTypeIdIndexMap.get(typeId, -1);
            if (mappedTypeId == -1) {
                int mappedTypeId2 = this.mTypeIdIndexMap.size() + 1;
                this.mTypeIdIndexMap.put(typeId, mappedTypeId2);
                return mappedTypeId2;
            }
            return mappedTypeId;
        }

        public boolean isViewTypeInRange(int typeId) {
            int mappedType = getMappedViewType(typeId);
            return mappedType < this.viewTypeCount;
        }

        public synchronized LoadingViewTemplate getLoadingTemplate(Context context) {
            if (this.loadingTemplate == null) {
                this.loadingTemplate = new LoadingViewTemplate(null, context);
            }
            return this.loadingTemplate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RemoteViewsIndexMetaData {
        long itemId;
        int typeId;

        public RemoteViewsIndexMetaData(RemoteViews v2, long itemId) {
            set(v2, itemId);
        }

        public void set(RemoteViews v2, long id2) {
            this.itemId = id2;
            if (v2 != null) {
                this.typeId = v2.getLayoutId();
            } else {
                this.typeId = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class FixedSizeRemoteViewsCache {
        private static final float sMaxCountSlackPercent = 0.75f;
        private static final int sMaxMemoryLimitInBytes = 2097152;
        private final Configuration mConfiguration;
        private final int mMaxCount;
        private final int mMaxCountSlack;
        private final RemoteViewsMetaData mMetaData = new RemoteViewsMetaData();
        private final RemoteViewsMetaData mTemporaryMetaData = new RemoteViewsMetaData();
        private final SparseArray<RemoteViewsIndexMetaData> mIndexMetaData = new SparseArray<>();
        private final SparseArray<RemoteViews> mIndexRemoteViews = new SparseArray<>();
        private final SparseBooleanArray mIndicesToLoad = new SparseBooleanArray();
        private int mPreloadLowerBound = 0;
        private int mPreloadUpperBound = -1;
        private int mLastRequestedIndex = -1;

        FixedSizeRemoteViewsCache(int maxCacheSize, Configuration configuration) {
            this.mMaxCount = maxCacheSize;
            this.mMaxCountSlack = Math.round((maxCacheSize / 2) * 0.75f);
            this.mConfiguration = new Configuration(configuration);
        }

        public void insert(int position, RemoteViews v2, long itemId, int[] visibleWindow) {
            int trimIndex;
            if (this.mIndexRemoteViews.size() >= this.mMaxCount) {
                this.mIndexRemoteViews.remove(getFarthestPositionFrom(position, visibleWindow));
            }
            int pruneFromPosition = this.mLastRequestedIndex;
            if (pruneFromPosition <= -1) {
                pruneFromPosition = position;
            }
            while (getRemoteViewsBitmapMemoryUsage() >= 2097152 && (trimIndex = getFarthestPositionFrom(pruneFromPosition, visibleWindow)) >= 0) {
                this.mIndexRemoteViews.remove(trimIndex);
            }
            RemoteViewsIndexMetaData metaData = this.mIndexMetaData.get(position);
            if (metaData != null) {
                metaData.set(v2, itemId);
            } else {
                this.mIndexMetaData.put(position, new RemoteViewsIndexMetaData(v2, itemId));
            }
            this.mIndexRemoteViews.put(position, v2);
        }

        public RemoteViewsMetaData getMetaData() {
            return this.mMetaData;
        }

        public RemoteViewsMetaData getTemporaryMetaData() {
            return this.mTemporaryMetaData;
        }

        public RemoteViews getRemoteViewsAt(int position) {
            return this.mIndexRemoteViews.get(position);
        }

        public RemoteViewsIndexMetaData getMetaDataAt(int position) {
            return this.mIndexMetaData.get(position);
        }

        public void commitTemporaryMetaData() {
            synchronized (this.mTemporaryMetaData) {
                synchronized (this.mMetaData) {
                    this.mMetaData.set(this.mTemporaryMetaData);
                }
            }
        }

        private int getRemoteViewsBitmapMemoryUsage() {
            int mem = 0;
            for (int i10 = this.mIndexRemoteViews.size() - 1; i10 >= 0; i10--) {
                RemoteViews v2 = this.mIndexRemoteViews.valueAt(i10);
                if (v2 != null) {
                    mem += v2.estimateMemoryUsage();
                }
            }
            return mem;
        }

        private int getFarthestPositionFrom(int pos, int[] visibleWindow) {
            int maxDist = 0;
            int maxDistIndex = -1;
            int maxDistNotVisible = 0;
            int maxDistIndexNotVisible = -1;
            for (int i10 = this.mIndexRemoteViews.size() - 1; i10 >= 0; i10--) {
                int index = this.mIndexRemoteViews.keyAt(i10);
                int dist = Math.abs(index - pos);
                if (dist > maxDistNotVisible && Arrays.binarySearch(visibleWindow, index) < 0) {
                    maxDistIndexNotVisible = index;
                    maxDistNotVisible = dist;
                }
                if (dist >= maxDist) {
                    maxDistIndex = index;
                    maxDist = dist;
                }
            }
            if (maxDistIndexNotVisible > -1) {
                return maxDistIndexNotVisible;
            }
            return maxDistIndex;
        }

        public void queueRequestedPositionToLoad(int position) {
            this.mLastRequestedIndex = position;
            synchronized (this.mIndicesToLoad) {
                this.mIndicesToLoad.put(position, true);
            }
        }

        public boolean queuePositionsToBePreloadedFromRequestedPosition(int position) {
            int count;
            int i10;
            int i11 = this.mPreloadLowerBound;
            if (i11 <= position && position <= (i10 = this.mPreloadUpperBound)) {
                int center = (i10 + i11) / 2;
                if (Math.abs(position - center) < this.mMaxCountSlack) {
                    return false;
                }
            }
            synchronized (this.mMetaData) {
                count = this.mMetaData.count;
            }
            synchronized (this.mIndicesToLoad) {
                for (int i12 = this.mIndicesToLoad.size() - 1; i12 >= 0; i12--) {
                    if (!this.mIndicesToLoad.valueAt(i12)) {
                        this.mIndicesToLoad.removeAt(i12);
                    }
                }
                int i13 = this.mMaxCount;
                int halfMaxCount = i13 / 2;
                int i14 = position - halfMaxCount;
                this.mPreloadLowerBound = i14;
                this.mPreloadUpperBound = position + halfMaxCount;
                int effectiveLowerBound = Math.max(0, i14);
                int effectiveUpperBound = Math.min(this.mPreloadUpperBound, count - 1);
                for (int i15 = effectiveLowerBound; i15 <= effectiveUpperBound; i15++) {
                    if (this.mIndexRemoteViews.indexOfKey(i15) < 0 && !this.mIndicesToLoad.get(i15)) {
                        this.mIndicesToLoad.put(i15, false);
                    }
                }
            }
            return true;
        }

        public int getNextIndexToLoad() {
            synchronized (this.mIndicesToLoad) {
                int index = this.mIndicesToLoad.indexOfValue(true);
                if (index < 0) {
                    index = this.mIndicesToLoad.indexOfValue(false);
                }
                if (index < 0) {
                    return -1;
                }
                int key = this.mIndicesToLoad.keyAt(index);
                this.mIndicesToLoad.removeAt(index);
                return key;
            }
        }

        public boolean containsRemoteViewAt(int position) {
            return this.mIndexRemoteViews.indexOfKey(position) >= 0;
        }

        public boolean containsMetaDataAt(int position) {
            return this.mIndexMetaData.indexOfKey(position) >= 0;
        }

        public void reset() {
            this.mPreloadLowerBound = 0;
            this.mPreloadUpperBound = -1;
            this.mLastRequestedIndex = -1;
            this.mIndexRemoteViews.clear();
            this.mIndexMetaData.clear();
            synchronized (this.mIndicesToLoad) {
                this.mIndicesToLoad.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RemoteViewsCacheKey {
        final Intent.FilterComparison filter;
        final int widgetId;

        RemoteViewsCacheKey(Intent.FilterComparison filter, int widgetId) {
            this.filter = filter;
            this.widgetId = widgetId;
        }

        public boolean equals(Object o10) {
            if (!(o10 instanceof RemoteViewsCacheKey)) {
                return false;
            }
            RemoteViewsCacheKey other = (RemoteViewsCacheKey) o10;
            return other.filter.equals(this.filter) && other.widgetId == this.widgetId;
        }

        public int hashCode() {
            Intent.FilterComparison filterComparison = this.filter;
            return (filterComparison == null ? 0 : filterComparison.hashCode()) ^ (this.widgetId << 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d7 A[Catch: all -> 0x00dc, TryCatch #1 {, blocks: (B:12:0x008e, B:14:0x009e, B:17:0x00ad, B:18:0x00b9, B:25:0x00d3, B:27:0x00d7, B:28:0x00da, B:34:0x00c9, B:35:0x00ca, B:20:0x00ba, B:22:0x00c2, B:23:0x00c5), top: B:11:0x008e, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RemoteViewsAdapter(android.content.Context r7, android.content.Intent r8, android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback r9, boolean r10) {
        /*
            r6 = this;
            r6.<init>()
            r0 = 0
            r6.mDataReady = r0
            r6.mContext = r7
            r6.mIntent = r8
            if (r8 == 0) goto Ldf
            java.lang.String r1 = "remoteAdapterAppWidgetId"
            r2 = -1
            int r1 = r8.getIntExtra(r1, r2)
            r6.mAppWidgetId = r1
            android.widget.RemoteViewsAdapter$RemoteViewsFrameLayoutRefSet r2 = new android.widget.RemoteViewsAdapter$RemoteViewsFrameLayoutRefSet
            r3 = 0
            r2.<init>()
            r6.mRequestedViews = r2
            java.lang.String r2 = "remoteAdapterOnLightBackground"
            boolean r0 = r8.getBooleanExtra(r2, r0)
            r6.mOnLightBackground = r0
            java.lang.String r0 = "remoteAdapterAppWidgetId"
            r8.removeExtra(r0)
            java.lang.String r0 = "remoteAdapterOnLightBackground"
            r8.removeExtra(r0)
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.String r2 = "RemoteViewsCache-loader"
            r0.<init>(r2)
            r6.mWorkerThread = r0
            r0.start()
            android.os.Handler r2 = new android.os.Handler
            android.os.Looper r4 = android.os.Looper.myLooper()
            r2.<init>(r4, r6)
            r6.mMainHandler = r2
            android.widget.RemoteViewsAdapter$RemoteServiceHandler r2 = new android.widget.RemoteViewsAdapter$RemoteServiceHandler
            android.os.Looper r4 = r0.getLooper()
            android.content.Context r5 = r7.getApplicationContext()
            r2.<init>(r4, r6, r5)
            r6.mServiceHandler = r2
            if (r10 == 0) goto L60
            android.widget.RemoteViewsAdapter$HandlerThreadExecutor r3 = new android.widget.RemoteViewsAdapter$HandlerThreadExecutor
            r3.<init>(r0)
        L60:
            r6.mAsyncViewLoadExecutor = r3
            r6.mCallback = r9
            android.os.HandlerThread r0 = android.widget.RemoteViewsAdapter.sCacheRemovalThread
            if (r0 != 0) goto L81
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.String r2 = "RemoteViewsAdapter-cachePruner"
            r0.<init>(r2)
            android.widget.RemoteViewsAdapter.sCacheRemovalThread = r0
            r0.start()
            android.os.Handler r0 = new android.os.Handler
            android.os.HandlerThread r2 = android.widget.RemoteViewsAdapter.sCacheRemovalThread
            android.os.Looper r2 = r2.getLooper()
            r0.<init>(r2)
            android.widget.RemoteViewsAdapter.sCacheRemovalQueue = r0
        L81:
            android.widget.RemoteViewsAdapter$RemoteViewsCacheKey r0 = new android.widget.RemoteViewsAdapter$RemoteViewsCacheKey
            android.content.Intent$FilterComparison r2 = new android.content.Intent$FilterComparison
            r2.<init>(r8)
            r0.<init>(r2, r1)
            java.util.HashMap<android.widget.RemoteViewsAdapter$RemoteViewsCacheKey, android.widget.RemoteViewsAdapter$FixedSizeRemoteViewsCache> r1 = android.widget.RemoteViewsAdapter.sCachedRemoteViewsCaches
            monitor-enter(r1)
            java.lang.Object r2 = r1.get(r0)     // Catch: java.lang.Throwable -> Ldc
            android.widget.RemoteViewsAdapter$FixedSizeRemoteViewsCache r2 = (android.widget.RemoteViewsAdapter.FixedSizeRemoteViewsCache) r2     // Catch: java.lang.Throwable -> Ldc
            android.content.res.Resources r3 = r7.getResources()     // Catch: java.lang.Throwable -> Ldc
            android.content.res.Configuration r3 = r3.getConfiguration()     // Catch: java.lang.Throwable -> Ldc
            if (r2 == 0) goto Lca
            android.content.res.Configuration r4 = android.widget.RemoteViewsAdapter.FixedSizeRemoteViewsCache.m1390$$Nest$fgetmConfiguration(r2)     // Catch: java.lang.Throwable -> Ldc
            int r4 = r4.diff(r3)     // Catch: java.lang.Throwable -> Ldc
            r5 = -1073737216(0xffffffffc0001200, float:-2.0010986)
            r4 = r4 & r5
            if (r4 == 0) goto Lad
            goto Lca
        Lad:
            java.lang.Object r4 = r1.get(r0)     // Catch: java.lang.Throwable -> Ldc
            android.widget.RemoteViewsAdapter$FixedSizeRemoteViewsCache r4 = (android.widget.RemoteViewsAdapter.FixedSizeRemoteViewsCache) r4     // Catch: java.lang.Throwable -> Ldc
            r6.mCache = r4     // Catch: java.lang.Throwable -> Ldc
            android.widget.RemoteViewsAdapter$RemoteViewsMetaData r5 = android.widget.RemoteViewsAdapter.FixedSizeRemoteViewsCache.m1392$$Nest$fgetmMetaData(r4)     // Catch: java.lang.Throwable -> Ldc
            monitor-enter(r5)     // Catch: java.lang.Throwable -> Ldc
            android.widget.RemoteViewsAdapter$RemoteViewsMetaData r4 = android.widget.RemoteViewsAdapter.FixedSizeRemoteViewsCache.m1392$$Nest$fgetmMetaData(r4)     // Catch: java.lang.Throwable -> Lc7
            int r4 = r4.count     // Catch: java.lang.Throwable -> Lc7
            if (r4 <= 0) goto Lc5
            r4 = 1
            r6.mDataReady = r4     // Catch: java.lang.Throwable -> Lc7
        Lc5:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> Lc7
            goto Ld3
        Lc7:
            r4 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> Lc7
            throw r4     // Catch: java.lang.Throwable -> Ldc
        Lca:
            android.widget.RemoteViewsAdapter$FixedSizeRemoteViewsCache r4 = new android.widget.RemoteViewsAdapter$FixedSizeRemoteViewsCache     // Catch: java.lang.Throwable -> Ldc
            r5 = 40
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> Ldc
            r6.mCache = r4     // Catch: java.lang.Throwable -> Ldc
        Ld3:
            boolean r4 = r6.mDataReady     // Catch: java.lang.Throwable -> Ldc
            if (r4 != 0) goto Lda
            r6.requestBindService()     // Catch: java.lang.Throwable -> Ldc
        Lda:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ldc
            return
        Ldc:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ldc
            throw r2
        Ldf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Non-null Intent must be specified."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.RemoteViewsAdapter.<init>(android.content.Context, android.content.Intent, android.widget.RemoteViewsAdapter$RemoteAdapterConnectionCallback, boolean):void");
    }

    protected void finalize() throws Throwable {
        try {
            this.mServiceHandler.unbindNow();
            this.mWorkerThread.quit();
        } finally {
            super.finalize();
        }
    }

    public boolean isDataReady() {
        return this.mDataReady;
    }

    public void setRemoteViewsInteractionHandler(RemoteViews.InteractionHandler handler) {
        this.mRemoteViewsInteractionHandler = handler;
    }

    public void saveRemoteViewsCache() {
        int metaDataCount;
        int numRemoteViewsCached;
        final RemoteViewsCacheKey key = new RemoteViewsCacheKey(new Intent.FilterComparison(this.mIntent), this.mAppWidgetId);
        HashMap<RemoteViewsCacheKey, FixedSizeRemoteViewsCache> hashMap = sCachedRemoteViewsCaches;
        synchronized (hashMap) {
            HashMap<RemoteViewsCacheKey, Runnable> hashMap2 = sRemoteViewsCacheRemoveRunnables;
            if (hashMap2.containsKey(key)) {
                sCacheRemovalQueue.removeCallbacks(hashMap2.get(key));
                hashMap2.remove(key);
            }
            synchronized (this.mCache.mMetaData) {
                metaDataCount = this.mCache.mMetaData.count;
            }
            synchronized (this.mCache) {
                numRemoteViewsCached = this.mCache.mIndexRemoteViews.size();
            }
            if (metaDataCount > 0 && numRemoteViewsCached > 0) {
                hashMap.put(key, this.mCache);
            }
            Runnable r10 = new Runnable() { // from class: android.widget.RemoteViewsAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteViewsAdapter.lambda$saveRemoteViewsCache$0(RemoteViewsAdapter.RemoteViewsCacheKey.this);
                }
            };
            hashMap2.put(key, r10);
            sCacheRemovalQueue.postDelayed(r10, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$saveRemoteViewsCache$0(RemoteViewsCacheKey key) {
        HashMap<RemoteViewsCacheKey, FixedSizeRemoteViewsCache> hashMap = sCachedRemoteViewsCaches;
        synchronized (hashMap) {
            hashMap.remove(key);
            sRemoteViewsCacheRemoveRunnables.remove(key);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTemporaryMetaData(IRemoteViewsFactory factory) {
        RemoteViews firstView;
        try {
            boolean hasStableIds = factory.hasStableIds();
            int viewTypeCount = factory.getViewTypeCount();
            int count = factory.getCount();
            LoadingViewTemplate loadingTemplate = new LoadingViewTemplate(factory.getLoadingView(), this.mContext);
            if (count > 0 && loadingTemplate.remoteViews == null && (firstView = factory.getViewAt(0)) != null) {
                loadingTemplate.loadFirstViewHeight(firstView, this.mContext, new HandlerThreadExecutor(this.mWorkerThread));
            }
            RemoteViewsMetaData tmpMetaData = this.mCache.getTemporaryMetaData();
            synchronized (tmpMetaData) {
                tmpMetaData.hasStableIds = hasStableIds;
                tmpMetaData.viewTypeCount = viewTypeCount + 1;
                tmpMetaData.count = count;
                tmpMetaData.loadingTemplate = loadingTemplate;
            }
        } catch (RemoteException | RuntimeException e2) {
            Log.e(TAG, "Error in updateMetaData: " + e2.getMessage());
            synchronized (this.mCache.getMetaData()) {
                this.mCache.getMetaData().reset();
                synchronized (this.mCache) {
                    this.mCache.reset();
                    this.mMainHandler.sendEmptyMessage(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteViews(IRemoteViewsFactory factory, int position, boolean notifyWhenLoaded) {
        boolean viewTypeInRange;
        int cacheCount;
        try {
            RemoteViews remoteViews = factory.getViewAt(position);
            long itemId = factory.getItemId(position);
            if (remoteViews == null) {
                throw new RuntimeException("Null remoteViews");
            }
            if (remoteViews.mApplication != null) {
                ApplicationInfo applicationInfo = this.mLastRemoteViewAppInfo;
                if (applicationInfo != null && remoteViews.hasSameAppInfo(applicationInfo)) {
                    remoteViews.mApplication = this.mLastRemoteViewAppInfo;
                } else {
                    this.mLastRemoteViewAppInfo = remoteViews.mApplication;
                }
            }
            int layoutId = remoteViews.getLayoutId();
            RemoteViewsMetaData metaData = this.mCache.getMetaData();
            synchronized (metaData) {
                viewTypeInRange = metaData.isViewTypeInRange(layoutId);
                cacheCount = this.mCache.mMetaData.count;
            }
            synchronized (this.mCache) {
                if (viewTypeInRange) {
                    int[] visibleWindow = getVisibleWindow(cacheCount);
                    this.mCache.insert(position, remoteViews, itemId, visibleWindow);
                    if (notifyWhenLoaded) {
                        Message.obtain(this.mMainHandler, 5, position, 0, remoteViews).sendToTarget();
                    }
                } else {
                    Log.e(TAG, "Error: widget's RemoteViewsFactory returns more view types than  indicated by getViewTypeCount() ");
                }
            }
        } catch (RemoteException | RuntimeException e2) {
            Log.e(TAG, "Error in updateRemoteViews(" + position + "): " + e2.getMessage());
        }
    }

    public Intent getRemoteViewsServiceIntent() {
        return this.mIntent;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i10;
        RemoteViewsMetaData metaData = this.mCache.getMetaData();
        synchronized (metaData) {
            i10 = metaData.count;
        }
        return i10;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        synchronized (this.mCache) {
            if (!this.mCache.containsMetaDataAt(position)) {
                return 0L;
            }
            return this.mCache.getMetaDataAt(position).itemId;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        int mappedViewType;
        synchronized (this.mCache) {
            if (!this.mCache.containsMetaDataAt(position)) {
                return 0;
            }
            int typeId = this.mCache.getMetaDataAt(position).typeId;
            RemoteViewsMetaData metaData = this.mCache.getMetaData();
            synchronized (metaData) {
                mappedViewType = metaData.getMappedViewType(typeId);
            }
            return mappedViewType;
        }
    }

    public void setVisibleRangeHint(int lowerBound, int upperBound) {
        this.mVisibleWindowLowerBound = lowerBound;
        this.mVisibleWindowUpperBound = upperBound;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        RemoteViewsFrameLayout layout;
        synchronized (this.mCache) {
            RemoteViews rv = this.mCache.getRemoteViewsAt(position);
            boolean isInCache = rv != null;
            boolean hasNewItems = false;
            if (convertView != null && (convertView instanceof RemoteViewsFrameLayout)) {
                this.mRequestedViews.removeView((RemoteViewsFrameLayout) convertView);
            }
            if (!isInCache) {
                requestBindService();
            } else {
                hasNewItems = this.mCache.queuePositionsToBePreloadedFromRequestedPosition(position);
            }
            if (convertView instanceof RemoteViewsFrameLayout) {
                layout = (RemoteViewsFrameLayout) convertView;
            } else {
                layout = new RemoteViewsFrameLayout(parent.getContext(), this.mCache);
                layout.setExecutor(this.mAsyncViewLoadExecutor);
                layout.setOnLightBackground(this.mOnLightBackground);
            }
            if (isInCache) {
                layout.onRemoteViewsLoaded(rv, this.mRemoteViewsInteractionHandler, false);
                if (hasNewItems) {
                    this.mServiceHandler.sendEmptyMessage(3);
                }
            } else {
                layout.onRemoteViewsLoaded(this.mCache.getMetaData().getLoadingTemplate(this.mContext).remoteViews, this.mRemoteViewsInteractionHandler, false);
                this.mRequestedViews.add(position, layout);
                this.mCache.queueRequestedPositionToLoad(position);
                this.mServiceHandler.sendEmptyMessage(3);
            }
        }
        return layout;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        int i10;
        RemoteViewsMetaData metaData = this.mCache.getMetaData();
        synchronized (metaData) {
            i10 = metaData.viewTypeCount;
        }
        return i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        boolean z10;
        RemoteViewsMetaData metaData = this.mCache.getMetaData();
        synchronized (metaData) {
            z10 = metaData.hasStableIds;
        }
        return z10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return getCount() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getVisibleWindow(int count) {
        int[] window;
        int lower = this.mVisibleWindowLowerBound;
        int upper = this.mVisibleWindowUpperBound;
        if ((lower == 0 && upper == 0) || lower < 0 || upper < 0) {
            return new int[0];
        }
        if (lower <= upper) {
            window = new int[(upper + 1) - lower];
            int i10 = lower;
            int j10 = 0;
            while (i10 <= upper) {
                window[j10] = i10;
                i10++;
                j10++;
            }
        } else {
            int count2 = Math.max(count, lower);
            window = new int[(count2 - lower) + upper + 1];
            int j11 = 0;
            int i11 = 0;
            while (i11 <= upper) {
                window[j11] = i11;
                i11++;
                j11++;
            }
            int i12 = lower;
            while (i12 < count2) {
                window[j11] = i12;
                i12++;
                j11++;
            }
        }
        return window;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.mServiceHandler.removeMessages(4);
        this.mServiceHandler.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void superNotifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 1:
                this.mCache.commitTemporaryMetaData();
                return true;
            case 2:
                superNotifyDataSetChanged();
                return true;
            case 3:
                RemoteAdapterConnectionCallback remoteAdapterConnectionCallback = this.mCallback;
                if (remoteAdapterConnectionCallback != null) {
                    remoteAdapterConnectionCallback.onRemoteAdapterConnected();
                }
                return true;
            case 4:
                RemoteAdapterConnectionCallback remoteAdapterConnectionCallback2 = this.mCallback;
                if (remoteAdapterConnectionCallback2 != null) {
                    remoteAdapterConnectionCallback2.onRemoteAdapterDisconnected();
                }
                return true;
            case 5:
                this.mRequestedViews.notifyOnRemoteViewsLoaded(msg.arg1, (RemoteViews) msg.obj);
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestBindService() {
        this.mServiceHandler.removeMessages(4);
        Message.obtain(this.mServiceHandler, 1, this.mAppWidgetId, 0, this.mIntent).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class HandlerThreadExecutor implements Executor {
        private final HandlerThread mThread;

        HandlerThreadExecutor(HandlerThread thread) {
            this.mThread = thread;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (Thread.currentThread().getId() == this.mThread.getId()) {
                runnable.run();
            } else {
                new Handler(this.mThread.getLooper()).post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LoadingViewTemplate {
        public int defaultHeight;
        public final RemoteViews remoteViews;

        LoadingViewTemplate(RemoteViews views, Context context) {
            this.remoteViews = views;
            float density = context.getResources().getDisplayMetrics().density;
            this.defaultHeight = Math.round(50.0f * density);
        }

        public void loadFirstViewHeight(RemoteViews firstView, Context context, Executor executor) {
            firstView.applyAsync(context, new RemoteViewsFrameLayout(context, null), executor, new RemoteViews.OnViewAppliedListener() { // from class: android.widget.RemoteViewsAdapter.LoadingViewTemplate.1
                @Override // android.widget.RemoteViews.OnViewAppliedListener
                public void onViewApplied(View v2) {
                    try {
                        v2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        LoadingViewTemplate.this.defaultHeight = v2.getMeasuredHeight();
                    } catch (Exception e2) {
                        onError(e2);
                    }
                }

                @Override // android.widget.RemoteViews.OnViewAppliedListener
                public void onError(Exception e2) {
                    Log.w(RemoteViewsAdapter.TAG, "Error inflating first RemoteViews", e2);
                }
            });
        }
    }
}
