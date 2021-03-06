package com.google.android.gms.common.api;

public abstract class PendingResult<R extends Result> {

    public interface zza {
        void zzq(Status status);
    }

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback);

    public void zza(zza com_google_android_gms_common_api_PendingResult_zza) {
        throw new UnsupportedOperationException();
    }

    public Integer zzafs() {
        throw new UnsupportedOperationException();
    }
}
