package gdi;

public class AVLTree {

    class Node{
        int height;
        int value;
        Node left;
        Node right;
        Node parent;
        Node add(int value) {
            if(this.value <= value) {
                if(right == null) {
                  right = create(value);  
                }
                else {
                   right = right.add(value);
                }
            }
            else {
                if(left == null) {
                    left = create(value);  
                  }
                  else {
                      left = left.add(value);
                  }
            }
            updateheight();
            return balance();
        }
         Node balance() {
            
            return null;
        }
        Node create(int value) {
            Node result = new Node();
            result.value = value;
            result.height = 1;
            result.parent = this;
            return result;
        }
        
        int min() {
            
            if(left == null) {
                return value;
            }
            else {
                return left.min();
            }
        }
        Node rotateLeft() {
            Node store = right;
            right = right.left;
            if(parent != null) {
                if(parent.left == this) {
                    parent.left = store;
                
                }
                else {
                    parent.right = store;
                }
               
            }
            store.parent = parent;
            if(store.left != null) {
                store.left.parent = this;
            }
            store.left = this;
            parent = store;
            return store;
        }
         Node remove(int value) {
             
             if(this.value <= value) {
                 
                 if(right.value == value) {
                     
                     if(right.left == null) {
                         
                         right = right.right;
                     }
                     else if(right.right ==null){
                         
                         right = right.left;
                         
                     }
                     else {
                         
                         int min = right.right.min();
                         right.value = min;
                         if(right.right.left == null) {
                             
                             right.right = right.right.right;
                         }
                         else {
                             
                            right.right = right.right.remove(min);
                         }
                         right.updateheight();
                     }
                     
                 }
             }
             else {
                 
                 if(left.value == value) {
                     
                     if(left.left == null) {
                         
                         left = left.right;
                     }
                     else if(left.right ==null){
                         
                         left = left.left;
                         
                     }
                     else {
                         
                         int min = left.right.min();
                         left.value = min;
                         if(left.right.left == null) {
                             
                             left.right = left.right.right;
                         }
                         else {
                             
                             left.right = left.right.remove(min);
                         }
                         left.updateheight();
                     }
                     
                 }
             }
            updateheight();
            return balance();
        }
        void updateheight() {
            int leftheight = leftheight();
            int rightheight = rightheight();
            if(rightheight > leftheight)
            {
                height = rightheight + 1;
            }else {
                height = leftheight +1;
            } 
        }
        int leftheight() {
            if (left == null) {
                return 0;
            }else {
                return left.height;
            }
        }
        int rightheight() {
            if (right == null) {
                return 0;
            }else {
                return right.height;
            }
        }
    }
    
   Node root;
   
   void add(int value){       if(isEmpty()){
           root = new Node();
           root.value = value;
           root.height = 1; 
       }
       else {
           root = root.add(value);
           root.parent = null;
       }
   }
   void remove(int value) {
       
       if(!isEmpty()) {
           
           if(root.value == value) {
               
               if(root.left == null) {
                   
                   root = root.right;
                   if(root!= null) {
                       root.parent = null;
                   }
               }
               else if(root.right ==null){
                   
                   root = root.left;
                   root.parent = null;
               }
               else {
                   
                   int min = root.right.min();
                   root.value = min;
                   if(root.right.left == null) {
                       
                       root.right = root.right.right;
                       if(root.right != null) {
                           root.right.parent = root;
                       }
                   }
                   else {  
                     root.right = root.right.remove(min);
                     root.right.parent = root;
                   }
               }
           }
           else {
               root = root.remove(value);
               root.parent = null;
           }
       }
       root.updateheight();
   }
   
  
   boolean isEmpty() {
       return root == null;
       
   }
}
