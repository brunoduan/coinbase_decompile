package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzcdi implements Callable<List<zzcfv>> {
    private /* synthetic */ String zziah;
    private /* synthetic */ zzcdb zziuk;
    private /* synthetic */ String zzium;
    private /* synthetic */ String zziun;

    zzcdi(zzcdb com_google_android_gms_internal_zzcdb, String str, String str2, String str3) {
        this.zziuk = com_google_android_gms_internal_zzcdb;
        this.zziah = str;
        this.zzium = str2;
        this.zziun = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zziuk.zziki.zzazk();
        return this.zziuk.zziki.zzauf().zzg(this.zziah, this.zzium, this.zziun);
    }
}
