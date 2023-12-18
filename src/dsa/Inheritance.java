package dsa;/*class dsa.Animal{
    static void sound1(){
        System.out.println("Aaaaaaaaaaa");
    }
}
class dsa.Dog extends dsa.Animal{
    static void sound2(){
        System.out.println("Bbbbbbbbbbbb");
    }
}

public class dsa.Inheritance {
    public static void main(String[] args) {
        dsa.Dog d = new dsa.Dog();
        d.sound2();
        d.sound1();
    }
}
*/

//Multilevel dsa.Inheritance
/*class dsa.Animal{
    static void sound1(){
        System.out.println("Aaaaaaaaaaaa");
    }
}
class dsa.Dog extends dsa.Animal{
    static void sound2(){
        System.out.println("Bbbbbbbbbbbb");
    }
}
class dsa.Pig extends dsa.Dog{
    static void sound3(){
        System.out.println("Cccccccccccc");
    }
}

class dsa.Inheritance{
    public static void main(String[] args) {
        dsa.Pig p = new dsa.Pig();
        p.sound3();
        p.sound2();
        p.sound1();
    }
}
*/

//Hierarchical dsa.Inheritance
/*class dsa.Animal{
    static void sound1(){
        System.out.println("Aaaaaaaaaaa");
    }
}
class dsa.Dog extends dsa.Animal{
    static void sound2(){
        System.out.println("Bbbbbbbbbbbb");
    }
}
class dsa.Pig extends dsa.Animal{
    static void sound3(){
        System.out.println("Cccccccccccc");
    }
}

public class dsa.Inheritance {
    public static void main(String[] args) {
        dsa.Dog d = new dsa.Dog();
        d.sound2();
        d.sound1();
    }
}
*/

//Multiple dsa.Inheritance
/*interface dsa.Animal{
    static void sound1(){
        System.out.println("Aaaaaaaaaaaa");
    }
}
interface dsa.Dog{
    static void sound2(){
        System.out.println("Bbbbbbbbbbbb");
    }
}
class dsa.Inheritance implements dsa.Animal,dsa.Dog{
    static void sound(){
        dsa.Animal.sound1();
        dsa.Dog.sound2();
    }
    public static void main(String[] args) {
        sound();
    }
}
*/
//Hybrid dsa.Inheritance
class Animal{
    static void sound1(){
        System.out.println("Aaaaaaaaaaa");
    }
}
class Dog extends Animal{
    static void sound2(){
        System.out.println("Bbbbbbbbbbbb");
    }
}
class Pig extends Animal{
    static void sound3(){
        System.out.println("Cccccccccccc");
    }
}
class Inheritance extends Dog{
    public static void main(String[] args) {
        sound2();
        sound1();
    }
}