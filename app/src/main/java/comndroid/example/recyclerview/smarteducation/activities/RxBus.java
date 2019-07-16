package comndroid.example.recyclerview.smarteducation.activities;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class RxBus
{
    private static volatile RxBus defaultInstance;
    private final Subject<Object, Object> bus = new SerializedSubject(PublishSubject.create());

    public static RxBus getDefault()
    {
        if (defaultInstance == null)
        {
            try
            {
                if (defaultInstance == null)
                    defaultInstance = new RxBus();
            }
            finally
            {
            }
        }
        return defaultInstance;
    }

    public void post(Object paramObject)
    {
        this.bus.onNext(paramObject);
    }

    public <T> Observable<T> toObservable(Class<T> paramClass)
    {
        return this.bus.ofType(paramClass);
    }
}