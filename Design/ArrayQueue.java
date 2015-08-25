package Design;

class ArrayQueue<T> {
    int size = 0;
    int length;
    T[] table;
    int index = 0;
    
    public ArrayQueue(int size){
        this.length = size;
        table = (T[])new Object[length];
    }
    
    public boolean add(T element){
        if(size == length){
            return false;
        }
        table[(index + size) % length] = element;
        size++;
        return true;
    }
    
    public T poll(){
        if(size == 0){
            return null;
        }
        T element = table[index];
        table[index] = null;
        index = (index + 1) % length;
        size--;
        return element;
    }
    
    public T peek(){
        if(size == 0){
            return null;
        }
        return table[index];
    }
    
    public int size(){
        return size;
    }
}
