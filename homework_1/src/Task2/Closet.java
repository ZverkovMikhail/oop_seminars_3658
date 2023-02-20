package Task2;

public class Closet {
    private boolean isOpen = false;
    private boolean allowed = false;

    public boolean isOpen() {
        return isOpen;
    }
    public boolean allowed() {
        return allowed;
    }
    public Closet allow() {
        allowed = true;
        return this;
    }

    public Closet open() {
        if (allowed){
            if(isOpen){
                System.out.println("Шкаф уже открыт!");
            }else {
                isOpen = true;
                System.out.println("Шкаф открыт!");
            }
        }else {
            System.out.println("Требуется разрешение жены!");
        }

        return this;
    }
}
