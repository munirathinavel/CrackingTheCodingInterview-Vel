package regex;

class Singleton {
	private Singleton singleton;

	private Singleton() {
	}

	public Singleton getInstance() {
		synchronized (this) {
			if (singleton == null) {
				synchronized (this) {
					if (singleton == null) {
						singleton = new Singleton();
						return singleton;
					} else {
						return singleton;
					}
				}
			} else {
				return singleton;
			}
		}
	}
}
