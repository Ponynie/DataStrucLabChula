package lab;


import datastr.ArrayStack;

//lab5q1
public class Main {
    public static void main(String[] args) throws Exception {
        String y = "12345";
        System.out.println(reverse(y));   
    }
    public static String reverse(String x) {
        if (x.length() > 1) {
            String trailing = x.substring(x.length()-1);
            String next = x.substring(0,x.length()-1);
            String miniReverse = "";
            ARI ari = new ARI(x,trailing,next,miniReverse);
            GlobalStack.stack.push(ari);
            System.out.println("Call reverse(\"" + x + "\")");
            System.out.print(GlobalStack.stack.toString());
            miniReverse = miniReverse + trailing + reverse(next);
            ari.setReturnValue(miniReverse);
            System.out.println("Return from reverse(\"" + x + "\")");
            System.out.print(GlobalStack.stack.toString());
            GlobalStack.stack.pop();
            return miniReverse;
        }
        else {
            ARI ari = new ARI(x,"","",x);
            GlobalStack.stack.push(ari);
            System.out.println("Call reverse(\"" + x + "\")");
            System.out.print(GlobalStack.stack.toString());
            GlobalStack.stack.pop();
            return x;
        }
    }
    public static class GlobalStack {
        public static ArrayStack stack = new ArrayStack();
    }
}