package model;

public class Pair <T1,T2>{
    public T1 pair1;
    public T2 pair2;

    public Pair(T1 pair1, T2 pair2){
        this.pair1=pair1;
        this.pair2=pair2;
    }

    @Override
    public String toString() {
        return
                 pair1 + " side at the index: "+
                pair2 ;
    }
}
