package com.google.api;

import com.google.api.Distribution;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface DistributionOrBuilder extends MessageOrBuilder {
    long getBucketCounts(int i10);

    int getBucketCountsCount();

    List<Long> getBucketCountsList();

    Distribution.BucketOptions getBucketOptions();

    Distribution.BucketOptionsOrBuilder getBucketOptionsOrBuilder();

    long getCount();

    Distribution.Exemplar getExemplars(int i10);

    int getExemplarsCount();

    List<Distribution.Exemplar> getExemplarsList();

    Distribution.ExemplarOrBuilder getExemplarsOrBuilder(int i10);

    List<? extends Distribution.ExemplarOrBuilder> getExemplarsOrBuilderList();

    double getMean();

    Distribution.Range getRange();

    Distribution.RangeOrBuilder getRangeOrBuilder();

    double getSumOfSquaredDeviation();

    boolean hasBucketOptions();

    boolean hasRange();
}
