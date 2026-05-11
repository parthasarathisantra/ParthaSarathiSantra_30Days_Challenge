int getHeight(node* n) {
    if (n == nullptr) return -1;
    return n->ht;
}

int getBalanceFactor(node* n) {
    if (n == nullptr) return 0;
    return getHeight(n->left) - getHeight(n->right);
}

node* rightRotate(node* y) {
    node* x = y->left;
    node* T2 = x->right;

    x->right = y;
    y->left = T2;

    y->ht = 1 + std::max(getHeight(y->left), getHeight(y->right));
    x->ht = 1 + std::max(getHeight(x->left), getHeight(x->right));

    return x;
}

node* leftRotate(node* x) {
    node* y = x->right;
    node* T2 = y->left;

    y->left = x;
    x->right = T2;

    x->ht = 1 + std::max(getHeight(x->left), getHeight(x->right));
    y->ht = 1 + std::max(getHeight(y->left), getHeight(y->right));

    return y;
}

node* insert(node* root, int val) {
    if (root == nullptr) {
        node* newNode = new node();
        newNode->val = val;
        newNode->left = nullptr;
        newNode->right = nullptr;
        newNode->ht = 0;
        return newNode;
    }

    if (val < root->val) {
        root->left = insert(root->left, val);
    } else if (val > root->val) {
        root->right = insert(root->right, val);
    } else {
        return root;
    }

    root->ht = 1 + std::max(getHeight(root->left), getHeight(root->right));

    int balance = getBalanceFactor(root);

    if (balance > 1 && val < root->left->val) {
        return rightRotate(root);
    }

    if (balance < -1 && val > root->right->val) {
        return leftRotate(root);
    }

    if (balance > 1 && val > root->left->val) {
        root->left = leftRotate(root->left);
        return rightRotate(root);
    }

    if (balance < -1 && val < root->right->val) {
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }

    return root;
}