package polaca;

public class PilaPolaca<T> {
        private Nodo<T> tope;
        private int size;

        public PilaPolaca() {
            this.tope = null;
            this.size = 0;
        }

        public void apilar(T valor) {
            Nodo<T> nuevo = new Nodo<>(valor);
            nuevo.setSiguiente(tope);
            tope = nuevo;
            size++;
        }

        public T desapilar() {
            if (isEmpty()) {
                return null;
            }
            T valor = tope.getValor();
            tope = tope.getSiguiente();
            size--;
            return valor;
        }

        public boolean isEmpty() {
            return tope == null;
        }
        public int getSize() {
            return size;
        }

        public T verTope() {
        if (isEmpty()) {
            return null;
        }
        return tope.getValor();
    }
}
