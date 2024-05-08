package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IInputtipsSearch {
    InputtipsQuery getQuery();

    ArrayList<Tip> requestInputtips() throws AMapException;

    void requestInputtips(String str, String str2) throws AMapException;

    void requestInputtips(String str, String str2, String str3) throws AMapException;

    void requestInputtipsAsyn();

    void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener);

    void setQuery(InputtipsQuery inputtipsQuery);
}
