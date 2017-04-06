package com.zelimir.android.mvpsampleapp.nav;

import com.zelimir.android.mvpsampleapp.dagger.modules.AppModule;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Implementation of a Bus which receives {@link NavEvent} object and sends it to
 * subscribers. Subscribers can subscribe to this Bus by calling {@link #toObservable()}.
 * <p/>
 * This bus is provided as a singleton in {@link AppModule} and can be injected with
 * Dagger where required.
 */
public class NavBus {

    private final Subject<NavEvent> navEventSubject;

    public NavBus() {
        final PublishSubject<NavEvent> publishSubject = PublishSubject.create();

        // Transform to serialized subject to make the calls to the onSubscribe, onNext,
        // onError and onComplete methods thread-safe.
        navEventSubject = publishSubject.toSerialized();
    }

    public void send(final NavEvent navEvent) {
        navEventSubject.onNext(navEvent);
    }

    public Observable<NavEvent> toObservable() {
        return navEventSubject.hide();
    }

}
