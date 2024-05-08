package android.view.accessibility;

import android.os.Build;
import android.util.ArraySet;
import android.util.Log;
import android.util.LongArray;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AccessibilityCache {
    public static final int CACHE_CRITICAL_EVENTS_MASK = 4307005;
    private static final boolean CHECK_INTEGRITY;
    private static final boolean DEBUG;
    private static final String LOG_TAG = "AccessibilityCache";
    private static final boolean VERBOSE;
    private final AccessibilityNodeRefresher mAccessibilityNodeRefresher;
    private boolean mIsAllWindowsCached;
    private boolean mEnabled = true;
    private final Object mLock = new Object();
    private long mAccessibilityFocus = ZipUtils.UPPER_UNIXTIME_BOUND;
    private long mInputFocus = ZipUtils.UPPER_UNIXTIME_BOUND;
    private long mValidWindowCacheTimeStamp = 0;
    private int mAccessibilityFocusedWindow = -1;
    private int mInputFocusWindow = -1;
    private final SparseArray<SparseArray<AccessibilityWindowInfo>> mWindowCacheByDisplay = new SparseArray<>();
    private final SparseArray<LongSparseArray<AccessibilityNodeInfo>> mNodeCache = new SparseArray<>();
    private final SparseArray<AccessibilityWindowInfo> mTempWindowArray = new SparseArray<>();

    static {
        DEBUG = Log.isLoggable(LOG_TAG, 3) && Build.IS_DEBUGGABLE;
        VERBOSE = Log.isLoggable(LOG_TAG, 2) && Build.IS_DEBUGGABLE;
        CHECK_INTEGRITY = Build.IS_ENG;
    }

    public AccessibilityCache(AccessibilityNodeRefresher nodeRefresher) {
        this.mAccessibilityNodeRefresher = nodeRefresher;
    }

    public boolean isEnabled() {
        boolean z10;
        synchronized (this.mLock) {
            z10 = this.mEnabled;
        }
        return z10;
    }

    public void setEnabled(boolean enabled) {
        synchronized (this.mLock) {
            this.mEnabled = enabled;
            clear();
        }
    }

    public void setWindowsOnAllDisplays(SparseArray<List<AccessibilityWindowInfo>> windowsOnAllDisplays, long populationTimeStamp) {
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
                return;
            }
            if (DEBUG) {
                Log.i(LOG_TAG, "Set windows");
            }
            if (this.mValidWindowCacheTimeStamp > populationTimeStamp) {
                return;
            }
            clearWindowCacheLocked();
            if (windowsOnAllDisplays == null) {
                return;
            }
            int displayCounts = windowsOnAllDisplays.size();
            for (int i10 = 0; i10 < displayCounts; i10++) {
                List<AccessibilityWindowInfo> windowsOfDisplay = windowsOnAllDisplays.valueAt(i10);
                if (windowsOfDisplay != null) {
                    int displayId = windowsOnAllDisplays.keyAt(i10);
                    int windowCount = windowsOfDisplay.size();
                    for (int j10 = 0; j10 < windowCount; j10++) {
                        addWindowByDisplayLocked(displayId, windowsOfDisplay.get(j10));
                    }
                }
            }
            this.mIsAllWindowsCached = true;
        }
    }

    public void addWindow(AccessibilityWindowInfo window) {
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
            } else {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Caching window: " + window.getId() + " at display Id [ " + window.getDisplayId() + " ]");
                }
                addWindowByDisplayLocked(window.getDisplayId(), window);
            }
        }
    }

    private void addWindowByDisplayLocked(int displayId, AccessibilityWindowInfo window) {
        SparseArray<AccessibilityWindowInfo> windows = this.mWindowCacheByDisplay.get(displayId);
        if (windows == null) {
            windows = new SparseArray<>();
            this.mWindowCacheByDisplay.put(displayId, windows);
        }
        int windowId = window.getId();
        windows.put(windowId, new AccessibilityWindowInfo(window));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0040. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAccessibilityEvent(android.view.accessibility.AccessibilityEvent r12) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.accessibility.AccessibilityCache.onAccessibilityEvent(android.view.accessibility.AccessibilityEvent):void");
    }

    private AccessibilityNodeInfo removeCachedNodeLocked(int windowId, long sourceId) {
        AccessibilityNodeInfo cachedInfo;
        if (DEBUG) {
            Log.i(LOG_TAG, "Removing cached node.");
        }
        LongSparseArray<AccessibilityNodeInfo> nodes = this.mNodeCache.get(windowId);
        if (nodes == null || (cachedInfo = nodes.get(sourceId)) == null) {
            return null;
        }
        nodes.remove(sourceId);
        return cachedInfo;
    }

    public AccessibilityNodeInfo getNode(int windowId, long accessibilityNodeId) {
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
                return null;
            }
            LongSparseArray<AccessibilityNodeInfo> nodes = this.mNodeCache.get(windowId);
            if (nodes == null) {
                return null;
            }
            AccessibilityNodeInfo info = nodes.get(accessibilityNodeId);
            if (info != null) {
                info = new AccessibilityNodeInfo(info);
            }
            if (VERBOSE) {
                Log.i(LOG_TAG, "get(0x" + Long.toHexString(accessibilityNodeId) + ") = " + ((Object) info));
            }
            return info;
        }
    }

    public boolean isNodeInCache(AccessibilityNodeInfo info) {
        if (info == null) {
            return false;
        }
        int windowId = info.getWindowId();
        long accessibilityNodeId = info.getSourceNodeId();
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
                return false;
            }
            LongSparseArray<AccessibilityNodeInfo> nodes = this.mNodeCache.get(windowId);
            if (nodes == null) {
                return false;
            }
            return nodes.get(accessibilityNodeId) != null;
        }
    }

    public SparseArray<List<AccessibilityWindowInfo>> getWindowsOnAllDisplays() {
        int windowCount;
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
                return null;
            }
            if (!this.mIsAllWindowsCached) {
                return null;
            }
            SparseArray<List<AccessibilityWindowInfo>> returnWindows = new SparseArray<>();
            int displayCounts = this.mWindowCacheByDisplay.size();
            if (displayCounts <= 0) {
                return null;
            }
            for (int i10 = 0; i10 < displayCounts; i10++) {
                int displayId = this.mWindowCacheByDisplay.keyAt(i10);
                SparseArray<AccessibilityWindowInfo> windowsOfDisplay = this.mWindowCacheByDisplay.valueAt(i10);
                if (windowsOfDisplay != null && (windowCount = windowsOfDisplay.size()) > 0) {
                    SparseArray<AccessibilityWindowInfo> sortedWindows = this.mTempWindowArray;
                    sortedWindows.clear();
                    for (int j10 = 0; j10 < windowCount; j10++) {
                        AccessibilityWindowInfo window = windowsOfDisplay.valueAt(j10);
                        sortedWindows.put(window.getLayer(), window);
                    }
                    int sortedWindowCount = sortedWindows.size();
                    List<AccessibilityWindowInfo> windows = new ArrayList<>(sortedWindowCount);
                    for (int j11 = sortedWindowCount - 1; j11 >= 0; j11--) {
                        windows.add(new AccessibilityWindowInfo(sortedWindows.valueAt(j11)));
                        sortedWindows.removeAt(j11);
                    }
                    returnWindows.put(displayId, windows);
                }
            }
            return returnWindows;
        }
    }

    public AccessibilityWindowInfo getWindow(int windowId) {
        AccessibilityWindowInfo window;
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
                return null;
            }
            int displayCounts = this.mWindowCacheByDisplay.size();
            for (int i10 = 0; i10 < displayCounts; i10++) {
                SparseArray<AccessibilityWindowInfo> windowsOfDisplay = this.mWindowCacheByDisplay.valueAt(i10);
                if (windowsOfDisplay != null && (window = windowsOfDisplay.get(windowId)) != null) {
                    return new AccessibilityWindowInfo(window);
                }
            }
            return null;
        }
    }

    public void add(AccessibilityNodeInfo info) {
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
                return;
            }
            if (VERBOSE) {
                Log.i(LOG_TAG, "add(" + ((Object) info) + ")");
            }
            int windowId = info.getWindowId();
            LongSparseArray<AccessibilityNodeInfo> nodes = this.mNodeCache.get(windowId);
            if (nodes == null) {
                nodes = new LongSparseArray<>();
                this.mNodeCache.put(windowId, nodes);
            }
            long sourceId = info.getSourceNodeId();
            AccessibilityNodeInfo oldInfo = nodes.get(sourceId);
            if (oldInfo != null) {
                LongArray newChildrenIds = info.getChildNodeIds();
                int oldChildCount = oldInfo.getChildCount();
                for (int i10 = 0; i10 < oldChildCount; i10++) {
                    long oldChildId = oldInfo.getChildId(i10);
                    if (newChildrenIds == null || newChildrenIds.indexOf(oldChildId) < 0) {
                        clearSubTreeLocked(windowId, oldChildId);
                    }
                    if (nodes.get(sourceId) == null) {
                        clearNodesForWindowLocked(windowId);
                        return;
                    }
                }
                long oldParentId = oldInfo.getParentNodeId();
                if (info.getParentNodeId() != oldParentId) {
                    clearSubTreeLocked(windowId, oldParentId);
                }
            }
            AccessibilityNodeInfo clone = new AccessibilityNodeInfo(info);
            nodes.put(sourceId, clone);
            if (clone.isAccessibilityFocused()) {
                long j10 = this.mAccessibilityFocus;
                if (j10 != ZipUtils.UPPER_UNIXTIME_BOUND && j10 != sourceId) {
                    removeCachedNodeLocked(windowId, j10);
                }
                this.mAccessibilityFocus = sourceId;
                this.mAccessibilityFocusedWindow = windowId;
            } else if (this.mAccessibilityFocus == sourceId) {
                this.mAccessibilityFocus = ZipUtils.UPPER_UNIXTIME_BOUND;
                this.mAccessibilityFocusedWindow = -1;
            }
            if (clone.isFocused()) {
                this.mInputFocus = sourceId;
                this.mInputFocusWindow = windowId;
            }
        }
    }

    public void clear() {
        synchronized (this.mLock) {
            if (DEBUG) {
                Log.i(LOG_TAG, "clear()");
            }
            clearWindowCacheLocked();
            int nodesForWindowCount = this.mNodeCache.size();
            for (int i10 = nodesForWindowCount - 1; i10 >= 0; i10--) {
                int windowId = this.mNodeCache.keyAt(i10);
                clearNodesForWindowLocked(windowId);
            }
            this.mAccessibilityFocus = ZipUtils.UPPER_UNIXTIME_BOUND;
            this.mInputFocus = ZipUtils.UPPER_UNIXTIME_BOUND;
            this.mAccessibilityFocusedWindow = -1;
            this.mInputFocusWindow = -1;
        }
    }

    private void clearWindowCacheLocked() {
        if (DEBUG) {
            Log.i(LOG_TAG, "clearWindowCacheLocked");
        }
        int displayCounts = this.mWindowCacheByDisplay.size();
        if (displayCounts > 0) {
            for (int i10 = displayCounts - 1; i10 >= 0; i10--) {
                int displayId = this.mWindowCacheByDisplay.keyAt(i10);
                SparseArray<AccessibilityWindowInfo> windows = this.mWindowCacheByDisplay.get(displayId);
                if (windows != null) {
                    windows.clear();
                }
                this.mWindowCacheByDisplay.remove(displayId);
            }
        }
        this.mIsAllWindowsCached = false;
    }

    public AccessibilityNodeInfo getFocus(int focusType, long initialNodeId, int windowId) {
        int currentFocusWindowId;
        long currentFocusId;
        AccessibilityNodeInfo currentFocusedNode;
        AccessibilityNodeInfo currentFocusedNode2;
        String str;
        String str2;
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
                return null;
            }
            if (focusType == 2) {
                int currentFocusWindowId2 = this.mAccessibilityFocusedWindow;
                currentFocusWindowId = currentFocusWindowId2;
                currentFocusId = this.mAccessibilityFocus;
            } else {
                int currentFocusWindowId3 = this.mInputFocusWindow;
                currentFocusWindowId = currentFocusWindowId3;
                currentFocusId = this.mInputFocus;
            }
            if (currentFocusWindowId == -1) {
                return null;
            }
            if (windowId != -2 && windowId != currentFocusWindowId) {
                return null;
            }
            LongSparseArray<AccessibilityNodeInfo> nodes = this.mNodeCache.get(currentFocusWindowId);
            if (nodes == null) {
                return null;
            }
            AccessibilityNodeInfo currentFocusedNode3 = nodes.get(currentFocusId);
            if (currentFocusedNode3 == null) {
                return null;
            }
            if (initialNodeId != currentFocusId) {
                currentFocusedNode = currentFocusedNode3;
                if (!isCachedNodeOrDescendantLocked(currentFocusedNode3.getParentNodeId(), initialNodeId, nodes)) {
                    if (VERBOSE) {
                        StringBuilder append = new StringBuilder().append("getFocus is null with type: ");
                        if (focusType == 2) {
                            str2 = "FOCUS_ACCESSIBILITY";
                        } else {
                            str2 = "FOCUS_INPUT";
                        }
                        Log.i(LOG_TAG, append.append(str2).toString());
                    }
                    return null;
                }
            } else {
                currentFocusedNode = currentFocusedNode3;
            }
            if (!VERBOSE) {
                currentFocusedNode2 = currentFocusedNode;
            } else {
                currentFocusedNode2 = currentFocusedNode;
                StringBuilder append2 = new StringBuilder().append("getFocus(0x").append(Long.toHexString(currentFocusId)).append(") = ").append((Object) currentFocusedNode2).append(" with type: ");
                if (focusType == 2) {
                    str = "FOCUS_ACCESSIBILITY";
                } else {
                    str = "FOCUS_INPUT";
                }
                Log.i(LOG_TAG, append2.append(str).toString());
            }
            return new AccessibilityNodeInfo(currentFocusedNode2);
        }
    }

    private boolean isCachedNodeOrDescendantLocked(long nodeId, long ancestorId, LongSparseArray<AccessibilityNodeInfo> nodes) {
        if (ancestorId == nodeId) {
            return true;
        }
        AccessibilityNodeInfo node = nodes.get(nodeId);
        if (node == null) {
            return false;
        }
        return isCachedNodeOrDescendantLocked(node.getParentNodeId(), ancestorId, nodes);
    }

    private void clearNodesForWindowLocked(int windowId) {
        if (DEBUG) {
            Log.i(LOG_TAG, "clearNodesForWindowLocked(" + windowId + ")");
        }
        LongSparseArray<AccessibilityNodeInfo> nodes = this.mNodeCache.get(windowId);
        if (nodes == null) {
            return;
        }
        this.mNodeCache.remove(windowId);
    }

    public boolean clearSubTree(AccessibilityNodeInfo info) {
        if (info == null) {
            return false;
        }
        synchronized (this.mLock) {
            if (!this.mEnabled) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Cache is disabled");
                }
                return false;
            }
            clearSubTreeLocked(info.getWindowId(), info.getSourceNodeId());
            return true;
        }
    }

    private void clearSubTreeLocked(int windowId, long rootNodeId) {
        if (DEBUG) {
            Log.i(LOG_TAG, "Clearing cached subtree.");
        }
        LongSparseArray<AccessibilityNodeInfo> nodes = this.mNodeCache.get(windowId);
        if (nodes != null) {
            clearSubTreeRecursiveLocked(nodes, rootNodeId);
        }
    }

    private boolean clearSubTreeRecursiveLocked(LongSparseArray<AccessibilityNodeInfo> nodes, long rootNodeId) {
        AccessibilityNodeInfo current = nodes.get(rootNodeId);
        if (current == null) {
            clear();
            return true;
        }
        nodes.remove(rootNodeId);
        int childCount = current.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            long childNodeId = current.getChildId(i10);
            if (clearSubTreeRecursiveLocked(nodes, childNodeId)) {
                return true;
            }
        }
        return false;
    }

    public void checkIntegrity() {
        AccessibilityWindowInfo focusedWindow;
        AccessibilityWindowInfo activeWindow;
        int displayCounts;
        AccessibilityWindowInfo focusedWindow2;
        AccessibilityWindowInfo activeWindow2;
        int displayCounts2;
        int childCount;
        AccessibilityNodeInfo inputFocus;
        int k10;
        AccessibilityCache accessibilityCache = this;
        synchronized (accessibilityCache.mLock) {
            if (accessibilityCache.mWindowCacheByDisplay.size() > 0 || accessibilityCache.mNodeCache.size() != 0) {
                AccessibilityWindowInfo focusedWindow3 = null;
                AccessibilityWindowInfo activeWindow3 = null;
                int displayCounts3 = accessibilityCache.mWindowCacheByDisplay.size();
                for (int i10 = 0; i10 < displayCounts3; i10++) {
                    SparseArray<AccessibilityWindowInfo> windowsOfDisplay = accessibilityCache.mWindowCacheByDisplay.valueAt(i10);
                    if (windowsOfDisplay != null) {
                        int windowCount = windowsOfDisplay.size();
                        for (int j10 = 0; j10 < windowCount; j10++) {
                            AccessibilityWindowInfo window = windowsOfDisplay.valueAt(j10);
                            if (window.isActive()) {
                                if (activeWindow3 != null) {
                                    Log.e(LOG_TAG, "Duplicate active window:" + ((Object) window));
                                } else {
                                    activeWindow3 = window;
                                }
                            }
                            if (window.isFocused()) {
                                if (focusedWindow3 != null) {
                                    Log.e(LOG_TAG, "Duplicate focused window:" + ((Object) window));
                                } else {
                                    focusedWindow3 = window;
                                }
                            }
                        }
                    }
                }
                AccessibilityNodeInfo accessFocus = null;
                AccessibilityNodeInfo inputFocus2 = null;
                int nodesForWindowCount = accessibilityCache.mNodeCache.size();
                int i11 = 0;
                while (i11 < nodesForWindowCount) {
                    LongSparseArray<AccessibilityNodeInfo> nodes = accessibilityCache.mNodeCache.valueAt(i11);
                    if (nodes.size() <= 0) {
                        focusedWindow = focusedWindow3;
                        activeWindow = activeWindow3;
                        displayCounts = displayCounts3;
                    } else {
                        ArraySet<AccessibilityNodeInfo> seen = new ArraySet<>();
                        int windowId = accessibilityCache.mNodeCache.keyAt(i11);
                        int nodeCount = nodes.size();
                        int j11 = 0;
                        while (j11 < nodeCount) {
                            AccessibilityNodeInfo node = nodes.valueAt(j11);
                            if (!seen.add(node)) {
                                focusedWindow2 = focusedWindow3;
                                Log.e(LOG_TAG, "Duplicate node: " + ((Object) node) + " in window:" + windowId);
                                activeWindow2 = activeWindow3;
                                displayCounts2 = displayCounts3;
                            } else {
                                focusedWindow2 = focusedWindow3;
                                if (node.isAccessibilityFocused()) {
                                    if (accessFocus != null) {
                                        Log.e(LOG_TAG, "Duplicate accessibility focus:" + ((Object) node) + " in window:" + windowId);
                                    } else {
                                        accessFocus = node;
                                    }
                                }
                                if (node.isFocused()) {
                                    if (inputFocus2 != null) {
                                        Log.e(LOG_TAG, "Duplicate input focus: " + ((Object) node) + " in window:" + windowId);
                                    } else {
                                        inputFocus2 = node;
                                    }
                                }
                                AccessibilityNodeInfo nodeParent = nodes.get(node.getParentNodeId());
                                if (nodeParent == null) {
                                    activeWindow2 = activeWindow3;
                                    displayCounts2 = displayCounts3;
                                } else {
                                    int childCount2 = nodeParent.getChildCount();
                                    int k11 = 0;
                                    while (true) {
                                        if (k11 >= childCount2) {
                                            activeWindow2 = activeWindow3;
                                            displayCounts2 = displayCounts3;
                                            k10 = 0;
                                            break;
                                        }
                                        activeWindow2 = activeWindow3;
                                        displayCounts2 = displayCounts3;
                                        if (nodes.get(nodeParent.getChildId(k11)) != node) {
                                            k11++;
                                            displayCounts3 = displayCounts2;
                                            activeWindow3 = activeWindow2;
                                        } else {
                                            k10 = 1;
                                            break;
                                        }
                                    }
                                    if (k10 == 0) {
                                        Log.e(LOG_TAG, "Invalid parent-child relation between parent: " + ((Object) nodeParent) + " and child: " + ((Object) node));
                                    }
                                }
                                int childCount3 = node.getChildCount();
                                int k12 = 0;
                                while (k12 < childCount3) {
                                    AccessibilityNodeInfo accessFocus2 = accessFocus;
                                    AccessibilityNodeInfo child = nodes.get(node.getChildId(k12));
                                    if (child == null) {
                                        childCount = childCount3;
                                        inputFocus = inputFocus2;
                                    } else {
                                        inputFocus = inputFocus2;
                                        AccessibilityNodeInfo parent = nodes.get(child.getParentNodeId());
                                        if (parent == node) {
                                            childCount = childCount3;
                                        } else {
                                            childCount = childCount3;
                                            Log.e(LOG_TAG, "Invalid child-parent relation between child: " + ((Object) node) + " and parent: " + ((Object) nodeParent));
                                        }
                                    }
                                    k12++;
                                    accessFocus = accessFocus2;
                                    inputFocus2 = inputFocus;
                                    childCount3 = childCount;
                                }
                            }
                            j11++;
                            focusedWindow3 = focusedWindow2;
                            displayCounts3 = displayCounts2;
                            activeWindow3 = activeWindow2;
                        }
                        focusedWindow = focusedWindow3;
                        activeWindow = activeWindow3;
                        displayCounts = displayCounts3;
                    }
                    i11++;
                    accessibilityCache = this;
                    focusedWindow3 = focusedWindow;
                    displayCounts3 = displayCounts;
                    activeWindow3 = activeWindow;
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class AccessibilityNodeRefresher {
        public boolean refreshNode(AccessibilityNodeInfo info, boolean bypassCache) {
            return info.refresh(null, bypassCache);
        }

        public boolean refreshWindow(AccessibilityWindowInfo info) {
            return info.refresh();
        }
    }
}
