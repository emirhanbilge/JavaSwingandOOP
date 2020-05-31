package guı_version_3;

class Node {

    int value;
    int id;
    Node left;
    Node right;

    Node(int id, int value) {
        this.id = id;
        this.value = value;
        left = null;
        right = null;
    }
}
