class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public int altura(TreeNode node) {
        if (node == null)
            return 0;
        else {
            int alturaEsquerda = altura(node.left);
            int alturaDireita = altura(node.right);

            if (alturaEsquerda > alturaDireita)
                return (alturaEsquerda + 1);
            else
                return (alturaDireita + 1);
        }
    }

    public boolean isEstritamenteBinaria(TreeNode node) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        if (node.left != null && node.right != null)
            return (isEstritamenteBinaria(node.left) && isEstritamenteBinaria(node.right));

        return false;
    }

    public boolean isCompleta(TreeNode node, int index, int numNodes) {
        if (node == null)
            return true;

        if (index >= numNodes)
            return false;

        return (isCompleta(node.left, 2 * index + 1, numNodes) && isCompleta(node.right, 2 * index + 2, numNodes));
    }

    public boolean isCheia(TreeNode node) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        if (node.left != null && node.right != null)
            return (isCheia(node.left) && isCheia(node.right));

        return false;
    }

    public void tipoEAltura() {
        int altura = altura(root);

        if (isEstritamenteBinaria(root)) {
            System.out.println("A árvore é estritamente binária e tem altura: " + altura);
        } else if (isCompleta(root, 0, countNodes(root))) {
            System.out.println("A árvore é completa e tem altura: " + altura);
        } else if (isCheia(root)) {
            System.out.println("A árvore é cheia e tem altura: " + altura);
        } else {
            System.out.println("A árvore não se enquadra em nenhum dos tipos definidos.");
        }
    }

    private int countNodes(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
