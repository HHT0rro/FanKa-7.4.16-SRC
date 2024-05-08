package android.view.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.IAccessibilityServiceConnection;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.view.SurfaceControl;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityCache;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.window.ScreenCapture;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class AccessibilityInteractionClient extends IAccessibilityInteractionConnectionCallback.Stub {
    public static final String CALL_STACK = "call_stack";
    private static final boolean CHECK_INTEGRITY = true;
    private static final boolean DEBUG = false;
    public static final String IGNORE_CALL_STACK = "ignore_call_stack";
    private static final String LOG_TAG = "AccessibilityInteractionClient";
    public static final int NO_ID = -1;
    private static final long TIMEOUT_INTERACTION_MILLIS = 5000;
    private final AccessibilityManager mAccessibilityManager;
    private List<StackTraceElement> mCallStackOfCallback;
    private volatile int mCallingUid;
    private int mConnectionIdWaitingForPrefetchResult;
    private AccessibilityNodeInfo mFindAccessibilityNodeInfoResult;
    private List<AccessibilityNodeInfo> mFindAccessibilityNodeInfosResult;
    private final Object mInstanceLock;
    private volatile int mInteractionId;
    private final AtomicInteger mInteractionIdCounter;
    private int mInteractionIdWaitingForPrefetchResult;
    private String[] mPackageNamesForNextPrefetchResult;
    private boolean mPerformAccessibilityActionResult;
    private Message mSameThreadMessage;
    private final SparseArray<Pair<Executor, AccessibilityService.TakeScreenshotCallback>> mTakeScreenshotOfWindowCallbacks;
    private static final long DISABLE_PREFETCHING_FOR_SCROLLING_MILLIS = (long) (ViewConfiguration.getSendRecurringAccessibilityEventsInterval() * 1.5d);
    private static final Object sStaticLock = new Object();
    private static final LongSparseArray<AccessibilityInteractionClient> sClients = new LongSparseArray<>();
    private static final SparseArray<IAccessibilityServiceConnection> sConnectionCache = new SparseArray<>();
    private static int sDirectConnectionIdCounter = 1073741824;
    private static int sDirectConnectionCount = 0;
    private static final SparseLongArray sScrollingWindows = new SparseLongArray();
    private static SparseArray<AccessibilityCache> sCaches = new SparseArray<>();

    public static AccessibilityInteractionClient getInstance() {
        long threadId = Thread.currentThread().getId();
        return getInstanceForThread(threadId);
    }

    public static AccessibilityInteractionClient getInstanceForThread(long threadId) {
        AccessibilityInteractionClient client;
        synchronized (sStaticLock) {
            LongSparseArray<AccessibilityInteractionClient> longSparseArray = sClients;
            client = longSparseArray.get(threadId);
            if (client == null) {
                client = new AccessibilityInteractionClient();
                longSparseArray.put(threadId, client);
            }
        }
        return client;
    }

    public static AccessibilityInteractionClient getInstance(Context context) {
        long threadId = Thread.currentThread().getId();
        if (context != null) {
            return getInstanceForThread(threadId, context);
        }
        return getInstanceForThread(threadId);
    }

    public static AccessibilityInteractionClient getInstanceForThread(long threadId, Context context) {
        AccessibilityInteractionClient client;
        synchronized (sStaticLock) {
            LongSparseArray<AccessibilityInteractionClient> longSparseArray = sClients;
            client = longSparseArray.get(threadId);
            if (client == null) {
                client = new AccessibilityInteractionClient(context);
                longSparseArray.put(threadId, client);
            }
        }
        return client;
    }

    public static IAccessibilityServiceConnection getConnection(int connectionId) {
        IAccessibilityServiceConnection iAccessibilityServiceConnection;
        SparseArray<IAccessibilityServiceConnection> sparseArray = sConnectionCache;
        synchronized (sparseArray) {
            iAccessibilityServiceConnection = sparseArray.get(connectionId);
        }
        return iAccessibilityServiceConnection;
    }

    public static void addConnection(int connectionId, IAccessibilityServiceConnection connection, boolean initializeCache) {
        if (connectionId == -1) {
            return;
        }
        SparseArray<IAccessibilityServiceConnection> sparseArray = sConnectionCache;
        synchronized (sparseArray) {
            IAccessibilityServiceConnection existingConnection = getConnection(connectionId);
            if (existingConnection instanceof DirectAccessibilityConnection) {
                throw new IllegalArgumentException("Cannot add service connection with id " + connectionId + " which conflicts with existing direct connection.");
            }
            sparseArray.put(connectionId, connection);
            if (initializeCache) {
                sCaches.put(connectionId, new AccessibilityCache(new AccessibilityCache.AccessibilityNodeRefresher()));
            }
        }
    }

    public static int addDirectConnection(IAccessibilityInteractionConnection connection, AccessibilityManager accessibilityManager) {
        int connectionId;
        SparseArray<IAccessibilityServiceConnection> sparseArray = sConnectionCache;
        synchronized (sparseArray) {
            connectionId = sDirectConnectionIdCounter;
            sDirectConnectionIdCounter = connectionId + 1;
            if (getConnection(connectionId) != null) {
                throw new IllegalArgumentException("Cannot add direct connection with existing id " + connectionId);
            }
            DirectAccessibilityConnection directAccessibilityConnection = new DirectAccessibilityConnection(connection, accessibilityManager);
            sparseArray.put(connectionId, directAccessibilityConnection);
            sDirectConnectionCount++;
        }
        return connectionId;
    }

    public static boolean hasAnyDirectConnection() {
        return sDirectConnectionCount > 0;
    }

    public static AccessibilityCache getCache(int connectionId) {
        AccessibilityCache accessibilityCache;
        synchronized (sConnectionCache) {
            accessibilityCache = sCaches.get(connectionId);
        }
        return accessibilityCache;
    }

    public static void removeConnection(int connectionId) {
        SparseArray<IAccessibilityServiceConnection> sparseArray = sConnectionCache;
        synchronized (sparseArray) {
            if (getConnection(connectionId) instanceof DirectAccessibilityConnection) {
                sDirectConnectionCount--;
            }
            sparseArray.remove(connectionId);
            sCaches.remove(connectionId);
        }
    }

    public static void setCache(int connectionId, AccessibilityCache cache) {
        synchronized (sConnectionCache) {
            sCaches.put(connectionId, cache);
        }
    }

    private AccessibilityInteractionClient() {
        this.mInteractionIdCounter = new AtomicInteger();
        this.mInstanceLock = new Object();
        this.mInteractionId = -1;
        this.mCallingUid = -1;
        this.mTakeScreenshotOfWindowCallbacks = new SparseArray<>();
        this.mInteractionIdWaitingForPrefetchResult = -1;
        this.mAccessibilityManager = null;
    }

    private AccessibilityInteractionClient(Context context) {
        this.mInteractionIdCounter = new AtomicInteger();
        this.mInstanceLock = new Object();
        this.mInteractionId = -1;
        this.mCallingUid = -1;
        this.mTakeScreenshotOfWindowCallbacks = new SparseArray<>();
        this.mInteractionIdWaitingForPrefetchResult = -1;
        this.mAccessibilityManager = (AccessibilityManager) context.getSystemService(AccessibilityManager.class);
    }

    public void setSameThreadMessage(Message message) {
        synchronized (this.mInstanceLock) {
            this.mSameThreadMessage = message;
            this.mInstanceLock.notifyAll();
        }
    }

    public AccessibilityNodeInfo getRootInActiveWindow(int connectionId, int strategy) {
        return findAccessibilityNodeInfoByAccessibilityId(connectionId, Integer.MAX_VALUE, AccessibilityNodeInfo.ROOT_NODE_ID, false, strategy, (Bundle) null);
    }

    public AccessibilityWindowInfo getWindow(int connectionId, int accessibilityWindowId) {
        return getWindow(connectionId, accessibilityWindowId, false);
    }

    public AccessibilityWindowInfo getWindow(int connectionId, int accessibilityWindowId, boolean bypassCache) {
        AccessibilityWindowInfo window;
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                AccessibilityCache cache = getCache(connectionId);
                if (cache != null && !bypassCache && (window = cache.getWindow(accessibilityWindowId)) != null) {
                    if (shouldTraceClient()) {
                        logTraceClient(connection, "getWindow cache", "connectionId=" + connectionId + ";accessibilityWindowId=" + accessibilityWindowId + ";bypassCache=false");
                    }
                    return window;
                }
                long identityToken = Binder.clearCallingIdentity();
                try {
                    AccessibilityWindowInfo window2 = connection.getWindow(accessibilityWindowId);
                    Binder.restoreCallingIdentity(identityToken);
                    if (shouldTraceClient()) {
                        logTraceClient(connection, "getWindow", "connectionId=" + connectionId + ";accessibilityWindowId=" + accessibilityWindowId + ";bypassCache=" + bypassCache);
                    }
                    if (window2 != null) {
                        if (!bypassCache && cache != null) {
                            cache.addWindow(window2);
                        }
                        return window2;
                    }
                    return null;
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(identityToken);
                    throw th;
                }
            }
            return null;
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error while calling remote getWindow", re);
            return null;
        }
    }

    public List<AccessibilityWindowInfo> getWindows(int connectionId) {
        return getWindowsOnDisplay(connectionId, 0);
    }

    public List<AccessibilityWindowInfo> getWindowsOnDisplay(int connectionId, int displayId) {
        SparseArray<List<AccessibilityWindowInfo>> windows = getWindowsOnAllDisplays(connectionId);
        return windows.get(displayId, Collections.emptyList());
    }

    public SparseArray<List<AccessibilityWindowInfo>> getWindowsOnAllDisplays(int connectionId) {
        SparseArray<List<AccessibilityWindowInfo>> windows;
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                AccessibilityCache cache = getCache(connectionId);
                if (cache != null && (windows = cache.getWindowsOnAllDisplays()) != null) {
                    if (shouldTraceClient()) {
                        logTraceClient(connection, "getWindows cache", "connectionId=" + connectionId);
                    }
                    return windows;
                }
                long identityToken = Binder.clearCallingIdentity();
                try {
                    long populationTimeStamp = SystemClock.uptimeMillis();
                    SparseArray<List<AccessibilityWindowInfo>> windows2 = connection.getWindows();
                    Binder.restoreCallingIdentity(identityToken);
                    if (shouldTraceClient()) {
                        logTraceClient(connection, "getWindows", "connectionId=" + connectionId);
                    }
                    if (windows2 != null) {
                        if (cache != null) {
                            cache.setWindowsOnAllDisplays(windows2, populationTimeStamp);
                        }
                        return windows2;
                    }
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(identityToken);
                    throw th;
                }
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error while calling remote getWindowsOnAllDisplays", re);
        }
        SparseArray<List<AccessibilityWindowInfo>> emptyWindows = new SparseArray<>();
        return emptyWindows;
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int connectionId, IBinder leashToken, long accessibilityNodeId, boolean bypassCache, int prefetchFlags, Bundle arguments) {
        if (leashToken == null) {
            return null;
        }
        int windowId = -1;
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                windowId = connection.getWindowIdForLeashToken(leashToken);
            }
        } catch (RemoteException re) {
            Log.e(LOG_TAG, "Error while calling remote getWindowIdForLeashToken", re);
        }
        if (windowId == -1) {
            return null;
        }
        return findAccessibilityNodeInfoByAccessibilityId(connectionId, windowId, accessibilityNodeId, bypassCache, prefetchFlags, arguments);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x01f7 A[Catch: RemoteException -> 0x0203, TryCatch #1 {RemoteException -> 0x0203, blocks: (B:35:0x014e, B:40:0x015f, B:42:0x0169, B:43:0x018d, B:45:0x0192, B:47:0x0198, B:52:0x01a1, B:54:0x01ad, B:55:0x01d1, B:58:0x01d7, B:59:0x01da, B:65:0x01ed, B:66:0x01f1, B:15:0x01f7, B:16:0x0202), top: B:13:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.accessibility.AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int r24, int r25, long r26, boolean r28, int r29, android.os.Bundle r30) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.accessibility.AccessibilityInteractionClient.findAccessibilityNodeInfoByAccessibilityId(int, int, long, boolean, int, android.os.Bundle):android.view.accessibility.AccessibilityNodeInfo");
    }

    private void setInteractionWaitingForPrefetchResult(int interactionId, int connectionId, String[] packageNames) {
        synchronized (this.mInstanceLock) {
            this.mInteractionIdWaitingForPrefetchResult = interactionId;
            this.mConnectionIdWaitingForPrefetchResult = connectionId;
            this.mPackageNamesForNextPrefetchResult = packageNames;
        }
    }

    private static String idToString(int accessibilityWindowId, long accessibilityNodeId) {
        return accessibilityWindowId + "/" + AccessibilityNodeInfo.idToString(accessibilityNodeId);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId(int connectionId, int accessibilityWindowId, long accessibilityNodeId, String viewId) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                int interactionId = this.mInteractionIdCounter.getAndIncrement();
                long identityToken = Binder.clearCallingIdentity();
                try {
                    if (shouldTraceClient()) {
                        try {
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                        } catch (Throwable th2) {
                            th = th2;
                            Binder.restoreCallingIdentity(identityToken);
                            throw th;
                        }
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            Binder.restoreCallingIdentity(identityToken);
                            throw th;
                        }
                        try {
                            logTraceClient(connection, "findAccessibilityNodeInfosByViewId", "InteractionId=" + interactionId + ";connectionId=" + connectionId + ";accessibilityWindowId=" + accessibilityWindowId + ";accessibilityNodeId=" + accessibilityNodeId + ";viewId=" + viewId);
                        } catch (Throwable th4) {
                            th = th4;
                            Binder.restoreCallingIdentity(identityToken);
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    String[] packageNames = connection.findAccessibilityNodeInfosByViewId(accessibilityWindowId, accessibilityNodeId, viewId, interactionId, this, Thread.currentThread().getId());
                    Binder.restoreCallingIdentity(identityToken);
                    if (packageNames != null) {
                        List<AccessibilityNodeInfo> infos = getFindAccessibilityNodeInfosResultAndClear(interactionId);
                        if (shouldTraceCallback()) {
                            logTraceCallback(connection, "findAccessibilityNodeInfosByViewId", "InteractionId=" + interactionId + ";connectionId=" + connectionId + ":Result: " + ((Object) infos));
                        }
                        if (infos != null) {
                            finalizeAndCacheAccessibilityNodeInfos(infos, connectionId, false, packageNames);
                            return infos;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    Binder.restoreCallingIdentity(identityToken);
                    throw th;
                }
            }
        } catch (RemoteException re) {
            Log.w(LOG_TAG, "Error while calling remote findAccessibilityNodeInfoByViewIdInActiveWindow", re);
        }
        return Collections.emptyList();
    }

    public void takeScreenshotOfWindow(int connectionId, int accessibilityWindowId, Executor executor, final AccessibilityService.TakeScreenshotCallback callback) {
        IAccessibilityServiceConnection connection;
        synchronized (this.mInstanceLock) {
            try {
                connection = getConnection(connectionId);
            } catch (RemoteException e2) {
                executor.execute(new Runnable() { // from class: android.view.accessibility.AccessibilityInteractionClient$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.onFailure(1);
                    }
                });
            }
            if (connection == null) {
                executor.execute(new Runnable() { // from class: android.view.accessibility.AccessibilityInteractionClient$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.onFailure(1);
                    }
                });
                return;
            }
            long identityToken = Binder.clearCallingIdentity();
            try {
                final int interactionId = this.mInteractionIdCounter.getAndIncrement();
                this.mTakeScreenshotOfWindowCallbacks.put(interactionId, Pair.create(executor, callback));
                ScreenCapture.ScreenCaptureListener listener = new ScreenCapture.ScreenCaptureListener((Consumer<ScreenCapture.ScreenshotHardwareBuffer>) new Consumer() { // from class: android.view.accessibility.AccessibilityInteractionClient$$ExternalSyntheticLambda1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        AccessibilityInteractionClient.this.lambda$takeScreenshotOfWindow$1(interactionId, (ScreenCapture.ScreenshotHardwareBuffer) obj);
                    }
                });
                connection.takeScreenshotOfWindow(accessibilityWindowId, interactionId, listener, this);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: android.view.accessibility.AccessibilityInteractionClient$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccessibilityInteractionClient.this.lambda$takeScreenshotOfWindow$2(interactionId);
                    }
                }, 5000L);
                Binder.restoreCallingIdentity(identityToken);
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(identityToken);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$takeScreenshotOfWindow$2(int interactionId) {
        synchronized (this.mInstanceLock) {
            if (this.mTakeScreenshotOfWindowCallbacks.contains(interactionId)) {
                sendTakeScreenshotOfWindowError(1, interactionId);
            }
        }
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(int connectionId, int accessibilityWindowId, long accessibilityNodeId, String text) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                int interactionId = this.mInteractionIdCounter.getAndIncrement();
                if (shouldTraceClient()) {
                    try {
                    } catch (RemoteException e2) {
                        re = e2;
                    }
                    try {
                        try {
                            try {
                                logTraceClient(connection, "findAccessibilityNodeInfosByText", "InteractionId:" + interactionId + "connectionId=" + connectionId + ";accessibilityWindowId=" + accessibilityWindowId + ";accessibilityNodeId=" + accessibilityNodeId + ";text=" + text);
                            } catch (RemoteException e10) {
                                re = e10;
                                Log.w(LOG_TAG, "Error while calling remote findAccessibilityNodeInfosByViewText", re);
                                return Collections.emptyList();
                            }
                        } catch (RemoteException e11) {
                            re = e11;
                            Log.w(LOG_TAG, "Error while calling remote findAccessibilityNodeInfosByViewText", re);
                            return Collections.emptyList();
                        }
                    } catch (RemoteException e12) {
                        re = e12;
                        Log.w(LOG_TAG, "Error while calling remote findAccessibilityNodeInfosByViewText", re);
                        return Collections.emptyList();
                    }
                }
                long identityToken = Binder.clearCallingIdentity();
                try {
                    String[] packageNames = connection.findAccessibilityNodeInfosByText(accessibilityWindowId, accessibilityNodeId, text, interactionId, this, Thread.currentThread().getId());
                    if (packageNames != null) {
                        List<AccessibilityNodeInfo> infos = getFindAccessibilityNodeInfosResultAndClear(interactionId);
                        if (shouldTraceCallback()) {
                            logTraceCallback(connection, "findAccessibilityNodeInfosByText", "InteractionId=" + interactionId + ";connectionId=" + connectionId + ";Result: " + ((Object) infos));
                        }
                        if (infos != null) {
                            finalizeAndCacheAccessibilityNodeInfos(infos, connectionId, false, packageNames);
                            return infos;
                        }
                    }
                } finally {
                    Binder.restoreCallingIdentity(identityToken);
                }
            }
        } catch (RemoteException e13) {
            re = e13;
        }
        return Collections.emptyList();
    }

    public AccessibilityNodeInfo findFocus(int connectionId, int accessibilityWindowId, long accessibilityNodeId, int focusType) {
        AccessibilityNodeInfo cachedInfo;
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                AccessibilityCache cache = getCache(connectionId);
                if (cache != null && (cachedInfo = cache.getFocus(focusType, accessibilityNodeId, accessibilityWindowId)) != null) {
                    return cachedInfo;
                }
                int interactionId = this.mInteractionIdCounter.getAndIncrement();
                if (shouldTraceClient()) {
                    logTraceClient(connection, "findFocus", "InteractionId:" + interactionId + "connectionId=" + connectionId + ";accessibilityWindowId=" + accessibilityWindowId + ";accessibilityNodeId=" + accessibilityNodeId + ";focusType=" + focusType);
                }
                long identityToken = Binder.clearCallingIdentity();
                try {
                    try {
                        String[] packageNames = connection.findFocus(accessibilityWindowId, accessibilityNodeId, focusType, interactionId, this, Thread.currentThread().getId());
                        Binder.restoreCallingIdentity(identityToken);
                        if (packageNames != null) {
                            AccessibilityNodeInfo info = getFindAccessibilityNodeInfoResultAndClear(interactionId);
                            if (shouldTraceCallback()) {
                                logTraceCallback(connection, "findFocus", "InteractionId=" + interactionId + ";connectionId=" + connectionId + ";Result:" + ((Object) info));
                            }
                            finalizeAndCacheAccessibilityNodeInfo(info, connectionId, false, packageNames);
                            return info;
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        Binder.restoreCallingIdentity(identityToken);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                return null;
            }
        } catch (RemoteException re) {
            Log.w(LOG_TAG, "Error while calling remote findFocus", re);
            return null;
        }
    }

    public AccessibilityNodeInfo focusSearch(int connectionId, int accessibilityWindowId, long accessibilityNodeId, int direction) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                int interactionId = this.mInteractionIdCounter.getAndIncrement();
                if (shouldTraceClient()) {
                    try {
                    } catch (RemoteException e2) {
                        re = e2;
                    }
                    try {
                        try {
                            try {
                                logTraceClient(connection, "focusSearch", "InteractionId:" + interactionId + "connectionId=" + connectionId + ";accessibilityWindowId=" + accessibilityWindowId + ";accessibilityNodeId=" + accessibilityNodeId + ";direction=" + direction);
                            } catch (RemoteException e10) {
                                re = e10;
                                Log.w(LOG_TAG, "Error while calling remote accessibilityFocusSearch", re);
                                return null;
                            }
                        } catch (RemoteException e11) {
                            re = e11;
                            Log.w(LOG_TAG, "Error while calling remote accessibilityFocusSearch", re);
                            return null;
                        }
                    } catch (RemoteException e12) {
                        re = e12;
                        Log.w(LOG_TAG, "Error while calling remote accessibilityFocusSearch", re);
                        return null;
                    }
                }
                long identityToken = Binder.clearCallingIdentity();
                try {
                    String[] packageNames = connection.focusSearch(accessibilityWindowId, accessibilityNodeId, direction, interactionId, this, Thread.currentThread().getId());
                    if (packageNames != null) {
                        AccessibilityNodeInfo info = getFindAccessibilityNodeInfoResultAndClear(interactionId);
                        finalizeAndCacheAccessibilityNodeInfo(info, connectionId, false, packageNames);
                        if (shouldTraceCallback()) {
                            logTraceCallback(connection, "focusSearch", "InteractionId=" + interactionId + ";connectionId=" + connectionId + ";Result:" + ((Object) info));
                        }
                        return info;
                    }
                    return null;
                } finally {
                    Binder.restoreCallingIdentity(identityToken);
                }
            }
            return null;
        } catch (RemoteException e13) {
            re = e13;
        }
    }

    public boolean performAccessibilityAction(int connectionId, int accessibilityWindowId, long accessibilityNodeId, int action, Bundle arguments) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                int interactionId = this.mInteractionIdCounter.getAndIncrement();
                if (shouldTraceClient()) {
                    try {
                    } catch (RemoteException e2) {
                        re = e2;
                    }
                    try {
                        try {
                        } catch (RemoteException e10) {
                            re = e10;
                            Log.w(LOG_TAG, "Error while calling remote performAccessibilityAction", re);
                            return false;
                        }
                        try {
                            logTraceClient(connection, "performAccessibilityAction", "InteractionId:" + interactionId + "connectionId=" + connectionId + ";accessibilityWindowId=" + accessibilityWindowId + ";accessibilityNodeId=" + accessibilityNodeId + ";action=" + action + ";arguments=" + ((Object) arguments));
                        } catch (RemoteException e11) {
                            re = e11;
                            Log.w(LOG_TAG, "Error while calling remote performAccessibilityAction", re);
                            return false;
                        }
                    } catch (RemoteException e12) {
                        re = e12;
                        Log.w(LOG_TAG, "Error while calling remote performAccessibilityAction", re);
                        return false;
                    }
                }
                long identityToken = Binder.clearCallingIdentity();
                try {
                    boolean success = connection.performAccessibilityAction(accessibilityWindowId, accessibilityNodeId, action, arguments, interactionId, this, Thread.currentThread().getId());
                    if (success) {
                        boolean result = getPerformAccessibilityActionResultAndClear(interactionId);
                        if (shouldTraceCallback()) {
                            logTraceCallback(connection, "performAccessibilityAction", "InteractionId=" + interactionId + ";connectionId=" + connectionId + ";Result: " + result);
                        }
                        return result;
                    }
                    return false;
                } finally {
                    Binder.restoreCallingIdentity(identityToken);
                }
            }
            return false;
        } catch (RemoteException e13) {
            re = e13;
            Log.w(LOG_TAG, "Error while calling remote performAccessibilityAction", re);
            return false;
        }
    }

    public void clearCache(int connectionId) {
        AccessibilityCache cache = getCache(connectionId);
        if (cache == null) {
            return;
        }
        cache.clear();
    }

    public void onAccessibilityEvent(AccessibilityEvent event, int connectionId) {
        switch (event.getEventType()) {
            case 4096:
                updateScrollingWindow(event.getWindowId(), SystemClock.uptimeMillis());
                break;
            case 4194304:
                if (event.getWindowChanges() == 2) {
                    deleteScrollingWindow(event.getWindowId());
                    break;
                }
                break;
        }
        AccessibilityCache cache = getCache(connectionId);
        if (cache == null) {
            return;
        }
        cache.onAccessibilityEvent(event);
    }

    private AccessibilityNodeInfo getFindAccessibilityNodeInfoResultAndClear(int interactionId) {
        AccessibilityNodeInfo result;
        synchronized (this.mInstanceLock) {
            boolean success = waitForResultTimedLocked(interactionId);
            result = success ? this.mFindAccessibilityNodeInfoResult : null;
            clearResultLocked();
        }
        return result;
    }

    @Override // android.view.accessibility.IAccessibilityInteractionConnectionCallback
    public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo info, int interactionId) {
        synchronized (this.mInstanceLock) {
            if (interactionId > this.mInteractionId) {
                this.mFindAccessibilityNodeInfoResult = info;
                this.mInteractionId = interactionId;
                this.mCallingUid = Binder.getCallingUid();
                this.mCallStackOfCallback = new ArrayList(Arrays.asList(Thread.currentThread().getStackTrace()));
            }
            this.mInstanceLock.notifyAll();
        }
    }

    private List<AccessibilityNodeInfo> getFindAccessibilityNodeInfosResultAndClear(int interactionId) {
        List<AccessibilityNodeInfo> result;
        synchronized (this.mInstanceLock) {
            boolean success = waitForResultTimedLocked(interactionId);
            if (success) {
                result = this.mFindAccessibilityNodeInfosResult;
            } else {
                result = Collections.emptyList();
            }
            clearResultLocked();
            if (Build.IS_DEBUGGABLE) {
                checkFindAccessibilityNodeInfoResultIntegrity(result);
            }
        }
        return result;
    }

    @Override // android.view.accessibility.IAccessibilityInteractionConnectionCallback
    public void setFindAccessibilityNodeInfosResult(List<AccessibilityNodeInfo> infos, int interactionId) {
        synchronized (this.mInstanceLock) {
            if (interactionId > this.mInteractionId) {
                if (infos != null) {
                    boolean isIpcCall = Binder.getCallingPid() != Process.myPid();
                    if (!isIpcCall) {
                        this.mFindAccessibilityNodeInfosResult = new ArrayList(infos);
                    } else {
                        this.mFindAccessibilityNodeInfosResult = infos;
                    }
                } else {
                    this.mFindAccessibilityNodeInfosResult = Collections.emptyList();
                }
                this.mInteractionId = interactionId;
                this.mCallingUid = Binder.getCallingUid();
                this.mCallStackOfCallback = new ArrayList(Arrays.asList(Thread.currentThread().getStackTrace()));
            }
            this.mInstanceLock.notifyAll();
        }
    }

    @Override // android.view.accessibility.IAccessibilityInteractionConnectionCallback
    public void setPrefetchAccessibilityNodeInfoResult(List<AccessibilityNodeInfo> infos, int interactionId) {
        int interactionIdWaitingForPrefetchResultCopy = -1;
        int connectionIdWaitingForPrefetchResultCopy = -1;
        String[] packageNamesForNextPrefetchResultCopy = null;
        if (infos.isEmpty()) {
            return;
        }
        synchronized (this.mInstanceLock) {
            int i10 = this.mInteractionIdWaitingForPrefetchResult;
            if (i10 == interactionId) {
                interactionIdWaitingForPrefetchResultCopy = i10;
                connectionIdWaitingForPrefetchResultCopy = this.mConnectionIdWaitingForPrefetchResult;
                String[] strArr = this.mPackageNamesForNextPrefetchResult;
                if (strArr != null) {
                    packageNamesForNextPrefetchResultCopy = new String[strArr.length];
                    int i11 = 0;
                    while (true) {
                        String[] strArr2 = this.mPackageNamesForNextPrefetchResult;
                        if (i11 >= strArr2.length) {
                            break;
                        }
                        packageNamesForNextPrefetchResultCopy[i11] = strArr2[i11];
                        i11++;
                    }
                }
            }
        }
        if (interactionIdWaitingForPrefetchResultCopy == interactionId) {
            finalizeAndCacheAccessibilityNodeInfos(infos, connectionIdWaitingForPrefetchResultCopy, false, packageNamesForNextPrefetchResultCopy);
            if (shouldTraceCallback()) {
                logTrace(getConnection(connectionIdWaitingForPrefetchResultCopy), "setPrefetchAccessibilityNodeInfoResult", "InteractionId:" + interactionId + ";connectionId=" + connectionIdWaitingForPrefetchResultCopy + ";Result: " + ((Object) infos), Binder.getCallingUid(), Arrays.asList(Thread.currentThread().getStackTrace()), new HashSet<>(Collections.singletonList("getStackTrace")), 32L);
            }
        }
    }

    private boolean getPerformAccessibilityActionResultAndClear(int interactionId) {
        boolean result;
        synchronized (this.mInstanceLock) {
            boolean success = waitForResultTimedLocked(interactionId);
            result = success ? this.mPerformAccessibilityActionResult : false;
            clearResultLocked();
        }
        return result;
    }

    @Override // android.view.accessibility.IAccessibilityInteractionConnectionCallback
    public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) {
        synchronized (this.mInstanceLock) {
            if (interactionId > this.mInteractionId) {
                this.mPerformAccessibilityActionResult = succeeded;
                this.mInteractionId = interactionId;
                this.mCallingUid = Binder.getCallingUid();
                this.mCallStackOfCallback = new ArrayList(Arrays.asList(Thread.currentThread().getStackTrace()));
            }
            this.mInstanceLock.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendWindowScreenshotSuccess, reason: merged with bridge method [inline-methods] */
    public void lambda$takeScreenshotOfWindow$1(ScreenCapture.ScreenshotHardwareBuffer screenshot, int interactionId) {
        if (screenshot == null) {
            sendTakeScreenshotOfWindowError(1, interactionId);
            return;
        }
        synchronized (this.mInstanceLock) {
            if (this.mTakeScreenshotOfWindowCallbacks.contains(interactionId)) {
                final AccessibilityService.ScreenshotResult result = new AccessibilityService.ScreenshotResult(screenshot.getHardwareBuffer(), screenshot.getColorSpace(), SystemClock.uptimeMillis());
                Pair<Executor, AccessibilityService.TakeScreenshotCallback> pair = this.mTakeScreenshotOfWindowCallbacks.get(interactionId);
                Executor executor = (Executor) pair.first;
                final AccessibilityService.TakeScreenshotCallback callback = (AccessibilityService.TakeScreenshotCallback) pair.second;
                executor.execute(new Runnable() { // from class: android.view.accessibility.AccessibilityInteractionClient$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.onSuccess(result);
                    }
                });
                this.mTakeScreenshotOfWindowCallbacks.remove(interactionId);
            }
        }
    }

    @Override // android.view.accessibility.IAccessibilityInteractionConnectionCallback
    public void sendTakeScreenshotOfWindowError(final int errorCode, int interactionId) {
        synchronized (this.mInstanceLock) {
            if (this.mTakeScreenshotOfWindowCallbacks.contains(interactionId)) {
                Pair<Executor, AccessibilityService.TakeScreenshotCallback> pair = this.mTakeScreenshotOfWindowCallbacks.get(interactionId);
                Executor executor = (Executor) pair.first;
                final AccessibilityService.TakeScreenshotCallback callback = (AccessibilityService.TakeScreenshotCallback) pair.second;
                executor.execute(new Runnable() { // from class: android.view.accessibility.AccessibilityInteractionClient$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.onFailure(errorCode);
                    }
                });
                this.mTakeScreenshotOfWindowCallbacks.remove(interactionId);
            }
        }
    }

    private void clearResultLocked() {
        this.mInteractionId = -1;
        this.mFindAccessibilityNodeInfoResult = null;
        this.mFindAccessibilityNodeInfosResult = null;
        this.mPerformAccessibilityActionResult = false;
    }

    private boolean waitForResultTimedLocked(int interactionId) {
        long startTimeMillis = SystemClock.uptimeMillis();
        while (true) {
            try {
                Message sameProcessMessage = getSameProcessMessageAndClear();
                if (sameProcessMessage != null) {
                    sameProcessMessage.getTarget().handleMessage(sameProcessMessage);
                }
            } catch (InterruptedException e2) {
            }
            if (this.mInteractionId == interactionId) {
                return true;
            }
            if (this.mInteractionId > interactionId) {
                return false;
            }
            long elapsedTimeMillis = SystemClock.uptimeMillis() - startTimeMillis;
            long waitTimeMillis = 5000 - elapsedTimeMillis;
            if (waitTimeMillis <= 0) {
                return false;
            }
            this.mInstanceLock.wait(waitTimeMillis);
        }
    }

    private void finalizeAndCacheAccessibilityNodeInfo(AccessibilityNodeInfo info, int connectionId, boolean bypassCache, String[] packageNames) {
        AccessibilityCache cache;
        CharSequence packageName;
        if (info != null) {
            info.setConnectionId(connectionId);
            if (!ArrayUtils.isEmpty(packageNames) && ((packageName = info.getPackageName()) == null || !ArrayUtils.contains(packageNames, packageName.toString()))) {
                info.setPackageName(packageNames[0]);
            }
            info.setSealed(true);
            if (bypassCache || (cache = getCache(connectionId)) == null) {
                return;
            }
            cache.add(info);
        }
    }

    private void finalizeAndCacheAccessibilityNodeInfos(List<AccessibilityNodeInfo> infos, int connectionId, boolean bypassCache, String[] packageNames) {
        if (infos != null) {
            int infosCount = infos.size();
            for (int i10 = 0; i10 < infosCount; i10++) {
                AccessibilityNodeInfo info = infos.get(i10);
                finalizeAndCacheAccessibilityNodeInfo(info, connectionId, bypassCache, packageNames);
            }
        }
    }

    private Message getSameProcessMessageAndClear() {
        Message result;
        synchronized (this.mInstanceLock) {
            result = this.mSameThreadMessage;
            this.mSameThreadMessage = null;
        }
        return result;
    }

    private void checkFindAccessibilityNodeInfoResultIntegrity(List<AccessibilityNodeInfo> infos) {
        if (infos.size() == 0) {
            return;
        }
        AccessibilityNodeInfo root = infos.get(0);
        int infoCount = infos.size();
        for (int i10 = 1; i10 < infoCount; i10++) {
            int j10 = i10;
            while (true) {
                if (j10 < infoCount) {
                    AccessibilityNodeInfo candidate = infos.get(j10);
                    if (root.getParentNodeId() != candidate.getSourceNodeId()) {
                        j10++;
                    } else {
                        root = candidate;
                        break;
                    }
                }
            }
        }
        if (root == null) {
            Log.e(LOG_TAG, "No root.");
        }
        HashSet<AccessibilityNodeInfo> seen = new HashSet<>();
        Queue<AccessibilityNodeInfo> fringe = new ArrayDeque<>();
        fringe.add(root);
        while (!fringe.isEmpty()) {
            AccessibilityNodeInfo current = fringe.poll();
            if (!seen.add(current)) {
                Log.e(LOG_TAG, "Duplicate node.");
                return;
            }
            int childCount = current.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                long childId = current.getChildId(i11);
                for (int j11 = 0; j11 < infoCount; j11++) {
                    AccessibilityNodeInfo child = infos.get(j11);
                    if (child.getSourceNodeId() == childId) {
                        fringe.add(child);
                    }
                }
            }
        }
        int disconnectedCount = infos.size() - seen.size();
        if (disconnectedCount > 0) {
            Log.e(LOG_TAG, disconnectedCount + " Disconnected nodes.");
        }
    }

    private void updateScrollingWindow(int windowId, long uptimeMillis) {
        SparseLongArray sparseLongArray = sScrollingWindows;
        synchronized (sparseLongArray) {
            sparseLongArray.put(windowId, uptimeMillis);
        }
    }

    private void deleteScrollingWindow(int windowId) {
        SparseLongArray sparseLongArray = sScrollingWindows;
        synchronized (sparseLongArray) {
            sparseLongArray.delete(windowId);
        }
    }

    private boolean isWindowScrolling(int windowId) {
        SparseLongArray sparseLongArray = sScrollingWindows;
        synchronized (sparseLongArray) {
            long latestScrollingTime = sparseLongArray.get(windowId);
            if (latestScrollingTime == 0) {
                return false;
            }
            long currentUptime = SystemClock.uptimeMillis();
            if (currentUptime > DISABLE_PREFETCHING_FOR_SCROLLING_MILLIS + latestScrollingTime) {
                sparseLongArray.delete(windowId);
                return false;
            }
            return true;
        }
    }

    private boolean shouldTraceClient() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isA11yInteractionClientTraceEnabled();
    }

    private boolean shouldTraceCallback() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isA11yInteractionConnectionCBTraceEnabled();
    }

    private void logTrace(IAccessibilityServiceConnection connection, String method, String params, int callingUid, List<StackTraceElement> callStack, HashSet<String> ignoreSet, long logTypes) {
        try {
            Bundle b4 = new Bundle();
            try {
                b4.putSerializable(CALL_STACK, new ArrayList(callStack));
                if (ignoreSet != null) {
                    b4.putSerializable(IGNORE_CALL_STACK, ignoreSet);
                }
            } catch (RemoteException e2) {
                e = e2;
            }
            try {
                connection.logTrace(SystemClock.elapsedRealtimeNanos(), "AccessibilityInteractionClient." + method, logTypes, params, Process.myPid(), Thread.currentThread().getId(), callingUid, b4);
            } catch (RemoteException e10) {
                e = e10;
                Log.e(LOG_TAG, "Failed to log trace. " + ((Object) e));
            }
        } catch (RemoteException e11) {
            e = e11;
        }
    }

    private void logTraceCallback(IAccessibilityServiceConnection connection, String method, String params) {
        logTrace(connection, method + " callback", params, this.mCallingUid, this.mCallStackOfCallback, new HashSet<>(Arrays.asList("getStackTrace")), 32L);
    }

    private void logTraceClient(IAccessibilityServiceConnection connection, String method, String params) {
        logTrace(connection, method, params, Binder.getCallingUid(), Arrays.asList(Thread.currentThread().getStackTrace()), new HashSet<>(Arrays.asList("getStackTrace", "logTraceClient")), PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
    }

    public void attachAccessibilityOverlayToWindow(int connectionId, int accessibilityWindowId, SurfaceControl sc2) {
        IAccessibilityServiceConnection connection;
        synchronized (this.mInstanceLock) {
            try {
                connection = getConnection(connectionId);
            } catch (RemoteException re) {
                re.rethrowFromSystemServer();
            }
            if (connection == null) {
                Log.e(LOG_TAG, "Error while getting service connection.");
            } else {
                connection.attachAccessibilityOverlayToWindow(accessibilityWindowId, sc2);
            }
        }
    }
}
