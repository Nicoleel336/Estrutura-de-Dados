class BinarySearchTree:
    class Node:
        def __init__(self, key):
            self.key = key
            self.left = None
            self.right = None

    def __init__(self):
        self.root = None

    def isEmpty(self):
        return self.root is None

    def insert(self, key):
        self.root = self._insert(self.root, key)

    def _insert(self, root, key):
        if root is None:
            return self.Node(key)
        if key < root.key:
            root.left = self._insert(root.left, key)
        elif key > root.key:
            root.right = self._insert(root.right, key)
        return root
    
    #Num de nós da árvore
    def tamanho(self):
        return self._tamanho(self.root)
    
    def _tamanho(self, root):
        if root is None:
            return 0
        return 1 + self._tamanho(root.left) + self._tamanho(root.right)
    
    #Altura da árvore 
    def altura(self):
        return self._altura(self.root)
    
    def _altura(self, root):
        if root is None:
            return -1
        return 1 + max(self._altura(root.left), self._altura(root.right))
    
    #Encontra o menor valor da árvore
    def min(self):
        current = self.root
        if current is None:
            return None
        while current.left is not None:
            current = current.left
        return current.key
    
    #Encontra o maior valor da árvore
    def max(self):
        current = self.root
        if current is None:
            return None
        while current.right is not None:
            current = current.right
        return current.key
    
    #Soma das alturas de todos os nós
    def internalPathLenght(self):
        return self._internalPathLenght(self.root, 0)
    
    def _internalPathLenght(self, root, depth):
        if root is None:
            return 0
        return depth + self._internalPathLenght(root.left, depth + 1) + self._internalPathLenght(root.right, depth + 1)
    
    def inOrder(self):
        return self._inOrder(self.root)
    
    def _inOrder(self, root):
        if root is None:
            return []
        return self._inOrder(root.left) + [root.key] + self._inOrder(root.right)
    
    def preOrder(self):
        return self._preOrder(self.root)
    
    def _preOrder(self, root):
        if root is None:
            return []
        return [root.key] + self._preOrder(root.left) + self._preOrder(root.right)
    
    def posOrder(self):
        return self._posOrder(self.root)
    
    def _posOrder(self, root):
        if root is None:
            return []
        return self._posOrder(root.left) + self._posOrder(root.right) + [root.key]
    
    def levelOrder(self):
        return self._levelOrder(self.root)
    
    def _levelOrder(self, root):
        if root is None:
            return []
        queue = [root]
        result = []
        while queue:
            node = queue.pop(0)
            result.append(node.key)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return result
    
    def isTreeBalanced(self):
        return self._isTreeBalanced(self.root)
    
    def _isTreeBalanced(self, root):
        if root is None:
            return True
        leftHeight = self._altura(root.left)
        rightHeight = self._altura(root.right)
        if abs(leftHeight - rightHeight) <= 1 and self._isTreeBalanced(root.left) and self._isTreeBalanced(root.right):
            return True
        return False
