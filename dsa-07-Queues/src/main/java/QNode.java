public class QNode<T> { // Create a QNode clas with Generic that can take any data
   T value;
   QNode<T> next;

    public QNode(T value) {
        this.value = value;
    }

}
