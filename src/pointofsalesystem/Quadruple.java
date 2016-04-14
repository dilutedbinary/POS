package pointofsalesystem;

import java.io.Serializable;

public class Quadruple<T, U, V, W> implements Serializable {
	private T a;
	private U b;
	private V c;
        private W d;

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
        
        void setA(T a) { this.a = a; }
        void setB(U b) { this.b = b; }
	void setC(V c) { this.c = c; }
        void setD(W d) { this.d = d; }
        

}
