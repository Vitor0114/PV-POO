public class Generic<S, N extends Number>{

    private S txt;
    private N num;

    public Generic(S txt, N num){
        this.txt  = txt;
        this.num = num;
    }

    @Override
    public String toString() { 
        return " | Letras: " + txt + " | Números: " + num + "\n";
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        Generic<S, N> Generic = (Generic<S, N>) o;
        if(this.num.equals(Generic.num) && this.txt.equals(Generic.txt)){
            return true;
        }
        return false;
    }

}