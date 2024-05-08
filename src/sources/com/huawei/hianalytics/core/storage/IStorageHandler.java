package com.huawei.hianalytics.core.storage;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IStorageHandler {
    void deleteAll();

    void deleteByTag(String str);

    void deleteByTagType(String str, String str2);

    void deleteCommonHeaderEx(String str);

    void deleteCommonHeaderExAll();

    void deleteEvents(List<Event> list);

    long insert(CommonHeaderEx commonHeaderEx);

    long insert(Event event);

    void insertEx(List<Event> list);

    List<Event> readBySql(String str);

    CommonHeaderEx readCommonHeaderEx(String str);

    long readEventSize(String str);

    long readEventSize(String str, String str2);

    List<Event> readEvents(String str, String str2);

    List<Event> readEvents(String str, String str2, String str3);

    List<Event> readEventsAll();

    List<Event> readEventsDefault(String str, String str2);

    List<Event> readOldEvents(String str, String str2, String str3);
}
