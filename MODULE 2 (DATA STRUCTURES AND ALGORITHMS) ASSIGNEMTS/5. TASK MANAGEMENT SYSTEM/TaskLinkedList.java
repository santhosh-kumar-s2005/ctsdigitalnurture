public class TaskLinkedList {
    private Node head;
    private int size;

    public TaskLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addAtBeginning(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Added at beginning: " + task);
    }

    public void addAtEnd(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Added at end: " + task);
    }

    public void addAtPosition(Task task, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position: " + position);
            return;
        }
        if (position == 1) {
            addAtBeginning(task);
            return;
        }
        Node newNode = new Node(task);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Added at position " + position + ": " + task);
    }

    public Task searchById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        System.out.println("All Tasks (size=" + size + "):");
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println("  [" + index + "] " + current.task);
            current = current.next;
            index++;
        }
    }

    public boolean deleteById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return false;
        }
        if (head.task.getTaskId() == taskId) {
            System.out.println("Deleted: " + head.task);
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                System.out.println("Deleted: " + current.next.task);
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + taskId + " not found.");
        return false;
    }

    public int getSize() {
        return size;
    }
}
