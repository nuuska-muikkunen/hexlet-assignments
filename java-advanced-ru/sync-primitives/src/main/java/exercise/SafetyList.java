package exercise;

class SafetyList {
    // BEGIN
    private Integer capacity = 10;
    private Integer[] elements = new Integer[10];
    private Integer freeIndex = 0;

    public Integer getSize() {
        return freeIndex;
    }

    public Integer get(Integer index) {
        return elements[index];
    }

    public synchronized void add(Integer element) {
        elements[freeIndex] = element;
        freeIndex += 1;
        if (freeIndex == capacity - 1) {
            // увеличиваем список
            Integer newCapacity = (capacity * 3) / 2 + 1;
            var newElements = new Integer[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, capacity);
            capacity = newCapacity;
            elements = newElements;
        }
    }

    // END
}
