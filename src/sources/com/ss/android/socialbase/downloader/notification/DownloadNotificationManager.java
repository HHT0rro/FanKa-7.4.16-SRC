package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadNotificationManager {
    private static final String KEY_NOTIFS_STRING = "notifs_string";
    private static volatile DownloadNotificationManager instance;
    private static final Object sLock = new Object();
    private final long PROGRESS_NOTIFY_DURATION = 1000;
    private final Map<Integer, Long> PROGRESS_NOTIFY_LAST_TIME_INFO = new HashMap();
    private final Set<String> notificationTagSet = new HashSet();
    private final SparseArray<AbsNotificationItem> notificationItemArray = new SparseArray<>();

    private DownloadNotificationManager() {
    }

    public static DownloadNotificationManager getInstance() {
        if (instance == null) {
            synchronized (DownloadNotificationManager.class) {
                if (instance == null) {
                    instance = new DownloadNotificationManager();
                }
            }
        }
        return instance;
    }

    public static boolean isCompleteAndVisible(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && isCompleteVisibility(downloadInfo.getNotificationVisibility());
    }

    public static boolean isCompleteVisibility(int i10) {
        return i10 == 1 || i10 == 3;
    }

    public void addNotification(AbsNotificationItem absNotificationItem) {
        if (absNotificationItem == null) {
            return;
        }
        synchronized (this.notificationItemArray) {
            this.notificationItemArray.put(absNotificationItem.getId(), absNotificationItem);
        }
    }

    public void cancel(int i10) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null || i10 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(appContext, (Class<?>) DownloadNotificationService.class);
            intent.setAction(NotificationConstants.ACTION_NOTIFICATION_CANCEL);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, i10);
            appContext.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cancelCompleteNotification(DownloadInfo downloadInfo) {
        if (isCompleteAndVisible(downloadInfo)) {
            cancelNotification(downloadInfo.getId());
        }
    }

    public void cancelNotification(int i10) {
        removeNotification(i10);
        if (i10 != 0) {
            getInstance().cancel(i10);
        }
    }

    public void clearNotification() {
        SparseArray<AbsNotificationItem> clone;
        synchronized (this.notificationItemArray) {
            clone = this.notificationItemArray.clone();
            this.notificationItemArray.clear();
        }
        for (int i10 = 0; i10 < clone.size(); i10++) {
            clone.get(clone.keyAt(i10)).cancel();
        }
    }

    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        SparseArray<AbsNotificationItem> sparseArray;
        synchronized (this.notificationItemArray) {
            sparseArray = this.notificationItemArray;
        }
        return sparseArray;
    }

    public AbsNotificationItem getNotificationItem(int i10) {
        AbsNotificationItem absNotificationItem;
        if (i10 == 0) {
            return null;
        }
        synchronized (this.notificationItemArray) {
            absNotificationItem = this.notificationItemArray.get(i10);
        }
        return absNotificationItem;
    }

    public void hideNotification(int i10) {
        DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i10);
        if (downloadInfo == null) {
            return;
        }
        updateNotificationState(downloadInfo);
        cancelCompleteNotification(downloadInfo);
    }

    public void notifyByService(int i10, int i11, Notification notification) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null || i10 == 0 || notification == null) {
            return;
        }
        if (i11 == 4) {
            synchronized (this.PROGRESS_NOTIFY_LAST_TIME_INFO) {
                Long l10 = this.PROGRESS_NOTIFY_LAST_TIME_INFO.get(Integer.valueOf(i10));
                long currentTimeMillis = System.currentTimeMillis();
                if (l10 != null && Math.abs(currentTimeMillis - l10.longValue()) < 1000) {
                    return;
                } else {
                    this.PROGRESS_NOTIFY_LAST_TIME_INFO.put(Integer.valueOf(i10), Long.valueOf(currentTimeMillis));
                }
            }
        }
        try {
            Intent intent = new Intent(appContext, (Class<?>) DownloadNotificationService.class);
            intent.setAction(NotificationConstants.ACTION_NOTIFICATION_NOTIFY);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, i11);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, i10);
            intent.putExtra(NotificationConstants.EXTRA_NOTIFICATION, notification);
            appContext.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AbsNotificationItem removeNotification(int i10) {
        AbsNotificationItem absNotificationItem;
        if (i10 == 0) {
            return null;
        }
        synchronized (this.notificationItemArray) {
            absNotificationItem = this.notificationItemArray.get(i10);
            if (absNotificationItem != null) {
                this.notificationItemArray.remove(i10);
                Logger.d("removeNotificationId " + i10);
            }
        }
        return absNotificationItem;
    }

    public void updateNotificationState(DownloadInfo downloadInfo) {
        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
        if (downloadCache != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                downloadCache.updateDownloadInfo(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
