package gdi;

public class BinaryTree {

    class Node{
        int value;
        Node left;
        Node right;
        void add(int value) {
            if(this.value <= value) {
                if(right == null) {
                  right = create(value);  
                }
                else {
                    right.add(value);
                }
            }
            else {
                if(left == null) {
                    left = create(value);  
                  }
                  else {
                      left.add(value);
                  }
            }
        }
        Node create(int value) {
            Node result = new Node();
            result.value = value;
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
         void remove(int value) {
             
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
                             
                             right.right.remove(min);
                         }
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
                             
                             left.right.remove(min);
                         }
                     }
                     
                 }
             }
            
        }
    }
    
   Node root;
   
   void add(int value){       if(isEmpty()){
           root = new Node();
           root.value = value;
           
       }
       else {
           root.add(value);
       }
   }
   void remove(int value) {
       
       if(!isEmpty()) {
           
           if(root.value == value) {
               
               if(root.left == null) {
                   
                   root = root.right;
               }
               else if(root.right ==null){
                   
                   root = root.left;
                   
               }
               else {
                   
                   int min = root.right.min();
                   root.value = min;
                   if(root.right.left == null) {
                       
                       root.right = root.right.right;
                   }
                   else {
                       
                       root.right.remove(min);
                   }
               }
           }
           else {
               
               root.remove(value);
           }
       }
   }
   
  
   boolean isEmpty() {
       return root == null;
       
   }
}
