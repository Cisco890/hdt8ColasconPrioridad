/** Juan Francisco Martínez 23617

 * VectorHeap es una implementación de PriorityQueue para manejar una cola con prioridad basada en un Heap.
 *
 * @param <E> El tipo de elementos almacenados en la cola con prioridad, que debe ser comparable.
 */
import java.util.PriorityQueue;
import java.util.NoSuchElementException;
import java.util.Vector;

// Clase VectorHeap que implementa PriorityQueue para manejar una cola con prioridad basada en un Heap
class VectorHeap<E extends Comparable<E>> extends PriorityQueue<E> {
    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    @Override
    public boolean add(E item) {
        data.add(item);
        int hoja = data.size() - 1;
        int raiz = (hoja - 1) / 2;
        while (raiz >= 0 && data.get(raiz).compareTo(data.get(hoja)) > 0) {
            E tmp = data.get(raiz);
            data.set(raiz, data.get(hoja));
            data.set(hoja, tmp);
            hoja = raiz;
            raiz = (hoja - 1) / 2;
        }
        return true;
    }

    @Override
    public E remove() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        E minVal = data.get(0);
        E lastVal = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, lastVal);
            int raiz = 0;
            int hojaizquierda = 2 * raiz + 1;
            int hojaderecha = 2 * raiz + 2;
            int actualHoja;
            while (hojaizquierda < data.size()) {
                if (hojaderecha < data.size() && data.get(hojaderecha).compareTo(data.get(hojaizquierda)) < 0) {
                    actualHoja = hojaderecha;
                } else {
                    actualHoja = hojaizquierda;
                }
                if (data.get(raiz).compareTo(data.get(actualHoja)) <= 0) {
                    break;
                }
                E tmp = data.get(raiz);
                data.set(raiz, data.get(actualHoja));
                data.set(actualHoja, tmp);
                raiz = actualHoja;
                hojaizquierda = 2 * raiz + 1;
                hojaderecha = 2 * raiz + 2;
            }
        }
        return minVal;
    }

    @Override
    public boolean offer(E e) {
        return add(e); // Reusamos el método add ya que ambos hacen lo mismo
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data.get(0);
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return peek();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }
}
