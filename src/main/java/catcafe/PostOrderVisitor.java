package catcafe;
import tree.*;

public class PostOrderVisitor<T extends Comparable<T>> implements TreeVisitor<T>{

    @Override
    public String visit(Empty<T> node) {
        return "Empty";
    }

    @Override
    public String visit(Node<T> node) {
        String result = "";
        if(node.leftChild() instanceof Node<T>) result += ((Node<T>)node.leftChild()).accept(this);
        if(node.rightChild() instanceof Node<T>) result += ((Node<T>) node.rightChild()).accept(this);
        result += " " + node.data().toString();
        return result;
    }
}