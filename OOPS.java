public class OOPS {
    public static void main(String[] args) {
        Fish f = new Fish();
        f.breath();
    }
}



class Animal {

    String colo ;
    void breath(){
        System.out.println("hii ia ma breathing");
    }

    void eat(){
        System.out.println("hii i am eatin hte ");
    }
}


class Fish extends Animal{
    int fins;
    void setFins(int f){
        this.fins = f;
    }
}