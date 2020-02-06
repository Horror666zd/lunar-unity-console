package spacemadness.com.lunarconsole.core

class BehaviorSubject<T>(value: T) : Subject<T>() {
    var value: T = value
        set(value) {
            field = value
            notifyObservers(value)
        }

    override fun subscribe(observer: (T) -> Unit): Disposable {
        val observe = super.subscribe(observer)
        notifyObserver(observer, value)
        return observe
    }
}