public class y{
    public static void main(String[]args)
    {
        Square3x3 s = new Square3x3();
        s.setCell(2, 2, 3);
        System.out.println(s.getCell(5, 6));
        System.out.println(s);

    }
}