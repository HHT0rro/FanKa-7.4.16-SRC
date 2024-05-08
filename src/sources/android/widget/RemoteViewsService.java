package android.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.android.internal.widget.IRemoteViewsFactory;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class RemoteViewsService extends Service {
    private static final String LOG_TAG = "RemoteViewsService";
    private static final HashMap<Intent.FilterComparison, RemoteViewsFactory> sRemoteViewFactories = new HashMap<>();
    private static final Object sLock = new Object();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface RemoteViewsFactory {
        int getCount();

        long getItemId(int i10);

        RemoteViews getLoadingView();

        RemoteViews getViewAt(int i10);

        int getViewTypeCount();

        boolean hasStableIds();

        void onCreate();

        void onDataSetChanged();

        void onDestroy();
    }

    public abstract RemoteViewsFactory onGetViewFactory(Intent intent);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class RemoteViewsFactoryAdapter extends IRemoteViewsFactory.Stub {
        private RemoteViewsFactory mFactory;
        private boolean mIsCreated;

        public RemoteViewsFactoryAdapter(RemoteViewsFactory factory, boolean isCreated) {
            this.mFactory = factory;
            this.mIsCreated = isCreated;
        }

        public synchronized boolean isCreated() {
            return this.mIsCreated;
        }

        public synchronized void onDataSetChanged() {
            try {
                this.mFactory.onDataSetChanged();
            } catch (Exception ex) {
                Thread t2 = Thread.currentThread();
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t2, ex);
            }
        }

        public synchronized void onDataSetChangedAsync() {
            onDataSetChanged();
        }

        public synchronized int getCount() {
            int count;
            count = 0;
            try {
                count = this.mFactory.getCount();
            } catch (Exception ex) {
                Thread t2 = Thread.currentThread();
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t2, ex);
            }
            return count;
        }

        public synchronized RemoteViews getViewAt(int position) {
            RemoteViews rv;
            rv = null;
            try {
                rv = this.mFactory.getViewAt(position);
                if (rv != null) {
                    rv.addFlags(2);
                }
            } catch (Exception ex) {
                Thread t2 = Thread.currentThread();
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t2, ex);
            }
            return rv;
        }

        public synchronized RemoteViews getLoadingView() {
            RemoteViews rv;
            rv = null;
            try {
                rv = this.mFactory.getLoadingView();
            } catch (Exception ex) {
                Thread t2 = Thread.currentThread();
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t2, ex);
            }
            return rv;
        }

        public synchronized int getViewTypeCount() {
            int count;
            count = 0;
            try {
                count = this.mFactory.getViewTypeCount();
            } catch (Exception ex) {
                Thread t2 = Thread.currentThread();
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t2, ex);
            }
            return count;
        }

        public synchronized long getItemId(int position) {
            long id2;
            id2 = 0;
            try {
                id2 = this.mFactory.getItemId(position);
            } catch (Exception ex) {
                Thread t2 = Thread.currentThread();
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t2, ex);
            }
            return id2;
        }

        public synchronized boolean hasStableIds() {
            boolean hasStableIds;
            hasStableIds = false;
            try {
                hasStableIds = this.mFactory.hasStableIds();
            } catch (Exception ex) {
                Thread t2 = Thread.currentThread();
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t2, ex);
            }
            return hasStableIds;
        }

        public void onDestroy(Intent intent) {
            synchronized (RemoteViewsService.sLock) {
                Intent.FilterComparison fc2 = new Intent.FilterComparison(intent);
                if (RemoteViewsService.sRemoteViewFactories.containsKey(fc2)) {
                    RemoteViewsFactory factory = (RemoteViewsFactory) RemoteViewsService.sRemoteViewFactories.get(fc2);
                    try {
                        factory.onDestroy();
                    } catch (Exception ex) {
                        Thread t2 = Thread.currentThread();
                        Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t2, ex);
                    }
                    RemoteViewsService.sRemoteViewFactories.remove(fc2);
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        RemoteViewsFactory factory;
        boolean isCreated;
        IRemoteViewsFactory.Stub remoteViewsFactoryAdapter;
        synchronized (sLock) {
            Intent.FilterComparison fc2 = new Intent.FilterComparison(intent);
            HashMap<Intent.FilterComparison, RemoteViewsFactory> hashMap = sRemoteViewFactories;
            if (!hashMap.containsKey(fc2)) {
                factory = onGetViewFactory(intent);
                hashMap.put(fc2, factory);
                factory.onCreate();
                isCreated = false;
            } else {
                factory = hashMap.get(fc2);
                isCreated = true;
            }
            remoteViewsFactoryAdapter = new RemoteViewsFactoryAdapter(factory, isCreated);
        }
        return remoteViewsFactoryAdapter;
    }
}
