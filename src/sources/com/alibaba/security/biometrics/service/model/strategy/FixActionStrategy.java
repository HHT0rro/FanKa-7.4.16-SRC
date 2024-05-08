package com.alibaba.security.biometrics.service.model.strategy;

import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FixActionStrategy implements ActionStrategy {
    public List<ABDetectType> detectTypeList;

    public FixActionStrategy(List<ABDetectType> list) {
        LinkedList linkedList = new LinkedList();
        this.detectTypeList = linkedList;
        linkedList.addAll(list);
    }

    public List<ABDetectType> getDetectTypeList() {
        return this.detectTypeList;
    }

    @Override // com.alibaba.security.biometrics.service.model.strategy.ActionStrategy
    public List<ABDetectType> getDetectTypes(int i10) {
        if (i10 >= this.detectTypeList.size()) {
            return new LinkedList(this.detectTypeList);
        }
        LinkedList linkedList = new LinkedList();
        for (int i11 = 0; i11 < i10; i11++) {
            linkedList.add(getDetectTypeList().get(i11));
        }
        return linkedList;
    }

    public void setDetectTypeList(List<ABDetectType> list) {
        this.detectTypeList = list;
    }
}
