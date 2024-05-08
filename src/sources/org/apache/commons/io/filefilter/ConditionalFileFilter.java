package org.apache.commons.io.filefilter;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ConditionalFileFilter {
    void addFileFilter(IOFileFilter iOFileFilter);

    List<IOFileFilter> getFileFilters();

    boolean removeFileFilter(IOFileFilter iOFileFilter);

    void setFileFilters(List<IOFileFilter> list);
}
