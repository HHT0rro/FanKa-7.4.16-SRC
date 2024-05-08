package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OfflineMapDownloadList.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bc {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<OfflineMapProvince> f5108a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private bn f5109b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5110c;

    public bc(Context context) {
        this.f5110c = context;
        this.f5109b = bn.a(context);
    }

    private void a(bi biVar) {
        bn bnVar = this.f5109b;
        if (bnVar == null || biVar == null) {
            return;
        }
        bnVar.a(biVar);
    }

    private static boolean a(int i10) {
        return i10 == 4;
    }

    private static boolean a(int i10, int i11) {
        return i11 != 1 || i10 <= 2 || i10 >= 98;
    }

    private void b(bi biVar) {
        bn bnVar = this.f5109b;
        if (bnVar != null) {
            bnVar.b(biVar);
        }
    }

    private static boolean b(int i10) {
        return i10 == 0 || i10 == 2 || i10 == 3 || i10 == 1 || i10 == 102 || i10 == 101 || i10 == 103 || i10 == -1;
    }

    private void h() {
        ArrayList<OfflineMapProvince> arrayList = this.f5108a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f5108a.clear();
            }
        }
    }

    public final OfflineMapProvince c(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f5108a) {
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                OfflineMapProvince next = iterator2.next();
                if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return next;
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapProvince> d() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f5108a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                OfflineMapProvince next = iterator2.next();
                if (next != null && (next.getState() == 4 || next.getState() == 7)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> e() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f5108a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                OfflineMapProvince next = iterator2.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (b(offlineMapCity.getState())) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> f() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f5108a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                OfflineMapProvince next = iterator2.next();
                if (next != null && b(next.getState())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final void g() {
        h();
        this.f5109b = null;
        this.f5110c = null;
    }

    private static boolean a(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> iterator2 = offlineMapProvince.getCityList().iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    public final OfflineMapCity b(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f5108a) {
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                Iterator<OfflineMapCity> iterator22 = iterator2.next().getCityList().iterator2();
                while (iterator22.hasNext()) {
                    OfflineMapCity next = iterator22.next();
                    if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapProvince> a() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.f5108a) {
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next());
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> c() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f5108a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                OfflineMapProvince next = iterator2.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getState() == 4 || offlineMapCity.getState() == 7) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final OfflineMapCity a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f5108a) {
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                Iterator<OfflineMapCity> iterator22 = iterator2.next().getCityList().iterator2();
                while (iterator22.hasNext()) {
                    OfflineMapCity next = iterator22.next();
                    if (next.getCode().equals(str)) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> b() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.f5108a) {
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            while (iterator2.hasNext()) {
                Iterator<OfflineMapCity> iterator22 = iterator2.next().getCityList().iterator2();
                while (iterator22.hasNext()) {
                    arrayList.add(iterator22.next());
                }
            }
        }
        return arrayList;
    }

    private void b(ax axVar) {
        File[] listFiles = new File(dx.c(this.f5110c)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isFile() && file.exists() && file.getName().contains(axVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                file.delete();
            }
        }
    }

    public final void a(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.f5108a) {
            if (this.f5108a.size() > 0) {
                for (int i10 = 0; i10 < this.f5108a.size(); i10++) {
                    OfflineMapProvince offlineMapProvince2 = this.f5108a.get(i10);
                    Iterator<OfflineMapProvince> iterator2 = list.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            offlineMapProvince = null;
                            break;
                        }
                        offlineMapProvince = iterator2.next();
                        if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                            break;
                        }
                        if (offlineMapProvince2.getPinyin().equals("quanguogaiyaotu") || offlineMapProvince2.getProvinceCode().equals("000001") || offlineMapProvince2.getProvinceCode().equals("100000")) {
                            if (offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                                break;
                            }
                        }
                    }
                    if (offlineMapProvince != null) {
                        a(offlineMapProvince2, offlineMapProvince);
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                        for (int i11 = 0; i11 < cityList.size(); i11++) {
                            OfflineMapCity offlineMapCity2 = cityList.get(i11);
                            Iterator<OfflineMapCity> iterator22 = cityList2.iterator2();
                            while (true) {
                                if (iterator22.hasNext()) {
                                    offlineMapCity = iterator22.next();
                                    if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                        break;
                                    }
                                } else {
                                    offlineMapCity = null;
                                    break;
                                }
                            }
                            if (offlineMapCity != null) {
                                a(offlineMapCity2, offlineMapCity);
                            }
                        }
                    }
                }
            } else {
                Iterator<OfflineMapProvince> iterator23 = list.iterator2();
                while (iterator23.hasNext()) {
                    this.f5108a.add(iterator23.next());
                }
            }
        }
    }

    private static void a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    private static void a(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    public final void a(ax axVar) {
        String pinyin = axVar.getPinyin();
        synchronized (this.f5108a) {
            Iterator<OfflineMapProvince> iterator2 = this.f5108a.iterator2();
            loop0: while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                OfflineMapProvince next = iterator2.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                            a(axVar, offlineMapCity);
                            a(axVar, next);
                            break loop0;
                        }
                    }
                }
            }
        }
    }

    private void a(ax axVar, OfflineMapCity offlineMapCity) {
        int b4 = axVar.c().b();
        if (axVar.c().equals(axVar.f5056a)) {
            b(axVar.t());
        } else {
            if (axVar.c().equals(axVar.f5061f)) {
                axVar.getCity();
                b(axVar);
                axVar.t().b();
            }
            if (a(axVar.getcompleteCode(), axVar.c().b())) {
                a(axVar.t());
            }
        }
        offlineMapCity.setState(b4);
        offlineMapCity.setCompleteCode(axVar.getcompleteCode());
    }

    private void a(ax axVar, OfflineMapProvince offlineMapProvince) {
        bi biVar;
        int b4 = axVar.c().b();
        if (b4 == 6) {
            offlineMapProvince.setState(b4);
            offlineMapProvince.setCompleteCode(0);
            b(new bi(offlineMapProvince, this.f5110c));
            try {
                bv.b(offlineMapProvince.getProvinceCode(), this.f5110c);
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        if (a(b4) && a(offlineMapProvince)) {
            if (axVar.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(b4);
                offlineMapProvince.setCompleteCode(axVar.getcompleteCode());
                offlineMapProvince.setVersion(axVar.getVersion());
                offlineMapProvince.setUrl(axVar.getUrl());
                biVar = new bi(offlineMapProvince, this.f5110c);
                biVar.a(axVar.a());
                biVar.d(axVar.getCode());
            } else {
                offlineMapProvince.setState(b4);
                offlineMapProvince.setCompleteCode(100);
                biVar = new bi(offlineMapProvince, this.f5110c);
            }
            biVar.b();
            a(biVar);
            biVar.c();
        }
    }
}
