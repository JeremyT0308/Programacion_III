import java.util.Stack;

public class Pila {

    private Stack<Character> pila;

    public Pila() {
        pila = new Stack<Character>();
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public void push(Character c) {
        pila.push(c);
    }

    public Character pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty Stack");
        }
        return pila.pop();
    }
    public boolean balance(String code) throws Exception {

        for(int i = 0; i < code.length(); i++){
            if(code.charAt(i) == '('){
                pila.push(code.charAt(i));
            }else {
                if (code.charAt(i) == ')') {
                    if (this.pop() == '(') {
                        return false;
                    }
                }
            }
        }

        if(pila.isEmpty()){
            return true;
        }
        return false;
    }
}
