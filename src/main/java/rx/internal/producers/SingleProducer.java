package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    final Subscriber<? super T> child;
    final T value;

    public SingleProducer(Subscriber<? super T> child, T value) {
        this.child = child;
        this.value = value;
    }

    public void request(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (n != 0 && compareAndSet(false, true)) {
            Subscriber<? super T> c = this.child;
            if (!c.isUnsubscribed()) {
                T v = this.value;
                try {
                    c.onNext(v);
                    if (!c.isUnsubscribed()) {
                        c.onCompleted();
                    }
                } catch (Throwable e) {
                    Exceptions.throwOrReport(e, c, v);
                }
            }
        }
    }
}
