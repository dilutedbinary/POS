package pointofsalesystem;

import java.io.Serializable;

public class Quadruple<T, U, V, W> implements Serializable {
	private final T a;
	private final U b;
	private final V c;
        private final W d;

	Quadruple(T a, U b, V c, W d) {
		this.a = a;
		this.b = b;
		this.c = c;
                this.d = d;
	}

	T getA() { return a; }
	U getB() { return b; }
	V getC() { return c; }
        W getD() { return d; }

}
